// $ANTLR 3.0.1 /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g 2008-05-27 17:39:55

package edu.wis.jtlv.env.core.fds;

//import java.util.HashMap;


import java.util.HashMap;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.RewriteEarlyExitException;
import org.antlr.runtime.tree.RewriteRuleSubtreeStream;
import org.antlr.runtime.tree.RewriteRuleTokenStream;
import org.antlr.runtime.tree.TreeAdaptor;

@SuppressWarnings("unused")
public class FDSParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PROG_T", "MODULE_T", "VAR_T", "INIT_T", "TRANS_T", "JUST_T", "VAR_DECL_T", "INIT_DECL_EXPR_T", "TRANS_DECL_T", "JUST_DECL_T", "BLOCK_T", "REF_T", "PRIME_T", "BOOL_T", "MODULE", "ID", "LEFT_CURLY", "RIGHT_CURLY", "VAR", "INIT", "TRANS", "JUST", "COLON", "SEMICOLON", "ASSIGN", "TRUE", "FALSE", "BINOR", "AND", "IMPLIES", "BIIMP", "EQ", "NEQ", "NOT", "LEFT_BRACES", "RIGHT_BRACES", "PRIME", "NEXT", "DOT", "BOOL_TYPE", "COMPASSION", "WS", "MULTI_COMMENT", "LINE_COMMENT"
    };
    public static final int PRIME=40;
    public static final int RIGHT_CURLY=21;
    public static final int BOOL_TYPE=43;
    public static final int MULTI_COMMENT=46;
    public static final int NOT=37;
    public static final int ID=19;
    public static final int AND=32;
    public static final int EOF=-1;
    public static final int TRANS_T=8;
    public static final int COMPASSION=44;
    public static final int PRIME_T=16;
    public static final int TRANS=24;
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

        public FDSParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[59+1];
         }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "/home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g"; }


    public static class program_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start program
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:51:1: program : ( module )+ EOF -> ^( PROG_T ( module )+ ) ;
    public final program_return program() throws RecognitionException {
        program_return retval = new program_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EOF2=null;
        module_return module1 = null;


        Object EOF2_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_module=new RewriteRuleSubtreeStream(adaptor,"rule module");
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:51:9: ( ( module )+ EOF -> ^( PROG_T ( module )+ ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:51:11: ( module )+ EOF
            {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:51:11: ( module )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==MODULE) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:51:12: module
            	    {
            	    pushFollow(FOLLOW_module_in_program133);
            	    module1=module();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_module.add(module1.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (backtracking>0) {failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            EOF2=(Token)input.LT(1);
            match(input,EOF,FOLLOW_EOF_in_program137); if (failed) return retval;
            if ( backtracking==0 ) stream_EOF.add(EOF2);


            // AST REWRITE
            // elements: module
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 52:2: -> ^( PROG_T ( module )+ )
            {
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:52:5: ^( PROG_T ( module )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(PROG_T, "PROG_T"), root_1);

                if ( !(stream_module.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_module.hasNext() ) {
                    adaptor.addChild(root_1, stream_module.next());

                }
                stream_module.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end program

    public static class module_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start module
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:54:1: module : MODULE ID LEFT_CURLY ( section )* RIGHT_CURLY -> ^( MODULE_T ID ( section )* ) ;
    public final module_return module() throws RecognitionException {
        module_return retval = new module_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token MODULE3=null;
        Token ID4=null;
        Token LEFT_CURLY5=null;
        Token RIGHT_CURLY7=null;
        section_return section6 = null;


        Object MODULE3_tree=null;
        Object ID4_tree=null;
        Object LEFT_CURLY5_tree=null;
        Object RIGHT_CURLY7_tree=null;
        RewriteRuleTokenStream stream_RIGHT_CURLY=new RewriteRuleTokenStream(adaptor,"token RIGHT_CURLY");
        RewriteRuleTokenStream stream_MODULE=new RewriteRuleTokenStream(adaptor,"token MODULE");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_LEFT_CURLY=new RewriteRuleTokenStream(adaptor,"token LEFT_CURLY");
        RewriteRuleSubtreeStream stream_section=new RewriteRuleSubtreeStream(adaptor,"rule section");
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:54:8: ( MODULE ID LEFT_CURLY ( section )* RIGHT_CURLY -> ^( MODULE_T ID ( section )* ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:54:10: MODULE ID LEFT_CURLY ( section )* RIGHT_CURLY
            {
            MODULE3=(Token)input.LT(1);
            match(input,MODULE,FOLLOW_MODULE_in_module155); if (failed) return retval;
            if ( backtracking==0 ) stream_MODULE.add(MODULE3);

            ID4=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_module157); if (failed) return retval;
            if ( backtracking==0 ) stream_ID.add(ID4);

            LEFT_CURLY5=(Token)input.LT(1);
            match(input,LEFT_CURLY,FOLLOW_LEFT_CURLY_in_module159); if (failed) return retval;
            if ( backtracking==0 ) stream_LEFT_CURLY.add(LEFT_CURLY5);

            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:54:31: ( section )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==ID||(LA2_0>=VAR && LA2_0<=JUST)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:54:32: section
            	    {
            	    pushFollow(FOLLOW_section_in_module162);
            	    section6=section();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_section.add(section6.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            RIGHT_CURLY7=(Token)input.LT(1);
            match(input,RIGHT_CURLY,FOLLOW_RIGHT_CURLY_in_module166); if (failed) return retval;
            if ( backtracking==0 ) stream_RIGHT_CURLY.add(RIGHT_CURLY7);


            // AST REWRITE
            // elements: ID, section
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 55:2: -> ^( MODULE_T ID ( section )* )
            {
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:55:5: ^( MODULE_T ID ( section )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(MODULE_T, "MODULE_T"), root_1);

                adaptor.addChild(root_1, stream_ID.next());
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:55:19: ( section )*
                while ( stream_section.hasNext() ) {
                    adaptor.addChild(root_1, stream_section.next());

                }
                stream_section.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end module

    public static class section_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start section
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:58:1: section : ( var_expl_sec | var_sec | init_sec | trans_sec | just_sec ) ;
    public final section_return section() throws RecognitionException {
        section_return retval = new section_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        var_expl_sec_return var_expl_sec8 = null;

        var_sec_return var_sec9 = null;

        init_sec_return init_sec10 = null;

        trans_sec_return trans_sec11 = null;

        just_sec_return just_sec12 = null;



        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:58:9: ( ( var_expl_sec | var_sec | init_sec | trans_sec | just_sec ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:58:11: ( var_expl_sec | var_sec | init_sec | trans_sec | just_sec )
            {
            root_0 = (Object)adaptor.nil();

            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:58:11: ( var_expl_sec | var_sec | init_sec | trans_sec | just_sec )
            int alt3=5;
            switch ( input.LA(1) ) {
            case VAR:
                {
                alt3=1;
                }
                break;
            case ID:
                {
                alt3=2;
                }
                break;
            case INIT:
                {
                alt3=3;
                }
                break;
            case TRANS:
                {
                alt3=4;
                }
                break;
            case JUST:
                {
                alt3=5;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("58:11: ( var_expl_sec | var_sec | init_sec | trans_sec | just_sec )", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:58:12: var_expl_sec
                    {
                    pushFollow(FOLLOW_var_expl_sec_in_section189);
                    var_expl_sec8=var_expl_sec();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, var_expl_sec8.getTree());

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:58:27: var_sec
                    {
                    pushFollow(FOLLOW_var_sec_in_section193);
                    var_sec9=var_sec();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, var_sec9.getTree());

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:58:37: init_sec
                    {
                    pushFollow(FOLLOW_init_sec_in_section197);
                    init_sec10=init_sec();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, init_sec10.getTree());

                    }
                    break;
                case 4 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:58:48: trans_sec
                    {
                    pushFollow(FOLLOW_trans_sec_in_section201);
                    trans_sec11=trans_sec();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, trans_sec11.getTree());

                    }
                    break;
                case 5 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:58:60: just_sec
                    {
                    pushFollow(FOLLOW_just_sec_in_section205);
                    just_sec12=just_sec();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, just_sec12.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end section

    public static class var_sec_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start var_sec
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:59:1: var_sec : ( var_decl )+ -> ^( VAR_T ( var_decl )* ) ;
    public final var_sec_return var_sec() throws RecognitionException {
        var_sec_return retval = new var_sec_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        var_decl_return var_decl13 = null;


        RewriteRuleSubtreeStream stream_var_decl=new RewriteRuleSubtreeStream(adaptor,"rule var_decl");
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:59:9: ( ( var_decl )+ -> ^( VAR_T ( var_decl )* ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:59:11: ( var_decl )+
            {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:59:11: ( var_decl )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==ID) ) {
                    int LA4_2 = input.LA(2);

                    if ( (synpred7()) ) {
                        alt4=1;
                    }


                }


                switch (alt4) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:59:12: var_decl
            	    {
            	    pushFollow(FOLLOW_var_decl_in_var_sec214);
            	    var_decl13=var_decl();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_var_decl.add(var_decl13.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
            	    if (backtracking>0) {failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            // AST REWRITE
            // elements: var_decl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 60:2: -> ^( VAR_T ( var_decl )* )
            {
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:60:5: ^( VAR_T ( var_decl )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(VAR_T, "VAR_T"), root_1);

                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:60:13: ( var_decl )*
                while ( stream_var_decl.hasNext() ) {
                    adaptor.addChild(root_1, stream_var_decl.next());

                }
                stream_var_decl.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end var_sec

    public static class var_expl_sec_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start var_expl_sec
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:61:1: var_expl_sec : VAR LEFT_CURLY ( var_decl )* RIGHT_CURLY -> ^( VAR_T ( var_decl )* ) ;
    public final var_expl_sec_return var_expl_sec() throws RecognitionException {
        var_expl_sec_return retval = new var_expl_sec_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token VAR14=null;
        Token LEFT_CURLY15=null;
        Token RIGHT_CURLY17=null;
        var_decl_return var_decl16 = null;


        Object VAR14_tree=null;
        Object LEFT_CURLY15_tree=null;
        Object RIGHT_CURLY17_tree=null;
        RewriteRuleTokenStream stream_VAR=new RewriteRuleTokenStream(adaptor,"token VAR");
        RewriteRuleTokenStream stream_RIGHT_CURLY=new RewriteRuleTokenStream(adaptor,"token RIGHT_CURLY");
        RewriteRuleTokenStream stream_LEFT_CURLY=new RewriteRuleTokenStream(adaptor,"token LEFT_CURLY");
        RewriteRuleSubtreeStream stream_var_decl=new RewriteRuleSubtreeStream(adaptor,"rule var_decl");
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:61:14: ( VAR LEFT_CURLY ( var_decl )* RIGHT_CURLY -> ^( VAR_T ( var_decl )* ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:61:16: VAR LEFT_CURLY ( var_decl )* RIGHT_CURLY
            {
            VAR14=(Token)input.LT(1);
            match(input,VAR,FOLLOW_VAR_in_var_expl_sec233); if (failed) return retval;
            if ( backtracking==0 ) stream_VAR.add(VAR14);

            LEFT_CURLY15=(Token)input.LT(1);
            match(input,LEFT_CURLY,FOLLOW_LEFT_CURLY_in_var_expl_sec235); if (failed) return retval;
            if ( backtracking==0 ) stream_LEFT_CURLY.add(LEFT_CURLY15);

            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:61:31: ( var_decl )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:61:32: var_decl
            	    {
            	    pushFollow(FOLLOW_var_decl_in_var_expl_sec238);
            	    var_decl16=var_decl();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_var_decl.add(var_decl16.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            RIGHT_CURLY17=(Token)input.LT(1);
            match(input,RIGHT_CURLY,FOLLOW_RIGHT_CURLY_in_var_expl_sec242); if (failed) return retval;
            if ( backtracking==0 ) stream_RIGHT_CURLY.add(RIGHT_CURLY17);


            // AST REWRITE
            // elements: var_decl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 62:2: -> ^( VAR_T ( var_decl )* )
            {
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:62:5: ^( VAR_T ( var_decl )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(VAR_T, "VAR_T"), root_1);

                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:62:13: ( var_decl )*
                while ( stream_var_decl.hasNext() ) {
                    adaptor.addChild(root_1, stream_var_decl.next());

                }
                stream_var_decl.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end var_expl_sec

    public static class init_sec_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start init_sec
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:63:1: init_sec : INIT LEFT_CURLY ( init_decl )* RIGHT_CURLY -> ^( INIT_T ( init_decl )* ) ;
    public final init_sec_return init_sec() throws RecognitionException {
        init_sec_return retval = new init_sec_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token INIT18=null;
        Token LEFT_CURLY19=null;
        Token RIGHT_CURLY21=null;
        init_decl_return init_decl20 = null;


        Object INIT18_tree=null;
        Object LEFT_CURLY19_tree=null;
        Object RIGHT_CURLY21_tree=null;
        RewriteRuleTokenStream stream_RIGHT_CURLY=new RewriteRuleTokenStream(adaptor,"token RIGHT_CURLY");
        RewriteRuleTokenStream stream_INIT=new RewriteRuleTokenStream(adaptor,"token INIT");
        RewriteRuleTokenStream stream_LEFT_CURLY=new RewriteRuleTokenStream(adaptor,"token LEFT_CURLY");
        RewriteRuleSubtreeStream stream_init_decl=new RewriteRuleSubtreeStream(adaptor,"rule init_decl");
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:63:10: ( INIT LEFT_CURLY ( init_decl )* RIGHT_CURLY -> ^( INIT_T ( init_decl )* ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:63:12: INIT LEFT_CURLY ( init_decl )* RIGHT_CURLY
            {
            INIT18=(Token)input.LT(1);
            match(input,INIT,FOLLOW_INIT_in_init_sec259); if (failed) return retval;
            if ( backtracking==0 ) stream_INIT.add(INIT18);

            LEFT_CURLY19=(Token)input.LT(1);
            match(input,LEFT_CURLY,FOLLOW_LEFT_CURLY_in_init_sec261); if (failed) return retval;
            if ( backtracking==0 ) stream_LEFT_CURLY.add(LEFT_CURLY19);

            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:63:28: ( init_decl )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==ID||(LA6_0>=TRUE && LA6_0<=FALSE)||(LA6_0>=NOT && LA6_0<=LEFT_BRACES)||LA6_0==NEXT) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:0:0: init_decl
            	    {
            	    pushFollow(FOLLOW_init_decl_in_init_sec263);
            	    init_decl20=init_decl();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_init_decl.add(init_decl20.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            RIGHT_CURLY21=(Token)input.LT(1);
            match(input,RIGHT_CURLY,FOLLOW_RIGHT_CURLY_in_init_sec266); if (failed) return retval;
            if ( backtracking==0 ) stream_RIGHT_CURLY.add(RIGHT_CURLY21);


            // AST REWRITE
            // elements: init_decl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 64:2: -> ^( INIT_T ( init_decl )* )
            {
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:64:5: ^( INIT_T ( init_decl )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(INIT_T, "INIT_T"), root_1);

                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:64:14: ( init_decl )*
                while ( stream_init_decl.hasNext() ) {
                    adaptor.addChild(root_1, stream_init_decl.next());

                }
                stream_init_decl.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end init_sec

    public static class trans_sec_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start trans_sec
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:65:1: trans_sec : TRANS LEFT_CURLY ( trans_decl )* RIGHT_CURLY -> ^( TRANS_T ( trans_decl )* ) ;
    public final trans_sec_return trans_sec() throws RecognitionException {
        trans_sec_return retval = new trans_sec_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TRANS22=null;
        Token LEFT_CURLY23=null;
        Token RIGHT_CURLY25=null;
        trans_decl_return trans_decl24 = null;


        Object TRANS22_tree=null;
        Object LEFT_CURLY23_tree=null;
        Object RIGHT_CURLY25_tree=null;
        RewriteRuleTokenStream stream_RIGHT_CURLY=new RewriteRuleTokenStream(adaptor,"token RIGHT_CURLY");
        RewriteRuleTokenStream stream_LEFT_CURLY=new RewriteRuleTokenStream(adaptor,"token LEFT_CURLY");
        RewriteRuleTokenStream stream_TRANS=new RewriteRuleTokenStream(adaptor,"token TRANS");
        RewriteRuleSubtreeStream stream_trans_decl=new RewriteRuleSubtreeStream(adaptor,"rule trans_decl");
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:65:11: ( TRANS LEFT_CURLY ( trans_decl )* RIGHT_CURLY -> ^( TRANS_T ( trans_decl )* ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:65:13: TRANS LEFT_CURLY ( trans_decl )* RIGHT_CURLY
            {
            TRANS22=(Token)input.LT(1);
            match(input,TRANS,FOLLOW_TRANS_in_trans_sec283); if (failed) return retval;
            if ( backtracking==0 ) stream_TRANS.add(TRANS22);

            LEFT_CURLY23=(Token)input.LT(1);
            match(input,LEFT_CURLY,FOLLOW_LEFT_CURLY_in_trans_sec285); if (failed) return retval;
            if ( backtracking==0 ) stream_LEFT_CURLY.add(LEFT_CURLY23);

            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:65:30: ( trans_decl )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==ID||(LA7_0>=TRUE && LA7_0<=FALSE)||(LA7_0>=NOT && LA7_0<=LEFT_BRACES)||LA7_0==NEXT) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:65:31: trans_decl
            	    {
            	    pushFollow(FOLLOW_trans_decl_in_trans_sec288);
            	    trans_decl24=trans_decl();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_trans_decl.add(trans_decl24.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            RIGHT_CURLY25=(Token)input.LT(1);
            match(input,RIGHT_CURLY,FOLLOW_RIGHT_CURLY_in_trans_sec292); if (failed) return retval;
            if ( backtracking==0 ) stream_RIGHT_CURLY.add(RIGHT_CURLY25);


            // AST REWRITE
            // elements: trans_decl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 66:2: -> ^( TRANS_T ( trans_decl )* )
            {
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:66:5: ^( TRANS_T ( trans_decl )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(TRANS_T, "TRANS_T"), root_1);

                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:66:15: ( trans_decl )*
                while ( stream_trans_decl.hasNext() ) {
                    adaptor.addChild(root_1, stream_trans_decl.next());

                }
                stream_trans_decl.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end trans_sec

    public static class just_sec_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start just_sec
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:67:1: just_sec : JUST LEFT_CURLY ( just_decl )* RIGHT_CURLY -> ^( JUST_T ( just_decl )* ) ;
    public final just_sec_return just_sec() throws RecognitionException {
        just_sec_return retval = new just_sec_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token JUST26=null;
        Token LEFT_CURLY27=null;
        Token RIGHT_CURLY29=null;
        just_decl_return just_decl28 = null;


        Object JUST26_tree=null;
        Object LEFT_CURLY27_tree=null;
        Object RIGHT_CURLY29_tree=null;
        RewriteRuleTokenStream stream_JUST=new RewriteRuleTokenStream(adaptor,"token JUST");
        RewriteRuleTokenStream stream_RIGHT_CURLY=new RewriteRuleTokenStream(adaptor,"token RIGHT_CURLY");
        RewriteRuleTokenStream stream_LEFT_CURLY=new RewriteRuleTokenStream(adaptor,"token LEFT_CURLY");
        RewriteRuleSubtreeStream stream_just_decl=new RewriteRuleSubtreeStream(adaptor,"rule just_decl");
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:67:10: ( JUST LEFT_CURLY ( just_decl )* RIGHT_CURLY -> ^( JUST_T ( just_decl )* ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:67:12: JUST LEFT_CURLY ( just_decl )* RIGHT_CURLY
            {
            JUST26=(Token)input.LT(1);
            match(input,JUST,FOLLOW_JUST_in_just_sec309); if (failed) return retval;
            if ( backtracking==0 ) stream_JUST.add(JUST26);

            LEFT_CURLY27=(Token)input.LT(1);
            match(input,LEFT_CURLY,FOLLOW_LEFT_CURLY_in_just_sec311); if (failed) return retval;
            if ( backtracking==0 ) stream_LEFT_CURLY.add(LEFT_CURLY27);

            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:67:28: ( just_decl )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==ID||(LA8_0>=TRUE && LA8_0<=FALSE)||(LA8_0>=NOT && LA8_0<=LEFT_BRACES)||LA8_0==NEXT) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:67:29: just_decl
            	    {
            	    pushFollow(FOLLOW_just_decl_in_just_sec314);
            	    just_decl28=just_decl();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_just_decl.add(just_decl28.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            RIGHT_CURLY29=(Token)input.LT(1);
            match(input,RIGHT_CURLY,FOLLOW_RIGHT_CURLY_in_just_sec318); if (failed) return retval;
            if ( backtracking==0 ) stream_RIGHT_CURLY.add(RIGHT_CURLY29);


            // AST REWRITE
            // elements: just_decl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 68:2: -> ^( JUST_T ( just_decl )* )
            {
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:68:5: ^( JUST_T ( just_decl )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(JUST_T, "JUST_T"), root_1);

                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:68:14: ( just_decl )*
                while ( stream_just_decl.hasNext() ) {
                    adaptor.addChild(root_1, stream_just_decl.next());

                }
                stream_just_decl.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end just_sec

    public static class var_decl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start var_decl
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:71:1: var_decl : ID COLON type SEMICOLON -> ^( VAR_DECL_T ID type ) ;
    public final var_decl_return var_decl() throws RecognitionException {
        var_decl_return retval = new var_decl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID30=null;
        Token COLON31=null;
        Token SEMICOLON33=null;
        type_return type32 = null;


        Object ID30_tree=null;
        Object COLON31_tree=null;
        Object SEMICOLON33_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:71:10: ( ID COLON type SEMICOLON -> ^( VAR_DECL_T ID type ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:71:12: ID COLON type SEMICOLON
            {
            ID30=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_var_decl337); if (failed) return retval;
            if ( backtracking==0 ) stream_ID.add(ID30);

            COLON31=(Token)input.LT(1);
            match(input,COLON,FOLLOW_COLON_in_var_decl339); if (failed) return retval;
            if ( backtracking==0 ) stream_COLON.add(COLON31);

            pushFollow(FOLLOW_type_in_var_decl341);
            type32=type();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_type.add(type32.getTree());
            SEMICOLON33=(Token)input.LT(1);
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_var_decl343); if (failed) return retval;
            if ( backtracking==0 ) stream_SEMICOLON.add(SEMICOLON33);


            // AST REWRITE
            // elements: type, ID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 72:2: -> ^( VAR_DECL_T ID type )
            {
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:72:5: ^( VAR_DECL_T ID type )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(VAR_DECL_T, "VAR_DECL_T"), root_1);

                adaptor.addChild(root_1, stream_ID.next());
                adaptor.addChild(root_1, stream_type.next());

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end var_decl

    public static class init_decl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start init_decl
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:73:1: init_decl : ( init_decl_assi | init_decl_expr );
    public final init_decl_return init_decl() throws RecognitionException {
        init_decl_return retval = new init_decl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        init_decl_assi_return init_decl_assi34 = null;

        init_decl_expr_return init_decl_expr35 = null;



        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:73:11: ( init_decl_assi | init_decl_expr )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==ID) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==ASSIGN) ) {
                    alt9=1;
                }
                else if ( (LA9_1==SEMICOLON||(LA9_1>=BINOR && LA9_1<=NEQ)||LA9_1==PRIME||LA9_1==DOT) ) {
                    alt9=2;
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("73:1: init_decl : ( init_decl_assi | init_decl_expr );", 9, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA9_0>=TRUE && LA9_0<=FALSE)||(LA9_0>=NOT && LA9_0<=LEFT_BRACES)||LA9_0==NEXT) ) {
                alt9=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("73:1: init_decl : ( init_decl_assi | init_decl_expr );", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:73:13: init_decl_assi
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_init_decl_assi_in_init_decl361);
                    init_decl_assi34=init_decl_assi();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, init_decl_assi34.getTree());

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:73:30: init_decl_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_init_decl_expr_in_init_decl365);
                    init_decl_expr35=init_decl_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, init_decl_expr35.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end init_decl

    public static class init_decl_assi_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start init_decl_assi
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:77:1: init_decl_assi : ( init_decl_t | init_decl_f );
    public final init_decl_assi_return init_decl_assi() throws RecognitionException {
        init_decl_assi_return retval = new init_decl_assi_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        init_decl_t_return init_decl_t36 = null;

        init_decl_f_return init_decl_f37 = null;



        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:77:16: ( init_decl_t | init_decl_f )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==ID) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==ASSIGN) ) {
                    int LA10_2 = input.LA(3);

                    if ( (LA10_2==TRUE) ) {
                        alt10=1;
                    }
                    else if ( (LA10_2==FALSE) ) {
                        alt10=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("77:1: init_decl_assi : ( init_decl_t | init_decl_f );", 10, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("77:1: init_decl_assi : ( init_decl_t | init_decl_f );", 10, 1, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("77:1: init_decl_assi : ( init_decl_t | init_decl_f );", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:77:18: init_decl_t
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_init_decl_t_in_init_decl_assi375);
                    init_decl_t36=init_decl_t();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, init_decl_t36.getTree());

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:77:32: init_decl_f
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_init_decl_f_in_init_decl_assi379);
                    init_decl_f37=init_decl_f();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, init_decl_f37.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end init_decl_assi

    public static class init_decl_t_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start init_decl_t
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:78:1: init_decl_t : ID ASSIGN TRUE SEMICOLON -> ^( INIT_DECL_EXPR_T ^( REF_T ID ) ) ;
    public final init_decl_t_return init_decl_t() throws RecognitionException {
        init_decl_t_return retval = new init_decl_t_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID38=null;
        Token ASSIGN39=null;
        Token TRUE40=null;
        Token SEMICOLON41=null;

        Object ID38_tree=null;
        Object ASSIGN39_tree=null;
        Object TRUE40_tree=null;
        Object SEMICOLON41_tree=null;
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_TRUE=new RewriteRuleTokenStream(adaptor,"token TRUE");
        RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:78:13: ( ID ASSIGN TRUE SEMICOLON -> ^( INIT_DECL_EXPR_T ^( REF_T ID ) ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:78:15: ID ASSIGN TRUE SEMICOLON
            {
            ID38=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_init_decl_t386); if (failed) return retval;
            if ( backtracking==0 ) stream_ID.add(ID38);

            ASSIGN39=(Token)input.LT(1);
            match(input,ASSIGN,FOLLOW_ASSIGN_in_init_decl_t388); if (failed) return retval;
            if ( backtracking==0 ) stream_ASSIGN.add(ASSIGN39);

            TRUE40=(Token)input.LT(1);
            match(input,TRUE,FOLLOW_TRUE_in_init_decl_t390); if (failed) return retval;
            if ( backtracking==0 ) stream_TRUE.add(TRUE40);

            SEMICOLON41=(Token)input.LT(1);
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_init_decl_t392); if (failed) return retval;
            if ( backtracking==0 ) stream_SEMICOLON.add(SEMICOLON41);


            // AST REWRITE
            // elements: ID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 79:2: -> ^( INIT_DECL_EXPR_T ^( REF_T ID ) )
            {
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:79:5: ^( INIT_DECL_EXPR_T ^( REF_T ID ) )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(INIT_DECL_EXPR_T, "INIT_DECL_EXPR_T"), root_1);

                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:79:24: ^( REF_T ID )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(adaptor.create(REF_T, "REF_T"), root_2);

                adaptor.addChild(root_2, stream_ID.next());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end init_decl_t

    public static class init_decl_f_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start init_decl_f
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:80:1: init_decl_f : ID ASSIGN FALSE SEMICOLON -> ^( INIT_DECL_EXPR_T ^( NOT ^( REF_T ID ) ) ) ;
    public final init_decl_f_return init_decl_f() throws RecognitionException {
        init_decl_f_return retval = new init_decl_f_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID42=null;
        Token ASSIGN43=null;
        Token FALSE44=null;
        Token SEMICOLON45=null;

        Object ID42_tree=null;
        Object ASSIGN43_tree=null;
        Object FALSE44_tree=null;
        Object SEMICOLON45_tree=null;
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_FALSE=new RewriteRuleTokenStream(adaptor,"token FALSE");
        RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:80:13: ( ID ASSIGN FALSE SEMICOLON -> ^( INIT_DECL_EXPR_T ^( NOT ^( REF_T ID ) ) ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:80:15: ID ASSIGN FALSE SEMICOLON
            {
            ID42=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_init_decl_f412); if (failed) return retval;
            if ( backtracking==0 ) stream_ID.add(ID42);

            ASSIGN43=(Token)input.LT(1);
            match(input,ASSIGN,FOLLOW_ASSIGN_in_init_decl_f414); if (failed) return retval;
            if ( backtracking==0 ) stream_ASSIGN.add(ASSIGN43);

            FALSE44=(Token)input.LT(1);
            match(input,FALSE,FOLLOW_FALSE_in_init_decl_f416); if (failed) return retval;
            if ( backtracking==0 ) stream_FALSE.add(FALSE44);

            SEMICOLON45=(Token)input.LT(1);
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_init_decl_f418); if (failed) return retval;
            if ( backtracking==0 ) stream_SEMICOLON.add(SEMICOLON45);


            // AST REWRITE
            // elements: ID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 81:2: -> ^( INIT_DECL_EXPR_T ^( NOT ^( REF_T ID ) ) )
            {
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:81:5: ^( INIT_DECL_EXPR_T ^( NOT ^( REF_T ID ) ) )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(INIT_DECL_EXPR_T, "INIT_DECL_EXPR_T"), root_1);

                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:81:24: ^( NOT ^( REF_T ID ) )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(adaptor.create(NOT, "NOT"), root_2);

                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:81:30: ^( REF_T ID )
                {
                Object root_3 = (Object)adaptor.nil();
                root_3 = (Object)adaptor.becomeRoot(adaptor.create(REF_T, "REF_T"), root_3);

                adaptor.addChild(root_3, stream_ID.next());

                adaptor.addChild(root_2, root_3);
                }

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end init_decl_f

    public static class init_decl_expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start init_decl_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:82:1: init_decl_expr : bool_expr SEMICOLON -> ^( INIT_DECL_EXPR_T bool_expr ) ;
    public final init_decl_expr_return init_decl_expr() throws RecognitionException {
        init_decl_expr_return retval = new init_decl_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SEMICOLON47=null;
        bool_expr_return bool_expr46 = null;


        Object SEMICOLON47_tree=null;
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleSubtreeStream stream_bool_expr=new RewriteRuleSubtreeStream(adaptor,"rule bool_expr");
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:82:16: ( bool_expr SEMICOLON -> ^( INIT_DECL_EXPR_T bool_expr ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:82:18: bool_expr SEMICOLON
            {
            pushFollow(FOLLOW_bool_expr_in_init_decl_expr442);
            bool_expr46=bool_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_bool_expr.add(bool_expr46.getTree());
            SEMICOLON47=(Token)input.LT(1);
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_init_decl_expr444); if (failed) return retval;
            if ( backtracking==0 ) stream_SEMICOLON.add(SEMICOLON47);


            // AST REWRITE
            // elements: bool_expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 83:2: -> ^( INIT_DECL_EXPR_T bool_expr )
            {
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:83:5: ^( INIT_DECL_EXPR_T bool_expr )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(INIT_DECL_EXPR_T, "INIT_DECL_EXPR_T"), root_1);

                adaptor.addChild(root_1, stream_bool_expr.next());

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end init_decl_expr

    public static class trans_decl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start trans_decl
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:84:1: trans_decl : bool_expr SEMICOLON -> ^( TRANS_DECL_T bool_expr ) ;
    public final trans_decl_return trans_decl() throws RecognitionException {
        trans_decl_return retval = new trans_decl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SEMICOLON49=null;
        bool_expr_return bool_expr48 = null;


        Object SEMICOLON49_tree=null;
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleSubtreeStream stream_bool_expr=new RewriteRuleSubtreeStream(adaptor,"rule bool_expr");
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:84:12: ( bool_expr SEMICOLON -> ^( TRANS_DECL_T bool_expr ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:84:14: bool_expr SEMICOLON
            {
            pushFollow(FOLLOW_bool_expr_in_trans_decl460);
            bool_expr48=bool_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_bool_expr.add(bool_expr48.getTree());
            SEMICOLON49=(Token)input.LT(1);
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_trans_decl462); if (failed) return retval;
            if ( backtracking==0 ) stream_SEMICOLON.add(SEMICOLON49);


            // AST REWRITE
            // elements: bool_expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 85:3: -> ^( TRANS_DECL_T bool_expr )
            {
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:85:6: ^( TRANS_DECL_T bool_expr )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(TRANS_DECL_T, "TRANS_DECL_T"), root_1);

                adaptor.addChild(root_1, stream_bool_expr.next());

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end trans_decl

    public static class just_decl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start just_decl
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:86:1: just_decl : bool_expr SEMICOLON -> ^( JUST_DECL_T bool_expr ) ;
    public final just_decl_return just_decl() throws RecognitionException {
        just_decl_return retval = new just_decl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SEMICOLON51=null;
        bool_expr_return bool_expr50 = null;


        Object SEMICOLON51_tree=null;
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleSubtreeStream stream_bool_expr=new RewriteRuleSubtreeStream(adaptor,"rule bool_expr");
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:86:11: ( bool_expr SEMICOLON -> ^( JUST_DECL_T bool_expr ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:86:13: bool_expr SEMICOLON
            {
            pushFollow(FOLLOW_bool_expr_in_just_decl479);
            bool_expr50=bool_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_bool_expr.add(bool_expr50.getTree());
            SEMICOLON51=(Token)input.LT(1);
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_just_decl481); if (failed) return retval;
            if ( backtracking==0 ) stream_SEMICOLON.add(SEMICOLON51);


            // AST REWRITE
            // elements: bool_expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 87:3: -> ^( JUST_DECL_T bool_expr )
            {
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:87:6: ^( JUST_DECL_T bool_expr )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(JUST_DECL_T, "JUST_DECL_T"), root_1);

                adaptor.addChild(root_1, stream_bool_expr.next());

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end just_decl

    public static class bool_expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start bool_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:90:1: bool_expr : binor_expr ;
    public final bool_expr_return bool_expr() throws RecognitionException {
        bool_expr_return retval = new bool_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        binor_expr_return binor_expr52 = null;



        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:90:11: ( binor_expr )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:90:13: binor_expr
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_binor_expr_in_bool_expr500);
            binor_expr52=binor_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, binor_expr52.getTree());

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end bool_expr

    public static class binor_expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start binor_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:91:1: binor_expr : and_expr ( BINOR and_expr )* ;
    public final binor_expr_return binor_expr() throws RecognitionException {
        binor_expr_return retval = new binor_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token BINOR54=null;
        and_expr_return and_expr53 = null;

        and_expr_return and_expr55 = null;


        Object BINOR54_tree=null;

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:91:12: ( and_expr ( BINOR and_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:91:14: and_expr ( BINOR and_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_and_expr_in_binor_expr508);
            and_expr53=and_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, and_expr53.getTree());
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:91:23: ( BINOR and_expr )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==BINOR) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:91:24: BINOR and_expr
            	    {
            	    BINOR54=(Token)input.LT(1);
            	    match(input,BINOR,FOLLOW_BINOR_in_binor_expr511); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    BINOR54_tree = (Object)adaptor.create(BINOR54);
            	    root_0 = (Object)adaptor.becomeRoot(BINOR54_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_and_expr_in_binor_expr514);
            	    and_expr55=and_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, and_expr55.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end binor_expr

    public static class and_expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start and_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:92:1: and_expr : implies_expr ( AND implies_expr )* ;
    public final and_expr_return and_expr() throws RecognitionException {
        and_expr_return retval = new and_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token AND57=null;
        implies_expr_return implies_expr56 = null;

        implies_expr_return implies_expr58 = null;


        Object AND57_tree=null;

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:92:10: ( implies_expr ( AND implies_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:92:12: implies_expr ( AND implies_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_implies_expr_in_and_expr523);
            implies_expr56=implies_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, implies_expr56.getTree());
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:92:25: ( AND implies_expr )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==AND) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:92:26: AND implies_expr
            	    {
            	    AND57=(Token)input.LT(1);
            	    match(input,AND,FOLLOW_AND_in_and_expr526); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    AND57_tree = (Object)adaptor.create(AND57);
            	    root_0 = (Object)adaptor.becomeRoot(AND57_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_implies_expr_in_and_expr529);
            	    implies_expr58=implies_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, implies_expr58.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end and_expr

    public static class implies_expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start implies_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:93:1: implies_expr : biimp_expr ( IMPLIES biimp_expr )* ;
    public final implies_expr_return implies_expr() throws RecognitionException {
        implies_expr_return retval = new implies_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IMPLIES60=null;
        biimp_expr_return biimp_expr59 = null;

        biimp_expr_return biimp_expr61 = null;


        Object IMPLIES60_tree=null;

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:93:14: ( biimp_expr ( IMPLIES biimp_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:93:16: biimp_expr ( IMPLIES biimp_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_biimp_expr_in_implies_expr538);
            biimp_expr59=biimp_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, biimp_expr59.getTree());
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:93:27: ( IMPLIES biimp_expr )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==IMPLIES) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:93:28: IMPLIES biimp_expr
            	    {
            	    IMPLIES60=(Token)input.LT(1);
            	    match(input,IMPLIES,FOLLOW_IMPLIES_in_implies_expr541); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    IMPLIES60_tree = (Object)adaptor.create(IMPLIES60);
            	    root_0 = (Object)adaptor.becomeRoot(IMPLIES60_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_biimp_expr_in_implies_expr544);
            	    biimp_expr61=biimp_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, biimp_expr61.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end implies_expr

    public static class biimp_expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start biimp_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:94:1: biimp_expr : eq_expr ( BIIMP eq_expr )* ;
    public final biimp_expr_return biimp_expr() throws RecognitionException {
        biimp_expr_return retval = new biimp_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token BIIMP63=null;
        eq_expr_return eq_expr62 = null;

        eq_expr_return eq_expr64 = null;


        Object BIIMP63_tree=null;

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:94:12: ( eq_expr ( BIIMP eq_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:94:14: eq_expr ( BIIMP eq_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_eq_expr_in_biimp_expr553);
            eq_expr62=eq_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, eq_expr62.getTree());
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:94:22: ( BIIMP eq_expr )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==BIIMP) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:94:23: BIIMP eq_expr
            	    {
            	    BIIMP63=(Token)input.LT(1);
            	    match(input,BIIMP,FOLLOW_BIIMP_in_biimp_expr556); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    BIIMP63_tree = (Object)adaptor.create(BIIMP63);
            	    root_0 = (Object)adaptor.becomeRoot(BIIMP63_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_eq_expr_in_biimp_expr559);
            	    eq_expr64=eq_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, eq_expr64.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end biimp_expr

    public static class eq_expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start eq_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:95:1: eq_expr : neq_expr ( EQ neq_expr )* ;
    public final eq_expr_return eq_expr() throws RecognitionException {
        eq_expr_return retval = new eq_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EQ66=null;
        neq_expr_return neq_expr65 = null;

        neq_expr_return neq_expr67 = null;


        Object EQ66_tree=null;

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:95:9: ( neq_expr ( EQ neq_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:95:11: neq_expr ( EQ neq_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_neq_expr_in_eq_expr568);
            neq_expr65=neq_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, neq_expr65.getTree());
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:95:20: ( EQ neq_expr )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==EQ) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:95:21: EQ neq_expr
            	    {
            	    EQ66=(Token)input.LT(1);
            	    match(input,EQ,FOLLOW_EQ_in_eq_expr571); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    EQ66_tree = (Object)adaptor.create(EQ66);
            	    root_0 = (Object)adaptor.becomeRoot(EQ66_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_neq_expr_in_eq_expr574);
            	    neq_expr67=neq_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, neq_expr67.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end eq_expr

    public static class neq_expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start neq_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:96:1: neq_expr : not_expr ( NEQ not_expr )* ;
    public final neq_expr_return neq_expr() throws RecognitionException {
        neq_expr_return retval = new neq_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NEQ69=null;
        not_expr_return not_expr68 = null;

        not_expr_return not_expr70 = null;


        Object NEQ69_tree=null;

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:96:10: ( not_expr ( NEQ not_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:96:12: not_expr ( NEQ not_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_not_expr_in_neq_expr583);
            not_expr68=not_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, not_expr68.getTree());
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:96:21: ( NEQ not_expr )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==NEQ) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:96:22: NEQ not_expr
            	    {
            	    NEQ69=(Token)input.LT(1);
            	    match(input,NEQ,FOLLOW_NEQ_in_neq_expr586); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    NEQ69_tree = (Object)adaptor.create(NEQ69);
            	    root_0 = (Object)adaptor.becomeRoot(NEQ69_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_not_expr_in_neq_expr589);
            	    not_expr70=not_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, not_expr70.getTree());

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end neq_expr

    public static class not_expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start not_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:97:1: not_expr : ( block_expr | ( NOT block_expr ) );
    public final not_expr_return not_expr() throws RecognitionException {
        not_expr_return retval = new not_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NOT72=null;
        block_expr_return block_expr71 = null;

        block_expr_return block_expr73 = null;


        Object NOT72_tree=null;

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:97:10: ( block_expr | ( NOT block_expr ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==ID||(LA17_0>=TRUE && LA17_0<=FALSE)||LA17_0==LEFT_BRACES||LA17_0==NEXT) ) {
                alt17=1;
            }
            else if ( (LA17_0==NOT) ) {
                alt17=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("97:1: not_expr : ( block_expr | ( NOT block_expr ) );", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:97:12: block_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_block_expr_in_not_expr598);
                    block_expr71=block_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, block_expr71.getTree());

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:97:25: ( NOT block_expr )
                    {
                    root_0 = (Object)adaptor.nil();

                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:97:25: ( NOT block_expr )
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:97:26: NOT block_expr
                    {
                    NOT72=(Token)input.LT(1);
                    match(input,NOT,FOLLOW_NOT_in_not_expr603); if (failed) return retval;
                    if ( backtracking==0 ) {
                    NOT72_tree = (Object)adaptor.create(NOT72);
                    root_0 = (Object)adaptor.becomeRoot(NOT72_tree, root_0);
                    }
                    pushFollow(FOLLOW_block_expr_in_not_expr606);
                    block_expr73=block_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, block_expr73.getTree());

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end not_expr

    public static class block_expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start block_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:98:1: block_expr : ( LEFT_BRACES bool_expr RIGHT_BRACES -> ^( BLOCK_T bool_expr ) | atom_expr );
    public final block_expr_return block_expr() throws RecognitionException {
        block_expr_return retval = new block_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LEFT_BRACES74=null;
        Token RIGHT_BRACES76=null;
        bool_expr_return bool_expr75 = null;

        atom_expr_return atom_expr77 = null;


        Object LEFT_BRACES74_tree=null;
        Object RIGHT_BRACES76_tree=null;
        RewriteRuleTokenStream stream_LEFT_BRACES=new RewriteRuleTokenStream(adaptor,"token LEFT_BRACES");
        RewriteRuleTokenStream stream_RIGHT_BRACES=new RewriteRuleTokenStream(adaptor,"token RIGHT_BRACES");
        RewriteRuleSubtreeStream stream_bool_expr=new RewriteRuleSubtreeStream(adaptor,"rule bool_expr");
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:98:12: ( LEFT_BRACES bool_expr RIGHT_BRACES -> ^( BLOCK_T bool_expr ) | atom_expr )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==LEFT_BRACES) ) {
                alt18=1;
            }
            else if ( (LA18_0==ID||(LA18_0>=TRUE && LA18_0<=FALSE)||LA18_0==NEXT) ) {
                alt18=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("98:1: block_expr : ( LEFT_BRACES bool_expr RIGHT_BRACES -> ^( BLOCK_T bool_expr ) | atom_expr );", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:98:14: LEFT_BRACES bool_expr RIGHT_BRACES
                    {
                    LEFT_BRACES74=(Token)input.LT(1);
                    match(input,LEFT_BRACES,FOLLOW_LEFT_BRACES_in_block_expr614); if (failed) return retval;
                    if ( backtracking==0 ) stream_LEFT_BRACES.add(LEFT_BRACES74);

                    pushFollow(FOLLOW_bool_expr_in_block_expr616);
                    bool_expr75=bool_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_bool_expr.add(bool_expr75.getTree());
                    RIGHT_BRACES76=(Token)input.LT(1);
                    match(input,RIGHT_BRACES,FOLLOW_RIGHT_BRACES_in_block_expr618); if (failed) return retval;
                    if ( backtracking==0 ) stream_RIGHT_BRACES.add(RIGHT_BRACES76);


                    // AST REWRITE
                    // elements: bool_expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 98:49: -> ^( BLOCK_T bool_expr )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:98:52: ^( BLOCK_T bool_expr )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(BLOCK_T, "BLOCK_T"), root_1);

                        adaptor.addChild(root_1, stream_bool_expr.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:99:4: atom_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_atom_expr_in_block_expr631);
                    atom_expr77=atom_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, atom_expr77.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end block_expr

    public static class atom_expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start atom_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:100:1: atom_expr : ( any_ref | value );
    public final atom_expr_return atom_expr() throws RecognitionException {
        atom_expr_return retval = new atom_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        any_ref_return any_ref78 = null;

        value_return value79 = null;



        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:100:11: ( any_ref | value )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==ID||LA19_0==NEXT) ) {
                alt19=1;
            }
            else if ( ((LA19_0>=TRUE && LA19_0<=FALSE)) ) {
                alt19=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("100:1: atom_expr : ( any_ref | value );", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:100:13: any_ref
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_any_ref_in_atom_expr638);
                    any_ref78=any_ref();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, any_ref78.getTree());

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:101:4: value
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_value_in_atom_expr643);
                    value79=value();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, value79.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end atom_expr

    public static class value_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start value
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:103:1: value : ( TRUE | FALSE );
    public final value_return value() throws RecognitionException {
        value_return retval = new value_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set80=null;

        Object set80_tree=null;

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:103:8: ( TRUE | FALSE )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:
            {
            root_0 = (Object)adaptor.nil();

            set80=(Token)input.LT(1);
            if ( (input.LA(1)>=TRUE && input.LA(1)<=FALSE) ) {
                input.consume();
                if ( backtracking==0 ) adaptor.addChild(root_0, adaptor.create(set80));
                errorRecovery=false;failed=false;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_value0);    throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end value

    public static class any_ref_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start any_ref
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:106:1: any_ref : ( unprime_ref | prime_ref_a | prime_ref_b );
    public final any_ref_return any_ref() throws RecognitionException {
        any_ref_return retval = new any_ref_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        unprime_ref_return unprime_ref81 = null;

        prime_ref_a_return prime_ref_a82 = null;

        prime_ref_b_return prime_ref_b83 = null;



        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:106:9: ( unprime_ref | prime_ref_a | prime_ref_b )
            int alt20=3;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:106:11: unprime_ref
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_unprime_ref_in_any_ref666);
                    unprime_ref81=unprime_ref();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, unprime_ref81.getTree());

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:106:25: prime_ref_a
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_prime_ref_a_in_any_ref670);
                    prime_ref_a82=prime_ref_a();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, prime_ref_a82.getTree());

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:106:39: prime_ref_b
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_prime_ref_b_in_any_ref674);
                    prime_ref_b83=prime_ref_b();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, prime_ref_b83.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end any_ref

    public static class prime_ref_a_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start prime_ref_a
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:107:1: prime_ref_a : ( native_ref PRIME ) -> ^( REF_T ^( PRIME_T native_ref ) ) ;
    public final prime_ref_a_return prime_ref_a() throws RecognitionException {
        prime_ref_a_return retval = new prime_ref_a_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PRIME85=null;
        native_ref_return native_ref84 = null;


        Object PRIME85_tree=null;
        RewriteRuleTokenStream stream_PRIME=new RewriteRuleTokenStream(adaptor,"token PRIME");
        RewriteRuleSubtreeStream stream_native_ref=new RewriteRuleSubtreeStream(adaptor,"rule native_ref");
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:107:13: ( ( native_ref PRIME ) -> ^( REF_T ^( PRIME_T native_ref ) ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:107:15: ( native_ref PRIME )
            {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:107:15: ( native_ref PRIME )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:107:16: native_ref PRIME
            {
            pushFollow(FOLLOW_native_ref_in_prime_ref_a682);
            native_ref84=native_ref();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_native_ref.add(native_ref84.getTree());
            PRIME85=(Token)input.LT(1);
            match(input,PRIME,FOLLOW_PRIME_in_prime_ref_a684); if (failed) return retval;
            if ( backtracking==0 ) stream_PRIME.add(PRIME85);


            }


            // AST REWRITE
            // elements: native_ref
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 108:2: -> ^( REF_T ^( PRIME_T native_ref ) )
            {
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:108:5: ^( REF_T ^( PRIME_T native_ref ) )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(REF_T, "REF_T"), root_1);

                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:108:13: ^( PRIME_T native_ref )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(adaptor.create(PRIME_T, "PRIME_T"), root_2);

                adaptor.addChild(root_2, stream_native_ref.next());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end prime_ref_a

    public static class prime_ref_b_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start prime_ref_b
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:109:1: prime_ref_b : ( NEXT LEFT_BRACES native_ref RIGHT_BRACES ) -> ^( REF_T ^( PRIME_T native_ref ) ) ;
    public final prime_ref_b_return prime_ref_b() throws RecognitionException {
        prime_ref_b_return retval = new prime_ref_b_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NEXT86=null;
        Token LEFT_BRACES87=null;
        Token RIGHT_BRACES89=null;
        native_ref_return native_ref88 = null;


        Object NEXT86_tree=null;
        Object LEFT_BRACES87_tree=null;
        Object RIGHT_BRACES89_tree=null;
        RewriteRuleTokenStream stream_NEXT=new RewriteRuleTokenStream(adaptor,"token NEXT");
        RewriteRuleTokenStream stream_LEFT_BRACES=new RewriteRuleTokenStream(adaptor,"token LEFT_BRACES");
        RewriteRuleTokenStream stream_RIGHT_BRACES=new RewriteRuleTokenStream(adaptor,"token RIGHT_BRACES");
        RewriteRuleSubtreeStream stream_native_ref=new RewriteRuleSubtreeStream(adaptor,"rule native_ref");
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:109:13: ( ( NEXT LEFT_BRACES native_ref RIGHT_BRACES ) -> ^( REF_T ^( PRIME_T native_ref ) ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:109:15: ( NEXT LEFT_BRACES native_ref RIGHT_BRACES )
            {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:109:15: ( NEXT LEFT_BRACES native_ref RIGHT_BRACES )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:109:16: NEXT LEFT_BRACES native_ref RIGHT_BRACES
            {
            NEXT86=(Token)input.LT(1);
            match(input,NEXT,FOLLOW_NEXT_in_prime_ref_b706); if (failed) return retval;
            if ( backtracking==0 ) stream_NEXT.add(NEXT86);

            LEFT_BRACES87=(Token)input.LT(1);
            match(input,LEFT_BRACES,FOLLOW_LEFT_BRACES_in_prime_ref_b708); if (failed) return retval;
            if ( backtracking==0 ) stream_LEFT_BRACES.add(LEFT_BRACES87);

            pushFollow(FOLLOW_native_ref_in_prime_ref_b710);
            native_ref88=native_ref();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_native_ref.add(native_ref88.getTree());
            RIGHT_BRACES89=(Token)input.LT(1);
            match(input,RIGHT_BRACES,FOLLOW_RIGHT_BRACES_in_prime_ref_b712); if (failed) return retval;
            if ( backtracking==0 ) stream_RIGHT_BRACES.add(RIGHT_BRACES89);


            }


            // AST REWRITE
            // elements: native_ref
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 110:2: -> ^( REF_T ^( PRIME_T native_ref ) )
            {
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:110:5: ^( REF_T ^( PRIME_T native_ref ) )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(REF_T, "REF_T"), root_1);

                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:110:13: ^( PRIME_T native_ref )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(adaptor.create(PRIME_T, "PRIME_T"), root_2);

                adaptor.addChild(root_2, stream_native_ref.next());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end prime_ref_b

    public static class unprime_ref_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start unprime_ref
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:111:1: unprime_ref : native_ref -> ^( REF_T native_ref ) ;
    public final unprime_ref_return unprime_ref() throws RecognitionException {
        unprime_ref_return retval = new unprime_ref_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        native_ref_return native_ref90 = null;


        RewriteRuleSubtreeStream stream_native_ref=new RewriteRuleSubtreeStream(adaptor,"rule native_ref");
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:111:13: ( native_ref -> ^( REF_T native_ref ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:111:15: native_ref
            {
            pushFollow(FOLLOW_native_ref_in_unprime_ref733);
            native_ref90=native_ref();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_native_ref.add(native_ref90.getTree());

            // AST REWRITE
            // elements: native_ref
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 112:2: -> ^( REF_T native_ref )
            {
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:112:5: ^( REF_T native_ref )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(REF_T, "REF_T"), root_1);

                adaptor.addChild(root_1, stream_native_ref.next());

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end unprime_ref

    public static class native_ref_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start native_ref
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:113:1: native_ref : ID ( DOT ID )* ;
    public final native_ref_return native_ref() throws RecognitionException {
        native_ref_return retval = new native_ref_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID91=null;
        Token DOT92=null;
        Token ID93=null;

        Object ID91_tree=null;
        Object DOT92_tree=null;
        Object ID93_tree=null;

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:113:12: ( ID ( DOT ID )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:113:14: ID ( DOT ID )*
            {
            root_0 = (Object)adaptor.nil();

            ID91=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_native_ref749); if (failed) return retval;
            if ( backtracking==0 ) {
            ID91_tree = (Object)adaptor.create(ID91);
            adaptor.addChild(root_0, ID91_tree);
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:113:17: ( DOT ID )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==DOT) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:113:18: DOT ID
            	    {
            	    DOT92=(Token)input.LT(1);
            	    match(input,DOT,FOLLOW_DOT_in_native_ref752); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    DOT92_tree = (Object)adaptor.create(DOT92);
            	    root_0 = (Object)adaptor.becomeRoot(DOT92_tree, root_0);
            	    }
            	    ID93=(Token)input.LT(1);
            	    match(input,ID,FOLLOW_ID_in_native_ref755); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    ID93_tree = (Object)adaptor.create(ID93);
            	    adaptor.addChild(root_0, ID93_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end native_ref

    public static class type_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start type
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:116:1: type : BOOL_TYPE -> ^( BOOL_T ) ;
    public final type_return type() throws RecognitionException {
        type_return retval = new type_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token BOOL_TYPE94=null;

        Object BOOL_TYPE94_tree=null;
        RewriteRuleTokenStream stream_BOOL_TYPE=new RewriteRuleTokenStream(adaptor,"token BOOL_TYPE");

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:116:6: ( BOOL_TYPE -> ^( BOOL_T ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:116:8: BOOL_TYPE
            {
            BOOL_TYPE94=(Token)input.LT(1);
            match(input,BOOL_TYPE,FOLLOW_BOOL_TYPE_in_type766); if (failed) return retval;
            if ( backtracking==0 ) stream_BOOL_TYPE.add(BOOL_TYPE94);


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 116:18: -> ^( BOOL_T )
            {
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:116:21: ^( BOOL_T )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(BOOL_T, "BOOL_T"), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end type

    // $ANTLR start synpred7
    public final void synpred7_fragment() throws RecognitionException {   
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:59:12: ( var_decl )
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/FDS.g:59:12: var_decl
        {
        pushFollow(FOLLOW_var_decl_in_synpred7214);
        var_decl();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred7

    public final boolean synpred7() {
        backtracking++;
        int start = input.mark();
        try {
            synpred7_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


    protected DFA20 dfa20 = new DFA20(this);
    static final String DFA20_eotS =
        "\7\uffff";
    static final String DFA20_eofS =
        "\1\uffff\1\5\4\uffff\1\5";
    static final String DFA20_minS =
        "\1\23\1\33\1\uffff\1\23\2\uffff\1\33";
    static final String DFA20_maxS =
        "\1\51\1\52\1\uffff\1\23\2\uffff\1\52";
    static final String DFA20_acceptS =
        "\2\uffff\1\3\1\uffff\1\2\1\1\1\uffff";
    static final String DFA20_specialS =
        "\7\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\1\25\uffff\1\2",
            "\1\5\3\uffff\6\5\2\uffff\1\5\1\4\1\uffff\1\3",
            "",
            "\1\6",
            "",
            "",
            "\1\5\3\uffff\6\5\2\uffff\1\5\1\4\1\uffff\1\3"
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "106:1: any_ref : ( unprime_ref | prime_ref_a | prime_ref_b );";
        }
    }
 

    public static final BitSet FOLLOW_module_in_program133 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_EOF_in_program137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MODULE_in_module155 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ID_in_module157 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_LEFT_CURLY_in_module159 = new BitSet(new long[]{0x0000000003E80000L});
    public static final BitSet FOLLOW_section_in_module162 = new BitSet(new long[]{0x0000000003E80000L});
    public static final BitSet FOLLOW_RIGHT_CURLY_in_module166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_expl_sec_in_section189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_sec_in_section193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_init_sec_in_section197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_trans_sec_in_section201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_just_sec_in_section205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_decl_in_var_sec214 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_VAR_in_var_expl_sec233 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_LEFT_CURLY_in_var_expl_sec235 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_var_decl_in_var_expl_sec238 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_RIGHT_CURLY_in_var_expl_sec242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INIT_in_init_sec259 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_LEFT_CURLY_in_init_sec261 = new BitSet(new long[]{0x0000026060280000L});
    public static final BitSet FOLLOW_init_decl_in_init_sec263 = new BitSet(new long[]{0x0000026060280000L});
    public static final BitSet FOLLOW_RIGHT_CURLY_in_init_sec266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRANS_in_trans_sec283 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_LEFT_CURLY_in_trans_sec285 = new BitSet(new long[]{0x0000026060280000L});
    public static final BitSet FOLLOW_trans_decl_in_trans_sec288 = new BitSet(new long[]{0x0000026060280000L});
    public static final BitSet FOLLOW_RIGHT_CURLY_in_trans_sec292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JUST_in_just_sec309 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_LEFT_CURLY_in_just_sec311 = new BitSet(new long[]{0x0000026060280000L});
    public static final BitSet FOLLOW_just_decl_in_just_sec314 = new BitSet(new long[]{0x0000026060280000L});
    public static final BitSet FOLLOW_RIGHT_CURLY_in_just_sec318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_var_decl337 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_COLON_in_var_decl339 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_type_in_var_decl341 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_var_decl343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_init_decl_assi_in_init_decl361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_init_decl_expr_in_init_decl365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_init_decl_t_in_init_decl_assi375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_init_decl_f_in_init_decl_assi379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_init_decl_t386 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_ASSIGN_in_init_decl_t388 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_TRUE_in_init_decl_t390 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_init_decl_t392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_init_decl_f412 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_ASSIGN_in_init_decl_f414 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_FALSE_in_init_decl_f416 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_init_decl_f418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bool_expr_in_init_decl_expr442 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_init_decl_expr444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bool_expr_in_trans_decl460 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_trans_decl462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bool_expr_in_just_decl479 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_just_decl481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binor_expr_in_bool_expr500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_and_expr_in_binor_expr508 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_BINOR_in_binor_expr511 = new BitSet(new long[]{0x0000026060080000L});
    public static final BitSet FOLLOW_and_expr_in_binor_expr514 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_implies_expr_in_and_expr523 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_AND_in_and_expr526 = new BitSet(new long[]{0x0000026060080000L});
    public static final BitSet FOLLOW_implies_expr_in_and_expr529 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_biimp_expr_in_implies_expr538 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_IMPLIES_in_implies_expr541 = new BitSet(new long[]{0x0000026060080000L});
    public static final BitSet FOLLOW_biimp_expr_in_implies_expr544 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_eq_expr_in_biimp_expr553 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_BIIMP_in_biimp_expr556 = new BitSet(new long[]{0x0000026060080000L});
    public static final BitSet FOLLOW_eq_expr_in_biimp_expr559 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_neq_expr_in_eq_expr568 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_EQ_in_eq_expr571 = new BitSet(new long[]{0x0000026060080000L});
    public static final BitSet FOLLOW_neq_expr_in_eq_expr574 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_not_expr_in_neq_expr583 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_NEQ_in_neq_expr586 = new BitSet(new long[]{0x0000026060080000L});
    public static final BitSet FOLLOW_not_expr_in_neq_expr589 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_block_expr_in_not_expr598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_not_expr603 = new BitSet(new long[]{0x0000024060080000L});
    public static final BitSet FOLLOW_block_expr_in_not_expr606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_BRACES_in_block_expr614 = new BitSet(new long[]{0x0000026060080000L});
    public static final BitSet FOLLOW_bool_expr_in_block_expr616 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_RIGHT_BRACES_in_block_expr618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_expr_in_block_expr631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_any_ref_in_atom_expr638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_value_in_atom_expr643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_value0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unprime_ref_in_any_ref666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prime_ref_a_in_any_ref670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prime_ref_b_in_any_ref674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_native_ref_in_prime_ref_a682 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_PRIME_in_prime_ref_a684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEXT_in_prime_ref_b706 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_LEFT_BRACES_in_prime_ref_b708 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_native_ref_in_prime_ref_b710 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_RIGHT_BRACES_in_prime_ref_b712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_native_ref_in_unprime_ref733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_native_ref749 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_DOT_in_native_ref752 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ID_in_native_ref755 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_BOOL_TYPE_in_type766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_decl_in_synpred7214 = new BitSet(new long[]{0x0000000000000002L});

}