package de.fhdo.ddmm.technology.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTechnologyDslLexer extends Lexer {
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

    public InternalTechnologyDslLexer() {;} 
    public InternalTechnologyDslLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalTechnologyDslLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalTechnologyDsl.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:11:7: ( 'technology' )
            // InternalTechnologyDsl.g:11:9: 'technology'
            {
            match("technology"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:12:7: ( '{' )
            // InternalTechnologyDsl.g:12:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:13:7: ( 'types' )
            // InternalTechnologyDsl.g:13:9: 'types'
            {
            match("types"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:14:7: ( 'compatibility' )
            // InternalTechnologyDsl.g:14:9: 'compatibility'
            {
            match("compatibility"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:15:7: ( 'matrix' )
            // InternalTechnologyDsl.g:15:9: 'matrix'
            {
            match("matrix"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:16:7: ( '}' )
            // InternalTechnologyDsl.g:16:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:17:7: ( 'protocols' )
            // InternalTechnologyDsl.g:17:9: 'protocols'
            {
            match("protocols"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:18:7: ( 'service' )
            // InternalTechnologyDsl.g:18:9: 'service'
            {
            match("service"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:19:7: ( 'aspects' )
            // InternalTechnologyDsl.g:19:9: 'aspects'
            {
            match("aspects"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:20:7: ( 'deployment' )
            // InternalTechnologyDsl.g:20:9: 'deployment'
            {
            match("deployment"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:21:7: ( 'technologies' )
            // InternalTechnologyDsl.g:21:9: 'technologies'
            {
            match("technologies"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:22:7: ( 'infrastructure' )
            // InternalTechnologyDsl.g:22:9: 'infrastructure'
            {
            match("infrastructure"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:23:7: ( 'operation' )
            // InternalTechnologyDsl.g:23:9: 'operation'
            {
            match("operation"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:24:7: ( 'import' )
            // InternalTechnologyDsl.g:24:9: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:25:7: ( 'from' )
            // InternalTechnologyDsl.g:25:9: 'from'
            {
            match("from"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:26:7: ( 'as' )
            // InternalTechnologyDsl.g:26:9: 'as'
            {
            match("as"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:27:7: ( 'data' )
            // InternalTechnologyDsl.g:27:9: 'data'
            {
            match("data"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:28:7: ( 'formats' )
            // InternalTechnologyDsl.g:28:9: 'formats'
            {
            match("formats"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:29:7: ( ',' )
            // InternalTechnologyDsl.g:29:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:30:7: ( 'default' )
            // InternalTechnologyDsl.g:30:9: 'default'
            {
            match("default"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:31:7: ( 'with' )
            // InternalTechnologyDsl.g:31:9: 'with'
            {
            match("with"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:32:7: ( 'format' )
            // InternalTechnologyDsl.g:32:9: 'format'
            {
            match("format"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:33:7: ( ';' )
            // InternalTechnologyDsl.g:33:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:34:7: ( 'primitive' )
            // InternalTechnologyDsl.g:34:9: 'primitive'
            {
            match("primitive"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:35:7: ( 'type' )
            // InternalTechnologyDsl.g:35:9: 'type'
            {
            match("type"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:36:7: ( 'based' )
            // InternalTechnologyDsl.g:36:9: 'based'
            {
            match("based"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:37:7: ( 'on' )
            // InternalTechnologyDsl.g:37:9: 'on'
            {
            match("on"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:38:7: ( 'list' )
            // InternalTechnologyDsl.g:38:9: 'list'
            {
            match("list"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:39:7: ( 'structure' )
            // InternalTechnologyDsl.g:39:9: 'structure'
            {
            match("structure"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:40:7: ( '::' )
            // InternalTechnologyDsl.g:40:9: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:41:7: ( 'environments' )
            // InternalTechnologyDsl.g:41:9: 'environments'
            {
            match("environments"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:42:7: ( '=' )
            // InternalTechnologyDsl.g:42:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:43:7: ( 'properties' )
            // InternalTechnologyDsl.g:43:9: 'properties'
            {
            match("properties"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:44:7: ( 'mandatory' )
            // InternalTechnologyDsl.g:44:9: 'mandatory'
            {
            match("mandatory"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:45:7: ( 'exchange_pattern' )
            // InternalTechnologyDsl.g:45:9: 'exchange_pattern'
            {
            match("exchange_pattern"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:46:7: ( 'communication_type' )
            // InternalTechnologyDsl.g:46:9: 'communication_type'
            {
            match("communication_type"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:47:7: ( 'protocol' )
            // InternalTechnologyDsl.g:47:9: 'protocol'
            {
            match("protocol"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:48:7: ( 'data_format' )
            // InternalTechnologyDsl.g:48:9: 'data_format'
            {
            match("data_format"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:49:7: ( 'selector' )
            // InternalTechnologyDsl.g:49:9: 'selector'
            {
            match("selector"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:50:7: ( '(' )
            // InternalTechnologyDsl.g:50:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:51:7: ( ')' )
            // InternalTechnologyDsl.g:51:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:52:7: ( 'aspect' )
            // InternalTechnologyDsl.g:52:9: 'aspect'
            {
            match("aspect"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:53:7: ( 'for' )
            // InternalTechnologyDsl.g:53:9: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:54:7: ( 'datatypes' )
            // InternalTechnologyDsl.g:54:9: 'datatypes'
            {
            match("datatypes"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:55:7: ( 'version' )
            // InternalTechnologyDsl.g:55:9: 'version'
            {
            match("version"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:56:7: ( 'context' )
            // InternalTechnologyDsl.g:56:9: 'context'
            {
            match("context"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:57:7: ( 'extends' )
            // InternalTechnologyDsl.g:57:9: 'extends'
            {
            match("extends"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:58:7: ( 'hide' )
            // InternalTechnologyDsl.g:58:9: 'hide'
            {
            match("hide"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:59:7: ( 'boolean' )
            // InternalTechnologyDsl.g:59:9: 'boolean'
            {
            match("boolean"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:60:7: ( 'byte' )
            // InternalTechnologyDsl.g:60:9: 'byte'
            {
            match("byte"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:61:7: ( 'char' )
            // InternalTechnologyDsl.g:61:9: 'char'
            {
            match("char"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:62:7: ( 'date' )
            // InternalTechnologyDsl.g:62:9: 'date'
            {
            match("date"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:63:7: ( 'double' )
            // InternalTechnologyDsl.g:63:9: 'double'
            {
            match("double"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:64:7: ( 'float' )
            // InternalTechnologyDsl.g:64:9: 'float'
            {
            match("float"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:65:7: ( 'int' )
            // InternalTechnologyDsl.g:65:9: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:66:7: ( 'long' )
            // InternalTechnologyDsl.g:66:9: 'long'
            {
            match("long"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:67:7: ( 'short' )
            // InternalTechnologyDsl.g:67:9: 'short'
            {
            match("short"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:68:7: ( 'string' )
            // InternalTechnologyDsl.g:68:9: 'string'
            {
            match("string"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:69:7: ( '.' )
            // InternalTechnologyDsl.g:69:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:70:7: ( 'in' )
            // InternalTechnologyDsl.g:70:9: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:71:7: ( 'out' )
            // InternalTechnologyDsl.g:71:9: 'out'
            {
            match("out"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:72:7: ( 'inout' )
            // InternalTechnologyDsl.g:72:9: 'inout'
            {
            match("inout"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:73:7: ( 'sync' )
            // InternalTechnologyDsl.g:73:9: 'sync'
            {
            match("sync"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:74:7: ( 'async' )
            // InternalTechnologyDsl.g:74:9: 'async'
            {
            match("async"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:75:7: ( '<-' )
            // InternalTechnologyDsl.g:75:9: '<-'
            {
            match("<-"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:76:7: ( '->' )
            // InternalTechnologyDsl.g:76:9: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:77:7: ( '<->' )
            // InternalTechnologyDsl.g:77:9: '<->'
            {
            match("<->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:78:7: ( 'microservices' )
            // InternalTechnologyDsl.g:78:9: 'microservices'
            {
            match("microservices"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:79:7: ( 'interfaces' )
            // InternalTechnologyDsl.g:79:9: 'interfaces'
            {
            match("interfaces"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:80:7: ( 'operations' )
            // InternalTechnologyDsl.g:80:9: 'operations'
            {
            match("operations"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:81:7: ( 'parameters' )
            // InternalTechnologyDsl.g:81:9: 'parameters'
            {
            match("parameters"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:82:7: ( 'fields' )
            // InternalTechnologyDsl.g:82:9: 'fields'
            {
            match("fields"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:83:7: ( 'containers' )
            // InternalTechnologyDsl.g:83:9: 'containers'
            {
            match("containers"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "RULE_BIG_DECIMAL"
    public final void mRULE_BIG_DECIMAL() throws RecognitionException {
        try {
            int _type = RULE_BIG_DECIMAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:3128:18: ( ( '-' )? RULE_INT ( '.' RULE_INT )? )
            // InternalTechnologyDsl.g:3128:20: ( '-' )? RULE_INT ( '.' RULE_INT )?
            {
            // InternalTechnologyDsl.g:3128:20: ( '-' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='-') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalTechnologyDsl.g:3128:20: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            mRULE_INT(); 
            // InternalTechnologyDsl.g:3128:34: ( '.' RULE_INT )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='.') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalTechnologyDsl.g:3128:35: '.' RULE_INT
                    {
                    match('.'); 
                    mRULE_INT(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BIG_DECIMAL"

    // $ANTLR start "RULE_BOOLEAN"
    public final void mRULE_BOOLEAN() throws RecognitionException {
        try {
            int _type = RULE_BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:3130:14: ( ( 'true' | 'false' ) )
            // InternalTechnologyDsl.g:3130:16: ( 'true' | 'false' )
            {
            // InternalTechnologyDsl.g:3130:16: ( 'true' | 'false' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='t') ) {
                alt3=1;
            }
            else if ( (LA3_0=='f') ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalTechnologyDsl.g:3130:17: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:3130:24: 'false'
                    {
                    match("false"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BOOLEAN"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:3132:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalTechnologyDsl.g:3132:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalTechnologyDsl.g:3132:11: ( '^' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='^') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalTechnologyDsl.g:3132:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalTechnologyDsl.g:3132:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')||(LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalTechnologyDsl.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            // InternalTechnologyDsl.g:3134:19: ( ( '0' .. '9' )+ )
            // InternalTechnologyDsl.g:3134:21: ( '0' .. '9' )+
            {
            // InternalTechnologyDsl.g:3134:21: ( '0' .. '9' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalTechnologyDsl.g:3134:22: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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

        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:3136:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalTechnologyDsl.g:3136:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalTechnologyDsl.g:3136:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\"') ) {
                alt9=1;
            }
            else if ( (LA9_0=='\'') ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalTechnologyDsl.g:3136:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalTechnologyDsl.g:3136:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop7:
                    do {
                        int alt7=3;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='\\') ) {
                            alt7=1;
                        }
                        else if ( ((LA7_0>='\u0000' && LA7_0<='!')||(LA7_0>='#' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFF')) ) {
                            alt7=2;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:3136:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalTechnologyDsl.g:3136:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalTechnologyDsl.g:3136:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalTechnologyDsl.g:3136:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop8:
                    do {
                        int alt8=3;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0=='\\') ) {
                            alt8=1;
                        }
                        else if ( ((LA8_0>='\u0000' && LA8_0<='&')||(LA8_0>='(' && LA8_0<='[')||(LA8_0>=']' && LA8_0<='\uFFFF')) ) {
                            alt8=2;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalTechnologyDsl.g:3136:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalTechnologyDsl.g:3136:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:3138:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalTechnologyDsl.g:3138:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalTechnologyDsl.g:3138:24: ( options {greedy=false; } : . )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='*') ) {
                    int LA10_1 = input.LA(2);

                    if ( (LA10_1=='/') ) {
                        alt10=2;
                    }
                    else if ( ((LA10_1>='\u0000' && LA10_1<='.')||(LA10_1>='0' && LA10_1<='\uFFFF')) ) {
                        alt10=1;
                    }


                }
                else if ( ((LA10_0>='\u0000' && LA10_0<=')')||(LA10_0>='+' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalTechnologyDsl.g:3138:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:3140:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalTechnologyDsl.g:3140:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalTechnologyDsl.g:3140:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\u0000' && LA11_0<='\t')||(LA11_0>='\u000B' && LA11_0<='\f')||(LA11_0>='\u000E' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalTechnologyDsl.g:3140:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // InternalTechnologyDsl.g:3140:40: ( ( '\\r' )? '\\n' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\n'||LA13_0=='\r') ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalTechnologyDsl.g:3140:41: ( '\\r' )? '\\n'
                    {
                    // InternalTechnologyDsl.g:3140:41: ( '\\r' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='\r') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalTechnologyDsl.g:3140:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:3142:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalTechnologyDsl.g:3142:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalTechnologyDsl.g:3142:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='\t' && LA14_0<='\n')||LA14_0=='\r'||LA14_0==' ') ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalTechnologyDsl.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalTechnologyDsl.g:3144:16: ( . )
            // InternalTechnologyDsl.g:3144:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalTechnologyDsl.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | RULE_BIG_DECIMAL | RULE_BOOLEAN | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt15=81;
        alt15 = dfa15.predict(input);
        switch (alt15) {
            case 1 :
                // InternalTechnologyDsl.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // InternalTechnologyDsl.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // InternalTechnologyDsl.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // InternalTechnologyDsl.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // InternalTechnologyDsl.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // InternalTechnologyDsl.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // InternalTechnologyDsl.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // InternalTechnologyDsl.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // InternalTechnologyDsl.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // InternalTechnologyDsl.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // InternalTechnologyDsl.g:1:70: T__23
                {
                mT__23(); 

                }
                break;
            case 12 :
                // InternalTechnologyDsl.g:1:76: T__24
                {
                mT__24(); 

                }
                break;
            case 13 :
                // InternalTechnologyDsl.g:1:82: T__25
                {
                mT__25(); 

                }
                break;
            case 14 :
                // InternalTechnologyDsl.g:1:88: T__26
                {
                mT__26(); 

                }
                break;
            case 15 :
                // InternalTechnologyDsl.g:1:94: T__27
                {
                mT__27(); 

                }
                break;
            case 16 :
                // InternalTechnologyDsl.g:1:100: T__28
                {
                mT__28(); 

                }
                break;
            case 17 :
                // InternalTechnologyDsl.g:1:106: T__29
                {
                mT__29(); 

                }
                break;
            case 18 :
                // InternalTechnologyDsl.g:1:112: T__30
                {
                mT__30(); 

                }
                break;
            case 19 :
                // InternalTechnologyDsl.g:1:118: T__31
                {
                mT__31(); 

                }
                break;
            case 20 :
                // InternalTechnologyDsl.g:1:124: T__32
                {
                mT__32(); 

                }
                break;
            case 21 :
                // InternalTechnologyDsl.g:1:130: T__33
                {
                mT__33(); 

                }
                break;
            case 22 :
                // InternalTechnologyDsl.g:1:136: T__34
                {
                mT__34(); 

                }
                break;
            case 23 :
                // InternalTechnologyDsl.g:1:142: T__35
                {
                mT__35(); 

                }
                break;
            case 24 :
                // InternalTechnologyDsl.g:1:148: T__36
                {
                mT__36(); 

                }
                break;
            case 25 :
                // InternalTechnologyDsl.g:1:154: T__37
                {
                mT__37(); 

                }
                break;
            case 26 :
                // InternalTechnologyDsl.g:1:160: T__38
                {
                mT__38(); 

                }
                break;
            case 27 :
                // InternalTechnologyDsl.g:1:166: T__39
                {
                mT__39(); 

                }
                break;
            case 28 :
                // InternalTechnologyDsl.g:1:172: T__40
                {
                mT__40(); 

                }
                break;
            case 29 :
                // InternalTechnologyDsl.g:1:178: T__41
                {
                mT__41(); 

                }
                break;
            case 30 :
                // InternalTechnologyDsl.g:1:184: T__42
                {
                mT__42(); 

                }
                break;
            case 31 :
                // InternalTechnologyDsl.g:1:190: T__43
                {
                mT__43(); 

                }
                break;
            case 32 :
                // InternalTechnologyDsl.g:1:196: T__44
                {
                mT__44(); 

                }
                break;
            case 33 :
                // InternalTechnologyDsl.g:1:202: T__45
                {
                mT__45(); 

                }
                break;
            case 34 :
                // InternalTechnologyDsl.g:1:208: T__46
                {
                mT__46(); 

                }
                break;
            case 35 :
                // InternalTechnologyDsl.g:1:214: T__47
                {
                mT__47(); 

                }
                break;
            case 36 :
                // InternalTechnologyDsl.g:1:220: T__48
                {
                mT__48(); 

                }
                break;
            case 37 :
                // InternalTechnologyDsl.g:1:226: T__49
                {
                mT__49(); 

                }
                break;
            case 38 :
                // InternalTechnologyDsl.g:1:232: T__50
                {
                mT__50(); 

                }
                break;
            case 39 :
                // InternalTechnologyDsl.g:1:238: T__51
                {
                mT__51(); 

                }
                break;
            case 40 :
                // InternalTechnologyDsl.g:1:244: T__52
                {
                mT__52(); 

                }
                break;
            case 41 :
                // InternalTechnologyDsl.g:1:250: T__53
                {
                mT__53(); 

                }
                break;
            case 42 :
                // InternalTechnologyDsl.g:1:256: T__54
                {
                mT__54(); 

                }
                break;
            case 43 :
                // InternalTechnologyDsl.g:1:262: T__55
                {
                mT__55(); 

                }
                break;
            case 44 :
                // InternalTechnologyDsl.g:1:268: T__56
                {
                mT__56(); 

                }
                break;
            case 45 :
                // InternalTechnologyDsl.g:1:274: T__57
                {
                mT__57(); 

                }
                break;
            case 46 :
                // InternalTechnologyDsl.g:1:280: T__58
                {
                mT__58(); 

                }
                break;
            case 47 :
                // InternalTechnologyDsl.g:1:286: T__59
                {
                mT__59(); 

                }
                break;
            case 48 :
                // InternalTechnologyDsl.g:1:292: T__60
                {
                mT__60(); 

                }
                break;
            case 49 :
                // InternalTechnologyDsl.g:1:298: T__61
                {
                mT__61(); 

                }
                break;
            case 50 :
                // InternalTechnologyDsl.g:1:304: T__62
                {
                mT__62(); 

                }
                break;
            case 51 :
                // InternalTechnologyDsl.g:1:310: T__63
                {
                mT__63(); 

                }
                break;
            case 52 :
                // InternalTechnologyDsl.g:1:316: T__64
                {
                mT__64(); 

                }
                break;
            case 53 :
                // InternalTechnologyDsl.g:1:322: T__65
                {
                mT__65(); 

                }
                break;
            case 54 :
                // InternalTechnologyDsl.g:1:328: T__66
                {
                mT__66(); 

                }
                break;
            case 55 :
                // InternalTechnologyDsl.g:1:334: T__67
                {
                mT__67(); 

                }
                break;
            case 56 :
                // InternalTechnologyDsl.g:1:340: T__68
                {
                mT__68(); 

                }
                break;
            case 57 :
                // InternalTechnologyDsl.g:1:346: T__69
                {
                mT__69(); 

                }
                break;
            case 58 :
                // InternalTechnologyDsl.g:1:352: T__70
                {
                mT__70(); 

                }
                break;
            case 59 :
                // InternalTechnologyDsl.g:1:358: T__71
                {
                mT__71(); 

                }
                break;
            case 60 :
                // InternalTechnologyDsl.g:1:364: T__72
                {
                mT__72(); 

                }
                break;
            case 61 :
                // InternalTechnologyDsl.g:1:370: T__73
                {
                mT__73(); 

                }
                break;
            case 62 :
                // InternalTechnologyDsl.g:1:376: T__74
                {
                mT__74(); 

                }
                break;
            case 63 :
                // InternalTechnologyDsl.g:1:382: T__75
                {
                mT__75(); 

                }
                break;
            case 64 :
                // InternalTechnologyDsl.g:1:388: T__76
                {
                mT__76(); 

                }
                break;
            case 65 :
                // InternalTechnologyDsl.g:1:394: T__77
                {
                mT__77(); 

                }
                break;
            case 66 :
                // InternalTechnologyDsl.g:1:400: T__78
                {
                mT__78(); 

                }
                break;
            case 67 :
                // InternalTechnologyDsl.g:1:406: T__79
                {
                mT__79(); 

                }
                break;
            case 68 :
                // InternalTechnologyDsl.g:1:412: T__80
                {
                mT__80(); 

                }
                break;
            case 69 :
                // InternalTechnologyDsl.g:1:418: T__81
                {
                mT__81(); 

                }
                break;
            case 70 :
                // InternalTechnologyDsl.g:1:424: T__82
                {
                mT__82(); 

                }
                break;
            case 71 :
                // InternalTechnologyDsl.g:1:430: T__83
                {
                mT__83(); 

                }
                break;
            case 72 :
                // InternalTechnologyDsl.g:1:436: T__84
                {
                mT__84(); 

                }
                break;
            case 73 :
                // InternalTechnologyDsl.g:1:442: T__85
                {
                mT__85(); 

                }
                break;
            case 74 :
                // InternalTechnologyDsl.g:1:448: RULE_BIG_DECIMAL
                {
                mRULE_BIG_DECIMAL(); 

                }
                break;
            case 75 :
                // InternalTechnologyDsl.g:1:465: RULE_BOOLEAN
                {
                mRULE_BOOLEAN(); 

                }
                break;
            case 76 :
                // InternalTechnologyDsl.g:1:478: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 77 :
                // InternalTechnologyDsl.g:1:486: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 78 :
                // InternalTechnologyDsl.g:1:498: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 79 :
                // InternalTechnologyDsl.g:1:514: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 80 :
                // InternalTechnologyDsl.g:1:530: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 81 :
                // InternalTechnologyDsl.g:1:538: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA15_eotS =
        "\1\uffff\1\47\1\uffff\2\47\1\uffff\7\47\1\uffff\1\47\1\uffff\2\47\1\43\1\47\3\uffff\2\47\1\uffff\2\43\1\uffff\1\43\1\uffff\3\43\2\uffff\3\47\2\uffff\4\47\1\uffff\6\47\1\155\3\47\1\165\2\47\1\170\6\47\1\uffff\1\47\1\uffff\5\47\1\uffff\2\47\3\uffff\2\47\1\uffff\1\u008b\6\uffff\23\47\1\uffff\5\47\1\u00a9\1\47\1\uffff\2\47\1\uffff\1\u00ad\1\47\1\u00b0\16\47\2\uffff\1\47\1\u00c1\1\u00c2\3\47\1\u00c7\14\47\1\u00d4\4\47\1\u00db\1\u00dc\3\47\1\uffff\3\47\1\uffff\1\u00e3\1\47\1\uffff\3\47\1\u00e8\2\47\1\u00eb\1\u00ec\1\u00ed\4\47\1\u00f2\1\47\1\u00f4\2\uffff\4\47\1\uffff\13\47\1\u0104\1\uffff\1\47\1\u0106\4\47\2\uffff\3\47\1\u010e\2\47\1\uffff\1\47\1\u0112\1\47\1\u00c2\1\uffff\1\u0114\1\47\3\uffff\4\47\1\uffff\1\47\1\uffff\4\47\1\u011f\11\47\1\u0129\1\uffff\1\u012b\1\uffff\4\47\1\u0130\2\47\1\uffff\1\u0133\1\47\1\u0136\1\uffff\1\u0137\1\uffff\10\47\1\u0140\1\47\1\uffff\6\47\1\u0148\2\47\1\uffff\1\u014b\1\uffff\1\47\1\u014d\2\47\1\uffff\2\47\1\uffff\1\47\1\u0153\2\uffff\1\u0154\2\47\1\u0157\1\u0158\3\47\1\uffff\3\47\1\u0160\3\47\1\uffff\1\u0164\1\47\1\uffff\1\47\1\uffff\5\47\2\uffff\2\47\2\uffff\4\47\1\u0173\1\47\1\u0175\1\uffff\1\47\1\u0177\1\47\1\uffff\1\u0179\2\47\1\u017c\2\47\1\u0180\2\47\1\u0183\3\47\1\u0187\1\uffff\1\47\1\uffff\1\u0189\1\uffff\1\u018a\1\uffff\1\u018b\1\47\1\uffff\1\47\1\u018e\1\u018f\1\uffff\2\47\1\uffff\3\47\1\uffff\1\47\3\uffff\1\u0196\1\47\2\uffff\2\47\1\u019a\3\47\1\uffff\1\47\1\u019f\1\47\1\uffff\1\u01a1\1\47\1\u01a3\1\47\1\uffff\1\47\1\uffff\1\47\1\uffff\1\u01a7\2\47\1\uffff\2\47\1\u01ac\1\47\1\uffff\1\u01ae\1\uffff";
    static final String DFA15_eofS =
        "\u01af\uffff";
    static final String DFA15_minS =
        "\1\0\1\145\1\uffff\1\150\1\141\1\uffff\1\141\1\145\1\163\1\141\1\155\1\156\1\141\1\uffff\1\151\1\uffff\1\141\1\151\1\72\1\156\3\uffff\1\145\1\151\1\uffff\1\55\1\60\1\uffff\1\101\1\uffff\2\0\1\52\2\uffff\1\143\1\160\1\165\2\uffff\1\155\1\141\1\156\1\143\1\uffff\1\151\1\162\1\154\1\162\1\157\1\156\1\60\1\146\1\164\1\165\1\60\1\160\1\145\1\60\1\164\1\157\1\162\1\157\1\145\1\154\1\uffff\1\164\1\uffff\1\163\1\157\1\164\1\163\1\156\1\uffff\1\166\1\143\3\uffff\1\162\1\144\1\uffff\1\76\6\uffff\1\150\2\145\1\155\1\164\2\162\1\144\1\162\1\160\1\155\1\141\1\166\1\145\1\151\1\162\1\143\1\145\1\156\1\uffff\1\154\2\141\1\142\1\162\1\60\1\165\1\uffff\1\157\1\162\1\uffff\1\60\1\155\1\60\1\141\1\154\1\163\1\150\1\145\1\154\1\145\1\164\1\147\1\151\1\150\1\145\1\163\1\145\2\uffff\1\156\2\60\1\141\1\165\1\141\1\60\1\151\1\141\2\157\1\145\1\151\1\155\1\151\2\143\1\156\1\164\1\60\2\143\1\157\1\165\2\60\1\154\1\141\1\162\1\uffff\1\164\1\162\1\141\1\uffff\1\60\1\141\1\uffff\1\164\1\144\1\145\1\60\1\144\1\145\3\60\1\162\1\141\1\156\1\151\1\60\1\157\1\60\2\uffff\1\164\1\156\1\170\1\151\1\uffff\1\170\1\164\1\163\1\143\1\162\1\164\1\145\1\143\2\164\1\147\1\60\1\uffff\1\164\1\60\1\171\1\154\1\146\1\171\2\uffff\1\145\1\163\1\146\1\60\2\164\1\uffff\1\164\1\60\1\163\1\60\1\uffff\1\60\1\141\3\uffff\1\157\1\156\1\144\1\157\1\uffff\1\154\1\uffff\2\151\1\164\1\156\1\60\1\157\1\145\1\157\1\164\1\151\1\164\1\145\1\157\1\165\1\60\1\uffff\1\60\1\uffff\1\155\1\164\1\157\1\160\1\60\1\164\1\141\1\uffff\1\60\1\151\1\60\1\uffff\1\60\1\uffff\2\156\1\147\1\163\1\156\1\157\1\142\1\143\1\60\1\145\1\uffff\2\162\1\154\1\151\1\166\1\145\1\60\2\162\1\uffff\1\60\1\uffff\1\145\1\60\1\162\1\145\1\uffff\1\162\1\143\1\uffff\1\157\1\60\2\uffff\1\60\1\155\1\145\2\60\1\147\1\151\1\141\1\uffff\1\162\1\171\1\166\1\60\2\145\1\162\1\uffff\1\60\1\145\1\uffff\1\156\1\uffff\1\155\1\163\1\165\1\145\1\156\2\uffff\1\145\1\137\2\uffff\1\151\1\154\1\164\1\163\1\60\1\151\1\60\1\uffff\1\163\1\60\1\163\1\uffff\1\60\1\164\1\141\1\60\1\143\1\163\1\60\1\156\1\160\1\60\1\145\2\151\1\60\1\uffff\1\143\1\uffff\1\60\1\uffff\1\60\1\uffff\1\60\1\164\1\uffff\1\164\2\60\1\uffff\1\164\1\141\1\uffff\1\163\1\164\1\157\1\uffff\1\145\3\uffff\1\60\1\165\2\uffff\1\163\1\164\1\60\1\171\1\156\1\163\1\uffff\1\162\1\60\1\164\1\uffff\1\60\1\137\1\60\1\145\1\uffff\1\145\1\uffff\1\164\1\uffff\1\60\1\162\1\171\1\uffff\1\156\1\160\1\60\1\145\1\uffff\1\60\1\uffff";
    static final String DFA15_maxS =
        "\1\uffff\1\171\1\uffff\1\157\1\151\1\uffff\1\162\1\171\1\163\1\157\1\156\1\165\1\162\1\uffff\1\151\1\uffff\1\171\1\157\1\72\1\170\3\uffff\1\145\1\151\1\uffff\1\55\1\76\1\uffff\1\172\1\uffff\2\uffff\1\57\2\uffff\1\143\1\160\1\165\2\uffff\1\156\1\141\1\164\1\143\1\uffff\1\157\3\162\1\157\1\156\1\172\1\160\1\164\1\165\1\172\1\160\1\145\1\172\1\164\1\157\1\162\1\157\1\145\1\154\1\uffff\1\164\1\uffff\1\163\1\157\1\164\1\163\1\156\1\uffff\1\166\1\164\3\uffff\1\162\1\144\1\uffff\1\76\6\uffff\1\150\2\145\1\160\1\164\2\162\1\144\1\162\1\164\1\155\1\141\1\166\1\145\1\165\1\162\1\143\1\145\1\156\1\uffff\1\154\1\141\1\145\1\142\1\162\1\172\1\165\1\uffff\1\157\1\162\1\uffff\1\172\1\155\1\172\1\141\1\154\1\163\1\150\1\145\1\154\1\145\1\164\1\147\1\151\1\150\1\145\1\163\1\145\2\uffff\1\156\2\172\1\141\1\165\1\145\1\172\1\151\1\141\2\157\1\145\1\151\1\155\1\151\2\143\1\156\1\164\1\172\2\143\1\157\1\165\2\172\1\154\1\141\1\162\1\uffff\1\164\1\162\1\141\1\uffff\1\172\1\141\1\uffff\1\164\1\144\1\145\1\172\1\144\1\145\3\172\1\162\1\141\1\156\1\151\1\172\1\157\1\172\2\uffff\1\164\1\156\1\170\1\151\1\uffff\1\170\1\164\1\163\1\143\1\162\1\164\1\145\1\143\2\164\1\147\1\172\1\uffff\1\164\1\172\1\171\1\154\1\146\1\171\2\uffff\1\145\1\163\1\146\1\172\2\164\1\uffff\1\164\1\172\1\163\1\172\1\uffff\1\172\1\141\3\uffff\1\157\1\156\1\144\1\157\1\uffff\1\154\1\uffff\2\151\1\164\1\156\1\172\1\157\1\145\1\157\1\164\1\151\1\164\1\145\1\157\1\165\1\172\1\uffff\1\172\1\uffff\1\155\1\164\1\157\1\160\1\172\1\164\1\141\1\uffff\1\172\1\151\1\172\1\uffff\1\172\1\uffff\2\156\1\147\1\163\1\156\1\157\1\142\1\143\1\172\1\145\1\uffff\2\162\1\154\1\151\1\166\1\145\1\172\2\162\1\uffff\1\172\1\uffff\1\145\1\172\1\162\1\145\1\uffff\1\162\1\143\1\uffff\1\157\1\172\2\uffff\1\172\1\155\1\145\2\172\1\147\1\151\1\141\1\uffff\1\162\1\171\1\166\1\172\2\145\1\162\1\uffff\1\172\1\145\1\uffff\1\156\1\uffff\1\155\1\163\1\165\1\145\1\156\2\uffff\1\145\1\137\2\uffff\1\171\1\154\1\164\1\163\1\172\1\151\1\172\1\uffff\1\163\1\172\1\163\1\uffff\1\172\1\164\1\141\1\172\1\143\1\163\1\172\1\156\1\160\1\172\1\145\2\151\1\172\1\uffff\1\143\1\uffff\1\172\1\uffff\1\172\1\uffff\1\172\1\164\1\uffff\1\164\2\172\1\uffff\1\164\1\141\1\uffff\1\163\1\164\1\157\1\uffff\1\145\3\uffff\1\172\1\165\2\uffff\1\163\1\164\1\172\1\171\1\156\1\163\1\uffff\1\162\1\172\1\164\1\uffff\1\172\1\137\1\172\1\145\1\uffff\1\145\1\uffff\1\164\1\uffff\1\172\1\162\1\171\1\uffff\1\156\1\160\1\172\1\145\1\uffff\1\172\1\uffff";
    static final String DFA15_acceptS =
        "\2\uffff\1\2\2\uffff\1\6\7\uffff\1\23\1\uffff\1\27\4\uffff\1\40\1\50\1\51\2\uffff\1\73\2\uffff\1\112\1\uffff\1\114\3\uffff\1\120\1\121\3\uffff\1\114\1\2\4\uffff\1\6\24\uffff\1\23\1\uffff\1\27\5\uffff\1\36\2\uffff\1\40\1\50\1\51\2\uffff\1\73\1\uffff\1\102\1\112\1\115\1\116\1\117\1\120\23\uffff\1\20\7\uffff\1\74\2\uffff\1\33\21\uffff\1\103\1\101\35\uffff\1\67\3\uffff\1\75\2\uffff\1\53\20\uffff\1\31\1\113\4\uffff\1\63\14\uffff\1\77\6\uffff\1\21\1\64\6\uffff\1\17\4\uffff\1\25\2\uffff\1\62\1\34\1\70\4\uffff\1\60\1\uffff\1\3\17\uffff\1\71\1\uffff\1\100\7\uffff\1\76\3\uffff\1\66\1\uffff\1\32\12\uffff\1\5\11\uffff\1\72\1\uffff\1\52\4\uffff\1\65\2\uffff\1\16\2\uffff\1\26\1\110\10\uffff\1\56\7\uffff\1\10\2\uffff\1\11\1\uffff\1\24\5\uffff\1\22\1\61\2\uffff\1\57\1\55\7\uffff\1\45\3\uffff\1\47\16\uffff\1\42\1\uffff\1\7\1\uffff\1\30\1\uffff\1\35\2\uffff\1\54\3\uffff\1\15\2\uffff\1\1\3\uffff\1\111\1\uffff\1\41\1\107\1\12\2\uffff\1\105\1\106\6\uffff\1\46\3\uffff\1\13\4\uffff\1\37\1\uffff\1\4\1\uffff\1\104\3\uffff\1\14\4\uffff\1\43\1\uffff\1\44";
    static final String DFA15_specialS =
        "\1\0\36\uffff\1\1\1\2\u018e\uffff}>";
    static final String[] DFA15_transitionS = {
            "\11\43\2\42\2\43\1\42\22\43\1\42\1\43\1\37\4\43\1\40\1\25\1\26\2\43\1\15\1\33\1\31\1\41\12\34\1\22\1\17\1\32\1\24\3\43\32\36\3\43\1\35\1\36\1\43\1\10\1\20\1\3\1\11\1\23\1\14\1\36\1\30\1\12\2\36\1\21\1\4\1\36\1\13\1\6\2\36\1\7\1\1\1\36\1\27\1\16\3\36\1\2\1\43\1\5\uff82\43",
            "\1\44\14\uffff\1\46\6\uffff\1\45",
            "",
            "\1\52\6\uffff\1\51",
            "\1\53\7\uffff\1\54",
            "",
            "\1\57\20\uffff\1\56",
            "\1\60\2\uffff\1\62\13\uffff\1\61\4\uffff\1\63",
            "\1\64",
            "\1\66\3\uffff\1\65\11\uffff\1\67",
            "\1\71\1\70",
            "\1\73\1\uffff\1\72\4\uffff\1\74",
            "\1\101\7\uffff\1\100\2\uffff\1\77\2\uffff\1\76\2\uffff\1\75",
            "",
            "\1\103",
            "",
            "\1\105\15\uffff\1\106\11\uffff\1\107",
            "\1\110\5\uffff\1\111",
            "\1\112",
            "\1\113\11\uffff\1\114",
            "",
            "",
            "",
            "\1\120",
            "\1\121",
            "",
            "\1\123",
            "\12\125\4\uffff\1\124",
            "",
            "\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\0\126",
            "\0\126",
            "\1\127\4\uffff\1\130",
            "",
            "",
            "\1\132",
            "\1\133",
            "\1\134",
            "",
            "",
            "\1\135\1\136",
            "\1\137",
            "\1\141\5\uffff\1\140",
            "\1\142",
            "",
            "\1\144\5\uffff\1\143",
            "\1\145",
            "\1\147\5\uffff\1\146",
            "\1\150",
            "\1\151",
            "\1\152",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\17\47\1\153\10\47\1\154\1\47",
            "\1\157\11\uffff\1\156",
            "\1\160",
            "\1\161",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\5\47\1\162\10\47\1\164\4\47\1\163\6\47",
            "\1\166",
            "\1\167",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "\1\176",
            "",
            "\1\177",
            "",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "",
            "\1\u0085",
            "\1\u0086\20\uffff\1\u0087",
            "",
            "",
            "",
            "\1\u0088",
            "\1\u0089",
            "",
            "\1\u008a",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u0090\2\uffff\1\u008f",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0097\3\uffff\1\u0096",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\u009d\13\uffff\1\u009c",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4\3\uffff\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\4\47\1\u00a8\25\47",
            "\1\u00aa",
            "",
            "\1\u00ab",
            "\1\u00ac",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00ae",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\14\47\1\u00af\15\47",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "",
            "",
            "\1\u00bf",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\22\47\1\u00c0\7\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c6\3\uffff\1\u00c5",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\12\47\7\uffff\32\47\4\uffff\1\u00d9\1\uffff\23\47\1\u00da\6\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00e4",
            "",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00e9",
            "\1\u00ea",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00f3",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "\1\u00f8",
            "",
            "\1\u00f9",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "\1\u0102",
            "\1\u0103",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\1\u0105",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "",
            "",
            "\1\u010b",
            "\1\u010c",
            "\1\u010d",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u010f",
            "\1\u0110",
            "",
            "\1\u0111",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0113",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0115",
            "",
            "",
            "",
            "\1\u0116",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119",
            "",
            "\1\u011a",
            "",
            "\1\u011b",
            "\1\u011c",
            "\1\u011d",
            "\1\u011e",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0120",
            "\1\u0121",
            "\1\u0122",
            "\1\u0123",
            "\1\u0124",
            "\1\u0125",
            "\1\u0126",
            "\1\u0127",
            "\1\u0128",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\22\47\1\u012a\7\47",
            "",
            "\1\u012c",
            "\1\u012d",
            "\1\u012e",
            "\1\u012f",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0131",
            "\1\u0132",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0134",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\22\47\1\u0135\7\47",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\1\u0138",
            "\1\u0139",
            "\1\u013a",
            "\1\u013b",
            "\1\u013c",
            "\1\u013d",
            "\1\u013e",
            "\1\u013f",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0141",
            "",
            "\1\u0142",
            "\1\u0143",
            "\1\u0144",
            "\1\u0145",
            "\1\u0146",
            "\1\u0147",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0149",
            "\1\u014a",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\1\u014c",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u014e",
            "\1\u014f",
            "",
            "\1\u0150",
            "\1\u0151",
            "",
            "\1\u0152",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0155",
            "\1\u0156",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0159",
            "\1\u015a",
            "\1\u015b",
            "",
            "\1\u015c",
            "\1\u015d",
            "\1\u015e",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\22\47\1\u015f\7\47",
            "\1\u0161",
            "\1\u0162",
            "\1\u0163",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0165",
            "",
            "\1\u0166",
            "",
            "\1\u0167",
            "\1\u0168",
            "\1\u0169",
            "\1\u016a",
            "\1\u016b",
            "",
            "",
            "\1\u016c",
            "\1\u016d",
            "",
            "",
            "\1\u016f\17\uffff\1\u016e",
            "\1\u0170",
            "\1\u0171",
            "\1\u0172",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0174",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\1\u0176",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0178",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u017a",
            "\1\u017b",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u017d",
            "\1\u017e",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\22\47\1\u017f\7\47",
            "\1\u0181",
            "\1\u0182",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0184",
            "\1\u0185",
            "\1\u0186",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\1\u0188",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u018c",
            "",
            "\1\u018d",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\1\u0190",
            "\1\u0191",
            "",
            "\1\u0192",
            "\1\u0193",
            "\1\u0194",
            "",
            "\1\u0195",
            "",
            "",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0197",
            "",
            "",
            "\1\u0198",
            "\1\u0199",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u019b",
            "\1\u019c",
            "\1\u019d",
            "",
            "\1\u019e",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u01a0",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u01a2",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u01a4",
            "",
            "\1\u01a5",
            "",
            "\1\u01a6",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u01a8",
            "\1\u01a9",
            "",
            "\1\u01aa",
            "\1\u01ab",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u01ad",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            ""
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | RULE_BIG_DECIMAL | RULE_BOOLEAN | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA15_0 = input.LA(1);

                        s = -1;
                        if ( (LA15_0=='t') ) {s = 1;}

                        else if ( (LA15_0=='{') ) {s = 2;}

                        else if ( (LA15_0=='c') ) {s = 3;}

                        else if ( (LA15_0=='m') ) {s = 4;}

                        else if ( (LA15_0=='}') ) {s = 5;}

                        else if ( (LA15_0=='p') ) {s = 6;}

                        else if ( (LA15_0=='s') ) {s = 7;}

                        else if ( (LA15_0=='a') ) {s = 8;}

                        else if ( (LA15_0=='d') ) {s = 9;}

                        else if ( (LA15_0=='i') ) {s = 10;}

                        else if ( (LA15_0=='o') ) {s = 11;}

                        else if ( (LA15_0=='f') ) {s = 12;}

                        else if ( (LA15_0==',') ) {s = 13;}

                        else if ( (LA15_0=='w') ) {s = 14;}

                        else if ( (LA15_0==';') ) {s = 15;}

                        else if ( (LA15_0=='b') ) {s = 16;}

                        else if ( (LA15_0=='l') ) {s = 17;}

                        else if ( (LA15_0==':') ) {s = 18;}

                        else if ( (LA15_0=='e') ) {s = 19;}

                        else if ( (LA15_0=='=') ) {s = 20;}

                        else if ( (LA15_0=='(') ) {s = 21;}

                        else if ( (LA15_0==')') ) {s = 22;}

                        else if ( (LA15_0=='v') ) {s = 23;}

                        else if ( (LA15_0=='h') ) {s = 24;}

                        else if ( (LA15_0=='.') ) {s = 25;}

                        else if ( (LA15_0=='<') ) {s = 26;}

                        else if ( (LA15_0=='-') ) {s = 27;}

                        else if ( ((LA15_0>='0' && LA15_0<='9')) ) {s = 28;}

                        else if ( (LA15_0=='^') ) {s = 29;}

                        else if ( ((LA15_0>='A' && LA15_0<='Z')||LA15_0=='_'||LA15_0=='g'||(LA15_0>='j' && LA15_0<='k')||LA15_0=='n'||(LA15_0>='q' && LA15_0<='r')||LA15_0=='u'||(LA15_0>='x' && LA15_0<='z')) ) {s = 30;}

                        else if ( (LA15_0=='\"') ) {s = 31;}

                        else if ( (LA15_0=='\'') ) {s = 32;}

                        else if ( (LA15_0=='/') ) {s = 33;}

                        else if ( ((LA15_0>='\t' && LA15_0<='\n')||LA15_0=='\r'||LA15_0==' ') ) {s = 34;}

                        else if ( ((LA15_0>='\u0000' && LA15_0<='\b')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='\u001F')||LA15_0=='!'||(LA15_0>='#' && LA15_0<='&')||(LA15_0>='*' && LA15_0<='+')||(LA15_0>='>' && LA15_0<='@')||(LA15_0>='[' && LA15_0<=']')||LA15_0=='`'||LA15_0=='|'||(LA15_0>='~' && LA15_0<='\uFFFF')) ) {s = 35;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA15_31 = input.LA(1);

                        s = -1;
                        if ( ((LA15_31>='\u0000' && LA15_31<='\uFFFF')) ) {s = 86;}

                        else s = 35;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA15_32 = input.LA(1);

                        s = -1;
                        if ( ((LA15_32>='\u0000' && LA15_32<='\uFFFF')) ) {s = 86;}

                        else s = 35;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 15, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}