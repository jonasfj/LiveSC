// $ANTLR 3.0.1 /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g 2008-05-28 22:53:08

package edu.wis.jtlv.env.core.fds;

import java.util.HashMap;

import net.sf.javabdd.BDD;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.TreeNodeStream;
import org.antlr.runtime.tree.TreeParser;

import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.module.FDSModule;
import edu.wis.jtlv.env.module.ModuleBDDField;
import edu.wis.jtlv.env.module.ModuleException;
public class FDSStmtWalker extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PROG_T", "MODULE_T", "VAR_T", "INIT_T", "TRANS_T", "JUST_T", "VAR_DECL_T", "INIT_DECL_EXPR_T", "TRANS_DECL_T", "JUST_DECL_T", "BLOCK_T", "REF_T", "PRIME_T", "BOOL_T", "MODULE", "ID", "LEFT_CURLY", "RIGHT_CURLY", "VAR", "INIT", "TRANS", "JUST", "COLON", "SEMICOLON", "ASSIGN", "TRUE", "FALSE", "BINOR", "AND", "IMPLIES", "BIIMP", "EQ", "NEQ", "NOT", "LEFT_BRACES", "RIGHT_BRACES", "PRIME", "NEXT", "DOT", "BOOL_TYPE", "COMPASSION", "WS", "MULTI_COMMENT", "LINE_COMMENT"
    };
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
    public static final int IMPLIES=33;
    public static final int BINOR=31;
    public static final int LINE_COMMENT=47;
    public static final int VAR_T=6;
    public static final int MODULE_T=5;
    public static final int TRANS_DECL_T=12;
    public static final int VAR_DECL_T=10;
    public static final int PROG_T=4;
    public static final int BOOL_T=17;
    public static final int LEFT_BRACES=38;
    public static final int SEMICOLON=27;
    public static final int BIIMP=34;
    public static final int MODULE=18;
    public static final int REF_T=15;
    public static final int INIT_DECL_EXPR_T=11;
    public static final int TRUE=29;
    public static final int JUST_DECL_T=13;
    public static final int COLON=26;
    public static final int NEQ=36;
    public static final int WS=45;
    public static final int INIT_T=7;
    public static final int LEFT_CURLY=20;
    public static final int ASSIGN=28;
    public static final int JUST=25;
    public static final int FALSE=30;
    public static final int INIT=23;

        public FDSStmtWalker(TreeNodeStream input) {
            super(input);
            ruleMemo = new HashMap[53+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "/home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g"; }


    public static FDSModule curr_module = null;



    // $ANTLR start program
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:32:1: program : ^( PROG_T ( module )+ ) ;
    public final void program() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:32:9: ( ^( PROG_T ( module )+ ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:32:11: ^( PROG_T ( module )+ )
            {
            match(input,PROG_T,FOLLOW_PROG_T_in_program57); if (failed) return ;

            match(input, Token.DOWN, null); if (failed) return ;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:32:20: ( module )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==MODULE_T) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:0:0: module
            	    {
            	    pushFollow(FOLLOW_module_in_program59);
            	    module();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (backtracking>0) {failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            match(input, Token.UP, null); if (failed) return ;

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
    // $ANTLR end program


    // $ANTLR start module
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:34:1: module : ^( MODULE_T m_name= ID ( section )* ) ;
    public final void module() throws RecognitionException {
        CommonTree m_name=null;

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:34:8: ( ^( MODULE_T m_name= ID ( section )* ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:34:10: ^( MODULE_T m_name= ID ( section )* )
            {
            match(input,MODULE_T,FOLLOW_MODULE_T_in_module70); if (failed) return ;

            match(input, Token.DOWN, null); if (failed) return ;
            m_name=(CommonTree)input.LT(1);
            match(input,ID,FOLLOW_ID_in_module74); if (failed) return ;
            if ( backtracking==0 ) {
              curr_module = ((FDSModule) Env.getModule(m_name.getText()));
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:34:90: ( section )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=VAR_T && LA2_0<=JUST_T)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:0:0: section
            	    {
            	    pushFollow(FOLLOW_section_in_module78);
            	    section();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            match(input, Token.UP, null); if (failed) return ;

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
    // $ANTLR end module


    // $ANTLR start section
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:37:1: section : ( var_sec | init_sec | trans_sec | just_sec ) ;
    public final void section() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:37:9: ( ( var_sec | init_sec | trans_sec | just_sec ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:37:11: ( var_sec | init_sec | trans_sec | just_sec )
            {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:37:11: ( var_sec | init_sec | trans_sec | just_sec )
            int alt3=4;
            switch ( input.LA(1) ) {
            case VAR_T:
                {
                alt3=1;
                }
                break;
            case INIT_T:
                {
                alt3=2;
                }
                break;
            case TRANS_T:
                {
                alt3=3;
                }
                break;
            case JUST_T:
                {
                alt3=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("37:11: ( var_sec | init_sec | trans_sec | just_sec )", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:37:12: var_sec
                    {
                    pushFollow(FOLLOW_var_sec_in_section90);
                    var_sec();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:37:22: init_sec
                    {
                    pushFollow(FOLLOW_init_sec_in_section94);
                    init_sec();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:37:33: trans_sec
                    {
                    pushFollow(FOLLOW_trans_sec_in_section98);
                    trans_sec();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 4 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:37:45: just_sec
                    {
                    pushFollow(FOLLOW_just_sec_in_section102);
                    just_sec();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }


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
    // $ANTLR end section


    // $ANTLR start var_sec
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:38:1: var_sec : ^( VAR_T ( var_decl )* ) ;
    public final void var_sec() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:38:9: ( ^( VAR_T ( var_decl )* ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:38:11: ^( VAR_T ( var_decl )* )
            {
            match(input,VAR_T,FOLLOW_VAR_T_in_var_sec111); if (failed) return ;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (failed) return ;
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:38:19: ( var_decl )*
                loop4:
                do {
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==VAR_DECL_T) ) {
                        alt4=1;
                    }


                    switch (alt4) {
                	case 1 :
                	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:0:0: var_decl
                	    {
                	    pushFollow(FOLLOW_var_decl_in_var_sec113);
                	    var_decl();
                	    _fsp--;
                	    if (failed) return ;

                	    }
                	    break;

                	default :
                	    break loop4;
                    }
                } while (true);


                match(input, Token.UP, null); if (failed) return ;
            }

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
    // $ANTLR end var_sec


    // $ANTLR start init_sec
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:39:1: init_sec : ^( INIT_T ( init_decl )* ) ;
    public final void init_sec() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:39:10: ( ^( INIT_T ( init_decl )* ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:39:12: ^( INIT_T ( init_decl )* )
            {
            match(input,INIT_T,FOLLOW_INIT_T_in_init_sec123); if (failed) return ;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (failed) return ;
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:39:21: ( init_decl )*
                loop5:
                do {
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==INIT_DECL_EXPR_T) ) {
                        alt5=1;
                    }


                    switch (alt5) {
                	case 1 :
                	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:0:0: init_decl
                	    {
                	    pushFollow(FOLLOW_init_decl_in_init_sec125);
                	    init_decl();
                	    _fsp--;
                	    if (failed) return ;

                	    }
                	    break;

                	default :
                	    break loop5;
                    }
                } while (true);


                match(input, Token.UP, null); if (failed) return ;
            }

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
    // $ANTLR end init_sec


    // $ANTLR start trans_sec
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:40:1: trans_sec : ^( TRANS_T ( trans_decl )* ) ;
    public final void trans_sec() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:40:11: ( ^( TRANS_T ( trans_decl )* ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:40:13: ^( TRANS_T ( trans_decl )* )
            {
            match(input,TRANS_T,FOLLOW_TRANS_T_in_trans_sec135); if (failed) return ;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (failed) return ;
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:40:23: ( trans_decl )*
                loop6:
                do {
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==TRANS_DECL_T) ) {
                        alt6=1;
                    }


                    switch (alt6) {
                	case 1 :
                	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:0:0: trans_decl
                	    {
                	    pushFollow(FOLLOW_trans_decl_in_trans_sec137);
                	    trans_decl();
                	    _fsp--;
                	    if (failed) return ;

                	    }
                	    break;

                	default :
                	    break loop6;
                    }
                } while (true);


                match(input, Token.UP, null); if (failed) return ;
            }

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
    // $ANTLR end trans_sec


    // $ANTLR start just_sec
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:41:1: just_sec : ^( JUST_T ( just_decl )* ) ;
    public final void just_sec() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:41:10: ( ^( JUST_T ( just_decl )* ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:41:12: ^( JUST_T ( just_decl )* )
            {
            match(input,JUST_T,FOLLOW_JUST_T_in_just_sec147); if (failed) return ;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (failed) return ;
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:41:21: ( just_decl )*
                loop7:
                do {
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==JUST_DECL_T) ) {
                        alt7=1;
                    }


                    switch (alt7) {
                	case 1 :
                	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:0:0: just_decl
                	    {
                	    pushFollow(FOLLOW_just_decl_in_just_sec149);
                	    just_decl();
                	    _fsp--;
                	    if (failed) return ;

                	    }
                	    break;

                	default :
                	    break loop7;
                    }
                } while (true);


                match(input, Token.UP, null); if (failed) return ;
            }

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
    // $ANTLR end just_sec


    // $ANTLR start var_decl
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:45:1: var_decl : ^( VAR_DECL_T ID type ) ;
    public final void var_decl() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:45:10: ( ^( VAR_DECL_T ID type ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:45:12: ^( VAR_DECL_T ID type )
            {
            match(input,VAR_DECL_T,FOLLOW_VAR_DECL_T_in_var_decl162); if (failed) return ;

            match(input, Token.DOWN, null); if (failed) return ;
            match(input,ID,FOLLOW_ID_in_var_decl164); if (failed) return ;
            pushFollow(FOLLOW_type_in_var_decl166);
            type();
            _fsp--;
            if (failed) return ;

            match(input, Token.UP, null); if (failed) return ;

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
    // $ANTLR end var_decl


    // $ANTLR start init_decl
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:46:1: init_decl : init_decl_expr ;
    public final void init_decl() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:46:11: ( init_decl_expr )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:46:36: init_decl_expr
            {
            pushFollow(FOLLOW_init_decl_expr_in_init_decl176);
            init_decl_expr();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end init_decl


    // $ANTLR start init_decl_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:51:1: init_decl_expr : ^( INIT_DECL_EXPR_T bool_expr ) ;
    public final void init_decl_expr() throws RecognitionException {
        BDD bool_expr1 = null;


        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:51:16: ( ^( INIT_DECL_EXPR_T bool_expr ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:51:18: ^( INIT_DECL_EXPR_T bool_expr )
            {
            match(input,INIT_DECL_EXPR_T,FOLLOW_INIT_DECL_EXPR_T_in_init_decl_expr188); if (failed) return ;

            match(input, Token.DOWN, null); if (failed) return ;
            pushFollow(FOLLOW_bool_expr_in_init_decl_expr190);
            bool_expr1=bool_expr();
            _fsp--;
            if (failed) return ;

            match(input, Token.UP, null); if (failed) return ;
            if ( backtracking==0 ) {
              curr_module.addInitial(bool_expr1);
            }

            }

        }
        catch (ModuleException e) {
            e.printStackTrace();
        }
        catch (RecognitionException re) {
            reportError(re); recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end init_decl_expr


    // $ANTLR start trans_decl
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:55:1: trans_decl : ^( TRANS_DECL_T bool_expr ) ;
    public final void trans_decl() throws RecognitionException {
        BDD bool_expr2 = null;


        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:55:12: ( ^( TRANS_DECL_T bool_expr ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:55:14: ^( TRANS_DECL_T bool_expr )
            {
            match(input,TRANS_DECL_T,FOLLOW_TRANS_DECL_T_in_trans_decl216); if (failed) return ;

            match(input, Token.DOWN, null); if (failed) return ;
            pushFollow(FOLLOW_bool_expr_in_trans_decl218);
            bool_expr2=bool_expr();
            _fsp--;
            if (failed) return ;

            match(input, Token.UP, null); if (failed) return ;
            if ( backtracking==0 ) {
              curr_module.conjunctTrans(bool_expr2);
            }

            }

        }
        catch (ModuleException e) {
            e.printStackTrace();
        }
        catch (RecognitionException re) {
            reportError(re); recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end trans_decl


    // $ANTLR start just_decl
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:59:1: just_decl : ^( JUST_DECL_T bool_expr ) ;
    public final void just_decl() throws RecognitionException {
        BDD bool_expr3 = null;


        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:59:11: ( ^( JUST_DECL_T bool_expr ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:59:13: ^( JUST_DECL_T bool_expr )
            {
            match(input,JUST_DECL_T,FOLLOW_JUST_DECL_T_in_just_decl244); if (failed) return ;

            match(input, Token.DOWN, null); if (failed) return ;
            pushFollow(FOLLOW_bool_expr_in_just_decl246);
            bool_expr3=bool_expr();
            _fsp--;
            if (failed) return ;

            match(input, Token.UP, null); if (failed) return ;
            if ( backtracking==0 ) {
              curr_module.addJustice(bool_expr3);
            }

            }

        }
        catch (ModuleException e) {
            e.printStackTrace();
        }
        catch (RecognitionException re) {
            reportError(re); recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end just_decl


    // $ANTLR start bool_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:65:1: bool_expr returns [BDD ret] : binor_expr ;
    public final BDD bool_expr() throws RecognitionException {
        BDD ret = null;

        BDD binor_expr4 = null;


        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:66:2: ( binor_expr )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:66:4: binor_expr
            {
            pushFollow(FOLLOW_binor_expr_in_bool_expr277);
            binor_expr4=binor_expr();
            _fsp--;
            if (failed) return ret;
            if ( backtracking==0 ) {
              ret = binor_expr4;
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret;
    }
    // $ANTLR end bool_expr


    // $ANTLR start binor_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:67:1: binor_expr returns [BDD ret] : ( ^( BINOR first= binor_expr second= binor_expr ) | and_expr );
    public final BDD binor_expr() throws RecognitionException {
        BDD ret = null;

        BDD first = null;

        BDD second = null;

        BDD and_expr5 = null;


        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:68:2: ( ^( BINOR first= binor_expr second= binor_expr ) | and_expr )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==BINOR) ) {
                alt8=1;
            }
            else if ( ((LA8_0>=BLOCK_T && LA8_0<=REF_T)||(LA8_0>=TRUE && LA8_0<=FALSE)||(LA8_0>=AND && LA8_0<=NOT)) ) {
                alt8=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret;}
                NoViableAltException nvae =
                    new NoViableAltException("67:1: binor_expr returns [BDD ret] : ( ^( BINOR first= binor_expr second= binor_expr ) | and_expr );", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:68:4: ^( BINOR first= binor_expr second= binor_expr )
                    {
                    match(input,BINOR,FOLLOW_BINOR_in_binor_expr291); if (failed) return ret;

                    match(input, Token.DOWN, null); if (failed) return ret;
                    pushFollow(FOLLOW_binor_expr_in_binor_expr295);
                    first=binor_expr();
                    _fsp--;
                    if (failed) return ret;
                    pushFollow(FOLLOW_binor_expr_in_binor_expr299);
                    second=binor_expr();
                    _fsp--;
                    if (failed) return ret;

                    match(input, Token.UP, null); if (failed) return ret;
                    if ( backtracking==0 ) {
                      ret = first.or(second);
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:69:4: and_expr
                    {
                    pushFollow(FOLLOW_and_expr_in_binor_expr307);
                    and_expr5=and_expr();
                    _fsp--;
                    if (failed) return ret;
                    if ( backtracking==0 ) {
                      ret = and_expr5;
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
        }
        return ret;
    }
    // $ANTLR end binor_expr


    // $ANTLR start and_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:70:1: and_expr returns [BDD ret] : ( ^( AND first= and_expr second= and_expr ) | implies_expr );
    public final BDD and_expr() throws RecognitionException {
        BDD ret = null;

        BDD first = null;

        BDD second = null;

        BDD implies_expr6 = null;


        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:71:2: ( ^( AND first= and_expr second= and_expr ) | implies_expr )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==AND) ) {
                alt9=1;
            }
            else if ( ((LA9_0>=BLOCK_T && LA9_0<=REF_T)||(LA9_0>=TRUE && LA9_0<=FALSE)||(LA9_0>=IMPLIES && LA9_0<=NOT)) ) {
                alt9=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret;}
                NoViableAltException nvae =
                    new NoViableAltException("70:1: and_expr returns [BDD ret] : ( ^( AND first= and_expr second= and_expr ) | implies_expr );", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:71:4: ^( AND first= and_expr second= and_expr )
                    {
                    match(input,AND,FOLLOW_AND_in_and_expr321); if (failed) return ret;

                    match(input, Token.DOWN, null); if (failed) return ret;
                    pushFollow(FOLLOW_and_expr_in_and_expr325);
                    first=and_expr();
                    _fsp--;
                    if (failed) return ret;
                    pushFollow(FOLLOW_and_expr_in_and_expr329);
                    second=and_expr();
                    _fsp--;
                    if (failed) return ret;

                    match(input, Token.UP, null); if (failed) return ret;
                    if ( backtracking==0 ) {
                      ret = first.and(second);
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:72:4: implies_expr
                    {
                    pushFollow(FOLLOW_implies_expr_in_and_expr337);
                    implies_expr6=implies_expr();
                    _fsp--;
                    if (failed) return ret;
                    if ( backtracking==0 ) {
                      ret = implies_expr6;
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
        }
        return ret;
    }
    // $ANTLR end and_expr


    // $ANTLR start implies_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:73:1: implies_expr returns [BDD ret] : ( ^( IMPLIES first= implies_expr second= implies_expr ) | biimp_expr );
    public final BDD implies_expr() throws RecognitionException {
        BDD ret = null;

        BDD first = null;

        BDD second = null;

        BDD biimp_expr7 = null;


        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:74:2: ( ^( IMPLIES first= implies_expr second= implies_expr ) | biimp_expr )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==IMPLIES) ) {
                alt10=1;
            }
            else if ( ((LA10_0>=BLOCK_T && LA10_0<=REF_T)||(LA10_0>=TRUE && LA10_0<=FALSE)||(LA10_0>=BIIMP && LA10_0<=NOT)) ) {
                alt10=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret;}
                NoViableAltException nvae =
                    new NoViableAltException("73:1: implies_expr returns [BDD ret] : ( ^( IMPLIES first= implies_expr second= implies_expr ) | biimp_expr );", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:74:4: ^( IMPLIES first= implies_expr second= implies_expr )
                    {
                    match(input,IMPLIES,FOLLOW_IMPLIES_in_implies_expr351); if (failed) return ret;

                    match(input, Token.DOWN, null); if (failed) return ret;
                    pushFollow(FOLLOW_implies_expr_in_implies_expr355);
                    first=implies_expr();
                    _fsp--;
                    if (failed) return ret;
                    pushFollow(FOLLOW_implies_expr_in_implies_expr359);
                    second=implies_expr();
                    _fsp--;
                    if (failed) return ret;

                    match(input, Token.UP, null); if (failed) return ret;
                    if ( backtracking==0 ) {
                      ret = first.imp(second);
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:75:4: biimp_expr
                    {
                    pushFollow(FOLLOW_biimp_expr_in_implies_expr367);
                    biimp_expr7=biimp_expr();
                    _fsp--;
                    if (failed) return ret;
                    if ( backtracking==0 ) {
                      ret = biimp_expr7;
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
        }
        return ret;
    }
    // $ANTLR end implies_expr


    // $ANTLR start biimp_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:76:1: biimp_expr returns [BDD ret] : ( ^( BIIMP first= biimp_expr second= biimp_expr ) | eq_expr );
    public final BDD biimp_expr() throws RecognitionException {
        BDD ret = null;

        BDD first = null;

        BDD second = null;

        BDD eq_expr8 = null;


        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:77:2: ( ^( BIIMP first= biimp_expr second= biimp_expr ) | eq_expr )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==BIIMP) ) {
                alt11=1;
            }
            else if ( ((LA11_0>=BLOCK_T && LA11_0<=REF_T)||(LA11_0>=TRUE && LA11_0<=FALSE)||(LA11_0>=EQ && LA11_0<=NOT)) ) {
                alt11=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret;}
                NoViableAltException nvae =
                    new NoViableAltException("76:1: biimp_expr returns [BDD ret] : ( ^( BIIMP first= biimp_expr second= biimp_expr ) | eq_expr );", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:77:4: ^( BIIMP first= biimp_expr second= biimp_expr )
                    {
                    match(input,BIIMP,FOLLOW_BIIMP_in_biimp_expr381); if (failed) return ret;

                    match(input, Token.DOWN, null); if (failed) return ret;
                    pushFollow(FOLLOW_biimp_expr_in_biimp_expr385);
                    first=biimp_expr();
                    _fsp--;
                    if (failed) return ret;
                    pushFollow(FOLLOW_biimp_expr_in_biimp_expr389);
                    second=biimp_expr();
                    _fsp--;
                    if (failed) return ret;

                    match(input, Token.UP, null); if (failed) return ret;
                    if ( backtracking==0 ) {
                      ret = first.biimp(second);
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:78:4: eq_expr
                    {
                    pushFollow(FOLLOW_eq_expr_in_biimp_expr397);
                    eq_expr8=eq_expr();
                    _fsp--;
                    if (failed) return ret;
                    if ( backtracking==0 ) {
                      ret = eq_expr8;
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
        }
        return ret;
    }
    // $ANTLR end biimp_expr


    // $ANTLR start eq_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:79:1: eq_expr returns [BDD ret] : ( ^( EQ first= eq_expr second= eq_expr ) | neq_expr );
    public final BDD eq_expr() throws RecognitionException {
        BDD ret = null;

        BDD first = null;

        BDD second = null;

        BDD neq_expr9 = null;


        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:80:2: ( ^( EQ first= eq_expr second= eq_expr ) | neq_expr )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==EQ) ) {
                alt12=1;
            }
            else if ( ((LA12_0>=BLOCK_T && LA12_0<=REF_T)||(LA12_0>=TRUE && LA12_0<=FALSE)||(LA12_0>=NEQ && LA12_0<=NOT)) ) {
                alt12=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret;}
                NoViableAltException nvae =
                    new NoViableAltException("79:1: eq_expr returns [BDD ret] : ( ^( EQ first= eq_expr second= eq_expr ) | neq_expr );", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:80:4: ^( EQ first= eq_expr second= eq_expr )
                    {
                    match(input,EQ,FOLLOW_EQ_in_eq_expr411); if (failed) return ret;

                    match(input, Token.DOWN, null); if (failed) return ret;
                    pushFollow(FOLLOW_eq_expr_in_eq_expr415);
                    first=eq_expr();
                    _fsp--;
                    if (failed) return ret;
                    pushFollow(FOLLOW_eq_expr_in_eq_expr419);
                    second=eq_expr();
                    _fsp--;
                    if (failed) return ret;

                    match(input, Token.UP, null); if (failed) return ret;
                    if ( backtracking==0 ) {
                      ret = first.biimp(second);
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:81:4: neq_expr
                    {
                    pushFollow(FOLLOW_neq_expr_in_eq_expr427);
                    neq_expr9=neq_expr();
                    _fsp--;
                    if (failed) return ret;
                    if ( backtracking==0 ) {
                      ret = neq_expr9;
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
        }
        return ret;
    }
    // $ANTLR end eq_expr


    // $ANTLR start neq_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:82:1: neq_expr returns [BDD ret] : ( ^( NEQ first= neq_expr second= neq_expr ) | not_expr );
    public final BDD neq_expr() throws RecognitionException {
        BDD ret = null;

        BDD first = null;

        BDD second = null;

        BDD not_expr10 = null;


        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:83:2: ( ^( NEQ first= neq_expr second= neq_expr ) | not_expr )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==NEQ) ) {
                alt13=1;
            }
            else if ( ((LA13_0>=BLOCK_T && LA13_0<=REF_T)||(LA13_0>=TRUE && LA13_0<=FALSE)||LA13_0==NOT) ) {
                alt13=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret;}
                NoViableAltException nvae =
                    new NoViableAltException("82:1: neq_expr returns [BDD ret] : ( ^( NEQ first= neq_expr second= neq_expr ) | not_expr );", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:83:4: ^( NEQ first= neq_expr second= neq_expr )
                    {
                    match(input,NEQ,FOLLOW_NEQ_in_neq_expr441); if (failed) return ret;

                    match(input, Token.DOWN, null); if (failed) return ret;
                    pushFollow(FOLLOW_neq_expr_in_neq_expr445);
                    first=neq_expr();
                    _fsp--;
                    if (failed) return ret;
                    pushFollow(FOLLOW_neq_expr_in_neq_expr449);
                    second=neq_expr();
                    _fsp--;
                    if (failed) return ret;

                    match(input, Token.UP, null); if (failed) return ret;
                    if ( backtracking==0 ) {
                      ret = first.biimp(second).not();
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:84:4: not_expr
                    {
                    pushFollow(FOLLOW_not_expr_in_neq_expr457);
                    not_expr10=not_expr();
                    _fsp--;
                    if (failed) return ret;
                    if ( backtracking==0 ) {
                      ret = not_expr10;
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
        }
        return ret;
    }
    // $ANTLR end neq_expr


    // $ANTLR start not_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:85:1: not_expr returns [BDD ret] : ( ^( NOT first= not_expr ) | block_expr );
    public final BDD not_expr() throws RecognitionException {
        BDD ret = null;

        BDD first = null;

        BDD block_expr11 = null;


        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:86:2: ( ^( NOT first= not_expr ) | block_expr )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==NOT) ) {
                alt14=1;
            }
            else if ( ((LA14_0>=BLOCK_T && LA14_0<=REF_T)||(LA14_0>=TRUE && LA14_0<=FALSE)) ) {
                alt14=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret;}
                NoViableAltException nvae =
                    new NoViableAltException("85:1: not_expr returns [BDD ret] : ( ^( NOT first= not_expr ) | block_expr );", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:86:4: ^( NOT first= not_expr )
                    {
                    match(input,NOT,FOLLOW_NOT_in_not_expr471); if (failed) return ret;

                    match(input, Token.DOWN, null); if (failed) return ret;
                    pushFollow(FOLLOW_not_expr_in_not_expr475);
                    first=not_expr();
                    _fsp--;
                    if (failed) return ret;

                    match(input, Token.UP, null); if (failed) return ret;
                    if ( backtracking==0 ) {
                      ret = first.not();
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:87:4: block_expr
                    {
                    pushFollow(FOLLOW_block_expr_in_not_expr483);
                    block_expr11=block_expr();
                    _fsp--;
                    if (failed) return ret;
                    if ( backtracking==0 ) {
                      ret = block_expr11;
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
        }
        return ret;
    }
    // $ANTLR end not_expr


    // $ANTLR start block_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:88:1: block_expr returns [BDD ret] : ( ^( BLOCK_T bool_expr ) | atom_expr );
    public final BDD block_expr() throws RecognitionException {
        BDD ret = null;

        BDD bool_expr12 = null;

        BDD atom_expr13 = null;


        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:89:2: ( ^( BLOCK_T bool_expr ) | atom_expr )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==BLOCK_T) ) {
                alt15=1;
            }
            else if ( (LA15_0==REF_T||(LA15_0>=TRUE && LA15_0<=FALSE)) ) {
                alt15=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret;}
                NoViableAltException nvae =
                    new NoViableAltException("88:1: block_expr returns [BDD ret] : ( ^( BLOCK_T bool_expr ) | atom_expr );", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:89:4: ^( BLOCK_T bool_expr )
                    {
                    match(input,BLOCK_T,FOLLOW_BLOCK_T_in_block_expr497); if (failed) return ret;

                    match(input, Token.DOWN, null); if (failed) return ret;
                    pushFollow(FOLLOW_bool_expr_in_block_expr499);
                    bool_expr12=bool_expr();
                    _fsp--;
                    if (failed) return ret;

                    match(input, Token.UP, null); if (failed) return ret;
                    if ( backtracking==0 ) {
                      ret = bool_expr12;
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:90:4: atom_expr
                    {
                    pushFollow(FOLLOW_atom_expr_in_block_expr507);
                    atom_expr13=atom_expr();
                    _fsp--;
                    if (failed) return ret;
                    if ( backtracking==0 ) {
                      ret = atom_expr13;
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
        }
        return ret;
    }
    // $ANTLR end block_expr


    // $ANTLR start atom_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:91:1: atom_expr returns [BDD ret] : ( any_ref | value );
    public final BDD atom_expr() throws RecognitionException {
        BDD ret = null;

        BDD any_ref14 = null;

        BDD value15 = null;


        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:92:2: ( any_ref | value )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==REF_T) ) {
                alt16=1;
            }
            else if ( ((LA16_0>=TRUE && LA16_0<=FALSE)) ) {
                alt16=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret;}
                NoViableAltException nvae =
                    new NoViableAltException("91:1: atom_expr returns [BDD ret] : ( any_ref | value );", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:92:4: any_ref
                    {
                    pushFollow(FOLLOW_any_ref_in_atom_expr520);
                    any_ref14=any_ref();
                    _fsp--;
                    if (failed) return ret;
                    if ( backtracking==0 ) {
                      ret = any_ref14;
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:93:4: value
                    {
                    pushFollow(FOLLOW_value_in_atom_expr527);
                    value15=value();
                    _fsp--;
                    if (failed) return ret;
                    if ( backtracking==0 ) {
                      ret = value15;
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
        }
        return ret;
    }
    // $ANTLR end atom_expr


    // $ANTLR start value
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:95:1: value returns [BDD ret] : ( TRUE | FALSE );
    public final BDD value() throws RecognitionException {
        BDD ret = null;

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:96:2: ( TRUE | FALSE )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==TRUE) ) {
                alt17=1;
            }
            else if ( (LA17_0==FALSE) ) {
                alt17=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret;}
                NoViableAltException nvae =
                    new NoViableAltException("95:1: value returns [BDD ret] : ( TRUE | FALSE );", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:96:4: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_value542); if (failed) return ret;
                    if ( backtracking==0 ) {
                      ret = edu.wis.jtlv.env.Env.TRUE();
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:97:4: FALSE
                    {
                    match(input,FALSE,FOLLOW_FALSE_in_value549); if (failed) return ret;
                    if ( backtracking==0 ) {
                      ret = edu.wis.jtlv.env.Env.FALSE();
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
        }
        return ret;
    }
    // $ANTLR end value


    // $ANTLR start any_ref
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:101:1: any_ref returns [BDD ret] : ( unprime_ref | prime_ref );
    public final BDD any_ref() throws RecognitionException {
        BDD ret = null;

        BDD unprime_ref16 = null;

        BDD prime_ref17 = null;


        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:102:2: ( unprime_ref | prime_ref )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==REF_T) ) {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==DOWN) ) {
                    int LA18_2 = input.LA(3);

                    if ( (LA18_2==PRIME_T) ) {
                        alt18=2;
                    }
                    else if ( (LA18_2==ID||LA18_2==DOT) ) {
                        alt18=1;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ret;}
                        NoViableAltException nvae =
                            new NoViableAltException("101:1: any_ref returns [BDD ret] : ( unprime_ref | prime_ref );", 18, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return ret;}
                    NoViableAltException nvae =
                        new NoViableAltException("101:1: any_ref returns [BDD ret] : ( unprime_ref | prime_ref );", 18, 1, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return ret;}
                NoViableAltException nvae =
                    new NoViableAltException("101:1: any_ref returns [BDD ret] : ( unprime_ref | prime_ref );", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:102:4: unprime_ref
                    {
                    pushFollow(FOLLOW_unprime_ref_in_any_ref566);
                    unprime_ref16=unprime_ref();
                    _fsp--;
                    if (failed) return ret;
                    if ( backtracking==0 ) {
                      ret = unprime_ref16;
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:103:4: prime_ref
                    {
                    pushFollow(FOLLOW_prime_ref_in_any_ref573);
                    prime_ref17=prime_ref();
                    _fsp--;
                    if (failed) return ret;
                    if ( backtracking==0 ) {
                      ret = prime_ref17;
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
        }
        return ret;
    }
    // $ANTLR end any_ref


    // $ANTLR start prime_ref
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:104:1: prime_ref returns [BDD ret] : ^( REF_T ^( PRIME_T native_ref ) ) ;
    public final BDD prime_ref() throws RecognitionException {
        BDD ret = null;

        ModuleBDDField native_ref18 = null;


        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:105:2: ( ^( REF_T ^( PRIME_T native_ref ) ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:105:4: ^( REF_T ^( PRIME_T native_ref ) )
            {
            match(input,REF_T,FOLLOW_REF_T_in_prime_ref587); if (failed) return ret;

            match(input, Token.DOWN, null); if (failed) return ret;
            match(input,PRIME_T,FOLLOW_PRIME_T_in_prime_ref590); if (failed) return ret;

            match(input, Token.DOWN, null); if (failed) return ret;
            pushFollow(FOLLOW_native_ref_in_prime_ref592);
            native_ref18=native_ref();
            _fsp--;
            if (failed) return ret;

            match(input, Token.UP, null); if (failed) return ret;

            match(input, Token.UP, null); if (failed) return ret;
            if ( backtracking==0 ) {
              ret = native_ref18.prime().getDomain().ithVar(1);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret;
    }
    // $ANTLR end prime_ref


    // $ANTLR start unprime_ref
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:106:1: unprime_ref returns [BDD ret] : ^( REF_T native_ref ) ;
    public final BDD unprime_ref() throws RecognitionException {
        BDD ret = null;

        ModuleBDDField native_ref19 = null;


        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:107:2: ( ^( REF_T native_ref ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:107:4: ^( REF_T native_ref )
            {
            match(input,REF_T,FOLLOW_REF_T_in_unprime_ref608); if (failed) return ret;

            match(input, Token.DOWN, null); if (failed) return ret;
            pushFollow(FOLLOW_native_ref_in_unprime_ref610);
            native_ref19=native_ref();
            _fsp--;
            if (failed) return ret;

            match(input, Token.UP, null); if (failed) return ret;
            if ( backtracking==0 ) {
              ret = native_ref19.getDomain().ithVar(1);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret;
    }
    // $ANTLR end unprime_ref


    // $ANTLR start native_ref
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:108:1: native_ref returns [ModuleBDDField ret] : construct_name ;
    public final ModuleBDDField native_ref() throws RecognitionException {
        ModuleBDDField ret = null;

        String construct_name20 = null;


        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:109:2: ( construct_name )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:109:4: construct_name
            {
            pushFollow(FOLLOW_construct_name_in_native_ref624);
            construct_name20=construct_name();
            _fsp--;
            if (failed) return ret;
            if ( backtracking==0 ) {

              if (construct_name20.indexOf("-->>") == -1)
              	ret = Env.getVar(curr_module.getFullInstName(), construct_name20);
              else
              	ret = edu.wis.jtlv.env.Env.getVar(construct_name20.substring(0, construct_name20.indexOf("-->>")), construct_name20.substring(construct_name20.indexOf("-->>") + 4));
              	if (ret == null) 
              		throw new FDSParseException("Could not find variable " + construct_name20, input);
              	//ret = edu.wis.jtlv.env.Env.getVar(construct_name20.substring(0, construct_name20.indexOf("-->>")), construct_name20.substring(construct_name20.indexOf("-->>") + 4));

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret;
    }
    // $ANTLR end native_ref


    // $ANTLR start construct_name
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:118:1: construct_name returns [String ret] : ( loc_ref | far_ref );
    public final String construct_name() throws RecognitionException {
        String ret = null;

        String loc_ref21 = null;

        String far_ref22 = null;


        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:119:2: ( loc_ref | far_ref )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==ID) ) {
                alt19=1;
            }
            else if ( (LA19_0==DOT) ) {
                alt19=2;
            }
            else {
                if (backtracking>0) {failed=true; return ret;}
                NoViableAltException nvae =
                    new NoViableAltException("118:1: construct_name returns [String ret] : ( loc_ref | far_ref );", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:119:4: loc_ref
                    {
                    pushFollow(FOLLOW_loc_ref_in_construct_name637);
                    loc_ref21=loc_ref();
                    _fsp--;
                    if (failed) return ret;
                    if ( backtracking==0 ) {
                      ret = loc_ref21;
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:120:4: far_ref
                    {
                    pushFollow(FOLLOW_far_ref_in_construct_name644);
                    far_ref22=far_ref();
                    _fsp--;
                    if (failed) return ret;
                    if ( backtracking==0 ) {
                      ret = far_ref22;
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
        }
        return ret;
    }
    // $ANTLR end construct_name


    // $ANTLR start loc_ref
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:121:1: loc_ref returns [String ret] : ID ;
    public final String loc_ref() throws RecognitionException {
        String ret = null;

        CommonTree ID23=null;

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:122:2: ( ID )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:122:4: ID
            {
            ID23=(CommonTree)input.LT(1);
            match(input,ID,FOLLOW_ID_in_loc_ref657); if (failed) return ret;
            if ( backtracking==0 ) {
              ret = ID23.getText();
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret;
    }
    // $ANTLR end loc_ref


    // $ANTLR start far_ref
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:123:1: far_ref returns [String ret] : ( ^( DOT ID loc_ref ) | ^( DOT ID far_ref ) );
    public final String far_ref() throws RecognitionException {
        String ret = null;

        CommonTree ID24=null;
        CommonTree ID26=null;
        String loc_ref25 = null;


        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:124:2: ( ^( DOT ID loc_ref ) | ^( DOT ID far_ref ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==DOT) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==DOWN) ) {
                    int LA20_2 = input.LA(3);

                    if ( (LA20_2==ID) ) {
                        int LA20_3 = input.LA(4);

                        if ( (LA20_3==ID) ) {
                            alt20=1;
                        }
                        else if ( (LA20_3==DOT) ) {
                            alt20=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return ret;}
                            NoViableAltException nvae =
                                new NoViableAltException("123:1: far_ref returns [String ret] : ( ^( DOT ID loc_ref ) | ^( DOT ID far_ref ) );", 20, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return ret;}
                        NoViableAltException nvae =
                            new NoViableAltException("123:1: far_ref returns [String ret] : ( ^( DOT ID loc_ref ) | ^( DOT ID far_ref ) );", 20, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return ret;}
                    NoViableAltException nvae =
                        new NoViableAltException("123:1: far_ref returns [String ret] : ( ^( DOT ID loc_ref ) | ^( DOT ID far_ref ) );", 20, 1, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return ret;}
                NoViableAltException nvae =
                    new NoViableAltException("123:1: far_ref returns [String ret] : ( ^( DOT ID loc_ref ) | ^( DOT ID far_ref ) );", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:124:4: ^( DOT ID loc_ref )
                    {
                    match(input,DOT,FOLLOW_DOT_in_far_ref671); if (failed) return ret;

                    match(input, Token.DOWN, null); if (failed) return ret;
                    ID24=(CommonTree)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_far_ref673); if (failed) return ret;
                    pushFollow(FOLLOW_loc_ref_in_far_ref675);
                    loc_ref25=loc_ref();
                    _fsp--;
                    if (failed) return ret;

                    match(input, Token.UP, null); if (failed) return ret;
                    if ( backtracking==0 ) {
                      ret = ID24.getText() + "-->>" + loc_ref25;
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:125:4: ^( DOT ID far_ref )
                    {
                    match(input,DOT,FOLLOW_DOT_in_far_ref685); if (failed) return ret;

                    match(input, Token.DOWN, null); if (failed) return ret;
                    ID26=(CommonTree)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_far_ref687); if (failed) return ret;
                    pushFollow(FOLLOW_far_ref_in_far_ref689);
                    far_ref();
                    _fsp--;
                    if (failed) return ret;

                    match(input, Token.UP, null); if (failed) return ret;
                    if ( backtracking==0 ) {
                      ret = ID26.getText() + ret;
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
        }
        return ret;
    }
    // $ANTLR end far_ref


    // $ANTLR start type
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:129:1: type : BOOL_T ;
    public final void type() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:129:7: ( BOOL_T )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSStmtWalker.g:129:9: BOOL_T
            {
            match(input,BOOL_T,FOLLOW_BOOL_T_in_type703); if (failed) return ;

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
    // $ANTLR end type


 

    public static final BitSet FOLLOW_PROG_T_in_program57 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_module_in_program59 = new BitSet(new long[]{0x0000000000000028L});
    public static final BitSet FOLLOW_MODULE_T_in_module70 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_module74 = new BitSet(new long[]{0x00000000000003C8L});
    public static final BitSet FOLLOW_section_in_module78 = new BitSet(new long[]{0x00000000000003C8L});
    public static final BitSet FOLLOW_var_sec_in_section90 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_init_sec_in_section94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_trans_sec_in_section98 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_just_sec_in_section102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_T_in_var_sec111 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_var_decl_in_var_sec113 = new BitSet(new long[]{0x0000000000000408L});
    public static final BitSet FOLLOW_INIT_T_in_init_sec123 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_init_decl_in_init_sec125 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_TRANS_T_in_trans_sec135 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_trans_decl_in_trans_sec137 = new BitSet(new long[]{0x0000000000001008L});
    public static final BitSet FOLLOW_JUST_T_in_just_sec147 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_just_decl_in_just_sec149 = new BitSet(new long[]{0x0000000000002008L});
    public static final BitSet FOLLOW_VAR_DECL_T_in_var_decl162 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_var_decl164 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_type_in_var_decl166 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_init_decl_expr_in_init_decl176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INIT_DECL_EXPR_T_in_init_decl_expr188 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_bool_expr_in_init_decl_expr190 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TRANS_DECL_T_in_trans_decl216 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_bool_expr_in_trans_decl218 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_JUST_DECL_T_in_just_decl244 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_bool_expr_in_just_decl246 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_binor_expr_in_bool_expr277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BINOR_in_binor_expr291 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_binor_expr_in_binor_expr295 = new BitSet(new long[]{0x0000003FE000C000L});
    public static final BitSet FOLLOW_binor_expr_in_binor_expr299 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_and_expr_in_binor_expr307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_and_expr321 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_and_expr_in_and_expr325 = new BitSet(new long[]{0x0000003F6000C000L});
    public static final BitSet FOLLOW_and_expr_in_and_expr329 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_implies_expr_in_and_expr337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPLIES_in_implies_expr351 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_implies_expr_in_implies_expr355 = new BitSet(new long[]{0x0000003E6000C000L});
    public static final BitSet FOLLOW_implies_expr_in_implies_expr359 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_biimp_expr_in_implies_expr367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIIMP_in_biimp_expr381 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_biimp_expr_in_biimp_expr385 = new BitSet(new long[]{0x0000003C6000C000L});
    public static final BitSet FOLLOW_biimp_expr_in_biimp_expr389 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_eq_expr_in_biimp_expr397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQ_in_eq_expr411 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_eq_expr_in_eq_expr415 = new BitSet(new long[]{0x000000386000C000L});
    public static final BitSet FOLLOW_eq_expr_in_eq_expr419 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_neq_expr_in_eq_expr427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEQ_in_neq_expr441 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_neq_expr_in_neq_expr445 = new BitSet(new long[]{0x000000306000C000L});
    public static final BitSet FOLLOW_neq_expr_in_neq_expr449 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_not_expr_in_neq_expr457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_not_expr471 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_not_expr_in_not_expr475 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_block_expr_in_not_expr483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_T_in_block_expr497 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_bool_expr_in_block_expr499 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_atom_expr_in_block_expr507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_any_ref_in_atom_expr520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_value_in_atom_expr527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_value542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_value549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unprime_ref_in_any_ref566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prime_ref_in_any_ref573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REF_T_in_prime_ref587 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PRIME_T_in_prime_ref590 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_native_ref_in_prime_ref592 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REF_T_in_unprime_ref608 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_native_ref_in_unprime_ref610 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_construct_name_in_native_ref624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_loc_ref_in_construct_name637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_far_ref_in_construct_name644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_loc_ref657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_far_ref671 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_far_ref673 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_loc_ref_in_far_ref675 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOT_in_far_ref685 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_far_ref687 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_far_ref_in_far_ref689 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BOOL_T_in_type703 = new BitSet(new long[]{0x0000000000000002L});

}