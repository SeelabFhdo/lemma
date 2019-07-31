package de.fhdo.lemma.technology.mappingdsl.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMappingDslLexer extends Lexer {
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
    public static final int RULE_BOOLEAN=6;
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
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=10;
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
    public static final int RULE_BIG_DECIMAL=7;
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
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
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

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:11:7: ( ';' )
            // InternalMappingDsl.g:11:9: ';'
            {
            match(';'); 

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
            // InternalMappingDsl.g:12:7: ( 'technology' )
            // InternalMappingDsl.g:12:9: 'technology'
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
            // InternalMappingDsl.g:13:7: ( 'microservices' )
            // InternalMappingDsl.g:13:9: 'microservices'
            {
            match("microservices"); 


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
            // InternalMappingDsl.g:14:7: ( 'internal' )
            // InternalMappingDsl.g:14:9: 'internal'
            {
            match("internal"); 


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
            // InternalMappingDsl.g:15:7: ( 'architecture' )
            // InternalMappingDsl.g:15:9: 'architecture'
            {
            match("architecture"); 


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
            // InternalMappingDsl.g:16:7: ( 'public' )
            // InternalMappingDsl.g:16:9: 'public'
            {
            match("public"); 


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
            // InternalMappingDsl.g:17:7: ( 'functional' )
            // InternalMappingDsl.g:17:9: 'functional'
            {
            match("functional"); 


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
            // InternalMappingDsl.g:18:7: ( 'utility' )
            // InternalMappingDsl.g:18:9: 'utility'
            {
            match("utility"); 


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
            // InternalMappingDsl.g:19:7: ( 'infrastructure' )
            // InternalMappingDsl.g:19:9: 'infrastructure'
            {
            match("infrastructure"); 


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
            // InternalMappingDsl.g:20:7: ( 'in' )
            // InternalMappingDsl.g:20:9: 'in'
            {
            match("in"); 


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
            // InternalMappingDsl.g:21:7: ( 'out' )
            // InternalMappingDsl.g:21:9: 'out'
            {
            match("out"); 


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
            // InternalMappingDsl.g:22:7: ( 'inout' )
            // InternalMappingDsl.g:22:9: 'inout'
            {
            match("inout"); 


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
            // InternalMappingDsl.g:23:7: ( 'sync' )
            // InternalMappingDsl.g:23:9: 'sync'
            {
            match("sync"); 


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
            // InternalMappingDsl.g:24:7: ( 'async' )
            // InternalMappingDsl.g:24:9: 'async'
            {
            match("async"); 


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
            // InternalMappingDsl.g:25:7: ( '<-' )
            // InternalMappingDsl.g:25:9: '<-'
            {
            match("<-"); 


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
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:27:7: ( '<->' )
            // InternalMappingDsl.g:27:9: '<->'
            {
            match("<->"); 


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
            // InternalMappingDsl.g:28:7: ( 'mandatory' )
            // InternalMappingDsl.g:28:9: 'mandatory'
            {
            match("mandatory"); 


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
            // InternalMappingDsl.g:29:7: ( 'singleval' )
            // InternalMappingDsl.g:29:9: 'singleval'
            {
            match("singleval"); 


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
            // InternalMappingDsl.g:30:7: ( 'interfaces' )
            // InternalMappingDsl.g:30:9: 'interfaces'
            {
            match("interfaces"); 


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
            // InternalMappingDsl.g:31:7: ( 'operations' )
            // InternalMappingDsl.g:31:9: 'operations'
            {
            match("operations"); 


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
            // InternalMappingDsl.g:32:7: ( 'parameters' )
            // InternalMappingDsl.g:32:9: 'parameters'
            {
            match("parameters"); 


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
            // InternalMappingDsl.g:33:7: ( 'types' )
            // InternalMappingDsl.g:33:9: 'types'
            {
            match("types"); 


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
            // InternalMappingDsl.g:34:7: ( 'fields' )
            // InternalMappingDsl.g:34:9: 'fields'
            {
            match("fields"); 


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
            // InternalMappingDsl.g:35:7: ( 'containers' )
            // InternalMappingDsl.g:35:9: 'containers'
            {
            match("containers"); 


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
            // InternalMappingDsl.g:36:7: ( 'aggregate' )
            // InternalMappingDsl.g:36:9: 'aggregate'
            {
            match("aggregate"); 


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
            // InternalMappingDsl.g:37:7: ( 'applicationService' )
            // InternalMappingDsl.g:37:9: 'applicationService'
            {
            match("applicationService"); 


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
            // InternalMappingDsl.g:38:7: ( 'domainEvent' )
            // InternalMappingDsl.g:38:9: 'domainEvent'
            {
            match("domainEvent"); 


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
            // InternalMappingDsl.g:39:7: ( 'domainService' )
            // InternalMappingDsl.g:39:9: 'domainService'
            {
            match("domainService"); 


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
            // InternalMappingDsl.g:40:7: ( 'entity' )
            // InternalMappingDsl.g:40:9: 'entity'
            {
            match("entity"); 


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
            // InternalMappingDsl.g:41:7: ( 'factory' )
            // InternalMappingDsl.g:41:9: 'factory'
            {
            match("factory"); 


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
            // InternalMappingDsl.g:42:7: ( 'infrastructureService' )
            // InternalMappingDsl.g:42:9: 'infrastructureService'
            {
            match("infrastructureService"); 


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
            // InternalMappingDsl.g:43:7: ( 'repository' )
            // InternalMappingDsl.g:43:9: 'repository'
            {
            match("repository"); 


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
            // InternalMappingDsl.g:44:7: ( 'service' )
            // InternalMappingDsl.g:44:9: 'service'
            {
            match("service"); 


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
            // InternalMappingDsl.g:45:7: ( 'specification' )
            // InternalMappingDsl.g:45:9: 'specification'
            {
            match("specification"); 


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
            // InternalMappingDsl.g:46:7: ( 'valueObject' )
            // InternalMappingDsl.g:46:9: 'valueObject'
            {
            match("valueObject"); 


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
            // InternalMappingDsl.g:47:7: ( 'identifier' )
            // InternalMappingDsl.g:47:9: 'identifier'
            {
            match("identifier"); 


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
            // InternalMappingDsl.g:48:7: ( 'part' )
            // InternalMappingDsl.g:48:9: 'part'
            {
            match("part"); 


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
            // InternalMappingDsl.g:49:7: ( 'closure' )
            // InternalMappingDsl.g:49:9: 'closure'
            {
            match("closure"); 


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
            // InternalMappingDsl.g:50:7: ( 'sideEffectFree' )
            // InternalMappingDsl.g:50:9: 'sideEffectFree'
            {
            match("sideEffectFree"); 


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
            // InternalMappingDsl.g:51:7: ( 'validator' )
            // InternalMappingDsl.g:51:9: 'validator'
            {
            match("validator"); 


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
            // InternalMappingDsl.g:52:7: ( 'type' )
            // InternalMappingDsl.g:52:9: 'type'
            {
            match("type"); 


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
            // InternalMappingDsl.g:53:7: ( '{' )
            // InternalMappingDsl.g:53:9: '{'
            {
            match('{'); 

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
            // InternalMappingDsl.g:54:7: ( '}' )
            // InternalMappingDsl.g:54:9: '}'
            {
            match('}'); 

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
            // InternalMappingDsl.g:55:7: ( 'aspects' )
            // InternalMappingDsl.g:55:9: 'aspects'
            {
            match("aspects"); 


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
            // InternalMappingDsl.g:56:7: ( '::' )
            // InternalMappingDsl.g:56:9: '::'
            {
            match("::"); 


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
            // InternalMappingDsl.g:57:7: ( 'protocols' )
            // InternalMappingDsl.g:57:9: 'protocols'
            {
            match("protocols"); 


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
            // InternalMappingDsl.g:58:7: ( 'endpoints' )
            // InternalMappingDsl.g:58:9: 'endpoints'
            {
            match("endpoints"); 


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
            // InternalMappingDsl.g:59:7: ( 'interface' )
            // InternalMappingDsl.g:59:9: 'interface'
            {
            match("interface"); 


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
            // InternalMappingDsl.g:60:7: ( 'operation' )
            // InternalMappingDsl.g:60:9: 'operation'
            {
            match("operation"); 


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
            // InternalMappingDsl.g:61:7: ( 'referred' )
            // InternalMappingDsl.g:61:9: 'referred'
            {
            match("referred"); 


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
            // InternalMappingDsl.g:62:7: ( 'primitive' )
            // InternalMappingDsl.g:62:9: 'primitive'
            {
            match("primitive"); 


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
            // InternalMappingDsl.g:63:7: ( ':' )
            // InternalMappingDsl.g:63:9: ':'
            {
            match(':'); 

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
            // InternalMappingDsl.g:64:7: ( 'complex' )
            // InternalMappingDsl.g:64:9: 'complex'
            {
            match("complex"); 


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
            // InternalMappingDsl.g:65:7: ( '.' )
            // InternalMappingDsl.g:65:9: '.'
            {
            match('.'); 

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
            // InternalMappingDsl.g:66:7: ( 'op' )
            // InternalMappingDsl.g:66:9: 'op'
            {
            match("op"); 


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
            // InternalMappingDsl.g:67:7: ( '/' )
            // InternalMappingDsl.g:67:9: '/'
            {
            match('/'); 

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
            // InternalMappingDsl.g:68:7: ( ',' )
            // InternalMappingDsl.g:68:9: ','
            {
            match(','); 

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
            // InternalMappingDsl.g:69:7: ( '(' )
            // InternalMappingDsl.g:69:9: '('
            {
            match('('); 

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
            // InternalMappingDsl.g:70:7: ( ')' )
            // InternalMappingDsl.g:70:9: ')'
            {
            match(')'); 

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
            // InternalMappingDsl.g:71:7: ( 'import' )
            // InternalMappingDsl.g:71:9: 'import'
            {
            match("import"); 


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
            // InternalMappingDsl.g:72:7: ( 'from' )
            // InternalMappingDsl.g:72:9: 'from'
            {
            match("from"); 


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
            // InternalMappingDsl.g:73:7: ( 'as' )
            // InternalMappingDsl.g:73:9: 'as'
            {
            match("as"); 


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
            // InternalMappingDsl.g:74:7: ( 'microservice' )
            // InternalMappingDsl.g:74:9: 'microservice'
            {
            match("microservice"); 


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
            // InternalMappingDsl.g:75:7: ( '@' )
            // InternalMappingDsl.g:75:9: '@'
            {
            match('@'); 

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
            // InternalMappingDsl.g:76:7: ( 'version' )
            // InternalMappingDsl.g:76:9: 'version'
            {
            match("version"); 


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
            // InternalMappingDsl.g:77:7: ( 'required' )
            // InternalMappingDsl.g:77:9: 'required'
            {
            match("required"); 


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
            // InternalMappingDsl.g:78:7: ( 'typedef' )
            // InternalMappingDsl.g:78:9: 'typedef'
            {
            match("typedef"); 


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
            // InternalMappingDsl.g:79:7: ( '=' )
            // InternalMappingDsl.g:79:9: '='
            {
            match('='); 

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
            // InternalMappingDsl.g:80:7: ( 'refers' )
            // InternalMappingDsl.g:80:9: 'refers'
            {
            match("refers"); 


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
            // InternalMappingDsl.g:81:7: ( 'data' )
            // InternalMappingDsl.g:81:9: 'data'
            {
            match("data"); 


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
            // InternalMappingDsl.g:82:7: ( 'formats' )
            // InternalMappingDsl.g:82:9: 'formats'
            {
            match("formats"); 


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
            // InternalMappingDsl.g:83:7: ( 'with' )
            // InternalMappingDsl.g:83:9: 'with'
            {
            match("with"); 


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
            // InternalMappingDsl.g:84:7: ( 'format' )
            // InternalMappingDsl.g:84:9: 'format'
            {
            match("format"); 


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
            // InternalMappingDsl.g:85:7: ( 'based' )
            // InternalMappingDsl.g:85:9: 'based'
            {
            match("based"); 


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
            // InternalMappingDsl.g:86:7: ( 'on' )
            // InternalMappingDsl.g:86:9: 'on'
            {
            match("on"); 


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
            // InternalMappingDsl.g:87:7: ( 'list' )
            // InternalMappingDsl.g:87:9: 'list'
            {
            match("list"); 


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
            // InternalMappingDsl.g:88:7: ( 'structure' )
            // InternalMappingDsl.g:88:9: 'structure'
            {
            match("structure"); 


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
            // InternalMappingDsl.g:89:7: ( 'environments' )
            // InternalMappingDsl.g:89:9: 'environments'
            {
            match("environments"); 


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
            // InternalMappingDsl.g:90:7: ( 'properties' )
            // InternalMappingDsl.g:90:9: 'properties'
            {
            match("properties"); 


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
            // InternalMappingDsl.g:91:7: ( '<' )
            // InternalMappingDsl.g:91:9: '<'
            {
            match('<'); 

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
            // InternalMappingDsl.g:92:7: ( '>' )
            // InternalMappingDsl.g:92:9: '>'
            {
            match('>'); 

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
            // InternalMappingDsl.g:93:7: ( 'selector' )
            // InternalMappingDsl.g:93:9: 'selector'
            {
            match("selector"); 


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
            // InternalMappingDsl.g:94:7: ( 'aspect' )
            // InternalMappingDsl.g:94:9: 'aspect'
            {
            match("aspect"); 


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
            // InternalMappingDsl.g:95:7: ( 'for' )
            // InternalMappingDsl.g:95:9: 'for'
            {
            match("for"); 


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
            // InternalMappingDsl.g:96:7: ( 'datatypes' )
            // InternalMappingDsl.g:96:9: 'datatypes'
            {
            match("datatypes"); 


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
            // InternalMappingDsl.g:97:7: ( 'context' )
            // InternalMappingDsl.g:97:9: 'context'
            {
            match("context"); 


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
            // InternalMappingDsl.g:98:8: ( 'extends' )
            // InternalMappingDsl.g:98:10: 'extends'
            {
            match("extends"); 


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
            // InternalMappingDsl.g:99:8: ( 'enum' )
            // InternalMappingDsl.g:99:10: 'enum'
            {
            match("enum"); 


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
            // InternalMappingDsl.g:100:8: ( 'function' )
            // InternalMappingDsl.g:100:10: 'function'
            {
            match("function"); 


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
            // InternalMappingDsl.g:101:8: ( 'boolean' )
            // InternalMappingDsl.g:101:10: 'boolean'
            {
            match("boolean"); 


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
            // InternalMappingDsl.g:102:8: ( 'byte' )
            // InternalMappingDsl.g:102:10: 'byte'
            {
            match("byte"); 


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
            // InternalMappingDsl.g:103:8: ( 'char' )
            // InternalMappingDsl.g:103:10: 'char'
            {
            match("char"); 


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
            // InternalMappingDsl.g:104:8: ( 'date' )
            // InternalMappingDsl.g:104:10: 'date'
            {
            match("date"); 


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
            // InternalMappingDsl.g:105:8: ( 'double' )
            // InternalMappingDsl.g:105:10: 'double'
            {
            match("double"); 


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
            // InternalMappingDsl.g:106:8: ( 'float' )
            // InternalMappingDsl.g:106:10: 'float'
            {
            match("float"); 


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
            // InternalMappingDsl.g:107:8: ( 'int' )
            // InternalMappingDsl.g:107:10: 'int'
            {
            match("int"); 


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
            // InternalMappingDsl.g:108:8: ( 'long' )
            // InternalMappingDsl.g:108:10: 'long'
            {
            match("long"); 


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
            // InternalMappingDsl.g:109:8: ( 'short' )
            // InternalMappingDsl.g:109:10: 'short'
            {
            match("short"); 


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
            // InternalMappingDsl.g:110:8: ( 'string' )
            // InternalMappingDsl.g:110:10: 'string'
            {
            match("string"); 


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
            // InternalMappingDsl.g:111:8: ( 'noimpl' )
            // InternalMappingDsl.g:111:10: 'noimpl'
            {
            match("noimpl"); 


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
            // InternalMappingDsl.g:112:8: ( 'fault' )
            // InternalMappingDsl.g:112:10: 'fault'
            {
            match("fault"); 


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
            // InternalMappingDsl.g:113:8: ( '?' )
            // InternalMappingDsl.g:113:10: '?'
            {
            match('?'); 

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
            // InternalMappingDsl.g:114:8: ( 'default' )
            // InternalMappingDsl.g:114:10: 'default'
            {
            match("default"); 


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
            // InternalMappingDsl.g:115:8: ( 'exchange_pattern' )
            // InternalMappingDsl.g:115:10: 'exchange_pattern'
            {
            match("exchange_pattern"); 


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
            // InternalMappingDsl.g:116:8: ( 'communication_type' )
            // InternalMappingDsl.g:116:10: 'communication_type'
            {
            match("communication_type"); 


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
            // InternalMappingDsl.g:117:8: ( 'protocol' )
            // InternalMappingDsl.g:117:10: 'protocol'
            {
            match("protocol"); 


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
            // InternalMappingDsl.g:118:8: ( 'data_format' )
            // InternalMappingDsl.g:118:10: 'data_format'
            {
            match("data_format"); 


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
            // InternalMappingDsl.g:119:8: ( 'hide' )
            // InternalMappingDsl.g:119:10: 'hide'
            {
            match("hide"); 


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
            // InternalMappingDsl.g:120:8: ( 'immutable' )
            // InternalMappingDsl.g:120:10: 'immutable'
            {
            match("immutable"); 


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
            // InternalMappingDsl.g:121:8: ( 'procedure' )
            // InternalMappingDsl.g:121:10: 'procedure'
            {
            match("procedure"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__123"

    // $ANTLR start "RULE_BIG_DECIMAL"
    public final void mRULE_BIG_DECIMAL() throws RecognitionException {
        try {
            int _type = RULE_BIG_DECIMAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMappingDsl.g:26038:18: ( ( '-' )? RULE_INT ( '.' RULE_INT )? )
            // InternalMappingDsl.g:26038:20: ( '-' )? RULE_INT ( '.' RULE_INT )?
            {
            // InternalMappingDsl.g:26038:20: ( '-' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='-') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalMappingDsl.g:26038:20: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            mRULE_INT(); 
            // InternalMappingDsl.g:26038:34: ( '.' RULE_INT )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='.') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalMappingDsl.g:26038:35: '.' RULE_INT
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
            // InternalMappingDsl.g:26040:14: ( ( 'true' | 'false' ) )
            // InternalMappingDsl.g:26040:16: ( 'true' | 'false' )
            {
            // InternalMappingDsl.g:26040:16: ( 'true' | 'false' )
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
                    // InternalMappingDsl.g:26040:17: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // InternalMappingDsl.g:26040:24: 'false'
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
            // InternalMappingDsl.g:26042:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalMappingDsl.g:26042:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalMappingDsl.g:26042:11: ( '^' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='^') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalMappingDsl.g:26042:11: '^'
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

            // InternalMappingDsl.g:26042:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')||(LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')) ) {
                    alt5=1;
                }


                switch (alt5) {
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
            // InternalMappingDsl.g:26044:19: ( ( '0' .. '9' )+ )
            // InternalMappingDsl.g:26044:21: ( '0' .. '9' )+
            {
            // InternalMappingDsl.g:26044:21: ( '0' .. '9' )+
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
            	    // InternalMappingDsl.g:26044:22: '0' .. '9'
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
            // InternalMappingDsl.g:26046:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalMappingDsl.g:26046:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalMappingDsl.g:26046:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // InternalMappingDsl.g:26046:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalMappingDsl.g:26046:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // InternalMappingDsl.g:26046:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalMappingDsl.g:26046:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // InternalMappingDsl.g:26046:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalMappingDsl.g:26046:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // InternalMappingDsl.g:26046:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalMappingDsl.g:26046:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // InternalMappingDsl.g:26048:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalMappingDsl.g:26048:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalMappingDsl.g:26048:24: ( options {greedy=false; } : . )*
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
            	    // InternalMappingDsl.g:26048:52: .
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
            // InternalMappingDsl.g:26050:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalMappingDsl.g:26050:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalMappingDsl.g:26050:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\u0000' && LA11_0<='\t')||(LA11_0>='\u000B' && LA11_0<='\f')||(LA11_0>='\u000E' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalMappingDsl.g:26050:24: ~ ( ( '\\n' | '\\r' ) )
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

            // InternalMappingDsl.g:26050:40: ( ( '\\r' )? '\\n' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\n'||LA13_0=='\r') ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalMappingDsl.g:26050:41: ( '\\r' )? '\\n'
                    {
                    // InternalMappingDsl.g:26050:41: ( '\\r' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='\r') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalMappingDsl.g:26050:41: '\\r'
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
            // InternalMappingDsl.g:26052:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalMappingDsl.g:26052:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalMappingDsl.g:26052:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            // InternalMappingDsl.g:26054:16: ( . )
            // InternalMappingDsl.g:26054:18: .
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
        // InternalMappingDsl.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | RULE_BIG_DECIMAL | RULE_BOOLEAN | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt15=119;
        alt15 = dfa15.predict(input);
        switch (alt15) {
            case 1 :
                // InternalMappingDsl.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // InternalMappingDsl.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // InternalMappingDsl.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // InternalMappingDsl.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // InternalMappingDsl.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // InternalMappingDsl.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // InternalMappingDsl.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // InternalMappingDsl.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // InternalMappingDsl.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // InternalMappingDsl.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // InternalMappingDsl.g:1:70: T__23
                {
                mT__23(); 

                }
                break;
            case 12 :
                // InternalMappingDsl.g:1:76: T__24
                {
                mT__24(); 

                }
                break;
            case 13 :
                // InternalMappingDsl.g:1:82: T__25
                {
                mT__25(); 

                }
                break;
            case 14 :
                // InternalMappingDsl.g:1:88: T__26
                {
                mT__26(); 

                }
                break;
            case 15 :
                // InternalMappingDsl.g:1:94: T__27
                {
                mT__27(); 

                }
                break;
            case 16 :
                // InternalMappingDsl.g:1:100: T__28
                {
                mT__28(); 

                }
                break;
            case 17 :
                // InternalMappingDsl.g:1:106: T__29
                {
                mT__29(); 

                }
                break;
            case 18 :
                // InternalMappingDsl.g:1:112: T__30
                {
                mT__30(); 

                }
                break;
            case 19 :
                // InternalMappingDsl.g:1:118: T__31
                {
                mT__31(); 

                }
                break;
            case 20 :
                // InternalMappingDsl.g:1:124: T__32
                {
                mT__32(); 

                }
                break;
            case 21 :
                // InternalMappingDsl.g:1:130: T__33
                {
                mT__33(); 

                }
                break;
            case 22 :
                // InternalMappingDsl.g:1:136: T__34
                {
                mT__34(); 

                }
                break;
            case 23 :
                // InternalMappingDsl.g:1:142: T__35
                {
                mT__35(); 

                }
                break;
            case 24 :
                // InternalMappingDsl.g:1:148: T__36
                {
                mT__36(); 

                }
                break;
            case 25 :
                // InternalMappingDsl.g:1:154: T__37
                {
                mT__37(); 

                }
                break;
            case 26 :
                // InternalMappingDsl.g:1:160: T__38
                {
                mT__38(); 

                }
                break;
            case 27 :
                // InternalMappingDsl.g:1:166: T__39
                {
                mT__39(); 

                }
                break;
            case 28 :
                // InternalMappingDsl.g:1:172: T__40
                {
                mT__40(); 

                }
                break;
            case 29 :
                // InternalMappingDsl.g:1:178: T__41
                {
                mT__41(); 

                }
                break;
            case 30 :
                // InternalMappingDsl.g:1:184: T__42
                {
                mT__42(); 

                }
                break;
            case 31 :
                // InternalMappingDsl.g:1:190: T__43
                {
                mT__43(); 

                }
                break;
            case 32 :
                // InternalMappingDsl.g:1:196: T__44
                {
                mT__44(); 

                }
                break;
            case 33 :
                // InternalMappingDsl.g:1:202: T__45
                {
                mT__45(); 

                }
                break;
            case 34 :
                // InternalMappingDsl.g:1:208: T__46
                {
                mT__46(); 

                }
                break;
            case 35 :
                // InternalMappingDsl.g:1:214: T__47
                {
                mT__47(); 

                }
                break;
            case 36 :
                // InternalMappingDsl.g:1:220: T__48
                {
                mT__48(); 

                }
                break;
            case 37 :
                // InternalMappingDsl.g:1:226: T__49
                {
                mT__49(); 

                }
                break;
            case 38 :
                // InternalMappingDsl.g:1:232: T__50
                {
                mT__50(); 

                }
                break;
            case 39 :
                // InternalMappingDsl.g:1:238: T__51
                {
                mT__51(); 

                }
                break;
            case 40 :
                // InternalMappingDsl.g:1:244: T__52
                {
                mT__52(); 

                }
                break;
            case 41 :
                // InternalMappingDsl.g:1:250: T__53
                {
                mT__53(); 

                }
                break;
            case 42 :
                // InternalMappingDsl.g:1:256: T__54
                {
                mT__54(); 

                }
                break;
            case 43 :
                // InternalMappingDsl.g:1:262: T__55
                {
                mT__55(); 

                }
                break;
            case 44 :
                // InternalMappingDsl.g:1:268: T__56
                {
                mT__56(); 

                }
                break;
            case 45 :
                // InternalMappingDsl.g:1:274: T__57
                {
                mT__57(); 

                }
                break;
            case 46 :
                // InternalMappingDsl.g:1:280: T__58
                {
                mT__58(); 

                }
                break;
            case 47 :
                // InternalMappingDsl.g:1:286: T__59
                {
                mT__59(); 

                }
                break;
            case 48 :
                // InternalMappingDsl.g:1:292: T__60
                {
                mT__60(); 

                }
                break;
            case 49 :
                // InternalMappingDsl.g:1:298: T__61
                {
                mT__61(); 

                }
                break;
            case 50 :
                // InternalMappingDsl.g:1:304: T__62
                {
                mT__62(); 

                }
                break;
            case 51 :
                // InternalMappingDsl.g:1:310: T__63
                {
                mT__63(); 

                }
                break;
            case 52 :
                // InternalMappingDsl.g:1:316: T__64
                {
                mT__64(); 

                }
                break;
            case 53 :
                // InternalMappingDsl.g:1:322: T__65
                {
                mT__65(); 

                }
                break;
            case 54 :
                // InternalMappingDsl.g:1:328: T__66
                {
                mT__66(); 

                }
                break;
            case 55 :
                // InternalMappingDsl.g:1:334: T__67
                {
                mT__67(); 

                }
                break;
            case 56 :
                // InternalMappingDsl.g:1:340: T__68
                {
                mT__68(); 

                }
                break;
            case 57 :
                // InternalMappingDsl.g:1:346: T__69
                {
                mT__69(); 

                }
                break;
            case 58 :
                // InternalMappingDsl.g:1:352: T__70
                {
                mT__70(); 

                }
                break;
            case 59 :
                // InternalMappingDsl.g:1:358: T__71
                {
                mT__71(); 

                }
                break;
            case 60 :
                // InternalMappingDsl.g:1:364: T__72
                {
                mT__72(); 

                }
                break;
            case 61 :
                // InternalMappingDsl.g:1:370: T__73
                {
                mT__73(); 

                }
                break;
            case 62 :
                // InternalMappingDsl.g:1:376: T__74
                {
                mT__74(); 

                }
                break;
            case 63 :
                // InternalMappingDsl.g:1:382: T__75
                {
                mT__75(); 

                }
                break;
            case 64 :
                // InternalMappingDsl.g:1:388: T__76
                {
                mT__76(); 

                }
                break;
            case 65 :
                // InternalMappingDsl.g:1:394: T__77
                {
                mT__77(); 

                }
                break;
            case 66 :
                // InternalMappingDsl.g:1:400: T__78
                {
                mT__78(); 

                }
                break;
            case 67 :
                // InternalMappingDsl.g:1:406: T__79
                {
                mT__79(); 

                }
                break;
            case 68 :
                // InternalMappingDsl.g:1:412: T__80
                {
                mT__80(); 

                }
                break;
            case 69 :
                // InternalMappingDsl.g:1:418: T__81
                {
                mT__81(); 

                }
                break;
            case 70 :
                // InternalMappingDsl.g:1:424: T__82
                {
                mT__82(); 

                }
                break;
            case 71 :
                // InternalMappingDsl.g:1:430: T__83
                {
                mT__83(); 

                }
                break;
            case 72 :
                // InternalMappingDsl.g:1:436: T__84
                {
                mT__84(); 

                }
                break;
            case 73 :
                // InternalMappingDsl.g:1:442: T__85
                {
                mT__85(); 

                }
                break;
            case 74 :
                // InternalMappingDsl.g:1:448: T__86
                {
                mT__86(); 

                }
                break;
            case 75 :
                // InternalMappingDsl.g:1:454: T__87
                {
                mT__87(); 

                }
                break;
            case 76 :
                // InternalMappingDsl.g:1:460: T__88
                {
                mT__88(); 

                }
                break;
            case 77 :
                // InternalMappingDsl.g:1:466: T__89
                {
                mT__89(); 

                }
                break;
            case 78 :
                // InternalMappingDsl.g:1:472: T__90
                {
                mT__90(); 

                }
                break;
            case 79 :
                // InternalMappingDsl.g:1:478: T__91
                {
                mT__91(); 

                }
                break;
            case 80 :
                // InternalMappingDsl.g:1:484: T__92
                {
                mT__92(); 

                }
                break;
            case 81 :
                // InternalMappingDsl.g:1:490: T__93
                {
                mT__93(); 

                }
                break;
            case 82 :
                // InternalMappingDsl.g:1:496: T__94
                {
                mT__94(); 

                }
                break;
            case 83 :
                // InternalMappingDsl.g:1:502: T__95
                {
                mT__95(); 

                }
                break;
            case 84 :
                // InternalMappingDsl.g:1:508: T__96
                {
                mT__96(); 

                }
                break;
            case 85 :
                // InternalMappingDsl.g:1:514: T__97
                {
                mT__97(); 

                }
                break;
            case 86 :
                // InternalMappingDsl.g:1:520: T__98
                {
                mT__98(); 

                }
                break;
            case 87 :
                // InternalMappingDsl.g:1:526: T__99
                {
                mT__99(); 

                }
                break;
            case 88 :
                // InternalMappingDsl.g:1:532: T__100
                {
                mT__100(); 

                }
                break;
            case 89 :
                // InternalMappingDsl.g:1:539: T__101
                {
                mT__101(); 

                }
                break;
            case 90 :
                // InternalMappingDsl.g:1:546: T__102
                {
                mT__102(); 

                }
                break;
            case 91 :
                // InternalMappingDsl.g:1:553: T__103
                {
                mT__103(); 

                }
                break;
            case 92 :
                // InternalMappingDsl.g:1:560: T__104
                {
                mT__104(); 

                }
                break;
            case 93 :
                // InternalMappingDsl.g:1:567: T__105
                {
                mT__105(); 

                }
                break;
            case 94 :
                // InternalMappingDsl.g:1:574: T__106
                {
                mT__106(); 

                }
                break;
            case 95 :
                // InternalMappingDsl.g:1:581: T__107
                {
                mT__107(); 

                }
                break;
            case 96 :
                // InternalMappingDsl.g:1:588: T__108
                {
                mT__108(); 

                }
                break;
            case 97 :
                // InternalMappingDsl.g:1:595: T__109
                {
                mT__109(); 

                }
                break;
            case 98 :
                // InternalMappingDsl.g:1:602: T__110
                {
                mT__110(); 

                }
                break;
            case 99 :
                // InternalMappingDsl.g:1:609: T__111
                {
                mT__111(); 

                }
                break;
            case 100 :
                // InternalMappingDsl.g:1:616: T__112
                {
                mT__112(); 

                }
                break;
            case 101 :
                // InternalMappingDsl.g:1:623: T__113
                {
                mT__113(); 

                }
                break;
            case 102 :
                // InternalMappingDsl.g:1:630: T__114
                {
                mT__114(); 

                }
                break;
            case 103 :
                // InternalMappingDsl.g:1:637: T__115
                {
                mT__115(); 

                }
                break;
            case 104 :
                // InternalMappingDsl.g:1:644: T__116
                {
                mT__116(); 

                }
                break;
            case 105 :
                // InternalMappingDsl.g:1:651: T__117
                {
                mT__117(); 

                }
                break;
            case 106 :
                // InternalMappingDsl.g:1:658: T__118
                {
                mT__118(); 

                }
                break;
            case 107 :
                // InternalMappingDsl.g:1:665: T__119
                {
                mT__119(); 

                }
                break;
            case 108 :
                // InternalMappingDsl.g:1:672: T__120
                {
                mT__120(); 

                }
                break;
            case 109 :
                // InternalMappingDsl.g:1:679: T__121
                {
                mT__121(); 

                }
                break;
            case 110 :
                // InternalMappingDsl.g:1:686: T__122
                {
                mT__122(); 

                }
                break;
            case 111 :
                // InternalMappingDsl.g:1:693: T__123
                {
                mT__123(); 

                }
                break;
            case 112 :
                // InternalMappingDsl.g:1:700: RULE_BIG_DECIMAL
                {
                mRULE_BIG_DECIMAL(); 

                }
                break;
            case 113 :
                // InternalMappingDsl.g:1:717: RULE_BOOLEAN
                {
                mRULE_BOOLEAN(); 

                }
                break;
            case 114 :
                // InternalMappingDsl.g:1:730: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 115 :
                // InternalMappingDsl.g:1:738: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 116 :
                // InternalMappingDsl.g:1:750: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 117 :
                // InternalMappingDsl.g:1:766: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 118 :
                // InternalMappingDsl.g:1:782: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 119 :
                // InternalMappingDsl.g:1:790: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA15_eotS =
        "\2\uffff\11\56\1\114\1\51\5\56\2\uffff\1\135\1\uffff\1\141\5\uffff\3\56\1\uffff\1\56\1\uffff\1\56\1\uffff\1\51\1\uffff\2\51\3\uffff\3\56\1\uffff\2\56\1\173\3\56\1\u0082\15\56\1\u0094\1\u0095\6\56\1\u009f\3\uffff\13\56\15\uffff\6\56\1\uffff\1\56\1\uffff\1\56\2\uffff\5\56\1\u00c1\2\56\1\uffff\6\56\1\uffff\14\56\1\u00da\2\56\1\u00dd\1\56\2\uffff\10\56\2\uffff\34\56\1\u0109\1\u010a\3\56\1\uffff\14\56\1\u011a\11\56\1\u0124\1\56\1\uffff\2\56\1\uffff\1\56\1\u0129\14\56\1\u0137\2\56\1\u013c\1\u013d\4\56\1\u0142\10\56\1\u014b\2\56\1\u014e\1\u014f\1\u0150\1\56\1\u0152\1\56\1\u0154\1\56\2\uffff\4\56\1\u015b\4\56\1\u0160\5\56\1\uffff\7\56\1\u016d\1\u010a\1\uffff\1\56\1\u016f\2\56\1\uffff\7\56\1\u0179\5\56\1\uffff\4\56\2\uffff\4\56\1\uffff\10\56\1\uffff\1\u0190\1\56\3\uffff\1\56\1\uffff\1\56\1\uffff\6\56\1\uffff\1\56\1\u019b\2\56\1\uffff\1\u019f\2\56\1\u01a2\6\56\1\u01a9\1\56\1\uffff\1\u01ac\1\uffff\10\56\1\u01b5\1\uffff\6\56\1\u01bd\3\56\1\u01c1\6\56\1\u01c8\4\56\1\uffff\1\56\1\u01ce\1\56\1\u01d0\6\56\1\uffff\2\56\1\u01d9\1\uffff\2\56\1\uffff\6\56\1\uffff\1\u01e2\1\u01e3\1\uffff\1\u01e4\3\56\1\u01e8\3\56\1\uffff\1\56\1\u01ed\1\u01ee\1\56\1\u01f0\2\56\1\uffff\2\56\1\u01f5\1\uffff\2\56\1\u01f8\3\56\1\uffff\3\56\1\u01ff\1\u0200\1\uffff\1\56\1\uffff\2\56\1\u0204\5\56\1\uffff\3\56\1\u020e\3\56\1\u0213\3\uffff\3\56\1\uffff\1\u0217\3\56\2\uffff\1\56\1\uffff\4\56\1\uffff\2\56\1\uffff\2\56\1\u0224\1\u0225\2\56\2\uffff\2\56\1\u022a\1\uffff\1\u022c\2\56\1\u022f\1\56\1\u0231\2\56\1\u0234\1\uffff\1\56\1\u0236\1\u0237\1\56\1\uffff\1\u023a\1\u023b\1\56\1\uffff\1\56\1\u023e\4\56\1\u0243\1\56\1\u0245\3\56\2\uffff\1\56\1\u024a\1\u024b\1\56\1\uffff\1\u024d\1\uffff\1\56\1\u024f\1\uffff\1\56\1\uffff\1\56\1\u0252\1\uffff\1\u0253\2\uffff\1\u0254\1\u0255\2\uffff\2\56\1\uffff\1\u0258\3\56\1\uffff\1\56\1\uffff\2\56\1\u025f\1\56\2\uffff\1\56\1\uffff\1\56\1\uffff\2\56\4\uffff\2\56\1\uffff\1\56\1\u0268\1\56\1\u026a\2\56\1\uffff\1\u026d\1\u026f\1\56\1\u0271\4\56\1\uffff\1\56\1\uffff\1\u0277\1\56\1\uffff\1\u0279\1\uffff\1\56\1\uffff\2\56\1\u027d\1\56\1\u027f\1\uffff\1\56\1\uffff\1\u0282\1\56\1\u0284\1\uffff\1\56\1\uffff\2\56\1\uffff\1\56\1\uffff\5\56\1\u028e\3\56\1\uffff\1\56\1\u0293\1\u0294\1\56\2\uffff\1\56\1\u0297\1\uffff";
    static final String DFA15_eofS =
        "\u0298\uffff";
    static final String DFA15_minS =
        "\1\0\1\uffff\1\145\1\141\1\144\1\147\2\141\1\164\1\156\1\145\1\55\1\60\1\150\1\141\1\156\1\145\1\141\2\uffff\1\72\1\uffff\1\52\5\uffff\1\151\1\141\1\151\1\uffff\1\157\1\uffff\1\151\1\uffff\1\101\1\uffff\2\0\3\uffff\1\143\1\160\1\165\1\uffff\1\143\1\156\1\60\1\145\1\155\1\143\1\60\1\147\1\160\1\142\1\162\1\151\1\156\1\145\1\143\1\157\1\162\1\157\1\151\1\164\2\60\1\156\1\144\1\154\1\145\1\162\1\157\1\76\3\uffff\1\155\1\157\1\141\1\155\1\164\1\146\1\144\1\143\1\146\1\154\1\162\15\uffff\1\164\1\163\1\157\1\164\1\163\1\156\1\uffff\1\151\1\uffff\1\144\2\uffff\1\150\2\145\1\162\1\144\1\60\1\162\1\165\1\uffff\1\156\1\157\1\165\1\150\1\156\1\145\1\uffff\1\162\2\154\1\141\1\143\1\155\1\143\1\154\1\164\1\154\1\163\1\155\1\60\1\141\1\154\1\60\1\162\2\uffff\1\143\1\147\1\145\1\166\1\145\1\143\1\151\1\162\2\uffff\1\164\1\155\1\163\1\162\1\141\1\142\2\141\1\151\1\160\1\151\1\155\1\145\1\150\1\157\1\145\1\165\1\151\1\163\1\150\1\145\1\154\1\145\1\164\1\147\1\155\1\145\1\156\2\60\1\157\1\141\1\162\1\uffff\1\141\2\164\1\162\1\164\1\151\2\143\1\145\2\151\1\155\1\60\1\157\2\145\1\151\1\164\1\144\1\157\1\164\1\145\1\60\1\141\1\uffff\1\164\1\151\1\uffff\1\141\1\60\1\154\1\105\1\151\1\143\1\151\1\143\1\156\1\164\1\141\1\154\2\165\1\60\1\151\1\154\2\60\1\165\1\164\1\157\1\162\1\60\1\156\1\141\1\163\1\162\1\151\1\145\1\144\1\151\1\60\1\144\1\145\3\60\1\160\1\60\1\157\1\60\1\145\2\uffff\1\163\1\164\1\146\1\163\1\60\1\151\1\164\1\141\1\164\1\60\1\164\1\147\2\143\1\145\1\uffff\1\143\1\162\1\144\1\164\1\151\1\163\1\162\2\60\1\uffff\1\164\1\60\2\164\1\uffff\1\145\1\146\1\143\1\164\1\146\1\164\1\147\1\60\1\151\1\170\1\145\1\156\1\162\1\uffff\1\156\1\145\1\171\1\146\2\uffff\1\154\1\171\1\151\1\157\1\uffff\1\144\1\156\1\151\2\162\1\117\1\141\1\157\1\uffff\1\60\1\141\3\uffff\1\154\1\uffff\1\154\1\uffff\1\146\1\145\1\157\2\141\1\164\1\uffff\1\146\1\60\1\142\1\145\1\uffff\1\60\2\141\1\60\1\164\1\157\1\164\1\165\1\151\1\157\1\60\1\171\1\uffff\1\60\1\uffff\1\171\1\151\1\166\1\146\1\145\1\157\1\151\1\165\1\60\1\uffff\1\156\1\164\1\170\1\151\1\145\1\105\1\60\1\160\1\157\1\164\1\60\2\156\1\163\1\147\1\164\1\145\1\60\1\145\1\142\1\164\1\156\1\uffff\1\156\1\60\1\157\1\60\2\162\1\154\1\143\1\162\1\151\1\uffff\1\154\1\143\1\60\1\uffff\2\164\1\uffff\1\145\1\154\1\151\1\162\1\166\1\156\1\uffff\2\60\1\uffff\1\60\1\157\1\141\1\145\1\60\1\162\1\143\1\162\1\uffff\1\145\2\60\1\143\1\60\1\166\1\145\1\uffff\1\145\1\162\1\60\1\uffff\1\164\1\155\1\60\1\145\1\157\1\144\1\uffff\1\144\1\152\1\157\2\60\1\uffff\1\147\1\uffff\1\166\1\171\1\60\1\145\1\165\2\145\1\164\1\uffff\1\145\1\151\1\162\1\60\3\145\1\60\3\uffff\1\156\1\154\1\143\1\uffff\1\60\1\141\1\145\1\162\2\uffff\1\141\1\uffff\1\145\1\162\1\163\1\155\1\uffff\1\163\1\145\1\uffff\1\137\1\162\2\60\1\145\1\162\2\uffff\1\171\1\151\1\60\1\uffff\1\60\1\143\1\162\1\60\1\165\1\60\1\157\1\163\1\60\1\uffff\1\163\2\60\1\154\1\uffff\2\60\1\164\1\uffff\1\164\1\60\1\163\1\164\1\156\1\166\1\60\1\141\1\60\1\156\1\160\1\171\2\uffff\1\143\2\60\1\143\1\uffff\1\60\1\uffff\1\164\1\60\1\uffff\1\162\1\uffff\1\156\1\60\1\uffff\1\60\2\uffff\2\60\2\uffff\1\106\1\151\1\uffff\1\60\1\151\1\164\1\151\1\uffff\1\164\1\uffff\1\164\1\141\1\60\1\164\2\uffff\1\145\1\uffff\1\165\1\uffff\1\145\1\123\4\uffff\1\162\1\157\1\uffff\1\157\1\60\1\143\1\60\1\163\1\164\1\uffff\2\60\1\162\1\60\2\145\2\156\1\uffff\1\145\1\uffff\1\60\1\164\1\uffff\1\60\1\uffff\1\145\1\uffff\1\162\1\145\1\60\1\137\1\60\1\uffff\1\145\1\uffff\1\60\1\166\1\60\1\uffff\1\164\1\uffff\1\162\1\145\1\uffff\1\151\1\uffff\1\171\1\156\1\162\1\143\1\160\1\60\1\166\2\145\1\uffff\1\151\2\60\1\143\2\uffff\1\145\1\60\1\uffff";
    static final String DFA15_maxS =
        "\1\uffff\1\uffff\1\171\1\151\1\156\1\163\2\165\1\164\1\165\1\171\1\55\1\76\2\157\1\170\2\145\2\uffff\1\72\1\uffff\1\57\5\uffff\1\151\1\171\1\157\1\uffff\1\157\1\uffff\1\151\1\uffff\1\172\1\uffff\2\uffff\3\uffff\1\143\1\160\1\165\1\uffff\1\143\1\156\1\172\1\145\1\160\1\143\1\172\1\147\1\160\1\142\1\162\1\157\1\156\1\145\1\165\1\157\1\162\1\157\1\151\1\164\2\172\2\156\1\162\1\145\1\162\1\157\1\76\3\uffff\1\156\1\157\1\141\1\165\1\164\1\146\1\166\1\164\1\161\1\154\1\162\15\uffff\1\164\1\163\1\157\1\164\1\163\1\156\1\uffff\1\151\1\uffff\1\144\2\uffff\1\150\2\145\1\162\1\144\1\172\1\162\1\165\1\uffff\1\156\1\157\1\165\1\150\1\156\1\145\1\uffff\1\162\2\154\2\164\1\155\1\143\1\154\1\164\1\154\1\163\1\155\1\172\1\141\1\154\1\172\1\162\2\uffff\1\143\1\147\1\145\1\166\1\145\1\143\1\165\1\162\2\uffff\1\164\1\160\1\163\1\162\1\141\1\142\1\145\1\141\1\151\1\160\1\151\1\155\1\145\1\150\1\157\1\145\2\165\1\163\1\150\1\145\1\154\1\145\1\164\1\147\1\155\1\145\1\156\2\172\1\157\1\141\1\162\1\uffff\1\141\2\164\1\162\1\164\1\151\2\143\1\145\2\151\1\155\1\172\1\157\2\145\1\151\1\164\1\144\1\157\1\164\1\145\1\172\1\141\1\uffff\1\164\1\151\1\uffff\1\141\1\172\1\154\1\105\1\151\1\143\1\151\1\143\1\156\1\164\1\145\1\154\2\165\1\172\1\151\1\154\2\172\1\165\1\164\1\157\1\162\1\172\1\156\1\141\1\163\1\162\1\151\1\145\1\144\1\151\1\172\1\144\1\145\3\172\1\160\1\172\1\157\1\172\1\145\2\uffff\1\163\1\164\1\156\1\163\1\172\1\151\1\164\1\141\1\164\1\172\1\164\1\147\2\143\1\145\1\uffff\1\143\1\162\1\144\1\164\1\151\1\163\1\162\2\172\1\uffff\1\164\1\172\2\164\1\uffff\1\145\1\146\1\143\1\164\1\146\1\164\1\147\1\172\1\151\1\170\1\145\1\156\1\162\1\uffff\1\156\1\145\1\171\1\146\2\uffff\1\154\1\171\1\151\1\157\1\uffff\1\144\1\156\1\151\1\163\1\162\1\117\1\141\1\157\1\uffff\1\172\1\141\3\uffff\1\154\1\uffff\1\154\1\uffff\1\146\1\145\1\157\2\141\1\164\1\uffff\1\146\1\172\1\142\1\145\1\uffff\1\172\2\141\1\172\1\164\1\157\1\164\1\165\1\151\1\157\1\172\1\171\1\uffff\1\172\1\uffff\1\171\1\151\1\166\1\146\1\145\1\157\1\151\1\165\1\172\1\uffff\1\156\1\164\1\170\1\151\1\145\1\123\1\172\1\160\1\157\1\164\1\172\2\156\1\163\1\147\1\164\1\145\1\172\1\145\1\142\1\164\1\156\1\uffff\1\156\1\172\1\157\1\172\2\162\1\154\1\143\1\162\1\151\1\uffff\1\154\1\143\1\172\1\uffff\2\164\1\uffff\1\145\1\154\1\151\1\162\1\166\1\156\1\uffff\2\172\1\uffff\1\172\1\157\1\141\1\145\1\172\1\162\1\143\1\162\1\uffff\1\145\2\172\1\143\1\172\1\166\1\145\1\uffff\1\145\1\162\1\172\1\uffff\1\164\1\155\1\172\1\145\1\157\1\144\1\uffff\1\144\1\152\1\157\2\172\1\uffff\1\147\1\uffff\1\166\1\171\1\172\1\145\1\165\2\145\1\164\1\uffff\1\145\1\151\1\162\1\172\3\145\1\172\3\uffff\1\156\1\154\1\143\1\uffff\1\172\1\141\1\145\1\162\2\uffff\1\141\1\uffff\1\145\1\162\1\163\1\155\1\uffff\1\163\1\145\1\uffff\1\137\1\162\2\172\1\145\1\162\2\uffff\1\171\1\151\1\172\1\uffff\1\172\1\143\1\162\1\172\1\165\1\172\1\157\1\163\1\172\1\uffff\1\163\2\172\1\154\1\uffff\2\172\1\164\1\uffff\1\164\1\172\1\163\1\164\1\156\1\166\1\172\1\141\1\172\1\156\1\160\1\171\2\uffff\1\143\2\172\1\143\1\uffff\1\172\1\uffff\1\164\1\172\1\uffff\1\162\1\uffff\1\156\1\172\1\uffff\1\172\2\uffff\2\172\2\uffff\1\106\1\151\1\uffff\1\172\1\151\1\164\1\151\1\uffff\1\164\1\uffff\1\164\1\141\1\172\1\164\2\uffff\1\145\1\uffff\1\165\1\uffff\1\145\1\123\4\uffff\1\162\1\157\1\uffff\1\157\1\172\1\143\1\172\1\163\1\164\1\uffff\2\172\1\162\1\172\2\145\2\156\1\uffff\1\145\1\uffff\1\172\1\164\1\uffff\1\172\1\uffff\1\145\1\uffff\1\162\1\145\1\172\1\137\1\172\1\uffff\1\145\1\uffff\1\172\1\166\1\172\1\uffff\1\164\1\uffff\1\162\1\145\1\uffff\1\151\1\uffff\1\171\1\156\1\162\1\143\1\160\1\172\1\166\2\145\1\uffff\1\151\2\172\1\143\2\uffff\1\145\1\172\1\uffff";
    static final String DFA15_acceptS =
        "\1\uffff\1\1\20\uffff\1\53\1\54\1\uffff\1\67\1\uffff\1\72\1\73\1\74\1\101\1\105\3\uffff\1\122\1\uffff\1\147\1\uffff\1\160\1\uffff\1\162\2\uffff\1\166\1\167\1\1\3\uffff\1\162\35\uffff\1\121\1\20\1\160\13\uffff\1\53\1\54\1\56\1\65\1\67\1\164\1\165\1\71\1\72\1\73\1\74\1\101\1\105\6\uffff\1\122\1\uffff\1\147\1\uffff\1\163\1\166\10\uffff\1\12\6\uffff\1\77\21\uffff\1\70\1\114\10\uffff\1\21\1\17\41\uffff\1\141\30\uffff\1\125\2\uffff\1\13\53\uffff\1\52\1\161\17\uffff\1\46\11\uffff\1\76\4\uffff\1\15\15\uffff\1\135\4\uffff\1\107\1\136\4\uffff\1\131\10\uffff\1\111\2\uffff\1\134\1\115\1\142\1\uffff\1\155\1\uffff\1\27\6\uffff\1\14\4\uffff\1\16\14\uffff\1\146\1\uffff\1\140\11\uffff\1\143\26\uffff\1\113\12\uffff\1\75\3\uffff\1\124\2\uffff\1\6\6\uffff\1\30\2\uffff\1\112\10\uffff\1\144\7\uffff\1\137\3\uffff\1\36\6\uffff\1\106\5\uffff\1\145\1\uffff\1\104\10\uffff\1\55\10\uffff\1\37\1\110\1\10\3\uffff\1\42\4\uffff\1\127\1\66\1\uffff\1\47\4\uffff\1\150\2\uffff\1\130\6\uffff\1\102\1\133\3\uffff\1\4\11\uffff\1\153\4\uffff\1\132\3\uffff\1\123\14\uffff\1\63\1\103\4\uffff\1\22\1\uffff\1\61\2\uffff\1\156\1\uffff\1\32\2\uffff\1\57\1\uffff\1\157\1\64\2\uffff\1\62\1\23\2\uffff\1\116\4\uffff\1\126\1\uffff\1\60\4\uffff\1\51\1\2\1\uffff\1\24\1\uffff\1\45\2\uffff\1\26\1\120\1\7\1\25\2\uffff\1\31\6\uffff\1\41\10\uffff\1\34\1\uffff\1\154\2\uffff\1\44\1\uffff\1\100\1\uffff\1\5\5\uffff\1\117\1\uffff\1\3\3\uffff\1\43\1\uffff\1\35\2\uffff\1\11\1\uffff\1\50\11\uffff\1\151\4\uffff\1\33\1\152\2\uffff\1\40";
    static final String DFA15_specialS =
        "\1\2\45\uffff\1\0\1\1\u0270\uffff}>";
    static final String[] DFA15_transitionS = {
            "\11\51\2\50\2\51\1\50\22\51\1\50\1\51\1\46\4\51\1\47\1\30\1\31\2\51\1\27\1\14\1\25\1\26\12\43\1\24\1\1\1\13\1\33\1\37\1\41\1\32\32\45\3\51\1\44\1\45\1\51\1\5\1\35\1\15\1\16\1\17\1\7\1\45\1\42\1\4\2\45\1\36\1\3\1\40\1\11\1\6\1\45\1\20\1\12\1\2\1\10\1\21\1\34\3\45\1\22\1\51\1\23\uff82\51",
            "",
            "\1\53\14\uffff\1\55\6\uffff\1\54",
            "\1\60\7\uffff\1\57",
            "\1\62\10\uffff\1\63\1\61",
            "\1\66\10\uffff\1\67\1\uffff\1\64\1\65",
            "\1\71\20\uffff\1\72\2\uffff\1\70",
            "\1\75\7\uffff\1\74\2\uffff\1\100\2\uffff\1\77\2\uffff\1\76\2\uffff\1\73",
            "\1\101",
            "\1\104\1\uffff\1\103\4\uffff\1\102",
            "\1\107\2\uffff\1\112\1\106\6\uffff\1\110\3\uffff\1\111\4\uffff\1\105",
            "\1\113",
            "\12\116\4\uffff\1\115",
            "\1\121\3\uffff\1\120\2\uffff\1\117",
            "\1\123\3\uffff\1\124\11\uffff\1\122",
            "\1\125\11\uffff\1\126",
            "\1\127",
            "\1\130\3\uffff\1\131",
            "",
            "",
            "\1\134",
            "",
            "\1\137\4\uffff\1\140",
            "",
            "",
            "",
            "",
            "",
            "\1\147",
            "\1\150\15\uffff\1\151\11\uffff\1\152",
            "\1\153\5\uffff\1\154",
            "",
            "\1\156",
            "",
            "\1\160",
            "",
            "\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "\0\161",
            "\0\161",
            "",
            "",
            "",
            "\1\163",
            "\1\164",
            "\1\165",
            "",
            "\1\166",
            "\1\167",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\5\56\1\171\10\56\1\172\4\56\1\170\6\56",
            "\1\174",
            "\1\176\2\uffff\1\175",
            "\1\177",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\17\56\1\u0081\10\56\1\u0080\1\56",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0088\5\uffff\1\u0087",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b\10\uffff\1\u008d\10\uffff\1\u008c",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\4\56\1\u0093\25\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u0096",
            "\1\u0098\11\uffff\1\u0097",
            "\1\u009a\5\uffff\1\u0099",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "",
            "",
            "",
            "\1\u00a1\1\u00a0",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4\7\uffff\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a9\17\uffff\1\u00a8\1\u00ab\1\u00aa",
            "\1\u00ad\20\uffff\1\u00ac",
            "\1\u00af\11\uffff\1\u00ae\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "",
            "\1\u00b9",
            "",
            "\1\u00ba",
            "",
            "",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\4\56\1\u00c0\25\56",
            "\1\u00c2",
            "\1\u00c3",
            "",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd\22\uffff\1\u00ce",
            "\1\u00d1\14\uffff\1\u00d0\3\uffff\1\u00cf",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\14\56\1\u00d9\15\56",
            "\1\u00db",
            "\1\u00dc",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u00de",
            "",
            "",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e6\13\uffff\1\u00e5",
            "\1\u00e7",
            "",
            "",
            "\1\u00e8",
            "\1\u00ea\2\uffff\1\u00e9",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00ef\3\uffff\1\u00f0",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "\1\u00f8",
            "\1\u00f9",
            "\1\u00fa",
            "\1\u00fc\13\uffff\1\u00fb",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "\1\u0105",
            "\1\u0106",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\3\56\1\u0108\16\56\1\u0107\7\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
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
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u011b",
            "\1\u011c",
            "\1\u011d",
            "\1\u011e",
            "\1\u011f",
            "\1\u0120",
            "\1\u0121",
            "\1\u0122",
            "\1\u0123",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u0125",
            "",
            "\1\u0126",
            "\1\u0127",
            "",
            "\1\u0128",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u012a",
            "\1\u012b",
            "\1\u012c",
            "\1\u012d",
            "\1\u012e",
            "\1\u012f",
            "\1\u0130",
            "\1\u0131",
            "\1\u0132\3\uffff\1\u0133",
            "\1\u0134",
            "\1\u0135",
            "\1\u0136",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u0138",
            "\1\u0139",
            "\12\56\7\uffff\32\56\4\uffff\1\u013b\1\uffff\23\56\1\u013a\6\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u013e",
            "\1\u013f",
            "\1\u0140",
            "\1\u0141",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u0143",
            "\1\u0144",
            "\1\u0145",
            "\1\u0146",
            "\1\u0147",
            "\1\u0148",
            "\1\u0149",
            "\1\u014a",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u014c",
            "\1\u014d",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u0151",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u0153",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u0155",
            "",
            "",
            "\1\u0156",
            "\1\u0157",
            "\1\u0159\7\uffff\1\u0158",
            "\1\u015a",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u015c",
            "\1\u015d",
            "\1\u015e",
            "\1\u015f",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u0161",
            "\1\u0162",
            "\1\u0163",
            "\1\u0164",
            "\1\u0165",
            "",
            "\1\u0166",
            "\1\u0167",
            "\1\u0168",
            "\1\u0169",
            "\1\u016a",
            "\1\u016b",
            "\1\u016c",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "\1\u016e",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u0170",
            "\1\u0171",
            "",
            "\1\u0172",
            "\1\u0173",
            "\1\u0174",
            "\1\u0175",
            "\1\u0176",
            "\1\u0177",
            "\1\u0178",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u017a",
            "\1\u017b",
            "\1\u017c",
            "\1\u017d",
            "\1\u017e",
            "",
            "\1\u017f",
            "\1\u0180",
            "\1\u0181",
            "\1\u0182",
            "",
            "",
            "\1\u0183",
            "\1\u0184",
            "\1\u0185",
            "\1\u0186",
            "",
            "\1\u0187",
            "\1\u0188",
            "\1\u0189",
            "\1\u018a\1\u018b",
            "\1\u018c",
            "\1\u018d",
            "\1\u018e",
            "\1\u018f",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u0191",
            "",
            "",
            "",
            "\1\u0192",
            "",
            "\1\u0193",
            "",
            "\1\u0194",
            "\1\u0195",
            "\1\u0196",
            "\1\u0197",
            "\1\u0198",
            "\1\u0199",
            "",
            "\1\u019a",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u019c",
            "\1\u019d",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\22\56\1\u019e\7\56",
            "\1\u01a0",
            "\1\u01a1",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u01a3",
            "\1\u01a4",
            "\1\u01a5",
            "\1\u01a6",
            "\1\u01a7",
            "\1\u01a8",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u01aa",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\22\56\1\u01ab\7\56",
            "",
            "\1\u01ad",
            "\1\u01ae",
            "\1\u01af",
            "\1\u01b0",
            "\1\u01b1",
            "\1\u01b2",
            "\1\u01b3",
            "\1\u01b4",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "\1\u01b6",
            "\1\u01b7",
            "\1\u01b8",
            "\1\u01b9",
            "\1\u01ba",
            "\1\u01bb\15\uffff\1\u01bc",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u01be",
            "\1\u01bf",
            "\1\u01c0",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u01c2",
            "\1\u01c3",
            "\1\u01c4",
            "\1\u01c5",
            "\1\u01c6",
            "\1\u01c7",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u01c9",
            "\1\u01ca",
            "\1\u01cb",
            "\1\u01cc",
            "",
            "\1\u01cd",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u01cf",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u01d1",
            "\1\u01d2",
            "\1\u01d3",
            "\1\u01d4",
            "\1\u01d5",
            "\1\u01d6",
            "",
            "\1\u01d7",
            "\1\u01d8",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "\1\u01da",
            "\1\u01db",
            "",
            "\1\u01dc",
            "\1\u01dd",
            "\1\u01de",
            "\1\u01df",
            "\1\u01e0",
            "\1\u01e1",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u01e5",
            "\1\u01e6",
            "\1\u01e7",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u01e9",
            "\1\u01ea",
            "\1\u01eb",
            "",
            "\1\u01ec",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u01ef",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u01f1",
            "\1\u01f2",
            "",
            "\1\u01f3",
            "\1\u01f4",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "\1\u01f6",
            "\1\u01f7",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u01f9",
            "\1\u01fa",
            "\1\u01fb",
            "",
            "\1\u01fc",
            "\1\u01fd",
            "\1\u01fe",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "\1\u0201",
            "",
            "\1\u0202",
            "\1\u0203",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u0205",
            "\1\u0206",
            "\1\u0207",
            "\1\u0208",
            "\1\u0209",
            "",
            "\1\u020a",
            "\1\u020b",
            "\1\u020c",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\22\56\1\u020d\7\56",
            "\1\u020f",
            "\1\u0210",
            "\1\u0211",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\1\u0212\31\56",
            "",
            "",
            "",
            "\1\u0214",
            "\1\u0215",
            "\1\u0216",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u0218",
            "\1\u0219",
            "\1\u021a",
            "",
            "",
            "\1\u021b",
            "",
            "\1\u021c",
            "\1\u021d",
            "\1\u021e",
            "\1\u021f",
            "",
            "\1\u0220",
            "\1\u0221",
            "",
            "\1\u0222",
            "\1\u0223",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u0226",
            "\1\u0227",
            "",
            "",
            "\1\u0228",
            "\1\u0229",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\22\56\1\u022b\7\56",
            "\1\u022d",
            "\1\u022e",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u0230",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u0232",
            "\1\u0233",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "\1\u0235",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u0238",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\22\56\1\u0239\7\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u023c",
            "",
            "\1\u023d",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u023f",
            "\1\u0240",
            "\1\u0241",
            "\1\u0242",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u0244",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u0246",
            "\1\u0247",
            "\1\u0248",
            "",
            "",
            "\1\u0249",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u024c",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "\1\u024e",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "\1\u0250",
            "",
            "\1\u0251",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "",
            "\1\u0256",
            "\1\u0257",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u0259",
            "\1\u025a",
            "\1\u025b",
            "",
            "\1\u025c",
            "",
            "\1\u025d",
            "\1\u025e",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u0260",
            "",
            "",
            "\1\u0261",
            "",
            "\1\u0262",
            "",
            "\1\u0263",
            "\1\u0264",
            "",
            "",
            "",
            "",
            "\1\u0265",
            "\1\u0266",
            "",
            "\1\u0267",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u0269",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u026b",
            "\1\u026c",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\22\56\1\u026e\7\56",
            "\1\u0270",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u0272",
            "\1\u0273",
            "\1\u0274",
            "\1\u0275",
            "",
            "\1\u0276",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u0278",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "\1\u027a",
            "",
            "\1\u027b",
            "\1\u027c",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u027e",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "\1\u0280",
            "",
            "\12\56\7\uffff\22\56\1\u0281\7\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u0283",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "\1\u0285",
            "",
            "\1\u0286",
            "\1\u0287",
            "",
            "\1\u0288",
            "",
            "\1\u0289",
            "\1\u028a",
            "\1\u028b",
            "\1\u028c",
            "\1\u028d",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u028f",
            "\1\u0290",
            "\1\u0291",
            "",
            "\1\u0292",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\u0295",
            "",
            "",
            "\1\u0296",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
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
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | RULE_BIG_DECIMAL | RULE_BOOLEAN | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA15_38 = input.LA(1);

                        s = -1;
                        if ( ((LA15_38>='\u0000' && LA15_38<='\uFFFF')) ) {s = 113;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA15_39 = input.LA(1);

                        s = -1;
                        if ( ((LA15_39>='\u0000' && LA15_39<='\uFFFF')) ) {s = 113;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA15_0 = input.LA(1);

                        s = -1;
                        if ( (LA15_0==';') ) {s = 1;}

                        else if ( (LA15_0=='t') ) {s = 2;}

                        else if ( (LA15_0=='m') ) {s = 3;}

                        else if ( (LA15_0=='i') ) {s = 4;}

                        else if ( (LA15_0=='a') ) {s = 5;}

                        else if ( (LA15_0=='p') ) {s = 6;}

                        else if ( (LA15_0=='f') ) {s = 7;}

                        else if ( (LA15_0=='u') ) {s = 8;}

                        else if ( (LA15_0=='o') ) {s = 9;}

                        else if ( (LA15_0=='s') ) {s = 10;}

                        else if ( (LA15_0=='<') ) {s = 11;}

                        else if ( (LA15_0=='-') ) {s = 12;}

                        else if ( (LA15_0=='c') ) {s = 13;}

                        else if ( (LA15_0=='d') ) {s = 14;}

                        else if ( (LA15_0=='e') ) {s = 15;}

                        else if ( (LA15_0=='r') ) {s = 16;}

                        else if ( (LA15_0=='v') ) {s = 17;}

                        else if ( (LA15_0=='{') ) {s = 18;}

                        else if ( (LA15_0=='}') ) {s = 19;}

                        else if ( (LA15_0==':') ) {s = 20;}

                        else if ( (LA15_0=='.') ) {s = 21;}

                        else if ( (LA15_0=='/') ) {s = 22;}

                        else if ( (LA15_0==',') ) {s = 23;}

                        else if ( (LA15_0=='(') ) {s = 24;}

                        else if ( (LA15_0==')') ) {s = 25;}

                        else if ( (LA15_0=='@') ) {s = 26;}

                        else if ( (LA15_0=='=') ) {s = 27;}

                        else if ( (LA15_0=='w') ) {s = 28;}

                        else if ( (LA15_0=='b') ) {s = 29;}

                        else if ( (LA15_0=='l') ) {s = 30;}

                        else if ( (LA15_0=='>') ) {s = 31;}

                        else if ( (LA15_0=='n') ) {s = 32;}

                        else if ( (LA15_0=='?') ) {s = 33;}

                        else if ( (LA15_0=='h') ) {s = 34;}

                        else if ( ((LA15_0>='0' && LA15_0<='9')) ) {s = 35;}

                        else if ( (LA15_0=='^') ) {s = 36;}

                        else if ( ((LA15_0>='A' && LA15_0<='Z')||LA15_0=='_'||LA15_0=='g'||(LA15_0>='j' && LA15_0<='k')||LA15_0=='q'||(LA15_0>='x' && LA15_0<='z')) ) {s = 37;}

                        else if ( (LA15_0=='\"') ) {s = 38;}

                        else if ( (LA15_0=='\'') ) {s = 39;}

                        else if ( ((LA15_0>='\t' && LA15_0<='\n')||LA15_0=='\r'||LA15_0==' ') ) {s = 40;}

                        else if ( ((LA15_0>='\u0000' && LA15_0<='\b')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='\u001F')||LA15_0=='!'||(LA15_0>='#' && LA15_0<='&')||(LA15_0>='*' && LA15_0<='+')||(LA15_0>='[' && LA15_0<=']')||LA15_0=='`'||LA15_0=='|'||(LA15_0>='~' && LA15_0<='\uFFFF')) ) {s = 41;}

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