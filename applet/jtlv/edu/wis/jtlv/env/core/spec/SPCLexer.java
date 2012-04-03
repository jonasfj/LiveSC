// $ANTLR 3.0.1 /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g 2008-09-25 14:58:32

package edu.wis.jtlv.env.core.spec;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;

import edu.wis.jtlv.env.Env;

public class SPCLexer extends Lexer {
    public static final int SPEC_LIST_T=5;
    public static final int TOK_OP_HISTORICALLY=79;
    public static final int TOK_CASE=52;
    public static final int NOP=4;
    public static final int EOF=-1;
    public static final int TOK_ABF=63;
    public static final int TOK_NOT=46;
    public static final int TOK_ABG=65;
    public static final int TOK_EX=56;
    public static final int TOK_WORD=91;
    public static final int VALUE_T=7;
    public static final int SET_LIST_EXP_T=8;
    public static final int TOK_LTL_SPEC=19;
    public static final int TOK_TIMES=43;
    public static final int TOK_TRIGGERED=74;
    public static final int TOK_RSHIFT=39;
    public static final int ARRAY_INDEX_T=13;
    public static final int TOK_EG=60;
    public static final int TOK_EF=58;
    public static final int TOK_SINCE=72;
    public static final int TOK_EE=70;
    public static final int TOK_IFF=22;
    public static final int TOK_RELEASES=73;
    public static final int TOK_UNARY_MINUS_T=14;
    public static final int TOK_OP_NEXT=75;
    public static final int TOK_IMPLIES=21;
    public static final int TOK_CTL_STAR_SPEC=20;
    public static final int TOK_FALSEEXP=89;
    public static final int TOK_ESAC=53;
    public static final int TOK_NOTEQUAL=28;
    public static final int JTOK_MULTI_COMMENT=94;
    public static final int TOK_SEMI=86;
    public static final int TOK_WAWRITE=55;
    public static final int JTOK_LINE_COMMENT=95;
    public static final int TOK_XOR=24;
    public static final int TOK_GT=30;
    public static final int TOK_PLUS=41;
    public static final int TOK_NUMBER=84;
    public static final int BIT_SELECT_T=12;
    public static final int TOK_COMMA=37;
    public static final int TOK_UNION=34;
    public static final int PURE_LTL_T=16;
    public static final int TOK_GE=32;
    public static final int TOK_DIVIDE=44;
    public static final int TOK_OR=23;
    public static final int TOK_OP_FINALLY=80;
    public static final int TOK_RCB=36;
    public static final int TOK_RP=48;
    public static final int CASE_ELEMENT_EXPR_T=11;
    public static final int TOK_AA=66;
    public static final int TOK_NEXT=51;
    public static final int TOK_CONCATENATION=45;
    public static final int TOK_NUMBER_WORD=87;
    public static final int TOK_WAREAD=54;
    public static final int TOK_AF=59;
    public static final int TOK_AG=61;
    public static final int TOK_EBG=64;
    public static final int TOK_EBF=62;
    public static final int TOK_DOT=83;
    public static final int TOK_NUMBER_FRAC=92;
    public static final int TOK_LCB=35;
    public static final int PURE_CTL_T=15;
    public static final int TOK_AX=57;
    public static final int TOK_AND=26;
    public static final int TOK_COLON=85;
    public static final int TOK_INVAR_SPEC=17;
    public static final int TOK_XNOR=25;
    public static final int SUBRANGE_T=6;
    public static final int TOK_MOD=40;
    public static final int TOK_BUNTIL=71;
    public static final int BLOCK_T=9;
    public static final int TOK_RB=69;
    public static final int TOK_OP_NOTPREVNOT=77;
    public static final int TOK_UNTIL=68;
    public static final int JTOK_WS=93;
    public static final int TOK_LP=47;
    public static final int TOK_BOOL=49;
    public static final int TOK_LT=29;
    public static final int CASE_LIST_EXPR_T=10;
    public static final int TOK_SETIN=33;
    public static final int TOK_CTL_SPEC=18;
    public static final int TOK_LB=67;
    public static final int TOK_TWODOTS=88;
    public static final int TOK_WORD1=50;
    public static final int TOK_OP_PREV=76;
    public static final int Tokens=96;
    public static final int TOK_LE=31;
    public static final int TOK_TRUEEXP=90;
    public static final int TOK_OP_GLOBALLY=78;
    public static final int TOK_ATOM=82;
    public static final int TOK_OP_ONCE=81;
    public static final int TOK_LSHIFT=38;
    public static final int TOK_MINUS=42;
    public static final int TOK_EQUAL=27;

    public String getErrorMessage(RecognitionException e, String[] tokenNames) {
    	String msg = null;
    	if (e instanceof SpecParseException) {
    		msg = e.toString();
    		Env.doError(e, msg);
    	} else {
    		msg = super.getErrorMessage(e, tokenNames);
    		Env.doError(e, msg);
    	}
    	return msg;
    }
    public void emitErrorMessage(String msg) {
    	// System.err.println(msg);
    	// do nothing.
    }

