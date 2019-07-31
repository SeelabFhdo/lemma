package de.fhdo.lemma.data.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDataDslLexer extends Lexer {
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
    public static final int RULE_ID=5;
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
    public static final int RULE_STRING=4;
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

    public InternalDataDslLexer() {;} 
    public InternalDataDslLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalDataDslLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalDataDsl.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDsl.g:11:7: ( 'import' )
            // InternalDataDsl.g:11:9: 'import'
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
            // InternalDataDsl.g:12:7: ( 'datatypes' )
            // InternalDataDsl.g:12:9: 'datatypes'
            {
            match("datatypes"); 


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
            // InternalDataDsl.g:13:7: ( 'from' )
            // InternalDataDsl.g:13:9: 'from'
            {
            match("from"); 


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
            // InternalDataDsl.g:14:7: ( 'as' )
            // InternalDataDsl.g:14:9: 'as'
            {
            match("as"); 


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
            // InternalDataDsl.g:15:7: ( 'version' )
            // InternalDataDsl.g:15:9: 'version'
            {
            match("version"); 


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
            // InternalDataDsl.g:16:7: ( '{' )
            // InternalDataDsl.g:16:9: '{'
            {
            match('{'); 

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
            // InternalDataDsl.g:17:7: ( '}' )
            // InternalDataDsl.g:17:9: '}'
            {
            match('}'); 

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
            // InternalDataDsl.g:18:7: ( 'context' )
            // InternalDataDsl.g:18:9: 'context'
            {
            match("context"); 


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
            // InternalDataDsl.g:19:7: ( 'structure' )
            // InternalDataDsl.g:19:9: 'structure'
            {
            match("structure"); 


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
            // InternalDataDsl.g:20:7: ( '<' )
            // InternalDataDsl.g:20:9: '<'
            {
            match('<'); 

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
            // InternalDataDsl.g:21:7: ( ',' )
            // InternalDataDsl.g:21:9: ','
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
            // InternalDataDsl.g:22:7: ( '>' )
            // InternalDataDsl.g:22:9: '>'
            {
            match('>'); 

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
            // InternalDataDsl.g:23:7: ( 'extends' )
            // InternalDataDsl.g:23:9: 'extends'
            {
            match("extends"); 


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
            // InternalDataDsl.g:24:7: ( 'list' )
            // InternalDataDsl.g:24:9: 'list'
            {
            match("list"); 


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
            // InternalDataDsl.g:25:7: ( 'hide' )
            // InternalDataDsl.g:25:9: 'hide'
            {
            match("hide"); 


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
            // InternalDataDsl.g:26:7: ( 'immutable' )
            // InternalDataDsl.g:26:9: 'immutable'
            {
            match("immutable"); 


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
            // InternalDataDsl.g:27:7: ( 'enum' )
            // InternalDataDsl.g:27:9: 'enum'
            {
            match("enum"); 


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
            // InternalDataDsl.g:28:7: ( '(' )
            // InternalDataDsl.g:28:9: '('
            {
            match('('); 

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
            // InternalDataDsl.g:29:7: ( ')' )
            // InternalDataDsl.g:29:9: ')'
            {
            match(')'); 

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
            // InternalDataDsl.g:30:7: ( 'procedure' )
            // InternalDataDsl.g:30:9: 'procedure'
            {
            match("procedure"); 


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
            // InternalDataDsl.g:31:7: ( 'function' )
            // InternalDataDsl.g:31:9: 'function'
            {
            match("function"); 


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
            // InternalDataDsl.g:32:7: ( '::' )
            // InternalDataDsl.g:32:9: '::'
            {
            match("::"); 


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
            // InternalDataDsl.g:33:7: ( 'boolean' )
            // InternalDataDsl.g:33:9: 'boolean'
            {
            match("boolean"); 


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
            // InternalDataDsl.g:34:7: ( 'byte' )
            // InternalDataDsl.g:34:9: 'byte'
            {
            match("byte"); 


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
            // InternalDataDsl.g:35:7: ( 'char' )
            // InternalDataDsl.g:35:9: 'char'
            {
            match("char"); 


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
            // InternalDataDsl.g:36:7: ( 'date' )
            // InternalDataDsl.g:36:9: 'date'
            {
            match("date"); 


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
            // InternalDataDsl.g:37:7: ( 'double' )
            // InternalDataDsl.g:37:9: 'double'
            {
            match("double"); 


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
            // InternalDataDsl.g:38:7: ( 'float' )
            // InternalDataDsl.g:38:9: 'float'
            {
            match("float"); 


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
            // InternalDataDsl.g:39:7: ( 'int' )
            // InternalDataDsl.g:39:9: 'int'
            {
            match("int"); 


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
            // InternalDataDsl.g:40:7: ( 'long' )
            // InternalDataDsl.g:40:9: 'long'
            {
            match("long"); 


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
            // InternalDataDsl.g:41:7: ( 'short' )
            // InternalDataDsl.g:41:9: 'short'
            {
            match("short"); 


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
            // InternalDataDsl.g:42:7: ( 'string' )
            // InternalDataDsl.g:42:9: 'string'
            {
            match("string"); 


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
            // InternalDataDsl.g:43:7: ( '.' )
            // InternalDataDsl.g:43:9: '.'
            {
            match('.'); 

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
            // InternalDataDsl.g:44:7: ( 'aggregate' )
            // InternalDataDsl.g:44:9: 'aggregate'
            {
            match("aggregate"); 


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
            // InternalDataDsl.g:45:7: ( 'applicationService' )
            // InternalDataDsl.g:45:9: 'applicationService'
            {
            match("applicationService"); 


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
            // InternalDataDsl.g:46:7: ( 'domainEvent' )
            // InternalDataDsl.g:46:9: 'domainEvent'
            {
            match("domainEvent"); 


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
            // InternalDataDsl.g:47:7: ( 'domainService' )
            // InternalDataDsl.g:47:9: 'domainService'
            {
            match("domainService"); 


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
            // InternalDataDsl.g:48:7: ( 'entity' )
            // InternalDataDsl.g:48:9: 'entity'
            {
            match("entity"); 


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
            // InternalDataDsl.g:49:7: ( 'factory' )
            // InternalDataDsl.g:49:9: 'factory'
            {
            match("factory"); 


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
            // InternalDataDsl.g:50:7: ( 'infrastructureService' )
            // InternalDataDsl.g:50:9: 'infrastructureService'
            {
            match("infrastructureService"); 


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
            // InternalDataDsl.g:51:7: ( 'repository' )
            // InternalDataDsl.g:51:9: 'repository'
            {
            match("repository"); 


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
            // InternalDataDsl.g:52:7: ( 'service' )
            // InternalDataDsl.g:52:9: 'service'
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
            // InternalDataDsl.g:53:7: ( 'specification' )
            // InternalDataDsl.g:53:9: 'specification'
            {
            match("specification"); 


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
            // InternalDataDsl.g:54:7: ( 'valueObject' )
            // InternalDataDsl.g:54:9: 'valueObject'
            {
            match("valueObject"); 


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
            // InternalDataDsl.g:55:7: ( 'identifier' )
            // InternalDataDsl.g:55:9: 'identifier'
            {
            match("identifier"); 


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
            // InternalDataDsl.g:56:7: ( 'neverEmpty' )
            // InternalDataDsl.g:56:9: 'neverEmpty'
            {
            match("neverEmpty"); 


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
            // InternalDataDsl.g:57:7: ( 'part' )
            // InternalDataDsl.g:57:9: 'part'
            {
            match("part"); 


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
            // InternalDataDsl.g:58:7: ( 'closure' )
            // InternalDataDsl.g:58:9: 'closure'
            {
            match("closure"); 


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
            // InternalDataDsl.g:59:7: ( 'sideEffectFree' )
            // InternalDataDsl.g:59:9: 'sideEffectFree'
            {
            match("sideEffectFree"); 


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
            // InternalDataDsl.g:60:7: ( 'validator' )
            // InternalDataDsl.g:60:9: 'validator'
            {
            match("validator"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "RULE_BIG_DECIMAL"
    public final void mRULE_BIG_DECIMAL() throws RecognitionException {
        try {
            int _type = RULE_BIG_DECIMAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalDataDsl.g:1972:18: ( ( '-' )? RULE_INT ( '.' RULE_INT )? )
            // InternalDataDsl.g:1972:20: ( '-' )? RULE_INT ( '.' RULE_INT )?
            {
            // InternalDataDsl.g:1972:20: ( '-' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='-') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalDataDsl.g:1972:20: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            mRULE_INT(); 
            // InternalDataDsl.g:1972:34: ( '.' RULE_INT )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='.') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalDataDsl.g:1972:35: '.' RULE_INT
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
            // InternalDataDsl.g:1974:14: ( ( 'true' | 'false' ) )
            // InternalDataDsl.g:1974:16: ( 'true' | 'false' )
            {
            // InternalDataDsl.g:1974:16: ( 'true' | 'false' )
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
                    // InternalDataDsl.g:1974:17: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // InternalDataDsl.g:1974:24: 'false'
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
            // InternalDataDsl.g:1976:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalDataDsl.g:1976:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalDataDsl.g:1976:11: ( '^' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='^') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalDataDsl.g:1976:11: '^'
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

            // InternalDataDsl.g:1976:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')||(LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalDataDsl.g:
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
            // InternalDataDsl.g:1978:19: ( ( '0' .. '9' )+ )
            // InternalDataDsl.g:1978:21: ( '0' .. '9' )+
            {
            // InternalDataDsl.g:1978:21: ( '0' .. '9' )+
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
            	    // InternalDataDsl.g:1978:22: '0' .. '9'
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
            // InternalDataDsl.g:1980:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalDataDsl.g:1980:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalDataDsl.g:1980:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // InternalDataDsl.g:1980:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalDataDsl.g:1980:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // InternalDataDsl.g:1980:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalDataDsl.g:1980:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // InternalDataDsl.g:1980:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalDataDsl.g:1980:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // InternalDataDsl.g:1980:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalDataDsl.g:1980:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // InternalDataDsl.g:1982:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalDataDsl.g:1982:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalDataDsl.g:1982:24: ( options {greedy=false; } : . )*
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
            	    // InternalDataDsl.g:1982:52: .
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
            // InternalDataDsl.g:1984:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalDataDsl.g:1984:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalDataDsl.g:1984:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\u0000' && LA11_0<='\t')||(LA11_0>='\u000B' && LA11_0<='\f')||(LA11_0>='\u000E' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalDataDsl.g:1984:24: ~ ( ( '\\n' | '\\r' ) )
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

            // InternalDataDsl.g:1984:40: ( ( '\\r' )? '\\n' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\n'||LA13_0=='\r') ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalDataDsl.g:1984:41: ( '\\r' )? '\\n'
                    {
                    // InternalDataDsl.g:1984:41: ( '\\r' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='\r') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalDataDsl.g:1984:41: '\\r'
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
            // InternalDataDsl.g:1986:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalDataDsl.g:1986:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalDataDsl.g:1986:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // InternalDataDsl.g:
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
            // InternalDataDsl.g:1988:16: ( . )
            // InternalDataDsl.g:1988:18: .
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
        // InternalDataDsl.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | RULE_BIG_DECIMAL | RULE_BOOLEAN | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt15=58;
        alt15 = dfa15.predict(input);
        switch (alt15) {
            case 1 :
                // InternalDataDsl.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // InternalDataDsl.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // InternalDataDsl.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // InternalDataDsl.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // InternalDataDsl.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // InternalDataDsl.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // InternalDataDsl.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // InternalDataDsl.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // InternalDataDsl.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // InternalDataDsl.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // InternalDataDsl.g:1:70: T__23
                {
                mT__23(); 

                }
                break;
            case 12 :
                // InternalDataDsl.g:1:76: T__24
                {
                mT__24(); 

                }
                break;
            case 13 :
                // InternalDataDsl.g:1:82: T__25
                {
                mT__25(); 

                }
                break;
            case 14 :
                // InternalDataDsl.g:1:88: T__26
                {
                mT__26(); 

                }
                break;
            case 15 :
                // InternalDataDsl.g:1:94: T__27
                {
                mT__27(); 

                }
                break;
            case 16 :
                // InternalDataDsl.g:1:100: T__28
                {
                mT__28(); 

                }
                break;
            case 17 :
                // InternalDataDsl.g:1:106: T__29
                {
                mT__29(); 

                }
                break;
            case 18 :
                // InternalDataDsl.g:1:112: T__30
                {
                mT__30(); 

                }
                break;
            case 19 :
                // InternalDataDsl.g:1:118: T__31
                {
                mT__31(); 

                }
                break;
            case 20 :
                // InternalDataDsl.g:1:124: T__32
                {
                mT__32(); 

                }
                break;
            case 21 :
                // InternalDataDsl.g:1:130: T__33
                {
                mT__33(); 

                }
                break;
            case 22 :
                // InternalDataDsl.g:1:136: T__34
                {
                mT__34(); 

                }
                break;
            case 23 :
                // InternalDataDsl.g:1:142: T__35
                {
                mT__35(); 

                }
                break;
            case 24 :
                // InternalDataDsl.g:1:148: T__36
                {
                mT__36(); 

                }
                break;
            case 25 :
                // InternalDataDsl.g:1:154: T__37
                {
                mT__37(); 

                }
                break;
            case 26 :
                // InternalDataDsl.g:1:160: T__38
                {
                mT__38(); 

                }
                break;
            case 27 :
                // InternalDataDsl.g:1:166: T__39
                {
                mT__39(); 

                }
                break;
            case 28 :
                // InternalDataDsl.g:1:172: T__40
                {
                mT__40(); 

                }
                break;
            case 29 :
                // InternalDataDsl.g:1:178: T__41
                {
                mT__41(); 

                }
                break;
            case 30 :
                // InternalDataDsl.g:1:184: T__42
                {
                mT__42(); 

                }
                break;
            case 31 :
                // InternalDataDsl.g:1:190: T__43
                {
                mT__43(); 

                }
                break;
            case 32 :
                // InternalDataDsl.g:1:196: T__44
                {
                mT__44(); 

                }
                break;
            case 33 :
                // InternalDataDsl.g:1:202: T__45
                {
                mT__45(); 

                }
                break;
            case 34 :
                // InternalDataDsl.g:1:208: T__46
                {
                mT__46(); 

                }
                break;
            case 35 :
                // InternalDataDsl.g:1:214: T__47
                {
                mT__47(); 

                }
                break;
            case 36 :
                // InternalDataDsl.g:1:220: T__48
                {
                mT__48(); 

                }
                break;
            case 37 :
                // InternalDataDsl.g:1:226: T__49
                {
                mT__49(); 

                }
                break;
            case 38 :
                // InternalDataDsl.g:1:232: T__50
                {
                mT__50(); 

                }
                break;
            case 39 :
                // InternalDataDsl.g:1:238: T__51
                {
                mT__51(); 

                }
                break;
            case 40 :
                // InternalDataDsl.g:1:244: T__52
                {
                mT__52(); 

                }
                break;
            case 41 :
                // InternalDataDsl.g:1:250: T__53
                {
                mT__53(); 

                }
                break;
            case 42 :
                // InternalDataDsl.g:1:256: T__54
                {
                mT__54(); 

                }
                break;
            case 43 :
                // InternalDataDsl.g:1:262: T__55
                {
                mT__55(); 

                }
                break;
            case 44 :
                // InternalDataDsl.g:1:268: T__56
                {
                mT__56(); 

                }
                break;
            case 45 :
                // InternalDataDsl.g:1:274: T__57
                {
                mT__57(); 

                }
                break;
            case 46 :
                // InternalDataDsl.g:1:280: T__58
                {
                mT__58(); 

                }
                break;
            case 47 :
                // InternalDataDsl.g:1:286: T__59
                {
                mT__59(); 

                }
                break;
            case 48 :
                // InternalDataDsl.g:1:292: T__60
                {
                mT__60(); 

                }
                break;
            case 49 :
                // InternalDataDsl.g:1:298: T__61
                {
                mT__61(); 

                }
                break;
            case 50 :
                // InternalDataDsl.g:1:304: T__62
                {
                mT__62(); 

                }
                break;
            case 51 :
                // InternalDataDsl.g:1:310: RULE_BIG_DECIMAL
                {
                mRULE_BIG_DECIMAL(); 

                }
                break;
            case 52 :
                // InternalDataDsl.g:1:327: RULE_BOOLEAN
                {
                mRULE_BOOLEAN(); 

                }
                break;
            case 53 :
                // InternalDataDsl.g:1:340: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 54 :
                // InternalDataDsl.g:1:348: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 55 :
                // InternalDataDsl.g:1:360: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 56 :
                // InternalDataDsl.g:1:376: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 57 :
                // InternalDataDsl.g:1:392: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 58 :
                // InternalDataDsl.g:1:400: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA15_eotS =
        "\1\uffff\5\45\2\uffff\2\45\3\uffff\3\45\2\uffff\1\45\1\41\1\45\1\uffff\2\45\1\41\1\uffff\1\45\1\41\1\uffff\3\41\2\uffff\3\45\1\uffff\6\45\1\140\4\45\2\uffff\10\45\3\uffff\5\45\2\uffff\2\45\1\uffff\2\45\1\uffff\2\45\1\uffff\1\45\4\uffff\2\45\1\174\12\45\1\uffff\33\45\1\uffff\3\45\1\u00a8\2\45\1\u00ab\12\45\1\u00b6\10\45\1\u00bf\1\45\1\u00c1\1\u00c2\1\u00c3\1\45\1\u00c5\1\45\1\u00c7\2\45\1\u00ca\5\45\1\uffff\2\45\1\uffff\1\45\1\u00d3\1\45\1\u00ca\6\45\1\uffff\3\45\1\u00de\4\45\1\uffff\1\45\3\uffff\1\45\1\uffff\1\45\1\uffff\2\45\1\uffff\1\u00e8\4\45\1\u00ed\2\45\1\uffff\11\45\1\u00fa\1\uffff\4\45\1\u00ff\4\45\1\uffff\4\45\1\uffff\3\45\1\u010b\2\45\1\u010e\2\45\1\u0111\1\u0112\1\45\1\uffff\1\u0114\2\45\1\u0117\1\uffff\1\45\1\u0119\10\45\1\u0122\1\uffff\2\45\1\uffff\2\45\2\uffff\1\45\1\uffff\2\45\1\uffff\1\45\1\uffff\2\45\1\u012d\2\45\1\u0130\2\45\1\uffff\1\u0133\2\45\1\u0136\1\u0137\2\45\1\u013a\2\45\1\uffff\1\45\1\u013e\1\uffff\2\45\1\uffff\2\45\2\uffff\2\45\1\uffff\1\u0145\1\u0146\1\45\1\uffff\1\u0148\2\45\1\u014b\2\45\2\uffff\1\45\1\uffff\2\45\1\uffff\3\45\1\u0154\1\45\1\u0156\2\45\1\uffff\1\45\1\uffff\1\u015a\2\45\1\uffff\5\45\1\u0162\1\45\1\uffff\1\45\1\u0165\1\uffff";
    static final String DFA15_eofS =
        "\u0166\uffff";
    static final String DFA15_minS =
        "\1\0\1\144\2\141\1\147\1\141\2\uffff\1\150\1\145\3\uffff\1\156\2\151\2\uffff\1\141\1\72\1\157\1\uffff\2\145\1\60\1\uffff\1\162\1\101\1\uffff\2\0\1\52\2\uffff\1\155\1\146\1\145\1\uffff\1\164\1\155\1\157\1\156\1\157\1\143\1\60\1\147\1\160\1\162\1\154\2\uffff\1\156\1\141\1\157\1\162\1\157\1\162\1\145\1\144\3\uffff\2\164\1\163\1\156\1\144\2\uffff\1\157\1\162\1\uffff\1\157\1\164\1\uffff\1\160\1\166\1\uffff\1\165\4\uffff\1\157\1\165\1\60\1\162\1\156\1\141\1\142\1\141\1\155\1\143\1\141\1\164\1\163\1\uffff\1\162\1\154\1\163\1\151\1\164\1\162\1\163\1\151\1\162\1\166\1\143\2\145\1\155\1\151\1\164\1\147\1\145\1\143\1\164\1\154\1\145\1\157\2\145\1\162\1\164\1\uffff\1\141\2\164\1\60\1\154\1\151\1\60\2\164\1\157\2\145\2\151\1\145\1\144\1\145\1\60\1\165\1\143\1\156\1\164\2\151\1\105\1\156\1\60\1\164\3\60\1\145\1\60\1\145\1\60\1\163\1\162\1\60\1\164\1\141\1\163\1\151\1\171\1\uffff\1\145\1\156\1\uffff\1\151\1\60\1\162\1\60\1\147\1\143\1\157\1\117\1\141\1\170\1\uffff\1\162\1\164\1\147\1\60\1\143\2\146\1\144\1\uffff\1\171\3\uffff\1\144\1\uffff\1\141\1\uffff\1\151\1\105\1\uffff\1\60\1\142\1\164\1\146\1\160\1\60\1\105\1\157\1\uffff\1\171\2\141\1\156\1\142\2\164\1\145\1\165\1\60\1\uffff\1\145\1\151\1\146\1\163\1\60\1\165\1\156\1\164\1\155\1\uffff\1\154\1\162\1\151\1\145\1\uffff\1\166\1\145\1\156\1\60\2\164\1\60\1\152\1\157\2\60\1\162\1\uffff\1\60\1\143\1\145\1\60\1\uffff\1\162\1\60\1\157\1\160\1\145\1\165\1\145\1\163\1\145\1\162\1\60\1\uffff\1\145\1\151\1\uffff\1\145\1\162\2\uffff\1\145\1\uffff\1\141\1\143\1\uffff\1\145\1\uffff\1\162\1\164\1\60\1\143\1\162\1\60\1\156\1\166\1\uffff\1\60\1\157\1\143\2\60\2\164\1\60\2\171\1\uffff\1\164\1\60\1\uffff\1\164\1\151\1\uffff\1\156\1\164\2\uffff\1\151\1\106\1\uffff\2\60\1\165\1\uffff\1\60\1\143\1\123\1\60\1\157\1\162\2\uffff\1\162\1\uffff\2\145\1\uffff\1\156\2\145\1\60\1\162\1\60\1\145\1\123\1\uffff\1\166\1\uffff\1\60\1\145\1\151\1\uffff\1\162\1\143\1\166\1\145\1\151\1\60\1\143\1\uffff\1\145\1\60\1\uffff";
    static final String DFA15_maxS =
        "\1\uffff\1\156\1\157\1\165\1\163\1\145\2\uffff\1\157\1\164\3\uffff\1\170\1\157\1\151\2\uffff\1\162\1\72\1\171\1\uffff\2\145\1\71\1\uffff\1\162\1\172\1\uffff\2\uffff\1\57\2\uffff\1\160\1\164\1\145\1\uffff\1\164\1\165\1\157\1\156\1\157\1\154\1\172\1\147\1\160\1\162\1\154\2\uffff\1\156\1\141\1\157\1\162\1\157\1\162\1\145\1\144\3\uffff\1\164\1\165\1\163\1\156\1\144\2\uffff\1\157\1\162\1\uffff\1\157\1\164\1\uffff\1\160\1\166\1\uffff\1\165\4\uffff\1\157\1\165\1\172\1\162\1\156\1\145\1\142\1\141\1\155\1\143\1\141\1\164\1\163\1\uffff\1\162\1\154\1\163\1\165\1\164\1\162\1\163\1\165\1\162\1\166\1\143\2\145\1\155\1\151\1\164\1\147\1\145\1\143\1\164\1\154\1\145\1\157\2\145\1\162\1\164\1\uffff\1\141\2\164\1\172\1\154\1\151\1\172\2\164\1\157\2\145\2\151\1\145\1\144\1\145\1\172\1\165\1\143\1\156\1\164\2\151\1\105\1\156\1\172\1\164\3\172\1\145\1\172\1\145\1\172\1\163\1\162\1\172\1\164\1\141\1\163\1\151\1\171\1\uffff\1\145\1\156\1\uffff\1\151\1\172\1\162\1\172\1\147\1\143\1\157\1\117\1\141\1\170\1\uffff\1\162\1\164\1\147\1\172\1\143\2\146\1\144\1\uffff\1\171\3\uffff\1\144\1\uffff\1\141\1\uffff\1\151\1\105\1\uffff\1\172\1\142\1\164\1\146\1\160\1\172\1\123\1\157\1\uffff\1\171\2\141\1\156\1\142\2\164\1\145\1\165\1\172\1\uffff\1\145\1\151\1\146\1\163\1\172\1\165\1\156\1\164\1\155\1\uffff\1\154\1\162\1\151\1\145\1\uffff\1\166\1\145\1\156\1\172\2\164\1\172\1\152\1\157\2\172\1\162\1\uffff\1\172\1\143\1\145\1\172\1\uffff\1\162\1\172\1\157\1\160\1\145\1\165\1\145\1\163\1\145\1\162\1\172\1\uffff\1\145\1\151\1\uffff\1\145\1\162\2\uffff\1\145\1\uffff\1\141\1\143\1\uffff\1\145\1\uffff\1\162\1\164\1\172\1\143\1\162\1\172\1\156\1\166\1\uffff\1\172\1\157\1\143\2\172\2\164\1\172\2\171\1\uffff\1\164\1\172\1\uffff\1\164\1\151\1\uffff\1\156\1\164\2\uffff\1\151\1\106\1\uffff\2\172\1\165\1\uffff\1\172\1\143\1\123\1\172\1\157\1\162\2\uffff\1\162\1\uffff\2\145\1\uffff\1\156\2\145\1\172\1\162\1\172\1\145\1\123\1\uffff\1\166\1\uffff\1\172\1\145\1\151\1\uffff\1\162\1\143\1\166\1\145\1\151\1\172\1\143\1\uffff\1\145\1\172\1\uffff";
    static final String DFA15_acceptS =
        "\6\uffff\1\6\1\7\2\uffff\1\12\1\13\1\14\3\uffff\1\22\1\23\3\uffff\1\41\3\uffff\1\63\2\uffff\1\65\3\uffff\1\71\1\72\3\uffff\1\65\13\uffff\1\6\1\7\10\uffff\1\12\1\13\1\14\5\uffff\1\22\1\23\2\uffff\1\26\2\uffff\1\41\2\uffff\1\63\1\uffff\1\66\1\67\1\70\1\71\15\uffff\1\4\33\uffff\1\35\53\uffff\1\32\2\uffff\1\3\12\uffff\1\31\10\uffff\1\21\1\uffff\1\16\1\36\1\17\1\uffff\1\57\1\uffff\1\30\2\uffff\1\64\10\uffff\1\34\12\uffff\1\37\11\uffff\1\1\4\uffff\1\33\14\uffff\1\40\4\uffff\1\46\13\uffff\1\47\2\uffff\1\5\2\uffff\1\10\1\60\1\uffff\1\52\2\uffff\1\15\1\uffff\1\27\10\uffff\1\25\12\uffff\1\20\2\uffff\1\2\2\uffff\1\42\2\uffff\1\62\1\11\2\uffff\1\24\3\uffff\1\55\6\uffff\1\51\1\56\1\uffff\1\44\2\uffff\1\54\10\uffff\1\45\1\uffff\1\53\3\uffff\1\61\7\uffff\1\43\2\uffff\1\50";
    static final String DFA15_specialS =
        "\1\1\34\uffff\1\2\1\0\u0147\uffff}>";
    static final String[] DFA15_transitionS = {
            "\11\41\2\40\2\41\1\40\22\41\1\40\1\41\1\35\4\41\1\36\1\20\1\21\2\41\1\13\1\30\1\25\1\37\12\31\1\23\1\41\1\12\1\41\1\14\2\41\32\34\3\41\1\33\1\34\1\41\1\4\1\24\1\10\1\2\1\15\1\3\1\34\1\17\1\1\2\34\1\16\1\34\1\27\1\34\1\22\1\34\1\26\1\11\1\32\1\34\1\5\4\34\1\6\1\41\1\7\uff82\41",
            "\1\44\10\uffff\1\42\1\43",
            "\1\46\15\uffff\1\47",
            "\1\53\12\uffff\1\52\5\uffff\1\50\2\uffff\1\51",
            "\1\55\10\uffff\1\56\2\uffff\1\54",
            "\1\60\3\uffff\1\57",
            "",
            "",
            "\1\64\3\uffff\1\65\2\uffff\1\63",
            "\1\70\2\uffff\1\67\1\72\6\uffff\1\71\3\uffff\1\66",
            "",
            "",
            "",
            "\1\77\11\uffff\1\76",
            "\1\100\5\uffff\1\101",
            "\1\102",
            "",
            "",
            "\1\106\20\uffff\1\105",
            "\1\107",
            "\1\110\11\uffff\1\111",
            "",
            "\1\113",
            "\1\114",
            "\12\115",
            "",
            "\1\116",
            "\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\0\117",
            "\0\117",
            "\1\120\4\uffff\1\121",
            "",
            "",
            "\1\124\2\uffff\1\123",
            "\1\126\15\uffff\1\125",
            "\1\127",
            "",
            "\1\130",
            "\1\132\7\uffff\1\131",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136\10\uffff\1\137",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "",
            "",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "",
            "",
            "",
            "\1\155",
            "\1\157\1\156",
            "\1\160",
            "\1\161",
            "\1\162",
            "",
            "",
            "\1\163",
            "\1\164",
            "",
            "\1\165",
            "\1\166",
            "",
            "\1\167",
            "\1\170",
            "",
            "\1\171",
            "",
            "",
            "",
            "",
            "\1\172",
            "\1\173",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\175",
            "\1\176",
            "\1\177\3\uffff\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008c\13\uffff\1\u008b",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0091\13\uffff\1\u0090",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00a9",
            "\1\u00aa",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00c0",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00c4",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00c6",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00c8",
            "\1\u00c9",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "",
            "\1\u00d0",
            "\1\u00d1",
            "",
            "\1\u00d2",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00d4",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "",
            "\1\u00db",
            "\1\u00dc",
            "\1\u00dd",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "",
            "\1\u00e3",
            "",
            "",
            "",
            "\1\u00e4",
            "",
            "\1\u00e5",
            "",
            "\1\u00e6",
            "\1\u00e7",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00ee\15\uffff\1\u00ef",
            "\1\u00f0",
            "",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "\1\u00f8",
            "\1\u00f9",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u0100",
            "\1\u0101",
            "\1\u0102",
            "\1\u0103",
            "",
            "\1\u0104",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "",
            "\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u010c",
            "\1\u010d",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u010f",
            "\1\u0110",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u0113",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u0115",
            "\1\u0116",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\1\u0118",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u011a",
            "\1\u011b",
            "\1\u011c",
            "\1\u011d",
            "\1\u011e",
            "\1\u011f",
            "\1\u0120",
            "\1\u0121",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\1\u0123",
            "\1\u0124",
            "",
            "\1\u0125",
            "\1\u0126",
            "",
            "",
            "\1\u0127",
            "",
            "\1\u0128",
            "\1\u0129",
            "",
            "\1\u012a",
            "",
            "\1\u012b",
            "\1\u012c",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u012e",
            "\1\u012f",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u0131",
            "\1\u0132",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u0134",
            "\1\u0135",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u0138",
            "\1\u0139",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u013b",
            "\1\u013c",
            "",
            "\1\u013d",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\1\u013f",
            "\1\u0140",
            "",
            "\1\u0141",
            "\1\u0142",
            "",
            "",
            "\1\u0143",
            "\1\u0144",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u0147",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u0149",
            "\1\u014a",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u014c",
            "\1\u014d",
            "",
            "",
            "\1\u014e",
            "",
            "\1\u014f",
            "\1\u0150",
            "",
            "\1\u0151",
            "\1\u0152",
            "\1\u0153",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u0155",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u0157",
            "\1\u0158",
            "",
            "\1\u0159",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u015b",
            "\1\u015c",
            "",
            "\1\u015d",
            "\1\u015e",
            "\1\u015f",
            "\1\u0160",
            "\1\u0161",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u0163",
            "",
            "\1\u0164",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
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
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | RULE_BIG_DECIMAL | RULE_BOOLEAN | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA15_30 = input.LA(1);

                        s = -1;
                        if ( ((LA15_30>='\u0000' && LA15_30<='\uFFFF')) ) {s = 79;}

                        else s = 33;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA15_0 = input.LA(1);

                        s = -1;
                        if ( (LA15_0=='i') ) {s = 1;}

                        else if ( (LA15_0=='d') ) {s = 2;}

                        else if ( (LA15_0=='f') ) {s = 3;}

                        else if ( (LA15_0=='a') ) {s = 4;}

                        else if ( (LA15_0=='v') ) {s = 5;}

                        else if ( (LA15_0=='{') ) {s = 6;}

                        else if ( (LA15_0=='}') ) {s = 7;}

                        else if ( (LA15_0=='c') ) {s = 8;}

                        else if ( (LA15_0=='s') ) {s = 9;}

                        else if ( (LA15_0=='<') ) {s = 10;}

                        else if ( (LA15_0==',') ) {s = 11;}

                        else if ( (LA15_0=='>') ) {s = 12;}

                        else if ( (LA15_0=='e') ) {s = 13;}

                        else if ( (LA15_0=='l') ) {s = 14;}

                        else if ( (LA15_0=='h') ) {s = 15;}

                        else if ( (LA15_0=='(') ) {s = 16;}

                        else if ( (LA15_0==')') ) {s = 17;}

                        else if ( (LA15_0=='p') ) {s = 18;}

                        else if ( (LA15_0==':') ) {s = 19;}

                        else if ( (LA15_0=='b') ) {s = 20;}

                        else if ( (LA15_0=='.') ) {s = 21;}

                        else if ( (LA15_0=='r') ) {s = 22;}

                        else if ( (LA15_0=='n') ) {s = 23;}

                        else if ( (LA15_0=='-') ) {s = 24;}

                        else if ( ((LA15_0>='0' && LA15_0<='9')) ) {s = 25;}

                        else if ( (LA15_0=='t') ) {s = 26;}

                        else if ( (LA15_0=='^') ) {s = 27;}

                        else if ( ((LA15_0>='A' && LA15_0<='Z')||LA15_0=='_'||LA15_0=='g'||(LA15_0>='j' && LA15_0<='k')||LA15_0=='m'||LA15_0=='o'||LA15_0=='q'||LA15_0=='u'||(LA15_0>='w' && LA15_0<='z')) ) {s = 28;}

                        else if ( (LA15_0=='\"') ) {s = 29;}

                        else if ( (LA15_0=='\'') ) {s = 30;}

                        else if ( (LA15_0=='/') ) {s = 31;}

                        else if ( ((LA15_0>='\t' && LA15_0<='\n')||LA15_0=='\r'||LA15_0==' ') ) {s = 32;}

                        else if ( ((LA15_0>='\u0000' && LA15_0<='\b')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='\u001F')||LA15_0=='!'||(LA15_0>='#' && LA15_0<='&')||(LA15_0>='*' && LA15_0<='+')||LA15_0==';'||LA15_0=='='||(LA15_0>='?' && LA15_0<='@')||(LA15_0>='[' && LA15_0<=']')||LA15_0=='`'||LA15_0=='|'||(LA15_0>='~' && LA15_0<='\uFFFF')) ) {s = 33;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA15_29 = input.LA(1);

                        s = -1;
                        if ( ((LA15_29>='\u0000' && LA15_29<='\uFFFF')) ) {s = 79;}

                        else s = 33;

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