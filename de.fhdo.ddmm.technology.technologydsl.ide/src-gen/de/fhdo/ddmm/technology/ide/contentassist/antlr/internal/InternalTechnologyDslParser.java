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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_BIG_DECIMAL", "RULE_BOOLEAN", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "';'", "'in'", "'out'", "'inout'", "'sync'", "'async'", "'<-'", "'->'", "'<->'", "'microservices'", "'interfaces'", "'operations'", "'parameters'", "'fields'", "'containers'", "'infrastructure'", "'technology'", "'{'", "'}'", "'types'", "'compatibility'", "'matrix'", "'protocols'", "'service'", "'aspects'", "'deployment'", "'technologies'", "'operation'", "'import'", "'from'", "'as'", "'data'", "'formats'", "','", "'with'", "'format'", "'primitive'", "'type'", "'based'", "'on'", "'list'", "'structure'", "'::'", "'environments'", "'='", "'properties'", "'selector'", "'('", "')'", "'aspect'", "'for'", "'datatypes'", "'version'", "'context'", "'extends'", "'boolean'", "'byte'", "'char'", "'date'", "'double'", "'float'", "'int'", "'long'", "'short'", "'string'", "'.'", "'default'", "'mandatory'", "'exchange_pattern'", "'communication_type'", "'protocol'", "'data_format'", "'hide'"
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


    // $ANTLR start "entryRulePrimitiveValue"
    // InternalTechnologyDsl.g:378:1: entryRulePrimitiveValue : rulePrimitiveValue EOF ;
    public final void entryRulePrimitiveValue() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:379:1: ( rulePrimitiveValue EOF )
            // InternalTechnologyDsl.g:380:1: rulePrimitiveValue EOF
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
    // InternalTechnologyDsl.g:387:1: rulePrimitiveValue : ( ( rule__PrimitiveValue__Alternatives ) ) ;
    public final void rulePrimitiveValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:391:2: ( ( ( rule__PrimitiveValue__Alternatives ) ) )
            // InternalTechnologyDsl.g:392:2: ( ( rule__PrimitiveValue__Alternatives ) )
            {
            // InternalTechnologyDsl.g:392:2: ( ( rule__PrimitiveValue__Alternatives ) )
            // InternalTechnologyDsl.g:393:3: ( rule__PrimitiveValue__Alternatives )
            {
             before(grammarAccess.getPrimitiveValueAccess().getAlternatives()); 
            // InternalTechnologyDsl.g:394:3: ( rule__PrimitiveValue__Alternatives )
            // InternalTechnologyDsl.g:394:4: rule__PrimitiveValue__Alternatives
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


    // $ANTLR start "entryRuleServiceAspectPointcut"
    // InternalTechnologyDsl.g:403:1: entryRuleServiceAspectPointcut : ruleServiceAspectPointcut EOF ;
    public final void entryRuleServiceAspectPointcut() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:404:1: ( ruleServiceAspectPointcut EOF )
            // InternalTechnologyDsl.g:405:1: ruleServiceAspectPointcut EOF
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
    // InternalTechnologyDsl.g:412:1: ruleServiceAspectPointcut : ( ( rule__ServiceAspectPointcut__Alternatives ) ) ;
    public final void ruleServiceAspectPointcut() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:416:2: ( ( ( rule__ServiceAspectPointcut__Alternatives ) ) )
            // InternalTechnologyDsl.g:417:2: ( ( rule__ServiceAspectPointcut__Alternatives ) )
            {
            // InternalTechnologyDsl.g:417:2: ( ( rule__ServiceAspectPointcut__Alternatives ) )
            // InternalTechnologyDsl.g:418:3: ( rule__ServiceAspectPointcut__Alternatives )
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getAlternatives()); 
            // InternalTechnologyDsl.g:419:3: ( rule__ServiceAspectPointcut__Alternatives )
            // InternalTechnologyDsl.g:419:4: rule__ServiceAspectPointcut__Alternatives
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
    // InternalTechnologyDsl.g:428:1: entryRuleServiceAspectPointcutSelector : ruleServiceAspectPointcutSelector EOF ;
    public final void entryRuleServiceAspectPointcutSelector() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:429:1: ( ruleServiceAspectPointcutSelector EOF )
            // InternalTechnologyDsl.g:430:1: ruleServiceAspectPointcutSelector EOF
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
    // InternalTechnologyDsl.g:437:1: ruleServiceAspectPointcutSelector : ( ( rule__ServiceAspectPointcutSelector__Group__0 ) ) ;
    public final void ruleServiceAspectPointcutSelector() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:441:2: ( ( ( rule__ServiceAspectPointcutSelector__Group__0 ) ) )
            // InternalTechnologyDsl.g:442:2: ( ( rule__ServiceAspectPointcutSelector__Group__0 ) )
            {
            // InternalTechnologyDsl.g:442:2: ( ( rule__ServiceAspectPointcutSelector__Group__0 ) )
            // InternalTechnologyDsl.g:443:3: ( rule__ServiceAspectPointcutSelector__Group__0 )
            {
             before(grammarAccess.getServiceAspectPointcutSelectorAccess().getGroup()); 
            // InternalTechnologyDsl.g:444:3: ( rule__ServiceAspectPointcutSelector__Group__0 )
            // InternalTechnologyDsl.g:444:4: rule__ServiceAspectPointcutSelector__Group__0
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
    // InternalTechnologyDsl.g:453:1: entryRuleServiceAspect : ruleServiceAspect EOF ;
    public final void entryRuleServiceAspect() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:454:1: ( ruleServiceAspect EOF )
            // InternalTechnologyDsl.g:455:1: ruleServiceAspect EOF
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
    // InternalTechnologyDsl.g:462:1: ruleServiceAspect : ( ( rule__ServiceAspect__Group__0 ) ) ;
    public final void ruleServiceAspect() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:466:2: ( ( ( rule__ServiceAspect__Group__0 ) ) )
            // InternalTechnologyDsl.g:467:2: ( ( rule__ServiceAspect__Group__0 ) )
            {
            // InternalTechnologyDsl.g:467:2: ( ( rule__ServiceAspect__Group__0 ) )
            // InternalTechnologyDsl.g:468:3: ( rule__ServiceAspect__Group__0 )
            {
             before(grammarAccess.getServiceAspectAccess().getGroup()); 
            // InternalTechnologyDsl.g:469:3: ( rule__ServiceAspect__Group__0 )
            // InternalTechnologyDsl.g:469:4: rule__ServiceAspect__Group__0
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
    // InternalTechnologyDsl.g:478:1: entryRuleOperationAspect : ruleOperationAspect EOF ;
    public final void entryRuleOperationAspect() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:479:1: ( ruleOperationAspect EOF )
            // InternalTechnologyDsl.g:480:1: ruleOperationAspect EOF
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
    // InternalTechnologyDsl.g:487:1: ruleOperationAspect : ( ( rule__OperationAspect__Group__0 ) ) ;
    public final void ruleOperationAspect() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:491:2: ( ( ( rule__OperationAspect__Group__0 ) ) )
            // InternalTechnologyDsl.g:492:2: ( ( rule__OperationAspect__Group__0 ) )
            {
            // InternalTechnologyDsl.g:492:2: ( ( rule__OperationAspect__Group__0 ) )
            // InternalTechnologyDsl.g:493:3: ( rule__OperationAspect__Group__0 )
            {
             before(grammarAccess.getOperationAspectAccess().getGroup()); 
            // InternalTechnologyDsl.g:494:3: ( rule__OperationAspect__Group__0 )
            // InternalTechnologyDsl.g:494:4: rule__OperationAspect__Group__0
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
    // InternalTechnologyDsl.g:503:1: entryRuleComplexTypeImport : ruleComplexTypeImport EOF ;
    public final void entryRuleComplexTypeImport() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:504:1: ( ruleComplexTypeImport EOF )
            // InternalTechnologyDsl.g:505:1: ruleComplexTypeImport EOF
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
    // InternalTechnologyDsl.g:512:1: ruleComplexTypeImport : ( ( rule__ComplexTypeImport__Group__0 ) ) ;
    public final void ruleComplexTypeImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:516:2: ( ( ( rule__ComplexTypeImport__Group__0 ) ) )
            // InternalTechnologyDsl.g:517:2: ( ( rule__ComplexTypeImport__Group__0 ) )
            {
            // InternalTechnologyDsl.g:517:2: ( ( rule__ComplexTypeImport__Group__0 ) )
            // InternalTechnologyDsl.g:518:3: ( rule__ComplexTypeImport__Group__0 )
            {
             before(grammarAccess.getComplexTypeImportAccess().getGroup()); 
            // InternalTechnologyDsl.g:519:3: ( rule__ComplexTypeImport__Group__0 )
            // InternalTechnologyDsl.g:519:4: rule__ComplexTypeImport__Group__0
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
    // InternalTechnologyDsl.g:528:1: entryRuleVersion : ruleVersion EOF ;
    public final void entryRuleVersion() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:529:1: ( ruleVersion EOF )
            // InternalTechnologyDsl.g:530:1: ruleVersion EOF
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
    // InternalTechnologyDsl.g:537:1: ruleVersion : ( ( rule__Version__Group__0 ) ) ;
    public final void ruleVersion() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:541:2: ( ( ( rule__Version__Group__0 ) ) )
            // InternalTechnologyDsl.g:542:2: ( ( rule__Version__Group__0 ) )
            {
            // InternalTechnologyDsl.g:542:2: ( ( rule__Version__Group__0 ) )
            // InternalTechnologyDsl.g:543:3: ( rule__Version__Group__0 )
            {
             before(grammarAccess.getVersionAccess().getGroup()); 
            // InternalTechnologyDsl.g:544:3: ( rule__Version__Group__0 )
            // InternalTechnologyDsl.g:544:4: rule__Version__Group__0
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
    // InternalTechnologyDsl.g:553:1: entryRuleContext : ruleContext EOF ;
    public final void entryRuleContext() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:554:1: ( ruleContext EOF )
            // InternalTechnologyDsl.g:555:1: ruleContext EOF
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
    // InternalTechnologyDsl.g:562:1: ruleContext : ( ( rule__Context__Group__0 ) ) ;
    public final void ruleContext() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:566:2: ( ( ( rule__Context__Group__0 ) ) )
            // InternalTechnologyDsl.g:567:2: ( ( rule__Context__Group__0 ) )
            {
            // InternalTechnologyDsl.g:567:2: ( ( rule__Context__Group__0 ) )
            // InternalTechnologyDsl.g:568:3: ( rule__Context__Group__0 )
            {
             before(grammarAccess.getContextAccess().getGroup()); 
            // InternalTechnologyDsl.g:569:3: ( rule__Context__Group__0 )
            // InternalTechnologyDsl.g:569:4: rule__Context__Group__0
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
    // InternalTechnologyDsl.g:578:1: entryRuleComplexType : ruleComplexType EOF ;
    public final void entryRuleComplexType() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:579:1: ( ruleComplexType EOF )
            // InternalTechnologyDsl.g:580:1: ruleComplexType EOF
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
    // InternalTechnologyDsl.g:587:1: ruleComplexType : ( ( rule__ComplexType__Alternatives ) ) ;
    public final void ruleComplexType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:591:2: ( ( ( rule__ComplexType__Alternatives ) ) )
            // InternalTechnologyDsl.g:592:2: ( ( rule__ComplexType__Alternatives ) )
            {
            // InternalTechnologyDsl.g:592:2: ( ( rule__ComplexType__Alternatives ) )
            // InternalTechnologyDsl.g:593:3: ( rule__ComplexType__Alternatives )
            {
             before(grammarAccess.getComplexTypeAccess().getAlternatives()); 
            // InternalTechnologyDsl.g:594:3: ( rule__ComplexType__Alternatives )
            // InternalTechnologyDsl.g:594:4: rule__ComplexType__Alternatives
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
    // InternalTechnologyDsl.g:603:1: entryRuleDataStructure : ruleDataStructure EOF ;
    public final void entryRuleDataStructure() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:604:1: ( ruleDataStructure EOF )
            // InternalTechnologyDsl.g:605:1: ruleDataStructure EOF
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
    // InternalTechnologyDsl.g:612:1: ruleDataStructure : ( ( rule__DataStructure__Group__0 ) ) ;
    public final void ruleDataStructure() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:616:2: ( ( ( rule__DataStructure__Group__0 ) ) )
            // InternalTechnologyDsl.g:617:2: ( ( rule__DataStructure__Group__0 ) )
            {
            // InternalTechnologyDsl.g:617:2: ( ( rule__DataStructure__Group__0 ) )
            // InternalTechnologyDsl.g:618:3: ( rule__DataStructure__Group__0 )
            {
             before(grammarAccess.getDataStructureAccess().getGroup()); 
            // InternalTechnologyDsl.g:619:3: ( rule__DataStructure__Group__0 )
            // InternalTechnologyDsl.g:619:4: rule__DataStructure__Group__0
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
    // InternalTechnologyDsl.g:628:1: entryRuleListType : ruleListType EOF ;
    public final void entryRuleListType() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:629:1: ( ruleListType EOF )
            // InternalTechnologyDsl.g:630:1: ruleListType EOF
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
    // InternalTechnologyDsl.g:637:1: ruleListType : ( ( rule__ListType__Alternatives ) ) ;
    public final void ruleListType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:641:2: ( ( ( rule__ListType__Alternatives ) ) )
            // InternalTechnologyDsl.g:642:2: ( ( rule__ListType__Alternatives ) )
            {
            // InternalTechnologyDsl.g:642:2: ( ( rule__ListType__Alternatives ) )
            // InternalTechnologyDsl.g:643:3: ( rule__ListType__Alternatives )
            {
             before(grammarAccess.getListTypeAccess().getAlternatives()); 
            // InternalTechnologyDsl.g:644:3: ( rule__ListType__Alternatives )
            // InternalTechnologyDsl.g:644:4: rule__ListType__Alternatives
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
    // InternalTechnologyDsl.g:653:1: entryRuleDataField : ruleDataField EOF ;
    public final void entryRuleDataField() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:654:1: ( ruleDataField EOF )
            // InternalTechnologyDsl.g:655:1: ruleDataField EOF
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
    // InternalTechnologyDsl.g:662:1: ruleDataField : ( ( rule__DataField__Group__0 ) ) ;
    public final void ruleDataField() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:666:2: ( ( ( rule__DataField__Group__0 ) ) )
            // InternalTechnologyDsl.g:667:2: ( ( rule__DataField__Group__0 ) )
            {
            // InternalTechnologyDsl.g:667:2: ( ( rule__DataField__Group__0 ) )
            // InternalTechnologyDsl.g:668:3: ( rule__DataField__Group__0 )
            {
             before(grammarAccess.getDataFieldAccess().getGroup()); 
            // InternalTechnologyDsl.g:669:3: ( rule__DataField__Group__0 )
            // InternalTechnologyDsl.g:669:4: rule__DataField__Group__0
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
    // InternalTechnologyDsl.g:678:1: entryRulePossiblyImportedComplexType : rulePossiblyImportedComplexType EOF ;
    public final void entryRulePossiblyImportedComplexType() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:679:1: ( rulePossiblyImportedComplexType EOF )
            // InternalTechnologyDsl.g:680:1: rulePossiblyImportedComplexType EOF
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
    // InternalTechnologyDsl.g:687:1: rulePossiblyImportedComplexType : ( ( rule__PossiblyImportedComplexType__Group__0 ) ) ;
    public final void rulePossiblyImportedComplexType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:691:2: ( ( ( rule__PossiblyImportedComplexType__Group__0 ) ) )
            // InternalTechnologyDsl.g:692:2: ( ( rule__PossiblyImportedComplexType__Group__0 ) )
            {
            // InternalTechnologyDsl.g:692:2: ( ( rule__PossiblyImportedComplexType__Group__0 ) )
            // InternalTechnologyDsl.g:693:3: ( rule__PossiblyImportedComplexType__Group__0 )
            {
             before(grammarAccess.getPossiblyImportedComplexTypeAccess().getGroup()); 
            // InternalTechnologyDsl.g:694:3: ( rule__PossiblyImportedComplexType__Group__0 )
            // InternalTechnologyDsl.g:694:4: rule__PossiblyImportedComplexType__Group__0
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
    // InternalTechnologyDsl.g:703:1: entryRulePrimitiveType : rulePrimitiveType EOF ;
    public final void entryRulePrimitiveType() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:704:1: ( rulePrimitiveType EOF )
            // InternalTechnologyDsl.g:705:1: rulePrimitiveType EOF
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
    // InternalTechnologyDsl.g:712:1: rulePrimitiveType : ( ( rule__PrimitiveType__Alternatives ) ) ;
    public final void rulePrimitiveType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:716:2: ( ( ( rule__PrimitiveType__Alternatives ) ) )
            // InternalTechnologyDsl.g:717:2: ( ( rule__PrimitiveType__Alternatives ) )
            {
            // InternalTechnologyDsl.g:717:2: ( ( rule__PrimitiveType__Alternatives ) )
            // InternalTechnologyDsl.g:718:3: ( rule__PrimitiveType__Alternatives )
            {
             before(grammarAccess.getPrimitiveTypeAccess().getAlternatives()); 
            // InternalTechnologyDsl.g:719:3: ( rule__PrimitiveType__Alternatives )
            // InternalTechnologyDsl.g:719:4: rule__PrimitiveType__Alternatives
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
    // InternalTechnologyDsl.g:728:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:729:1: ( ruleQualifiedName EOF )
            // InternalTechnologyDsl.g:730:1: ruleQualifiedName EOF
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
    // InternalTechnologyDsl.g:737:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:741:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalTechnologyDsl.g:742:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalTechnologyDsl.g:742:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalTechnologyDsl.g:743:3: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalTechnologyDsl.g:744:3: ( rule__QualifiedName__Group__0 )
            // InternalTechnologyDsl.g:744:4: rule__QualifiedName__Group__0
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
    // InternalTechnologyDsl.g:753:1: ruleExchangePattern : ( ( rule__ExchangePattern__Alternatives ) ) ;
    public final void ruleExchangePattern() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:757:1: ( ( ( rule__ExchangePattern__Alternatives ) ) )
            // InternalTechnologyDsl.g:758:2: ( ( rule__ExchangePattern__Alternatives ) )
            {
            // InternalTechnologyDsl.g:758:2: ( ( rule__ExchangePattern__Alternatives ) )
            // InternalTechnologyDsl.g:759:3: ( rule__ExchangePattern__Alternatives )
            {
             before(grammarAccess.getExchangePatternAccess().getAlternatives()); 
            // InternalTechnologyDsl.g:760:3: ( rule__ExchangePattern__Alternatives )
            // InternalTechnologyDsl.g:760:4: rule__ExchangePattern__Alternatives
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
    // InternalTechnologyDsl.g:769:1: ruleCommunicationType : ( ( rule__CommunicationType__Alternatives ) ) ;
    public final void ruleCommunicationType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:773:1: ( ( ( rule__CommunicationType__Alternatives ) ) )
            // InternalTechnologyDsl.g:774:2: ( ( rule__CommunicationType__Alternatives ) )
            {
            // InternalTechnologyDsl.g:774:2: ( ( rule__CommunicationType__Alternatives ) )
            // InternalTechnologyDsl.g:775:3: ( rule__CommunicationType__Alternatives )
            {
             before(grammarAccess.getCommunicationTypeAccess().getAlternatives()); 
            // InternalTechnologyDsl.g:776:3: ( rule__CommunicationType__Alternatives )
            // InternalTechnologyDsl.g:776:4: rule__CommunicationType__Alternatives
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
    // InternalTechnologyDsl.g:785:1: ruleCompatibilityDirection : ( ( rule__CompatibilityDirection__Alternatives ) ) ;
    public final void ruleCompatibilityDirection() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:789:1: ( ( ( rule__CompatibilityDirection__Alternatives ) ) )
            // InternalTechnologyDsl.g:790:2: ( ( rule__CompatibilityDirection__Alternatives ) )
            {
            // InternalTechnologyDsl.g:790:2: ( ( rule__CompatibilityDirection__Alternatives ) )
            // InternalTechnologyDsl.g:791:3: ( rule__CompatibilityDirection__Alternatives )
            {
             before(grammarAccess.getCompatibilityDirectionAccess().getAlternatives()); 
            // InternalTechnologyDsl.g:792:3: ( rule__CompatibilityDirection__Alternatives )
            // InternalTechnologyDsl.g:792:4: rule__CompatibilityDirection__Alternatives
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
    // InternalTechnologyDsl.g:801:1: ruleServiceJoinPointType : ( ( rule__ServiceJoinPointType__Alternatives ) ) ;
    public final void ruleServiceJoinPointType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:805:1: ( ( ( rule__ServiceJoinPointType__Alternatives ) ) )
            // InternalTechnologyDsl.g:806:2: ( ( rule__ServiceJoinPointType__Alternatives ) )
            {
            // InternalTechnologyDsl.g:806:2: ( ( rule__ServiceJoinPointType__Alternatives ) )
            // InternalTechnologyDsl.g:807:3: ( rule__ServiceJoinPointType__Alternatives )
            {
             before(grammarAccess.getServiceJoinPointTypeAccess().getAlternatives()); 
            // InternalTechnologyDsl.g:808:3: ( rule__ServiceJoinPointType__Alternatives )
            // InternalTechnologyDsl.g:808:4: rule__ServiceJoinPointType__Alternatives
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
    // InternalTechnologyDsl.g:817:1: ruleOperationJoinPointType : ( ( rule__OperationJoinPointType__Alternatives ) ) ;
    public final void ruleOperationJoinPointType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:821:1: ( ( ( rule__OperationJoinPointType__Alternatives ) ) )
            // InternalTechnologyDsl.g:822:2: ( ( rule__OperationJoinPointType__Alternatives ) )
            {
            // InternalTechnologyDsl.g:822:2: ( ( rule__OperationJoinPointType__Alternatives ) )
            // InternalTechnologyDsl.g:823:3: ( rule__OperationJoinPointType__Alternatives )
            {
             before(grammarAccess.getOperationJoinPointTypeAccess().getAlternatives()); 
            // InternalTechnologyDsl.g:824:3: ( rule__OperationJoinPointType__Alternatives )
            // InternalTechnologyDsl.g:824:4: rule__OperationJoinPointType__Alternatives
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
    // InternalTechnologyDsl.g:832:1: rule__Technology__Alternatives_4_2 : ( ( ( rule__Technology__PrimitiveTypesAssignment_4_2_0 ) ) | ( ( rule__Technology__ListTypesAssignment_4_2_1 ) ) | ( ( rule__Technology__DataStructuresAssignment_4_2_2 ) ) );
    public final void rule__Technology__Alternatives_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:836:1: ( ( ( rule__Technology__PrimitiveTypesAssignment_4_2_0 ) ) | ( ( rule__Technology__ListTypesAssignment_4_2_1 ) ) | ( ( rule__Technology__DataStructuresAssignment_4_2_2 ) ) )
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
                    // InternalTechnologyDsl.g:837:2: ( ( rule__Technology__PrimitiveTypesAssignment_4_2_0 ) )
                    {
                    // InternalTechnologyDsl.g:837:2: ( ( rule__Technology__PrimitiveTypesAssignment_4_2_0 ) )
                    // InternalTechnologyDsl.g:838:3: ( rule__Technology__PrimitiveTypesAssignment_4_2_0 )
                    {
                     before(grammarAccess.getTechnologyAccess().getPrimitiveTypesAssignment_4_2_0()); 
                    // InternalTechnologyDsl.g:839:3: ( rule__Technology__PrimitiveTypesAssignment_4_2_0 )
                    // InternalTechnologyDsl.g:839:4: rule__Technology__PrimitiveTypesAssignment_4_2_0
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
                    // InternalTechnologyDsl.g:843:2: ( ( rule__Technology__ListTypesAssignment_4_2_1 ) )
                    {
                    // InternalTechnologyDsl.g:843:2: ( ( rule__Technology__ListTypesAssignment_4_2_1 ) )
                    // InternalTechnologyDsl.g:844:3: ( rule__Technology__ListTypesAssignment_4_2_1 )
                    {
                     before(grammarAccess.getTechnologyAccess().getListTypesAssignment_4_2_1()); 
                    // InternalTechnologyDsl.g:845:3: ( rule__Technology__ListTypesAssignment_4_2_1 )
                    // InternalTechnologyDsl.g:845:4: rule__Technology__ListTypesAssignment_4_2_1
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
                    // InternalTechnologyDsl.g:849:2: ( ( rule__Technology__DataStructuresAssignment_4_2_2 ) )
                    {
                    // InternalTechnologyDsl.g:849:2: ( ( rule__Technology__DataStructuresAssignment_4_2_2 ) )
                    // InternalTechnologyDsl.g:850:3: ( rule__Technology__DataStructuresAssignment_4_2_2 )
                    {
                     before(grammarAccess.getTechnologyAccess().getDataStructuresAssignment_4_2_2()); 
                    // InternalTechnologyDsl.g:851:3: ( rule__Technology__DataStructuresAssignment_4_2_2 )
                    // InternalTechnologyDsl.g:851:4: rule__Technology__DataStructuresAssignment_4_2_2
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
    // InternalTechnologyDsl.g:859:1: rule__TechnologySpecificProperty__Alternatives_2 : ( ( ( rule__TechnologySpecificProperty__Group_2_0__0 ) ) | ( ( rule__TechnologySpecificProperty__MandatoryAssignment_2_1 ) ) );
    public final void rule__TechnologySpecificProperty__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:863:1: ( ( ( rule__TechnologySpecificProperty__Group_2_0__0 ) ) | ( ( rule__TechnologySpecificProperty__MandatoryAssignment_2_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==57) ) {
                alt2=1;
            }
            else if ( (LA2_0==80) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalTechnologyDsl.g:864:2: ( ( rule__TechnologySpecificProperty__Group_2_0__0 ) )
                    {
                    // InternalTechnologyDsl.g:864:2: ( ( rule__TechnologySpecificProperty__Group_2_0__0 ) )
                    // InternalTechnologyDsl.g:865:3: ( rule__TechnologySpecificProperty__Group_2_0__0 )
                    {
                     before(grammarAccess.getTechnologySpecificPropertyAccess().getGroup_2_0()); 
                    // InternalTechnologyDsl.g:866:3: ( rule__TechnologySpecificProperty__Group_2_0__0 )
                    // InternalTechnologyDsl.g:866:4: rule__TechnologySpecificProperty__Group_2_0__0
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
                    // InternalTechnologyDsl.g:870:2: ( ( rule__TechnologySpecificProperty__MandatoryAssignment_2_1 ) )
                    {
                    // InternalTechnologyDsl.g:870:2: ( ( rule__TechnologySpecificProperty__MandatoryAssignment_2_1 ) )
                    // InternalTechnologyDsl.g:871:3: ( rule__TechnologySpecificProperty__MandatoryAssignment_2_1 )
                    {
                     before(grammarAccess.getTechnologySpecificPropertyAccess().getMandatoryAssignment_2_1()); 
                    // InternalTechnologyDsl.g:872:3: ( rule__TechnologySpecificProperty__MandatoryAssignment_2_1 )
                    // InternalTechnologyDsl.g:872:4: rule__TechnologySpecificProperty__MandatoryAssignment_2_1
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


    // $ANTLR start "rule__PrimitiveValue__Alternatives"
    // InternalTechnologyDsl.g:880:1: rule__PrimitiveValue__Alternatives : ( ( ( rule__PrimitiveValue__NumericValueAssignment_0 ) ) | ( ( rule__PrimitiveValue__BooleanValueAssignment_1 ) ) | ( ( rule__PrimitiveValue__StringValueAssignment_2 ) ) );
    public final void rule__PrimitiveValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:884:1: ( ( ( rule__PrimitiveValue__NumericValueAssignment_0 ) ) | ( ( rule__PrimitiveValue__BooleanValueAssignment_1 ) ) | ( ( rule__PrimitiveValue__StringValueAssignment_2 ) ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case RULE_BIG_DECIMAL:
                {
                alt3=1;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt3=2;
                }
                break;
            case RULE_STRING:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalTechnologyDsl.g:885:2: ( ( rule__PrimitiveValue__NumericValueAssignment_0 ) )
                    {
                    // InternalTechnologyDsl.g:885:2: ( ( rule__PrimitiveValue__NumericValueAssignment_0 ) )
                    // InternalTechnologyDsl.g:886:3: ( rule__PrimitiveValue__NumericValueAssignment_0 )
                    {
                     before(grammarAccess.getPrimitiveValueAccess().getNumericValueAssignment_0()); 
                    // InternalTechnologyDsl.g:887:3: ( rule__PrimitiveValue__NumericValueAssignment_0 )
                    // InternalTechnologyDsl.g:887:4: rule__PrimitiveValue__NumericValueAssignment_0
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
                    // InternalTechnologyDsl.g:891:2: ( ( rule__PrimitiveValue__BooleanValueAssignment_1 ) )
                    {
                    // InternalTechnologyDsl.g:891:2: ( ( rule__PrimitiveValue__BooleanValueAssignment_1 ) )
                    // InternalTechnologyDsl.g:892:3: ( rule__PrimitiveValue__BooleanValueAssignment_1 )
                    {
                     before(grammarAccess.getPrimitiveValueAccess().getBooleanValueAssignment_1()); 
                    // InternalTechnologyDsl.g:893:3: ( rule__PrimitiveValue__BooleanValueAssignment_1 )
                    // InternalTechnologyDsl.g:893:4: rule__PrimitiveValue__BooleanValueAssignment_1
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
                    // InternalTechnologyDsl.g:897:2: ( ( rule__PrimitiveValue__StringValueAssignment_2 ) )
                    {
                    // InternalTechnologyDsl.g:897:2: ( ( rule__PrimitiveValue__StringValueAssignment_2 ) )
                    // InternalTechnologyDsl.g:898:3: ( rule__PrimitiveValue__StringValueAssignment_2 )
                    {
                     before(grammarAccess.getPrimitiveValueAccess().getStringValueAssignment_2()); 
                    // InternalTechnologyDsl.g:899:3: ( rule__PrimitiveValue__StringValueAssignment_2 )
                    // InternalTechnologyDsl.g:899:4: rule__PrimitiveValue__StringValueAssignment_2
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


    // $ANTLR start "rule__ServiceAspectPointcut__Alternatives"
    // InternalTechnologyDsl.g:907:1: rule__ServiceAspectPointcut__Alternatives : ( ( ( rule__ServiceAspectPointcut__Group_0__0 ) ) | ( ( rule__ServiceAspectPointcut__Group_1__0 ) ) | ( ( rule__ServiceAspectPointcut__Group_2__0 ) ) | ( ( rule__ServiceAspectPointcut__Group_3__0 ) ) );
    public final void rule__ServiceAspectPointcut__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:911:1: ( ( ( rule__ServiceAspectPointcut__Group_0__0 ) ) | ( ( rule__ServiceAspectPointcut__Group_1__0 ) ) | ( ( rule__ServiceAspectPointcut__Group_2__0 ) ) | ( ( rule__ServiceAspectPointcut__Group_3__0 ) ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 81:
                {
                alt4=1;
                }
                break;
            case 82:
                {
                alt4=2;
                }
                break;
            case 83:
                {
                alt4=3;
                }
                break;
            case 84:
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalTechnologyDsl.g:912:2: ( ( rule__ServiceAspectPointcut__Group_0__0 ) )
                    {
                    // InternalTechnologyDsl.g:912:2: ( ( rule__ServiceAspectPointcut__Group_0__0 ) )
                    // InternalTechnologyDsl.g:913:3: ( rule__ServiceAspectPointcut__Group_0__0 )
                    {
                     before(grammarAccess.getServiceAspectPointcutAccess().getGroup_0()); 
                    // InternalTechnologyDsl.g:914:3: ( rule__ServiceAspectPointcut__Group_0__0 )
                    // InternalTechnologyDsl.g:914:4: rule__ServiceAspectPointcut__Group_0__0
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
                    // InternalTechnologyDsl.g:918:2: ( ( rule__ServiceAspectPointcut__Group_1__0 ) )
                    {
                    // InternalTechnologyDsl.g:918:2: ( ( rule__ServiceAspectPointcut__Group_1__0 ) )
                    // InternalTechnologyDsl.g:919:3: ( rule__ServiceAspectPointcut__Group_1__0 )
                    {
                     before(grammarAccess.getServiceAspectPointcutAccess().getGroup_1()); 
                    // InternalTechnologyDsl.g:920:3: ( rule__ServiceAspectPointcut__Group_1__0 )
                    // InternalTechnologyDsl.g:920:4: rule__ServiceAspectPointcut__Group_1__0
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
                    // InternalTechnologyDsl.g:924:2: ( ( rule__ServiceAspectPointcut__Group_2__0 ) )
                    {
                    // InternalTechnologyDsl.g:924:2: ( ( rule__ServiceAspectPointcut__Group_2__0 ) )
                    // InternalTechnologyDsl.g:925:3: ( rule__ServiceAspectPointcut__Group_2__0 )
                    {
                     before(grammarAccess.getServiceAspectPointcutAccess().getGroup_2()); 
                    // InternalTechnologyDsl.g:926:3: ( rule__ServiceAspectPointcut__Group_2__0 )
                    // InternalTechnologyDsl.g:926:4: rule__ServiceAspectPointcut__Group_2__0
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
                    // InternalTechnologyDsl.g:930:2: ( ( rule__ServiceAspectPointcut__Group_3__0 ) )
                    {
                    // InternalTechnologyDsl.g:930:2: ( ( rule__ServiceAspectPointcut__Group_3__0 ) )
                    // InternalTechnologyDsl.g:931:3: ( rule__ServiceAspectPointcut__Group_3__0 )
                    {
                     before(grammarAccess.getServiceAspectPointcutAccess().getGroup_3()); 
                    // InternalTechnologyDsl.g:932:3: ( rule__ServiceAspectPointcut__Group_3__0 )
                    // InternalTechnologyDsl.g:932:4: rule__ServiceAspectPointcut__Group_3__0
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
    // InternalTechnologyDsl.g:940:1: rule__ServiceAspect__Alternatives_5 : ( ( ( rule__ServiceAspect__Group_5_0__0 ) ) | ( ';' ) );
    public final void rule__ServiceAspect__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:944:1: ( ( ( rule__ServiceAspect__Group_5_0__0 ) ) | ( ';' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==30) ) {
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
                    // InternalTechnologyDsl.g:945:2: ( ( rule__ServiceAspect__Group_5_0__0 ) )
                    {
                    // InternalTechnologyDsl.g:945:2: ( ( rule__ServiceAspect__Group_5_0__0 ) )
                    // InternalTechnologyDsl.g:946:3: ( rule__ServiceAspect__Group_5_0__0 )
                    {
                     before(grammarAccess.getServiceAspectAccess().getGroup_5_0()); 
                    // InternalTechnologyDsl.g:947:3: ( rule__ServiceAspect__Group_5_0__0 )
                    // InternalTechnologyDsl.g:947:4: rule__ServiceAspect__Group_5_0__0
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
                    // InternalTechnologyDsl.g:951:2: ( ';' )
                    {
                    // InternalTechnologyDsl.g:951:2: ( ';' )
                    // InternalTechnologyDsl.g:952:3: ';'
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
    // InternalTechnologyDsl.g:961:1: rule__OperationAspect__Alternatives_5 : ( ( ( rule__OperationAspect__Group_5_0__0 ) ) | ( ';' ) );
    public final void rule__OperationAspect__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:965:1: ( ( ( rule__OperationAspect__Group_5_0__0 ) ) | ( ';' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==30) ) {
                alt6=1;
            }
            else if ( (LA6_0==13) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalTechnologyDsl.g:966:2: ( ( rule__OperationAspect__Group_5_0__0 ) )
                    {
                    // InternalTechnologyDsl.g:966:2: ( ( rule__OperationAspect__Group_5_0__0 ) )
                    // InternalTechnologyDsl.g:967:3: ( rule__OperationAspect__Group_5_0__0 )
                    {
                     before(grammarAccess.getOperationAspectAccess().getGroup_5_0()); 
                    // InternalTechnologyDsl.g:968:3: ( rule__OperationAspect__Group_5_0__0 )
                    // InternalTechnologyDsl.g:968:4: rule__OperationAspect__Group_5_0__0
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
                    // InternalTechnologyDsl.g:972:2: ( ';' )
                    {
                    // InternalTechnologyDsl.g:972:2: ( ';' )
                    // InternalTechnologyDsl.g:973:3: ';'
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
    // InternalTechnologyDsl.g:982:1: rule__Version__Alternatives_3 : ( ( ( ( rule__Version__ComplexTypesAssignment_3_0 ) ) ( ( rule__Version__ComplexTypesAssignment_3_0 )* ) ) | ( ( ( rule__Version__ContextsAssignment_3_1 ) ) ( ( rule__Version__ContextsAssignment_3_1 )* ) ) );
    public final void rule__Version__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:986:1: ( ( ( ( rule__Version__ComplexTypesAssignment_3_0 ) ) ( ( rule__Version__ComplexTypesAssignment_3_0 )* ) ) | ( ( ( rule__Version__ContextsAssignment_3_1 ) ) ( ( rule__Version__ContextsAssignment_3_1 )* ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=53 && LA9_0<=54)) ) {
                alt9=1;
            }
            else if ( (LA9_0==66) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalTechnologyDsl.g:987:2: ( ( ( rule__Version__ComplexTypesAssignment_3_0 ) ) ( ( rule__Version__ComplexTypesAssignment_3_0 )* ) )
                    {
                    // InternalTechnologyDsl.g:987:2: ( ( ( rule__Version__ComplexTypesAssignment_3_0 ) ) ( ( rule__Version__ComplexTypesAssignment_3_0 )* ) )
                    // InternalTechnologyDsl.g:988:3: ( ( rule__Version__ComplexTypesAssignment_3_0 ) ) ( ( rule__Version__ComplexTypesAssignment_3_0 )* )
                    {
                    // InternalTechnologyDsl.g:988:3: ( ( rule__Version__ComplexTypesAssignment_3_0 ) )
                    // InternalTechnologyDsl.g:989:4: ( rule__Version__ComplexTypesAssignment_3_0 )
                    {
                     before(grammarAccess.getVersionAccess().getComplexTypesAssignment_3_0()); 
                    // InternalTechnologyDsl.g:990:4: ( rule__Version__ComplexTypesAssignment_3_0 )
                    // InternalTechnologyDsl.g:990:5: rule__Version__ComplexTypesAssignment_3_0
                    {
                    pushFollow(FOLLOW_3);
                    rule__Version__ComplexTypesAssignment_3_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getVersionAccess().getComplexTypesAssignment_3_0()); 

                    }

                    // InternalTechnologyDsl.g:993:3: ( ( rule__Version__ComplexTypesAssignment_3_0 )* )
                    // InternalTechnologyDsl.g:994:4: ( rule__Version__ComplexTypesAssignment_3_0 )*
                    {
                     before(grammarAccess.getVersionAccess().getComplexTypesAssignment_3_0()); 
                    // InternalTechnologyDsl.g:995:4: ( rule__Version__ComplexTypesAssignment_3_0 )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>=53 && LA7_0<=54)) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:995:5: rule__Version__ComplexTypesAssignment_3_0
                    	    {
                    	    pushFollow(FOLLOW_3);
                    	    rule__Version__ComplexTypesAssignment_3_0();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                     after(grammarAccess.getVersionAccess().getComplexTypesAssignment_3_0()); 

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:1000:2: ( ( ( rule__Version__ContextsAssignment_3_1 ) ) ( ( rule__Version__ContextsAssignment_3_1 )* ) )
                    {
                    // InternalTechnologyDsl.g:1000:2: ( ( ( rule__Version__ContextsAssignment_3_1 ) ) ( ( rule__Version__ContextsAssignment_3_1 )* ) )
                    // InternalTechnologyDsl.g:1001:3: ( ( rule__Version__ContextsAssignment_3_1 ) ) ( ( rule__Version__ContextsAssignment_3_1 )* )
                    {
                    // InternalTechnologyDsl.g:1001:3: ( ( rule__Version__ContextsAssignment_3_1 ) )
                    // InternalTechnologyDsl.g:1002:4: ( rule__Version__ContextsAssignment_3_1 )
                    {
                     before(grammarAccess.getVersionAccess().getContextsAssignment_3_1()); 
                    // InternalTechnologyDsl.g:1003:4: ( rule__Version__ContextsAssignment_3_1 )
                    // InternalTechnologyDsl.g:1003:5: rule__Version__ContextsAssignment_3_1
                    {
                    pushFollow(FOLLOW_4);
                    rule__Version__ContextsAssignment_3_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getVersionAccess().getContextsAssignment_3_1()); 

                    }

                    // InternalTechnologyDsl.g:1006:3: ( ( rule__Version__ContextsAssignment_3_1 )* )
                    // InternalTechnologyDsl.g:1007:4: ( rule__Version__ContextsAssignment_3_1 )*
                    {
                     before(grammarAccess.getVersionAccess().getContextsAssignment_3_1()); 
                    // InternalTechnologyDsl.g:1008:4: ( rule__Version__ContextsAssignment_3_1 )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==66) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:1008:5: rule__Version__ContextsAssignment_3_1
                    	    {
                    	    pushFollow(FOLLOW_4);
                    	    rule__Version__ContextsAssignment_3_1();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
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
    // InternalTechnologyDsl.g:1017:1: rule__ComplexType__Alternatives : ( ( ruleDataStructure ) | ( ruleListType ) );
    public final void rule__ComplexType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1021:1: ( ( ruleDataStructure ) | ( ruleListType ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==54) ) {
                alt10=1;
            }
            else if ( (LA10_0==53) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalTechnologyDsl.g:1022:2: ( ruleDataStructure )
                    {
                    // InternalTechnologyDsl.g:1022:2: ( ruleDataStructure )
                    // InternalTechnologyDsl.g:1023:3: ruleDataStructure
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
                    // InternalTechnologyDsl.g:1028:2: ( ruleListType )
                    {
                    // InternalTechnologyDsl.g:1028:2: ( ruleListType )
                    // InternalTechnologyDsl.g:1029:3: ruleListType
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
    // InternalTechnologyDsl.g:1038:1: rule__ListType__Alternatives : ( ( ( rule__ListType__Group_0__0 ) ) | ( ( rule__ListType__Group_1__0 ) ) );
    public final void rule__ListType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1042:1: ( ( ( rule__ListType__Group_0__0 ) ) | ( ( rule__ListType__Group_1__0 ) ) )
            int alt11=2;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // InternalTechnologyDsl.g:1043:2: ( ( rule__ListType__Group_0__0 ) )
                    {
                    // InternalTechnologyDsl.g:1043:2: ( ( rule__ListType__Group_0__0 ) )
                    // InternalTechnologyDsl.g:1044:3: ( rule__ListType__Group_0__0 )
                    {
                     before(grammarAccess.getListTypeAccess().getGroup_0()); 
                    // InternalTechnologyDsl.g:1045:3: ( rule__ListType__Group_0__0 )
                    // InternalTechnologyDsl.g:1045:4: rule__ListType__Group_0__0
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
                    // InternalTechnologyDsl.g:1049:2: ( ( rule__ListType__Group_1__0 ) )
                    {
                    // InternalTechnologyDsl.g:1049:2: ( ( rule__ListType__Group_1__0 ) )
                    // InternalTechnologyDsl.g:1050:3: ( rule__ListType__Group_1__0 )
                    {
                     before(grammarAccess.getListTypeAccess().getGroup_1()); 
                    // InternalTechnologyDsl.g:1051:3: ( rule__ListType__Group_1__0 )
                    // InternalTechnologyDsl.g:1051:4: rule__ListType__Group_1__0
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
    // InternalTechnologyDsl.g:1059:1: rule__DataField__Alternatives_1 : ( ( ( rule__DataField__PrimitiveTypeAssignment_1_0 ) ) | ( ( rule__DataField__ComplexTypeAssignment_1_1 ) ) );
    public final void rule__DataField__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1063:1: ( ( ( rule__DataField__PrimitiveTypeAssignment_1_0 ) ) | ( ( rule__DataField__ComplexTypeAssignment_1_1 ) ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=68 && LA12_0<=77)) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_ID) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalTechnologyDsl.g:1064:2: ( ( rule__DataField__PrimitiveTypeAssignment_1_0 ) )
                    {
                    // InternalTechnologyDsl.g:1064:2: ( ( rule__DataField__PrimitiveTypeAssignment_1_0 ) )
                    // InternalTechnologyDsl.g:1065:3: ( rule__DataField__PrimitiveTypeAssignment_1_0 )
                    {
                     before(grammarAccess.getDataFieldAccess().getPrimitiveTypeAssignment_1_0()); 
                    // InternalTechnologyDsl.g:1066:3: ( rule__DataField__PrimitiveTypeAssignment_1_0 )
                    // InternalTechnologyDsl.g:1066:4: rule__DataField__PrimitiveTypeAssignment_1_0
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
                    // InternalTechnologyDsl.g:1070:2: ( ( rule__DataField__ComplexTypeAssignment_1_1 ) )
                    {
                    // InternalTechnologyDsl.g:1070:2: ( ( rule__DataField__ComplexTypeAssignment_1_1 ) )
                    // InternalTechnologyDsl.g:1071:3: ( rule__DataField__ComplexTypeAssignment_1_1 )
                    {
                     before(grammarAccess.getDataFieldAccess().getComplexTypeAssignment_1_1()); 
                    // InternalTechnologyDsl.g:1072:3: ( rule__DataField__ComplexTypeAssignment_1_1 )
                    // InternalTechnologyDsl.g:1072:4: rule__DataField__ComplexTypeAssignment_1_1
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
    // InternalTechnologyDsl.g:1080:1: rule__PrimitiveType__Alternatives : ( ( ( rule__PrimitiveType__Group_0__0 ) ) | ( ( rule__PrimitiveType__Group_1__0 ) ) | ( ( rule__PrimitiveType__Group_2__0 ) ) | ( ( rule__PrimitiveType__Group_3__0 ) ) | ( ( rule__PrimitiveType__Group_4__0 ) ) | ( ( rule__PrimitiveType__Group_5__0 ) ) | ( ( rule__PrimitiveType__Group_6__0 ) ) | ( ( rule__PrimitiveType__Group_7__0 ) ) | ( ( rule__PrimitiveType__Group_8__0 ) ) | ( ( rule__PrimitiveType__Group_9__0 ) ) );
    public final void rule__PrimitiveType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1084:1: ( ( ( rule__PrimitiveType__Group_0__0 ) ) | ( ( rule__PrimitiveType__Group_1__0 ) ) | ( ( rule__PrimitiveType__Group_2__0 ) ) | ( ( rule__PrimitiveType__Group_3__0 ) ) | ( ( rule__PrimitiveType__Group_4__0 ) ) | ( ( rule__PrimitiveType__Group_5__0 ) ) | ( ( rule__PrimitiveType__Group_6__0 ) ) | ( ( rule__PrimitiveType__Group_7__0 ) ) | ( ( rule__PrimitiveType__Group_8__0 ) ) | ( ( rule__PrimitiveType__Group_9__0 ) ) )
            int alt13=10;
            switch ( input.LA(1) ) {
            case 68:
                {
                alt13=1;
                }
                break;
            case 69:
                {
                alt13=2;
                }
                break;
            case 70:
                {
                alt13=3;
                }
                break;
            case 71:
                {
                alt13=4;
                }
                break;
            case 72:
                {
                alt13=5;
                }
                break;
            case 73:
                {
                alt13=6;
                }
                break;
            case 74:
                {
                alt13=7;
                }
                break;
            case 75:
                {
                alt13=8;
                }
                break;
            case 76:
                {
                alt13=9;
                }
                break;
            case 77:
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
                    // InternalTechnologyDsl.g:1085:2: ( ( rule__PrimitiveType__Group_0__0 ) )
                    {
                    // InternalTechnologyDsl.g:1085:2: ( ( rule__PrimitiveType__Group_0__0 ) )
                    // InternalTechnologyDsl.g:1086:3: ( rule__PrimitiveType__Group_0__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_0()); 
                    // InternalTechnologyDsl.g:1087:3: ( rule__PrimitiveType__Group_0__0 )
                    // InternalTechnologyDsl.g:1087:4: rule__PrimitiveType__Group_0__0
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
                    // InternalTechnologyDsl.g:1091:2: ( ( rule__PrimitiveType__Group_1__0 ) )
                    {
                    // InternalTechnologyDsl.g:1091:2: ( ( rule__PrimitiveType__Group_1__0 ) )
                    // InternalTechnologyDsl.g:1092:3: ( rule__PrimitiveType__Group_1__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_1()); 
                    // InternalTechnologyDsl.g:1093:3: ( rule__PrimitiveType__Group_1__0 )
                    // InternalTechnologyDsl.g:1093:4: rule__PrimitiveType__Group_1__0
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
                    // InternalTechnologyDsl.g:1097:2: ( ( rule__PrimitiveType__Group_2__0 ) )
                    {
                    // InternalTechnologyDsl.g:1097:2: ( ( rule__PrimitiveType__Group_2__0 ) )
                    // InternalTechnologyDsl.g:1098:3: ( rule__PrimitiveType__Group_2__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_2()); 
                    // InternalTechnologyDsl.g:1099:3: ( rule__PrimitiveType__Group_2__0 )
                    // InternalTechnologyDsl.g:1099:4: rule__PrimitiveType__Group_2__0
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
                    // InternalTechnologyDsl.g:1103:2: ( ( rule__PrimitiveType__Group_3__0 ) )
                    {
                    // InternalTechnologyDsl.g:1103:2: ( ( rule__PrimitiveType__Group_3__0 ) )
                    // InternalTechnologyDsl.g:1104:3: ( rule__PrimitiveType__Group_3__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_3()); 
                    // InternalTechnologyDsl.g:1105:3: ( rule__PrimitiveType__Group_3__0 )
                    // InternalTechnologyDsl.g:1105:4: rule__PrimitiveType__Group_3__0
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
                    // InternalTechnologyDsl.g:1109:2: ( ( rule__PrimitiveType__Group_4__0 ) )
                    {
                    // InternalTechnologyDsl.g:1109:2: ( ( rule__PrimitiveType__Group_4__0 ) )
                    // InternalTechnologyDsl.g:1110:3: ( rule__PrimitiveType__Group_4__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_4()); 
                    // InternalTechnologyDsl.g:1111:3: ( rule__PrimitiveType__Group_4__0 )
                    // InternalTechnologyDsl.g:1111:4: rule__PrimitiveType__Group_4__0
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
                    // InternalTechnologyDsl.g:1115:2: ( ( rule__PrimitiveType__Group_5__0 ) )
                    {
                    // InternalTechnologyDsl.g:1115:2: ( ( rule__PrimitiveType__Group_5__0 ) )
                    // InternalTechnologyDsl.g:1116:3: ( rule__PrimitiveType__Group_5__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_5()); 
                    // InternalTechnologyDsl.g:1117:3: ( rule__PrimitiveType__Group_5__0 )
                    // InternalTechnologyDsl.g:1117:4: rule__PrimitiveType__Group_5__0
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
                    // InternalTechnologyDsl.g:1121:2: ( ( rule__PrimitiveType__Group_6__0 ) )
                    {
                    // InternalTechnologyDsl.g:1121:2: ( ( rule__PrimitiveType__Group_6__0 ) )
                    // InternalTechnologyDsl.g:1122:3: ( rule__PrimitiveType__Group_6__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_6()); 
                    // InternalTechnologyDsl.g:1123:3: ( rule__PrimitiveType__Group_6__0 )
                    // InternalTechnologyDsl.g:1123:4: rule__PrimitiveType__Group_6__0
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
                    // InternalTechnologyDsl.g:1127:2: ( ( rule__PrimitiveType__Group_7__0 ) )
                    {
                    // InternalTechnologyDsl.g:1127:2: ( ( rule__PrimitiveType__Group_7__0 ) )
                    // InternalTechnologyDsl.g:1128:3: ( rule__PrimitiveType__Group_7__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_7()); 
                    // InternalTechnologyDsl.g:1129:3: ( rule__PrimitiveType__Group_7__0 )
                    // InternalTechnologyDsl.g:1129:4: rule__PrimitiveType__Group_7__0
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
                    // InternalTechnologyDsl.g:1133:2: ( ( rule__PrimitiveType__Group_8__0 ) )
                    {
                    // InternalTechnologyDsl.g:1133:2: ( ( rule__PrimitiveType__Group_8__0 ) )
                    // InternalTechnologyDsl.g:1134:3: ( rule__PrimitiveType__Group_8__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_8()); 
                    // InternalTechnologyDsl.g:1135:3: ( rule__PrimitiveType__Group_8__0 )
                    // InternalTechnologyDsl.g:1135:4: rule__PrimitiveType__Group_8__0
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
                    // InternalTechnologyDsl.g:1139:2: ( ( rule__PrimitiveType__Group_9__0 ) )
                    {
                    // InternalTechnologyDsl.g:1139:2: ( ( rule__PrimitiveType__Group_9__0 ) )
                    // InternalTechnologyDsl.g:1140:3: ( rule__PrimitiveType__Group_9__0 )
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getGroup_9()); 
                    // InternalTechnologyDsl.g:1141:3: ( rule__PrimitiveType__Group_9__0 )
                    // InternalTechnologyDsl.g:1141:4: rule__PrimitiveType__Group_9__0
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
    // InternalTechnologyDsl.g:1149:1: rule__ExchangePattern__Alternatives : ( ( ( 'in' ) ) | ( ( 'out' ) ) | ( ( 'inout' ) ) );
    public final void rule__ExchangePattern__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1153:1: ( ( ( 'in' ) ) | ( ( 'out' ) ) | ( ( 'inout' ) ) )
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
                    // InternalTechnologyDsl.g:1154:2: ( ( 'in' ) )
                    {
                    // InternalTechnologyDsl.g:1154:2: ( ( 'in' ) )
                    // InternalTechnologyDsl.g:1155:3: ( 'in' )
                    {
                     before(grammarAccess.getExchangePatternAccess().getINEnumLiteralDeclaration_0()); 
                    // InternalTechnologyDsl.g:1156:3: ( 'in' )
                    // InternalTechnologyDsl.g:1156:4: 'in'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getExchangePatternAccess().getINEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:1160:2: ( ( 'out' ) )
                    {
                    // InternalTechnologyDsl.g:1160:2: ( ( 'out' ) )
                    // InternalTechnologyDsl.g:1161:3: ( 'out' )
                    {
                     before(grammarAccess.getExchangePatternAccess().getOUTEnumLiteralDeclaration_1()); 
                    // InternalTechnologyDsl.g:1162:3: ( 'out' )
                    // InternalTechnologyDsl.g:1162:4: 'out'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getExchangePatternAccess().getOUTEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTechnologyDsl.g:1166:2: ( ( 'inout' ) )
                    {
                    // InternalTechnologyDsl.g:1166:2: ( ( 'inout' ) )
                    // InternalTechnologyDsl.g:1167:3: ( 'inout' )
                    {
                     before(grammarAccess.getExchangePatternAccess().getINOUTEnumLiteralDeclaration_2()); 
                    // InternalTechnologyDsl.g:1168:3: ( 'inout' )
                    // InternalTechnologyDsl.g:1168:4: 'inout'
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
    // InternalTechnologyDsl.g:1176:1: rule__CommunicationType__Alternatives : ( ( ( 'sync' ) ) | ( ( 'async' ) ) );
    public final void rule__CommunicationType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1180:1: ( ( ( 'sync' ) ) | ( ( 'async' ) ) )
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
                    // InternalTechnologyDsl.g:1181:2: ( ( 'sync' ) )
                    {
                    // InternalTechnologyDsl.g:1181:2: ( ( 'sync' ) )
                    // InternalTechnologyDsl.g:1182:3: ( 'sync' )
                    {
                     before(grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_0()); 
                    // InternalTechnologyDsl.g:1183:3: ( 'sync' )
                    // InternalTechnologyDsl.g:1183:4: 'sync'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getCommunicationTypeAccess().getSYNCHRONOUSEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:1187:2: ( ( 'async' ) )
                    {
                    // InternalTechnologyDsl.g:1187:2: ( ( 'async' ) )
                    // InternalTechnologyDsl.g:1188:3: ( 'async' )
                    {
                     before(grammarAccess.getCommunicationTypeAccess().getASYNCHRONOUSEnumLiteralDeclaration_1()); 
                    // InternalTechnologyDsl.g:1189:3: ( 'async' )
                    // InternalTechnologyDsl.g:1189:4: 'async'
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
    // InternalTechnologyDsl.g:1197:1: rule__CompatibilityDirection__Alternatives : ( ( ( '<-' ) ) | ( ( '->' ) ) | ( ( '<->' ) ) );
    public final void rule__CompatibilityDirection__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1201:1: ( ( ( '<-' ) ) | ( ( '->' ) ) | ( ( '<->' ) ) )
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
                    // InternalTechnologyDsl.g:1202:2: ( ( '<-' ) )
                    {
                    // InternalTechnologyDsl.g:1202:2: ( ( '<-' ) )
                    // InternalTechnologyDsl.g:1203:3: ( '<-' )
                    {
                     before(grammarAccess.getCompatibilityDirectionAccess().getMAPPING_TO_COMPATIBLE_TYPESEnumLiteralDeclaration_0()); 
                    // InternalTechnologyDsl.g:1204:3: ( '<-' )
                    // InternalTechnologyDsl.g:1204:4: '<-'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getCompatibilityDirectionAccess().getMAPPING_TO_COMPATIBLE_TYPESEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:1208:2: ( ( '->' ) )
                    {
                    // InternalTechnologyDsl.g:1208:2: ( ( '->' ) )
                    // InternalTechnologyDsl.g:1209:3: ( '->' )
                    {
                     before(grammarAccess.getCompatibilityDirectionAccess().getCOMPATIBLE_TYPES_TO_MAPPINGEnumLiteralDeclaration_1()); 
                    // InternalTechnologyDsl.g:1210:3: ( '->' )
                    // InternalTechnologyDsl.g:1210:4: '->'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getCompatibilityDirectionAccess().getCOMPATIBLE_TYPES_TO_MAPPINGEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTechnologyDsl.g:1214:2: ( ( '<->' ) )
                    {
                    // InternalTechnologyDsl.g:1214:2: ( ( '<->' ) )
                    // InternalTechnologyDsl.g:1215:3: ( '<->' )
                    {
                     before(grammarAccess.getCompatibilityDirectionAccess().getBIDIRECTIONALEnumLiteralDeclaration_2()); 
                    // InternalTechnologyDsl.g:1216:3: ( '<->' )
                    // InternalTechnologyDsl.g:1216:4: '<->'
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
    // InternalTechnologyDsl.g:1224:1: rule__ServiceJoinPointType__Alternatives : ( ( ( 'microservices' ) ) | ( ( 'interfaces' ) ) | ( ( 'operations' ) ) | ( ( 'parameters' ) ) | ( ( 'fields' ) ) );
    public final void rule__ServiceJoinPointType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1228:1: ( ( ( 'microservices' ) ) | ( ( 'interfaces' ) ) | ( ( 'operations' ) ) | ( ( 'parameters' ) ) | ( ( 'fields' ) ) )
            int alt17=5;
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalTechnologyDsl.g:1229:2: ( ( 'microservices' ) )
                    {
                    // InternalTechnologyDsl.g:1229:2: ( ( 'microservices' ) )
                    // InternalTechnologyDsl.g:1230:3: ( 'microservices' )
                    {
                     before(grammarAccess.getServiceJoinPointTypeAccess().getMICROSERVICESEnumLiteralDeclaration_0()); 
                    // InternalTechnologyDsl.g:1231:3: ( 'microservices' )
                    // InternalTechnologyDsl.g:1231:4: 'microservices'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getServiceJoinPointTypeAccess().getMICROSERVICESEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:1235:2: ( ( 'interfaces' ) )
                    {
                    // InternalTechnologyDsl.g:1235:2: ( ( 'interfaces' ) )
                    // InternalTechnologyDsl.g:1236:3: ( 'interfaces' )
                    {
                     before(grammarAccess.getServiceJoinPointTypeAccess().getINTERFACESEnumLiteralDeclaration_1()); 
                    // InternalTechnologyDsl.g:1237:3: ( 'interfaces' )
                    // InternalTechnologyDsl.g:1237:4: 'interfaces'
                    {
                    match(input,23,FOLLOW_2); 

                    }

                     after(grammarAccess.getServiceJoinPointTypeAccess().getINTERFACESEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTechnologyDsl.g:1241:2: ( ( 'operations' ) )
                    {
                    // InternalTechnologyDsl.g:1241:2: ( ( 'operations' ) )
                    // InternalTechnologyDsl.g:1242:3: ( 'operations' )
                    {
                     before(grammarAccess.getServiceJoinPointTypeAccess().getOPERATIONSEnumLiteralDeclaration_2()); 
                    // InternalTechnologyDsl.g:1243:3: ( 'operations' )
                    // InternalTechnologyDsl.g:1243:4: 'operations'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getServiceJoinPointTypeAccess().getOPERATIONSEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalTechnologyDsl.g:1247:2: ( ( 'parameters' ) )
                    {
                    // InternalTechnologyDsl.g:1247:2: ( ( 'parameters' ) )
                    // InternalTechnologyDsl.g:1248:3: ( 'parameters' )
                    {
                     before(grammarAccess.getServiceJoinPointTypeAccess().getPARAMETERSEnumLiteralDeclaration_3()); 
                    // InternalTechnologyDsl.g:1249:3: ( 'parameters' )
                    // InternalTechnologyDsl.g:1249:4: 'parameters'
                    {
                    match(input,25,FOLLOW_2); 

                    }

                     after(grammarAccess.getServiceJoinPointTypeAccess().getPARAMETERSEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalTechnologyDsl.g:1253:2: ( ( 'fields' ) )
                    {
                    // InternalTechnologyDsl.g:1253:2: ( ( 'fields' ) )
                    // InternalTechnologyDsl.g:1254:3: ( 'fields' )
                    {
                     before(grammarAccess.getServiceJoinPointTypeAccess().getDATA_FIELDSEnumLiteralDeclaration_4()); 
                    // InternalTechnologyDsl.g:1255:3: ( 'fields' )
                    // InternalTechnologyDsl.g:1255:4: 'fields'
                    {
                    match(input,26,FOLLOW_2); 

                    }

                     after(grammarAccess.getServiceJoinPointTypeAccess().getDATA_FIELDSEnumLiteralDeclaration_4()); 

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
    // InternalTechnologyDsl.g:1263:1: rule__OperationJoinPointType__Alternatives : ( ( ( 'containers' ) ) | ( ( 'infrastructure' ) ) );
    public final void rule__OperationJoinPointType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1267:1: ( ( ( 'containers' ) ) | ( ( 'infrastructure' ) ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==27) ) {
                alt18=1;
            }
            else if ( (LA18_0==28) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalTechnologyDsl.g:1268:2: ( ( 'containers' ) )
                    {
                    // InternalTechnologyDsl.g:1268:2: ( ( 'containers' ) )
                    // InternalTechnologyDsl.g:1269:3: ( 'containers' )
                    {
                     before(grammarAccess.getOperationJoinPointTypeAccess().getCONTAINERSEnumLiteralDeclaration_0()); 
                    // InternalTechnologyDsl.g:1270:3: ( 'containers' )
                    // InternalTechnologyDsl.g:1270:4: 'containers'
                    {
                    match(input,27,FOLLOW_2); 

                    }

                     after(grammarAccess.getOperationJoinPointTypeAccess().getCONTAINERSEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:1274:2: ( ( 'infrastructure' ) )
                    {
                    // InternalTechnologyDsl.g:1274:2: ( ( 'infrastructure' ) )
                    // InternalTechnologyDsl.g:1275:3: ( 'infrastructure' )
                    {
                     before(grammarAccess.getOperationJoinPointTypeAccess().getINFRASTRUCTURE_NODESEnumLiteralDeclaration_1()); 
                    // InternalTechnologyDsl.g:1276:3: ( 'infrastructure' )
                    // InternalTechnologyDsl.g:1276:4: 'infrastructure'
                    {
                    match(input,28,FOLLOW_2); 

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
    // InternalTechnologyDsl.g:1284:1: rule__Technology__Group__0 : rule__Technology__Group__0__Impl rule__Technology__Group__1 ;
    public final void rule__Technology__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1288:1: ( rule__Technology__Group__0__Impl rule__Technology__Group__1 )
            // InternalTechnologyDsl.g:1289:2: rule__Technology__Group__0__Impl rule__Technology__Group__1
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
    // InternalTechnologyDsl.g:1296:1: rule__Technology__Group__0__Impl : ( ( rule__Technology__ImportsAssignment_0 )* ) ;
    public final void rule__Technology__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1300:1: ( ( ( rule__Technology__ImportsAssignment_0 )* ) )
            // InternalTechnologyDsl.g:1301:1: ( ( rule__Technology__ImportsAssignment_0 )* )
            {
            // InternalTechnologyDsl.g:1301:1: ( ( rule__Technology__ImportsAssignment_0 )* )
            // InternalTechnologyDsl.g:1302:2: ( rule__Technology__ImportsAssignment_0 )*
            {
             before(grammarAccess.getTechnologyAccess().getImportsAssignment_0()); 
            // InternalTechnologyDsl.g:1303:2: ( rule__Technology__ImportsAssignment_0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==41) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalTechnologyDsl.g:1303:3: rule__Technology__ImportsAssignment_0
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
    // InternalTechnologyDsl.g:1311:1: rule__Technology__Group__1 : rule__Technology__Group__1__Impl rule__Technology__Group__2 ;
    public final void rule__Technology__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1315:1: ( rule__Technology__Group__1__Impl rule__Technology__Group__2 )
            // InternalTechnologyDsl.g:1316:2: rule__Technology__Group__1__Impl rule__Technology__Group__2
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
    // InternalTechnologyDsl.g:1323:1: rule__Technology__Group__1__Impl : ( 'technology' ) ;
    public final void rule__Technology__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1327:1: ( ( 'technology' ) )
            // InternalTechnologyDsl.g:1328:1: ( 'technology' )
            {
            // InternalTechnologyDsl.g:1328:1: ( 'technology' )
            // InternalTechnologyDsl.g:1329:2: 'technology'
            {
             before(grammarAccess.getTechnologyAccess().getTechnologyKeyword_1()); 
            match(input,29,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:1338:1: rule__Technology__Group__2 : rule__Technology__Group__2__Impl rule__Technology__Group__3 ;
    public final void rule__Technology__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1342:1: ( rule__Technology__Group__2__Impl rule__Technology__Group__3 )
            // InternalTechnologyDsl.g:1343:2: rule__Technology__Group__2__Impl rule__Technology__Group__3
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
    // InternalTechnologyDsl.g:1350:1: rule__Technology__Group__2__Impl : ( ( rule__Technology__NameAssignment_2 ) ) ;
    public final void rule__Technology__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1354:1: ( ( ( rule__Technology__NameAssignment_2 ) ) )
            // InternalTechnologyDsl.g:1355:1: ( ( rule__Technology__NameAssignment_2 ) )
            {
            // InternalTechnologyDsl.g:1355:1: ( ( rule__Technology__NameAssignment_2 ) )
            // InternalTechnologyDsl.g:1356:2: ( rule__Technology__NameAssignment_2 )
            {
             before(grammarAccess.getTechnologyAccess().getNameAssignment_2()); 
            // InternalTechnologyDsl.g:1357:2: ( rule__Technology__NameAssignment_2 )
            // InternalTechnologyDsl.g:1357:3: rule__Technology__NameAssignment_2
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
    // InternalTechnologyDsl.g:1365:1: rule__Technology__Group__3 : rule__Technology__Group__3__Impl rule__Technology__Group__4 ;
    public final void rule__Technology__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1369:1: ( rule__Technology__Group__3__Impl rule__Technology__Group__4 )
            // InternalTechnologyDsl.g:1370:2: rule__Technology__Group__3__Impl rule__Technology__Group__4
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
    // InternalTechnologyDsl.g:1377:1: rule__Technology__Group__3__Impl : ( '{' ) ;
    public final void rule__Technology__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1381:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:1382:1: ( '{' )
            {
            // InternalTechnologyDsl.g:1382:1: ( '{' )
            // InternalTechnologyDsl.g:1383:2: '{'
            {
             before(grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,30,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:1392:1: rule__Technology__Group__4 : rule__Technology__Group__4__Impl rule__Technology__Group__5 ;
    public final void rule__Technology__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1396:1: ( rule__Technology__Group__4__Impl rule__Technology__Group__5 )
            // InternalTechnologyDsl.g:1397:2: rule__Technology__Group__4__Impl rule__Technology__Group__5
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
    // InternalTechnologyDsl.g:1404:1: rule__Technology__Group__4__Impl : ( ( rule__Technology__Group_4__0 )? ) ;
    public final void rule__Technology__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1408:1: ( ( ( rule__Technology__Group_4__0 )? ) )
            // InternalTechnologyDsl.g:1409:1: ( ( rule__Technology__Group_4__0 )? )
            {
            // InternalTechnologyDsl.g:1409:1: ( ( rule__Technology__Group_4__0 )? )
            // InternalTechnologyDsl.g:1410:2: ( rule__Technology__Group_4__0 )?
            {
             before(grammarAccess.getTechnologyAccess().getGroup_4()); 
            // InternalTechnologyDsl.g:1411:2: ( rule__Technology__Group_4__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==32) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalTechnologyDsl.g:1411:3: rule__Technology__Group_4__0
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
    // InternalTechnologyDsl.g:1419:1: rule__Technology__Group__5 : rule__Technology__Group__5__Impl rule__Technology__Group__6 ;
    public final void rule__Technology__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1423:1: ( rule__Technology__Group__5__Impl rule__Technology__Group__6 )
            // InternalTechnologyDsl.g:1424:2: rule__Technology__Group__5__Impl rule__Technology__Group__6
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
    // InternalTechnologyDsl.g:1431:1: rule__Technology__Group__5__Impl : ( ( rule__Technology__Group_5__0 )? ) ;
    public final void rule__Technology__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1435:1: ( ( ( rule__Technology__Group_5__0 )? ) )
            // InternalTechnologyDsl.g:1436:1: ( ( rule__Technology__Group_5__0 )? )
            {
            // InternalTechnologyDsl.g:1436:1: ( ( rule__Technology__Group_5__0 )? )
            // InternalTechnologyDsl.g:1437:2: ( rule__Technology__Group_5__0 )?
            {
             before(grammarAccess.getTechnologyAccess().getGroup_5()); 
            // InternalTechnologyDsl.g:1438:2: ( rule__Technology__Group_5__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==35) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalTechnologyDsl.g:1438:3: rule__Technology__Group_5__0
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
    // InternalTechnologyDsl.g:1446:1: rule__Technology__Group__6 : rule__Technology__Group__6__Impl rule__Technology__Group__7 ;
    public final void rule__Technology__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1450:1: ( rule__Technology__Group__6__Impl rule__Technology__Group__7 )
            // InternalTechnologyDsl.g:1451:2: rule__Technology__Group__6__Impl rule__Technology__Group__7
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
    // InternalTechnologyDsl.g:1458:1: rule__Technology__Group__6__Impl : ( ( rule__Technology__Group_6__0 )? ) ;
    public final void rule__Technology__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1462:1: ( ( ( rule__Technology__Group_6__0 )? ) )
            // InternalTechnologyDsl.g:1463:1: ( ( rule__Technology__Group_6__0 )? )
            {
            // InternalTechnologyDsl.g:1463:1: ( ( rule__Technology__Group_6__0 )? )
            // InternalTechnologyDsl.g:1464:2: ( rule__Technology__Group_6__0 )?
            {
             before(grammarAccess.getTechnologyAccess().getGroup_6()); 
            // InternalTechnologyDsl.g:1465:2: ( rule__Technology__Group_6__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==36) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalTechnologyDsl.g:1465:3: rule__Technology__Group_6__0
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
    // InternalTechnologyDsl.g:1473:1: rule__Technology__Group__7 : rule__Technology__Group__7__Impl rule__Technology__Group__8 ;
    public final void rule__Technology__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1477:1: ( rule__Technology__Group__7__Impl rule__Technology__Group__8 )
            // InternalTechnologyDsl.g:1478:2: rule__Technology__Group__7__Impl rule__Technology__Group__8
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
    // InternalTechnologyDsl.g:1485:1: rule__Technology__Group__7__Impl : ( ( rule__Technology__Group_7__0 )? ) ;
    public final void rule__Technology__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1489:1: ( ( ( rule__Technology__Group_7__0 )? ) )
            // InternalTechnologyDsl.g:1490:1: ( ( rule__Technology__Group_7__0 )? )
            {
            // InternalTechnologyDsl.g:1490:1: ( ( rule__Technology__Group_7__0 )? )
            // InternalTechnologyDsl.g:1491:2: ( rule__Technology__Group_7__0 )?
            {
             before(grammarAccess.getTechnologyAccess().getGroup_7()); 
            // InternalTechnologyDsl.g:1492:2: ( rule__Technology__Group_7__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==38) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalTechnologyDsl.g:1492:3: rule__Technology__Group_7__0
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
    // InternalTechnologyDsl.g:1500:1: rule__Technology__Group__8 : rule__Technology__Group__8__Impl rule__Technology__Group__9 ;
    public final void rule__Technology__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1504:1: ( rule__Technology__Group__8__Impl rule__Technology__Group__9 )
            // InternalTechnologyDsl.g:1505:2: rule__Technology__Group__8__Impl rule__Technology__Group__9
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
    // InternalTechnologyDsl.g:1512:1: rule__Technology__Group__8__Impl : ( ( rule__Technology__Group_8__0 )? ) ;
    public final void rule__Technology__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1516:1: ( ( ( rule__Technology__Group_8__0 )? ) )
            // InternalTechnologyDsl.g:1517:1: ( ( rule__Technology__Group_8__0 )? )
            {
            // InternalTechnologyDsl.g:1517:1: ( ( rule__Technology__Group_8__0 )? )
            // InternalTechnologyDsl.g:1518:2: ( rule__Technology__Group_8__0 )?
            {
             before(grammarAccess.getTechnologyAccess().getGroup_8()); 
            // InternalTechnologyDsl.g:1519:2: ( rule__Technology__Group_8__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==28) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalTechnologyDsl.g:1519:3: rule__Technology__Group_8__0
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
    // InternalTechnologyDsl.g:1527:1: rule__Technology__Group__9 : rule__Technology__Group__9__Impl rule__Technology__Group__10 ;
    public final void rule__Technology__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1531:1: ( rule__Technology__Group__9__Impl rule__Technology__Group__10 )
            // InternalTechnologyDsl.g:1532:2: rule__Technology__Group__9__Impl rule__Technology__Group__10
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
    // InternalTechnologyDsl.g:1539:1: rule__Technology__Group__9__Impl : ( ( rule__Technology__Group_9__0 )? ) ;
    public final void rule__Technology__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1543:1: ( ( ( rule__Technology__Group_9__0 )? ) )
            // InternalTechnologyDsl.g:1544:1: ( ( rule__Technology__Group_9__0 )? )
            {
            // InternalTechnologyDsl.g:1544:1: ( ( rule__Technology__Group_9__0 )? )
            // InternalTechnologyDsl.g:1545:2: ( rule__Technology__Group_9__0 )?
            {
             before(grammarAccess.getTechnologyAccess().getGroup_9()); 
            // InternalTechnologyDsl.g:1546:2: ( rule__Technology__Group_9__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==40) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalTechnologyDsl.g:1546:3: rule__Technology__Group_9__0
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
    // InternalTechnologyDsl.g:1554:1: rule__Technology__Group__10 : rule__Technology__Group__10__Impl ;
    public final void rule__Technology__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1558:1: ( rule__Technology__Group__10__Impl )
            // InternalTechnologyDsl.g:1559:2: rule__Technology__Group__10__Impl
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
    // InternalTechnologyDsl.g:1565:1: rule__Technology__Group__10__Impl : ( '}' ) ;
    public final void rule__Technology__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1569:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:1570:1: ( '}' )
            {
            // InternalTechnologyDsl.g:1570:1: ( '}' )
            // InternalTechnologyDsl.g:1571:2: '}'
            {
             before(grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_10()); 
            match(input,31,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:1581:1: rule__Technology__Group_4__0 : rule__Technology__Group_4__0__Impl rule__Technology__Group_4__1 ;
    public final void rule__Technology__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1585:1: ( rule__Technology__Group_4__0__Impl rule__Technology__Group_4__1 )
            // InternalTechnologyDsl.g:1586:2: rule__Technology__Group_4__0__Impl rule__Technology__Group_4__1
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
    // InternalTechnologyDsl.g:1593:1: rule__Technology__Group_4__0__Impl : ( 'types' ) ;
    public final void rule__Technology__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1597:1: ( ( 'types' ) )
            // InternalTechnologyDsl.g:1598:1: ( 'types' )
            {
            // InternalTechnologyDsl.g:1598:1: ( 'types' )
            // InternalTechnologyDsl.g:1599:2: 'types'
            {
             before(grammarAccess.getTechnologyAccess().getTypesKeyword_4_0()); 
            match(input,32,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:1608:1: rule__Technology__Group_4__1 : rule__Technology__Group_4__1__Impl rule__Technology__Group_4__2 ;
    public final void rule__Technology__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1612:1: ( rule__Technology__Group_4__1__Impl rule__Technology__Group_4__2 )
            // InternalTechnologyDsl.g:1613:2: rule__Technology__Group_4__1__Impl rule__Technology__Group_4__2
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
    // InternalTechnologyDsl.g:1620:1: rule__Technology__Group_4__1__Impl : ( '{' ) ;
    public final void rule__Technology__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1624:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:1625:1: ( '{' )
            {
            // InternalTechnologyDsl.g:1625:1: ( '{' )
            // InternalTechnologyDsl.g:1626:2: '{'
            {
             before(grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_4_1()); 
            match(input,30,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:1635:1: rule__Technology__Group_4__2 : rule__Technology__Group_4__2__Impl rule__Technology__Group_4__3 ;
    public final void rule__Technology__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1639:1: ( rule__Technology__Group_4__2__Impl rule__Technology__Group_4__3 )
            // InternalTechnologyDsl.g:1640:2: rule__Technology__Group_4__2__Impl rule__Technology__Group_4__3
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
    // InternalTechnologyDsl.g:1647:1: rule__Technology__Group_4__2__Impl : ( ( ( rule__Technology__Alternatives_4_2 ) ) ( ( rule__Technology__Alternatives_4_2 )* ) ) ;
    public final void rule__Technology__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1651:1: ( ( ( ( rule__Technology__Alternatives_4_2 ) ) ( ( rule__Technology__Alternatives_4_2 )* ) ) )
            // InternalTechnologyDsl.g:1652:1: ( ( ( rule__Technology__Alternatives_4_2 ) ) ( ( rule__Technology__Alternatives_4_2 )* ) )
            {
            // InternalTechnologyDsl.g:1652:1: ( ( ( rule__Technology__Alternatives_4_2 ) ) ( ( rule__Technology__Alternatives_4_2 )* ) )
            // InternalTechnologyDsl.g:1653:2: ( ( rule__Technology__Alternatives_4_2 ) ) ( ( rule__Technology__Alternatives_4_2 )* )
            {
            // InternalTechnologyDsl.g:1653:2: ( ( rule__Technology__Alternatives_4_2 ) )
            // InternalTechnologyDsl.g:1654:3: ( rule__Technology__Alternatives_4_2 )
            {
             before(grammarAccess.getTechnologyAccess().getAlternatives_4_2()); 
            // InternalTechnologyDsl.g:1655:3: ( rule__Technology__Alternatives_4_2 )
            // InternalTechnologyDsl.g:1655:4: rule__Technology__Alternatives_4_2
            {
            pushFollow(FOLLOW_12);
            rule__Technology__Alternatives_4_2();

            state._fsp--;


            }

             after(grammarAccess.getTechnologyAccess().getAlternatives_4_2()); 

            }

            // InternalTechnologyDsl.g:1658:2: ( ( rule__Technology__Alternatives_4_2 )* )
            // InternalTechnologyDsl.g:1659:3: ( rule__Technology__Alternatives_4_2 )*
            {
             before(grammarAccess.getTechnologyAccess().getAlternatives_4_2()); 
            // InternalTechnologyDsl.g:1660:3: ( rule__Technology__Alternatives_4_2 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==49||(LA26_0>=53 && LA26_0<=54)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalTechnologyDsl.g:1660:4: rule__Technology__Alternatives_4_2
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
    // InternalTechnologyDsl.g:1669:1: rule__Technology__Group_4__3 : rule__Technology__Group_4__3__Impl rule__Technology__Group_4__4 ;
    public final void rule__Technology__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1673:1: ( rule__Technology__Group_4__3__Impl rule__Technology__Group_4__4 )
            // InternalTechnologyDsl.g:1674:2: rule__Technology__Group_4__3__Impl rule__Technology__Group_4__4
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
    // InternalTechnologyDsl.g:1681:1: rule__Technology__Group_4__3__Impl : ( ( rule__Technology__Group_4_3__0 )? ) ;
    public final void rule__Technology__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1685:1: ( ( ( rule__Technology__Group_4_3__0 )? ) )
            // InternalTechnologyDsl.g:1686:1: ( ( rule__Technology__Group_4_3__0 )? )
            {
            // InternalTechnologyDsl.g:1686:1: ( ( rule__Technology__Group_4_3__0 )? )
            // InternalTechnologyDsl.g:1687:2: ( rule__Technology__Group_4_3__0 )?
            {
             before(grammarAccess.getTechnologyAccess().getGroup_4_3()); 
            // InternalTechnologyDsl.g:1688:2: ( rule__Technology__Group_4_3__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==33) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalTechnologyDsl.g:1688:3: rule__Technology__Group_4_3__0
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
    // InternalTechnologyDsl.g:1696:1: rule__Technology__Group_4__4 : rule__Technology__Group_4__4__Impl ;
    public final void rule__Technology__Group_4__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1700:1: ( rule__Technology__Group_4__4__Impl )
            // InternalTechnologyDsl.g:1701:2: rule__Technology__Group_4__4__Impl
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
    // InternalTechnologyDsl.g:1707:1: rule__Technology__Group_4__4__Impl : ( '}' ) ;
    public final void rule__Technology__Group_4__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1711:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:1712:1: ( '}' )
            {
            // InternalTechnologyDsl.g:1712:1: ( '}' )
            // InternalTechnologyDsl.g:1713:2: '}'
            {
             before(grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_4_4()); 
            match(input,31,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:1723:1: rule__Technology__Group_4_3__0 : rule__Technology__Group_4_3__0__Impl rule__Technology__Group_4_3__1 ;
    public final void rule__Technology__Group_4_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1727:1: ( rule__Technology__Group_4_3__0__Impl rule__Technology__Group_4_3__1 )
            // InternalTechnologyDsl.g:1728:2: rule__Technology__Group_4_3__0__Impl rule__Technology__Group_4_3__1
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
    // InternalTechnologyDsl.g:1735:1: rule__Technology__Group_4_3__0__Impl : ( 'compatibility' ) ;
    public final void rule__Technology__Group_4_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1739:1: ( ( 'compatibility' ) )
            // InternalTechnologyDsl.g:1740:1: ( 'compatibility' )
            {
            // InternalTechnologyDsl.g:1740:1: ( 'compatibility' )
            // InternalTechnologyDsl.g:1741:2: 'compatibility'
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
    // InternalTechnologyDsl.g:1750:1: rule__Technology__Group_4_3__1 : rule__Technology__Group_4_3__1__Impl rule__Technology__Group_4_3__2 ;
    public final void rule__Technology__Group_4_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1754:1: ( rule__Technology__Group_4_3__1__Impl rule__Technology__Group_4_3__2 )
            // InternalTechnologyDsl.g:1755:2: rule__Technology__Group_4_3__1__Impl rule__Technology__Group_4_3__2
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
    // InternalTechnologyDsl.g:1762:1: rule__Technology__Group_4_3__1__Impl : ( 'matrix' ) ;
    public final void rule__Technology__Group_4_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1766:1: ( ( 'matrix' ) )
            // InternalTechnologyDsl.g:1767:1: ( 'matrix' )
            {
            // InternalTechnologyDsl.g:1767:1: ( 'matrix' )
            // InternalTechnologyDsl.g:1768:2: 'matrix'
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
    // InternalTechnologyDsl.g:1777:1: rule__Technology__Group_4_3__2 : rule__Technology__Group_4_3__2__Impl rule__Technology__Group_4_3__3 ;
    public final void rule__Technology__Group_4_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1781:1: ( rule__Technology__Group_4_3__2__Impl rule__Technology__Group_4_3__3 )
            // InternalTechnologyDsl.g:1782:2: rule__Technology__Group_4_3__2__Impl rule__Technology__Group_4_3__3
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
    // InternalTechnologyDsl.g:1789:1: rule__Technology__Group_4_3__2__Impl : ( '{' ) ;
    public final void rule__Technology__Group_4_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1793:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:1794:1: ( '{' )
            {
            // InternalTechnologyDsl.g:1794:1: ( '{' )
            // InternalTechnologyDsl.g:1795:2: '{'
            {
             before(grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_4_3_2()); 
            match(input,30,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:1804:1: rule__Technology__Group_4_3__3 : rule__Technology__Group_4_3__3__Impl rule__Technology__Group_4_3__4 ;
    public final void rule__Technology__Group_4_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1808:1: ( rule__Technology__Group_4_3__3__Impl rule__Technology__Group_4_3__4 )
            // InternalTechnologyDsl.g:1809:2: rule__Technology__Group_4_3__3__Impl rule__Technology__Group_4_3__4
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
    // InternalTechnologyDsl.g:1816:1: rule__Technology__Group_4_3__3__Impl : ( ( ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 ) ) ( ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 )* ) ) ;
    public final void rule__Technology__Group_4_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1820:1: ( ( ( ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 ) ) ( ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 )* ) ) )
            // InternalTechnologyDsl.g:1821:1: ( ( ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 ) ) ( ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 )* ) )
            {
            // InternalTechnologyDsl.g:1821:1: ( ( ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 ) ) ( ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 )* ) )
            // InternalTechnologyDsl.g:1822:2: ( ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 ) ) ( ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 )* )
            {
            // InternalTechnologyDsl.g:1822:2: ( ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 ) )
            // InternalTechnologyDsl.g:1823:3: ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 )
            {
             before(grammarAccess.getTechnologyAccess().getCompatibilityEntriesAssignment_4_3_3()); 
            // InternalTechnologyDsl.g:1824:3: ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 )
            // InternalTechnologyDsl.g:1824:4: rule__Technology__CompatibilityEntriesAssignment_4_3_3
            {
            pushFollow(FOLLOW_15);
            rule__Technology__CompatibilityEntriesAssignment_4_3_3();

            state._fsp--;


            }

             after(grammarAccess.getTechnologyAccess().getCompatibilityEntriesAssignment_4_3_3()); 

            }

            // InternalTechnologyDsl.g:1827:2: ( ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 )* )
            // InternalTechnologyDsl.g:1828:3: ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 )*
            {
             before(grammarAccess.getTechnologyAccess().getCompatibilityEntriesAssignment_4_3_3()); 
            // InternalTechnologyDsl.g:1829:3: ( rule__Technology__CompatibilityEntriesAssignment_4_3_3 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_ID) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalTechnologyDsl.g:1829:4: rule__Technology__CompatibilityEntriesAssignment_4_3_3
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
    // InternalTechnologyDsl.g:1838:1: rule__Technology__Group_4_3__4 : rule__Technology__Group_4_3__4__Impl ;
    public final void rule__Technology__Group_4_3__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1842:1: ( rule__Technology__Group_4_3__4__Impl )
            // InternalTechnologyDsl.g:1843:2: rule__Technology__Group_4_3__4__Impl
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
    // InternalTechnologyDsl.g:1849:1: rule__Technology__Group_4_3__4__Impl : ( '}' ) ;
    public final void rule__Technology__Group_4_3__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1853:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:1854:1: ( '}' )
            {
            // InternalTechnologyDsl.g:1854:1: ( '}' )
            // InternalTechnologyDsl.g:1855:2: '}'
            {
             before(grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_4_3_4()); 
            match(input,31,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:1865:1: rule__Technology__Group_5__0 : rule__Technology__Group_5__0__Impl rule__Technology__Group_5__1 ;
    public final void rule__Technology__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1869:1: ( rule__Technology__Group_5__0__Impl rule__Technology__Group_5__1 )
            // InternalTechnologyDsl.g:1870:2: rule__Technology__Group_5__0__Impl rule__Technology__Group_5__1
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
    // InternalTechnologyDsl.g:1877:1: rule__Technology__Group_5__0__Impl : ( 'protocols' ) ;
    public final void rule__Technology__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1881:1: ( ( 'protocols' ) )
            // InternalTechnologyDsl.g:1882:1: ( 'protocols' )
            {
            // InternalTechnologyDsl.g:1882:1: ( 'protocols' )
            // InternalTechnologyDsl.g:1883:2: 'protocols'
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
    // InternalTechnologyDsl.g:1892:1: rule__Technology__Group_5__1 : rule__Technology__Group_5__1__Impl rule__Technology__Group_5__2 ;
    public final void rule__Technology__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1896:1: ( rule__Technology__Group_5__1__Impl rule__Technology__Group_5__2 )
            // InternalTechnologyDsl.g:1897:2: rule__Technology__Group_5__1__Impl rule__Technology__Group_5__2
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
    // InternalTechnologyDsl.g:1904:1: rule__Technology__Group_5__1__Impl : ( '{' ) ;
    public final void rule__Technology__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1908:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:1909:1: ( '{' )
            {
            // InternalTechnologyDsl.g:1909:1: ( '{' )
            // InternalTechnologyDsl.g:1910:2: '{'
            {
             before(grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_5_1()); 
            match(input,30,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:1919:1: rule__Technology__Group_5__2 : rule__Technology__Group_5__2__Impl rule__Technology__Group_5__3 ;
    public final void rule__Technology__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1923:1: ( rule__Technology__Group_5__2__Impl rule__Technology__Group_5__3 )
            // InternalTechnologyDsl.g:1924:2: rule__Technology__Group_5__2__Impl rule__Technology__Group_5__3
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
    // InternalTechnologyDsl.g:1931:1: rule__Technology__Group_5__2__Impl : ( ( ( rule__Technology__ProtocolsAssignment_5_2 ) ) ( ( rule__Technology__ProtocolsAssignment_5_2 )* ) ) ;
    public final void rule__Technology__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1935:1: ( ( ( ( rule__Technology__ProtocolsAssignment_5_2 ) ) ( ( rule__Technology__ProtocolsAssignment_5_2 )* ) ) )
            // InternalTechnologyDsl.g:1936:1: ( ( ( rule__Technology__ProtocolsAssignment_5_2 ) ) ( ( rule__Technology__ProtocolsAssignment_5_2 )* ) )
            {
            // InternalTechnologyDsl.g:1936:1: ( ( ( rule__Technology__ProtocolsAssignment_5_2 ) ) ( ( rule__Technology__ProtocolsAssignment_5_2 )* ) )
            // InternalTechnologyDsl.g:1937:2: ( ( rule__Technology__ProtocolsAssignment_5_2 ) ) ( ( rule__Technology__ProtocolsAssignment_5_2 )* )
            {
            // InternalTechnologyDsl.g:1937:2: ( ( rule__Technology__ProtocolsAssignment_5_2 ) )
            // InternalTechnologyDsl.g:1938:3: ( rule__Technology__ProtocolsAssignment_5_2 )
            {
             before(grammarAccess.getTechnologyAccess().getProtocolsAssignment_5_2()); 
            // InternalTechnologyDsl.g:1939:3: ( rule__Technology__ProtocolsAssignment_5_2 )
            // InternalTechnologyDsl.g:1939:4: rule__Technology__ProtocolsAssignment_5_2
            {
            pushFollow(FOLLOW_17);
            rule__Technology__ProtocolsAssignment_5_2();

            state._fsp--;


            }

             after(grammarAccess.getTechnologyAccess().getProtocolsAssignment_5_2()); 

            }

            // InternalTechnologyDsl.g:1942:2: ( ( rule__Technology__ProtocolsAssignment_5_2 )* )
            // InternalTechnologyDsl.g:1943:3: ( rule__Technology__ProtocolsAssignment_5_2 )*
            {
             before(grammarAccess.getTechnologyAccess().getProtocolsAssignment_5_2()); 
            // InternalTechnologyDsl.g:1944:3: ( rule__Technology__ProtocolsAssignment_5_2 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=17 && LA29_0<=18)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalTechnologyDsl.g:1944:4: rule__Technology__ProtocolsAssignment_5_2
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
    // InternalTechnologyDsl.g:1953:1: rule__Technology__Group_5__3 : rule__Technology__Group_5__3__Impl ;
    public final void rule__Technology__Group_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1957:1: ( rule__Technology__Group_5__3__Impl )
            // InternalTechnologyDsl.g:1958:2: rule__Technology__Group_5__3__Impl
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
    // InternalTechnologyDsl.g:1964:1: rule__Technology__Group_5__3__Impl : ( '}' ) ;
    public final void rule__Technology__Group_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1968:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:1969:1: ( '}' )
            {
            // InternalTechnologyDsl.g:1969:1: ( '}' )
            // InternalTechnologyDsl.g:1970:2: '}'
            {
             before(grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_5_3()); 
            match(input,31,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:1980:1: rule__Technology__Group_6__0 : rule__Technology__Group_6__0__Impl rule__Technology__Group_6__1 ;
    public final void rule__Technology__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1984:1: ( rule__Technology__Group_6__0__Impl rule__Technology__Group_6__1 )
            // InternalTechnologyDsl.g:1985:2: rule__Technology__Group_6__0__Impl rule__Technology__Group_6__1
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
    // InternalTechnologyDsl.g:1992:1: rule__Technology__Group_6__0__Impl : ( 'service' ) ;
    public final void rule__Technology__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:1996:1: ( ( 'service' ) )
            // InternalTechnologyDsl.g:1997:1: ( 'service' )
            {
            // InternalTechnologyDsl.g:1997:1: ( 'service' )
            // InternalTechnologyDsl.g:1998:2: 'service'
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
    // InternalTechnologyDsl.g:2007:1: rule__Technology__Group_6__1 : rule__Technology__Group_6__1__Impl rule__Technology__Group_6__2 ;
    public final void rule__Technology__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2011:1: ( rule__Technology__Group_6__1__Impl rule__Technology__Group_6__2 )
            // InternalTechnologyDsl.g:2012:2: rule__Technology__Group_6__1__Impl rule__Technology__Group_6__2
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
    // InternalTechnologyDsl.g:2019:1: rule__Technology__Group_6__1__Impl : ( 'aspects' ) ;
    public final void rule__Technology__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2023:1: ( ( 'aspects' ) )
            // InternalTechnologyDsl.g:2024:1: ( 'aspects' )
            {
            // InternalTechnologyDsl.g:2024:1: ( 'aspects' )
            // InternalTechnologyDsl.g:2025:2: 'aspects'
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
    // InternalTechnologyDsl.g:2034:1: rule__Technology__Group_6__2 : rule__Technology__Group_6__2__Impl rule__Technology__Group_6__3 ;
    public final void rule__Technology__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2038:1: ( rule__Technology__Group_6__2__Impl rule__Technology__Group_6__3 )
            // InternalTechnologyDsl.g:2039:2: rule__Technology__Group_6__2__Impl rule__Technology__Group_6__3
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
    // InternalTechnologyDsl.g:2046:1: rule__Technology__Group_6__2__Impl : ( '{' ) ;
    public final void rule__Technology__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2050:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:2051:1: ( '{' )
            {
            // InternalTechnologyDsl.g:2051:1: ( '{' )
            // InternalTechnologyDsl.g:2052:2: '{'
            {
             before(grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_6_2()); 
            match(input,30,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:2061:1: rule__Technology__Group_6__3 : rule__Technology__Group_6__3__Impl rule__Technology__Group_6__4 ;
    public final void rule__Technology__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2065:1: ( rule__Technology__Group_6__3__Impl rule__Technology__Group_6__4 )
            // InternalTechnologyDsl.g:2066:2: rule__Technology__Group_6__3__Impl rule__Technology__Group_6__4
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
    // InternalTechnologyDsl.g:2073:1: rule__Technology__Group_6__3__Impl : ( ( ( rule__Technology__ServiceAspectsAssignment_6_3 ) ) ( ( rule__Technology__ServiceAspectsAssignment_6_3 )* ) ) ;
    public final void rule__Technology__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2077:1: ( ( ( ( rule__Technology__ServiceAspectsAssignment_6_3 ) ) ( ( rule__Technology__ServiceAspectsAssignment_6_3 )* ) ) )
            // InternalTechnologyDsl.g:2078:1: ( ( ( rule__Technology__ServiceAspectsAssignment_6_3 ) ) ( ( rule__Technology__ServiceAspectsAssignment_6_3 )* ) )
            {
            // InternalTechnologyDsl.g:2078:1: ( ( ( rule__Technology__ServiceAspectsAssignment_6_3 ) ) ( ( rule__Technology__ServiceAspectsAssignment_6_3 )* ) )
            // InternalTechnologyDsl.g:2079:2: ( ( rule__Technology__ServiceAspectsAssignment_6_3 ) ) ( ( rule__Technology__ServiceAspectsAssignment_6_3 )* )
            {
            // InternalTechnologyDsl.g:2079:2: ( ( rule__Technology__ServiceAspectsAssignment_6_3 ) )
            // InternalTechnologyDsl.g:2080:3: ( rule__Technology__ServiceAspectsAssignment_6_3 )
            {
             before(grammarAccess.getTechnologyAccess().getServiceAspectsAssignment_6_3()); 
            // InternalTechnologyDsl.g:2081:3: ( rule__Technology__ServiceAspectsAssignment_6_3 )
            // InternalTechnologyDsl.g:2081:4: rule__Technology__ServiceAspectsAssignment_6_3
            {
            pushFollow(FOLLOW_20);
            rule__Technology__ServiceAspectsAssignment_6_3();

            state._fsp--;


            }

             after(grammarAccess.getTechnologyAccess().getServiceAspectsAssignment_6_3()); 

            }

            // InternalTechnologyDsl.g:2084:2: ( ( rule__Technology__ServiceAspectsAssignment_6_3 )* )
            // InternalTechnologyDsl.g:2085:3: ( rule__Technology__ServiceAspectsAssignment_6_3 )*
            {
             before(grammarAccess.getTechnologyAccess().getServiceAspectsAssignment_6_3()); 
            // InternalTechnologyDsl.g:2086:3: ( rule__Technology__ServiceAspectsAssignment_6_3 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==62) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalTechnologyDsl.g:2086:4: rule__Technology__ServiceAspectsAssignment_6_3
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
    // InternalTechnologyDsl.g:2095:1: rule__Technology__Group_6__4 : rule__Technology__Group_6__4__Impl ;
    public final void rule__Technology__Group_6__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2099:1: ( rule__Technology__Group_6__4__Impl )
            // InternalTechnologyDsl.g:2100:2: rule__Technology__Group_6__4__Impl
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
    // InternalTechnologyDsl.g:2106:1: rule__Technology__Group_6__4__Impl : ( '}' ) ;
    public final void rule__Technology__Group_6__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2110:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:2111:1: ( '}' )
            {
            // InternalTechnologyDsl.g:2111:1: ( '}' )
            // InternalTechnologyDsl.g:2112:2: '}'
            {
             before(grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_6_4()); 
            match(input,31,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:2122:1: rule__Technology__Group_7__0 : rule__Technology__Group_7__0__Impl rule__Technology__Group_7__1 ;
    public final void rule__Technology__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2126:1: ( rule__Technology__Group_7__0__Impl rule__Technology__Group_7__1 )
            // InternalTechnologyDsl.g:2127:2: rule__Technology__Group_7__0__Impl rule__Technology__Group_7__1
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
    // InternalTechnologyDsl.g:2134:1: rule__Technology__Group_7__0__Impl : ( 'deployment' ) ;
    public final void rule__Technology__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2138:1: ( ( 'deployment' ) )
            // InternalTechnologyDsl.g:2139:1: ( 'deployment' )
            {
            // InternalTechnologyDsl.g:2139:1: ( 'deployment' )
            // InternalTechnologyDsl.g:2140:2: 'deployment'
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
    // InternalTechnologyDsl.g:2149:1: rule__Technology__Group_7__1 : rule__Technology__Group_7__1__Impl rule__Technology__Group_7__2 ;
    public final void rule__Technology__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2153:1: ( rule__Technology__Group_7__1__Impl rule__Technology__Group_7__2 )
            // InternalTechnologyDsl.g:2154:2: rule__Technology__Group_7__1__Impl rule__Technology__Group_7__2
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
    // InternalTechnologyDsl.g:2161:1: rule__Technology__Group_7__1__Impl : ( 'technologies' ) ;
    public final void rule__Technology__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2165:1: ( ( 'technologies' ) )
            // InternalTechnologyDsl.g:2166:1: ( 'technologies' )
            {
            // InternalTechnologyDsl.g:2166:1: ( 'technologies' )
            // InternalTechnologyDsl.g:2167:2: 'technologies'
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
    // InternalTechnologyDsl.g:2176:1: rule__Technology__Group_7__2 : rule__Technology__Group_7__2__Impl rule__Technology__Group_7__3 ;
    public final void rule__Technology__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2180:1: ( rule__Technology__Group_7__2__Impl rule__Technology__Group_7__3 )
            // InternalTechnologyDsl.g:2181:2: rule__Technology__Group_7__2__Impl rule__Technology__Group_7__3
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
    // InternalTechnologyDsl.g:2188:1: rule__Technology__Group_7__2__Impl : ( '{' ) ;
    public final void rule__Technology__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2192:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:2193:1: ( '{' )
            {
            // InternalTechnologyDsl.g:2193:1: ( '{' )
            // InternalTechnologyDsl.g:2194:2: '{'
            {
             before(grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_7_2()); 
            match(input,30,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:2203:1: rule__Technology__Group_7__3 : rule__Technology__Group_7__3__Impl rule__Technology__Group_7__4 ;
    public final void rule__Technology__Group_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2207:1: ( rule__Technology__Group_7__3__Impl rule__Technology__Group_7__4 )
            // InternalTechnologyDsl.g:2208:2: rule__Technology__Group_7__3__Impl rule__Technology__Group_7__4
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
    // InternalTechnologyDsl.g:2215:1: rule__Technology__Group_7__3__Impl : ( ( ( rule__Technology__DeploymentTechnologiesAssignment_7_3 ) ) ( ( rule__Technology__DeploymentTechnologiesAssignment_7_3 )* ) ) ;
    public final void rule__Technology__Group_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2219:1: ( ( ( ( rule__Technology__DeploymentTechnologiesAssignment_7_3 ) ) ( ( rule__Technology__DeploymentTechnologiesAssignment_7_3 )* ) ) )
            // InternalTechnologyDsl.g:2220:1: ( ( ( rule__Technology__DeploymentTechnologiesAssignment_7_3 ) ) ( ( rule__Technology__DeploymentTechnologiesAssignment_7_3 )* ) )
            {
            // InternalTechnologyDsl.g:2220:1: ( ( ( rule__Technology__DeploymentTechnologiesAssignment_7_3 ) ) ( ( rule__Technology__DeploymentTechnologiesAssignment_7_3 )* ) )
            // InternalTechnologyDsl.g:2221:2: ( ( rule__Technology__DeploymentTechnologiesAssignment_7_3 ) ) ( ( rule__Technology__DeploymentTechnologiesAssignment_7_3 )* )
            {
            // InternalTechnologyDsl.g:2221:2: ( ( rule__Technology__DeploymentTechnologiesAssignment_7_3 ) )
            // InternalTechnologyDsl.g:2222:3: ( rule__Technology__DeploymentTechnologiesAssignment_7_3 )
            {
             before(grammarAccess.getTechnologyAccess().getDeploymentTechnologiesAssignment_7_3()); 
            // InternalTechnologyDsl.g:2223:3: ( rule__Technology__DeploymentTechnologiesAssignment_7_3 )
            // InternalTechnologyDsl.g:2223:4: rule__Technology__DeploymentTechnologiesAssignment_7_3
            {
            pushFollow(FOLLOW_15);
            rule__Technology__DeploymentTechnologiesAssignment_7_3();

            state._fsp--;


            }

             after(grammarAccess.getTechnologyAccess().getDeploymentTechnologiesAssignment_7_3()); 

            }

            // InternalTechnologyDsl.g:2226:2: ( ( rule__Technology__DeploymentTechnologiesAssignment_7_3 )* )
            // InternalTechnologyDsl.g:2227:3: ( rule__Technology__DeploymentTechnologiesAssignment_7_3 )*
            {
             before(grammarAccess.getTechnologyAccess().getDeploymentTechnologiesAssignment_7_3()); 
            // InternalTechnologyDsl.g:2228:3: ( rule__Technology__DeploymentTechnologiesAssignment_7_3 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_ID) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalTechnologyDsl.g:2228:4: rule__Technology__DeploymentTechnologiesAssignment_7_3
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
    // InternalTechnologyDsl.g:2237:1: rule__Technology__Group_7__4 : rule__Technology__Group_7__4__Impl ;
    public final void rule__Technology__Group_7__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2241:1: ( rule__Technology__Group_7__4__Impl )
            // InternalTechnologyDsl.g:2242:2: rule__Technology__Group_7__4__Impl
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
    // InternalTechnologyDsl.g:2248:1: rule__Technology__Group_7__4__Impl : ( '}' ) ;
    public final void rule__Technology__Group_7__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2252:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:2253:1: ( '}' )
            {
            // InternalTechnologyDsl.g:2253:1: ( '}' )
            // InternalTechnologyDsl.g:2254:2: '}'
            {
             before(grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_7_4()); 
            match(input,31,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:2264:1: rule__Technology__Group_8__0 : rule__Technology__Group_8__0__Impl rule__Technology__Group_8__1 ;
    public final void rule__Technology__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2268:1: ( rule__Technology__Group_8__0__Impl rule__Technology__Group_8__1 )
            // InternalTechnologyDsl.g:2269:2: rule__Technology__Group_8__0__Impl rule__Technology__Group_8__1
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
    // InternalTechnologyDsl.g:2276:1: rule__Technology__Group_8__0__Impl : ( 'infrastructure' ) ;
    public final void rule__Technology__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2280:1: ( ( 'infrastructure' ) )
            // InternalTechnologyDsl.g:2281:1: ( 'infrastructure' )
            {
            // InternalTechnologyDsl.g:2281:1: ( 'infrastructure' )
            // InternalTechnologyDsl.g:2282:2: 'infrastructure'
            {
             before(grammarAccess.getTechnologyAccess().getInfrastructureKeyword_8_0()); 
            match(input,28,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:2291:1: rule__Technology__Group_8__1 : rule__Technology__Group_8__1__Impl rule__Technology__Group_8__2 ;
    public final void rule__Technology__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2295:1: ( rule__Technology__Group_8__1__Impl rule__Technology__Group_8__2 )
            // InternalTechnologyDsl.g:2296:2: rule__Technology__Group_8__1__Impl rule__Technology__Group_8__2
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
    // InternalTechnologyDsl.g:2303:1: rule__Technology__Group_8__1__Impl : ( 'technologies' ) ;
    public final void rule__Technology__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2307:1: ( ( 'technologies' ) )
            // InternalTechnologyDsl.g:2308:1: ( 'technologies' )
            {
            // InternalTechnologyDsl.g:2308:1: ( 'technologies' )
            // InternalTechnologyDsl.g:2309:2: 'technologies'
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
    // InternalTechnologyDsl.g:2318:1: rule__Technology__Group_8__2 : rule__Technology__Group_8__2__Impl rule__Technology__Group_8__3 ;
    public final void rule__Technology__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2322:1: ( rule__Technology__Group_8__2__Impl rule__Technology__Group_8__3 )
            // InternalTechnologyDsl.g:2323:2: rule__Technology__Group_8__2__Impl rule__Technology__Group_8__3
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
    // InternalTechnologyDsl.g:2330:1: rule__Technology__Group_8__2__Impl : ( '{' ) ;
    public final void rule__Technology__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2334:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:2335:1: ( '{' )
            {
            // InternalTechnologyDsl.g:2335:1: ( '{' )
            // InternalTechnologyDsl.g:2336:2: '{'
            {
             before(grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_8_2()); 
            match(input,30,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:2345:1: rule__Technology__Group_8__3 : rule__Technology__Group_8__3__Impl rule__Technology__Group_8__4 ;
    public final void rule__Technology__Group_8__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2349:1: ( rule__Technology__Group_8__3__Impl rule__Technology__Group_8__4 )
            // InternalTechnologyDsl.g:2350:2: rule__Technology__Group_8__3__Impl rule__Technology__Group_8__4
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
    // InternalTechnologyDsl.g:2357:1: rule__Technology__Group_8__3__Impl : ( ( ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 ) ) ( ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 )* ) ) ;
    public final void rule__Technology__Group_8__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2361:1: ( ( ( ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 ) ) ( ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 )* ) ) )
            // InternalTechnologyDsl.g:2362:1: ( ( ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 ) ) ( ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 )* ) )
            {
            // InternalTechnologyDsl.g:2362:1: ( ( ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 ) ) ( ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 )* ) )
            // InternalTechnologyDsl.g:2363:2: ( ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 ) ) ( ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 )* )
            {
            // InternalTechnologyDsl.g:2363:2: ( ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 ) )
            // InternalTechnologyDsl.g:2364:3: ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 )
            {
             before(grammarAccess.getTechnologyAccess().getInfrastructureTechnologiesAssignment_8_3()); 
            // InternalTechnologyDsl.g:2365:3: ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 )
            // InternalTechnologyDsl.g:2365:4: rule__Technology__InfrastructureTechnologiesAssignment_8_3
            {
            pushFollow(FOLLOW_15);
            rule__Technology__InfrastructureTechnologiesAssignment_8_3();

            state._fsp--;


            }

             after(grammarAccess.getTechnologyAccess().getInfrastructureTechnologiesAssignment_8_3()); 

            }

            // InternalTechnologyDsl.g:2368:2: ( ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 )* )
            // InternalTechnologyDsl.g:2369:3: ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 )*
            {
             before(grammarAccess.getTechnologyAccess().getInfrastructureTechnologiesAssignment_8_3()); 
            // InternalTechnologyDsl.g:2370:3: ( rule__Technology__InfrastructureTechnologiesAssignment_8_3 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_ID) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalTechnologyDsl.g:2370:4: rule__Technology__InfrastructureTechnologiesAssignment_8_3
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
    // InternalTechnologyDsl.g:2379:1: rule__Technology__Group_8__4 : rule__Technology__Group_8__4__Impl ;
    public final void rule__Technology__Group_8__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2383:1: ( rule__Technology__Group_8__4__Impl )
            // InternalTechnologyDsl.g:2384:2: rule__Technology__Group_8__4__Impl
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
    // InternalTechnologyDsl.g:2390:1: rule__Technology__Group_8__4__Impl : ( '}' ) ;
    public final void rule__Technology__Group_8__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2394:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:2395:1: ( '}' )
            {
            // InternalTechnologyDsl.g:2395:1: ( '}' )
            // InternalTechnologyDsl.g:2396:2: '}'
            {
             before(grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_8_4()); 
            match(input,31,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:2406:1: rule__Technology__Group_9__0 : rule__Technology__Group_9__0__Impl rule__Technology__Group_9__1 ;
    public final void rule__Technology__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2410:1: ( rule__Technology__Group_9__0__Impl rule__Technology__Group_9__1 )
            // InternalTechnologyDsl.g:2411:2: rule__Technology__Group_9__0__Impl rule__Technology__Group_9__1
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
    // InternalTechnologyDsl.g:2418:1: rule__Technology__Group_9__0__Impl : ( 'operation' ) ;
    public final void rule__Technology__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2422:1: ( ( 'operation' ) )
            // InternalTechnologyDsl.g:2423:1: ( 'operation' )
            {
            // InternalTechnologyDsl.g:2423:1: ( 'operation' )
            // InternalTechnologyDsl.g:2424:2: 'operation'
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
    // InternalTechnologyDsl.g:2433:1: rule__Technology__Group_9__1 : rule__Technology__Group_9__1__Impl rule__Technology__Group_9__2 ;
    public final void rule__Technology__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2437:1: ( rule__Technology__Group_9__1__Impl rule__Technology__Group_9__2 )
            // InternalTechnologyDsl.g:2438:2: rule__Technology__Group_9__1__Impl rule__Technology__Group_9__2
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
    // InternalTechnologyDsl.g:2445:1: rule__Technology__Group_9__1__Impl : ( 'aspects' ) ;
    public final void rule__Technology__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2449:1: ( ( 'aspects' ) )
            // InternalTechnologyDsl.g:2450:1: ( 'aspects' )
            {
            // InternalTechnologyDsl.g:2450:1: ( 'aspects' )
            // InternalTechnologyDsl.g:2451:2: 'aspects'
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
    // InternalTechnologyDsl.g:2460:1: rule__Technology__Group_9__2 : rule__Technology__Group_9__2__Impl rule__Technology__Group_9__3 ;
    public final void rule__Technology__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2464:1: ( rule__Technology__Group_9__2__Impl rule__Technology__Group_9__3 )
            // InternalTechnologyDsl.g:2465:2: rule__Technology__Group_9__2__Impl rule__Technology__Group_9__3
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
    // InternalTechnologyDsl.g:2472:1: rule__Technology__Group_9__2__Impl : ( '{' ) ;
    public final void rule__Technology__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2476:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:2477:1: ( '{' )
            {
            // InternalTechnologyDsl.g:2477:1: ( '{' )
            // InternalTechnologyDsl.g:2478:2: '{'
            {
             before(grammarAccess.getTechnologyAccess().getLeftCurlyBracketKeyword_9_2()); 
            match(input,30,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:2487:1: rule__Technology__Group_9__3 : rule__Technology__Group_9__3__Impl rule__Technology__Group_9__4 ;
    public final void rule__Technology__Group_9__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2491:1: ( rule__Technology__Group_9__3__Impl rule__Technology__Group_9__4 )
            // InternalTechnologyDsl.g:2492:2: rule__Technology__Group_9__3__Impl rule__Technology__Group_9__4
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
    // InternalTechnologyDsl.g:2499:1: rule__Technology__Group_9__3__Impl : ( ( ( rule__Technology__OperationAspectsAssignment_9_3 ) ) ( ( rule__Technology__OperationAspectsAssignment_9_3 )* ) ) ;
    public final void rule__Technology__Group_9__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2503:1: ( ( ( ( rule__Technology__OperationAspectsAssignment_9_3 ) ) ( ( rule__Technology__OperationAspectsAssignment_9_3 )* ) ) )
            // InternalTechnologyDsl.g:2504:1: ( ( ( rule__Technology__OperationAspectsAssignment_9_3 ) ) ( ( rule__Technology__OperationAspectsAssignment_9_3 )* ) )
            {
            // InternalTechnologyDsl.g:2504:1: ( ( ( rule__Technology__OperationAspectsAssignment_9_3 ) ) ( ( rule__Technology__OperationAspectsAssignment_9_3 )* ) )
            // InternalTechnologyDsl.g:2505:2: ( ( rule__Technology__OperationAspectsAssignment_9_3 ) ) ( ( rule__Technology__OperationAspectsAssignment_9_3 )* )
            {
            // InternalTechnologyDsl.g:2505:2: ( ( rule__Technology__OperationAspectsAssignment_9_3 ) )
            // InternalTechnologyDsl.g:2506:3: ( rule__Technology__OperationAspectsAssignment_9_3 )
            {
             before(grammarAccess.getTechnologyAccess().getOperationAspectsAssignment_9_3()); 
            // InternalTechnologyDsl.g:2507:3: ( rule__Technology__OperationAspectsAssignment_9_3 )
            // InternalTechnologyDsl.g:2507:4: rule__Technology__OperationAspectsAssignment_9_3
            {
            pushFollow(FOLLOW_20);
            rule__Technology__OperationAspectsAssignment_9_3();

            state._fsp--;


            }

             after(grammarAccess.getTechnologyAccess().getOperationAspectsAssignment_9_3()); 

            }

            // InternalTechnologyDsl.g:2510:2: ( ( rule__Technology__OperationAspectsAssignment_9_3 )* )
            // InternalTechnologyDsl.g:2511:3: ( rule__Technology__OperationAspectsAssignment_9_3 )*
            {
             before(grammarAccess.getTechnologyAccess().getOperationAspectsAssignment_9_3()); 
            // InternalTechnologyDsl.g:2512:3: ( rule__Technology__OperationAspectsAssignment_9_3 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==62) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalTechnologyDsl.g:2512:4: rule__Technology__OperationAspectsAssignment_9_3
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
    // InternalTechnologyDsl.g:2521:1: rule__Technology__Group_9__4 : rule__Technology__Group_9__4__Impl ;
    public final void rule__Technology__Group_9__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2525:1: ( rule__Technology__Group_9__4__Impl )
            // InternalTechnologyDsl.g:2526:2: rule__Technology__Group_9__4__Impl
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
    // InternalTechnologyDsl.g:2532:1: rule__Technology__Group_9__4__Impl : ( '}' ) ;
    public final void rule__Technology__Group_9__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2536:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:2537:1: ( '}' )
            {
            // InternalTechnologyDsl.g:2537:1: ( '}' )
            // InternalTechnologyDsl.g:2538:2: '}'
            {
             before(grammarAccess.getTechnologyAccess().getRightCurlyBracketKeyword_9_4()); 
            match(input,31,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:2548:1: rule__TechnologyImport__Group__0 : rule__TechnologyImport__Group__0__Impl rule__TechnologyImport__Group__1 ;
    public final void rule__TechnologyImport__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2552:1: ( rule__TechnologyImport__Group__0__Impl rule__TechnologyImport__Group__1 )
            // InternalTechnologyDsl.g:2553:2: rule__TechnologyImport__Group__0__Impl rule__TechnologyImport__Group__1
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
    // InternalTechnologyDsl.g:2560:1: rule__TechnologyImport__Group__0__Impl : ( 'import' ) ;
    public final void rule__TechnologyImport__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2564:1: ( ( 'import' ) )
            // InternalTechnologyDsl.g:2565:1: ( 'import' )
            {
            // InternalTechnologyDsl.g:2565:1: ( 'import' )
            // InternalTechnologyDsl.g:2566:2: 'import'
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
    // InternalTechnologyDsl.g:2575:1: rule__TechnologyImport__Group__1 : rule__TechnologyImport__Group__1__Impl rule__TechnologyImport__Group__2 ;
    public final void rule__TechnologyImport__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2579:1: ( rule__TechnologyImport__Group__1__Impl rule__TechnologyImport__Group__2 )
            // InternalTechnologyDsl.g:2580:2: rule__TechnologyImport__Group__1__Impl rule__TechnologyImport__Group__2
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
    // InternalTechnologyDsl.g:2587:1: rule__TechnologyImport__Group__1__Impl : ( 'technology' ) ;
    public final void rule__TechnologyImport__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2591:1: ( ( 'technology' ) )
            // InternalTechnologyDsl.g:2592:1: ( 'technology' )
            {
            // InternalTechnologyDsl.g:2592:1: ( 'technology' )
            // InternalTechnologyDsl.g:2593:2: 'technology'
            {
             before(grammarAccess.getTechnologyImportAccess().getTechnologyKeyword_1()); 
            match(input,29,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:2602:1: rule__TechnologyImport__Group__2 : rule__TechnologyImport__Group__2__Impl rule__TechnologyImport__Group__3 ;
    public final void rule__TechnologyImport__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2606:1: ( rule__TechnologyImport__Group__2__Impl rule__TechnologyImport__Group__3 )
            // InternalTechnologyDsl.g:2607:2: rule__TechnologyImport__Group__2__Impl rule__TechnologyImport__Group__3
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
    // InternalTechnologyDsl.g:2614:1: rule__TechnologyImport__Group__2__Impl : ( 'from' ) ;
    public final void rule__TechnologyImport__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2618:1: ( ( 'from' ) )
            // InternalTechnologyDsl.g:2619:1: ( 'from' )
            {
            // InternalTechnologyDsl.g:2619:1: ( 'from' )
            // InternalTechnologyDsl.g:2620:2: 'from'
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
    // InternalTechnologyDsl.g:2629:1: rule__TechnologyImport__Group__3 : rule__TechnologyImport__Group__3__Impl rule__TechnologyImport__Group__4 ;
    public final void rule__TechnologyImport__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2633:1: ( rule__TechnologyImport__Group__3__Impl rule__TechnologyImport__Group__4 )
            // InternalTechnologyDsl.g:2634:2: rule__TechnologyImport__Group__3__Impl rule__TechnologyImport__Group__4
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
    // InternalTechnologyDsl.g:2641:1: rule__TechnologyImport__Group__3__Impl : ( ( rule__TechnologyImport__ImportURIAssignment_3 ) ) ;
    public final void rule__TechnologyImport__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2645:1: ( ( ( rule__TechnologyImport__ImportURIAssignment_3 ) ) )
            // InternalTechnologyDsl.g:2646:1: ( ( rule__TechnologyImport__ImportURIAssignment_3 ) )
            {
            // InternalTechnologyDsl.g:2646:1: ( ( rule__TechnologyImport__ImportURIAssignment_3 ) )
            // InternalTechnologyDsl.g:2647:2: ( rule__TechnologyImport__ImportURIAssignment_3 )
            {
             before(grammarAccess.getTechnologyImportAccess().getImportURIAssignment_3()); 
            // InternalTechnologyDsl.g:2648:2: ( rule__TechnologyImport__ImportURIAssignment_3 )
            // InternalTechnologyDsl.g:2648:3: rule__TechnologyImport__ImportURIAssignment_3
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
    // InternalTechnologyDsl.g:2656:1: rule__TechnologyImport__Group__4 : rule__TechnologyImport__Group__4__Impl rule__TechnologyImport__Group__5 ;
    public final void rule__TechnologyImport__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2660:1: ( rule__TechnologyImport__Group__4__Impl rule__TechnologyImport__Group__5 )
            // InternalTechnologyDsl.g:2661:2: rule__TechnologyImport__Group__4__Impl rule__TechnologyImport__Group__5
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
    // InternalTechnologyDsl.g:2668:1: rule__TechnologyImport__Group__4__Impl : ( 'as' ) ;
    public final void rule__TechnologyImport__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2672:1: ( ( 'as' ) )
            // InternalTechnologyDsl.g:2673:1: ( 'as' )
            {
            // InternalTechnologyDsl.g:2673:1: ( 'as' )
            // InternalTechnologyDsl.g:2674:2: 'as'
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
    // InternalTechnologyDsl.g:2683:1: rule__TechnologyImport__Group__5 : rule__TechnologyImport__Group__5__Impl ;
    public final void rule__TechnologyImport__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2687:1: ( rule__TechnologyImport__Group__5__Impl )
            // InternalTechnologyDsl.g:2688:2: rule__TechnologyImport__Group__5__Impl
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
    // InternalTechnologyDsl.g:2694:1: rule__TechnologyImport__Group__5__Impl : ( ( rule__TechnologyImport__NameAssignment_5 ) ) ;
    public final void rule__TechnologyImport__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2698:1: ( ( ( rule__TechnologyImport__NameAssignment_5 ) ) )
            // InternalTechnologyDsl.g:2699:1: ( ( rule__TechnologyImport__NameAssignment_5 ) )
            {
            // InternalTechnologyDsl.g:2699:1: ( ( rule__TechnologyImport__NameAssignment_5 ) )
            // InternalTechnologyDsl.g:2700:2: ( rule__TechnologyImport__NameAssignment_5 )
            {
             before(grammarAccess.getTechnologyImportAccess().getNameAssignment_5()); 
            // InternalTechnologyDsl.g:2701:2: ( rule__TechnologyImport__NameAssignment_5 )
            // InternalTechnologyDsl.g:2701:3: rule__TechnologyImport__NameAssignment_5
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
    // InternalTechnologyDsl.g:2710:1: rule__Protocol__Group__0 : rule__Protocol__Group__0__Impl rule__Protocol__Group__1 ;
    public final void rule__Protocol__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2714:1: ( rule__Protocol__Group__0__Impl rule__Protocol__Group__1 )
            // InternalTechnologyDsl.g:2715:2: rule__Protocol__Group__0__Impl rule__Protocol__Group__1
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
    // InternalTechnologyDsl.g:2722:1: rule__Protocol__Group__0__Impl : ( ( rule__Protocol__CommunicationTypeAssignment_0 ) ) ;
    public final void rule__Protocol__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2726:1: ( ( ( rule__Protocol__CommunicationTypeAssignment_0 ) ) )
            // InternalTechnologyDsl.g:2727:1: ( ( rule__Protocol__CommunicationTypeAssignment_0 ) )
            {
            // InternalTechnologyDsl.g:2727:1: ( ( rule__Protocol__CommunicationTypeAssignment_0 ) )
            // InternalTechnologyDsl.g:2728:2: ( rule__Protocol__CommunicationTypeAssignment_0 )
            {
             before(grammarAccess.getProtocolAccess().getCommunicationTypeAssignment_0()); 
            // InternalTechnologyDsl.g:2729:2: ( rule__Protocol__CommunicationTypeAssignment_0 )
            // InternalTechnologyDsl.g:2729:3: rule__Protocol__CommunicationTypeAssignment_0
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
    // InternalTechnologyDsl.g:2737:1: rule__Protocol__Group__1 : rule__Protocol__Group__1__Impl rule__Protocol__Group__2 ;
    public final void rule__Protocol__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2741:1: ( rule__Protocol__Group__1__Impl rule__Protocol__Group__2 )
            // InternalTechnologyDsl.g:2742:2: rule__Protocol__Group__1__Impl rule__Protocol__Group__2
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
    // InternalTechnologyDsl.g:2749:1: rule__Protocol__Group__1__Impl : ( ( rule__Protocol__NameAssignment_1 ) ) ;
    public final void rule__Protocol__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2753:1: ( ( ( rule__Protocol__NameAssignment_1 ) ) )
            // InternalTechnologyDsl.g:2754:1: ( ( rule__Protocol__NameAssignment_1 ) )
            {
            // InternalTechnologyDsl.g:2754:1: ( ( rule__Protocol__NameAssignment_1 ) )
            // InternalTechnologyDsl.g:2755:2: ( rule__Protocol__NameAssignment_1 )
            {
             before(grammarAccess.getProtocolAccess().getNameAssignment_1()); 
            // InternalTechnologyDsl.g:2756:2: ( rule__Protocol__NameAssignment_1 )
            // InternalTechnologyDsl.g:2756:3: rule__Protocol__NameAssignment_1
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
    // InternalTechnologyDsl.g:2764:1: rule__Protocol__Group__2 : rule__Protocol__Group__2__Impl rule__Protocol__Group__3 ;
    public final void rule__Protocol__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2768:1: ( rule__Protocol__Group__2__Impl rule__Protocol__Group__3 )
            // InternalTechnologyDsl.g:2769:2: rule__Protocol__Group__2__Impl rule__Protocol__Group__3
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
    // InternalTechnologyDsl.g:2776:1: rule__Protocol__Group__2__Impl : ( 'data' ) ;
    public final void rule__Protocol__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2780:1: ( ( 'data' ) )
            // InternalTechnologyDsl.g:2781:1: ( 'data' )
            {
            // InternalTechnologyDsl.g:2781:1: ( 'data' )
            // InternalTechnologyDsl.g:2782:2: 'data'
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
    // InternalTechnologyDsl.g:2791:1: rule__Protocol__Group__3 : rule__Protocol__Group__3__Impl rule__Protocol__Group__4 ;
    public final void rule__Protocol__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2795:1: ( rule__Protocol__Group__3__Impl rule__Protocol__Group__4 )
            // InternalTechnologyDsl.g:2796:2: rule__Protocol__Group__3__Impl rule__Protocol__Group__4
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
    // InternalTechnologyDsl.g:2803:1: rule__Protocol__Group__3__Impl : ( 'formats' ) ;
    public final void rule__Protocol__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2807:1: ( ( 'formats' ) )
            // InternalTechnologyDsl.g:2808:1: ( 'formats' )
            {
            // InternalTechnologyDsl.g:2808:1: ( 'formats' )
            // InternalTechnologyDsl.g:2809:2: 'formats'
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
    // InternalTechnologyDsl.g:2818:1: rule__Protocol__Group__4 : rule__Protocol__Group__4__Impl rule__Protocol__Group__5 ;
    public final void rule__Protocol__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2822:1: ( rule__Protocol__Group__4__Impl rule__Protocol__Group__5 )
            // InternalTechnologyDsl.g:2823:2: rule__Protocol__Group__4__Impl rule__Protocol__Group__5
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
    // InternalTechnologyDsl.g:2830:1: rule__Protocol__Group__4__Impl : ( ( rule__Protocol__DataFormatsAssignment_4 ) ) ;
    public final void rule__Protocol__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2834:1: ( ( ( rule__Protocol__DataFormatsAssignment_4 ) ) )
            // InternalTechnologyDsl.g:2835:1: ( ( rule__Protocol__DataFormatsAssignment_4 ) )
            {
            // InternalTechnologyDsl.g:2835:1: ( ( rule__Protocol__DataFormatsAssignment_4 ) )
            // InternalTechnologyDsl.g:2836:2: ( rule__Protocol__DataFormatsAssignment_4 )
            {
             before(grammarAccess.getProtocolAccess().getDataFormatsAssignment_4()); 
            // InternalTechnologyDsl.g:2837:2: ( rule__Protocol__DataFormatsAssignment_4 )
            // InternalTechnologyDsl.g:2837:3: rule__Protocol__DataFormatsAssignment_4
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
    // InternalTechnologyDsl.g:2845:1: rule__Protocol__Group__5 : rule__Protocol__Group__5__Impl rule__Protocol__Group__6 ;
    public final void rule__Protocol__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2849:1: ( rule__Protocol__Group__5__Impl rule__Protocol__Group__6 )
            // InternalTechnologyDsl.g:2850:2: rule__Protocol__Group__5__Impl rule__Protocol__Group__6
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
    // InternalTechnologyDsl.g:2857:1: rule__Protocol__Group__5__Impl : ( ( rule__Protocol__Group_5__0 )* ) ;
    public final void rule__Protocol__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2861:1: ( ( ( rule__Protocol__Group_5__0 )* ) )
            // InternalTechnologyDsl.g:2862:1: ( ( rule__Protocol__Group_5__0 )* )
            {
            // InternalTechnologyDsl.g:2862:1: ( ( rule__Protocol__Group_5__0 )* )
            // InternalTechnologyDsl.g:2863:2: ( rule__Protocol__Group_5__0 )*
            {
             before(grammarAccess.getProtocolAccess().getGroup_5()); 
            // InternalTechnologyDsl.g:2864:2: ( rule__Protocol__Group_5__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==46) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalTechnologyDsl.g:2864:3: rule__Protocol__Group_5__0
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
    // InternalTechnologyDsl.g:2872:1: rule__Protocol__Group__6 : rule__Protocol__Group__6__Impl rule__Protocol__Group__7 ;
    public final void rule__Protocol__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2876:1: ( rule__Protocol__Group__6__Impl rule__Protocol__Group__7 )
            // InternalTechnologyDsl.g:2877:2: rule__Protocol__Group__6__Impl rule__Protocol__Group__7
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
    // InternalTechnologyDsl.g:2884:1: rule__Protocol__Group__6__Impl : ( ( rule__Protocol__Group_6__0 )? ) ;
    public final void rule__Protocol__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2888:1: ( ( ( rule__Protocol__Group_6__0 )? ) )
            // InternalTechnologyDsl.g:2889:1: ( ( rule__Protocol__Group_6__0 )? )
            {
            // InternalTechnologyDsl.g:2889:1: ( ( rule__Protocol__Group_6__0 )? )
            // InternalTechnologyDsl.g:2890:2: ( rule__Protocol__Group_6__0 )?
            {
             before(grammarAccess.getProtocolAccess().getGroup_6()); 
            // InternalTechnologyDsl.g:2891:2: ( rule__Protocol__Group_6__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==79) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalTechnologyDsl.g:2891:3: rule__Protocol__Group_6__0
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
    // InternalTechnologyDsl.g:2899:1: rule__Protocol__Group__7 : rule__Protocol__Group__7__Impl ;
    public final void rule__Protocol__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2903:1: ( rule__Protocol__Group__7__Impl )
            // InternalTechnologyDsl.g:2904:2: rule__Protocol__Group__7__Impl
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
    // InternalTechnologyDsl.g:2910:1: rule__Protocol__Group__7__Impl : ( ';' ) ;
    public final void rule__Protocol__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2914:1: ( ( ';' ) )
            // InternalTechnologyDsl.g:2915:1: ( ';' )
            {
            // InternalTechnologyDsl.g:2915:1: ( ';' )
            // InternalTechnologyDsl.g:2916:2: ';'
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
    // InternalTechnologyDsl.g:2926:1: rule__Protocol__Group_5__0 : rule__Protocol__Group_5__0__Impl rule__Protocol__Group_5__1 ;
    public final void rule__Protocol__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2930:1: ( rule__Protocol__Group_5__0__Impl rule__Protocol__Group_5__1 )
            // InternalTechnologyDsl.g:2931:2: rule__Protocol__Group_5__0__Impl rule__Protocol__Group_5__1
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
    // InternalTechnologyDsl.g:2938:1: rule__Protocol__Group_5__0__Impl : ( ',' ) ;
    public final void rule__Protocol__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2942:1: ( ( ',' ) )
            // InternalTechnologyDsl.g:2943:1: ( ',' )
            {
            // InternalTechnologyDsl.g:2943:1: ( ',' )
            // InternalTechnologyDsl.g:2944:2: ','
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
    // InternalTechnologyDsl.g:2953:1: rule__Protocol__Group_5__1 : rule__Protocol__Group_5__1__Impl ;
    public final void rule__Protocol__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2957:1: ( rule__Protocol__Group_5__1__Impl )
            // InternalTechnologyDsl.g:2958:2: rule__Protocol__Group_5__1__Impl
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
    // InternalTechnologyDsl.g:2964:1: rule__Protocol__Group_5__1__Impl : ( ( rule__Protocol__DataFormatsAssignment_5_1 ) ) ;
    public final void rule__Protocol__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2968:1: ( ( ( rule__Protocol__DataFormatsAssignment_5_1 ) ) )
            // InternalTechnologyDsl.g:2969:1: ( ( rule__Protocol__DataFormatsAssignment_5_1 ) )
            {
            // InternalTechnologyDsl.g:2969:1: ( ( rule__Protocol__DataFormatsAssignment_5_1 ) )
            // InternalTechnologyDsl.g:2970:2: ( rule__Protocol__DataFormatsAssignment_5_1 )
            {
             before(grammarAccess.getProtocolAccess().getDataFormatsAssignment_5_1()); 
            // InternalTechnologyDsl.g:2971:2: ( rule__Protocol__DataFormatsAssignment_5_1 )
            // InternalTechnologyDsl.g:2971:3: rule__Protocol__DataFormatsAssignment_5_1
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
    // InternalTechnologyDsl.g:2980:1: rule__Protocol__Group_6__0 : rule__Protocol__Group_6__0__Impl rule__Protocol__Group_6__1 ;
    public final void rule__Protocol__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2984:1: ( rule__Protocol__Group_6__0__Impl rule__Protocol__Group_6__1 )
            // InternalTechnologyDsl.g:2985:2: rule__Protocol__Group_6__0__Impl rule__Protocol__Group_6__1
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
    // InternalTechnologyDsl.g:2992:1: rule__Protocol__Group_6__0__Impl : ( ( rule__Protocol__DefaultAssignment_6_0 ) ) ;
    public final void rule__Protocol__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:2996:1: ( ( ( rule__Protocol__DefaultAssignment_6_0 ) ) )
            // InternalTechnologyDsl.g:2997:1: ( ( rule__Protocol__DefaultAssignment_6_0 ) )
            {
            // InternalTechnologyDsl.g:2997:1: ( ( rule__Protocol__DefaultAssignment_6_0 ) )
            // InternalTechnologyDsl.g:2998:2: ( rule__Protocol__DefaultAssignment_6_0 )
            {
             before(grammarAccess.getProtocolAccess().getDefaultAssignment_6_0()); 
            // InternalTechnologyDsl.g:2999:2: ( rule__Protocol__DefaultAssignment_6_0 )
            // InternalTechnologyDsl.g:2999:3: rule__Protocol__DefaultAssignment_6_0
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
    // InternalTechnologyDsl.g:3007:1: rule__Protocol__Group_6__1 : rule__Protocol__Group_6__1__Impl rule__Protocol__Group_6__2 ;
    public final void rule__Protocol__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3011:1: ( rule__Protocol__Group_6__1__Impl rule__Protocol__Group_6__2 )
            // InternalTechnologyDsl.g:3012:2: rule__Protocol__Group_6__1__Impl rule__Protocol__Group_6__2
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
    // InternalTechnologyDsl.g:3019:1: rule__Protocol__Group_6__1__Impl : ( 'with' ) ;
    public final void rule__Protocol__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3023:1: ( ( 'with' ) )
            // InternalTechnologyDsl.g:3024:1: ( 'with' )
            {
            // InternalTechnologyDsl.g:3024:1: ( 'with' )
            // InternalTechnologyDsl.g:3025:2: 'with'
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
    // InternalTechnologyDsl.g:3034:1: rule__Protocol__Group_6__2 : rule__Protocol__Group_6__2__Impl rule__Protocol__Group_6__3 ;
    public final void rule__Protocol__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3038:1: ( rule__Protocol__Group_6__2__Impl rule__Protocol__Group_6__3 )
            // InternalTechnologyDsl.g:3039:2: rule__Protocol__Group_6__2__Impl rule__Protocol__Group_6__3
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
    // InternalTechnologyDsl.g:3046:1: rule__Protocol__Group_6__2__Impl : ( 'format' ) ;
    public final void rule__Protocol__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3050:1: ( ( 'format' ) )
            // InternalTechnologyDsl.g:3051:1: ( 'format' )
            {
            // InternalTechnologyDsl.g:3051:1: ( 'format' )
            // InternalTechnologyDsl.g:3052:2: 'format'
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
    // InternalTechnologyDsl.g:3061:1: rule__Protocol__Group_6__3 : rule__Protocol__Group_6__3__Impl ;
    public final void rule__Protocol__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3065:1: ( rule__Protocol__Group_6__3__Impl )
            // InternalTechnologyDsl.g:3066:2: rule__Protocol__Group_6__3__Impl
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
    // InternalTechnologyDsl.g:3072:1: rule__Protocol__Group_6__3__Impl : ( ( rule__Protocol__DefaultFormatAssignment_6_3 ) ) ;
    public final void rule__Protocol__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3076:1: ( ( ( rule__Protocol__DefaultFormatAssignment_6_3 ) ) )
            // InternalTechnologyDsl.g:3077:1: ( ( rule__Protocol__DefaultFormatAssignment_6_3 ) )
            {
            // InternalTechnologyDsl.g:3077:1: ( ( rule__Protocol__DefaultFormatAssignment_6_3 ) )
            // InternalTechnologyDsl.g:3078:2: ( rule__Protocol__DefaultFormatAssignment_6_3 )
            {
             before(grammarAccess.getProtocolAccess().getDefaultFormatAssignment_6_3()); 
            // InternalTechnologyDsl.g:3079:2: ( rule__Protocol__DefaultFormatAssignment_6_3 )
            // InternalTechnologyDsl.g:3079:3: rule__Protocol__DefaultFormatAssignment_6_3
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
    // InternalTechnologyDsl.g:3088:1: rule__TechnologySpecificPrimitiveType__Group__0 : rule__TechnologySpecificPrimitiveType__Group__0__Impl rule__TechnologySpecificPrimitiveType__Group__1 ;
    public final void rule__TechnologySpecificPrimitiveType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3092:1: ( rule__TechnologySpecificPrimitiveType__Group__0__Impl rule__TechnologySpecificPrimitiveType__Group__1 )
            // InternalTechnologyDsl.g:3093:2: rule__TechnologySpecificPrimitiveType__Group__0__Impl rule__TechnologySpecificPrimitiveType__Group__1
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
    // InternalTechnologyDsl.g:3100:1: rule__TechnologySpecificPrimitiveType__Group__0__Impl : ( 'primitive' ) ;
    public final void rule__TechnologySpecificPrimitiveType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3104:1: ( ( 'primitive' ) )
            // InternalTechnologyDsl.g:3105:1: ( 'primitive' )
            {
            // InternalTechnologyDsl.g:3105:1: ( 'primitive' )
            // InternalTechnologyDsl.g:3106:2: 'primitive'
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
    // InternalTechnologyDsl.g:3115:1: rule__TechnologySpecificPrimitiveType__Group__1 : rule__TechnologySpecificPrimitiveType__Group__1__Impl rule__TechnologySpecificPrimitiveType__Group__2 ;
    public final void rule__TechnologySpecificPrimitiveType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3119:1: ( rule__TechnologySpecificPrimitiveType__Group__1__Impl rule__TechnologySpecificPrimitiveType__Group__2 )
            // InternalTechnologyDsl.g:3120:2: rule__TechnologySpecificPrimitiveType__Group__1__Impl rule__TechnologySpecificPrimitiveType__Group__2
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
    // InternalTechnologyDsl.g:3127:1: rule__TechnologySpecificPrimitiveType__Group__1__Impl : ( 'type' ) ;
    public final void rule__TechnologySpecificPrimitiveType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3131:1: ( ( 'type' ) )
            // InternalTechnologyDsl.g:3132:1: ( 'type' )
            {
            // InternalTechnologyDsl.g:3132:1: ( 'type' )
            // InternalTechnologyDsl.g:3133:2: 'type'
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
    // InternalTechnologyDsl.g:3142:1: rule__TechnologySpecificPrimitiveType__Group__2 : rule__TechnologySpecificPrimitiveType__Group__2__Impl rule__TechnologySpecificPrimitiveType__Group__3 ;
    public final void rule__TechnologySpecificPrimitiveType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3146:1: ( rule__TechnologySpecificPrimitiveType__Group__2__Impl rule__TechnologySpecificPrimitiveType__Group__3 )
            // InternalTechnologyDsl.g:3147:2: rule__TechnologySpecificPrimitiveType__Group__2__Impl rule__TechnologySpecificPrimitiveType__Group__3
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
    // InternalTechnologyDsl.g:3154:1: rule__TechnologySpecificPrimitiveType__Group__2__Impl : ( ( rule__TechnologySpecificPrimitiveType__NameAssignment_2 ) ) ;
    public final void rule__TechnologySpecificPrimitiveType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3158:1: ( ( ( rule__TechnologySpecificPrimitiveType__NameAssignment_2 ) ) )
            // InternalTechnologyDsl.g:3159:1: ( ( rule__TechnologySpecificPrimitiveType__NameAssignment_2 ) )
            {
            // InternalTechnologyDsl.g:3159:1: ( ( rule__TechnologySpecificPrimitiveType__NameAssignment_2 ) )
            // InternalTechnologyDsl.g:3160:2: ( rule__TechnologySpecificPrimitiveType__NameAssignment_2 )
            {
             before(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getNameAssignment_2()); 
            // InternalTechnologyDsl.g:3161:2: ( rule__TechnologySpecificPrimitiveType__NameAssignment_2 )
            // InternalTechnologyDsl.g:3161:3: rule__TechnologySpecificPrimitiveType__NameAssignment_2
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
    // InternalTechnologyDsl.g:3169:1: rule__TechnologySpecificPrimitiveType__Group__3 : rule__TechnologySpecificPrimitiveType__Group__3__Impl rule__TechnologySpecificPrimitiveType__Group__4 ;
    public final void rule__TechnologySpecificPrimitiveType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3173:1: ( rule__TechnologySpecificPrimitiveType__Group__3__Impl rule__TechnologySpecificPrimitiveType__Group__4 )
            // InternalTechnologyDsl.g:3174:2: rule__TechnologySpecificPrimitiveType__Group__3__Impl rule__TechnologySpecificPrimitiveType__Group__4
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
    // InternalTechnologyDsl.g:3181:1: rule__TechnologySpecificPrimitiveType__Group__3__Impl : ( ( rule__TechnologySpecificPrimitiveType__Group_3__0 )? ) ;
    public final void rule__TechnologySpecificPrimitiveType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3185:1: ( ( ( rule__TechnologySpecificPrimitiveType__Group_3__0 )? ) )
            // InternalTechnologyDsl.g:3186:1: ( ( rule__TechnologySpecificPrimitiveType__Group_3__0 )? )
            {
            // InternalTechnologyDsl.g:3186:1: ( ( rule__TechnologySpecificPrimitiveType__Group_3__0 )? )
            // InternalTechnologyDsl.g:3187:2: ( rule__TechnologySpecificPrimitiveType__Group_3__0 )?
            {
             before(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getGroup_3()); 
            // InternalTechnologyDsl.g:3188:2: ( rule__TechnologySpecificPrimitiveType__Group_3__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==51) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalTechnologyDsl.g:3188:3: rule__TechnologySpecificPrimitiveType__Group_3__0
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
    // InternalTechnologyDsl.g:3196:1: rule__TechnologySpecificPrimitiveType__Group__4 : rule__TechnologySpecificPrimitiveType__Group__4__Impl ;
    public final void rule__TechnologySpecificPrimitiveType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3200:1: ( rule__TechnologySpecificPrimitiveType__Group__4__Impl )
            // InternalTechnologyDsl.g:3201:2: rule__TechnologySpecificPrimitiveType__Group__4__Impl
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
    // InternalTechnologyDsl.g:3207:1: rule__TechnologySpecificPrimitiveType__Group__4__Impl : ( ';' ) ;
    public final void rule__TechnologySpecificPrimitiveType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3211:1: ( ( ';' ) )
            // InternalTechnologyDsl.g:3212:1: ( ';' )
            {
            // InternalTechnologyDsl.g:3212:1: ( ';' )
            // InternalTechnologyDsl.g:3213:2: ';'
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
    // InternalTechnologyDsl.g:3223:1: rule__TechnologySpecificPrimitiveType__Group_3__0 : rule__TechnologySpecificPrimitiveType__Group_3__0__Impl rule__TechnologySpecificPrimitiveType__Group_3__1 ;
    public final void rule__TechnologySpecificPrimitiveType__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3227:1: ( rule__TechnologySpecificPrimitiveType__Group_3__0__Impl rule__TechnologySpecificPrimitiveType__Group_3__1 )
            // InternalTechnologyDsl.g:3228:2: rule__TechnologySpecificPrimitiveType__Group_3__0__Impl rule__TechnologySpecificPrimitiveType__Group_3__1
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
    // InternalTechnologyDsl.g:3235:1: rule__TechnologySpecificPrimitiveType__Group_3__0__Impl : ( 'based' ) ;
    public final void rule__TechnologySpecificPrimitiveType__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3239:1: ( ( 'based' ) )
            // InternalTechnologyDsl.g:3240:1: ( 'based' )
            {
            // InternalTechnologyDsl.g:3240:1: ( 'based' )
            // InternalTechnologyDsl.g:3241:2: 'based'
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
    // InternalTechnologyDsl.g:3250:1: rule__TechnologySpecificPrimitiveType__Group_3__1 : rule__TechnologySpecificPrimitiveType__Group_3__1__Impl rule__TechnologySpecificPrimitiveType__Group_3__2 ;
    public final void rule__TechnologySpecificPrimitiveType__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3254:1: ( rule__TechnologySpecificPrimitiveType__Group_3__1__Impl rule__TechnologySpecificPrimitiveType__Group_3__2 )
            // InternalTechnologyDsl.g:3255:2: rule__TechnologySpecificPrimitiveType__Group_3__1__Impl rule__TechnologySpecificPrimitiveType__Group_3__2
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
    // InternalTechnologyDsl.g:3262:1: rule__TechnologySpecificPrimitiveType__Group_3__1__Impl : ( 'on' ) ;
    public final void rule__TechnologySpecificPrimitiveType__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3266:1: ( ( 'on' ) )
            // InternalTechnologyDsl.g:3267:1: ( 'on' )
            {
            // InternalTechnologyDsl.g:3267:1: ( 'on' )
            // InternalTechnologyDsl.g:3268:2: 'on'
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
    // InternalTechnologyDsl.g:3277:1: rule__TechnologySpecificPrimitiveType__Group_3__2 : rule__TechnologySpecificPrimitiveType__Group_3__2__Impl rule__TechnologySpecificPrimitiveType__Group_3__3 ;
    public final void rule__TechnologySpecificPrimitiveType__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3281:1: ( rule__TechnologySpecificPrimitiveType__Group_3__2__Impl rule__TechnologySpecificPrimitiveType__Group_3__3 )
            // InternalTechnologyDsl.g:3282:2: rule__TechnologySpecificPrimitiveType__Group_3__2__Impl rule__TechnologySpecificPrimitiveType__Group_3__3
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
    // InternalTechnologyDsl.g:3289:1: rule__TechnologySpecificPrimitiveType__Group_3__2__Impl : ( ( rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_2 ) ) ;
    public final void rule__TechnologySpecificPrimitiveType__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3293:1: ( ( ( rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_2 ) ) )
            // InternalTechnologyDsl.g:3294:1: ( ( rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_2 ) )
            {
            // InternalTechnologyDsl.g:3294:1: ( ( rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_2 ) )
            // InternalTechnologyDsl.g:3295:2: ( rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_2 )
            {
             before(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesAssignment_3_2()); 
            // InternalTechnologyDsl.g:3296:2: ( rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_2 )
            // InternalTechnologyDsl.g:3296:3: rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_2
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
    // InternalTechnologyDsl.g:3304:1: rule__TechnologySpecificPrimitiveType__Group_3__3 : rule__TechnologySpecificPrimitiveType__Group_3__3__Impl rule__TechnologySpecificPrimitiveType__Group_3__4 ;
    public final void rule__TechnologySpecificPrimitiveType__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3308:1: ( rule__TechnologySpecificPrimitiveType__Group_3__3__Impl rule__TechnologySpecificPrimitiveType__Group_3__4 )
            // InternalTechnologyDsl.g:3309:2: rule__TechnologySpecificPrimitiveType__Group_3__3__Impl rule__TechnologySpecificPrimitiveType__Group_3__4
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
    // InternalTechnologyDsl.g:3316:1: rule__TechnologySpecificPrimitiveType__Group_3__3__Impl : ( ( rule__TechnologySpecificPrimitiveType__Group_3_3__0 )* ) ;
    public final void rule__TechnologySpecificPrimitiveType__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3320:1: ( ( ( rule__TechnologySpecificPrimitiveType__Group_3_3__0 )* ) )
            // InternalTechnologyDsl.g:3321:1: ( ( rule__TechnologySpecificPrimitiveType__Group_3_3__0 )* )
            {
            // InternalTechnologyDsl.g:3321:1: ( ( rule__TechnologySpecificPrimitiveType__Group_3_3__0 )* )
            // InternalTechnologyDsl.g:3322:2: ( rule__TechnologySpecificPrimitiveType__Group_3_3__0 )*
            {
             before(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getGroup_3_3()); 
            // InternalTechnologyDsl.g:3323:2: ( rule__TechnologySpecificPrimitiveType__Group_3_3__0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==46) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalTechnologyDsl.g:3323:3: rule__TechnologySpecificPrimitiveType__Group_3_3__0
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
    // InternalTechnologyDsl.g:3331:1: rule__TechnologySpecificPrimitiveType__Group_3__4 : rule__TechnologySpecificPrimitiveType__Group_3__4__Impl ;
    public final void rule__TechnologySpecificPrimitiveType__Group_3__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3335:1: ( rule__TechnologySpecificPrimitiveType__Group_3__4__Impl )
            // InternalTechnologyDsl.g:3336:2: rule__TechnologySpecificPrimitiveType__Group_3__4__Impl
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
    // InternalTechnologyDsl.g:3342:1: rule__TechnologySpecificPrimitiveType__Group_3__4__Impl : ( ( rule__TechnologySpecificPrimitiveType__DefaultAssignment_3_4 )? ) ;
    public final void rule__TechnologySpecificPrimitiveType__Group_3__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3346:1: ( ( ( rule__TechnologySpecificPrimitiveType__DefaultAssignment_3_4 )? ) )
            // InternalTechnologyDsl.g:3347:1: ( ( rule__TechnologySpecificPrimitiveType__DefaultAssignment_3_4 )? )
            {
            // InternalTechnologyDsl.g:3347:1: ( ( rule__TechnologySpecificPrimitiveType__DefaultAssignment_3_4 )? )
            // InternalTechnologyDsl.g:3348:2: ( rule__TechnologySpecificPrimitiveType__DefaultAssignment_3_4 )?
            {
             before(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getDefaultAssignment_3_4()); 
            // InternalTechnologyDsl.g:3349:2: ( rule__TechnologySpecificPrimitiveType__DefaultAssignment_3_4 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==79) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalTechnologyDsl.g:3349:3: rule__TechnologySpecificPrimitiveType__DefaultAssignment_3_4
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
    // InternalTechnologyDsl.g:3358:1: rule__TechnologySpecificPrimitiveType__Group_3_3__0 : rule__TechnologySpecificPrimitiveType__Group_3_3__0__Impl rule__TechnologySpecificPrimitiveType__Group_3_3__1 ;
    public final void rule__TechnologySpecificPrimitiveType__Group_3_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3362:1: ( rule__TechnologySpecificPrimitiveType__Group_3_3__0__Impl rule__TechnologySpecificPrimitiveType__Group_3_3__1 )
            // InternalTechnologyDsl.g:3363:2: rule__TechnologySpecificPrimitiveType__Group_3_3__0__Impl rule__TechnologySpecificPrimitiveType__Group_3_3__1
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
    // InternalTechnologyDsl.g:3370:1: rule__TechnologySpecificPrimitiveType__Group_3_3__0__Impl : ( ',' ) ;
    public final void rule__TechnologySpecificPrimitiveType__Group_3_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3374:1: ( ( ',' ) )
            // InternalTechnologyDsl.g:3375:1: ( ',' )
            {
            // InternalTechnologyDsl.g:3375:1: ( ',' )
            // InternalTechnologyDsl.g:3376:2: ','
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
    // InternalTechnologyDsl.g:3385:1: rule__TechnologySpecificPrimitiveType__Group_3_3__1 : rule__TechnologySpecificPrimitiveType__Group_3_3__1__Impl ;
    public final void rule__TechnologySpecificPrimitiveType__Group_3_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3389:1: ( rule__TechnologySpecificPrimitiveType__Group_3_3__1__Impl )
            // InternalTechnologyDsl.g:3390:2: rule__TechnologySpecificPrimitiveType__Group_3_3__1__Impl
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
    // InternalTechnologyDsl.g:3396:1: rule__TechnologySpecificPrimitiveType__Group_3_3__1__Impl : ( ( rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_3_1 ) ) ;
    public final void rule__TechnologySpecificPrimitiveType__Group_3_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3400:1: ( ( ( rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_3_1 ) ) )
            // InternalTechnologyDsl.g:3401:1: ( ( rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_3_1 ) )
            {
            // InternalTechnologyDsl.g:3401:1: ( ( rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_3_1 ) )
            // InternalTechnologyDsl.g:3402:2: ( rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_3_1 )
            {
             before(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getBasicBuiltinPrimitiveTypesAssignment_3_3_1()); 
            // InternalTechnologyDsl.g:3403:2: ( rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_3_1 )
            // InternalTechnologyDsl.g:3403:3: rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_3_1
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
    // InternalTechnologyDsl.g:3412:1: rule__TechnologySpecificListType__Group__0 : rule__TechnologySpecificListType__Group__0__Impl rule__TechnologySpecificListType__Group__1 ;
    public final void rule__TechnologySpecificListType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3416:1: ( rule__TechnologySpecificListType__Group__0__Impl rule__TechnologySpecificListType__Group__1 )
            // InternalTechnologyDsl.g:3417:2: rule__TechnologySpecificListType__Group__0__Impl rule__TechnologySpecificListType__Group__1
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
    // InternalTechnologyDsl.g:3424:1: rule__TechnologySpecificListType__Group__0__Impl : ( 'list' ) ;
    public final void rule__TechnologySpecificListType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3428:1: ( ( 'list' ) )
            // InternalTechnologyDsl.g:3429:1: ( 'list' )
            {
            // InternalTechnologyDsl.g:3429:1: ( 'list' )
            // InternalTechnologyDsl.g:3430:2: 'list'
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
    // InternalTechnologyDsl.g:3439:1: rule__TechnologySpecificListType__Group__1 : rule__TechnologySpecificListType__Group__1__Impl rule__TechnologySpecificListType__Group__2 ;
    public final void rule__TechnologySpecificListType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3443:1: ( rule__TechnologySpecificListType__Group__1__Impl rule__TechnologySpecificListType__Group__2 )
            // InternalTechnologyDsl.g:3444:2: rule__TechnologySpecificListType__Group__1__Impl rule__TechnologySpecificListType__Group__2
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
    // InternalTechnologyDsl.g:3451:1: rule__TechnologySpecificListType__Group__1__Impl : ( 'type' ) ;
    public final void rule__TechnologySpecificListType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3455:1: ( ( 'type' ) )
            // InternalTechnologyDsl.g:3456:1: ( 'type' )
            {
            // InternalTechnologyDsl.g:3456:1: ( 'type' )
            // InternalTechnologyDsl.g:3457:2: 'type'
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
    // InternalTechnologyDsl.g:3466:1: rule__TechnologySpecificListType__Group__2 : rule__TechnologySpecificListType__Group__2__Impl rule__TechnologySpecificListType__Group__3 ;
    public final void rule__TechnologySpecificListType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3470:1: ( rule__TechnologySpecificListType__Group__2__Impl rule__TechnologySpecificListType__Group__3 )
            // InternalTechnologyDsl.g:3471:2: rule__TechnologySpecificListType__Group__2__Impl rule__TechnologySpecificListType__Group__3
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
    // InternalTechnologyDsl.g:3478:1: rule__TechnologySpecificListType__Group__2__Impl : ( ( rule__TechnologySpecificListType__NameAssignment_2 ) ) ;
    public final void rule__TechnologySpecificListType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3482:1: ( ( ( rule__TechnologySpecificListType__NameAssignment_2 ) ) )
            // InternalTechnologyDsl.g:3483:1: ( ( rule__TechnologySpecificListType__NameAssignment_2 ) )
            {
            // InternalTechnologyDsl.g:3483:1: ( ( rule__TechnologySpecificListType__NameAssignment_2 ) )
            // InternalTechnologyDsl.g:3484:2: ( rule__TechnologySpecificListType__NameAssignment_2 )
            {
             before(grammarAccess.getTechnologySpecificListTypeAccess().getNameAssignment_2()); 
            // InternalTechnologyDsl.g:3485:2: ( rule__TechnologySpecificListType__NameAssignment_2 )
            // InternalTechnologyDsl.g:3485:3: rule__TechnologySpecificListType__NameAssignment_2
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
    // InternalTechnologyDsl.g:3493:1: rule__TechnologySpecificListType__Group__3 : rule__TechnologySpecificListType__Group__3__Impl ;
    public final void rule__TechnologySpecificListType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3497:1: ( rule__TechnologySpecificListType__Group__3__Impl )
            // InternalTechnologyDsl.g:3498:2: rule__TechnologySpecificListType__Group__3__Impl
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
    // InternalTechnologyDsl.g:3504:1: rule__TechnologySpecificListType__Group__3__Impl : ( ';' ) ;
    public final void rule__TechnologySpecificListType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3508:1: ( ( ';' ) )
            // InternalTechnologyDsl.g:3509:1: ( ';' )
            {
            // InternalTechnologyDsl.g:3509:1: ( ';' )
            // InternalTechnologyDsl.g:3510:2: ';'
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
    // InternalTechnologyDsl.g:3520:1: rule__TechnologySpecificDataStructure__Group__0 : rule__TechnologySpecificDataStructure__Group__0__Impl rule__TechnologySpecificDataStructure__Group__1 ;
    public final void rule__TechnologySpecificDataStructure__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3524:1: ( rule__TechnologySpecificDataStructure__Group__0__Impl rule__TechnologySpecificDataStructure__Group__1 )
            // InternalTechnologyDsl.g:3525:2: rule__TechnologySpecificDataStructure__Group__0__Impl rule__TechnologySpecificDataStructure__Group__1
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
    // InternalTechnologyDsl.g:3532:1: rule__TechnologySpecificDataStructure__Group__0__Impl : ( 'structure' ) ;
    public final void rule__TechnologySpecificDataStructure__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3536:1: ( ( 'structure' ) )
            // InternalTechnologyDsl.g:3537:1: ( 'structure' )
            {
            // InternalTechnologyDsl.g:3537:1: ( 'structure' )
            // InternalTechnologyDsl.g:3538:2: 'structure'
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
    // InternalTechnologyDsl.g:3547:1: rule__TechnologySpecificDataStructure__Group__1 : rule__TechnologySpecificDataStructure__Group__1__Impl rule__TechnologySpecificDataStructure__Group__2 ;
    public final void rule__TechnologySpecificDataStructure__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3551:1: ( rule__TechnologySpecificDataStructure__Group__1__Impl rule__TechnologySpecificDataStructure__Group__2 )
            // InternalTechnologyDsl.g:3552:2: rule__TechnologySpecificDataStructure__Group__1__Impl rule__TechnologySpecificDataStructure__Group__2
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
    // InternalTechnologyDsl.g:3559:1: rule__TechnologySpecificDataStructure__Group__1__Impl : ( 'type' ) ;
    public final void rule__TechnologySpecificDataStructure__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3563:1: ( ( 'type' ) )
            // InternalTechnologyDsl.g:3564:1: ( 'type' )
            {
            // InternalTechnologyDsl.g:3564:1: ( 'type' )
            // InternalTechnologyDsl.g:3565:2: 'type'
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
    // InternalTechnologyDsl.g:3574:1: rule__TechnologySpecificDataStructure__Group__2 : rule__TechnologySpecificDataStructure__Group__2__Impl rule__TechnologySpecificDataStructure__Group__3 ;
    public final void rule__TechnologySpecificDataStructure__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3578:1: ( rule__TechnologySpecificDataStructure__Group__2__Impl rule__TechnologySpecificDataStructure__Group__3 )
            // InternalTechnologyDsl.g:3579:2: rule__TechnologySpecificDataStructure__Group__2__Impl rule__TechnologySpecificDataStructure__Group__3
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
    // InternalTechnologyDsl.g:3586:1: rule__TechnologySpecificDataStructure__Group__2__Impl : ( ( rule__TechnologySpecificDataStructure__NameAssignment_2 ) ) ;
    public final void rule__TechnologySpecificDataStructure__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3590:1: ( ( ( rule__TechnologySpecificDataStructure__NameAssignment_2 ) ) )
            // InternalTechnologyDsl.g:3591:1: ( ( rule__TechnologySpecificDataStructure__NameAssignment_2 ) )
            {
            // InternalTechnologyDsl.g:3591:1: ( ( rule__TechnologySpecificDataStructure__NameAssignment_2 ) )
            // InternalTechnologyDsl.g:3592:2: ( rule__TechnologySpecificDataStructure__NameAssignment_2 )
            {
             before(grammarAccess.getTechnologySpecificDataStructureAccess().getNameAssignment_2()); 
            // InternalTechnologyDsl.g:3593:2: ( rule__TechnologySpecificDataStructure__NameAssignment_2 )
            // InternalTechnologyDsl.g:3593:3: rule__TechnologySpecificDataStructure__NameAssignment_2
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
    // InternalTechnologyDsl.g:3601:1: rule__TechnologySpecificDataStructure__Group__3 : rule__TechnologySpecificDataStructure__Group__3__Impl ;
    public final void rule__TechnologySpecificDataStructure__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3605:1: ( rule__TechnologySpecificDataStructure__Group__3__Impl )
            // InternalTechnologyDsl.g:3606:2: rule__TechnologySpecificDataStructure__Group__3__Impl
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
    // InternalTechnologyDsl.g:3612:1: rule__TechnologySpecificDataStructure__Group__3__Impl : ( ';' ) ;
    public final void rule__TechnologySpecificDataStructure__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3616:1: ( ( ';' ) )
            // InternalTechnologyDsl.g:3617:1: ( ';' )
            {
            // InternalTechnologyDsl.g:3617:1: ( ';' )
            // InternalTechnologyDsl.g:3618:2: ';'
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
    // InternalTechnologyDsl.g:3628:1: rule__PossiblyImportedTechnologySpecificType__Group__0 : rule__PossiblyImportedTechnologySpecificType__Group__0__Impl rule__PossiblyImportedTechnologySpecificType__Group__1 ;
    public final void rule__PossiblyImportedTechnologySpecificType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3632:1: ( rule__PossiblyImportedTechnologySpecificType__Group__0__Impl rule__PossiblyImportedTechnologySpecificType__Group__1 )
            // InternalTechnologyDsl.g:3633:2: rule__PossiblyImportedTechnologySpecificType__Group__0__Impl rule__PossiblyImportedTechnologySpecificType__Group__1
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
    // InternalTechnologyDsl.g:3640:1: rule__PossiblyImportedTechnologySpecificType__Group__0__Impl : ( ( rule__PossiblyImportedTechnologySpecificType__Group_0__0 )? ) ;
    public final void rule__PossiblyImportedTechnologySpecificType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3644:1: ( ( ( rule__PossiblyImportedTechnologySpecificType__Group_0__0 )? ) )
            // InternalTechnologyDsl.g:3645:1: ( ( rule__PossiblyImportedTechnologySpecificType__Group_0__0 )? )
            {
            // InternalTechnologyDsl.g:3645:1: ( ( rule__PossiblyImportedTechnologySpecificType__Group_0__0 )? )
            // InternalTechnologyDsl.g:3646:2: ( rule__PossiblyImportedTechnologySpecificType__Group_0__0 )?
            {
             before(grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getGroup_0()); 
            // InternalTechnologyDsl.g:3647:2: ( rule__PossiblyImportedTechnologySpecificType__Group_0__0 )?
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
                    // InternalTechnologyDsl.g:3647:3: rule__PossiblyImportedTechnologySpecificType__Group_0__0
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
    // InternalTechnologyDsl.g:3655:1: rule__PossiblyImportedTechnologySpecificType__Group__1 : rule__PossiblyImportedTechnologySpecificType__Group__1__Impl ;
    public final void rule__PossiblyImportedTechnologySpecificType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3659:1: ( rule__PossiblyImportedTechnologySpecificType__Group__1__Impl )
            // InternalTechnologyDsl.g:3660:2: rule__PossiblyImportedTechnologySpecificType__Group__1__Impl
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
    // InternalTechnologyDsl.g:3666:1: rule__PossiblyImportedTechnologySpecificType__Group__1__Impl : ( ( rule__PossiblyImportedTechnologySpecificType__TypeAssignment_1 ) ) ;
    public final void rule__PossiblyImportedTechnologySpecificType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3670:1: ( ( ( rule__PossiblyImportedTechnologySpecificType__TypeAssignment_1 ) ) )
            // InternalTechnologyDsl.g:3671:1: ( ( rule__PossiblyImportedTechnologySpecificType__TypeAssignment_1 ) )
            {
            // InternalTechnologyDsl.g:3671:1: ( ( rule__PossiblyImportedTechnologySpecificType__TypeAssignment_1 ) )
            // InternalTechnologyDsl.g:3672:2: ( rule__PossiblyImportedTechnologySpecificType__TypeAssignment_1 )
            {
             before(grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getTypeAssignment_1()); 
            // InternalTechnologyDsl.g:3673:2: ( rule__PossiblyImportedTechnologySpecificType__TypeAssignment_1 )
            // InternalTechnologyDsl.g:3673:3: rule__PossiblyImportedTechnologySpecificType__TypeAssignment_1
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
    // InternalTechnologyDsl.g:3682:1: rule__PossiblyImportedTechnologySpecificType__Group_0__0 : rule__PossiblyImportedTechnologySpecificType__Group_0__0__Impl rule__PossiblyImportedTechnologySpecificType__Group_0__1 ;
    public final void rule__PossiblyImportedTechnologySpecificType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3686:1: ( rule__PossiblyImportedTechnologySpecificType__Group_0__0__Impl rule__PossiblyImportedTechnologySpecificType__Group_0__1 )
            // InternalTechnologyDsl.g:3687:2: rule__PossiblyImportedTechnologySpecificType__Group_0__0__Impl rule__PossiblyImportedTechnologySpecificType__Group_0__1
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
    // InternalTechnologyDsl.g:3694:1: rule__PossiblyImportedTechnologySpecificType__Group_0__0__Impl : ( ( rule__PossiblyImportedTechnologySpecificType__ImportAssignment_0_0 ) ) ;
    public final void rule__PossiblyImportedTechnologySpecificType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3698:1: ( ( ( rule__PossiblyImportedTechnologySpecificType__ImportAssignment_0_0 ) ) )
            // InternalTechnologyDsl.g:3699:1: ( ( rule__PossiblyImportedTechnologySpecificType__ImportAssignment_0_0 ) )
            {
            // InternalTechnologyDsl.g:3699:1: ( ( rule__PossiblyImportedTechnologySpecificType__ImportAssignment_0_0 ) )
            // InternalTechnologyDsl.g:3700:2: ( rule__PossiblyImportedTechnologySpecificType__ImportAssignment_0_0 )
            {
             before(grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getImportAssignment_0_0()); 
            // InternalTechnologyDsl.g:3701:2: ( rule__PossiblyImportedTechnologySpecificType__ImportAssignment_0_0 )
            // InternalTechnologyDsl.g:3701:3: rule__PossiblyImportedTechnologySpecificType__ImportAssignment_0_0
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
    // InternalTechnologyDsl.g:3709:1: rule__PossiblyImportedTechnologySpecificType__Group_0__1 : rule__PossiblyImportedTechnologySpecificType__Group_0__1__Impl ;
    public final void rule__PossiblyImportedTechnologySpecificType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3713:1: ( rule__PossiblyImportedTechnologySpecificType__Group_0__1__Impl )
            // InternalTechnologyDsl.g:3714:2: rule__PossiblyImportedTechnologySpecificType__Group_0__1__Impl
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
    // InternalTechnologyDsl.g:3720:1: rule__PossiblyImportedTechnologySpecificType__Group_0__1__Impl : ( '::' ) ;
    public final void rule__PossiblyImportedTechnologySpecificType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3724:1: ( ( '::' ) )
            // InternalTechnologyDsl.g:3725:1: ( '::' )
            {
            // InternalTechnologyDsl.g:3725:1: ( '::' )
            // InternalTechnologyDsl.g:3726:2: '::'
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
    // InternalTechnologyDsl.g:3736:1: rule__CompatibilityMatrixEntry__Group__0 : rule__CompatibilityMatrixEntry__Group__0__Impl rule__CompatibilityMatrixEntry__Group__1 ;
    public final void rule__CompatibilityMatrixEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3740:1: ( rule__CompatibilityMatrixEntry__Group__0__Impl rule__CompatibilityMatrixEntry__Group__1 )
            // InternalTechnologyDsl.g:3741:2: rule__CompatibilityMatrixEntry__Group__0__Impl rule__CompatibilityMatrixEntry__Group__1
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
    // InternalTechnologyDsl.g:3748:1: rule__CompatibilityMatrixEntry__Group__0__Impl : ( ( rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_0 ) ) ;
    public final void rule__CompatibilityMatrixEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3752:1: ( ( ( rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_0 ) ) )
            // InternalTechnologyDsl.g:3753:1: ( ( rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_0 ) )
            {
            // InternalTechnologyDsl.g:3753:1: ( ( rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_0 ) )
            // InternalTechnologyDsl.g:3754:2: ( rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_0 )
            {
             before(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesAssignment_0()); 
            // InternalTechnologyDsl.g:3755:2: ( rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_0 )
            // InternalTechnologyDsl.g:3755:3: rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_0
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
    // InternalTechnologyDsl.g:3763:1: rule__CompatibilityMatrixEntry__Group__1 : rule__CompatibilityMatrixEntry__Group__1__Impl rule__CompatibilityMatrixEntry__Group__2 ;
    public final void rule__CompatibilityMatrixEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3767:1: ( rule__CompatibilityMatrixEntry__Group__1__Impl rule__CompatibilityMatrixEntry__Group__2 )
            // InternalTechnologyDsl.g:3768:2: rule__CompatibilityMatrixEntry__Group__1__Impl rule__CompatibilityMatrixEntry__Group__2
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
    // InternalTechnologyDsl.g:3775:1: rule__CompatibilityMatrixEntry__Group__1__Impl : ( ( rule__CompatibilityMatrixEntry__Group_1__0 )* ) ;
    public final void rule__CompatibilityMatrixEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3779:1: ( ( ( rule__CompatibilityMatrixEntry__Group_1__0 )* ) )
            // InternalTechnologyDsl.g:3780:1: ( ( rule__CompatibilityMatrixEntry__Group_1__0 )* )
            {
            // InternalTechnologyDsl.g:3780:1: ( ( rule__CompatibilityMatrixEntry__Group_1__0 )* )
            // InternalTechnologyDsl.g:3781:2: ( rule__CompatibilityMatrixEntry__Group_1__0 )*
            {
             before(grammarAccess.getCompatibilityMatrixEntryAccess().getGroup_1()); 
            // InternalTechnologyDsl.g:3782:2: ( rule__CompatibilityMatrixEntry__Group_1__0 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==46) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalTechnologyDsl.g:3782:3: rule__CompatibilityMatrixEntry__Group_1__0
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
    // InternalTechnologyDsl.g:3790:1: rule__CompatibilityMatrixEntry__Group__2 : rule__CompatibilityMatrixEntry__Group__2__Impl rule__CompatibilityMatrixEntry__Group__3 ;
    public final void rule__CompatibilityMatrixEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3794:1: ( rule__CompatibilityMatrixEntry__Group__2__Impl rule__CompatibilityMatrixEntry__Group__3 )
            // InternalTechnologyDsl.g:3795:2: rule__CompatibilityMatrixEntry__Group__2__Impl rule__CompatibilityMatrixEntry__Group__3
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
    // InternalTechnologyDsl.g:3802:1: rule__CompatibilityMatrixEntry__Group__2__Impl : ( ( rule__CompatibilityMatrixEntry__DirectionAssignment_2 ) ) ;
    public final void rule__CompatibilityMatrixEntry__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3806:1: ( ( ( rule__CompatibilityMatrixEntry__DirectionAssignment_2 ) ) )
            // InternalTechnologyDsl.g:3807:1: ( ( rule__CompatibilityMatrixEntry__DirectionAssignment_2 ) )
            {
            // InternalTechnologyDsl.g:3807:1: ( ( rule__CompatibilityMatrixEntry__DirectionAssignment_2 ) )
            // InternalTechnologyDsl.g:3808:2: ( rule__CompatibilityMatrixEntry__DirectionAssignment_2 )
            {
             before(grammarAccess.getCompatibilityMatrixEntryAccess().getDirectionAssignment_2()); 
            // InternalTechnologyDsl.g:3809:2: ( rule__CompatibilityMatrixEntry__DirectionAssignment_2 )
            // InternalTechnologyDsl.g:3809:3: rule__CompatibilityMatrixEntry__DirectionAssignment_2
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
    // InternalTechnologyDsl.g:3817:1: rule__CompatibilityMatrixEntry__Group__3 : rule__CompatibilityMatrixEntry__Group__3__Impl rule__CompatibilityMatrixEntry__Group__4 ;
    public final void rule__CompatibilityMatrixEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3821:1: ( rule__CompatibilityMatrixEntry__Group__3__Impl rule__CompatibilityMatrixEntry__Group__4 )
            // InternalTechnologyDsl.g:3822:2: rule__CompatibilityMatrixEntry__Group__3__Impl rule__CompatibilityMatrixEntry__Group__4
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
    // InternalTechnologyDsl.g:3829:1: rule__CompatibilityMatrixEntry__Group__3__Impl : ( ( rule__CompatibilityMatrixEntry__MappingTypeAssignment_3 ) ) ;
    public final void rule__CompatibilityMatrixEntry__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3833:1: ( ( ( rule__CompatibilityMatrixEntry__MappingTypeAssignment_3 ) ) )
            // InternalTechnologyDsl.g:3834:1: ( ( rule__CompatibilityMatrixEntry__MappingTypeAssignment_3 ) )
            {
            // InternalTechnologyDsl.g:3834:1: ( ( rule__CompatibilityMatrixEntry__MappingTypeAssignment_3 ) )
            // InternalTechnologyDsl.g:3835:2: ( rule__CompatibilityMatrixEntry__MappingTypeAssignment_3 )
            {
             before(grammarAccess.getCompatibilityMatrixEntryAccess().getMappingTypeAssignment_3()); 
            // InternalTechnologyDsl.g:3836:2: ( rule__CompatibilityMatrixEntry__MappingTypeAssignment_3 )
            // InternalTechnologyDsl.g:3836:3: rule__CompatibilityMatrixEntry__MappingTypeAssignment_3
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
    // InternalTechnologyDsl.g:3844:1: rule__CompatibilityMatrixEntry__Group__4 : rule__CompatibilityMatrixEntry__Group__4__Impl ;
    public final void rule__CompatibilityMatrixEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3848:1: ( rule__CompatibilityMatrixEntry__Group__4__Impl )
            // InternalTechnologyDsl.g:3849:2: rule__CompatibilityMatrixEntry__Group__4__Impl
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
    // InternalTechnologyDsl.g:3855:1: rule__CompatibilityMatrixEntry__Group__4__Impl : ( ';' ) ;
    public final void rule__CompatibilityMatrixEntry__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3859:1: ( ( ';' ) )
            // InternalTechnologyDsl.g:3860:1: ( ';' )
            {
            // InternalTechnologyDsl.g:3860:1: ( ';' )
            // InternalTechnologyDsl.g:3861:2: ';'
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
    // InternalTechnologyDsl.g:3871:1: rule__CompatibilityMatrixEntry__Group_1__0 : rule__CompatibilityMatrixEntry__Group_1__0__Impl rule__CompatibilityMatrixEntry__Group_1__1 ;
    public final void rule__CompatibilityMatrixEntry__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3875:1: ( rule__CompatibilityMatrixEntry__Group_1__0__Impl rule__CompatibilityMatrixEntry__Group_1__1 )
            // InternalTechnologyDsl.g:3876:2: rule__CompatibilityMatrixEntry__Group_1__0__Impl rule__CompatibilityMatrixEntry__Group_1__1
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
    // InternalTechnologyDsl.g:3883:1: rule__CompatibilityMatrixEntry__Group_1__0__Impl : ( ',' ) ;
    public final void rule__CompatibilityMatrixEntry__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3887:1: ( ( ',' ) )
            // InternalTechnologyDsl.g:3888:1: ( ',' )
            {
            // InternalTechnologyDsl.g:3888:1: ( ',' )
            // InternalTechnologyDsl.g:3889:2: ','
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
    // InternalTechnologyDsl.g:3898:1: rule__CompatibilityMatrixEntry__Group_1__1 : rule__CompatibilityMatrixEntry__Group_1__1__Impl ;
    public final void rule__CompatibilityMatrixEntry__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3902:1: ( rule__CompatibilityMatrixEntry__Group_1__1__Impl )
            // InternalTechnologyDsl.g:3903:2: rule__CompatibilityMatrixEntry__Group_1__1__Impl
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
    // InternalTechnologyDsl.g:3909:1: rule__CompatibilityMatrixEntry__Group_1__1__Impl : ( ( rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_1_1 ) ) ;
    public final void rule__CompatibilityMatrixEntry__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3913:1: ( ( ( rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_1_1 ) ) )
            // InternalTechnologyDsl.g:3914:1: ( ( rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_1_1 ) )
            {
            // InternalTechnologyDsl.g:3914:1: ( ( rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_1_1 ) )
            // InternalTechnologyDsl.g:3915:2: ( rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_1_1 )
            {
             before(grammarAccess.getCompatibilityMatrixEntryAccess().getCompatibleTypesAssignment_1_1()); 
            // InternalTechnologyDsl.g:3916:2: ( rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_1_1 )
            // InternalTechnologyDsl.g:3916:3: rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_1_1
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
    // InternalTechnologyDsl.g:3925:1: rule__DeploymentTechnology__Group__0 : rule__DeploymentTechnology__Group__0__Impl rule__DeploymentTechnology__Group__1 ;
    public final void rule__DeploymentTechnology__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3929:1: ( rule__DeploymentTechnology__Group__0__Impl rule__DeploymentTechnology__Group__1 )
            // InternalTechnologyDsl.g:3930:2: rule__DeploymentTechnology__Group__0__Impl rule__DeploymentTechnology__Group__1
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
    // InternalTechnologyDsl.g:3937:1: rule__DeploymentTechnology__Group__0__Impl : ( ( rule__DeploymentTechnology__NameAssignment_0 ) ) ;
    public final void rule__DeploymentTechnology__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3941:1: ( ( ( rule__DeploymentTechnology__NameAssignment_0 ) ) )
            // InternalTechnologyDsl.g:3942:1: ( ( rule__DeploymentTechnology__NameAssignment_0 ) )
            {
            // InternalTechnologyDsl.g:3942:1: ( ( rule__DeploymentTechnology__NameAssignment_0 ) )
            // InternalTechnologyDsl.g:3943:2: ( rule__DeploymentTechnology__NameAssignment_0 )
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getNameAssignment_0()); 
            // InternalTechnologyDsl.g:3944:2: ( rule__DeploymentTechnology__NameAssignment_0 )
            // InternalTechnologyDsl.g:3944:3: rule__DeploymentTechnology__NameAssignment_0
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
    // InternalTechnologyDsl.g:3952:1: rule__DeploymentTechnology__Group__1 : rule__DeploymentTechnology__Group__1__Impl rule__DeploymentTechnology__Group__2 ;
    public final void rule__DeploymentTechnology__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3956:1: ( rule__DeploymentTechnology__Group__1__Impl rule__DeploymentTechnology__Group__2 )
            // InternalTechnologyDsl.g:3957:2: rule__DeploymentTechnology__Group__1__Impl rule__DeploymentTechnology__Group__2
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
    // InternalTechnologyDsl.g:3964:1: rule__DeploymentTechnology__Group__1__Impl : ( '{' ) ;
    public final void rule__DeploymentTechnology__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3968:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:3969:1: ( '{' )
            {
            // InternalTechnologyDsl.g:3969:1: ( '{' )
            // InternalTechnologyDsl.g:3970:2: '{'
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,30,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:3979:1: rule__DeploymentTechnology__Group__2 : rule__DeploymentTechnology__Group__2__Impl rule__DeploymentTechnology__Group__3 ;
    public final void rule__DeploymentTechnology__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3983:1: ( rule__DeploymentTechnology__Group__2__Impl rule__DeploymentTechnology__Group__3 )
            // InternalTechnologyDsl.g:3984:2: rule__DeploymentTechnology__Group__2__Impl rule__DeploymentTechnology__Group__3
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
    // InternalTechnologyDsl.g:3991:1: rule__DeploymentTechnology__Group__2__Impl : ( 'operation' ) ;
    public final void rule__DeploymentTechnology__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:3995:1: ( ( 'operation' ) )
            // InternalTechnologyDsl.g:3996:1: ( 'operation' )
            {
            // InternalTechnologyDsl.g:3996:1: ( 'operation' )
            // InternalTechnologyDsl.g:3997:2: 'operation'
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
    // InternalTechnologyDsl.g:4006:1: rule__DeploymentTechnology__Group__3 : rule__DeploymentTechnology__Group__3__Impl rule__DeploymentTechnology__Group__4 ;
    public final void rule__DeploymentTechnology__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4010:1: ( rule__DeploymentTechnology__Group__3__Impl rule__DeploymentTechnology__Group__4 )
            // InternalTechnologyDsl.g:4011:2: rule__DeploymentTechnology__Group__3__Impl rule__DeploymentTechnology__Group__4
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
    // InternalTechnologyDsl.g:4018:1: rule__DeploymentTechnology__Group__3__Impl : ( 'environments' ) ;
    public final void rule__DeploymentTechnology__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4022:1: ( ( 'environments' ) )
            // InternalTechnologyDsl.g:4023:1: ( 'environments' )
            {
            // InternalTechnologyDsl.g:4023:1: ( 'environments' )
            // InternalTechnologyDsl.g:4024:2: 'environments'
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
    // InternalTechnologyDsl.g:4033:1: rule__DeploymentTechnology__Group__4 : rule__DeploymentTechnology__Group__4__Impl rule__DeploymentTechnology__Group__5 ;
    public final void rule__DeploymentTechnology__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4037:1: ( rule__DeploymentTechnology__Group__4__Impl rule__DeploymentTechnology__Group__5 )
            // InternalTechnologyDsl.g:4038:2: rule__DeploymentTechnology__Group__4__Impl rule__DeploymentTechnology__Group__5
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
    // InternalTechnologyDsl.g:4045:1: rule__DeploymentTechnology__Group__4__Impl : ( '=' ) ;
    public final void rule__DeploymentTechnology__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4049:1: ( ( '=' ) )
            // InternalTechnologyDsl.g:4050:1: ( '=' )
            {
            // InternalTechnologyDsl.g:4050:1: ( '=' )
            // InternalTechnologyDsl.g:4051:2: '='
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
    // InternalTechnologyDsl.g:4060:1: rule__DeploymentTechnology__Group__5 : rule__DeploymentTechnology__Group__5__Impl rule__DeploymentTechnology__Group__6 ;
    public final void rule__DeploymentTechnology__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4064:1: ( rule__DeploymentTechnology__Group__5__Impl rule__DeploymentTechnology__Group__6 )
            // InternalTechnologyDsl.g:4065:2: rule__DeploymentTechnology__Group__5__Impl rule__DeploymentTechnology__Group__6
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
    // InternalTechnologyDsl.g:4072:1: rule__DeploymentTechnology__Group__5__Impl : ( ( rule__DeploymentTechnology__OperationEnvironmentsAssignment_5 ) ) ;
    public final void rule__DeploymentTechnology__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4076:1: ( ( ( rule__DeploymentTechnology__OperationEnvironmentsAssignment_5 ) ) )
            // InternalTechnologyDsl.g:4077:1: ( ( rule__DeploymentTechnology__OperationEnvironmentsAssignment_5 ) )
            {
            // InternalTechnologyDsl.g:4077:1: ( ( rule__DeploymentTechnology__OperationEnvironmentsAssignment_5 ) )
            // InternalTechnologyDsl.g:4078:2: ( rule__DeploymentTechnology__OperationEnvironmentsAssignment_5 )
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getOperationEnvironmentsAssignment_5()); 
            // InternalTechnologyDsl.g:4079:2: ( rule__DeploymentTechnology__OperationEnvironmentsAssignment_5 )
            // InternalTechnologyDsl.g:4079:3: rule__DeploymentTechnology__OperationEnvironmentsAssignment_5
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
    // InternalTechnologyDsl.g:4087:1: rule__DeploymentTechnology__Group__6 : rule__DeploymentTechnology__Group__6__Impl rule__DeploymentTechnology__Group__7 ;
    public final void rule__DeploymentTechnology__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4091:1: ( rule__DeploymentTechnology__Group__6__Impl rule__DeploymentTechnology__Group__7 )
            // InternalTechnologyDsl.g:4092:2: rule__DeploymentTechnology__Group__6__Impl rule__DeploymentTechnology__Group__7
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
    // InternalTechnologyDsl.g:4099:1: rule__DeploymentTechnology__Group__6__Impl : ( ( rule__DeploymentTechnology__Group_6__0 )* ) ;
    public final void rule__DeploymentTechnology__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4103:1: ( ( ( rule__DeploymentTechnology__Group_6__0 )* ) )
            // InternalTechnologyDsl.g:4104:1: ( ( rule__DeploymentTechnology__Group_6__0 )* )
            {
            // InternalTechnologyDsl.g:4104:1: ( ( rule__DeploymentTechnology__Group_6__0 )* )
            // InternalTechnologyDsl.g:4105:2: ( rule__DeploymentTechnology__Group_6__0 )*
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getGroup_6()); 
            // InternalTechnologyDsl.g:4106:2: ( rule__DeploymentTechnology__Group_6__0 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==46) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalTechnologyDsl.g:4106:3: rule__DeploymentTechnology__Group_6__0
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
    // InternalTechnologyDsl.g:4114:1: rule__DeploymentTechnology__Group__7 : rule__DeploymentTechnology__Group__7__Impl rule__DeploymentTechnology__Group__8 ;
    public final void rule__DeploymentTechnology__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4118:1: ( rule__DeploymentTechnology__Group__7__Impl rule__DeploymentTechnology__Group__8 )
            // InternalTechnologyDsl.g:4119:2: rule__DeploymentTechnology__Group__7__Impl rule__DeploymentTechnology__Group__8
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
    // InternalTechnologyDsl.g:4126:1: rule__DeploymentTechnology__Group__7__Impl : ( ';' ) ;
    public final void rule__DeploymentTechnology__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4130:1: ( ( ';' ) )
            // InternalTechnologyDsl.g:4131:1: ( ';' )
            {
            // InternalTechnologyDsl.g:4131:1: ( ';' )
            // InternalTechnologyDsl.g:4132:2: ';'
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
    // InternalTechnologyDsl.g:4141:1: rule__DeploymentTechnology__Group__8 : rule__DeploymentTechnology__Group__8__Impl rule__DeploymentTechnology__Group__9 ;
    public final void rule__DeploymentTechnology__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4145:1: ( rule__DeploymentTechnology__Group__8__Impl rule__DeploymentTechnology__Group__9 )
            // InternalTechnologyDsl.g:4146:2: rule__DeploymentTechnology__Group__8__Impl rule__DeploymentTechnology__Group__9
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
    // InternalTechnologyDsl.g:4153:1: rule__DeploymentTechnology__Group__8__Impl : ( ( rule__DeploymentTechnology__Group_8__0 )? ) ;
    public final void rule__DeploymentTechnology__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4157:1: ( ( ( rule__DeploymentTechnology__Group_8__0 )? ) )
            // InternalTechnologyDsl.g:4158:1: ( ( rule__DeploymentTechnology__Group_8__0 )? )
            {
            // InternalTechnologyDsl.g:4158:1: ( ( rule__DeploymentTechnology__Group_8__0 )? )
            // InternalTechnologyDsl.g:4159:2: ( rule__DeploymentTechnology__Group_8__0 )?
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getGroup_8()); 
            // InternalTechnologyDsl.g:4160:2: ( rule__DeploymentTechnology__Group_8__0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==36) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalTechnologyDsl.g:4160:3: rule__DeploymentTechnology__Group_8__0
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
    // InternalTechnologyDsl.g:4168:1: rule__DeploymentTechnology__Group__9 : rule__DeploymentTechnology__Group__9__Impl ;
    public final void rule__DeploymentTechnology__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4172:1: ( rule__DeploymentTechnology__Group__9__Impl )
            // InternalTechnologyDsl.g:4173:2: rule__DeploymentTechnology__Group__9__Impl
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
    // InternalTechnologyDsl.g:4179:1: rule__DeploymentTechnology__Group__9__Impl : ( '}' ) ;
    public final void rule__DeploymentTechnology__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4183:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:4184:1: ( '}' )
            {
            // InternalTechnologyDsl.g:4184:1: ( '}' )
            // InternalTechnologyDsl.g:4185:2: '}'
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getRightCurlyBracketKeyword_9()); 
            match(input,31,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:4195:1: rule__DeploymentTechnology__Group_6__0 : rule__DeploymentTechnology__Group_6__0__Impl rule__DeploymentTechnology__Group_6__1 ;
    public final void rule__DeploymentTechnology__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4199:1: ( rule__DeploymentTechnology__Group_6__0__Impl rule__DeploymentTechnology__Group_6__1 )
            // InternalTechnologyDsl.g:4200:2: rule__DeploymentTechnology__Group_6__0__Impl rule__DeploymentTechnology__Group_6__1
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
    // InternalTechnologyDsl.g:4207:1: rule__DeploymentTechnology__Group_6__0__Impl : ( ',' ) ;
    public final void rule__DeploymentTechnology__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4211:1: ( ( ',' ) )
            // InternalTechnologyDsl.g:4212:1: ( ',' )
            {
            // InternalTechnologyDsl.g:4212:1: ( ',' )
            // InternalTechnologyDsl.g:4213:2: ','
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
    // InternalTechnologyDsl.g:4222:1: rule__DeploymentTechnology__Group_6__1 : rule__DeploymentTechnology__Group_6__1__Impl ;
    public final void rule__DeploymentTechnology__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4226:1: ( rule__DeploymentTechnology__Group_6__1__Impl )
            // InternalTechnologyDsl.g:4227:2: rule__DeploymentTechnology__Group_6__1__Impl
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
    // InternalTechnologyDsl.g:4233:1: rule__DeploymentTechnology__Group_6__1__Impl : ( ( rule__DeploymentTechnology__OperationEnvironmentsAssignment_6_1 ) ) ;
    public final void rule__DeploymentTechnology__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4237:1: ( ( ( rule__DeploymentTechnology__OperationEnvironmentsAssignment_6_1 ) ) )
            // InternalTechnologyDsl.g:4238:1: ( ( rule__DeploymentTechnology__OperationEnvironmentsAssignment_6_1 ) )
            {
            // InternalTechnologyDsl.g:4238:1: ( ( rule__DeploymentTechnology__OperationEnvironmentsAssignment_6_1 ) )
            // InternalTechnologyDsl.g:4239:2: ( rule__DeploymentTechnology__OperationEnvironmentsAssignment_6_1 )
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getOperationEnvironmentsAssignment_6_1()); 
            // InternalTechnologyDsl.g:4240:2: ( rule__DeploymentTechnology__OperationEnvironmentsAssignment_6_1 )
            // InternalTechnologyDsl.g:4240:3: rule__DeploymentTechnology__OperationEnvironmentsAssignment_6_1
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
    // InternalTechnologyDsl.g:4249:1: rule__DeploymentTechnology__Group_8__0 : rule__DeploymentTechnology__Group_8__0__Impl rule__DeploymentTechnology__Group_8__1 ;
    public final void rule__DeploymentTechnology__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4253:1: ( rule__DeploymentTechnology__Group_8__0__Impl rule__DeploymentTechnology__Group_8__1 )
            // InternalTechnologyDsl.g:4254:2: rule__DeploymentTechnology__Group_8__0__Impl rule__DeploymentTechnology__Group_8__1
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
    // InternalTechnologyDsl.g:4261:1: rule__DeploymentTechnology__Group_8__0__Impl : ( 'service' ) ;
    public final void rule__DeploymentTechnology__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4265:1: ( ( 'service' ) )
            // InternalTechnologyDsl.g:4266:1: ( 'service' )
            {
            // InternalTechnologyDsl.g:4266:1: ( 'service' )
            // InternalTechnologyDsl.g:4267:2: 'service'
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
    // InternalTechnologyDsl.g:4276:1: rule__DeploymentTechnology__Group_8__1 : rule__DeploymentTechnology__Group_8__1__Impl rule__DeploymentTechnology__Group_8__2 ;
    public final void rule__DeploymentTechnology__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4280:1: ( rule__DeploymentTechnology__Group_8__1__Impl rule__DeploymentTechnology__Group_8__2 )
            // InternalTechnologyDsl.g:4281:2: rule__DeploymentTechnology__Group_8__1__Impl rule__DeploymentTechnology__Group_8__2
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
    // InternalTechnologyDsl.g:4288:1: rule__DeploymentTechnology__Group_8__1__Impl : ( 'properties' ) ;
    public final void rule__DeploymentTechnology__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4292:1: ( ( 'properties' ) )
            // InternalTechnologyDsl.g:4293:1: ( 'properties' )
            {
            // InternalTechnologyDsl.g:4293:1: ( 'properties' )
            // InternalTechnologyDsl.g:4294:2: 'properties'
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
    // InternalTechnologyDsl.g:4303:1: rule__DeploymentTechnology__Group_8__2 : rule__DeploymentTechnology__Group_8__2__Impl rule__DeploymentTechnology__Group_8__3 ;
    public final void rule__DeploymentTechnology__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4307:1: ( rule__DeploymentTechnology__Group_8__2__Impl rule__DeploymentTechnology__Group_8__3 )
            // InternalTechnologyDsl.g:4308:2: rule__DeploymentTechnology__Group_8__2__Impl rule__DeploymentTechnology__Group_8__3
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
    // InternalTechnologyDsl.g:4315:1: rule__DeploymentTechnology__Group_8__2__Impl : ( '{' ) ;
    public final void rule__DeploymentTechnology__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4319:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:4320:1: ( '{' )
            {
            // InternalTechnologyDsl.g:4320:1: ( '{' )
            // InternalTechnologyDsl.g:4321:2: '{'
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getLeftCurlyBracketKeyword_8_2()); 
            match(input,30,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:4330:1: rule__DeploymentTechnology__Group_8__3 : rule__DeploymentTechnology__Group_8__3__Impl rule__DeploymentTechnology__Group_8__4 ;
    public final void rule__DeploymentTechnology__Group_8__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4334:1: ( rule__DeploymentTechnology__Group_8__3__Impl rule__DeploymentTechnology__Group_8__4 )
            // InternalTechnologyDsl.g:4335:2: rule__DeploymentTechnology__Group_8__3__Impl rule__DeploymentTechnology__Group_8__4
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
    // InternalTechnologyDsl.g:4342:1: rule__DeploymentTechnology__Group_8__3__Impl : ( ( ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 ) ) ( ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 )* ) ) ;
    public final void rule__DeploymentTechnology__Group_8__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4346:1: ( ( ( ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 ) ) ( ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 )* ) ) )
            // InternalTechnologyDsl.g:4347:1: ( ( ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 ) ) ( ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 )* ) )
            {
            // InternalTechnologyDsl.g:4347:1: ( ( ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 ) ) ( ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 )* ) )
            // InternalTechnologyDsl.g:4348:2: ( ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 ) ) ( ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 )* )
            {
            // InternalTechnologyDsl.g:4348:2: ( ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 ) )
            // InternalTechnologyDsl.g:4349:3: ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 )
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getServicePropertiesAssignment_8_3()); 
            // InternalTechnologyDsl.g:4350:3: ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 )
            // InternalTechnologyDsl.g:4350:4: rule__DeploymentTechnology__ServicePropertiesAssignment_8_3
            {
            pushFollow(FOLLOW_45);
            rule__DeploymentTechnology__ServicePropertiesAssignment_8_3();

            state._fsp--;


            }

             after(grammarAccess.getDeploymentTechnologyAccess().getServicePropertiesAssignment_8_3()); 

            }

            // InternalTechnologyDsl.g:4353:2: ( ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 )* )
            // InternalTechnologyDsl.g:4354:3: ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 )*
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getServicePropertiesAssignment_8_3()); 
            // InternalTechnologyDsl.g:4355:3: ( rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( ((LA43_0>=68 && LA43_0<=77)) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalTechnologyDsl.g:4355:4: rule__DeploymentTechnology__ServicePropertiesAssignment_8_3
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
    // InternalTechnologyDsl.g:4364:1: rule__DeploymentTechnology__Group_8__4 : rule__DeploymentTechnology__Group_8__4__Impl ;
    public final void rule__DeploymentTechnology__Group_8__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4368:1: ( rule__DeploymentTechnology__Group_8__4__Impl )
            // InternalTechnologyDsl.g:4369:2: rule__DeploymentTechnology__Group_8__4__Impl
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
    // InternalTechnologyDsl.g:4375:1: rule__DeploymentTechnology__Group_8__4__Impl : ( '}' ) ;
    public final void rule__DeploymentTechnology__Group_8__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4379:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:4380:1: ( '}' )
            {
            // InternalTechnologyDsl.g:4380:1: ( '}' )
            // InternalTechnologyDsl.g:4381:2: '}'
            {
             before(grammarAccess.getDeploymentTechnologyAccess().getRightCurlyBracketKeyword_8_4()); 
            match(input,31,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:4391:1: rule__InfrastructureTechnology__Group__0 : rule__InfrastructureTechnology__Group__0__Impl rule__InfrastructureTechnology__Group__1 ;
    public final void rule__InfrastructureTechnology__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4395:1: ( rule__InfrastructureTechnology__Group__0__Impl rule__InfrastructureTechnology__Group__1 )
            // InternalTechnologyDsl.g:4396:2: rule__InfrastructureTechnology__Group__0__Impl rule__InfrastructureTechnology__Group__1
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
    // InternalTechnologyDsl.g:4403:1: rule__InfrastructureTechnology__Group__0__Impl : ( ( rule__InfrastructureTechnology__NameAssignment_0 ) ) ;
    public final void rule__InfrastructureTechnology__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4407:1: ( ( ( rule__InfrastructureTechnology__NameAssignment_0 ) ) )
            // InternalTechnologyDsl.g:4408:1: ( ( rule__InfrastructureTechnology__NameAssignment_0 ) )
            {
            // InternalTechnologyDsl.g:4408:1: ( ( rule__InfrastructureTechnology__NameAssignment_0 ) )
            // InternalTechnologyDsl.g:4409:2: ( rule__InfrastructureTechnology__NameAssignment_0 )
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getNameAssignment_0()); 
            // InternalTechnologyDsl.g:4410:2: ( rule__InfrastructureTechnology__NameAssignment_0 )
            // InternalTechnologyDsl.g:4410:3: rule__InfrastructureTechnology__NameAssignment_0
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
    // InternalTechnologyDsl.g:4418:1: rule__InfrastructureTechnology__Group__1 : rule__InfrastructureTechnology__Group__1__Impl rule__InfrastructureTechnology__Group__2 ;
    public final void rule__InfrastructureTechnology__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4422:1: ( rule__InfrastructureTechnology__Group__1__Impl rule__InfrastructureTechnology__Group__2 )
            // InternalTechnologyDsl.g:4423:2: rule__InfrastructureTechnology__Group__1__Impl rule__InfrastructureTechnology__Group__2
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
    // InternalTechnologyDsl.g:4430:1: rule__InfrastructureTechnology__Group__1__Impl : ( '{' ) ;
    public final void rule__InfrastructureTechnology__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4434:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:4435:1: ( '{' )
            {
            // InternalTechnologyDsl.g:4435:1: ( '{' )
            // InternalTechnologyDsl.g:4436:2: '{'
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,30,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:4445:1: rule__InfrastructureTechnology__Group__2 : rule__InfrastructureTechnology__Group__2__Impl rule__InfrastructureTechnology__Group__3 ;
    public final void rule__InfrastructureTechnology__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4449:1: ( rule__InfrastructureTechnology__Group__2__Impl rule__InfrastructureTechnology__Group__3 )
            // InternalTechnologyDsl.g:4450:2: rule__InfrastructureTechnology__Group__2__Impl rule__InfrastructureTechnology__Group__3
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
    // InternalTechnologyDsl.g:4457:1: rule__InfrastructureTechnology__Group__2__Impl : ( 'operation' ) ;
    public final void rule__InfrastructureTechnology__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4461:1: ( ( 'operation' ) )
            // InternalTechnologyDsl.g:4462:1: ( 'operation' )
            {
            // InternalTechnologyDsl.g:4462:1: ( 'operation' )
            // InternalTechnologyDsl.g:4463:2: 'operation'
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
    // InternalTechnologyDsl.g:4472:1: rule__InfrastructureTechnology__Group__3 : rule__InfrastructureTechnology__Group__3__Impl rule__InfrastructureTechnology__Group__4 ;
    public final void rule__InfrastructureTechnology__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4476:1: ( rule__InfrastructureTechnology__Group__3__Impl rule__InfrastructureTechnology__Group__4 )
            // InternalTechnologyDsl.g:4477:2: rule__InfrastructureTechnology__Group__3__Impl rule__InfrastructureTechnology__Group__4
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
    // InternalTechnologyDsl.g:4484:1: rule__InfrastructureTechnology__Group__3__Impl : ( 'environments' ) ;
    public final void rule__InfrastructureTechnology__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4488:1: ( ( 'environments' ) )
            // InternalTechnologyDsl.g:4489:1: ( 'environments' )
            {
            // InternalTechnologyDsl.g:4489:1: ( 'environments' )
            // InternalTechnologyDsl.g:4490:2: 'environments'
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
    // InternalTechnologyDsl.g:4499:1: rule__InfrastructureTechnology__Group__4 : rule__InfrastructureTechnology__Group__4__Impl rule__InfrastructureTechnology__Group__5 ;
    public final void rule__InfrastructureTechnology__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4503:1: ( rule__InfrastructureTechnology__Group__4__Impl rule__InfrastructureTechnology__Group__5 )
            // InternalTechnologyDsl.g:4504:2: rule__InfrastructureTechnology__Group__4__Impl rule__InfrastructureTechnology__Group__5
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
    // InternalTechnologyDsl.g:4511:1: rule__InfrastructureTechnology__Group__4__Impl : ( '=' ) ;
    public final void rule__InfrastructureTechnology__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4515:1: ( ( '=' ) )
            // InternalTechnologyDsl.g:4516:1: ( '=' )
            {
            // InternalTechnologyDsl.g:4516:1: ( '=' )
            // InternalTechnologyDsl.g:4517:2: '='
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
    // InternalTechnologyDsl.g:4526:1: rule__InfrastructureTechnology__Group__5 : rule__InfrastructureTechnology__Group__5__Impl rule__InfrastructureTechnology__Group__6 ;
    public final void rule__InfrastructureTechnology__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4530:1: ( rule__InfrastructureTechnology__Group__5__Impl rule__InfrastructureTechnology__Group__6 )
            // InternalTechnologyDsl.g:4531:2: rule__InfrastructureTechnology__Group__5__Impl rule__InfrastructureTechnology__Group__6
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
    // InternalTechnologyDsl.g:4538:1: rule__InfrastructureTechnology__Group__5__Impl : ( ( rule__InfrastructureTechnology__OperationEnvironmentsAssignment_5 ) ) ;
    public final void rule__InfrastructureTechnology__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4542:1: ( ( ( rule__InfrastructureTechnology__OperationEnvironmentsAssignment_5 ) ) )
            // InternalTechnologyDsl.g:4543:1: ( ( rule__InfrastructureTechnology__OperationEnvironmentsAssignment_5 ) )
            {
            // InternalTechnologyDsl.g:4543:1: ( ( rule__InfrastructureTechnology__OperationEnvironmentsAssignment_5 ) )
            // InternalTechnologyDsl.g:4544:2: ( rule__InfrastructureTechnology__OperationEnvironmentsAssignment_5 )
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getOperationEnvironmentsAssignment_5()); 
            // InternalTechnologyDsl.g:4545:2: ( rule__InfrastructureTechnology__OperationEnvironmentsAssignment_5 )
            // InternalTechnologyDsl.g:4545:3: rule__InfrastructureTechnology__OperationEnvironmentsAssignment_5
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
    // InternalTechnologyDsl.g:4553:1: rule__InfrastructureTechnology__Group__6 : rule__InfrastructureTechnology__Group__6__Impl rule__InfrastructureTechnology__Group__7 ;
    public final void rule__InfrastructureTechnology__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4557:1: ( rule__InfrastructureTechnology__Group__6__Impl rule__InfrastructureTechnology__Group__7 )
            // InternalTechnologyDsl.g:4558:2: rule__InfrastructureTechnology__Group__6__Impl rule__InfrastructureTechnology__Group__7
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
    // InternalTechnologyDsl.g:4565:1: rule__InfrastructureTechnology__Group__6__Impl : ( ( rule__InfrastructureTechnology__Group_6__0 )* ) ;
    public final void rule__InfrastructureTechnology__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4569:1: ( ( ( rule__InfrastructureTechnology__Group_6__0 )* ) )
            // InternalTechnologyDsl.g:4570:1: ( ( rule__InfrastructureTechnology__Group_6__0 )* )
            {
            // InternalTechnologyDsl.g:4570:1: ( ( rule__InfrastructureTechnology__Group_6__0 )* )
            // InternalTechnologyDsl.g:4571:2: ( rule__InfrastructureTechnology__Group_6__0 )*
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getGroup_6()); 
            // InternalTechnologyDsl.g:4572:2: ( rule__InfrastructureTechnology__Group_6__0 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==46) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalTechnologyDsl.g:4572:3: rule__InfrastructureTechnology__Group_6__0
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
    // InternalTechnologyDsl.g:4580:1: rule__InfrastructureTechnology__Group__7 : rule__InfrastructureTechnology__Group__7__Impl rule__InfrastructureTechnology__Group__8 ;
    public final void rule__InfrastructureTechnology__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4584:1: ( rule__InfrastructureTechnology__Group__7__Impl rule__InfrastructureTechnology__Group__8 )
            // InternalTechnologyDsl.g:4585:2: rule__InfrastructureTechnology__Group__7__Impl rule__InfrastructureTechnology__Group__8
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
    // InternalTechnologyDsl.g:4592:1: rule__InfrastructureTechnology__Group__7__Impl : ( ';' ) ;
    public final void rule__InfrastructureTechnology__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4596:1: ( ( ';' ) )
            // InternalTechnologyDsl.g:4597:1: ( ';' )
            {
            // InternalTechnologyDsl.g:4597:1: ( ';' )
            // InternalTechnologyDsl.g:4598:2: ';'
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
    // InternalTechnologyDsl.g:4607:1: rule__InfrastructureTechnology__Group__8 : rule__InfrastructureTechnology__Group__8__Impl rule__InfrastructureTechnology__Group__9 ;
    public final void rule__InfrastructureTechnology__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4611:1: ( rule__InfrastructureTechnology__Group__8__Impl rule__InfrastructureTechnology__Group__9 )
            // InternalTechnologyDsl.g:4612:2: rule__InfrastructureTechnology__Group__8__Impl rule__InfrastructureTechnology__Group__9
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
    // InternalTechnologyDsl.g:4619:1: rule__InfrastructureTechnology__Group__8__Impl : ( ( rule__InfrastructureTechnology__Group_8__0 )? ) ;
    public final void rule__InfrastructureTechnology__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4623:1: ( ( ( rule__InfrastructureTechnology__Group_8__0 )? ) )
            // InternalTechnologyDsl.g:4624:1: ( ( rule__InfrastructureTechnology__Group_8__0 )? )
            {
            // InternalTechnologyDsl.g:4624:1: ( ( rule__InfrastructureTechnology__Group_8__0 )? )
            // InternalTechnologyDsl.g:4625:2: ( rule__InfrastructureTechnology__Group_8__0 )?
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getGroup_8()); 
            // InternalTechnologyDsl.g:4626:2: ( rule__InfrastructureTechnology__Group_8__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==36) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalTechnologyDsl.g:4626:3: rule__InfrastructureTechnology__Group_8__0
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
    // InternalTechnologyDsl.g:4634:1: rule__InfrastructureTechnology__Group__9 : rule__InfrastructureTechnology__Group__9__Impl ;
    public final void rule__InfrastructureTechnology__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4638:1: ( rule__InfrastructureTechnology__Group__9__Impl )
            // InternalTechnologyDsl.g:4639:2: rule__InfrastructureTechnology__Group__9__Impl
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
    // InternalTechnologyDsl.g:4645:1: rule__InfrastructureTechnology__Group__9__Impl : ( '}' ) ;
    public final void rule__InfrastructureTechnology__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4649:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:4650:1: ( '}' )
            {
            // InternalTechnologyDsl.g:4650:1: ( '}' )
            // InternalTechnologyDsl.g:4651:2: '}'
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getRightCurlyBracketKeyword_9()); 
            match(input,31,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:4661:1: rule__InfrastructureTechnology__Group_6__0 : rule__InfrastructureTechnology__Group_6__0__Impl rule__InfrastructureTechnology__Group_6__1 ;
    public final void rule__InfrastructureTechnology__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4665:1: ( rule__InfrastructureTechnology__Group_6__0__Impl rule__InfrastructureTechnology__Group_6__1 )
            // InternalTechnologyDsl.g:4666:2: rule__InfrastructureTechnology__Group_6__0__Impl rule__InfrastructureTechnology__Group_6__1
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
    // InternalTechnologyDsl.g:4673:1: rule__InfrastructureTechnology__Group_6__0__Impl : ( ',' ) ;
    public final void rule__InfrastructureTechnology__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4677:1: ( ( ',' ) )
            // InternalTechnologyDsl.g:4678:1: ( ',' )
            {
            // InternalTechnologyDsl.g:4678:1: ( ',' )
            // InternalTechnologyDsl.g:4679:2: ','
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
    // InternalTechnologyDsl.g:4688:1: rule__InfrastructureTechnology__Group_6__1 : rule__InfrastructureTechnology__Group_6__1__Impl ;
    public final void rule__InfrastructureTechnology__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4692:1: ( rule__InfrastructureTechnology__Group_6__1__Impl )
            // InternalTechnologyDsl.g:4693:2: rule__InfrastructureTechnology__Group_6__1__Impl
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
    // InternalTechnologyDsl.g:4699:1: rule__InfrastructureTechnology__Group_6__1__Impl : ( ( rule__InfrastructureTechnology__OperationEnvironmentsAssignment_6_1 ) ) ;
    public final void rule__InfrastructureTechnology__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4703:1: ( ( ( rule__InfrastructureTechnology__OperationEnvironmentsAssignment_6_1 ) ) )
            // InternalTechnologyDsl.g:4704:1: ( ( rule__InfrastructureTechnology__OperationEnvironmentsAssignment_6_1 ) )
            {
            // InternalTechnologyDsl.g:4704:1: ( ( rule__InfrastructureTechnology__OperationEnvironmentsAssignment_6_1 ) )
            // InternalTechnologyDsl.g:4705:2: ( rule__InfrastructureTechnology__OperationEnvironmentsAssignment_6_1 )
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getOperationEnvironmentsAssignment_6_1()); 
            // InternalTechnologyDsl.g:4706:2: ( rule__InfrastructureTechnology__OperationEnvironmentsAssignment_6_1 )
            // InternalTechnologyDsl.g:4706:3: rule__InfrastructureTechnology__OperationEnvironmentsAssignment_6_1
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
    // InternalTechnologyDsl.g:4715:1: rule__InfrastructureTechnology__Group_8__0 : rule__InfrastructureTechnology__Group_8__0__Impl rule__InfrastructureTechnology__Group_8__1 ;
    public final void rule__InfrastructureTechnology__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4719:1: ( rule__InfrastructureTechnology__Group_8__0__Impl rule__InfrastructureTechnology__Group_8__1 )
            // InternalTechnologyDsl.g:4720:2: rule__InfrastructureTechnology__Group_8__0__Impl rule__InfrastructureTechnology__Group_8__1
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
    // InternalTechnologyDsl.g:4727:1: rule__InfrastructureTechnology__Group_8__0__Impl : ( 'service' ) ;
    public final void rule__InfrastructureTechnology__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4731:1: ( ( 'service' ) )
            // InternalTechnologyDsl.g:4732:1: ( 'service' )
            {
            // InternalTechnologyDsl.g:4732:1: ( 'service' )
            // InternalTechnologyDsl.g:4733:2: 'service'
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
    // InternalTechnologyDsl.g:4742:1: rule__InfrastructureTechnology__Group_8__1 : rule__InfrastructureTechnology__Group_8__1__Impl rule__InfrastructureTechnology__Group_8__2 ;
    public final void rule__InfrastructureTechnology__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4746:1: ( rule__InfrastructureTechnology__Group_8__1__Impl rule__InfrastructureTechnology__Group_8__2 )
            // InternalTechnologyDsl.g:4747:2: rule__InfrastructureTechnology__Group_8__1__Impl rule__InfrastructureTechnology__Group_8__2
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
    // InternalTechnologyDsl.g:4754:1: rule__InfrastructureTechnology__Group_8__1__Impl : ( 'properties' ) ;
    public final void rule__InfrastructureTechnology__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4758:1: ( ( 'properties' ) )
            // InternalTechnologyDsl.g:4759:1: ( 'properties' )
            {
            // InternalTechnologyDsl.g:4759:1: ( 'properties' )
            // InternalTechnologyDsl.g:4760:2: 'properties'
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
    // InternalTechnologyDsl.g:4769:1: rule__InfrastructureTechnology__Group_8__2 : rule__InfrastructureTechnology__Group_8__2__Impl rule__InfrastructureTechnology__Group_8__3 ;
    public final void rule__InfrastructureTechnology__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4773:1: ( rule__InfrastructureTechnology__Group_8__2__Impl rule__InfrastructureTechnology__Group_8__3 )
            // InternalTechnologyDsl.g:4774:2: rule__InfrastructureTechnology__Group_8__2__Impl rule__InfrastructureTechnology__Group_8__3
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
    // InternalTechnologyDsl.g:4781:1: rule__InfrastructureTechnology__Group_8__2__Impl : ( '{' ) ;
    public final void rule__InfrastructureTechnology__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4785:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:4786:1: ( '{' )
            {
            // InternalTechnologyDsl.g:4786:1: ( '{' )
            // InternalTechnologyDsl.g:4787:2: '{'
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getLeftCurlyBracketKeyword_8_2()); 
            match(input,30,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:4796:1: rule__InfrastructureTechnology__Group_8__3 : rule__InfrastructureTechnology__Group_8__3__Impl rule__InfrastructureTechnology__Group_8__4 ;
    public final void rule__InfrastructureTechnology__Group_8__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4800:1: ( rule__InfrastructureTechnology__Group_8__3__Impl rule__InfrastructureTechnology__Group_8__4 )
            // InternalTechnologyDsl.g:4801:2: rule__InfrastructureTechnology__Group_8__3__Impl rule__InfrastructureTechnology__Group_8__4
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
    // InternalTechnologyDsl.g:4808:1: rule__InfrastructureTechnology__Group_8__3__Impl : ( ( ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 ) ) ( ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 )* ) ) ;
    public final void rule__InfrastructureTechnology__Group_8__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4812:1: ( ( ( ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 ) ) ( ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 )* ) ) )
            // InternalTechnologyDsl.g:4813:1: ( ( ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 ) ) ( ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 )* ) )
            {
            // InternalTechnologyDsl.g:4813:1: ( ( ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 ) ) ( ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 )* ) )
            // InternalTechnologyDsl.g:4814:2: ( ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 ) ) ( ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 )* )
            {
            // InternalTechnologyDsl.g:4814:2: ( ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 ) )
            // InternalTechnologyDsl.g:4815:3: ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 )
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getServicePropertiesAssignment_8_3()); 
            // InternalTechnologyDsl.g:4816:3: ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 )
            // InternalTechnologyDsl.g:4816:4: rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3
            {
            pushFollow(FOLLOW_45);
            rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3();

            state._fsp--;


            }

             after(grammarAccess.getInfrastructureTechnologyAccess().getServicePropertiesAssignment_8_3()); 

            }

            // InternalTechnologyDsl.g:4819:2: ( ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 )* )
            // InternalTechnologyDsl.g:4820:3: ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 )*
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getServicePropertiesAssignment_8_3()); 
            // InternalTechnologyDsl.g:4821:3: ( rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( ((LA46_0>=68 && LA46_0<=77)) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalTechnologyDsl.g:4821:4: rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3
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
    // InternalTechnologyDsl.g:4830:1: rule__InfrastructureTechnology__Group_8__4 : rule__InfrastructureTechnology__Group_8__4__Impl ;
    public final void rule__InfrastructureTechnology__Group_8__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4834:1: ( rule__InfrastructureTechnology__Group_8__4__Impl )
            // InternalTechnologyDsl.g:4835:2: rule__InfrastructureTechnology__Group_8__4__Impl
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
    // InternalTechnologyDsl.g:4841:1: rule__InfrastructureTechnology__Group_8__4__Impl : ( '}' ) ;
    public final void rule__InfrastructureTechnology__Group_8__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4845:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:4846:1: ( '}' )
            {
            // InternalTechnologyDsl.g:4846:1: ( '}' )
            // InternalTechnologyDsl.g:4847:2: '}'
            {
             before(grammarAccess.getInfrastructureTechnologyAccess().getRightCurlyBracketKeyword_8_4()); 
            match(input,31,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:4857:1: rule__OperationEnvironment__Group__0 : rule__OperationEnvironment__Group__0__Impl rule__OperationEnvironment__Group__1 ;
    public final void rule__OperationEnvironment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4861:1: ( rule__OperationEnvironment__Group__0__Impl rule__OperationEnvironment__Group__1 )
            // InternalTechnologyDsl.g:4862:2: rule__OperationEnvironment__Group__0__Impl rule__OperationEnvironment__Group__1
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
    // InternalTechnologyDsl.g:4869:1: rule__OperationEnvironment__Group__0__Impl : ( ( rule__OperationEnvironment__EnvironmentNameAssignment_0 ) ) ;
    public final void rule__OperationEnvironment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4873:1: ( ( ( rule__OperationEnvironment__EnvironmentNameAssignment_0 ) ) )
            // InternalTechnologyDsl.g:4874:1: ( ( rule__OperationEnvironment__EnvironmentNameAssignment_0 ) )
            {
            // InternalTechnologyDsl.g:4874:1: ( ( rule__OperationEnvironment__EnvironmentNameAssignment_0 ) )
            // InternalTechnologyDsl.g:4875:2: ( rule__OperationEnvironment__EnvironmentNameAssignment_0 )
            {
             before(grammarAccess.getOperationEnvironmentAccess().getEnvironmentNameAssignment_0()); 
            // InternalTechnologyDsl.g:4876:2: ( rule__OperationEnvironment__EnvironmentNameAssignment_0 )
            // InternalTechnologyDsl.g:4876:3: rule__OperationEnvironment__EnvironmentNameAssignment_0
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
    // InternalTechnologyDsl.g:4884:1: rule__OperationEnvironment__Group__1 : rule__OperationEnvironment__Group__1__Impl ;
    public final void rule__OperationEnvironment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4888:1: ( rule__OperationEnvironment__Group__1__Impl )
            // InternalTechnologyDsl.g:4889:2: rule__OperationEnvironment__Group__1__Impl
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
    // InternalTechnologyDsl.g:4895:1: rule__OperationEnvironment__Group__1__Impl : ( ( rule__OperationEnvironment__DefaultAssignment_1 )? ) ;
    public final void rule__OperationEnvironment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4899:1: ( ( ( rule__OperationEnvironment__DefaultAssignment_1 )? ) )
            // InternalTechnologyDsl.g:4900:1: ( ( rule__OperationEnvironment__DefaultAssignment_1 )? )
            {
            // InternalTechnologyDsl.g:4900:1: ( ( rule__OperationEnvironment__DefaultAssignment_1 )? )
            // InternalTechnologyDsl.g:4901:2: ( rule__OperationEnvironment__DefaultAssignment_1 )?
            {
             before(grammarAccess.getOperationEnvironmentAccess().getDefaultAssignment_1()); 
            // InternalTechnologyDsl.g:4902:2: ( rule__OperationEnvironment__DefaultAssignment_1 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==79) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalTechnologyDsl.g:4902:3: rule__OperationEnvironment__DefaultAssignment_1
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
    // InternalTechnologyDsl.g:4911:1: rule__TechnologySpecificProperty__Group__0 : rule__TechnologySpecificProperty__Group__0__Impl rule__TechnologySpecificProperty__Group__1 ;
    public final void rule__TechnologySpecificProperty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4915:1: ( rule__TechnologySpecificProperty__Group__0__Impl rule__TechnologySpecificProperty__Group__1 )
            // InternalTechnologyDsl.g:4916:2: rule__TechnologySpecificProperty__Group__0__Impl rule__TechnologySpecificProperty__Group__1
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
    // InternalTechnologyDsl.g:4923:1: rule__TechnologySpecificProperty__Group__0__Impl : ( ( rule__TechnologySpecificProperty__TypeAssignment_0 ) ) ;
    public final void rule__TechnologySpecificProperty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4927:1: ( ( ( rule__TechnologySpecificProperty__TypeAssignment_0 ) ) )
            // InternalTechnologyDsl.g:4928:1: ( ( rule__TechnologySpecificProperty__TypeAssignment_0 ) )
            {
            // InternalTechnologyDsl.g:4928:1: ( ( rule__TechnologySpecificProperty__TypeAssignment_0 ) )
            // InternalTechnologyDsl.g:4929:2: ( rule__TechnologySpecificProperty__TypeAssignment_0 )
            {
             before(grammarAccess.getTechnologySpecificPropertyAccess().getTypeAssignment_0()); 
            // InternalTechnologyDsl.g:4930:2: ( rule__TechnologySpecificProperty__TypeAssignment_0 )
            // InternalTechnologyDsl.g:4930:3: rule__TechnologySpecificProperty__TypeAssignment_0
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
    // InternalTechnologyDsl.g:4938:1: rule__TechnologySpecificProperty__Group__1 : rule__TechnologySpecificProperty__Group__1__Impl rule__TechnologySpecificProperty__Group__2 ;
    public final void rule__TechnologySpecificProperty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4942:1: ( rule__TechnologySpecificProperty__Group__1__Impl rule__TechnologySpecificProperty__Group__2 )
            // InternalTechnologyDsl.g:4943:2: rule__TechnologySpecificProperty__Group__1__Impl rule__TechnologySpecificProperty__Group__2
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
    // InternalTechnologyDsl.g:4950:1: rule__TechnologySpecificProperty__Group__1__Impl : ( ( rule__TechnologySpecificProperty__NameAssignment_1 ) ) ;
    public final void rule__TechnologySpecificProperty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4954:1: ( ( ( rule__TechnologySpecificProperty__NameAssignment_1 ) ) )
            // InternalTechnologyDsl.g:4955:1: ( ( rule__TechnologySpecificProperty__NameAssignment_1 ) )
            {
            // InternalTechnologyDsl.g:4955:1: ( ( rule__TechnologySpecificProperty__NameAssignment_1 ) )
            // InternalTechnologyDsl.g:4956:2: ( rule__TechnologySpecificProperty__NameAssignment_1 )
            {
             before(grammarAccess.getTechnologySpecificPropertyAccess().getNameAssignment_1()); 
            // InternalTechnologyDsl.g:4957:2: ( rule__TechnologySpecificProperty__NameAssignment_1 )
            // InternalTechnologyDsl.g:4957:3: rule__TechnologySpecificProperty__NameAssignment_1
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
    // InternalTechnologyDsl.g:4965:1: rule__TechnologySpecificProperty__Group__2 : rule__TechnologySpecificProperty__Group__2__Impl rule__TechnologySpecificProperty__Group__3 ;
    public final void rule__TechnologySpecificProperty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4969:1: ( rule__TechnologySpecificProperty__Group__2__Impl rule__TechnologySpecificProperty__Group__3 )
            // InternalTechnologyDsl.g:4970:2: rule__TechnologySpecificProperty__Group__2__Impl rule__TechnologySpecificProperty__Group__3
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
    // InternalTechnologyDsl.g:4977:1: rule__TechnologySpecificProperty__Group__2__Impl : ( ( rule__TechnologySpecificProperty__Alternatives_2 )? ) ;
    public final void rule__TechnologySpecificProperty__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4981:1: ( ( ( rule__TechnologySpecificProperty__Alternatives_2 )? ) )
            // InternalTechnologyDsl.g:4982:1: ( ( rule__TechnologySpecificProperty__Alternatives_2 )? )
            {
            // InternalTechnologyDsl.g:4982:1: ( ( rule__TechnologySpecificProperty__Alternatives_2 )? )
            // InternalTechnologyDsl.g:4983:2: ( rule__TechnologySpecificProperty__Alternatives_2 )?
            {
             before(grammarAccess.getTechnologySpecificPropertyAccess().getAlternatives_2()); 
            // InternalTechnologyDsl.g:4984:2: ( rule__TechnologySpecificProperty__Alternatives_2 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==57||LA48_0==80) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalTechnologyDsl.g:4984:3: rule__TechnologySpecificProperty__Alternatives_2
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
    // InternalTechnologyDsl.g:4992:1: rule__TechnologySpecificProperty__Group__3 : rule__TechnologySpecificProperty__Group__3__Impl ;
    public final void rule__TechnologySpecificProperty__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:4996:1: ( rule__TechnologySpecificProperty__Group__3__Impl )
            // InternalTechnologyDsl.g:4997:2: rule__TechnologySpecificProperty__Group__3__Impl
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
    // InternalTechnologyDsl.g:5003:1: rule__TechnologySpecificProperty__Group__3__Impl : ( ';' ) ;
    public final void rule__TechnologySpecificProperty__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5007:1: ( ( ';' ) )
            // InternalTechnologyDsl.g:5008:1: ( ';' )
            {
            // InternalTechnologyDsl.g:5008:1: ( ';' )
            // InternalTechnologyDsl.g:5009:2: ';'
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
    // InternalTechnologyDsl.g:5019:1: rule__TechnologySpecificProperty__Group_2_0__0 : rule__TechnologySpecificProperty__Group_2_0__0__Impl rule__TechnologySpecificProperty__Group_2_0__1 ;
    public final void rule__TechnologySpecificProperty__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5023:1: ( rule__TechnologySpecificProperty__Group_2_0__0__Impl rule__TechnologySpecificProperty__Group_2_0__1 )
            // InternalTechnologyDsl.g:5024:2: rule__TechnologySpecificProperty__Group_2_0__0__Impl rule__TechnologySpecificProperty__Group_2_0__1
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
    // InternalTechnologyDsl.g:5031:1: rule__TechnologySpecificProperty__Group_2_0__0__Impl : ( '=' ) ;
    public final void rule__TechnologySpecificProperty__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5035:1: ( ( '=' ) )
            // InternalTechnologyDsl.g:5036:1: ( '=' )
            {
            // InternalTechnologyDsl.g:5036:1: ( '=' )
            // InternalTechnologyDsl.g:5037:2: '='
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
    // InternalTechnologyDsl.g:5046:1: rule__TechnologySpecificProperty__Group_2_0__1 : rule__TechnologySpecificProperty__Group_2_0__1__Impl ;
    public final void rule__TechnologySpecificProperty__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5050:1: ( rule__TechnologySpecificProperty__Group_2_0__1__Impl )
            // InternalTechnologyDsl.g:5051:2: rule__TechnologySpecificProperty__Group_2_0__1__Impl
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
    // InternalTechnologyDsl.g:5057:1: rule__TechnologySpecificProperty__Group_2_0__1__Impl : ( ( rule__TechnologySpecificProperty__DefaultValueAssignment_2_0_1 ) ) ;
    public final void rule__TechnologySpecificProperty__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5061:1: ( ( ( rule__TechnologySpecificProperty__DefaultValueAssignment_2_0_1 ) ) )
            // InternalTechnologyDsl.g:5062:1: ( ( rule__TechnologySpecificProperty__DefaultValueAssignment_2_0_1 ) )
            {
            // InternalTechnologyDsl.g:5062:1: ( ( rule__TechnologySpecificProperty__DefaultValueAssignment_2_0_1 ) )
            // InternalTechnologyDsl.g:5063:2: ( rule__TechnologySpecificProperty__DefaultValueAssignment_2_0_1 )
            {
             before(grammarAccess.getTechnologySpecificPropertyAccess().getDefaultValueAssignment_2_0_1()); 
            // InternalTechnologyDsl.g:5064:2: ( rule__TechnologySpecificProperty__DefaultValueAssignment_2_0_1 )
            // InternalTechnologyDsl.g:5064:3: rule__TechnologySpecificProperty__DefaultValueAssignment_2_0_1
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
    // InternalTechnologyDsl.g:5073:1: rule__ServiceAspectPointcut__Group_0__0 : rule__ServiceAspectPointcut__Group_0__0__Impl rule__ServiceAspectPointcut__Group_0__1 ;
    public final void rule__ServiceAspectPointcut__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5077:1: ( rule__ServiceAspectPointcut__Group_0__0__Impl rule__ServiceAspectPointcut__Group_0__1 )
            // InternalTechnologyDsl.g:5078:2: rule__ServiceAspectPointcut__Group_0__0__Impl rule__ServiceAspectPointcut__Group_0__1
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
    // InternalTechnologyDsl.g:5085:1: rule__ServiceAspectPointcut__Group_0__0__Impl : ( ( rule__ServiceAspectPointcut__ForExchangePatternAssignment_0_0 ) ) ;
    public final void rule__ServiceAspectPointcut__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5089:1: ( ( ( rule__ServiceAspectPointcut__ForExchangePatternAssignment_0_0 ) ) )
            // InternalTechnologyDsl.g:5090:1: ( ( rule__ServiceAspectPointcut__ForExchangePatternAssignment_0_0 ) )
            {
            // InternalTechnologyDsl.g:5090:1: ( ( rule__ServiceAspectPointcut__ForExchangePatternAssignment_0_0 ) )
            // InternalTechnologyDsl.g:5091:2: ( rule__ServiceAspectPointcut__ForExchangePatternAssignment_0_0 )
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getForExchangePatternAssignment_0_0()); 
            // InternalTechnologyDsl.g:5092:2: ( rule__ServiceAspectPointcut__ForExchangePatternAssignment_0_0 )
            // InternalTechnologyDsl.g:5092:3: rule__ServiceAspectPointcut__ForExchangePatternAssignment_0_0
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
    // InternalTechnologyDsl.g:5100:1: rule__ServiceAspectPointcut__Group_0__1 : rule__ServiceAspectPointcut__Group_0__1__Impl rule__ServiceAspectPointcut__Group_0__2 ;
    public final void rule__ServiceAspectPointcut__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5104:1: ( rule__ServiceAspectPointcut__Group_0__1__Impl rule__ServiceAspectPointcut__Group_0__2 )
            // InternalTechnologyDsl.g:5105:2: rule__ServiceAspectPointcut__Group_0__1__Impl rule__ServiceAspectPointcut__Group_0__2
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
    // InternalTechnologyDsl.g:5112:1: rule__ServiceAspectPointcut__Group_0__1__Impl : ( '=' ) ;
    public final void rule__ServiceAspectPointcut__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5116:1: ( ( '=' ) )
            // InternalTechnologyDsl.g:5117:1: ( '=' )
            {
            // InternalTechnologyDsl.g:5117:1: ( '=' )
            // InternalTechnologyDsl.g:5118:2: '='
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
    // InternalTechnologyDsl.g:5127:1: rule__ServiceAspectPointcut__Group_0__2 : rule__ServiceAspectPointcut__Group_0__2__Impl ;
    public final void rule__ServiceAspectPointcut__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5131:1: ( rule__ServiceAspectPointcut__Group_0__2__Impl )
            // InternalTechnologyDsl.g:5132:2: rule__ServiceAspectPointcut__Group_0__2__Impl
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
    // InternalTechnologyDsl.g:5138:1: rule__ServiceAspectPointcut__Group_0__2__Impl : ( ( rule__ServiceAspectPointcut__ExchangePatternAssignment_0_2 ) ) ;
    public final void rule__ServiceAspectPointcut__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5142:1: ( ( ( rule__ServiceAspectPointcut__ExchangePatternAssignment_0_2 ) ) )
            // InternalTechnologyDsl.g:5143:1: ( ( rule__ServiceAspectPointcut__ExchangePatternAssignment_0_2 ) )
            {
            // InternalTechnologyDsl.g:5143:1: ( ( rule__ServiceAspectPointcut__ExchangePatternAssignment_0_2 ) )
            // InternalTechnologyDsl.g:5144:2: ( rule__ServiceAspectPointcut__ExchangePatternAssignment_0_2 )
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getExchangePatternAssignment_0_2()); 
            // InternalTechnologyDsl.g:5145:2: ( rule__ServiceAspectPointcut__ExchangePatternAssignment_0_2 )
            // InternalTechnologyDsl.g:5145:3: rule__ServiceAspectPointcut__ExchangePatternAssignment_0_2
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
    // InternalTechnologyDsl.g:5154:1: rule__ServiceAspectPointcut__Group_1__0 : rule__ServiceAspectPointcut__Group_1__0__Impl rule__ServiceAspectPointcut__Group_1__1 ;
    public final void rule__ServiceAspectPointcut__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5158:1: ( rule__ServiceAspectPointcut__Group_1__0__Impl rule__ServiceAspectPointcut__Group_1__1 )
            // InternalTechnologyDsl.g:5159:2: rule__ServiceAspectPointcut__Group_1__0__Impl rule__ServiceAspectPointcut__Group_1__1
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
    // InternalTechnologyDsl.g:5166:1: rule__ServiceAspectPointcut__Group_1__0__Impl : ( ( rule__ServiceAspectPointcut__ForCommunicationTypeAssignment_1_0 ) ) ;
    public final void rule__ServiceAspectPointcut__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5170:1: ( ( ( rule__ServiceAspectPointcut__ForCommunicationTypeAssignment_1_0 ) ) )
            // InternalTechnologyDsl.g:5171:1: ( ( rule__ServiceAspectPointcut__ForCommunicationTypeAssignment_1_0 ) )
            {
            // InternalTechnologyDsl.g:5171:1: ( ( rule__ServiceAspectPointcut__ForCommunicationTypeAssignment_1_0 ) )
            // InternalTechnologyDsl.g:5172:2: ( rule__ServiceAspectPointcut__ForCommunicationTypeAssignment_1_0 )
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getForCommunicationTypeAssignment_1_0()); 
            // InternalTechnologyDsl.g:5173:2: ( rule__ServiceAspectPointcut__ForCommunicationTypeAssignment_1_0 )
            // InternalTechnologyDsl.g:5173:3: rule__ServiceAspectPointcut__ForCommunicationTypeAssignment_1_0
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
    // InternalTechnologyDsl.g:5181:1: rule__ServiceAspectPointcut__Group_1__1 : rule__ServiceAspectPointcut__Group_1__1__Impl rule__ServiceAspectPointcut__Group_1__2 ;
    public final void rule__ServiceAspectPointcut__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5185:1: ( rule__ServiceAspectPointcut__Group_1__1__Impl rule__ServiceAspectPointcut__Group_1__2 )
            // InternalTechnologyDsl.g:5186:2: rule__ServiceAspectPointcut__Group_1__1__Impl rule__ServiceAspectPointcut__Group_1__2
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
    // InternalTechnologyDsl.g:5193:1: rule__ServiceAspectPointcut__Group_1__1__Impl : ( '=' ) ;
    public final void rule__ServiceAspectPointcut__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5197:1: ( ( '=' ) )
            // InternalTechnologyDsl.g:5198:1: ( '=' )
            {
            // InternalTechnologyDsl.g:5198:1: ( '=' )
            // InternalTechnologyDsl.g:5199:2: '='
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
    // InternalTechnologyDsl.g:5208:1: rule__ServiceAspectPointcut__Group_1__2 : rule__ServiceAspectPointcut__Group_1__2__Impl ;
    public final void rule__ServiceAspectPointcut__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5212:1: ( rule__ServiceAspectPointcut__Group_1__2__Impl )
            // InternalTechnologyDsl.g:5213:2: rule__ServiceAspectPointcut__Group_1__2__Impl
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
    // InternalTechnologyDsl.g:5219:1: rule__ServiceAspectPointcut__Group_1__2__Impl : ( ( rule__ServiceAspectPointcut__CommunicationTypeAssignment_1_2 ) ) ;
    public final void rule__ServiceAspectPointcut__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5223:1: ( ( ( rule__ServiceAspectPointcut__CommunicationTypeAssignment_1_2 ) ) )
            // InternalTechnologyDsl.g:5224:1: ( ( rule__ServiceAspectPointcut__CommunicationTypeAssignment_1_2 ) )
            {
            // InternalTechnologyDsl.g:5224:1: ( ( rule__ServiceAspectPointcut__CommunicationTypeAssignment_1_2 ) )
            // InternalTechnologyDsl.g:5225:2: ( rule__ServiceAspectPointcut__CommunicationTypeAssignment_1_2 )
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getCommunicationTypeAssignment_1_2()); 
            // InternalTechnologyDsl.g:5226:2: ( rule__ServiceAspectPointcut__CommunicationTypeAssignment_1_2 )
            // InternalTechnologyDsl.g:5226:3: rule__ServiceAspectPointcut__CommunicationTypeAssignment_1_2
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
    // InternalTechnologyDsl.g:5235:1: rule__ServiceAspectPointcut__Group_2__0 : rule__ServiceAspectPointcut__Group_2__0__Impl rule__ServiceAspectPointcut__Group_2__1 ;
    public final void rule__ServiceAspectPointcut__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5239:1: ( rule__ServiceAspectPointcut__Group_2__0__Impl rule__ServiceAspectPointcut__Group_2__1 )
            // InternalTechnologyDsl.g:5240:2: rule__ServiceAspectPointcut__Group_2__0__Impl rule__ServiceAspectPointcut__Group_2__1
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
    // InternalTechnologyDsl.g:5247:1: rule__ServiceAspectPointcut__Group_2__0__Impl : ( ( rule__ServiceAspectPointcut__ForProtocolAssignment_2_0 ) ) ;
    public final void rule__ServiceAspectPointcut__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5251:1: ( ( ( rule__ServiceAspectPointcut__ForProtocolAssignment_2_0 ) ) )
            // InternalTechnologyDsl.g:5252:1: ( ( rule__ServiceAspectPointcut__ForProtocolAssignment_2_0 ) )
            {
            // InternalTechnologyDsl.g:5252:1: ( ( rule__ServiceAspectPointcut__ForProtocolAssignment_2_0 ) )
            // InternalTechnologyDsl.g:5253:2: ( rule__ServiceAspectPointcut__ForProtocolAssignment_2_0 )
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getForProtocolAssignment_2_0()); 
            // InternalTechnologyDsl.g:5254:2: ( rule__ServiceAspectPointcut__ForProtocolAssignment_2_0 )
            // InternalTechnologyDsl.g:5254:3: rule__ServiceAspectPointcut__ForProtocolAssignment_2_0
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
    // InternalTechnologyDsl.g:5262:1: rule__ServiceAspectPointcut__Group_2__1 : rule__ServiceAspectPointcut__Group_2__1__Impl rule__ServiceAspectPointcut__Group_2__2 ;
    public final void rule__ServiceAspectPointcut__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5266:1: ( rule__ServiceAspectPointcut__Group_2__1__Impl rule__ServiceAspectPointcut__Group_2__2 )
            // InternalTechnologyDsl.g:5267:2: rule__ServiceAspectPointcut__Group_2__1__Impl rule__ServiceAspectPointcut__Group_2__2
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
    // InternalTechnologyDsl.g:5274:1: rule__ServiceAspectPointcut__Group_2__1__Impl : ( '=' ) ;
    public final void rule__ServiceAspectPointcut__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5278:1: ( ( '=' ) )
            // InternalTechnologyDsl.g:5279:1: ( '=' )
            {
            // InternalTechnologyDsl.g:5279:1: ( '=' )
            // InternalTechnologyDsl.g:5280:2: '='
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
    // InternalTechnologyDsl.g:5289:1: rule__ServiceAspectPointcut__Group_2__2 : rule__ServiceAspectPointcut__Group_2__2__Impl ;
    public final void rule__ServiceAspectPointcut__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5293:1: ( rule__ServiceAspectPointcut__Group_2__2__Impl )
            // InternalTechnologyDsl.g:5294:2: rule__ServiceAspectPointcut__Group_2__2__Impl
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
    // InternalTechnologyDsl.g:5300:1: rule__ServiceAspectPointcut__Group_2__2__Impl : ( ( rule__ServiceAspectPointcut__ProtocolAssignment_2_2 ) ) ;
    public final void rule__ServiceAspectPointcut__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5304:1: ( ( ( rule__ServiceAspectPointcut__ProtocolAssignment_2_2 ) ) )
            // InternalTechnologyDsl.g:5305:1: ( ( rule__ServiceAspectPointcut__ProtocolAssignment_2_2 ) )
            {
            // InternalTechnologyDsl.g:5305:1: ( ( rule__ServiceAspectPointcut__ProtocolAssignment_2_2 ) )
            // InternalTechnologyDsl.g:5306:2: ( rule__ServiceAspectPointcut__ProtocolAssignment_2_2 )
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getProtocolAssignment_2_2()); 
            // InternalTechnologyDsl.g:5307:2: ( rule__ServiceAspectPointcut__ProtocolAssignment_2_2 )
            // InternalTechnologyDsl.g:5307:3: rule__ServiceAspectPointcut__ProtocolAssignment_2_2
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
    // InternalTechnologyDsl.g:5316:1: rule__ServiceAspectPointcut__Group_3__0 : rule__ServiceAspectPointcut__Group_3__0__Impl rule__ServiceAspectPointcut__Group_3__1 ;
    public final void rule__ServiceAspectPointcut__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5320:1: ( rule__ServiceAspectPointcut__Group_3__0__Impl rule__ServiceAspectPointcut__Group_3__1 )
            // InternalTechnologyDsl.g:5321:2: rule__ServiceAspectPointcut__Group_3__0__Impl rule__ServiceAspectPointcut__Group_3__1
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
    // InternalTechnologyDsl.g:5328:1: rule__ServiceAspectPointcut__Group_3__0__Impl : ( ( rule__ServiceAspectPointcut__ForDataFormatAssignment_3_0 ) ) ;
    public final void rule__ServiceAspectPointcut__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5332:1: ( ( ( rule__ServiceAspectPointcut__ForDataFormatAssignment_3_0 ) ) )
            // InternalTechnologyDsl.g:5333:1: ( ( rule__ServiceAspectPointcut__ForDataFormatAssignment_3_0 ) )
            {
            // InternalTechnologyDsl.g:5333:1: ( ( rule__ServiceAspectPointcut__ForDataFormatAssignment_3_0 ) )
            // InternalTechnologyDsl.g:5334:2: ( rule__ServiceAspectPointcut__ForDataFormatAssignment_3_0 )
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getForDataFormatAssignment_3_0()); 
            // InternalTechnologyDsl.g:5335:2: ( rule__ServiceAspectPointcut__ForDataFormatAssignment_3_0 )
            // InternalTechnologyDsl.g:5335:3: rule__ServiceAspectPointcut__ForDataFormatAssignment_3_0
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
    // InternalTechnologyDsl.g:5343:1: rule__ServiceAspectPointcut__Group_3__1 : rule__ServiceAspectPointcut__Group_3__1__Impl rule__ServiceAspectPointcut__Group_3__2 ;
    public final void rule__ServiceAspectPointcut__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5347:1: ( rule__ServiceAspectPointcut__Group_3__1__Impl rule__ServiceAspectPointcut__Group_3__2 )
            // InternalTechnologyDsl.g:5348:2: rule__ServiceAspectPointcut__Group_3__1__Impl rule__ServiceAspectPointcut__Group_3__2
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
    // InternalTechnologyDsl.g:5355:1: rule__ServiceAspectPointcut__Group_3__1__Impl : ( '=' ) ;
    public final void rule__ServiceAspectPointcut__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5359:1: ( ( '=' ) )
            // InternalTechnologyDsl.g:5360:1: ( '=' )
            {
            // InternalTechnologyDsl.g:5360:1: ( '=' )
            // InternalTechnologyDsl.g:5361:2: '='
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
    // InternalTechnologyDsl.g:5370:1: rule__ServiceAspectPointcut__Group_3__2 : rule__ServiceAspectPointcut__Group_3__2__Impl ;
    public final void rule__ServiceAspectPointcut__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5374:1: ( rule__ServiceAspectPointcut__Group_3__2__Impl )
            // InternalTechnologyDsl.g:5375:2: rule__ServiceAspectPointcut__Group_3__2__Impl
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
    // InternalTechnologyDsl.g:5381:1: rule__ServiceAspectPointcut__Group_3__2__Impl : ( ( rule__ServiceAspectPointcut__DataFormatAssignment_3_2 ) ) ;
    public final void rule__ServiceAspectPointcut__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5385:1: ( ( ( rule__ServiceAspectPointcut__DataFormatAssignment_3_2 ) ) )
            // InternalTechnologyDsl.g:5386:1: ( ( rule__ServiceAspectPointcut__DataFormatAssignment_3_2 ) )
            {
            // InternalTechnologyDsl.g:5386:1: ( ( rule__ServiceAspectPointcut__DataFormatAssignment_3_2 ) )
            // InternalTechnologyDsl.g:5387:2: ( rule__ServiceAspectPointcut__DataFormatAssignment_3_2 )
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getDataFormatAssignment_3_2()); 
            // InternalTechnologyDsl.g:5388:2: ( rule__ServiceAspectPointcut__DataFormatAssignment_3_2 )
            // InternalTechnologyDsl.g:5388:3: rule__ServiceAspectPointcut__DataFormatAssignment_3_2
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
    // InternalTechnologyDsl.g:5397:1: rule__ServiceAspectPointcutSelector__Group__0 : rule__ServiceAspectPointcutSelector__Group__0__Impl rule__ServiceAspectPointcutSelector__Group__1 ;
    public final void rule__ServiceAspectPointcutSelector__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5401:1: ( rule__ServiceAspectPointcutSelector__Group__0__Impl rule__ServiceAspectPointcutSelector__Group__1 )
            // InternalTechnologyDsl.g:5402:2: rule__ServiceAspectPointcutSelector__Group__0__Impl rule__ServiceAspectPointcutSelector__Group__1
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
    // InternalTechnologyDsl.g:5409:1: rule__ServiceAspectPointcutSelector__Group__0__Impl : ( 'selector' ) ;
    public final void rule__ServiceAspectPointcutSelector__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5413:1: ( ( 'selector' ) )
            // InternalTechnologyDsl.g:5414:1: ( 'selector' )
            {
            // InternalTechnologyDsl.g:5414:1: ( 'selector' )
            // InternalTechnologyDsl.g:5415:2: 'selector'
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
    // InternalTechnologyDsl.g:5424:1: rule__ServiceAspectPointcutSelector__Group__1 : rule__ServiceAspectPointcutSelector__Group__1__Impl rule__ServiceAspectPointcutSelector__Group__2 ;
    public final void rule__ServiceAspectPointcutSelector__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5428:1: ( rule__ServiceAspectPointcutSelector__Group__1__Impl rule__ServiceAspectPointcutSelector__Group__2 )
            // InternalTechnologyDsl.g:5429:2: rule__ServiceAspectPointcutSelector__Group__1__Impl rule__ServiceAspectPointcutSelector__Group__2
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
    // InternalTechnologyDsl.g:5436:1: rule__ServiceAspectPointcutSelector__Group__1__Impl : ( '(' ) ;
    public final void rule__ServiceAspectPointcutSelector__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5440:1: ( ( '(' ) )
            // InternalTechnologyDsl.g:5441:1: ( '(' )
            {
            // InternalTechnologyDsl.g:5441:1: ( '(' )
            // InternalTechnologyDsl.g:5442:2: '('
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
    // InternalTechnologyDsl.g:5451:1: rule__ServiceAspectPointcutSelector__Group__2 : rule__ServiceAspectPointcutSelector__Group__2__Impl rule__ServiceAspectPointcutSelector__Group__3 ;
    public final void rule__ServiceAspectPointcutSelector__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5455:1: ( rule__ServiceAspectPointcutSelector__Group__2__Impl rule__ServiceAspectPointcutSelector__Group__3 )
            // InternalTechnologyDsl.g:5456:2: rule__ServiceAspectPointcutSelector__Group__2__Impl rule__ServiceAspectPointcutSelector__Group__3
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
    // InternalTechnologyDsl.g:5463:1: rule__ServiceAspectPointcutSelector__Group__2__Impl : ( ( rule__ServiceAspectPointcutSelector__PointcutsAssignment_2 ) ) ;
    public final void rule__ServiceAspectPointcutSelector__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5467:1: ( ( ( rule__ServiceAspectPointcutSelector__PointcutsAssignment_2 ) ) )
            // InternalTechnologyDsl.g:5468:1: ( ( rule__ServiceAspectPointcutSelector__PointcutsAssignment_2 ) )
            {
            // InternalTechnologyDsl.g:5468:1: ( ( rule__ServiceAspectPointcutSelector__PointcutsAssignment_2 ) )
            // InternalTechnologyDsl.g:5469:2: ( rule__ServiceAspectPointcutSelector__PointcutsAssignment_2 )
            {
             before(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsAssignment_2()); 
            // InternalTechnologyDsl.g:5470:2: ( rule__ServiceAspectPointcutSelector__PointcutsAssignment_2 )
            // InternalTechnologyDsl.g:5470:3: rule__ServiceAspectPointcutSelector__PointcutsAssignment_2
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
    // InternalTechnologyDsl.g:5478:1: rule__ServiceAspectPointcutSelector__Group__3 : rule__ServiceAspectPointcutSelector__Group__3__Impl rule__ServiceAspectPointcutSelector__Group__4 ;
    public final void rule__ServiceAspectPointcutSelector__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5482:1: ( rule__ServiceAspectPointcutSelector__Group__3__Impl rule__ServiceAspectPointcutSelector__Group__4 )
            // InternalTechnologyDsl.g:5483:2: rule__ServiceAspectPointcutSelector__Group__3__Impl rule__ServiceAspectPointcutSelector__Group__4
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
    // InternalTechnologyDsl.g:5490:1: rule__ServiceAspectPointcutSelector__Group__3__Impl : ( ( rule__ServiceAspectPointcutSelector__Group_3__0 )* ) ;
    public final void rule__ServiceAspectPointcutSelector__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5494:1: ( ( ( rule__ServiceAspectPointcutSelector__Group_3__0 )* ) )
            // InternalTechnologyDsl.g:5495:1: ( ( rule__ServiceAspectPointcutSelector__Group_3__0 )* )
            {
            // InternalTechnologyDsl.g:5495:1: ( ( rule__ServiceAspectPointcutSelector__Group_3__0 )* )
            // InternalTechnologyDsl.g:5496:2: ( rule__ServiceAspectPointcutSelector__Group_3__0 )*
            {
             before(grammarAccess.getServiceAspectPointcutSelectorAccess().getGroup_3()); 
            // InternalTechnologyDsl.g:5497:2: ( rule__ServiceAspectPointcutSelector__Group_3__0 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==46) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalTechnologyDsl.g:5497:3: rule__ServiceAspectPointcutSelector__Group_3__0
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
    // InternalTechnologyDsl.g:5505:1: rule__ServiceAspectPointcutSelector__Group__4 : rule__ServiceAspectPointcutSelector__Group__4__Impl rule__ServiceAspectPointcutSelector__Group__5 ;
    public final void rule__ServiceAspectPointcutSelector__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5509:1: ( rule__ServiceAspectPointcutSelector__Group__4__Impl rule__ServiceAspectPointcutSelector__Group__5 )
            // InternalTechnologyDsl.g:5510:2: rule__ServiceAspectPointcutSelector__Group__4__Impl rule__ServiceAspectPointcutSelector__Group__5
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
    // InternalTechnologyDsl.g:5517:1: rule__ServiceAspectPointcutSelector__Group__4__Impl : ( ')' ) ;
    public final void rule__ServiceAspectPointcutSelector__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5521:1: ( ( ')' ) )
            // InternalTechnologyDsl.g:5522:1: ( ')' )
            {
            // InternalTechnologyDsl.g:5522:1: ( ')' )
            // InternalTechnologyDsl.g:5523:2: ')'
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
    // InternalTechnologyDsl.g:5532:1: rule__ServiceAspectPointcutSelector__Group__5 : rule__ServiceAspectPointcutSelector__Group__5__Impl ;
    public final void rule__ServiceAspectPointcutSelector__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5536:1: ( rule__ServiceAspectPointcutSelector__Group__5__Impl )
            // InternalTechnologyDsl.g:5537:2: rule__ServiceAspectPointcutSelector__Group__5__Impl
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
    // InternalTechnologyDsl.g:5543:1: rule__ServiceAspectPointcutSelector__Group__5__Impl : ( ';' ) ;
    public final void rule__ServiceAspectPointcutSelector__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5547:1: ( ( ';' ) )
            // InternalTechnologyDsl.g:5548:1: ( ';' )
            {
            // InternalTechnologyDsl.g:5548:1: ( ';' )
            // InternalTechnologyDsl.g:5549:2: ';'
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
    // InternalTechnologyDsl.g:5559:1: rule__ServiceAspectPointcutSelector__Group_3__0 : rule__ServiceAspectPointcutSelector__Group_3__0__Impl rule__ServiceAspectPointcutSelector__Group_3__1 ;
    public final void rule__ServiceAspectPointcutSelector__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5563:1: ( rule__ServiceAspectPointcutSelector__Group_3__0__Impl rule__ServiceAspectPointcutSelector__Group_3__1 )
            // InternalTechnologyDsl.g:5564:2: rule__ServiceAspectPointcutSelector__Group_3__0__Impl rule__ServiceAspectPointcutSelector__Group_3__1
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
    // InternalTechnologyDsl.g:5571:1: rule__ServiceAspectPointcutSelector__Group_3__0__Impl : ( ',' ) ;
    public final void rule__ServiceAspectPointcutSelector__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5575:1: ( ( ',' ) )
            // InternalTechnologyDsl.g:5576:1: ( ',' )
            {
            // InternalTechnologyDsl.g:5576:1: ( ',' )
            // InternalTechnologyDsl.g:5577:2: ','
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
    // InternalTechnologyDsl.g:5586:1: rule__ServiceAspectPointcutSelector__Group_3__1 : rule__ServiceAspectPointcutSelector__Group_3__1__Impl ;
    public final void rule__ServiceAspectPointcutSelector__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5590:1: ( rule__ServiceAspectPointcutSelector__Group_3__1__Impl )
            // InternalTechnologyDsl.g:5591:2: rule__ServiceAspectPointcutSelector__Group_3__1__Impl
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
    // InternalTechnologyDsl.g:5597:1: rule__ServiceAspectPointcutSelector__Group_3__1__Impl : ( ( rule__ServiceAspectPointcutSelector__PointcutsAssignment_3_1 ) ) ;
    public final void rule__ServiceAspectPointcutSelector__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5601:1: ( ( ( rule__ServiceAspectPointcutSelector__PointcutsAssignment_3_1 ) ) )
            // InternalTechnologyDsl.g:5602:1: ( ( rule__ServiceAspectPointcutSelector__PointcutsAssignment_3_1 ) )
            {
            // InternalTechnologyDsl.g:5602:1: ( ( rule__ServiceAspectPointcutSelector__PointcutsAssignment_3_1 ) )
            // InternalTechnologyDsl.g:5603:2: ( rule__ServiceAspectPointcutSelector__PointcutsAssignment_3_1 )
            {
             before(grammarAccess.getServiceAspectPointcutSelectorAccess().getPointcutsAssignment_3_1()); 
            // InternalTechnologyDsl.g:5604:2: ( rule__ServiceAspectPointcutSelector__PointcutsAssignment_3_1 )
            // InternalTechnologyDsl.g:5604:3: rule__ServiceAspectPointcutSelector__PointcutsAssignment_3_1
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
    // InternalTechnologyDsl.g:5613:1: rule__ServiceAspect__Group__0 : rule__ServiceAspect__Group__0__Impl rule__ServiceAspect__Group__1 ;
    public final void rule__ServiceAspect__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5617:1: ( rule__ServiceAspect__Group__0__Impl rule__ServiceAspect__Group__1 )
            // InternalTechnologyDsl.g:5618:2: rule__ServiceAspect__Group__0__Impl rule__ServiceAspect__Group__1
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
    // InternalTechnologyDsl.g:5625:1: rule__ServiceAspect__Group__0__Impl : ( 'aspect' ) ;
    public final void rule__ServiceAspect__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5629:1: ( ( 'aspect' ) )
            // InternalTechnologyDsl.g:5630:1: ( 'aspect' )
            {
            // InternalTechnologyDsl.g:5630:1: ( 'aspect' )
            // InternalTechnologyDsl.g:5631:2: 'aspect'
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
    // InternalTechnologyDsl.g:5640:1: rule__ServiceAspect__Group__1 : rule__ServiceAspect__Group__1__Impl rule__ServiceAspect__Group__2 ;
    public final void rule__ServiceAspect__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5644:1: ( rule__ServiceAspect__Group__1__Impl rule__ServiceAspect__Group__2 )
            // InternalTechnologyDsl.g:5645:2: rule__ServiceAspect__Group__1__Impl rule__ServiceAspect__Group__2
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
    // InternalTechnologyDsl.g:5652:1: rule__ServiceAspect__Group__1__Impl : ( ( rule__ServiceAspect__NameAssignment_1 ) ) ;
    public final void rule__ServiceAspect__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5656:1: ( ( ( rule__ServiceAspect__NameAssignment_1 ) ) )
            // InternalTechnologyDsl.g:5657:1: ( ( rule__ServiceAspect__NameAssignment_1 ) )
            {
            // InternalTechnologyDsl.g:5657:1: ( ( rule__ServiceAspect__NameAssignment_1 ) )
            // InternalTechnologyDsl.g:5658:2: ( rule__ServiceAspect__NameAssignment_1 )
            {
             before(grammarAccess.getServiceAspectAccess().getNameAssignment_1()); 
            // InternalTechnologyDsl.g:5659:2: ( rule__ServiceAspect__NameAssignment_1 )
            // InternalTechnologyDsl.g:5659:3: rule__ServiceAspect__NameAssignment_1
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
    // InternalTechnologyDsl.g:5667:1: rule__ServiceAspect__Group__2 : rule__ServiceAspect__Group__2__Impl rule__ServiceAspect__Group__3 ;
    public final void rule__ServiceAspect__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5671:1: ( rule__ServiceAspect__Group__2__Impl rule__ServiceAspect__Group__3 )
            // InternalTechnologyDsl.g:5672:2: rule__ServiceAspect__Group__2__Impl rule__ServiceAspect__Group__3
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
    // InternalTechnologyDsl.g:5679:1: rule__ServiceAspect__Group__2__Impl : ( 'for' ) ;
    public final void rule__ServiceAspect__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5683:1: ( ( 'for' ) )
            // InternalTechnologyDsl.g:5684:1: ( 'for' )
            {
            // InternalTechnologyDsl.g:5684:1: ( 'for' )
            // InternalTechnologyDsl.g:5685:2: 'for'
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
    // InternalTechnologyDsl.g:5694:1: rule__ServiceAspect__Group__3 : rule__ServiceAspect__Group__3__Impl rule__ServiceAspect__Group__4 ;
    public final void rule__ServiceAspect__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5698:1: ( rule__ServiceAspect__Group__3__Impl rule__ServiceAspect__Group__4 )
            // InternalTechnologyDsl.g:5699:2: rule__ServiceAspect__Group__3__Impl rule__ServiceAspect__Group__4
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
    // InternalTechnologyDsl.g:5706:1: rule__ServiceAspect__Group__3__Impl : ( ( rule__ServiceAspect__JoinPointsAssignment_3 ) ) ;
    public final void rule__ServiceAspect__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5710:1: ( ( ( rule__ServiceAspect__JoinPointsAssignment_3 ) ) )
            // InternalTechnologyDsl.g:5711:1: ( ( rule__ServiceAspect__JoinPointsAssignment_3 ) )
            {
            // InternalTechnologyDsl.g:5711:1: ( ( rule__ServiceAspect__JoinPointsAssignment_3 ) )
            // InternalTechnologyDsl.g:5712:2: ( rule__ServiceAspect__JoinPointsAssignment_3 )
            {
             before(grammarAccess.getServiceAspectAccess().getJoinPointsAssignment_3()); 
            // InternalTechnologyDsl.g:5713:2: ( rule__ServiceAspect__JoinPointsAssignment_3 )
            // InternalTechnologyDsl.g:5713:3: rule__ServiceAspect__JoinPointsAssignment_3
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
    // InternalTechnologyDsl.g:5721:1: rule__ServiceAspect__Group__4 : rule__ServiceAspect__Group__4__Impl rule__ServiceAspect__Group__5 ;
    public final void rule__ServiceAspect__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5725:1: ( rule__ServiceAspect__Group__4__Impl rule__ServiceAspect__Group__5 )
            // InternalTechnologyDsl.g:5726:2: rule__ServiceAspect__Group__4__Impl rule__ServiceAspect__Group__5
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
    // InternalTechnologyDsl.g:5733:1: rule__ServiceAspect__Group__4__Impl : ( ( rule__ServiceAspect__Group_4__0 )* ) ;
    public final void rule__ServiceAspect__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5737:1: ( ( ( rule__ServiceAspect__Group_4__0 )* ) )
            // InternalTechnologyDsl.g:5738:1: ( ( rule__ServiceAspect__Group_4__0 )* )
            {
            // InternalTechnologyDsl.g:5738:1: ( ( rule__ServiceAspect__Group_4__0 )* )
            // InternalTechnologyDsl.g:5739:2: ( rule__ServiceAspect__Group_4__0 )*
            {
             before(grammarAccess.getServiceAspectAccess().getGroup_4()); 
            // InternalTechnologyDsl.g:5740:2: ( rule__ServiceAspect__Group_4__0 )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==46) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalTechnologyDsl.g:5740:3: rule__ServiceAspect__Group_4__0
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
    // InternalTechnologyDsl.g:5748:1: rule__ServiceAspect__Group__5 : rule__ServiceAspect__Group__5__Impl ;
    public final void rule__ServiceAspect__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5752:1: ( rule__ServiceAspect__Group__5__Impl )
            // InternalTechnologyDsl.g:5753:2: rule__ServiceAspect__Group__5__Impl
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
    // InternalTechnologyDsl.g:5759:1: rule__ServiceAspect__Group__5__Impl : ( ( rule__ServiceAspect__Alternatives_5 ) ) ;
    public final void rule__ServiceAspect__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5763:1: ( ( ( rule__ServiceAspect__Alternatives_5 ) ) )
            // InternalTechnologyDsl.g:5764:1: ( ( rule__ServiceAspect__Alternatives_5 ) )
            {
            // InternalTechnologyDsl.g:5764:1: ( ( rule__ServiceAspect__Alternatives_5 ) )
            // InternalTechnologyDsl.g:5765:2: ( rule__ServiceAspect__Alternatives_5 )
            {
             before(grammarAccess.getServiceAspectAccess().getAlternatives_5()); 
            // InternalTechnologyDsl.g:5766:2: ( rule__ServiceAspect__Alternatives_5 )
            // InternalTechnologyDsl.g:5766:3: rule__ServiceAspect__Alternatives_5
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
    // InternalTechnologyDsl.g:5775:1: rule__ServiceAspect__Group_4__0 : rule__ServiceAspect__Group_4__0__Impl rule__ServiceAspect__Group_4__1 ;
    public final void rule__ServiceAspect__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5779:1: ( rule__ServiceAspect__Group_4__0__Impl rule__ServiceAspect__Group_4__1 )
            // InternalTechnologyDsl.g:5780:2: rule__ServiceAspect__Group_4__0__Impl rule__ServiceAspect__Group_4__1
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
    // InternalTechnologyDsl.g:5787:1: rule__ServiceAspect__Group_4__0__Impl : ( ',' ) ;
    public final void rule__ServiceAspect__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5791:1: ( ( ',' ) )
            // InternalTechnologyDsl.g:5792:1: ( ',' )
            {
            // InternalTechnologyDsl.g:5792:1: ( ',' )
            // InternalTechnologyDsl.g:5793:2: ','
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
    // InternalTechnologyDsl.g:5802:1: rule__ServiceAspect__Group_4__1 : rule__ServiceAspect__Group_4__1__Impl ;
    public final void rule__ServiceAspect__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5806:1: ( rule__ServiceAspect__Group_4__1__Impl )
            // InternalTechnologyDsl.g:5807:2: rule__ServiceAspect__Group_4__1__Impl
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
    // InternalTechnologyDsl.g:5813:1: rule__ServiceAspect__Group_4__1__Impl : ( ( rule__ServiceAspect__JoinPointsAssignment_4_1 ) ) ;
    public final void rule__ServiceAspect__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5817:1: ( ( ( rule__ServiceAspect__JoinPointsAssignment_4_1 ) ) )
            // InternalTechnologyDsl.g:5818:1: ( ( rule__ServiceAspect__JoinPointsAssignment_4_1 ) )
            {
            // InternalTechnologyDsl.g:5818:1: ( ( rule__ServiceAspect__JoinPointsAssignment_4_1 ) )
            // InternalTechnologyDsl.g:5819:2: ( rule__ServiceAspect__JoinPointsAssignment_4_1 )
            {
             before(grammarAccess.getServiceAspectAccess().getJoinPointsAssignment_4_1()); 
            // InternalTechnologyDsl.g:5820:2: ( rule__ServiceAspect__JoinPointsAssignment_4_1 )
            // InternalTechnologyDsl.g:5820:3: rule__ServiceAspect__JoinPointsAssignment_4_1
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
    // InternalTechnologyDsl.g:5829:1: rule__ServiceAspect__Group_5_0__0 : rule__ServiceAspect__Group_5_0__0__Impl rule__ServiceAspect__Group_5_0__1 ;
    public final void rule__ServiceAspect__Group_5_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5833:1: ( rule__ServiceAspect__Group_5_0__0__Impl rule__ServiceAspect__Group_5_0__1 )
            // InternalTechnologyDsl.g:5834:2: rule__ServiceAspect__Group_5_0__0__Impl rule__ServiceAspect__Group_5_0__1
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
    // InternalTechnologyDsl.g:5841:1: rule__ServiceAspect__Group_5_0__0__Impl : ( '{' ) ;
    public final void rule__ServiceAspect__Group_5_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5845:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:5846:1: ( '{' )
            {
            // InternalTechnologyDsl.g:5846:1: ( '{' )
            // InternalTechnologyDsl.g:5847:2: '{'
            {
             before(grammarAccess.getServiceAspectAccess().getLeftCurlyBracketKeyword_5_0_0()); 
            match(input,30,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:5856:1: rule__ServiceAspect__Group_5_0__1 : rule__ServiceAspect__Group_5_0__1__Impl rule__ServiceAspect__Group_5_0__2 ;
    public final void rule__ServiceAspect__Group_5_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5860:1: ( rule__ServiceAspect__Group_5_0__1__Impl rule__ServiceAspect__Group_5_0__2 )
            // InternalTechnologyDsl.g:5861:2: rule__ServiceAspect__Group_5_0__1__Impl rule__ServiceAspect__Group_5_0__2
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
    // InternalTechnologyDsl.g:5868:1: rule__ServiceAspect__Group_5_0__1__Impl : ( ( rule__ServiceAspect__PointcutSelectorsAssignment_5_0_1 )* ) ;
    public final void rule__ServiceAspect__Group_5_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5872:1: ( ( ( rule__ServiceAspect__PointcutSelectorsAssignment_5_0_1 )* ) )
            // InternalTechnologyDsl.g:5873:1: ( ( rule__ServiceAspect__PointcutSelectorsAssignment_5_0_1 )* )
            {
            // InternalTechnologyDsl.g:5873:1: ( ( rule__ServiceAspect__PointcutSelectorsAssignment_5_0_1 )* )
            // InternalTechnologyDsl.g:5874:2: ( rule__ServiceAspect__PointcutSelectorsAssignment_5_0_1 )*
            {
             before(grammarAccess.getServiceAspectAccess().getPointcutSelectorsAssignment_5_0_1()); 
            // InternalTechnologyDsl.g:5875:2: ( rule__ServiceAspect__PointcutSelectorsAssignment_5_0_1 )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==59) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalTechnologyDsl.g:5875:3: rule__ServiceAspect__PointcutSelectorsAssignment_5_0_1
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
    // InternalTechnologyDsl.g:5883:1: rule__ServiceAspect__Group_5_0__2 : rule__ServiceAspect__Group_5_0__2__Impl rule__ServiceAspect__Group_5_0__3 ;
    public final void rule__ServiceAspect__Group_5_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5887:1: ( rule__ServiceAspect__Group_5_0__2__Impl rule__ServiceAspect__Group_5_0__3 )
            // InternalTechnologyDsl.g:5888:2: rule__ServiceAspect__Group_5_0__2__Impl rule__ServiceAspect__Group_5_0__3
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
    // InternalTechnologyDsl.g:5895:1: rule__ServiceAspect__Group_5_0__2__Impl : ( ( rule__ServiceAspect__PropertiesAssignment_5_0_2 )* ) ;
    public final void rule__ServiceAspect__Group_5_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5899:1: ( ( ( rule__ServiceAspect__PropertiesAssignment_5_0_2 )* ) )
            // InternalTechnologyDsl.g:5900:1: ( ( rule__ServiceAspect__PropertiesAssignment_5_0_2 )* )
            {
            // InternalTechnologyDsl.g:5900:1: ( ( rule__ServiceAspect__PropertiesAssignment_5_0_2 )* )
            // InternalTechnologyDsl.g:5901:2: ( rule__ServiceAspect__PropertiesAssignment_5_0_2 )*
            {
             before(grammarAccess.getServiceAspectAccess().getPropertiesAssignment_5_0_2()); 
            // InternalTechnologyDsl.g:5902:2: ( rule__ServiceAspect__PropertiesAssignment_5_0_2 )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( ((LA52_0>=68 && LA52_0<=77)) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalTechnologyDsl.g:5902:3: rule__ServiceAspect__PropertiesAssignment_5_0_2
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
    // InternalTechnologyDsl.g:5910:1: rule__ServiceAspect__Group_5_0__3 : rule__ServiceAspect__Group_5_0__3__Impl ;
    public final void rule__ServiceAspect__Group_5_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5914:1: ( rule__ServiceAspect__Group_5_0__3__Impl )
            // InternalTechnologyDsl.g:5915:2: rule__ServiceAspect__Group_5_0__3__Impl
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
    // InternalTechnologyDsl.g:5921:1: rule__ServiceAspect__Group_5_0__3__Impl : ( '}' ) ;
    public final void rule__ServiceAspect__Group_5_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5925:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:5926:1: ( '}' )
            {
            // InternalTechnologyDsl.g:5926:1: ( '}' )
            // InternalTechnologyDsl.g:5927:2: '}'
            {
             before(grammarAccess.getServiceAspectAccess().getRightCurlyBracketKeyword_5_0_3()); 
            match(input,31,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:5937:1: rule__OperationAspect__Group__0 : rule__OperationAspect__Group__0__Impl rule__OperationAspect__Group__1 ;
    public final void rule__OperationAspect__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5941:1: ( rule__OperationAspect__Group__0__Impl rule__OperationAspect__Group__1 )
            // InternalTechnologyDsl.g:5942:2: rule__OperationAspect__Group__0__Impl rule__OperationAspect__Group__1
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
    // InternalTechnologyDsl.g:5949:1: rule__OperationAspect__Group__0__Impl : ( 'aspect' ) ;
    public final void rule__OperationAspect__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5953:1: ( ( 'aspect' ) )
            // InternalTechnologyDsl.g:5954:1: ( 'aspect' )
            {
            // InternalTechnologyDsl.g:5954:1: ( 'aspect' )
            // InternalTechnologyDsl.g:5955:2: 'aspect'
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
    // InternalTechnologyDsl.g:5964:1: rule__OperationAspect__Group__1 : rule__OperationAspect__Group__1__Impl rule__OperationAspect__Group__2 ;
    public final void rule__OperationAspect__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5968:1: ( rule__OperationAspect__Group__1__Impl rule__OperationAspect__Group__2 )
            // InternalTechnologyDsl.g:5969:2: rule__OperationAspect__Group__1__Impl rule__OperationAspect__Group__2
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
    // InternalTechnologyDsl.g:5976:1: rule__OperationAspect__Group__1__Impl : ( ( rule__OperationAspect__NameAssignment_1 ) ) ;
    public final void rule__OperationAspect__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5980:1: ( ( ( rule__OperationAspect__NameAssignment_1 ) ) )
            // InternalTechnologyDsl.g:5981:1: ( ( rule__OperationAspect__NameAssignment_1 ) )
            {
            // InternalTechnologyDsl.g:5981:1: ( ( rule__OperationAspect__NameAssignment_1 ) )
            // InternalTechnologyDsl.g:5982:2: ( rule__OperationAspect__NameAssignment_1 )
            {
             before(grammarAccess.getOperationAspectAccess().getNameAssignment_1()); 
            // InternalTechnologyDsl.g:5983:2: ( rule__OperationAspect__NameAssignment_1 )
            // InternalTechnologyDsl.g:5983:3: rule__OperationAspect__NameAssignment_1
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
    // InternalTechnologyDsl.g:5991:1: rule__OperationAspect__Group__2 : rule__OperationAspect__Group__2__Impl rule__OperationAspect__Group__3 ;
    public final void rule__OperationAspect__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:5995:1: ( rule__OperationAspect__Group__2__Impl rule__OperationAspect__Group__3 )
            // InternalTechnologyDsl.g:5996:2: rule__OperationAspect__Group__2__Impl rule__OperationAspect__Group__3
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
    // InternalTechnologyDsl.g:6003:1: rule__OperationAspect__Group__2__Impl : ( 'for' ) ;
    public final void rule__OperationAspect__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6007:1: ( ( 'for' ) )
            // InternalTechnologyDsl.g:6008:1: ( 'for' )
            {
            // InternalTechnologyDsl.g:6008:1: ( 'for' )
            // InternalTechnologyDsl.g:6009:2: 'for'
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
    // InternalTechnologyDsl.g:6018:1: rule__OperationAspect__Group__3 : rule__OperationAspect__Group__3__Impl rule__OperationAspect__Group__4 ;
    public final void rule__OperationAspect__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6022:1: ( rule__OperationAspect__Group__3__Impl rule__OperationAspect__Group__4 )
            // InternalTechnologyDsl.g:6023:2: rule__OperationAspect__Group__3__Impl rule__OperationAspect__Group__4
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
    // InternalTechnologyDsl.g:6030:1: rule__OperationAspect__Group__3__Impl : ( ( rule__OperationAspect__JoinPointsAssignment_3 ) ) ;
    public final void rule__OperationAspect__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6034:1: ( ( ( rule__OperationAspect__JoinPointsAssignment_3 ) ) )
            // InternalTechnologyDsl.g:6035:1: ( ( rule__OperationAspect__JoinPointsAssignment_3 ) )
            {
            // InternalTechnologyDsl.g:6035:1: ( ( rule__OperationAspect__JoinPointsAssignment_3 ) )
            // InternalTechnologyDsl.g:6036:2: ( rule__OperationAspect__JoinPointsAssignment_3 )
            {
             before(grammarAccess.getOperationAspectAccess().getJoinPointsAssignment_3()); 
            // InternalTechnologyDsl.g:6037:2: ( rule__OperationAspect__JoinPointsAssignment_3 )
            // InternalTechnologyDsl.g:6037:3: rule__OperationAspect__JoinPointsAssignment_3
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
    // InternalTechnologyDsl.g:6045:1: rule__OperationAspect__Group__4 : rule__OperationAspect__Group__4__Impl rule__OperationAspect__Group__5 ;
    public final void rule__OperationAspect__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6049:1: ( rule__OperationAspect__Group__4__Impl rule__OperationAspect__Group__5 )
            // InternalTechnologyDsl.g:6050:2: rule__OperationAspect__Group__4__Impl rule__OperationAspect__Group__5
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
    // InternalTechnologyDsl.g:6057:1: rule__OperationAspect__Group__4__Impl : ( ( rule__OperationAspect__Group_4__0 )* ) ;
    public final void rule__OperationAspect__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6061:1: ( ( ( rule__OperationAspect__Group_4__0 )* ) )
            // InternalTechnologyDsl.g:6062:1: ( ( rule__OperationAspect__Group_4__0 )* )
            {
            // InternalTechnologyDsl.g:6062:1: ( ( rule__OperationAspect__Group_4__0 )* )
            // InternalTechnologyDsl.g:6063:2: ( rule__OperationAspect__Group_4__0 )*
            {
             before(grammarAccess.getOperationAspectAccess().getGroup_4()); 
            // InternalTechnologyDsl.g:6064:2: ( rule__OperationAspect__Group_4__0 )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==46) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalTechnologyDsl.g:6064:3: rule__OperationAspect__Group_4__0
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
    // InternalTechnologyDsl.g:6072:1: rule__OperationAspect__Group__5 : rule__OperationAspect__Group__5__Impl ;
    public final void rule__OperationAspect__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6076:1: ( rule__OperationAspect__Group__5__Impl )
            // InternalTechnologyDsl.g:6077:2: rule__OperationAspect__Group__5__Impl
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
    // InternalTechnologyDsl.g:6083:1: rule__OperationAspect__Group__5__Impl : ( ( rule__OperationAspect__Alternatives_5 ) ) ;
    public final void rule__OperationAspect__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6087:1: ( ( ( rule__OperationAspect__Alternatives_5 ) ) )
            // InternalTechnologyDsl.g:6088:1: ( ( rule__OperationAspect__Alternatives_5 ) )
            {
            // InternalTechnologyDsl.g:6088:1: ( ( rule__OperationAspect__Alternatives_5 ) )
            // InternalTechnologyDsl.g:6089:2: ( rule__OperationAspect__Alternatives_5 )
            {
             before(grammarAccess.getOperationAspectAccess().getAlternatives_5()); 
            // InternalTechnologyDsl.g:6090:2: ( rule__OperationAspect__Alternatives_5 )
            // InternalTechnologyDsl.g:6090:3: rule__OperationAspect__Alternatives_5
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
    // InternalTechnologyDsl.g:6099:1: rule__OperationAspect__Group_4__0 : rule__OperationAspect__Group_4__0__Impl rule__OperationAspect__Group_4__1 ;
    public final void rule__OperationAspect__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6103:1: ( rule__OperationAspect__Group_4__0__Impl rule__OperationAspect__Group_4__1 )
            // InternalTechnologyDsl.g:6104:2: rule__OperationAspect__Group_4__0__Impl rule__OperationAspect__Group_4__1
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
    // InternalTechnologyDsl.g:6111:1: rule__OperationAspect__Group_4__0__Impl : ( ',' ) ;
    public final void rule__OperationAspect__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6115:1: ( ( ',' ) )
            // InternalTechnologyDsl.g:6116:1: ( ',' )
            {
            // InternalTechnologyDsl.g:6116:1: ( ',' )
            // InternalTechnologyDsl.g:6117:2: ','
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
    // InternalTechnologyDsl.g:6126:1: rule__OperationAspect__Group_4__1 : rule__OperationAspect__Group_4__1__Impl ;
    public final void rule__OperationAspect__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6130:1: ( rule__OperationAspect__Group_4__1__Impl )
            // InternalTechnologyDsl.g:6131:2: rule__OperationAspect__Group_4__1__Impl
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
    // InternalTechnologyDsl.g:6137:1: rule__OperationAspect__Group_4__1__Impl : ( ( rule__OperationAspect__JoinPointsAssignment_4_1 ) ) ;
    public final void rule__OperationAspect__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6141:1: ( ( ( rule__OperationAspect__JoinPointsAssignment_4_1 ) ) )
            // InternalTechnologyDsl.g:6142:1: ( ( rule__OperationAspect__JoinPointsAssignment_4_1 ) )
            {
            // InternalTechnologyDsl.g:6142:1: ( ( rule__OperationAspect__JoinPointsAssignment_4_1 ) )
            // InternalTechnologyDsl.g:6143:2: ( rule__OperationAspect__JoinPointsAssignment_4_1 )
            {
             before(grammarAccess.getOperationAspectAccess().getJoinPointsAssignment_4_1()); 
            // InternalTechnologyDsl.g:6144:2: ( rule__OperationAspect__JoinPointsAssignment_4_1 )
            // InternalTechnologyDsl.g:6144:3: rule__OperationAspect__JoinPointsAssignment_4_1
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
    // InternalTechnologyDsl.g:6153:1: rule__OperationAspect__Group_5_0__0 : rule__OperationAspect__Group_5_0__0__Impl rule__OperationAspect__Group_5_0__1 ;
    public final void rule__OperationAspect__Group_5_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6157:1: ( rule__OperationAspect__Group_5_0__0__Impl rule__OperationAspect__Group_5_0__1 )
            // InternalTechnologyDsl.g:6158:2: rule__OperationAspect__Group_5_0__0__Impl rule__OperationAspect__Group_5_0__1
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
    // InternalTechnologyDsl.g:6165:1: rule__OperationAspect__Group_5_0__0__Impl : ( '{' ) ;
    public final void rule__OperationAspect__Group_5_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6169:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:6170:1: ( '{' )
            {
            // InternalTechnologyDsl.g:6170:1: ( '{' )
            // InternalTechnologyDsl.g:6171:2: '{'
            {
             before(grammarAccess.getOperationAspectAccess().getLeftCurlyBracketKeyword_5_0_0()); 
            match(input,30,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:6180:1: rule__OperationAspect__Group_5_0__1 : rule__OperationAspect__Group_5_0__1__Impl rule__OperationAspect__Group_5_0__2 ;
    public final void rule__OperationAspect__Group_5_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6184:1: ( rule__OperationAspect__Group_5_0__1__Impl rule__OperationAspect__Group_5_0__2 )
            // InternalTechnologyDsl.g:6185:2: rule__OperationAspect__Group_5_0__1__Impl rule__OperationAspect__Group_5_0__2
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
    // InternalTechnologyDsl.g:6192:1: rule__OperationAspect__Group_5_0__1__Impl : ( ( rule__OperationAspect__PropertiesAssignment_5_0_1 )* ) ;
    public final void rule__OperationAspect__Group_5_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6196:1: ( ( ( rule__OperationAspect__PropertiesAssignment_5_0_1 )* ) )
            // InternalTechnologyDsl.g:6197:1: ( ( rule__OperationAspect__PropertiesAssignment_5_0_1 )* )
            {
            // InternalTechnologyDsl.g:6197:1: ( ( rule__OperationAspect__PropertiesAssignment_5_0_1 )* )
            // InternalTechnologyDsl.g:6198:2: ( rule__OperationAspect__PropertiesAssignment_5_0_1 )*
            {
             before(grammarAccess.getOperationAspectAccess().getPropertiesAssignment_5_0_1()); 
            // InternalTechnologyDsl.g:6199:2: ( rule__OperationAspect__PropertiesAssignment_5_0_1 )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( ((LA54_0>=68 && LA54_0<=77)) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalTechnologyDsl.g:6199:3: rule__OperationAspect__PropertiesAssignment_5_0_1
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
    // InternalTechnologyDsl.g:6207:1: rule__OperationAspect__Group_5_0__2 : rule__OperationAspect__Group_5_0__2__Impl ;
    public final void rule__OperationAspect__Group_5_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6211:1: ( rule__OperationAspect__Group_5_0__2__Impl )
            // InternalTechnologyDsl.g:6212:2: rule__OperationAspect__Group_5_0__2__Impl
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
    // InternalTechnologyDsl.g:6218:1: rule__OperationAspect__Group_5_0__2__Impl : ( '}' ) ;
    public final void rule__OperationAspect__Group_5_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6222:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:6223:1: ( '}' )
            {
            // InternalTechnologyDsl.g:6223:1: ( '}' )
            // InternalTechnologyDsl.g:6224:2: '}'
            {
             before(grammarAccess.getOperationAspectAccess().getRightCurlyBracketKeyword_5_0_2()); 
            match(input,31,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:6234:1: rule__ComplexTypeImport__Group__0 : rule__ComplexTypeImport__Group__0__Impl rule__ComplexTypeImport__Group__1 ;
    public final void rule__ComplexTypeImport__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6238:1: ( rule__ComplexTypeImport__Group__0__Impl rule__ComplexTypeImport__Group__1 )
            // InternalTechnologyDsl.g:6239:2: rule__ComplexTypeImport__Group__0__Impl rule__ComplexTypeImport__Group__1
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
    // InternalTechnologyDsl.g:6246:1: rule__ComplexTypeImport__Group__0__Impl : ( 'import' ) ;
    public final void rule__ComplexTypeImport__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6250:1: ( ( 'import' ) )
            // InternalTechnologyDsl.g:6251:1: ( 'import' )
            {
            // InternalTechnologyDsl.g:6251:1: ( 'import' )
            // InternalTechnologyDsl.g:6252:2: 'import'
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
    // InternalTechnologyDsl.g:6261:1: rule__ComplexTypeImport__Group__1 : rule__ComplexTypeImport__Group__1__Impl rule__ComplexTypeImport__Group__2 ;
    public final void rule__ComplexTypeImport__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6265:1: ( rule__ComplexTypeImport__Group__1__Impl rule__ComplexTypeImport__Group__2 )
            // InternalTechnologyDsl.g:6266:2: rule__ComplexTypeImport__Group__1__Impl rule__ComplexTypeImport__Group__2
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
    // InternalTechnologyDsl.g:6273:1: rule__ComplexTypeImport__Group__1__Impl : ( 'datatypes' ) ;
    public final void rule__ComplexTypeImport__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6277:1: ( ( 'datatypes' ) )
            // InternalTechnologyDsl.g:6278:1: ( 'datatypes' )
            {
            // InternalTechnologyDsl.g:6278:1: ( 'datatypes' )
            // InternalTechnologyDsl.g:6279:2: 'datatypes'
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
    // InternalTechnologyDsl.g:6288:1: rule__ComplexTypeImport__Group__2 : rule__ComplexTypeImport__Group__2__Impl rule__ComplexTypeImport__Group__3 ;
    public final void rule__ComplexTypeImport__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6292:1: ( rule__ComplexTypeImport__Group__2__Impl rule__ComplexTypeImport__Group__3 )
            // InternalTechnologyDsl.g:6293:2: rule__ComplexTypeImport__Group__2__Impl rule__ComplexTypeImport__Group__3
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
    // InternalTechnologyDsl.g:6300:1: rule__ComplexTypeImport__Group__2__Impl : ( 'from' ) ;
    public final void rule__ComplexTypeImport__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6304:1: ( ( 'from' ) )
            // InternalTechnologyDsl.g:6305:1: ( 'from' )
            {
            // InternalTechnologyDsl.g:6305:1: ( 'from' )
            // InternalTechnologyDsl.g:6306:2: 'from'
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
    // InternalTechnologyDsl.g:6315:1: rule__ComplexTypeImport__Group__3 : rule__ComplexTypeImport__Group__3__Impl rule__ComplexTypeImport__Group__4 ;
    public final void rule__ComplexTypeImport__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6319:1: ( rule__ComplexTypeImport__Group__3__Impl rule__ComplexTypeImport__Group__4 )
            // InternalTechnologyDsl.g:6320:2: rule__ComplexTypeImport__Group__3__Impl rule__ComplexTypeImport__Group__4
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
    // InternalTechnologyDsl.g:6327:1: rule__ComplexTypeImport__Group__3__Impl : ( ( rule__ComplexTypeImport__ImportURIAssignment_3 ) ) ;
    public final void rule__ComplexTypeImport__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6331:1: ( ( ( rule__ComplexTypeImport__ImportURIAssignment_3 ) ) )
            // InternalTechnologyDsl.g:6332:1: ( ( rule__ComplexTypeImport__ImportURIAssignment_3 ) )
            {
            // InternalTechnologyDsl.g:6332:1: ( ( rule__ComplexTypeImport__ImportURIAssignment_3 ) )
            // InternalTechnologyDsl.g:6333:2: ( rule__ComplexTypeImport__ImportURIAssignment_3 )
            {
             before(grammarAccess.getComplexTypeImportAccess().getImportURIAssignment_3()); 
            // InternalTechnologyDsl.g:6334:2: ( rule__ComplexTypeImport__ImportURIAssignment_3 )
            // InternalTechnologyDsl.g:6334:3: rule__ComplexTypeImport__ImportURIAssignment_3
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
    // InternalTechnologyDsl.g:6342:1: rule__ComplexTypeImport__Group__4 : rule__ComplexTypeImport__Group__4__Impl rule__ComplexTypeImport__Group__5 ;
    public final void rule__ComplexTypeImport__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6346:1: ( rule__ComplexTypeImport__Group__4__Impl rule__ComplexTypeImport__Group__5 )
            // InternalTechnologyDsl.g:6347:2: rule__ComplexTypeImport__Group__4__Impl rule__ComplexTypeImport__Group__5
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
    // InternalTechnologyDsl.g:6354:1: rule__ComplexTypeImport__Group__4__Impl : ( 'as' ) ;
    public final void rule__ComplexTypeImport__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6358:1: ( ( 'as' ) )
            // InternalTechnologyDsl.g:6359:1: ( 'as' )
            {
            // InternalTechnologyDsl.g:6359:1: ( 'as' )
            // InternalTechnologyDsl.g:6360:2: 'as'
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
    // InternalTechnologyDsl.g:6369:1: rule__ComplexTypeImport__Group__5 : rule__ComplexTypeImport__Group__5__Impl ;
    public final void rule__ComplexTypeImport__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6373:1: ( rule__ComplexTypeImport__Group__5__Impl )
            // InternalTechnologyDsl.g:6374:2: rule__ComplexTypeImport__Group__5__Impl
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
    // InternalTechnologyDsl.g:6380:1: rule__ComplexTypeImport__Group__5__Impl : ( ( rule__ComplexTypeImport__NameAssignment_5 ) ) ;
    public final void rule__ComplexTypeImport__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6384:1: ( ( ( rule__ComplexTypeImport__NameAssignment_5 ) ) )
            // InternalTechnologyDsl.g:6385:1: ( ( rule__ComplexTypeImport__NameAssignment_5 ) )
            {
            // InternalTechnologyDsl.g:6385:1: ( ( rule__ComplexTypeImport__NameAssignment_5 ) )
            // InternalTechnologyDsl.g:6386:2: ( rule__ComplexTypeImport__NameAssignment_5 )
            {
             before(grammarAccess.getComplexTypeImportAccess().getNameAssignment_5()); 
            // InternalTechnologyDsl.g:6387:2: ( rule__ComplexTypeImport__NameAssignment_5 )
            // InternalTechnologyDsl.g:6387:3: rule__ComplexTypeImport__NameAssignment_5
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
    // InternalTechnologyDsl.g:6396:1: rule__Version__Group__0 : rule__Version__Group__0__Impl rule__Version__Group__1 ;
    public final void rule__Version__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6400:1: ( rule__Version__Group__0__Impl rule__Version__Group__1 )
            // InternalTechnologyDsl.g:6401:2: rule__Version__Group__0__Impl rule__Version__Group__1
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
    // InternalTechnologyDsl.g:6408:1: rule__Version__Group__0__Impl : ( 'version' ) ;
    public final void rule__Version__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6412:1: ( ( 'version' ) )
            // InternalTechnologyDsl.g:6413:1: ( 'version' )
            {
            // InternalTechnologyDsl.g:6413:1: ( 'version' )
            // InternalTechnologyDsl.g:6414:2: 'version'
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
    // InternalTechnologyDsl.g:6423:1: rule__Version__Group__1 : rule__Version__Group__1__Impl rule__Version__Group__2 ;
    public final void rule__Version__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6427:1: ( rule__Version__Group__1__Impl rule__Version__Group__2 )
            // InternalTechnologyDsl.g:6428:2: rule__Version__Group__1__Impl rule__Version__Group__2
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
    // InternalTechnologyDsl.g:6435:1: rule__Version__Group__1__Impl : ( ( rule__Version__NameAssignment_1 ) ) ;
    public final void rule__Version__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6439:1: ( ( ( rule__Version__NameAssignment_1 ) ) )
            // InternalTechnologyDsl.g:6440:1: ( ( rule__Version__NameAssignment_1 ) )
            {
            // InternalTechnologyDsl.g:6440:1: ( ( rule__Version__NameAssignment_1 ) )
            // InternalTechnologyDsl.g:6441:2: ( rule__Version__NameAssignment_1 )
            {
             before(grammarAccess.getVersionAccess().getNameAssignment_1()); 
            // InternalTechnologyDsl.g:6442:2: ( rule__Version__NameAssignment_1 )
            // InternalTechnologyDsl.g:6442:3: rule__Version__NameAssignment_1
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
    // InternalTechnologyDsl.g:6450:1: rule__Version__Group__2 : rule__Version__Group__2__Impl rule__Version__Group__3 ;
    public final void rule__Version__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6454:1: ( rule__Version__Group__2__Impl rule__Version__Group__3 )
            // InternalTechnologyDsl.g:6455:2: rule__Version__Group__2__Impl rule__Version__Group__3
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
    // InternalTechnologyDsl.g:6462:1: rule__Version__Group__2__Impl : ( '{' ) ;
    public final void rule__Version__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6466:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:6467:1: ( '{' )
            {
            // InternalTechnologyDsl.g:6467:1: ( '{' )
            // InternalTechnologyDsl.g:6468:2: '{'
            {
             before(grammarAccess.getVersionAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,30,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:6477:1: rule__Version__Group__3 : rule__Version__Group__3__Impl rule__Version__Group__4 ;
    public final void rule__Version__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6481:1: ( rule__Version__Group__3__Impl rule__Version__Group__4 )
            // InternalTechnologyDsl.g:6482:2: rule__Version__Group__3__Impl rule__Version__Group__4
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
    // InternalTechnologyDsl.g:6489:1: rule__Version__Group__3__Impl : ( ( rule__Version__Alternatives_3 )? ) ;
    public final void rule__Version__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6493:1: ( ( ( rule__Version__Alternatives_3 )? ) )
            // InternalTechnologyDsl.g:6494:1: ( ( rule__Version__Alternatives_3 )? )
            {
            // InternalTechnologyDsl.g:6494:1: ( ( rule__Version__Alternatives_3 )? )
            // InternalTechnologyDsl.g:6495:2: ( rule__Version__Alternatives_3 )?
            {
             before(grammarAccess.getVersionAccess().getAlternatives_3()); 
            // InternalTechnologyDsl.g:6496:2: ( rule__Version__Alternatives_3 )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( ((LA55_0>=53 && LA55_0<=54)||LA55_0==66) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalTechnologyDsl.g:6496:3: rule__Version__Alternatives_3
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
    // InternalTechnologyDsl.g:6504:1: rule__Version__Group__4 : rule__Version__Group__4__Impl ;
    public final void rule__Version__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6508:1: ( rule__Version__Group__4__Impl )
            // InternalTechnologyDsl.g:6509:2: rule__Version__Group__4__Impl
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
    // InternalTechnologyDsl.g:6515:1: rule__Version__Group__4__Impl : ( '}' ) ;
    public final void rule__Version__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6519:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:6520:1: ( '}' )
            {
            // InternalTechnologyDsl.g:6520:1: ( '}' )
            // InternalTechnologyDsl.g:6521:2: '}'
            {
             before(grammarAccess.getVersionAccess().getRightCurlyBracketKeyword_4()); 
            match(input,31,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:6531:1: rule__Context__Group__0 : rule__Context__Group__0__Impl rule__Context__Group__1 ;
    public final void rule__Context__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6535:1: ( rule__Context__Group__0__Impl rule__Context__Group__1 )
            // InternalTechnologyDsl.g:6536:2: rule__Context__Group__0__Impl rule__Context__Group__1
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
    // InternalTechnologyDsl.g:6543:1: rule__Context__Group__0__Impl : ( 'context' ) ;
    public final void rule__Context__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6547:1: ( ( 'context' ) )
            // InternalTechnologyDsl.g:6548:1: ( 'context' )
            {
            // InternalTechnologyDsl.g:6548:1: ( 'context' )
            // InternalTechnologyDsl.g:6549:2: 'context'
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
    // InternalTechnologyDsl.g:6558:1: rule__Context__Group__1 : rule__Context__Group__1__Impl rule__Context__Group__2 ;
    public final void rule__Context__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6562:1: ( rule__Context__Group__1__Impl rule__Context__Group__2 )
            // InternalTechnologyDsl.g:6563:2: rule__Context__Group__1__Impl rule__Context__Group__2
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
    // InternalTechnologyDsl.g:6570:1: rule__Context__Group__1__Impl : ( ( rule__Context__NameAssignment_1 ) ) ;
    public final void rule__Context__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6574:1: ( ( ( rule__Context__NameAssignment_1 ) ) )
            // InternalTechnologyDsl.g:6575:1: ( ( rule__Context__NameAssignment_1 ) )
            {
            // InternalTechnologyDsl.g:6575:1: ( ( rule__Context__NameAssignment_1 ) )
            // InternalTechnologyDsl.g:6576:2: ( rule__Context__NameAssignment_1 )
            {
             before(grammarAccess.getContextAccess().getNameAssignment_1()); 
            // InternalTechnologyDsl.g:6577:2: ( rule__Context__NameAssignment_1 )
            // InternalTechnologyDsl.g:6577:3: rule__Context__NameAssignment_1
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
    // InternalTechnologyDsl.g:6585:1: rule__Context__Group__2 : rule__Context__Group__2__Impl rule__Context__Group__3 ;
    public final void rule__Context__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6589:1: ( rule__Context__Group__2__Impl rule__Context__Group__3 )
            // InternalTechnologyDsl.g:6590:2: rule__Context__Group__2__Impl rule__Context__Group__3
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
    // InternalTechnologyDsl.g:6597:1: rule__Context__Group__2__Impl : ( '{' ) ;
    public final void rule__Context__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6601:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:6602:1: ( '{' )
            {
            // InternalTechnologyDsl.g:6602:1: ( '{' )
            // InternalTechnologyDsl.g:6603:2: '{'
            {
             before(grammarAccess.getContextAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,30,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:6612:1: rule__Context__Group__3 : rule__Context__Group__3__Impl rule__Context__Group__4 ;
    public final void rule__Context__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6616:1: ( rule__Context__Group__3__Impl rule__Context__Group__4 )
            // InternalTechnologyDsl.g:6617:2: rule__Context__Group__3__Impl rule__Context__Group__4
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
    // InternalTechnologyDsl.g:6624:1: rule__Context__Group__3__Impl : ( ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* ) ) ;
    public final void rule__Context__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6628:1: ( ( ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* ) ) )
            // InternalTechnologyDsl.g:6629:1: ( ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* ) )
            {
            // InternalTechnologyDsl.g:6629:1: ( ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* ) )
            // InternalTechnologyDsl.g:6630:2: ( ( rule__Context__ComplexTypesAssignment_3 ) ) ( ( rule__Context__ComplexTypesAssignment_3 )* )
            {
            // InternalTechnologyDsl.g:6630:2: ( ( rule__Context__ComplexTypesAssignment_3 ) )
            // InternalTechnologyDsl.g:6631:3: ( rule__Context__ComplexTypesAssignment_3 )
            {
             before(grammarAccess.getContextAccess().getComplexTypesAssignment_3()); 
            // InternalTechnologyDsl.g:6632:3: ( rule__Context__ComplexTypesAssignment_3 )
            // InternalTechnologyDsl.g:6632:4: rule__Context__ComplexTypesAssignment_3
            {
            pushFollow(FOLLOW_3);
            rule__Context__ComplexTypesAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getContextAccess().getComplexTypesAssignment_3()); 

            }

            // InternalTechnologyDsl.g:6635:2: ( ( rule__Context__ComplexTypesAssignment_3 )* )
            // InternalTechnologyDsl.g:6636:3: ( rule__Context__ComplexTypesAssignment_3 )*
            {
             before(grammarAccess.getContextAccess().getComplexTypesAssignment_3()); 
            // InternalTechnologyDsl.g:6637:3: ( rule__Context__ComplexTypesAssignment_3 )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( ((LA56_0>=53 && LA56_0<=54)) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalTechnologyDsl.g:6637:4: rule__Context__ComplexTypesAssignment_3
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
    // InternalTechnologyDsl.g:6646:1: rule__Context__Group__4 : rule__Context__Group__4__Impl ;
    public final void rule__Context__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6650:1: ( rule__Context__Group__4__Impl )
            // InternalTechnologyDsl.g:6651:2: rule__Context__Group__4__Impl
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
    // InternalTechnologyDsl.g:6657:1: rule__Context__Group__4__Impl : ( '}' ) ;
    public final void rule__Context__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6661:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:6662:1: ( '}' )
            {
            // InternalTechnologyDsl.g:6662:1: ( '}' )
            // InternalTechnologyDsl.g:6663:2: '}'
            {
             before(grammarAccess.getContextAccess().getRightCurlyBracketKeyword_4()); 
            match(input,31,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:6673:1: rule__DataStructure__Group__0 : rule__DataStructure__Group__0__Impl rule__DataStructure__Group__1 ;
    public final void rule__DataStructure__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6677:1: ( rule__DataStructure__Group__0__Impl rule__DataStructure__Group__1 )
            // InternalTechnologyDsl.g:6678:2: rule__DataStructure__Group__0__Impl rule__DataStructure__Group__1
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
    // InternalTechnologyDsl.g:6685:1: rule__DataStructure__Group__0__Impl : ( 'structure' ) ;
    public final void rule__DataStructure__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6689:1: ( ( 'structure' ) )
            // InternalTechnologyDsl.g:6690:1: ( 'structure' )
            {
            // InternalTechnologyDsl.g:6690:1: ( 'structure' )
            // InternalTechnologyDsl.g:6691:2: 'structure'
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
    // InternalTechnologyDsl.g:6700:1: rule__DataStructure__Group__1 : rule__DataStructure__Group__1__Impl rule__DataStructure__Group__2 ;
    public final void rule__DataStructure__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6704:1: ( rule__DataStructure__Group__1__Impl rule__DataStructure__Group__2 )
            // InternalTechnologyDsl.g:6705:2: rule__DataStructure__Group__1__Impl rule__DataStructure__Group__2
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
    // InternalTechnologyDsl.g:6712:1: rule__DataStructure__Group__1__Impl : ( ( rule__DataStructure__NameAssignment_1 ) ) ;
    public final void rule__DataStructure__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6716:1: ( ( ( rule__DataStructure__NameAssignment_1 ) ) )
            // InternalTechnologyDsl.g:6717:1: ( ( rule__DataStructure__NameAssignment_1 ) )
            {
            // InternalTechnologyDsl.g:6717:1: ( ( rule__DataStructure__NameAssignment_1 ) )
            // InternalTechnologyDsl.g:6718:2: ( rule__DataStructure__NameAssignment_1 )
            {
             before(grammarAccess.getDataStructureAccess().getNameAssignment_1()); 
            // InternalTechnologyDsl.g:6719:2: ( rule__DataStructure__NameAssignment_1 )
            // InternalTechnologyDsl.g:6719:3: rule__DataStructure__NameAssignment_1
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
    // InternalTechnologyDsl.g:6727:1: rule__DataStructure__Group__2 : rule__DataStructure__Group__2__Impl rule__DataStructure__Group__3 ;
    public final void rule__DataStructure__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6731:1: ( rule__DataStructure__Group__2__Impl rule__DataStructure__Group__3 )
            // InternalTechnologyDsl.g:6732:2: rule__DataStructure__Group__2__Impl rule__DataStructure__Group__3
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
    // InternalTechnologyDsl.g:6739:1: rule__DataStructure__Group__2__Impl : ( ( rule__DataStructure__Group_2__0 )? ) ;
    public final void rule__DataStructure__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6743:1: ( ( ( rule__DataStructure__Group_2__0 )? ) )
            // InternalTechnologyDsl.g:6744:1: ( ( rule__DataStructure__Group_2__0 )? )
            {
            // InternalTechnologyDsl.g:6744:1: ( ( rule__DataStructure__Group_2__0 )? )
            // InternalTechnologyDsl.g:6745:2: ( rule__DataStructure__Group_2__0 )?
            {
             before(grammarAccess.getDataStructureAccess().getGroup_2()); 
            // InternalTechnologyDsl.g:6746:2: ( rule__DataStructure__Group_2__0 )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==67) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalTechnologyDsl.g:6746:3: rule__DataStructure__Group_2__0
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
    // InternalTechnologyDsl.g:6754:1: rule__DataStructure__Group__3 : rule__DataStructure__Group__3__Impl rule__DataStructure__Group__4 ;
    public final void rule__DataStructure__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6758:1: ( rule__DataStructure__Group__3__Impl rule__DataStructure__Group__4 )
            // InternalTechnologyDsl.g:6759:2: rule__DataStructure__Group__3__Impl rule__DataStructure__Group__4
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
    // InternalTechnologyDsl.g:6766:1: rule__DataStructure__Group__3__Impl : ( '{' ) ;
    public final void rule__DataStructure__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6770:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:6771:1: ( '{' )
            {
            // InternalTechnologyDsl.g:6771:1: ( '{' )
            // InternalTechnologyDsl.g:6772:2: '{'
            {
             before(grammarAccess.getDataStructureAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,30,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:6781:1: rule__DataStructure__Group__4 : rule__DataStructure__Group__4__Impl rule__DataStructure__Group__5 ;
    public final void rule__DataStructure__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6785:1: ( rule__DataStructure__Group__4__Impl rule__DataStructure__Group__5 )
            // InternalTechnologyDsl.g:6786:2: rule__DataStructure__Group__4__Impl rule__DataStructure__Group__5
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
    // InternalTechnologyDsl.g:6793:1: rule__DataStructure__Group__4__Impl : ( ( rule__DataStructure__Group_4__0 )? ) ;
    public final void rule__DataStructure__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6797:1: ( ( ( rule__DataStructure__Group_4__0 )? ) )
            // InternalTechnologyDsl.g:6798:1: ( ( rule__DataStructure__Group_4__0 )? )
            {
            // InternalTechnologyDsl.g:6798:1: ( ( rule__DataStructure__Group_4__0 )? )
            // InternalTechnologyDsl.g:6799:2: ( rule__DataStructure__Group_4__0 )?
            {
             before(grammarAccess.getDataStructureAccess().getGroup_4()); 
            // InternalTechnologyDsl.g:6800:2: ( rule__DataStructure__Group_4__0 )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==RULE_ID||(LA58_0>=68 && LA58_0<=77)||LA58_0==85) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalTechnologyDsl.g:6800:3: rule__DataStructure__Group_4__0
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
    // InternalTechnologyDsl.g:6808:1: rule__DataStructure__Group__5 : rule__DataStructure__Group__5__Impl ;
    public final void rule__DataStructure__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6812:1: ( rule__DataStructure__Group__5__Impl )
            // InternalTechnologyDsl.g:6813:2: rule__DataStructure__Group__5__Impl
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
    // InternalTechnologyDsl.g:6819:1: rule__DataStructure__Group__5__Impl : ( '}' ) ;
    public final void rule__DataStructure__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6823:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:6824:1: ( '}' )
            {
            // InternalTechnologyDsl.g:6824:1: ( '}' )
            // InternalTechnologyDsl.g:6825:2: '}'
            {
             before(grammarAccess.getDataStructureAccess().getRightCurlyBracketKeyword_5()); 
            match(input,31,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:6835:1: rule__DataStructure__Group_2__0 : rule__DataStructure__Group_2__0__Impl rule__DataStructure__Group_2__1 ;
    public final void rule__DataStructure__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6839:1: ( rule__DataStructure__Group_2__0__Impl rule__DataStructure__Group_2__1 )
            // InternalTechnologyDsl.g:6840:2: rule__DataStructure__Group_2__0__Impl rule__DataStructure__Group_2__1
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
    // InternalTechnologyDsl.g:6847:1: rule__DataStructure__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__DataStructure__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6851:1: ( ( 'extends' ) )
            // InternalTechnologyDsl.g:6852:1: ( 'extends' )
            {
            // InternalTechnologyDsl.g:6852:1: ( 'extends' )
            // InternalTechnologyDsl.g:6853:2: 'extends'
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
    // InternalTechnologyDsl.g:6862:1: rule__DataStructure__Group_2__1 : rule__DataStructure__Group_2__1__Impl ;
    public final void rule__DataStructure__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6866:1: ( rule__DataStructure__Group_2__1__Impl )
            // InternalTechnologyDsl.g:6867:2: rule__DataStructure__Group_2__1__Impl
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
    // InternalTechnologyDsl.g:6873:1: rule__DataStructure__Group_2__1__Impl : ( ( rule__DataStructure__SuperAssignment_2_1 ) ) ;
    public final void rule__DataStructure__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6877:1: ( ( ( rule__DataStructure__SuperAssignment_2_1 ) ) )
            // InternalTechnologyDsl.g:6878:1: ( ( rule__DataStructure__SuperAssignment_2_1 ) )
            {
            // InternalTechnologyDsl.g:6878:1: ( ( rule__DataStructure__SuperAssignment_2_1 ) )
            // InternalTechnologyDsl.g:6879:2: ( rule__DataStructure__SuperAssignment_2_1 )
            {
             before(grammarAccess.getDataStructureAccess().getSuperAssignment_2_1()); 
            // InternalTechnologyDsl.g:6880:2: ( rule__DataStructure__SuperAssignment_2_1 )
            // InternalTechnologyDsl.g:6880:3: rule__DataStructure__SuperAssignment_2_1
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
    // InternalTechnologyDsl.g:6889:1: rule__DataStructure__Group_4__0 : rule__DataStructure__Group_4__0__Impl rule__DataStructure__Group_4__1 ;
    public final void rule__DataStructure__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6893:1: ( rule__DataStructure__Group_4__0__Impl rule__DataStructure__Group_4__1 )
            // InternalTechnologyDsl.g:6894:2: rule__DataStructure__Group_4__0__Impl rule__DataStructure__Group_4__1
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
    // InternalTechnologyDsl.g:6901:1: rule__DataStructure__Group_4__0__Impl : ( ( rule__DataStructure__DataFieldsAssignment_4_0 ) ) ;
    public final void rule__DataStructure__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6905:1: ( ( ( rule__DataStructure__DataFieldsAssignment_4_0 ) ) )
            // InternalTechnologyDsl.g:6906:1: ( ( rule__DataStructure__DataFieldsAssignment_4_0 ) )
            {
            // InternalTechnologyDsl.g:6906:1: ( ( rule__DataStructure__DataFieldsAssignment_4_0 ) )
            // InternalTechnologyDsl.g:6907:2: ( rule__DataStructure__DataFieldsAssignment_4_0 )
            {
             before(grammarAccess.getDataStructureAccess().getDataFieldsAssignment_4_0()); 
            // InternalTechnologyDsl.g:6908:2: ( rule__DataStructure__DataFieldsAssignment_4_0 )
            // InternalTechnologyDsl.g:6908:3: rule__DataStructure__DataFieldsAssignment_4_0
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
    // InternalTechnologyDsl.g:6916:1: rule__DataStructure__Group_4__1 : rule__DataStructure__Group_4__1__Impl ;
    public final void rule__DataStructure__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6920:1: ( rule__DataStructure__Group_4__1__Impl )
            // InternalTechnologyDsl.g:6921:2: rule__DataStructure__Group_4__1__Impl
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
    // InternalTechnologyDsl.g:6927:1: rule__DataStructure__Group_4__1__Impl : ( ( rule__DataStructure__Group_4_1__0 )* ) ;
    public final void rule__DataStructure__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6931:1: ( ( ( rule__DataStructure__Group_4_1__0 )* ) )
            // InternalTechnologyDsl.g:6932:1: ( ( rule__DataStructure__Group_4_1__0 )* )
            {
            // InternalTechnologyDsl.g:6932:1: ( ( rule__DataStructure__Group_4_1__0 )* )
            // InternalTechnologyDsl.g:6933:2: ( rule__DataStructure__Group_4_1__0 )*
            {
             before(grammarAccess.getDataStructureAccess().getGroup_4_1()); 
            // InternalTechnologyDsl.g:6934:2: ( rule__DataStructure__Group_4_1__0 )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==46) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalTechnologyDsl.g:6934:3: rule__DataStructure__Group_4_1__0
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
    // InternalTechnologyDsl.g:6943:1: rule__DataStructure__Group_4_1__0 : rule__DataStructure__Group_4_1__0__Impl rule__DataStructure__Group_4_1__1 ;
    public final void rule__DataStructure__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6947:1: ( rule__DataStructure__Group_4_1__0__Impl rule__DataStructure__Group_4_1__1 )
            // InternalTechnologyDsl.g:6948:2: rule__DataStructure__Group_4_1__0__Impl rule__DataStructure__Group_4_1__1
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
    // InternalTechnologyDsl.g:6955:1: rule__DataStructure__Group_4_1__0__Impl : ( ',' ) ;
    public final void rule__DataStructure__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6959:1: ( ( ',' ) )
            // InternalTechnologyDsl.g:6960:1: ( ',' )
            {
            // InternalTechnologyDsl.g:6960:1: ( ',' )
            // InternalTechnologyDsl.g:6961:2: ','
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
    // InternalTechnologyDsl.g:6970:1: rule__DataStructure__Group_4_1__1 : rule__DataStructure__Group_4_1__1__Impl ;
    public final void rule__DataStructure__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6974:1: ( rule__DataStructure__Group_4_1__1__Impl )
            // InternalTechnologyDsl.g:6975:2: rule__DataStructure__Group_4_1__1__Impl
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
    // InternalTechnologyDsl.g:6981:1: rule__DataStructure__Group_4_1__1__Impl : ( ( rule__DataStructure__DataFieldsAssignment_4_1_1 ) ) ;
    public final void rule__DataStructure__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:6985:1: ( ( ( rule__DataStructure__DataFieldsAssignment_4_1_1 ) ) )
            // InternalTechnologyDsl.g:6986:1: ( ( rule__DataStructure__DataFieldsAssignment_4_1_1 ) )
            {
            // InternalTechnologyDsl.g:6986:1: ( ( rule__DataStructure__DataFieldsAssignment_4_1_1 ) )
            // InternalTechnologyDsl.g:6987:2: ( rule__DataStructure__DataFieldsAssignment_4_1_1 )
            {
             before(grammarAccess.getDataStructureAccess().getDataFieldsAssignment_4_1_1()); 
            // InternalTechnologyDsl.g:6988:2: ( rule__DataStructure__DataFieldsAssignment_4_1_1 )
            // InternalTechnologyDsl.g:6988:3: rule__DataStructure__DataFieldsAssignment_4_1_1
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
    // InternalTechnologyDsl.g:6997:1: rule__ListType__Group_0__0 : rule__ListType__Group_0__0__Impl rule__ListType__Group_0__1 ;
    public final void rule__ListType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7001:1: ( rule__ListType__Group_0__0__Impl rule__ListType__Group_0__1 )
            // InternalTechnologyDsl.g:7002:2: rule__ListType__Group_0__0__Impl rule__ListType__Group_0__1
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
    // InternalTechnologyDsl.g:7009:1: rule__ListType__Group_0__0__Impl : ( 'list' ) ;
    public final void rule__ListType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7013:1: ( ( 'list' ) )
            // InternalTechnologyDsl.g:7014:1: ( 'list' )
            {
            // InternalTechnologyDsl.g:7014:1: ( 'list' )
            // InternalTechnologyDsl.g:7015:2: 'list'
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
    // InternalTechnologyDsl.g:7024:1: rule__ListType__Group_0__1 : rule__ListType__Group_0__1__Impl rule__ListType__Group_0__2 ;
    public final void rule__ListType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7028:1: ( rule__ListType__Group_0__1__Impl rule__ListType__Group_0__2 )
            // InternalTechnologyDsl.g:7029:2: rule__ListType__Group_0__1__Impl rule__ListType__Group_0__2
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
    // InternalTechnologyDsl.g:7036:1: rule__ListType__Group_0__1__Impl : ( ( rule__ListType__NameAssignment_0_1 ) ) ;
    public final void rule__ListType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7040:1: ( ( ( rule__ListType__NameAssignment_0_1 ) ) )
            // InternalTechnologyDsl.g:7041:1: ( ( rule__ListType__NameAssignment_0_1 ) )
            {
            // InternalTechnologyDsl.g:7041:1: ( ( rule__ListType__NameAssignment_0_1 ) )
            // InternalTechnologyDsl.g:7042:2: ( rule__ListType__NameAssignment_0_1 )
            {
             before(grammarAccess.getListTypeAccess().getNameAssignment_0_1()); 
            // InternalTechnologyDsl.g:7043:2: ( rule__ListType__NameAssignment_0_1 )
            // InternalTechnologyDsl.g:7043:3: rule__ListType__NameAssignment_0_1
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
    // InternalTechnologyDsl.g:7051:1: rule__ListType__Group_0__2 : rule__ListType__Group_0__2__Impl rule__ListType__Group_0__3 ;
    public final void rule__ListType__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7055:1: ( rule__ListType__Group_0__2__Impl rule__ListType__Group_0__3 )
            // InternalTechnologyDsl.g:7056:2: rule__ListType__Group_0__2__Impl rule__ListType__Group_0__3
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
    // InternalTechnologyDsl.g:7063:1: rule__ListType__Group_0__2__Impl : ( '{' ) ;
    public final void rule__ListType__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7067:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:7068:1: ( '{' )
            {
            // InternalTechnologyDsl.g:7068:1: ( '{' )
            // InternalTechnologyDsl.g:7069:2: '{'
            {
             before(grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_0_2()); 
            match(input,30,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:7078:1: rule__ListType__Group_0__3 : rule__ListType__Group_0__3__Impl rule__ListType__Group_0__4 ;
    public final void rule__ListType__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7082:1: ( rule__ListType__Group_0__3__Impl rule__ListType__Group_0__4 )
            // InternalTechnologyDsl.g:7083:2: rule__ListType__Group_0__3__Impl rule__ListType__Group_0__4
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
    // InternalTechnologyDsl.g:7090:1: rule__ListType__Group_0__3__Impl : ( ( rule__ListType__DataFieldsAssignment_0_3 ) ) ;
    public final void rule__ListType__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7094:1: ( ( ( rule__ListType__DataFieldsAssignment_0_3 ) ) )
            // InternalTechnologyDsl.g:7095:1: ( ( rule__ListType__DataFieldsAssignment_0_3 ) )
            {
            // InternalTechnologyDsl.g:7095:1: ( ( rule__ListType__DataFieldsAssignment_0_3 ) )
            // InternalTechnologyDsl.g:7096:2: ( rule__ListType__DataFieldsAssignment_0_3 )
            {
             before(grammarAccess.getListTypeAccess().getDataFieldsAssignment_0_3()); 
            // InternalTechnologyDsl.g:7097:2: ( rule__ListType__DataFieldsAssignment_0_3 )
            // InternalTechnologyDsl.g:7097:3: rule__ListType__DataFieldsAssignment_0_3
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
    // InternalTechnologyDsl.g:7105:1: rule__ListType__Group_0__4 : rule__ListType__Group_0__4__Impl rule__ListType__Group_0__5 ;
    public final void rule__ListType__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7109:1: ( rule__ListType__Group_0__4__Impl rule__ListType__Group_0__5 )
            // InternalTechnologyDsl.g:7110:2: rule__ListType__Group_0__4__Impl rule__ListType__Group_0__5
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
    // InternalTechnologyDsl.g:7117:1: rule__ListType__Group_0__4__Impl : ( ( rule__ListType__Group_0_4__0 )* ) ;
    public final void rule__ListType__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7121:1: ( ( ( rule__ListType__Group_0_4__0 )* ) )
            // InternalTechnologyDsl.g:7122:1: ( ( rule__ListType__Group_0_4__0 )* )
            {
            // InternalTechnologyDsl.g:7122:1: ( ( rule__ListType__Group_0_4__0 )* )
            // InternalTechnologyDsl.g:7123:2: ( rule__ListType__Group_0_4__0 )*
            {
             before(grammarAccess.getListTypeAccess().getGroup_0_4()); 
            // InternalTechnologyDsl.g:7124:2: ( rule__ListType__Group_0_4__0 )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==46) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalTechnologyDsl.g:7124:3: rule__ListType__Group_0_4__0
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
    // InternalTechnologyDsl.g:7132:1: rule__ListType__Group_0__5 : rule__ListType__Group_0__5__Impl ;
    public final void rule__ListType__Group_0__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7136:1: ( rule__ListType__Group_0__5__Impl )
            // InternalTechnologyDsl.g:7137:2: rule__ListType__Group_0__5__Impl
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
    // InternalTechnologyDsl.g:7143:1: rule__ListType__Group_0__5__Impl : ( '}' ) ;
    public final void rule__ListType__Group_0__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7147:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:7148:1: ( '}' )
            {
            // InternalTechnologyDsl.g:7148:1: ( '}' )
            // InternalTechnologyDsl.g:7149:2: '}'
            {
             before(grammarAccess.getListTypeAccess().getRightCurlyBracketKeyword_0_5()); 
            match(input,31,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:7159:1: rule__ListType__Group_0_4__0 : rule__ListType__Group_0_4__0__Impl rule__ListType__Group_0_4__1 ;
    public final void rule__ListType__Group_0_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7163:1: ( rule__ListType__Group_0_4__0__Impl rule__ListType__Group_0_4__1 )
            // InternalTechnologyDsl.g:7164:2: rule__ListType__Group_0_4__0__Impl rule__ListType__Group_0_4__1
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
    // InternalTechnologyDsl.g:7171:1: rule__ListType__Group_0_4__0__Impl : ( ',' ) ;
    public final void rule__ListType__Group_0_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7175:1: ( ( ',' ) )
            // InternalTechnologyDsl.g:7176:1: ( ',' )
            {
            // InternalTechnologyDsl.g:7176:1: ( ',' )
            // InternalTechnologyDsl.g:7177:2: ','
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
    // InternalTechnologyDsl.g:7186:1: rule__ListType__Group_0_4__1 : rule__ListType__Group_0_4__1__Impl ;
    public final void rule__ListType__Group_0_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7190:1: ( rule__ListType__Group_0_4__1__Impl )
            // InternalTechnologyDsl.g:7191:2: rule__ListType__Group_0_4__1__Impl
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
    // InternalTechnologyDsl.g:7197:1: rule__ListType__Group_0_4__1__Impl : ( ( rule__ListType__DataFieldsAssignment_0_4_1 ) ) ;
    public final void rule__ListType__Group_0_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7201:1: ( ( ( rule__ListType__DataFieldsAssignment_0_4_1 ) ) )
            // InternalTechnologyDsl.g:7202:1: ( ( rule__ListType__DataFieldsAssignment_0_4_1 ) )
            {
            // InternalTechnologyDsl.g:7202:1: ( ( rule__ListType__DataFieldsAssignment_0_4_1 ) )
            // InternalTechnologyDsl.g:7203:2: ( rule__ListType__DataFieldsAssignment_0_4_1 )
            {
             before(grammarAccess.getListTypeAccess().getDataFieldsAssignment_0_4_1()); 
            // InternalTechnologyDsl.g:7204:2: ( rule__ListType__DataFieldsAssignment_0_4_1 )
            // InternalTechnologyDsl.g:7204:3: rule__ListType__DataFieldsAssignment_0_4_1
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
    // InternalTechnologyDsl.g:7213:1: rule__ListType__Group_1__0 : rule__ListType__Group_1__0__Impl rule__ListType__Group_1__1 ;
    public final void rule__ListType__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7217:1: ( rule__ListType__Group_1__0__Impl rule__ListType__Group_1__1 )
            // InternalTechnologyDsl.g:7218:2: rule__ListType__Group_1__0__Impl rule__ListType__Group_1__1
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
    // InternalTechnologyDsl.g:7225:1: rule__ListType__Group_1__0__Impl : ( 'list' ) ;
    public final void rule__ListType__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7229:1: ( ( 'list' ) )
            // InternalTechnologyDsl.g:7230:1: ( 'list' )
            {
            // InternalTechnologyDsl.g:7230:1: ( 'list' )
            // InternalTechnologyDsl.g:7231:2: 'list'
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
    // InternalTechnologyDsl.g:7240:1: rule__ListType__Group_1__1 : rule__ListType__Group_1__1__Impl rule__ListType__Group_1__2 ;
    public final void rule__ListType__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7244:1: ( rule__ListType__Group_1__1__Impl rule__ListType__Group_1__2 )
            // InternalTechnologyDsl.g:7245:2: rule__ListType__Group_1__1__Impl rule__ListType__Group_1__2
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
    // InternalTechnologyDsl.g:7252:1: rule__ListType__Group_1__1__Impl : ( ( rule__ListType__NameAssignment_1_1 ) ) ;
    public final void rule__ListType__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7256:1: ( ( ( rule__ListType__NameAssignment_1_1 ) ) )
            // InternalTechnologyDsl.g:7257:1: ( ( rule__ListType__NameAssignment_1_1 ) )
            {
            // InternalTechnologyDsl.g:7257:1: ( ( rule__ListType__NameAssignment_1_1 ) )
            // InternalTechnologyDsl.g:7258:2: ( rule__ListType__NameAssignment_1_1 )
            {
             before(grammarAccess.getListTypeAccess().getNameAssignment_1_1()); 
            // InternalTechnologyDsl.g:7259:2: ( rule__ListType__NameAssignment_1_1 )
            // InternalTechnologyDsl.g:7259:3: rule__ListType__NameAssignment_1_1
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
    // InternalTechnologyDsl.g:7267:1: rule__ListType__Group_1__2 : rule__ListType__Group_1__2__Impl rule__ListType__Group_1__3 ;
    public final void rule__ListType__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7271:1: ( rule__ListType__Group_1__2__Impl rule__ListType__Group_1__3 )
            // InternalTechnologyDsl.g:7272:2: rule__ListType__Group_1__2__Impl rule__ListType__Group_1__3
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
    // InternalTechnologyDsl.g:7279:1: rule__ListType__Group_1__2__Impl : ( '{' ) ;
    public final void rule__ListType__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7283:1: ( ( '{' ) )
            // InternalTechnologyDsl.g:7284:1: ( '{' )
            {
            // InternalTechnologyDsl.g:7284:1: ( '{' )
            // InternalTechnologyDsl.g:7285:2: '{'
            {
             before(grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_1_2()); 
            match(input,30,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:7294:1: rule__ListType__Group_1__3 : rule__ListType__Group_1__3__Impl rule__ListType__Group_1__4 ;
    public final void rule__ListType__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7298:1: ( rule__ListType__Group_1__3__Impl rule__ListType__Group_1__4 )
            // InternalTechnologyDsl.g:7299:2: rule__ListType__Group_1__3__Impl rule__ListType__Group_1__4
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
    // InternalTechnologyDsl.g:7306:1: rule__ListType__Group_1__3__Impl : ( ( rule__ListType__PrimitiveTypeAssignment_1_3 ) ) ;
    public final void rule__ListType__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7310:1: ( ( ( rule__ListType__PrimitiveTypeAssignment_1_3 ) ) )
            // InternalTechnologyDsl.g:7311:1: ( ( rule__ListType__PrimitiveTypeAssignment_1_3 ) )
            {
            // InternalTechnologyDsl.g:7311:1: ( ( rule__ListType__PrimitiveTypeAssignment_1_3 ) )
            // InternalTechnologyDsl.g:7312:2: ( rule__ListType__PrimitiveTypeAssignment_1_3 )
            {
             before(grammarAccess.getListTypeAccess().getPrimitiveTypeAssignment_1_3()); 
            // InternalTechnologyDsl.g:7313:2: ( rule__ListType__PrimitiveTypeAssignment_1_3 )
            // InternalTechnologyDsl.g:7313:3: rule__ListType__PrimitiveTypeAssignment_1_3
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
    // InternalTechnologyDsl.g:7321:1: rule__ListType__Group_1__4 : rule__ListType__Group_1__4__Impl ;
    public final void rule__ListType__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7325:1: ( rule__ListType__Group_1__4__Impl )
            // InternalTechnologyDsl.g:7326:2: rule__ListType__Group_1__4__Impl
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
    // InternalTechnologyDsl.g:7332:1: rule__ListType__Group_1__4__Impl : ( '}' ) ;
    public final void rule__ListType__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7336:1: ( ( '}' ) )
            // InternalTechnologyDsl.g:7337:1: ( '}' )
            {
            // InternalTechnologyDsl.g:7337:1: ( '}' )
            // InternalTechnologyDsl.g:7338:2: '}'
            {
             before(grammarAccess.getListTypeAccess().getRightCurlyBracketKeyword_1_4()); 
            match(input,31,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:7348:1: rule__DataField__Group__0 : rule__DataField__Group__0__Impl rule__DataField__Group__1 ;
    public final void rule__DataField__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7352:1: ( rule__DataField__Group__0__Impl rule__DataField__Group__1 )
            // InternalTechnologyDsl.g:7353:2: rule__DataField__Group__0__Impl rule__DataField__Group__1
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
    // InternalTechnologyDsl.g:7360:1: rule__DataField__Group__0__Impl : ( ( rule__DataField__HiddenAssignment_0 )? ) ;
    public final void rule__DataField__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7364:1: ( ( ( rule__DataField__HiddenAssignment_0 )? ) )
            // InternalTechnologyDsl.g:7365:1: ( ( rule__DataField__HiddenAssignment_0 )? )
            {
            // InternalTechnologyDsl.g:7365:1: ( ( rule__DataField__HiddenAssignment_0 )? )
            // InternalTechnologyDsl.g:7366:2: ( rule__DataField__HiddenAssignment_0 )?
            {
             before(grammarAccess.getDataFieldAccess().getHiddenAssignment_0()); 
            // InternalTechnologyDsl.g:7367:2: ( rule__DataField__HiddenAssignment_0 )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==85) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalTechnologyDsl.g:7367:3: rule__DataField__HiddenAssignment_0
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
    // InternalTechnologyDsl.g:7375:1: rule__DataField__Group__1 : rule__DataField__Group__1__Impl rule__DataField__Group__2 ;
    public final void rule__DataField__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7379:1: ( rule__DataField__Group__1__Impl rule__DataField__Group__2 )
            // InternalTechnologyDsl.g:7380:2: rule__DataField__Group__1__Impl rule__DataField__Group__2
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
    // InternalTechnologyDsl.g:7387:1: rule__DataField__Group__1__Impl : ( ( rule__DataField__Alternatives_1 )? ) ;
    public final void rule__DataField__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7391:1: ( ( ( rule__DataField__Alternatives_1 )? ) )
            // InternalTechnologyDsl.g:7392:1: ( ( rule__DataField__Alternatives_1 )? )
            {
            // InternalTechnologyDsl.g:7392:1: ( ( rule__DataField__Alternatives_1 )? )
            // InternalTechnologyDsl.g:7393:2: ( rule__DataField__Alternatives_1 )?
            {
             before(grammarAccess.getDataFieldAccess().getAlternatives_1()); 
            // InternalTechnologyDsl.g:7394:2: ( rule__DataField__Alternatives_1 )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( ((LA62_0>=68 && LA62_0<=77)) ) {
                alt62=1;
            }
            else if ( (LA62_0==RULE_ID) ) {
                int LA62_2 = input.LA(2);

                if ( (LA62_2==RULE_ID||LA62_2==55||LA62_2==78) ) {
                    alt62=1;
                }
            }
            switch (alt62) {
                case 1 :
                    // InternalTechnologyDsl.g:7394:3: rule__DataField__Alternatives_1
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
    // InternalTechnologyDsl.g:7402:1: rule__DataField__Group__2 : rule__DataField__Group__2__Impl ;
    public final void rule__DataField__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7406:1: ( rule__DataField__Group__2__Impl )
            // InternalTechnologyDsl.g:7407:2: rule__DataField__Group__2__Impl
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
    // InternalTechnologyDsl.g:7413:1: rule__DataField__Group__2__Impl : ( ( rule__DataField__NameAssignment_2 ) ) ;
    public final void rule__DataField__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7417:1: ( ( ( rule__DataField__NameAssignment_2 ) ) )
            // InternalTechnologyDsl.g:7418:1: ( ( rule__DataField__NameAssignment_2 ) )
            {
            // InternalTechnologyDsl.g:7418:1: ( ( rule__DataField__NameAssignment_2 ) )
            // InternalTechnologyDsl.g:7419:2: ( rule__DataField__NameAssignment_2 )
            {
             before(grammarAccess.getDataFieldAccess().getNameAssignment_2()); 
            // InternalTechnologyDsl.g:7420:2: ( rule__DataField__NameAssignment_2 )
            // InternalTechnologyDsl.g:7420:3: rule__DataField__NameAssignment_2
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
    // InternalTechnologyDsl.g:7429:1: rule__PossiblyImportedComplexType__Group__0 : rule__PossiblyImportedComplexType__Group__0__Impl rule__PossiblyImportedComplexType__Group__1 ;
    public final void rule__PossiblyImportedComplexType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7433:1: ( rule__PossiblyImportedComplexType__Group__0__Impl rule__PossiblyImportedComplexType__Group__1 )
            // InternalTechnologyDsl.g:7434:2: rule__PossiblyImportedComplexType__Group__0__Impl rule__PossiblyImportedComplexType__Group__1
            {
            pushFollow(FOLLOW_68);
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
    // InternalTechnologyDsl.g:7441:1: rule__PossiblyImportedComplexType__Group__0__Impl : ( ( rule__PossiblyImportedComplexType__Group_0__0 )? ) ;
    public final void rule__PossiblyImportedComplexType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7445:1: ( ( ( rule__PossiblyImportedComplexType__Group_0__0 )? ) )
            // InternalTechnologyDsl.g:7446:1: ( ( rule__PossiblyImportedComplexType__Group_0__0 )? )
            {
            // InternalTechnologyDsl.g:7446:1: ( ( rule__PossiblyImportedComplexType__Group_0__0 )? )
            // InternalTechnologyDsl.g:7447:2: ( rule__PossiblyImportedComplexType__Group_0__0 )?
            {
             before(grammarAccess.getPossiblyImportedComplexTypeAccess().getGroup_0()); 
            // InternalTechnologyDsl.g:7448:2: ( rule__PossiblyImportedComplexType__Group_0__0 )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==RULE_ID) ) {
                int LA63_1 = input.LA(2);

                if ( (LA63_1==55) ) {
                    alt63=1;
                }
            }
            switch (alt63) {
                case 1 :
                    // InternalTechnologyDsl.g:7448:3: rule__PossiblyImportedComplexType__Group_0__0
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
    // InternalTechnologyDsl.g:7456:1: rule__PossiblyImportedComplexType__Group__1 : rule__PossiblyImportedComplexType__Group__1__Impl ;
    public final void rule__PossiblyImportedComplexType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7460:1: ( rule__PossiblyImportedComplexType__Group__1__Impl )
            // InternalTechnologyDsl.g:7461:2: rule__PossiblyImportedComplexType__Group__1__Impl
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
    // InternalTechnologyDsl.g:7467:1: rule__PossiblyImportedComplexType__Group__1__Impl : ( ( rule__PossiblyImportedComplexType__ComplexTypeAssignment_1 ) ) ;
    public final void rule__PossiblyImportedComplexType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7471:1: ( ( ( rule__PossiblyImportedComplexType__ComplexTypeAssignment_1 ) ) )
            // InternalTechnologyDsl.g:7472:1: ( ( rule__PossiblyImportedComplexType__ComplexTypeAssignment_1 ) )
            {
            // InternalTechnologyDsl.g:7472:1: ( ( rule__PossiblyImportedComplexType__ComplexTypeAssignment_1 ) )
            // InternalTechnologyDsl.g:7473:2: ( rule__PossiblyImportedComplexType__ComplexTypeAssignment_1 )
            {
             before(grammarAccess.getPossiblyImportedComplexTypeAccess().getComplexTypeAssignment_1()); 
            // InternalTechnologyDsl.g:7474:2: ( rule__PossiblyImportedComplexType__ComplexTypeAssignment_1 )
            // InternalTechnologyDsl.g:7474:3: rule__PossiblyImportedComplexType__ComplexTypeAssignment_1
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
    // InternalTechnologyDsl.g:7483:1: rule__PossiblyImportedComplexType__Group_0__0 : rule__PossiblyImportedComplexType__Group_0__0__Impl rule__PossiblyImportedComplexType__Group_0__1 ;
    public final void rule__PossiblyImportedComplexType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7487:1: ( rule__PossiblyImportedComplexType__Group_0__0__Impl rule__PossiblyImportedComplexType__Group_0__1 )
            // InternalTechnologyDsl.g:7488:2: rule__PossiblyImportedComplexType__Group_0__0__Impl rule__PossiblyImportedComplexType__Group_0__1
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
    // InternalTechnologyDsl.g:7495:1: rule__PossiblyImportedComplexType__Group_0__0__Impl : ( ( rule__PossiblyImportedComplexType__ImportAssignment_0_0 ) ) ;
    public final void rule__PossiblyImportedComplexType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7499:1: ( ( ( rule__PossiblyImportedComplexType__ImportAssignment_0_0 ) ) )
            // InternalTechnologyDsl.g:7500:1: ( ( rule__PossiblyImportedComplexType__ImportAssignment_0_0 ) )
            {
            // InternalTechnologyDsl.g:7500:1: ( ( rule__PossiblyImportedComplexType__ImportAssignment_0_0 ) )
            // InternalTechnologyDsl.g:7501:2: ( rule__PossiblyImportedComplexType__ImportAssignment_0_0 )
            {
             before(grammarAccess.getPossiblyImportedComplexTypeAccess().getImportAssignment_0_0()); 
            // InternalTechnologyDsl.g:7502:2: ( rule__PossiblyImportedComplexType__ImportAssignment_0_0 )
            // InternalTechnologyDsl.g:7502:3: rule__PossiblyImportedComplexType__ImportAssignment_0_0
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
    // InternalTechnologyDsl.g:7510:1: rule__PossiblyImportedComplexType__Group_0__1 : rule__PossiblyImportedComplexType__Group_0__1__Impl ;
    public final void rule__PossiblyImportedComplexType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7514:1: ( rule__PossiblyImportedComplexType__Group_0__1__Impl )
            // InternalTechnologyDsl.g:7515:2: rule__PossiblyImportedComplexType__Group_0__1__Impl
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
    // InternalTechnologyDsl.g:7521:1: rule__PossiblyImportedComplexType__Group_0__1__Impl : ( '::' ) ;
    public final void rule__PossiblyImportedComplexType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7525:1: ( ( '::' ) )
            // InternalTechnologyDsl.g:7526:1: ( '::' )
            {
            // InternalTechnologyDsl.g:7526:1: ( '::' )
            // InternalTechnologyDsl.g:7527:2: '::'
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
    // InternalTechnologyDsl.g:7537:1: rule__PrimitiveType__Group_0__0 : rule__PrimitiveType__Group_0__0__Impl rule__PrimitiveType__Group_0__1 ;
    public final void rule__PrimitiveType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7541:1: ( rule__PrimitiveType__Group_0__0__Impl rule__PrimitiveType__Group_0__1 )
            // InternalTechnologyDsl.g:7542:2: rule__PrimitiveType__Group_0__0__Impl rule__PrimitiveType__Group_0__1
            {
            pushFollow(FOLLOW_69);
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
    // InternalTechnologyDsl.g:7549:1: rule__PrimitiveType__Group_0__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7553:1: ( ( () ) )
            // InternalTechnologyDsl.g:7554:1: ( () )
            {
            // InternalTechnologyDsl.g:7554:1: ( () )
            // InternalTechnologyDsl.g:7555:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveBooleanAction_0_0()); 
            // InternalTechnologyDsl.g:7556:2: ()
            // InternalTechnologyDsl.g:7556:3: 
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
    // InternalTechnologyDsl.g:7564:1: rule__PrimitiveType__Group_0__1 : rule__PrimitiveType__Group_0__1__Impl ;
    public final void rule__PrimitiveType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7568:1: ( rule__PrimitiveType__Group_0__1__Impl )
            // InternalTechnologyDsl.g:7569:2: rule__PrimitiveType__Group_0__1__Impl
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
    // InternalTechnologyDsl.g:7575:1: rule__PrimitiveType__Group_0__1__Impl : ( 'boolean' ) ;
    public final void rule__PrimitiveType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7579:1: ( ( 'boolean' ) )
            // InternalTechnologyDsl.g:7580:1: ( 'boolean' )
            {
            // InternalTechnologyDsl.g:7580:1: ( 'boolean' )
            // InternalTechnologyDsl.g:7581:2: 'boolean'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getBooleanKeyword_0_1()); 
            match(input,68,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:7591:1: rule__PrimitiveType__Group_1__0 : rule__PrimitiveType__Group_1__0__Impl rule__PrimitiveType__Group_1__1 ;
    public final void rule__PrimitiveType__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7595:1: ( rule__PrimitiveType__Group_1__0__Impl rule__PrimitiveType__Group_1__1 )
            // InternalTechnologyDsl.g:7596:2: rule__PrimitiveType__Group_1__0__Impl rule__PrimitiveType__Group_1__1
            {
            pushFollow(FOLLOW_70);
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
    // InternalTechnologyDsl.g:7603:1: rule__PrimitiveType__Group_1__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7607:1: ( ( () ) )
            // InternalTechnologyDsl.g:7608:1: ( () )
            {
            // InternalTechnologyDsl.g:7608:1: ( () )
            // InternalTechnologyDsl.g:7609:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveByteAction_1_0()); 
            // InternalTechnologyDsl.g:7610:2: ()
            // InternalTechnologyDsl.g:7610:3: 
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
    // InternalTechnologyDsl.g:7618:1: rule__PrimitiveType__Group_1__1 : rule__PrimitiveType__Group_1__1__Impl ;
    public final void rule__PrimitiveType__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7622:1: ( rule__PrimitiveType__Group_1__1__Impl )
            // InternalTechnologyDsl.g:7623:2: rule__PrimitiveType__Group_1__1__Impl
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
    // InternalTechnologyDsl.g:7629:1: rule__PrimitiveType__Group_1__1__Impl : ( 'byte' ) ;
    public final void rule__PrimitiveType__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7633:1: ( ( 'byte' ) )
            // InternalTechnologyDsl.g:7634:1: ( 'byte' )
            {
            // InternalTechnologyDsl.g:7634:1: ( 'byte' )
            // InternalTechnologyDsl.g:7635:2: 'byte'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getByteKeyword_1_1()); 
            match(input,69,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:7645:1: rule__PrimitiveType__Group_2__0 : rule__PrimitiveType__Group_2__0__Impl rule__PrimitiveType__Group_2__1 ;
    public final void rule__PrimitiveType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7649:1: ( rule__PrimitiveType__Group_2__0__Impl rule__PrimitiveType__Group_2__1 )
            // InternalTechnologyDsl.g:7650:2: rule__PrimitiveType__Group_2__0__Impl rule__PrimitiveType__Group_2__1
            {
            pushFollow(FOLLOW_71);
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
    // InternalTechnologyDsl.g:7657:1: rule__PrimitiveType__Group_2__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7661:1: ( ( () ) )
            // InternalTechnologyDsl.g:7662:1: ( () )
            {
            // InternalTechnologyDsl.g:7662:1: ( () )
            // InternalTechnologyDsl.g:7663:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveCharacterAction_2_0()); 
            // InternalTechnologyDsl.g:7664:2: ()
            // InternalTechnologyDsl.g:7664:3: 
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
    // InternalTechnologyDsl.g:7672:1: rule__PrimitiveType__Group_2__1 : rule__PrimitiveType__Group_2__1__Impl ;
    public final void rule__PrimitiveType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7676:1: ( rule__PrimitiveType__Group_2__1__Impl )
            // InternalTechnologyDsl.g:7677:2: rule__PrimitiveType__Group_2__1__Impl
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
    // InternalTechnologyDsl.g:7683:1: rule__PrimitiveType__Group_2__1__Impl : ( 'char' ) ;
    public final void rule__PrimitiveType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7687:1: ( ( 'char' ) )
            // InternalTechnologyDsl.g:7688:1: ( 'char' )
            {
            // InternalTechnologyDsl.g:7688:1: ( 'char' )
            // InternalTechnologyDsl.g:7689:2: 'char'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getCharKeyword_2_1()); 
            match(input,70,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:7699:1: rule__PrimitiveType__Group_3__0 : rule__PrimitiveType__Group_3__0__Impl rule__PrimitiveType__Group_3__1 ;
    public final void rule__PrimitiveType__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7703:1: ( rule__PrimitiveType__Group_3__0__Impl rule__PrimitiveType__Group_3__1 )
            // InternalTechnologyDsl.g:7704:2: rule__PrimitiveType__Group_3__0__Impl rule__PrimitiveType__Group_3__1
            {
            pushFollow(FOLLOW_72);
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
    // InternalTechnologyDsl.g:7711:1: rule__PrimitiveType__Group_3__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7715:1: ( ( () ) )
            // InternalTechnologyDsl.g:7716:1: ( () )
            {
            // InternalTechnologyDsl.g:7716:1: ( () )
            // InternalTechnologyDsl.g:7717:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveDateAction_3_0()); 
            // InternalTechnologyDsl.g:7718:2: ()
            // InternalTechnologyDsl.g:7718:3: 
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
    // InternalTechnologyDsl.g:7726:1: rule__PrimitiveType__Group_3__1 : rule__PrimitiveType__Group_3__1__Impl ;
    public final void rule__PrimitiveType__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7730:1: ( rule__PrimitiveType__Group_3__1__Impl )
            // InternalTechnologyDsl.g:7731:2: rule__PrimitiveType__Group_3__1__Impl
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
    // InternalTechnologyDsl.g:7737:1: rule__PrimitiveType__Group_3__1__Impl : ( 'date' ) ;
    public final void rule__PrimitiveType__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7741:1: ( ( 'date' ) )
            // InternalTechnologyDsl.g:7742:1: ( 'date' )
            {
            // InternalTechnologyDsl.g:7742:1: ( 'date' )
            // InternalTechnologyDsl.g:7743:2: 'date'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getDateKeyword_3_1()); 
            match(input,71,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:7753:1: rule__PrimitiveType__Group_4__0 : rule__PrimitiveType__Group_4__0__Impl rule__PrimitiveType__Group_4__1 ;
    public final void rule__PrimitiveType__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7757:1: ( rule__PrimitiveType__Group_4__0__Impl rule__PrimitiveType__Group_4__1 )
            // InternalTechnologyDsl.g:7758:2: rule__PrimitiveType__Group_4__0__Impl rule__PrimitiveType__Group_4__1
            {
            pushFollow(FOLLOW_73);
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
    // InternalTechnologyDsl.g:7765:1: rule__PrimitiveType__Group_4__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7769:1: ( ( () ) )
            // InternalTechnologyDsl.g:7770:1: ( () )
            {
            // InternalTechnologyDsl.g:7770:1: ( () )
            // InternalTechnologyDsl.g:7771:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveDoubleAction_4_0()); 
            // InternalTechnologyDsl.g:7772:2: ()
            // InternalTechnologyDsl.g:7772:3: 
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
    // InternalTechnologyDsl.g:7780:1: rule__PrimitiveType__Group_4__1 : rule__PrimitiveType__Group_4__1__Impl ;
    public final void rule__PrimitiveType__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7784:1: ( rule__PrimitiveType__Group_4__1__Impl )
            // InternalTechnologyDsl.g:7785:2: rule__PrimitiveType__Group_4__1__Impl
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
    // InternalTechnologyDsl.g:7791:1: rule__PrimitiveType__Group_4__1__Impl : ( 'double' ) ;
    public final void rule__PrimitiveType__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7795:1: ( ( 'double' ) )
            // InternalTechnologyDsl.g:7796:1: ( 'double' )
            {
            // InternalTechnologyDsl.g:7796:1: ( 'double' )
            // InternalTechnologyDsl.g:7797:2: 'double'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getDoubleKeyword_4_1()); 
            match(input,72,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:7807:1: rule__PrimitiveType__Group_5__0 : rule__PrimitiveType__Group_5__0__Impl rule__PrimitiveType__Group_5__1 ;
    public final void rule__PrimitiveType__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7811:1: ( rule__PrimitiveType__Group_5__0__Impl rule__PrimitiveType__Group_5__1 )
            // InternalTechnologyDsl.g:7812:2: rule__PrimitiveType__Group_5__0__Impl rule__PrimitiveType__Group_5__1
            {
            pushFollow(FOLLOW_74);
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
    // InternalTechnologyDsl.g:7819:1: rule__PrimitiveType__Group_5__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7823:1: ( ( () ) )
            // InternalTechnologyDsl.g:7824:1: ( () )
            {
            // InternalTechnologyDsl.g:7824:1: ( () )
            // InternalTechnologyDsl.g:7825:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveFloatAction_5_0()); 
            // InternalTechnologyDsl.g:7826:2: ()
            // InternalTechnologyDsl.g:7826:3: 
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
    // InternalTechnologyDsl.g:7834:1: rule__PrimitiveType__Group_5__1 : rule__PrimitiveType__Group_5__1__Impl ;
    public final void rule__PrimitiveType__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7838:1: ( rule__PrimitiveType__Group_5__1__Impl )
            // InternalTechnologyDsl.g:7839:2: rule__PrimitiveType__Group_5__1__Impl
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
    // InternalTechnologyDsl.g:7845:1: rule__PrimitiveType__Group_5__1__Impl : ( 'float' ) ;
    public final void rule__PrimitiveType__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7849:1: ( ( 'float' ) )
            // InternalTechnologyDsl.g:7850:1: ( 'float' )
            {
            // InternalTechnologyDsl.g:7850:1: ( 'float' )
            // InternalTechnologyDsl.g:7851:2: 'float'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getFloatKeyword_5_1()); 
            match(input,73,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:7861:1: rule__PrimitiveType__Group_6__0 : rule__PrimitiveType__Group_6__0__Impl rule__PrimitiveType__Group_6__1 ;
    public final void rule__PrimitiveType__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7865:1: ( rule__PrimitiveType__Group_6__0__Impl rule__PrimitiveType__Group_6__1 )
            // InternalTechnologyDsl.g:7866:2: rule__PrimitiveType__Group_6__0__Impl rule__PrimitiveType__Group_6__1
            {
            pushFollow(FOLLOW_75);
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
    // InternalTechnologyDsl.g:7873:1: rule__PrimitiveType__Group_6__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7877:1: ( ( () ) )
            // InternalTechnologyDsl.g:7878:1: ( () )
            {
            // InternalTechnologyDsl.g:7878:1: ( () )
            // InternalTechnologyDsl.g:7879:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveIntegerAction_6_0()); 
            // InternalTechnologyDsl.g:7880:2: ()
            // InternalTechnologyDsl.g:7880:3: 
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
    // InternalTechnologyDsl.g:7888:1: rule__PrimitiveType__Group_6__1 : rule__PrimitiveType__Group_6__1__Impl ;
    public final void rule__PrimitiveType__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7892:1: ( rule__PrimitiveType__Group_6__1__Impl )
            // InternalTechnologyDsl.g:7893:2: rule__PrimitiveType__Group_6__1__Impl
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
    // InternalTechnologyDsl.g:7899:1: rule__PrimitiveType__Group_6__1__Impl : ( 'int' ) ;
    public final void rule__PrimitiveType__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7903:1: ( ( 'int' ) )
            // InternalTechnologyDsl.g:7904:1: ( 'int' )
            {
            // InternalTechnologyDsl.g:7904:1: ( 'int' )
            // InternalTechnologyDsl.g:7905:2: 'int'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getIntKeyword_6_1()); 
            match(input,74,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:7915:1: rule__PrimitiveType__Group_7__0 : rule__PrimitiveType__Group_7__0__Impl rule__PrimitiveType__Group_7__1 ;
    public final void rule__PrimitiveType__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7919:1: ( rule__PrimitiveType__Group_7__0__Impl rule__PrimitiveType__Group_7__1 )
            // InternalTechnologyDsl.g:7920:2: rule__PrimitiveType__Group_7__0__Impl rule__PrimitiveType__Group_7__1
            {
            pushFollow(FOLLOW_76);
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
    // InternalTechnologyDsl.g:7927:1: rule__PrimitiveType__Group_7__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7931:1: ( ( () ) )
            // InternalTechnologyDsl.g:7932:1: ( () )
            {
            // InternalTechnologyDsl.g:7932:1: ( () )
            // InternalTechnologyDsl.g:7933:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveLongAction_7_0()); 
            // InternalTechnologyDsl.g:7934:2: ()
            // InternalTechnologyDsl.g:7934:3: 
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
    // InternalTechnologyDsl.g:7942:1: rule__PrimitiveType__Group_7__1 : rule__PrimitiveType__Group_7__1__Impl ;
    public final void rule__PrimitiveType__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7946:1: ( rule__PrimitiveType__Group_7__1__Impl )
            // InternalTechnologyDsl.g:7947:2: rule__PrimitiveType__Group_7__1__Impl
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
    // InternalTechnologyDsl.g:7953:1: rule__PrimitiveType__Group_7__1__Impl : ( 'long' ) ;
    public final void rule__PrimitiveType__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7957:1: ( ( 'long' ) )
            // InternalTechnologyDsl.g:7958:1: ( 'long' )
            {
            // InternalTechnologyDsl.g:7958:1: ( 'long' )
            // InternalTechnologyDsl.g:7959:2: 'long'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getLongKeyword_7_1()); 
            match(input,75,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:7969:1: rule__PrimitiveType__Group_8__0 : rule__PrimitiveType__Group_8__0__Impl rule__PrimitiveType__Group_8__1 ;
    public final void rule__PrimitiveType__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7973:1: ( rule__PrimitiveType__Group_8__0__Impl rule__PrimitiveType__Group_8__1 )
            // InternalTechnologyDsl.g:7974:2: rule__PrimitiveType__Group_8__0__Impl rule__PrimitiveType__Group_8__1
            {
            pushFollow(FOLLOW_77);
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
    // InternalTechnologyDsl.g:7981:1: rule__PrimitiveType__Group_8__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:7985:1: ( ( () ) )
            // InternalTechnologyDsl.g:7986:1: ( () )
            {
            // InternalTechnologyDsl.g:7986:1: ( () )
            // InternalTechnologyDsl.g:7987:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveShortAction_8_0()); 
            // InternalTechnologyDsl.g:7988:2: ()
            // InternalTechnologyDsl.g:7988:3: 
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
    // InternalTechnologyDsl.g:7996:1: rule__PrimitiveType__Group_8__1 : rule__PrimitiveType__Group_8__1__Impl ;
    public final void rule__PrimitiveType__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8000:1: ( rule__PrimitiveType__Group_8__1__Impl )
            // InternalTechnologyDsl.g:8001:2: rule__PrimitiveType__Group_8__1__Impl
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
    // InternalTechnologyDsl.g:8007:1: rule__PrimitiveType__Group_8__1__Impl : ( 'short' ) ;
    public final void rule__PrimitiveType__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8011:1: ( ( 'short' ) )
            // InternalTechnologyDsl.g:8012:1: ( 'short' )
            {
            // InternalTechnologyDsl.g:8012:1: ( 'short' )
            // InternalTechnologyDsl.g:8013:2: 'short'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getShortKeyword_8_1()); 
            match(input,76,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:8023:1: rule__PrimitiveType__Group_9__0 : rule__PrimitiveType__Group_9__0__Impl rule__PrimitiveType__Group_9__1 ;
    public final void rule__PrimitiveType__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8027:1: ( rule__PrimitiveType__Group_9__0__Impl rule__PrimitiveType__Group_9__1 )
            // InternalTechnologyDsl.g:8028:2: rule__PrimitiveType__Group_9__0__Impl rule__PrimitiveType__Group_9__1
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
    // InternalTechnologyDsl.g:8035:1: rule__PrimitiveType__Group_9__0__Impl : ( () ) ;
    public final void rule__PrimitiveType__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8039:1: ( ( () ) )
            // InternalTechnologyDsl.g:8040:1: ( () )
            {
            // InternalTechnologyDsl.g:8040:1: ( () )
            // InternalTechnologyDsl.g:8041:2: ()
            {
             before(grammarAccess.getPrimitiveTypeAccess().getPrimitiveStringAction_9_0()); 
            // InternalTechnologyDsl.g:8042:2: ()
            // InternalTechnologyDsl.g:8042:3: 
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
    // InternalTechnologyDsl.g:8050:1: rule__PrimitiveType__Group_9__1 : rule__PrimitiveType__Group_9__1__Impl ;
    public final void rule__PrimitiveType__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8054:1: ( rule__PrimitiveType__Group_9__1__Impl )
            // InternalTechnologyDsl.g:8055:2: rule__PrimitiveType__Group_9__1__Impl
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
    // InternalTechnologyDsl.g:8061:1: rule__PrimitiveType__Group_9__1__Impl : ( 'string' ) ;
    public final void rule__PrimitiveType__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8065:1: ( ( 'string' ) )
            // InternalTechnologyDsl.g:8066:1: ( 'string' )
            {
            // InternalTechnologyDsl.g:8066:1: ( 'string' )
            // InternalTechnologyDsl.g:8067:2: 'string'
            {
             before(grammarAccess.getPrimitiveTypeAccess().getStringKeyword_9_1()); 
            match(input,77,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:8077:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8081:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalTechnologyDsl.g:8082:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_78);
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
    // InternalTechnologyDsl.g:8089:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8093:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:8094:1: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:8094:1: ( RULE_ID )
            // InternalTechnologyDsl.g:8095:2: RULE_ID
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
    // InternalTechnologyDsl.g:8104:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8108:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalTechnologyDsl.g:8109:2: rule__QualifiedName__Group__1__Impl
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
    // InternalTechnologyDsl.g:8115:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8119:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalTechnologyDsl.g:8120:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalTechnologyDsl.g:8120:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalTechnologyDsl.g:8121:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalTechnologyDsl.g:8122:2: ( rule__QualifiedName__Group_1__0 )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==78) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalTechnologyDsl.g:8122:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_79);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop64;
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
    // InternalTechnologyDsl.g:8131:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8135:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalTechnologyDsl.g:8136:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
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
    // InternalTechnologyDsl.g:8143:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8147:1: ( ( '.' ) )
            // InternalTechnologyDsl.g:8148:1: ( '.' )
            {
            // InternalTechnologyDsl.g:8148:1: ( '.' )
            // InternalTechnologyDsl.g:8149:2: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,78,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:8158:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8162:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalTechnologyDsl.g:8163:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalTechnologyDsl.g:8169:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8173:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:8174:1: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:8174:1: ( RULE_ID )
            // InternalTechnologyDsl.g:8175:2: RULE_ID
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
    // InternalTechnologyDsl.g:8185:1: rule__Technology__ImportsAssignment_0 : ( ruleTechnologyImport ) ;
    public final void rule__Technology__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8189:1: ( ( ruleTechnologyImport ) )
            // InternalTechnologyDsl.g:8190:2: ( ruleTechnologyImport )
            {
            // InternalTechnologyDsl.g:8190:2: ( ruleTechnologyImport )
            // InternalTechnologyDsl.g:8191:3: ruleTechnologyImport
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
    // InternalTechnologyDsl.g:8200:1: rule__Technology__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Technology__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8204:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:8205:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:8205:2: ( RULE_ID )
            // InternalTechnologyDsl.g:8206:3: RULE_ID
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
    // InternalTechnologyDsl.g:8215:1: rule__Technology__PrimitiveTypesAssignment_4_2_0 : ( ruleTechnologySpecificPrimitiveType ) ;
    public final void rule__Technology__PrimitiveTypesAssignment_4_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8219:1: ( ( ruleTechnologySpecificPrimitiveType ) )
            // InternalTechnologyDsl.g:8220:2: ( ruleTechnologySpecificPrimitiveType )
            {
            // InternalTechnologyDsl.g:8220:2: ( ruleTechnologySpecificPrimitiveType )
            // InternalTechnologyDsl.g:8221:3: ruleTechnologySpecificPrimitiveType
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
    // InternalTechnologyDsl.g:8230:1: rule__Technology__ListTypesAssignment_4_2_1 : ( ruleTechnologySpecificListType ) ;
    public final void rule__Technology__ListTypesAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8234:1: ( ( ruleTechnologySpecificListType ) )
            // InternalTechnologyDsl.g:8235:2: ( ruleTechnologySpecificListType )
            {
            // InternalTechnologyDsl.g:8235:2: ( ruleTechnologySpecificListType )
            // InternalTechnologyDsl.g:8236:3: ruleTechnologySpecificListType
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
    // InternalTechnologyDsl.g:8245:1: rule__Technology__DataStructuresAssignment_4_2_2 : ( ruleTechnologySpecificDataStructure ) ;
    public final void rule__Technology__DataStructuresAssignment_4_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8249:1: ( ( ruleTechnologySpecificDataStructure ) )
            // InternalTechnologyDsl.g:8250:2: ( ruleTechnologySpecificDataStructure )
            {
            // InternalTechnologyDsl.g:8250:2: ( ruleTechnologySpecificDataStructure )
            // InternalTechnologyDsl.g:8251:3: ruleTechnologySpecificDataStructure
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
    // InternalTechnologyDsl.g:8260:1: rule__Technology__CompatibilityEntriesAssignment_4_3_3 : ( ruleCompatibilityMatrixEntry ) ;
    public final void rule__Technology__CompatibilityEntriesAssignment_4_3_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8264:1: ( ( ruleCompatibilityMatrixEntry ) )
            // InternalTechnologyDsl.g:8265:2: ( ruleCompatibilityMatrixEntry )
            {
            // InternalTechnologyDsl.g:8265:2: ( ruleCompatibilityMatrixEntry )
            // InternalTechnologyDsl.g:8266:3: ruleCompatibilityMatrixEntry
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
    // InternalTechnologyDsl.g:8275:1: rule__Technology__ProtocolsAssignment_5_2 : ( ruleProtocol ) ;
    public final void rule__Technology__ProtocolsAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8279:1: ( ( ruleProtocol ) )
            // InternalTechnologyDsl.g:8280:2: ( ruleProtocol )
            {
            // InternalTechnologyDsl.g:8280:2: ( ruleProtocol )
            // InternalTechnologyDsl.g:8281:3: ruleProtocol
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
    // InternalTechnologyDsl.g:8290:1: rule__Technology__ServiceAspectsAssignment_6_3 : ( ruleServiceAspect ) ;
    public final void rule__Technology__ServiceAspectsAssignment_6_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8294:1: ( ( ruleServiceAspect ) )
            // InternalTechnologyDsl.g:8295:2: ( ruleServiceAspect )
            {
            // InternalTechnologyDsl.g:8295:2: ( ruleServiceAspect )
            // InternalTechnologyDsl.g:8296:3: ruleServiceAspect
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
    // InternalTechnologyDsl.g:8305:1: rule__Technology__DeploymentTechnologiesAssignment_7_3 : ( ruleDeploymentTechnology ) ;
    public final void rule__Technology__DeploymentTechnologiesAssignment_7_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8309:1: ( ( ruleDeploymentTechnology ) )
            // InternalTechnologyDsl.g:8310:2: ( ruleDeploymentTechnology )
            {
            // InternalTechnologyDsl.g:8310:2: ( ruleDeploymentTechnology )
            // InternalTechnologyDsl.g:8311:3: ruleDeploymentTechnology
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
    // InternalTechnologyDsl.g:8320:1: rule__Technology__InfrastructureTechnologiesAssignment_8_3 : ( ruleInfrastructureTechnology ) ;
    public final void rule__Technology__InfrastructureTechnologiesAssignment_8_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8324:1: ( ( ruleInfrastructureTechnology ) )
            // InternalTechnologyDsl.g:8325:2: ( ruleInfrastructureTechnology )
            {
            // InternalTechnologyDsl.g:8325:2: ( ruleInfrastructureTechnology )
            // InternalTechnologyDsl.g:8326:3: ruleInfrastructureTechnology
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
    // InternalTechnologyDsl.g:8335:1: rule__Technology__OperationAspectsAssignment_9_3 : ( ruleOperationAspect ) ;
    public final void rule__Technology__OperationAspectsAssignment_9_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8339:1: ( ( ruleOperationAspect ) )
            // InternalTechnologyDsl.g:8340:2: ( ruleOperationAspect )
            {
            // InternalTechnologyDsl.g:8340:2: ( ruleOperationAspect )
            // InternalTechnologyDsl.g:8341:3: ruleOperationAspect
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
    // InternalTechnologyDsl.g:8350:1: rule__TechnologyImport__ImportURIAssignment_3 : ( RULE_STRING ) ;
    public final void rule__TechnologyImport__ImportURIAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8354:1: ( ( RULE_STRING ) )
            // InternalTechnologyDsl.g:8355:2: ( RULE_STRING )
            {
            // InternalTechnologyDsl.g:8355:2: ( RULE_STRING )
            // InternalTechnologyDsl.g:8356:3: RULE_STRING
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
    // InternalTechnologyDsl.g:8365:1: rule__TechnologyImport__NameAssignment_5 : ( RULE_ID ) ;
    public final void rule__TechnologyImport__NameAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8369:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:8370:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:8370:2: ( RULE_ID )
            // InternalTechnologyDsl.g:8371:3: RULE_ID
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
    // InternalTechnologyDsl.g:8380:1: rule__Protocol__CommunicationTypeAssignment_0 : ( ruleCommunicationType ) ;
    public final void rule__Protocol__CommunicationTypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8384:1: ( ( ruleCommunicationType ) )
            // InternalTechnologyDsl.g:8385:2: ( ruleCommunicationType )
            {
            // InternalTechnologyDsl.g:8385:2: ( ruleCommunicationType )
            // InternalTechnologyDsl.g:8386:3: ruleCommunicationType
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
    // InternalTechnologyDsl.g:8395:1: rule__Protocol__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Protocol__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8399:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:8400:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:8400:2: ( RULE_ID )
            // InternalTechnologyDsl.g:8401:3: RULE_ID
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
    // InternalTechnologyDsl.g:8410:1: rule__Protocol__DataFormatsAssignment_4 : ( ruleDataFormat ) ;
    public final void rule__Protocol__DataFormatsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8414:1: ( ( ruleDataFormat ) )
            // InternalTechnologyDsl.g:8415:2: ( ruleDataFormat )
            {
            // InternalTechnologyDsl.g:8415:2: ( ruleDataFormat )
            // InternalTechnologyDsl.g:8416:3: ruleDataFormat
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
    // InternalTechnologyDsl.g:8425:1: rule__Protocol__DataFormatsAssignment_5_1 : ( ruleDataFormat ) ;
    public final void rule__Protocol__DataFormatsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8429:1: ( ( ruleDataFormat ) )
            // InternalTechnologyDsl.g:8430:2: ( ruleDataFormat )
            {
            // InternalTechnologyDsl.g:8430:2: ( ruleDataFormat )
            // InternalTechnologyDsl.g:8431:3: ruleDataFormat
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
    // InternalTechnologyDsl.g:8440:1: rule__Protocol__DefaultAssignment_6_0 : ( ( 'default' ) ) ;
    public final void rule__Protocol__DefaultAssignment_6_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8444:1: ( ( ( 'default' ) ) )
            // InternalTechnologyDsl.g:8445:2: ( ( 'default' ) )
            {
            // InternalTechnologyDsl.g:8445:2: ( ( 'default' ) )
            // InternalTechnologyDsl.g:8446:3: ( 'default' )
            {
             before(grammarAccess.getProtocolAccess().getDefaultDefaultKeyword_6_0_0()); 
            // InternalTechnologyDsl.g:8447:3: ( 'default' )
            // InternalTechnologyDsl.g:8448:4: 'default'
            {
             before(grammarAccess.getProtocolAccess().getDefaultDefaultKeyword_6_0_0()); 
            match(input,79,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:8459:1: rule__Protocol__DefaultFormatAssignment_6_3 : ( ( RULE_ID ) ) ;
    public final void rule__Protocol__DefaultFormatAssignment_6_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8463:1: ( ( ( RULE_ID ) ) )
            // InternalTechnologyDsl.g:8464:2: ( ( RULE_ID ) )
            {
            // InternalTechnologyDsl.g:8464:2: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:8465:3: ( RULE_ID )
            {
             before(grammarAccess.getProtocolAccess().getDefaultFormatDataFormatCrossReference_6_3_0()); 
            // InternalTechnologyDsl.g:8466:3: ( RULE_ID )
            // InternalTechnologyDsl.g:8467:4: RULE_ID
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
    // InternalTechnologyDsl.g:8478:1: rule__DataFormat__FormatNameAssignment : ( RULE_ID ) ;
    public final void rule__DataFormat__FormatNameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8482:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:8483:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:8483:2: ( RULE_ID )
            // InternalTechnologyDsl.g:8484:3: RULE_ID
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
    // InternalTechnologyDsl.g:8493:1: rule__TechnologySpecificPrimitiveType__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__TechnologySpecificPrimitiveType__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8497:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:8498:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:8498:2: ( RULE_ID )
            // InternalTechnologyDsl.g:8499:3: RULE_ID
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
    // InternalTechnologyDsl.g:8508:1: rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_2 : ( rulePrimitiveType ) ;
    public final void rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8512:1: ( ( rulePrimitiveType ) )
            // InternalTechnologyDsl.g:8513:2: ( rulePrimitiveType )
            {
            // InternalTechnologyDsl.g:8513:2: ( rulePrimitiveType )
            // InternalTechnologyDsl.g:8514:3: rulePrimitiveType
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
    // InternalTechnologyDsl.g:8523:1: rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_3_1 : ( rulePrimitiveType ) ;
    public final void rule__TechnologySpecificPrimitiveType__BasicBuiltinPrimitiveTypesAssignment_3_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8527:1: ( ( rulePrimitiveType ) )
            // InternalTechnologyDsl.g:8528:2: ( rulePrimitiveType )
            {
            // InternalTechnologyDsl.g:8528:2: ( rulePrimitiveType )
            // InternalTechnologyDsl.g:8529:3: rulePrimitiveType
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
    // InternalTechnologyDsl.g:8538:1: rule__TechnologySpecificPrimitiveType__DefaultAssignment_3_4 : ( ( 'default' ) ) ;
    public final void rule__TechnologySpecificPrimitiveType__DefaultAssignment_3_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8542:1: ( ( ( 'default' ) ) )
            // InternalTechnologyDsl.g:8543:2: ( ( 'default' ) )
            {
            // InternalTechnologyDsl.g:8543:2: ( ( 'default' ) )
            // InternalTechnologyDsl.g:8544:3: ( 'default' )
            {
             before(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getDefaultDefaultKeyword_3_4_0()); 
            // InternalTechnologyDsl.g:8545:3: ( 'default' )
            // InternalTechnologyDsl.g:8546:4: 'default'
            {
             before(grammarAccess.getTechnologySpecificPrimitiveTypeAccess().getDefaultDefaultKeyword_3_4_0()); 
            match(input,79,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:8557:1: rule__TechnologySpecificListType__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__TechnologySpecificListType__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8561:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:8562:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:8562:2: ( RULE_ID )
            // InternalTechnologyDsl.g:8563:3: RULE_ID
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
    // InternalTechnologyDsl.g:8572:1: rule__TechnologySpecificDataStructure__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__TechnologySpecificDataStructure__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8576:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:8577:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:8577:2: ( RULE_ID )
            // InternalTechnologyDsl.g:8578:3: RULE_ID
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
    // InternalTechnologyDsl.g:8587:1: rule__PossiblyImportedTechnologySpecificType__ImportAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__PossiblyImportedTechnologySpecificType__ImportAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8591:1: ( ( ( RULE_ID ) ) )
            // InternalTechnologyDsl.g:8592:2: ( ( RULE_ID ) )
            {
            // InternalTechnologyDsl.g:8592:2: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:8593:3: ( RULE_ID )
            {
             before(grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getImportTechnologyImportCrossReference_0_0_0()); 
            // InternalTechnologyDsl.g:8594:3: ( RULE_ID )
            // InternalTechnologyDsl.g:8595:4: RULE_ID
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
    // InternalTechnologyDsl.g:8606:1: rule__PossiblyImportedTechnologySpecificType__TypeAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__PossiblyImportedTechnologySpecificType__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8610:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTechnologyDsl.g:8611:2: ( ( ruleQualifiedName ) )
            {
            // InternalTechnologyDsl.g:8611:2: ( ( ruleQualifiedName ) )
            // InternalTechnologyDsl.g:8612:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getPossiblyImportedTechnologySpecificTypeAccess().getTypeTypeCrossReference_1_0()); 
            // InternalTechnologyDsl.g:8613:3: ( ruleQualifiedName )
            // InternalTechnologyDsl.g:8614:4: ruleQualifiedName
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
    // InternalTechnologyDsl.g:8625:1: rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_0 : ( rulePossiblyImportedTechnologySpecificType ) ;
    public final void rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8629:1: ( ( rulePossiblyImportedTechnologySpecificType ) )
            // InternalTechnologyDsl.g:8630:2: ( rulePossiblyImportedTechnologySpecificType )
            {
            // InternalTechnologyDsl.g:8630:2: ( rulePossiblyImportedTechnologySpecificType )
            // InternalTechnologyDsl.g:8631:3: rulePossiblyImportedTechnologySpecificType
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
    // InternalTechnologyDsl.g:8640:1: rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_1_1 : ( rulePossiblyImportedTechnologySpecificType ) ;
    public final void rule__CompatibilityMatrixEntry__CompatibleTypesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8644:1: ( ( rulePossiblyImportedTechnologySpecificType ) )
            // InternalTechnologyDsl.g:8645:2: ( rulePossiblyImportedTechnologySpecificType )
            {
            // InternalTechnologyDsl.g:8645:2: ( rulePossiblyImportedTechnologySpecificType )
            // InternalTechnologyDsl.g:8646:3: rulePossiblyImportedTechnologySpecificType
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
    // InternalTechnologyDsl.g:8655:1: rule__CompatibilityMatrixEntry__DirectionAssignment_2 : ( ruleCompatibilityDirection ) ;
    public final void rule__CompatibilityMatrixEntry__DirectionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8659:1: ( ( ruleCompatibilityDirection ) )
            // InternalTechnologyDsl.g:8660:2: ( ruleCompatibilityDirection )
            {
            // InternalTechnologyDsl.g:8660:2: ( ruleCompatibilityDirection )
            // InternalTechnologyDsl.g:8661:3: ruleCompatibilityDirection
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
    // InternalTechnologyDsl.g:8670:1: rule__CompatibilityMatrixEntry__MappingTypeAssignment_3 : ( rulePossiblyImportedTechnologySpecificType ) ;
    public final void rule__CompatibilityMatrixEntry__MappingTypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8674:1: ( ( rulePossiblyImportedTechnologySpecificType ) )
            // InternalTechnologyDsl.g:8675:2: ( rulePossiblyImportedTechnologySpecificType )
            {
            // InternalTechnologyDsl.g:8675:2: ( rulePossiblyImportedTechnologySpecificType )
            // InternalTechnologyDsl.g:8676:3: rulePossiblyImportedTechnologySpecificType
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
    // InternalTechnologyDsl.g:8685:1: rule__DeploymentTechnology__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__DeploymentTechnology__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8689:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:8690:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:8690:2: ( RULE_ID )
            // InternalTechnologyDsl.g:8691:3: RULE_ID
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
    // InternalTechnologyDsl.g:8700:1: rule__DeploymentTechnology__OperationEnvironmentsAssignment_5 : ( ruleOperationEnvironment ) ;
    public final void rule__DeploymentTechnology__OperationEnvironmentsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8704:1: ( ( ruleOperationEnvironment ) )
            // InternalTechnologyDsl.g:8705:2: ( ruleOperationEnvironment )
            {
            // InternalTechnologyDsl.g:8705:2: ( ruleOperationEnvironment )
            // InternalTechnologyDsl.g:8706:3: ruleOperationEnvironment
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
    // InternalTechnologyDsl.g:8715:1: rule__DeploymentTechnology__OperationEnvironmentsAssignment_6_1 : ( ruleOperationEnvironment ) ;
    public final void rule__DeploymentTechnology__OperationEnvironmentsAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8719:1: ( ( ruleOperationEnvironment ) )
            // InternalTechnologyDsl.g:8720:2: ( ruleOperationEnvironment )
            {
            // InternalTechnologyDsl.g:8720:2: ( ruleOperationEnvironment )
            // InternalTechnologyDsl.g:8721:3: ruleOperationEnvironment
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
    // InternalTechnologyDsl.g:8730:1: rule__DeploymentTechnology__ServicePropertiesAssignment_8_3 : ( ruleTechnologySpecificProperty ) ;
    public final void rule__DeploymentTechnology__ServicePropertiesAssignment_8_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8734:1: ( ( ruleTechnologySpecificProperty ) )
            // InternalTechnologyDsl.g:8735:2: ( ruleTechnologySpecificProperty )
            {
            // InternalTechnologyDsl.g:8735:2: ( ruleTechnologySpecificProperty )
            // InternalTechnologyDsl.g:8736:3: ruleTechnologySpecificProperty
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
    // InternalTechnologyDsl.g:8745:1: rule__InfrastructureTechnology__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__InfrastructureTechnology__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8749:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:8750:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:8750:2: ( RULE_ID )
            // InternalTechnologyDsl.g:8751:3: RULE_ID
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
    // InternalTechnologyDsl.g:8760:1: rule__InfrastructureTechnology__OperationEnvironmentsAssignment_5 : ( ruleOperationEnvironment ) ;
    public final void rule__InfrastructureTechnology__OperationEnvironmentsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8764:1: ( ( ruleOperationEnvironment ) )
            // InternalTechnologyDsl.g:8765:2: ( ruleOperationEnvironment )
            {
            // InternalTechnologyDsl.g:8765:2: ( ruleOperationEnvironment )
            // InternalTechnologyDsl.g:8766:3: ruleOperationEnvironment
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
    // InternalTechnologyDsl.g:8775:1: rule__InfrastructureTechnology__OperationEnvironmentsAssignment_6_1 : ( ruleOperationEnvironment ) ;
    public final void rule__InfrastructureTechnology__OperationEnvironmentsAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8779:1: ( ( ruleOperationEnvironment ) )
            // InternalTechnologyDsl.g:8780:2: ( ruleOperationEnvironment )
            {
            // InternalTechnologyDsl.g:8780:2: ( ruleOperationEnvironment )
            // InternalTechnologyDsl.g:8781:3: ruleOperationEnvironment
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
    // InternalTechnologyDsl.g:8790:1: rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3 : ( ruleTechnologySpecificProperty ) ;
    public final void rule__InfrastructureTechnology__ServicePropertiesAssignment_8_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8794:1: ( ( ruleTechnologySpecificProperty ) )
            // InternalTechnologyDsl.g:8795:2: ( ruleTechnologySpecificProperty )
            {
            // InternalTechnologyDsl.g:8795:2: ( ruleTechnologySpecificProperty )
            // InternalTechnologyDsl.g:8796:3: ruleTechnologySpecificProperty
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
    // InternalTechnologyDsl.g:8805:1: rule__OperationEnvironment__EnvironmentNameAssignment_0 : ( RULE_STRING ) ;
    public final void rule__OperationEnvironment__EnvironmentNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8809:1: ( ( RULE_STRING ) )
            // InternalTechnologyDsl.g:8810:2: ( RULE_STRING )
            {
            // InternalTechnologyDsl.g:8810:2: ( RULE_STRING )
            // InternalTechnologyDsl.g:8811:3: RULE_STRING
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
    // InternalTechnologyDsl.g:8820:1: rule__OperationEnvironment__DefaultAssignment_1 : ( ( 'default' ) ) ;
    public final void rule__OperationEnvironment__DefaultAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8824:1: ( ( ( 'default' ) ) )
            // InternalTechnologyDsl.g:8825:2: ( ( 'default' ) )
            {
            // InternalTechnologyDsl.g:8825:2: ( ( 'default' ) )
            // InternalTechnologyDsl.g:8826:3: ( 'default' )
            {
             before(grammarAccess.getOperationEnvironmentAccess().getDefaultDefaultKeyword_1_0()); 
            // InternalTechnologyDsl.g:8827:3: ( 'default' )
            // InternalTechnologyDsl.g:8828:4: 'default'
            {
             before(grammarAccess.getOperationEnvironmentAccess().getDefaultDefaultKeyword_1_0()); 
            match(input,79,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:8839:1: rule__TechnologySpecificProperty__TypeAssignment_0 : ( rulePrimitiveType ) ;
    public final void rule__TechnologySpecificProperty__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8843:1: ( ( rulePrimitiveType ) )
            // InternalTechnologyDsl.g:8844:2: ( rulePrimitiveType )
            {
            // InternalTechnologyDsl.g:8844:2: ( rulePrimitiveType )
            // InternalTechnologyDsl.g:8845:3: rulePrimitiveType
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
    // InternalTechnologyDsl.g:8854:1: rule__TechnologySpecificProperty__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__TechnologySpecificProperty__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8858:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:8859:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:8859:2: ( RULE_ID )
            // InternalTechnologyDsl.g:8860:3: RULE_ID
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
    // InternalTechnologyDsl.g:8869:1: rule__TechnologySpecificProperty__DefaultValueAssignment_2_0_1 : ( rulePrimitiveValue ) ;
    public final void rule__TechnologySpecificProperty__DefaultValueAssignment_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8873:1: ( ( rulePrimitiveValue ) )
            // InternalTechnologyDsl.g:8874:2: ( rulePrimitiveValue )
            {
            // InternalTechnologyDsl.g:8874:2: ( rulePrimitiveValue )
            // InternalTechnologyDsl.g:8875:3: rulePrimitiveValue
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
    // InternalTechnologyDsl.g:8884:1: rule__TechnologySpecificProperty__MandatoryAssignment_2_1 : ( ( 'mandatory' ) ) ;
    public final void rule__TechnologySpecificProperty__MandatoryAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8888:1: ( ( ( 'mandatory' ) ) )
            // InternalTechnologyDsl.g:8889:2: ( ( 'mandatory' ) )
            {
            // InternalTechnologyDsl.g:8889:2: ( ( 'mandatory' ) )
            // InternalTechnologyDsl.g:8890:3: ( 'mandatory' )
            {
             before(grammarAccess.getTechnologySpecificPropertyAccess().getMandatoryMandatoryKeyword_2_1_0()); 
            // InternalTechnologyDsl.g:8891:3: ( 'mandatory' )
            // InternalTechnologyDsl.g:8892:4: 'mandatory'
            {
             before(grammarAccess.getTechnologySpecificPropertyAccess().getMandatoryMandatoryKeyword_2_1_0()); 
            match(input,80,FOLLOW_2); 
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


    // $ANTLR start "rule__PrimitiveValue__NumericValueAssignment_0"
    // InternalTechnologyDsl.g:8903:1: rule__PrimitiveValue__NumericValueAssignment_0 : ( RULE_BIG_DECIMAL ) ;
    public final void rule__PrimitiveValue__NumericValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8907:1: ( ( RULE_BIG_DECIMAL ) )
            // InternalTechnologyDsl.g:8908:2: ( RULE_BIG_DECIMAL )
            {
            // InternalTechnologyDsl.g:8908:2: ( RULE_BIG_DECIMAL )
            // InternalTechnologyDsl.g:8909:3: RULE_BIG_DECIMAL
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
    // InternalTechnologyDsl.g:8918:1: rule__PrimitiveValue__BooleanValueAssignment_1 : ( RULE_BOOLEAN ) ;
    public final void rule__PrimitiveValue__BooleanValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8922:1: ( ( RULE_BOOLEAN ) )
            // InternalTechnologyDsl.g:8923:2: ( RULE_BOOLEAN )
            {
            // InternalTechnologyDsl.g:8923:2: ( RULE_BOOLEAN )
            // InternalTechnologyDsl.g:8924:3: RULE_BOOLEAN
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
    // InternalTechnologyDsl.g:8933:1: rule__PrimitiveValue__StringValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__PrimitiveValue__StringValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8937:1: ( ( RULE_STRING ) )
            // InternalTechnologyDsl.g:8938:2: ( RULE_STRING )
            {
            // InternalTechnologyDsl.g:8938:2: ( RULE_STRING )
            // InternalTechnologyDsl.g:8939:3: RULE_STRING
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


    // $ANTLR start "rule__ServiceAspectPointcut__ForExchangePatternAssignment_0_0"
    // InternalTechnologyDsl.g:8948:1: rule__ServiceAspectPointcut__ForExchangePatternAssignment_0_0 : ( ( 'exchange_pattern' ) ) ;
    public final void rule__ServiceAspectPointcut__ForExchangePatternAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8952:1: ( ( ( 'exchange_pattern' ) ) )
            // InternalTechnologyDsl.g:8953:2: ( ( 'exchange_pattern' ) )
            {
            // InternalTechnologyDsl.g:8953:2: ( ( 'exchange_pattern' ) )
            // InternalTechnologyDsl.g:8954:3: ( 'exchange_pattern' )
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getForExchangePatternExchange_patternKeyword_0_0_0()); 
            // InternalTechnologyDsl.g:8955:3: ( 'exchange_pattern' )
            // InternalTechnologyDsl.g:8956:4: 'exchange_pattern'
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getForExchangePatternExchange_patternKeyword_0_0_0()); 
            match(input,81,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:8967:1: rule__ServiceAspectPointcut__ExchangePatternAssignment_0_2 : ( ruleExchangePattern ) ;
    public final void rule__ServiceAspectPointcut__ExchangePatternAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8971:1: ( ( ruleExchangePattern ) )
            // InternalTechnologyDsl.g:8972:2: ( ruleExchangePattern )
            {
            // InternalTechnologyDsl.g:8972:2: ( ruleExchangePattern )
            // InternalTechnologyDsl.g:8973:3: ruleExchangePattern
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
    // InternalTechnologyDsl.g:8982:1: rule__ServiceAspectPointcut__ForCommunicationTypeAssignment_1_0 : ( ( 'communication_type' ) ) ;
    public final void rule__ServiceAspectPointcut__ForCommunicationTypeAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:8986:1: ( ( ( 'communication_type' ) ) )
            // InternalTechnologyDsl.g:8987:2: ( ( 'communication_type' ) )
            {
            // InternalTechnologyDsl.g:8987:2: ( ( 'communication_type' ) )
            // InternalTechnologyDsl.g:8988:3: ( 'communication_type' )
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getForCommunicationTypeCommunication_typeKeyword_1_0_0()); 
            // InternalTechnologyDsl.g:8989:3: ( 'communication_type' )
            // InternalTechnologyDsl.g:8990:4: 'communication_type'
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getForCommunicationTypeCommunication_typeKeyword_1_0_0()); 
            match(input,82,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:9001:1: rule__ServiceAspectPointcut__CommunicationTypeAssignment_1_2 : ( ruleCommunicationType ) ;
    public final void rule__ServiceAspectPointcut__CommunicationTypeAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9005:1: ( ( ruleCommunicationType ) )
            // InternalTechnologyDsl.g:9006:2: ( ruleCommunicationType )
            {
            // InternalTechnologyDsl.g:9006:2: ( ruleCommunicationType )
            // InternalTechnologyDsl.g:9007:3: ruleCommunicationType
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
    // InternalTechnologyDsl.g:9016:1: rule__ServiceAspectPointcut__ForProtocolAssignment_2_0 : ( ( 'protocol' ) ) ;
    public final void rule__ServiceAspectPointcut__ForProtocolAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9020:1: ( ( ( 'protocol' ) ) )
            // InternalTechnologyDsl.g:9021:2: ( ( 'protocol' ) )
            {
            // InternalTechnologyDsl.g:9021:2: ( ( 'protocol' ) )
            // InternalTechnologyDsl.g:9022:3: ( 'protocol' )
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getForProtocolProtocolKeyword_2_0_0()); 
            // InternalTechnologyDsl.g:9023:3: ( 'protocol' )
            // InternalTechnologyDsl.g:9024:4: 'protocol'
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getForProtocolProtocolKeyword_2_0_0()); 
            match(input,83,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:9035:1: rule__ServiceAspectPointcut__ProtocolAssignment_2_2 : ( ( RULE_ID ) ) ;
    public final void rule__ServiceAspectPointcut__ProtocolAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9039:1: ( ( ( RULE_ID ) ) )
            // InternalTechnologyDsl.g:9040:2: ( ( RULE_ID ) )
            {
            // InternalTechnologyDsl.g:9040:2: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:9041:3: ( RULE_ID )
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getProtocolProtocolCrossReference_2_2_0()); 
            // InternalTechnologyDsl.g:9042:3: ( RULE_ID )
            // InternalTechnologyDsl.g:9043:4: RULE_ID
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
    // InternalTechnologyDsl.g:9054:1: rule__ServiceAspectPointcut__ForDataFormatAssignment_3_0 : ( ( 'data_format' ) ) ;
    public final void rule__ServiceAspectPointcut__ForDataFormatAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9058:1: ( ( ( 'data_format' ) ) )
            // InternalTechnologyDsl.g:9059:2: ( ( 'data_format' ) )
            {
            // InternalTechnologyDsl.g:9059:2: ( ( 'data_format' ) )
            // InternalTechnologyDsl.g:9060:3: ( 'data_format' )
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getForDataFormatData_formatKeyword_3_0_0()); 
            // InternalTechnologyDsl.g:9061:3: ( 'data_format' )
            // InternalTechnologyDsl.g:9062:4: 'data_format'
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getForDataFormatData_formatKeyword_3_0_0()); 
            match(input,84,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:9073:1: rule__ServiceAspectPointcut__DataFormatAssignment_3_2 : ( ( RULE_ID ) ) ;
    public final void rule__ServiceAspectPointcut__DataFormatAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9077:1: ( ( ( RULE_ID ) ) )
            // InternalTechnologyDsl.g:9078:2: ( ( RULE_ID ) )
            {
            // InternalTechnologyDsl.g:9078:2: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:9079:3: ( RULE_ID )
            {
             before(grammarAccess.getServiceAspectPointcutAccess().getDataFormatDataFormatCrossReference_3_2_0()); 
            // InternalTechnologyDsl.g:9080:3: ( RULE_ID )
            // InternalTechnologyDsl.g:9081:4: RULE_ID
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
    // InternalTechnologyDsl.g:9092:1: rule__ServiceAspectPointcutSelector__PointcutsAssignment_2 : ( ruleServiceAspectPointcut ) ;
    public final void rule__ServiceAspectPointcutSelector__PointcutsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9096:1: ( ( ruleServiceAspectPointcut ) )
            // InternalTechnologyDsl.g:9097:2: ( ruleServiceAspectPointcut )
            {
            // InternalTechnologyDsl.g:9097:2: ( ruleServiceAspectPointcut )
            // InternalTechnologyDsl.g:9098:3: ruleServiceAspectPointcut
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
    // InternalTechnologyDsl.g:9107:1: rule__ServiceAspectPointcutSelector__PointcutsAssignment_3_1 : ( ruleServiceAspectPointcut ) ;
    public final void rule__ServiceAspectPointcutSelector__PointcutsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9111:1: ( ( ruleServiceAspectPointcut ) )
            // InternalTechnologyDsl.g:9112:2: ( ruleServiceAspectPointcut )
            {
            // InternalTechnologyDsl.g:9112:2: ( ruleServiceAspectPointcut )
            // InternalTechnologyDsl.g:9113:3: ruleServiceAspectPointcut
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
    // InternalTechnologyDsl.g:9122:1: rule__ServiceAspect__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ServiceAspect__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9126:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:9127:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:9127:2: ( RULE_ID )
            // InternalTechnologyDsl.g:9128:3: RULE_ID
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
    // InternalTechnologyDsl.g:9137:1: rule__ServiceAspect__JoinPointsAssignment_3 : ( ruleServiceJoinPointType ) ;
    public final void rule__ServiceAspect__JoinPointsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9141:1: ( ( ruleServiceJoinPointType ) )
            // InternalTechnologyDsl.g:9142:2: ( ruleServiceJoinPointType )
            {
            // InternalTechnologyDsl.g:9142:2: ( ruleServiceJoinPointType )
            // InternalTechnologyDsl.g:9143:3: ruleServiceJoinPointType
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
    // InternalTechnologyDsl.g:9152:1: rule__ServiceAspect__JoinPointsAssignment_4_1 : ( ruleServiceJoinPointType ) ;
    public final void rule__ServiceAspect__JoinPointsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9156:1: ( ( ruleServiceJoinPointType ) )
            // InternalTechnologyDsl.g:9157:2: ( ruleServiceJoinPointType )
            {
            // InternalTechnologyDsl.g:9157:2: ( ruleServiceJoinPointType )
            // InternalTechnologyDsl.g:9158:3: ruleServiceJoinPointType
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
    // InternalTechnologyDsl.g:9167:1: rule__ServiceAspect__PointcutSelectorsAssignment_5_0_1 : ( ruleServiceAspectPointcutSelector ) ;
    public final void rule__ServiceAspect__PointcutSelectorsAssignment_5_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9171:1: ( ( ruleServiceAspectPointcutSelector ) )
            // InternalTechnologyDsl.g:9172:2: ( ruleServiceAspectPointcutSelector )
            {
            // InternalTechnologyDsl.g:9172:2: ( ruleServiceAspectPointcutSelector )
            // InternalTechnologyDsl.g:9173:3: ruleServiceAspectPointcutSelector
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
    // InternalTechnologyDsl.g:9182:1: rule__ServiceAspect__PropertiesAssignment_5_0_2 : ( ruleTechnologySpecificProperty ) ;
    public final void rule__ServiceAspect__PropertiesAssignment_5_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9186:1: ( ( ruleTechnologySpecificProperty ) )
            // InternalTechnologyDsl.g:9187:2: ( ruleTechnologySpecificProperty )
            {
            // InternalTechnologyDsl.g:9187:2: ( ruleTechnologySpecificProperty )
            // InternalTechnologyDsl.g:9188:3: ruleTechnologySpecificProperty
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
    // InternalTechnologyDsl.g:9197:1: rule__OperationAspect__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__OperationAspect__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9201:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:9202:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:9202:2: ( RULE_ID )
            // InternalTechnologyDsl.g:9203:3: RULE_ID
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
    // InternalTechnologyDsl.g:9212:1: rule__OperationAspect__JoinPointsAssignment_3 : ( ruleOperationJoinPointType ) ;
    public final void rule__OperationAspect__JoinPointsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9216:1: ( ( ruleOperationJoinPointType ) )
            // InternalTechnologyDsl.g:9217:2: ( ruleOperationJoinPointType )
            {
            // InternalTechnologyDsl.g:9217:2: ( ruleOperationJoinPointType )
            // InternalTechnologyDsl.g:9218:3: ruleOperationJoinPointType
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
    // InternalTechnologyDsl.g:9227:1: rule__OperationAspect__JoinPointsAssignment_4_1 : ( ruleOperationJoinPointType ) ;
    public final void rule__OperationAspect__JoinPointsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9231:1: ( ( ruleOperationJoinPointType ) )
            // InternalTechnologyDsl.g:9232:2: ( ruleOperationJoinPointType )
            {
            // InternalTechnologyDsl.g:9232:2: ( ruleOperationJoinPointType )
            // InternalTechnologyDsl.g:9233:3: ruleOperationJoinPointType
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
    // InternalTechnologyDsl.g:9242:1: rule__OperationAspect__PropertiesAssignment_5_0_1 : ( ruleTechnologySpecificProperty ) ;
    public final void rule__OperationAspect__PropertiesAssignment_5_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9246:1: ( ( ruleTechnologySpecificProperty ) )
            // InternalTechnologyDsl.g:9247:2: ( ruleTechnologySpecificProperty )
            {
            // InternalTechnologyDsl.g:9247:2: ( ruleTechnologySpecificProperty )
            // InternalTechnologyDsl.g:9248:3: ruleTechnologySpecificProperty
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
    // InternalTechnologyDsl.g:9257:1: rule__ComplexTypeImport__ImportURIAssignment_3 : ( RULE_STRING ) ;
    public final void rule__ComplexTypeImport__ImportURIAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9261:1: ( ( RULE_STRING ) )
            // InternalTechnologyDsl.g:9262:2: ( RULE_STRING )
            {
            // InternalTechnologyDsl.g:9262:2: ( RULE_STRING )
            // InternalTechnologyDsl.g:9263:3: RULE_STRING
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
    // InternalTechnologyDsl.g:9272:1: rule__ComplexTypeImport__NameAssignment_5 : ( RULE_ID ) ;
    public final void rule__ComplexTypeImport__NameAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9276:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:9277:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:9277:2: ( RULE_ID )
            // InternalTechnologyDsl.g:9278:3: RULE_ID
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
    // InternalTechnologyDsl.g:9287:1: rule__Version__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Version__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9291:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:9292:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:9292:2: ( RULE_ID )
            // InternalTechnologyDsl.g:9293:3: RULE_ID
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
    // InternalTechnologyDsl.g:9302:1: rule__Version__ComplexTypesAssignment_3_0 : ( ruleComplexType ) ;
    public final void rule__Version__ComplexTypesAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9306:1: ( ( ruleComplexType ) )
            // InternalTechnologyDsl.g:9307:2: ( ruleComplexType )
            {
            // InternalTechnologyDsl.g:9307:2: ( ruleComplexType )
            // InternalTechnologyDsl.g:9308:3: ruleComplexType
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
    // InternalTechnologyDsl.g:9317:1: rule__Version__ContextsAssignment_3_1 : ( ruleContext ) ;
    public final void rule__Version__ContextsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9321:1: ( ( ruleContext ) )
            // InternalTechnologyDsl.g:9322:2: ( ruleContext )
            {
            // InternalTechnologyDsl.g:9322:2: ( ruleContext )
            // InternalTechnologyDsl.g:9323:3: ruleContext
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
    // InternalTechnologyDsl.g:9332:1: rule__Context__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Context__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9336:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:9337:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:9337:2: ( RULE_ID )
            // InternalTechnologyDsl.g:9338:3: RULE_ID
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
    // InternalTechnologyDsl.g:9347:1: rule__Context__ComplexTypesAssignment_3 : ( ruleComplexType ) ;
    public final void rule__Context__ComplexTypesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9351:1: ( ( ruleComplexType ) )
            // InternalTechnologyDsl.g:9352:2: ( ruleComplexType )
            {
            // InternalTechnologyDsl.g:9352:2: ( ruleComplexType )
            // InternalTechnologyDsl.g:9353:3: ruleComplexType
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
    // InternalTechnologyDsl.g:9362:1: rule__DataStructure__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__DataStructure__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9366:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:9367:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:9367:2: ( RULE_ID )
            // InternalTechnologyDsl.g:9368:3: RULE_ID
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
    // InternalTechnologyDsl.g:9377:1: rule__DataStructure__SuperAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__DataStructure__SuperAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9381:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTechnologyDsl.g:9382:2: ( ( ruleQualifiedName ) )
            {
            // InternalTechnologyDsl.g:9382:2: ( ( ruleQualifiedName ) )
            // InternalTechnologyDsl.g:9383:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getDataStructureAccess().getSuperDataStructureCrossReference_2_1_0()); 
            // InternalTechnologyDsl.g:9384:3: ( ruleQualifiedName )
            // InternalTechnologyDsl.g:9385:4: ruleQualifiedName
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
    // InternalTechnologyDsl.g:9396:1: rule__DataStructure__DataFieldsAssignment_4_0 : ( ruleDataField ) ;
    public final void rule__DataStructure__DataFieldsAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9400:1: ( ( ruleDataField ) )
            // InternalTechnologyDsl.g:9401:2: ( ruleDataField )
            {
            // InternalTechnologyDsl.g:9401:2: ( ruleDataField )
            // InternalTechnologyDsl.g:9402:3: ruleDataField
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
    // InternalTechnologyDsl.g:9411:1: rule__DataStructure__DataFieldsAssignment_4_1_1 : ( ruleDataField ) ;
    public final void rule__DataStructure__DataFieldsAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9415:1: ( ( ruleDataField ) )
            // InternalTechnologyDsl.g:9416:2: ( ruleDataField )
            {
            // InternalTechnologyDsl.g:9416:2: ( ruleDataField )
            // InternalTechnologyDsl.g:9417:3: ruleDataField
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
    // InternalTechnologyDsl.g:9426:1: rule__ListType__NameAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__ListType__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9430:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:9431:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:9431:2: ( RULE_ID )
            // InternalTechnologyDsl.g:9432:3: RULE_ID
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
    // InternalTechnologyDsl.g:9441:1: rule__ListType__DataFieldsAssignment_0_3 : ( ruleDataField ) ;
    public final void rule__ListType__DataFieldsAssignment_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9445:1: ( ( ruleDataField ) )
            // InternalTechnologyDsl.g:9446:2: ( ruleDataField )
            {
            // InternalTechnologyDsl.g:9446:2: ( ruleDataField )
            // InternalTechnologyDsl.g:9447:3: ruleDataField
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
    // InternalTechnologyDsl.g:9456:1: rule__ListType__DataFieldsAssignment_0_4_1 : ( ruleDataField ) ;
    public final void rule__ListType__DataFieldsAssignment_0_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9460:1: ( ( ruleDataField ) )
            // InternalTechnologyDsl.g:9461:2: ( ruleDataField )
            {
            // InternalTechnologyDsl.g:9461:2: ( ruleDataField )
            // InternalTechnologyDsl.g:9462:3: ruleDataField
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
    // InternalTechnologyDsl.g:9471:1: rule__ListType__NameAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__ListType__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9475:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:9476:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:9476:2: ( RULE_ID )
            // InternalTechnologyDsl.g:9477:3: RULE_ID
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
    // InternalTechnologyDsl.g:9486:1: rule__ListType__PrimitiveTypeAssignment_1_3 : ( rulePrimitiveType ) ;
    public final void rule__ListType__PrimitiveTypeAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9490:1: ( ( rulePrimitiveType ) )
            // InternalTechnologyDsl.g:9491:2: ( rulePrimitiveType )
            {
            // InternalTechnologyDsl.g:9491:2: ( rulePrimitiveType )
            // InternalTechnologyDsl.g:9492:3: rulePrimitiveType
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
    // InternalTechnologyDsl.g:9501:1: rule__DataField__HiddenAssignment_0 : ( ( 'hide' ) ) ;
    public final void rule__DataField__HiddenAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9505:1: ( ( ( 'hide' ) ) )
            // InternalTechnologyDsl.g:9506:2: ( ( 'hide' ) )
            {
            // InternalTechnologyDsl.g:9506:2: ( ( 'hide' ) )
            // InternalTechnologyDsl.g:9507:3: ( 'hide' )
            {
             before(grammarAccess.getDataFieldAccess().getHiddenHideKeyword_0_0()); 
            // InternalTechnologyDsl.g:9508:3: ( 'hide' )
            // InternalTechnologyDsl.g:9509:4: 'hide'
            {
             before(grammarAccess.getDataFieldAccess().getHiddenHideKeyword_0_0()); 
            match(input,85,FOLLOW_2); 
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
    // InternalTechnologyDsl.g:9520:1: rule__DataField__PrimitiveTypeAssignment_1_0 : ( rulePrimitiveType ) ;
    public final void rule__DataField__PrimitiveTypeAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9524:1: ( ( rulePrimitiveType ) )
            // InternalTechnologyDsl.g:9525:2: ( rulePrimitiveType )
            {
            // InternalTechnologyDsl.g:9525:2: ( rulePrimitiveType )
            // InternalTechnologyDsl.g:9526:3: rulePrimitiveType
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
    // InternalTechnologyDsl.g:9535:1: rule__DataField__ComplexTypeAssignment_1_1 : ( rulePossiblyImportedComplexType ) ;
    public final void rule__DataField__ComplexTypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9539:1: ( ( rulePossiblyImportedComplexType ) )
            // InternalTechnologyDsl.g:9540:2: ( rulePossiblyImportedComplexType )
            {
            // InternalTechnologyDsl.g:9540:2: ( rulePossiblyImportedComplexType )
            // InternalTechnologyDsl.g:9541:3: rulePossiblyImportedComplexType
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
    // InternalTechnologyDsl.g:9550:1: rule__DataField__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__DataField__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9554:1: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:9555:2: ( RULE_ID )
            {
            // InternalTechnologyDsl.g:9555:2: ( RULE_ID )
            // InternalTechnologyDsl.g:9556:3: RULE_ID
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
    // InternalTechnologyDsl.g:9565:1: rule__PossiblyImportedComplexType__ImportAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__PossiblyImportedComplexType__ImportAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9569:1: ( ( ( RULE_ID ) ) )
            // InternalTechnologyDsl.g:9570:2: ( ( RULE_ID ) )
            {
            // InternalTechnologyDsl.g:9570:2: ( ( RULE_ID ) )
            // InternalTechnologyDsl.g:9571:3: ( RULE_ID )
            {
             before(grammarAccess.getPossiblyImportedComplexTypeAccess().getImportComplexTypeImportCrossReference_0_0_0()); 
            // InternalTechnologyDsl.g:9572:3: ( RULE_ID )
            // InternalTechnologyDsl.g:9573:4: RULE_ID
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
    // InternalTechnologyDsl.g:9584:1: rule__PossiblyImportedComplexType__ComplexTypeAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__PossiblyImportedComplexType__ComplexTypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTechnologyDsl.g:9588:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTechnologyDsl.g:9589:2: ( ( ruleQualifiedName ) )
            {
            // InternalTechnologyDsl.g:9589:2: ( ( ruleQualifiedName ) )
            // InternalTechnologyDsl.g:9590:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getPossiblyImportedComplexTypeAccess().getComplexTypeComplexTypeCrossReference_1_0()); 
            // InternalTechnologyDsl.g:9591:3: ( ruleQualifiedName )
            // InternalTechnologyDsl.g:9592:4: ruleQualifiedName
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


    protected DFA11 dfa11 = new DFA11(this);
    static final String dfa_1s = "\20\uffff";
    static final String dfa_2s = "\1\65\1\4\1\36\13\4\2\uffff";
    static final String dfa_3s = "\1\65\1\4\1\36\1\125\12\37\2\uffff";
    static final String dfa_4s = "\16\uffff\1\1\1\2";
    static final String dfa_5s = "\20\uffff}>";
    static final String[] dfa_6s = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\16\77\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\7\uffff\1\16",
            "\1\16\32\uffff\1\17",
            "\1\16\32\uffff\1\17",
            "\1\16\32\uffff\1\17",
            "\1\16\32\uffff\1\17",
            "\1\16\32\uffff\1\17",
            "\1\16\32\uffff\1\17",
            "\1\16\32\uffff\1\17",
            "\1\16\32\uffff\1\17",
            "\1\16\32\uffff\1\17",
            "\1\16\32\uffff\1\17",
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
            return "1038:1: rule__ListType__Alternatives : ( ( ( rule__ListType__Group_0__0 ) ) | ( ( rule__ListType__Group_1__0 ) ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0060000000000002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000015990000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0062000000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000280000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0062000000000002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000080000000L});
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
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000400000002000L,0x0000000000008000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0008000000002000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000000L,0x0000000000003FF0L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000400000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000400000380000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000400000002000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000001080000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000002L,0x0000000000003FF0L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0200000000002000L,0x0000000000010000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x000000000001C000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x00000000001E0000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x2000400000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000007C00000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000400040002000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0800000080000000L,0x0000000000003FF0L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000080000000L,0x0000000000003FF0L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0060000080000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0060000000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000040000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000080000010L,0x0000000000203FF0L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000010L,0x0000000000203FF0L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000400080000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000010L,0x0000000000003FF0L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});

}