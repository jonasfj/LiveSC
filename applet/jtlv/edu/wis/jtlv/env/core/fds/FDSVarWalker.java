// $ANTLR 3.0.1 /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g 2008-05-28 15:40:41

package edu.wis.jtlv.env.core.fds;

import java.util.HashMap;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.TreeNodeStream;
import org.antlr.runtime.tree.TreeParser;

import edu.wis.jtlv.env.Env;
import edu.wis.jtlv.env.module.FDSModule;
import edu.wis.jtlv.env.module.ModuleException;
import edu.wis.jtlv.env.module.ModuleVariableException;
public class FDSVarWalker extends TreeParser {
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

        public FDSVarWalker(TreeNodeStream input) {
            super(input);
            ruleMemo = new HashMap[51+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "/home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g"; }


    public static String curr_module_name = "global";



    // $ANTLR start program
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:30:1: program : ^( PROG_T ( module )+ ) ;
    public final void program() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:30:9: ( ^( PROG_T ( module )+ ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:30:11: ^( PROG_T ( module )+ )
            {
            match(input,PROG_T,FOLLOW_PROG_T_in_program57); if (failed) return ;

            match(input, Token.DOWN, null); if (failed) return ;
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:30:20: ( module )+
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
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:0:0: module
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
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:32:1: module : ^( MODULE_T m_name= ID ( section )* ) ;
    public final void module() throws RecognitionException {
        CommonTree m_name=null;

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:32:8: ( ^( MODULE_T m_name= ID ( section )* ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:32:10: ^( MODULE_T m_name= ID ( section )* )
            {
            match(input,MODULE_T,FOLLOW_MODULE_T_in_module70); if (failed) return ;

            match(input, Token.DOWN, null); if (failed) return ;
            m_name=(CommonTree)input.LT(1);
            match(input,ID,FOLLOW_ID_in_module74); if (failed) return ;
            if ( backtracking==0 ) {
              curr_module_name = m_name.getText(); Env.putModule(curr_module_name, new FDSModule(m_name.getText()));
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:32:128: ( section )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=VAR_T && LA2_0<=JUST_T)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:0:0: section
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
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:35:1: section : ( var_sec | init_sec | trans_sec | just_sec ) ;
    public final void section() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:35:9: ( ( var_sec | init_sec | trans_sec | just_sec ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:35:11: ( var_sec | init_sec | trans_sec | just_sec )
            {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:35:11: ( var_sec | init_sec | trans_sec | just_sec )
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
                    new NoViableAltException("35:11: ( var_sec | init_sec | trans_sec | just_sec )", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:35:12: var_sec
                    {
                    pushFollow(FOLLOW_var_sec_in_section90);
                    var_sec();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:35:22: init_sec
                    {
                    pushFollow(FOLLOW_init_sec_in_section94);
                    init_sec();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:35:33: trans_sec
                    {
                    pushFollow(FOLLOW_trans_sec_in_section98);
                    trans_sec();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 4 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:35:45: just_sec
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
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:36:1: var_sec : ^( VAR_T ( var_decl )* ) ;
    public final void var_sec() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:36:9: ( ^( VAR_T ( var_decl )* ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:36:11: ^( VAR_T ( var_decl )* )
            {
            match(input,VAR_T,FOLLOW_VAR_T_in_var_sec111); if (failed) return ;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (failed) return ;
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:36:19: ( var_decl )*
                loop4:
                do {
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==VAR_DECL_T) ) {
                        alt4=1;
                    }


                    switch (alt4) {
                	case 1 :
                	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:0:0: var_decl
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
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:37:1: init_sec : ^( INIT_T ( init_decl )* ) ;
    public final void init_sec() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:37:10: ( ^( INIT_T ( init_decl )* ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:37:12: ^( INIT_T ( init_decl )* )
            {
            match(input,INIT_T,FOLLOW_INIT_T_in_init_sec123); if (failed) return ;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (failed) return ;
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:37:21: ( init_decl )*
                loop5:
                do {
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==INIT_DECL_EXPR_T) ) {
                        alt5=1;
                    }


                    switch (alt5) {
                	case 1 :
                	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:0:0: init_decl
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
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:38:1: trans_sec : ^( TRANS_T ( trans_decl )* ) ;
    public final void trans_sec() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:38:11: ( ^( TRANS_T ( trans_decl )* ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:38:13: ^( TRANS_T ( trans_decl )* )
            {
            match(input,TRANS_T,FOLLOW_TRANS_T_in_trans_sec135); if (failed) return ;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (failed) return ;
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:38:23: ( trans_decl )*
                loop6:
                do {
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==TRANS_DECL_T) ) {
                        alt6=1;
                    }


                    switch (alt6) {
                	case 1 :
                	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:0:0: trans_decl
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
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:39:1: just_sec : ^( JUST_T ( just_decl )* ) ;
    public final void just_sec() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:39:10: ( ^( JUST_T ( just_decl )* ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:39:12: ^( JUST_T ( just_decl )* )
            {
            match(input,JUST_T,FOLLOW_JUST_T_in_just_sec147); if (failed) return ;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (failed) return ;
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:39:21: ( just_decl )*
                loop7:
                do {
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==JUST_DECL_T) ) {
                        alt7=1;
                    }


                    switch (alt7) {
                	case 1 :
                	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:0:0: just_decl
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
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:43:1: var_decl : ^( VAR_DECL_T a_name= ID type ) ;
    public final void var_decl() throws RecognitionException {
        CommonTree a_name=null;

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:43:10: ( ^( VAR_DECL_T a_name= ID type ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:43:12: ^( VAR_DECL_T a_name= ID type )
            {
            match(input,VAR_DECL_T,FOLLOW_VAR_DECL_T_in_var_decl162); if (failed) return ;

            match(input, Token.DOWN, null); if (failed) return ;
            a_name=(CommonTree)input.LT(1);
            match(input,ID,FOLLOW_ID_in_var_decl166); if (failed) return ;
            pushFollow(FOLLOW_type_in_var_decl168);
            type();
            _fsp--;
            if (failed) return ;

            match(input, Token.UP, null); if (failed) return ;
            if ( backtracking==0 ) {
               try {
              		Env.getModule(curr_module_name).addVar(a_name.getText());
              	} catch (ModuleVariableException e) {
              		throw new FDSParseException(e.getMessage(), input);
              	} 
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
    // $ANTLR end var_decl


    // $ANTLR start init_decl
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:52:1: init_decl : init_decl_expr ;
    public final void init_decl() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:52:11: ( init_decl_expr )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:52:36: init_decl_expr
            {
            pushFollow(FOLLOW_init_decl_expr_in_init_decl197);
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
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:55:1: init_decl_expr : ^( INIT_DECL_EXPR_T bool_expr ) ;
    public final void init_decl_expr() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:55:16: ( ^( INIT_DECL_EXPR_T bool_expr ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:55:18: ^( INIT_DECL_EXPR_T bool_expr )
            {
            match(input,INIT_DECL_EXPR_T,FOLLOW_INIT_DECL_EXPR_T_in_init_decl_expr207); if (failed) return ;

            match(input, Token.DOWN, null); if (failed) return ;
            pushFollow(FOLLOW_bool_expr_in_init_decl_expr209);
            bool_expr();
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
    // $ANTLR end init_decl_expr


    // $ANTLR start trans_decl
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:56:1: trans_decl : ^( TRANS_DECL_T bool_expr ) ;
    public final void trans_decl() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:56:12: ( ^( TRANS_DECL_T bool_expr ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:56:14: ^( TRANS_DECL_T bool_expr )
            {
            match(input,TRANS_DECL_T,FOLLOW_TRANS_DECL_T_in_trans_decl218); if (failed) return ;

            match(input, Token.DOWN, null); if (failed) return ;
            pushFollow(FOLLOW_bool_expr_in_trans_decl220);
            bool_expr();
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
    // $ANTLR end trans_decl


    // $ANTLR start just_decl
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:57:1: just_decl : ^( JUST_DECL_T bool_expr ) ;
    public final void just_decl() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:57:11: ( ^( JUST_DECL_T bool_expr ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:57:13: ^( JUST_DECL_T bool_expr )
            {
            match(input,JUST_DECL_T,FOLLOW_JUST_DECL_T_in_just_decl229); if (failed) return ;

            match(input, Token.DOWN, null); if (failed) return ;
            pushFollow(FOLLOW_bool_expr_in_just_decl231);
            bool_expr();
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
    // $ANTLR end just_decl


    // $ANTLR start bool_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:60:1: bool_expr : binor_expr ;
    public final void bool_expr() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:60:11: ( binor_expr )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:60:13: binor_expr
            {
            pushFollow(FOLLOW_binor_expr_in_bool_expr241);
            binor_expr();
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
    // $ANTLR end bool_expr


    // $ANTLR start binor_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:61:1: binor_expr : ( ^( BINOR binor_expr binor_expr ) | and_expr );
    public final void binor_expr() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:61:12: ( ^( BINOR binor_expr binor_expr ) | and_expr )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==BINOR) ) {
                alt8=1;
            }
            else if ( ((LA8_0>=BLOCK_T && LA8_0<=REF_T)||(LA8_0>=TRUE && LA8_0<=FALSE)||(LA8_0>=AND && LA8_0<=NOT)) ) {
                alt8=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("61:1: binor_expr : ( ^( BINOR binor_expr binor_expr ) | and_expr );", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:61:14: ^( BINOR binor_expr binor_expr )
                    {
                    match(input,BINOR,FOLLOW_BINOR_in_binor_expr249); if (failed) return ;

                    match(input, Token.DOWN, null); if (failed) return ;
                    pushFollow(FOLLOW_binor_expr_in_binor_expr251);
                    binor_expr();
                    _fsp--;
                    if (failed) return ;
                    pushFollow(FOLLOW_binor_expr_in_binor_expr253);
                    binor_expr();
                    _fsp--;
                    if (failed) return ;

                    match(input, Token.UP, null); if (failed) return ;

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:61:47: and_expr
                    {
                    pushFollow(FOLLOW_and_expr_in_binor_expr258);
                    and_expr();
                    _fsp--;
                    if (failed) return ;

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
        return ;
    }
    // $ANTLR end binor_expr


    // $ANTLR start and_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:62:1: and_expr : ( ^( AND and_expr and_expr ) | implies_expr );
    public final void and_expr() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:62:10: ( ^( AND and_expr and_expr ) | implies_expr )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==AND) ) {
                alt9=1;
            }
            else if ( ((LA9_0>=BLOCK_T && LA9_0<=REF_T)||(LA9_0>=TRUE && LA9_0<=FALSE)||(LA9_0>=IMPLIES && LA9_0<=NOT)) ) {
                alt9=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("62:1: and_expr : ( ^( AND and_expr and_expr ) | implies_expr );", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:62:12: ^( AND and_expr and_expr )
                    {
                    match(input,AND,FOLLOW_AND_in_and_expr266); if (failed) return ;

                    match(input, Token.DOWN, null); if (failed) return ;
                    pushFollow(FOLLOW_and_expr_in_and_expr268);
                    and_expr();
                    _fsp--;
                    if (failed) return ;
                    pushFollow(FOLLOW_and_expr_in_and_expr270);
                    and_expr();
                    _fsp--;
                    if (failed) return ;

                    match(input, Token.UP, null); if (failed) return ;

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:62:39: implies_expr
                    {
                    pushFollow(FOLLOW_implies_expr_in_and_expr275);
                    implies_expr();
                    _fsp--;
                    if (failed) return ;

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
        return ;
    }
    // $ANTLR end and_expr


    // $ANTLR start implies_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:63:1: implies_expr : ( ^( IMPLIES implies_expr implies_expr ) | biimp_expr );
    public final void implies_expr() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:63:14: ( ^( IMPLIES implies_expr implies_expr ) | biimp_expr )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==IMPLIES) ) {
                alt10=1;
            }
            else if ( ((LA10_0>=BLOCK_T && LA10_0<=REF_T)||(LA10_0>=TRUE && LA10_0<=FALSE)||(LA10_0>=BIIMP && LA10_0<=NOT)) ) {
                alt10=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("63:1: implies_expr : ( ^( IMPLIES implies_expr implies_expr ) | biimp_expr );", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:63:16: ^( IMPLIES implies_expr implies_expr )
                    {
                    match(input,IMPLIES,FOLLOW_IMPLIES_in_implies_expr283); if (failed) return ;

                    match(input, Token.DOWN, null); if (failed) return ;
                    pushFollow(FOLLOW_implies_expr_in_implies_expr285);
                    implies_expr();
                    _fsp--;
                    if (failed) return ;
                    pushFollow(FOLLOW_implies_expr_in_implies_expr287);
                    implies_expr();
                    _fsp--;
                    if (failed) return ;

                    match(input, Token.UP, null); if (failed) return ;

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:63:55: biimp_expr
                    {
                    pushFollow(FOLLOW_biimp_expr_in_implies_expr292);
                    biimp_expr();
                    _fsp--;
                    if (failed) return ;

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
        return ;
    }
    // $ANTLR end implies_expr


    // $ANTLR start biimp_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:64:1: biimp_expr : ( ^( BIIMP biimp_expr biimp_expr ) | eq_expr );
    public final void biimp_expr() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:64:12: ( ^( BIIMP biimp_expr biimp_expr ) | eq_expr )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==BIIMP) ) {
                alt11=1;
            }
            else if ( ((LA11_0>=BLOCK_T && LA11_0<=REF_T)||(LA11_0>=TRUE && LA11_0<=FALSE)||(LA11_0>=EQ && LA11_0<=NOT)) ) {
                alt11=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("64:1: biimp_expr : ( ^( BIIMP biimp_expr biimp_expr ) | eq_expr );", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:64:14: ^( BIIMP biimp_expr biimp_expr )
                    {
                    match(input,BIIMP,FOLLOW_BIIMP_in_biimp_expr300); if (failed) return ;

                    match(input, Token.DOWN, null); if (failed) return ;
                    pushFollow(FOLLOW_biimp_expr_in_biimp_expr302);
                    biimp_expr();
                    _fsp--;
                    if (failed) return ;
                    pushFollow(FOLLOW_biimp_expr_in_biimp_expr304);
                    biimp_expr();
                    _fsp--;
                    if (failed) return ;

                    match(input, Token.UP, null); if (failed) return ;

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:64:47: eq_expr
                    {
                    pushFollow(FOLLOW_eq_expr_in_biimp_expr309);
                    eq_expr();
                    _fsp--;
                    if (failed) return ;

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
        return ;
    }
    // $ANTLR end biimp_expr


    // $ANTLR start eq_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:65:1: eq_expr : ( ^( EQ eq_expr eq_expr ) | neq_expr );
    public final void eq_expr() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:65:9: ( ^( EQ eq_expr eq_expr ) | neq_expr )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==EQ) ) {
                alt12=1;
            }
            else if ( ((LA12_0>=BLOCK_T && LA12_0<=REF_T)||(LA12_0>=TRUE && LA12_0<=FALSE)||(LA12_0>=NEQ && LA12_0<=NOT)) ) {
                alt12=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("65:1: eq_expr : ( ^( EQ eq_expr eq_expr ) | neq_expr );", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:65:11: ^( EQ eq_expr eq_expr )
                    {
                    match(input,EQ,FOLLOW_EQ_in_eq_expr317); if (failed) return ;

                    match(input, Token.DOWN, null); if (failed) return ;
                    pushFollow(FOLLOW_eq_expr_in_eq_expr319);
                    eq_expr();
                    _fsp--;
                    if (failed) return ;
                    pushFollow(FOLLOW_eq_expr_in_eq_expr321);
                    eq_expr();
                    _fsp--;
                    if (failed) return ;

                    match(input, Token.UP, null); if (failed) return ;

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:65:35: neq_expr
                    {
                    pushFollow(FOLLOW_neq_expr_in_eq_expr326);
                    neq_expr();
                    _fsp--;
                    if (failed) return ;

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
        return ;
    }
    // $ANTLR end eq_expr


    // $ANTLR start neq_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:66:1: neq_expr : ( ^( NEQ neq_expr neq_expr ) | not_expr );
    public final void neq_expr() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:66:10: ( ^( NEQ neq_expr neq_expr ) | not_expr )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==NEQ) ) {
                alt13=1;
            }
            else if ( ((LA13_0>=BLOCK_T && LA13_0<=REF_T)||(LA13_0>=TRUE && LA13_0<=FALSE)||LA13_0==NOT) ) {
                alt13=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("66:1: neq_expr : ( ^( NEQ neq_expr neq_expr ) | not_expr );", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:66:12: ^( NEQ neq_expr neq_expr )
                    {
                    match(input,NEQ,FOLLOW_NEQ_in_neq_expr334); if (failed) return ;

                    match(input, Token.DOWN, null); if (failed) return ;
                    pushFollow(FOLLOW_neq_expr_in_neq_expr336);
                    neq_expr();
                    _fsp--;
                    if (failed) return ;
                    pushFollow(FOLLOW_neq_expr_in_neq_expr338);
                    neq_expr();
                    _fsp--;
                    if (failed) return ;

                    match(input, Token.UP, null); if (failed) return ;

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:66:39: not_expr
                    {
                    pushFollow(FOLLOW_not_expr_in_neq_expr343);
                    not_expr();
                    _fsp--;
                    if (failed) return ;

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
        return ;
    }
    // $ANTLR end neq_expr


    // $ANTLR start not_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:67:1: not_expr : ( ^( NOT block_expr ) | block_expr );
    public final void not_expr() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:67:10: ( ^( NOT block_expr ) | block_expr )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==NOT) ) {
                alt14=1;
            }
            else if ( ((LA14_0>=BLOCK_T && LA14_0<=REF_T)||(LA14_0>=TRUE && LA14_0<=FALSE)) ) {
                alt14=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("67:1: not_expr : ( ^( NOT block_expr ) | block_expr );", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:67:12: ^( NOT block_expr )
                    {
                    match(input,NOT,FOLLOW_NOT_in_not_expr351); if (failed) return ;

                    match(input, Token.DOWN, null); if (failed) return ;
                    pushFollow(FOLLOW_block_expr_in_not_expr353);
                    block_expr();
                    _fsp--;
                    if (failed) return ;

                    match(input, Token.UP, null); if (failed) return ;

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:67:32: block_expr
                    {
                    pushFollow(FOLLOW_block_expr_in_not_expr358);
                    block_expr();
                    _fsp--;
                    if (failed) return ;

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
        return ;
    }
    // $ANTLR end not_expr


    // $ANTLR start block_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:68:1: block_expr : ( ^( BLOCK_T bool_expr ) | atom_expr );
    public final void block_expr() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:68:12: ( ^( BLOCK_T bool_expr ) | atom_expr )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==BLOCK_T) ) {
                alt15=1;
            }
            else if ( (LA15_0==REF_T||(LA15_0>=TRUE && LA15_0<=FALSE)) ) {
                alt15=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("68:1: block_expr : ( ^( BLOCK_T bool_expr ) | atom_expr );", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:68:14: ^( BLOCK_T bool_expr )
                    {
                    match(input,BLOCK_T,FOLLOW_BLOCK_T_in_block_expr366); if (failed) return ;

                    match(input, Token.DOWN, null); if (failed) return ;
                    pushFollow(FOLLOW_bool_expr_in_block_expr368);
                    bool_expr();
                    _fsp--;
                    if (failed) return ;

                    match(input, Token.UP, null); if (failed) return ;

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:68:37: atom_expr
                    {
                    pushFollow(FOLLOW_atom_expr_in_block_expr373);
                    atom_expr();
                    _fsp--;
                    if (failed) return ;

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
        return ;
    }
    // $ANTLR end block_expr


    // $ANTLR start atom_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:70:1: atom_expr : ( any_ref | value );
    public final void atom_expr() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:70:11: ( any_ref | value )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==REF_T) ) {
                alt16=1;
            }
            else if ( ((LA16_0>=TRUE && LA16_0<=FALSE)) ) {
                alt16=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("70:1: atom_expr : ( any_ref | value );", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:70:13: any_ref
                    {
                    pushFollow(FOLLOW_any_ref_in_atom_expr381);
                    any_ref();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:71:4: value
                    {
                    pushFollow(FOLLOW_value_in_atom_expr386);
                    value();
                    _fsp--;
                    if (failed) return ;

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
        return ;
    }
    // $ANTLR end atom_expr


    // $ANTLR start value
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:73:1: value : ( TRUE | FALSE );
    public final void value() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:73:7: ( TRUE | FALSE )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:
            {
            if ( (input.LA(1)>=TRUE && input.LA(1)<=FALSE) ) {
                input.consume();
                errorRecovery=false;failed=false;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_value0);    throw mse;
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
    // $ANTLR end value


    // $ANTLR start any_ref
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:76:1: any_ref : ( unprime_ref | prime_ref );
    public final void any_ref() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:76:9: ( unprime_ref | prime_ref )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==REF_T) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==DOWN) ) {
                    int LA17_2 = input.LA(3);

                    if ( (LA17_2==PRIME_T) ) {
                        alt17=2;
                    }
                    else if ( (LA17_2==ID||LA17_2==DOT) ) {
                        alt17=1;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("76:1: any_ref : ( unprime_ref | prime_ref );", 17, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("76:1: any_ref : ( unprime_ref | prime_ref );", 17, 1, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("76:1: any_ref : ( unprime_ref | prime_ref );", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:76:11: unprime_ref
                    {
                    pushFollow(FOLLOW_unprime_ref_in_any_ref408);
                    unprime_ref();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:76:25: prime_ref
                    {
                    pushFollow(FOLLOW_prime_ref_in_any_ref412);
                    prime_ref();
                    _fsp--;
                    if (failed) return ;

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
        return ;
    }
    // $ANTLR end any_ref


    // $ANTLR start prime_ref
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:77:1: prime_ref : ^( REF_T ^( PRIME_T native_ref ) ) ;
    public final void prime_ref() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:77:11: ( ^( REF_T ^( PRIME_T native_ref ) ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:77:13: ^( REF_T ^( PRIME_T native_ref ) )
            {
            match(input,REF_T,FOLLOW_REF_T_in_prime_ref420); if (failed) return ;

            match(input, Token.DOWN, null); if (failed) return ;
            match(input,PRIME_T,FOLLOW_PRIME_T_in_prime_ref423); if (failed) return ;

            match(input, Token.DOWN, null); if (failed) return ;
            pushFollow(FOLLOW_native_ref_in_prime_ref425);
            native_ref();
            _fsp--;
            if (failed) return ;

            match(input, Token.UP, null); if (failed) return ;

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
    // $ANTLR end prime_ref


    // $ANTLR start unprime_ref
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:78:1: unprime_ref : ^( REF_T native_ref ) ;
    public final void unprime_ref() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:78:13: ( ^( REF_T native_ref ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:78:15: ^( REF_T native_ref )
            {
            match(input,REF_T,FOLLOW_REF_T_in_unprime_ref435); if (failed) return ;

            match(input, Token.DOWN, null); if (failed) return ;
            pushFollow(FOLLOW_native_ref_in_unprime_ref437);
            native_ref();
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
    // $ANTLR end unprime_ref


    // $ANTLR start native_ref
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:79:1: native_ref : ( loc_ref | far_ref );
    public final void native_ref() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:79:12: ( loc_ref | far_ref )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==ID) ) {
                alt18=1;
            }
            else if ( (LA18_0==DOT) ) {
                alt18=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("79:1: native_ref : ( loc_ref | far_ref );", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:79:14: loc_ref
                    {
                    pushFollow(FOLLOW_loc_ref_in_native_ref445);
                    loc_ref();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:79:24: far_ref
                    {
                    pushFollow(FOLLOW_far_ref_in_native_ref449);
                    far_ref();
                    _fsp--;
                    if (failed) return ;

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
        return ;
    }
    // $ANTLR end native_ref


    // $ANTLR start loc_ref
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:80:1: loc_ref : ID ;
    public final void loc_ref() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:80:9: ( ID )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:80:11: ID
            {
            match(input,ID,FOLLOW_ID_in_loc_ref456); if (failed) return ;

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
    // $ANTLR end loc_ref


    // $ANTLR start far_ref
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:81:1: far_ref : ^( DOT ID native_ref ) ;
    public final void far_ref() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:81:9: ( ^( DOT ID native_ref ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:81:11: ^( DOT ID native_ref )
            {
            match(input,DOT,FOLLOW_DOT_in_far_ref464); if (failed) return ;

            match(input, Token.DOWN, null); if (failed) return ;
            match(input,ID,FOLLOW_ID_in_far_ref466); if (failed) return ;
            pushFollow(FOLLOW_native_ref_in_far_ref468);
            native_ref();
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
    // $ANTLR end far_ref


    // $ANTLR start type
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:84:1: type : BOOL_T ;
    public final void type() throws RecognitionException {
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:84:6: ( BOOL_T )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDSVarWalker.g:84:8: BOOL_T
            {
            match(input,BOOL_T,FOLLOW_BOOL_T_in_type478); if (failed) return ;

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
    public static final BitSet FOLLOW_ID_in_var_decl166 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_type_in_var_decl168 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_init_decl_expr_in_init_decl197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INIT_DECL_EXPR_T_in_init_decl_expr207 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_bool_expr_in_init_decl_expr209 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TRANS_DECL_T_in_trans_decl218 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_bool_expr_in_trans_decl220 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_JUST_DECL_T_in_just_decl229 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_bool_expr_in_just_decl231 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_binor_expr_in_bool_expr241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BINOR_in_binor_expr249 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_binor_expr_in_binor_expr251 = new BitSet(new long[]{0x0000003FE000C000L});
    public static final BitSet FOLLOW_binor_expr_in_binor_expr253 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_and_expr_in_binor_expr258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_and_expr266 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_and_expr_in_and_expr268 = new BitSet(new long[]{0x0000003F6000C000L});
    public static final BitSet FOLLOW_and_expr_in_and_expr270 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_implies_expr_in_and_expr275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPLIES_in_implies_expr283 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_implies_expr_in_implies_expr285 = new BitSet(new long[]{0x0000003E6000C000L});
    public static final BitSet FOLLOW_implies_expr_in_implies_expr287 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_biimp_expr_in_implies_expr292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIIMP_in_biimp_expr300 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_biimp_expr_in_biimp_expr302 = new BitSet(new long[]{0x0000003C6000C000L});
    public static final BitSet FOLLOW_biimp_expr_in_biimp_expr304 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_eq_expr_in_biimp_expr309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQ_in_eq_expr317 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_eq_expr_in_eq_expr319 = new BitSet(new long[]{0x000000386000C000L});
    public static final BitSet FOLLOW_eq_expr_in_eq_expr321 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_neq_expr_in_eq_expr326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEQ_in_neq_expr334 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_neq_expr_in_neq_expr336 = new BitSet(new long[]{0x000000306000C000L});
    public static final BitSet FOLLOW_neq_expr_in_neq_expr338 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_not_expr_in_neq_expr343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_not_expr351 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_expr_in_not_expr353 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_block_expr_in_not_expr358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_T_in_block_expr366 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_bool_expr_in_block_expr368 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_atom_expr_in_block_expr373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_any_ref_in_atom_expr381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_value_in_atom_expr386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_value0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unprime_ref_in_any_ref408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prime_ref_in_any_ref412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REF_T_in_prime_ref420 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PRIME_T_in_prime_ref423 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_native_ref_in_prime_ref425 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REF_T_in_unprime_ref435 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_native_ref_in_unprime_ref437 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_loc_ref_in_native_ref445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_far_ref_in_native_ref449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_loc_ref456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_far_ref464 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_far_ref466 = new BitSet(new long[]{0x0000040000080000L});
    public static final BitSet FOLLOW_native_ref_in_far_ref468 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BOOL_T_in_type478 = new BitSet(new long[]{0x0000000000000002L});

}