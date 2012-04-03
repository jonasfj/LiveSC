// $ANTLR 3.0.1 /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g 2008-05-27 17:39:56

package edu.wis.jtlv.env.core.fds;


import org.antlr.runtime.CharStream;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;

public class FDSLexer extends Lexer {
    public static final int PRIME=40;
    public static final int RIGHT_CURLY=21;
    public static final int BOOL_TYPE=43;
    public static final int MULTI_COMMENT=46;
    public static final int NOT=37;
    public static final int AND=32;
    public static final int ID=19;
    public static final int EOF=-1;
    public static final int TRANS_T=8;
    public static final int COMPASSION=44;
    public static final int TRANS=24;
    public static final int PRIME_T=16;
    public static final int RIGHT_BRACES=39;
    public static final int JUST_T=9;
    public static final int NEXT=41;
    public static final int VAR=22;
    public static final int BLOCK_T=14;
    public static final int EQ=35;
    public static final int DOT=42;
    public static final int BINOR=31;
    public static final int IMPLIES=33;
    public static final int LINE_COMMENT=47;
    public static final int MODULE_T=5;
    public static final int VAR_T=6;
    public static final int TRANS_DECL_T=12;
    public static final int VAR_DECL_T=10;
    public static final int PROG_T=4;
    public static final int BOOL_T=17;
    public static final int LEFT_BRACES=38;
    public static final int SEMICOLON=27;
    public static final int BIIMP=34;
    public static final int MODULE=18;
    public static final int Tokens=48;
    public static final int REF_T=15;
    public static final int INIT_DECL_EXPR_T=11;
    public static final int JUST_DECL_T=13;
    public static final int TRUE=29;
    public static final int COLON=26;
    public static final int WS=45;
    public static final int NEQ=36;
    public static final int INIT_T=7;
    public static final int LEFT_CURLY=20;
    public static final int ASSIGN=28;
    public static final int JUST=25;
    public static final int FALSE=30;
    public static final int INIT=23;
    public FDSLexer() {;} 
    public FDSLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "/home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g"; }

    // $ANTLR start MODULE
    public final void mMODULE() throws RecognitionException {
        try {
            int _type = MODULE;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:167:9: ( 'MODULE' | 'Module' | 'PLAYER' | 'Player' )
            int alt1=4;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='M') ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1=='o') ) {
                    alt1=2;
                }
                else if ( (LA1_1=='O') ) {
                    alt1=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("167:1: MODULE : ( 'MODULE' | 'Module' | 'PLAYER' | 'Player' );", 1, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA1_0=='P') ) {
                int LA1_2 = input.LA(2);

                if ( (LA1_2=='l') ) {
                    alt1=4;
                }
                else if ( (LA1_2=='L') ) {
                    alt1=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("167:1: MODULE : ( 'MODULE' | 'Module' | 'PLAYER' | 'Player' );", 1, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("167:1: MODULE : ( 'MODULE' | 'Module' | 'PLAYER' | 'Player' );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:167:11: 'MODULE'
                    {
                    match("MODULE"); 


                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:167:22: 'Module'
                    {
                    match("Module"); 


                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:167:33: 'PLAYER'
                    {
                    match("PLAYER"); 


                    }
                    break;
                case 4 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:167:44: 'Player'
                    {
                    match("Player"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end MODULE

    // $ANTLR start VAR
    public final void mVAR() throws RecognitionException {
        try {
            int _type = VAR;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:168:6: ( 'VAR' | 'Var' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='V') ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1=='a') ) {
                    alt2=2;
                }
                else if ( (LA2_1=='A') ) {
                    alt2=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("168:1: VAR : ( 'VAR' | 'Var' );", 2, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("168:1: VAR : ( 'VAR' | 'Var' );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:168:8: 'VAR'
                    {
                    match("VAR"); 


                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:168:16: 'Var'
                    {
                    match("Var"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end VAR

    // $ANTLR start INIT
    public final void mINIT() throws RecognitionException {
        try {
            int _type = INIT;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:169:7: ( 'INIT' | 'Init' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='I') ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1=='n') ) {
                    alt3=2;
                }
                else if ( (LA3_1=='N') ) {
                    alt3=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("169:1: INIT : ( 'INIT' | 'Init' );", 3, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("169:1: INIT : ( 'INIT' | 'Init' );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:169:9: 'INIT'
                    {
                    match("INIT"); 


                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:169:18: 'Init'
                    {
                    match("Init"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end INIT

    // $ANTLR start TRANS
    public final void mTRANS() throws RecognitionException {
        try {
            int _type = TRANS;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:170:8: ( 'TRANS' | 'Trans' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='T') ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1=='r') ) {
                    alt4=2;
                }
                else if ( (LA4_1=='R') ) {
                    alt4=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("170:1: TRANS : ( 'TRANS' | 'Trans' );", 4, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("170:1: TRANS : ( 'TRANS' | 'Trans' );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:170:10: 'TRANS'
                    {
                    match("TRANS"); 


                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:170:20: 'Trans'
                    {
                    match("Trans"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TRANS

    // $ANTLR start JUST
    public final void mJUST() throws RecognitionException {
        try {
            int _type = JUST;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:171:7: ( 'JUST' | 'Just' | 'JUSTICE' | 'Justice' )
            int alt5=4;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='J') ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1=='u') ) {
                    int LA5_2 = input.LA(3);

                    if ( (LA5_2=='s') ) {
                        int LA5_4 = input.LA(4);

                        if ( (LA5_4=='t') ) {
                            int LA5_6 = input.LA(5);

                            if ( (LA5_6=='i') ) {
                                alt5=4;
                            }
                            else {
                                alt5=2;}
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("171:1: JUST : ( 'JUST' | 'Just' | 'JUSTICE' | 'Justice' );", 5, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("171:1: JUST : ( 'JUST' | 'Just' | 'JUSTICE' | 'Justice' );", 5, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA5_1=='U') ) {
                    int LA5_3 = input.LA(3);

                    if ( (LA5_3=='S') ) {
                        int LA5_5 = input.LA(4);

                        if ( (LA5_5=='T') ) {
                            int LA5_7 = input.LA(5);

                            if ( (LA5_7=='I') ) {
                                alt5=3;
                            }
                            else {
                                alt5=1;}
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("171:1: JUST : ( 'JUST' | 'Just' | 'JUSTICE' | 'Justice' );", 5, 5, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("171:1: JUST : ( 'JUST' | 'Just' | 'JUSTICE' | 'Justice' );", 5, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("171:1: JUST : ( 'JUST' | 'Just' | 'JUSTICE' | 'Justice' );", 5, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("171:1: JUST : ( 'JUST' | 'Just' | 'JUSTICE' | 'Justice' );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:171:9: 'JUST'
                    {
                    match("JUST"); 


                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:171:18: 'Just'
                    {
                    match("Just"); 


                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:171:27: 'JUSTICE'
                    {
                    match("JUSTICE"); 


                    }
                    break;
                case 4 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:171:39: 'Justice'
                    {
                    match("Justice"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end JUST

    // $ANTLR start COMPASSION
    public final void mCOMPASSION() throws RecognitionException {
        try {
            int _type = COMPASSION;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:172:13: ( 'COMP' | 'Comp' | 'COMPASSION' | 'Compassion' )
            int alt6=4;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='C') ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1=='o') ) {
                    int LA6_2 = input.LA(3);

                    if ( (LA6_2=='m') ) {
                        int LA6_4 = input.LA(4);

                        if ( (LA6_4=='p') ) {
                            int LA6_6 = input.LA(5);

                            if ( (LA6_6=='a') ) {
                                alt6=4;
                            }
                            else {
                                alt6=2;}
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("172:1: COMPASSION : ( 'COMP' | 'Comp' | 'COMPASSION' | 'Compassion' );", 6, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("172:1: COMPASSION : ( 'COMP' | 'Comp' | 'COMPASSION' | 'Compassion' );", 6, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA6_1=='O') ) {
                    int LA6_3 = input.LA(3);

                    if ( (LA6_3=='M') ) {
                        int LA6_5 = input.LA(4);

                        if ( (LA6_5=='P') ) {
                            int LA6_7 = input.LA(5);

                            if ( (LA6_7=='A') ) {
                                alt6=3;
                            }
                            else {
                                alt6=1;}
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("172:1: COMPASSION : ( 'COMP' | 'Comp' | 'COMPASSION' | 'Compassion' );", 6, 5, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("172:1: COMPASSION : ( 'COMP' | 'Comp' | 'COMPASSION' | 'Compassion' );", 6, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("172:1: COMPASSION : ( 'COMP' | 'Comp' | 'COMPASSION' | 'Compassion' );", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("172:1: COMPASSION : ( 'COMP' | 'Comp' | 'COMPASSION' | 'Compassion' );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:172:15: 'COMP'
                    {
                    match("COMP"); 


                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:172:24: 'Comp'
                    {
                    match("Comp"); 


                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:172:33: 'COMPASSION'
                    {
                    match("COMPASSION"); 


                    }
                    break;
                case 4 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:172:48: 'Compassion'
                    {
                    match("Compassion"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COMPASSION

    // $ANTLR start NEXT
    public final void mNEXT() throws RecognitionException {
        try {
            int _type = NEXT;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:173:7: ( 'next' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:173:9: 'next'
            {
            match("next"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NEXT

    // $ANTLR start PRIME
    public final void mPRIME() throws RecognitionException {
        try {
            int _type = PRIME;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:174:8: ( '\\'' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:174:10: '\\''
            {
            match('\''); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end PRIME

    // $ANTLR start LEFT_BRACES
    public final void mLEFT_BRACES() throws RecognitionException {
        try {
            int _type = LEFT_BRACES;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:175:14: ( '(' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:175:16: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LEFT_BRACES

    // $ANTLR start LEFT_CURLY
    public final void mLEFT_CURLY() throws RecognitionException {
        try {
            int _type = LEFT_CURLY;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:176:13: ( '{' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:176:15: '{'
            {
            match('{'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LEFT_CURLY

    // $ANTLR start RIGHT_CURLY
    public final void mRIGHT_CURLY() throws RecognitionException {
        try {
            int _type = RIGHT_CURLY;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:177:14: ( '}' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:177:16: '}'
            {
            match('}'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RIGHT_CURLY

    // $ANTLR start RIGHT_BRACES
    public final void mRIGHT_BRACES() throws RecognitionException {
        try {
            int _type = RIGHT_BRACES;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:178:14: ( ')' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:178:16: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RIGHT_BRACES

    // $ANTLR start SEMICOLON
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:179:12: ( ';' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:179:14: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SEMICOLON

    // $ANTLR start COLON
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:180:8: ( ':' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:180:10: ':'
            {
            match(':'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COLON

    // $ANTLR start ASSIGN
    public final void mASSIGN() throws RecognitionException {
        try {
            int _type = ASSIGN;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:181:9: ( ':=' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:181:11: ':='
            {
            match(":="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ASSIGN

    // $ANTLR start DOT
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:182:6: ( '.' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:182:8: '.'
            {
            match('.'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DOT

    // $ANTLR start AND
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:185:6: ( '/\\\\' | '&' | 'and' )
            int alt7=3;
            switch ( input.LA(1) ) {
            case '/':
                {
                alt7=1;
                }
                break;
            case '&':
                {
                alt7=2;
                }
                break;
            case 'a':
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("185:1: AND : ( '/\\\\' | '&' | 'and' );", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:185:8: '/\\\\'
                    {
                    match("/\\"); 


                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:185:16: '&'
                    {
                    match('&'); 

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:185:22: 'and'
                    {
                    match("and"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end AND

    // $ANTLR start BINOR
    public final void mBINOR() throws RecognitionException {
        try {
            int _type = BINOR;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:186:8: ( '\\\\/' | '|' | 'or' )
            int alt8=3;
            switch ( input.LA(1) ) {
            case '\\':
                {
                alt8=1;
                }
                break;
            case '|':
                {
                alt8=2;
                }
                break;
            case 'o':
                {
                alt8=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("186:1: BINOR : ( '\\\\/' | '|' | 'or' );", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:186:10: '\\\\/'
                    {
                    match("\\/"); 


                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:186:18: '|'
                    {
                    match('|'); 

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:186:24: 'or'
                    {
                    match("or"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BINOR

    // $ANTLR start IMPLIES
    public final void mIMPLIES() throws RecognitionException {
        try {
            int _type = IMPLIES;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:187:10: ( '->' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:187:13: '->'
            {
            match("->"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end IMPLIES

    // $ANTLR start BIIMP
    public final void mBIIMP() throws RecognitionException {
        try {
            int _type = BIIMP;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:188:8: ( '<->' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:188:10: '<->'
            {
            match("<->"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BIIMP

    // $ANTLR start EQ
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:189:5: ( '==' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:189:7: '=='
            {
            match("=="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end EQ

    // $ANTLR start NEQ
    public final void mNEQ() throws RecognitionException {
        try {
            int _type = NEQ;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:190:6: ( '!=' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:190:8: '!='
            {
            match("!="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NEQ

    // $ANTLR start NOT
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:191:6: ( '!' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:191:8: '!'
            {
            match('!'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NOT

    // $ANTLR start BOOL_TYPE
    public final void mBOOL_TYPE() throws RecognitionException {
        try {
            int _type = BOOL_TYPE;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:194:12: ( 'bool' | 'boolean' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='b') ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1=='o') ) {
                    int LA9_2 = input.LA(3);

                    if ( (LA9_2=='o') ) {
                        int LA9_3 = input.LA(4);

                        if ( (LA9_3=='l') ) {
                            int LA9_4 = input.LA(5);

                            if ( (LA9_4=='e') ) {
                                alt9=2;
                            }
                            else {
                                alt9=1;}
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("194:1: BOOL_TYPE : ( 'bool' | 'boolean' );", 9, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("194:1: BOOL_TYPE : ( 'bool' | 'boolean' );", 9, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("194:1: BOOL_TYPE : ( 'bool' | 'boolean' );", 9, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("194:1: BOOL_TYPE : ( 'bool' | 'boolean' );", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:194:14: 'bool'
                    {
                    match("bool"); 


                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:194:23: 'boolean'
                    {
                    match("boolean"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BOOL_TYPE

    // $ANTLR start TRUE
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:195:7: ( 'T' | 'TRUE' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='T') ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1=='R') ) {
                    alt10=2;
                }
                else {
                    alt10=1;}
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("195:1: TRUE : ( 'T' | 'TRUE' );", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:195:9: 'T'
                    {
                    match('T'); 

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:195:15: 'TRUE'
                    {
                    match("TRUE"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TRUE

    // $ANTLR start FALSE
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:196:8: ( 'F' | 'FALSE' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='F') ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1=='A') ) {
                    alt11=2;
                }
                else {
                    alt11=1;}
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("196:1: FALSE : ( 'F' | 'FALSE' );", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:196:10: 'F'
                    {
                    match('F'); 

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:196:16: 'FALSE'
                    {
                    match("FALSE"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FALSE

    // $ANTLR start ID
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:200:5: ( ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:200:7: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:200:7: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' )
            int alt12=3;
            switch ( input.LA(1) ) {
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
                alt12=1;
                }
                break;
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
                {
                alt12=2;
                }
                break;
            case '_':
                {
                alt12=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("200:7: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' )", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:200:8: ( 'a' .. 'z' )
                    {
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:200:8: ( 'a' .. 'z' )
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:200:9: 'a' .. 'z'
                    {
                    matchRange('a','z'); 

                    }


                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:200:21: ( 'A' .. 'Z' )
                    {
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:200:21: ( 'A' .. 'Z' )
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:200:22: 'A' .. 'Z'
                    {
                    matchRange('A','Z'); 

                    }


                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:200:34: '_'
                    {
                    match('_'); 

                    }
                    break;

            }

            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:200:39: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='0' && LA13_0<='9')||(LA13_0>='A' && LA13_0<='Z')||LA13_0=='_'||(LA13_0>='a' && LA13_0<='z')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
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
            	    break loop13;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ID

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:201:6: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:201:10: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:201:10: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:
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
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);

             channel=HIDDEN; 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WS

    // $ANTLR start MULTI_COMMENT
    public final void mMULTI_COMMENT() throws RecognitionException {
        try {
            int _type = MULTI_COMMENT;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:207:15: ( ( '/*' ( options {greedy=false; } : '\\r' | '\\n' | ~ ( '\\n' | '\\r' ) )* '*/' ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:207:17: ( '/*' ( options {greedy=false; } : '\\r' | '\\n' | ~ ( '\\n' | '\\r' ) )* '*/' )
            {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:207:17: ( '/*' ( options {greedy=false; } : '\\r' | '\\n' | ~ ( '\\n' | '\\r' ) )* '*/' )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:207:18: '/*' ( options {greedy=false; } : '\\r' | '\\n' | ~ ( '\\n' | '\\r' ) )* '*/'
            {
            match("/*"); 

            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:207:23: ( options {greedy=false; } : '\\r' | '\\n' | ~ ( '\\n' | '\\r' ) )*
            loop15:
            do {
                int alt15=4;
                int LA15_0 = input.LA(1);

                if ( (LA15_0=='*') ) {
                    int LA15_1 = input.LA(2);

                    if ( (LA15_1=='/') ) {
                        alt15=4;
                    }
                    else if ( ((LA15_1>='\u0000' && LA15_1<='.')||(LA15_1>='0' && LA15_1<='\uFFFE')) ) {
                        alt15=3;
                    }


                }
                else if ( (LA15_0=='\r') ) {
                    alt15=1;
                }
                else if ( (LA15_0=='\n') ) {
                    alt15=2;
                }
                else if ( ((LA15_0>='\u0000' && LA15_0<='\t')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<=')')||(LA15_0>='+' && LA15_0<='\uFFFE')) ) {
                    alt15=3;
                }


                switch (alt15) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:210:3: '\\r'
            	    {
            	    match('\r'); 

            	    }
            	    break;
            	case 2 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:211:7: '\\n'
            	    {
            	    match('\n'); 

            	    }
            	    break;
            	case 3 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:212:7: ~ ( '\\n' | '\\r' )
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
            	    break loop15;
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
    // $ANTLR end MULTI_COMMENT

    // $ANTLR start LINE_COMMENT
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:216:14: ( ( '--' (~ ( '\\n' | '\\r' ) )* ( ( '\\n' | '\\r' ( '\\n' )? ) )? ) | ( '//' (~ ( '\\n' | '\\r' ) )* ( ( '\\n' | '\\r' ( '\\n' )? ) )? ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0=='-') ) {
                alt24=1;
            }
            else if ( (LA24_0=='/') ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("216:1: LINE_COMMENT : ( ( '--' (~ ( '\\n' | '\\r' ) )* ( ( '\\n' | '\\r' ( '\\n' )? ) )? ) | ( '//' (~ ( '\\n' | '\\r' ) )* ( ( '\\n' | '\\r' ( '\\n' )? ) )? ) );", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:216:16: ( '--' (~ ( '\\n' | '\\r' ) )* ( ( '\\n' | '\\r' ( '\\n' )? ) )? )
                    {
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:216:16: ( '--' (~ ( '\\n' | '\\r' ) )* ( ( '\\n' | '\\r' ( '\\n' )? ) )? )
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:216:17: '--' (~ ( '\\n' | '\\r' ) )* ( ( '\\n' | '\\r' ( '\\n' )? ) )?
                    {
                    match("--"); 

                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:216:22: (~ ( '\\n' | '\\r' ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0>='\u0000' && LA16_0<='\t')||(LA16_0>='\u000B' && LA16_0<='\f')||(LA16_0>='\u000E' && LA16_0<='\uFFFE')) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:216:23: ~ ( '\\n' | '\\r' )
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
                    	    break loop16;
                        }
                    } while (true);

                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:216:38: ( ( '\\n' | '\\r' ( '\\n' )? ) )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0=='\n'||LA19_0=='\r') ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:216:39: ( '\\n' | '\\r' ( '\\n' )? )
                            {
                            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:216:39: ( '\\n' | '\\r' ( '\\n' )? )
                            int alt18=2;
                            int LA18_0 = input.LA(1);

                            if ( (LA18_0=='\n') ) {
                                alt18=1;
                            }
                            else if ( (LA18_0=='\r') ) {
                                alt18=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("216:39: ( '\\n' | '\\r' ( '\\n' )? )", 18, 0, input);

                                throw nvae;
                            }
                            switch (alt18) {
                                case 1 :
                                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:216:40: '\\n'
                                    {
                                    match('\n'); 

                                    }
                                    break;
                                case 2 :
                                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:216:45: '\\r' ( '\\n' )?
                                    {
                                    match('\r'); 
                                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:216:49: ( '\\n' )?
                                    int alt17=2;
                                    int LA17_0 = input.LA(1);

                                    if ( (LA17_0=='\n') ) {
                                        alt17=1;
                                    }
                                    switch (alt17) {
                                        case 1 :
                                            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:216:50: '\\n'
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
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:218:3: ( '//' (~ ( '\\n' | '\\r' ) )* ( ( '\\n' | '\\r' ( '\\n' )? ) )? )
                    {
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:218:3: ( '//' (~ ( '\\n' | '\\r' ) )* ( ( '\\n' | '\\r' ( '\\n' )? ) )? )
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:218:4: '//' (~ ( '\\n' | '\\r' ) )* ( ( '\\n' | '\\r' ( '\\n' )? ) )?
                    {
                    match("//"); 

                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:218:9: (~ ( '\\n' | '\\r' ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( ((LA20_0>='\u0000' && LA20_0<='\t')||(LA20_0>='\u000B' && LA20_0<='\f')||(LA20_0>='\u000E' && LA20_0<='\uFFFE')) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:218:10: ~ ( '\\n' | '\\r' )
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

                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:218:25: ( ( '\\n' | '\\r' ( '\\n' )? ) )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0=='\n'||LA23_0=='\r') ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:218:26: ( '\\n' | '\\r' ( '\\n' )? )
                            {
                            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:218:26: ( '\\n' | '\\r' ( '\\n' )? )
                            int alt22=2;
                            int LA22_0 = input.LA(1);

                            if ( (LA22_0=='\n') ) {
                                alt22=1;
                            }
                            else if ( (LA22_0=='\r') ) {
                                alt22=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("218:26: ( '\\n' | '\\r' ( '\\n' )? )", 22, 0, input);

                                throw nvae;
                            }
                            switch (alt22) {
                                case 1 :
                                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:218:27: '\\n'
                                    {
                                    match('\n'); 

                                    }
                                    break;
                                case 2 :
                                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:218:32: '\\r' ( '\\n' )?
                                    {
                                    match('\r'); 
                                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:218:36: ( '\\n' )?
                                    int alt21=2;
                                    int LA21_0 = input.LA(1);

                                    if ( (LA21_0=='\n') ) {
                                        alt21=1;
                                    }
                                    switch (alt21) {
                                        case 1 :
                                            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:218:37: '\\n'
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
    // $ANTLR end LINE_COMMENT

    public void mTokens() throws RecognitionException {
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:8: ( MODULE | VAR | INIT | TRANS | JUST | COMPASSION | NEXT | PRIME | LEFT_BRACES | LEFT_CURLY | RIGHT_CURLY | RIGHT_BRACES | SEMICOLON | COLON | ASSIGN | DOT | AND | BINOR | IMPLIES | BIIMP | EQ | NEQ | NOT | BOOL_TYPE | TRUE | FALSE | ID | WS | MULTI_COMMENT | LINE_COMMENT )
        int alt25=30;
        switch ( input.LA(1) ) {
        case 'M':
            {
            switch ( input.LA(2) ) {
            case 'o':
                {
                int LA25_30 = input.LA(3);

                if ( (LA25_30=='d') ) {
                    int LA25_58 = input.LA(4);

                    if ( (LA25_58=='u') ) {
                        int LA25_77 = input.LA(5);

                        if ( (LA25_77=='l') ) {
                            int LA25_94 = input.LA(6);

                            if ( (LA25_94=='e') ) {
                                int LA25_111 = input.LA(7);

                                if ( ((LA25_111>='0' && LA25_111<='9')||(LA25_111>='A' && LA25_111<='Z')||LA25_111=='_'||(LA25_111>='a' && LA25_111<='z')) ) {
                                    alt25=27;
                                }
                                else {
                                    alt25=1;}
                            }
                            else {
                                alt25=27;}
                        }
                        else {
                            alt25=27;}
                    }
                    else {
                        alt25=27;}
                }
                else {
                    alt25=27;}
                }
                break;
            case 'O':
                {
                int LA25_31 = input.LA(3);

                if ( (LA25_31=='D') ) {
                    int LA25_59 = input.LA(4);

                    if ( (LA25_59=='U') ) {
                        int LA25_78 = input.LA(5);

                        if ( (LA25_78=='L') ) {
                            int LA25_95 = input.LA(6);

                            if ( (LA25_95=='E') ) {
                                int LA25_112 = input.LA(7);

                                if ( ((LA25_112>='0' && LA25_112<='9')||(LA25_112>='A' && LA25_112<='Z')||LA25_112=='_'||(LA25_112>='a' && LA25_112<='z')) ) {
                                    alt25=27;
                                }
                                else {
                                    alt25=1;}
                            }
                            else {
                                alt25=27;}
                        }
                        else {
                            alt25=27;}
                    }
                    else {
                        alt25=27;}
                }
                else {
                    alt25=27;}
                }
                break;
            default:
                alt25=27;}

            }
            break;
        case 'P':
            {
            switch ( input.LA(2) ) {
            case 'l':
                {
                int LA25_32 = input.LA(3);

                if ( (LA25_32=='a') ) {
                    int LA25_60 = input.LA(4);

                    if ( (LA25_60=='y') ) {
                        int LA25_79 = input.LA(5);

                        if ( (LA25_79=='e') ) {
                            int LA25_96 = input.LA(6);

                            if ( (LA25_96=='r') ) {
                                int LA25_113 = input.LA(7);

                                if ( ((LA25_113>='0' && LA25_113<='9')||(LA25_113>='A' && LA25_113<='Z')||LA25_113=='_'||(LA25_113>='a' && LA25_113<='z')) ) {
                                    alt25=27;
                                }
                                else {
                                    alt25=1;}
                            }
                            else {
                                alt25=27;}
                        }
                        else {
                            alt25=27;}
                    }
                    else {
                        alt25=27;}
                }
                else {
                    alt25=27;}
                }
                break;
            case 'L':
                {
                int LA25_33 = input.LA(3);

                if ( (LA25_33=='A') ) {
                    int LA25_61 = input.LA(4);

                    if ( (LA25_61=='Y') ) {
                        int LA25_80 = input.LA(5);

                        if ( (LA25_80=='E') ) {
                            int LA25_97 = input.LA(6);

                            if ( (LA25_97=='R') ) {
                                int LA25_114 = input.LA(7);

                                if ( ((LA25_114>='0' && LA25_114<='9')||(LA25_114>='A' && LA25_114<='Z')||LA25_114=='_'||(LA25_114>='a' && LA25_114<='z')) ) {
                                    alt25=27;
                                }
                                else {
                                    alt25=1;}
                            }
                            else {
                                alt25=27;}
                        }
                        else {
                            alt25=27;}
                    }
                    else {
                        alt25=27;}
                }
                else {
                    alt25=27;}
                }
                break;
            default:
                alt25=27;}

            }
            break;
        case 'V':
            {
            switch ( input.LA(2) ) {
            case 'a':
                {
                int LA25_34 = input.LA(3);

                if ( (LA25_34=='r') ) {
                    int LA25_62 = input.LA(4);

                    if ( ((LA25_62>='0' && LA25_62<='9')||(LA25_62>='A' && LA25_62<='Z')||LA25_62=='_'||(LA25_62>='a' && LA25_62<='z')) ) {
                        alt25=27;
                    }
                    else {
                        alt25=2;}
                }
                else {
                    alt25=27;}
                }
                break;
            case 'A':
                {
                int LA25_35 = input.LA(3);

                if ( (LA25_35=='R') ) {
                    int LA25_63 = input.LA(4);

                    if ( ((LA25_63>='0' && LA25_63<='9')||(LA25_63>='A' && LA25_63<='Z')||LA25_63=='_'||(LA25_63>='a' && LA25_63<='z')) ) {
                        alt25=27;
                    }
                    else {
                        alt25=2;}
                }
                else {
                    alt25=27;}
                }
                break;
            default:
                alt25=27;}

            }
            break;
        case 'I':
            {
            switch ( input.LA(2) ) {
            case 'n':
                {
                int LA25_36 = input.LA(3);

                if ( (LA25_36=='i') ) {
                    int LA25_64 = input.LA(4);

                    if ( (LA25_64=='t') ) {
                        int LA25_82 = input.LA(5);

                        if ( ((LA25_82>='0' && LA25_82<='9')||(LA25_82>='A' && LA25_82<='Z')||LA25_82=='_'||(LA25_82>='a' && LA25_82<='z')) ) {
                            alt25=27;
                        }
                        else {
                            alt25=3;}
                    }
                    else {
                        alt25=27;}
                }
                else {
                    alt25=27;}
                }
                break;
            case 'N':
                {
                int LA25_37 = input.LA(3);

                if ( (LA25_37=='I') ) {
                    int LA25_65 = input.LA(4);

                    if ( (LA25_65=='T') ) {
                        int LA25_83 = input.LA(5);

                        if ( ((LA25_83>='0' && LA25_83<='9')||(LA25_83>='A' && LA25_83<='Z')||LA25_83=='_'||(LA25_83>='a' && LA25_83<='z')) ) {
                            alt25=27;
                        }
                        else {
                            alt25=3;}
                    }
                    else {
                        alt25=27;}
                }
                else {
                    alt25=27;}
                }
                break;
            default:
                alt25=27;}

            }
            break;
        case 'T':
            {
            switch ( input.LA(2) ) {
            case 'r':
                {
                int LA25_38 = input.LA(3);

                if ( (LA25_38=='a') ) {
                    int LA25_66 = input.LA(4);

                    if ( (LA25_66=='n') ) {
                        int LA25_84 = input.LA(5);

                        if ( (LA25_84=='s') ) {
                            int LA25_99 = input.LA(6);

                            if ( ((LA25_99>='0' && LA25_99<='9')||(LA25_99>='A' && LA25_99<='Z')||LA25_99=='_'||(LA25_99>='a' && LA25_99<='z')) ) {
                                alt25=27;
                            }
                            else {
                                alt25=4;}
                        }
                        else {
                            alt25=27;}
                    }
                    else {
                        alt25=27;}
                }
                else {
                    alt25=27;}
                }
                break;
            case 'R':
                {
                switch ( input.LA(3) ) {
                case 'U':
                    {
                    int LA25_67 = input.LA(4);

                    if ( (LA25_67=='E') ) {
                        int LA25_85 = input.LA(5);

                        if ( ((LA25_85>='0' && LA25_85<='9')||(LA25_85>='A' && LA25_85<='Z')||LA25_85=='_'||(LA25_85>='a' && LA25_85<='z')) ) {
                            alt25=27;
                        }
                        else {
                            alt25=25;}
                    }
                    else {
                        alt25=27;}
                    }
                    break;
                case 'A':
                    {
                    int LA25_68 = input.LA(4);

                    if ( (LA25_68=='N') ) {
                        int LA25_86 = input.LA(5);

                        if ( (LA25_86=='S') ) {
                            int LA25_100 = input.LA(6);

                            if ( ((LA25_100>='0' && LA25_100<='9')||(LA25_100>='A' && LA25_100<='Z')||LA25_100=='_'||(LA25_100>='a' && LA25_100<='z')) ) {
                                alt25=27;
                            }
                            else {
                                alt25=4;}
                        }
                        else {
                            alt25=27;}
                    }
                    else {
                        alt25=27;}
                    }
                    break;
                default:
                    alt25=27;}

                }
                break;
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
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                alt25=27;
                }
                break;
            default:
                alt25=25;}

            }
            break;
        case 'J':
            {
            switch ( input.LA(2) ) {
            case 'u':
                {
                int LA25_41 = input.LA(3);

                if ( (LA25_41=='s') ) {
                    int LA25_69 = input.LA(4);

                    if ( (LA25_69=='t') ) {
                        switch ( input.LA(5) ) {
                        case 'i':
                            {
                            int LA25_101 = input.LA(6);

                            if ( (LA25_101=='c') ) {
                                int LA25_116 = input.LA(7);

                                if ( (LA25_116=='e') ) {
                                    int LA25_122 = input.LA(8);

                                    if ( ((LA25_122>='0' && LA25_122<='9')||(LA25_122>='A' && LA25_122<='Z')||LA25_122=='_'||(LA25_122>='a' && LA25_122<='z')) ) {
                                        alt25=27;
                                    }
                                    else {
                                        alt25=5;}
                                }
                                else {
                                    alt25=27;}
                            }
                            else {
                                alt25=27;}
                            }
                            break;
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
                        case 'R':
                        case 'S':
                        case 'T':
                        case 'U':
                        case 'V':
                        case 'W':
                        case 'X':
                        case 'Y':
                        case 'Z':
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
                            alt25=27;
                            }
                            break;
                        default:
                            alt25=5;}

                    }
                    else {
                        alt25=27;}
                }
                else {
                    alt25=27;}
                }
                break;
            case 'U':
                {
                int LA25_42 = input.LA(3);

                if ( (LA25_42=='S') ) {
                    int LA25_70 = input.LA(4);

                    if ( (LA25_70=='T') ) {
                        switch ( input.LA(5) ) {
                        case 'I':
                            {
                            int LA25_103 = input.LA(6);

                            if ( (LA25_103=='C') ) {
                                int LA25_117 = input.LA(7);

                                if ( (LA25_117=='E') ) {
                                    int LA25_123 = input.LA(8);

                                    if ( ((LA25_123>='0' && LA25_123<='9')||(LA25_123>='A' && LA25_123<='Z')||LA25_123=='_'||(LA25_123>='a' && LA25_123<='z')) ) {
                                        alt25=27;
                                    }
                                    else {
                                        alt25=5;}
                                }
                                else {
                                    alt25=27;}
                            }
                            else {
                                alt25=27;}
                            }
                            break;
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
                            alt25=27;
                            }
                            break;
                        default:
                            alt25=5;}

                    }
                    else {
                        alt25=27;}
                }
                else {
                    alt25=27;}
                }
                break;
            default:
                alt25=27;}

            }
            break;
        case 'C':
            {
            switch ( input.LA(2) ) {
            case 'o':
                {
                int LA25_43 = input.LA(3);

                if ( (LA25_43=='m') ) {
                    int LA25_71 = input.LA(4);

                    if ( (LA25_71=='p') ) {
                        switch ( input.LA(5) ) {
                        case 'a':
                            {
                            int LA25_104 = input.LA(6);

                            if ( (LA25_104=='s') ) {
                                int LA25_118 = input.LA(7);

                                if ( (LA25_118=='s') ) {
                                    int LA25_124 = input.LA(8);

                                    if ( (LA25_124=='i') ) {
                                        int LA25_127 = input.LA(9);

                                        if ( (LA25_127=='o') ) {
                                            int LA25_129 = input.LA(10);

                                            if ( (LA25_129=='n') ) {
                                                int LA25_131 = input.LA(11);

                                                if ( ((LA25_131>='0' && LA25_131<='9')||(LA25_131>='A' && LA25_131<='Z')||LA25_131=='_'||(LA25_131>='a' && LA25_131<='z')) ) {
                                                    alt25=27;
                                                }
                                                else {
                                                    alt25=6;}
                                            }
                                            else {
                                                alt25=27;}
                                        }
                                        else {
                                            alt25=27;}
                                    }
                                    else {
                                        alt25=27;}
                                }
                                else {
                                    alt25=27;}
                            }
                            else {
                                alt25=27;}
                            }
                            break;
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
                        case 'R':
                        case 'S':
                        case 'T':
                        case 'U':
                        case 'V':
                        case 'W':
                        case 'X':
                        case 'Y':
                        case 'Z':
                        case '_':
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
                            alt25=27;
                            }
                            break;
                        default:
                            alt25=6;}

                    }
                    else {
                        alt25=27;}
                }
                else {
                    alt25=27;}
                }
                break;
            case 'O':
                {
                int LA25_44 = input.LA(3);

                if ( (LA25_44=='M') ) {
                    int LA25_72 = input.LA(4);

                    if ( (LA25_72=='P') ) {
                        switch ( input.LA(5) ) {
                        case 'A':
                            {
                            int LA25_106 = input.LA(6);

                            if ( (LA25_106=='S') ) {
                                int LA25_119 = input.LA(7);

                                if ( (LA25_119=='S') ) {
                                    int LA25_125 = input.LA(8);

                                    if ( (LA25_125=='I') ) {
                                        int LA25_128 = input.LA(9);

                                        if ( (LA25_128=='O') ) {
                                            int LA25_130 = input.LA(10);

                                            if ( (LA25_130=='N') ) {
                                                int LA25_132 = input.LA(11);

                                                if ( ((LA25_132>='0' && LA25_132<='9')||(LA25_132>='A' && LA25_132<='Z')||LA25_132=='_'||(LA25_132>='a' && LA25_132<='z')) ) {
                                                    alt25=27;
                                                }
                                                else {
                                                    alt25=6;}
                                            }
                                            else {
                                                alt25=27;}
                                        }
                                        else {
                                            alt25=27;}
                                    }
                                    else {
                                        alt25=27;}
                                }
                                else {
                                    alt25=27;}
                            }
                            else {
                                alt25=27;}
                            }
                            break;
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
                            alt25=27;
                            }
                            break;
                        default:
                            alt25=6;}

                    }
                    else {
                        alt25=27;}
                }
                else {
                    alt25=27;}
                }
                break;
            default:
                alt25=27;}

            }
            break;
        case 'n':
            {
            int LA25_8 = input.LA(2);

            if ( (LA25_8=='e') ) {
                int LA25_45 = input.LA(3);

                if ( (LA25_45=='x') ) {
                    int LA25_73 = input.LA(4);

                    if ( (LA25_73=='t') ) {
                        int LA25_91 = input.LA(5);

                        if ( ((LA25_91>='0' && LA25_91<='9')||(LA25_91>='A' && LA25_91<='Z')||LA25_91=='_'||(LA25_91>='a' && LA25_91<='z')) ) {
                            alt25=27;
                        }
                        else {
                            alt25=7;}
                    }
                    else {
                        alt25=27;}
                }
                else {
                    alt25=27;}
            }
            else {
                alt25=27;}
            }
            break;
        case '\'':
            {
            alt25=8;
            }
            break;
        case '(':
            {
            alt25=9;
            }
            break;
        case '{':
            {
            alt25=10;
            }
            break;
        case '}':
            {
            alt25=11;
            }
            break;
        case ')':
            {
            alt25=12;
            }
            break;
        case ';':
            {
            alt25=13;
            }
            break;
        case ':':
            {
            int LA25_15 = input.LA(2);

            if ( (LA25_15=='=') ) {
                alt25=15;
            }
            else {
                alt25=14;}
            }
            break;
        case '.':
            {
            alt25=16;
            }
            break;
        case '/':
            {
            switch ( input.LA(2) ) {
            case '*':
                {
                alt25=29;
                }
                break;
            case '/':
                {
                alt25=30;
                }
                break;
            case '\\':
                {
                alt25=17;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1:1: Tokens : ( MODULE | VAR | INIT | TRANS | JUST | COMPASSION | NEXT | PRIME | LEFT_BRACES | LEFT_CURLY | RIGHT_CURLY | RIGHT_BRACES | SEMICOLON | COLON | ASSIGN | DOT | AND | BINOR | IMPLIES | BIIMP | EQ | NEQ | NOT | BOOL_TYPE | TRUE | FALSE | ID | WS | MULTI_COMMENT | LINE_COMMENT );", 25, 17, input);

                throw nvae;
            }

            }
            break;
        case '&':
            {
            alt25=17;
            }
            break;
        case 'a':
            {
            int LA25_19 = input.LA(2);

            if ( (LA25_19=='n') ) {
                int LA25_50 = input.LA(3);

                if ( (LA25_50=='d') ) {
                    int LA25_74 = input.LA(4);

                    if ( ((LA25_74>='0' && LA25_74<='9')||(LA25_74>='A' && LA25_74<='Z')||LA25_74=='_'||(LA25_74>='a' && LA25_74<='z')) ) {
                        alt25=27;
                    }
                    else {
                        alt25=17;}
                }
                else {
                    alt25=27;}
            }
            else {
                alt25=27;}
            }
            break;
        case '\\':
        case '|':
            {
            alt25=18;
            }
            break;
        case 'o':
            {
            int LA25_21 = input.LA(2);

            if ( (LA25_21=='r') ) {
                int LA25_51 = input.LA(3);

                if ( ((LA25_51>='0' && LA25_51<='9')||(LA25_51>='A' && LA25_51<='Z')||LA25_51=='_'||(LA25_51>='a' && LA25_51<='z')) ) {
                    alt25=27;
                }
                else {
                    alt25=18;}
            }
            else {
                alt25=27;}
            }
            break;
        case '-':
            {
            int LA25_22 = input.LA(2);

            if ( (LA25_22=='-') ) {
                alt25=30;
            }
            else if ( (LA25_22=='>') ) {
                alt25=19;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1:1: Tokens : ( MODULE | VAR | INIT | TRANS | JUST | COMPASSION | NEXT | PRIME | LEFT_BRACES | LEFT_CURLY | RIGHT_CURLY | RIGHT_BRACES | SEMICOLON | COLON | ASSIGN | DOT | AND | BINOR | IMPLIES | BIIMP | EQ | NEQ | NOT | BOOL_TYPE | TRUE | FALSE | ID | WS | MULTI_COMMENT | LINE_COMMENT );", 25, 22, input);

                throw nvae;
            }
            }
            break;
        case '<':
            {
            alt25=20;
            }
            break;
        case '=':
            {
            alt25=21;
            }
            break;
        case '!':
            {
            int LA25_25 = input.LA(2);

            if ( (LA25_25=='=') ) {
                alt25=22;
            }
            else {
                alt25=23;}
            }
            break;
        case 'b':
            {
            int LA25_26 = input.LA(2);

            if ( (LA25_26=='o') ) {
                int LA25_55 = input.LA(3);

                if ( (LA25_55=='o') ) {
                    int LA25_75 = input.LA(4);

                    if ( (LA25_75=='l') ) {
                        switch ( input.LA(5) ) {
                        case 'e':
                            {
                            int LA25_108 = input.LA(6);

                            if ( (LA25_108=='a') ) {
                                int LA25_120 = input.LA(7);

                                if ( (LA25_120=='n') ) {
                                    int LA25_126 = input.LA(8);

                                    if ( ((LA25_126>='0' && LA25_126<='9')||(LA25_126>='A' && LA25_126<='Z')||LA25_126=='_'||(LA25_126>='a' && LA25_126<='z')) ) {
                                        alt25=27;
                                    }
                                    else {
                                        alt25=24;}
                                }
                                else {
                                    alt25=27;}
                            }
                            else {
                                alt25=27;}
                            }
                            break;
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
                        case 'R':
                        case 'S':
                        case 'T':
                        case 'U':
                        case 'V':
                        case 'W':
                        case 'X':
                        case 'Y':
                        case 'Z':
                        case '_':
                        case 'a':
                        case 'b':
                        case 'c':
                        case 'd':
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
                            alt25=27;
                            }
                            break;
                        default:
                            alt25=24;}

                    }
                    else {
                        alt25=27;}
                }
                else {
                    alt25=27;}
            }
            else {
                alt25=27;}
            }
            break;
        case 'F':
            {
            switch ( input.LA(2) ) {
            case 'A':
                {
                int LA25_56 = input.LA(3);

                if ( (LA25_56=='L') ) {
                    int LA25_76 = input.LA(4);

                    if ( (LA25_76=='S') ) {
                        int LA25_93 = input.LA(5);

                        if ( (LA25_93=='E') ) {
                            int LA25_110 = input.LA(6);

                            if ( ((LA25_110>='0' && LA25_110<='9')||(LA25_110>='A' && LA25_110<='Z')||LA25_110=='_'||(LA25_110>='a' && LA25_110<='z')) ) {
                                alt25=27;
                            }
                            else {
                                alt25=26;}
                        }
                        else {
                            alt25=27;}
                    }
                    else {
                        alt25=27;}
                }
                else {
                    alt25=27;}
                }
                break;
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
                alt25=27;
                }
                break;
            default:
                alt25=26;}

            }
            break;
        case 'A':
        case 'B':
        case 'D':
        case 'E':
        case 'G':
        case 'H':
        case 'K':
        case 'L':
        case 'N':
        case 'O':
        case 'Q':
        case 'R':
        case 'S':
        case 'U':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case '_':
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
            alt25=27;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt25=28;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( MODULE | VAR | INIT | TRANS | JUST | COMPASSION | NEXT | PRIME | LEFT_BRACES | LEFT_CURLY | RIGHT_CURLY | RIGHT_BRACES | SEMICOLON | COLON | ASSIGN | DOT | AND | BINOR | IMPLIES | BIIMP | EQ | NEQ | NOT | BOOL_TYPE | TRUE | FALSE | ID | WS | MULTI_COMMENT | LINE_COMMENT );", 25, 0, input);

            throw nvae;
        }

        switch (alt25) {
            case 1 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:10: MODULE
                {
                mMODULE(); 

                }
                break;
            case 2 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:17: VAR
                {
                mVAR(); 

                }
                break;
            case 3 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:21: INIT
                {
                mINIT(); 

                }
                break;
            case 4 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:26: TRANS
                {
                mTRANS(); 

                }
                break;
            case 5 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:32: JUST
                {
                mJUST(); 

                }
                break;
            case 6 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:37: COMPASSION
                {
                mCOMPASSION(); 

                }
                break;
            case 7 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:48: NEXT
                {
                mNEXT(); 

                }
                break;
            case 8 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:53: PRIME
                {
                mPRIME(); 

                }
                break;
            case 9 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:59: LEFT_BRACES
                {
                mLEFT_BRACES(); 

                }
                break;
            case 10 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:71: LEFT_CURLY
                {
                mLEFT_CURLY(); 

                }
                break;
            case 11 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:82: RIGHT_CURLY
                {
                mRIGHT_CURLY(); 

                }
                break;
            case 12 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:94: RIGHT_BRACES
                {
                mRIGHT_BRACES(); 

                }
                break;
            case 13 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:107: SEMICOLON
                {
                mSEMICOLON(); 

                }
                break;
            case 14 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:117: COLON
                {
                mCOLON(); 

                }
                break;
            case 15 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:123: ASSIGN
                {
                mASSIGN(); 

                }
                break;
            case 16 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:130: DOT
                {
                mDOT(); 

                }
                break;
            case 17 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:134: AND
                {
                mAND(); 

                }
                break;
            case 18 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:138: BINOR
                {
                mBINOR(); 

                }
                break;
            case 19 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:144: IMPLIES
                {
                mIMPLIES(); 

                }
                break;
            case 20 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:152: BIIMP
                {
                mBIIMP(); 

                }
                break;
            case 21 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:158: EQ
                {
                mEQ(); 

                }
                break;
            case 22 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:161: NEQ
                {
                mNEQ(); 

                }
                break;
            case 23 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:165: NOT
                {
                mNOT(); 

                }
                break;
            case 24 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:169: BOOL_TYPE
                {
                mBOOL_TYPE(); 

                }
                break;
            case 25 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:179: TRUE
                {
                mTRUE(); 

                }
                break;
            case 26 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:184: FALSE
                {
                mFALSE(); 

                }
                break;
            case 27 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:190: ID
                {
                mID(); 

                }
                break;
            case 28 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:193: WS
                {
                mWS(); 

                }
                break;
            case 29 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:196: MULTI_COMMENT
                {
                mMULTI_COMMENT(); 

                }
                break;
            case 30 :
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:1:210: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;

        }

    }


 

}