package de.fhdo.lemma.technology.mappingdsl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMappingDslLexer extends Lexer {
    public static final int T__144=144;
    public static final int T__143=143;
    public static final int T__146=146;
    public static final int T__50=50;
    public static final int T__145=145;
    public static final int T__140=140;
    public static final int T__142=142;
    public static final int T__141=141;
    public static final int RULE_NUMBER_WITH_TRAILING_PERIOD=7;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__137=137;
    public static final int T__52=52;
    public static final int T__136=136;
    public static final int T__53=53;
    public static final int T__139=139;
    public static final int T__54=54;
    public static final int T__138=138;
    public static final int T__133=133;
    public static final int T__132=132;
    public static final int T__60=60;
    public static final int T__135=135;
    public static final int T__61=61;
    public static final int T__134=134;
    public static final int RULE_ID=4;
    public static final int T__131=131;
    public static final int T__130=130;
    public static final int RULE_INT=10;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=11;
    public static final int T__67=67;
    public static final int T__129=129;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__126=126;
    public static final int T__63=63;
    public static final int T__125=125;
    public static final int T__64=64;
    public static final int T__128=128;
    public static final int T__65=65;
    public static final int T__127=127;
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
    public static final int T__147=147;
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
    public static final int RULE_BOOLEAN=6;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__99=99;
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
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__124=124;
    public static final int T__72=72;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=12;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int RULE_BIG_DECIMAL=8;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=13;
    public static final int RULE_ANY_OTHER=9;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators

    public InternalMappingDslLexer() {;} 
    public InternalMappingDslLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalMappingDslLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalMappingDsl.g"; }

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:11:7: ( 'type' )
            // InternalMappingDsl.g:11:9: 'type'
            {
            match("type"); 


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
            // InternalMappingDsl.g:12:7: ( '{' )
            // InternalMappingDsl.g:12:9: '{'
            {
            match('{'); 

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
            // InternalMappingDsl.g:13:7: ( 'aspects' )
            // InternalMappingDsl.g:13:9: 'aspects'
            {
            match("aspects"); 


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
            // InternalMappingDsl.g:14:7: ( '}' )
            // InternalMappingDsl.g:14:9: '}'
            {
            match('}'); 

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
            // InternalMappingDsl.g:15:7: ( '::' )
            // InternalMappingDsl.g:15:9: '::'
            {
            match("::"); 


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
            // InternalMappingDsl.g:16:7: ( 'protocols' )
            // InternalMappingDsl.g:16:9: 'protocols'
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
            // InternalMappingDsl.g:17:7: ( 'endpoints' )
            // InternalMappingDsl.g:17:9: 'endpoints'
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
            // InternalMappingDsl.g:18:7: ( 'interface' )
            // InternalMappingDsl.g:18:9: 'interface'
            {
            match("interface"); 


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
            // InternalMappingDsl.g:19:7: ( 'operation' )
            // InternalMappingDsl.g:19:9: 'operation'
            {
            match("operation"); 


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
            // InternalMappingDsl.g:20:7: ( 'parameters' )
            // InternalMappingDsl.g:20:9: 'parameters'
            {
            match("parameters"); 


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
            // InternalMappingDsl.g:21:7: ( 'referred' )
            // InternalMappingDsl.g:21:9: 'referred'
            {
            match("referred"); 


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
            // InternalMappingDsl.g:22:7: ( 'primitive' )
            // InternalMappingDsl.g:22:9: 'primitive'
            {
            match("primitive"); 


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
            // InternalMappingDsl.g:23:7: ( ':' )
            // InternalMappingDsl.g:23:9: ':'
            {
            match(':'); 

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
            // InternalMappingDsl.g:24:7: ( ';' )
            // InternalMappingDsl.g:24:9: ';'
            {
            match(';'); 

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
            // InternalMappingDsl.g:25:7: ( 'complex' )
            // InternalMappingDsl.g:25:9: 'complex'
            {
            match("complex"); 


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
            // InternalMappingDsl.g:26:7: ( '->' )
            // InternalMappingDsl.g:26:9: '->'
            {
            match("->"); 


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
            // InternalMappingDsl.g:27:7: ( '.' )
            // InternalMappingDsl.g:27:9: '.'
            {
            match('.'); 

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
            // InternalMappingDsl.g:28:7: ( 'op' )
            // InternalMappingDsl.g:28:9: 'op'
            {
            match("op"); 


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
            // InternalMappingDsl.g:29:7: ( 'return' )
            // InternalMappingDsl.g:29:9: 'return'
            {
            match("return"); 


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
            // InternalMappingDsl.g:30:7: ( '(' )
            // InternalMappingDsl.g:30:9: '('
            {
            match('('); 

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
            // InternalMappingDsl.g:31:7: ( ')' )
            // InternalMappingDsl.g:31:9: ')'
            {
            match(')'); 

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
            // InternalMappingDsl.g:32:7: ( ',' )
            // InternalMappingDsl.g:32:9: ','
            {
            match(','); 

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
            // InternalMappingDsl.g:33:7: ( 'import' )
            // InternalMappingDsl.g:33:9: 'import'
            {
            match("import"); 


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
            // InternalMappingDsl.g:34:7: ( 'from' )
            // InternalMappingDsl.g:34:9: 'from'
            {
            match("from"); 


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
            // InternalMappingDsl.g:35:7: ( 'as' )
            // InternalMappingDsl.g:35:9: 'as'
            {
            match("as"); 


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
            // InternalMappingDsl.g:36:7: ( '@' )
            // InternalMappingDsl.g:36:9: '@'
            {
            match('@'); 

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
            // InternalMappingDsl.g:37:7: ( '({' )
            // InternalMappingDsl.g:37:9: '({'
            {
            match("({"); 


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
            // InternalMappingDsl.g:38:7: ( '})' )
            // InternalMappingDsl.g:38:9: '})'
            {
            match("})"); 


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
            // InternalMappingDsl.g:39:7: ( 'microservice' )
            // InternalMappingDsl.g:39:9: 'microservice'
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
            // InternalMappingDsl.g:40:7: ( 'version' )
            // InternalMappingDsl.g:40:9: 'version'
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
            // InternalMappingDsl.g:41:7: ( 'required' )
            // InternalMappingDsl.g:41:9: 'required'
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
            // InternalMappingDsl.g:42:7: ( 'microservices' )
            // InternalMappingDsl.g:42:9: 'microservices'
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
            // InternalMappingDsl.g:43:7: ( 'interfaces' )
            // InternalMappingDsl.g:43:9: 'interfaces'
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
            // InternalMappingDsl.g:44:7: ( 'operations' )
            // InternalMappingDsl.g:44:9: 'operations'
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
            // InternalMappingDsl.g:45:7: ( 'technology' )
            // InternalMappingDsl.g:45:9: 'technology'
            {
            match("technology"); 


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
            // InternalMappingDsl.g:46:7: ( 'typedef' )
            // InternalMappingDsl.g:46:9: 'typedef'
            {
            match("typedef"); 


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
            // InternalMappingDsl.g:47:7: ( '=' )
            // InternalMappingDsl.g:47:9: '='
            {
            match('='); 

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
            // InternalMappingDsl.g:48:7: ( 'noimpl' )
            // InternalMappingDsl.g:48:9: 'noimpl'
            {
            match("noimpl"); 


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
            // InternalMappingDsl.g:49:7: ( '---' )
            // InternalMappingDsl.g:49:9: '---'
            {
            match("---"); 


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
            // InternalMappingDsl.g:50:7: ( '@param' )
            // InternalMappingDsl.g:50:9: '@param'
            {
            match("@param"); 


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
            // InternalMappingDsl.g:51:7: ( '@required' )
            // InternalMappingDsl.g:51:9: '@required'
            {
            match("@required"); 


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
            // InternalMappingDsl.g:52:7: ( '@requires' )
            // InternalMappingDsl.g:52:9: '@requires'
            {
            match("@requires"); 


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
            // InternalMappingDsl.g:53:7: ( '@returned' )
            // InternalMappingDsl.g:53:9: '@returned'
            {
            match("@returned"); 


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
            // InternalMappingDsl.g:54:7: ( '@returns' )
            // InternalMappingDsl.g:54:9: '@returns'
            {
            match("@returns"); 


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
            // InternalMappingDsl.g:55:7: ( 'refers' )
            // InternalMappingDsl.g:55:9: 'refers'
            {
            match("refers"); 


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
            // InternalMappingDsl.g:56:7: ( 'fault' )
            // InternalMappingDsl.g:56:9: 'fault'
            {
            match("fault"); 


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
            // InternalMappingDsl.g:57:7: ( '?' )
            // InternalMappingDsl.g:57:9: '?'
            {
            match('?'); 

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
            // InternalMappingDsl.g:58:7: ( '<' )
            // InternalMappingDsl.g:58:9: '<'
            {
            match('<'); 

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
            // InternalMappingDsl.g:59:7: ( '>' )
            // InternalMappingDsl.g:59:9: '>'
            {
            match('>'); 

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
            // InternalMappingDsl.g:60:7: ( '-' )
            // InternalMappingDsl.g:60:9: '-'
            {
            match('-'); 

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
            // InternalMappingDsl.g:61:7: ( '--' )
            // InternalMappingDsl.g:61:9: '--'
            {
            match("--"); 


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
            // InternalMappingDsl.g:62:7: ( '/' )
            // InternalMappingDsl.g:62:9: '/'
            {
            match('/'); 

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
            // InternalMappingDsl.g:63:7: ( 'types' )
            // InternalMappingDsl.g:63:9: 'types'
            {
            match("types"); 


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
            // InternalMappingDsl.g:64:7: ( 'compatibility' )
            // InternalMappingDsl.g:64:9: 'compatibility'
            {
            match("compatibility"); 


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
            // InternalMappingDsl.g:65:7: ( 'matrix' )
            // InternalMappingDsl.g:65:9: 'matrix'
            {
            match("matrix"); 


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
            // InternalMappingDsl.g:66:7: ( 'service' )
            // InternalMappingDsl.g:66:9: 'service'
            {
            match("service"); 


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
            // InternalMappingDsl.g:67:7: ( 'deployment' )
            // InternalMappingDsl.g:67:9: 'deployment'
            {
            match("deployment"); 


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
            // InternalMappingDsl.g:68:7: ( 'technologies' )
            // InternalMappingDsl.g:68:9: 'technologies'
            {
            match("technologies"); 


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
            // InternalMappingDsl.g:69:7: ( 'infrastructure' )
            // InternalMappingDsl.g:69:9: 'infrastructure'
            {
            match("infrastructure"); 


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
            // InternalMappingDsl.g:70:7: ( 'data' )
            // InternalMappingDsl.g:70:9: 'data'
            {
            match("data"); 


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
            // InternalMappingDsl.g:71:7: ( 'formats' )
            // InternalMappingDsl.g:71:9: 'formats'
            {
            match("formats"); 


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
            // InternalMappingDsl.g:72:7: ( 'default' )
            // InternalMappingDsl.g:72:9: 'default'
            {
            match("default"); 


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
            // InternalMappingDsl.g:73:7: ( 'with' )
            // InternalMappingDsl.g:73:9: 'with'
            {
            match("with"); 


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
            // InternalMappingDsl.g:74:7: ( 'format' )
            // InternalMappingDsl.g:74:9: 'format'
            {
            match("format"); 


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
            // InternalMappingDsl.g:75:7: ( 'in' )
            // InternalMappingDsl.g:75:9: 'in'
            {
            match("in"); 


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
            // InternalMappingDsl.g:76:7: ( 'out' )
            // InternalMappingDsl.g:76:9: 'out'
            {
            match("out"); 


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
            // InternalMappingDsl.g:77:7: ( 'inout' )
            // InternalMappingDsl.g:77:9: 'inout'
            {
            match("inout"); 


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
            // InternalMappingDsl.g:78:7: ( 'sync' )
            // InternalMappingDsl.g:78:9: 'sync'
            {
            match("sync"); 


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
            // InternalMappingDsl.g:79:7: ( 'async' )
            // InternalMappingDsl.g:79:9: 'async'
            {
            match("async"); 


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
            // InternalMappingDsl.g:80:7: ( 'based' )
            // InternalMappingDsl.g:80:9: 'based'
            {
            match("based"); 


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
            // InternalMappingDsl.g:81:7: ( 'on' )
            // InternalMappingDsl.g:81:9: 'on'
            {
            match("on"); 


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
            // InternalMappingDsl.g:82:7: ( 'collection' )
            // InternalMappingDsl.g:82:9: 'collection'
            {
            match("collection"); 


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
            // InternalMappingDsl.g:83:7: ( 'structure' )
            // InternalMappingDsl.g:83:9: 'structure'
            {
            match("structure"); 


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
            // InternalMappingDsl.g:84:7: ( '<-' )
            // InternalMappingDsl.g:84:9: '<-'
            {
            match("<-"); 


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
            // InternalMappingDsl.g:85:7: ( '<->' )
            // InternalMappingDsl.g:85:9: '<->'
            {
            match("<->"); 


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
            // InternalMappingDsl.g:86:7: ( 'environments' )
            // InternalMappingDsl.g:86:9: 'environments'
            {
            match("environments"); 


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
            // InternalMappingDsl.g:87:7: ( 'properties' )
            // InternalMappingDsl.g:87:9: 'properties'
            {
            match("properties"); 


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
            // InternalMappingDsl.g:88:7: ( 'mandatory' )
            // InternalMappingDsl.g:88:9: 'mandatory'
            {
            match("mandatory"); 


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
            // InternalMappingDsl.g:89:7: ( 'singleval' )
            // InternalMappingDsl.g:89:9: 'singleval'
            {
            match("singleval"); 


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
            // InternalMappingDsl.g:90:7: ( 'fields' )
            // InternalMappingDsl.g:90:9: 'fields'
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
            // InternalMappingDsl.g:91:7: ( 'exchange_pattern' )
            // InternalMappingDsl.g:91:9: 'exchange_pattern'
            {
            match("exchange_pattern"); 


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
            // InternalMappingDsl.g:92:7: ( 'communication_type' )
            // InternalMappingDsl.g:92:9: 'communication_type'
            {
            match("communication_type"); 


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
            // InternalMappingDsl.g:93:7: ( 'protocol' )
            // InternalMappingDsl.g:93:9: 'protocol'
            {
            match("protocol"); 


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
            // InternalMappingDsl.g:94:7: ( 'data_format' )
            // InternalMappingDsl.g:94:9: 'data_format'
            {
            match("data_format"); 


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
            // InternalMappingDsl.g:95:7: ( 'aspect' )
            // InternalMappingDsl.g:95:9: 'aspect'
            {
            match("aspect"); 


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
            // InternalMappingDsl.g:96:7: ( 'for' )
            // InternalMappingDsl.g:96:9: 'for'
            {
            match("for"); 


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
            // InternalMappingDsl.g:97:8: ( 'containers' )
            // InternalMappingDsl.g:97:10: 'containers'
            {
            match("containers"); 


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
            // InternalMappingDsl.g:98:8: ( 'selector' )
            // InternalMappingDsl.g:98:10: 'selector'
            {
            match("selector"); 


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
            // InternalMappingDsl.g:99:8: ( 'datatypes' )
            // InternalMappingDsl.g:99:10: 'datatypes'
            {
            match("datatypes"); 


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
            // InternalMappingDsl.g:100:8: ( 'context' )
            // InternalMappingDsl.g:100:10: 'context'
            {
            match("context"); 


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
            // InternalMappingDsl.g:101:8: ( 'aggregate' )
            // InternalMappingDsl.g:101:10: 'aggregate'
            {
            match("aggregate"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__104"

    // $ANTLR start "T__105"
    public final void mT__105() throws RecognitionException {
        try {
            int _type = T__105;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:102:8: ( 'applicationService' )
            // InternalMappingDsl.g:102:10: 'applicationService'
            {
            match("applicationService"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__105"

    // $ANTLR start "T__106"
    public final void mT__106() throws RecognitionException {
        try {
            int _type = T__106;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:103:8: ( 'domainEvent' )
            // InternalMappingDsl.g:103:10: 'domainEvent'
            {
            match("domainEvent"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__106"

    // $ANTLR start "T__107"
    public final void mT__107() throws RecognitionException {
        try {
            int _type = T__107;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:104:8: ( 'domainService' )
            // InternalMappingDsl.g:104:10: 'domainService'
            {
            match("domainService"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__107"

    // $ANTLR start "T__108"
    public final void mT__108() throws RecognitionException {
        try {
            int _type = T__108;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:105:8: ( 'entity' )
            // InternalMappingDsl.g:105:10: 'entity'
            {
            match("entity"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__108"

    // $ANTLR start "T__109"
    public final void mT__109() throws RecognitionException {
        try {
            int _type = T__109;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:106:8: ( 'factory' )
            // InternalMappingDsl.g:106:10: 'factory'
            {
            match("factory"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__109"

    // $ANTLR start "T__110"
    public final void mT__110() throws RecognitionException {
        try {
            int _type = T__110;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:107:8: ( 'infrastructureService' )
            // InternalMappingDsl.g:107:10: 'infrastructureService'
            {
            match("infrastructureService"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__110"

    // $ANTLR start "T__111"
    public final void mT__111() throws RecognitionException {
        try {
            int _type = T__111;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:108:8: ( 'repository' )
            // InternalMappingDsl.g:108:10: 'repository'
            {
            match("repository"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__111"

    // $ANTLR start "T__112"
    public final void mT__112() throws RecognitionException {
        try {
            int _type = T__112;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:109:8: ( 'specification' )
            // InternalMappingDsl.g:109:10: 'specification'
            {
            match("specification"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__112"

    // $ANTLR start "T__113"
    public final void mT__113() throws RecognitionException {
        try {
            int _type = T__113;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:110:8: ( 'valueObject' )
            // InternalMappingDsl.g:110:10: 'valueObject'
            {
            match("valueObject"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__113"

    // $ANTLR start "T__114"
    public final void mT__114() throws RecognitionException {
        try {
            int _type = T__114;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:111:8: ( 'extends' )
            // InternalMappingDsl.g:111:10: 'extends'
            {
            match("extends"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__114"

    // $ANTLR start "T__115"
    public final void mT__115() throws RecognitionException {
        try {
            int _type = T__115;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:112:8: ( 'identifier' )
            // InternalMappingDsl.g:112:10: 'identifier'
            {
            match("identifier"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__115"

    // $ANTLR start "T__116"
    public final void mT__116() throws RecognitionException {
        try {
            int _type = T__116;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:113:8: ( 'neverEmpty' )
            // InternalMappingDsl.g:113:10: 'neverEmpty'
            {
            match("neverEmpty"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__116"

    // $ANTLR start "T__117"
    public final void mT__117() throws RecognitionException {
        try {
            int _type = T__117;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:114:8: ( 'part' )
            // InternalMappingDsl.g:114:10: 'part'
            {
            match("part"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__117"

    // $ANTLR start "T__118"
    public final void mT__118() throws RecognitionException {
        try {
            int _type = T__118;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:115:8: ( 'hide' )
            // InternalMappingDsl.g:115:10: 'hide'
            {
            match("hide"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__118"

    // $ANTLR start "T__119"
    public final void mT__119() throws RecognitionException {
        try {
            int _type = T__119;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:116:8: ( 'immutable' )
            // InternalMappingDsl.g:116:10: 'immutable'
            {
            match("immutable"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__119"

    // $ANTLR start "T__120"
    public final void mT__120() throws RecognitionException {
        try {
            int _type = T__120;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:117:8: ( 'enum' )
            // InternalMappingDsl.g:117:10: 'enum'
            {
            match("enum"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__120"

    // $ANTLR start "T__121"
    public final void mT__121() throws RecognitionException {
        try {
            int _type = T__121;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:118:8: ( 'closure' )
            // InternalMappingDsl.g:118:10: 'closure'
            {
            match("closure"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__121"

    // $ANTLR start "T__122"
    public final void mT__122() throws RecognitionException {
        try {
            int _type = T__122;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:119:8: ( 'sideEffectFree' )
            // InternalMappingDsl.g:119:10: 'sideEffectFree'
            {
            match("sideEffectFree"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__122"

    // $ANTLR start "T__123"
    public final void mT__123() throws RecognitionException {
        try {
            int _type = T__123;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:120:8: ( 'validator' )
            // InternalMappingDsl.g:120:10: 'validator'
            {
            match("validator"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__123"

    // $ANTLR start "T__124"
    public final void mT__124() throws RecognitionException {
        try {
            int _type = T__124;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:121:8: ( 'function' )
            // InternalMappingDsl.g:121:10: 'function'
            {
            match("function"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__124"

    // $ANTLR start "T__125"
    public final void mT__125() throws RecognitionException {
        try {
            int _type = T__125;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:122:8: ( 'procedure' )
            // InternalMappingDsl.g:122:10: 'procedure'
            {
            match("procedure"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__125"

    // $ANTLR start "T__126"
    public final void mT__126() throws RecognitionException {
        try {
            int _type = T__126;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:123:8: ( 'boolean' )
            // InternalMappingDsl.g:123:10: 'boolean'
            {
            match("boolean"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__126"

    // $ANTLR start "T__127"
    public final void mT__127() throws RecognitionException {
        try {
            int _type = T__127;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:124:8: ( 'byte' )
            // InternalMappingDsl.g:124:10: 'byte'
            {
            match("byte"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__127"

    // $ANTLR start "T__128"
    public final void mT__128() throws RecognitionException {
        try {
            int _type = T__128;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:125:8: ( 'char' )
            // InternalMappingDsl.g:125:10: 'char'
            {
            match("char"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__128"

    // $ANTLR start "T__129"
    public final void mT__129() throws RecognitionException {
        try {
            int _type = T__129;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:126:8: ( 'date' )
            // InternalMappingDsl.g:126:10: 'date'
            {
            match("date"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__129"

    // $ANTLR start "T__130"
    public final void mT__130() throws RecognitionException {
        try {
            int _type = T__130;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:127:8: ( 'double' )
            // InternalMappingDsl.g:127:10: 'double'
            {
            match("double"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__130"

    // $ANTLR start "T__131"
    public final void mT__131() throws RecognitionException {
        try {
            int _type = T__131;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:128:8: ( 'float' )
            // InternalMappingDsl.g:128:10: 'float'
            {
            match("float"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__131"

    // $ANTLR start "T__132"
    public final void mT__132() throws RecognitionException {
        try {
            int _type = T__132;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:129:8: ( 'int' )
            // InternalMappingDsl.g:129:10: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__132"

    // $ANTLR start "T__133"
    public final void mT__133() throws RecognitionException {
        try {
            int _type = T__133;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:130:8: ( 'long' )
            // InternalMappingDsl.g:130:10: 'long'
            {
            match("long"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__133"

    // $ANTLR start "T__134"
    public final void mT__134() throws RecognitionException {
        try {
            int _type = T__134;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:131:8: ( 'short' )
            // InternalMappingDsl.g:131:10: 'short'
            {
            match("short"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__134"

    // $ANTLR start "T__135"
    public final void mT__135() throws RecognitionException {
        try {
            int _type = T__135;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:132:8: ( 'string' )
            // InternalMappingDsl.g:132:10: 'string'
            {
            match("string"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__135"

    // $ANTLR start "T__136"
    public final void mT__136() throws RecognitionException {
        try {
            int _type = T__136;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:133:8: ( 'internal' )
            // InternalMappingDsl.g:133:10: 'internal'
            {
            match("internal"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__136"

    // $ANTLR start "T__137"
    public final void mT__137() throws RecognitionException {
        try {
            int _type = T__137;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:134:8: ( 'architecture' )
            // InternalMappingDsl.g:134:10: 'architecture'
            {
            match("architecture"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__137"

    // $ANTLR start "T__138"
    public final void mT__138() throws RecognitionException {
        try {
            int _type = T__138;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:135:8: ( 'public' )
            // InternalMappingDsl.g:135:10: 'public'
            {
            match("public"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__138"

    // $ANTLR start "T__139"
    public final void mT__139() throws RecognitionException {
        try {
            int _type = T__139;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:136:8: ( 'requires' )
            // InternalMappingDsl.g:136:10: 'requires'
            {
            match("requires"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__139"

    // $ANTLR start "T__140"
    public final void mT__140() throws RecognitionException {
        try {
            int _type = T__140;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:137:8: ( 'returned' )
            // InternalMappingDsl.g:137:10: 'returned'
            {
            match("returned"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__140"

    // $ANTLR start "T__141"
    public final void mT__141() throws RecognitionException {
        try {
            int _type = T__141;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:138:8: ( 'returns' )
            // InternalMappingDsl.g:138:10: 'returns'
            {
            match("returns"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__141"

    // $ANTLR start "T__142"
    public final void mT__142() throws RecognitionException {
        try {
            int _type = T__142;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:139:8: ( 'param' )
            // InternalMappingDsl.g:139:10: 'param'
            {
            match("param"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__142"

    // $ANTLR start "T__143"
    public final void mT__143() throws RecognitionException {
        try {
            int _type = T__143;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:140:8: ( 'functional' )
            // InternalMappingDsl.g:140:10: 'functional'
            {
            match("functional"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__143"

    // $ANTLR start "T__144"
    public final void mT__144() throws RecognitionException {
        try {
            int _type = T__144;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:141:8: ( 'utility' )
            // InternalMappingDsl.g:141:10: 'utility'
            {
            match("utility"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__144"

    // $ANTLR start "T__145"
    public final void mT__145() throws RecognitionException {
        try {
            int _type = T__145;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:142:8: ( 'unspecified' )
            // InternalMappingDsl.g:142:10: 'unspecified'
            {
            match("unspecified"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__145"

    // $ANTLR start "T__146"
    public final void mT__146() throws RecognitionException {
        try {
            int _type = T__146;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:143:8: ( 'domainOperations' )
            // InternalMappingDsl.g:143:10: 'domainOperations'
            {
            match("domainOperations"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__146"

    // $ANTLR start "T__147"
    public final void mT__147() throws RecognitionException {
        try {
            int _type = T__147;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:144:8: ( 'domainParameters' )
            // InternalMappingDsl.g:144:10: 'domainParameters'
            {
            match("domainParameters"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__147"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:9757:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalMappingDsl.g:9757:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalMappingDsl.g:9757:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\"') ) {
                alt3=1;
            }
            else if ( (LA3_0=='\'') ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalMappingDsl.g:9757:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalMappingDsl.g:9757:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop1:
                    do {
                        int alt1=3;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0=='\\') ) {
                            alt1=1;
                        }
                        else if ( ((LA1_0>='\u0000' && LA1_0<='!')||(LA1_0>='#' && LA1_0<='[')||(LA1_0>=']' && LA1_0<='\uFFFF')) ) {
                            alt1=2;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalMappingDsl.g:9757:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalMappingDsl.g:9757:28: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop1;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:9757:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalMappingDsl.g:9757:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop2:
                    do {
                        int alt2=3;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0=='\\') ) {
                            alt2=1;
                        }
                        else if ( ((LA2_0>='\u0000' && LA2_0<='&')||(LA2_0>='(' && LA2_0<='[')||(LA2_0>=']' && LA2_0<='\uFFFF')) ) {
                            alt2=2;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalMappingDsl.g:9757:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalMappingDsl.g:9757:61: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop2;
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

    // $ANTLR start "RULE_NUMBER_WITH_TRAILING_PERIOD"
    public final void mRULE_NUMBER_WITH_TRAILING_PERIOD() throws RecognitionException {
        try {
            int _type = RULE_NUMBER_WITH_TRAILING_PERIOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:9759:34: ( RULE_INT '.' )
            // InternalMappingDsl.g:9759:36: RULE_INT '.'
            {
            mRULE_INT(); 
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NUMBER_WITH_TRAILING_PERIOD"

    // $ANTLR start "RULE_BIG_DECIMAL"
    public final void mRULE_BIG_DECIMAL() throws RecognitionException {
        try {
            int _type = RULE_BIG_DECIMAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:9761:18: ( ( '-' )? RULE_INT ( '.' RULE_INT )? )
            // InternalMappingDsl.g:9761:20: ( '-' )? RULE_INT ( '.' RULE_INT )?
            {
            // InternalMappingDsl.g:9761:20: ( '-' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='-') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalMappingDsl.g:9761:20: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            mRULE_INT(); 
            // InternalMappingDsl.g:9761:34: ( '.' RULE_INT )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='.') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalMappingDsl.g:9761:35: '.' RULE_INT
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
            // InternalMappingDsl.g:9763:14: ( ( 'true' | 'false' ) )
            // InternalMappingDsl.g:9763:16: ( 'true' | 'false' )
            {
            // InternalMappingDsl.g:9763:16: ( 'true' | 'false' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='t') ) {
                alt6=1;
            }
            else if ( (LA6_0=='f') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalMappingDsl.g:9763:17: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:9763:24: 'false'
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
            // InternalMappingDsl.g:9765:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalMappingDsl.g:9765:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalMappingDsl.g:9765:11: ( '^' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='^') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalMappingDsl.g:9765:11: '^'
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

            // InternalMappingDsl.g:9765:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')||(LA8_0>='A' && LA8_0<='Z')||LA8_0=='_'||(LA8_0>='a' && LA8_0<='z')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalMappingDsl.g:
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
            	    break loop8;
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
            // InternalMappingDsl.g:9767:19: ( ( '0' .. '9' )+ )
            // InternalMappingDsl.g:9767:21: ( '0' .. '9' )+
            {
            // InternalMappingDsl.g:9767:21: ( '0' .. '9' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalMappingDsl.g:9767:22: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:9769:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalMappingDsl.g:9769:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalMappingDsl.g:9769:24: ( options {greedy=false; } : . )*
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
            	    // InternalMappingDsl.g:9769:52: .
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
            // InternalMappingDsl.g:9771:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalMappingDsl.g:9771:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalMappingDsl.g:9771:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\u0000' && LA11_0<='\t')||(LA11_0>='\u000B' && LA11_0<='\f')||(LA11_0>='\u000E' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalMappingDsl.g:9771:24: ~ ( ( '\\n' | '\\r' ) )
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

            // InternalMappingDsl.g:9771:40: ( ( '\\r' )? '\\n' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\n'||LA13_0=='\r') ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalMappingDsl.g:9771:41: ( '\\r' )? '\\n'
                    {
                    // InternalMappingDsl.g:9771:41: ( '\\r' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='\r') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalMappingDsl.g:9771:41: '\\r'
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
            // InternalMappingDsl.g:9773:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalMappingDsl.g:9773:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalMappingDsl.g:9773:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // InternalMappingDsl.g:
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
            // InternalMappingDsl.g:9775:16: ( . )
            // InternalMappingDsl.g:9775:18: .
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
        // InternalMappingDsl.g:1:8: ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | T__129 | T__130 | T__131 | T__132 | T__133 | T__134 | T__135 | T__136 | T__137 | T__138 | T__139 | T__140 | T__141 | T__142 | T__143 | T__144 | T__145 | T__146 | T__147 | RULE_STRING | RULE_NUMBER_WITH_TRAILING_PERIOD | RULE_BIG_DECIMAL | RULE_BOOLEAN | RULE_ID | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt15=143;
        alt15 = dfa15.predict(input);
        switch (alt15) {
            case 1 :
                // InternalMappingDsl.g:1:10: T__14
                {
                mT__14(); 

                }
                break;
            case 2 :
                // InternalMappingDsl.g:1:16: T__15
                {
                mT__15(); 

                }
                break;
            case 3 :
                // InternalMappingDsl.g:1:22: T__16
                {
                mT__16(); 

                }
                break;
            case 4 :
                // InternalMappingDsl.g:1:28: T__17
                {
                mT__17(); 

                }
                break;
            case 5 :
                // InternalMappingDsl.g:1:34: T__18
                {
                mT__18(); 

                }
                break;
            case 6 :
                // InternalMappingDsl.g:1:40: T__19
                {
                mT__19(); 

                }
                break;
            case 7 :
                // InternalMappingDsl.g:1:46: T__20
                {
                mT__20(); 

                }
                break;
            case 8 :
                // InternalMappingDsl.g:1:52: T__21
                {
                mT__21(); 

                }
                break;
            case 9 :
                // InternalMappingDsl.g:1:58: T__22
                {
                mT__22(); 

                }
                break;
            case 10 :
                // InternalMappingDsl.g:1:64: T__23
                {
                mT__23(); 

                }
                break;
            case 11 :
                // InternalMappingDsl.g:1:70: T__24
                {
                mT__24(); 

                }
                break;
            case 12 :
                // InternalMappingDsl.g:1:76: T__25
                {
                mT__25(); 

                }
                break;
            case 13 :
                // InternalMappingDsl.g:1:82: T__26
                {
                mT__26(); 

                }
                break;
            case 14 :
                // InternalMappingDsl.g:1:88: T__27
                {
                mT__27(); 

                }
                break;
            case 15 :
                // InternalMappingDsl.g:1:94: T__28
                {
                mT__28(); 

                }
                break;
            case 16 :
                // InternalMappingDsl.g:1:100: T__29
                {
                mT__29(); 

                }
                break;
            case 17 :
                // InternalMappingDsl.g:1:106: T__30
                {
                mT__30(); 

                }
                break;
            case 18 :
                // InternalMappingDsl.g:1:112: T__31
                {
                mT__31(); 

                }
                break;
            case 19 :
                // InternalMappingDsl.g:1:118: T__32
                {
                mT__32(); 

                }
                break;
            case 20 :
                // InternalMappingDsl.g:1:124: T__33
                {
                mT__33(); 

                }
                break;
            case 21 :
                // InternalMappingDsl.g:1:130: T__34
                {
                mT__34(); 

                }
                break;
            case 22 :
                // InternalMappingDsl.g:1:136: T__35
                {
                mT__35(); 

                }
                break;
            case 23 :
                // InternalMappingDsl.g:1:142: T__36
                {
                mT__36(); 

                }
                break;
            case 24 :
                // InternalMappingDsl.g:1:148: T__37
                {
                mT__37(); 

                }
                break;
            case 25 :
                // InternalMappingDsl.g:1:154: T__38
                {
                mT__38(); 

                }
                break;
            case 26 :
                // InternalMappingDsl.g:1:160: T__39
                {
                mT__39(); 

                }
                break;
            case 27 :
                // InternalMappingDsl.g:1:166: T__40
                {
                mT__40(); 

                }
                break;
            case 28 :
                // InternalMappingDsl.g:1:172: T__41
                {
                mT__41(); 

                }
                break;
            case 29 :
                // InternalMappingDsl.g:1:178: T__42
                {
                mT__42(); 

                }
                break;
            case 30 :
                // InternalMappingDsl.g:1:184: T__43
                {
                mT__43(); 

                }
                break;
            case 31 :
                // InternalMappingDsl.g:1:190: T__44
                {
                mT__44(); 

                }
                break;
            case 32 :
                // InternalMappingDsl.g:1:196: T__45
                {
                mT__45(); 

                }
                break;
            case 33 :
                // InternalMappingDsl.g:1:202: T__46
                {
                mT__46(); 

                }
                break;
            case 34 :
                // InternalMappingDsl.g:1:208: T__47
                {
                mT__47(); 

                }
                break;
            case 35 :
                // InternalMappingDsl.g:1:214: T__48
                {
                mT__48(); 

                }
                break;
            case 36 :
                // InternalMappingDsl.g:1:220: T__49
                {
                mT__49(); 

                }
                break;
            case 37 :
                // InternalMappingDsl.g:1:226: T__50
                {
                mT__50(); 

                }
                break;
            case 38 :
                // InternalMappingDsl.g:1:232: T__51
                {
                mT__51(); 

                }
                break;
            case 39 :
                // InternalMappingDsl.g:1:238: T__52
                {
                mT__52(); 

                }
                break;
            case 40 :
                // InternalMappingDsl.g:1:244: T__53
                {
                mT__53(); 

                }
                break;
            case 41 :
                // InternalMappingDsl.g:1:250: T__54
                {
                mT__54(); 

                }
                break;
            case 42 :
                // InternalMappingDsl.g:1:256: T__55
                {
                mT__55(); 

                }
                break;
            case 43 :
                // InternalMappingDsl.g:1:262: T__56
                {
                mT__56(); 

                }
                break;
            case 44 :
                // InternalMappingDsl.g:1:268: T__57
                {
                mT__57(); 

                }
                break;
            case 45 :
                // InternalMappingDsl.g:1:274: T__58
                {
                mT__58(); 

                }
                break;
            case 46 :
                // InternalMappingDsl.g:1:280: T__59
                {
                mT__59(); 

                }
                break;
            case 47 :
                // InternalMappingDsl.g:1:286: T__60
                {
                mT__60(); 

                }
                break;
            case 48 :
                // InternalMappingDsl.g:1:292: T__61
                {
                mT__61(); 

                }
                break;
            case 49 :
                // InternalMappingDsl.g:1:298: T__62
                {
                mT__62(); 

                }
                break;
            case 50 :
                // InternalMappingDsl.g:1:304: T__63
                {
                mT__63(); 

                }
                break;
            case 51 :
                // InternalMappingDsl.g:1:310: T__64
                {
                mT__64(); 

                }
                break;
            case 52 :
                // InternalMappingDsl.g:1:316: T__65
                {
                mT__65(); 

                }
                break;
            case 53 :
                // InternalMappingDsl.g:1:322: T__66
                {
                mT__66(); 

                }
                break;
            case 54 :
                // InternalMappingDsl.g:1:328: T__67
                {
                mT__67(); 

                }
                break;
            case 55 :
                // InternalMappingDsl.g:1:334: T__68
                {
                mT__68(); 

                }
                break;
            case 56 :
                // InternalMappingDsl.g:1:340: T__69
                {
                mT__69(); 

                }
                break;
            case 57 :
                // InternalMappingDsl.g:1:346: T__70
                {
                mT__70(); 

                }
                break;
            case 58 :
                // InternalMappingDsl.g:1:352: T__71
                {
                mT__71(); 

                }
                break;
            case 59 :
                // InternalMappingDsl.g:1:358: T__72
                {
                mT__72(); 

                }
                break;
            case 60 :
                // InternalMappingDsl.g:1:364: T__73
                {
                mT__73(); 

                }
                break;
            case 61 :
                // InternalMappingDsl.g:1:370: T__74
                {
                mT__74(); 

                }
                break;
            case 62 :
                // InternalMappingDsl.g:1:376: T__75
                {
                mT__75(); 

                }
                break;
            case 63 :
                // InternalMappingDsl.g:1:382: T__76
                {
                mT__76(); 

                }
                break;
            case 64 :
                // InternalMappingDsl.g:1:388: T__77
                {
                mT__77(); 

                }
                break;
            case 65 :
                // InternalMappingDsl.g:1:394: T__78
                {
                mT__78(); 

                }
                break;
            case 66 :
                // InternalMappingDsl.g:1:400: T__79
                {
                mT__79(); 

                }
                break;
            case 67 :
                // InternalMappingDsl.g:1:406: T__80
                {
                mT__80(); 

                }
                break;
            case 68 :
                // InternalMappingDsl.g:1:412: T__81
                {
                mT__81(); 

                }
                break;
            case 69 :
                // InternalMappingDsl.g:1:418: T__82
                {
                mT__82(); 

                }
                break;
            case 70 :
                // InternalMappingDsl.g:1:424: T__83
                {
                mT__83(); 

                }
                break;
            case 71 :
                // InternalMappingDsl.g:1:430: T__84
                {
                mT__84(); 

                }
                break;
            case 72 :
                // InternalMappingDsl.g:1:436: T__85
                {
                mT__85(); 

                }
                break;
            case 73 :
                // InternalMappingDsl.g:1:442: T__86
                {
                mT__86(); 

                }
                break;
            case 74 :
                // InternalMappingDsl.g:1:448: T__87
                {
                mT__87(); 

                }
                break;
            case 75 :
                // InternalMappingDsl.g:1:454: T__88
                {
                mT__88(); 

                }
                break;
            case 76 :
                // InternalMappingDsl.g:1:460: T__89
                {
                mT__89(); 

                }
                break;
            case 77 :
                // InternalMappingDsl.g:1:466: T__90
                {
                mT__90(); 

                }
                break;
            case 78 :
                // InternalMappingDsl.g:1:472: T__91
                {
                mT__91(); 

                }
                break;
            case 79 :
                // InternalMappingDsl.g:1:478: T__92
                {
                mT__92(); 

                }
                break;
            case 80 :
                // InternalMappingDsl.g:1:484: T__93
                {
                mT__93(); 

                }
                break;
            case 81 :
                // InternalMappingDsl.g:1:490: T__94
                {
                mT__94(); 

                }
                break;
            case 82 :
                // InternalMappingDsl.g:1:496: T__95
                {
                mT__95(); 

                }
                break;
            case 83 :
                // InternalMappingDsl.g:1:502: T__96
                {
                mT__96(); 

                }
                break;
            case 84 :
                // InternalMappingDsl.g:1:508: T__97
                {
                mT__97(); 

                }
                break;
            case 85 :
                // InternalMappingDsl.g:1:514: T__98
                {
                mT__98(); 

                }
                break;
            case 86 :
                // InternalMappingDsl.g:1:520: T__99
                {
                mT__99(); 

                }
                break;
            case 87 :
                // InternalMappingDsl.g:1:526: T__100
                {
                mT__100(); 

                }
                break;
            case 88 :
                // InternalMappingDsl.g:1:533: T__101
                {
                mT__101(); 

                }
                break;
            case 89 :
                // InternalMappingDsl.g:1:540: T__102
                {
                mT__102(); 

                }
                break;
            case 90 :
                // InternalMappingDsl.g:1:547: T__103
                {
                mT__103(); 

                }
                break;
            case 91 :
                // InternalMappingDsl.g:1:554: T__104
                {
                mT__104(); 

                }
                break;
            case 92 :
                // InternalMappingDsl.g:1:561: T__105
                {
                mT__105(); 

                }
                break;
            case 93 :
                // InternalMappingDsl.g:1:568: T__106
                {
                mT__106(); 

                }
                break;
            case 94 :
                // InternalMappingDsl.g:1:575: T__107
                {
                mT__107(); 

                }
                break;
            case 95 :
                // InternalMappingDsl.g:1:582: T__108
                {
                mT__108(); 

                }
                break;
            case 96 :
                // InternalMappingDsl.g:1:589: T__109
                {
                mT__109(); 

                }
                break;
            case 97 :
                // InternalMappingDsl.g:1:596: T__110
                {
                mT__110(); 

                }
                break;
            case 98 :
                // InternalMappingDsl.g:1:603: T__111
                {
                mT__111(); 

                }
                break;
            case 99 :
                // InternalMappingDsl.g:1:610: T__112
                {
                mT__112(); 

                }
                break;
            case 100 :
                // InternalMappingDsl.g:1:617: T__113
                {
                mT__113(); 

                }
                break;
            case 101 :
                // InternalMappingDsl.g:1:624: T__114
                {
                mT__114(); 

                }
                break;
            case 102 :
                // InternalMappingDsl.g:1:631: T__115
                {
                mT__115(); 

                }
                break;
            case 103 :
                // InternalMappingDsl.g:1:638: T__116
                {
                mT__116(); 

                }
                break;
            case 104 :
                // InternalMappingDsl.g:1:645: T__117
                {
                mT__117(); 

                }
                break;
            case 105 :
                // InternalMappingDsl.g:1:652: T__118
                {
                mT__118(); 

                }
                break;
            case 106 :
                // InternalMappingDsl.g:1:659: T__119
                {
                mT__119(); 

                }
                break;
            case 107 :
                // InternalMappingDsl.g:1:666: T__120
                {
                mT__120(); 

                }
                break;
            case 108 :
                // InternalMappingDsl.g:1:673: T__121
                {
                mT__121(); 

                }
                break;
            case 109 :
                // InternalMappingDsl.g:1:680: T__122
                {
                mT__122(); 

                }
                break;
            case 110 :
                // InternalMappingDsl.g:1:687: T__123
                {
                mT__123(); 

                }
                break;
            case 111 :
                // InternalMappingDsl.g:1:694: T__124
                {
                mT__124(); 

                }
                break;
            case 112 :
                // InternalMappingDsl.g:1:701: T__125
                {
                mT__125(); 

                }
                break;
            case 113 :
                // InternalMappingDsl.g:1:708: T__126
                {
                mT__126(); 

                }
                break;
            case 114 :
                // InternalMappingDsl.g:1:715: T__127
                {
                mT__127(); 

                }
                break;
            case 115 :
                // InternalMappingDsl.g:1:722: T__128
                {
                mT__128(); 

                }
                break;
            case 116 :
                // InternalMappingDsl.g:1:729: T__129
                {
                mT__129(); 

                }
                break;
            case 117 :
                // InternalMappingDsl.g:1:736: T__130
                {
                mT__130(); 

                }
                break;
            case 118 :
                // InternalMappingDsl.g:1:743: T__131
                {
                mT__131(); 

                }
                break;
            case 119 :
                // InternalMappingDsl.g:1:750: T__132
                {
                mT__132(); 

                }
                break;
            case 120 :
                // InternalMappingDsl.g:1:757: T__133
                {
                mT__133(); 

                }
                break;
            case 121 :
                // InternalMappingDsl.g:1:764: T__134
                {
                mT__134(); 

                }
                break;
            case 122 :
                // InternalMappingDsl.g:1:771: T__135
                {
                mT__135(); 

                }
                break;
            case 123 :
                // InternalMappingDsl.g:1:778: T__136
                {
                mT__136(); 

                }
                break;
            case 124 :
                // InternalMappingDsl.g:1:785: T__137
                {
                mT__137(); 

                }
                break;
            case 125 :
                // InternalMappingDsl.g:1:792: T__138
                {
                mT__138(); 

                }
                break;
            case 126 :
                // InternalMappingDsl.g:1:799: T__139
                {
                mT__139(); 

                }
                break;
            case 127 :
                // InternalMappingDsl.g:1:806: T__140
                {
                mT__140(); 

                }
                break;
            case 128 :
                // InternalMappingDsl.g:1:813: T__141
                {
                mT__141(); 

                }
                break;
            case 129 :
                // InternalMappingDsl.g:1:820: T__142
                {
                mT__142(); 

                }
                break;
            case 130 :
                // InternalMappingDsl.g:1:827: T__143
                {
                mT__143(); 

                }
                break;
            case 131 :
                // InternalMappingDsl.g:1:834: T__144
                {
                mT__144(); 

                }
                break;
            case 132 :
                // InternalMappingDsl.g:1:841: T__145
                {
                mT__145(); 

                }
                break;
            case 133 :
                // InternalMappingDsl.g:1:848: T__146
                {
                mT__146(); 

                }
                break;
            case 134 :
                // InternalMappingDsl.g:1:855: T__147
                {
                mT__147(); 

                }
                break;
            case 135 :
                // InternalMappingDsl.g:1:862: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 136 :
                // InternalMappingDsl.g:1:874: RULE_NUMBER_WITH_TRAILING_PERIOD
                {
                mRULE_NUMBER_WITH_TRAILING_PERIOD(); 

                }
                break;
            case 137 :
                // InternalMappingDsl.g:1:907: RULE_BIG_DECIMAL
                {
                mRULE_BIG_DECIMAL(); 

                }
                break;
            case 138 :
                // InternalMappingDsl.g:1:924: RULE_BOOLEAN
                {
                mRULE_BOOLEAN(); 

                }
                break;
            case 139 :
                // InternalMappingDsl.g:1:937: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 140 :
                // InternalMappingDsl.g:1:945: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 141 :
                // InternalMappingDsl.g:1:961: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 142 :
                // InternalMappingDsl.g:1:977: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 143 :
                // InternalMappingDsl.g:1:985: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA15_eotS =
        "\1\uffff\1\55\1\uffff\1\55\1\64\1\66\5\55\1\uffff\1\55\1\111\1\uffff\1\115\2\uffff\1\55\1\130\2\55\1\uffff\1\55\1\uffff\1\142\1\uffff\1\146\7\55\2\51\1\112\1\51\3\uffff\3\55\2\uffff\1\u0081\3\55\4\uffff\5\55\1\u0092\2\55\1\u0097\1\55\1\u0099\1\55\1\uffff\3\55\1\uffff\1\u00a4\7\uffff\6\55\3\uffff\4\55\1\uffff\2\55\1\uffff\1\u00b6\5\uffff\21\55\1\uffff\1\u00cc\1\112\1\uffff\5\55\1\uffff\15\55\1\u00e3\2\55\1\uffff\4\55\1\uffff\1\u00ea\1\uffff\11\55\2\uffff\4\55\1\u00fa\3\55\1\uffff\7\55\2\uffff\25\55\1\uffff\1\u0121\1\55\1\u0123\12\55\1\u012e\4\55\1\u0133\3\55\1\uffff\6\55\1\uffff\11\55\1\u0148\1\u0149\4\55\1\uffff\3\55\2\uffff\12\55\1\u015d\10\55\1\u0168\1\u0169\2\55\1\u016c\2\55\1\u016f\1\u0170\1\u0171\3\55\1\u0175\1\uffff\1\55\1\uffff\1\55\1\u0178\7\55\1\u0181\1\uffff\4\55\1\uffff\4\55\1\u018b\17\55\2\uffff\1\u019c\1\55\1\u0123\3\55\1\u01a1\2\uffff\12\55\1\uffff\5\55\1\u01b3\4\55\2\uffff\2\55\1\uffff\1\u01ba\1\55\3\uffff\3\55\1\uffff\1\55\1\u01c1\1\uffff\10\55\1\uffff\1\u01ca\2\55\1\u01cd\5\55\1\uffff\1\u01d3\4\55\1\u01d8\1\u01db\11\55\1\uffff\1\55\1\u01e7\1\u01e8\1\55\3\uffff\1\55\1\u01ed\4\55\1\u01f2\4\55\1\u01f7\3\55\1\uffff\5\55\1\u0203\1\uffff\3\55\1\u0207\1\55\1\u0209\1\uffff\10\55\1\uffff\2\55\1\uffff\1\55\1\u0215\3\55\1\uffff\4\55\1\uffff\1\55\1\u021e\1\uffff\2\55\1\u0222\4\55\1\u0227\1\u0228\1\u0229\1\u022a\2\uffff\1\55\2\uffff\1\55\1\uffff\1\55\1\u0231\2\55\1\uffff\1\55\1\u0235\2\55\1\uffff\4\55\1\u023c\6\55\1\uffff\1\u0243\1\u0244\1\55\1\uffff\1\55\1\uffff\3\55\1\u024b\7\55\1\uffff\1\55\1\u0254\4\55\1\u0259\1\u025a\1\uffff\1\u025b\1\u025c\1\55\1\uffff\4\55\4\uffff\1\u0263\3\uffff\2\55\1\uffff\3\55\1\uffff\1\u026b\5\55\1\uffff\6\55\2\uffff\2\55\1\u027a\2\55\1\u027d\1\uffff\1\55\1\u027f\1\u0280\1\55\1\u0282\2\55\1\u0286\1\uffff\1\55\1\u0288\1\55\1\u028b\4\uffff\6\55\3\uffff\1\55\1\u0293\1\55\1\u0295\1\55\1\uffff\1\u0297\1\u0298\4\55\1\u029d\5\55\1\u02a3\1\55\1\uffff\2\55\1\uffff\1\u02a7\2\uffff\1\u02a8\1\uffff\2\55\1\u02ab\1\uffff\1\55\1\uffff\1\u02ad\1\u02ae\1\uffff\1\u02af\2\55\1\u02b2\1\u02b3\1\u02b4\1\55\1\uffff\1\55\1\uffff\1\u02b7\2\uffff\2\55\1\u02ba\1\55\1\uffff\5\55\1\uffff\3\55\2\uffff\2\55\1\uffff\1\55\3\uffff\2\55\3\uffff\1\55\1\u02ca\1\uffff\2\55\1\uffff\1\u02cd\1\u02ce\3\55\1\u02d2\1\u02d3\1\55\1\u02d5\1\u02d6\4\55\1\u02dc\1\uffff\2\55\2\uffff\3\55\2\uffff\1\55\2\uffff\2\55\1\u02e5\1\55\1\u02e7\1\uffff\1\55\1\u02e9\1\u02ea\4\55\1\u02f0\1\uffff\1\55\1\uffff\1\u02f2\2\uffff\5\55\1\uffff\1\55\1\uffff\3\55\1\u02fc\2\55\1\u02ff\1\u0300\1\55\1\uffff\2\55\2\uffff\1\u0304\1\55\1\u0306\1\uffff\1\55\1\uffff\1\55\1\u0309\1\uffff";
    static final String DFA15_eofS =
        "\u030a\uffff";
    static final String DFA15_minS =
        "\1\0\1\145\1\uffff\1\147\1\51\1\72\1\141\1\156\1\144\1\156\1\145\1\uffff\1\150\1\55\1\uffff\1\173\2\uffff\1\141\1\160\2\141\1\uffff\1\145\1\uffff\1\55\1\uffff\1\52\1\145\1\141\1\151\1\141\1\151\1\157\1\156\2\0\1\56\1\101\3\uffff\1\160\1\143\1\165\2\uffff\1\60\1\147\1\160\1\143\4\uffff\1\151\1\162\1\142\1\144\1\143\1\60\1\155\1\145\1\60\1\164\1\60\1\146\1\uffff\1\154\1\157\1\141\1\uffff\1\55\7\uffff\1\157\1\143\1\162\1\145\1\156\1\157\1\uffff\1\145\1\uffff\1\143\1\156\1\162\1\154\1\uffff\1\151\1\166\1\uffff\1\76\5\uffff\1\154\1\156\1\162\1\144\1\145\1\157\1\146\1\164\1\155\1\164\1\163\1\157\1\164\1\144\1\156\1\151\1\163\1\uffff\1\60\1\56\1\uffff\1\145\1\150\2\145\1\156\1\uffff\1\162\1\154\1\150\1\143\1\155\1\141\1\154\1\160\2\151\1\155\1\150\1\145\1\60\1\162\1\165\1\uffff\1\157\1\165\1\156\1\162\1\uffff\1\60\1\uffff\1\145\2\165\1\157\1\155\1\154\1\164\1\163\1\162\2\uffff\1\155\1\154\1\164\1\163\1\60\1\154\1\143\1\141\1\161\2\162\1\144\1\163\1\151\1\155\1\145\2\uffff\1\166\1\145\1\143\1\151\1\147\1\145\1\143\1\162\1\154\3\141\1\142\1\150\1\145\1\154\2\145\1\147\1\154\1\160\1\uffff\1\60\1\156\1\60\2\143\1\145\2\151\1\157\2\145\1\151\1\155\1\60\1\151\1\157\1\162\1\164\1\60\1\141\1\156\1\162\1\uffff\1\141\1\164\1\162\2\164\1\141\1\uffff\2\162\1\151\1\163\1\141\1\165\1\145\1\141\1\165\2\60\1\164\1\157\1\145\1\141\1\uffff\1\144\2\164\2\165\1\157\1\151\1\141\1\151\1\145\1\144\1\160\1\162\1\151\1\143\1\60\1\143\1\156\1\154\1\105\1\151\1\164\1\157\1\165\2\60\1\151\1\154\1\60\1\144\1\145\3\60\1\151\2\145\1\60\1\uffff\1\157\1\uffff\1\164\1\60\1\147\1\143\1\164\1\143\1\162\1\144\1\164\1\60\1\uffff\1\143\1\151\1\157\1\171\1\uffff\1\156\1\144\1\146\1\163\1\60\1\164\1\141\1\151\1\164\1\162\1\156\1\162\1\151\1\145\1\164\1\156\1\143\1\151\1\170\1\162\2\uffff\1\60\1\162\1\60\1\164\1\163\1\151\1\60\1\151\1\162\1\163\1\170\1\164\1\157\1\117\1\141\1\154\1\105\1\143\1\164\1\uffff\1\164\1\147\1\145\2\146\1\60\1\171\1\154\1\146\1\171\2\uffff\1\156\1\145\1\uffff\1\60\1\141\3\uffff\1\164\1\143\1\146\1\uffff\1\154\1\60\1\uffff\2\141\1\145\1\157\1\164\1\165\1\151\1\164\1\uffff\1\60\2\156\1\60\1\147\1\163\2\141\1\164\1\uffff\1\60\1\142\1\146\1\151\1\145\2\60\1\145\1\164\1\170\2\151\1\164\1\156\1\164\1\145\1\uffff\1\171\2\60\1\157\1\uffff\1\162\1\156\1\145\1\60\1\157\1\156\1\142\1\164\1\60\1\155\1\145\1\157\1\165\1\60\1\166\1\146\1\151\1\uffff\1\155\1\164\1\157\1\160\1\105\1\60\1\uffff\1\156\1\171\1\151\1\60\1\157\1\60\1\uffff\2\164\1\143\1\154\1\151\1\162\1\166\1\145\1\uffff\1\164\1\155\1\uffff\1\145\1\60\1\143\1\154\1\162\1\uffff\1\154\1\151\1\157\1\144\1\uffff\1\144\1\60\1\uffff\1\144\1\157\1\60\1\142\1\143\1\151\1\145\4\60\2\uffff\1\156\2\145\1\162\1\uffff\1\162\1\60\1\152\1\157\1\uffff\1\160\1\60\2\162\1\uffff\1\141\1\145\1\143\1\145\1\60\1\162\1\145\1\166\1\145\1\160\1\141\1\uffff\2\60\1\146\1\uffff\1\147\1\uffff\1\145\1\151\1\164\1\60\3\145\1\162\1\163\1\145\1\137\1\uffff\1\145\1\60\1\165\2\145\1\156\2\60\1\uffff\2\60\1\162\1\uffff\1\151\1\141\1\157\1\162\4\uffff\1\60\1\144\2\uffff\1\166\1\171\1\uffff\1\145\1\162\1\164\1\uffff\1\60\1\145\1\154\1\143\1\141\1\156\1\uffff\1\155\1\163\1\145\1\162\1\145\1\162\2\uffff\2\151\1\60\1\157\1\165\1\60\1\uffff\1\163\2\60\1\163\1\60\1\156\1\160\1\60\1\uffff\1\143\1\60\1\162\1\60\4\uffff\1\171\1\154\1\164\1\156\1\163\1\154\3\uffff\1\151\1\60\1\143\1\60\1\171\1\uffff\2\60\3\164\1\141\1\60\1\156\1\166\1\162\1\141\1\145\1\60\1\145\1\uffff\1\156\1\162\1\uffff\1\60\2\uffff\1\60\1\uffff\1\164\1\141\1\60\1\uffff\1\164\1\uffff\2\60\1\uffff\1\60\2\151\3\60\1\143\1\uffff\1\164\1\uffff\1\60\2\uffff\1\106\1\151\1\60\1\164\1\uffff\1\164\1\151\1\141\1\155\1\144\1\uffff\1\163\1\123\1\145\2\uffff\1\163\1\164\1\uffff\1\165\3\uffff\1\164\1\157\3\uffff\1\145\1\60\1\uffff\1\162\1\157\1\uffff\2\60\1\143\1\164\1\145\2\60\1\145\2\60\1\164\1\162\1\171\1\156\1\60\1\uffff\1\145\1\156\2\uffff\1\145\1\151\1\164\2\uffff\1\162\2\uffff\2\145\1\60\1\137\1\60\1\uffff\1\145\2\60\1\157\1\145\1\166\1\162\1\60\1\uffff\1\164\1\uffff\1\60\2\uffff\1\156\1\162\1\151\1\156\1\145\1\uffff\1\171\1\uffff\2\163\1\143\1\60\1\162\1\160\2\60\1\145\1\uffff\1\166\1\145\2\uffff\1\60\1\151\1\60\1\uffff\1\143\1\uffff\1\145\1\60\1\uffff";
    static final String DFA15_maxS =
        "\1\uffff\1\171\1\uffff\1\163\1\51\1\72\1\165\1\170\1\156\1\165\1\145\1\uffff\1\157\1\76\1\uffff\1\173\2\uffff\1\165\1\162\1\151\1\145\1\uffff\1\157\1\uffff\1\55\1\uffff\1\57\1\171\1\157\1\151\1\171\1\151\1\157\1\164\2\uffff\1\71\1\172\3\uffff\1\160\1\143\1\165\2\uffff\1\172\1\147\1\160\1\143\4\uffff\1\157\1\162\1\142\1\166\1\164\1\172\1\160\1\145\1\172\1\164\1\172\1\164\1\uffff\1\156\1\157\1\141\1\uffff\1\55\7\uffff\1\157\1\165\1\162\1\145\1\156\1\157\1\uffff\1\145\1\uffff\1\143\1\164\1\162\1\154\1\uffff\1\151\1\166\1\uffff\1\76\5\uffff\1\162\1\156\1\162\1\156\1\145\1\157\1\160\1\164\1\165\1\164\1\163\1\157\1\164\1\144\1\156\1\151\1\163\1\uffff\2\71\1\uffff\1\145\1\150\2\145\1\156\1\uffff\1\162\1\154\1\150\1\164\1\155\1\164\1\154\1\160\2\151\1\155\1\150\1\145\1\172\1\162\1\165\1\uffff\1\157\1\165\1\156\1\162\1\uffff\1\172\1\uffff\1\145\2\165\1\157\1\160\1\154\1\164\1\163\1\162\2\uffff\1\155\1\154\1\164\1\163\1\172\1\154\1\143\1\141\1\164\2\162\1\144\1\163\1\165\1\155\1\145\2\uffff\1\166\1\145\1\143\1\165\1\147\1\145\1\143\1\162\1\154\1\141\1\145\1\141\1\142\1\150\1\145\1\154\2\145\1\147\1\154\1\160\1\uffff\1\172\1\156\1\172\2\143\1\145\2\151\1\157\2\145\1\151\1\155\1\172\1\151\1\157\1\162\1\164\1\172\1\141\1\156\1\162\1\uffff\1\141\1\164\1\162\2\164\1\141\1\uffff\2\162\1\151\1\163\1\154\1\165\2\145\1\165\2\172\1\164\1\157\1\145\1\141\1\uffff\1\144\2\164\2\165\1\157\1\151\1\141\1\151\1\145\1\144\1\160\1\162\1\151\1\143\1\172\1\143\1\156\1\154\1\105\1\151\1\164\1\157\1\165\2\172\1\151\1\154\1\172\1\144\1\145\3\172\1\151\2\145\1\172\1\uffff\1\157\1\uffff\1\164\1\172\1\147\1\143\1\164\1\143\1\162\1\144\1\164\1\172\1\uffff\1\143\1\151\1\157\1\171\1\uffff\1\156\1\144\1\156\1\163\1\172\1\164\1\141\1\151\1\164\1\163\1\156\1\162\1\151\1\145\1\164\1\156\1\143\1\151\1\170\1\162\2\uffff\1\172\1\162\1\172\1\164\1\163\1\151\1\172\1\151\1\162\1\163\1\170\1\164\1\157\1\117\1\141\1\154\1\105\1\143\1\164\1\uffff\1\164\1\147\1\145\2\146\1\172\1\171\1\154\1\146\1\171\2\uffff\1\156\1\145\1\uffff\1\172\1\141\3\uffff\1\164\1\143\1\146\1\uffff\1\154\1\172\1\uffff\2\141\1\145\1\157\1\164\1\165\1\151\1\164\1\uffff\1\172\2\156\1\172\1\147\1\163\2\141\1\164\1\uffff\1\172\1\142\1\146\1\151\1\145\2\172\1\145\1\164\1\170\2\151\1\164\1\156\1\164\1\145\1\uffff\1\171\2\172\1\157\1\uffff\1\162\1\156\1\145\1\172\1\157\1\156\1\142\1\164\1\172\1\155\1\145\1\157\1\165\1\172\1\166\1\146\1\151\1\uffff\1\155\1\164\1\157\1\160\1\123\1\172\1\uffff\1\156\1\171\1\151\1\172\1\157\1\172\1\uffff\2\164\1\143\1\154\1\151\1\162\1\166\1\145\1\uffff\1\164\1\155\1\uffff\1\145\1\172\1\143\1\154\1\162\1\uffff\1\154\1\151\1\157\1\144\1\uffff\1\144\1\172\1\uffff\1\163\1\157\1\172\1\142\1\143\1\151\1\145\4\172\2\uffff\1\156\1\145\1\163\1\162\1\uffff\1\162\1\172\1\152\1\157\1\uffff\1\160\1\172\2\162\1\uffff\1\141\1\145\1\143\1\145\1\172\1\162\1\145\1\166\1\145\1\160\1\141\1\uffff\2\172\1\146\1\uffff\1\147\1\uffff\1\145\1\151\1\164\1\172\3\145\1\162\1\163\1\145\1\137\1\uffff\1\145\1\172\1\165\2\145\1\156\2\172\1\uffff\2\172\1\162\1\uffff\1\151\1\141\1\157\1\162\4\uffff\1\172\1\163\2\uffff\1\166\1\171\1\uffff\1\145\1\162\1\164\1\uffff\1\172\1\145\1\154\1\143\1\141\1\156\1\uffff\1\155\1\163\1\145\1\162\1\145\1\162\2\uffff\1\151\1\171\1\172\1\157\1\165\1\172\1\uffff\1\163\2\172\1\163\1\172\1\156\1\160\1\172\1\uffff\1\143\1\172\1\162\1\172\4\uffff\1\171\1\154\1\164\1\156\1\163\1\154\3\uffff\1\151\1\172\1\143\1\172\1\171\1\uffff\2\172\3\164\1\141\1\172\1\156\1\166\1\162\1\141\1\145\1\172\1\145\1\uffff\1\156\1\162\1\uffff\1\172\2\uffff\1\172\1\uffff\1\164\1\141\1\172\1\uffff\1\164\1\uffff\2\172\1\uffff\1\172\2\151\3\172\1\143\1\uffff\1\164\1\uffff\1\172\2\uffff\1\106\1\151\1\172\1\164\1\uffff\1\164\1\151\1\141\1\155\1\144\1\uffff\1\163\1\123\1\145\2\uffff\1\163\1\164\1\uffff\1\165\3\uffff\1\164\1\157\3\uffff\1\145\1\172\1\uffff\1\162\1\157\1\uffff\2\172\1\143\1\164\1\145\2\172\1\145\2\172\1\164\1\162\1\171\1\156\1\172\1\uffff\1\145\1\156\2\uffff\1\145\1\151\1\164\2\uffff\1\162\2\uffff\2\145\1\172\1\137\1\172\1\uffff\1\145\2\172\1\157\1\145\1\166\1\162\1\172\1\uffff\1\164\1\uffff\1\172\2\uffff\1\156\1\162\1\151\1\156\1\145\1\uffff\1\171\1\uffff\2\163\1\143\1\172\1\162\1\160\2\172\1\145\1\uffff\1\166\1\145\2\uffff\1\172\1\151\1\172\1\uffff\1\143\1\uffff\1\145\1\172\1\uffff";
    static final String DFA15_acceptS =
        "\2\uffff\1\2\10\uffff\1\16\2\uffff\1\21\1\uffff\1\25\1\26\4\uffff\1\45\1\uffff\1\57\1\uffff\1\61\14\uffff\1\u008b\1\u008e\1\u008f\3\uffff\1\u008b\1\2\4\uffff\1\34\1\4\1\5\1\15\14\uffff\1\16\3\uffff\1\20\1\uffff\1\62\1\u0089\1\21\1\33\1\24\1\25\1\26\6\uffff\1\50\1\uffff\1\32\4\uffff\1\45\2\uffff\1\57\1\uffff\1\60\1\61\1\u008c\1\u008d\1\64\21\uffff\1\u0087\2\uffff\1\u008e\5\uffff\1\31\20\uffff\1\101\4\uffff\1\22\1\uffff\1\107\11\uffff\1\47\1\63\20\uffff\1\113\1\112\25\uffff\1\u0088\26\uffff\1\167\6\uffff\1\102\17\uffff\1\126\46\uffff\1\1\1\uffff\1\u008a\12\uffff\1\150\4\uffff\1\153\24\uffff\1\163\1\30\23\uffff\1\104\12\uffff\1\74\1\164\2\uffff\1\77\2\uffff\1\162\1\151\1\170\3\uffff\1\65\2\uffff\1\105\10\uffff\1\u0081\11\uffff\1\103\20\uffff\1\56\4\uffff\1\166\21\uffff\1\171\6\uffff\1\106\6\uffff\1\125\10\uffff\1\175\2\uffff\1\137\5\uffff\1\27\4\uffff\1\55\2\uffff\1\23\13\uffff\1\100\1\120\4\uffff\1\67\4\uffff\1\46\4\uffff\1\172\13\uffff\1\165\3\uffff\1\44\1\uffff\1\3\13\uffff\1\145\10\uffff\1\u0080\3\uffff\1\17\4\uffff\1\132\1\154\1\140\1\75\2\uffff\1\53\1\54\2\uffff\1\36\3\uffff\1\70\6\uffff\1\76\6\uffff\1\161\1\u0083\6\uffff\1\123\10\uffff\1\173\4\uffff\1\13\1\177\1\37\1\176\6\uffff\1\157\1\51\1\52\5\uffff\1\130\16\uffff\1\133\2\uffff\1\6\1\uffff\1\160\1\14\1\uffff\1\7\3\uffff\1\10\1\uffff\1\152\2\uffff\1\11\7\uffff\1\116\1\uffff\1\156\1\uffff\1\111\1\117\4\uffff\1\131\5\uffff\1\43\3\uffff\1\115\1\12\2\uffff\1\41\1\uffff\1\146\1\42\1\142\2\uffff\1\110\1\127\1\u0082\2\uffff\1\147\2\uffff\1\71\17\uffff\1\144\2\uffff\1\124\1\135\3\uffff\1\u0084\1\72\1\uffff\1\174\1\114\5\uffff\1\35\10\uffff\1\66\1\uffff\1\40\1\uffff\1\143\1\136\5\uffff\1\73\1\uffff\1\155\11\uffff\1\121\2\uffff\1\u0085\1\u0086\3\uffff\1\134\1\uffff\1\122\2\uffff\1\141";
    static final String DFA15_specialS =
        "\1\0\42\uffff\1\1\1\2\u02e5\uffff}>";
    static final String[] DFA15_transitionS = {
            "\11\51\2\50\2\51\1\50\22\51\1\50\1\51\1\43\4\51\1\44\1\17\1\20\2\51\1\21\1\15\1\16\1\33\12\45\1\5\1\13\1\31\1\26\1\32\1\30\1\23\32\47\3\51\1\46\1\47\1\51\1\3\1\37\1\14\1\35\1\7\1\22\1\47\1\40\1\10\2\47\1\41\1\24\1\27\1\11\1\6\1\47\1\12\1\34\1\1\1\42\1\25\1\36\3\47\1\2\1\51\1\4\uff82\51",
            "\1\53\14\uffff\1\54\6\uffff\1\52",
            "",
            "\1\60\10\uffff\1\61\1\uffff\1\62\1\57",
            "\1\63",
            "\1\65",
            "\1\70\20\uffff\1\67\2\uffff\1\71",
            "\1\72\11\uffff\1\73",
            "\1\76\10\uffff\1\75\1\74",
            "\1\101\1\uffff\1\77\4\uffff\1\100",
            "\1\102",
            "",
            "\1\106\3\uffff\1\105\2\uffff\1\104",
            "\1\110\2\uffff\12\112\4\uffff\1\107",
            "",
            "\1\114",
            "",
            "",
            "\1\121\7\uffff\1\123\2\uffff\1\125\2\uffff\1\122\2\uffff\1\120\2\uffff\1\124",
            "\1\126\1\uffff\1\127",
            "\1\132\7\uffff\1\131",
            "\1\134\3\uffff\1\133",
            "",
            "\1\137\11\uffff\1\136",
            "",
            "\1\141",
            "",
            "\1\144\4\uffff\1\145",
            "\1\147\2\uffff\1\154\1\152\6\uffff\1\153\3\uffff\1\151\4\uffff\1\150",
            "\1\156\3\uffff\1\155\11\uffff\1\157",
            "\1\160",
            "\1\161\15\uffff\1\162\11\uffff\1\163",
            "\1\164",
            "\1\165",
            "\1\167\5\uffff\1\166",
            "\0\170",
            "\0\170",
            "\1\171\1\uffff\12\172",
            "\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "",
            "",
            "\1\174",
            "\1\175",
            "\1\176",
            "",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\17\55\1\177\10\55\1\u0080\1\55",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "",
            "",
            "",
            "",
            "\1\u0086\5\uffff\1\u0085",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089\17\uffff\1\u008b\1\u008c\1\u008a",
            "\1\u008d\20\uffff\1\u008e",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\5\55\1\u0090\10\55\1\u0091\4\55\1\u008f\6\55",
            "\1\u0094\2\uffff\1\u0093",
            "\1\u0095",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\4\55\1\u0096\25\55",
            "\1\u0098",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u009a\11\uffff\1\u009d\1\u009c\2\uffff\1\u009b",
            "",
            "\1\u009f\1\u009e\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "",
            "\1\u00a3",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00a5",
            "\1\u00a7\10\uffff\1\u00a8\10\uffff\1\u00a6",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "",
            "\1\u00ad",
            "",
            "\1\u00ae",
            "\1\u00b0\5\uffff\1\u00af",
            "\1\u00b1",
            "\1\u00b2",
            "",
            "\1\u00b3",
            "\1\u00b4",
            "",
            "\1\u00b5",
            "",
            "",
            "",
            "",
            "",
            "\1\u00b8\5\uffff\1\u00b7",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bc\11\uffff\1\u00bb",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00c0\11\uffff\1\u00bf",
            "\1\u00c1",
            "\1\u00c2\7\uffff\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "",
            "\12\112",
            "\1\171\1\uffff\12\172",
            "",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d7\14\uffff\1\u00d6\3\uffff\1\u00d5",
            "\1\u00d8",
            "\1\u00d9\22\uffff\1\u00da",
            "\1\u00db",
            "\1\u00dc",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\4\55\1\u00e2\25\55",
            "\1\u00e4",
            "\1\u00e5",
            "",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
            "\1\u00e9",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00f0\2\uffff\1\u00ef",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "",
            "",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "\1\u00f8",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\14\55\1\u00f9\15\55",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe\2\uffff\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "\1\u0102",
            "\1\u0103",
            "\1\u0105\13\uffff\1\u0104",
            "\1\u0106",
            "\1\u0107",
            "",
            "",
            "\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "\1\u010c\13\uffff\1\u010b",
            "\1\u010d",
            "\1\u010e",
            "\1\u010f",
            "\1\u0110",
            "\1\u0111",
            "\1\u0112",
            "\1\u0113\3\uffff\1\u0114",
            "\1\u0115",
            "\1\u0116",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119",
            "\1\u011a",
            "\1\u011b",
            "\1\u011c",
            "\1\u011d",
            "\1\u011e",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\3\55\1\u011f\16\55\1\u0120\7\55",
            "\1\u0122",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
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
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u012f",
            "\1\u0130",
            "\1\u0131",
            "\1\u0132",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0134",
            "\1\u0135",
            "\1\u0136",
            "",
            "\1\u0137",
            "\1\u0138",
            "\1\u0139",
            "\1\u013a",
            "\1\u013b",
            "\1\u013c",
            "",
            "\1\u013d",
            "\1\u013e",
            "\1\u013f",
            "\1\u0140",
            "\1\u0142\12\uffff\1\u0141",
            "\1\u0143",
            "\1\u0144",
            "\1\u0145\3\uffff\1\u0146",
            "\1\u0147",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u014a",
            "\1\u014b",
            "\1\u014c",
            "\1\u014d",
            "",
            "\1\u014e",
            "\1\u014f",
            "\1\u0150",
            "\1\u0151",
            "\1\u0152",
            "\1\u0153",
            "\1\u0154",
            "\1\u0155",
            "\1\u0156",
            "\1\u0157",
            "\1\u0158",
            "\1\u0159",
            "\1\u015a",
            "\1\u015b",
            "\1\u015c",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u015e",
            "\1\u015f",
            "\1\u0160",
            "\1\u0161",
            "\1\u0162",
            "\1\u0163",
            "\1\u0164",
            "\1\u0165",
            "\12\55\7\uffff\32\55\4\uffff\1\u0166\1\uffff\23\55\1\u0167\6\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u016a",
            "\1\u016b",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u016d",
            "\1\u016e",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0172",
            "\1\u0173",
            "\1\u0174",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u0176",
            "",
            "\1\u0177",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0179",
            "\1\u017a",
            "\1\u017b",
            "\1\u017c",
            "\1\u017d",
            "\1\u017e",
            "\1\u017f",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\4\55\1\u0180\25\55",
            "",
            "\1\u0182",
            "\1\u0183",
            "\1\u0184",
            "\1\u0185",
            "",
            "\1\u0186",
            "\1\u0187",
            "\1\u0188\7\uffff\1\u0189",
            "\1\u018a",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u018c",
            "\1\u018d",
            "\1\u018e",
            "\1\u018f",
            "\1\u0190\1\u0191",
            "\1\u0192",
            "\1\u0193",
            "\1\u0194",
            "\1\u0195",
            "\1\u0196",
            "\1\u0197",
            "\1\u0198",
            "\1\u0199",
            "\1\u019a",
            "\1\u019b",
            "",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u019d",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u019e",
            "\1\u019f",
            "\1\u01a0",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u01a2",
            "\1\u01a3",
            "\1\u01a4",
            "\1\u01a5",
            "\1\u01a6",
            "\1\u01a7",
            "\1\u01a8",
            "\1\u01a9",
            "\1\u01aa",
            "\1\u01ab",
            "\1\u01ac",
            "\1\u01ad",
            "",
            "\1\u01ae",
            "\1\u01af",
            "\1\u01b0",
            "\1\u01b1",
            "\1\u01b2",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u01b4",
            "\1\u01b5",
            "\1\u01b6",
            "\1\u01b7",
            "",
            "",
            "\1\u01b8",
            "\1\u01b9",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u01bb",
            "",
            "",
            "",
            "\1\u01bc",
            "\1\u01bd",
            "\1\u01be",
            "",
            "\1\u01bf",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\22\55\1\u01c0\7\55",
            "",
            "\1\u01c2",
            "\1\u01c3",
            "\1\u01c4",
            "\1\u01c5",
            "\1\u01c6",
            "\1\u01c7",
            "\1\u01c8",
            "\1\u01c9",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u01cb",
            "\1\u01cc",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u01ce",
            "\1\u01cf",
            "\1\u01d0",
            "\1\u01d1",
            "\1\u01d2",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u01d4",
            "\1\u01d5",
            "\1\u01d6",
            "\1\u01d7",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\4\55\1\u01d9\15\55\1\u01da\7\55",
            "\1\u01dc",
            "\1\u01dd",
            "\1\u01de",
            "\1\u01df",
            "\1\u01e0",
            "\1\u01e1",
            "\1\u01e2",
            "\1\u01e3",
            "\1\u01e4",
            "",
            "\1\u01e5",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\22\55\1\u01e6\7\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u01e9",
            "",
            "\1\u01ea",
            "\1\u01eb",
            "\1\u01ec",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u01ee",
            "\1\u01ef",
            "\1\u01f0",
            "\1\u01f1",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u01f3",
            "\1\u01f4",
            "\1\u01f5",
            "\1\u01f6",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u01f8",
            "\1\u01f9",
            "\1\u01fa",
            "",
            "\1\u01fb",
            "\1\u01fc",
            "\1\u01fd",
            "\1\u01fe",
            "\1\u01ff\11\uffff\1\u0201\1\u0202\2\uffff\1\u0200",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u0204",
            "\1\u0205",
            "\1\u0206",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0208",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u020a",
            "\1\u020b",
            "\1\u020c",
            "\1\u020d",
            "\1\u020e",
            "\1\u020f",
            "\1\u0210",
            "\1\u0211",
            "",
            "\1\u0212",
            "\1\u0213",
            "",
            "\1\u0214",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0216",
            "\1\u0217",
            "\1\u0218",
            "",
            "\1\u0219",
            "\1\u021a",
            "\1\u021b",
            "\1\u021c",
            "",
            "\1\u021d",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u021f\16\uffff\1\u0220",
            "\1\u0221",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0223",
            "\1\u0224",
            "\1\u0225",
            "\1\u0226",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "",
            "\1\u022b",
            "\1\u022c",
            "\1\u022d\15\uffff\1\u022e",
            "\1\u022f",
            "",
            "\1\u0230",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0232",
            "\1\u0233",
            "",
            "\1\u0234",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0236",
            "\1\u0237",
            "",
            "\1\u0238",
            "\1\u0239",
            "\1\u023a",
            "\1\u023b",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u023d",
            "\1\u023e",
            "\1\u023f",
            "\1\u0240",
            "\1\u0241",
            "\1\u0242",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0245",
            "",
            "\1\u0246",
            "",
            "\1\u0247",
            "\1\u0248",
            "\1\u0249",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\22\55\1\u024a\7\55",
            "\1\u024c",
            "\1\u024d",
            "\1\u024e",
            "\1\u024f",
            "\1\u0250",
            "\1\u0251",
            "\1\u0252",
            "",
            "\1\u0253",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0255",
            "\1\u0256",
            "\1\u0257",
            "\1\u0258",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u025d",
            "",
            "\1\u025e",
            "\1\u025f",
            "\1\u0260",
            "\1\u0261",
            "",
            "",
            "",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\1\u0262\31\55",
            "\1\u0264\16\uffff\1\u0265",
            "",
            "",
            "\1\u0266",
            "\1\u0267",
            "",
            "\1\u0268",
            "\1\u0269",
            "\1\u026a",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u026c",
            "\1\u026d",
            "\1\u026e",
            "\1\u026f",
            "\1\u0270",
            "",
            "\1\u0271",
            "\1\u0272",
            "\1\u0273",
            "\1\u0274",
            "\1\u0275",
            "\1\u0276",
            "",
            "",
            "\1\u0277",
            "\1\u0279\17\uffff\1\u0278",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u027b",
            "\1\u027c",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u027e",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0281",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0283",
            "\1\u0284",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\22\55\1\u0285\7\55",
            "",
            "\1\u0287",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0289",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\22\55\1\u028a\7\55",
            "",
            "",
            "",
            "",
            "\1\u028c",
            "\1\u028d",
            "\1\u028e",
            "\1\u028f",
            "\1\u0290",
            "\1\u0291",
            "",
            "",
            "",
            "\1\u0292",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0294",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0296",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0299",
            "\1\u029a",
            "\1\u029b",
            "\1\u029c",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u029e",
            "\1\u029f",
            "\1\u02a0",
            "\1\u02a1",
            "\1\u02a2",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u02a4",
            "",
            "\1\u02a5",
            "\1\u02a6",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u02a9",
            "\1\u02aa",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u02ac",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u02b0",
            "\1\u02b1",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u02b5",
            "",
            "\1\u02b6",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "",
            "\1\u02b8",
            "\1\u02b9",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u02bb",
            "",
            "\1\u02bc",
            "\1\u02bd",
            "\1\u02be",
            "\1\u02bf",
            "\1\u02c0",
            "",
            "\1\u02c1",
            "\1\u02c2",
            "\1\u02c3",
            "",
            "",
            "\1\u02c4",
            "\1\u02c5",
            "",
            "\1\u02c6",
            "",
            "",
            "",
            "\1\u02c7",
            "\1\u02c8",
            "",
            "",
            "",
            "\1\u02c9",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u02cb",
            "\1\u02cc",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u02cf",
            "\1\u02d0",
            "\1\u02d1",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u02d4",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u02d7",
            "\1\u02d8",
            "\1\u02d9",
            "\1\u02da",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\22\55\1\u02db\7\55",
            "",
            "\1\u02dd",
            "\1\u02de",
            "",
            "",
            "\1\u02df",
            "\1\u02e0",
            "\1\u02e1",
            "",
            "",
            "\1\u02e2",
            "",
            "",
            "\1\u02e3",
            "\1\u02e4",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u02e6",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u02e8",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u02eb",
            "\1\u02ec",
            "\1\u02ed",
            "\1\u02ee",
            "\12\55\7\uffff\22\55\1\u02ef\7\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u02f1",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "",
            "\1\u02f3",
            "\1\u02f4",
            "\1\u02f5",
            "\1\u02f6",
            "\1\u02f7",
            "",
            "\1\u02f8",
            "",
            "\1\u02f9",
            "\1\u02fa",
            "\1\u02fb",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u02fd",
            "\1\u02fe",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0301",
            "",
            "\1\u0302",
            "\1\u0303",
            "",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0305",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u0307",
            "",
            "\1\u0308",
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
            return "1:1: Tokens : ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | T__129 | T__130 | T__131 | T__132 | T__133 | T__134 | T__135 | T__136 | T__137 | T__138 | T__139 | T__140 | T__141 | T__142 | T__143 | T__144 | T__145 | T__146 | T__147 | RULE_STRING | RULE_NUMBER_WITH_TRAILING_PERIOD | RULE_BIG_DECIMAL | RULE_BOOLEAN | RULE_ID | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
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

                        else if ( (LA15_0=='a') ) {s = 3;}

                        else if ( (LA15_0=='}') ) {s = 4;}

                        else if ( (LA15_0==':') ) {s = 5;}

                        else if ( (LA15_0=='p') ) {s = 6;}

                        else if ( (LA15_0=='e') ) {s = 7;}

                        else if ( (LA15_0=='i') ) {s = 8;}

                        else if ( (LA15_0=='o') ) {s = 9;}

                        else if ( (LA15_0=='r') ) {s = 10;}

                        else if ( (LA15_0==';') ) {s = 11;}

                        else if ( (LA15_0=='c') ) {s = 12;}

                        else if ( (LA15_0=='-') ) {s = 13;}

                        else if ( (LA15_0=='.') ) {s = 14;}

                        else if ( (LA15_0=='(') ) {s = 15;}

                        else if ( (LA15_0==')') ) {s = 16;}

                        else if ( (LA15_0==',') ) {s = 17;}

                        else if ( (LA15_0=='f') ) {s = 18;}

                        else if ( (LA15_0=='@') ) {s = 19;}

                        else if ( (LA15_0=='m') ) {s = 20;}

                        else if ( (LA15_0=='v') ) {s = 21;}

                        else if ( (LA15_0=='=') ) {s = 22;}

                        else if ( (LA15_0=='n') ) {s = 23;}

                        else if ( (LA15_0=='?') ) {s = 24;}

                        else if ( (LA15_0=='<') ) {s = 25;}

                        else if ( (LA15_0=='>') ) {s = 26;}

                        else if ( (LA15_0=='/') ) {s = 27;}

                        else if ( (LA15_0=='s') ) {s = 28;}

                        else if ( (LA15_0=='d') ) {s = 29;}

                        else if ( (LA15_0=='w') ) {s = 30;}

                        else if ( (LA15_0=='b') ) {s = 31;}

                        else if ( (LA15_0=='h') ) {s = 32;}

                        else if ( (LA15_0=='l') ) {s = 33;}

                        else if ( (LA15_0=='u') ) {s = 34;}

                        else if ( (LA15_0=='\"') ) {s = 35;}

                        else if ( (LA15_0=='\'') ) {s = 36;}

                        else if ( ((LA15_0>='0' && LA15_0<='9')) ) {s = 37;}

                        else if ( (LA15_0=='^') ) {s = 38;}

                        else if ( ((LA15_0>='A' && LA15_0<='Z')||LA15_0=='_'||LA15_0=='g'||(LA15_0>='j' && LA15_0<='k')||LA15_0=='q'||(LA15_0>='x' && LA15_0<='z')) ) {s = 39;}

                        else if ( ((LA15_0>='\t' && LA15_0<='\n')||LA15_0=='\r'||LA15_0==' ') ) {s = 40;}

                        else if ( ((LA15_0>='\u0000' && LA15_0<='\b')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='\u001F')||LA15_0=='!'||(LA15_0>='#' && LA15_0<='&')||(LA15_0>='*' && LA15_0<='+')||(LA15_0>='[' && LA15_0<=']')||LA15_0=='`'||LA15_0=='|'||(LA15_0>='~' && LA15_0<='\uFFFF')) ) {s = 41;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA15_35 = input.LA(1);

                        s = -1;
                        if ( ((LA15_35>='\u0000' && LA15_35<='\uFFFF')) ) {s = 120;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA15_36 = input.LA(1);

                        s = -1;
                        if ( ((LA15_36>='\u0000' && LA15_36<='\uFFFF')) ) {s = 120;}

                        else s = 41;

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