    public SPCLexer() {;} 
    public SPCLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "/home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g"; }

    // $ANTLR start TOK_CTL_SPEC
    public final void mTOK_CTL_SPEC() throws RecognitionException {
        try {
            int _type = TOK_CTL_SPEC;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1323:17: ( 'CTLSPEC' | 'SPEC' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='C') ) {
                alt1=1;
            }
            else if ( (LA1_0=='S') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1323:1: TOK_CTL_SPEC : ( 'CTLSPEC' | 'SPEC' );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1323:19: 'CTLSPEC'
                    {
                    match("CTLSPEC"); 


                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1323:31: 'SPEC'
                    {
                    match("SPEC"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_CTL_SPEC

    // $ANTLR start TOK_CTL_STAR_SPEC
    public final void mTOK_CTL_STAR_SPEC() throws RecognitionException {
        try {
            int _type = TOK_CTL_STAR_SPEC;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1324:21: ( 'CTL*SPEC' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1324:23: 'CTL*SPEC'
            {
            match("CTL*SPEC"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_CTL_STAR_SPEC

    // $ANTLR start TOK_LTL_SPEC
    public final void mTOK_LTL_SPEC() throws RecognitionException {
        try {
            int _type = TOK_LTL_SPEC;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1325:17: ( 'LTLSPEC' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1325:19: 'LTLSPEC'
            {
            match("LTLSPEC"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_LTL_SPEC

    // $ANTLR start TOK_INVAR_SPEC
    public final void mTOK_INVAR_SPEC() throws RecognitionException {
        try {
            int _type = TOK_INVAR_SPEC;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1326:19: ( 'INVARSPEC' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1326:21: 'INVARSPEC'
            {
            match("INVARSPEC"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_INVAR_SPEC

    // $ANTLR start TOK_EX
    public final void mTOK_EX() throws RecognitionException {
        try {
            int _type = TOK_EX;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1328:13: ( 'EX' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1328:15: 'EX'
            {
            match("EX"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_EX

    // $ANTLR start TOK_AX
    public final void mTOK_AX() throws RecognitionException {
        try {
            int _type = TOK_AX;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1329:13: ( 'AX' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1329:15: 'AX'
            {
            match("AX"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_AX

    // $ANTLR start TOK_EF
    public final void mTOK_EF() throws RecognitionException {
        try {
            int _type = TOK_EF;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1330:13: ( 'EF' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1330:15: 'EF'
            {
            match("EF"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_EF

    // $ANTLR start TOK_AF
    public final void mTOK_AF() throws RecognitionException {
        try {
            int _type = TOK_AF;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1331:13: ( 'AF' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1331:15: 'AF'
            {
            match("AF"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_AF

    // $ANTLR start TOK_EG
    public final void mTOK_EG() throws RecognitionException {
        try {
            int _type = TOK_EG;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1332:13: ( 'EG' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1332:15: 'EG'
            {
            match("EG"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_EG

    // $ANTLR start TOK_AG
    public final void mTOK_AG() throws RecognitionException {
        try {
            int _type = TOK_AG;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1333:13: ( 'AG' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1333:15: 'AG'
            {
            match("AG"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_AG

    // $ANTLR start TOK_EE
    public final void mTOK_EE() throws RecognitionException {
        try {
            int _type = TOK_EE;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1334:13: ( 'E' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1334:15: 'E'
            {
            match('E'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_EE

    // $ANTLR start TOK_AA
    public final void mTOK_AA() throws RecognitionException {
        try {
            int _type = TOK_AA;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1335:13: ( 'A' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1335:15: 'A'
            {
            match('A'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_AA

    // $ANTLR start TOK_BUNTIL
    public final void mTOK_BUNTIL() throws RecognitionException {
        try {
            int _type = TOK_BUNTIL;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1336:16: ( 'BU' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1336:18: 'BU'
            {
            match("BU"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_BUNTIL

    // $ANTLR start TOK_EBF
    public final void mTOK_EBF() throws RecognitionException {
        try {
            int _type = TOK_EBF;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1337:14: ( 'EBF' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1337:16: 'EBF'
            {
            match("EBF"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_EBF

    // $ANTLR start TOK_ABF
    public final void mTOK_ABF() throws RecognitionException {
        try {
            int _type = TOK_ABF;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1338:14: ( 'ABF' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1338:16: 'ABF'
            {
            match("ABF"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_ABF

    // $ANTLR start TOK_EBG
    public final void mTOK_EBG() throws RecognitionException {
        try {
            int _type = TOK_EBG;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1339:14: ( 'EBG' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1339:16: 'EBG'
            {
            match("EBG"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_EBG

    // $ANTLR start TOK_ABG
    public final void mTOK_ABG() throws RecognitionException {
        try {
            int _type = TOK_ABG;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1340:14: ( 'ABG' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1340:16: 'ABG'
            {
            match("ABG"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_ABG

    // $ANTLR start TOK_OP_FINALLY
    public final void mTOK_OP_FINALLY() throws RecognitionException {
        try {
            int _type = TOK_OP_FINALLY;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1342:19: ( '<>' | 'F' | 'FINALLY' | 'EVENTUALLY' )
            int alt2=4;
            switch ( input.LA(1) ) {
            case '<':
                {
                alt2=1;
                }
                break;
            case 'F':
                {
                int LA2_2 = input.LA(2);

                if ( (LA2_2=='I') ) {
                    alt2=3;
                }
                else {
                    alt2=2;}
                }
                break;
            case 'E':
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1342:1: TOK_OP_FINALLY : ( '<>' | 'F' | 'FINALLY' | 'EVENTUALLY' );", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1342:21: '<>'
                    {
                    match("<>"); 


                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1342:28: 'F'
                    {
                    match('F'); 

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1342:34: 'FINALLY'
                    {
                    match("FINALLY"); 


                    }
                    break;
                case 4 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1342:46: 'EVENTUALLY'
                    {
                    match("EVENTUALLY"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_OP_FINALLY

    // $ANTLR start TOK_OP_ONCE
    public final void mTOK_OP_ONCE() throws RecognitionException {
        try {
            int _type = TOK_OP_ONCE;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1343:17: ( '<_>' | 'O' | 'ONCE' )
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='<') ) {
                alt3=1;
            }
            else if ( (LA3_0=='O') ) {
                int LA3_2 = input.LA(2);

                if ( (LA3_2=='N') ) {
                    alt3=3;
                }
                else {
                    alt3=2;}
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1343:1: TOK_OP_ONCE : ( '<_>' | 'O' | 'ONCE' );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1343:19: '<_>'
                    {
                    match("<_>"); 


                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1343:27: 'O'
                    {
                    match('O'); 

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1343:33: 'ONCE'
                    {
                    match("ONCE"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_OP_ONCE

    // $ANTLR start TOK_OP_GLOBALLY
    public final void mTOK_OP_GLOBALLY() throws RecognitionException {
        try {
            int _type = TOK_OP_GLOBALLY;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1344:20: ( '[]' | 'G' | 'GLOBALLY' | 'ALWAYS' )
            int alt4=4;
            switch ( input.LA(1) ) {
            case '[':
                {
                alt4=1;
                }
                break;
            case 'G':
                {
                int LA4_2 = input.LA(2);

                if ( (LA4_2=='L') ) {
                    alt4=3;
                }
                else {
                    alt4=2;}
                }
                break;
            case 'A':
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1344:1: TOK_OP_GLOBALLY : ( '[]' | 'G' | 'GLOBALLY' | 'ALWAYS' );", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1344:22: '[]'
                    {
                    match("[]"); 


                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1344:29: 'G'
                    {
                    match('G'); 

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1344:35: 'GLOBALLY'
                    {
                    match("GLOBALLY"); 


                    }
                    break;
                case 4 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1344:48: 'ALWAYS'
                    {
                    match("ALWAYS"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_OP_GLOBALLY

    // $ANTLR start TOK_OP_HISTORICALLY
    public final void mTOK_OP_HISTORICALLY() throws RecognitionException {
        try {
            int _type = TOK_OP_HISTORICALLY;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1345:23: ( '[_]' | 'H' | 'HISTORICALLY' )
            int alt5=3;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='[') ) {
                alt5=1;
            }
            else if ( (LA5_0=='H') ) {
                int LA5_2 = input.LA(2);

                if ( (LA5_2=='I') ) {
                    alt5=3;
                }
                else {
                    alt5=2;}
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1345:1: TOK_OP_HISTORICALLY : ( '[_]' | 'H' | 'HISTORICALLY' );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1345:25: '[_]'
                    {
                    match("[_]"); 


                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1345:33: 'H'
                    {
                    match('H'); 

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1345:39: 'HISTORICALLY'
                    {
                    match("HISTORICALLY"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_OP_HISTORICALLY

    // $ANTLR start TOK_OP_NEXT
    public final void mTOK_OP_NEXT() throws RecognitionException {
        try {
            int _type = TOK_OP_NEXT;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1346:17: ( '()' | 'X' | 'NEXT' )
            int alt6=3;
            switch ( input.LA(1) ) {
            case '(':
                {
                alt6=1;
                }
                break;
            case 'X':
                {
                alt6=2;
                }
                break;
            case 'N':
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1346:1: TOK_OP_NEXT : ( '()' | 'X' | 'NEXT' );", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1346:19: '()'
                    {
                    match("()"); 


                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1346:26: 'X'
                    {
                    match('X'); 

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1346:32: 'NEXT'
                    {
                    match("NEXT"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_OP_NEXT

    // $ANTLR start TOK_OP_PREV
    public final void mTOK_OP_PREV() throws RecognitionException {
        try {
            int _type = TOK_OP_PREV;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1347:17: ( '(_)' | 'Y' | 'PREV' )
            int alt7=3;
            switch ( input.LA(1) ) {
            case '(':
                {
                alt7=1;
                }
                break;
            case 'Y':
                {
                alt7=2;
                }
                break;
            case 'P':
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1347:1: TOK_OP_PREV : ( '(_)' | 'Y' | 'PREV' );", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1347:19: '(_)'
                    {
                    match("(_)"); 


                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1347:27: 'Y'
                    {
                    match('Y'); 

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1347:33: 'PREV'
                    {
                    match("PREV"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_OP_PREV

    // $ANTLR start TOK_UNTIL
    public final void mTOK_UNTIL() throws RecognitionException {
        try {
            int _type = TOK_UNTIL;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1348:15: ( 'Until' | 'U' | 'UNTIL' )
            int alt8=3;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='U') ) {
                switch ( input.LA(2) ) {
                case 'N':
                    {
                    alt8=3;
                    }
                    break;
                case 'n':
                    {
                    alt8=1;
                    }
                    break;
                default:
                    alt8=2;}

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1348:1: TOK_UNTIL : ( 'Until' | 'U' | 'UNTIL' );", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1348:17: 'Until'
                    {
                    match("Until"); 


                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1348:27: 'U'
                    {
                    match('U'); 

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1348:33: 'UNTIL'
                    {
                    match("UNTIL"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_UNTIL

    // $ANTLR start TOK_SINCE
    public final void mTOK_SINCE() throws RecognitionException {
        try {
            int _type = TOK_SINCE;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1349:15: ( 'Since' | 'S' | 'SINCE' )
            int alt9=3;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='S') ) {
                switch ( input.LA(2) ) {
                case 'I':
                    {
                    alt9=3;
                    }
                    break;
                case 'i':
                    {
                    alt9=1;
                    }
                    break;
                default:
                    alt9=2;}

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1349:1: TOK_SINCE : ( 'Since' | 'S' | 'SINCE' );", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1349:17: 'Since'
                    {
                    match("Since"); 


                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1349:27: 'S'
                    {
                    match('S'); 

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1349:33: 'SINCE'
                    {
                    match("SINCE"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_SINCE

    // $ANTLR start TOK_RELEASES
    public final void mTOK_RELEASES() throws RecognitionException {
        try {
            int _type = TOK_RELEASES;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1350:17: ( 'Awaits' | 'V' | 'RELEASES' )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 'A':
                {
                alt10=1;
                }
                break;
            case 'V':
                {
                alt10=2;
                }
                break;
            case 'R':
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1350:1: TOK_RELEASES : ( 'Awaits' | 'V' | 'RELEASES' );", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1350:19: 'Awaits'
                    {
                    match("Awaits"); 


                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1350:30: 'V'
                    {
                    match('V'); 

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1350:36: 'RELEASES'
                    {
                    match("RELEASES"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_RELEASES

    // $ANTLR start TOK_TRIGGERED
    public final void mTOK_TRIGGERED() throws RecognitionException {
        try {
            int _type = TOK_TRIGGERED;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1351:18: ( 'Backto' | 'T' | 'TRIGGERED' )
            int alt11=3;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='B') ) {
                alt11=1;
            }
            else if ( (LA11_0=='T') ) {
                int LA11_2 = input.LA(2);

                if ( (LA11_2=='R') ) {
                    alt11=3;
                }
                else {
                    alt11=2;}
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1351:1: TOK_TRIGGERED : ( 'Backto' | 'T' | 'TRIGGERED' );", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1351:20: 'Backto'
                    {
                    match("Backto"); 


                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1351:31: 'T'
                    {
                    match('T'); 

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1351:37: 'TRIGGERED'
                    {
                    match("TRIGGERED"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_TRIGGERED

    // $ANTLR start TOK_OP_NOTPREVNOT
    public final void mTOK_OP_NOTPREVNOT() throws RecognitionException {
        try {
            int _type = TOK_OP_NOTPREVNOT;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1352:21: ( 'Z' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1352:23: 'Z'
            {
            match('Z'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_OP_NOTPREVNOT

    // $ANTLR start TOK_LP
    public final void mTOK_LP() throws RecognitionException {
        try {
            int _type = TOK_LP;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1357:13: ( '(' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1357:15: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_LP

    // $ANTLR start TOK_RP
    public final void mTOK_RP() throws RecognitionException {
        try {
            int _type = TOK_RP;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1358:13: ( ')' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1358:15: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_RP

    // $ANTLR start TOK_LB
    public final void mTOK_LB() throws RecognitionException {
        try {
            int _type = TOK_LB;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1359:13: ( '[' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1359:15: '['
            {
            match('['); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_LB

    // $ANTLR start TOK_RB
    public final void mTOK_RB() throws RecognitionException {
        try {
            int _type = TOK_RB;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1360:13: ( ']' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1360:15: ']'
            {
            match(']'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_RB

    // $ANTLR start TOK_LCB
    public final void mTOK_LCB() throws RecognitionException {
        try {
            int _type = TOK_LCB;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1361:14: ( '{' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1361:16: '{'
            {
            match('{'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_LCB

    // $ANTLR start TOK_RCB
    public final void mTOK_RCB() throws RecognitionException {
        try {
            int _type = TOK_RCB;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1362:14: ( '}' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1362:16: '}'
            {
            match('}'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_RCB

    // $ANTLR start TOK_FALSEEXP
    public final void mTOK_FALSEEXP() throws RecognitionException {
        try {
            int _type = TOK_FALSEEXP;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1363:17: ( 'FALSE' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1363:19: 'FALSE'
            {
            match("FALSE"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_FALSEEXP

    // $ANTLR start TOK_TRUEEXP
    public final void mTOK_TRUEEXP() throws RecognitionException {
        try {
            int _type = TOK_TRUEEXP;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1364:17: ( 'TRUE' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1364:19: 'TRUE'
            {
            match("TRUE"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_TRUEEXP

    // $ANTLR start TOK_WORD1
    public final void mTOK_WORD1() throws RecognitionException {
        try {
            int _type = TOK_WORD1;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1368:15: ( 'word1' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1368:17: 'word1'
            {
            match("word1"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_WORD1

    // $ANTLR start TOK_WORD
    public final void mTOK_WORD() throws RecognitionException {
        try {
            int _type = TOK_WORD;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1369:14: ( 'word' | 'Word' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='w') ) {
                alt12=1;
            }
            else if ( (LA12_0=='W') ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1369:1: TOK_WORD : ( 'word' | 'Word' );", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1369:16: 'word'
                    {
                    match("word"); 


                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1369:25: 'Word'
                    {
                    match("Word"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_WORD

    // $ANTLR start TOK_BOOL
    public final void mTOK_BOOL() throws RecognitionException {
        try {
            int _type = TOK_BOOL;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1370:14: ( 'bool' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1370:16: 'bool'
            {
            match("bool"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_BOOL

    // $ANTLR start TOK_WAREAD
    public final void mTOK_WAREAD() throws RecognitionException {
        try {
            int _type = TOK_WAREAD;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1371:16: ( 'READ' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1371:18: 'READ'
            {
            match("READ"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_WAREAD

    // $ANTLR start TOK_WAWRITE
    public final void mTOK_WAWRITE() throws RecognitionException {
        try {
            int _type = TOK_WAWRITE;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1372:17: ( 'WRITE' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1372:19: 'WRITE'
            {
            match("WRITE"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_WAWRITE

    // $ANTLR start TOK_CASE
    public final void mTOK_CASE() throws RecognitionException {
        try {
            int _type = TOK_CASE;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1374:14: ( 'case' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1374:16: 'case'
            {
            match("case"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_CASE

    // $ANTLR start TOK_ESAC
    public final void mTOK_ESAC() throws RecognitionException {
        try {
            int _type = TOK_ESAC;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1375:14: ( 'esac' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1375:16: 'esac'
            {
            match("esac"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_ESAC

    // $ANTLR start TOK_PLUS
    public final void mTOK_PLUS() throws RecognitionException {
        try {
            int _type = TOK_PLUS;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1376:14: ( '+' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1376:16: '+'
            {
            match('+'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_PLUS

    // $ANTLR start TOK_MINUS
    public final void mTOK_MINUS() throws RecognitionException {
        try {
            int _type = TOK_MINUS;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1377:15: ( '-' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1377:17: '-'
            {
            match('-'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_MINUS

    // $ANTLR start TOK_TIMES
    public final void mTOK_TIMES() throws RecognitionException {
        try {
            int _type = TOK_TIMES;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1378:15: ( '*' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1378:17: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_TIMES

    // $ANTLR start TOK_DIVIDE
    public final void mTOK_DIVIDE() throws RecognitionException {
        try {
            int _type = TOK_DIVIDE;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1379:16: ( '/' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1379:18: '/'
            {
            match('/'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_DIVIDE

    // $ANTLR start TOK_MOD
    public final void mTOK_MOD() throws RecognitionException {
        try {
            int _type = TOK_MOD;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1380:14: ( 'mod' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1380:16: 'mod'
            {
            match("mod"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_MOD

    // $ANTLR start TOK_LSHIFT
    public final void mTOK_LSHIFT() throws RecognitionException {
        try {
            int _type = TOK_LSHIFT;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1381:16: ( '<<' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1381:18: '<<'
            {
            match("<<"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_LSHIFT

    // $ANTLR start TOK_RSHIFT
    public final void mTOK_RSHIFT() throws RecognitionException {
        try {
            int _type = TOK_RSHIFT;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1382:16: ( '>>' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1382:18: '>>'
            {
            match(">>"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_RSHIFT

    // $ANTLR start TOK_EQUAL
    public final void mTOK_EQUAL() throws RecognitionException {
        try {
            int _type = TOK_EQUAL;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1385:15: ( '=' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1385:17: '='
            {
            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_EQUAL

    // $ANTLR start TOK_NOTEQUAL
    public final void mTOK_NOTEQUAL() throws RecognitionException {
        try {
            int _type = TOK_NOTEQUAL;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1386:17: ( '!=' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1386:19: '!='
            {
            match("!="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_NOTEQUAL

    // $ANTLR start TOK_LE
    public final void mTOK_LE() throws RecognitionException {
        try {
            int _type = TOK_LE;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1387:13: ( '<=' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1387:15: '<='
            {
            match("<="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_LE

    // $ANTLR start TOK_GE
    public final void mTOK_GE() throws RecognitionException {
        try {
            int _type = TOK_GE;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1388:13: ( '>=' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1388:15: '>='
            {
            match(">="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_GE

    // $ANTLR start TOK_LT
    public final void mTOK_LT() throws RecognitionException {
        try {
            int _type = TOK_LT;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1389:13: ( '<' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1389:15: '<'
            {
            match('<'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_LT

    // $ANTLR start TOK_GT
    public final void mTOK_GT() throws RecognitionException {
        try {
            int _type = TOK_GT;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1390:13: ( '>' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1390:15: '>'
            {
            match('>'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_GT

    // $ANTLR start TOK_NEXT
    public final void mTOK_NEXT() throws RecognitionException {
        try {
            int _type = TOK_NEXT;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1391:14: ( 'next' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1391:16: 'next'
            {
            match("next"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_NEXT

    // $ANTLR start TOK_UNION
    public final void mTOK_UNION() throws RecognitionException {
        try {
            int _type = TOK_UNION;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1393:15: ( 'union' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1393:17: 'union'
            {
            match("union"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_UNION

    // $ANTLR start TOK_SETIN
    public final void mTOK_SETIN() throws RecognitionException {
        try {
            int _type = TOK_SETIN;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1394:15: ( 'in' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1394:17: 'in'
            {
            match("in"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_SETIN

    // $ANTLR start TOK_TWODOTS
    public final void mTOK_TWODOTS() throws RecognitionException {
        try {
            int _type = TOK_TWODOTS;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1395:17: ( '..' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1395:19: '..'
            {
            match(".."); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_TWODOTS

    // $ANTLR start TOK_DOT
    public final void mTOK_DOT() throws RecognitionException {
        try {
            int _type = TOK_DOT;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1396:14: ( '.' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1396:16: '.'
            {
            match('.'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_DOT

    // $ANTLR start TOK_IMPLIES
    public final void mTOK_IMPLIES() throws RecognitionException {
        try {
            int _type = TOK_IMPLIES;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1399:17: ( '->' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1399:19: '->'
            {
            match("->"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_IMPLIES

    // $ANTLR start TOK_IFF
    public final void mTOK_IFF() throws RecognitionException {
        try {
            int _type = TOK_IFF;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1400:14: ( '<->' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1400:16: '<->'
            {
            match("<->"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_IFF

    // $ANTLR start TOK_OR
    public final void mTOK_OR() throws RecognitionException {
        try {
            int _type = TOK_OR;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1401:13: ( '|' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1401:15: '|'
            {
            match('|'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_OR

    // $ANTLR start TOK_AND
    public final void mTOK_AND() throws RecognitionException {
        try {
            int _type = TOK_AND;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1402:14: ( '&' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1402:16: '&'
            {
            match('&'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_AND

    // $ANTLR start TOK_XOR
    public final void mTOK_XOR() throws RecognitionException {
        try {
            int _type = TOK_XOR;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1403:14: ( 'xor' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1403:16: 'xor'
            {
            match("xor"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_XOR

    // $ANTLR start TOK_XNOR
    public final void mTOK_XNOR() throws RecognitionException {
        try {
            int _type = TOK_XNOR;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1404:14: ( 'xnor' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1404:16: 'xnor'
            {
            match("xnor"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_XNOR

    // $ANTLR start TOK_NOT
    public final void mTOK_NOT() throws RecognitionException {
        try {
            int _type = TOK_NOT;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1405:14: ( '!' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1405:16: '!'
            {
            match('!'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_NOT

    // $ANTLR start TOK_COMMA
    public final void mTOK_COMMA() throws RecognitionException {
        try {
            int _type = TOK_COMMA;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1407:15: ( ',' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1407:17: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_COMMA

    // $ANTLR start TOK_COLON
    public final void mTOK_COLON() throws RecognitionException {
        try {
            int _type = TOK_COLON;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1408:15: ( ':' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1408:17: ':'
            {
            match(':'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_COLON

    // $ANTLR start TOK_SEMI
    public final void mTOK_SEMI() throws RecognitionException {
        try {
            int _type = TOK_SEMI;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1409:14: ( ';' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1409:16: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_SEMI

    // $ANTLR start TOK_CONCATENATION
    public final void mTOK_CONCATENATION() throws RecognitionException {
        try {
            int _type = TOK_CONCATENATION;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1410:21: ( '::' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1410:23: '::'
            {
            match("::"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_CONCATENATION

    // $ANTLR start TOK_NUMBER_WORD
    public final void mTOK_NUMBER_WORD() throws RecognitionException {
        try {
            int _type = TOK_NUMBER_WORD;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1419:21: ( '0' ( 'b' | 'B' | 'o' | 'O' | 'd' | 'D' | 'h' | 'H' ) ( '0' .. '9' )* '_' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1419:23: '0' ( 'b' | 'B' | 'o' | 'O' | 'd' | 'D' | 'h' | 'H' ) ( '0' .. '9' )* '_' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )*
            {
            match('0'); 
            if ( input.LA(1)=='B'||input.LA(1)=='D'||input.LA(1)=='H'||input.LA(1)=='O'||input.LA(1)=='b'||input.LA(1)=='d'||input.LA(1)=='h'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1419:75: ( '0' .. '9' )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='0' && LA13_0<='9')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1419:76: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            match('_'); 
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1419:124: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='0' && LA14_0<='9')||(LA14_0>='A' && LA14_0<='F')||LA14_0=='_'||(LA14_0>='a' && LA14_0<='f')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_NUMBER_WORD

    // $ANTLR start TOK_NUMBER_FRAC
    public final void mTOK_NUMBER_FRAC() throws RecognitionException {
        try {
            int _type = TOK_NUMBER_FRAC;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1422:21: ( ( 'f' | 'F' ) '\\'' ( '0' .. '9' )+ '/' ( '0' .. '9' )+ )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1422:23: ( 'f' | 'F' ) '\\'' ( '0' .. '9' )+ '/' ( '0' .. '9' )+
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            match('\''); 
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1422:40: ( '0' .. '9' )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='0' && LA15_0<='9')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1422:41: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);

            match('/'); 
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1422:56: ( '0' .. '9' )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='0' && LA16_0<='9')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1422:57: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_NUMBER_FRAC

    // $ANTLR start TOK_NUMBER
    public final void mTOK_NUMBER() throws RecognitionException {
        try {
            int _type = TOK_NUMBER;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1425:17: ( ( '0' .. '9' )+ )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1425:19: ( '0' .. '9' )+
            {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1425:19: ( '0' .. '9' )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>='0' && LA17_0<='9')) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1425:20: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_NUMBER

    // $ANTLR start TOK_ATOM
    public final void mTOK_ATOM() throws RecognitionException {
        try {
            int _type = TOK_ATOM;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1428:15: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '\\\\' | '$' | '#' | '-' )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1428:17: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '\\\\' | '$' | '#' | '-' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1428:45: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '\\\\' | '$' | '#' | '-' )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>='#' && LA18_0<='$')||LA18_0=='-'||(LA18_0>='0' && LA18_0<='9')||(LA18_0>='A' && LA18_0<='Z')||LA18_0=='\\'||LA18_0=='_'||(LA18_0>='a' && LA18_0<='z')) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:
            	    {
            	    if ( (input.LA(1)>='#' && input.LA(1)<='$')||input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='\\'||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TOK_ATOM

    // $ANTLR start JTOK_WS
    public final void mJTOK_WS() throws RecognitionException {
        try {
            int _type = JTOK_WS;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1431:15: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1431:19: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1431:19: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>='\t' && LA19_0<='\n')||LA19_0=='\r'||LA19_0==' ') ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);

             channel=HIDDEN; 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end JTOK_WS

    // $ANTLR start JTOK_MULTI_COMMENT
    public final void mJTOK_MULTI_COMMENT() throws RecognitionException {
        try {
            int _type = JTOK_MULTI_COMMENT;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1437:23: ( ( '/*' ( options {greedy=false; } : '\\r' | '\\n' | ~ ( '\\n' | '\\r' ) )* '*/' ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1437:25: ( '/*' ( options {greedy=false; } : '\\r' | '\\n' | ~ ( '\\n' | '\\r' ) )* '*/' )
            {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1437:25: ( '/*' ( options {greedy=false; } : '\\r' | '\\n' | ~ ( '\\n' | '\\r' ) )* '*/' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1437:26: '/*' ( options {greedy=false; } : '\\r' | '\\n' | ~ ( '\\n' | '\\r' ) )* '*/'
            {
            match("/*"); 

            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1437:31: ( options {greedy=false; } : '\\r' | '\\n' | ~ ( '\\n' | '\\r' ) )*
            loop20:
            do {
                int alt20=4;
                int LA20_0 = input.LA(1);

                if ( (LA20_0=='*') ) {
                    int LA20_1 = input.LA(2);

                    if ( (LA20_1=='/') ) {
                        alt20=4;
                    }
                    else if ( ((LA20_1>='\u0000' && LA20_1<='.')||(LA20_1>='0' && LA20_1<='\uFFFE')) ) {
                        alt20=3;
                    }


                }
                else if ( (LA20_0=='\r') ) {
                    alt20=1;
                }
                else if ( (LA20_0=='\n') ) {
                    alt20=2;
                }
                else if ( ((LA20_0>='\u0000' && LA20_0<='\t')||(LA20_0>='\u000B' && LA20_0<='\f')||(LA20_0>='\u000E' && LA20_0<=')')||(LA20_0>='+' && LA20_0<='\uFFFE')) ) {
                    alt20=3;
                }


                switch (alt20) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1440:9: '\\r'
            	    {
            	    match('\r'); 

            	    }
            	    break;
            	case 2 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1441:13: '\\n'
            	    {
            	    match('\n'); 

            	    }
            	    break;
            	case 3 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1442:13: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            match("*/"); 

            channel=HIDDEN;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end JTOK_MULTI_COMMENT

    // $ANTLR start JTOK_LINE_COMMENT
    public final void mJTOK_LINE_COMMENT() throws RecognitionException {
        try {
            int _type = JTOK_LINE_COMMENT;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1446:22: ( ( '--' (~ ( '\\n' | '\\r' ) )* ( ( '\\n' | '\\r' ( '\\n' )? ) )? ) | ( '//' (~ ( '\\n' | '\\r' ) )* ( ( '\\n' | '\\r' ( '\\n' )? ) )? ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0=='-') ) {
                alt29=1;
            }
            else if ( (LA29_0=='/') ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1446:1: JTOK_LINE_COMMENT : ( ( '--' (~ ( '\\n' | '\\r' ) )* ( ( '\\n' | '\\r' ( '\\n' )? ) )? ) | ( '//' (~ ( '\\n' | '\\r' ) )* ( ( '\\n' | '\\r' ( '\\n' )? ) )? ) );", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1446:24: ( '--' (~ ( '\\n' | '\\r' ) )* ( ( '\\n' | '\\r' ( '\\n' )? ) )? )
                    {
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1446:24: ( '--' (~ ( '\\n' | '\\r' ) )* ( ( '\\n' | '\\r' ( '\\n' )? ) )? )
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1446:25: '--' (~ ( '\\n' | '\\r' ) )* ( ( '\\n' | '\\r' ( '\\n' )? ) )?
                    {
                    match("--"); 

                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1446:30: (~ ( '\\n' | '\\r' ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( ((LA21_0>='\u0000' && LA21_0<='\t')||(LA21_0>='\u000B' && LA21_0<='\f')||(LA21_0>='\u000E' && LA21_0<='\uFFFE')) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1446:31: ~ ( '\\n' | '\\r' )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);

                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1446:46: ( ( '\\n' | '\\r' ( '\\n' )? ) )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0=='\n'||LA24_0=='\r') ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1446:47: ( '\\n' | '\\r' ( '\\n' )? )
                            {
                            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1446:47: ( '\\n' | '\\r' ( '\\n' )? )
                            int alt23=2;
                            int LA23_0 = input.LA(1);

                            if ( (LA23_0=='\n') ) {
                                alt23=1;
                            }
                            else if ( (LA23_0=='\r') ) {
                                alt23=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1446:47: ( '\\n' | '\\r' ( '\\n' )? )", 23, 0, input);

                                throw nvae;
                            }
                            switch (alt23) {
                                case 1 :
                                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1446:48: '\\n'
                                    {
                                    match('\n'); 

                                    }
                                    break;
                                case 2 :
                                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1446:53: '\\r' ( '\\n' )?
                                    {
                                    match('\r'); 
                                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1446:57: ( '\\n' )?
                                    int alt22=2;
                                    int LA22_0 = input.LA(1);

                                    if ( (LA22_0=='\n') ) {
                                        alt22=1;
                                    }
                                    switch (alt22) {
                                        case 1 :
                                            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1446:58: '\\n'
                                            {
                                            match('\n'); 

                                            }
                                            break;

                                    }


                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    channel=HIDDEN;

                    }


                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1447:11: ( '//' (~ ( '\\n' | '\\r' ) )* ( ( '\\n' | '\\r' ( '\\n' )? ) )? )
                    {
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1447:11: ( '//' (~ ( '\\n' | '\\r' ) )* ( ( '\\n' | '\\r' ( '\\n' )? ) )? )
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1447:12: '//' (~ ( '\\n' | '\\r' ) )* ( ( '\\n' | '\\r' ( '\\n' )? ) )?
                    {
                    match("//"); 

                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1447:17: (~ ( '\\n' | '\\r' ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( ((LA25_0>='\u0000' && LA25_0<='\t')||(LA25_0>='\u000B' && LA25_0<='\f')||(LA25_0>='\u000E' && LA25_0<='\uFFFE')) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1447:18: ~ ( '\\n' | '\\r' )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);

                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1447:33: ( ( '\\n' | '\\r' ( '\\n' )? ) )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0=='\n'||LA28_0=='\r') ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1447:34: ( '\\n' | '\\r' ( '\\n' )? )
                            {
                            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1447:34: ( '\\n' | '\\r' ( '\\n' )? )
                            int alt27=2;
                            int LA27_0 = input.LA(1);

                            if ( (LA27_0=='\n') ) {
                                alt27=1;
                            }
                            else if ( (LA27_0=='\r') ) {
                                alt27=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1447:34: ( '\\n' | '\\r' ( '\\n' )? )", 27, 0, input);

                                throw nvae;
                            }
                            switch (alt27) {
                                case 1 :
                                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1447:35: '\\n'
                                    {
                                    match('\n'); 

                                    }
                                    break;
                                case 2 :
                                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1447:40: '\\r' ( '\\n' )?
                                    {
                                    match('\r'); 
                                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1447:44: ( '\\n' )?
                                    int alt26=2;
                                    int LA26_0 = input.LA(1);

                                    if ( (LA26_0=='\n') ) {
                                        alt26=1;
                                    }
                                    switch (alt26) {
                                        case 1 :
                                            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1447:45: '\\n'
                                            {
                                            match('\n'); 

                                            }
                                            break;

                                    }


                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    channel=HIDDEN;

                    }


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end JTOK_LINE_COMMENT

    public void mTokens() throws RecognitionException {
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:8: ( TOK_CTL_SPEC | TOK_CTL_STAR_SPEC | TOK_LTL_SPEC | TOK_INVAR_SPEC | TOK_EX | TOK_AX | TOK_EF | TOK_AF | TOK_EG | TOK_AG | TOK_EE | TOK_AA | TOK_BUNTIL | TOK_EBF | TOK_ABF | TOK_EBG | TOK_ABG | TOK_OP_FINALLY | TOK_OP_ONCE | TOK_OP_GLOBALLY | TOK_OP_HISTORICALLY | TOK_OP_NEXT | TOK_OP_PREV | TOK_UNTIL | TOK_SINCE | TOK_RELEASES | TOK_TRIGGERED | TOK_OP_NOTPREVNOT | TOK_LP | TOK_RP | TOK_LB | TOK_RB | TOK_LCB | TOK_RCB | TOK_FALSEEXP | TOK_TRUEEXP | TOK_WORD1 | TOK_WORD | TOK_BOOL | TOK_WAREAD | TOK_WAWRITE | TOK_CASE | TOK_ESAC | TOK_PLUS | TOK_MINUS | TOK_TIMES | TOK_DIVIDE | TOK_MOD | TOK_LSHIFT | TOK_RSHIFT | TOK_EQUAL | TOK_NOTEQUAL | TOK_LE | TOK_GE | TOK_LT | TOK_GT | TOK_NEXT | TOK_UNION | TOK_SETIN | TOK_TWODOTS | TOK_DOT | TOK_IMPLIES | TOK_IFF | TOK_OR | TOK_AND | TOK_XOR | TOK_XNOR | TOK_NOT | TOK_COMMA | TOK_COLON | TOK_SEMI | TOK_CONCATENATION | TOK_NUMBER_WORD | TOK_NUMBER_FRAC | TOK_NUMBER | TOK_ATOM | JTOK_WS | JTOK_MULTI_COMMENT | JTOK_LINE_COMMENT )
        int alt30=79;
        switch ( input.LA(1) ) {
        case 'C':
            {
            int LA30_1 = input.LA(2);

            if ( (LA30_1=='T') ) {
                int LA30_56 = input.LA(3);

                if ( (LA30_56=='L') ) {
                    switch ( input.LA(4) ) {
                    case 'S':
                        {
                        int LA30_179 = input.LA(5);

                        if ( (LA30_179=='P') ) {
                            int LA30_218 = input.LA(6);

                            if ( (LA30_218=='E') ) {
                                int LA30_247 = input.LA(7);

                                if ( (LA30_247=='C') ) {
                                    int LA30_263 = input.LA(8);

                                    if ( ((LA30_263>='#' && LA30_263<='$')||LA30_263=='-'||(LA30_263>='0' && LA30_263<='9')||(LA30_263>='A' && LA30_263<='Z')||LA30_263=='\\'||LA30_263=='_'||(LA30_263>='a' && LA30_263<='z')) ) {
                                        alt30=76;
                                    }
                                    else {
                                        alt30=1;}
                                }
                                else {
                                    alt30=76;}
                            }
                            else {
                                alt30=76;}
                        }
                        else {
                            alt30=76;}
                        }
                        break;
                    case '*':
                        {
                        alt30=2;
                        }
                        break;
                    default:
                        alt30=76;}

                }
                else {
                    alt30=76;}
            }
            else {
                alt30=76;}
            }
            break;
        case 'S':
            {
            switch ( input.LA(2) ) {
            case 'i':
                {
                int LA30_57 = input.LA(3);

                if ( (LA30_57=='n') ) {
                    int LA30_134 = input.LA(4);

                    if ( (LA30_134=='c') ) {
                        int LA30_181 = input.LA(5);

                        if ( (LA30_181=='e') ) {
                            int LA30_219 = input.LA(6);

                            if ( ((LA30_219>='#' && LA30_219<='$')||LA30_219=='-'||(LA30_219>='0' && LA30_219<='9')||(LA30_219>='A' && LA30_219<='Z')||LA30_219=='\\'||LA30_219=='_'||(LA30_219>='a' && LA30_219<='z')) ) {
                                alt30=76;
                            }
                            else {
                                alt30=25;}
                        }
                        else {
                            alt30=76;}
                    }
                    else {
                        alt30=76;}
                }
                else {
                    alt30=76;}
                }
                break;
            case 'I':
                {
                int LA30_58 = input.LA(3);

                if ( (LA30_58=='N') ) {
                    int LA30_135 = input.LA(4);

                    if ( (LA30_135=='C') ) {
                        int LA30_182 = input.LA(5);

                        if ( (LA30_182=='E') ) {
                            int LA30_220 = input.LA(6);

                            if ( ((LA30_220>='#' && LA30_220<='$')||LA30_220=='-'||(LA30_220>='0' && LA30_220<='9')||(LA30_220>='A' && LA30_220<='Z')||LA30_220=='\\'||LA30_220=='_'||(LA30_220>='a' && LA30_220<='z')) ) {
                                alt30=76;
                            }
                            else {
                                alt30=25;}
                        }
                        else {
                            alt30=76;}
                    }
                    else {
                        alt30=76;}
                }
                else {
                    alt30=76;}
                }
                break;
            case 'P':
                {
                int LA30_59 = input.LA(3);

                if ( (LA30_59=='E') ) {
                    int LA30_136 = input.LA(4);

                    if ( (LA30_136=='C') ) {
                        int LA30_183 = input.LA(5);

                        if ( ((LA30_183>='#' && LA30_183<='$')||LA30_183=='-'||(LA30_183>='0' && LA30_183<='9')||(LA30_183>='A' && LA30_183<='Z')||LA30_183=='\\'||LA30_183=='_'||(LA30_183>='a' && LA30_183<='z')) ) {
                            alt30=76;
                        }
                        else {
                            alt30=1;}
                    }
                    else {
                        alt30=76;}
                }
                else {
                    alt30=76;}
                }
                break;
            case '#':
            case '$':
            case '-':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            case '\\':
            case '_':
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                alt30=76;
                }
                break;
            default:
                alt30=25;}

            }
            break;
        case 'L':
            {
            int LA30_3 = input.LA(2);

            if ( (LA30_3=='T') ) {
                int LA30_61 = input.LA(3);

                if ( (LA30_61=='L') ) {
                    int LA30_137 = input.LA(4);

                    if ( (LA30_137=='S') ) {
                        int LA30_184 = input.LA(5);

                        if ( (LA30_184=='P') ) {
                            int LA30_222 = input.LA(6);

                            if ( (LA30_222=='E') ) {
                                int LA30_248 = input.LA(7);

                                if ( (LA30_248=='C') ) {
                                    int LA30_264 = input.LA(8);

                                    if ( ((LA30_264>='#' && LA30_264<='$')||LA30_264=='-'||(LA30_264>='0' && LA30_264<='9')||(LA30_264>='A' && LA30_264<='Z')||LA30_264=='\\'||LA30_264=='_'||(LA30_264>='a' && LA30_264<='z')) ) {
                                        alt30=76;
                                    }
                                    else {
                                        alt30=3;}
                                }
                                else {
                                    alt30=76;}
                            }
                            else {
                                alt30=76;}
                        }
                        else {
                            alt30=76;}
                    }
                    else {
                        alt30=76;}
                }
                else {
                    alt30=76;}
            }
            else {
                alt30=76;}
            }
            break;
        case 'I':
            {
            int LA30_4 = input.LA(2);

            if ( (LA30_4=='N') ) {
                int LA30_62 = input.LA(3);

                if ( (LA30_62=='V') ) {
                    int LA30_138 = input.LA(4);

                    if ( (LA30_138=='A') ) {
                        int LA30_185 = input.LA(5);

                        if ( (LA30_185=='R') ) {
                            int LA30_223 = input.LA(6);

                            if ( (LA30_223=='S') ) {
                                int LA30_249 = input.LA(7);

                                if ( (LA30_249=='P') ) {
                                    int LA30_265 = input.LA(8);

                                    if ( (LA30_265=='E') ) {
                                        int LA30_273 = input.LA(9);

                                        if ( (LA30_273=='C') ) {
                                            int LA30_279 = input.LA(10);

                                            if ( ((LA30_279>='#' && LA30_279<='$')||LA30_279=='-'||(LA30_279>='0' && LA30_279<='9')||(LA30_279>='A' && LA30_279<='Z')||LA30_279=='\\'||LA30_279=='_'||(LA30_279>='a' && LA30_279<='z')) ) {
                                                alt30=76;
                                            }
                                            else {
                                                alt30=4;}
                                        }
                                        else {
                                            alt30=76;}
                                    }
                                    else {
                                        alt30=76;}
                                }
                                else {
                                    alt30=76;}
                            }
                            else {
                                alt30=76;}
                        }
                        else {
                            alt30=76;}
                    }
                    else {
                        alt30=76;}
                }
                else {
                    alt30=76;}
            }
            else {
                alt30=76;}
            }
            break;
        case 'E':
            {
            switch ( input.LA(2) ) {
            case 'B':
                {
                switch ( input.LA(3) ) {
                case 'G':
                    {
                    int LA30_139 = input.LA(4);

                    if ( ((LA30_139>='#' && LA30_139<='$')||LA30_139=='-'||(LA30_139>='0' && LA30_139<='9')||(LA30_139>='A' && LA30_139<='Z')||LA30_139=='\\'||LA30_139=='_'||(LA30_139>='a' && LA30_139<='z')) ) {
                        alt30=76;
                    }
                    else {
                        alt30=16;}
                    }
                    break;
                case 'F':
                    {
                    int LA30_140 = input.LA(4);

                    if ( ((LA30_140>='#' && LA30_140<='$')||LA30_140=='-'||(LA30_140>='0' && LA30_140<='9')||(LA30_140>='A' && LA30_140<='Z')||LA30_140=='\\'||LA30_140=='_'||(LA30_140>='a' && LA30_140<='z')) ) {
                        alt30=76;
                    }
                    else {
                        alt30=14;}
                    }
                    break;
                default:
                    alt30=76;}

                }
                break;
            case 'V':
                {
                int LA30_64 = input.LA(3);

                if ( (LA30_64=='E') ) {
                    int LA30_141 = input.LA(4);

                    if ( (LA30_141=='N') ) {
                        int LA30_188 = input.LA(5);

                        if ( (LA30_188=='T') ) {
                            int LA30_224 = input.LA(6);

                            if ( (LA30_224=='U') ) {
                                int LA30_250 = input.LA(7);

                                if ( (LA30_250=='A') ) {
                                    int LA30_266 = input.LA(8);

                                    if ( (LA30_266=='L') ) {
                                        int LA30_274 = input.LA(9);

                                        if ( (LA30_274=='L') ) {
                                            int LA30_280 = input.LA(10);

                                            if ( (LA30_280=='Y') ) {
                                                int LA30_284 = input.LA(11);

                                                if ( ((LA30_284>='#' && LA30_284<='$')||LA30_284=='-'||(LA30_284>='0' && LA30_284<='9')||(LA30_284>='A' && LA30_284<='Z')||LA30_284=='\\'||LA30_284=='_'||(LA30_284>='a' && LA30_284<='z')) ) {
                                                    alt30=76;
                                                }
                                                else {
                                                    alt30=18;}
                                            }
                                            else {
                                                alt30=76;}
                                        }
                                        else {
                                            alt30=76;}
                                    }
                                    else {
                                        alt30=76;}
                                }
                                else {
                                    alt30=76;}
                            }
                            else {
                                alt30=76;}
                        }
                        else {
                            alt30=76;}
                    }
                    else {
                        alt30=76;}
                }
                else {
                    alt30=76;}
                }
                break;
            case 'F':
                {
                int LA30_65 = input.LA(3);

                if ( ((LA30_65>='#' && LA30_65<='$')||LA30_65=='-'||(LA30_65>='0' && LA30_65<='9')||(LA30_65>='A' && LA30_65<='Z')||LA30_65=='\\'||LA30_65=='_'||(LA30_65>='a' && LA30_65<='z')) ) {
                    alt30=76;
                }
                else {
                    alt30=7;}
                }
                break;
            case 'G':
                {
                int LA30_66 = input.LA(3);

                if ( ((LA30_66>='#' && LA30_66<='$')||LA30_66=='-'||(LA30_66>='0' && LA30_66<='9')||(LA30_66>='A' && LA30_66<='Z')||LA30_66=='\\'||LA30_66=='_'||(LA30_66>='a' && LA30_66<='z')) ) {
                    alt30=76;
                }
                else {
                    alt30=9;}
                }
                break;
            case 'X':
                {
                int LA30_67 = input.LA(3);

                if ( ((LA30_67>='#' && LA30_67<='$')||LA30_67=='-'||(LA30_67>='0' && LA30_67<='9')||(LA30_67>='A' && LA30_67<='Z')||LA30_67=='\\'||LA30_67=='_'||(LA30_67>='a' && LA30_67<='z')) ) {
                    alt30=76;
                }
                else {
                    alt30=5;}
                }
                break;
            case '#':
            case '$':
            case '-':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case 'A':
            case 'C':
            case 'D':
            case 'E':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'W':
            case 'Y':
            case 'Z':
            case '\\':
            case '_':
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                alt30=76;
                }
                break;
            default:
                alt30=11;}

            }
            break;
        case 'A':
            {
            switch ( input.LA(2) ) {
            case 'B':
                {
                switch ( input.LA(3) ) {
                case 'F':
                    {
                    int LA30_145 = input.LA(4);

                    if ( ((LA30_145>='#' && LA30_145<='$')||LA30_145=='-'||(LA30_145>='0' && LA30_145<='9')||(LA30_145>='A' && LA30_145<='Z')||LA30_145=='\\'||LA30_145=='_'||(LA30_145>='a' && LA30_145<='z')) ) {
                        alt30=76;
                    }
                    else {
                        alt30=15;}
                    }
                    break;
                case 'G':
                    {
                    int LA30_146 = input.LA(4);

                    if ( ((LA30_146>='#' && LA30_146<='$')||LA30_146=='-'||(LA30_146>='0' && LA30_146<='9')||(LA30_146>='A' && LA30_146<='Z')||LA30_146=='\\'||LA30_146=='_'||(LA30_146>='a' && LA30_146<='z')) ) {
                        alt30=76;
                    }
                    else {
                        alt30=17;}
                    }
                    break;
                default:
                    alt30=76;}

                }
                break;
            case 'F':
                {
                int LA30_70 = input.LA(3);

                if ( ((LA30_70>='#' && LA30_70<='$')||LA30_70=='-'||(LA30_70>='0' && LA30_70<='9')||(LA30_70>='A' && LA30_70<='Z')||LA30_70=='\\'||LA30_70=='_'||(LA30_70>='a' && LA30_70<='z')) ) {
                    alt30=76;
                }
                else {
                    alt30=8;}
                }
                break;
            case 'X':
                {
                int LA30_71 = input.LA(3);

                if ( ((LA30_71>='#' && LA30_71<='$')||LA30_71=='-'||(LA30_71>='0' && LA30_71<='9')||(LA30_71>='A' && LA30_71<='Z')||LA30_71=='\\'||LA30_71=='_'||(LA30_71>='a' && LA30_71<='z')) ) {
                    alt30=76;
                }
                else {
                    alt30=6;}
                }
                break;
            case 'G':
                {
                int LA30_72 = input.LA(3);

                if ( ((LA30_72>='#' && LA30_72<='$')||LA30_72=='-'||(LA30_72>='0' && LA30_72<='9')||(LA30_72>='A' && LA30_72<='Z')||LA30_72=='\\'||LA30_72=='_'||(LA30_72>='a' && LA30_72<='z')) ) {
                    alt30=76;
                }
                else {
                    alt30=10;}
                }
                break;
            case 'L':
                {
                int LA30_73 = input.LA(3);

                if ( (LA30_73=='W') ) {
                    int LA30_150 = input.LA(4);

                    if ( (LA30_150=='A') ) {
                        int LA30_191 = input.LA(5);

                        if ( (LA30_191=='Y') ) {
                            int LA30_225 = input.LA(6);

                            if ( (LA30_225=='S') ) {
                                int LA30_251 = input.LA(7);

                                if ( ((LA30_251>='#' && LA30_251<='$')||LA30_251=='-'||(LA30_251>='0' && LA30_251<='9')||(LA30_251>='A' && LA30_251<='Z')||LA30_251=='\\'||LA30_251=='_'||(LA30_251>='a' && LA30_251<='z')) ) {
                                    alt30=76;
                                }
                                else {
                                    alt30=20;}
                            }
                            else {
                                alt30=76;}
                        }
                        else {
                            alt30=76;}
                    }
                    else {
                        alt30=76;}
                }
                else {
                    alt30=76;}
                }
                break;
            case 'w':
                {
                int LA30_74 = input.LA(3);

                if ( (LA30_74=='a') ) {
                    int LA30_151 = input.LA(4);

                    if ( (LA30_151=='i') ) {
                        int LA30_192 = input.LA(5);

                        if ( (LA30_192=='t') ) {
                            int LA30_226 = input.LA(6);

                            if ( (LA30_226=='s') ) {
                                int LA30_252 = input.LA(7);

                                if ( ((LA30_252>='#' && LA30_252<='$')||LA30_252=='-'||(LA30_252>='0' && LA30_252<='9')||(LA30_252>='A' && LA30_252<='Z')||LA30_252=='\\'||LA30_252=='_'||(LA30_252>='a' && LA30_252<='z')) ) {
                                    alt30=76;
                                }
                                else {
                                    alt30=26;}
                            }
                            else {
                                alt30=76;}
                        }
                        else {
                            alt30=76;}
                    }
                    else {
                        alt30=76;}
                }
                else {
                    alt30=76;}
                }
                break;
            case '#':
            case '$':
            case '-':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case 'A':
            case 'C':
            case 'D':
            case 'E':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'Y':
            case 'Z':
            case '\\':
            case '_':
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'x':
            case 'y':
            case 'z':
                {
                alt30=76;
                }
                break;
            default:
                alt30=12;}

            }
            break;
        case 'B':
            {
            switch ( input.LA(2) ) {
            case 'U':
                {
                int LA30_76 = input.LA(3);

                if ( ((LA30_76>='#' && LA30_76<='$')||LA30_76=='-'||(LA30_76>='0' && LA30_76<='9')||(LA30_76>='A' && LA30_76<='Z')||LA30_76=='\\'||LA30_76=='_'||(LA30_76>='a' && LA30_76<='z')) ) {
                    alt30=76;
                }
                else {
                    alt30=13;}
                }
                break;
            case 'a':
                {
                int LA30_77 = input.LA(3);

                if ( (LA30_77=='c') ) {
                    int LA30_153 = input.LA(4);

                    if ( (LA30_153=='k') ) {
                        int LA30_193 = input.LA(5);

                        if ( (LA30_193=='t') ) {
                            int LA30_227 = input.LA(6);

                            if ( (LA30_227=='o') ) {
                                int LA30_253 = input.LA(7);

                                if ( ((LA30_253>='#' && LA30_253<='$')||LA30_253=='-'||(LA30_253>='0' && LA30_253<='9')||(LA30_253>='A' && LA30_253<='Z')||LA30_253=='\\'||LA30_253=='_'||(LA30_253>='a' && LA30_253<='z')) ) {
                                    alt30=76;
                                }
                                else {
                                    alt30=27;}
                            }
                            else {
                                alt30=76;}
                        }
                        else {
                            alt30=76;}
                    }
                    else {
                        alt30=76;}
                }
                else {
                    alt30=76;}
                }
                break;
            default:
                alt30=76;}

            }
            break;
        case '<':
            {
            switch ( input.LA(2) ) {
            case '>':
                {
                alt30=18;
                }
                break;
            case '-':
                {
                alt30=63;
                }
                break;
            case '_':
                {
                alt30=19;
                }
                break;
            case '=':
                {
                alt30=53;
                }
                break;
            case '<':
                {
                alt30=49;
                }
                break;
            default:
                alt30=55;}

            }
            break;
        case 'F':
            {
            switch ( input.LA(2) ) {
            case 'I':
                {
                int LA30_84 = input.LA(3);

                if ( (LA30_84=='N') ) {
                    int LA30_154 = input.LA(4);

                    if ( (LA30_154=='A') ) {
                        int LA30_194 = input.LA(5);

                        if ( (LA30_194=='L') ) {
                            int LA30_228 = input.LA(6);

                            if ( (LA30_228=='L') ) {
                                int LA30_254 = input.LA(7);

                                if ( (LA30_254=='Y') ) {
                                    int LA30_267 = input.LA(8);

                                    if ( ((LA30_267>='#' && LA30_267<='$')||LA30_267=='-'||(LA30_267>='0' && LA30_267<='9')||(LA30_267>='A' && LA30_267<='Z')||LA30_267=='\\'||LA30_267=='_'||(LA30_267>='a' && LA30_267<='z')) ) {
                                        alt30=76;
                                    }
                                    else {
                                        alt30=18;}
                                }
                                else {
                                    alt30=76;}
                            }
                            else {
                                alt30=76;}
                        }
                        else {
                            alt30=76;}
                    }
                    else {
                        alt30=76;}
                }
                else {
                    alt30=76;}
                }
                break;
            case '\'':
                {
                alt30=74;
                }
                break;
            case 'A':
                {
                int LA30_86 = input.LA(3);

                if ( (LA30_86=='L') ) {
                    int LA30_155 = input.LA(4);

                    if ( (LA30_155=='S') ) {
                        int LA30_195 = input.LA(5);

                        if ( (LA30_195=='E') ) {
                            int LA30_229 = input.LA(6);

                            if ( ((LA30_229>='#' && LA30_229<='$')||LA30_229=='-'||(LA30_229>='0' && LA30_229<='9')||(LA30_229>='A' && LA30_229<='Z')||LA30_229=='\\'||LA30_229=='_'||(LA30_229>='a' && LA30_229<='z')) ) {
                                alt30=76;
                            }
                            else {
                                alt30=35;}
                        }
                        else {
                            alt30=76;}
                    }
                    else {
                        alt30=76;}
                }
                else {
                    alt30=76;}
                }
                break;
            case '#':
            case '$':
            case '-':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            case '\\':
            case '_':
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                alt30=76;
                }
                break;
            default:
                alt30=18;}

            }
            break;
        case 'O':
            {
            switch ( input.LA(2) ) {
            case 'N':
                {
                int LA30_87 = input.LA(3);

                if ( (LA30_87=='C') ) {
                    int LA30_156 = input.LA(4);

                    if ( (LA30_156=='E') ) {
                        int LA30_196 = input.LA(5);

                        if ( ((LA30_196>='#' && LA30_196<='$')||LA30_196=='-'||(LA30_196>='0' && LA30_196<='9')||(LA30_196>='A' && LA30_196<='Z')||LA30_196=='\\'||LA30_196=='_'||(LA30_196>='a' && LA30_196<='z')) ) {
                            alt30=76;
                        }
                        else {
                            alt30=19;}
                    }
                    else {
                        alt30=76;}
                }
                else {
                    alt30=76;}
                }
                break;
            case '#':
            case '$':
            case '-':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            case '\\':
            case '_':
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                alt30=76;
                }
                break;
            default:
                alt30=19;}

            }
            break;
        case '[':
            {
            switch ( input.LA(2) ) {
            case ']':
                {
                alt30=20;
                }
                break;
            case '_':
                {
                alt30=21;
                }
                break;
            default:
                alt30=31;}

            }
            break;
        case 'G':
            {
            switch ( input.LA(2) ) {
            case 'L':
                {
                int LA30_91 = input.LA(3);

                if ( (LA30_91=='O') ) {
                    int LA30_157 = input.LA(4);

                    if ( (LA30_157=='B') ) {
                        int LA30_197 = input.LA(5);

                        if ( (LA30_197=='A') ) {
                            int LA30_230 = input.LA(6);

                            if ( (LA30_230=='L') ) {
                                int LA30_256 = input.LA(7);

                                if ( (LA30_256=='L') ) {
                                    int LA30_268 = input.LA(8);

                                    if ( (LA30_268=='Y') ) {
                                        int LA30_275 = input.LA(9);

                                        if ( ((LA30_275>='#' && LA30_275<='$')||LA30_275=='-'||(LA30_275>='0' && LA30_275<='9')||(LA30_275>='A' && LA30_275<='Z')||LA30_275=='\\'||LA30_275=='_'||(LA30_275>='a' && LA30_275<='z')) ) {
                                            alt30=76;
                                        }
                                        else {
                                            alt30=20;}
                                    }
                                    else {
                                        alt30=76;}
                                }
                                else {
                                    alt30=76;}
                            }
                            else {
                                alt30=76;}
                        }
                        else {
                            alt30=76;}
                    }
                    else {
                        alt30=76;}
                }
                else {
                    alt30=76;}
                }
                break;
            case '#':
            case '$':
            case '-':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            case '\\':
            case '_':
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                alt30=76;
                }
                break;
            default:
                alt30=20;}

            }
            break;
        case 'H':
            {
            switch ( input.LA(2) ) {
            case 'I':
                {
                int LA30_92 = input.LA(3);

                if ( (LA30_92=='S') ) {
                    int LA30_158 = input.LA(4);

                    if ( (LA30_158=='T') ) {
                        int LA30_198 = input.LA(5);

                        if ( (LA30_198=='O') ) {
                            int LA30_231 = input.LA(6);

                            if ( (LA30_231=='R') ) {
                                int LA30_257 = input.LA(7);

                                if ( (LA30_257=='I') ) {
                                    int LA30_269 = input.LA(8);

                                    if ( (LA30_269=='C') ) {
                                        int LA30_276 = input.LA(9);

                                        if ( (LA30_276=='A') ) {
                                            int LA30_281 = input.LA(10);

                                            if ( (LA30_281=='L') ) {
                                                int LA30_285 = input.LA(11);

                                                if ( (LA30_285=='L') ) {
                                                    int LA30_286 = input.LA(12);

                                                    if ( (LA30_286=='Y') ) {
                                                        int LA30_287 = input.LA(13);

                                                        if ( ((LA30_287>='#' && LA30_287<='$')||LA30_287=='-'||(LA30_287>='0' && LA30_287<='9')||(LA30_287>='A' && LA30_287<='Z')||LA30_287=='\\'||LA30_287=='_'||(LA30_287>='a' && LA30_287<='z')) ) {
                                                            alt30=76;
                                                        }
                                                        else {
                                                            alt30=21;}
                                                    }
                                                    else {
                                                        alt30=76;}
                                                }
                                                else {
                                                    alt30=76;}
                                            }
                                            else {
                                                alt30=76;}
                                        }
                                        else {
                                            alt30=76;}
                                    }
                                    else {
                                        alt30=76;}
                                }
                                else {
                                    alt30=76;}
                            }
                            else {
                                alt30=76;}
                        }
                        else {
                            alt30=76;}
                    }
                    else {
                        alt30=76;}
                }
                else {
                    alt30=76;}
                }
                break;
            case '#':
            case '$':
            case '-':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            case '\\':
            case '_':
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                alt30=76;
                }
                break;
            default:
                alt30=21;}

            }
            break;
        case '(':
            {
            switch ( input.LA(2) ) {
            case ')':
                {
                alt30=22;
                }
                break;
            case '_':
                {
                alt30=23;
                }
                break;
            default:
                alt30=29;}

            }
            break;
        case 'X':
            {
            int LA30_15 = input.LA(2);

            if ( ((LA30_15>='#' && LA30_15<='$')||LA30_15=='-'||(LA30_15>='0' && LA30_15<='9')||(LA30_15>='A' && LA30_15<='Z')||LA30_15=='\\'||LA30_15=='_'||(LA30_15>='a' && LA30_15<='z')) ) {
                alt30=76;
            }
            else {
                alt30=22;}
            }
            break;
        case 'N':
            {
            int LA30_16 = input.LA(2);

            if ( (LA30_16=='E') ) {
                int LA30_96 = input.LA(3);

                if ( (LA30_96=='X') ) {
                    int LA30_159 = input.LA(4);

                    if ( (LA30_159=='T') ) {
                        int LA30_199 = input.LA(5);

                        if ( ((LA30_199>='#' && LA30_199<='$')||LA30_199=='-'||(LA30_199>='0' && LA30_199<='9')||(LA30_199>='A' && LA30_199<='Z')||LA30_199=='\\'||LA30_199=='_'||(LA30_199>='a' && LA30_199<='z')) ) {
                            alt30=76;
                        }
                        else {
                            alt30=22;}
                    }
                    else {
                        alt30=76;}
                }
                else {
                    alt30=76;}
            }
            else {
                alt30=76;}
            }
            break;
        case 'Y':
            {
            int LA30_17 = input.LA(2);

            if ( ((LA30_17>='#' && LA30_17<='$')||LA30_17=='-'||(LA30_17>='0' && LA30_17<='9')||(LA30_17>='A' && LA30_17<='Z')||LA30_17=='\\'||LA30_17=='_'||(LA30_17>='a' && LA30_17<='z')) ) {
                alt30=76;
            }
            else {
                alt30=23;}
            }
            break;
        case 'P':
            {
            int LA30_18 = input.LA(2);

            if ( (LA30_18=='R') ) {
                int LA30_97 = input.LA(3);

                if ( (LA30_97=='E') ) {
                    int LA30_160 = input.LA(4);

                    if ( (LA30_160=='V') ) {
                        int LA30_200 = input.LA(5);

                        if ( ((LA30_200>='#' && LA30_200<='$')||LA30_200=='-'||(LA30_200>='0' && LA30_200<='9')||(LA30_200>='A' && LA30_200<='Z')||LA30_200=='\\'||LA30_200=='_'||(LA30_200>='a' && LA30_200<='z')) ) {
                            alt30=76;
                        }
                        else {
                            alt30=23;}
                    }
                    else {
                        alt30=76;}
                }
                else {
                    alt30=76;}
            }
            else {
                alt30=76;}
            }
            break;
        case 'U':
            {
            switch ( input.LA(2) ) {
            case 'n':
                {
                int LA30_98 = input.LA(3);

                if ( (LA30_98=='t') ) {
                    int LA30_161 = input.LA(4);

                    if ( (LA30_161=='i') ) {
                        int LA30_201 = input.LA(5);

                        if ( (LA30_201=='l') ) {
                            int LA30_232 = input.LA(6);

                            if ( ((LA30_232>='#' && LA30_232<='$')||LA30_232=='-'||(LA30_232>='0' && LA30_232<='9')||(LA30_232>='A' && LA30_232<='Z')||LA30_232=='\\'||LA30_232=='_'||(LA30_232>='a' && LA30_232<='z')) ) {
                                alt30=76;
                            }
                            else {
                                alt30=24;}
                        }
                        else {
                            alt30=76;}
                    }
                    else {
                        alt30=76;}
                }
                else {
                    alt30=76;}
                }
                break;
            case 'N':
                {
                int LA30_99 = input.LA(3);

                if ( (LA30_99=='T') ) {
                    int LA30_162 = input.LA(4);

                    if ( (LA30_162=='I') ) {
                        int LA30_202 = input.LA(5);

                        if ( (LA30_202=='L') ) {
                            int LA30_233 = input.LA(6);

                            if ( ((LA30_233>='#' && LA30_233<='$')||LA30_233=='-'||(LA30_233>='0' && LA30_233<='9')||(LA30_233>='A' && LA30_233<='Z')||LA30_233=='\\'||LA30_233=='_'||(LA30_233>='a' && LA30_233<='z')) ) {
                                alt30=76;
                            }
                            else {
                                alt30=24;}
                        }
                        else {
                            alt30=76;}
                    }
                    else {
                        alt30=76;}
                }
                else {
                    alt30=76;}
                }
                break;
            case '#':
            case '$':
            case '-':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            case '\\':
            case '_':
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                alt30=76;
                }
                break;
            default:
                alt30=24;}

            }
            break;
        case 'V':
            {
            int LA30_20 = input.LA(2);

            if ( ((LA30_20>='#' && LA30_20<='$')||LA30_20=='-'||(LA30_20>='0' && LA30_20<='9')||(LA30_20>='A' && LA30_20<='Z')||LA30_20=='\\'||LA30_20=='_'||(LA30_20>='a' && LA30_20<='z')) ) {
                alt30=76;
            }
            else {
                alt30=26;}
            }
            break;
        case 'R':
            {
            int LA30_21 = input.LA(2);

            if ( (LA30_21=='E') ) {
                switch ( input.LA(3) ) {
                case 'A':
                    {
                    int LA30_163 = input.LA(4);

                    if ( (LA30_163=='D') ) {
                        int LA30_203 = input.LA(5);

                        if ( ((LA30_203>='#' && LA30_203<='$')||LA30_203=='-'||(LA30_203>='0' && LA30_203<='9')||(LA30_203>='A' && LA30_203<='Z')||LA30_203=='\\'||LA30_203=='_'||(LA30_203>='a' && LA30_203<='z')) ) {
                            alt30=76;
                        }
                        else {
                            alt30=40;}
                    }
                    else {
                        alt30=76;}
                    }
                    break;
                case 'L':
                    {
                    int LA30_164 = input.LA(4);

                    if ( (LA30_164=='E') ) {
                        int LA30_204 = input.LA(5);

                        if ( (LA30_204=='A') ) {
                            int LA30_235 = input.LA(6);

                            if ( (LA30_235=='S') ) {
                                int LA30_258 = input.LA(7);

                                if ( (LA30_258=='E') ) {
                                    int LA30_270 = input.LA(8);

                                    if ( (LA30_270=='S') ) {
                                        int LA30_277 = input.LA(9);

                                        if ( ((LA30_277>='#' && LA30_277<='$')||LA30_277=='-'||(LA30_277>='0' && LA30_277<='9')||(LA30_277>='A' && LA30_277<='Z')||LA30_277=='\\'||LA30_277=='_'||(LA30_277>='a' && LA30_277<='z')) ) {
                                            alt30=76;
                                        }
                                        else {
                                            alt30=26;}
                                    }
                                    else {
                                        alt30=76;}
                                }
                                else {
                                    alt30=76;}
                            }
                            else {
                                alt30=76;}
                        }
                        else {
                            alt30=76;}
                    }
                    else {
                        alt30=76;}
                    }
                    break;
                default:
                    alt30=76;}

            }
            else {
                alt30=76;}
            }
            break;
        case 'T':
            {
            switch ( input.LA(2) ) {
            case 'R':
                {
                switch ( input.LA(3) ) {
                case 'U':
                    {
                    int LA30_165 = input.LA(4);

                    if ( (LA30_165=='E') ) {
                        int LA30_205 = input.LA(5);

                        if ( ((LA30_205>='#' && LA30_205<='$')||LA30_205=='-'||(LA30_205>='0' && LA30_205<='9')||(LA30_205>='A' && LA30_205<='Z')||LA30_205=='\\'||LA30_205=='_'||(LA30_205>='a' && LA30_205<='z')) ) {
                            alt30=76;
                        }
                        else {
                            alt30=36;}
                    }
                    else {
                        alt30=76;}
                    }
                    break;
                case 'I':
                    {
                    int LA30_166 = input.LA(4);

                    if ( (LA30_166=='G') ) {
                        int LA30_206 = input.LA(5);

                        if ( (LA30_206=='G') ) {
                            int LA30_237 = input.LA(6);

                            if ( (LA30_237=='E') ) {
                                int LA30_259 = input.LA(7);

                                if ( (LA30_259=='R') ) {
                                    int LA30_271 = input.LA(8);

                                    if ( (LA30_271=='E') ) {
                                        int LA30_278 = input.LA(9);

                                        if ( (LA30_278=='D') ) {
                                            int LA30_282 = input.LA(10);

                                            if ( ((LA30_282>='#' && LA30_282<='$')||LA30_282=='-'||(LA30_282>='0' && LA30_282<='9')||(LA30_282>='A' && LA30_282<='Z')||LA30_282=='\\'||LA30_282=='_'||(LA30_282>='a' && LA30_282<='z')) ) {
                                                alt30=76;
                                            }
                                            else {
                                                alt30=27;}
                                        }
                                        else {
                                            alt30=76;}
                                    }
                                    else {
                                        alt30=76;}
                                }
                                else {
                                    alt30=76;}
                            }
                            else {
                                alt30=76;}
                        }
                        else {
                            alt30=76;}
                    }
                    else {
                        alt30=76;}
                    }
                    break;
                default:
                    alt30=76;}

                }
                break;
            case '#':
            case '$':
            case '-':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            case '\\':
            case '_':
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                alt30=76;
                }
                break;
            default:
                alt30=27;}

            }
            break;
        case 'Z':
            {
            int LA30_23 = input.LA(2);

            if ( ((LA30_23>='#' && LA30_23<='$')||LA30_23=='-'||(LA30_23>='0' && LA30_23<='9')||(LA30_23>='A' && LA30_23<='Z')||LA30_23=='\\'||LA30_23=='_'||(LA30_23>='a' && LA30_23<='z')) ) {
                alt30=76;
            }
            else {
                alt30=28;}
            }
            break;
        case ')':
            {
            alt30=30;
            }
            break;
        case ']':
            {
            alt30=32;
            }
            break;
        case '{':
            {
            alt30=33;
            }
            break;
        case '}':
            {
            alt30=34;
            }
            break;
        case 'w':
            {
            int LA30_28 = input.LA(2);

            if ( (LA30_28=='o') ) {
                int LA30_106 = input.LA(3);

                if ( (LA30_106=='r') ) {
                    int LA30_167 = input.LA(4);

                    if ( (LA30_167=='d') ) {
                        switch ( input.LA(5) ) {
                        case '1':
                            {
                            int LA30_238 = input.LA(6);

                            if ( ((LA30_238>='#' && LA30_238<='$')||LA30_238=='-'||(LA30_238>='0' && LA30_238<='9')||(LA30_238>='A' && LA30_238<='Z')||LA30_238=='\\'||LA30_238=='_'||(LA30_238>='a' && LA30_238<='z')) ) {
                                alt30=76;
                            }
                            else {
                                alt30=37;}
                            }
                            break;
                        case '#':
                        case '$':
                        case '-':
                        case '0':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                        case 'A':
                        case 'B':
                        case 'C':
                        case 'D':
                        case 'E':
                        case 'F':
                        case 'G':
                        case 'H':
                        case 'I':
                        case 'J':
                        case 'K':
                        case 'L':
                        case 'M':
                        case 'N':
                        case 'O':
                        case 'P':
                        case 'Q':
                        case 'R':
                        case 'S':
                        case 'T':
                        case 'U':
                        case 'V':
                        case 'W':
                        case 'X':
                        case 'Y':
                        case 'Z':
                        case '\\':
                        case '_':
                        case 'a':
                        case 'b':
                        case 'c':
                        case 'd':
                        case 'e':
                        case 'f':
                        case 'g':
                        case 'h':
                        case 'i':
                        case 'j':
                        case 'k':
                        case 'l':
                        case 'm':
                        case 'n':
                        case 'o':
                        case 'p':
                        case 'q':
                        case 'r':
                        case 's':
                        case 't':
                        case 'u':
                        case 'v':
                        case 'w':
                        case 'x':
                        case 'y':
                        case 'z':
                            {
                            alt30=76;
                            }
                            break;
                        default:
                            alt30=38;}

                    }
                    else {
                        alt30=76;}
                }
                else {
                    alt30=76;}
            }
            else {
                alt30=76;}
            }
            break;
        case 'W':
            {
            switch ( input.LA(2) ) {
            case 'o':
                {
                int LA30_107 = input.LA(3);

                if ( (LA30_107=='r') ) {
                    int LA30_168 = input.LA(4);

                    if ( (LA30_168=='d') ) {
                        int LA30_208 = input.LA(5);

                        if ( ((LA30_208>='#' && LA30_208<='$')||LA30_208=='-'||(LA30_208>='0' && LA30_208<='9')||(LA30_208>='A' && LA30_208<='Z')||LA30_208=='\\'||LA30_208=='_'||(LA30_208>='a' && LA30_208<='z')) ) {
                            alt30=76;
                        }
                        else {
                            alt30=38;}
                    }
                    else {
                        alt30=76;}
                }
                else {
                    alt30=76;}
                }
                break;
            case 'R':
                {
                int LA30_108 = input.LA(3);

                if ( (LA30_108=='I') ) {
                    int LA30_169 = input.LA(4);

                    if ( (LA30_169=='T') ) {
                        int LA30_209 = input.LA(5);

                        if ( (LA30_209=='E') ) {
                            int LA30_240 = input.LA(6);

                            if ( ((LA30_240>='#' && LA30_240<='$')||LA30_240=='-'||(LA30_240>='0' && LA30_240<='9')||(LA30_240>='A' && LA30_240<='Z')||LA30_240=='\\'||LA30_240=='_'||(LA30_240>='a' && LA30_240<='z')) ) {
                                alt30=76;
                            }
                            else {
                                alt30=41;}
                        }
                        else {
                            alt30=76;}
                    }
                    else {
                        alt30=76;}
                }
                else {
                    alt30=76;}
                }
                break;
            default:
                alt30=76;}

            }
            break;
        case 'b':
            {
            int LA30_30 = input.LA(2);

            if ( (LA30_30=='o') ) {
                int LA30_109 = input.LA(3);

                if ( (LA30_109=='o') ) {
                    int LA30_170 = input.LA(4);

                    if ( (LA30_170=='l') ) {
                        int LA30_210 = input.LA(5);

                        if ( ((LA30_210>='#' && LA30_210<='$')||LA30_210=='-'||(LA30_210>='0' && LA30_210<='9')||(LA30_210>='A' && LA30_210<='Z')||LA30_210=='\\'||LA30_210=='_'||(LA30_210>='a' && LA30_210<='z')) ) {
                            alt30=76;
                        }
                        else {
                            alt30=39;}
                    }
                    else {
                        alt30=76;}
                }
                else {
                    alt30=76;}
            }
            else {
                alt30=76;}
            }
            break;
        case 'c':
            {
            int LA30_31 = input.LA(2);

            if ( (LA30_31=='a') ) {
                int LA30_110 = input.LA(3);

                if ( (LA30_110=='s') ) {
                    int LA30_171 = input.LA(4);

                    if ( (LA30_171=='e') ) {
                        int LA30_211 = input.LA(5);

                        if ( ((LA30_211>='#' && LA30_211<='$')||LA30_211=='-'||(LA30_211>='0' && LA30_211<='9')||(LA30_211>='A' && LA30_211<='Z')||LA30_211=='\\'||LA30_211=='_'||(LA30_211>='a' && LA30_211<='z')) ) {
                            alt30=76;
                        }
                        else {
                            alt30=42;}
                    }
                    else {
                        alt30=76;}
                }
                else {
                    alt30=76;}
            }
            else {
                alt30=76;}
            }
            break;
        case 'e':
            {
            int LA30_32 = input.LA(2);

            if ( (LA30_32=='s') ) {
                int LA30_111 = input.LA(3);

                if ( (LA30_111=='a') ) {
                    int LA30_172 = input.LA(4);

                    if ( (LA30_172=='c') ) {
                        int LA30_212 = input.LA(5);

                        if ( ((LA30_212>='#' && LA30_212<='$')||LA30_212=='-'||(LA30_212>='0' && LA30_212<='9')||(LA30_212>='A' && LA30_212<='Z')||LA30_212=='\\'||LA30_212=='_'||(LA30_212>='a' && LA30_212<='z')) ) {
                            alt30=76;
                        }
                        else {
                            alt30=43;}
                    }
                    else {
                        alt30=76;}
                }
                else {
                    alt30=76;}
            }
            else {
                alt30=76;}
            }
            break;
        case '+':
            {
            alt30=44;
            }
            break;
        case '-':
            {
            switch ( input.LA(2) ) {
            case '>':
                {
                alt30=62;
                }
                break;
            case '-':
                {
                alt30=79;
                }
                break;
            default:
                alt30=45;}

            }
            break;
        case '*':
            {
            alt30=46;
            }
            break;
        case '/':
            {
            switch ( input.LA(2) ) {
            case '*':
                {
                alt30=78;
                }
                break;
            case '/':
                {
                alt30=79;
                }
                break;
            default:
                alt30=47;}

            }
            break;
        case 'm':
            {
            int LA30_37 = input.LA(2);

            if ( (LA30_37=='o') ) {
                int LA30_117 = input.LA(3);

                if ( (LA30_117=='d') ) {
                    int LA30_173 = input.LA(4);

                    if ( ((LA30_173>='#' && LA30_173<='$')||LA30_173=='-'||(LA30_173>='0' && LA30_173<='9')||(LA30_173>='A' && LA30_173<='Z')||LA30_173=='\\'||LA30_173=='_'||(LA30_173>='a' && LA30_173<='z')) ) {
                        alt30=76;
                    }
                    else {
                        alt30=48;}
                }
                else {
                    alt30=76;}
            }
            else {
                alt30=76;}
            }
            break;
        case '>':
            {
            switch ( input.LA(2) ) {
            case '=':
                {
                alt30=54;
                }
                break;
            case '>':
                {
                alt30=50;
                }
                break;
            default:
                alt30=56;}

            }
            break;
        case '=':
            {
            alt30=51;
            }
            break;
        case '!':
            {
            int LA30_40 = input.LA(2);

            if ( (LA30_40=='=') ) {
                alt30=52;
            }
            else {
                alt30=68;}
            }
            break;
        case 'n':
            {
            int LA30_41 = input.LA(2);

            if ( (LA30_41=='e') ) {
                int LA30_123 = input.LA(3);

                if ( (LA30_123=='x') ) {
                    int LA30_174 = input.LA(4);

                    if ( (LA30_174=='t') ) {
                        int LA30_214 = input.LA(5);

                        if ( ((LA30_214>='#' && LA30_214<='$')||LA30_214=='-'||(LA30_214>='0' && LA30_214<='9')||(LA30_214>='A' && LA30_214<='Z')||LA30_214=='\\'||LA30_214=='_'||(LA30_214>='a' && LA30_214<='z')) ) {
                            alt30=76;
                        }
                        else {
                            alt30=57;}
                    }
                    else {
                        alt30=76;}
                }
                else {
                    alt30=76;}
            }
            else {
                alt30=76;}
            }
            break;
        case 'u':
            {
            int LA30_42 = input.LA(2);

            if ( (LA30_42=='n') ) {
                int LA30_124 = input.LA(3);

                if ( (LA30_124=='i') ) {
                    int LA30_175 = input.LA(4);

                    if ( (LA30_175=='o') ) {
                        int LA30_215 = input.LA(5);

                        if ( (LA30_215=='n') ) {
                            int LA30_245 = input.LA(6);

                            if ( ((LA30_245>='#' && LA30_245<='$')||LA30_245=='-'||(LA30_245>='0' && LA30_245<='9')||(LA30_245>='A' && LA30_245<='Z')||LA30_245=='\\'||LA30_245=='_'||(LA30_245>='a' && LA30_245<='z')) ) {
                                alt30=76;
                            }
                            else {
                                alt30=58;}
                        }
                        else {
                            alt30=76;}
                    }
                    else {
                        alt30=76;}
                }
                else {
                    alt30=76;}
            }
            else {
                alt30=76;}
            }
            break;
        case 'i':
            {
            int LA30_43 = input.LA(2);

            if ( (LA30_43=='n') ) {
                int LA30_125 = input.LA(3);

                if ( ((LA30_125>='#' && LA30_125<='$')||LA30_125=='-'||(LA30_125>='0' && LA30_125<='9')||(LA30_125>='A' && LA30_125<='Z')||LA30_125=='\\'||LA30_125=='_'||(LA30_125>='a' && LA30_125<='z')) ) {
                    alt30=76;
                }
                else {
                    alt30=59;}
            }
            else {
                alt30=76;}
            }
            break;
        case '.':
            {
            int LA30_44 = input.LA(2);

            if ( (LA30_44=='.') ) {
                alt30=60;
            }
            else {
                alt30=61;}
            }
            break;
        case '|':
            {
            alt30=64;
            }
            break;
        case '&':
            {
            alt30=65;
            }
            break;
        case 'x':
            {
            switch ( input.LA(2) ) {
            case 'n':
                {
                int LA30_128 = input.LA(3);

                if ( (LA30_128=='o') ) {
                    int LA30_177 = input.LA(4);

                    if ( (LA30_177=='r') ) {
                        int LA30_216 = input.LA(5);

                        if ( ((LA30_216>='#' && LA30_216<='$')||LA30_216=='-'||(LA30_216>='0' && LA30_216<='9')||(LA30_216>='A' && LA30_216<='Z')||LA30_216=='\\'||LA30_216=='_'||(LA30_216>='a' && LA30_216<='z')) ) {
                            alt30=76;
                        }
                        else {
                            alt30=67;}
                    }
                    else {
                        alt30=76;}
                }
                else {
                    alt30=76;}
                }
                break;
            case 'o':
                {
                int LA30_129 = input.LA(3);

                if ( (LA30_129=='r') ) {
                    int LA30_178 = input.LA(4);

                    if ( ((LA30_178>='#' && LA30_178<='$')||LA30_178=='-'||(LA30_178>='0' && LA30_178<='9')||(LA30_178>='A' && LA30_178<='Z')||LA30_178=='\\'||LA30_178=='_'||(LA30_178>='a' && LA30_178<='z')) ) {
                        alt30=76;
                    }
                    else {
                        alt30=66;}
                }
                else {
                    alt30=76;}
                }
                break;
            default:
                alt30=76;}

            }
            break;
        case ',':
            {
            alt30=69;
            }
            break;
        case ':':
            {
            int LA30_49 = input.LA(2);

            if ( (LA30_49==':') ) {
                alt30=72;
            }
            else {
                alt30=70;}
            }
            break;
        case ';':
            {
            alt30=71;
            }
            break;
        case '0':
            {
            int LA30_51 = input.LA(2);

            if ( (LA30_51=='B'||LA30_51=='D'||LA30_51=='H'||LA30_51=='O'||LA30_51=='b'||LA30_51=='d'||LA30_51=='h'||LA30_51=='o') ) {
                alt30=73;
            }
            else {
                alt30=75;}
            }
            break;
        case 'f':
            {
            int LA30_52 = input.LA(2);

            if ( (LA30_52=='\'') ) {
                alt30=74;
            }
            else {
                alt30=76;}
            }
            break;
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt30=75;
            }
            break;
        case 'D':
        case 'J':
        case 'K':
        case 'M':
        case 'Q':
        case '_':
        case 'a':
        case 'd':
        case 'g':
        case 'h':
        case 'j':
        case 'k':
        case 'l':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'v':
        case 'y':
        case 'z':
            {
            alt30=76;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt30=77;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( TOK_CTL_SPEC | TOK_CTL_STAR_SPEC | TOK_LTL_SPEC | TOK_INVAR_SPEC | TOK_EX | TOK_AX | TOK_EF | TOK_AF | TOK_EG | TOK_AG | TOK_EE | TOK_AA | TOK_BUNTIL | TOK_EBF | TOK_ABF | TOK_EBG | TOK_ABG | TOK_OP_FINALLY | TOK_OP_ONCE | TOK_OP_GLOBALLY | TOK_OP_HISTORICALLY | TOK_OP_NEXT | TOK_OP_PREV | TOK_UNTIL | TOK_SINCE | TOK_RELEASES | TOK_TRIGGERED | TOK_OP_NOTPREVNOT | TOK_LP | TOK_RP | TOK_LB | TOK_RB | TOK_LCB | TOK_RCB | TOK_FALSEEXP | TOK_TRUEEXP | TOK_WORD1 | TOK_WORD | TOK_BOOL | TOK_WAREAD | TOK_WAWRITE | TOK_CASE | TOK_ESAC | TOK_PLUS | TOK_MINUS | TOK_TIMES | TOK_DIVIDE | TOK_MOD | TOK_LSHIFT | TOK_RSHIFT | TOK_EQUAL | TOK_NOTEQUAL | TOK_LE | TOK_GE | TOK_LT | TOK_GT | TOK_NEXT | TOK_UNION | TOK_SETIN | TOK_TWODOTS | TOK_DOT | TOK_IMPLIES | TOK_IFF | TOK_OR | TOK_AND | TOK_XOR | TOK_XNOR | TOK_NOT | TOK_COMMA | TOK_COLON | TOK_SEMI | TOK_CONCATENATION | TOK_NUMBER_WORD | TOK_NUMBER_FRAC | TOK_NUMBER | TOK_ATOM | JTOK_WS | JTOK_MULTI_COMMENT | JTOK_LINE_COMMENT );", 30, 0, input);

            throw nvae;
        }

        switch (alt30) {
            case 1 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:10: TOK_CTL_SPEC
                {
                mTOK_CTL_SPEC(); 

                }
                break;
            case 2 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:23: TOK_CTL_STAR_SPEC
                {
                mTOK_CTL_STAR_SPEC(); 

                }
                break;
            case 3 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:41: TOK_LTL_SPEC
                {
                mTOK_LTL_SPEC(); 

                }
                break;
            case 4 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:54: TOK_INVAR_SPEC
                {
                mTOK_INVAR_SPEC(); 

                }
                break;
            case 5 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:69: TOK_EX
                {
                mTOK_EX(); 

                }
                break;
            case 6 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:76: TOK_AX
                {
                mTOK_AX(); 

                }
                break;
            case 7 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:83: TOK_EF
                {
                mTOK_EF(); 

                }
                break;
            case 8 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:90: TOK_AF
                {
                mTOK_AF(); 

                }
                break;
            case 9 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:97: TOK_EG
                {
                mTOK_EG(); 

                }
                break;
            case 10 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:104: TOK_AG
                {
                mTOK_AG(); 

                }
                break;
            case 11 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:111: TOK_EE
                {
                mTOK_EE(); 

                }
                break;
            case 12 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:118: TOK_AA
                {
                mTOK_AA(); 

                }
                break;
            case 13 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:125: TOK_BUNTIL
                {
                mTOK_BUNTIL(); 

                }
                break;
            case 14 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:136: TOK_EBF
                {
                mTOK_EBF(); 

                }
                break;
            case 15 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:144: TOK_ABF
                {
                mTOK_ABF(); 

                }
                break;
            case 16 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:152: TOK_EBG
                {
                mTOK_EBG(); 

                }
                break;
            case 17 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:160: TOK_ABG
                {
                mTOK_ABG(); 

                }
                break;
            case 18 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:168: TOK_OP_FINALLY
                {
                mTOK_OP_FINALLY(); 

                }
                break;
            case 19 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:183: TOK_OP_ONCE
                {
                mTOK_OP_ONCE(); 

                }
                break;
            case 20 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:195: TOK_OP_GLOBALLY
                {
                mTOK_OP_GLOBALLY(); 

                }
                break;
            case 21 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:211: TOK_OP_HISTORICALLY
                {
                mTOK_OP_HISTORICALLY(); 

                }
                break;
            case 22 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:231: TOK_OP_NEXT
                {
                mTOK_OP_NEXT(); 

                }
                break;
            case 23 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:243: TOK_OP_PREV
                {
                mTOK_OP_PREV(); 

                }
                break;
            case 24 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:255: TOK_UNTIL
                {
                mTOK_UNTIL(); 

                }
                break;
            case 25 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:265: TOK_SINCE
                {
                mTOK_SINCE(); 

                }
                break;
            case 26 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:275: TOK_RELEASES
                {
                mTOK_RELEASES(); 

                }
                break;
            case 27 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:288: TOK_TRIGGERED
                {
                mTOK_TRIGGERED(); 

                }
                break;
            case 28 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:302: TOK_OP_NOTPREVNOT
                {
                mTOK_OP_NOTPREVNOT(); 

                }
                break;
            case 29 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:320: TOK_LP
                {
                mTOK_LP(); 

                }
                break;
            case 30 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:327: TOK_RP
                {
                mTOK_RP(); 

                }
                break;
            case 31 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:334: TOK_LB
                {
                mTOK_LB(); 

                }
                break;
            case 32 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:341: TOK_RB
                {
                mTOK_RB(); 

                }
                break;
            case 33 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:348: TOK_LCB
                {
                mTOK_LCB(); 

                }
                break;
            case 34 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:356: TOK_RCB
                {
                mTOK_RCB(); 

                }
                break;
            case 35 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:364: TOK_FALSEEXP
                {
                mTOK_FALSEEXP(); 

                }
                break;
            case 36 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:377: TOK_TRUEEXP
                {
                mTOK_TRUEEXP(); 

                }
                break;
            case 37 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:389: TOK_WORD1
                {
                mTOK_WORD1(); 

                }
                break;
            case 38 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:399: TOK_WORD
                {
                mTOK_WORD(); 

                }
                break;
            case 39 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:408: TOK_BOOL
                {
                mTOK_BOOL(); 

                }
                break;
            case 40 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:417: TOK_WAREAD
                {
                mTOK_WAREAD(); 

                }
                break;
            case 41 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:428: TOK_WAWRITE
                {
                mTOK_WAWRITE(); 

                }
                break;
            case 42 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:440: TOK_CASE
                {
                mTOK_CASE(); 

                }
                break;
            case 43 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:449: TOK_ESAC
                {
                mTOK_ESAC(); 

                }
                break;
            case 44 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:458: TOK_PLUS
                {
                mTOK_PLUS(); 

                }
                break;
            case 45 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:467: TOK_MINUS
                {
                mTOK_MINUS(); 

                }
                break;
            case 46 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:477: TOK_TIMES
                {
                mTOK_TIMES(); 

                }
                break;
            case 47 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:487: TOK_DIVIDE
                {
                mTOK_DIVIDE(); 

                }
                break;
            case 48 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:498: TOK_MOD
                {
                mTOK_MOD(); 

                }
                break;
            case 49 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:506: TOK_LSHIFT
                {
                mTOK_LSHIFT(); 

                }
                break;
            case 50 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:517: TOK_RSHIFT
                {
                mTOK_RSHIFT(); 

                }
                break;
            case 51 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:528: TOK_EQUAL
                {
                mTOK_EQUAL(); 

                }
                break;
            case 52 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:538: TOK_NOTEQUAL
                {
                mTOK_NOTEQUAL(); 

                }
                break;
            case 53 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:551: TOK_LE
                {
                mTOK_LE(); 

                }
                break;
            case 54 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:558: TOK_GE
                {
                mTOK_GE(); 

                }
                break;
            case 55 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:565: TOK_LT
                {
                mTOK_LT(); 

                }
                break;
            case 56 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:572: TOK_GT
                {
                mTOK_GT(); 

                }
                break;
            case 57 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:579: TOK_NEXT
                {
                mTOK_NEXT(); 

                }
                break;
            case 58 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:588: TOK_UNION
                {
                mTOK_UNION(); 

                }
                break;
            case 59 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:598: TOK_SETIN
                {
                mTOK_SETIN(); 

                }
                break;
            case 60 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:608: TOK_TWODOTS
                {
                mTOK_TWODOTS(); 

                }
                break;
            case 61 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:620: TOK_DOT
                {
                mTOK_DOT(); 

                }
                break;
            case 62 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:628: TOK_IMPLIES
                {
                mTOK_IMPLIES(); 

                }
                break;
            case 63 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:640: TOK_IFF
                {
                mTOK_IFF(); 

                }
                break;
            case 64 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:648: TOK_OR
                {
                mTOK_OR(); 

                }
                break;
            case 65 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:655: TOK_AND
                {
                mTOK_AND(); 

                }
                break;
            case 66 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:663: TOK_XOR
                {
                mTOK_XOR(); 

                }
                break;
            case 67 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:671: TOK_XNOR
                {
                mTOK_XNOR(); 

                }
                break;
            case 68 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:680: TOK_NOT
                {
                mTOK_NOT(); 

                }
                break;
            case 69 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:688: TOK_COMMA
                {
                mTOK_COMMA(); 

                }
                break;
            case 70 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:698: TOK_COLON
                {
                mTOK_COLON(); 

                }
                break;
            case 71 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:708: TOK_SEMI
                {
                mTOK_SEMI(); 

                }
                break;
            case 72 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:717: TOK_CONCATENATION
                {
                mTOK_CONCATENATION(); 

                }
                break;
            case 73 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:735: TOK_NUMBER_WORD
                {
                mTOK_NUMBER_WORD(); 

                }
                break;
            case 74 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:751: TOK_NUMBER_FRAC
                {
                mTOK_NUMBER_FRAC(); 

                }
                break;
            case 75 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:767: TOK_NUMBER
                {
                mTOK_NUMBER(); 

                }
                break;
            case 76 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:778: TOK_ATOM
                {
                mTOK_ATOM(); 

                }
                break;
            case 77 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:787: JTOK_WS
                {
                mJTOK_WS(); 

                }
                break;
            case 78 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:795: JTOK_MULTI_COMMENT
                {
                mJTOK_MULTI_COMMENT(); 

                }
                break;
            case 79 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1:814: JTOK_LINE_COMMENT
                {
                mJTOK_LINE_COMMENT(); 

                }
                break;

        }

    }


 

}