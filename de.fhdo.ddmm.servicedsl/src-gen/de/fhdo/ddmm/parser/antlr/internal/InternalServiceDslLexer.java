package de.fhdo.ddmm.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalServiceDslLexer extends Lexer {
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int RULE_INT=8;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
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
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__90=90;
    public static final int RULE_BOOLEAN=7;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int RULE_BIG_DECIMAL=6;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;

    // delegates
    // delegators

    public InternalServiceDslLexer() {;} 
    public InternalServiceDslLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalServiceDslLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalServiceDsl.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalServiceDsl.g:11:7: ( 'import' )
            // InternalServiceDsl.g:11:9: 'import'
            {
            match("import"); 


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
            // InternalServiceDsl.g:12:7: ( 'from' )
            // InternalServiceDsl.g:12:9: 'from'
            {
            match("from"); 


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
            // InternalServiceDsl.g:13:7: ( 'as' )
            // InternalServiceDsl.g:13:9: 'as'
            {
            match("as"); 


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
            // InternalServiceDsl.g:14:7: ( '@' )
            // InternalServiceDsl.g:14:9: '@'
            {
            match('@'); 

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
            // InternalServiceDsl.g:15:7: ( 'technology' )
            // InternalServiceDsl.g:15:9: 'technology'
            {
            match("technology"); 


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
            // InternalServiceDsl.g:16:7: ( '(' )
            // InternalServiceDsl.g:16:9: '('
            {
            match('('); 

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
            // InternalServiceDsl.g:17:7: ( ')' )
            // InternalServiceDsl.g:17:9: ')'
            {
            match(')'); 

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
            // InternalServiceDsl.g:18:7: ( 'endpoints' )
            // InternalServiceDsl.g:18:9: 'endpoints'
            {
            match("endpoints"); 


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
            // InternalServiceDsl.g:19:7: ( 'microservice' )
            // InternalServiceDsl.g:19:9: 'microservice'
            {
            match("microservice"); 


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
            // InternalServiceDsl.g:20:7: ( 'version' )
            // InternalServiceDsl.g:20:9: 'version'
            {
            match("version"); 


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
            // InternalServiceDsl.g:21:7: ( '{' )
            // InternalServiceDsl.g:21:9: '{'
            {
            match('{'); 

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
            // InternalServiceDsl.g:22:7: ( 'required' )
            // InternalServiceDsl.g:22:9: 'required'
            {
            match("required"); 


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
            // InternalServiceDsl.g:23:7: ( 'microservices' )
            // InternalServiceDsl.g:23:9: 'microservices'
            {
            match("microservices"); 


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
            // InternalServiceDsl.g:24:7: ( ',' )
            // InternalServiceDsl.g:24:9: ','
            {
            match(','); 

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
            // InternalServiceDsl.g:25:7: ( '}' )
            // InternalServiceDsl.g:25:9: '}'
            {
            match('}'); 

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
            // InternalServiceDsl.g:26:7: ( 'interfaces' )
            // InternalServiceDsl.g:26:9: 'interfaces'
            {
            match("interfaces"); 


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
            // InternalServiceDsl.g:27:7: ( 'operations' )
            // InternalServiceDsl.g:27:9: 'operations'
            {
            match("operations"); 


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
            // InternalServiceDsl.g:28:7: ( '::' )
            // InternalServiceDsl.g:28:9: '::'
            {
            match("::"); 


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
            // InternalServiceDsl.g:29:7: ( 'noimpl' )
            // InternalServiceDsl.g:29:9: 'noimpl'
            {
            match("noimpl"); 


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
            // InternalServiceDsl.g:30:7: ( 'interface' )
            // InternalServiceDsl.g:30:9: 'interface'
            {
            match("interface"); 


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
            // InternalServiceDsl.g:31:7: ( ';' )
            // InternalServiceDsl.g:31:9: ';'
            {
            match(';'); 

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
            // InternalServiceDsl.g:32:7: ( 'refers' )
            // InternalServiceDsl.g:32:9: 'refers'
            {
            match("refers"); 


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
            // InternalServiceDsl.g:33:7: ( 'fault' )
            // InternalServiceDsl.g:33:9: 'fault'
            {
            match("fault"); 


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
            // InternalServiceDsl.g:34:7: ( '?' )
            // InternalServiceDsl.g:34:9: '?'
            {
            match('?'); 

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
            // InternalServiceDsl.g:35:7: ( ':' )
            // InternalServiceDsl.g:35:9: ':'
            {
            match(':'); 

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
            // InternalServiceDsl.g:36:7: ( '=' )
            // InternalServiceDsl.g:36:9: '='
            {
            match('='); 

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
            // InternalServiceDsl.g:37:7: ( '/' )
            // InternalServiceDsl.g:37:9: '/'
            {
            match('/'); 

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
            // InternalServiceDsl.g:38:7: ( '.' )
            // InternalServiceDsl.g:38:9: '.'
            {
            match('.'); 

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
            // InternalServiceDsl.g:39:7: ( 'data' )
            // InternalServiceDsl.g:39:9: 'data'
            {
            match("data"); 


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
            // InternalServiceDsl.g:40:7: ( 'formats' )
            // InternalServiceDsl.g:40:9: 'formats'
            {
            match("formats"); 


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
            // InternalServiceDsl.g:41:7: ( 'default' )
            // InternalServiceDsl.g:41:9: 'default'
            {
            match("default"); 


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
            // InternalServiceDsl.g:42:7: ( 'with' )
            // InternalServiceDsl.g:42:9: 'with'
            {
            match("with"); 


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
            // InternalServiceDsl.g:43:7: ( 'format' )
            // InternalServiceDsl.g:43:9: 'format'
            {
            match("format"); 


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
            // InternalServiceDsl.g:44:7: ( 'primitive' )
            // InternalServiceDsl.g:44:9: 'primitive'
            {
            match("primitive"); 


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
            // InternalServiceDsl.g:45:7: ( 'type' )
            // InternalServiceDsl.g:45:9: 'type'
            {
            match("type"); 


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
            // InternalServiceDsl.g:46:7: ( 'based' )
            // InternalServiceDsl.g:46:9: 'based'
            {
            match("based"); 


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
            // InternalServiceDsl.g:47:7: ( 'on' )
            // InternalServiceDsl.g:47:9: 'on'
            {
            match("on"); 


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
            // InternalServiceDsl.g:48:7: ( 'list' )
            // InternalServiceDsl.g:48:9: 'list'
            {
            match("list"); 


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
            // InternalServiceDsl.g:49:7: ( 'structure' )
            // InternalServiceDsl.g:49:9: 'structure'
            {
            match("structure"); 


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
            // InternalServiceDsl.g:50:7: ( 'operation' )
            // InternalServiceDsl.g:50:9: 'operation'
            {
            match("operation"); 


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
            // InternalServiceDsl.g:51:7: ( 'environments' )
            // InternalServiceDsl.g:51:9: 'environments'
            {
            match("environments"); 


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
            // InternalServiceDsl.g:52:7: ( 'service' )
            // InternalServiceDsl.g:52:9: 'service'
            {
            match("service"); 


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
            // InternalServiceDsl.g:53:7: ( 'properties' )
            // InternalServiceDsl.g:53:9: 'properties'
            {
            match("properties"); 


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
            // InternalServiceDsl.g:54:7: ( 'mandatory' )
            // InternalServiceDsl.g:54:9: 'mandatory'
            {
            match("mandatory"); 


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
            // InternalServiceDsl.g:55:7: ( 'exchange_pattern' )
            // InternalServiceDsl.g:55:9: 'exchange_pattern'
            {
            match("exchange_pattern"); 


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
            // InternalServiceDsl.g:56:7: ( 'communication_type' )
            // InternalServiceDsl.g:56:9: 'communication_type'
            {
            match("communication_type"); 


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
            // InternalServiceDsl.g:57:7: ( 'protocol' )
            // InternalServiceDsl.g:57:9: 'protocol'
            {
            match("protocol"); 


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
            // InternalServiceDsl.g:58:7: ( 'data_format' )
            // InternalServiceDsl.g:58:9: 'data_format'
            {
            match("data_format"); 


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
            // InternalServiceDsl.g:59:7: ( 'selector' )
            // InternalServiceDsl.g:59:9: 'selector'
            {
            match("selector"); 


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
            // InternalServiceDsl.g:60:7: ( 'aspect' )
            // InternalServiceDsl.g:60:9: 'aspect'
            {
            match("aspect"); 


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
            // InternalServiceDsl.g:61:7: ( 'for' )
            // InternalServiceDsl.g:61:9: 'for'
            {
            match("for"); 


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
            // InternalServiceDsl.g:62:7: ( 'datatypes' )
            // InternalServiceDsl.g:62:9: 'datatypes'
            {
            match("datatypes"); 


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
            // InternalServiceDsl.g:63:7: ( 'context' )
            // InternalServiceDsl.g:63:9: 'context'
            {
            match("context"); 


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
            // InternalServiceDsl.g:64:7: ( 'extends' )
            // InternalServiceDsl.g:64:9: 'extends'
            {
            match("extends"); 


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
            // InternalServiceDsl.g:65:7: ( 'hide' )
            // InternalServiceDsl.g:65:9: 'hide'
            {
            match("hide"); 


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
            // InternalServiceDsl.g:66:7: ( 'boolean' )
            // InternalServiceDsl.g:66:9: 'boolean'
            {
            match("boolean"); 


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
            // InternalServiceDsl.g:67:7: ( 'byte' )
            // InternalServiceDsl.g:67:9: 'byte'
            {
            match("byte"); 


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
            // InternalServiceDsl.g:68:7: ( 'char' )
            // InternalServiceDsl.g:68:9: 'char'
            {
            match("char"); 


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
            // InternalServiceDsl.g:69:7: ( 'date' )
            // InternalServiceDsl.g:69:9: 'date'
            {
            match("date"); 


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
            // InternalServiceDsl.g:70:7: ( 'double' )
            // InternalServiceDsl.g:70:9: 'double'
            {
            match("double"); 


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
            // InternalServiceDsl.g:71:7: ( 'float' )
            // InternalServiceDsl.g:71:9: 'float'
            {
            match("float"); 


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
            // InternalServiceDsl.g:72:7: ( 'int' )
            // InternalServiceDsl.g:72:9: 'int'
            {
            match("int"); 


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
            // InternalServiceDsl.g:73:7: ( 'long' )
            // InternalServiceDsl.g:73:9: 'long'
            {
            match("long"); 


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
            // InternalServiceDsl.g:74:7: ( 'short' )
            // InternalServiceDsl.g:74:9: 'short'
            {
            match("short"); 


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
            // InternalServiceDsl.g:75:7: ( 'string' )
            // InternalServiceDsl.g:75:9: 'string'
            {
            match("string"); 


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
            // InternalServiceDsl.g:76:7: ( 'internal' )
            // InternalServiceDsl.g:76:9: 'internal'
            {
            match("internal"); 


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
            // InternalServiceDsl.g:77:7: ( 'architecture' )
            // InternalServiceDsl.g:77:9: 'architecture'
            {
            match("architecture"); 


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
            // InternalServiceDsl.g:78:7: ( 'public' )
            // InternalServiceDsl.g:78:9: 'public'
            {
            match("public"); 


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
            // InternalServiceDsl.g:79:7: ( 'functional' )
            // InternalServiceDsl.g:79:9: 'functional'
            {
            match("functional"); 


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
            // InternalServiceDsl.g:80:7: ( 'utility' )
            // InternalServiceDsl.g:80:9: 'utility'
            {
            match("utility"); 


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
            // InternalServiceDsl.g:81:7: ( 'infrastructure' )
            // InternalServiceDsl.g:81:9: 'infrastructure'
            {
            match("infrastructure"); 


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
            // InternalServiceDsl.g:82:7: ( 'in' )
            // InternalServiceDsl.g:82:9: 'in'
            {
            match("in"); 


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
            // InternalServiceDsl.g:83:7: ( 'out' )
            // InternalServiceDsl.g:83:9: 'out'
            {
            match("out"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalServiceDsl.g:84:7: ( 'inout' )
            // InternalServiceDsl.g:84:9: 'inout'
            {
            match("inout"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalServiceDsl.g:85:7: ( 'sync' )
            // InternalServiceDsl.g:85:9: 'sync'
            {
            match("sync"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalServiceDsl.g:86:7: ( 'async' )
            // InternalServiceDsl.g:86:9: 'async'
            {
            match("async"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalServiceDsl.g:87:7: ( '<-' )
            // InternalServiceDsl.g:87:9: '<-'
            {
            match("<-"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalServiceDsl.g:88:7: ( '->' )
            // InternalServiceDsl.g:88:9: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalServiceDsl.g:89:7: ( '<->' )
            // InternalServiceDsl.g:89:9: '<->'
            {
            match("<->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalServiceDsl.g:90:7: ( 'parameters' )
            // InternalServiceDsl.g:90:9: 'parameters'
            {
            match("parameters"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalServiceDsl.g:91:7: ( 'fields' )
            // InternalServiceDsl.g:91:9: 'fields'
            {
            match("fields"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "T__94"
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalServiceDsl.g:92:7: ( 'containers' )
            // InternalServiceDsl.g:92:9: 'containers'
            {
            match("containers"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__94"

    // $ANTLR start "RULE_BIG_DECIMAL"
    public final void mRULE_BIG_DECIMAL() throws RecognitionException {
        try {
            int _type = RULE_BIG_DECIMAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalServiceDsl.g:4925:18: ( ( '-' )? RULE_INT ( '.' RULE_INT )? )
            // InternalServiceDsl.g:4925:20: ( '-' )? RULE_INT ( '.' RULE_INT )?
            {
            // InternalServiceDsl.g:4925:20: ( '-' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='-') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalServiceDsl.g:4925:20: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            mRULE_INT(); 
            // InternalServiceDsl.g:4925:34: ( '.' RULE_INT )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='.') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalServiceDsl.g:4925:35: '.' RULE_INT
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
            // InternalServiceDsl.g:4927:14: ( ( 'true' | 'false' ) )
            // InternalServiceDsl.g:4927:16: ( 'true' | 'false' )
            {
            // InternalServiceDsl.g:4927:16: ( 'true' | 'false' )
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
                    // InternalServiceDsl.g:4927:17: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // InternalServiceDsl.g:4927:24: 'false'
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
            // InternalServiceDsl.g:4929:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalServiceDsl.g:4929:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalServiceDsl.g:4929:11: ( '^' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='^') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalServiceDsl.g:4929:11: '^'
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

            // InternalServiceDsl.g:4929:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')||(LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalServiceDsl.g:
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
            // InternalServiceDsl.g:4931:19: ( ( '0' .. '9' )+ )
            // InternalServiceDsl.g:4931:21: ( '0' .. '9' )+
            {
            // InternalServiceDsl.g:4931:21: ( '0' .. '9' )+
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
            	    // InternalServiceDsl.g:4931:22: '0' .. '9'
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
            // InternalServiceDsl.g:4933:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalServiceDsl.g:4933:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalServiceDsl.g:4933:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // InternalServiceDsl.g:4933:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalServiceDsl.g:4933:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // InternalServiceDsl.g:4933:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalServiceDsl.g:4933:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // InternalServiceDsl.g:4933:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalServiceDsl.g:4933:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // InternalServiceDsl.g:4933:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalServiceDsl.g:4933:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // InternalServiceDsl.g:4935:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalServiceDsl.g:4935:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalServiceDsl.g:4935:24: ( options {greedy=false; } : . )*
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
            	    // InternalServiceDsl.g:4935:52: .
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
            // InternalServiceDsl.g:4937:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalServiceDsl.g:4937:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalServiceDsl.g:4937:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\u0000' && LA11_0<='\t')||(LA11_0>='\u000B' && LA11_0<='\f')||(LA11_0>='\u000E' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalServiceDsl.g:4937:24: ~ ( ( '\\n' | '\\r' ) )
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

            // InternalServiceDsl.g:4937:40: ( ( '\\r' )? '\\n' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\n'||LA13_0=='\r') ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalServiceDsl.g:4937:41: ( '\\r' )? '\\n'
                    {
                    // InternalServiceDsl.g:4937:41: ( '\\r' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='\r') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalServiceDsl.g:4937:41: '\\r'
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
            // InternalServiceDsl.g:4939:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalServiceDsl.g:4939:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalServiceDsl.g:4939:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // InternalServiceDsl.g:
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
            // InternalServiceDsl.g:4941:16: ( . )
            // InternalServiceDsl.g:4941:18: .
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
        // InternalServiceDsl.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | RULE_BIG_DECIMAL | RULE_BOOLEAN | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt15=90;
        alt15 = dfa15.predict(input);
        switch (alt15) {
            case 1 :
                // InternalServiceDsl.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // InternalServiceDsl.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // InternalServiceDsl.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // InternalServiceDsl.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // InternalServiceDsl.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // InternalServiceDsl.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // InternalServiceDsl.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // InternalServiceDsl.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // InternalServiceDsl.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // InternalServiceDsl.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // InternalServiceDsl.g:1:70: T__23
                {
                mT__23(); 

                }
                break;
            case 12 :
                // InternalServiceDsl.g:1:76: T__24
                {
                mT__24(); 

                }
                break;
            case 13 :
                // InternalServiceDsl.g:1:82: T__25
                {
                mT__25(); 

                }
                break;
            case 14 :
                // InternalServiceDsl.g:1:88: T__26
                {
                mT__26(); 

                }
                break;
            case 15 :
                // InternalServiceDsl.g:1:94: T__27
                {
                mT__27(); 

                }
                break;
            case 16 :
                // InternalServiceDsl.g:1:100: T__28
                {
                mT__28(); 

                }
                break;
            case 17 :
                // InternalServiceDsl.g:1:106: T__29
                {
                mT__29(); 

                }
                break;
            case 18 :
                // InternalServiceDsl.g:1:112: T__30
                {
                mT__30(); 

                }
                break;
            case 19 :
                // InternalServiceDsl.g:1:118: T__31
                {
                mT__31(); 

                }
                break;
            case 20 :
                // InternalServiceDsl.g:1:124: T__32
                {
                mT__32(); 

                }
                break;
            case 21 :
                // InternalServiceDsl.g:1:130: T__33
                {
                mT__33(); 

                }
                break;
            case 22 :
                // InternalServiceDsl.g:1:136: T__34
                {
                mT__34(); 

                }
                break;
            case 23 :
                // InternalServiceDsl.g:1:142: T__35
                {
                mT__35(); 

                }
                break;
            case 24 :
                // InternalServiceDsl.g:1:148: T__36
                {
                mT__36(); 

                }
                break;
            case 25 :
                // InternalServiceDsl.g:1:154: T__37
                {
                mT__37(); 

                }
                break;
            case 26 :
                // InternalServiceDsl.g:1:160: T__38
                {
                mT__38(); 

                }
                break;
            case 27 :
                // InternalServiceDsl.g:1:166: T__39
                {
                mT__39(); 

                }
                break;
            case 28 :
                // InternalServiceDsl.g:1:172: T__40
                {
                mT__40(); 

                }
                break;
            case 29 :
                // InternalServiceDsl.g:1:178: T__41
                {
                mT__41(); 

                }
                break;
            case 30 :
                // InternalServiceDsl.g:1:184: T__42
                {
                mT__42(); 

                }
                break;
            case 31 :
                // InternalServiceDsl.g:1:190: T__43
                {
                mT__43(); 

                }
                break;
            case 32 :
                // InternalServiceDsl.g:1:196: T__44
                {
                mT__44(); 

                }
                break;
            case 33 :
                // InternalServiceDsl.g:1:202: T__45
                {
                mT__45(); 

                }
                break;
            case 34 :
                // InternalServiceDsl.g:1:208: T__46
                {
                mT__46(); 

                }
                break;
            case 35 :
                // InternalServiceDsl.g:1:214: T__47
                {
                mT__47(); 

                }
                break;
            case 36 :
                // InternalServiceDsl.g:1:220: T__48
                {
                mT__48(); 

                }
                break;
            case 37 :
                // InternalServiceDsl.g:1:226: T__49
                {
                mT__49(); 

                }
                break;
            case 38 :
                // InternalServiceDsl.g:1:232: T__50
                {
                mT__50(); 

                }
                break;
            case 39 :
                // InternalServiceDsl.g:1:238: T__51
                {
                mT__51(); 

                }
                break;
            case 40 :
                // InternalServiceDsl.g:1:244: T__52
                {
                mT__52(); 

                }
                break;
            case 41 :
                // InternalServiceDsl.g:1:250: T__53
                {
                mT__53(); 

                }
                break;
            case 42 :
                // InternalServiceDsl.g:1:256: T__54
                {
                mT__54(); 

                }
                break;
            case 43 :
                // InternalServiceDsl.g:1:262: T__55
                {
                mT__55(); 

                }
                break;
            case 44 :
                // InternalServiceDsl.g:1:268: T__56
                {
                mT__56(); 

                }
                break;
            case 45 :
                // InternalServiceDsl.g:1:274: T__57
                {
                mT__57(); 

                }
                break;
            case 46 :
                // InternalServiceDsl.g:1:280: T__58
                {
                mT__58(); 

                }
                break;
            case 47 :
                // InternalServiceDsl.g:1:286: T__59
                {
                mT__59(); 

                }
                break;
            case 48 :
                // InternalServiceDsl.g:1:292: T__60
                {
                mT__60(); 

                }
                break;
            case 49 :
                // InternalServiceDsl.g:1:298: T__61
                {
                mT__61(); 

                }
                break;
            case 50 :
                // InternalServiceDsl.g:1:304: T__62
                {
                mT__62(); 

                }
                break;
            case 51 :
                // InternalServiceDsl.g:1:310: T__63
                {
                mT__63(); 

                }
                break;
            case 52 :
                // InternalServiceDsl.g:1:316: T__64
                {
                mT__64(); 

                }
                break;
            case 53 :
                // InternalServiceDsl.g:1:322: T__65
                {
                mT__65(); 

                }
                break;
            case 54 :
                // InternalServiceDsl.g:1:328: T__66
                {
                mT__66(); 

                }
                break;
            case 55 :
                // InternalServiceDsl.g:1:334: T__67
                {
                mT__67(); 

                }
                break;
            case 56 :
                // InternalServiceDsl.g:1:340: T__68
                {
                mT__68(); 

                }
                break;
            case 57 :
                // InternalServiceDsl.g:1:346: T__69
                {
                mT__69(); 

                }
                break;
            case 58 :
                // InternalServiceDsl.g:1:352: T__70
                {
                mT__70(); 

                }
                break;
            case 59 :
                // InternalServiceDsl.g:1:358: T__71
                {
                mT__71(); 

                }
                break;
            case 60 :
                // InternalServiceDsl.g:1:364: T__72
                {
                mT__72(); 

                }
                break;
            case 61 :
                // InternalServiceDsl.g:1:370: T__73
                {
                mT__73(); 

                }
                break;
            case 62 :
                // InternalServiceDsl.g:1:376: T__74
                {
                mT__74(); 

                }
                break;
            case 63 :
                // InternalServiceDsl.g:1:382: T__75
                {
                mT__75(); 

                }
                break;
            case 64 :
                // InternalServiceDsl.g:1:388: T__76
                {
                mT__76(); 

                }
                break;
            case 65 :
                // InternalServiceDsl.g:1:394: T__77
                {
                mT__77(); 

                }
                break;
            case 66 :
                // InternalServiceDsl.g:1:400: T__78
                {
                mT__78(); 

                }
                break;
            case 67 :
                // InternalServiceDsl.g:1:406: T__79
                {
                mT__79(); 

                }
                break;
            case 68 :
                // InternalServiceDsl.g:1:412: T__80
                {
                mT__80(); 

                }
                break;
            case 69 :
                // InternalServiceDsl.g:1:418: T__81
                {
                mT__81(); 

                }
                break;
            case 70 :
                // InternalServiceDsl.g:1:424: T__82
                {
                mT__82(); 

                }
                break;
            case 71 :
                // InternalServiceDsl.g:1:430: T__83
                {
                mT__83(); 

                }
                break;
            case 72 :
                // InternalServiceDsl.g:1:436: T__84
                {
                mT__84(); 

                }
                break;
            case 73 :
                // InternalServiceDsl.g:1:442: T__85
                {
                mT__85(); 

                }
                break;
            case 74 :
                // InternalServiceDsl.g:1:448: T__86
                {
                mT__86(); 

                }
                break;
            case 75 :
                // InternalServiceDsl.g:1:454: T__87
                {
                mT__87(); 

                }
                break;
            case 76 :
                // InternalServiceDsl.g:1:460: T__88
                {
                mT__88(); 

                }
                break;
            case 77 :
                // InternalServiceDsl.g:1:466: T__89
                {
                mT__89(); 

                }
                break;
            case 78 :
                // InternalServiceDsl.g:1:472: T__90
                {
                mT__90(); 

                }
                break;
            case 79 :
                // InternalServiceDsl.g:1:478: T__91
                {
                mT__91(); 

                }
                break;
            case 80 :
                // InternalServiceDsl.g:1:484: T__92
                {
                mT__92(); 

                }
                break;
            case 81 :
                // InternalServiceDsl.g:1:490: T__93
                {
                mT__93(); 

                }
                break;
            case 82 :
                // InternalServiceDsl.g:1:496: T__94
                {
                mT__94(); 

                }
                break;
            case 83 :
                // InternalServiceDsl.g:1:502: RULE_BIG_DECIMAL
                {
                mRULE_BIG_DECIMAL(); 

                }
                break;
            case 84 :
                // InternalServiceDsl.g:1:519: RULE_BOOLEAN
                {
                mRULE_BOOLEAN(); 

                }
                break;
            case 85 :
                // InternalServiceDsl.g:1:532: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 86 :
                // InternalServiceDsl.g:1:540: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 87 :
                // InternalServiceDsl.g:1:552: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 88 :
                // InternalServiceDsl.g:1:568: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 89 :
                // InternalServiceDsl.g:1:584: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 90 :
                // InternalServiceDsl.g:1:592: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA15_eotS =
        "\1\uffff\3\53\1\uffff\1\53\2\uffff\3\53\1\uffff\1\53\2\uffff\1\53\1\107\1\53\3\uffff\1\116\1\uffff\11\53\2\50\1\uffff\1\50\1\uffff\2\50\2\uffff\1\53\1\155\1\uffff\6\53\1\167\1\53\1\uffff\3\53\2\uffff\5\53\1\uffff\1\53\2\uffff\1\53\1\u0086\1\53\2\uffff\1\53\7\uffff\24\53\1\u00a1\4\uffff\1\53\1\u00a4\2\53\1\uffff\3\53\1\u00ab\5\53\1\uffff\16\53\1\uffff\1\u00bf\30\53\2\uffff\2\53\1\uffff\2\53\1\u00df\3\53\1\uffff\7\53\1\u00ea\1\u00eb\12\53\1\uffff\1\53\1\u00f9\1\u00fa\2\53\1\u00fd\7\53\1\u0105\1\u0106\1\u0107\5\53\1\u010d\2\53\1\u0111\1\u0112\4\53\1\u0118\1\uffff\1\u0119\1\u00eb\1\53\1\u011b\3\53\1\u011f\2\53\2\uffff\15\53\2\uffff\2\53\1\uffff\5\53\1\u0136\1\53\3\uffff\4\53\1\u013c\1\uffff\3\53\2\uffff\1\53\1\u0141\3\53\2\uffff\1\u0146\1\uffff\1\53\1\u0148\1\u0149\1\uffff\12\53\1\u0154\1\53\1\u0156\3\53\1\u015a\3\53\1\u015e\1\53\1\uffff\2\53\1\u0162\2\53\1\uffff\4\53\1\uffff\3\53\1\u016c\1\uffff\1\53\2\uffff\5\53\1\u0173\2\53\1\u0176\1\53\1\uffff\1\53\1\uffff\2\53\1\u017b\1\uffff\3\53\1\uffff\1\53\1\u0180\1\53\1\uffff\1\u0182\2\53\1\u0185\1\53\1\u0187\1\53\1\u0189\1\53\1\uffff\6\53\1\uffff\2\53\1\uffff\1\u0193\3\53\1\uffff\2\53\1\u0199\1\53\1\uffff\1\53\1\uffff\1\u019c\1\53\1\uffff\1\53\1\uffff\1\u01a0\1\uffff\4\53\1\u01a5\3\53\1\u01a9\1\uffff\1\u01ab\1\53\1\u01ad\1\u01ae\1\53\1\uffff\1\53\1\u01b1\1\uffff\2\53\1\u01b4\1\uffff\1\53\1\u01b6\1\53\1\u01b8\1\uffff\3\53\1\uffff\1\u01bc\1\uffff\1\53\2\uffff\1\u01be\1\u01bf\1\uffff\1\53\1\u01c1\1\uffff\1\53\1\uffff\1\53\1\uffff\3\53\1\uffff\1\u01c7\2\uffff\1\53\1\uffff\1\53\1\u01ca\1\u01cb\1\53\1\u01ce\1\uffff\2\53\2\uffff\1\53\1\u01d2\1\uffff\1\53\1\u01d4\1\53\1\uffff\1\53\1\uffff\2\53\1\u01d9\1\53\1\uffff\1\53\1\u01dc\1\uffff";
    static final String DFA15_eofS =
        "\u01dd\uffff";
    static final String DFA15_minS =
        "\1\0\1\155\1\141\1\162\1\uffff\1\145\2\uffff\1\156\1\141\1\145\1\uffff\1\145\2\uffff\1\156\1\72\1\157\3\uffff\1\52\1\uffff\1\141\1\151\2\141\1\151\1\145\1\150\1\151\1\164\1\55\1\60\1\uffff\1\101\1\uffff\2\0\2\uffff\1\160\1\60\1\uffff\1\157\1\154\1\162\1\157\1\156\1\145\1\60\1\143\1\uffff\1\143\1\160\1\165\2\uffff\1\144\2\143\1\156\1\162\1\uffff\1\146\2\uffff\1\145\1\60\1\164\2\uffff\1\151\7\uffff\1\164\1\146\1\165\1\164\1\151\1\142\1\162\1\163\1\157\1\164\1\163\1\156\1\162\1\154\1\157\1\156\1\155\1\141\1\144\1\151\1\76\4\uffff\1\157\1\60\1\162\1\165\1\uffff\1\155\1\154\1\163\1\60\1\141\1\143\1\154\1\145\1\156\1\uffff\2\150\2\145\1\160\1\151\1\150\1\145\1\162\1\144\1\163\1\165\1\145\1\162\1\uffff\1\60\1\155\2\141\1\142\1\150\1\155\1\160\1\154\1\141\1\145\1\154\1\145\1\164\1\147\1\151\1\166\1\145\1\162\1\143\1\155\1\164\1\162\1\145\1\154\2\uffff\2\162\1\uffff\1\141\1\164\1\60\1\164\1\145\1\141\1\uffff\2\164\1\144\2\143\1\151\1\156\2\60\1\157\1\162\1\141\1\156\1\157\1\141\2\151\1\162\1\141\1\uffff\1\160\2\60\1\165\1\154\1\60\1\151\1\145\1\157\1\151\1\155\1\144\1\145\3\60\1\143\1\156\1\151\1\143\1\164\1\60\1\165\1\141\2\60\1\151\1\164\1\146\1\163\1\60\1\uffff\2\60\1\164\1\60\1\151\1\163\1\164\1\60\1\164\1\157\2\uffff\1\151\1\157\1\156\1\144\1\163\1\164\1\157\1\162\1\163\1\164\1\154\1\146\1\171\2\uffff\1\154\1\145\1\uffff\1\164\1\162\2\143\1\145\1\60\1\141\3\uffff\1\164\1\147\1\143\1\164\1\60\1\uffff\1\156\1\170\1\151\2\uffff\1\164\1\60\2\141\1\164\2\uffff\1\60\1\uffff\1\157\2\60\1\uffff\1\145\1\154\2\156\1\147\1\163\1\145\1\157\1\156\1\145\1\60\1\151\1\60\1\157\1\160\1\164\1\60\1\151\1\164\1\157\1\60\1\164\1\uffff\1\156\1\165\1\60\1\145\1\157\1\uffff\1\151\1\164\1\156\1\171\1\uffff\1\143\1\154\1\162\1\60\1\uffff\1\156\2\uffff\1\143\1\157\1\164\1\155\1\145\1\60\2\162\1\60\1\144\1\uffff\1\157\1\uffff\1\162\1\145\1\60\1\uffff\1\166\1\151\1\154\1\uffff\1\145\1\60\1\162\1\uffff\1\60\1\162\1\143\1\60\1\145\1\60\1\145\1\60\1\165\1\uffff\1\141\1\164\1\147\1\163\1\145\1\137\1\uffff\1\166\1\171\1\uffff\1\60\1\156\1\155\1\163\1\uffff\2\145\1\60\1\162\1\uffff\1\145\1\uffff\1\60\1\141\1\uffff\1\162\1\uffff\1\60\1\uffff\1\143\1\154\1\165\1\171\1\60\1\156\1\160\1\151\1\60\1\uffff\1\60\1\141\2\60\1\163\1\uffff\1\163\1\60\1\uffff\1\164\1\163\1\60\1\uffff\1\164\1\60\1\162\1\60\1\uffff\1\164\1\141\1\143\1\uffff\1\60\1\uffff\1\164\2\uffff\2\60\1\uffff\1\151\1\60\1\uffff\1\165\1\uffff\1\145\1\uffff\1\163\1\164\1\145\1\uffff\1\60\2\uffff\1\157\1\uffff\1\162\2\60\1\164\1\60\1\uffff\1\156\1\145\2\uffff\1\145\1\60\1\uffff\1\137\1\60\1\162\1\uffff\1\164\1\uffff\1\156\1\171\1\60\1\160\1\uffff\1\145\1\60\1\uffff";
    static final String DFA15_maxS =
        "\1\uffff\1\156\1\165\1\163\1\uffff\1\171\2\uffff\1\170\1\151\1\145\1\uffff\1\145\2\uffff\1\165\1\72\1\157\3\uffff\1\57\1\uffff\1\157\1\151\1\165\1\171\1\157\1\171\1\157\1\151\1\164\1\55\1\76\1\uffff\1\172\1\uffff\2\uffff\2\uffff\1\160\1\172\1\uffff\1\157\1\165\1\162\1\157\1\156\1\145\1\172\1\143\1\uffff\1\143\1\160\1\165\2\uffff\1\166\1\164\1\143\1\156\1\162\1\uffff\1\161\2\uffff\1\145\1\172\1\164\2\uffff\1\151\7\uffff\1\164\1\146\1\165\1\164\1\157\1\142\1\162\1\163\1\157\1\164\1\163\1\156\2\162\1\157\2\156\1\141\1\144\1\151\1\76\4\uffff\1\157\1\172\1\162\1\165\1\uffff\1\155\1\154\1\163\1\172\1\141\1\143\1\154\1\145\1\156\1\uffff\2\150\2\145\1\160\1\151\1\150\1\145\1\162\1\144\1\163\1\165\1\145\1\162\1\uffff\1\172\1\155\1\145\1\141\1\142\1\150\1\155\1\164\1\154\1\141\1\145\1\154\1\145\1\164\1\147\1\165\1\166\1\145\1\162\1\143\1\155\1\164\1\162\1\145\1\154\2\uffff\2\162\1\uffff\1\141\1\164\1\172\1\164\1\145\1\141\1\uffff\2\164\1\144\2\143\1\151\1\156\2\172\1\157\1\162\1\141\1\156\1\157\1\141\2\151\1\162\1\141\1\uffff\1\160\2\172\1\165\1\154\1\172\1\151\1\145\1\157\1\151\1\155\1\144\1\145\3\172\1\143\1\156\1\151\1\143\1\164\1\172\1\165\1\145\2\172\1\151\1\164\1\156\1\163\1\172\1\uffff\2\172\1\164\1\172\1\151\1\163\1\164\1\172\1\164\1\157\2\uffff\1\151\1\157\1\156\1\144\1\163\1\164\1\157\1\162\1\163\1\164\1\154\1\146\1\171\2\uffff\1\154\1\145\1\uffff\1\164\1\162\2\143\1\145\1\172\1\141\3\uffff\1\164\1\147\1\143\1\164\1\172\1\uffff\1\156\1\170\1\151\2\uffff\1\164\1\172\2\141\1\164\2\uffff\1\172\1\uffff\1\157\2\172\1\uffff\1\145\1\154\2\156\1\147\1\163\1\145\1\157\1\156\1\145\1\172\1\151\1\172\1\157\1\160\1\164\1\172\1\151\1\164\1\157\1\172\1\164\1\uffff\1\156\1\165\1\172\1\145\1\157\1\uffff\1\151\1\164\1\156\1\171\1\uffff\1\143\1\154\1\162\1\172\1\uffff\1\156\2\uffff\1\143\1\157\1\164\1\155\1\145\1\172\2\162\1\172\1\144\1\uffff\1\157\1\uffff\1\162\1\145\1\172\1\uffff\1\166\1\151\1\154\1\uffff\1\145\1\172\1\162\1\uffff\1\172\1\162\1\143\1\172\1\145\1\172\1\145\1\172\1\165\1\uffff\1\141\1\164\1\147\1\163\1\145\1\137\1\uffff\1\166\1\171\1\uffff\1\172\1\156\1\155\1\163\1\uffff\2\145\1\172\1\162\1\uffff\1\145\1\uffff\1\172\1\141\1\uffff\1\162\1\uffff\1\172\1\uffff\1\143\1\154\1\165\1\171\1\172\1\156\1\160\1\151\1\172\1\uffff\1\172\1\141\2\172\1\163\1\uffff\1\163\1\172\1\uffff\1\164\1\163\1\172\1\uffff\1\164\1\172\1\162\1\172\1\uffff\1\164\1\141\1\143\1\uffff\1\172\1\uffff\1\164\2\uffff\2\172\1\uffff\1\151\1\172\1\uffff\1\165\1\uffff\1\145\1\uffff\1\163\1\164\1\145\1\uffff\1\172\2\uffff\1\157\1\uffff\1\162\2\172\1\164\1\172\1\uffff\1\156\1\145\2\uffff\1\145\1\172\1\uffff\1\137\1\172\1\162\1\uffff\1\164\1\uffff\1\156\1\171\1\172\1\160\1\uffff\1\145\1\172\1\uffff";
    static final String DFA15_acceptS =
        "\4\uffff\1\4\1\uffff\1\6\1\7\3\uffff\1\13\1\uffff\1\16\1\17\3\uffff\1\25\1\30\1\32\1\uffff\1\34\13\uffff\1\123\1\uffff\1\125\2\uffff\1\131\1\132\2\uffff\1\125\10\uffff\1\4\3\uffff\1\6\1\7\5\uffff\1\13\1\uffff\1\16\1\17\3\uffff\1\22\1\31\1\uffff\1\25\1\30\1\32\1\127\1\130\1\33\1\34\25\uffff\1\116\1\123\1\126\1\131\4\uffff\1\110\11\uffff\1\3\16\uffff\1\45\31\uffff\1\117\1\115\2\uffff\1\76\6\uffff\1\63\23\uffff\1\111\37\uffff\1\2\12\uffff\1\43\1\124\15\uffff\1\35\1\73\2\uffff\1\40\7\uffff\1\71\1\46\1\77\5\uffff\1\113\3\uffff\1\72\1\67\5\uffff\1\112\1\27\1\uffff\1\75\3\uffff\1\114\26\uffff\1\44\5\uffff\1\100\4\uffff\1\1\4\uffff\1\41\1\uffff\1\121\1\62\12\uffff\1\26\1\uffff\1\23\3\uffff\1\74\3\uffff\1\104\3\uffff\1\101\11\uffff\1\36\6\uffff\1\66\2\uffff\1\12\4\uffff\1\37\4\uffff\1\70\1\uffff\1\52\2\uffff\1\65\1\uffff\1\106\1\uffff\1\102\11\uffff\1\14\5\uffff\1\57\2\uffff\1\61\3\uffff\1\24\4\uffff\1\10\3\uffff\1\54\1\uffff\1\50\1\uffff\1\64\1\42\2\uffff\1\47\2\uffff\1\20\1\uffff\1\105\1\uffff\1\5\3\uffff\1\21\1\uffff\1\53\1\120\1\uffff\1\122\5\uffff\1\60\2\uffff\1\103\1\51\2\uffff\1\11\3\uffff\1\15\1\uffff\1\107\4\uffff\1\55\2\uffff\1\56";
    static final String DFA15_specialS =
        "\1\1\44\uffff\1\0\1\2\u01b6\uffff}>";
    static final String[] DFA15_transitionS = {
            "\11\50\2\47\2\50\1\47\22\50\1\47\1\50\1\45\4\50\1\46\1\6\1\7\2\50\1\15\1\41\1\26\1\25\12\42\1\20\1\22\1\40\1\24\1\50\1\23\1\4\32\44\3\50\1\43\1\44\1\50\1\3\1\32\1\35\1\27\1\10\1\2\1\44\1\36\1\1\2\44\1\33\1\11\1\21\1\17\1\31\1\44\1\14\1\34\1\5\1\37\1\12\1\30\3\44\1\13\1\50\1\16\uff82\50",
            "\1\51\1\52",
            "\1\55\7\uffff\1\61\2\uffff\1\57\2\uffff\1\56\2\uffff\1\54\2\uffff\1\60",
            "\1\63\1\62",
            "",
            "\1\65\14\uffff\1\67\6\uffff\1\66",
            "",
            "",
            "\1\72\11\uffff\1\73",
            "\1\75\7\uffff\1\74",
            "\1\76",
            "",
            "\1\100",
            "",
            "",
            "\1\104\1\uffff\1\103\4\uffff\1\105",
            "\1\106",
            "\1\110",
            "",
            "",
            "",
            "\1\114\4\uffff\1\115",
            "",
            "\1\120\3\uffff\1\121\11\uffff\1\122",
            "\1\123",
            "\1\126\20\uffff\1\124\2\uffff\1\125",
            "\1\127\15\uffff\1\130\11\uffff\1\131",
            "\1\132\5\uffff\1\133",
            "\1\135\2\uffff\1\136\13\uffff\1\134\4\uffff\1\137",
            "\1\141\6\uffff\1\140",
            "\1\142",
            "\1\143",
            "\1\144",
            "\12\146\4\uffff\1\145",
            "",
            "\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\0\147",
            "\0\147",
            "",
            "",
            "\1\151",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\5\53\1\153\10\53\1\154\4\53\1\152\6\53",
            "",
            "\1\156",
            "\1\160\10\uffff\1\157",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\17\53\1\165\10\53\1\166\1\53",
            "\1\170",
            "",
            "\1\171",
            "\1\172",
            "\1\173",
            "",
            "",
            "\1\174\21\uffff\1\175",
            "\1\176\20\uffff\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "",
            "\1\u0084\12\uffff\1\u0083",
            "",
            "",
            "\1\u0085",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0087",
            "",
            "",
            "\1\u0088",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d\5\uffff\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0098\5\uffff\1\u0097",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "",
            "",
            "",
            "",
            "\1\u00a2",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\4\53\1\u00a3\25\53",
            "\1\u00a5",
            "\1\u00a6",
            "",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\14\53\1\u00aa\15\53",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "",
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
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00c0",
            "\1\u00c1\3\uffff\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7\3\uffff\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d1\13\uffff\1\u00d0",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "",
            "",
            "\1\u00db",
            "\1\u00dc",
            "",
            "\1\u00dd",
            "\1\u00de",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
            "\1\u00e9",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "",
            "\1\u00f6",
            "\12\53\7\uffff\32\53\4\uffff\1\u00f7\1\uffff\23\53\1\u00f8\6\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00fb",
            "\1\u00fc",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "\1\u010c",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u010e",
            "\1\u0110\3\uffff\1\u010f",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0113",
            "\1\u0114",
            "\1\u0115\7\uffff\1\u0116",
            "\1\u0117",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u011a",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u011c",
            "\1\u011d",
            "\1\u011e",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0120",
            "\1\u0121",
            "",
            "",
            "\1\u0122",
            "\1\u0123",
            "\1\u0124",
            "\1\u0125",
            "\1\u0126",
            "\1\u0127",
            "\1\u0128",
            "\1\u0129",
            "\1\u012a",
            "\1\u012b",
            "\1\u012c",
            "\1\u012d",
            "\1\u012e",
            "",
            "",
            "\1\u012f",
            "\1\u0130",
            "",
            "\1\u0131",
            "\1\u0132",
            "\1\u0133",
            "\1\u0134",
            "\1\u0135",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0137",
            "",
            "",
            "",
            "\1\u0138",
            "\1\u0139",
            "\1\u013a",
            "\1\u013b",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u013d",
            "\1\u013e",
            "\1\u013f",
            "",
            "",
            "\1\u0140",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0142",
            "\1\u0143",
            "\1\u0144",
            "",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\22\53\1\u0145\7\53",
            "",
            "\1\u0147",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u014a",
            "\1\u014b",
            "\1\u014c",
            "\1\u014d",
            "\1\u014e",
            "\1\u014f",
            "\1\u0150",
            "\1\u0151",
            "\1\u0152",
            "\1\u0153",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0155",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0157",
            "\1\u0158",
            "\1\u0159",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u015b",
            "\1\u015c",
            "\1\u015d",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u015f",
            "",
            "\1\u0160",
            "\1\u0161",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0163",
            "\1\u0164",
            "",
            "\1\u0165",
            "\1\u0166",
            "\1\u0167",
            "\1\u0168",
            "",
            "\1\u0169",
            "\1\u016a",
            "\1\u016b",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u016d",
            "",
            "",
            "\1\u016e",
            "\1\u016f",
            "\1\u0170",
            "\1\u0171",
            "\1\u0172",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0174",
            "\1\u0175",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0177",
            "",
            "\1\u0178",
            "",
            "\1\u0179",
            "\1\u017a",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u017c",
            "\1\u017d",
            "\1\u017e",
            "",
            "\1\u017f",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0181",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0183",
            "\1\u0184",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0186",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0188",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u018a",
            "",
            "\1\u018b",
            "\1\u018c",
            "\1\u018d",
            "\1\u018e",
            "\1\u018f",
            "\1\u0190",
            "",
            "\1\u0191",
            "\1\u0192",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0194",
            "\1\u0195",
            "\1\u0196",
            "",
            "\1\u0197",
            "\1\u0198",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u019a",
            "",
            "\1\u019b",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u019d",
            "",
            "\1\u019e",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\22\53\1\u019f\7\53",
            "",
            "\1\u01a1",
            "\1\u01a2",
            "\1\u01a3",
            "\1\u01a4",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01a6",
            "\1\u01a7",
            "\1\u01a8",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\22\53\1\u01aa\7\53",
            "\1\u01ac",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01af",
            "",
            "\1\u01b0",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u01b2",
            "\1\u01b3",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u01b5",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01b7",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u01b9",
            "\1\u01ba",
            "\1\u01bb",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u01bd",
            "",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u01c0",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u01c2",
            "",
            "\1\u01c3",
            "",
            "\1\u01c4",
            "\1\u01c5",
            "\1\u01c6",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "",
            "\1\u01c8",
            "",
            "\1\u01c9",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01cc",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\22\53\1\u01cd\7\53",
            "",
            "\1\u01cf",
            "\1\u01d0",
            "",
            "",
            "\1\u01d1",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u01d3",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01d5",
            "",
            "\1\u01d6",
            "",
            "\1\u01d7",
            "\1\u01d8",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01da",
            "",
            "\1\u01db",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
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
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | RULE_BIG_DECIMAL | RULE_BOOLEAN | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA15_37 = input.LA(1);

                        s = -1;
                        if ( ((LA15_37>='\u0000' && LA15_37<='\uFFFF')) ) {s = 103;}

                        else s = 40;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA15_0 = input.LA(1);

                        s = -1;
                        if ( (LA15_0=='i') ) {s = 1;}

                        else if ( (LA15_0=='f') ) {s = 2;}

                        else if ( (LA15_0=='a') ) {s = 3;}

                        else if ( (LA15_0=='@') ) {s = 4;}

                        else if ( (LA15_0=='t') ) {s = 5;}

                        else if ( (LA15_0=='(') ) {s = 6;}

                        else if ( (LA15_0==')') ) {s = 7;}

                        else if ( (LA15_0=='e') ) {s = 8;}

                        else if ( (LA15_0=='m') ) {s = 9;}

                        else if ( (LA15_0=='v') ) {s = 10;}

                        else if ( (LA15_0=='{') ) {s = 11;}

                        else if ( (LA15_0=='r') ) {s = 12;}

                        else if ( (LA15_0==',') ) {s = 13;}

                        else if ( (LA15_0=='}') ) {s = 14;}

                        else if ( (LA15_0=='o') ) {s = 15;}

                        else if ( (LA15_0==':') ) {s = 16;}

                        else if ( (LA15_0=='n') ) {s = 17;}

                        else if ( (LA15_0==';') ) {s = 18;}

                        else if ( (LA15_0=='?') ) {s = 19;}

                        else if ( (LA15_0=='=') ) {s = 20;}

                        else if ( (LA15_0=='/') ) {s = 21;}

                        else if ( (LA15_0=='.') ) {s = 22;}

                        else if ( (LA15_0=='d') ) {s = 23;}

                        else if ( (LA15_0=='w') ) {s = 24;}

                        else if ( (LA15_0=='p') ) {s = 25;}

                        else if ( (LA15_0=='b') ) {s = 26;}

                        else if ( (LA15_0=='l') ) {s = 27;}

                        else if ( (LA15_0=='s') ) {s = 28;}

                        else if ( (LA15_0=='c') ) {s = 29;}

                        else if ( (LA15_0=='h') ) {s = 30;}

                        else if ( (LA15_0=='u') ) {s = 31;}

                        else if ( (LA15_0=='<') ) {s = 32;}

                        else if ( (LA15_0=='-') ) {s = 33;}

                        else if ( ((LA15_0>='0' && LA15_0<='9')) ) {s = 34;}

                        else if ( (LA15_0=='^') ) {s = 35;}

                        else if ( ((LA15_0>='A' && LA15_0<='Z')||LA15_0=='_'||LA15_0=='g'||(LA15_0>='j' && LA15_0<='k')||LA15_0=='q'||(LA15_0>='x' && LA15_0<='z')) ) {s = 36;}

                        else if ( (LA15_0=='\"') ) {s = 37;}

                        else if ( (LA15_0=='\'') ) {s = 38;}

                        else if ( ((LA15_0>='\t' && LA15_0<='\n')||LA15_0=='\r'||LA15_0==' ') ) {s = 39;}

                        else if ( ((LA15_0>='\u0000' && LA15_0<='\b')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='\u001F')||LA15_0=='!'||(LA15_0>='#' && LA15_0<='&')||(LA15_0>='*' && LA15_0<='+')||LA15_0=='>'||(LA15_0>='[' && LA15_0<=']')||LA15_0=='`'||LA15_0=='|'||(LA15_0>='~' && LA15_0<='\uFFFF')) ) {s = 40;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA15_38 = input.LA(1);

                        s = -1;
                        if ( ((LA15_38>='\u0000' && LA15_38<='\uFFFF')) ) {s = 103;}

                        else s = 40;

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