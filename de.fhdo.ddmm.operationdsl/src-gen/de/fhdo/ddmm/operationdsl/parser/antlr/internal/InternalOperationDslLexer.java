package de.fhdo.ddmm.operationdsl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalOperationDslLexer extends Lexer {
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
    public static final int RULE_ID=4;
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
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int RULE_BOOLEAN=7;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__99=99;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
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
    public static final int RULE_STRING=5;
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
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__87=87;

    // delegates
    // delegators

    public InternalOperationDslLexer() {;} 
    public InternalOperationDslLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalOperationDslLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalOperationDsl.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOperationDsl.g:11:7: ( '@' )
            // InternalOperationDsl.g:11:9: '@'
            {
            match('@'); 

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
            // InternalOperationDsl.g:12:7: ( 'technology' )
            // InternalOperationDsl.g:12:9: 'technology'
            {
            match("technology"); 


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
            // InternalOperationDsl.g:13:7: ( '(' )
            // InternalOperationDsl.g:13:9: '('
            {
            match('('); 

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
            // InternalOperationDsl.g:14:7: ( ')' )
            // InternalOperationDsl.g:14:9: ')'
            {
            match(')'); 

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
            // InternalOperationDsl.g:15:7: ( 'container' )
            // InternalOperationDsl.g:15:9: 'container'
            {
            match("container"); 


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
            // InternalOperationDsl.g:16:7: ( 'deployment' )
            // InternalOperationDsl.g:16:9: 'deployment'
            {
            match("deployment"); 


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
            // InternalOperationDsl.g:17:7: ( 'with' )
            // InternalOperationDsl.g:17:9: 'with'
            {
            match("with"); 


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
            // InternalOperationDsl.g:18:7: ( 'operation' )
            // InternalOperationDsl.g:18:9: 'operation'
            {
            match("operation"); 


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
            // InternalOperationDsl.g:19:7: ( 'environment' )
            // InternalOperationDsl.g:19:9: 'environment'
            {
            match("environment"); 


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
            // InternalOperationDsl.g:20:7: ( 'deploys' )
            // InternalOperationDsl.g:20:9: 'deploys'
            {
            match("deploys"); 


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
            // InternalOperationDsl.g:21:7: ( ',' )
            // InternalOperationDsl.g:21:9: ','
            {
            match(','); 

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
            // InternalOperationDsl.g:22:7: ( '{' )
            // InternalOperationDsl.g:22:9: '{'
            {
            match('{'); 

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
            // InternalOperationDsl.g:23:7: ( 'aspects' )
            // InternalOperationDsl.g:23:9: 'aspects'
            {
            match("aspects"); 


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
            // InternalOperationDsl.g:24:7: ( '}' )
            // InternalOperationDsl.g:24:9: '}'
            {
            match('}'); 

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
            // InternalOperationDsl.g:25:7: ( 'default' )
            // InternalOperationDsl.g:25:9: 'default'
            {
            match("default"); 


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
            // InternalOperationDsl.g:26:7: ( 'values' )
            // InternalOperationDsl.g:26:9: 'values'
            {
            match("values"); 


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
            // InternalOperationDsl.g:27:7: ( 'basic' )
            // InternalOperationDsl.g:27:9: 'basic'
            {
            match("basic"); 


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
            // InternalOperationDsl.g:28:7: ( 'endpoints' )
            // InternalOperationDsl.g:28:9: 'endpoints'
            {
            match("endpoints"); 


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
            // InternalOperationDsl.g:29:7: ( '::' )
            // InternalOperationDsl.g:29:9: '::'
            {
            match("::"); 


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
            // InternalOperationDsl.g:30:7: ( 'is' )
            // InternalOperationDsl.g:30:9: 'is'
            {
            match("is"); 


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
            // InternalOperationDsl.g:31:7: ( 'used' )
            // InternalOperationDsl.g:31:9: 'used'
            {
            match("used"); 


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
            // InternalOperationDsl.g:32:7: ( 'by' )
            // InternalOperationDsl.g:32:9: 'by'
            {
            match("by"); 


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
            // InternalOperationDsl.g:33:7: ( '/' )
            // InternalOperationDsl.g:33:9: '/'
            {
            match('/'); 

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
            // InternalOperationDsl.g:34:7: ( ':' )
            // InternalOperationDsl.g:34:9: ':'
            {
            match(':'); 

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
            // InternalOperationDsl.g:35:7: ( ';' )
            // InternalOperationDsl.g:35:9: ';'
            {
            match(';'); 

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
            // InternalOperationDsl.g:36:7: ( '=' )
            // InternalOperationDsl.g:36:9: '='
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
            // InternalOperationDsl.g:37:7: ( 'import' )
            // InternalOperationDsl.g:37:9: 'import'
            {
            match("import"); 


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
            // InternalOperationDsl.g:38:7: ( 'from' )
            // InternalOperationDsl.g:38:9: 'from'
            {
            match("from"); 


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
            // InternalOperationDsl.g:39:7: ( 'as' )
            // InternalOperationDsl.g:39:9: 'as'
            {
            match("as"); 


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
            // InternalOperationDsl.g:40:7: ( 'microservice' )
            // InternalOperationDsl.g:40:9: 'microservice'
            {
            match("microservice"); 


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
            // InternalOperationDsl.g:41:7: ( 'version' )
            // InternalOperationDsl.g:41:9: 'version'
            {
            match("version"); 


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
            // InternalOperationDsl.g:42:7: ( 'required' )
            // InternalOperationDsl.g:42:9: 'required'
            {
            match("required"); 


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
            // InternalOperationDsl.g:43:7: ( 'microservices' )
            // InternalOperationDsl.g:43:9: 'microservices'
            {
            match("microservices"); 


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
            // InternalOperationDsl.g:44:7: ( 'interfaces' )
            // InternalOperationDsl.g:44:9: 'interfaces'
            {
            match("interfaces"); 


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
            // InternalOperationDsl.g:45:7: ( 'operations' )
            // InternalOperationDsl.g:45:9: 'operations'
            {
            match("operations"); 


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
            // InternalOperationDsl.g:46:7: ( 'noimpl' )
            // InternalOperationDsl.g:46:9: 'noimpl'
            {
            match("noimpl"); 


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
            // InternalOperationDsl.g:47:7: ( 'interface' )
            // InternalOperationDsl.g:47:9: 'interface'
            {
            match("interface"); 


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
            // InternalOperationDsl.g:48:7: ( 'refers' )
            // InternalOperationDsl.g:48:9: 'refers'
            {
            match("refers"); 


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
            // InternalOperationDsl.g:49:7: ( 'fault' )
            // InternalOperationDsl.g:49:9: 'fault'
            {
            match("fault"); 


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
            // InternalOperationDsl.g:50:7: ( '?' )
            // InternalOperationDsl.g:50:9: '?'
            {
            match('?'); 

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
            // InternalOperationDsl.g:51:7: ( '.' )
            // InternalOperationDsl.g:51:9: '.'
            {
            match('.'); 

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
            // InternalOperationDsl.g:52:7: ( 'data' )
            // InternalOperationDsl.g:52:9: 'data'
            {
            match("data"); 


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
            // InternalOperationDsl.g:53:7: ( 'formats' )
            // InternalOperationDsl.g:53:9: 'formats'
            {
            match("formats"); 


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
            // InternalOperationDsl.g:54:7: ( 'format' )
            // InternalOperationDsl.g:54:9: 'format'
            {
            match("format"); 


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
            // InternalOperationDsl.g:55:7: ( 'primitive' )
            // InternalOperationDsl.g:55:9: 'primitive'
            {
            match("primitive"); 


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
            // InternalOperationDsl.g:56:7: ( 'type' )
            // InternalOperationDsl.g:56:9: 'type'
            {
            match("type"); 


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
            // InternalOperationDsl.g:57:7: ( 'based' )
            // InternalOperationDsl.g:57:9: 'based'
            {
            match("based"); 


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
            // InternalOperationDsl.g:58:7: ( 'on' )
            // InternalOperationDsl.g:58:9: 'on'
            {
            match("on"); 


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
            // InternalOperationDsl.g:59:7: ( 'list' )
            // InternalOperationDsl.g:59:9: 'list'
            {
            match("list"); 


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
            // InternalOperationDsl.g:60:7: ( 'structure' )
            // InternalOperationDsl.g:60:9: 'structure'
            {
            match("structure"); 


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
            // InternalOperationDsl.g:61:7: ( 'environments' )
            // InternalOperationDsl.g:61:9: 'environments'
            {
            match("environments"); 


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
            // InternalOperationDsl.g:62:7: ( 'service' )
            // InternalOperationDsl.g:62:9: 'service'
            {
            match("service"); 


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
            // InternalOperationDsl.g:63:7: ( 'properties' )
            // InternalOperationDsl.g:63:9: 'properties'
            {
            match("properties"); 


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
            // InternalOperationDsl.g:64:7: ( 'mandatory' )
            // InternalOperationDsl.g:64:9: 'mandatory'
            {
            match("mandatory"); 


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
            // InternalOperationDsl.g:65:7: ( 'exchange_pattern' )
            // InternalOperationDsl.g:65:9: 'exchange_pattern'
            {
            match("exchange_pattern"); 


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
            // InternalOperationDsl.g:66:7: ( 'communication_type' )
            // InternalOperationDsl.g:66:9: 'communication_type'
            {
            match("communication_type"); 


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
            // InternalOperationDsl.g:67:7: ( 'protocol' )
            // InternalOperationDsl.g:67:9: 'protocol'
            {
            match("protocol"); 


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
            // InternalOperationDsl.g:68:7: ( 'data_format' )
            // InternalOperationDsl.g:68:9: 'data_format'
            {
            match("data_format"); 


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
            // InternalOperationDsl.g:69:7: ( 'selector' )
            // InternalOperationDsl.g:69:9: 'selector'
            {
            match("selector"); 


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
            // InternalOperationDsl.g:70:7: ( 'aspect' )
            // InternalOperationDsl.g:70:9: 'aspect'
            {
            match("aspect"); 


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
            // InternalOperationDsl.g:71:7: ( 'for' )
            // InternalOperationDsl.g:71:9: 'for'
            {
            match("for"); 


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
            // InternalOperationDsl.g:72:7: ( 'datatypes' )
            // InternalOperationDsl.g:72:9: 'datatypes'
            {
            match("datatypes"); 


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
            // InternalOperationDsl.g:73:7: ( 'context' )
            // InternalOperationDsl.g:73:9: 'context'
            {
            match("context"); 


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
            // InternalOperationDsl.g:74:7: ( 'extends' )
            // InternalOperationDsl.g:74:9: 'extends'
            {
            match("extends"); 


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
            // InternalOperationDsl.g:75:7: ( 'hide' )
            // InternalOperationDsl.g:75:9: 'hide'
            {
            match("hide"); 


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
            // InternalOperationDsl.g:76:7: ( 'boolean' )
            // InternalOperationDsl.g:76:9: 'boolean'
            {
            match("boolean"); 


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
            // InternalOperationDsl.g:77:7: ( 'byte' )
            // InternalOperationDsl.g:77:9: 'byte'
            {
            match("byte"); 


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
            // InternalOperationDsl.g:78:7: ( 'char' )
            // InternalOperationDsl.g:78:9: 'char'
            {
            match("char"); 


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
            // InternalOperationDsl.g:79:7: ( 'date' )
            // InternalOperationDsl.g:79:9: 'date'
            {
            match("date"); 


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
            // InternalOperationDsl.g:80:7: ( 'double' )
            // InternalOperationDsl.g:80:9: 'double'
            {
            match("double"); 


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
            // InternalOperationDsl.g:81:7: ( 'float' )
            // InternalOperationDsl.g:81:9: 'float'
            {
            match("float"); 


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
            // InternalOperationDsl.g:82:7: ( 'int' )
            // InternalOperationDsl.g:82:9: 'int'
            {
            match("int"); 


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
            // InternalOperationDsl.g:83:7: ( 'long' )
            // InternalOperationDsl.g:83:9: 'long'
            {
            match("long"); 


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
            // InternalOperationDsl.g:84:7: ( 'short' )
            // InternalOperationDsl.g:84:9: 'short'
            {
            match("short"); 


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
            // InternalOperationDsl.g:85:7: ( 'string' )
            // InternalOperationDsl.g:85:9: 'string'
            {
            match("string"); 


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
            // InternalOperationDsl.g:86:7: ( 'internal' )
            // InternalOperationDsl.g:86:9: 'internal'
            {
            match("internal"); 


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
            // InternalOperationDsl.g:87:7: ( 'architecture' )
            // InternalOperationDsl.g:87:9: 'architecture'
            {
            match("architecture"); 


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
            // InternalOperationDsl.g:88:7: ( 'public' )
            // InternalOperationDsl.g:88:9: 'public'
            {
            match("public"); 


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
            // InternalOperationDsl.g:89:7: ( 'functional' )
            // InternalOperationDsl.g:89:9: 'functional'
            {
            match("functional"); 


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
            // InternalOperationDsl.g:90:7: ( 'utility' )
            // InternalOperationDsl.g:90:9: 'utility'
            {
            match("utility"); 


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
            // InternalOperationDsl.g:91:7: ( 'infrastructure' )
            // InternalOperationDsl.g:91:9: 'infrastructure'
            {
            match("infrastructure"); 


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
            // InternalOperationDsl.g:92:7: ( 'in' )
            // InternalOperationDsl.g:92:9: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__94"

    // $ANTLR start "T__95"
    public final void mT__95() throws RecognitionException {
        try {
            int _type = T__95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOperationDsl.g:93:7: ( 'out' )
            // InternalOperationDsl.g:93:9: 'out'
            {
            match("out"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__95"

    // $ANTLR start "T__96"
    public final void mT__96() throws RecognitionException {
        try {
            int _type = T__96;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOperationDsl.g:94:7: ( 'inout' )
            // InternalOperationDsl.g:94:9: 'inout'
            {
            match("inout"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__96"

    // $ANTLR start "T__97"
    public final void mT__97() throws RecognitionException {
        try {
            int _type = T__97;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOperationDsl.g:95:7: ( 'sync' )
            // InternalOperationDsl.g:95:9: 'sync'
            {
            match("sync"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__97"

    // $ANTLR start "T__98"
    public final void mT__98() throws RecognitionException {
        try {
            int _type = T__98;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOperationDsl.g:96:7: ( 'async' )
            // InternalOperationDsl.g:96:9: 'async'
            {
            match("async"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__98"

    // $ANTLR start "T__99"
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOperationDsl.g:97:7: ( '<-' )
            // InternalOperationDsl.g:97:9: '<-'
            {
            match("<-"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__99"

    // $ANTLR start "T__100"
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOperationDsl.g:98:8: ( '->' )
            // InternalOperationDsl.g:98:10: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__100"

    // $ANTLR start "T__101"
    public final void mT__101() throws RecognitionException {
        try {
            int _type = T__101;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOperationDsl.g:99:8: ( '<->' )
            // InternalOperationDsl.g:99:10: '<->'
            {
            match("<->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__101"

    // $ANTLR start "T__102"
    public final void mT__102() throws RecognitionException {
        try {
            int _type = T__102;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOperationDsl.g:100:8: ( 'parameters' )
            // InternalOperationDsl.g:100:10: 'parameters'
            {
            match("parameters"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__102"

    // $ANTLR start "T__103"
    public final void mT__103() throws RecognitionException {
        try {
            int _type = T__103;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOperationDsl.g:101:8: ( 'fields' )
            // InternalOperationDsl.g:101:10: 'fields'
            {
            match("fields"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__103"

    // $ANTLR start "T__104"
    public final void mT__104() throws RecognitionException {
        try {
            int _type = T__104;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOperationDsl.g:102:8: ( 'containers' )
            // InternalOperationDsl.g:102:10: 'containers'
            {
            match("containers"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__104"

    // $ANTLR start "RULE_BIG_DECIMAL"
    public final void mRULE_BIG_DECIMAL() throws RecognitionException {
        try {
            int _type = RULE_BIG_DECIMAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalOperationDsl.g:6197:18: ( ( '-' )? RULE_INT ( '.' RULE_INT )? )
            // InternalOperationDsl.g:6197:20: ( '-' )? RULE_INT ( '.' RULE_INT )?
            {
            // InternalOperationDsl.g:6197:20: ( '-' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='-') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalOperationDsl.g:6197:20: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            mRULE_INT(); 
            // InternalOperationDsl.g:6197:34: ( '.' RULE_INT )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='.') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalOperationDsl.g:6197:35: '.' RULE_INT
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
            // InternalOperationDsl.g:6199:14: ( ( 'true' | 'false' ) )
            // InternalOperationDsl.g:6199:16: ( 'true' | 'false' )
            {
            // InternalOperationDsl.g:6199:16: ( 'true' | 'false' )
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
                    // InternalOperationDsl.g:6199:17: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // InternalOperationDsl.g:6199:24: 'false'
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
            // InternalOperationDsl.g:6201:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalOperationDsl.g:6201:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalOperationDsl.g:6201:11: ( '^' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='^') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalOperationDsl.g:6201:11: '^'
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

            // InternalOperationDsl.g:6201:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')||(LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalOperationDsl.g:
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
            // InternalOperationDsl.g:6203:19: ( ( '0' .. '9' )+ )
            // InternalOperationDsl.g:6203:21: ( '0' .. '9' )+
            {
            // InternalOperationDsl.g:6203:21: ( '0' .. '9' )+
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
            	    // InternalOperationDsl.g:6203:22: '0' .. '9'
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
            // InternalOperationDsl.g:6205:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalOperationDsl.g:6205:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalOperationDsl.g:6205:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // InternalOperationDsl.g:6205:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalOperationDsl.g:6205:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // InternalOperationDsl.g:6205:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalOperationDsl.g:6205:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // InternalOperationDsl.g:6205:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalOperationDsl.g:6205:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // InternalOperationDsl.g:6205:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalOperationDsl.g:6205:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // InternalOperationDsl.g:6207:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalOperationDsl.g:6207:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalOperationDsl.g:6207:24: ( options {greedy=false; } : . )*
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
            	    // InternalOperationDsl.g:6207:52: .
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
            // InternalOperationDsl.g:6209:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalOperationDsl.g:6209:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalOperationDsl.g:6209:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\u0000' && LA11_0<='\t')||(LA11_0>='\u000B' && LA11_0<='\f')||(LA11_0>='\u000E' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalOperationDsl.g:6209:24: ~ ( ( '\\n' | '\\r' ) )
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

            // InternalOperationDsl.g:6209:40: ( ( '\\r' )? '\\n' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\n'||LA13_0=='\r') ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalOperationDsl.g:6209:41: ( '\\r' )? '\\n'
                    {
                    // InternalOperationDsl.g:6209:41: ( '\\r' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='\r') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalOperationDsl.g:6209:41: '\\r'
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
            // InternalOperationDsl.g:6211:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalOperationDsl.g:6211:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalOperationDsl.g:6211:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // InternalOperationDsl.g:
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
            // InternalOperationDsl.g:6213:16: ( . )
            // InternalOperationDsl.g:6213:18: .
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
        // InternalOperationDsl.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | RULE_BIG_DECIMAL | RULE_BOOLEAN | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt15=100;
        alt15 = dfa15.predict(input);
        switch (alt15) {
            case 1 :
                // InternalOperationDsl.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // InternalOperationDsl.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // InternalOperationDsl.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // InternalOperationDsl.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // InternalOperationDsl.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // InternalOperationDsl.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // InternalOperationDsl.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // InternalOperationDsl.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // InternalOperationDsl.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // InternalOperationDsl.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // InternalOperationDsl.g:1:70: T__23
                {
                mT__23(); 

                }
                break;
            case 12 :
                // InternalOperationDsl.g:1:76: T__24
                {
                mT__24(); 

                }
                break;
            case 13 :
                // InternalOperationDsl.g:1:82: T__25
                {
                mT__25(); 

                }
                break;
            case 14 :
                // InternalOperationDsl.g:1:88: T__26
                {
                mT__26(); 

                }
                break;
            case 15 :
                // InternalOperationDsl.g:1:94: T__27
                {
                mT__27(); 

                }
                break;
            case 16 :
                // InternalOperationDsl.g:1:100: T__28
                {
                mT__28(); 

                }
                break;
            case 17 :
                // InternalOperationDsl.g:1:106: T__29
                {
                mT__29(); 

                }
                break;
            case 18 :
                // InternalOperationDsl.g:1:112: T__30
                {
                mT__30(); 

                }
                break;
            case 19 :
                // InternalOperationDsl.g:1:118: T__31
                {
                mT__31(); 

                }
                break;
            case 20 :
                // InternalOperationDsl.g:1:124: T__32
                {
                mT__32(); 

                }
                break;
            case 21 :
                // InternalOperationDsl.g:1:130: T__33
                {
                mT__33(); 

                }
                break;
            case 22 :
                // InternalOperationDsl.g:1:136: T__34
                {
                mT__34(); 

                }
                break;
            case 23 :
                // InternalOperationDsl.g:1:142: T__35
                {
                mT__35(); 

                }
                break;
            case 24 :
                // InternalOperationDsl.g:1:148: T__36
                {
                mT__36(); 

                }
                break;
            case 25 :
                // InternalOperationDsl.g:1:154: T__37
                {
                mT__37(); 

                }
                break;
            case 26 :
                // InternalOperationDsl.g:1:160: T__38
                {
                mT__38(); 

                }
                break;
            case 27 :
                // InternalOperationDsl.g:1:166: T__39
                {
                mT__39(); 

                }
                break;
            case 28 :
                // InternalOperationDsl.g:1:172: T__40
                {
                mT__40(); 

                }
                break;
            case 29 :
                // InternalOperationDsl.g:1:178: T__41
                {
                mT__41(); 

                }
                break;
            case 30 :
                // InternalOperationDsl.g:1:184: T__42
                {
                mT__42(); 

                }
                break;
            case 31 :
                // InternalOperationDsl.g:1:190: T__43
                {
                mT__43(); 

                }
                break;
            case 32 :
                // InternalOperationDsl.g:1:196: T__44
                {
                mT__44(); 

                }
                break;
            case 33 :
                // InternalOperationDsl.g:1:202: T__45
                {
                mT__45(); 

                }
                break;
            case 34 :
                // InternalOperationDsl.g:1:208: T__46
                {
                mT__46(); 

                }
                break;
            case 35 :
                // InternalOperationDsl.g:1:214: T__47
                {
                mT__47(); 

                }
                break;
            case 36 :
                // InternalOperationDsl.g:1:220: T__48
                {
                mT__48(); 

                }
                break;
            case 37 :
                // InternalOperationDsl.g:1:226: T__49
                {
                mT__49(); 

                }
                break;
            case 38 :
                // InternalOperationDsl.g:1:232: T__50
                {
                mT__50(); 

                }
                break;
            case 39 :
                // InternalOperationDsl.g:1:238: T__51
                {
                mT__51(); 

                }
                break;
            case 40 :
                // InternalOperationDsl.g:1:244: T__52
                {
                mT__52(); 

                }
                break;
            case 41 :
                // InternalOperationDsl.g:1:250: T__53
                {
                mT__53(); 

                }
                break;
            case 42 :
                // InternalOperationDsl.g:1:256: T__54
                {
                mT__54(); 

                }
                break;
            case 43 :
                // InternalOperationDsl.g:1:262: T__55
                {
                mT__55(); 

                }
                break;
            case 44 :
                // InternalOperationDsl.g:1:268: T__56
                {
                mT__56(); 

                }
                break;
            case 45 :
                // InternalOperationDsl.g:1:274: T__57
                {
                mT__57(); 

                }
                break;
            case 46 :
                // InternalOperationDsl.g:1:280: T__58
                {
                mT__58(); 

                }
                break;
            case 47 :
                // InternalOperationDsl.g:1:286: T__59
                {
                mT__59(); 

                }
                break;
            case 48 :
                // InternalOperationDsl.g:1:292: T__60
                {
                mT__60(); 

                }
                break;
            case 49 :
                // InternalOperationDsl.g:1:298: T__61
                {
                mT__61(); 

                }
                break;
            case 50 :
                // InternalOperationDsl.g:1:304: T__62
                {
                mT__62(); 

                }
                break;
            case 51 :
                // InternalOperationDsl.g:1:310: T__63
                {
                mT__63(); 

                }
                break;
            case 52 :
                // InternalOperationDsl.g:1:316: T__64
                {
                mT__64(); 

                }
                break;
            case 53 :
                // InternalOperationDsl.g:1:322: T__65
                {
                mT__65(); 

                }
                break;
            case 54 :
                // InternalOperationDsl.g:1:328: T__66
                {
                mT__66(); 

                }
                break;
            case 55 :
                // InternalOperationDsl.g:1:334: T__67
                {
                mT__67(); 

                }
                break;
            case 56 :
                // InternalOperationDsl.g:1:340: T__68
                {
                mT__68(); 

                }
                break;
            case 57 :
                // InternalOperationDsl.g:1:346: T__69
                {
                mT__69(); 

                }
                break;
            case 58 :
                // InternalOperationDsl.g:1:352: T__70
                {
                mT__70(); 

                }
                break;
            case 59 :
                // InternalOperationDsl.g:1:358: T__71
                {
                mT__71(); 

                }
                break;
            case 60 :
                // InternalOperationDsl.g:1:364: T__72
                {
                mT__72(); 

                }
                break;
            case 61 :
                // InternalOperationDsl.g:1:370: T__73
                {
                mT__73(); 

                }
                break;
            case 62 :
                // InternalOperationDsl.g:1:376: T__74
                {
                mT__74(); 

                }
                break;
            case 63 :
                // InternalOperationDsl.g:1:382: T__75
                {
                mT__75(); 

                }
                break;
            case 64 :
                // InternalOperationDsl.g:1:388: T__76
                {
                mT__76(); 

                }
                break;
            case 65 :
                // InternalOperationDsl.g:1:394: T__77
                {
                mT__77(); 

                }
                break;
            case 66 :
                // InternalOperationDsl.g:1:400: T__78
                {
                mT__78(); 

                }
                break;
            case 67 :
                // InternalOperationDsl.g:1:406: T__79
                {
                mT__79(); 

                }
                break;
            case 68 :
                // InternalOperationDsl.g:1:412: T__80
                {
                mT__80(); 

                }
                break;
            case 69 :
                // InternalOperationDsl.g:1:418: T__81
                {
                mT__81(); 

                }
                break;
            case 70 :
                // InternalOperationDsl.g:1:424: T__82
                {
                mT__82(); 

                }
                break;
            case 71 :
                // InternalOperationDsl.g:1:430: T__83
                {
                mT__83(); 

                }
                break;
            case 72 :
                // InternalOperationDsl.g:1:436: T__84
                {
                mT__84(); 

                }
                break;
            case 73 :
                // InternalOperationDsl.g:1:442: T__85
                {
                mT__85(); 

                }
                break;
            case 74 :
                // InternalOperationDsl.g:1:448: T__86
                {
                mT__86(); 

                }
                break;
            case 75 :
                // InternalOperationDsl.g:1:454: T__87
                {
                mT__87(); 

                }
                break;
            case 76 :
                // InternalOperationDsl.g:1:460: T__88
                {
                mT__88(); 

                }
                break;
            case 77 :
                // InternalOperationDsl.g:1:466: T__89
                {
                mT__89(); 

                }
                break;
            case 78 :
                // InternalOperationDsl.g:1:472: T__90
                {
                mT__90(); 

                }
                break;
            case 79 :
                // InternalOperationDsl.g:1:478: T__91
                {
                mT__91(); 

                }
                break;
            case 80 :
                // InternalOperationDsl.g:1:484: T__92
                {
                mT__92(); 

                }
                break;
            case 81 :
                // InternalOperationDsl.g:1:490: T__93
                {
                mT__93(); 

                }
                break;
            case 82 :
                // InternalOperationDsl.g:1:496: T__94
                {
                mT__94(); 

                }
                break;
            case 83 :
                // InternalOperationDsl.g:1:502: T__95
                {
                mT__95(); 

                }
                break;
            case 84 :
                // InternalOperationDsl.g:1:508: T__96
                {
                mT__96(); 

                }
                break;
            case 85 :
                // InternalOperationDsl.g:1:514: T__97
                {
                mT__97(); 

                }
                break;
            case 86 :
                // InternalOperationDsl.g:1:520: T__98
                {
                mT__98(); 

                }
                break;
            case 87 :
                // InternalOperationDsl.g:1:526: T__99
                {
                mT__99(); 

                }
                break;
            case 88 :
                // InternalOperationDsl.g:1:532: T__100
                {
                mT__100(); 

                }
                break;
            case 89 :
                // InternalOperationDsl.g:1:539: T__101
                {
                mT__101(); 

                }
                break;
            case 90 :
                // InternalOperationDsl.g:1:546: T__102
                {
                mT__102(); 

                }
                break;
            case 91 :
                // InternalOperationDsl.g:1:553: T__103
                {
                mT__103(); 

                }
                break;
            case 92 :
                // InternalOperationDsl.g:1:560: T__104
                {
                mT__104(); 

                }
                break;
            case 93 :
                // InternalOperationDsl.g:1:567: RULE_BIG_DECIMAL
                {
                mRULE_BIG_DECIMAL(); 

                }
                break;
            case 94 :
                // InternalOperationDsl.g:1:584: RULE_BOOLEAN
                {
                mRULE_BOOLEAN(); 

                }
                break;
            case 95 :
                // InternalOperationDsl.g:1:597: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 96 :
                // InternalOperationDsl.g:1:605: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 97 :
                // InternalOperationDsl.g:1:617: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 98 :
                // InternalOperationDsl.g:1:633: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 99 :
                // InternalOperationDsl.g:1:649: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 100 :
                // InternalOperationDsl.g:1:657: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA15_eotS =
        "\2\uffff\1\55\2\uffff\5\55\2\uffff\1\55\1\uffff\2\55\1\106\2\55\1\116\2\uffff\4\55\2\uffff\4\55\2\50\1\uffff\1\50\1\uffff\2\50\3\uffff\3\55\3\uffff\7\55\1\170\3\55\2\uffff\1\u0080\1\55\1\uffff\3\55\1\u0086\1\55\2\uffff\1\u0088\1\55\1\u008d\2\55\5\uffff\12\55\2\uffff\12\55\1\u00a9\4\uffff\14\55\1\uffff\1\u00b7\6\55\1\uffff\5\55\1\uffff\1\55\1\uffff\1\55\1\u00c7\2\55\1\uffff\5\55\1\u00d0\24\55\2\uffff\1\55\1\u00e8\1\u00e9\2\55\1\u00ed\2\55\1\u00f2\1\u00f3\1\55\1\u00f5\1\55\1\uffff\13\55\1\u0102\3\55\1\uffff\2\55\1\u0108\1\55\1\u010a\3\55\1\uffff\15\55\1\u011b\1\u011c\5\55\1\u0122\1\u0123\1\55\2\uffff\3\55\1\uffff\4\55\2\uffff\1\55\1\uffff\6\55\1\u0133\3\55\1\u0137\1\u0138\1\uffff\4\55\1\u013e\1\uffff\1\55\1\uffff\1\u0140\1\u00e9\1\55\1\u0142\14\55\2\uffff\4\55\1\u0153\2\uffff\10\55\1\u015d\5\55\1\u0164\1\uffff\1\55\1\u0166\1\55\2\uffff\1\55\1\u0169\3\55\1\uffff\1\55\1\uffff\1\u016f\1\uffff\1\55\1\u0171\3\55\1\u0175\1\u0176\3\55\1\u017a\2\55\1\u017d\2\55\1\uffff\2\55\1\u0182\2\55\1\u0185\1\u0186\2\55\1\uffff\4\55\1\u018d\1\u018e\1\uffff\1\55\1\uffff\1\u0190\1\u0191\1\uffff\3\55\1\u0195\1\u0196\1\uffff\1\55\1\uffff\3\55\2\uffff\3\55\1\uffff\2\55\1\uffff\1\u01a0\3\55\1\uffff\2\55\2\uffff\6\55\2\uffff\1\55\2\uffff\1\55\1\u01ae\1\55\2\uffff\3\55\1\u01b3\2\55\1\u01b6\2\55\1\uffff\1\u01b9\1\55\1\u01bc\3\55\1\u01c0\1\u01c2\1\55\1\u01c4\2\55\1\u01c8\1\uffff\3\55\1\u01cc\1\uffff\1\u01cd\1\55\1\uffff\1\55\1\u01d0\1\uffff\1\u01d1\1\u01d2\1\uffff\1\55\1\u01d4\1\55\1\uffff\1\u01d6\1\uffff\1\55\1\uffff\2\55\1\u01da\1\uffff\1\55\1\u01dc\1\55\2\uffff\1\u01de\1\u01df\3\uffff\1\55\1\uffff\1\u01e1\1\uffff\1\u01e3\2\55\1\uffff\1\55\1\uffff\1\55\2\uffff\1\55\1\uffff\1\u01e9\1\uffff\1\55\1\u01eb\1\55\1\u01ee\1\55\1\uffff\1\55\1\uffff\1\55\1\u01f2\1\uffff\2\55\1\u01f5\1\uffff\2\55\1\uffff\1\55\1\u01f9\1\55\1\uffff\1\u01fb\1\uffff";
    static final String DFA15_eofS =
        "\u01fc\uffff";
    static final String DFA15_minS =
        "\1\0\1\uffff\1\145\2\uffff\1\150\1\141\1\151\2\156\2\uffff\1\162\1\uffff\2\141\1\72\1\155\1\163\1\52\2\uffff\2\141\1\145\1\157\2\uffff\1\141\1\151\1\145\1\151\1\55\1\60\1\uffff\1\101\1\uffff\2\0\3\uffff\1\143\1\160\1\165\3\uffff\1\155\1\141\1\146\1\164\1\165\1\164\1\145\1\60\1\164\1\144\1\143\2\uffff\1\60\1\143\1\uffff\1\154\1\162\1\163\1\60\1\157\2\uffff\1\60\1\160\1\60\1\145\1\151\5\uffff\1\157\1\154\1\162\1\157\1\156\1\145\1\143\1\156\1\146\1\151\2\uffff\1\151\1\142\1\162\1\163\1\156\1\162\1\154\1\157\1\156\1\144\1\76\4\uffff\1\150\2\145\1\164\1\155\1\162\1\154\2\141\1\142\1\150\1\162\1\uffff\1\60\1\151\1\160\1\150\2\145\1\156\1\uffff\1\150\1\165\1\163\2\145\1\uffff\1\154\1\uffff\1\157\1\60\1\162\1\165\1\uffff\1\144\1\154\1\155\1\154\1\163\1\60\1\141\1\143\1\154\1\162\1\144\1\165\1\145\2\155\1\160\1\154\1\141\1\164\1\147\1\151\1\166\1\145\1\162\1\143\1\145\2\uffff\1\156\2\60\1\141\1\165\1\60\1\157\1\165\2\60\1\154\1\60\1\141\1\uffff\1\162\1\157\1\141\1\156\2\143\1\151\1\145\1\151\1\143\1\144\1\60\1\145\2\162\1\uffff\1\141\1\164\1\60\1\151\1\60\1\164\1\145\1\141\1\uffff\2\164\1\144\1\157\1\141\1\151\1\162\1\160\1\151\1\145\1\157\1\151\1\155\2\60\1\143\1\156\1\151\1\143\1\164\2\60\1\157\2\uffff\1\151\1\170\1\156\1\uffff\1\171\1\154\1\146\1\171\2\uffff\1\145\1\uffff\1\164\1\157\1\151\1\156\1\144\1\164\1\60\1\164\1\163\1\157\2\60\1\uffff\1\141\1\164\1\146\1\163\1\60\1\uffff\1\164\1\uffff\2\60\1\164\1\60\1\151\2\163\1\164\1\162\1\163\1\154\1\164\1\162\2\143\1\145\2\uffff\1\164\1\147\1\143\1\164\1\60\2\uffff\1\154\1\156\1\164\1\151\1\155\1\164\1\157\1\160\1\60\1\151\2\156\1\147\1\163\1\60\1\uffff\1\145\1\60\1\156\2\uffff\1\156\1\60\2\141\1\164\1\uffff\1\171\1\uffff\1\60\1\uffff\1\157\1\60\1\145\1\157\1\145\2\60\1\151\1\164\1\157\1\60\1\164\1\165\1\60\1\145\1\157\1\uffff\1\157\1\145\1\60\1\143\1\145\2\60\1\162\1\145\1\uffff\1\157\1\155\1\164\1\145\2\60\1\uffff\1\143\1\uffff\2\60\1\uffff\1\143\1\154\1\162\2\60\1\uffff\1\156\1\uffff\2\162\1\144\2\uffff\1\166\1\151\1\154\1\uffff\1\145\1\162\1\uffff\1\60\1\162\1\147\1\162\1\uffff\1\141\1\156\2\uffff\1\155\1\163\1\156\1\145\1\163\1\137\2\uffff\1\164\2\uffff\1\145\1\60\1\165\2\uffff\1\141\1\166\1\171\1\60\2\145\1\60\1\162\1\145\1\uffff\1\60\1\171\1\60\2\164\1\141\2\60\1\156\1\60\1\160\1\165\1\60\1\uffff\1\143\1\154\1\151\1\60\1\uffff\1\60\1\163\1\uffff\1\163\1\60\1\uffff\2\60\1\uffff\1\151\1\60\1\164\1\uffff\1\60\1\uffff\1\164\1\uffff\1\141\1\162\1\60\1\uffff\1\164\1\60\1\143\2\uffff\2\60\3\uffff\1\157\1\uffff\1\60\1\uffff\1\60\1\164\1\145\1\uffff\1\165\1\uffff\1\145\2\uffff\1\156\1\uffff\1\60\1\uffff\1\164\1\60\1\162\1\60\1\137\1\uffff\1\145\1\uffff\1\145\1\60\1\uffff\1\164\1\162\1\60\1\uffff\1\171\1\156\1\uffff\1\160\1\60\1\145\1\uffff\1\60\1\uffff";
    static final String DFA15_maxS =
        "\1\uffff\1\uffff\1\171\2\uffff\2\157\1\151\1\165\1\170\2\uffff\1\163\1\uffff\1\145\1\171\1\72\1\163\1\164\1\57\2\uffff\1\165\1\151\1\145\1\157\2\uffff\1\165\1\157\1\171\1\151\1\55\1\76\1\uffff\1\172\1\uffff\2\uffff\3\uffff\1\143\1\160\1\165\3\uffff\1\156\1\141\1\160\1\164\1\165\1\164\1\145\1\172\1\164\1\166\1\164\2\uffff\1\172\1\143\1\uffff\1\154\1\162\1\163\1\172\1\157\2\uffff\1\172\1\160\1\172\1\145\1\151\5\uffff\1\157\1\165\1\162\1\157\1\156\1\145\1\143\1\156\1\161\1\151\2\uffff\1\157\1\142\1\162\1\163\1\156\2\162\1\157\1\156\1\144\1\76\4\uffff\1\150\2\145\1\164\1\155\1\162\1\154\1\141\1\145\1\142\1\150\1\162\1\uffff\1\172\1\151\1\160\1\150\2\145\1\156\1\uffff\1\150\1\165\1\163\1\151\1\145\1\uffff\1\154\1\uffff\1\157\1\172\1\162\1\165\1\uffff\1\144\1\154\1\155\1\154\1\163\1\172\1\141\1\143\1\154\1\162\1\144\1\165\1\145\2\155\1\164\1\154\1\141\1\164\1\147\1\165\1\166\1\145\1\162\1\143\1\145\2\uffff\1\156\2\172\1\145\1\165\1\172\1\157\1\165\2\172\1\154\1\172\1\141\1\uffff\1\162\1\157\1\141\1\156\2\143\1\151\1\145\1\151\1\143\1\144\1\172\1\145\2\162\1\uffff\1\141\1\164\1\172\1\151\1\172\1\164\1\145\1\141\1\uffff\2\164\1\144\1\157\1\141\1\151\1\162\1\160\1\151\1\145\1\157\1\151\1\155\2\172\1\143\1\156\1\151\1\143\1\164\2\172\1\157\2\uffff\1\151\1\170\1\156\1\uffff\1\171\1\154\1\146\1\171\2\uffff\1\145\1\uffff\1\164\1\157\1\151\1\156\1\144\1\164\1\172\1\164\1\163\1\157\2\172\1\uffff\1\141\1\164\1\156\1\163\1\172\1\uffff\1\164\1\uffff\2\172\1\164\1\172\1\151\2\163\1\164\1\162\1\163\1\154\1\164\1\162\2\143\1\145\2\uffff\1\164\1\147\1\143\1\164\1\172\2\uffff\1\154\1\156\1\164\1\151\1\163\1\164\1\157\1\160\1\172\1\151\2\156\1\147\1\163\1\172\1\uffff\1\145\1\172\1\156\2\uffff\1\156\1\172\2\141\1\164\1\uffff\1\171\1\uffff\1\172\1\uffff\1\157\1\172\1\145\1\157\1\145\2\172\1\151\1\164\1\157\1\172\1\164\1\165\1\172\1\145\1\157\1\uffff\1\157\1\145\1\172\1\143\1\145\2\172\1\162\1\145\1\uffff\1\157\1\155\1\164\1\145\2\172\1\uffff\1\143\1\uffff\2\172\1\uffff\1\143\1\154\1\162\2\172\1\uffff\1\156\1\uffff\2\162\1\144\2\uffff\1\166\1\151\1\154\1\uffff\1\145\1\162\1\uffff\1\172\1\162\1\147\1\162\1\uffff\1\141\1\156\2\uffff\1\155\1\163\1\156\1\145\1\163\1\137\2\uffff\1\164\2\uffff\1\145\1\172\1\165\2\uffff\1\141\1\166\1\171\1\172\2\145\1\172\1\162\1\145\1\uffff\1\172\1\171\1\172\2\164\1\141\2\172\1\156\1\172\1\160\1\165\1\172\1\uffff\1\143\1\154\1\151\1\172\1\uffff\1\172\1\163\1\uffff\1\163\1\172\1\uffff\2\172\1\uffff\1\151\1\172\1\164\1\uffff\1\172\1\uffff\1\164\1\uffff\1\141\1\162\1\172\1\uffff\1\164\1\172\1\143\2\uffff\2\172\3\uffff\1\157\1\uffff\1\172\1\uffff\1\172\1\164\1\145\1\uffff\1\165\1\uffff\1\145\2\uffff\1\156\1\uffff\1\172\1\uffff\1\164\1\172\1\162\1\172\1\137\1\uffff\1\145\1\uffff\1\145\1\172\1\uffff\1\164\1\162\1\172\1\uffff\1\171\1\156\1\uffff\1\160\1\172\1\145\1\uffff\1\172\1\uffff";
    static final String DFA15_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\1\4\5\uffff\1\13\1\14\1\uffff\1\16\6\uffff\1\31\1\32\4\uffff\1\50\1\51\6\uffff\1\135\1\uffff\1\137\2\uffff\1\143\1\144\1\1\3\uffff\1\137\1\3\1\4\13\uffff\1\13\1\14\2\uffff\1\16\5\uffff\1\23\1\30\5\uffff\1\141\1\142\1\27\1\31\1\32\12\uffff\1\50\1\51\13\uffff\1\130\1\135\1\140\1\143\14\uffff\1\60\7\uffff\1\35\5\uffff\1\26\1\uffff\1\24\4\uffff\1\122\32\uffff\1\131\1\127\15\uffff\1\123\17\uffff\1\110\10\uffff\1\75\27\uffff\1\56\1\136\3\uffff\1\104\4\uffff\1\52\1\105\1\uffff\1\7\14\uffff\1\103\5\uffff\1\25\1\uffff\1\34\20\uffff\1\61\1\111\5\uffff\1\125\1\101\17\uffff\1\126\3\uffff\1\21\1\57\5\uffff\1\124\1\uffff\1\47\1\uffff\1\107\20\uffff\1\112\11\uffff\1\106\6\uffff\1\74\1\uffff\1\20\2\uffff\1\33\5\uffff\1\54\1\uffff\1\133\3\uffff\1\46\1\44\3\uffff\1\116\2\uffff\1\113\4\uffff\1\77\2\uffff\1\12\1\17\6\uffff\1\100\1\15\1\uffff\1\37\1\102\3\uffff\1\120\1\53\11\uffff\1\64\15\uffff\1\114\4\uffff\1\40\2\uffff\1\71\2\uffff\1\73\2\uffff\1\5\3\uffff\1\76\1\uffff\1\10\1\uffff\1\22\3\uffff\1\45\3\uffff\1\66\1\55\2\uffff\1\62\1\2\1\134\1\uffff\1\6\1\uffff\1\43\3\uffff\1\42\1\uffff\1\117\1\uffff\1\65\1\132\1\uffff\1\72\1\uffff\1\11\5\uffff\1\63\1\uffff\1\115\2\uffff\1\36\3\uffff\1\41\2\uffff\1\121\3\uffff\1\67\1\uffff\1\70";
    static final String DFA15_specialS =
        "\1\2\44\uffff\1\0\1\1\u01d5\uffff}>";
    static final String[] DFA15_transitionS = {
            "\11\50\2\47\2\50\1\47\22\50\1\47\1\50\1\45\4\50\1\46\1\3\1\4\2\50\1\12\1\41\1\33\1\23\12\42\1\20\1\24\1\40\1\25\1\50\1\32\1\1\32\44\3\50\1\43\1\44\1\50\1\14\1\17\1\5\1\6\1\11\1\26\1\44\1\37\1\21\2\44\1\35\1\27\1\31\1\10\1\34\1\44\1\30\1\36\1\2\1\22\1\16\1\7\3\44\1\13\1\50\1\15\uff82\50",
            "",
            "\1\52\14\uffff\1\54\6\uffff\1\53",
            "",
            "",
            "\1\61\6\uffff\1\60",
            "\1\63\3\uffff\1\62\11\uffff\1\64",
            "\1\65",
            "\1\67\1\uffff\1\66\4\uffff\1\70",
            "\1\71\11\uffff\1\72",
            "",
            "",
            "\1\76\1\75",
            "",
            "\1\100\3\uffff\1\101",
            "\1\102\15\uffff\1\104\11\uffff\1\103",
            "\1\105",
            "\1\110\1\111\4\uffff\1\107",
            "\1\112\1\113",
            "\1\114\4\uffff\1\115",
            "",
            "",
            "\1\122\7\uffff\1\126\2\uffff\1\124\2\uffff\1\123\2\uffff\1\121\2\uffff\1\125",
            "\1\130\7\uffff\1\127",
            "\1\131",
            "\1\132",
            "",
            "",
            "\1\137\20\uffff\1\135\2\uffff\1\136",
            "\1\140\5\uffff\1\141",
            "\1\143\2\uffff\1\144\13\uffff\1\142\4\uffff\1\145",
            "\1\146",
            "\1\147",
            "\12\151\4\uffff\1\150",
            "",
            "\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\0\152",
            "\0\152",
            "",
            "",
            "",
            "\1\154",
            "\1\155",
            "\1\156",
            "",
            "",
            "",
            "\1\160\1\157",
            "\1\161",
            "\1\163\11\uffff\1\162",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\171",
            "\1\173\21\uffff\1\172",
            "\1\174\20\uffff\1\175",
            "",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\17\55\1\176\10\55\1\177\1\55",
            "\1\u0081",
            "",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\23\55\1\u0085\6\55",
            "\1\u0087",
            "",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0089",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\5\55\1\u008b\10\55\1\u008c\4\55\1\u008a\6\55",
            "\1\u008e",
            "\1\u008f",
            "",
            "",
            "",
            "",
            "",
            "\1\u0090",
            "\1\u0092\10\uffff\1\u0091",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u009a\12\uffff\1\u0099",
            "\1\u009b",
            "",
            "",
            "\1\u009c\5\uffff\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a4\5\uffff\1\u00a3",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "",
            "",
            "",
            "",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2\3\uffff\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c2\3\uffff\1\u00c1",
            "\1\u00c3",
            "",
            "\1\u00c4",
            "",
            "\1\u00c5",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\4\55\1\u00c6\25\55",
            "\1\u00c8",
            "\1\u00c9",
            "",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\14\55\1\u00cf\15\55",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da\3\uffff\1\u00db",
            "\1\u00dc",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e1\13\uffff\1\u00e0",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "",
            "",
            "\1\u00e7",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u00ea\3\uffff\1\u00eb",
            "\1\u00ec",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u00ee",
            "\1\u00ef",
            "\12\55\7\uffff\32\55\4\uffff\1\u00f0\1\uffff\23\55\1\u00f1\6\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u00f4",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u00f6",
            "",
            "\1\u00f7",
            "\1\u00f8",
            "\1\u00f9",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0103",
            "\1\u0104",
            "\1\u0105",
            "",
            "\1\u0106",
            "\1\u0107",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0109",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u010b",
            "\1\u010c",
            "\1\u010d",
            "",
            "\1\u010e",
            "\1\u010f",
            "\1\u0110",
            "\1\u0111",
            "\1\u0112",
            "\1\u0113",
            "\1\u0114",
            "\1\u0115",
            "\1\u0116",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119",
            "\1\u011a",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u011d",
            "\1\u011e",
            "\1\u011f",
            "\1\u0120",
            "\1\u0121",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0124",
            "",
            "",
            "\1\u0125",
            "\1\u0126",
            "\1\u0127",
            "",
            "\1\u0128",
            "\1\u0129",
            "\1\u012a",
            "\1\u012b",
            "",
            "",
            "\1\u012c",
            "",
            "\1\u012d",
            "\1\u012e",
            "\1\u012f",
            "\1\u0130",
            "\1\u0131",
            "\1\u0132",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0134",
            "\1\u0135",
            "\1\u0136",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u0139",
            "\1\u013a",
            "\1\u013b\7\uffff\1\u013c",
            "\1\u013d",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u013f",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0141",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0143",
            "\1\u0144",
            "\1\u0145",
            "\1\u0146",
            "\1\u0147",
            "\1\u0148",
            "\1\u0149",
            "\1\u014a",
            "\1\u014b",
            "\1\u014c",
            "\1\u014d",
            "\1\u014e",
            "",
            "",
            "\1\u014f",
            "\1\u0150",
            "\1\u0151",
            "\1\u0152",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "",
            "\1\u0154",
            "\1\u0155",
            "\1\u0156",
            "\1\u0157",
            "\1\u0158\5\uffff\1\u0159",
            "\1\u015a",
            "\1\u015b",
            "\1\u015c",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u015e",
            "\1\u015f",
            "\1\u0160",
            "\1\u0161",
            "\1\u0162",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\22\55\1\u0163\7\55",
            "",
            "\1\u0165",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0167",
            "",
            "",
            "\1\u0168",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u016a",
            "\1\u016b",
            "\1\u016c",
            "",
            "\1\u016d",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\22\55\1\u016e\7\55",
            "",
            "\1\u0170",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0172",
            "\1\u0173",
            "\1\u0174",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0177",
            "\1\u0178",
            "\1\u0179",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u017b",
            "\1\u017c",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u017e",
            "\1\u017f",
            "",
            "\1\u0180",
            "\1\u0181",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0183",
            "\1\u0184",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0187",
            "\1\u0188",
            "",
            "\1\u0189",
            "\1\u018a",
            "\1\u018b",
            "\1\u018c",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u018f",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u0192",
            "\1\u0193",
            "\1\u0194",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u0197",
            "",
            "\1\u0198",
            "\1\u0199",
            "\1\u019a",
            "",
            "",
            "\1\u019b",
            "\1\u019c",
            "\1\u019d",
            "",
            "\1\u019e",
            "\1\u019f",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u01a1",
            "\1\u01a2",
            "\1\u01a3",
            "",
            "\1\u01a4",
            "\1\u01a5",
            "",
            "",
            "\1\u01a6",
            "\1\u01a7",
            "\1\u01a8",
            "\1\u01a9",
            "\1\u01aa",
            "\1\u01ab",
            "",
            "",
            "\1\u01ac",
            "",
            "",
            "\1\u01ad",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u01af",
            "",
            "",
            "\1\u01b0",
            "\1\u01b1",
            "\1\u01b2",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u01b4",
            "\1\u01b5",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u01b7",
            "\1\u01b8",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u01ba",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\22\55\1\u01bb\7\55",
            "\1\u01bd",
            "\1\u01be",
            "\1\u01bf",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\22\55\1\u01c1\7\55",
            "\1\u01c3",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u01c5",
            "\1\u01c6",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\22\55\1\u01c7\7\55",
            "",
            "\1\u01c9",
            "\1\u01ca",
            "\1\u01cb",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u01ce",
            "",
            "\1\u01cf",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u01d3",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u01d5",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u01d7",
            "",
            "\1\u01d8",
            "\1\u01d9",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u01db",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u01dd",
            "",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "",
            "",
            "\1\u01e0",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\22\55\1\u01e2\7\55",
            "\1\u01e4",
            "\1\u01e5",
            "",
            "\1\u01e6",
            "",
            "\1\u01e7",
            "",
            "",
            "\1\u01e8",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u01ea",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u01ec",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\22\55\1\u01ed\7\55",
            "\1\u01ef",
            "",
            "\1\u01f0",
            "",
            "\1\u01f1",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u01f3",
            "\1\u01f4",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u01f6",
            "\1\u01f7",
            "",
            "\1\u01f8",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u01fa",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
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
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | RULE_BIG_DECIMAL | RULE_BOOLEAN | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA15_37 = input.LA(1);

                        s = -1;
                        if ( ((LA15_37>='\u0000' && LA15_37<='\uFFFF')) ) {s = 106;}

                        else s = 40;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA15_38 = input.LA(1);

                        s = -1;
                        if ( ((LA15_38>='\u0000' && LA15_38<='\uFFFF')) ) {s = 106;}

                        else s = 40;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA15_0 = input.LA(1);

                        s = -1;
                        if ( (LA15_0=='@') ) {s = 1;}

                        else if ( (LA15_0=='t') ) {s = 2;}

                        else if ( (LA15_0=='(') ) {s = 3;}

                        else if ( (LA15_0==')') ) {s = 4;}

                        else if ( (LA15_0=='c') ) {s = 5;}

                        else if ( (LA15_0=='d') ) {s = 6;}

                        else if ( (LA15_0=='w') ) {s = 7;}

                        else if ( (LA15_0=='o') ) {s = 8;}

                        else if ( (LA15_0=='e') ) {s = 9;}

                        else if ( (LA15_0==',') ) {s = 10;}

                        else if ( (LA15_0=='{') ) {s = 11;}

                        else if ( (LA15_0=='a') ) {s = 12;}

                        else if ( (LA15_0=='}') ) {s = 13;}

                        else if ( (LA15_0=='v') ) {s = 14;}

                        else if ( (LA15_0=='b') ) {s = 15;}

                        else if ( (LA15_0==':') ) {s = 16;}

                        else if ( (LA15_0=='i') ) {s = 17;}

                        else if ( (LA15_0=='u') ) {s = 18;}

                        else if ( (LA15_0=='/') ) {s = 19;}

                        else if ( (LA15_0==';') ) {s = 20;}

                        else if ( (LA15_0=='=') ) {s = 21;}

                        else if ( (LA15_0=='f') ) {s = 22;}

                        else if ( (LA15_0=='m') ) {s = 23;}

                        else if ( (LA15_0=='r') ) {s = 24;}

                        else if ( (LA15_0=='n') ) {s = 25;}

                        else if ( (LA15_0=='?') ) {s = 26;}

                        else if ( (LA15_0=='.') ) {s = 27;}

                        else if ( (LA15_0=='p') ) {s = 28;}

                        else if ( (LA15_0=='l') ) {s = 29;}

                        else if ( (LA15_0=='s') ) {s = 30;}

                        else if ( (LA15_0=='h') ) {s = 31;}

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
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 15, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}