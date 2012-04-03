// $ANTLR 3.0.1 /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g 2008-09-25 14:58:31

package edu.wis.jtlv.env.core.spec;
import java.util.HashMap;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.RewriteRuleSubtreeStream;
import org.antlr.runtime.tree.RewriteRuleTokenStream;
import org.antlr.runtime.tree.TreeAdaptor;

import edu.wis.jtlv.env.Env;

@SuppressWarnings("unused")
public class SPCParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NOP", "SPEC_LIST_T", "SUBRANGE_T", "VALUE_T", "SET_LIST_EXP_T", "BLOCK_T", "CASE_LIST_EXPR_T", "CASE_ELEMENT_EXPR_T", "BIT_SELECT_T", "ARRAY_INDEX_T", "TOK_UNARY_MINUS_T", "PURE_CTL_T", "PURE_LTL_T", "TOK_INVAR_SPEC", "TOK_CTL_SPEC", "TOK_LTL_SPEC", "TOK_CTL_STAR_SPEC", "TOK_IMPLIES", "TOK_IFF", "TOK_OR", "TOK_XOR", "TOK_XNOR", "TOK_AND", "TOK_EQUAL", "TOK_NOTEQUAL", "TOK_LT", "TOK_GT", "TOK_LE", "TOK_GE", "TOK_SETIN", "TOK_UNION", "TOK_LCB", "TOK_RCB", "TOK_COMMA", "TOK_LSHIFT", "TOK_RSHIFT", "TOK_MOD", "TOK_PLUS", "TOK_MINUS", "TOK_TIMES", "TOK_DIVIDE", "TOK_CONCATENATION", "TOK_NOT", "TOK_LP", "TOK_RP", "TOK_BOOL", "TOK_WORD1", "TOK_NEXT", "TOK_CASE", "TOK_ESAC", "TOK_WAREAD", "TOK_WAWRITE", "TOK_EX", "TOK_AX", "TOK_EF", "TOK_AF", "TOK_EG", "TOK_AG", "TOK_EBF", "TOK_ABF", "TOK_EBG", "TOK_ABG", "TOK_AA", "TOK_LB", "TOK_UNTIL", "TOK_RB", "TOK_EE", "TOK_BUNTIL", "TOK_SINCE", "TOK_RELEASES", "TOK_TRIGGERED", "TOK_OP_NEXT", "TOK_OP_PREV", "TOK_OP_NOTPREVNOT", "TOK_OP_GLOBALLY", "TOK_OP_HISTORICALLY", "TOK_OP_FINALLY", "TOK_OP_ONCE", "TOK_ATOM", "TOK_DOT", "TOK_NUMBER", "TOK_COLON", "TOK_SEMI", "TOK_NUMBER_WORD", "TOK_TWODOTS", "TOK_FALSEEXP", "TOK_TRUEEXP", "TOK_WORD", "TOK_NUMBER_FRAC", "JTOK_WS", "JTOK_MULTI_COMMENT", "JTOK_LINE_COMMENT"
    };
    public static final int SPEC_LIST_T=5;
    public static final int TOK_CASE=52;
    public static final int TOK_OP_HISTORICALLY=79;
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
    public static final int TOK_RSHIFT=39;
    public static final int ARRAY_INDEX_T=13;
    public static final int TOK_EG=60;
    public static final int TOK_TRIGGERED=74;
    public static final int TOK_EF=58;
    public static final int TOK_SINCE=72;
    public static final int TOK_IFF=22;
    public static final int TOK_EE=70;
    public static final int TOK_RELEASES=73;
    public static final int TOK_UNARY_MINUS_T=14;
    public static final int TOK_OP_NEXT=75;
    public static final int TOK_IMPLIES=21;
    public static final int TOK_CTL_STAR_SPEC=20;
    public static final int TOK_FALSEEXP=89;
    public static final int TOK_NOTEQUAL=28;
    public static final int TOK_ESAC=53;
    public static final int JTOK_MULTI_COMMENT=94;
    public static final int TOK_SEMI=86;
    public static final int TOK_WAWRITE=55;
    public static final int JTOK_LINE_COMMENT=95;
    public static final int TOK_XOR=24;
    public static final int TOK_GT=30;
    public static final int TOK_PLUS=41;
    public static final int BIT_SELECT_T=12;
    public static final int TOK_NUMBER=84;
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
    public static final int TOK_LE=31;
    public static final int TOK_TRUEEXP=90;
    public static final int TOK_OP_GLOBALLY=78;
    public static final int TOK_ATOM=82;
    public static final int TOK_LSHIFT=38;
    public static final int TOK_OP_ONCE=81;
    public static final int TOK_MINUS=42;
    public static final int TOK_EQUAL=27;

        public SPCParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[124+1];
         }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "/home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g"; }


    // for exception handling
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

    // I don't like the printing...
    public void recoverFromMismatchedToken(IntStream input,
    		RecognitionException e, int ttype, BitSet follow)
    		throws RecognitionException {
    	//System.err.println("BR.recoverFromMismatchedToken");
    	// if next token is what we are looking for then "delete" this token
    	if (input.LA(2) == ttype) {
    		reportError(e);
    		/*
    		 * System.err.println("recoverFromMismatchedToken deleting
    		 * "+input.LT(1)+ " since "+input.LT(2)+" is what we want");
    		 */
    		beginResync();
    		input.consume(); // simply delete extra token
    		endResync();
    		input.consume(); // move past ttype token as if all were ok
    		return;
    	}
    	if (!recoverFromMismatchedElement(input, e, follow)) {
    		throw e;
    	}
    }

    public static boolean in_my_recovery_mode = false;
    public boolean er() {
    	//if (input.LA(1) == TOK_SEMI)
    	//	in_my_recovery_mode = true;
    	return errorRecovery | in_my_recovery_mode;
    }
    public void recover(IntStream input, RecognitionException re) {
    	in_my_recovery_mode = true;
    	super.recover(input, re);
    }
    public void consumeUntilSpecStart(TokenStream input) throws SpecParseException {
    	int ttype = input.LA(1);
    	
    	Token tstart = input.LT(1);
    	Token tstop = null;
    	while (ttype != Token.EOF && ttype != SPCLexer.TOK_INVAR_SPEC && ttype != SPCLexer.TOK_CTL_SPEC && ttype != SPCLexer.TOK_LTL_SPEC && ttype != SPCLexer.TOK_CTL_STAR_SPEC) {
    		tstop = input.LT(1);
    		input.consume();
    		ttype = input.LA(1);
    	}
    	// if there is something to  throw, i.e. there was a problem.
    	if (tstop != null) {
    		throw new SpecParseException("Failed to parse expression '" + input.toString(tstart, tstop) + "'" , input, tstart, tstop);
    	}
    }


    public static class spec_return extends ParserRuleReturnScope {
        public WAArrayOfSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start spec
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:125:1: spec returns [WAArrayOfSpec ret] : ( EOF | spec_list EOF -> ^( SPEC_LIST_T spec_list ) );
    public final spec_return spec() throws RecognitionException {
        spec_return retval = new spec_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EOF1=null;
        Token EOF3=null;
        spec_list_return spec_list2 = null;


        Object EOF1_tree=null;
        Object EOF3_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_spec_list=new RewriteRuleSubtreeStream(adaptor,"rule spec_list");
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:126:9: ( EOF | spec_list EOF -> ^( SPEC_LIST_T spec_list ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==EOF) ) {
                alt1=1;
            }
            else if ( ((LA1_0>=TOK_INVAR_SPEC && LA1_0<=TOK_CTL_STAR_SPEC)) ) {
                alt1=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("125:1: spec returns [WAArrayOfSpec ret] : ( EOF | spec_list EOF -> ^( SPEC_LIST_T spec_list ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:126:11: EOF
                    {
                    root_0 = (Object)adaptor.nil();

                    EOF1=(Token)input.LT(1);
                    match(input,EOF,FOLLOW_EOF_in_spec134); if (failed) return retval;
                    if ( backtracking==0 ) {
                    EOF1_tree = (Object)adaptor.create(EOF1);
                    adaptor.addChild(root_0, EOF1_tree);
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:127:11: spec_list EOF
                    {
                    pushFollow(FOLLOW_spec_list_in_spec146);
                    spec_list2=spec_list();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_spec_list.add(spec_list2.getTree());
                    EOF3=(Token)input.LT(1);
                    match(input,EOF,FOLLOW_EOF_in_spec148); if (failed) return retval;
                    if ( backtracking==0 ) stream_EOF.add(EOF3);

                    if ( backtracking==0 ) {
                       retval.ret = spec_list2.ret; 
                    }

                    // AST REWRITE
                    // elements: spec_list
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 129:9: -> ^( SPEC_LIST_T spec_list )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:129:12: ^( SPEC_LIST_T spec_list )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(SPEC_LIST_T, "SPEC_LIST_T"), root_1);

                        adaptor.addChild(root_1, stream_spec_list.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

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
    // $ANTLR end spec

    public static class spec_list_return extends ParserRuleReturnScope {
        public WAArrayOfSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start spec_list
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:131:1: spec_list returns [WAArrayOfSpec ret] : f= spec_element (s= spec_element )* ;
    public final spec_list_return spec_list() throws RecognitionException {
        spec_list_return retval = new spec_list_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        spec_element_return f = null;

        spec_element_return s = null;



        retval.ret = new WAArrayOfSpec(); 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:133:9: (f= spec_element (s= spec_element )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:133:11: f= spec_element (s= spec_element )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_spec_element_in_spec_list212);
            f=spec_element();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if(!er()) retval.ret.specs.add(f.ret); else retval.ret.specs.add(null); in_my_recovery_mode = false; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:134:9: (s= spec_element )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=TOK_INVAR_SPEC && LA2_0<=TOK_CTL_STAR_SPEC)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:134:11: s= spec_element
            	    {
            	    pushFollow(FOLLOW_spec_element_in_spec_list228);
            	    s=spec_element();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if(!er()) retval.ret.specs.add(s.ret); else retval.ret.specs.add(null); in_my_recovery_mode = false; 
            	    }

            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end spec_list

    public static class spec_element_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start spec_element
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:137:1: spec_element returns [InternalSpec ret] : ( invar_spec | ctl_spec | ltl_spec | ctls_spec );
    public final spec_element_return spec_element() throws RecognitionException {
        spec_element_return retval = new spec_element_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        invar_spec_return invar_spec4 = null;

        ctl_spec_return ctl_spec5 = null;

        ltl_spec_return ltl_spec6 = null;

        ctls_spec_return ctls_spec7 = null;



        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:138:9: ( invar_spec | ctl_spec | ltl_spec | ctls_spec )
            int alt3=4;
            switch ( input.LA(1) ) {
            case TOK_INVAR_SPEC:
                {
                alt3=1;
                }
                break;
            case TOK_CTL_SPEC:
                {
                alt3=2;
                }
                break;
            case TOK_LTL_SPEC:
                {
                alt3=3;
                }
                break;
            case TOK_CTL_STAR_SPEC:
                {
                alt3=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("137:1: spec_element returns [InternalSpec ret] : ( invar_spec | ctl_spec | ltl_spec | ctls_spec );", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:138:11: invar_spec
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_invar_spec_in_spec_element271);
                    invar_spec4=invar_spec();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, invar_spec4.getTree());
                    if ( backtracking==0 ) {
                      if(!er()) retval.ret = invar_spec4.ret; consumeUntilSpecStart(input); 
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:139:11: ctl_spec
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ctl_spec_in_spec_element285);
                    ctl_spec5=ctl_spec();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, ctl_spec5.getTree());
                    if ( backtracking==0 ) {
                      if(!er()) retval.ret = ctl_spec5.ret; consumeUntilSpecStart(input); 
                    }

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:140:11: ltl_spec
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ltl_spec_in_spec_element299);
                    ltl_spec6=ltl_spec();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, ltl_spec6.getTree());
                    if ( backtracking==0 ) {
                      if(!er()) retval.ret = ltl_spec6.ret; consumeUntilSpecStart(input); 
                    }

                    }
                    break;
                case 4 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:141:11: ctls_spec
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ctls_spec_in_spec_element313);
                    ctls_spec7=ctls_spec();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, ctls_spec7.getTree());
                    if ( backtracking==0 ) {
                      if(!er()) retval.ret = ctls_spec7.ret; consumeUntilSpecStart(input); 
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
    // $ANTLR end spec_element

    public static class invar_spec_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start invar_spec
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:153:1: invar_spec returns [InternalSpec ret] : TOK_INVAR_SPEC simple_root_expr optsemi ;
    public final invar_spec_return invar_spec() throws RecognitionException {
        invar_spec_return retval = new invar_spec_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TOK_INVAR_SPEC8=null;
        simple_root_expr_return simple_root_expr9 = null;

        optsemi_return optsemi10 = null;


        Object TOK_INVAR_SPEC8_tree=null;

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:155:9: ( TOK_INVAR_SPEC simple_root_expr optsemi )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:155:11: TOK_INVAR_SPEC simple_root_expr optsemi
            {
            root_0 = (Object)adaptor.nil();

            TOK_INVAR_SPEC8=(Token)input.LT(1);
            match(input,TOK_INVAR_SPEC,FOLLOW_TOK_INVAR_SPEC_in_invar_spec361); if (failed) return retval;
            if ( backtracking==0 ) {
            TOK_INVAR_SPEC8_tree = (Object)adaptor.create(TOK_INVAR_SPEC8);
            root_0 = (Object)adaptor.becomeRoot(TOK_INVAR_SPEC8_tree, root_0);
            }
            pushFollow(FOLLOW_simple_root_expr_in_invar_spec364);
            simple_root_expr9=simple_root_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, simple_root_expr9.getTree());
            pushFollow(FOLLOW_optsemi_in_invar_spec366);
            optsemi10=optsemi();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) {
              if(!er()) retval.ret = simple_root_expr9.ret; 
            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if (!er() && (retval.ret instanceof InternalSpecBDD)) ((InternalSpecBDD) retval.ret).evalBDDExp(input); 
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
    // $ANTLR end invar_spec

    public static class ctl_spec_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctl_spec
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:157:1: ctl_spec returns [InternalSpec ret] : TOK_CTL_SPEC ctl_root_expr optsemi ;
    public final ctl_spec_return ctl_spec() throws RecognitionException {
        ctl_spec_return retval = new ctl_spec_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TOK_CTL_SPEC11=null;
        ctl_root_expr_return ctl_root_expr12 = null;

        optsemi_return optsemi13 = null;


        Object TOK_CTL_SPEC11_tree=null;

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:159:9: ( TOK_CTL_SPEC ctl_root_expr optsemi )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:159:11: TOK_CTL_SPEC ctl_root_expr optsemi
            {
            root_0 = (Object)adaptor.nil();

            TOK_CTL_SPEC11=(Token)input.LT(1);
            match(input,TOK_CTL_SPEC,FOLLOW_TOK_CTL_SPEC_in_ctl_spec405); if (failed) return retval;
            if ( backtracking==0 ) {
            TOK_CTL_SPEC11_tree = (Object)adaptor.create(TOK_CTL_SPEC11);
            root_0 = (Object)adaptor.becomeRoot(TOK_CTL_SPEC11_tree, root_0);
            }
            pushFollow(FOLLOW_ctl_root_expr_in_ctl_spec408);
            ctl_root_expr12=ctl_root_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, ctl_root_expr12.getTree());
            pushFollow(FOLLOW_optsemi_in_ctl_spec410);
            optsemi13=optsemi();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) {
              if(!er()) retval.ret = ctl_root_expr12.ret; 
            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if (!er() && (retval.ret instanceof InternalSpecBDD)) ((InternalSpecBDD) retval.ret).evalBDDExp(input); 
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
    // $ANTLR end ctl_spec

    public static class ltl_spec_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ltl_spec
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:161:1: ltl_spec returns [InternalSpec ret] : TOK_LTL_SPEC ltl_root_expr optsemi ;
    public final ltl_spec_return ltl_spec() throws RecognitionException {
        ltl_spec_return retval = new ltl_spec_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TOK_LTL_SPEC14=null;
        ltl_root_expr_return ltl_root_expr15 = null;

        optsemi_return optsemi16 = null;


        Object TOK_LTL_SPEC14_tree=null;

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:163:9: ( TOK_LTL_SPEC ltl_root_expr optsemi )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:163:11: TOK_LTL_SPEC ltl_root_expr optsemi
            {
            root_0 = (Object)adaptor.nil();

            TOK_LTL_SPEC14=(Token)input.LT(1);
            match(input,TOK_LTL_SPEC,FOLLOW_TOK_LTL_SPEC_in_ltl_spec449); if (failed) return retval;
            if ( backtracking==0 ) {
            TOK_LTL_SPEC14_tree = (Object)adaptor.create(TOK_LTL_SPEC14);
            root_0 = (Object)adaptor.becomeRoot(TOK_LTL_SPEC14_tree, root_0);
            }
            pushFollow(FOLLOW_ltl_root_expr_in_ltl_spec452);
            ltl_root_expr15=ltl_root_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, ltl_root_expr15.getTree());
            pushFollow(FOLLOW_optsemi_in_ltl_spec454);
            optsemi16=optsemi();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) {
              if(!er()) retval.ret = ltl_root_expr15.ret; 
            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if (!er() && (retval.ret instanceof InternalSpecBDD)) ((InternalSpecBDD) retval.ret).evalBDDExp(input); 
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
    // $ANTLR end ltl_spec

    public static class ctls_spec_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctls_spec
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:165:1: ctls_spec returns [InternalSpec ret] : TOK_CTL_STAR_SPEC ctls_root_expr optsemi ;
    public final ctls_spec_return ctls_spec() throws RecognitionException {
        ctls_spec_return retval = new ctls_spec_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TOK_CTL_STAR_SPEC17=null;
        ctls_root_expr_return ctls_root_expr18 = null;

        optsemi_return optsemi19 = null;


        Object TOK_CTL_STAR_SPEC17_tree=null;

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:167:9: ( TOK_CTL_STAR_SPEC ctls_root_expr optsemi )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:167:11: TOK_CTL_STAR_SPEC ctls_root_expr optsemi
            {
            root_0 = (Object)adaptor.nil();

            TOK_CTL_STAR_SPEC17=(Token)input.LT(1);
            match(input,TOK_CTL_STAR_SPEC,FOLLOW_TOK_CTL_STAR_SPEC_in_ctls_spec493); if (failed) return retval;
            if ( backtracking==0 ) {
            TOK_CTL_STAR_SPEC17_tree = (Object)adaptor.create(TOK_CTL_STAR_SPEC17);
            root_0 = (Object)adaptor.becomeRoot(TOK_CTL_STAR_SPEC17_tree, root_0);
            }
            pushFollow(FOLLOW_ctls_root_expr_in_ctls_spec496);
            ctls_root_expr18=ctls_root_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, ctls_root_expr18.getTree());
            pushFollow(FOLLOW_optsemi_in_ctls_spec498);
            optsemi19=optsemi();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) {
              if(!er()) retval.ret = ctls_root_expr18.ret; 
            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if (!er() && (retval.ret instanceof InternalSpecBDD)) ((InternalSpecBDD) retval.ret).evalBDDExp(input); 
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
    // $ANTLR end ctls_spec

    public static class simple_root_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start simple_root_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:176:1: simple_root_expr returns [InternalSpec ret] : implies_expr ;
    public final simple_root_expr_return simple_root_expr() throws RecognitionException {
        simple_root_expr_return retval = new simple_root_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        implies_expr_return implies_expr20 = null;



        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:177:9: ( implies_expr )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:177:11: implies_expr
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_implies_expr_in_simple_root_expr540);
            implies_expr20=implies_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, implies_expr20.getTree());
            if ( backtracking==0 ) {
              if(!er()) retval.ret = implies_expr20.ret; 
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
    // $ANTLR end simple_root_expr

    public static class implies_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start implies_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:179:1: implies_expr returns [InternalSpec ret] : f= iff_expr (op= TOK_IMPLIES s= implies_expr )? ;
    public final implies_expr_return implies_expr() throws RecognitionException {
        implies_expr_return retval = new implies_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        iff_expr_return f = null;

        implies_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:182:9: (f= iff_expr (op= TOK_IMPLIES s= implies_expr )? )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:182:11: f= iff_expr (op= TOK_IMPLIES s= implies_expr )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_iff_expr_in_implies_expr584);
            f=iff_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:183:9: (op= TOK_IMPLIES s= implies_expr )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==TOK_IMPLIES) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:183:11: op= TOK_IMPLIES s= implies_expr
                    {
                    op=(Token)input.LT(1);
                    match(input,TOK_IMPLIES,FOLLOW_TOK_IMPLIES_in_implies_expr600); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_implies_expr_in_implies_expr605);
                    s=implies_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_imply(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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

    public static class iff_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start iff_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:187:1: iff_expr returns [InternalSpec ret] : f= or_expr (op= TOK_IFF s= or_expr )* ;
    public final iff_expr_return iff_expr() throws RecognitionException {
        iff_expr_return retval = new iff_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        or_expr_return f = null;

        or_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:190:9: (f= or_expr (op= TOK_IFF s= or_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:190:11: f= or_expr (op= TOK_IFF s= or_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_or_expr_in_iff_expr671);
            f=or_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:191:9: (op= TOK_IFF s= or_expr )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==TOK_IFF) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:191:11: op= TOK_IFF s= or_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_IFF,FOLLOW_TOK_IFF_in_iff_expr687); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_or_expr_in_iff_expr692);
            	    s=or_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_iff(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end iff_expr

    public static class or_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start or_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:195:1: or_expr returns [InternalSpec ret] : f= and_expr (op= TOK_OR s= and_expr | op= TOK_XOR s= and_expr | op= TOK_XNOR s= and_expr )* ;
    public final or_expr_return or_expr() throws RecognitionException {
        or_expr_return retval = new or_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        and_expr_return f = null;

        and_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:198:9: (f= and_expr (op= TOK_OR s= and_expr | op= TOK_XOR s= and_expr | op= TOK_XNOR s= and_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:198:11: f= and_expr (op= TOK_OR s= and_expr | op= TOK_XOR s= and_expr | op= TOK_XNOR s= and_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_and_expr_in_or_expr757);
            f=and_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:199:9: (op= TOK_OR s= and_expr | op= TOK_XOR s= and_expr | op= TOK_XNOR s= and_expr )*
            loop6:
            do {
                int alt6=4;
                switch ( input.LA(1) ) {
                case TOK_OR:
                    {
                    alt6=1;
                    }
                    break;
                case TOK_XOR:
                    {
                    alt6=2;
                    }
                    break;
                case TOK_XNOR:
                    {
                    alt6=3;
                    }
                    break;

                }

                switch (alt6) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:199:11: op= TOK_OR s= and_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_OR,FOLLOW_TOK_OR_in_or_expr773); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_and_expr_in_or_expr778);
            	    s=and_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_or(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:201:11: op= TOK_XOR s= and_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_XOR,FOLLOW_TOK_XOR_in_or_expr802); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_and_expr_in_or_expr807);
            	    s=and_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_xor(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 3 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:203:11: op= TOK_XNOR s= and_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_XNOR,FOLLOW_TOK_XNOR_in_or_expr831); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_and_expr_in_or_expr836);
            	    s=and_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_xnor(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end or_expr

    public static class and_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start and_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:207:1: and_expr returns [InternalSpec ret] : f= relational_expr (op= TOK_AND s= relational_expr )* ;
    public final and_expr_return and_expr() throws RecognitionException {
        and_expr_return retval = new and_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        relational_expr_return f = null;

        relational_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:210:9: (f= relational_expr (op= TOK_AND s= relational_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:210:11: f= relational_expr (op= TOK_AND s= relational_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_relational_expr_in_and_expr900);
            f=relational_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:211:9: (op= TOK_AND s= relational_expr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==TOK_AND) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:211:11: op= TOK_AND s= relational_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_AND,FOLLOW_TOK_AND_in_and_expr916); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_relational_expr_in_and_expr921);
            	    s=relational_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_and(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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

    public static class relational_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start relational_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:215:1: relational_expr returns [InternalSpec ret] : f= in_expr (op= TOK_EQUAL s= in_expr | op= TOK_NOTEQUAL s= in_expr | op= TOK_LT s= in_expr | op= TOK_GT s= in_expr | op= TOK_LE s= in_expr | op= TOK_GE s= in_expr )* ;
    public final relational_expr_return relational_expr() throws RecognitionException {
        relational_expr_return retval = new relational_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        in_expr_return f = null;

        in_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:218:9: (f= in_expr (op= TOK_EQUAL s= in_expr | op= TOK_NOTEQUAL s= in_expr | op= TOK_LT s= in_expr | op= TOK_GT s= in_expr | op= TOK_LE s= in_expr | op= TOK_GE s= in_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:218:11: f= in_expr (op= TOK_EQUAL s= in_expr | op= TOK_NOTEQUAL s= in_expr | op= TOK_LT s= in_expr | op= TOK_GT s= in_expr | op= TOK_LE s= in_expr | op= TOK_GE s= in_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_in_expr_in_relational_expr984);
            f=in_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:219:9: (op= TOK_EQUAL s= in_expr | op= TOK_NOTEQUAL s= in_expr | op= TOK_LT s= in_expr | op= TOK_GT s= in_expr | op= TOK_LE s= in_expr | op= TOK_GE s= in_expr )*
            loop8:
            do {
                int alt8=7;
                switch ( input.LA(1) ) {
                case TOK_EQUAL:
                    {
                    alt8=1;
                    }
                    break;
                case TOK_NOTEQUAL:
                    {
                    alt8=2;
                    }
                    break;
                case TOK_LT:
                    {
                    alt8=3;
                    }
                    break;
                case TOK_GT:
                    {
                    alt8=4;
                    }
                    break;
                case TOK_LE:
                    {
                    alt8=5;
                    }
                    break;
                case TOK_GE:
                    {
                    alt8=6;
                    }
                    break;

                }

                switch (alt8) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:219:11: op= TOK_EQUAL s= in_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_EQUAL,FOLLOW_TOK_EQUAL_in_relational_expr1000); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_in_expr_in_relational_expr1005);
            	    s=in_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_eq(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:221:11: op= TOK_NOTEQUAL s= in_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_NOTEQUAL,FOLLOW_TOK_NOTEQUAL_in_relational_expr1030); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_in_expr_in_relational_expr1035);
            	    s=in_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_neq(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 3 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:223:11: op= TOK_LT s= in_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_LT,FOLLOW_TOK_LT_in_relational_expr1060); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_in_expr_in_relational_expr1065);
            	    s=in_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_lt(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 4 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:225:11: op= TOK_GT s= in_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_GT,FOLLOW_TOK_GT_in_relational_expr1090); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_in_expr_in_relational_expr1095);
            	    s=in_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_gt(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 5 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:227:11: op= TOK_LE s= in_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_LE,FOLLOW_TOK_LE_in_relational_expr1120); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_in_expr_in_relational_expr1125);
            	    s=in_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_le(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 6 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:229:11: op= TOK_GE s= in_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_GE,FOLLOW_TOK_GE_in_relational_expr1150); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_in_expr_in_relational_expr1155);
            	    s=in_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ge(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end relational_expr

    public static class in_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start in_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:233:1: in_expr returns [InternalSpec ret] : f= union_expr (op= TOK_SETIN s= union_expr )* ;
    public final in_expr_return in_expr() throws RecognitionException {
        in_expr_return retval = new in_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        union_expr_return f = null;

        union_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:236:9: (f= union_expr (op= TOK_SETIN s= union_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:236:11: f= union_expr (op= TOK_SETIN s= union_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_union_expr_in_in_expr1220);
            f=union_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:237:9: (op= TOK_SETIN s= union_expr )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==TOK_SETIN) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:237:11: op= TOK_SETIN s= union_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_SETIN,FOLLOW_TOK_SETIN_in_in_expr1236); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_union_expr_in_in_expr1241);
            	    s=union_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_setin(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end in_expr

    public static class union_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start union_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:241:1: union_expr returns [InternalSpec ret] : f= set_expr (op= TOK_UNION s= set_expr )* ;
    public final union_expr_return union_expr() throws RecognitionException {
        union_expr_return retval = new union_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        set_expr_return f = null;

        set_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:244:9: (f= set_expr (op= TOK_UNION s= set_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:244:11: f= set_expr (op= TOK_UNION s= set_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_set_expr_in_union_expr1305);
            f=set_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:245:9: (op= TOK_UNION s= set_expr )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==TOK_UNION) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:245:11: op= TOK_UNION s= set_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_UNION,FOLLOW_TOK_UNION_in_union_expr1321); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_set_expr_in_union_expr1326);
            	    s=set_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_union(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end union_expr

    public static class set_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start set_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:249:1: set_expr returns [InternalSpec ret] : ( shift_expr | subrange | TOK_LCB set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T set_list_expr ) );
    public final set_expr_return set_expr() throws RecognitionException {
        set_expr_return retval = new set_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TOK_LCB23=null;
        Token TOK_RCB25=null;
        shift_expr_return shift_expr21 = null;

        subrange_return subrange22 = null;

        set_list_expr_return set_list_expr24 = null;


        Object TOK_LCB23_tree=null;
        Object TOK_RCB25_tree=null;
        RewriteRuleTokenStream stream_TOK_LCB=new RewriteRuleTokenStream(adaptor,"token TOK_LCB");
        RewriteRuleTokenStream stream_TOK_RCB=new RewriteRuleTokenStream(adaptor,"token TOK_RCB");
        RewriteRuleSubtreeStream stream_set_list_expr=new RewriteRuleSubtreeStream(adaptor,"rule set_list_expr");
        boolean append_end = false;
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:252:9: ( shift_expr | subrange | TOK_LCB set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T set_list_expr ) )
            int alt11=3;
            switch ( input.LA(1) ) {
            case TOK_NOT:
            case TOK_LP:
            case TOK_BOOL:
            case TOK_WORD1:
            case TOK_NEXT:
            case TOK_CASE:
            case TOK_WAREAD:
            case TOK_WAWRITE:
            case TOK_ATOM:
            case TOK_NUMBER_WORD:
            case TOK_FALSEEXP:
            case TOK_TRUEEXP:
                {
                alt11=1;
                }
                break;
            case TOK_NUMBER:
                {
                int LA11_2 = input.LA(2);

                if ( (LA11_2==TOK_TWODOTS) ) {
                    alt11=2;
                }
                else if ( (LA11_2==EOF||(LA11_2>=TOK_INVAR_SPEC && LA11_2<=TOK_UNION)||(LA11_2>=TOK_RCB && LA11_2<=TOK_CONCATENATION)||LA11_2==TOK_RP||LA11_2==TOK_LB||LA11_2==TOK_RB||LA11_2==TOK_DOT||(LA11_2>=TOK_COLON && LA11_2<=TOK_SEMI)) ) {
                    alt11=1;
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("249:1: set_expr returns [InternalSpec ret] : ( shift_expr | subrange | TOK_LCB set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T set_list_expr ) );", 11, 2, input);

                    throw nvae;
                }
                }
                break;
            case TOK_PLUS:
                {
                int LA11_3 = input.LA(2);

                if ( (LA11_3==TOK_NUMBER) ) {
                    int LA11_7 = input.LA(3);

                    if ( (LA11_7==EOF||(LA11_7>=TOK_INVAR_SPEC && LA11_7<=TOK_UNION)||(LA11_7>=TOK_RCB && LA11_7<=TOK_CONCATENATION)||LA11_7==TOK_RP||LA11_7==TOK_LB||LA11_7==TOK_RB||LA11_7==TOK_DOT||(LA11_7>=TOK_COLON && LA11_7<=TOK_SEMI)) ) {
                        alt11=1;
                    }
                    else if ( (LA11_7==TOK_TWODOTS) ) {
                        alt11=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("249:1: set_expr returns [InternalSpec ret] : ( shift_expr | subrange | TOK_LCB set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T set_list_expr ) );", 11, 7, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("249:1: set_expr returns [InternalSpec ret] : ( shift_expr | subrange | TOK_LCB set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T set_list_expr ) );", 11, 3, input);

                    throw nvae;
                }
                }
                break;
            case TOK_MINUS:
                {
                int LA11_4 = input.LA(2);

                if ( (LA11_4==TOK_NUMBER) ) {
                    int LA11_8 = input.LA(3);

                    if ( (LA11_8==EOF||(LA11_8>=TOK_INVAR_SPEC && LA11_8<=TOK_UNION)||(LA11_8>=TOK_RCB && LA11_8<=TOK_CONCATENATION)||LA11_8==TOK_RP||LA11_8==TOK_LB||LA11_8==TOK_RB||LA11_8==TOK_DOT||(LA11_8>=TOK_COLON && LA11_8<=TOK_SEMI)) ) {
                        alt11=1;
                    }
                    else if ( (LA11_8==TOK_TWODOTS) ) {
                        alt11=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("249:1: set_expr returns [InternalSpec ret] : ( shift_expr | subrange | TOK_LCB set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T set_list_expr ) );", 11, 8, input);

                        throw nvae;
                    }
                }
                else if ( ((LA11_4>=TOK_PLUS && LA11_4<=TOK_MINUS)||(LA11_4>=TOK_NOT && LA11_4<=TOK_LP)||(LA11_4>=TOK_BOOL && LA11_4<=TOK_CASE)||(LA11_4>=TOK_WAREAD && LA11_4<=TOK_WAWRITE)||LA11_4==TOK_ATOM||LA11_4==TOK_NUMBER_WORD||(LA11_4>=TOK_FALSEEXP && LA11_4<=TOK_TRUEEXP)) ) {
                    alt11=1;
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("249:1: set_expr returns [InternalSpec ret] : ( shift_expr | subrange | TOK_LCB set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T set_list_expr ) );", 11, 4, input);

                    throw nvae;
                }
                }
                break;
            case TOK_LCB:
                {
                alt11=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("249:1: set_expr returns [InternalSpec ret] : ( shift_expr | subrange | TOK_LCB set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T set_list_expr ) );", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:252:11: shift_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_shift_expr_in_set_expr1388);
                    shift_expr21=shift_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, shift_expr21.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) retval.ret = shift_expr21.ret; 
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:254:11: subrange
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_subrange_in_set_expr1410);
                    subrange22=subrange();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, subrange22.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_range(input, ((Token)retval.start), input.toString(subrange22.start,subrange22.stop)); 
                    }

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:256:11: TOK_LCB set_list_expr TOK_RCB
                    {
                    TOK_LCB23=(Token)input.LT(1);
                    match(input,TOK_LCB,FOLLOW_TOK_LCB_in_set_expr1433); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_LCB.add(TOK_LCB23);

                    pushFollow(FOLLOW_set_list_expr_in_set_expr1435);
                    set_list_expr24=set_list_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_set_list_expr.add(set_list_expr24.getTree());
                    TOK_RCB25=(Token)input.LT(1);
                    match(input,TOK_RCB,FOLLOW_TOK_RCB_in_set_expr1437); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_RCB.add(TOK_RCB25);

                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_set(input, ((Token)retval.start), TOK_LCB23.getText() + " " + input.toString(set_list_expr24.start,set_list_expr24.stop) + " " + TOK_RCB25.getText()); 
                    }

                    // AST REWRITE
                    // elements: set_list_expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 258:9: -> ^( SET_LIST_EXP_T set_list_expr )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:258:12: ^( SET_LIST_EXP_T set_list_expr )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(SET_LIST_EXP_T, "SET_LIST_EXP_T"), root_1);

                        adaptor.addChild(root_1, stream_set_list_expr.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end set_expr

    public static class set_list_expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start set_list_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:260:1: set_list_expr : simple_root_expr ( TOK_COMMA simple_root_expr )* ;
    public final set_list_expr_return set_list_expr() throws RecognitionException {
        set_list_expr_return retval = new set_list_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TOK_COMMA27=null;
        simple_root_expr_return simple_root_expr26 = null;

        simple_root_expr_return simple_root_expr28 = null;


        Object TOK_COMMA27_tree=null;

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:261:9: ( simple_root_expr ( TOK_COMMA simple_root_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:261:11: simple_root_expr ( TOK_COMMA simple_root_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_simple_root_expr_in_set_list_expr1491);
            simple_root_expr26=simple_root_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, simple_root_expr26.getTree());
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:261:28: ( TOK_COMMA simple_root_expr )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==TOK_COMMA) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:261:29: TOK_COMMA simple_root_expr
            	    {
            	    TOK_COMMA27=(Token)input.LT(1);
            	    match(input,TOK_COMMA,FOLLOW_TOK_COMMA_in_set_list_expr1494); if (failed) return retval;
            	    pushFollow(FOLLOW_simple_root_expr_in_set_list_expr1497);
            	    simple_root_expr28=simple_root_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, simple_root_expr28.getTree());

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
    // $ANTLR end set_list_expr

    public static class shift_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start shift_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:263:1: shift_expr returns [InternalSpec ret] : f= remainder_expr (op= TOK_LSHIFT s= remainder_expr | op= TOK_RSHIFT s= remainder_expr )* ;
    public final shift_expr_return shift_expr() throws RecognitionException {
        shift_expr_return retval = new shift_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        remainder_expr_return f = null;

        remainder_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:266:9: (f= remainder_expr (op= TOK_LSHIFT s= remainder_expr | op= TOK_RSHIFT s= remainder_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:266:11: f= remainder_expr (op= TOK_LSHIFT s= remainder_expr | op= TOK_RSHIFT s= remainder_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_remainder_expr_in_shift_expr1542);
            f=remainder_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:267:9: (op= TOK_LSHIFT s= remainder_expr | op= TOK_RSHIFT s= remainder_expr )*
            loop13:
            do {
                int alt13=3;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==TOK_LSHIFT) ) {
                    alt13=1;
                }
                else if ( (LA13_0==TOK_RSHIFT) ) {
                    alt13=2;
                }


                switch (alt13) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:267:11: op= TOK_LSHIFT s= remainder_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_LSHIFT,FOLLOW_TOK_LSHIFT_in_shift_expr1558); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_remainder_expr_in_shift_expr1563);
            	    s=remainder_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_lshift(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:269:11: op= TOK_RSHIFT s= remainder_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_RSHIFT,FOLLOW_TOK_RSHIFT_in_shift_expr1587); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_remainder_expr_in_shift_expr1592);
            	    s=remainder_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_rshift(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

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
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end shift_expr

    public static class remainder_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start remainder_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:273:1: remainder_expr returns [InternalSpec ret] : f= additive_expr (op= TOK_MOD s= additive_expr )* ;
    public final remainder_expr_return remainder_expr() throws RecognitionException {
        remainder_expr_return retval = new remainder_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        additive_expr_return f = null;

        additive_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:276:9: (f= additive_expr (op= TOK_MOD s= additive_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:276:11: f= additive_expr (op= TOK_MOD s= additive_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_additive_expr_in_remainder_expr1655);
            f=additive_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:277:9: (op= TOK_MOD s= additive_expr )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==TOK_MOD) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:277:11: op= TOK_MOD s= additive_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_MOD,FOLLOW_TOK_MOD_in_remainder_expr1671); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_additive_expr_in_remainder_expr1676);
            	    s=additive_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_mod(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

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
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end remainder_expr

    public static class additive_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start additive_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:281:1: additive_expr returns [InternalSpec ret] : f= multiplicative_expr (op= TOK_PLUS s= multiplicative_expr | op= TOK_MINUS s= multiplicative_expr )* ;
    public final additive_expr_return additive_expr() throws RecognitionException {
        additive_expr_return retval = new additive_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        multiplicative_expr_return f = null;

        multiplicative_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:284:9: (f= multiplicative_expr (op= TOK_PLUS s= multiplicative_expr | op= TOK_MINUS s= multiplicative_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:284:11: f= multiplicative_expr (op= TOK_PLUS s= multiplicative_expr | op= TOK_MINUS s= multiplicative_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_multiplicative_expr_in_additive_expr1739);
            f=multiplicative_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:285:9: (op= TOK_PLUS s= multiplicative_expr | op= TOK_MINUS s= multiplicative_expr )*
            loop15:
            do {
                int alt15=3;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==TOK_PLUS) ) {
                    alt15=1;
                }
                else if ( (LA15_0==TOK_MINUS) ) {
                    alt15=2;
                }


                switch (alt15) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:285:11: op= TOK_PLUS s= multiplicative_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_PLUS,FOLLOW_TOK_PLUS_in_additive_expr1755); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_multiplicative_expr_in_additive_expr1760);
            	    s=multiplicative_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_plus(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:287:11: op= TOK_MINUS s= multiplicative_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_MINUS,FOLLOW_TOK_MINUS_in_additive_expr1784); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_multiplicative_expr_in_additive_expr1789);
            	    s=multiplicative_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_minus(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

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
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end additive_expr

    public static class multiplicative_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start multiplicative_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:291:1: multiplicative_expr returns [InternalSpec ret] : f= concatination_expr (op= TOK_TIMES s= concatination_expr | op= TOK_DIVIDE s= concatination_expr )* ;
    public final multiplicative_expr_return multiplicative_expr() throws RecognitionException {
        multiplicative_expr_return retval = new multiplicative_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        concatination_expr_return f = null;

        concatination_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:294:9: (f= concatination_expr (op= TOK_TIMES s= concatination_expr | op= TOK_DIVIDE s= concatination_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:294:11: f= concatination_expr (op= TOK_TIMES s= concatination_expr | op= TOK_DIVIDE s= concatination_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_concatination_expr_in_multiplicative_expr1851);
            f=concatination_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:295:9: (op= TOK_TIMES s= concatination_expr | op= TOK_DIVIDE s= concatination_expr )*
            loop16:
            do {
                int alt16=3;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==TOK_TIMES) ) {
                    alt16=1;
                }
                else if ( (LA16_0==TOK_DIVIDE) ) {
                    alt16=2;
                }


                switch (alt16) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:295:11: op= TOK_TIMES s= concatination_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_TIMES,FOLLOW_TOK_TIMES_in_multiplicative_expr1867); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_concatination_expr_in_multiplicative_expr1872);
            	    s=concatination_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_times(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:297:11: op= TOK_DIVIDE s= concatination_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_DIVIDE,FOLLOW_TOK_DIVIDE_in_multiplicative_expr1896); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_concatination_expr_in_multiplicative_expr1901);
            	    s=concatination_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_divide(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

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
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end multiplicative_expr

    public static class concatination_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start concatination_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:301:1: concatination_expr returns [InternalSpec ret] : f= primary_expr (op= TOK_CONCATENATION s= primary_expr )* ;
    public final concatination_expr_return concatination_expr() throws RecognitionException {
        concatination_expr_return retval = new concatination_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        primary_expr_return f = null;

        primary_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:304:9: (f= primary_expr (op= TOK_CONCATENATION s= primary_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:304:11: f= primary_expr (op= TOK_CONCATENATION s= primary_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_primary_expr_in_concatination_expr1963);
            f=primary_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:305:9: (op= TOK_CONCATENATION s= primary_expr )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==TOK_CONCATENATION) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:305:11: op= TOK_CONCATENATION s= primary_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_CONCATENATION,FOLLOW_TOK_CONCATENATION_in_concatination_expr1979); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_primary_expr_in_concatination_expr1984);
            	    s=primary_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += op.getText() + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_concatenation(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end concatination_expr

    public static class primary_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start primary_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:310:1: primary_expr returns [InternalSpec ret] : ( primary_expr_helper1 | op= TOK_MINUS v= primary_expr -> ^( TOK_UNARY_MINUS_T primary_expr ) | op= TOK_NOT v= primary_expr -> ^( TOK_NOT primary_expr ) );
    public final primary_expr_return primary_expr() throws RecognitionException {
        primary_expr_return retval = new primary_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        primary_expr_return v = null;

        primary_expr_helper1_return primary_expr_helper129 = null;


        Object op_tree=null;
        RewriteRuleTokenStream stream_TOK_MINUS=new RewriteRuleTokenStream(adaptor,"token TOK_MINUS");
        RewriteRuleTokenStream stream_TOK_NOT=new RewriteRuleTokenStream(adaptor,"token TOK_NOT");
        RewriteRuleSubtreeStream stream_primary_expr=new RewriteRuleSubtreeStream(adaptor,"rule primary_expr");
        boolean append_end = false; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:313:9: ( primary_expr_helper1 | op= TOK_MINUS v= primary_expr -> ^( TOK_UNARY_MINUS_T primary_expr ) | op= TOK_NOT v= primary_expr -> ^( TOK_NOT primary_expr ) )
            int alt18=3;
            switch ( input.LA(1) ) {
            case TOK_PLUS:
            case TOK_LP:
            case TOK_BOOL:
            case TOK_WORD1:
            case TOK_NEXT:
            case TOK_CASE:
            case TOK_WAREAD:
            case TOK_WAWRITE:
            case TOK_ATOM:
            case TOK_NUMBER:
            case TOK_NUMBER_WORD:
            case TOK_FALSEEXP:
            case TOK_TRUEEXP:
                {
                alt18=1;
                }
                break;
            case TOK_MINUS:
                {
                alt18=2;
                }
                break;
            case TOK_NOT:
                {
                alt18=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("310:1: primary_expr returns [InternalSpec ret] : ( primary_expr_helper1 | op= TOK_MINUS v= primary_expr -> ^( TOK_UNARY_MINUS_T primary_expr ) | op= TOK_NOT v= primary_expr -> ^( TOK_NOT primary_expr ) );", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:313:11: primary_expr_helper1
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_primary_expr_helper1_in_primary_expr2054);
                    primary_expr_helper129=primary_expr_helper1();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, primary_expr_helper129.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) retval.ret = primary_expr_helper129.ret; 
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:317:11: op= TOK_MINUS v= primary_expr
                    {
                    op=(Token)input.LT(1);
                    match(input,TOK_MINUS,FOLLOW_TOK_MINUS_in_primary_expr2096); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_MINUS.add(op);

                    pushFollow(FOLLOW_primary_expr_in_primary_expr2100);
                    v=primary_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr.add(v.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_unary_minus(input, ((Token)retval.start), op.getText() + " " + input.toString(v.start,v.stop), v.ret); 
                    }

                    // AST REWRITE
                    // elements: primary_expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 319:9: -> ^( TOK_UNARY_MINUS_T primary_expr )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:319:12: ^( TOK_UNARY_MINUS_T primary_expr )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(TOK_UNARY_MINUS_T, "TOK_UNARY_MINUS_T"), root_1);

                        adaptor.addChild(root_1, stream_primary_expr.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:320:11: op= TOK_NOT v= primary_expr
                    {
                    op=(Token)input.LT(1);
                    match(input,TOK_NOT,FOLLOW_TOK_NOT_in_primary_expr2140); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_NOT.add(op);

                    pushFollow(FOLLOW_primary_expr_in_primary_expr2144);
                    v=primary_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr.add(v.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_not(input, ((Token)retval.start), op.getText() + " " + input.toString(v.start,v.stop), v.ret); 
                    }

                    // AST REWRITE
                    // elements: TOK_NOT, primary_expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 322:9: -> ^( TOK_NOT primary_expr )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:322:12: ^( TOK_NOT primary_expr )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_TOK_NOT.next(), root_1);

                        adaptor.addChild(root_1, stream_primary_expr.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end primary_expr

    public static class primary_expr_helper1_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start primary_expr_helper1
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:325:1: primary_expr_helper1 returns [InternalSpec ret] : ( constant primary_expr_select -> ^( VALUE_T constant NOP primary_expr_select ) | primary_expr_helper1_pointer1 | TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( BLOCK_T simple_root_expr NOP primary_expr_select ) | TOK_BOOL TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_BOOL simple_root_expr NOP primary_expr_select ) | TOK_WORD1 TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WORD1 simple_root_expr NOP primary_expr_select ) | TOK_NEXT TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_NEXT simple_root_expr NOP primary_expr_select ) | TOK_CASE case_element_list_expr TOK_ESAC primary_expr_select -> ^( CASE_LIST_EXPR_T case_element_list_expr NOP primary_expr_select ) | TOK_WAREAD TOK_LP simple_root_expr TOK_COMMA simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WAREAD simple_root_expr simple_root_expr NOP primary_expr_select ) | TOK_WAWRITE TOK_LP simple_root_expr TOK_COMMA simple_root_expr TOK_COMMA simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WAWRITE simple_root_expr simple_root_expr simple_root_expr NOP primary_expr_select ) );
    public final primary_expr_helper1_return primary_expr_helper1() throws RecognitionException {
        primary_expr_helper1_return retval = new primary_expr_helper1_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TOK_LP33=null;
        Token TOK_RP35=null;
        Token TOK_BOOL37=null;
        Token TOK_LP38=null;
        Token TOK_RP40=null;
        Token TOK_WORD142=null;
        Token TOK_LP43=null;
        Token TOK_RP45=null;
        Token TOK_NEXT47=null;
        Token TOK_LP48=null;
        Token TOK_RP50=null;
        Token TOK_CASE52=null;
        Token TOK_ESAC54=null;
        Token TOK_WAREAD56=null;
        Token TOK_LP57=null;
        Token TOK_COMMA59=null;
        Token TOK_RP61=null;
        Token TOK_WAWRITE63=null;
        Token TOK_LP64=null;
        Token TOK_COMMA66=null;
        Token TOK_COMMA68=null;
        Token TOK_RP70=null;
        constant_return constant30 = null;

        primary_expr_select_return primary_expr_select31 = null;

        primary_expr_helper1_pointer1_return primary_expr_helper1_pointer132 = null;

        simple_root_expr_return simple_root_expr34 = null;

        primary_expr_select_return primary_expr_select36 = null;

        simple_root_expr_return simple_root_expr39 = null;

        primary_expr_select_return primary_expr_select41 = null;

        simple_root_expr_return simple_root_expr44 = null;

        primary_expr_select_return primary_expr_select46 = null;

        simple_root_expr_return simple_root_expr49 = null;

        primary_expr_select_return primary_expr_select51 = null;

        case_element_list_expr_return case_element_list_expr53 = null;

        primary_expr_select_return primary_expr_select55 = null;

        simple_root_expr_return simple_root_expr58 = null;

        simple_root_expr_return simple_root_expr60 = null;

        primary_expr_select_return primary_expr_select62 = null;

        simple_root_expr_return simple_root_expr65 = null;

        simple_root_expr_return simple_root_expr67 = null;

        simple_root_expr_return simple_root_expr69 = null;

        primary_expr_select_return primary_expr_select71 = null;


        Object TOK_LP33_tree=null;
        Object TOK_RP35_tree=null;
        Object TOK_BOOL37_tree=null;
        Object TOK_LP38_tree=null;
        Object TOK_RP40_tree=null;
        Object TOK_WORD142_tree=null;
        Object TOK_LP43_tree=null;
        Object TOK_RP45_tree=null;
        Object TOK_NEXT47_tree=null;
        Object TOK_LP48_tree=null;
        Object TOK_RP50_tree=null;
        Object TOK_CASE52_tree=null;
        Object TOK_ESAC54_tree=null;
        Object TOK_WAREAD56_tree=null;
        Object TOK_LP57_tree=null;
        Object TOK_COMMA59_tree=null;
        Object TOK_RP61_tree=null;
        Object TOK_WAWRITE63_tree=null;
        Object TOK_LP64_tree=null;
        Object TOK_COMMA66_tree=null;
        Object TOK_COMMA68_tree=null;
        Object TOK_RP70_tree=null;
        RewriteRuleTokenStream stream_TOK_LP=new RewriteRuleTokenStream(adaptor,"token TOK_LP");
        RewriteRuleTokenStream stream_TOK_BOOL=new RewriteRuleTokenStream(adaptor,"token TOK_BOOL");
        RewriteRuleTokenStream stream_TOK_WAWRITE=new RewriteRuleTokenStream(adaptor,"token TOK_WAWRITE");
        RewriteRuleTokenStream stream_TOK_WAREAD=new RewriteRuleTokenStream(adaptor,"token TOK_WAREAD");
        RewriteRuleTokenStream stream_TOK_WORD1=new RewriteRuleTokenStream(adaptor,"token TOK_WORD1");
        RewriteRuleTokenStream stream_TOK_RP=new RewriteRuleTokenStream(adaptor,"token TOK_RP");
        RewriteRuleTokenStream stream_TOK_CASE=new RewriteRuleTokenStream(adaptor,"token TOK_CASE");
        RewriteRuleTokenStream stream_TOK_ESAC=new RewriteRuleTokenStream(adaptor,"token TOK_ESAC");
        RewriteRuleTokenStream stream_TOK_NEXT=new RewriteRuleTokenStream(adaptor,"token TOK_NEXT");
        RewriteRuleTokenStream stream_TOK_COMMA=new RewriteRuleTokenStream(adaptor,"token TOK_COMMA");
        RewriteRuleSubtreeStream stream_case_element_list_expr=new RewriteRuleSubtreeStream(adaptor,"rule case_element_list_expr");
        RewriteRuleSubtreeStream stream_constant=new RewriteRuleSubtreeStream(adaptor,"rule constant");
        RewriteRuleSubtreeStream stream_simple_root_expr=new RewriteRuleSubtreeStream(adaptor,"rule simple_root_expr");
        RewriteRuleSubtreeStream stream_primary_expr_select=new RewriteRuleSubtreeStream(adaptor,"rule primary_expr_select");
        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:328:9: ( constant primary_expr_select -> ^( VALUE_T constant NOP primary_expr_select ) | primary_expr_helper1_pointer1 | TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( BLOCK_T simple_root_expr NOP primary_expr_select ) | TOK_BOOL TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_BOOL simple_root_expr NOP primary_expr_select ) | TOK_WORD1 TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WORD1 simple_root_expr NOP primary_expr_select ) | TOK_NEXT TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_NEXT simple_root_expr NOP primary_expr_select ) | TOK_CASE case_element_list_expr TOK_ESAC primary_expr_select -> ^( CASE_LIST_EXPR_T case_element_list_expr NOP primary_expr_select ) | TOK_WAREAD TOK_LP simple_root_expr TOK_COMMA simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WAREAD simple_root_expr simple_root_expr NOP primary_expr_select ) | TOK_WAWRITE TOK_LP simple_root_expr TOK_COMMA simple_root_expr TOK_COMMA simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WAWRITE simple_root_expr simple_root_expr simple_root_expr NOP primary_expr_select ) )
            int alt19=9;
            switch ( input.LA(1) ) {
            case TOK_PLUS:
            case TOK_NUMBER:
            case TOK_NUMBER_WORD:
            case TOK_FALSEEXP:
            case TOK_TRUEEXP:
                {
                alt19=1;
                }
                break;
            case TOK_ATOM:
                {
                alt19=2;
                }
                break;
            case TOK_LP:
                {
                alt19=3;
                }
                break;
            case TOK_BOOL:
                {
                alt19=4;
                }
                break;
            case TOK_WORD1:
                {
                alt19=5;
                }
                break;
            case TOK_NEXT:
                {
                alt19=6;
                }
                break;
            case TOK_CASE:
                {
                alt19=7;
                }
                break;
            case TOK_WAREAD:
                {
                alt19=8;
                }
                break;
            case TOK_WAWRITE:
                {
                alt19=9;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("325:1: primary_expr_helper1 returns [InternalSpec ret] : ( constant primary_expr_select -> ^( VALUE_T constant NOP primary_expr_select ) | primary_expr_helper1_pointer1 | TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( BLOCK_T simple_root_expr NOP primary_expr_select ) | TOK_BOOL TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_BOOL simple_root_expr NOP primary_expr_select ) | TOK_WORD1 TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WORD1 simple_root_expr NOP primary_expr_select ) | TOK_NEXT TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_NEXT simple_root_expr NOP primary_expr_select ) | TOK_CASE case_element_list_expr TOK_ESAC primary_expr_select -> ^( CASE_LIST_EXPR_T case_element_list_expr NOP primary_expr_select ) | TOK_WAREAD TOK_LP simple_root_expr TOK_COMMA simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WAREAD simple_root_expr simple_root_expr NOP primary_expr_select ) | TOK_WAWRITE TOK_LP simple_root_expr TOK_COMMA simple_root_expr TOK_COMMA simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WAWRITE simple_root_expr simple_root_expr simple_root_expr NOP primary_expr_select ) );", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:328:11: constant primary_expr_select
                    {
                    pushFollow(FOLLOW_constant_in_primary_expr_helper12209);
                    constant30=constant();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_constant.add(constant30.getTree());
                    pushFollow(FOLLOW_primary_expr_select_in_primary_expr_helper12211);
                    primary_expr_select31=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select31.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    // AST REWRITE
                    // elements: primary_expr_select, constant
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 330:9: -> ^( VALUE_T constant NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:330:12: ^( VALUE_T constant NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(VALUE_T, "VALUE_T"), root_1);

                        adaptor.addChild(root_1, stream_constant.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:331:11: primary_expr_helper1_pointer1
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_primary_expr_helper1_pointer1_in_primary_expr_helper12253);
                    primary_expr_helper1_pointer132=primary_expr_helper1_pointer1();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, primary_expr_helper1_pointer132.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:336:11: TOK_LP simple_root_expr TOK_RP primary_expr_select
                    {
                    TOK_LP33=(Token)input.LT(1);
                    match(input,TOK_LP,FOLLOW_TOK_LP_in_primary_expr_helper12286); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_LP.add(TOK_LP33);

                    pushFollow(FOLLOW_simple_root_expr_in_primary_expr_helper12288);
                    simple_root_expr34=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(simple_root_expr34.getTree());
                    TOK_RP35=(Token)input.LT(1);
                    match(input,TOK_RP,FOLLOW_TOK_RP_in_primary_expr_helper12290); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_RP.add(TOK_RP35);

                    pushFollow(FOLLOW_primary_expr_select_in_primary_expr_helper12292);
                    primary_expr_select36=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select36.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    // AST REWRITE
                    // elements: primary_expr_select, simple_root_expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 338:9: -> ^( BLOCK_T simple_root_expr NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:338:12: ^( BLOCK_T simple_root_expr NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(BLOCK_T, "BLOCK_T"), root_1);

                        adaptor.addChild(root_1, stream_simple_root_expr.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 4 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:339:11: TOK_BOOL TOK_LP simple_root_expr TOK_RP primary_expr_select
                    {
                    TOK_BOOL37=(Token)input.LT(1);
                    match(input,TOK_BOOL,FOLLOW_TOK_BOOL_in_primary_expr_helper12334); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_BOOL.add(TOK_BOOL37);

                    TOK_LP38=(Token)input.LT(1);
                    match(input,TOK_LP,FOLLOW_TOK_LP_in_primary_expr_helper12337); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_LP.add(TOK_LP38);

                    pushFollow(FOLLOW_simple_root_expr_in_primary_expr_helper12339);
                    simple_root_expr39=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(simple_root_expr39.getTree());
                    TOK_RP40=(Token)input.LT(1);
                    match(input,TOK_RP,FOLLOW_TOK_RP_in_primary_expr_helper12341); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_RP.add(TOK_RP40);

                    pushFollow(FOLLOW_primary_expr_select_in_primary_expr_helper12343);
                    primary_expr_select41=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select41.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    // AST REWRITE
                    // elements: simple_root_expr, primary_expr_select, TOK_BOOL
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 341:9: -> ^( TOK_BOOL simple_root_expr NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:341:12: ^( TOK_BOOL simple_root_expr NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_TOK_BOOL.next(), root_1);

                        adaptor.addChild(root_1, stream_simple_root_expr.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 5 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:342:11: TOK_WORD1 TOK_LP simple_root_expr TOK_RP primary_expr_select
                    {
                    TOK_WORD142=(Token)input.LT(1);
                    match(input,TOK_WORD1,FOLLOW_TOK_WORD1_in_primary_expr_helper12386); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_WORD1.add(TOK_WORD142);

                    TOK_LP43=(Token)input.LT(1);
                    match(input,TOK_LP,FOLLOW_TOK_LP_in_primary_expr_helper12388); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_LP.add(TOK_LP43);

                    pushFollow(FOLLOW_simple_root_expr_in_primary_expr_helper12390);
                    simple_root_expr44=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(simple_root_expr44.getTree());
                    TOK_RP45=(Token)input.LT(1);
                    match(input,TOK_RP,FOLLOW_TOK_RP_in_primary_expr_helper12392); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_RP.add(TOK_RP45);

                    pushFollow(FOLLOW_primary_expr_select_in_primary_expr_helper12394);
                    primary_expr_select46=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select46.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    // AST REWRITE
                    // elements: TOK_WORD1, primary_expr_select, simple_root_expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 344:9: -> ^( TOK_WORD1 simple_root_expr NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:344:12: ^( TOK_WORD1 simple_root_expr NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_TOK_WORD1.next(), root_1);

                        adaptor.addChild(root_1, stream_simple_root_expr.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 6 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:345:11: TOK_NEXT TOK_LP simple_root_expr TOK_RP primary_expr_select
                    {
                    TOK_NEXT47=(Token)input.LT(1);
                    match(input,TOK_NEXT,FOLLOW_TOK_NEXT_in_primary_expr_helper12436); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_NEXT.add(TOK_NEXT47);

                    TOK_LP48=(Token)input.LT(1);
                    match(input,TOK_LP,FOLLOW_TOK_LP_in_primary_expr_helper12438); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_LP.add(TOK_LP48);

                    pushFollow(FOLLOW_simple_root_expr_in_primary_expr_helper12440);
                    simple_root_expr49=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(simple_root_expr49.getTree());
                    TOK_RP50=(Token)input.LT(1);
                    match(input,TOK_RP,FOLLOW_TOK_RP_in_primary_expr_helper12442); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_RP.add(TOK_RP50);

                    pushFollow(FOLLOW_primary_expr_select_in_primary_expr_helper12444);
                    primary_expr_select51=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select51.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    // AST REWRITE
                    // elements: TOK_NEXT, simple_root_expr, primary_expr_select
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 347:9: -> ^( TOK_NEXT simple_root_expr NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:347:12: ^( TOK_NEXT simple_root_expr NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_TOK_NEXT.next(), root_1);

                        adaptor.addChild(root_1, stream_simple_root_expr.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 7 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:348:11: TOK_CASE case_element_list_expr TOK_ESAC primary_expr_select
                    {
                    TOK_CASE52=(Token)input.LT(1);
                    match(input,TOK_CASE,FOLLOW_TOK_CASE_in_primary_expr_helper12486); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_CASE.add(TOK_CASE52);

                    pushFollow(FOLLOW_case_element_list_expr_in_primary_expr_helper12488);
                    case_element_list_expr53=case_element_list_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_case_element_list_expr.add(case_element_list_expr53.getTree());
                    TOK_ESAC54=(Token)input.LT(1);
                    match(input,TOK_ESAC,FOLLOW_TOK_ESAC_in_primary_expr_helper12490); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_ESAC.add(TOK_ESAC54);

                    pushFollow(FOLLOW_primary_expr_select_in_primary_expr_helper12492);
                    primary_expr_select55=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select55.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    // AST REWRITE
                    // elements: case_element_list_expr, primary_expr_select
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 350:9: -> ^( CASE_LIST_EXPR_T case_element_list_expr NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:350:12: ^( CASE_LIST_EXPR_T case_element_list_expr NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(CASE_LIST_EXPR_T, "CASE_LIST_EXPR_T"), root_1);

                        adaptor.addChild(root_1, stream_case_element_list_expr.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 8 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:351:11: TOK_WAREAD TOK_LP simple_root_expr TOK_COMMA simple_root_expr TOK_RP primary_expr_select
                    {
                    TOK_WAREAD56=(Token)input.LT(1);
                    match(input,TOK_WAREAD,FOLLOW_TOK_WAREAD_in_primary_expr_helper12534); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_WAREAD.add(TOK_WAREAD56);

                    TOK_LP57=(Token)input.LT(1);
                    match(input,TOK_LP,FOLLOW_TOK_LP_in_primary_expr_helper12536); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_LP.add(TOK_LP57);

                    pushFollow(FOLLOW_simple_root_expr_in_primary_expr_helper12538);
                    simple_root_expr58=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(simple_root_expr58.getTree());
                    TOK_COMMA59=(Token)input.LT(1);
                    match(input,TOK_COMMA,FOLLOW_TOK_COMMA_in_primary_expr_helper12540); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_COMMA.add(TOK_COMMA59);

                    pushFollow(FOLLOW_simple_root_expr_in_primary_expr_helper12542);
                    simple_root_expr60=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(simple_root_expr60.getTree());
                    TOK_RP61=(Token)input.LT(1);
                    match(input,TOK_RP,FOLLOW_TOK_RP_in_primary_expr_helper12544); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_RP.add(TOK_RP61);

                    pushFollow(FOLLOW_primary_expr_select_in_primary_expr_helper12546);
                    primary_expr_select62=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select62.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    // AST REWRITE
                    // elements: simple_root_expr, primary_expr_select, simple_root_expr, TOK_WAREAD
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 353:9: -> ^( TOK_WAREAD simple_root_expr simple_root_expr NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:353:12: ^( TOK_WAREAD simple_root_expr simple_root_expr NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_TOK_WAREAD.next(), root_1);

                        adaptor.addChild(root_1, stream_simple_root_expr.next());
                        adaptor.addChild(root_1, stream_simple_root_expr.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 9 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:354:11: TOK_WAWRITE TOK_LP simple_root_expr TOK_COMMA simple_root_expr TOK_COMMA simple_root_expr TOK_RP primary_expr_select
                    {
                    TOK_WAWRITE63=(Token)input.LT(1);
                    match(input,TOK_WAWRITE,FOLLOW_TOK_WAWRITE_in_primary_expr_helper12590); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_WAWRITE.add(TOK_WAWRITE63);

                    TOK_LP64=(Token)input.LT(1);
                    match(input,TOK_LP,FOLLOW_TOK_LP_in_primary_expr_helper12592); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_LP.add(TOK_LP64);

                    pushFollow(FOLLOW_simple_root_expr_in_primary_expr_helper12594);
                    simple_root_expr65=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(simple_root_expr65.getTree());
                    TOK_COMMA66=(Token)input.LT(1);
                    match(input,TOK_COMMA,FOLLOW_TOK_COMMA_in_primary_expr_helper12596); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_COMMA.add(TOK_COMMA66);

                    pushFollow(FOLLOW_simple_root_expr_in_primary_expr_helper12598);
                    simple_root_expr67=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(simple_root_expr67.getTree());
                    TOK_COMMA68=(Token)input.LT(1);
                    match(input,TOK_COMMA,FOLLOW_TOK_COMMA_in_primary_expr_helper12600); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_COMMA.add(TOK_COMMA68);

                    pushFollow(FOLLOW_simple_root_expr_in_primary_expr_helper12602);
                    simple_root_expr69=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(simple_root_expr69.getTree());
                    TOK_RP70=(Token)input.LT(1);
                    match(input,TOK_RP,FOLLOW_TOK_RP_in_primary_expr_helper12604); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_RP.add(TOK_RP70);

                    pushFollow(FOLLOW_primary_expr_select_in_primary_expr_helper12606);
                    primary_expr_select71=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select71.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    // AST REWRITE
                    // elements: simple_root_expr, TOK_WAWRITE, simple_root_expr, simple_root_expr, primary_expr_select
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 356:9: -> ^( TOK_WAWRITE simple_root_expr simple_root_expr simple_root_expr NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:356:12: ^( TOK_WAWRITE simple_root_expr simple_root_expr simple_root_expr NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_TOK_WAWRITE.next(), root_1);

                        adaptor.addChild(root_1, stream_simple_root_expr.next());
                        adaptor.addChild(root_1, stream_simple_root_expr.next());
                        adaptor.addChild(root_1, stream_simple_root_expr.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end primary_expr_helper1

    public static class ctl_root_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctl_root_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:362:1: ctl_root_expr returns [InternalSpec ret] : ctl_implies_expr ;
    public final ctl_root_expr_return ctl_root_expr() throws RecognitionException {
        ctl_root_expr_return retval = new ctl_root_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ctl_implies_expr_return ctl_implies_expr72 = null;



        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:363:9: ( ctl_implies_expr )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:363:11: ctl_implies_expr
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ctl_implies_expr_in_ctl_root_expr2674);
            ctl_implies_expr72=ctl_implies_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, ctl_implies_expr72.getTree());
            if ( backtracking==0 ) {
              if(!er()) retval.ret = ctl_implies_expr72.ret; 
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
    // $ANTLR end ctl_root_expr

    public static class ctl_implies_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctl_implies_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:365:1: ctl_implies_expr returns [InternalSpec ret] : f= ctl_iff_expr (op= TOK_IMPLIES s= ctl_implies_expr )? ;
    public final ctl_implies_expr_return ctl_implies_expr() throws RecognitionException {
        ctl_implies_expr_return retval = new ctl_implies_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ctl_iff_expr_return f = null;

        ctl_implies_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:368:9: (f= ctl_iff_expr (op= TOK_IMPLIES s= ctl_implies_expr )? )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:368:11: f= ctl_iff_expr (op= TOK_IMPLIES s= ctl_implies_expr )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ctl_iff_expr_in_ctl_implies_expr2717);
            f=ctl_iff_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:369:9: (op= TOK_IMPLIES s= ctl_implies_expr )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==TOK_IMPLIES) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:369:11: op= TOK_IMPLIES s= ctl_implies_expr
                    {
                    op=(Token)input.LT(1);
                    match(input,TOK_IMPLIES,FOLLOW_TOK_IMPLIES_in_ctl_implies_expr2733); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ctl_implies_expr_in_ctl_implies_expr2738);
                    s=ctl_implies_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_imply(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctl_implies_expr

    public static class ctl_iff_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctl_iff_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:373:1: ctl_iff_expr returns [InternalSpec ret] : f= ctl_or_expr (op= TOK_IFF s= ctl_or_expr )* ;
    public final ctl_iff_expr_return ctl_iff_expr() throws RecognitionException {
        ctl_iff_expr_return retval = new ctl_iff_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ctl_or_expr_return f = null;

        ctl_or_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:376:9: (f= ctl_or_expr (op= TOK_IFF s= ctl_or_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:376:11: f= ctl_or_expr (op= TOK_IFF s= ctl_or_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ctl_or_expr_in_ctl_iff_expr2803);
            f=ctl_or_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:377:9: (op= TOK_IFF s= ctl_or_expr )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==TOK_IFF) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:377:11: op= TOK_IFF s= ctl_or_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_IFF,FOLLOW_TOK_IFF_in_ctl_iff_expr2819); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctl_or_expr_in_ctl_iff_expr2824);
            	    s=ctl_or_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_iff(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
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
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctl_iff_expr

    public static class ctl_or_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctl_or_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:381:1: ctl_or_expr returns [InternalSpec ret] : f= ctl_and_expr (op= TOK_OR s= ctl_and_expr | op= TOK_XOR s= ctl_and_expr | op= TOK_XNOR s= ctl_and_expr )* ;
    public final ctl_or_expr_return ctl_or_expr() throws RecognitionException {
        ctl_or_expr_return retval = new ctl_or_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ctl_and_expr_return f = null;

        ctl_and_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:384:9: (f= ctl_and_expr (op= TOK_OR s= ctl_and_expr | op= TOK_XOR s= ctl_and_expr | op= TOK_XNOR s= ctl_and_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:384:11: f= ctl_and_expr (op= TOK_OR s= ctl_and_expr | op= TOK_XOR s= ctl_and_expr | op= TOK_XNOR s= ctl_and_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ctl_and_expr_in_ctl_or_expr2888);
            f=ctl_and_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:385:9: (op= TOK_OR s= ctl_and_expr | op= TOK_XOR s= ctl_and_expr | op= TOK_XNOR s= ctl_and_expr )*
            loop22:
            do {
                int alt22=4;
                switch ( input.LA(1) ) {
                case TOK_OR:
                    {
                    alt22=1;
                    }
                    break;
                case TOK_XOR:
                    {
                    alt22=2;
                    }
                    break;
                case TOK_XNOR:
                    {
                    alt22=3;
                    }
                    break;

                }

                switch (alt22) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:385:11: op= TOK_OR s= ctl_and_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_OR,FOLLOW_TOK_OR_in_ctl_or_expr2904); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctl_and_expr_in_ctl_or_expr2909);
            	    s=ctl_and_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_or(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:387:11: op= TOK_XOR s= ctl_and_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_XOR,FOLLOW_TOK_XOR_in_ctl_or_expr2933); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctl_and_expr_in_ctl_or_expr2938);
            	    s=ctl_and_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_xor(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 3 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:389:11: op= TOK_XNOR s= ctl_and_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_XNOR,FOLLOW_TOK_XNOR_in_ctl_or_expr2962); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctl_and_expr_in_ctl_or_expr2967);
            	    s=ctl_and_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_xnor(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctl_or_expr

    public static class ctl_and_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctl_and_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:393:1: ctl_and_expr returns [InternalSpec ret] : f= ctl_expr (op= TOK_AND s= ctl_expr )* ;
    public final ctl_and_expr_return ctl_and_expr() throws RecognitionException {
        ctl_and_expr_return retval = new ctl_and_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ctl_expr_return f = null;

        ctl_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:396:9: (f= ctl_expr (op= TOK_AND s= ctl_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:396:11: f= ctl_expr (op= TOK_AND s= ctl_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ctl_expr_in_ctl_and_expr3030);
            f=ctl_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:397:9: (op= TOK_AND s= ctl_expr )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==TOK_AND) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:397:11: op= TOK_AND s= ctl_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_AND,FOLLOW_TOK_AND_in_ctl_and_expr3046); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctl_expr_in_ctl_and_expr3051);
            	    s=ctl_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_and(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctl_and_expr

    public static class ctl_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctl_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:401:1: ctl_expr returns [InternalSpec ret] : ( ( ( TOK_NOT )* ( TOK_EX | TOK_AX | TOK_EF | TOK_AF | TOK_EG | TOK_AG | TOK_AA | TOK_EE | TOK_EBF | TOK_ABF | TOK_EBG | TOK_ABG ) )=> pure_ctl_expr -> ^( PURE_CTL_T pure_ctl_expr ) | ctl_relational_expr );
    public final ctl_expr_return ctl_expr() throws RecognitionException {
        ctl_expr_return retval = new ctl_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        pure_ctl_expr_return pure_ctl_expr73 = null;

        ctl_relational_expr_return ctl_relational_expr74 = null;


        RewriteRuleSubtreeStream stream_pure_ctl_expr=new RewriteRuleSubtreeStream(adaptor,"rule pure_ctl_expr");
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:402:9: ( ( ( TOK_NOT )* ( TOK_EX | TOK_AX | TOK_EF | TOK_AF | TOK_EG | TOK_AG | TOK_AA | TOK_EE | TOK_EBF | TOK_ABF | TOK_EBG | TOK_ABG ) )=> pure_ctl_expr -> ^( PURE_CTL_T pure_ctl_expr ) | ctl_relational_expr )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==TOK_EX) && (synpred1())) {
                alt24=1;
            }
            else if ( (LA24_0==TOK_AX) && (synpred1())) {
                alt24=1;
            }
            else if ( (LA24_0==TOK_EF) && (synpred1())) {
                alt24=1;
            }
            else if ( (LA24_0==TOK_AF) && (synpred1())) {
                alt24=1;
            }
            else if ( (LA24_0==TOK_EG) && (synpred1())) {
                alt24=1;
            }
            else if ( (LA24_0==TOK_AG) && (synpred1())) {
                alt24=1;
            }
            else if ( (LA24_0==TOK_AA) && (synpred1())) {
                alt24=1;
            }
            else if ( (LA24_0==TOK_EE) && (synpred1())) {
                alt24=1;
            }
            else if ( (LA24_0==TOK_EBF) && (synpred1())) {
                alt24=1;
            }
            else if ( (LA24_0==TOK_ABF) && (synpred1())) {
                alt24=1;
            }
            else if ( (LA24_0==TOK_EBG) && (synpred1())) {
                alt24=1;
            }
            else if ( (LA24_0==TOK_ABG) && (synpred1())) {
                alt24=1;
            }
            else if ( (LA24_0==TOK_NOT) ) {
                int LA24_13 = input.LA(2);

                if ( (LA24_13==TOK_EX) && (synpred1())) {
                    alt24=1;
                }
                else if ( (LA24_13==TOK_AX) && (synpred1())) {
                    alt24=1;
                }
                else if ( (LA24_13==TOK_EF) && (synpred1())) {
                    alt24=1;
                }
                else if ( (LA24_13==TOK_AF) && (synpred1())) {
                    alt24=1;
                }
                else if ( (LA24_13==TOK_EG) && (synpred1())) {
                    alt24=1;
                }
                else if ( (LA24_13==TOK_AG) && (synpred1())) {
                    alt24=1;
                }
                else if ( (LA24_13==TOK_AA) && (synpred1())) {
                    alt24=1;
                }
                else if ( (LA24_13==TOK_EE) && (synpred1())) {
                    alt24=1;
                }
                else if ( (LA24_13==TOK_EBF) && (synpred1())) {
                    alt24=1;
                }
                else if ( (LA24_13==TOK_ABF) && (synpred1())) {
                    alt24=1;
                }
                else if ( (LA24_13==TOK_EBG) && (synpred1())) {
                    alt24=1;
                }
                else if ( (LA24_13==TOK_ABG) && (synpred1())) {
                    alt24=1;
                }
                else if ( (LA24_13==TOK_NOT) ) {
                    int LA24_27 = input.LA(3);

                    if ( (synpred1()) ) {
                        alt24=1;
                    }
                    else if ( (true) ) {
                        alt24=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("401:1: ctl_expr returns [InternalSpec ret] : ( ( ( TOK_NOT )* ( TOK_EX | TOK_AX | TOK_EF | TOK_AF | TOK_EG | TOK_AG | TOK_AA | TOK_EE | TOK_EBF | TOK_ABF | TOK_EBG | TOK_ABG ) )=> pure_ctl_expr -> ^( PURE_CTL_T pure_ctl_expr ) | ctl_relational_expr );", 24, 27, input);

                        throw nvae;
                    }
                }
                else if ( ((LA24_13>=TOK_PLUS && LA24_13<=TOK_MINUS)||LA24_13==TOK_LP||(LA24_13>=TOK_BOOL && LA24_13<=TOK_CASE)||(LA24_13>=TOK_WAREAD && LA24_13<=TOK_WAWRITE)||LA24_13==TOK_ATOM||LA24_13==TOK_NUMBER||LA24_13==TOK_NUMBER_WORD||(LA24_13>=TOK_FALSEEXP && LA24_13<=TOK_TRUEEXP)) ) {
                    alt24=2;
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("401:1: ctl_expr returns [InternalSpec ret] : ( ( ( TOK_NOT )* ( TOK_EX | TOK_AX | TOK_EF | TOK_AF | TOK_EG | TOK_AG | TOK_AA | TOK_EE | TOK_EBF | TOK_ABF | TOK_EBG | TOK_ABG ) )=> pure_ctl_expr -> ^( PURE_CTL_T pure_ctl_expr ) | ctl_relational_expr );", 24, 13, input);

                    throw nvae;
                }
            }
            else if ( (LA24_0==TOK_LCB||(LA24_0>=TOK_PLUS && LA24_0<=TOK_MINUS)||LA24_0==TOK_LP||(LA24_0>=TOK_BOOL && LA24_0<=TOK_CASE)||(LA24_0>=TOK_WAREAD && LA24_0<=TOK_WAWRITE)||LA24_0==TOK_ATOM||LA24_0==TOK_NUMBER||LA24_0==TOK_NUMBER_WORD||(LA24_0>=TOK_FALSEEXP && LA24_0<=TOK_TRUEEXP)) ) {
                alt24=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("401:1: ctl_expr returns [InternalSpec ret] : ( ( ( TOK_NOT )* ( TOK_EX | TOK_AX | TOK_EF | TOK_AF | TOK_EG | TOK_AG | TOK_AA | TOK_EE | TOK_EBF | TOK_ABF | TOK_EBG | TOK_ABG ) )=> pure_ctl_expr -> ^( PURE_CTL_T pure_ctl_expr ) | ctl_relational_expr );", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:402:11: ( ( TOK_NOT )* ( TOK_EX | TOK_AX | TOK_EF | TOK_AF | TOK_EG | TOK_AG | TOK_AA | TOK_EE | TOK_EBF | TOK_ABF | TOK_EBG | TOK_ABG ) )=> pure_ctl_expr
                    {
                    pushFollow(FOLLOW_pure_ctl_expr_in_ctl_expr3279);
                    pure_ctl_expr73=pure_ctl_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_pure_ctl_expr.add(pure_ctl_expr73.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) retval.ret = pure_ctl_expr73.ret; 
                    }

                    // AST REWRITE
                    // elements: pure_ctl_expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 416:9: -> ^( PURE_CTL_T pure_ctl_expr )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:416:12: ^( PURE_CTL_T pure_ctl_expr )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(PURE_CTL_T, "PURE_CTL_T"), root_1);

                        adaptor.addChild(root_1, stream_pure_ctl_expr.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:417:11: ctl_relational_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ctl_relational_expr_in_ctl_expr3317);
                    ctl_relational_expr74=ctl_relational_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, ctl_relational_expr74.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) retval.ret = ctl_relational_expr74.ret; 
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
    // $ANTLR end ctl_expr

    public static class pure_ctl_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start pure_ctl_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:420:1: pure_ctl_expr returns [InternalSpec ret] : (op= TOK_EX f= ctl_expr | op= TOK_AX f= ctl_expr | op= TOK_EF f= ctl_expr | op= TOK_AF f= ctl_expr | op= TOK_EG f= ctl_expr | op= TOK_AG f= ctl_expr | ( TOK_AA TOK_LB ctl_root_expr TOK_UNTIL )=> ctl_au | ( TOK_AA TOK_LB ctl_root_expr TOK_BUNTIL )=> ctl_abu | ( TOK_EE TOK_LB ctl_root_expr TOK_UNTIL )=> ctl_eu | ( TOK_EE TOK_LB ctl_root_expr TOK_BUNTIL )=> ctl_ebu | op= TOK_EBF fsr= subrange s= ctl_expr | op= TOK_ABF fsr= subrange s= ctl_expr | op= TOK_EBG fsr= subrange s= ctl_expr | op= TOK_ABG fsr= subrange s= ctl_expr | op= TOK_NOT fp= pure_ctl_expr );
    public final pure_ctl_expr_return pure_ctl_expr() throws RecognitionException {
        pure_ctl_expr_return retval = new pure_ctl_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ctl_expr_return f = null;

        subrange_return fsr = null;

        ctl_expr_return s = null;

        pure_ctl_expr_return fp = null;

        ctl_au_return ctl_au75 = null;

        ctl_abu_return ctl_abu76 = null;

        ctl_eu_return ctl_eu77 = null;

        ctl_ebu_return ctl_ebu78 = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:423:9: (op= TOK_EX f= ctl_expr | op= TOK_AX f= ctl_expr | op= TOK_EF f= ctl_expr | op= TOK_AF f= ctl_expr | op= TOK_EG f= ctl_expr | op= TOK_AG f= ctl_expr | ( TOK_AA TOK_LB ctl_root_expr TOK_UNTIL )=> ctl_au | ( TOK_AA TOK_LB ctl_root_expr TOK_BUNTIL )=> ctl_abu | ( TOK_EE TOK_LB ctl_root_expr TOK_UNTIL )=> ctl_eu | ( TOK_EE TOK_LB ctl_root_expr TOK_BUNTIL )=> ctl_ebu | op= TOK_EBF fsr= subrange s= ctl_expr | op= TOK_ABF fsr= subrange s= ctl_expr | op= TOK_EBG fsr= subrange s= ctl_expr | op= TOK_ABG fsr= subrange s= ctl_expr | op= TOK_NOT fp= pure_ctl_expr )
            int alt25=15;
            switch ( input.LA(1) ) {
            case TOK_EX:
                {
                alt25=1;
                }
                break;
            case TOK_AX:
                {
                alt25=2;
                }
                break;
            case TOK_EF:
                {
                alt25=3;
                }
                break;
            case TOK_AF:
                {
                alt25=4;
                }
                break;
            case TOK_EG:
                {
                alt25=5;
                }
                break;
            case TOK_AG:
                {
                alt25=6;
                }
                break;
            case TOK_AA:
                {
                int LA25_7 = input.LA(2);

                if ( (LA25_7==TOK_LB) ) {
                    int LA25_14 = input.LA(3);

                    if ( (synpred2()) ) {
                        alt25=7;
                    }
                    else if ( (synpred3()) ) {
                        alt25=8;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("420:1: pure_ctl_expr returns [InternalSpec ret] : (op= TOK_EX f= ctl_expr | op= TOK_AX f= ctl_expr | op= TOK_EF f= ctl_expr | op= TOK_AF f= ctl_expr | op= TOK_EG f= ctl_expr | op= TOK_AG f= ctl_expr | ( TOK_AA TOK_LB ctl_root_expr TOK_UNTIL )=> ctl_au | ( TOK_AA TOK_LB ctl_root_expr TOK_BUNTIL )=> ctl_abu | ( TOK_EE TOK_LB ctl_root_expr TOK_UNTIL )=> ctl_eu | ( TOK_EE TOK_LB ctl_root_expr TOK_BUNTIL )=> ctl_ebu | op= TOK_EBF fsr= subrange s= ctl_expr | op= TOK_ABF fsr= subrange s= ctl_expr | op= TOK_EBG fsr= subrange s= ctl_expr | op= TOK_ABG fsr= subrange s= ctl_expr | op= TOK_NOT fp= pure_ctl_expr );", 25, 14, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("420:1: pure_ctl_expr returns [InternalSpec ret] : (op= TOK_EX f= ctl_expr | op= TOK_AX f= ctl_expr | op= TOK_EF f= ctl_expr | op= TOK_AF f= ctl_expr | op= TOK_EG f= ctl_expr | op= TOK_AG f= ctl_expr | ( TOK_AA TOK_LB ctl_root_expr TOK_UNTIL )=> ctl_au | ( TOK_AA TOK_LB ctl_root_expr TOK_BUNTIL )=> ctl_abu | ( TOK_EE TOK_LB ctl_root_expr TOK_UNTIL )=> ctl_eu | ( TOK_EE TOK_LB ctl_root_expr TOK_BUNTIL )=> ctl_ebu | op= TOK_EBF fsr= subrange s= ctl_expr | op= TOK_ABF fsr= subrange s= ctl_expr | op= TOK_EBG fsr= subrange s= ctl_expr | op= TOK_ABG fsr= subrange s= ctl_expr | op= TOK_NOT fp= pure_ctl_expr );", 25, 7, input);

                    throw nvae;
                }
                }
                break;
            case TOK_EE:
                {
                int LA25_8 = input.LA(2);

                if ( (LA25_8==TOK_LB) ) {
                    int LA25_15 = input.LA(3);

                    if ( (synpred4()) ) {
                        alt25=9;
                    }
                    else if ( (synpred5()) ) {
                        alt25=10;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("420:1: pure_ctl_expr returns [InternalSpec ret] : (op= TOK_EX f= ctl_expr | op= TOK_AX f= ctl_expr | op= TOK_EF f= ctl_expr | op= TOK_AF f= ctl_expr | op= TOK_EG f= ctl_expr | op= TOK_AG f= ctl_expr | ( TOK_AA TOK_LB ctl_root_expr TOK_UNTIL )=> ctl_au | ( TOK_AA TOK_LB ctl_root_expr TOK_BUNTIL )=> ctl_abu | ( TOK_EE TOK_LB ctl_root_expr TOK_UNTIL )=> ctl_eu | ( TOK_EE TOK_LB ctl_root_expr TOK_BUNTIL )=> ctl_ebu | op= TOK_EBF fsr= subrange s= ctl_expr | op= TOK_ABF fsr= subrange s= ctl_expr | op= TOK_EBG fsr= subrange s= ctl_expr | op= TOK_ABG fsr= subrange s= ctl_expr | op= TOK_NOT fp= pure_ctl_expr );", 25, 15, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("420:1: pure_ctl_expr returns [InternalSpec ret] : (op= TOK_EX f= ctl_expr | op= TOK_AX f= ctl_expr | op= TOK_EF f= ctl_expr | op= TOK_AF f= ctl_expr | op= TOK_EG f= ctl_expr | op= TOK_AG f= ctl_expr | ( TOK_AA TOK_LB ctl_root_expr TOK_UNTIL )=> ctl_au | ( TOK_AA TOK_LB ctl_root_expr TOK_BUNTIL )=> ctl_abu | ( TOK_EE TOK_LB ctl_root_expr TOK_UNTIL )=> ctl_eu | ( TOK_EE TOK_LB ctl_root_expr TOK_BUNTIL )=> ctl_ebu | op= TOK_EBF fsr= subrange s= ctl_expr | op= TOK_ABF fsr= subrange s= ctl_expr | op= TOK_EBG fsr= subrange s= ctl_expr | op= TOK_ABG fsr= subrange s= ctl_expr | op= TOK_NOT fp= pure_ctl_expr );", 25, 8, input);

                    throw nvae;
                }
                }
                break;
            case TOK_EBF:
                {
                alt25=11;
                }
                break;
            case TOK_ABF:
                {
                alt25=12;
                }
                break;
            case TOK_EBG:
                {
                alt25=13;
                }
                break;
            case TOK_ABG:
                {
                alt25=14;
                }
                break;
            case TOK_NOT:
                {
                alt25=15;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("420:1: pure_ctl_expr returns [InternalSpec ret] : (op= TOK_EX f= ctl_expr | op= TOK_AX f= ctl_expr | op= TOK_EF f= ctl_expr | op= TOK_AF f= ctl_expr | op= TOK_EG f= ctl_expr | op= TOK_AG f= ctl_expr | ( TOK_AA TOK_LB ctl_root_expr TOK_UNTIL )=> ctl_au | ( TOK_AA TOK_LB ctl_root_expr TOK_BUNTIL )=> ctl_abu | ( TOK_EE TOK_LB ctl_root_expr TOK_UNTIL )=> ctl_eu | ( TOK_EE TOK_LB ctl_root_expr TOK_BUNTIL )=> ctl_ebu | op= TOK_EBF fsr= subrange s= ctl_expr | op= TOK_ABF fsr= subrange s= ctl_expr | op= TOK_EBG fsr= subrange s= ctl_expr | op= TOK_ABG fsr= subrange s= ctl_expr | op= TOK_NOT fp= pure_ctl_expr );", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:423:11: op= TOK_EX f= ctl_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_EX,FOLLOW_TOK_EX_in_pure_ctl_expr3369); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ctl_expr_in_pure_ctl_expr3374);
                    f=ctl_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(f.start,f.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_EX(input, ((Token)retval.start), exp_str, f.ret); 
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:425:11: op= TOK_AX f= ctl_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_AX,FOLLOW_TOK_AX_in_pure_ctl_expr3398); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ctl_expr_in_pure_ctl_expr3403);
                    f=ctl_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(f.start,f.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_AX(input, ((Token)retval.start), exp_str, f.ret); 
                    }

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:427:11: op= TOK_EF f= ctl_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_EF,FOLLOW_TOK_EF_in_pure_ctl_expr3427); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ctl_expr_in_pure_ctl_expr3432);
                    f=ctl_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(f.start,f.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_EF(input, ((Token)retval.start), exp_str, f.ret); 
                    }

                    }
                    break;
                case 4 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:429:11: op= TOK_AF f= ctl_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_AF,FOLLOW_TOK_AF_in_pure_ctl_expr3456); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ctl_expr_in_pure_ctl_expr3461);
                    f=ctl_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(f.start,f.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_AF(input, ((Token)retval.start), exp_str, f.ret); 
                    }

                    }
                    break;
                case 5 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:431:11: op= TOK_EG f= ctl_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_EG,FOLLOW_TOK_EG_in_pure_ctl_expr3485); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ctl_expr_in_pure_ctl_expr3490);
                    f=ctl_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(f.start,f.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_EG(input, ((Token)retval.start), exp_str, f.ret); 
                    }

                    }
                    break;
                case 6 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:433:11: op= TOK_AG f= ctl_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_AG,FOLLOW_TOK_AG_in_pure_ctl_expr3514); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ctl_expr_in_pure_ctl_expr3519);
                    f=ctl_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(f.start,f.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_AG(input, ((Token)retval.start), exp_str, f.ret); 
                    }

                    }
                    break;
                case 7 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:443:11: ( TOK_AA TOK_LB ctl_root_expr TOK_UNTIL )=> ctl_au
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ctl_au_in_pure_ctl_expr3625);
                    ctl_au75=ctl_au();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, ctl_au75.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) retval.ret = ctl_au75.ret; 
                    }

                    }
                    break;
                case 8 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:444:11: ( TOK_AA TOK_LB ctl_root_expr TOK_BUNTIL )=> ctl_abu
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ctl_abu_in_pure_ctl_expr3651);
                    ctl_abu76=ctl_abu();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, ctl_abu76.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) retval.ret = ctl_abu76.ret; 
                    }

                    }
                    break;
                case 9 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:445:11: ( TOK_EE TOK_LB ctl_root_expr TOK_UNTIL )=> ctl_eu
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ctl_eu_in_pure_ctl_expr3677);
                    ctl_eu77=ctl_eu();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, ctl_eu77.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) retval.ret = ctl_eu77.ret; 
                    }

                    }
                    break;
                case 10 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:446:11: ( TOK_EE TOK_LB ctl_root_expr TOK_BUNTIL )=> ctl_ebu
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ctl_ebu_in_pure_ctl_expr3703);
                    ctl_ebu78=ctl_ebu();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, ctl_ebu78.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) retval.ret = ctl_ebu78.ret; 
                    }

                    }
                    break;
                case 11 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:447:11: op= TOK_EBF fsr= subrange s= ctl_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_EBF,FOLLOW_TOK_EBF_in_pure_ctl_expr3719); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_subrange_in_pure_ctl_expr3724);
                    fsr=subrange();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, fsr.getTree());
                    pushFollow(FOLLOW_ctl_expr_in_pure_ctl_expr3728);
                    s=ctl_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(fsr.start,fsr.stop) + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_EBF(input, ((Token)retval.start), exp_str, fsr.ret, s.ret); 
                    }

                    }
                    break;
                case 12 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:449:11: op= TOK_ABF fsr= subrange s= ctl_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_ABF,FOLLOW_TOK_ABF_in_pure_ctl_expr3752); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_subrange_in_pure_ctl_expr3757);
                    fsr=subrange();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, fsr.getTree());
                    pushFollow(FOLLOW_ctl_expr_in_pure_ctl_expr3761);
                    s=ctl_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(fsr.start,fsr.stop) + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ABF(input, ((Token)retval.start), exp_str, fsr.ret, s.ret); 
                    }

                    }
                    break;
                case 13 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:451:11: op= TOK_EBG fsr= subrange s= ctl_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_EBG,FOLLOW_TOK_EBG_in_pure_ctl_expr3785); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_subrange_in_pure_ctl_expr3790);
                    fsr=subrange();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, fsr.getTree());
                    pushFollow(FOLLOW_ctl_expr_in_pure_ctl_expr3794);
                    s=ctl_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(fsr.start,fsr.stop) + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_EBG(input, ((Token)retval.start), exp_str, fsr.ret, s.ret); 
                    }

                    }
                    break;
                case 14 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:453:11: op= TOK_ABG fsr= subrange s= ctl_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_ABG,FOLLOW_TOK_ABG_in_pure_ctl_expr3818); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_subrange_in_pure_ctl_expr3823);
                    fsr=subrange();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, fsr.getTree());
                    pushFollow(FOLLOW_ctl_expr_in_pure_ctl_expr3827);
                    s=ctl_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(fsr.start,fsr.stop) + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ABG(input, ((Token)retval.start), exp_str, fsr.ret, s.ret); 
                    }

                    }
                    break;
                case 15 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:456:11: op= TOK_NOT fp= pure_ctl_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_NOT,FOLLOW_TOK_NOT_in_pure_ctl_expr3861); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_pure_ctl_expr_in_pure_ctl_expr3866);
                    fp=pure_ctl_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, fp.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(fp.start,fp.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_not(input, ((Token)retval.start), exp_str, fp.ret); 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end pure_ctl_expr

    public static class ctl_au_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctl_au
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:459:1: ctl_au returns [InternalSpec ret] : op= TOK_AA lb= TOK_LB fre= ctl_root_expr opu= TOK_UNTIL sre= ctl_root_expr rb= TOK_RB ;
    public final ctl_au_return ctl_au() throws RecognitionException {
        ctl_au_return retval = new ctl_au_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        Token lb=null;
        Token opu=null;
        Token rb=null;
        ctl_root_expr_return fre = null;

        ctl_root_expr_return sre = null;


        Object op_tree=null;
        Object lb_tree=null;
        Object opu_tree=null;
        Object rb_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:462:9: (op= TOK_AA lb= TOK_LB fre= ctl_root_expr opu= TOK_UNTIL sre= ctl_root_expr rb= TOK_RB )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:462:11: op= TOK_AA lb= TOK_LB fre= ctl_root_expr opu= TOK_UNTIL sre= ctl_root_expr rb= TOK_RB
            {
            root_0 = (Object)adaptor.nil();

            op=(Token)input.LT(1);
            match(input,TOK_AA,FOLLOW_TOK_AA_in_ctl_au3920); if (failed) return retval;
            if ( backtracking==0 ) {
            op_tree = (Object)adaptor.create(op);
            root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            }
            lb=(Token)input.LT(1);
            match(input,TOK_LB,FOLLOW_TOK_LB_in_ctl_au3925); if (failed) return retval;
            pushFollow(FOLLOW_ctl_root_expr_in_ctl_au3930);
            fre=ctl_root_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, fre.getTree());
            opu=(Token)input.LT(1);
            match(input,TOK_UNTIL,FOLLOW_TOK_UNTIL_in_ctl_au3934); if (failed) return retval;
            if ( backtracking==0 ) {
            opu_tree = (Object)adaptor.create(opu);
            adaptor.addChild(root_0, opu_tree);
            }
            pushFollow(FOLLOW_ctl_root_expr_in_ctl_au3938);
            sre=ctl_root_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, sre.getTree());
            rb=(Token)input.LT(1);
            match(input,TOK_RB,FOLLOW_TOK_RB_in_ctl_au3942); if (failed) return retval;
            if ( backtracking==0 ) {
               if (!er()) exp_str = op.getText() + lb.getText() + input.toString(fre.start,fre.stop) + " " + opu.getText() + " " + input.toString(sre.start,sre.stop) + rb.getText(); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_AU(input, ((Token)retval.start), exp_str, fre.ret, sre.ret); 
            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctl_au

    public static class ctl_eu_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctl_eu
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:465:1: ctl_eu returns [InternalSpec ret] : op= TOK_EE lb= TOK_LB fre= ctl_root_expr opu= TOK_UNTIL sre= ctl_root_expr rb= TOK_RB ;
    public final ctl_eu_return ctl_eu() throws RecognitionException {
        ctl_eu_return retval = new ctl_eu_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        Token lb=null;
        Token opu=null;
        Token rb=null;
        ctl_root_expr_return fre = null;

        ctl_root_expr_return sre = null;


        Object op_tree=null;
        Object lb_tree=null;
        Object opu_tree=null;
        Object rb_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:468:9: (op= TOK_EE lb= TOK_LB fre= ctl_root_expr opu= TOK_UNTIL sre= ctl_root_expr rb= TOK_RB )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:468:11: op= TOK_EE lb= TOK_LB fre= ctl_root_expr opu= TOK_UNTIL sre= ctl_root_expr rb= TOK_RB
            {
            root_0 = (Object)adaptor.nil();

            op=(Token)input.LT(1);
            match(input,TOK_EE,FOLLOW_TOK_EE_in_ctl_eu3997); if (failed) return retval;
            if ( backtracking==0 ) {
            op_tree = (Object)adaptor.create(op);
            root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            }
            lb=(Token)input.LT(1);
            match(input,TOK_LB,FOLLOW_TOK_LB_in_ctl_eu4002); if (failed) return retval;
            pushFollow(FOLLOW_ctl_root_expr_in_ctl_eu4007);
            fre=ctl_root_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, fre.getTree());
            opu=(Token)input.LT(1);
            match(input,TOK_UNTIL,FOLLOW_TOK_UNTIL_in_ctl_eu4011); if (failed) return retval;
            if ( backtracking==0 ) {
            opu_tree = (Object)adaptor.create(opu);
            adaptor.addChild(root_0, opu_tree);
            }
            pushFollow(FOLLOW_ctl_root_expr_in_ctl_eu4015);
            sre=ctl_root_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, sre.getTree());
            rb=(Token)input.LT(1);
            match(input,TOK_RB,FOLLOW_TOK_RB_in_ctl_eu4019); if (failed) return retval;
            if ( backtracking==0 ) {
               if (!er()) exp_str = op.getText() + lb.getText() + input.toString(fre.start,fre.stop) + " " + opu.getText() + " " + input.toString(sre.start,sre.stop) + rb.getText(); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_EU(input, ((Token)retval.start), exp_str, fre.ret, sre.ret); 
            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctl_eu

    public static class ctl_abu_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctl_abu
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:471:1: ctl_abu returns [InternalSpec ret] : op= TOK_AA lb= TOK_LB fre= ctl_root_expr opu= TOK_BUNTIL msr= subrange sre= ctl_root_expr rb= TOK_RB ;
    public final ctl_abu_return ctl_abu() throws RecognitionException {
        ctl_abu_return retval = new ctl_abu_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        Token lb=null;
        Token opu=null;
        Token rb=null;
        ctl_root_expr_return fre = null;

        subrange_return msr = null;

        ctl_root_expr_return sre = null;


        Object op_tree=null;
        Object lb_tree=null;
        Object opu_tree=null;
        Object rb_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:474:9: (op= TOK_AA lb= TOK_LB fre= ctl_root_expr opu= TOK_BUNTIL msr= subrange sre= ctl_root_expr rb= TOK_RB )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:474:11: op= TOK_AA lb= TOK_LB fre= ctl_root_expr opu= TOK_BUNTIL msr= subrange sre= ctl_root_expr rb= TOK_RB
            {
            root_0 = (Object)adaptor.nil();

            op=(Token)input.LT(1);
            match(input,TOK_AA,FOLLOW_TOK_AA_in_ctl_abu4074); if (failed) return retval;
            if ( backtracking==0 ) {
            op_tree = (Object)adaptor.create(op);
            root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            }
            lb=(Token)input.LT(1);
            match(input,TOK_LB,FOLLOW_TOK_LB_in_ctl_abu4079); if (failed) return retval;
            pushFollow(FOLLOW_ctl_root_expr_in_ctl_abu4084);
            fre=ctl_root_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, fre.getTree());
            opu=(Token)input.LT(1);
            match(input,TOK_BUNTIL,FOLLOW_TOK_BUNTIL_in_ctl_abu4088); if (failed) return retval;
            if ( backtracking==0 ) {
            opu_tree = (Object)adaptor.create(opu);
            adaptor.addChild(root_0, opu_tree);
            }
            pushFollow(FOLLOW_subrange_in_ctl_abu4092);
            msr=subrange();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, msr.getTree());
            pushFollow(FOLLOW_ctl_root_expr_in_ctl_abu4096);
            sre=ctl_root_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, sre.getTree());
            rb=(Token)input.LT(1);
            match(input,TOK_RB,FOLLOW_TOK_RB_in_ctl_abu4100); if (failed) return retval;
            if ( backtracking==0 ) {
               if (!er()) exp_str = op.getText() + lb.getText() + input.toString(fre.start,fre.stop) + " " + opu.getText() + " " + input.toString(msr.start,msr.stop) + " " + input.toString(sre.start,sre.stop) + rb.getText(); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ABU(input, ((Token)retval.start), exp_str, fre.ret, msr.ret, sre.ret); 
            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctl_abu

    public static class ctl_ebu_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctl_ebu
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:477:1: ctl_ebu returns [InternalSpec ret] : op= TOK_EE lb= TOK_LB fre= ctl_root_expr opu= TOK_BUNTIL msr= subrange sre= ctl_root_expr rb= TOK_RB ;
    public final ctl_ebu_return ctl_ebu() throws RecognitionException {
        ctl_ebu_return retval = new ctl_ebu_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        Token lb=null;
        Token opu=null;
        Token rb=null;
        ctl_root_expr_return fre = null;

        subrange_return msr = null;

        ctl_root_expr_return sre = null;


        Object op_tree=null;
        Object lb_tree=null;
        Object opu_tree=null;
        Object rb_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:480:9: (op= TOK_EE lb= TOK_LB fre= ctl_root_expr opu= TOK_BUNTIL msr= subrange sre= ctl_root_expr rb= TOK_RB )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:480:11: op= TOK_EE lb= TOK_LB fre= ctl_root_expr opu= TOK_BUNTIL msr= subrange sre= ctl_root_expr rb= TOK_RB
            {
            root_0 = (Object)adaptor.nil();

            op=(Token)input.LT(1);
            match(input,TOK_EE,FOLLOW_TOK_EE_in_ctl_ebu4155); if (failed) return retval;
            if ( backtracking==0 ) {
            op_tree = (Object)adaptor.create(op);
            root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            }
            lb=(Token)input.LT(1);
            match(input,TOK_LB,FOLLOW_TOK_LB_in_ctl_ebu4160); if (failed) return retval;
            pushFollow(FOLLOW_ctl_root_expr_in_ctl_ebu4165);
            fre=ctl_root_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, fre.getTree());
            opu=(Token)input.LT(1);
            match(input,TOK_BUNTIL,FOLLOW_TOK_BUNTIL_in_ctl_ebu4169); if (failed) return retval;
            if ( backtracking==0 ) {
            opu_tree = (Object)adaptor.create(opu);
            adaptor.addChild(root_0, opu_tree);
            }
            pushFollow(FOLLOW_subrange_in_ctl_ebu4173);
            msr=subrange();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, msr.getTree());
            pushFollow(FOLLOW_ctl_root_expr_in_ctl_ebu4177);
            sre=ctl_root_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, sre.getTree());
            rb=(Token)input.LT(1);
            match(input,TOK_RB,FOLLOW_TOK_RB_in_ctl_ebu4181); if (failed) return retval;
            if ( backtracking==0 ) {
               if (!er()) exp_str = op.getText() + lb.getText() + input.toString(fre.start,fre.stop) + " " + opu.getText() + " " + input.toString(msr.start,msr.stop) + " " + input.toString(sre.start,sre.stop) + rb.getText(); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_EBU(input, ((Token)retval.start), exp_str, fre.ret, msr.ret, sre.ret); 
            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctl_ebu

    public static class ctl_relational_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctl_relational_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:484:1: ctl_relational_expr returns [InternalSpec ret] : f= ctl_in_expr (op= TOK_EQUAL s= ctl_in_expr | op= TOK_NOTEQUAL s= ctl_in_expr | op= TOK_LT s= ctl_in_expr | op= TOK_GT s= ctl_in_expr | op= TOK_LE s= ctl_in_expr | op= TOK_GE s= ctl_in_expr )* ;
    public final ctl_relational_expr_return ctl_relational_expr() throws RecognitionException {
        ctl_relational_expr_return retval = new ctl_relational_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ctl_in_expr_return f = null;

        ctl_in_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:487:9: (f= ctl_in_expr (op= TOK_EQUAL s= ctl_in_expr | op= TOK_NOTEQUAL s= ctl_in_expr | op= TOK_LT s= ctl_in_expr | op= TOK_GT s= ctl_in_expr | op= TOK_LE s= ctl_in_expr | op= TOK_GE s= ctl_in_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:487:11: f= ctl_in_expr (op= TOK_EQUAL s= ctl_in_expr | op= TOK_NOTEQUAL s= ctl_in_expr | op= TOK_LT s= ctl_in_expr | op= TOK_GT s= ctl_in_expr | op= TOK_LE s= ctl_in_expr | op= TOK_GE s= ctl_in_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ctl_in_expr_in_ctl_relational_expr4242);
            f=ctl_in_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:488:9: (op= TOK_EQUAL s= ctl_in_expr | op= TOK_NOTEQUAL s= ctl_in_expr | op= TOK_LT s= ctl_in_expr | op= TOK_GT s= ctl_in_expr | op= TOK_LE s= ctl_in_expr | op= TOK_GE s= ctl_in_expr )*
            loop26:
            do {
                int alt26=7;
                switch ( input.LA(1) ) {
                case TOK_EQUAL:
                    {
                    alt26=1;
                    }
                    break;
                case TOK_NOTEQUAL:
                    {
                    alt26=2;
                    }
                    break;
                case TOK_LT:
                    {
                    alt26=3;
                    }
                    break;
                case TOK_GT:
                    {
                    alt26=4;
                    }
                    break;
                case TOK_LE:
                    {
                    alt26=5;
                    }
                    break;
                case TOK_GE:
                    {
                    alt26=6;
                    }
                    break;

                }

                switch (alt26) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:488:11: op= TOK_EQUAL s= ctl_in_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_EQUAL,FOLLOW_TOK_EQUAL_in_ctl_relational_expr4258); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctl_in_expr_in_ctl_relational_expr4263);
            	    s=ctl_in_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_eq(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:490:11: op= TOK_NOTEQUAL s= ctl_in_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_NOTEQUAL,FOLLOW_TOK_NOTEQUAL_in_ctl_relational_expr4288); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctl_in_expr_in_ctl_relational_expr4293);
            	    s=ctl_in_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_neq(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 3 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:492:11: op= TOK_LT s= ctl_in_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_LT,FOLLOW_TOK_LT_in_ctl_relational_expr4318); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctl_in_expr_in_ctl_relational_expr4323);
            	    s=ctl_in_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_lt(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 4 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:494:11: op= TOK_GT s= ctl_in_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_GT,FOLLOW_TOK_GT_in_ctl_relational_expr4348); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctl_in_expr_in_ctl_relational_expr4353);
            	    s=ctl_in_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_gt(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 5 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:496:11: op= TOK_LE s= ctl_in_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_LE,FOLLOW_TOK_LE_in_ctl_relational_expr4378); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctl_in_expr_in_ctl_relational_expr4383);
            	    s=ctl_in_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_le(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 6 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:498:11: op= TOK_GE s= ctl_in_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_GE,FOLLOW_TOK_GE_in_ctl_relational_expr4408); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctl_in_expr_in_ctl_relational_expr4413);
            	    s=ctl_in_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ge(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctl_relational_expr

    public static class ctl_in_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctl_in_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:502:1: ctl_in_expr returns [InternalSpec ret] : f= ctl_union_expr (op= TOK_SETIN s= ctl_union_expr )* ;
    public final ctl_in_expr_return ctl_in_expr() throws RecognitionException {
        ctl_in_expr_return retval = new ctl_in_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ctl_union_expr_return f = null;

        ctl_union_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:505:9: (f= ctl_union_expr (op= TOK_SETIN s= ctl_union_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:505:11: f= ctl_union_expr (op= TOK_SETIN s= ctl_union_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ctl_union_expr_in_ctl_in_expr4477);
            f=ctl_union_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:506:9: (op= TOK_SETIN s= ctl_union_expr )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==TOK_SETIN) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:506:11: op= TOK_SETIN s= ctl_union_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_SETIN,FOLLOW_TOK_SETIN_in_ctl_in_expr4493); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctl_union_expr_in_ctl_in_expr4498);
            	    s=ctl_union_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_setin(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctl_in_expr

    public static class ctl_union_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctl_union_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:510:1: ctl_union_expr returns [InternalSpec ret] : f= ctl_set_expr (op= TOK_UNION s= ctl_set_expr )* ;
    public final ctl_union_expr_return ctl_union_expr() throws RecognitionException {
        ctl_union_expr_return retval = new ctl_union_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ctl_set_expr_return f = null;

        ctl_set_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:513:9: (f= ctl_set_expr (op= TOK_UNION s= ctl_set_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:513:11: f= ctl_set_expr (op= TOK_UNION s= ctl_set_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ctl_set_expr_in_ctl_union_expr4561);
            f=ctl_set_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:514:9: (op= TOK_UNION s= ctl_set_expr )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==TOK_UNION) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:514:11: op= TOK_UNION s= ctl_set_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_UNION,FOLLOW_TOK_UNION_in_ctl_union_expr4577); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctl_set_expr_in_ctl_union_expr4582);
            	    s=ctl_set_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_union(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctl_union_expr

    public static class ctl_set_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctl_set_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:518:1: ctl_set_expr returns [InternalSpec ret] : ( ctl_shift_expr | subrange | TOK_LCB ctl_set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T ctl_set_list_expr ) );
    public final ctl_set_expr_return ctl_set_expr() throws RecognitionException {
        ctl_set_expr_return retval = new ctl_set_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TOK_LCB81=null;
        Token TOK_RCB83=null;
        ctl_shift_expr_return ctl_shift_expr79 = null;

        subrange_return subrange80 = null;

        ctl_set_list_expr_return ctl_set_list_expr82 = null;


        Object TOK_LCB81_tree=null;
        Object TOK_RCB83_tree=null;
        RewriteRuleTokenStream stream_TOK_LCB=new RewriteRuleTokenStream(adaptor,"token TOK_LCB");
        RewriteRuleTokenStream stream_TOK_RCB=new RewriteRuleTokenStream(adaptor,"token TOK_RCB");
        RewriteRuleSubtreeStream stream_ctl_set_list_expr=new RewriteRuleSubtreeStream(adaptor,"rule ctl_set_list_expr");
        boolean append_end = false; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:521:9: ( ctl_shift_expr | subrange | TOK_LCB ctl_set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T ctl_set_list_expr ) )
            int alt29=3;
            switch ( input.LA(1) ) {
            case TOK_NOT:
            case TOK_LP:
            case TOK_BOOL:
            case TOK_WORD1:
            case TOK_NEXT:
            case TOK_CASE:
            case TOK_WAREAD:
            case TOK_WAWRITE:
            case TOK_ATOM:
            case TOK_NUMBER_WORD:
            case TOK_FALSEEXP:
            case TOK_TRUEEXP:
                {
                alt29=1;
                }
                break;
            case TOK_NUMBER:
                {
                int LA29_2 = input.LA(2);

                if ( (LA29_2==EOF||(LA29_2>=TOK_INVAR_SPEC && LA29_2<=TOK_UNION)||(LA29_2>=TOK_LSHIFT && LA29_2<=TOK_CONCATENATION)||LA29_2==TOK_RP||(LA29_2>=TOK_LB && LA29_2<=TOK_RB)||LA29_2==TOK_BUNTIL||LA29_2==TOK_DOT||LA29_2==TOK_SEMI) ) {
                    alt29=1;
                }
                else if ( (LA29_2==TOK_TWODOTS) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("518:1: ctl_set_expr returns [InternalSpec ret] : ( ctl_shift_expr | subrange | TOK_LCB ctl_set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T ctl_set_list_expr ) );", 29, 2, input);

                    throw nvae;
                }
                }
                break;
            case TOK_PLUS:
                {
                int LA29_3 = input.LA(2);

                if ( (LA29_3==TOK_NUMBER) ) {
                    int LA29_7 = input.LA(3);

                    if ( (LA29_7==TOK_TWODOTS) ) {
                        alt29=2;
                    }
                    else if ( (LA29_7==EOF||(LA29_7>=TOK_INVAR_SPEC && LA29_7<=TOK_UNION)||(LA29_7>=TOK_LSHIFT && LA29_7<=TOK_CONCATENATION)||LA29_7==TOK_RP||(LA29_7>=TOK_LB && LA29_7<=TOK_RB)||LA29_7==TOK_BUNTIL||LA29_7==TOK_DOT||LA29_7==TOK_SEMI) ) {
                        alt29=1;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("518:1: ctl_set_expr returns [InternalSpec ret] : ( ctl_shift_expr | subrange | TOK_LCB ctl_set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T ctl_set_list_expr ) );", 29, 7, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("518:1: ctl_set_expr returns [InternalSpec ret] : ( ctl_shift_expr | subrange | TOK_LCB ctl_set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T ctl_set_list_expr ) );", 29, 3, input);

                    throw nvae;
                }
                }
                break;
            case TOK_MINUS:
                {
                int LA29_4 = input.LA(2);

                if ( (LA29_4==TOK_NUMBER) ) {
                    int LA29_8 = input.LA(3);

                    if ( (LA29_8==EOF||(LA29_8>=TOK_INVAR_SPEC && LA29_8<=TOK_UNION)||(LA29_8>=TOK_LSHIFT && LA29_8<=TOK_CONCATENATION)||LA29_8==TOK_RP||(LA29_8>=TOK_LB && LA29_8<=TOK_RB)||LA29_8==TOK_BUNTIL||LA29_8==TOK_DOT||LA29_8==TOK_SEMI) ) {
                        alt29=1;
                    }
                    else if ( (LA29_8==TOK_TWODOTS) ) {
                        alt29=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("518:1: ctl_set_expr returns [InternalSpec ret] : ( ctl_shift_expr | subrange | TOK_LCB ctl_set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T ctl_set_list_expr ) );", 29, 8, input);

                        throw nvae;
                    }
                }
                else if ( ((LA29_4>=TOK_PLUS && LA29_4<=TOK_MINUS)||(LA29_4>=TOK_NOT && LA29_4<=TOK_LP)||(LA29_4>=TOK_BOOL && LA29_4<=TOK_CASE)||(LA29_4>=TOK_WAREAD && LA29_4<=TOK_WAWRITE)||LA29_4==TOK_ATOM||LA29_4==TOK_NUMBER_WORD||(LA29_4>=TOK_FALSEEXP && LA29_4<=TOK_TRUEEXP)) ) {
                    alt29=1;
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("518:1: ctl_set_expr returns [InternalSpec ret] : ( ctl_shift_expr | subrange | TOK_LCB ctl_set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T ctl_set_list_expr ) );", 29, 4, input);

                    throw nvae;
                }
                }
                break;
            case TOK_LCB:
                {
                alt29=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("518:1: ctl_set_expr returns [InternalSpec ret] : ( ctl_shift_expr | subrange | TOK_LCB ctl_set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T ctl_set_list_expr ) );", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:521:11: ctl_shift_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ctl_shift_expr_in_ctl_set_expr4643);
                    ctl_shift_expr79=ctl_shift_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, ctl_shift_expr79.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) retval.ret = ctl_shift_expr79.ret; 
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:523:11: subrange
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_subrange_in_ctl_set_expr4665);
                    subrange80=subrange();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, subrange80.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_range(input, ((Token)retval.start), input.toString(subrange80.start,subrange80.stop)); 
                    }

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:525:11: TOK_LCB ctl_set_list_expr TOK_RCB
                    {
                    TOK_LCB81=(Token)input.LT(1);
                    match(input,TOK_LCB,FOLLOW_TOK_LCB_in_ctl_set_expr4688); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_LCB.add(TOK_LCB81);

                    pushFollow(FOLLOW_ctl_set_list_expr_in_ctl_set_expr4690);
                    ctl_set_list_expr82=ctl_set_list_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_ctl_set_list_expr.add(ctl_set_list_expr82.getTree());
                    TOK_RCB83=(Token)input.LT(1);
                    match(input,TOK_RCB,FOLLOW_TOK_RCB_in_ctl_set_expr4692); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_RCB.add(TOK_RCB83);

                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_set(input, ((Token)retval.start), TOK_LCB81.getText() + " " + input.toString(ctl_set_list_expr82.start,ctl_set_list_expr82.stop) + " " + TOK_RCB83.getText()); 
                    }

                    // AST REWRITE
                    // elements: ctl_set_list_expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 527:9: -> ^( SET_LIST_EXP_T ctl_set_list_expr )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:527:12: ^( SET_LIST_EXP_T ctl_set_list_expr )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(SET_LIST_EXP_T, "SET_LIST_EXP_T"), root_1);

                        adaptor.addChild(root_1, stream_ctl_set_list_expr.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctl_set_expr

    public static class ctl_set_list_expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctl_set_list_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:529:1: ctl_set_list_expr : simple_root_expr ( TOK_COMMA simple_root_expr )* ;
    public final ctl_set_list_expr_return ctl_set_list_expr() throws RecognitionException {
        ctl_set_list_expr_return retval = new ctl_set_list_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TOK_COMMA85=null;
        simple_root_expr_return simple_root_expr84 = null;

        simple_root_expr_return simple_root_expr86 = null;


        Object TOK_COMMA85_tree=null;

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:530:9: ( simple_root_expr ( TOK_COMMA simple_root_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:530:11: simple_root_expr ( TOK_COMMA simple_root_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_simple_root_expr_in_ctl_set_list_expr4745);
            simple_root_expr84=simple_root_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, simple_root_expr84.getTree());
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:530:28: ( TOK_COMMA simple_root_expr )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==TOK_COMMA) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:530:29: TOK_COMMA simple_root_expr
            	    {
            	    TOK_COMMA85=(Token)input.LT(1);
            	    match(input,TOK_COMMA,FOLLOW_TOK_COMMA_in_ctl_set_list_expr4748); if (failed) return retval;
            	    pushFollow(FOLLOW_simple_root_expr_in_ctl_set_list_expr4751);
            	    simple_root_expr86=simple_root_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, simple_root_expr86.getTree());

            	    }
            	    break;

            	default :
            	    break loop30;
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
    // $ANTLR end ctl_set_list_expr

    public static class ctl_shift_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctl_shift_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:532:1: ctl_shift_expr returns [InternalSpec ret] : f= ctl_remainder_expr (op= TOK_LSHIFT s= ctl_remainder_expr | op= TOK_RSHIFT s= ctl_remainder_expr )* ;
    public final ctl_shift_expr_return ctl_shift_expr() throws RecognitionException {
        ctl_shift_expr_return retval = new ctl_shift_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ctl_remainder_expr_return f = null;

        ctl_remainder_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:535:9: (f= ctl_remainder_expr (op= TOK_LSHIFT s= ctl_remainder_expr | op= TOK_RSHIFT s= ctl_remainder_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:535:11: f= ctl_remainder_expr (op= TOK_LSHIFT s= ctl_remainder_expr | op= TOK_RSHIFT s= ctl_remainder_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ctl_remainder_expr_in_ctl_shift_expr4797);
            f=ctl_remainder_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:536:9: (op= TOK_LSHIFT s= ctl_remainder_expr | op= TOK_RSHIFT s= ctl_remainder_expr )*
            loop31:
            do {
                int alt31=3;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==TOK_LSHIFT) ) {
                    alt31=1;
                }
                else if ( (LA31_0==TOK_RSHIFT) ) {
                    alt31=2;
                }


                switch (alt31) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:536:11: op= TOK_LSHIFT s= ctl_remainder_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_LSHIFT,FOLLOW_TOK_LSHIFT_in_ctl_shift_expr4813); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctl_remainder_expr_in_ctl_shift_expr4818);
            	    s=ctl_remainder_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_lshift(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:538:11: op= TOK_RSHIFT s= ctl_remainder_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_RSHIFT,FOLLOW_TOK_RSHIFT_in_ctl_shift_expr4842); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctl_remainder_expr_in_ctl_shift_expr4847);
            	    s=ctl_remainder_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_rshift(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctl_shift_expr

    public static class ctl_remainder_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctl_remainder_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:542:1: ctl_remainder_expr returns [InternalSpec ret] : f= ctl_additive_expr (op= TOK_MOD s= ctl_additive_expr )* ;
    public final ctl_remainder_expr_return ctl_remainder_expr() throws RecognitionException {
        ctl_remainder_expr_return retval = new ctl_remainder_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ctl_additive_expr_return f = null;

        ctl_additive_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:545:9: (f= ctl_additive_expr (op= TOK_MOD s= ctl_additive_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:545:11: f= ctl_additive_expr (op= TOK_MOD s= ctl_additive_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ctl_additive_expr_in_ctl_remainder_expr4909);
            f=ctl_additive_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:546:9: (op= TOK_MOD s= ctl_additive_expr )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==TOK_MOD) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:546:11: op= TOK_MOD s= ctl_additive_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_MOD,FOLLOW_TOK_MOD_in_ctl_remainder_expr4925); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctl_additive_expr_in_ctl_remainder_expr4930);
            	    s=ctl_additive_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_mod(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctl_remainder_expr

    public static class ctl_additive_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctl_additive_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:552:1: ctl_additive_expr returns [InternalSpec ret] : f= ctl_multiplicative_expr (op= TOK_PLUS s= ctl_multiplicative_expr | op= TOK_MINUS s= ctl_multiplicative_expr )* ;
    public final ctl_additive_expr_return ctl_additive_expr() throws RecognitionException {
        ctl_additive_expr_return retval = new ctl_additive_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ctl_multiplicative_expr_return f = null;

        ctl_multiplicative_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:555:9: (f= ctl_multiplicative_expr (op= TOK_PLUS s= ctl_multiplicative_expr | op= TOK_MINUS s= ctl_multiplicative_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:555:11: f= ctl_multiplicative_expr (op= TOK_PLUS s= ctl_multiplicative_expr | op= TOK_MINUS s= ctl_multiplicative_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ctl_multiplicative_expr_in_ctl_additive_expr4994);
            f=ctl_multiplicative_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:556:9: (op= TOK_PLUS s= ctl_multiplicative_expr | op= TOK_MINUS s= ctl_multiplicative_expr )*
            loop33:
            do {
                int alt33=3;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==TOK_PLUS) ) {
                    alt33=1;
                }
                else if ( (LA33_0==TOK_MINUS) ) {
                    alt33=2;
                }


                switch (alt33) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:556:11: op= TOK_PLUS s= ctl_multiplicative_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_PLUS,FOLLOW_TOK_PLUS_in_ctl_additive_expr5010); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctl_multiplicative_expr_in_ctl_additive_expr5015);
            	    s=ctl_multiplicative_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_plus(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:558:11: op= TOK_MINUS s= ctl_multiplicative_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_MINUS,FOLLOW_TOK_MINUS_in_ctl_additive_expr5039); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctl_multiplicative_expr_in_ctl_additive_expr5044);
            	    s=ctl_multiplicative_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_minus(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctl_additive_expr

    public static class ctl_multiplicative_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctl_multiplicative_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:562:1: ctl_multiplicative_expr returns [InternalSpec ret] : f= ctl_concatination_expr (op= TOK_TIMES s= ctl_concatination_expr | op= TOK_DIVIDE s= ctl_concatination_expr )* ;
    public final ctl_multiplicative_expr_return ctl_multiplicative_expr() throws RecognitionException {
        ctl_multiplicative_expr_return retval = new ctl_multiplicative_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ctl_concatination_expr_return f = null;

        ctl_concatination_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:565:9: (f= ctl_concatination_expr (op= TOK_TIMES s= ctl_concatination_expr | op= TOK_DIVIDE s= ctl_concatination_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:565:11: f= ctl_concatination_expr (op= TOK_TIMES s= ctl_concatination_expr | op= TOK_DIVIDE s= ctl_concatination_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ctl_concatination_expr_in_ctl_multiplicative_expr5105);
            f=ctl_concatination_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:566:9: (op= TOK_TIMES s= ctl_concatination_expr | op= TOK_DIVIDE s= ctl_concatination_expr )*
            loop34:
            do {
                int alt34=3;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==TOK_TIMES) ) {
                    alt34=1;
                }
                else if ( (LA34_0==TOK_DIVIDE) ) {
                    alt34=2;
                }


                switch (alt34) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:566:11: op= TOK_TIMES s= ctl_concatination_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_TIMES,FOLLOW_TOK_TIMES_in_ctl_multiplicative_expr5121); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctl_concatination_expr_in_ctl_multiplicative_expr5126);
            	    s=ctl_concatination_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_times(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:568:11: op= TOK_DIVIDE s= ctl_concatination_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_DIVIDE,FOLLOW_TOK_DIVIDE_in_ctl_multiplicative_expr5150); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctl_concatination_expr_in_ctl_multiplicative_expr5155);
            	    s=ctl_concatination_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_divide(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctl_multiplicative_expr

    public static class ctl_concatination_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctl_concatination_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:572:1: ctl_concatination_expr returns [InternalSpec ret] : f= ctl_primary_expr (op= TOK_CONCATENATION s= ctl_primary_expr )* ;
    public final ctl_concatination_expr_return ctl_concatination_expr() throws RecognitionException {
        ctl_concatination_expr_return retval = new ctl_concatination_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ctl_primary_expr_return f = null;

        ctl_primary_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:575:9: (f= ctl_primary_expr (op= TOK_CONCATENATION s= ctl_primary_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:575:11: f= ctl_primary_expr (op= TOK_CONCATENATION s= ctl_primary_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ctl_primary_expr_in_ctl_concatination_expr5216);
            f=ctl_primary_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:576:9: (op= TOK_CONCATENATION s= ctl_primary_expr )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==TOK_CONCATENATION) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:576:11: op= TOK_CONCATENATION s= ctl_primary_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_CONCATENATION,FOLLOW_TOK_CONCATENATION_in_ctl_concatination_expr5232); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctl_primary_expr_in_ctl_concatination_expr5237);
            	    s=ctl_primary_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += op.getText() + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_concatenation(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctl_concatination_expr

    public static class ctl_primary_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctl_primary_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:581:1: ctl_primary_expr returns [InternalSpec ret] : ( ctl_primary_expr_helper1 | op= TOK_MINUS v= ctl_primary_expr -> ^( TOK_UNARY_MINUS_T $v) | op= TOK_NOT v= ctl_primary_expr -> ^( TOK_NOT $v) );
    public final ctl_primary_expr_return ctl_primary_expr() throws RecognitionException {
        ctl_primary_expr_return retval = new ctl_primary_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ctl_primary_expr_return v = null;

        ctl_primary_expr_helper1_return ctl_primary_expr_helper187 = null;


        Object op_tree=null;
        RewriteRuleTokenStream stream_TOK_MINUS=new RewriteRuleTokenStream(adaptor,"token TOK_MINUS");
        RewriteRuleTokenStream stream_TOK_NOT=new RewriteRuleTokenStream(adaptor,"token TOK_NOT");
        RewriteRuleSubtreeStream stream_ctl_primary_expr=new RewriteRuleSubtreeStream(adaptor,"rule ctl_primary_expr");
        boolean append_end = false; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:584:9: ( ctl_primary_expr_helper1 | op= TOK_MINUS v= ctl_primary_expr -> ^( TOK_UNARY_MINUS_T $v) | op= TOK_NOT v= ctl_primary_expr -> ^( TOK_NOT $v) )
            int alt36=3;
            switch ( input.LA(1) ) {
            case TOK_PLUS:
            case TOK_LP:
            case TOK_BOOL:
            case TOK_WORD1:
            case TOK_NEXT:
            case TOK_CASE:
            case TOK_WAREAD:
            case TOK_WAWRITE:
            case TOK_ATOM:
            case TOK_NUMBER:
            case TOK_NUMBER_WORD:
            case TOK_FALSEEXP:
            case TOK_TRUEEXP:
                {
                alt36=1;
                }
                break;
            case TOK_MINUS:
                {
                alt36=2;
                }
                break;
            case TOK_NOT:
                {
                alt36=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("581:1: ctl_primary_expr returns [InternalSpec ret] : ( ctl_primary_expr_helper1 | op= TOK_MINUS v= ctl_primary_expr -> ^( TOK_UNARY_MINUS_T $v) | op= TOK_NOT v= ctl_primary_expr -> ^( TOK_NOT $v) );", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:584:11: ctl_primary_expr_helper1
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ctl_primary_expr_helper1_in_ctl_primary_expr5306);
                    ctl_primary_expr_helper187=ctl_primary_expr_helper1();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, ctl_primary_expr_helper187.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) retval.ret = ctl_primary_expr_helper187.ret; 
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:586:11: op= TOK_MINUS v= ctl_primary_expr
                    {
                    op=(Token)input.LT(1);
                    match(input,TOK_MINUS,FOLLOW_TOK_MINUS_in_ctl_primary_expr5330); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_MINUS.add(op);

                    pushFollow(FOLLOW_ctl_primary_expr_in_ctl_primary_expr5334);
                    v=ctl_primary_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_ctl_primary_expr.add(v.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_unary_minus(input, ((Token)retval.start), op.getText() + " " + input.toString(v.start,v.stop), v.ret); 
                    }

                    // AST REWRITE
                    // elements: v
                    // token labels: 
                    // rule labels: v, retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_v=new RewriteRuleSubtreeStream(adaptor,"token v",v!=null?v.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 588:9: -> ^( TOK_UNARY_MINUS_T $v)
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:588:12: ^( TOK_UNARY_MINUS_T $v)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(TOK_UNARY_MINUS_T, "TOK_UNARY_MINUS_T"), root_1);

                        adaptor.addChild(root_1, stream_v.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:589:11: op= TOK_NOT v= ctl_primary_expr
                    {
                    op=(Token)input.LT(1);
                    match(input,TOK_NOT,FOLLOW_TOK_NOT_in_ctl_primary_expr5375); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_NOT.add(op);

                    pushFollow(FOLLOW_ctl_primary_expr_in_ctl_primary_expr5379);
                    v=ctl_primary_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_ctl_primary_expr.add(v.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_not(input, ((Token)retval.start), op.getText() + " " + input.toString(v.start,v.stop), v.ret); 
                    }

                    // AST REWRITE
                    // elements: v, TOK_NOT
                    // token labels: 
                    // rule labels: v, retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_v=new RewriteRuleSubtreeStream(adaptor,"token v",v!=null?v.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 591:9: -> ^( TOK_NOT $v)
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:591:12: ^( TOK_NOT $v)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_TOK_NOT.next(), root_1);

                        adaptor.addChild(root_1, stream_v.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctl_primary_expr

    public static class ctl_primary_expr_helper1_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctl_primary_expr_helper1
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:594:1: ctl_primary_expr_helper1 returns [InternalSpec ret] : ( constant primary_expr_select -> ^( VALUE_T constant NOP primary_expr_select ) | primary_expr_helper1_pointer1 | TOK_LP ctl_root_expr TOK_RP primary_expr_select -> ^( BLOCK_T ctl_root_expr NOP primary_expr_select ) | TOK_BOOL TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_BOOL simple_root_expr NOP primary_expr_select ) | TOK_WORD1 TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WORD1 simple_root_expr NOP primary_expr_select ) | TOK_NEXT TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_NEXT simple_root_expr NOP primary_expr_select ) | TOK_CASE case_element_list_expr TOK_ESAC primary_expr_select -> ^( CASE_LIST_EXPR_T case_element_list_expr NOP primary_expr_select ) | TOK_WAREAD TOK_LP f= simple_root_expr TOK_COMMA s= simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WAREAD $f $s NOP primary_expr_select ) | TOK_WAWRITE TOK_LP f= simple_root_expr tc1= TOK_COMMA m= simple_root_expr tc2= TOK_COMMA s= simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WAWRITE $f $m $s NOP primary_expr_select ) );
    public final ctl_primary_expr_helper1_return ctl_primary_expr_helper1() throws RecognitionException {
        ctl_primary_expr_helper1_return retval = new ctl_primary_expr_helper1_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token tc1=null;
        Token tc2=null;
        Token TOK_LP91=null;
        Token TOK_RP93=null;
        Token TOK_BOOL95=null;
        Token TOK_LP96=null;
        Token TOK_RP98=null;
        Token TOK_WORD1100=null;
        Token TOK_LP101=null;
        Token TOK_RP103=null;
        Token TOK_NEXT105=null;
        Token TOK_LP106=null;
        Token TOK_RP108=null;
        Token TOK_CASE110=null;
        Token TOK_ESAC112=null;
        Token TOK_WAREAD114=null;
        Token TOK_LP115=null;
        Token TOK_COMMA116=null;
        Token TOK_RP117=null;
        Token TOK_WAWRITE119=null;
        Token TOK_LP120=null;
        Token TOK_RP121=null;
        simple_root_expr_return f = null;

        simple_root_expr_return s = null;

        simple_root_expr_return m = null;

        constant_return constant88 = null;

        primary_expr_select_return primary_expr_select89 = null;

        primary_expr_helper1_pointer1_return primary_expr_helper1_pointer190 = null;

        ctl_root_expr_return ctl_root_expr92 = null;

        primary_expr_select_return primary_expr_select94 = null;

        simple_root_expr_return simple_root_expr97 = null;

        primary_expr_select_return primary_expr_select99 = null;

        simple_root_expr_return simple_root_expr102 = null;

        primary_expr_select_return primary_expr_select104 = null;

        simple_root_expr_return simple_root_expr107 = null;

        primary_expr_select_return primary_expr_select109 = null;

        case_element_list_expr_return case_element_list_expr111 = null;

        primary_expr_select_return primary_expr_select113 = null;

        primary_expr_select_return primary_expr_select118 = null;

        primary_expr_select_return primary_expr_select122 = null;


        Object tc1_tree=null;
        Object tc2_tree=null;
        Object TOK_LP91_tree=null;
        Object TOK_RP93_tree=null;
        Object TOK_BOOL95_tree=null;
        Object TOK_LP96_tree=null;
        Object TOK_RP98_tree=null;
        Object TOK_WORD1100_tree=null;
        Object TOK_LP101_tree=null;
        Object TOK_RP103_tree=null;
        Object TOK_NEXT105_tree=null;
        Object TOK_LP106_tree=null;
        Object TOK_RP108_tree=null;
        Object TOK_CASE110_tree=null;
        Object TOK_ESAC112_tree=null;
        Object TOK_WAREAD114_tree=null;
        Object TOK_LP115_tree=null;
        Object TOK_COMMA116_tree=null;
        Object TOK_RP117_tree=null;
        Object TOK_WAWRITE119_tree=null;
        Object TOK_LP120_tree=null;
        Object TOK_RP121_tree=null;
        RewriteRuleTokenStream stream_TOK_LP=new RewriteRuleTokenStream(adaptor,"token TOK_LP");
        RewriteRuleTokenStream stream_TOK_BOOL=new RewriteRuleTokenStream(adaptor,"token TOK_BOOL");
        RewriteRuleTokenStream stream_TOK_WAWRITE=new RewriteRuleTokenStream(adaptor,"token TOK_WAWRITE");
        RewriteRuleTokenStream stream_TOK_WAREAD=new RewriteRuleTokenStream(adaptor,"token TOK_WAREAD");
        RewriteRuleTokenStream stream_TOK_WORD1=new RewriteRuleTokenStream(adaptor,"token TOK_WORD1");
        RewriteRuleTokenStream stream_TOK_RP=new RewriteRuleTokenStream(adaptor,"token TOK_RP");
        RewriteRuleTokenStream stream_TOK_CASE=new RewriteRuleTokenStream(adaptor,"token TOK_CASE");
        RewriteRuleTokenStream stream_TOK_ESAC=new RewriteRuleTokenStream(adaptor,"token TOK_ESAC");
        RewriteRuleTokenStream stream_TOK_NEXT=new RewriteRuleTokenStream(adaptor,"token TOK_NEXT");
        RewriteRuleTokenStream stream_TOK_COMMA=new RewriteRuleTokenStream(adaptor,"token TOK_COMMA");
        RewriteRuleSubtreeStream stream_case_element_list_expr=new RewriteRuleSubtreeStream(adaptor,"rule case_element_list_expr");
        RewriteRuleSubtreeStream stream_constant=new RewriteRuleSubtreeStream(adaptor,"rule constant");
        RewriteRuleSubtreeStream stream_simple_root_expr=new RewriteRuleSubtreeStream(adaptor,"rule simple_root_expr");
        RewriteRuleSubtreeStream stream_ctl_root_expr=new RewriteRuleSubtreeStream(adaptor,"rule ctl_root_expr");
        RewriteRuleSubtreeStream stream_primary_expr_select=new RewriteRuleSubtreeStream(adaptor,"rule primary_expr_select");
        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:597:9: ( constant primary_expr_select -> ^( VALUE_T constant NOP primary_expr_select ) | primary_expr_helper1_pointer1 | TOK_LP ctl_root_expr TOK_RP primary_expr_select -> ^( BLOCK_T ctl_root_expr NOP primary_expr_select ) | TOK_BOOL TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_BOOL simple_root_expr NOP primary_expr_select ) | TOK_WORD1 TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WORD1 simple_root_expr NOP primary_expr_select ) | TOK_NEXT TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_NEXT simple_root_expr NOP primary_expr_select ) | TOK_CASE case_element_list_expr TOK_ESAC primary_expr_select -> ^( CASE_LIST_EXPR_T case_element_list_expr NOP primary_expr_select ) | TOK_WAREAD TOK_LP f= simple_root_expr TOK_COMMA s= simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WAREAD $f $s NOP primary_expr_select ) | TOK_WAWRITE TOK_LP f= simple_root_expr tc1= TOK_COMMA m= simple_root_expr tc2= TOK_COMMA s= simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WAWRITE $f $m $s NOP primary_expr_select ) )
            int alt37=9;
            switch ( input.LA(1) ) {
            case TOK_PLUS:
            case TOK_NUMBER:
            case TOK_NUMBER_WORD:
            case TOK_FALSEEXP:
            case TOK_TRUEEXP:
                {
                alt37=1;
                }
                break;
            case TOK_ATOM:
                {
                alt37=2;
                }
                break;
            case TOK_LP:
                {
                alt37=3;
                }
                break;
            case TOK_BOOL:
                {
                alt37=4;
                }
                break;
            case TOK_WORD1:
                {
                alt37=5;
                }
                break;
            case TOK_NEXT:
                {
                alt37=6;
                }
                break;
            case TOK_CASE:
                {
                alt37=7;
                }
                break;
            case TOK_WAREAD:
                {
                alt37=8;
                }
                break;
            case TOK_WAWRITE:
                {
                alt37=9;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("594:1: ctl_primary_expr_helper1 returns [InternalSpec ret] : ( constant primary_expr_select -> ^( VALUE_T constant NOP primary_expr_select ) | primary_expr_helper1_pointer1 | TOK_LP ctl_root_expr TOK_RP primary_expr_select -> ^( BLOCK_T ctl_root_expr NOP primary_expr_select ) | TOK_BOOL TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_BOOL simple_root_expr NOP primary_expr_select ) | TOK_WORD1 TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WORD1 simple_root_expr NOP primary_expr_select ) | TOK_NEXT TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_NEXT simple_root_expr NOP primary_expr_select ) | TOK_CASE case_element_list_expr TOK_ESAC primary_expr_select -> ^( CASE_LIST_EXPR_T case_element_list_expr NOP primary_expr_select ) | TOK_WAREAD TOK_LP f= simple_root_expr TOK_COMMA s= simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WAREAD $f $s NOP primary_expr_select ) | TOK_WAWRITE TOK_LP f= simple_root_expr tc1= TOK_COMMA m= simple_root_expr tc2= TOK_COMMA s= simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WAWRITE $f $m $s NOP primary_expr_select ) );", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:597:11: constant primary_expr_select
                    {
                    pushFollow(FOLLOW_constant_in_ctl_primary_expr_helper15444);
                    constant88=constant();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_constant.add(constant88.getTree());
                    pushFollow(FOLLOW_primary_expr_select_in_ctl_primary_expr_helper15446);
                    primary_expr_select89=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select89.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    // AST REWRITE
                    // elements: primary_expr_select, constant
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 600:9: -> ^( VALUE_T constant NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:600:12: ^( VALUE_T constant NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(VALUE_T, "VALUE_T"), root_1);

                        adaptor.addChild(root_1, stream_constant.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:601:11: primary_expr_helper1_pointer1
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_primary_expr_helper1_pointer1_in_ctl_primary_expr_helper15497);
                    primary_expr_helper1_pointer190=primary_expr_helper1_pointer1();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, primary_expr_helper1_pointer190.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:610:11: TOK_LP ctl_root_expr TOK_RP primary_expr_select
                    {
                    TOK_LP91=(Token)input.LT(1);
                    match(input,TOK_LP,FOLLOW_TOK_LP_in_ctl_primary_expr_helper15550); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_LP.add(TOK_LP91);

                    pushFollow(FOLLOW_ctl_root_expr_in_ctl_primary_expr_helper15552);
                    ctl_root_expr92=ctl_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_ctl_root_expr.add(ctl_root_expr92.getTree());
                    TOK_RP93=(Token)input.LT(1);
                    match(input,TOK_RP,FOLLOW_TOK_RP_in_ctl_primary_expr_helper15554); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_RP.add(TOK_RP93);

                    pushFollow(FOLLOW_primary_expr_select_in_ctl_primary_expr_helper15556);
                    primary_expr_select94=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select94.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) retval.ret = ctl_root_expr92.ret; 
                    }

                    // AST REWRITE
                    // elements: ctl_root_expr, primary_expr_select
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 612:9: -> ^( BLOCK_T ctl_root_expr NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:612:12: ^( BLOCK_T ctl_root_expr NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(BLOCK_T, "BLOCK_T"), root_1);

                        adaptor.addChild(root_1, stream_ctl_root_expr.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 4 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:616:11: TOK_BOOL TOK_LP simple_root_expr TOK_RP primary_expr_select
                    {
                    TOK_BOOL95=(Token)input.LT(1);
                    match(input,TOK_BOOL,FOLLOW_TOK_BOOL_in_ctl_primary_expr_helper15627); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_BOOL.add(TOK_BOOL95);

                    TOK_LP96=(Token)input.LT(1);
                    match(input,TOK_LP,FOLLOW_TOK_LP_in_ctl_primary_expr_helper15629); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_LP.add(TOK_LP96);

                    pushFollow(FOLLOW_simple_root_expr_in_ctl_primary_expr_helper15631);
                    simple_root_expr97=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(simple_root_expr97.getTree());
                    TOK_RP98=(Token)input.LT(1);
                    match(input,TOK_RP,FOLLOW_TOK_RP_in_ctl_primary_expr_helper15633); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_RP.add(TOK_RP98);

                    pushFollow(FOLLOW_primary_expr_select_in_ctl_primary_expr_helper15635);
                    primary_expr_select99=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select99.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    // AST REWRITE
                    // elements: TOK_BOOL, primary_expr_select, simple_root_expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 619:9: -> ^( TOK_BOOL simple_root_expr NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:619:12: ^( TOK_BOOL simple_root_expr NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_TOK_BOOL.next(), root_1);

                        adaptor.addChild(root_1, stream_simple_root_expr.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 5 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:620:11: TOK_WORD1 TOK_LP simple_root_expr TOK_RP primary_expr_select
                    {
                    TOK_WORD1100=(Token)input.LT(1);
                    match(input,TOK_WORD1,FOLLOW_TOK_WORD1_in_ctl_primary_expr_helper15686); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_WORD1.add(TOK_WORD1100);

                    TOK_LP101=(Token)input.LT(1);
                    match(input,TOK_LP,FOLLOW_TOK_LP_in_ctl_primary_expr_helper15688); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_LP.add(TOK_LP101);

                    pushFollow(FOLLOW_simple_root_expr_in_ctl_primary_expr_helper15690);
                    simple_root_expr102=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(simple_root_expr102.getTree());
                    TOK_RP103=(Token)input.LT(1);
                    match(input,TOK_RP,FOLLOW_TOK_RP_in_ctl_primary_expr_helper15692); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_RP.add(TOK_RP103);

                    pushFollow(FOLLOW_primary_expr_select_in_ctl_primary_expr_helper15694);
                    primary_expr_select104=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select104.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    // AST REWRITE
                    // elements: simple_root_expr, primary_expr_select, TOK_WORD1
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 623:9: -> ^( TOK_WORD1 simple_root_expr NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:623:12: ^( TOK_WORD1 simple_root_expr NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_TOK_WORD1.next(), root_1);

                        adaptor.addChild(root_1, stream_simple_root_expr.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 6 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:625:11: TOK_NEXT TOK_LP simple_root_expr TOK_RP primary_expr_select
                    {
                    TOK_NEXT105=(Token)input.LT(1);
                    match(input,TOK_NEXT,FOLLOW_TOK_NEXT_in_ctl_primary_expr_helper15754); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_NEXT.add(TOK_NEXT105);

                    TOK_LP106=(Token)input.LT(1);
                    match(input,TOK_LP,FOLLOW_TOK_LP_in_ctl_primary_expr_helper15756); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_LP.add(TOK_LP106);

                    pushFollow(FOLLOW_simple_root_expr_in_ctl_primary_expr_helper15758);
                    simple_root_expr107=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(simple_root_expr107.getTree());
                    TOK_RP108=(Token)input.LT(1);
                    match(input,TOK_RP,FOLLOW_TOK_RP_in_ctl_primary_expr_helper15760); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_RP.add(TOK_RP108);

                    pushFollow(FOLLOW_primary_expr_select_in_ctl_primary_expr_helper15762);
                    primary_expr_select109=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select109.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    // AST REWRITE
                    // elements: primary_expr_select, simple_root_expr, TOK_NEXT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 628:9: -> ^( TOK_NEXT simple_root_expr NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:628:12: ^( TOK_NEXT simple_root_expr NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_TOK_NEXT.next(), root_1);

                        adaptor.addChild(root_1, stream_simple_root_expr.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 7 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:630:11: TOK_CASE case_element_list_expr TOK_ESAC primary_expr_select
                    {
                    TOK_CASE110=(Token)input.LT(1);
                    match(input,TOK_CASE,FOLLOW_TOK_CASE_in_ctl_primary_expr_helper15822); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_CASE.add(TOK_CASE110);

                    pushFollow(FOLLOW_case_element_list_expr_in_ctl_primary_expr_helper15824);
                    case_element_list_expr111=case_element_list_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_case_element_list_expr.add(case_element_list_expr111.getTree());
                    TOK_ESAC112=(Token)input.LT(1);
                    match(input,TOK_ESAC,FOLLOW_TOK_ESAC_in_ctl_primary_expr_helper15826); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_ESAC.add(TOK_ESAC112);

                    pushFollow(FOLLOW_primary_expr_select_in_ctl_primary_expr_helper15828);
                    primary_expr_select113=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select113.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    // AST REWRITE
                    // elements: primary_expr_select, case_element_list_expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 633:9: -> ^( CASE_LIST_EXPR_T case_element_list_expr NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:633:12: ^( CASE_LIST_EXPR_T case_element_list_expr NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(CASE_LIST_EXPR_T, "CASE_LIST_EXPR_T"), root_1);

                        adaptor.addChild(root_1, stream_case_element_list_expr.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 8 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:635:11: TOK_WAREAD TOK_LP f= simple_root_expr TOK_COMMA s= simple_root_expr TOK_RP primary_expr_select
                    {
                    TOK_WAREAD114=(Token)input.LT(1);
                    match(input,TOK_WAREAD,FOLLOW_TOK_WAREAD_in_ctl_primary_expr_helper15888); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_WAREAD.add(TOK_WAREAD114);

                    TOK_LP115=(Token)input.LT(1);
                    match(input,TOK_LP,FOLLOW_TOK_LP_in_ctl_primary_expr_helper15890); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_LP.add(TOK_LP115);

                    pushFollow(FOLLOW_simple_root_expr_in_ctl_primary_expr_helper15894);
                    f=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(f.getTree());
                    TOK_COMMA116=(Token)input.LT(1);
                    match(input,TOK_COMMA,FOLLOW_TOK_COMMA_in_ctl_primary_expr_helper15896); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_COMMA.add(TOK_COMMA116);

                    pushFollow(FOLLOW_simple_root_expr_in_ctl_primary_expr_helper15900);
                    s=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(s.getTree());
                    TOK_RP117=(Token)input.LT(1);
                    match(input,TOK_RP,FOLLOW_TOK_RP_in_ctl_primary_expr_helper15902); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_RP.add(TOK_RP117);

                    pushFollow(FOLLOW_primary_expr_select_in_ctl_primary_expr_helper15904);
                    primary_expr_select118=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select118.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    // AST REWRITE
                    // elements: s, TOK_WAREAD, f, primary_expr_select
                    // token labels: 
                    // rule labels: f, retval, s
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_f=new RewriteRuleSubtreeStream(adaptor,"token f",f!=null?f.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_s=new RewriteRuleSubtreeStream(adaptor,"token s",s!=null?s.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 638:9: -> ^( TOK_WAREAD $f $s NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:638:12: ^( TOK_WAREAD $f $s NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_TOK_WAREAD.next(), root_1);

                        adaptor.addChild(root_1, stream_f.next());
                        adaptor.addChild(root_1, stream_s.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 9 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:640:11: TOK_WAWRITE TOK_LP f= simple_root_expr tc1= TOK_COMMA m= simple_root_expr tc2= TOK_COMMA s= simple_root_expr TOK_RP primary_expr_select
                    {
                    TOK_WAWRITE119=(Token)input.LT(1);
                    match(input,TOK_WAWRITE,FOLLOW_TOK_WAWRITE_in_ctl_primary_expr_helper15968); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_WAWRITE.add(TOK_WAWRITE119);

                    TOK_LP120=(Token)input.LT(1);
                    match(input,TOK_LP,FOLLOW_TOK_LP_in_ctl_primary_expr_helper15970); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_LP.add(TOK_LP120);

                    pushFollow(FOLLOW_simple_root_expr_in_ctl_primary_expr_helper15974);
                    f=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(f.getTree());
                    tc1=(Token)input.LT(1);
                    match(input,TOK_COMMA,FOLLOW_TOK_COMMA_in_ctl_primary_expr_helper15978); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_COMMA.add(tc1);

                    pushFollow(FOLLOW_simple_root_expr_in_ctl_primary_expr_helper15982);
                    m=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(m.getTree());
                    tc2=(Token)input.LT(1);
                    match(input,TOK_COMMA,FOLLOW_TOK_COMMA_in_ctl_primary_expr_helper15986); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_COMMA.add(tc2);

                    pushFollow(FOLLOW_simple_root_expr_in_ctl_primary_expr_helper15990);
                    s=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(s.getTree());
                    TOK_RP121=(Token)input.LT(1);
                    match(input,TOK_RP,FOLLOW_TOK_RP_in_ctl_primary_expr_helper15992); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_RP.add(TOK_RP121);

                    pushFollow(FOLLOW_primary_expr_select_in_ctl_primary_expr_helper15994);
                    primary_expr_select122=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select122.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    // AST REWRITE
                    // elements: s, TOK_WAWRITE, m, f, primary_expr_select
                    // token labels: 
                    // rule labels: f, retval, s, m
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_f=new RewriteRuleSubtreeStream(adaptor,"token f",f!=null?f.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_s=new RewriteRuleSubtreeStream(adaptor,"token s",s!=null?s.tree:null);
                    RewriteRuleSubtreeStream stream_m=new RewriteRuleSubtreeStream(adaptor,"token m",m!=null?m.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 643:9: -> ^( TOK_WAWRITE $f $m $s NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:643:12: ^( TOK_WAWRITE $f $m $s NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_TOK_WAWRITE.next(), root_1);

                        adaptor.addChild(root_1, stream_f.next());
                        adaptor.addChild(root_1, stream_m.next());
                        adaptor.addChild(root_1, stream_s.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctl_primary_expr_helper1

    public static class ltl_root_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ltl_root_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:649:1: ltl_root_expr returns [InternalSpec ret] : ltl_implies_expr ;
    public final ltl_root_expr_return ltl_root_expr() throws RecognitionException {
        ltl_root_expr_return retval = new ltl_root_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ltl_implies_expr_return ltl_implies_expr123 = null;



        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:650:9: ( ltl_implies_expr )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:650:11: ltl_implies_expr
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ltl_implies_expr_in_ltl_root_expr6074);
            ltl_implies_expr123=ltl_implies_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, ltl_implies_expr123.getTree());
            if ( backtracking==0 ) {
              if(!er()) retval.ret = ltl_implies_expr123.ret; 
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
    // $ANTLR end ltl_root_expr

    public static class ltl_implies_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ltl_implies_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:652:1: ltl_implies_expr returns [InternalSpec ret] : f= ltl_iff_expr (op= TOK_IMPLIES s= ltl_implies_expr )? ;
    public final ltl_implies_expr_return ltl_implies_expr() throws RecognitionException {
        ltl_implies_expr_return retval = new ltl_implies_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ltl_iff_expr_return f = null;

        ltl_implies_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:655:9: (f= ltl_iff_expr (op= TOK_IMPLIES s= ltl_implies_expr )? )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:655:11: f= ltl_iff_expr (op= TOK_IMPLIES s= ltl_implies_expr )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ltl_iff_expr_in_ltl_implies_expr6117);
            f=ltl_iff_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:656:9: (op= TOK_IMPLIES s= ltl_implies_expr )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==TOK_IMPLIES) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:656:11: op= TOK_IMPLIES s= ltl_implies_expr
                    {
                    op=(Token)input.LT(1);
                    match(input,TOK_IMPLIES,FOLLOW_TOK_IMPLIES_in_ltl_implies_expr6133); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ltl_implies_expr_in_ltl_implies_expr6138);
                    s=ltl_implies_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_imply(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ltl_implies_expr

    public static class ltl_iff_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ltl_iff_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:660:1: ltl_iff_expr returns [InternalSpec ret] : f= ltl_or_expr (op= TOK_IFF s= ltl_or_expr )* ;
    public final ltl_iff_expr_return ltl_iff_expr() throws RecognitionException {
        ltl_iff_expr_return retval = new ltl_iff_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ltl_or_expr_return f = null;

        ltl_or_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:663:9: (f= ltl_or_expr (op= TOK_IFF s= ltl_or_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:663:11: f= ltl_or_expr (op= TOK_IFF s= ltl_or_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ltl_or_expr_in_ltl_iff_expr6203);
            f=ltl_or_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:664:9: (op= TOK_IFF s= ltl_or_expr )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==TOK_IFF) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:664:11: op= TOK_IFF s= ltl_or_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_IFF,FOLLOW_TOK_IFF_in_ltl_iff_expr6219); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ltl_or_expr_in_ltl_iff_expr6224);
            	    s=ltl_or_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_iff(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ltl_iff_expr

    public static class ltl_or_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ltl_or_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:668:1: ltl_or_expr returns [InternalSpec ret] : f= ltl_and_expr (op= TOK_OR s= ltl_and_expr | op= TOK_XOR s= ltl_and_expr | op= TOK_XNOR s= ltl_and_expr )* ;
    public final ltl_or_expr_return ltl_or_expr() throws RecognitionException {
        ltl_or_expr_return retval = new ltl_or_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ltl_and_expr_return f = null;

        ltl_and_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:671:9: (f= ltl_and_expr (op= TOK_OR s= ltl_and_expr | op= TOK_XOR s= ltl_and_expr | op= TOK_XNOR s= ltl_and_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:671:11: f= ltl_and_expr (op= TOK_OR s= ltl_and_expr | op= TOK_XOR s= ltl_and_expr | op= TOK_XNOR s= ltl_and_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ltl_and_expr_in_ltl_or_expr6288);
            f=ltl_and_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:672:9: (op= TOK_OR s= ltl_and_expr | op= TOK_XOR s= ltl_and_expr | op= TOK_XNOR s= ltl_and_expr )*
            loop40:
            do {
                int alt40=4;
                switch ( input.LA(1) ) {
                case TOK_OR:
                    {
                    alt40=1;
                    }
                    break;
                case TOK_XOR:
                    {
                    alt40=2;
                    }
                    break;
                case TOK_XNOR:
                    {
                    alt40=3;
                    }
                    break;

                }

                switch (alt40) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:672:11: op= TOK_OR s= ltl_and_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_OR,FOLLOW_TOK_OR_in_ltl_or_expr6304); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ltl_and_expr_in_ltl_or_expr6309);
            	    s=ltl_and_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_or(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:674:11: op= TOK_XOR s= ltl_and_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_XOR,FOLLOW_TOK_XOR_in_ltl_or_expr6333); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ltl_and_expr_in_ltl_or_expr6338);
            	    s=ltl_and_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_xor(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 3 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:676:11: op= TOK_XNOR s= ltl_and_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_XNOR,FOLLOW_TOK_XNOR_in_ltl_or_expr6362); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ltl_and_expr_in_ltl_or_expr6367);
            	    s=ltl_and_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_xnor(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ltl_or_expr

    public static class ltl_and_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ltl_and_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:680:1: ltl_and_expr returns [InternalSpec ret] : f= ltl_binary_expr (op= TOK_AND s= ltl_binary_expr )* ;
    public final ltl_and_expr_return ltl_and_expr() throws RecognitionException {
        ltl_and_expr_return retval = new ltl_and_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ltl_binary_expr_return f = null;

        ltl_binary_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:683:9: (f= ltl_binary_expr (op= TOK_AND s= ltl_binary_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:683:11: f= ltl_binary_expr (op= TOK_AND s= ltl_binary_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ltl_binary_expr_in_ltl_and_expr6430);
            f=ltl_binary_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:684:9: (op= TOK_AND s= ltl_binary_expr )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==TOK_AND) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:684:11: op= TOK_AND s= ltl_binary_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_AND,FOLLOW_TOK_AND_in_ltl_and_expr6446); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ltl_binary_expr_in_ltl_and_expr6451);
            	    s=ltl_binary_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_and(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ltl_and_expr

    public static class ltl_binary_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ltl_binary_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:690:1: ltl_binary_expr returns [InternalSpec ret] : f= ltl_unary_expr (op= TOK_UNTIL s= ltl_unary_expr | op= TOK_SINCE s= ltl_unary_expr | op= TOK_RELEASES s= ltl_unary_expr | op= TOK_TRIGGERED s= ltl_unary_expr )* ;
    public final ltl_binary_expr_return ltl_binary_expr() throws RecognitionException {
        ltl_binary_expr_return retval = new ltl_binary_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ltl_unary_expr_return f = null;

        ltl_unary_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:693:9: (f= ltl_unary_expr (op= TOK_UNTIL s= ltl_unary_expr | op= TOK_SINCE s= ltl_unary_expr | op= TOK_RELEASES s= ltl_unary_expr | op= TOK_TRIGGERED s= ltl_unary_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:693:11: f= ltl_unary_expr (op= TOK_UNTIL s= ltl_unary_expr | op= TOK_SINCE s= ltl_unary_expr | op= TOK_RELEASES s= ltl_unary_expr | op= TOK_TRIGGERED s= ltl_unary_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ltl_unary_expr_in_ltl_binary_expr6516);
            f=ltl_unary_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:694:9: (op= TOK_UNTIL s= ltl_unary_expr | op= TOK_SINCE s= ltl_unary_expr | op= TOK_RELEASES s= ltl_unary_expr | op= TOK_TRIGGERED s= ltl_unary_expr )*
            loop42:
            do {
                int alt42=5;
                switch ( input.LA(1) ) {
                case TOK_UNTIL:
                    {
                    alt42=1;
                    }
                    break;
                case TOK_SINCE:
                    {
                    alt42=2;
                    }
                    break;
                case TOK_RELEASES:
                    {
                    alt42=3;
                    }
                    break;
                case TOK_TRIGGERED:
                    {
                    alt42=4;
                    }
                    break;

                }

                switch (alt42) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:694:11: op= TOK_UNTIL s= ltl_unary_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_UNTIL,FOLLOW_TOK_UNTIL_in_ltl_binary_expr6532); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ltl_unary_expr_in_ltl_binary_expr6537);
            	    s=ltl_unary_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_until(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:696:11: op= TOK_SINCE s= ltl_unary_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_SINCE,FOLLOW_TOK_SINCE_in_ltl_binary_expr6562); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ltl_unary_expr_in_ltl_binary_expr6567);
            	    s=ltl_unary_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_since(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 3 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:698:11: op= TOK_RELEASES s= ltl_unary_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_RELEASES,FOLLOW_TOK_RELEASES_in_ltl_binary_expr6592); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ltl_unary_expr_in_ltl_binary_expr6597);
            	    s=ltl_unary_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_releases(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 4 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:700:11: op= TOK_TRIGGERED s= ltl_unary_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_TRIGGERED,FOLLOW_TOK_TRIGGERED_in_ltl_binary_expr6622); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ltl_unary_expr_in_ltl_binary_expr6627);
            	    s=ltl_unary_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_triggered(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ltl_binary_expr

    public static class ltl_unary_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ltl_unary_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:704:1: ltl_unary_expr returns [InternalSpec ret] : ( ( ( TOK_NOT )* ( TOK_OP_NEXT | TOK_OP_PREV | TOK_OP_NOTPREVNOT | TOK_OP_GLOBALLY | TOK_OP_HISTORICALLY | TOK_OP_FINALLY | TOK_OP_ONCE ) )=> ltl_pure_unary_expr -> ^( PURE_LTL_T ltl_pure_unary_expr ) | ltl_relational_expr );
    public final ltl_unary_expr_return ltl_unary_expr() throws RecognitionException {
        ltl_unary_expr_return retval = new ltl_unary_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ltl_pure_unary_expr_return ltl_pure_unary_expr124 = null;

        ltl_relational_expr_return ltl_relational_expr125 = null;


        RewriteRuleSubtreeStream stream_ltl_pure_unary_expr=new RewriteRuleSubtreeStream(adaptor,"rule ltl_pure_unary_expr");
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:705:9: ( ( ( TOK_NOT )* ( TOK_OP_NEXT | TOK_OP_PREV | TOK_OP_NOTPREVNOT | TOK_OP_GLOBALLY | TOK_OP_HISTORICALLY | TOK_OP_FINALLY | TOK_OP_ONCE ) )=> ltl_pure_unary_expr -> ^( PURE_LTL_T ltl_pure_unary_expr ) | ltl_relational_expr )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==TOK_OP_NEXT) && (synpred6())) {
                alt43=1;
            }
            else if ( (LA43_0==TOK_OP_PREV) && (synpred6())) {
                alt43=1;
            }
            else if ( (LA43_0==TOK_OP_NOTPREVNOT) && (synpred6())) {
                alt43=1;
            }
            else if ( (LA43_0==TOK_OP_GLOBALLY) && (synpred6())) {
                alt43=1;
            }
            else if ( (LA43_0==TOK_OP_HISTORICALLY) && (synpred6())) {
                alt43=1;
            }
            else if ( (LA43_0==TOK_OP_FINALLY) && (synpred6())) {
                alt43=1;
            }
            else if ( (LA43_0==TOK_OP_ONCE) && (synpred6())) {
                alt43=1;
            }
            else if ( (LA43_0==TOK_NOT) ) {
                int LA43_8 = input.LA(2);

                if ( ((LA43_8>=TOK_PLUS && LA43_8<=TOK_MINUS)||LA43_8==TOK_LP||(LA43_8>=TOK_BOOL && LA43_8<=TOK_CASE)||(LA43_8>=TOK_WAREAD && LA43_8<=TOK_WAWRITE)||LA43_8==TOK_ATOM||LA43_8==TOK_NUMBER||LA43_8==TOK_NUMBER_WORD||(LA43_8>=TOK_FALSEEXP && LA43_8<=TOK_TRUEEXP)) ) {
                    alt43=2;
                }
                else if ( (LA43_8==TOK_NOT) ) {
                    int LA43_10 = input.LA(3);

                    if ( (synpred6()) ) {
                        alt43=1;
                    }
                    else if ( (true) ) {
                        alt43=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("704:1: ltl_unary_expr returns [InternalSpec ret] : ( ( ( TOK_NOT )* ( TOK_OP_NEXT | TOK_OP_PREV | TOK_OP_NOTPREVNOT | TOK_OP_GLOBALLY | TOK_OP_HISTORICALLY | TOK_OP_FINALLY | TOK_OP_ONCE ) )=> ltl_pure_unary_expr -> ^( PURE_LTL_T ltl_pure_unary_expr ) | ltl_relational_expr );", 43, 10, input);

                        throw nvae;
                    }
                }
                else if ( (LA43_8==TOK_OP_NEXT) && (synpred6())) {
                    alt43=1;
                }
                else if ( (LA43_8==TOK_OP_PREV) && (synpred6())) {
                    alt43=1;
                }
                else if ( (LA43_8==TOK_OP_NOTPREVNOT) && (synpred6())) {
                    alt43=1;
                }
                else if ( (LA43_8==TOK_OP_GLOBALLY) && (synpred6())) {
                    alt43=1;
                }
                else if ( (LA43_8==TOK_OP_HISTORICALLY) && (synpred6())) {
                    alt43=1;
                }
                else if ( (LA43_8==TOK_OP_FINALLY) && (synpred6())) {
                    alt43=1;
                }
                else if ( (LA43_8==TOK_OP_ONCE) && (synpred6())) {
                    alt43=1;
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("704:1: ltl_unary_expr returns [InternalSpec ret] : ( ( ( TOK_NOT )* ( TOK_OP_NEXT | TOK_OP_PREV | TOK_OP_NOTPREVNOT | TOK_OP_GLOBALLY | TOK_OP_HISTORICALLY | TOK_OP_FINALLY | TOK_OP_ONCE ) )=> ltl_pure_unary_expr -> ^( PURE_LTL_T ltl_pure_unary_expr ) | ltl_relational_expr );", 43, 8, input);

                    throw nvae;
                }
            }
            else if ( (LA43_0==TOK_LCB||(LA43_0>=TOK_PLUS && LA43_0<=TOK_MINUS)||LA43_0==TOK_LP||(LA43_0>=TOK_BOOL && LA43_0<=TOK_CASE)||(LA43_0>=TOK_WAREAD && LA43_0<=TOK_WAWRITE)||LA43_0==TOK_ATOM||LA43_0==TOK_NUMBER||LA43_0==TOK_NUMBER_WORD||(LA43_0>=TOK_FALSEEXP && LA43_0<=TOK_TRUEEXP)) ) {
                alt43=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("704:1: ltl_unary_expr returns [InternalSpec ret] : ( ( ( TOK_NOT )* ( TOK_OP_NEXT | TOK_OP_PREV | TOK_OP_NOTPREVNOT | TOK_OP_GLOBALLY | TOK_OP_HISTORICALLY | TOK_OP_FINALLY | TOK_OP_ONCE ) )=> ltl_pure_unary_expr -> ^( PURE_LTL_T ltl_pure_unary_expr ) | ltl_relational_expr );", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:705:11: ( ( TOK_NOT )* ( TOK_OP_NEXT | TOK_OP_PREV | TOK_OP_NOTPREVNOT | TOK_OP_GLOBALLY | TOK_OP_HISTORICALLY | TOK_OP_FINALLY | TOK_OP_ONCE ) )=> ltl_pure_unary_expr
                    {
                    pushFollow(FOLLOW_ltl_pure_unary_expr_in_ltl_unary_expr6779);
                    ltl_pure_unary_expr124=ltl_pure_unary_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_ltl_pure_unary_expr.add(ltl_pure_unary_expr124.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) retval.ret = ltl_pure_unary_expr124.ret; 
                    }

                    // AST REWRITE
                    // elements: ltl_pure_unary_expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 714:9: -> ^( PURE_LTL_T ltl_pure_unary_expr )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:714:12: ^( PURE_LTL_T ltl_pure_unary_expr )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(PURE_LTL_T, "PURE_LTL_T"), root_1);

                        adaptor.addChild(root_1, stream_ltl_pure_unary_expr.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:715:11: ltl_relational_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ltl_relational_expr_in_ltl_unary_expr6820);
                    ltl_relational_expr125=ltl_relational_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, ltl_relational_expr125.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) retval.ret = ltl_relational_expr125.ret; 
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
    // $ANTLR end ltl_unary_expr

    public static class ltl_pure_unary_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ltl_pure_unary_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:718:1: ltl_pure_unary_expr returns [InternalSpec ret] : (op= TOK_OP_NEXT f= ltl_unary_expr | op= TOK_OP_PREV f= ltl_unary_expr | op= TOK_OP_NOTPREVNOT f= ltl_unary_expr | op= TOK_OP_GLOBALLY f= ltl_unary_expr | op= TOK_OP_HISTORICALLY f= ltl_unary_expr | op= TOK_OP_FINALLY f= ltl_unary_expr | op= TOK_OP_ONCE f= ltl_unary_expr | op= TOK_NOT fp= ltl_pure_unary_expr );
    public final ltl_pure_unary_expr_return ltl_pure_unary_expr() throws RecognitionException {
        ltl_pure_unary_expr_return retval = new ltl_pure_unary_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ltl_unary_expr_return f = null;

        ltl_pure_unary_expr_return fp = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:721:9: (op= TOK_OP_NEXT f= ltl_unary_expr | op= TOK_OP_PREV f= ltl_unary_expr | op= TOK_OP_NOTPREVNOT f= ltl_unary_expr | op= TOK_OP_GLOBALLY f= ltl_unary_expr | op= TOK_OP_HISTORICALLY f= ltl_unary_expr | op= TOK_OP_FINALLY f= ltl_unary_expr | op= TOK_OP_ONCE f= ltl_unary_expr | op= TOK_NOT fp= ltl_pure_unary_expr )
            int alt44=8;
            switch ( input.LA(1) ) {
            case TOK_OP_NEXT:
                {
                alt44=1;
                }
                break;
            case TOK_OP_PREV:
                {
                alt44=2;
                }
                break;
            case TOK_OP_NOTPREVNOT:
                {
                alt44=3;
                }
                break;
            case TOK_OP_GLOBALLY:
                {
                alt44=4;
                }
                break;
            case TOK_OP_HISTORICALLY:
                {
                alt44=5;
                }
                break;
            case TOK_OP_FINALLY:
                {
                alt44=6;
                }
                break;
            case TOK_OP_ONCE:
                {
                alt44=7;
                }
                break;
            case TOK_NOT:
                {
                alt44=8;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("718:1: ltl_pure_unary_expr returns [InternalSpec ret] : (op= TOK_OP_NEXT f= ltl_unary_expr | op= TOK_OP_PREV f= ltl_unary_expr | op= TOK_OP_NOTPREVNOT f= ltl_unary_expr | op= TOK_OP_GLOBALLY f= ltl_unary_expr | op= TOK_OP_HISTORICALLY f= ltl_unary_expr | op= TOK_OP_FINALLY f= ltl_unary_expr | op= TOK_OP_ONCE f= ltl_unary_expr | op= TOK_NOT fp= ltl_pure_unary_expr );", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:721:11: op= TOK_OP_NEXT f= ltl_unary_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_OP_NEXT,FOLLOW_TOK_OP_NEXT_in_ltl_pure_unary_expr6872); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ltl_unary_expr_in_ltl_pure_unary_expr6877);
                    f=ltl_unary_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(f.start,f.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_next(input, ((Token)retval.start), exp_str, f.ret); 
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:723:11: op= TOK_OP_PREV f= ltl_unary_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_OP_PREV,FOLLOW_TOK_OP_PREV_in_ltl_pure_unary_expr6901); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ltl_unary_expr_in_ltl_pure_unary_expr6906);
                    f=ltl_unary_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(f.start,f.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_prev(input, ((Token)retval.start), exp_str, f.ret); 
                    }

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:725:11: op= TOK_OP_NOTPREVNOT f= ltl_unary_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_OP_NOTPREVNOT,FOLLOW_TOK_OP_NOTPREVNOT_in_ltl_pure_unary_expr6930); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ltl_unary_expr_in_ltl_pure_unary_expr6935);
                    f=ltl_unary_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(f.start,f.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_notprevnot(input, ((Token)retval.start), exp_str, f.ret); 
                    }

                    }
                    break;
                case 4 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:727:11: op= TOK_OP_GLOBALLY f= ltl_unary_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_OP_GLOBALLY,FOLLOW_TOK_OP_GLOBALLY_in_ltl_pure_unary_expr6959); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ltl_unary_expr_in_ltl_pure_unary_expr6964);
                    f=ltl_unary_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(f.start,f.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_globally(input, ((Token)retval.start), exp_str, f.ret); 
                    }

                    }
                    break;
                case 5 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:729:11: op= TOK_OP_HISTORICALLY f= ltl_unary_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_OP_HISTORICALLY,FOLLOW_TOK_OP_HISTORICALLY_in_ltl_pure_unary_expr6988); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ltl_unary_expr_in_ltl_pure_unary_expr6993);
                    f=ltl_unary_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(f.start,f.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_historically(input, ((Token)retval.start), exp_str, f.ret); 
                    }

                    }
                    break;
                case 6 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:731:11: op= TOK_OP_FINALLY f= ltl_unary_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_OP_FINALLY,FOLLOW_TOK_OP_FINALLY_in_ltl_pure_unary_expr7017); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ltl_unary_expr_in_ltl_pure_unary_expr7022);
                    f=ltl_unary_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(f.start,f.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_finally(input, ((Token)retval.start), exp_str, f.ret); 
                    }

                    }
                    break;
                case 7 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:733:11: op= TOK_OP_ONCE f= ltl_unary_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_OP_ONCE,FOLLOW_TOK_OP_ONCE_in_ltl_pure_unary_expr7046); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ltl_unary_expr_in_ltl_pure_unary_expr7051);
                    f=ltl_unary_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(f.start,f.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_once(input, ((Token)retval.start), exp_str, f.ret); 
                    }

                    }
                    break;
                case 8 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:736:11: op= TOK_NOT fp= ltl_pure_unary_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_NOT,FOLLOW_TOK_NOT_in_ltl_pure_unary_expr7085); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ltl_pure_unary_expr_in_ltl_pure_unary_expr7090);
                    fp=ltl_pure_unary_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, fp.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(fp.start,fp.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_not(input, ((Token)retval.start), exp_str, fp.ret); 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ltl_pure_unary_expr

    public static class ltl_relational_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ltl_relational_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:740:1: ltl_relational_expr returns [InternalSpec ret] : f= ltl_in_expr (op= TOK_EQUAL s= ltl_in_expr | op= TOK_NOTEQUAL s= ltl_in_expr | op= TOK_LT s= ltl_in_expr | op= TOK_GT s= ltl_in_expr | op= TOK_LE s= ltl_in_expr | op= TOK_GE s= ltl_in_expr )* ;
    public final ltl_relational_expr_return ltl_relational_expr() throws RecognitionException {
        ltl_relational_expr_return retval = new ltl_relational_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ltl_in_expr_return f = null;

        ltl_in_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:743:9: (f= ltl_in_expr (op= TOK_EQUAL s= ltl_in_expr | op= TOK_NOTEQUAL s= ltl_in_expr | op= TOK_LT s= ltl_in_expr | op= TOK_GT s= ltl_in_expr | op= TOK_LE s= ltl_in_expr | op= TOK_GE s= ltl_in_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:743:11: f= ltl_in_expr (op= TOK_EQUAL s= ltl_in_expr | op= TOK_NOTEQUAL s= ltl_in_expr | op= TOK_LT s= ltl_in_expr | op= TOK_GT s= ltl_in_expr | op= TOK_LE s= ltl_in_expr | op= TOK_GE s= ltl_in_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ltl_in_expr_in_ltl_relational_expr7142);
            f=ltl_in_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:744:9: (op= TOK_EQUAL s= ltl_in_expr | op= TOK_NOTEQUAL s= ltl_in_expr | op= TOK_LT s= ltl_in_expr | op= TOK_GT s= ltl_in_expr | op= TOK_LE s= ltl_in_expr | op= TOK_GE s= ltl_in_expr )*
            loop45:
            do {
                int alt45=7;
                switch ( input.LA(1) ) {
                case TOK_EQUAL:
                    {
                    alt45=1;
                    }
                    break;
                case TOK_NOTEQUAL:
                    {
                    alt45=2;
                    }
                    break;
                case TOK_LT:
                    {
                    alt45=3;
                    }
                    break;
                case TOK_GT:
                    {
                    alt45=4;
                    }
                    break;
                case TOK_LE:
                    {
                    alt45=5;
                    }
                    break;
                case TOK_GE:
                    {
                    alt45=6;
                    }
                    break;

                }

                switch (alt45) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:744:11: op= TOK_EQUAL s= ltl_in_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_EQUAL,FOLLOW_TOK_EQUAL_in_ltl_relational_expr7158); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ltl_in_expr_in_ltl_relational_expr7163);
            	    s=ltl_in_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_eq(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:746:11: op= TOK_NOTEQUAL s= ltl_in_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_NOTEQUAL,FOLLOW_TOK_NOTEQUAL_in_ltl_relational_expr7188); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ltl_in_expr_in_ltl_relational_expr7193);
            	    s=ltl_in_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_neq(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 3 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:748:11: op= TOK_LT s= ltl_in_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_LT,FOLLOW_TOK_LT_in_ltl_relational_expr7218); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ltl_in_expr_in_ltl_relational_expr7223);
            	    s=ltl_in_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_lt(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 4 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:750:11: op= TOK_GT s= ltl_in_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_GT,FOLLOW_TOK_GT_in_ltl_relational_expr7248); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ltl_in_expr_in_ltl_relational_expr7253);
            	    s=ltl_in_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_gt(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 5 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:752:11: op= TOK_LE s= ltl_in_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_LE,FOLLOW_TOK_LE_in_ltl_relational_expr7278); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ltl_in_expr_in_ltl_relational_expr7283);
            	    s=ltl_in_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_le(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 6 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:754:11: op= TOK_GE s= ltl_in_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_GE,FOLLOW_TOK_GE_in_ltl_relational_expr7308); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ltl_in_expr_in_ltl_relational_expr7313);
            	    s=ltl_in_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ge(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ltl_relational_expr

    public static class ltl_in_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ltl_in_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:758:1: ltl_in_expr returns [InternalSpec ret] : f= ltl_union_expr (op= TOK_SETIN s= ltl_union_expr )* ;
    public final ltl_in_expr_return ltl_in_expr() throws RecognitionException {
        ltl_in_expr_return retval = new ltl_in_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ltl_union_expr_return f = null;

        ltl_union_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:761:9: (f= ltl_union_expr (op= TOK_SETIN s= ltl_union_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:761:11: f= ltl_union_expr (op= TOK_SETIN s= ltl_union_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ltl_union_expr_in_ltl_in_expr7377);
            f=ltl_union_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:762:9: (op= TOK_SETIN s= ltl_union_expr )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==TOK_SETIN) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:762:11: op= TOK_SETIN s= ltl_union_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_SETIN,FOLLOW_TOK_SETIN_in_ltl_in_expr7393); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ltl_union_expr_in_ltl_in_expr7398);
            	    s=ltl_union_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_setin(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ltl_in_expr

    public static class ltl_union_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ltl_union_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:766:1: ltl_union_expr returns [InternalSpec ret] : f= ltl_set_expr (op= TOK_UNION s= ltl_set_expr )* ;
    public final ltl_union_expr_return ltl_union_expr() throws RecognitionException {
        ltl_union_expr_return retval = new ltl_union_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ltl_set_expr_return f = null;

        ltl_set_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:769:9: (f= ltl_set_expr (op= TOK_UNION s= ltl_set_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:769:11: f= ltl_set_expr (op= TOK_UNION s= ltl_set_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ltl_set_expr_in_ltl_union_expr7461);
            f=ltl_set_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:770:9: (op= TOK_UNION s= ltl_set_expr )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==TOK_UNION) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:770:11: op= TOK_UNION s= ltl_set_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_UNION,FOLLOW_TOK_UNION_in_ltl_union_expr7477); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ltl_set_expr_in_ltl_union_expr7482);
            	    s=ltl_set_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_union(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ltl_union_expr

    public static class ltl_set_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ltl_set_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:774:1: ltl_set_expr returns [InternalSpec ret] : ( ltl_shift_expr | subrange | TOK_LCB ltl_set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T ltl_set_list_expr ) );
    public final ltl_set_expr_return ltl_set_expr() throws RecognitionException {
        ltl_set_expr_return retval = new ltl_set_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TOK_LCB128=null;
        Token TOK_RCB130=null;
        ltl_shift_expr_return ltl_shift_expr126 = null;

        subrange_return subrange127 = null;

        ltl_set_list_expr_return ltl_set_list_expr129 = null;


        Object TOK_LCB128_tree=null;
        Object TOK_RCB130_tree=null;
        RewriteRuleTokenStream stream_TOK_LCB=new RewriteRuleTokenStream(adaptor,"token TOK_LCB");
        RewriteRuleTokenStream stream_TOK_RCB=new RewriteRuleTokenStream(adaptor,"token TOK_RCB");
        RewriteRuleSubtreeStream stream_ltl_set_list_expr=new RewriteRuleSubtreeStream(adaptor,"rule ltl_set_list_expr");
        boolean append_end = false; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:777:9: ( ltl_shift_expr | subrange | TOK_LCB ltl_set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T ltl_set_list_expr ) )
            int alt48=3;
            switch ( input.LA(1) ) {
            case TOK_NOT:
            case TOK_LP:
            case TOK_BOOL:
            case TOK_WORD1:
            case TOK_NEXT:
            case TOK_CASE:
            case TOK_WAREAD:
            case TOK_WAWRITE:
            case TOK_ATOM:
            case TOK_NUMBER_WORD:
            case TOK_FALSEEXP:
            case TOK_TRUEEXP:
                {
                alt48=1;
                }
                break;
            case TOK_NUMBER:
                {
                int LA48_2 = input.LA(2);

                if ( (LA48_2==TOK_TWODOTS) ) {
                    alt48=2;
                }
                else if ( (LA48_2==EOF||(LA48_2>=TOK_INVAR_SPEC && LA48_2<=TOK_UNION)||(LA48_2>=TOK_LSHIFT && LA48_2<=TOK_CONCATENATION)||LA48_2==TOK_RP||(LA48_2>=TOK_LB && LA48_2<=TOK_UNTIL)||(LA48_2>=TOK_SINCE && LA48_2<=TOK_TRIGGERED)||LA48_2==TOK_DOT||LA48_2==TOK_SEMI) ) {
                    alt48=1;
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("774:1: ltl_set_expr returns [InternalSpec ret] : ( ltl_shift_expr | subrange | TOK_LCB ltl_set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T ltl_set_list_expr ) );", 48, 2, input);

                    throw nvae;
                }
                }
                break;
            case TOK_PLUS:
                {
                int LA48_3 = input.LA(2);

                if ( (LA48_3==TOK_NUMBER) ) {
                    int LA48_7 = input.LA(3);

                    if ( (LA48_7==EOF||(LA48_7>=TOK_INVAR_SPEC && LA48_7<=TOK_UNION)||(LA48_7>=TOK_LSHIFT && LA48_7<=TOK_CONCATENATION)||LA48_7==TOK_RP||(LA48_7>=TOK_LB && LA48_7<=TOK_UNTIL)||(LA48_7>=TOK_SINCE && LA48_7<=TOK_TRIGGERED)||LA48_7==TOK_DOT||LA48_7==TOK_SEMI) ) {
                        alt48=1;
                    }
                    else if ( (LA48_7==TOK_TWODOTS) ) {
                        alt48=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("774:1: ltl_set_expr returns [InternalSpec ret] : ( ltl_shift_expr | subrange | TOK_LCB ltl_set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T ltl_set_list_expr ) );", 48, 7, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("774:1: ltl_set_expr returns [InternalSpec ret] : ( ltl_shift_expr | subrange | TOK_LCB ltl_set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T ltl_set_list_expr ) );", 48, 3, input);

                    throw nvae;
                }
                }
                break;
            case TOK_MINUS:
                {
                int LA48_4 = input.LA(2);

                if ( (LA48_4==TOK_NUMBER) ) {
                    int LA48_8 = input.LA(3);

                    if ( (LA48_8==TOK_TWODOTS) ) {
                        alt48=2;
                    }
                    else if ( (LA48_8==EOF||(LA48_8>=TOK_INVAR_SPEC && LA48_8<=TOK_UNION)||(LA48_8>=TOK_LSHIFT && LA48_8<=TOK_CONCATENATION)||LA48_8==TOK_RP||(LA48_8>=TOK_LB && LA48_8<=TOK_UNTIL)||(LA48_8>=TOK_SINCE && LA48_8<=TOK_TRIGGERED)||LA48_8==TOK_DOT||LA48_8==TOK_SEMI) ) {
                        alt48=1;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("774:1: ltl_set_expr returns [InternalSpec ret] : ( ltl_shift_expr | subrange | TOK_LCB ltl_set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T ltl_set_list_expr ) );", 48, 8, input);

                        throw nvae;
                    }
                }
                else if ( ((LA48_4>=TOK_PLUS && LA48_4<=TOK_MINUS)||(LA48_4>=TOK_NOT && LA48_4<=TOK_LP)||(LA48_4>=TOK_BOOL && LA48_4<=TOK_CASE)||(LA48_4>=TOK_WAREAD && LA48_4<=TOK_WAWRITE)||LA48_4==TOK_ATOM||LA48_4==TOK_NUMBER_WORD||(LA48_4>=TOK_FALSEEXP && LA48_4<=TOK_TRUEEXP)) ) {
                    alt48=1;
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("774:1: ltl_set_expr returns [InternalSpec ret] : ( ltl_shift_expr | subrange | TOK_LCB ltl_set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T ltl_set_list_expr ) );", 48, 4, input);

                    throw nvae;
                }
                }
                break;
            case TOK_LCB:
                {
                alt48=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("774:1: ltl_set_expr returns [InternalSpec ret] : ( ltl_shift_expr | subrange | TOK_LCB ltl_set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T ltl_set_list_expr ) );", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:777:11: ltl_shift_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ltl_shift_expr_in_ltl_set_expr7543);
                    ltl_shift_expr126=ltl_shift_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, ltl_shift_expr126.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) retval.ret = ltl_shift_expr126.ret; 
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:779:11: subrange
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_subrange_in_ltl_set_expr7565);
                    subrange127=subrange();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, subrange127.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_range(input, ((Token)retval.start), input.toString(subrange127.start,subrange127.stop)); 
                    }

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:781:11: TOK_LCB ltl_set_list_expr TOK_RCB
                    {
                    TOK_LCB128=(Token)input.LT(1);
                    match(input,TOK_LCB,FOLLOW_TOK_LCB_in_ltl_set_expr7588); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_LCB.add(TOK_LCB128);

                    pushFollow(FOLLOW_ltl_set_list_expr_in_ltl_set_expr7590);
                    ltl_set_list_expr129=ltl_set_list_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_ltl_set_list_expr.add(ltl_set_list_expr129.getTree());
                    TOK_RCB130=(Token)input.LT(1);
                    match(input,TOK_RCB,FOLLOW_TOK_RCB_in_ltl_set_expr7592); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_RCB.add(TOK_RCB130);

                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_set(input, ((Token)retval.start), TOK_LCB128.getText() + " " + input.toString(ltl_set_list_expr129.start,ltl_set_list_expr129.stop) + " " + TOK_RCB130.getText()); 
                    }

                    // AST REWRITE
                    // elements: ltl_set_list_expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 783:9: -> ^( SET_LIST_EXP_T ltl_set_list_expr )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:783:12: ^( SET_LIST_EXP_T ltl_set_list_expr )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(SET_LIST_EXP_T, "SET_LIST_EXP_T"), root_1);

                        adaptor.addChild(root_1, stream_ltl_set_list_expr.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ltl_set_expr

    public static class ltl_set_list_expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ltl_set_list_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:785:1: ltl_set_list_expr : simple_root_expr ( TOK_COMMA simple_root_expr )* ;
    public final ltl_set_list_expr_return ltl_set_list_expr() throws RecognitionException {
        ltl_set_list_expr_return retval = new ltl_set_list_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TOK_COMMA132=null;
        simple_root_expr_return simple_root_expr131 = null;

        simple_root_expr_return simple_root_expr133 = null;


        Object TOK_COMMA132_tree=null;

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:786:9: ( simple_root_expr ( TOK_COMMA simple_root_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:786:11: simple_root_expr ( TOK_COMMA simple_root_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_simple_root_expr_in_ltl_set_list_expr7645);
            simple_root_expr131=simple_root_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, simple_root_expr131.getTree());
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:786:28: ( TOK_COMMA simple_root_expr )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==TOK_COMMA) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:786:29: TOK_COMMA simple_root_expr
            	    {
            	    TOK_COMMA132=(Token)input.LT(1);
            	    match(input,TOK_COMMA,FOLLOW_TOK_COMMA_in_ltl_set_list_expr7648); if (failed) return retval;
            	    pushFollow(FOLLOW_simple_root_expr_in_ltl_set_list_expr7651);
            	    simple_root_expr133=simple_root_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, simple_root_expr133.getTree());

            	    }
            	    break;

            	default :
            	    break loop49;
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
    // $ANTLR end ltl_set_list_expr

    public static class ltl_shift_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ltl_shift_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:788:1: ltl_shift_expr returns [InternalSpec ret] : f= ltl_remainder_expr (op= TOK_LSHIFT s= ltl_remainder_expr | op= TOK_RSHIFT s= ltl_remainder_expr )* ;
    public final ltl_shift_expr_return ltl_shift_expr() throws RecognitionException {
        ltl_shift_expr_return retval = new ltl_shift_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ltl_remainder_expr_return f = null;

        ltl_remainder_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:791:9: (f= ltl_remainder_expr (op= TOK_LSHIFT s= ltl_remainder_expr | op= TOK_RSHIFT s= ltl_remainder_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:791:11: f= ltl_remainder_expr (op= TOK_LSHIFT s= ltl_remainder_expr | op= TOK_RSHIFT s= ltl_remainder_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ltl_remainder_expr_in_ltl_shift_expr7697);
            f=ltl_remainder_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:792:9: (op= TOK_LSHIFT s= ltl_remainder_expr | op= TOK_RSHIFT s= ltl_remainder_expr )*
            loop50:
            do {
                int alt50=3;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==TOK_LSHIFT) ) {
                    alt50=1;
                }
                else if ( (LA50_0==TOK_RSHIFT) ) {
                    alt50=2;
                }


                switch (alt50) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:792:11: op= TOK_LSHIFT s= ltl_remainder_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_LSHIFT,FOLLOW_TOK_LSHIFT_in_ltl_shift_expr7713); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ltl_remainder_expr_in_ltl_shift_expr7718);
            	    s=ltl_remainder_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_lshift(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:794:11: op= TOK_RSHIFT s= ltl_remainder_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_RSHIFT,FOLLOW_TOK_RSHIFT_in_ltl_shift_expr7742); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ltl_remainder_expr_in_ltl_shift_expr7747);
            	    s=ltl_remainder_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_rshift(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ltl_shift_expr

    public static class ltl_remainder_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ltl_remainder_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:798:1: ltl_remainder_expr returns [InternalSpec ret] : f= ltl_additive_expr (op= TOK_MOD s= ltl_additive_expr )* ;
    public final ltl_remainder_expr_return ltl_remainder_expr() throws RecognitionException {
        ltl_remainder_expr_return retval = new ltl_remainder_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ltl_additive_expr_return f = null;

        ltl_additive_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:801:9: (f= ltl_additive_expr (op= TOK_MOD s= ltl_additive_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:801:11: f= ltl_additive_expr (op= TOK_MOD s= ltl_additive_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ltl_additive_expr_in_ltl_remainder_expr7809);
            f=ltl_additive_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:802:9: (op= TOK_MOD s= ltl_additive_expr )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==TOK_MOD) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:802:11: op= TOK_MOD s= ltl_additive_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_MOD,FOLLOW_TOK_MOD_in_ltl_remainder_expr7825); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ltl_additive_expr_in_ltl_remainder_expr7830);
            	    s=ltl_additive_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_mod(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ltl_remainder_expr

    public static class ltl_additive_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ltl_additive_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:808:1: ltl_additive_expr returns [InternalSpec ret] : f= ltl_multiplicative_expr (op= TOK_PLUS s= ltl_multiplicative_expr | op= TOK_MINUS s= ltl_multiplicative_expr )* ;
    public final ltl_additive_expr_return ltl_additive_expr() throws RecognitionException {
        ltl_additive_expr_return retval = new ltl_additive_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ltl_multiplicative_expr_return f = null;

        ltl_multiplicative_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:811:9: (f= ltl_multiplicative_expr (op= TOK_PLUS s= ltl_multiplicative_expr | op= TOK_MINUS s= ltl_multiplicative_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:811:11: f= ltl_multiplicative_expr (op= TOK_PLUS s= ltl_multiplicative_expr | op= TOK_MINUS s= ltl_multiplicative_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ltl_multiplicative_expr_in_ltl_additive_expr7894);
            f=ltl_multiplicative_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:812:9: (op= TOK_PLUS s= ltl_multiplicative_expr | op= TOK_MINUS s= ltl_multiplicative_expr )*
            loop52:
            do {
                int alt52=3;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==TOK_PLUS) ) {
                    alt52=1;
                }
                else if ( (LA52_0==TOK_MINUS) ) {
                    alt52=2;
                }


                switch (alt52) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:812:11: op= TOK_PLUS s= ltl_multiplicative_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_PLUS,FOLLOW_TOK_PLUS_in_ltl_additive_expr7910); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ltl_multiplicative_expr_in_ltl_additive_expr7915);
            	    s=ltl_multiplicative_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_plus(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:814:11: op= TOK_MINUS s= ltl_multiplicative_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_MINUS,FOLLOW_TOK_MINUS_in_ltl_additive_expr7939); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ltl_multiplicative_expr_in_ltl_additive_expr7944);
            	    s=ltl_multiplicative_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_minus(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ltl_additive_expr

    public static class ltl_multiplicative_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ltl_multiplicative_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:818:1: ltl_multiplicative_expr returns [InternalSpec ret] : f= ltl_concatination_expr (op= TOK_TIMES s= ltl_concatination_expr | op= TOK_DIVIDE s= ltl_concatination_expr )* ;
    public final ltl_multiplicative_expr_return ltl_multiplicative_expr() throws RecognitionException {
        ltl_multiplicative_expr_return retval = new ltl_multiplicative_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ltl_concatination_expr_return f = null;

        ltl_concatination_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:821:9: (f= ltl_concatination_expr (op= TOK_TIMES s= ltl_concatination_expr | op= TOK_DIVIDE s= ltl_concatination_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:821:11: f= ltl_concatination_expr (op= TOK_TIMES s= ltl_concatination_expr | op= TOK_DIVIDE s= ltl_concatination_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ltl_concatination_expr_in_ltl_multiplicative_expr8005);
            f=ltl_concatination_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:822:9: (op= TOK_TIMES s= ltl_concatination_expr | op= TOK_DIVIDE s= ltl_concatination_expr )*
            loop53:
            do {
                int alt53=3;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==TOK_TIMES) ) {
                    alt53=1;
                }
                else if ( (LA53_0==TOK_DIVIDE) ) {
                    alt53=2;
                }


                switch (alt53) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:822:11: op= TOK_TIMES s= ltl_concatination_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_TIMES,FOLLOW_TOK_TIMES_in_ltl_multiplicative_expr8021); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ltl_concatination_expr_in_ltl_multiplicative_expr8026);
            	    s=ltl_concatination_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_times(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:824:11: op= TOK_DIVIDE s= ltl_concatination_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_DIVIDE,FOLLOW_TOK_DIVIDE_in_ltl_multiplicative_expr8050); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ltl_concatination_expr_in_ltl_multiplicative_expr8055);
            	    s=ltl_concatination_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_divide(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ltl_multiplicative_expr

    public static class ltl_concatination_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ltl_concatination_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:828:1: ltl_concatination_expr returns [InternalSpec ret] : f= ltl_primary_expr (op= TOK_CONCATENATION s= ltl_primary_expr )* ;
    public final ltl_concatination_expr_return ltl_concatination_expr() throws RecognitionException {
        ltl_concatination_expr_return retval = new ltl_concatination_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ltl_primary_expr_return f = null;

        ltl_primary_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:831:9: (f= ltl_primary_expr (op= TOK_CONCATENATION s= ltl_primary_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:831:11: f= ltl_primary_expr (op= TOK_CONCATENATION s= ltl_primary_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ltl_primary_expr_in_ltl_concatination_expr8116);
            f=ltl_primary_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:832:9: (op= TOK_CONCATENATION s= ltl_primary_expr )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==TOK_CONCATENATION) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:832:11: op= TOK_CONCATENATION s= ltl_primary_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_CONCATENATION,FOLLOW_TOK_CONCATENATION_in_ltl_concatination_expr8132); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ltl_primary_expr_in_ltl_concatination_expr8137);
            	    s=ltl_primary_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += op.getText() + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_concatenation(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ltl_concatination_expr

    public static class ltl_primary_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ltl_primary_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:837:1: ltl_primary_expr returns [InternalSpec ret] : ( ltl_primary_expr_helper1 | op= TOK_MINUS v= ltl_primary_expr -> ^( TOK_UNARY_MINUS_T $v) | op= TOK_NOT v= ltl_primary_expr -> ^( TOK_NOT $v) );
    public final ltl_primary_expr_return ltl_primary_expr() throws RecognitionException {
        ltl_primary_expr_return retval = new ltl_primary_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ltl_primary_expr_return v = null;

        ltl_primary_expr_helper1_return ltl_primary_expr_helper1134 = null;


        Object op_tree=null;
        RewriteRuleTokenStream stream_TOK_MINUS=new RewriteRuleTokenStream(adaptor,"token TOK_MINUS");
        RewriteRuleTokenStream stream_TOK_NOT=new RewriteRuleTokenStream(adaptor,"token TOK_NOT");
        RewriteRuleSubtreeStream stream_ltl_primary_expr=new RewriteRuleSubtreeStream(adaptor,"rule ltl_primary_expr");
        boolean append_end = false; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:840:9: ( ltl_primary_expr_helper1 | op= TOK_MINUS v= ltl_primary_expr -> ^( TOK_UNARY_MINUS_T $v) | op= TOK_NOT v= ltl_primary_expr -> ^( TOK_NOT $v) )
            int alt55=3;
            switch ( input.LA(1) ) {
            case TOK_PLUS:
            case TOK_LP:
            case TOK_BOOL:
            case TOK_WORD1:
            case TOK_NEXT:
            case TOK_CASE:
            case TOK_WAREAD:
            case TOK_WAWRITE:
            case TOK_ATOM:
            case TOK_NUMBER:
            case TOK_NUMBER_WORD:
            case TOK_FALSEEXP:
            case TOK_TRUEEXP:
                {
                alt55=1;
                }
                break;
            case TOK_MINUS:
                {
                alt55=2;
                }
                break;
            case TOK_NOT:
                {
                alt55=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("837:1: ltl_primary_expr returns [InternalSpec ret] : ( ltl_primary_expr_helper1 | op= TOK_MINUS v= ltl_primary_expr -> ^( TOK_UNARY_MINUS_T $v) | op= TOK_NOT v= ltl_primary_expr -> ^( TOK_NOT $v) );", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:840:11: ltl_primary_expr_helper1
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ltl_primary_expr_helper1_in_ltl_primary_expr8198);
                    ltl_primary_expr_helper1134=ltl_primary_expr_helper1();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, ltl_primary_expr_helper1134.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) retval.ret = ltl_primary_expr_helper1134.ret; 
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:842:11: op= TOK_MINUS v= ltl_primary_expr
                    {
                    op=(Token)input.LT(1);
                    match(input,TOK_MINUS,FOLLOW_TOK_MINUS_in_ltl_primary_expr8222); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_MINUS.add(op);

                    pushFollow(FOLLOW_ltl_primary_expr_in_ltl_primary_expr8226);
                    v=ltl_primary_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_ltl_primary_expr.add(v.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_unary_minus(input, ((Token)retval.start), op.getText() + " " + input.toString(v.start,v.stop), v.ret); 
                    }

                    // AST REWRITE
                    // elements: v
                    // token labels: 
                    // rule labels: v, retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_v=new RewriteRuleSubtreeStream(adaptor,"token v",v!=null?v.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 844:9: -> ^( TOK_UNARY_MINUS_T $v)
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:844:12: ^( TOK_UNARY_MINUS_T $v)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(TOK_UNARY_MINUS_T, "TOK_UNARY_MINUS_T"), root_1);

                        adaptor.addChild(root_1, stream_v.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:845:11: op= TOK_NOT v= ltl_primary_expr
                    {
                    op=(Token)input.LT(1);
                    match(input,TOK_NOT,FOLLOW_TOK_NOT_in_ltl_primary_expr8267); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_NOT.add(op);

                    pushFollow(FOLLOW_ltl_primary_expr_in_ltl_primary_expr8271);
                    v=ltl_primary_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_ltl_primary_expr.add(v.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_not(input, ((Token)retval.start), op.getText() + " " + input.toString(v.start,v.stop), v.ret); 
                    }

                    // AST REWRITE
                    // elements: v, TOK_NOT
                    // token labels: 
                    // rule labels: v, retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_v=new RewriteRuleSubtreeStream(adaptor,"token v",v!=null?v.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 847:9: -> ^( TOK_NOT $v)
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:847:12: ^( TOK_NOT $v)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_TOK_NOT.next(), root_1);

                        adaptor.addChild(root_1, stream_v.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ltl_primary_expr

    public static class ltl_primary_expr_helper1_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ltl_primary_expr_helper1
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:850:1: ltl_primary_expr_helper1 returns [InternalSpec ret] : ( constant primary_expr_select -> ^( VALUE_T constant NOP primary_expr_select ) | primary_expr_helper1_pointer1 | TOK_LP ltl_root_expr TOK_RP primary_expr_select -> ^( BLOCK_T ltl_root_expr NOP primary_expr_select ) | TOK_BOOL TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_BOOL simple_root_expr NOP primary_expr_select ) | TOK_WORD1 TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WORD1 simple_root_expr NOP primary_expr_select ) | TOK_NEXT TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_NEXT simple_root_expr NOP primary_expr_select ) | TOK_CASE case_element_list_expr TOK_ESAC primary_expr_select -> ^( CASE_LIST_EXPR_T case_element_list_expr NOP primary_expr_select ) | TOK_WAREAD TOK_LP f= simple_root_expr TOK_COMMA s= simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WAREAD $f $s NOP primary_expr_select ) | TOK_WAWRITE TOK_LP f= simple_root_expr tc1= TOK_COMMA m= simple_root_expr tc2= TOK_COMMA s= simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WAWRITE $f $m $s NOP primary_expr_select ) );
    public final ltl_primary_expr_helper1_return ltl_primary_expr_helper1() throws RecognitionException {
        ltl_primary_expr_helper1_return retval = new ltl_primary_expr_helper1_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token tc1=null;
        Token tc2=null;
        Token TOK_LP138=null;
        Token TOK_RP140=null;
        Token TOK_BOOL142=null;
        Token TOK_LP143=null;
        Token TOK_RP145=null;
        Token TOK_WORD1147=null;
        Token TOK_LP148=null;
        Token TOK_RP150=null;
        Token TOK_NEXT152=null;
        Token TOK_LP153=null;
        Token TOK_RP155=null;
        Token TOK_CASE157=null;
        Token TOK_ESAC159=null;
        Token TOK_WAREAD161=null;
        Token TOK_LP162=null;
        Token TOK_COMMA163=null;
        Token TOK_RP164=null;
        Token TOK_WAWRITE166=null;
        Token TOK_LP167=null;
        Token TOK_RP168=null;
        simple_root_expr_return f = null;

        simple_root_expr_return s = null;

        simple_root_expr_return m = null;

        constant_return constant135 = null;

        primary_expr_select_return primary_expr_select136 = null;

        primary_expr_helper1_pointer1_return primary_expr_helper1_pointer1137 = null;

        ltl_root_expr_return ltl_root_expr139 = null;

        primary_expr_select_return primary_expr_select141 = null;

        simple_root_expr_return simple_root_expr144 = null;

        primary_expr_select_return primary_expr_select146 = null;

        simple_root_expr_return simple_root_expr149 = null;

        primary_expr_select_return primary_expr_select151 = null;

        simple_root_expr_return simple_root_expr154 = null;

        primary_expr_select_return primary_expr_select156 = null;

        case_element_list_expr_return case_element_list_expr158 = null;

        primary_expr_select_return primary_expr_select160 = null;

        primary_expr_select_return primary_expr_select165 = null;

        primary_expr_select_return primary_expr_select169 = null;


        Object tc1_tree=null;
        Object tc2_tree=null;
        Object TOK_LP138_tree=null;
        Object TOK_RP140_tree=null;
        Object TOK_BOOL142_tree=null;
        Object TOK_LP143_tree=null;
        Object TOK_RP145_tree=null;
        Object TOK_WORD1147_tree=null;
        Object TOK_LP148_tree=null;
        Object TOK_RP150_tree=null;
        Object TOK_NEXT152_tree=null;
        Object TOK_LP153_tree=null;
        Object TOK_RP155_tree=null;
        Object TOK_CASE157_tree=null;
        Object TOK_ESAC159_tree=null;
        Object TOK_WAREAD161_tree=null;
        Object TOK_LP162_tree=null;
        Object TOK_COMMA163_tree=null;
        Object TOK_RP164_tree=null;
        Object TOK_WAWRITE166_tree=null;
        Object TOK_LP167_tree=null;
        Object TOK_RP168_tree=null;
        RewriteRuleTokenStream stream_TOK_LP=new RewriteRuleTokenStream(adaptor,"token TOK_LP");
        RewriteRuleTokenStream stream_TOK_BOOL=new RewriteRuleTokenStream(adaptor,"token TOK_BOOL");
        RewriteRuleTokenStream stream_TOK_WAWRITE=new RewriteRuleTokenStream(adaptor,"token TOK_WAWRITE");
        RewriteRuleTokenStream stream_TOK_WAREAD=new RewriteRuleTokenStream(adaptor,"token TOK_WAREAD");
        RewriteRuleTokenStream stream_TOK_WORD1=new RewriteRuleTokenStream(adaptor,"token TOK_WORD1");
        RewriteRuleTokenStream stream_TOK_RP=new RewriteRuleTokenStream(adaptor,"token TOK_RP");
        RewriteRuleTokenStream stream_TOK_CASE=new RewriteRuleTokenStream(adaptor,"token TOK_CASE");
        RewriteRuleTokenStream stream_TOK_ESAC=new RewriteRuleTokenStream(adaptor,"token TOK_ESAC");
        RewriteRuleTokenStream stream_TOK_NEXT=new RewriteRuleTokenStream(adaptor,"token TOK_NEXT");
        RewriteRuleTokenStream stream_TOK_COMMA=new RewriteRuleTokenStream(adaptor,"token TOK_COMMA");
        RewriteRuleSubtreeStream stream_case_element_list_expr=new RewriteRuleSubtreeStream(adaptor,"rule case_element_list_expr");
        RewriteRuleSubtreeStream stream_constant=new RewriteRuleSubtreeStream(adaptor,"rule constant");
        RewriteRuleSubtreeStream stream_ltl_root_expr=new RewriteRuleSubtreeStream(adaptor,"rule ltl_root_expr");
        RewriteRuleSubtreeStream stream_simple_root_expr=new RewriteRuleSubtreeStream(adaptor,"rule simple_root_expr");
        RewriteRuleSubtreeStream stream_primary_expr_select=new RewriteRuleSubtreeStream(adaptor,"rule primary_expr_select");
        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:853:9: ( constant primary_expr_select -> ^( VALUE_T constant NOP primary_expr_select ) | primary_expr_helper1_pointer1 | TOK_LP ltl_root_expr TOK_RP primary_expr_select -> ^( BLOCK_T ltl_root_expr NOP primary_expr_select ) | TOK_BOOL TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_BOOL simple_root_expr NOP primary_expr_select ) | TOK_WORD1 TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WORD1 simple_root_expr NOP primary_expr_select ) | TOK_NEXT TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_NEXT simple_root_expr NOP primary_expr_select ) | TOK_CASE case_element_list_expr TOK_ESAC primary_expr_select -> ^( CASE_LIST_EXPR_T case_element_list_expr NOP primary_expr_select ) | TOK_WAREAD TOK_LP f= simple_root_expr TOK_COMMA s= simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WAREAD $f $s NOP primary_expr_select ) | TOK_WAWRITE TOK_LP f= simple_root_expr tc1= TOK_COMMA m= simple_root_expr tc2= TOK_COMMA s= simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WAWRITE $f $m $s NOP primary_expr_select ) )
            int alt56=9;
            switch ( input.LA(1) ) {
            case TOK_PLUS:
            case TOK_NUMBER:
            case TOK_NUMBER_WORD:
            case TOK_FALSEEXP:
            case TOK_TRUEEXP:
                {
                alt56=1;
                }
                break;
            case TOK_ATOM:
                {
                alt56=2;
                }
                break;
            case TOK_LP:
                {
                alt56=3;
                }
                break;
            case TOK_BOOL:
                {
                alt56=4;
                }
                break;
            case TOK_WORD1:
                {
                alt56=5;
                }
                break;
            case TOK_NEXT:
                {
                alt56=6;
                }
                break;
            case TOK_CASE:
                {
                alt56=7;
                }
                break;
            case TOK_WAREAD:
                {
                alt56=8;
                }
                break;
            case TOK_WAWRITE:
                {
                alt56=9;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("850:1: ltl_primary_expr_helper1 returns [InternalSpec ret] : ( constant primary_expr_select -> ^( VALUE_T constant NOP primary_expr_select ) | primary_expr_helper1_pointer1 | TOK_LP ltl_root_expr TOK_RP primary_expr_select -> ^( BLOCK_T ltl_root_expr NOP primary_expr_select ) | TOK_BOOL TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_BOOL simple_root_expr NOP primary_expr_select ) | TOK_WORD1 TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WORD1 simple_root_expr NOP primary_expr_select ) | TOK_NEXT TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_NEXT simple_root_expr NOP primary_expr_select ) | TOK_CASE case_element_list_expr TOK_ESAC primary_expr_select -> ^( CASE_LIST_EXPR_T case_element_list_expr NOP primary_expr_select ) | TOK_WAREAD TOK_LP f= simple_root_expr TOK_COMMA s= simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WAREAD $f $s NOP primary_expr_select ) | TOK_WAWRITE TOK_LP f= simple_root_expr tc1= TOK_COMMA m= simple_root_expr tc2= TOK_COMMA s= simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WAWRITE $f $m $s NOP primary_expr_select ) );", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:853:11: constant primary_expr_select
                    {
                    pushFollow(FOLLOW_constant_in_ltl_primary_expr_helper18336);
                    constant135=constant();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_constant.add(constant135.getTree());
                    pushFollow(FOLLOW_primary_expr_select_in_ltl_primary_expr_helper18338);
                    primary_expr_select136=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select136.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    // AST REWRITE
                    // elements: constant, primary_expr_select
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 856:9: -> ^( VALUE_T constant NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:856:12: ^( VALUE_T constant NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(VALUE_T, "VALUE_T"), root_1);

                        adaptor.addChild(root_1, stream_constant.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:857:11: primary_expr_helper1_pointer1
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_primary_expr_helper1_pointer1_in_ltl_primary_expr_helper18389);
                    primary_expr_helper1_pointer1137=primary_expr_helper1_pointer1();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, primary_expr_helper1_pointer1137.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:866:11: TOK_LP ltl_root_expr TOK_RP primary_expr_select
                    {
                    TOK_LP138=(Token)input.LT(1);
                    match(input,TOK_LP,FOLLOW_TOK_LP_in_ltl_primary_expr_helper18442); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_LP.add(TOK_LP138);

                    pushFollow(FOLLOW_ltl_root_expr_in_ltl_primary_expr_helper18444);
                    ltl_root_expr139=ltl_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_ltl_root_expr.add(ltl_root_expr139.getTree());
                    TOK_RP140=(Token)input.LT(1);
                    match(input,TOK_RP,FOLLOW_TOK_RP_in_ltl_primary_expr_helper18446); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_RP.add(TOK_RP140);

                    pushFollow(FOLLOW_primary_expr_select_in_ltl_primary_expr_helper18448);
                    primary_expr_select141=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select141.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) retval.ret = ltl_root_expr139.ret; 
                    }

                    // AST REWRITE
                    // elements: ltl_root_expr, primary_expr_select
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 868:9: -> ^( BLOCK_T ltl_root_expr NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:868:12: ^( BLOCK_T ltl_root_expr NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(BLOCK_T, "BLOCK_T"), root_1);

                        adaptor.addChild(root_1, stream_ltl_root_expr.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 4 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:872:11: TOK_BOOL TOK_LP simple_root_expr TOK_RP primary_expr_select
                    {
                    TOK_BOOL142=(Token)input.LT(1);
                    match(input,TOK_BOOL,FOLLOW_TOK_BOOL_in_ltl_primary_expr_helper18519); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_BOOL.add(TOK_BOOL142);

                    TOK_LP143=(Token)input.LT(1);
                    match(input,TOK_LP,FOLLOW_TOK_LP_in_ltl_primary_expr_helper18521); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_LP.add(TOK_LP143);

                    pushFollow(FOLLOW_simple_root_expr_in_ltl_primary_expr_helper18523);
                    simple_root_expr144=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(simple_root_expr144.getTree());
                    TOK_RP145=(Token)input.LT(1);
                    match(input,TOK_RP,FOLLOW_TOK_RP_in_ltl_primary_expr_helper18525); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_RP.add(TOK_RP145);

                    pushFollow(FOLLOW_primary_expr_select_in_ltl_primary_expr_helper18527);
                    primary_expr_select146=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select146.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    // AST REWRITE
                    // elements: primary_expr_select, simple_root_expr, TOK_BOOL
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 875:9: -> ^( TOK_BOOL simple_root_expr NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:875:12: ^( TOK_BOOL simple_root_expr NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_TOK_BOOL.next(), root_1);

                        adaptor.addChild(root_1, stream_simple_root_expr.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 5 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:876:11: TOK_WORD1 TOK_LP simple_root_expr TOK_RP primary_expr_select
                    {
                    TOK_WORD1147=(Token)input.LT(1);
                    match(input,TOK_WORD1,FOLLOW_TOK_WORD1_in_ltl_primary_expr_helper18578); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_WORD1.add(TOK_WORD1147);

                    TOK_LP148=(Token)input.LT(1);
                    match(input,TOK_LP,FOLLOW_TOK_LP_in_ltl_primary_expr_helper18580); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_LP.add(TOK_LP148);

                    pushFollow(FOLLOW_simple_root_expr_in_ltl_primary_expr_helper18582);
                    simple_root_expr149=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(simple_root_expr149.getTree());
                    TOK_RP150=(Token)input.LT(1);
                    match(input,TOK_RP,FOLLOW_TOK_RP_in_ltl_primary_expr_helper18584); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_RP.add(TOK_RP150);

                    pushFollow(FOLLOW_primary_expr_select_in_ltl_primary_expr_helper18586);
                    primary_expr_select151=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select151.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    // AST REWRITE
                    // elements: TOK_WORD1, primary_expr_select, simple_root_expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 879:9: -> ^( TOK_WORD1 simple_root_expr NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:879:12: ^( TOK_WORD1 simple_root_expr NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_TOK_WORD1.next(), root_1);

                        adaptor.addChild(root_1, stream_simple_root_expr.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 6 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:881:11: TOK_NEXT TOK_LP simple_root_expr TOK_RP primary_expr_select
                    {
                    TOK_NEXT152=(Token)input.LT(1);
                    match(input,TOK_NEXT,FOLLOW_TOK_NEXT_in_ltl_primary_expr_helper18646); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_NEXT.add(TOK_NEXT152);

                    TOK_LP153=(Token)input.LT(1);
                    match(input,TOK_LP,FOLLOW_TOK_LP_in_ltl_primary_expr_helper18648); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_LP.add(TOK_LP153);

                    pushFollow(FOLLOW_simple_root_expr_in_ltl_primary_expr_helper18650);
                    simple_root_expr154=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(simple_root_expr154.getTree());
                    TOK_RP155=(Token)input.LT(1);
                    match(input,TOK_RP,FOLLOW_TOK_RP_in_ltl_primary_expr_helper18652); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_RP.add(TOK_RP155);

                    pushFollow(FOLLOW_primary_expr_select_in_ltl_primary_expr_helper18654);
                    primary_expr_select156=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select156.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    // AST REWRITE
                    // elements: simple_root_expr, primary_expr_select, TOK_NEXT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 884:9: -> ^( TOK_NEXT simple_root_expr NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:884:12: ^( TOK_NEXT simple_root_expr NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_TOK_NEXT.next(), root_1);

                        adaptor.addChild(root_1, stream_simple_root_expr.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 7 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:886:11: TOK_CASE case_element_list_expr TOK_ESAC primary_expr_select
                    {
                    TOK_CASE157=(Token)input.LT(1);
                    match(input,TOK_CASE,FOLLOW_TOK_CASE_in_ltl_primary_expr_helper18714); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_CASE.add(TOK_CASE157);

                    pushFollow(FOLLOW_case_element_list_expr_in_ltl_primary_expr_helper18716);
                    case_element_list_expr158=case_element_list_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_case_element_list_expr.add(case_element_list_expr158.getTree());
                    TOK_ESAC159=(Token)input.LT(1);
                    match(input,TOK_ESAC,FOLLOW_TOK_ESAC_in_ltl_primary_expr_helper18718); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_ESAC.add(TOK_ESAC159);

                    pushFollow(FOLLOW_primary_expr_select_in_ltl_primary_expr_helper18720);
                    primary_expr_select160=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select160.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    // AST REWRITE
                    // elements: case_element_list_expr, primary_expr_select
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 889:9: -> ^( CASE_LIST_EXPR_T case_element_list_expr NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:889:12: ^( CASE_LIST_EXPR_T case_element_list_expr NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(CASE_LIST_EXPR_T, "CASE_LIST_EXPR_T"), root_1);

                        adaptor.addChild(root_1, stream_case_element_list_expr.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 8 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:891:11: TOK_WAREAD TOK_LP f= simple_root_expr TOK_COMMA s= simple_root_expr TOK_RP primary_expr_select
                    {
                    TOK_WAREAD161=(Token)input.LT(1);
                    match(input,TOK_WAREAD,FOLLOW_TOK_WAREAD_in_ltl_primary_expr_helper18780); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_WAREAD.add(TOK_WAREAD161);

                    TOK_LP162=(Token)input.LT(1);
                    match(input,TOK_LP,FOLLOW_TOK_LP_in_ltl_primary_expr_helper18782); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_LP.add(TOK_LP162);

                    pushFollow(FOLLOW_simple_root_expr_in_ltl_primary_expr_helper18786);
                    f=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(f.getTree());
                    TOK_COMMA163=(Token)input.LT(1);
                    match(input,TOK_COMMA,FOLLOW_TOK_COMMA_in_ltl_primary_expr_helper18788); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_COMMA.add(TOK_COMMA163);

                    pushFollow(FOLLOW_simple_root_expr_in_ltl_primary_expr_helper18792);
                    s=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(s.getTree());
                    TOK_RP164=(Token)input.LT(1);
                    match(input,TOK_RP,FOLLOW_TOK_RP_in_ltl_primary_expr_helper18794); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_RP.add(TOK_RP164);

                    pushFollow(FOLLOW_primary_expr_select_in_ltl_primary_expr_helper18796);
                    primary_expr_select165=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select165.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    // AST REWRITE
                    // elements: f, TOK_WAREAD, s, primary_expr_select
                    // token labels: 
                    // rule labels: f, retval, s
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_f=new RewriteRuleSubtreeStream(adaptor,"token f",f!=null?f.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_s=new RewriteRuleSubtreeStream(adaptor,"token s",s!=null?s.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 894:9: -> ^( TOK_WAREAD $f $s NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:894:12: ^( TOK_WAREAD $f $s NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_TOK_WAREAD.next(), root_1);

                        adaptor.addChild(root_1, stream_f.next());
                        adaptor.addChild(root_1, stream_s.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 9 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:896:11: TOK_WAWRITE TOK_LP f= simple_root_expr tc1= TOK_COMMA m= simple_root_expr tc2= TOK_COMMA s= simple_root_expr TOK_RP primary_expr_select
                    {
                    TOK_WAWRITE166=(Token)input.LT(1);
                    match(input,TOK_WAWRITE,FOLLOW_TOK_WAWRITE_in_ltl_primary_expr_helper18860); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_WAWRITE.add(TOK_WAWRITE166);

                    TOK_LP167=(Token)input.LT(1);
                    match(input,TOK_LP,FOLLOW_TOK_LP_in_ltl_primary_expr_helper18862); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_LP.add(TOK_LP167);

                    pushFollow(FOLLOW_simple_root_expr_in_ltl_primary_expr_helper18866);
                    f=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(f.getTree());
                    tc1=(Token)input.LT(1);
                    match(input,TOK_COMMA,FOLLOW_TOK_COMMA_in_ltl_primary_expr_helper18870); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_COMMA.add(tc1);

                    pushFollow(FOLLOW_simple_root_expr_in_ltl_primary_expr_helper18874);
                    m=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(m.getTree());
                    tc2=(Token)input.LT(1);
                    match(input,TOK_COMMA,FOLLOW_TOK_COMMA_in_ltl_primary_expr_helper18878); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_COMMA.add(tc2);

                    pushFollow(FOLLOW_simple_root_expr_in_ltl_primary_expr_helper18882);
                    s=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(s.getTree());
                    TOK_RP168=(Token)input.LT(1);
                    match(input,TOK_RP,FOLLOW_TOK_RP_in_ltl_primary_expr_helper18884); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_RP.add(TOK_RP168);

                    pushFollow(FOLLOW_primary_expr_select_in_ltl_primary_expr_helper18886);
                    primary_expr_select169=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select169.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    // AST REWRITE
                    // elements: s, m, TOK_WAWRITE, f, primary_expr_select
                    // token labels: 
                    // rule labels: f, retval, s, m
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_f=new RewriteRuleSubtreeStream(adaptor,"token f",f!=null?f.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_s=new RewriteRuleSubtreeStream(adaptor,"token s",s!=null?s.tree:null);
                    RewriteRuleSubtreeStream stream_m=new RewriteRuleSubtreeStream(adaptor,"token m",m!=null?m.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 899:9: -> ^( TOK_WAWRITE $f $m $s NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:899:12: ^( TOK_WAWRITE $f $m $s NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_TOK_WAWRITE.next(), root_1);

                        adaptor.addChild(root_1, stream_f.next());
                        adaptor.addChild(root_1, stream_m.next());
                        adaptor.addChild(root_1, stream_s.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ltl_primary_expr_helper1

    public static class ctls_root_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctls_root_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:906:1: ctls_root_expr returns [InternalSpec ret] : ctls_implies_expr ;
    public final ctls_root_expr_return ctls_root_expr() throws RecognitionException {
        ctls_root_expr_return retval = new ctls_root_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ctls_implies_expr_return ctls_implies_expr170 = null;



        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:907:9: ( ctls_implies_expr )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:907:11: ctls_implies_expr
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ctls_implies_expr_in_ctls_root_expr8967);
            ctls_implies_expr170=ctls_implies_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, ctls_implies_expr170.getTree());
            if ( backtracking==0 ) {
              if(!er()) retval.ret = ctls_implies_expr170.ret; 
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
    // $ANTLR end ctls_root_expr

    public static class ctls_implies_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctls_implies_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:909:1: ctls_implies_expr returns [InternalSpec ret] : f= ctls_iff_expr (op= TOK_IMPLIES s= ctls_implies_expr )? ;
    public final ctls_implies_expr_return ctls_implies_expr() throws RecognitionException {
        ctls_implies_expr_return retval = new ctls_implies_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ctls_iff_expr_return f = null;

        ctls_implies_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:912:9: (f= ctls_iff_expr (op= TOK_IMPLIES s= ctls_implies_expr )? )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:912:11: f= ctls_iff_expr (op= TOK_IMPLIES s= ctls_implies_expr )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ctls_iff_expr_in_ctls_implies_expr9010);
            f=ctls_iff_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:913:9: (op= TOK_IMPLIES s= ctls_implies_expr )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==TOK_IMPLIES) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:913:11: op= TOK_IMPLIES s= ctls_implies_expr
                    {
                    op=(Token)input.LT(1);
                    match(input,TOK_IMPLIES,FOLLOW_TOK_IMPLIES_in_ctls_implies_expr9026); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ctls_implies_expr_in_ctls_implies_expr9031);
                    s=ctls_implies_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_imply(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctls_implies_expr

    public static class ctls_iff_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctls_iff_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:917:1: ctls_iff_expr returns [InternalSpec ret] : f= ctls_or_expr (op= TOK_IFF s= ctls_or_expr )* ;
    public final ctls_iff_expr_return ctls_iff_expr() throws RecognitionException {
        ctls_iff_expr_return retval = new ctls_iff_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ctls_or_expr_return f = null;

        ctls_or_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:920:9: (f= ctls_or_expr (op= TOK_IFF s= ctls_or_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:920:11: f= ctls_or_expr (op= TOK_IFF s= ctls_or_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ctls_or_expr_in_ctls_iff_expr9096);
            f=ctls_or_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:921:9: (op= TOK_IFF s= ctls_or_expr )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==TOK_IFF) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:921:11: op= TOK_IFF s= ctls_or_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_IFF,FOLLOW_TOK_IFF_in_ctls_iff_expr9112); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctls_or_expr_in_ctls_iff_expr9117);
            	    s=ctls_or_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_iff(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctls_iff_expr

    public static class ctls_or_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctls_or_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:925:1: ctls_or_expr returns [InternalSpec ret] : f= ctls_and_expr (op= TOK_OR s= ctls_and_expr | op= TOK_XOR s= ctls_and_expr | op= TOK_XNOR s= ctls_and_expr )* ;
    public final ctls_or_expr_return ctls_or_expr() throws RecognitionException {
        ctls_or_expr_return retval = new ctls_or_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ctls_and_expr_return f = null;

        ctls_and_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:928:9: (f= ctls_and_expr (op= TOK_OR s= ctls_and_expr | op= TOK_XOR s= ctls_and_expr | op= TOK_XNOR s= ctls_and_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:928:11: f= ctls_and_expr (op= TOK_OR s= ctls_and_expr | op= TOK_XOR s= ctls_and_expr | op= TOK_XNOR s= ctls_and_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ctls_and_expr_in_ctls_or_expr9180);
            f=ctls_and_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:929:9: (op= TOK_OR s= ctls_and_expr | op= TOK_XOR s= ctls_and_expr | op= TOK_XNOR s= ctls_and_expr )*
            loop59:
            do {
                int alt59=4;
                switch ( input.LA(1) ) {
                case TOK_OR:
                    {
                    alt59=1;
                    }
                    break;
                case TOK_XOR:
                    {
                    alt59=2;
                    }
                    break;
                case TOK_XNOR:
                    {
                    alt59=3;
                    }
                    break;

                }

                switch (alt59) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:929:11: op= TOK_OR s= ctls_and_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_OR,FOLLOW_TOK_OR_in_ctls_or_expr9196); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctls_and_expr_in_ctls_or_expr9201);
            	    s=ctls_and_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_or(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:931:11: op= TOK_XOR s= ctls_and_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_XOR,FOLLOW_TOK_XOR_in_ctls_or_expr9225); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctls_and_expr_in_ctls_or_expr9230);
            	    s=ctls_and_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_xor(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 3 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:933:11: op= TOK_XNOR s= ctls_and_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_XNOR,FOLLOW_TOK_XNOR_in_ctls_or_expr9254); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctls_and_expr_in_ctls_or_expr9259);
            	    s=ctls_and_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_xnor(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop59;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctls_or_expr

    public static class ctls_and_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctls_and_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:937:1: ctls_and_expr returns [InternalSpec ret] : f= ctls_ltl_binary_expr (op= TOK_AND s= ctls_ltl_binary_expr )* ;
    public final ctls_and_expr_return ctls_and_expr() throws RecognitionException {
        ctls_and_expr_return retval = new ctls_and_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ctls_ltl_binary_expr_return f = null;

        ctls_ltl_binary_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:940:9: (f= ctls_ltl_binary_expr (op= TOK_AND s= ctls_ltl_binary_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:940:11: f= ctls_ltl_binary_expr (op= TOK_AND s= ctls_ltl_binary_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ctls_ltl_binary_expr_in_ctls_and_expr9322);
            f=ctls_ltl_binary_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:941:9: (op= TOK_AND s= ctls_ltl_binary_expr )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==TOK_AND) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:941:11: op= TOK_AND s= ctls_ltl_binary_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_AND,FOLLOW_TOK_AND_in_ctls_and_expr9338); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctls_ltl_binary_expr_in_ctls_and_expr9343);
            	    s=ctls_ltl_binary_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_and(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctls_and_expr

    public static class ctls_ltl_binary_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctls_ltl_binary_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:947:1: ctls_ltl_binary_expr returns [InternalSpec ret] : f= ctls_ltl_unary_expr (op= TOK_UNTIL s= ctls_ltl_unary_expr | op= TOK_SINCE s= ctls_ltl_unary_expr | op= TOK_RELEASES s= ctls_ltl_unary_expr | op= TOK_TRIGGERED s= ctls_ltl_unary_expr )* ;
    public final ctls_ltl_binary_expr_return ctls_ltl_binary_expr() throws RecognitionException {
        ctls_ltl_binary_expr_return retval = new ctls_ltl_binary_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ctls_ltl_unary_expr_return f = null;

        ctls_ltl_unary_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:950:9: (f= ctls_ltl_unary_expr (op= TOK_UNTIL s= ctls_ltl_unary_expr | op= TOK_SINCE s= ctls_ltl_unary_expr | op= TOK_RELEASES s= ctls_ltl_unary_expr | op= TOK_TRIGGERED s= ctls_ltl_unary_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:950:11: f= ctls_ltl_unary_expr (op= TOK_UNTIL s= ctls_ltl_unary_expr | op= TOK_SINCE s= ctls_ltl_unary_expr | op= TOK_RELEASES s= ctls_ltl_unary_expr | op= TOK_TRIGGERED s= ctls_ltl_unary_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ctls_ltl_unary_expr_in_ctls_ltl_binary_expr9407);
            f=ctls_ltl_unary_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:951:9: (op= TOK_UNTIL s= ctls_ltl_unary_expr | op= TOK_SINCE s= ctls_ltl_unary_expr | op= TOK_RELEASES s= ctls_ltl_unary_expr | op= TOK_TRIGGERED s= ctls_ltl_unary_expr )*
            loop61:
            do {
                int alt61=5;
                switch ( input.LA(1) ) {
                case TOK_UNTIL:
                    {
                    alt61=1;
                    }
                    break;
                case TOK_SINCE:
                    {
                    alt61=2;
                    }
                    break;
                case TOK_RELEASES:
                    {
                    alt61=3;
                    }
                    break;
                case TOK_TRIGGERED:
                    {
                    alt61=4;
                    }
                    break;

                }

                switch (alt61) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:951:11: op= TOK_UNTIL s= ctls_ltl_unary_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_UNTIL,FOLLOW_TOK_UNTIL_in_ctls_ltl_binary_expr9423); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctls_ltl_unary_expr_in_ctls_ltl_binary_expr9428);
            	    s=ctls_ltl_unary_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_until(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:953:11: op= TOK_SINCE s= ctls_ltl_unary_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_SINCE,FOLLOW_TOK_SINCE_in_ctls_ltl_binary_expr9453); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctls_ltl_unary_expr_in_ctls_ltl_binary_expr9458);
            	    s=ctls_ltl_unary_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_since(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 3 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:955:11: op= TOK_RELEASES s= ctls_ltl_unary_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_RELEASES,FOLLOW_TOK_RELEASES_in_ctls_ltl_binary_expr9483); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctls_ltl_unary_expr_in_ctls_ltl_binary_expr9488);
            	    s=ctls_ltl_unary_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_releases(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 4 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:957:11: op= TOK_TRIGGERED s= ctls_ltl_unary_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_TRIGGERED,FOLLOW_TOK_TRIGGERED_in_ctls_ltl_binary_expr9513); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctls_ltl_unary_expr_in_ctls_ltl_binary_expr9518);
            	    s=ctls_ltl_unary_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_triggered(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctls_ltl_binary_expr

    public static class ctls_ltl_unary_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctls_ltl_unary_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:961:1: ctls_ltl_unary_expr returns [InternalSpec ret] : ( ( ( TOK_NOT )* ( TOK_OP_NEXT | TOK_OP_PREV | TOK_OP_NOTPREVNOT | TOK_OP_GLOBALLY | TOK_OP_HISTORICALLY | TOK_OP_FINALLY | TOK_OP_ONCE ) )=> ctls_ltl_pure_unary_expr -> ^( PURE_LTL_T ctls_ltl_pure_unary_expr ) | ctls_ctl_expr );
    public final ctls_ltl_unary_expr_return ctls_ltl_unary_expr() throws RecognitionException {
        ctls_ltl_unary_expr_return retval = new ctls_ltl_unary_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ctls_ltl_pure_unary_expr_return ctls_ltl_pure_unary_expr171 = null;

        ctls_ctl_expr_return ctls_ctl_expr172 = null;


        RewriteRuleSubtreeStream stream_ctls_ltl_pure_unary_expr=new RewriteRuleSubtreeStream(adaptor,"rule ctls_ltl_pure_unary_expr");
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:962:9: ( ( ( TOK_NOT )* ( TOK_OP_NEXT | TOK_OP_PREV | TOK_OP_NOTPREVNOT | TOK_OP_GLOBALLY | TOK_OP_HISTORICALLY | TOK_OP_FINALLY | TOK_OP_ONCE ) )=> ctls_ltl_pure_unary_expr -> ^( PURE_LTL_T ctls_ltl_pure_unary_expr ) | ctls_ctl_expr )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==TOK_OP_NEXT) && (synpred7())) {
                alt62=1;
            }
            else if ( (LA62_0==TOK_OP_PREV) && (synpred7())) {
                alt62=1;
            }
            else if ( (LA62_0==TOK_OP_NOTPREVNOT) && (synpred7())) {
                alt62=1;
            }
            else if ( (LA62_0==TOK_OP_GLOBALLY) && (synpred7())) {
                alt62=1;
            }
            else if ( (LA62_0==TOK_OP_HISTORICALLY) && (synpred7())) {
                alt62=1;
            }
            else if ( (LA62_0==TOK_OP_FINALLY) && (synpred7())) {
                alt62=1;
            }
            else if ( (LA62_0==TOK_OP_ONCE) && (synpred7())) {
                alt62=1;
            }
            else if ( (LA62_0==TOK_NOT) ) {
                int LA62_8 = input.LA(2);

                if ( ((LA62_8>=TOK_PLUS && LA62_8<=TOK_MINUS)||LA62_8==TOK_LP||(LA62_8>=TOK_BOOL && LA62_8<=TOK_CASE)||(LA62_8>=TOK_WAREAD && LA62_8<=TOK_AA)||LA62_8==TOK_EE||LA62_8==TOK_ATOM||LA62_8==TOK_NUMBER||LA62_8==TOK_NUMBER_WORD||(LA62_8>=TOK_FALSEEXP && LA62_8<=TOK_TRUEEXP)) ) {
                    alt62=2;
                }
                else if ( (LA62_8==TOK_NOT) ) {
                    int LA62_10 = input.LA(3);

                    if ( (synpred7()) ) {
                        alt62=1;
                    }
                    else if ( (true) ) {
                        alt62=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("961:1: ctls_ltl_unary_expr returns [InternalSpec ret] : ( ( ( TOK_NOT )* ( TOK_OP_NEXT | TOK_OP_PREV | TOK_OP_NOTPREVNOT | TOK_OP_GLOBALLY | TOK_OP_HISTORICALLY | TOK_OP_FINALLY | TOK_OP_ONCE ) )=> ctls_ltl_pure_unary_expr -> ^( PURE_LTL_T ctls_ltl_pure_unary_expr ) | ctls_ctl_expr );", 62, 10, input);

                        throw nvae;
                    }
                }
                else if ( (LA62_8==TOK_OP_NEXT) && (synpred7())) {
                    alt62=1;
                }
                else if ( (LA62_8==TOK_OP_PREV) && (synpred7())) {
                    alt62=1;
                }
                else if ( (LA62_8==TOK_OP_NOTPREVNOT) && (synpred7())) {
                    alt62=1;
                }
                else if ( (LA62_8==TOK_OP_GLOBALLY) && (synpred7())) {
                    alt62=1;
                }
                else if ( (LA62_8==TOK_OP_HISTORICALLY) && (synpred7())) {
                    alt62=1;
                }
                else if ( (LA62_8==TOK_OP_FINALLY) && (synpred7())) {
                    alt62=1;
                }
                else if ( (LA62_8==TOK_OP_ONCE) && (synpred7())) {
                    alt62=1;
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("961:1: ctls_ltl_unary_expr returns [InternalSpec ret] : ( ( ( TOK_NOT )* ( TOK_OP_NEXT | TOK_OP_PREV | TOK_OP_NOTPREVNOT | TOK_OP_GLOBALLY | TOK_OP_HISTORICALLY | TOK_OP_FINALLY | TOK_OP_ONCE ) )=> ctls_ltl_pure_unary_expr -> ^( PURE_LTL_T ctls_ltl_pure_unary_expr ) | ctls_ctl_expr );", 62, 8, input);

                    throw nvae;
                }
            }
            else if ( (LA62_0==TOK_LCB||(LA62_0>=TOK_PLUS && LA62_0<=TOK_MINUS)||LA62_0==TOK_LP||(LA62_0>=TOK_BOOL && LA62_0<=TOK_CASE)||(LA62_0>=TOK_WAREAD && LA62_0<=TOK_AA)||LA62_0==TOK_EE||LA62_0==TOK_ATOM||LA62_0==TOK_NUMBER||LA62_0==TOK_NUMBER_WORD||(LA62_0>=TOK_FALSEEXP && LA62_0<=TOK_TRUEEXP)) ) {
                alt62=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("961:1: ctls_ltl_unary_expr returns [InternalSpec ret] : ( ( ( TOK_NOT )* ( TOK_OP_NEXT | TOK_OP_PREV | TOK_OP_NOTPREVNOT | TOK_OP_GLOBALLY | TOK_OP_HISTORICALLY | TOK_OP_FINALLY | TOK_OP_ONCE ) )=> ctls_ltl_pure_unary_expr -> ^( PURE_LTL_T ctls_ltl_pure_unary_expr ) | ctls_ctl_expr );", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:962:11: ( ( TOK_NOT )* ( TOK_OP_NEXT | TOK_OP_PREV | TOK_OP_NOTPREVNOT | TOK_OP_GLOBALLY | TOK_OP_HISTORICALLY | TOK_OP_FINALLY | TOK_OP_ONCE ) )=> ctls_ltl_pure_unary_expr
                    {
                    pushFollow(FOLLOW_ctls_ltl_pure_unary_expr_in_ctls_ltl_unary_expr9669);
                    ctls_ltl_pure_unary_expr171=ctls_ltl_pure_unary_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_ctls_ltl_pure_unary_expr.add(ctls_ltl_pure_unary_expr171.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) retval.ret = ctls_ltl_pure_unary_expr171.ret; 
                    }

                    // AST REWRITE
                    // elements: ctls_ltl_pure_unary_expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 971:9: -> ^( PURE_LTL_T ctls_ltl_pure_unary_expr )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:971:12: ^( PURE_LTL_T ctls_ltl_pure_unary_expr )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(PURE_LTL_T, "PURE_LTL_T"), root_1);

                        adaptor.addChild(root_1, stream_ctls_ltl_pure_unary_expr.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:972:11: ctls_ctl_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ctls_ctl_expr_in_ctls_ltl_unary_expr9710);
                    ctls_ctl_expr172=ctls_ctl_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, ctls_ctl_expr172.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) retval.ret = ctls_ctl_expr172.ret; 
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
    // $ANTLR end ctls_ltl_unary_expr

    public static class ctls_ltl_pure_unary_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctls_ltl_pure_unary_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:975:1: ctls_ltl_pure_unary_expr returns [InternalSpec ret] : (op= TOK_OP_NEXT f= ctls_ltl_unary_expr | op= TOK_OP_PREV f= ctls_ltl_unary_expr | op= TOK_OP_NOTPREVNOT f= ctls_ltl_unary_expr | op= TOK_OP_GLOBALLY f= ctls_ltl_unary_expr | op= TOK_OP_HISTORICALLY f= ctls_ltl_unary_expr | op= TOK_OP_FINALLY f= ctls_ltl_unary_expr | op= TOK_OP_ONCE f= ctls_ltl_unary_expr | op= TOK_NOT fp= ctls_ltl_pure_unary_expr );
    public final ctls_ltl_pure_unary_expr_return ctls_ltl_pure_unary_expr() throws RecognitionException {
        ctls_ltl_pure_unary_expr_return retval = new ctls_ltl_pure_unary_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ctls_ltl_unary_expr_return f = null;

        ctls_ltl_pure_unary_expr_return fp = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:978:9: (op= TOK_OP_NEXT f= ctls_ltl_unary_expr | op= TOK_OP_PREV f= ctls_ltl_unary_expr | op= TOK_OP_NOTPREVNOT f= ctls_ltl_unary_expr | op= TOK_OP_GLOBALLY f= ctls_ltl_unary_expr | op= TOK_OP_HISTORICALLY f= ctls_ltl_unary_expr | op= TOK_OP_FINALLY f= ctls_ltl_unary_expr | op= TOK_OP_ONCE f= ctls_ltl_unary_expr | op= TOK_NOT fp= ctls_ltl_pure_unary_expr )
            int alt63=8;
            switch ( input.LA(1) ) {
            case TOK_OP_NEXT:
                {
                alt63=1;
                }
                break;
            case TOK_OP_PREV:
                {
                alt63=2;
                }
                break;
            case TOK_OP_NOTPREVNOT:
                {
                alt63=3;
                }
                break;
            case TOK_OP_GLOBALLY:
                {
                alt63=4;
                }
                break;
            case TOK_OP_HISTORICALLY:
                {
                alt63=5;
                }
                break;
            case TOK_OP_FINALLY:
                {
                alt63=6;
                }
                break;
            case TOK_OP_ONCE:
                {
                alt63=7;
                }
                break;
            case TOK_NOT:
                {
                alt63=8;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("975:1: ctls_ltl_pure_unary_expr returns [InternalSpec ret] : (op= TOK_OP_NEXT f= ctls_ltl_unary_expr | op= TOK_OP_PREV f= ctls_ltl_unary_expr | op= TOK_OP_NOTPREVNOT f= ctls_ltl_unary_expr | op= TOK_OP_GLOBALLY f= ctls_ltl_unary_expr | op= TOK_OP_HISTORICALLY f= ctls_ltl_unary_expr | op= TOK_OP_FINALLY f= ctls_ltl_unary_expr | op= TOK_OP_ONCE f= ctls_ltl_unary_expr | op= TOK_NOT fp= ctls_ltl_pure_unary_expr );", 63, 0, input);

                throw nvae;
            }

            switch (alt63) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:978:11: op= TOK_OP_NEXT f= ctls_ltl_unary_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_OP_NEXT,FOLLOW_TOK_OP_NEXT_in_ctls_ltl_pure_unary_expr9760); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ctls_ltl_unary_expr_in_ctls_ltl_pure_unary_expr9765);
                    f=ctls_ltl_unary_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(f.start,f.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_next(input, ((Token)retval.start), exp_str, f.ret); 
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:980:11: op= TOK_OP_PREV f= ctls_ltl_unary_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_OP_PREV,FOLLOW_TOK_OP_PREV_in_ctls_ltl_pure_unary_expr9789); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ctls_ltl_unary_expr_in_ctls_ltl_pure_unary_expr9794);
                    f=ctls_ltl_unary_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(f.start,f.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_prev(input, ((Token)retval.start), exp_str, f.ret); 
                    }

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:982:11: op= TOK_OP_NOTPREVNOT f= ctls_ltl_unary_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_OP_NOTPREVNOT,FOLLOW_TOK_OP_NOTPREVNOT_in_ctls_ltl_pure_unary_expr9818); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ctls_ltl_unary_expr_in_ctls_ltl_pure_unary_expr9823);
                    f=ctls_ltl_unary_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(f.start,f.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_notprevnot(input, ((Token)retval.start), exp_str, f.ret); 
                    }

                    }
                    break;
                case 4 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:984:11: op= TOK_OP_GLOBALLY f= ctls_ltl_unary_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_OP_GLOBALLY,FOLLOW_TOK_OP_GLOBALLY_in_ctls_ltl_pure_unary_expr9847); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ctls_ltl_unary_expr_in_ctls_ltl_pure_unary_expr9852);
                    f=ctls_ltl_unary_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(f.start,f.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_globally(input, ((Token)retval.start), exp_str, f.ret); 
                    }

                    }
                    break;
                case 5 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:986:11: op= TOK_OP_HISTORICALLY f= ctls_ltl_unary_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_OP_HISTORICALLY,FOLLOW_TOK_OP_HISTORICALLY_in_ctls_ltl_pure_unary_expr9876); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ctls_ltl_unary_expr_in_ctls_ltl_pure_unary_expr9881);
                    f=ctls_ltl_unary_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(f.start,f.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_historically(input, ((Token)retval.start), exp_str, f.ret); 
                    }

                    }
                    break;
                case 6 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:988:11: op= TOK_OP_FINALLY f= ctls_ltl_unary_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_OP_FINALLY,FOLLOW_TOK_OP_FINALLY_in_ctls_ltl_pure_unary_expr9905); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ctls_ltl_unary_expr_in_ctls_ltl_pure_unary_expr9910);
                    f=ctls_ltl_unary_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(f.start,f.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_finally(input, ((Token)retval.start), exp_str, f.ret); 
                    }

                    }
                    break;
                case 7 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:990:11: op= TOK_OP_ONCE f= ctls_ltl_unary_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_OP_ONCE,FOLLOW_TOK_OP_ONCE_in_ctls_ltl_pure_unary_expr9934); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ctls_ltl_unary_expr_in_ctls_ltl_pure_unary_expr9939);
                    f=ctls_ltl_unary_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(f.start,f.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_once(input, ((Token)retval.start), exp_str, f.ret); 
                    }

                    }
                    break;
                case 8 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:993:11: op= TOK_NOT fp= ctls_ltl_pure_unary_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_NOT,FOLLOW_TOK_NOT_in_ctls_ltl_pure_unary_expr9973); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ctls_ltl_pure_unary_expr_in_ctls_ltl_pure_unary_expr9978);
                    fp=ctls_ltl_pure_unary_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, fp.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(fp.start,fp.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_not(input, ((Token)retval.start), exp_str, fp.ret); 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctls_ltl_pure_unary_expr

    public static class ctls_ctl_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctls_ctl_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:998:1: ctls_ctl_expr returns [InternalSpec ret] : ( ( ( TOK_NOT )* ( TOK_EX | TOK_AX | TOK_EF | TOK_AF | TOK_EG | TOK_AG | TOK_AA | TOK_EE | TOK_EBF | TOK_ABF | TOK_EBG | TOK_ABG ) )=> ctls_pure_ctl_expr -> ^( PURE_CTL_T ctls_pure_ctl_expr ) | ctls_relational_expr );
    public final ctls_ctl_expr_return ctls_ctl_expr() throws RecognitionException {
        ctls_ctl_expr_return retval = new ctls_ctl_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ctls_pure_ctl_expr_return ctls_pure_ctl_expr173 = null;

        ctls_relational_expr_return ctls_relational_expr174 = null;


        RewriteRuleSubtreeStream stream_ctls_pure_ctl_expr=new RewriteRuleSubtreeStream(adaptor,"rule ctls_pure_ctl_expr");
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:999:9: ( ( ( TOK_NOT )* ( TOK_EX | TOK_AX | TOK_EF | TOK_AF | TOK_EG | TOK_AG | TOK_AA | TOK_EE | TOK_EBF | TOK_ABF | TOK_EBG | TOK_ABG ) )=> ctls_pure_ctl_expr -> ^( PURE_CTL_T ctls_pure_ctl_expr ) | ctls_relational_expr )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==TOK_EX) && (synpred8())) {
                alt64=1;
            }
            else if ( (LA64_0==TOK_AX) && (synpred8())) {
                alt64=1;
            }
            else if ( (LA64_0==TOK_EF) && (synpred8())) {
                alt64=1;
            }
            else if ( (LA64_0==TOK_AF) && (synpred8())) {
                alt64=1;
            }
            else if ( (LA64_0==TOK_EG) && (synpred8())) {
                alt64=1;
            }
            else if ( (LA64_0==TOK_AG) && (synpred8())) {
                alt64=1;
            }
            else if ( (LA64_0==TOK_AA) && (synpred8())) {
                alt64=1;
            }
            else if ( (LA64_0==TOK_EE) && (synpred8())) {
                alt64=1;
            }
            else if ( (LA64_0==TOK_EBF) && (synpred8())) {
                alt64=1;
            }
            else if ( (LA64_0==TOK_ABF) && (synpred8())) {
                alt64=1;
            }
            else if ( (LA64_0==TOK_EBG) && (synpred8())) {
                alt64=1;
            }
            else if ( (LA64_0==TOK_ABG) && (synpred8())) {
                alt64=1;
            }
            else if ( (LA64_0==TOK_NOT) ) {
                int LA64_13 = input.LA(2);

                if ( ((LA64_13>=TOK_PLUS && LA64_13<=TOK_MINUS)||LA64_13==TOK_LP||(LA64_13>=TOK_BOOL && LA64_13<=TOK_CASE)||(LA64_13>=TOK_WAREAD && LA64_13<=TOK_WAWRITE)||LA64_13==TOK_ATOM||LA64_13==TOK_NUMBER||LA64_13==TOK_NUMBER_WORD||(LA64_13>=TOK_FALSEEXP && LA64_13<=TOK_TRUEEXP)) ) {
                    alt64=2;
                }
                else if ( (LA64_13==TOK_NOT) ) {
                    int LA64_15 = input.LA(3);

                    if ( (synpred8()) ) {
                        alt64=1;
                    }
                    else if ( (true) ) {
                        alt64=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("998:1: ctls_ctl_expr returns [InternalSpec ret] : ( ( ( TOK_NOT )* ( TOK_EX | TOK_AX | TOK_EF | TOK_AF | TOK_EG | TOK_AG | TOK_AA | TOK_EE | TOK_EBF | TOK_ABF | TOK_EBG | TOK_ABG ) )=> ctls_pure_ctl_expr -> ^( PURE_CTL_T ctls_pure_ctl_expr ) | ctls_relational_expr );", 64, 15, input);

                        throw nvae;
                    }
                }
                else if ( (LA64_13==TOK_EX) && (synpred8())) {
                    alt64=1;
                }
                else if ( (LA64_13==TOK_AX) && (synpred8())) {
                    alt64=1;
                }
                else if ( (LA64_13==TOK_EF) && (synpred8())) {
                    alt64=1;
                }
                else if ( (LA64_13==TOK_AF) && (synpred8())) {
                    alt64=1;
                }
                else if ( (LA64_13==TOK_EG) && (synpred8())) {
                    alt64=1;
                }
                else if ( (LA64_13==TOK_AG) && (synpred8())) {
                    alt64=1;
                }
                else if ( (LA64_13==TOK_AA) && (synpred8())) {
                    alt64=1;
                }
                else if ( (LA64_13==TOK_EE) && (synpred8())) {
                    alt64=1;
                }
                else if ( (LA64_13==TOK_EBF) && (synpred8())) {
                    alt64=1;
                }
                else if ( (LA64_13==TOK_ABF) && (synpred8())) {
                    alt64=1;
                }
                else if ( (LA64_13==TOK_EBG) && (synpred8())) {
                    alt64=1;
                }
                else if ( (LA64_13==TOK_ABG) && (synpred8())) {
                    alt64=1;
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("998:1: ctls_ctl_expr returns [InternalSpec ret] : ( ( ( TOK_NOT )* ( TOK_EX | TOK_AX | TOK_EF | TOK_AF | TOK_EG | TOK_AG | TOK_AA | TOK_EE | TOK_EBF | TOK_ABF | TOK_EBG | TOK_ABG ) )=> ctls_pure_ctl_expr -> ^( PURE_CTL_T ctls_pure_ctl_expr ) | ctls_relational_expr );", 64, 13, input);

                    throw nvae;
                }
            }
            else if ( (LA64_0==TOK_LCB||(LA64_0>=TOK_PLUS && LA64_0<=TOK_MINUS)||LA64_0==TOK_LP||(LA64_0>=TOK_BOOL && LA64_0<=TOK_CASE)||(LA64_0>=TOK_WAREAD && LA64_0<=TOK_WAWRITE)||LA64_0==TOK_ATOM||LA64_0==TOK_NUMBER||LA64_0==TOK_NUMBER_WORD||(LA64_0>=TOK_FALSEEXP && LA64_0<=TOK_TRUEEXP)) ) {
                alt64=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("998:1: ctls_ctl_expr returns [InternalSpec ret] : ( ( ( TOK_NOT )* ( TOK_EX | TOK_AX | TOK_EF | TOK_AF | TOK_EG | TOK_AG | TOK_AA | TOK_EE | TOK_EBF | TOK_ABF | TOK_EBG | TOK_ABG ) )=> ctls_pure_ctl_expr -> ^( PURE_CTL_T ctls_pure_ctl_expr ) | ctls_relational_expr );", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:999:11: ( ( TOK_NOT )* ( TOK_EX | TOK_AX | TOK_EF | TOK_AF | TOK_EG | TOK_AG | TOK_AA | TOK_EE | TOK_EBF | TOK_ABF | TOK_EBG | TOK_ABG ) )=> ctls_pure_ctl_expr
                    {
                    pushFollow(FOLLOW_ctls_pure_ctl_expr_in_ctls_ctl_expr10197);
                    ctls_pure_ctl_expr173=ctls_pure_ctl_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_ctls_pure_ctl_expr.add(ctls_pure_ctl_expr173.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) retval.ret = ctls_pure_ctl_expr173.ret; 
                    }

                    // AST REWRITE
                    // elements: ctls_pure_ctl_expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1013:9: -> ^( PURE_CTL_T ctls_pure_ctl_expr )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1013:12: ^( PURE_CTL_T ctls_pure_ctl_expr )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(PURE_CTL_T, "PURE_CTL_T"), root_1);

                        adaptor.addChild(root_1, stream_ctls_pure_ctl_expr.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1014:11: ctls_relational_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ctls_relational_expr_in_ctls_ctl_expr10235);
                    ctls_relational_expr174=ctls_relational_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, ctls_relational_expr174.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) retval.ret = ctls_relational_expr174.ret; 
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
    // $ANTLR end ctls_ctl_expr

    public static class ctls_pure_ctl_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctls_pure_ctl_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1017:1: ctls_pure_ctl_expr returns [InternalSpec ret] : (op= TOK_EX f= ctls_ctl_expr | op= TOK_AX f= ctls_ctl_expr | op= TOK_EF f= ctls_ctl_expr | op= TOK_AF f= ctls_ctl_expr | op= TOK_EG f= ctls_ctl_expr | op= TOK_AG f= ctls_ctl_expr | ( TOK_AA )=> ctls_aa | ( TOK_EE )=> ctls_ee | op= TOK_EBF fsr= subrange s= ctls_ctl_expr | op= TOK_ABF fsr= subrange s= ctls_ctl_expr | op= TOK_EBG fsr= subrange s= ctls_ctl_expr | op= TOK_ABG fsr= subrange s= ctls_ctl_expr | op= TOK_NOT fp= ctls_pure_ctl_expr );
    public final ctls_pure_ctl_expr_return ctls_pure_ctl_expr() throws RecognitionException {
        ctls_pure_ctl_expr_return retval = new ctls_pure_ctl_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ctls_ctl_expr_return f = null;

        subrange_return fsr = null;

        ctls_ctl_expr_return s = null;

        ctls_pure_ctl_expr_return fp = null;

        ctls_aa_return ctls_aa175 = null;

        ctls_ee_return ctls_ee176 = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1020:9: (op= TOK_EX f= ctls_ctl_expr | op= TOK_AX f= ctls_ctl_expr | op= TOK_EF f= ctls_ctl_expr | op= TOK_AF f= ctls_ctl_expr | op= TOK_EG f= ctls_ctl_expr | op= TOK_AG f= ctls_ctl_expr | ( TOK_AA )=> ctls_aa | ( TOK_EE )=> ctls_ee | op= TOK_EBF fsr= subrange s= ctls_ctl_expr | op= TOK_ABF fsr= subrange s= ctls_ctl_expr | op= TOK_EBG fsr= subrange s= ctls_ctl_expr | op= TOK_ABG fsr= subrange s= ctls_ctl_expr | op= TOK_NOT fp= ctls_pure_ctl_expr )
            int alt65=13;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==TOK_EX) ) {
                alt65=1;
            }
            else if ( (LA65_0==TOK_AX) ) {
                alt65=2;
            }
            else if ( (LA65_0==TOK_EF) ) {
                alt65=3;
            }
            else if ( (LA65_0==TOK_AF) ) {
                alt65=4;
            }
            else if ( (LA65_0==TOK_EG) ) {
                alt65=5;
            }
            else if ( (LA65_0==TOK_AG) ) {
                alt65=6;
            }
            else if ( (LA65_0==TOK_AA) && (synpred9())) {
                alt65=7;
            }
            else if ( (LA65_0==TOK_EE) && (synpred10())) {
                alt65=8;
            }
            else if ( (LA65_0==TOK_EBF) ) {
                alt65=9;
            }
            else if ( (LA65_0==TOK_ABF) ) {
                alt65=10;
            }
            else if ( (LA65_0==TOK_EBG) ) {
                alt65=11;
            }
            else if ( (LA65_0==TOK_ABG) ) {
                alt65=12;
            }
            else if ( (LA65_0==TOK_NOT) ) {
                alt65=13;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("1017:1: ctls_pure_ctl_expr returns [InternalSpec ret] : (op= TOK_EX f= ctls_ctl_expr | op= TOK_AX f= ctls_ctl_expr | op= TOK_EF f= ctls_ctl_expr | op= TOK_AF f= ctls_ctl_expr | op= TOK_EG f= ctls_ctl_expr | op= TOK_AG f= ctls_ctl_expr | ( TOK_AA )=> ctls_aa | ( TOK_EE )=> ctls_ee | op= TOK_EBF fsr= subrange s= ctls_ctl_expr | op= TOK_ABF fsr= subrange s= ctls_ctl_expr | op= TOK_EBG fsr= subrange s= ctls_ctl_expr | op= TOK_ABG fsr= subrange s= ctls_ctl_expr | op= TOK_NOT fp= ctls_pure_ctl_expr );", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1020:11: op= TOK_EX f= ctls_ctl_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_EX,FOLLOW_TOK_EX_in_ctls_pure_ctl_expr10286); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ctls_ctl_expr_in_ctls_pure_ctl_expr10291);
                    f=ctls_ctl_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(f.start,f.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_EX(input, ((Token)retval.start), exp_str, f.ret); 
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1022:11: op= TOK_AX f= ctls_ctl_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_AX,FOLLOW_TOK_AX_in_ctls_pure_ctl_expr10315); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ctls_ctl_expr_in_ctls_pure_ctl_expr10320);
                    f=ctls_ctl_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(f.start,f.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_AX(input, ((Token)retval.start), exp_str, f.ret); 
                    }

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1024:11: op= TOK_EF f= ctls_ctl_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_EF,FOLLOW_TOK_EF_in_ctls_pure_ctl_expr10344); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ctls_ctl_expr_in_ctls_pure_ctl_expr10349);
                    f=ctls_ctl_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(f.start,f.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_EF(input, ((Token)retval.start), exp_str, f.ret); 
                    }

                    }
                    break;
                case 4 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1026:11: op= TOK_AF f= ctls_ctl_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_AF,FOLLOW_TOK_AF_in_ctls_pure_ctl_expr10373); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ctls_ctl_expr_in_ctls_pure_ctl_expr10378);
                    f=ctls_ctl_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(f.start,f.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_AF(input, ((Token)retval.start), exp_str, f.ret); 
                    }

                    }
                    break;
                case 5 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1028:11: op= TOK_EG f= ctls_ctl_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_EG,FOLLOW_TOK_EG_in_ctls_pure_ctl_expr10402); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ctls_ctl_expr_in_ctls_pure_ctl_expr10407);
                    f=ctls_ctl_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(f.start,f.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_EG(input, ((Token)retval.start), exp_str, f.ret); 
                    }

                    }
                    break;
                case 6 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1030:11: op= TOK_AG f= ctls_ctl_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_AG,FOLLOW_TOK_AG_in_ctls_pure_ctl_expr10431); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ctls_ctl_expr_in_ctls_pure_ctl_expr10436);
                    f=ctls_ctl_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(f.start,f.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_AG(input, ((Token)retval.start), exp_str, f.ret); 
                    }

                    }
                    break;
                case 7 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1033:11: ( TOK_AA )=> ctls_aa
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ctls_aa_in_ctls_pure_ctl_expr10465);
                    ctls_aa175=ctls_aa();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, ctls_aa175.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) retval.ret = ctls_aa175.ret; 
                    }

                    }
                    break;
                case 8 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1034:11: ( TOK_EE )=> ctls_ee
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ctls_ee_in_ctls_pure_ctl_expr10485);
                    ctls_ee176=ctls_ee();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, ctls_ee176.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) retval.ret = ctls_ee176.ret; 
                    }

                    }
                    break;
                case 9 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1036:11: op= TOK_EBF fsr= subrange s= ctls_ctl_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_EBF,FOLLOW_TOK_EBF_in_ctls_pure_ctl_expr10502); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_subrange_in_ctls_pure_ctl_expr10507);
                    fsr=subrange();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, fsr.getTree());
                    pushFollow(FOLLOW_ctls_ctl_expr_in_ctls_pure_ctl_expr10511);
                    s=ctls_ctl_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(fsr.start,fsr.stop) + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_EBF(input, ((Token)retval.start), exp_str, fsr.ret, s.ret); 
                    }

                    }
                    break;
                case 10 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1038:11: op= TOK_ABF fsr= subrange s= ctls_ctl_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_ABF,FOLLOW_TOK_ABF_in_ctls_pure_ctl_expr10535); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_subrange_in_ctls_pure_ctl_expr10540);
                    fsr=subrange();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, fsr.getTree());
                    pushFollow(FOLLOW_ctls_ctl_expr_in_ctls_pure_ctl_expr10544);
                    s=ctls_ctl_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(fsr.start,fsr.stop) + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ABF(input, ((Token)retval.start), exp_str, fsr.ret, s.ret); 
                    }

                    }
                    break;
                case 11 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1040:11: op= TOK_EBG fsr= subrange s= ctls_ctl_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_EBG,FOLLOW_TOK_EBG_in_ctls_pure_ctl_expr10568); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_subrange_in_ctls_pure_ctl_expr10573);
                    fsr=subrange();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, fsr.getTree());
                    pushFollow(FOLLOW_ctls_ctl_expr_in_ctls_pure_ctl_expr10577);
                    s=ctls_ctl_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(fsr.start,fsr.stop) + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_EBG(input, ((Token)retval.start), exp_str, fsr.ret, s.ret); 
                    }

                    }
                    break;
                case 12 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1042:11: op= TOK_ABG fsr= subrange s= ctls_ctl_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_ABG,FOLLOW_TOK_ABG_in_ctls_pure_ctl_expr10601); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_subrange_in_ctls_pure_ctl_expr10606);
                    fsr=subrange();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, fsr.getTree());
                    pushFollow(FOLLOW_ctls_ctl_expr_in_ctls_pure_ctl_expr10610);
                    s=ctls_ctl_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(fsr.start,fsr.stop) + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ABG(input, ((Token)retval.start), exp_str, fsr.ret, s.ret); 
                    }

                    }
                    break;
                case 13 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1045:11: op= TOK_NOT fp= ctls_pure_ctl_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,TOK_NOT,FOLLOW_TOK_NOT_in_ctls_pure_ctl_expr10644); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    pushFollow(FOLLOW_ctls_pure_ctl_expr_in_ctls_pure_ctl_expr10649);
                    fp=ctls_pure_ctl_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, fp.getTree());
                    if ( backtracking==0 ) {
                       if (!er()) exp_str = op.getText() + " " + input.toString(fp.start,fp.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_not(input, ((Token)retval.start), exp_str, fp.ret); 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctls_pure_ctl_expr

    public static class ctls_aa_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctls_aa
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1048:1: ctls_aa returns [InternalSpec ret] : ( ( TOK_AA TOK_LB ctls_root_expr TOK_BUNTIL )=> ctls_abu | ( TOK_AA TOK_LB )=> ctls_au );
    public final ctls_aa_return ctls_aa() throws RecognitionException {
        ctls_aa_return retval = new ctls_aa_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ctls_abu_return ctls_abu177 = null;

        ctls_au_return ctls_au178 = null;



        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1050:9: ( ( TOK_AA TOK_LB ctls_root_expr TOK_BUNTIL )=> ctls_abu | ( TOK_AA TOK_LB )=> ctls_au )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==TOK_AA) ) {
                int LA66_1 = input.LA(2);

                if ( (LA66_1==TOK_LB) ) {
                    int LA66_2 = input.LA(3);

                    if ( (synpred11()) ) {
                        alt66=1;
                    }
                    else if ( (synpred12()) ) {
                        alt66=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("1048:1: ctls_aa returns [InternalSpec ret] : ( ( TOK_AA TOK_LB ctls_root_expr TOK_BUNTIL )=> ctls_abu | ( TOK_AA TOK_LB )=> ctls_au );", 66, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("1048:1: ctls_aa returns [InternalSpec ret] : ( ( TOK_AA TOK_LB ctls_root_expr TOK_BUNTIL )=> ctls_abu | ( TOK_AA TOK_LB )=> ctls_au );", 66, 1, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("1048:1: ctls_aa returns [InternalSpec ret] : ( ( TOK_AA TOK_LB ctls_root_expr TOK_BUNTIL )=> ctls_abu | ( TOK_AA TOK_LB )=> ctls_au );", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1050:11: ( TOK_AA TOK_LB ctls_root_expr TOK_BUNTIL )=> ctls_abu
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ctls_abu_in_ctls_aa10708);
                    ctls_abu177=ctls_abu();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, ctls_abu177.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) retval.ret = ctls_abu177.ret; 
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1052:11: ( TOK_AA TOK_LB )=> ctls_au
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ctls_au_in_ctls_aa10739);
                    ctls_au178=ctls_au();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, ctls_au178.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) retval.ret = ctls_au178.ret; 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctls_aa

    public static class ctls_ee_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctls_ee
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1056:1: ctls_ee returns [InternalSpec ret] : ( ( TOK_EE TOK_LB ctls_root_expr TOK_BUNTIL )=> ctls_ebu | ( TOK_EE TOK_LB )=> ctls_eu );
    public final ctls_ee_return ctls_ee() throws RecognitionException {
        ctls_ee_return retval = new ctls_ee_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ctls_ebu_return ctls_ebu179 = null;

        ctls_eu_return ctls_eu180 = null;



        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1058:9: ( ( TOK_EE TOK_LB ctls_root_expr TOK_BUNTIL )=> ctls_ebu | ( TOK_EE TOK_LB )=> ctls_eu )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==TOK_EE) ) {
                int LA67_1 = input.LA(2);

                if ( (LA67_1==TOK_LB) ) {
                    int LA67_2 = input.LA(3);

                    if ( (synpred13()) ) {
                        alt67=1;
                    }
                    else if ( (synpred14()) ) {
                        alt67=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("1056:1: ctls_ee returns [InternalSpec ret] : ( ( TOK_EE TOK_LB ctls_root_expr TOK_BUNTIL )=> ctls_ebu | ( TOK_EE TOK_LB )=> ctls_eu );", 67, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("1056:1: ctls_ee returns [InternalSpec ret] : ( ( TOK_EE TOK_LB ctls_root_expr TOK_BUNTIL )=> ctls_ebu | ( TOK_EE TOK_LB )=> ctls_eu );", 67, 1, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("1056:1: ctls_ee returns [InternalSpec ret] : ( ( TOK_EE TOK_LB ctls_root_expr TOK_BUNTIL )=> ctls_ebu | ( TOK_EE TOK_LB )=> ctls_eu );", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1058:11: ( TOK_EE TOK_LB ctls_root_expr TOK_BUNTIL )=> ctls_ebu
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ctls_ebu_in_ctls_ee10808);
                    ctls_ebu179=ctls_ebu();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, ctls_ebu179.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) retval.ret = ctls_ebu179.ret; 
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1060:11: ( TOK_EE TOK_LB )=> ctls_eu
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ctls_eu_in_ctls_ee10839);
                    ctls_eu180=ctls_eu();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, ctls_eu180.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) retval.ret = ctls_eu180.ret; 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctls_ee

    public static class ctls_au_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctls_au
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1065:1: ctls_au returns [InternalSpec ret] : op= TOK_AA lb= TOK_LB fre= ctls_root_expr rb= TOK_RB ;
    public final ctls_au_return ctls_au() throws RecognitionException {
        ctls_au_return retval = new ctls_au_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        Token lb=null;
        Token rb=null;
        ctls_root_expr_return fre = null;


        Object op_tree=null;
        Object lb_tree=null;
        Object rb_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1068:9: (op= TOK_AA lb= TOK_LB fre= ctls_root_expr rb= TOK_RB )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1068:11: op= TOK_AA lb= TOK_LB fre= ctls_root_expr rb= TOK_RB
            {
            root_0 = (Object)adaptor.nil();

            op=(Token)input.LT(1);
            match(input,TOK_AA,FOLLOW_TOK_AA_in_ctls_au10904); if (failed) return retval;
            if ( backtracking==0 ) {
            op_tree = (Object)adaptor.create(op);
            root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            }
            lb=(Token)input.LT(1);
            match(input,TOK_LB,FOLLOW_TOK_LB_in_ctls_au10909); if (failed) return retval;
            pushFollow(FOLLOW_ctls_root_expr_in_ctls_au10914);
            fre=ctls_root_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, fre.getTree());
            rb=(Token)input.LT(1);
            match(input,TOK_RB,FOLLOW_TOK_RB_in_ctls_au10918); if (failed) return retval;
            if ( backtracking==0 ) {
               if (!er()) exp_str = op.getText() + lb.getText() + input.toString(fre.start,fre.stop) + rb.getText(); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_AU(input, ((Token)retval.start), exp_str, fre.ret); 
            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctls_au

    public static class ctls_eu_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctls_eu
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1071:1: ctls_eu returns [InternalSpec ret] : op= TOK_EE lb= TOK_LB fre= ctls_root_expr rb= TOK_RB ;
    public final ctls_eu_return ctls_eu() throws RecognitionException {
        ctls_eu_return retval = new ctls_eu_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        Token lb=null;
        Token rb=null;
        ctls_root_expr_return fre = null;


        Object op_tree=null;
        Object lb_tree=null;
        Object rb_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1074:9: (op= TOK_EE lb= TOK_LB fre= ctls_root_expr rb= TOK_RB )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1074:11: op= TOK_EE lb= TOK_LB fre= ctls_root_expr rb= TOK_RB
            {
            root_0 = (Object)adaptor.nil();

            op=(Token)input.LT(1);
            match(input,TOK_EE,FOLLOW_TOK_EE_in_ctls_eu10973); if (failed) return retval;
            if ( backtracking==0 ) {
            op_tree = (Object)adaptor.create(op);
            root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            }
            lb=(Token)input.LT(1);
            match(input,TOK_LB,FOLLOW_TOK_LB_in_ctls_eu10978); if (failed) return retval;
            pushFollow(FOLLOW_ctls_root_expr_in_ctls_eu10983);
            fre=ctls_root_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, fre.getTree());
            rb=(Token)input.LT(1);
            match(input,TOK_RB,FOLLOW_TOK_RB_in_ctls_eu10987); if (failed) return retval;
            if ( backtracking==0 ) {
               if (!er()) exp_str = op.getText() + lb.getText() + input.toString(fre.start,fre.stop) + rb.getText(); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_EU(input, ((Token)retval.start), exp_str, fre.ret); 
            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctls_eu

    public static class ctls_abu_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctls_abu
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1077:1: ctls_abu returns [InternalSpec ret] : op= TOK_AA lb= TOK_LB fre= ctls_root_expr opu= TOK_BUNTIL msr= subrange sre= ctls_root_expr rb= TOK_RB ;
    public final ctls_abu_return ctls_abu() throws RecognitionException {
        ctls_abu_return retval = new ctls_abu_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        Token lb=null;
        Token opu=null;
        Token rb=null;
        ctls_root_expr_return fre = null;

        subrange_return msr = null;

        ctls_root_expr_return sre = null;


        Object op_tree=null;
        Object lb_tree=null;
        Object opu_tree=null;
        Object rb_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1080:9: (op= TOK_AA lb= TOK_LB fre= ctls_root_expr opu= TOK_BUNTIL msr= subrange sre= ctls_root_expr rb= TOK_RB )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1080:11: op= TOK_AA lb= TOK_LB fre= ctls_root_expr opu= TOK_BUNTIL msr= subrange sre= ctls_root_expr rb= TOK_RB
            {
            root_0 = (Object)adaptor.nil();

            op=(Token)input.LT(1);
            match(input,TOK_AA,FOLLOW_TOK_AA_in_ctls_abu11041); if (failed) return retval;
            if ( backtracking==0 ) {
            op_tree = (Object)adaptor.create(op);
            root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            }
            lb=(Token)input.LT(1);
            match(input,TOK_LB,FOLLOW_TOK_LB_in_ctls_abu11046); if (failed) return retval;
            pushFollow(FOLLOW_ctls_root_expr_in_ctls_abu11051);
            fre=ctls_root_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, fre.getTree());
            opu=(Token)input.LT(1);
            match(input,TOK_BUNTIL,FOLLOW_TOK_BUNTIL_in_ctls_abu11055); if (failed) return retval;
            if ( backtracking==0 ) {
            opu_tree = (Object)adaptor.create(opu);
            adaptor.addChild(root_0, opu_tree);
            }
            pushFollow(FOLLOW_subrange_in_ctls_abu11059);
            msr=subrange();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, msr.getTree());
            pushFollow(FOLLOW_ctls_root_expr_in_ctls_abu11063);
            sre=ctls_root_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, sre.getTree());
            rb=(Token)input.LT(1);
            match(input,TOK_RB,FOLLOW_TOK_RB_in_ctls_abu11067); if (failed) return retval;
            if ( backtracking==0 ) {
               if (!er()) exp_str = op.getText() + lb.getText() + input.toString(fre.start,fre.stop) + " " + opu.getText() + " " + input.toString(msr.start,msr.stop) + " " + input.toString(sre.start,sre.stop) + rb.getText(); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ABU(input, ((Token)retval.start), exp_str, fre.ret, msr.ret, sre.ret); 
            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctls_abu

    public static class ctls_ebu_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctls_ebu
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1083:1: ctls_ebu returns [InternalSpec ret] : op= TOK_EE lb= TOK_LB fre= ctls_root_expr opu= TOK_BUNTIL msr= subrange sre= ctls_root_expr rb= TOK_RB ;
    public final ctls_ebu_return ctls_ebu() throws RecognitionException {
        ctls_ebu_return retval = new ctls_ebu_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        Token lb=null;
        Token opu=null;
        Token rb=null;
        ctls_root_expr_return fre = null;

        subrange_return msr = null;

        ctls_root_expr_return sre = null;


        Object op_tree=null;
        Object lb_tree=null;
        Object opu_tree=null;
        Object rb_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1086:9: (op= TOK_EE lb= TOK_LB fre= ctls_root_expr opu= TOK_BUNTIL msr= subrange sre= ctls_root_expr rb= TOK_RB )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1086:11: op= TOK_EE lb= TOK_LB fre= ctls_root_expr opu= TOK_BUNTIL msr= subrange sre= ctls_root_expr rb= TOK_RB
            {
            root_0 = (Object)adaptor.nil();

            op=(Token)input.LT(1);
            match(input,TOK_EE,FOLLOW_TOK_EE_in_ctls_ebu11121); if (failed) return retval;
            if ( backtracking==0 ) {
            op_tree = (Object)adaptor.create(op);
            root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            }
            lb=(Token)input.LT(1);
            match(input,TOK_LB,FOLLOW_TOK_LB_in_ctls_ebu11126); if (failed) return retval;
            pushFollow(FOLLOW_ctls_root_expr_in_ctls_ebu11131);
            fre=ctls_root_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, fre.getTree());
            opu=(Token)input.LT(1);
            match(input,TOK_BUNTIL,FOLLOW_TOK_BUNTIL_in_ctls_ebu11135); if (failed) return retval;
            if ( backtracking==0 ) {
            opu_tree = (Object)adaptor.create(opu);
            adaptor.addChild(root_0, opu_tree);
            }
            pushFollow(FOLLOW_subrange_in_ctls_ebu11139);
            msr=subrange();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, msr.getTree());
            pushFollow(FOLLOW_ctls_root_expr_in_ctls_ebu11143);
            sre=ctls_root_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, sre.getTree());
            rb=(Token)input.LT(1);
            match(input,TOK_RB,FOLLOW_TOK_RB_in_ctls_ebu11147); if (failed) return retval;
            if ( backtracking==0 ) {
               if (!er()) exp_str = op.getText() + lb.getText() + input.toString(fre.start,fre.stop) + " " + opu.getText() + " " + input.toString(msr.start,msr.stop) + " " + input.toString(sre.start,sre.stop) + rb.getText(); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_EBU(input, ((Token)retval.start), exp_str, fre.ret, msr.ret, sre.ret); 
            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctls_ebu

    public static class ctls_relational_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctls_relational_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1090:1: ctls_relational_expr returns [InternalSpec ret] : f= ctls_in_expr (op= TOK_EQUAL s= ctls_in_expr | op= TOK_NOTEQUAL s= ctls_in_expr | op= TOK_LT s= ctls_in_expr | op= TOK_GT s= ctls_in_expr | op= TOK_LE s= ctls_in_expr | op= TOK_GE s= ctls_in_expr )* ;
    public final ctls_relational_expr_return ctls_relational_expr() throws RecognitionException {
        ctls_relational_expr_return retval = new ctls_relational_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ctls_in_expr_return f = null;

        ctls_in_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1093:9: (f= ctls_in_expr (op= TOK_EQUAL s= ctls_in_expr | op= TOK_NOTEQUAL s= ctls_in_expr | op= TOK_LT s= ctls_in_expr | op= TOK_GT s= ctls_in_expr | op= TOK_LE s= ctls_in_expr | op= TOK_GE s= ctls_in_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1093:11: f= ctls_in_expr (op= TOK_EQUAL s= ctls_in_expr | op= TOK_NOTEQUAL s= ctls_in_expr | op= TOK_LT s= ctls_in_expr | op= TOK_GT s= ctls_in_expr | op= TOK_LE s= ctls_in_expr | op= TOK_GE s= ctls_in_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ctls_in_expr_in_ctls_relational_expr11199);
            f=ctls_in_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1094:9: (op= TOK_EQUAL s= ctls_in_expr | op= TOK_NOTEQUAL s= ctls_in_expr | op= TOK_LT s= ctls_in_expr | op= TOK_GT s= ctls_in_expr | op= TOK_LE s= ctls_in_expr | op= TOK_GE s= ctls_in_expr )*
            loop68:
            do {
                int alt68=7;
                switch ( input.LA(1) ) {
                case TOK_EQUAL:
                    {
                    alt68=1;
                    }
                    break;
                case TOK_NOTEQUAL:
                    {
                    alt68=2;
                    }
                    break;
                case TOK_LT:
                    {
                    alt68=3;
                    }
                    break;
                case TOK_GT:
                    {
                    alt68=4;
                    }
                    break;
                case TOK_LE:
                    {
                    alt68=5;
                    }
                    break;
                case TOK_GE:
                    {
                    alt68=6;
                    }
                    break;

                }

                switch (alt68) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1094:11: op= TOK_EQUAL s= ctls_in_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_EQUAL,FOLLOW_TOK_EQUAL_in_ctls_relational_expr11215); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctls_in_expr_in_ctls_relational_expr11220);
            	    s=ctls_in_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_eq(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1096:11: op= TOK_NOTEQUAL s= ctls_in_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_NOTEQUAL,FOLLOW_TOK_NOTEQUAL_in_ctls_relational_expr11245); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctls_in_expr_in_ctls_relational_expr11250);
            	    s=ctls_in_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_neq(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 3 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1098:11: op= TOK_LT s= ctls_in_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_LT,FOLLOW_TOK_LT_in_ctls_relational_expr11275); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctls_in_expr_in_ctls_relational_expr11280);
            	    s=ctls_in_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_lt(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 4 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1100:11: op= TOK_GT s= ctls_in_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_GT,FOLLOW_TOK_GT_in_ctls_relational_expr11305); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctls_in_expr_in_ctls_relational_expr11310);
            	    s=ctls_in_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_gt(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 5 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1102:11: op= TOK_LE s= ctls_in_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_LE,FOLLOW_TOK_LE_in_ctls_relational_expr11335); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctls_in_expr_in_ctls_relational_expr11340);
            	    s=ctls_in_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_le(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 6 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1104:11: op= TOK_GE s= ctls_in_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_GE,FOLLOW_TOK_GE_in_ctls_relational_expr11365); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctls_in_expr_in_ctls_relational_expr11370);
            	    s=ctls_in_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ge(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop68;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctls_relational_expr

    public static class ctls_in_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctls_in_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1108:1: ctls_in_expr returns [InternalSpec ret] : f= ctls_union_expr (op= TOK_SETIN s= ctls_union_expr )* ;
    public final ctls_in_expr_return ctls_in_expr() throws RecognitionException {
        ctls_in_expr_return retval = new ctls_in_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ctls_union_expr_return f = null;

        ctls_union_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1111:9: (f= ctls_union_expr (op= TOK_SETIN s= ctls_union_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1111:11: f= ctls_union_expr (op= TOK_SETIN s= ctls_union_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ctls_union_expr_in_ctls_in_expr11433);
            f=ctls_union_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1112:9: (op= TOK_SETIN s= ctls_union_expr )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==TOK_SETIN) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1112:11: op= TOK_SETIN s= ctls_union_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_SETIN,FOLLOW_TOK_SETIN_in_ctls_in_expr11449); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctls_union_expr_in_ctls_in_expr11454);
            	    s=ctls_union_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_setin(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop69;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctls_in_expr

    public static class ctls_union_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctls_union_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1116:1: ctls_union_expr returns [InternalSpec ret] : f= ctls_set_expr (op= TOK_UNION s= ctls_set_expr )* ;
    public final ctls_union_expr_return ctls_union_expr() throws RecognitionException {
        ctls_union_expr_return retval = new ctls_union_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ctls_set_expr_return f = null;

        ctls_set_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1119:9: (f= ctls_set_expr (op= TOK_UNION s= ctls_set_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1119:11: f= ctls_set_expr (op= TOK_UNION s= ctls_set_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ctls_set_expr_in_ctls_union_expr11517);
            f=ctls_set_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1120:9: (op= TOK_UNION s= ctls_set_expr )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==TOK_UNION) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1120:11: op= TOK_UNION s= ctls_set_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_UNION,FOLLOW_TOK_UNION_in_ctls_union_expr11533); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctls_set_expr_in_ctls_union_expr11538);
            	    s=ctls_set_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_union(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop70;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctls_union_expr

    public static class ctls_set_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctls_set_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1125:1: ctls_set_expr returns [InternalSpec ret] : ( ctls_shift_expr | subrange | TOK_LCB ctls_set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T ctls_set_list_expr ) );
    public final ctls_set_expr_return ctls_set_expr() throws RecognitionException {
        ctls_set_expr_return retval = new ctls_set_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TOK_LCB183=null;
        Token TOK_RCB185=null;
        ctls_shift_expr_return ctls_shift_expr181 = null;

        subrange_return subrange182 = null;

        ctls_set_list_expr_return ctls_set_list_expr184 = null;


        Object TOK_LCB183_tree=null;
        Object TOK_RCB185_tree=null;
        RewriteRuleTokenStream stream_TOK_LCB=new RewriteRuleTokenStream(adaptor,"token TOK_LCB");
        RewriteRuleTokenStream stream_TOK_RCB=new RewriteRuleTokenStream(adaptor,"token TOK_RCB");
        RewriteRuleSubtreeStream stream_ctls_set_list_expr=new RewriteRuleSubtreeStream(adaptor,"rule ctls_set_list_expr");
        boolean append_end = false; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1128:9: ( ctls_shift_expr | subrange | TOK_LCB ctls_set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T ctls_set_list_expr ) )
            int alt71=3;
            switch ( input.LA(1) ) {
            case TOK_NOT:
            case TOK_LP:
            case TOK_BOOL:
            case TOK_WORD1:
            case TOK_NEXT:
            case TOK_CASE:
            case TOK_WAREAD:
            case TOK_WAWRITE:
            case TOK_ATOM:
            case TOK_NUMBER_WORD:
            case TOK_FALSEEXP:
            case TOK_TRUEEXP:
                {
                alt71=1;
                }
                break;
            case TOK_NUMBER:
                {
                int LA71_2 = input.LA(2);

                if ( (LA71_2==TOK_TWODOTS) ) {
                    alt71=2;
                }
                else if ( (LA71_2==EOF||(LA71_2>=TOK_INVAR_SPEC && LA71_2<=TOK_UNION)||(LA71_2>=TOK_LSHIFT && LA71_2<=TOK_CONCATENATION)||LA71_2==TOK_RP||(LA71_2>=TOK_LB && LA71_2<=TOK_RB)||(LA71_2>=TOK_BUNTIL && LA71_2<=TOK_TRIGGERED)||LA71_2==TOK_DOT||LA71_2==TOK_SEMI) ) {
                    alt71=1;
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("1125:1: ctls_set_expr returns [InternalSpec ret] : ( ctls_shift_expr | subrange | TOK_LCB ctls_set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T ctls_set_list_expr ) );", 71, 2, input);

                    throw nvae;
                }
                }
                break;
            case TOK_PLUS:
                {
                int LA71_3 = input.LA(2);

                if ( (LA71_3==TOK_NUMBER) ) {
                    int LA71_7 = input.LA(3);

                    if ( (LA71_7==EOF||(LA71_7>=TOK_INVAR_SPEC && LA71_7<=TOK_UNION)||(LA71_7>=TOK_LSHIFT && LA71_7<=TOK_CONCATENATION)||LA71_7==TOK_RP||(LA71_7>=TOK_LB && LA71_7<=TOK_RB)||(LA71_7>=TOK_BUNTIL && LA71_7<=TOK_TRIGGERED)||LA71_7==TOK_DOT||LA71_7==TOK_SEMI) ) {
                        alt71=1;
                    }
                    else if ( (LA71_7==TOK_TWODOTS) ) {
                        alt71=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("1125:1: ctls_set_expr returns [InternalSpec ret] : ( ctls_shift_expr | subrange | TOK_LCB ctls_set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T ctls_set_list_expr ) );", 71, 7, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("1125:1: ctls_set_expr returns [InternalSpec ret] : ( ctls_shift_expr | subrange | TOK_LCB ctls_set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T ctls_set_list_expr ) );", 71, 3, input);

                    throw nvae;
                }
                }
                break;
            case TOK_MINUS:
                {
                int LA71_4 = input.LA(2);

                if ( (LA71_4==TOK_NUMBER) ) {
                    int LA71_8 = input.LA(3);

                    if ( (LA71_8==EOF||(LA71_8>=TOK_INVAR_SPEC && LA71_8<=TOK_UNION)||(LA71_8>=TOK_LSHIFT && LA71_8<=TOK_CONCATENATION)||LA71_8==TOK_RP||(LA71_8>=TOK_LB && LA71_8<=TOK_RB)||(LA71_8>=TOK_BUNTIL && LA71_8<=TOK_TRIGGERED)||LA71_8==TOK_DOT||LA71_8==TOK_SEMI) ) {
                        alt71=1;
                    }
                    else if ( (LA71_8==TOK_TWODOTS) ) {
                        alt71=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("1125:1: ctls_set_expr returns [InternalSpec ret] : ( ctls_shift_expr | subrange | TOK_LCB ctls_set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T ctls_set_list_expr ) );", 71, 8, input);

                        throw nvae;
                    }
                }
                else if ( ((LA71_4>=TOK_PLUS && LA71_4<=TOK_MINUS)||(LA71_4>=TOK_NOT && LA71_4<=TOK_LP)||(LA71_4>=TOK_BOOL && LA71_4<=TOK_CASE)||(LA71_4>=TOK_WAREAD && LA71_4<=TOK_WAWRITE)||LA71_4==TOK_ATOM||LA71_4==TOK_NUMBER_WORD||(LA71_4>=TOK_FALSEEXP && LA71_4<=TOK_TRUEEXP)) ) {
                    alt71=1;
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("1125:1: ctls_set_expr returns [InternalSpec ret] : ( ctls_shift_expr | subrange | TOK_LCB ctls_set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T ctls_set_list_expr ) );", 71, 4, input);

                    throw nvae;
                }
                }
                break;
            case TOK_LCB:
                {
                alt71=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("1125:1: ctls_set_expr returns [InternalSpec ret] : ( ctls_shift_expr | subrange | TOK_LCB ctls_set_list_expr TOK_RCB -> ^( SET_LIST_EXP_T ctls_set_list_expr ) );", 71, 0, input);

                throw nvae;
            }

            switch (alt71) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1128:11: ctls_shift_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ctls_shift_expr_in_ctls_set_expr11600);
                    ctls_shift_expr181=ctls_shift_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, ctls_shift_expr181.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) retval.ret = ctls_shift_expr181.ret; 
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1130:11: subrange
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_subrange_in_ctls_set_expr11622);
                    subrange182=subrange();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, subrange182.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_range(input, ((Token)retval.start), input.toString(subrange182.start,subrange182.stop)); 
                    }

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1132:11: TOK_LCB ctls_set_list_expr TOK_RCB
                    {
                    TOK_LCB183=(Token)input.LT(1);
                    match(input,TOK_LCB,FOLLOW_TOK_LCB_in_ctls_set_expr11645); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_LCB.add(TOK_LCB183);

                    pushFollow(FOLLOW_ctls_set_list_expr_in_ctls_set_expr11647);
                    ctls_set_list_expr184=ctls_set_list_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_ctls_set_list_expr.add(ctls_set_list_expr184.getTree());
                    TOK_RCB185=(Token)input.LT(1);
                    match(input,TOK_RCB,FOLLOW_TOK_RCB_in_ctls_set_expr11649); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_RCB.add(TOK_RCB185);

                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_set(input, ((Token)retval.start), TOK_LCB183.getText() + " " + input.toString(ctls_set_list_expr184.start,ctls_set_list_expr184.stop) + " " + TOK_RCB185.getText()); 
                    }

                    // AST REWRITE
                    // elements: ctls_set_list_expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1134:9: -> ^( SET_LIST_EXP_T ctls_set_list_expr )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1134:12: ^( SET_LIST_EXP_T ctls_set_list_expr )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(SET_LIST_EXP_T, "SET_LIST_EXP_T"), root_1);

                        adaptor.addChild(root_1, stream_ctls_set_list_expr.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctls_set_expr

    public static class ctls_set_list_expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctls_set_list_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1136:1: ctls_set_list_expr : simple_root_expr ( TOK_COMMA simple_root_expr )* ;
    public final ctls_set_list_expr_return ctls_set_list_expr() throws RecognitionException {
        ctls_set_list_expr_return retval = new ctls_set_list_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TOK_COMMA187=null;
        simple_root_expr_return simple_root_expr186 = null;

        simple_root_expr_return simple_root_expr188 = null;


        Object TOK_COMMA187_tree=null;

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1137:9: ( simple_root_expr ( TOK_COMMA simple_root_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1137:11: simple_root_expr ( TOK_COMMA simple_root_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_simple_root_expr_in_ctls_set_list_expr11702);
            simple_root_expr186=simple_root_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, simple_root_expr186.getTree());
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1137:28: ( TOK_COMMA simple_root_expr )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==TOK_COMMA) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1137:29: TOK_COMMA simple_root_expr
            	    {
            	    TOK_COMMA187=(Token)input.LT(1);
            	    match(input,TOK_COMMA,FOLLOW_TOK_COMMA_in_ctls_set_list_expr11705); if (failed) return retval;
            	    pushFollow(FOLLOW_simple_root_expr_in_ctls_set_list_expr11708);
            	    simple_root_expr188=simple_root_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, simple_root_expr188.getTree());

            	    }
            	    break;

            	default :
            	    break loop72;
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
    // $ANTLR end ctls_set_list_expr

    public static class ctls_shift_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctls_shift_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1139:1: ctls_shift_expr returns [InternalSpec ret] : f= ctls_remainder_expr (op= TOK_LSHIFT s= ctls_remainder_expr | op= TOK_RSHIFT s= ctls_remainder_expr )* ;
    public final ctls_shift_expr_return ctls_shift_expr() throws RecognitionException {
        ctls_shift_expr_return retval = new ctls_shift_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ctls_remainder_expr_return f = null;

        ctls_remainder_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1142:9: (f= ctls_remainder_expr (op= TOK_LSHIFT s= ctls_remainder_expr | op= TOK_RSHIFT s= ctls_remainder_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1142:11: f= ctls_remainder_expr (op= TOK_LSHIFT s= ctls_remainder_expr | op= TOK_RSHIFT s= ctls_remainder_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ctls_remainder_expr_in_ctls_shift_expr11754);
            f=ctls_remainder_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1143:9: (op= TOK_LSHIFT s= ctls_remainder_expr | op= TOK_RSHIFT s= ctls_remainder_expr )*
            loop73:
            do {
                int alt73=3;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==TOK_LSHIFT) ) {
                    alt73=1;
                }
                else if ( (LA73_0==TOK_RSHIFT) ) {
                    alt73=2;
                }


                switch (alt73) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1143:11: op= TOK_LSHIFT s= ctls_remainder_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_LSHIFT,FOLLOW_TOK_LSHIFT_in_ctls_shift_expr11770); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctls_remainder_expr_in_ctls_shift_expr11775);
            	    s=ctls_remainder_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_lshift(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1145:11: op= TOK_RSHIFT s= ctls_remainder_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_RSHIFT,FOLLOW_TOK_RSHIFT_in_ctls_shift_expr11799); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctls_remainder_expr_in_ctls_shift_expr11804);
            	    s=ctls_remainder_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_rshift(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop73;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctls_shift_expr

    public static class ctls_remainder_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctls_remainder_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1149:1: ctls_remainder_expr returns [InternalSpec ret] : f= ctls_additive_expr (op= TOK_MOD s= ctls_additive_expr )* ;
    public final ctls_remainder_expr_return ctls_remainder_expr() throws RecognitionException {
        ctls_remainder_expr_return retval = new ctls_remainder_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ctls_additive_expr_return f = null;

        ctls_additive_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1152:9: (f= ctls_additive_expr (op= TOK_MOD s= ctls_additive_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1152:11: f= ctls_additive_expr (op= TOK_MOD s= ctls_additive_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ctls_additive_expr_in_ctls_remainder_expr11866);
            f=ctls_additive_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1153:9: (op= TOK_MOD s= ctls_additive_expr )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==TOK_MOD) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1153:11: op= TOK_MOD s= ctls_additive_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_MOD,FOLLOW_TOK_MOD_in_ctls_remainder_expr11882); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctls_additive_expr_in_ctls_remainder_expr11887);
            	    s=ctls_additive_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_mod(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctls_remainder_expr

    public static class ctls_additive_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctls_additive_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1160:1: ctls_additive_expr returns [InternalSpec ret] : f= ctls_multiplicative_expr (op= TOK_PLUS s= ctls_multiplicative_expr | op= TOK_MINUS s= ctls_multiplicative_expr )* ;
    public final ctls_additive_expr_return ctls_additive_expr() throws RecognitionException {
        ctls_additive_expr_return retval = new ctls_additive_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ctls_multiplicative_expr_return f = null;

        ctls_multiplicative_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1163:9: (f= ctls_multiplicative_expr (op= TOK_PLUS s= ctls_multiplicative_expr | op= TOK_MINUS s= ctls_multiplicative_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1163:11: f= ctls_multiplicative_expr (op= TOK_PLUS s= ctls_multiplicative_expr | op= TOK_MINUS s= ctls_multiplicative_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ctls_multiplicative_expr_in_ctls_additive_expr11952);
            f=ctls_multiplicative_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1164:9: (op= TOK_PLUS s= ctls_multiplicative_expr | op= TOK_MINUS s= ctls_multiplicative_expr )*
            loop75:
            do {
                int alt75=3;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==TOK_PLUS) ) {
                    alt75=1;
                }
                else if ( (LA75_0==TOK_MINUS) ) {
                    alt75=2;
                }


                switch (alt75) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1164:11: op= TOK_PLUS s= ctls_multiplicative_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_PLUS,FOLLOW_TOK_PLUS_in_ctls_additive_expr11968); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctls_multiplicative_expr_in_ctls_additive_expr11973);
            	    s=ctls_multiplicative_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_plus(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1166:11: op= TOK_MINUS s= ctls_multiplicative_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_MINUS,FOLLOW_TOK_MINUS_in_ctls_additive_expr11997); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctls_multiplicative_expr_in_ctls_additive_expr12002);
            	    s=ctls_multiplicative_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_minus(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop75;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctls_additive_expr

    public static class ctls_multiplicative_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctls_multiplicative_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1170:1: ctls_multiplicative_expr returns [InternalSpec ret] : f= ctls_concatination_expr (op= TOK_TIMES s= ctls_concatination_expr | op= TOK_DIVIDE s= ctls_concatination_expr )* ;
    public final ctls_multiplicative_expr_return ctls_multiplicative_expr() throws RecognitionException {
        ctls_multiplicative_expr_return retval = new ctls_multiplicative_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ctls_concatination_expr_return f = null;

        ctls_concatination_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1173:9: (f= ctls_concatination_expr (op= TOK_TIMES s= ctls_concatination_expr | op= TOK_DIVIDE s= ctls_concatination_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1173:11: f= ctls_concatination_expr (op= TOK_TIMES s= ctls_concatination_expr | op= TOK_DIVIDE s= ctls_concatination_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ctls_concatination_expr_in_ctls_multiplicative_expr12062);
            f=ctls_concatination_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1174:9: (op= TOK_TIMES s= ctls_concatination_expr | op= TOK_DIVIDE s= ctls_concatination_expr )*
            loop76:
            do {
                int alt76=3;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==TOK_TIMES) ) {
                    alt76=1;
                }
                else if ( (LA76_0==TOK_DIVIDE) ) {
                    alt76=2;
                }


                switch (alt76) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1174:11: op= TOK_TIMES s= ctls_concatination_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_TIMES,FOLLOW_TOK_TIMES_in_ctls_multiplicative_expr12078); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctls_concatination_expr_in_ctls_multiplicative_expr12083);
            	    s=ctls_concatination_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_times(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1176:11: op= TOK_DIVIDE s= ctls_concatination_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_DIVIDE,FOLLOW_TOK_DIVIDE_in_ctls_multiplicative_expr12107); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctls_concatination_expr_in_ctls_multiplicative_expr12112);
            	    s=ctls_concatination_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += " " + op.getText() + " " + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_divide(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop76;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctls_multiplicative_expr

    public static class ctls_concatination_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctls_concatination_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1180:1: ctls_concatination_expr returns [InternalSpec ret] : f= ctls_primary_expr (op= TOK_CONCATENATION s= ctls_primary_expr )* ;
    public final ctls_concatination_expr_return ctls_concatination_expr() throws RecognitionException {
        ctls_concatination_expr_return retval = new ctls_concatination_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ctls_primary_expr_return f = null;

        ctls_primary_expr_return s = null;


        Object op_tree=null;

        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1183:9: (f= ctls_primary_expr (op= TOK_CONCATENATION s= ctls_primary_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1183:11: f= ctls_primary_expr (op= TOK_CONCATENATION s= ctls_primary_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ctls_primary_expr_in_ctls_concatination_expr12173);
            f=ctls_primary_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if ( backtracking==0 ) {
               if (!er()) exp_str += input.toString(f.start,f.stop); if(!er()) retval.ret = f.ret; 
            }
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1184:9: (op= TOK_CONCATENATION s= ctls_primary_expr )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==TOK_CONCATENATION) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1184:11: op= TOK_CONCATENATION s= ctls_primary_expr
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,TOK_CONCATENATION,FOLLOW_TOK_CONCATENATION_in_ctls_concatination_expr12189); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_ctls_primary_expr_in_ctls_concatination_expr12194);
            	    s=ctls_primary_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if ( backtracking==0 ) {
            	       if (!er()) exp_str += op.getText() + input.toString(s.start,s.stop); if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_concatenation(input, ((Token)retval.start), exp_str, retval.ret, s.ret); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop77;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctls_concatination_expr

    public static class ctls_primary_expr_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctls_primary_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1189:1: ctls_primary_expr returns [InternalSpec ret] : ( ctls_primary_expr_helper1 | op= TOK_MINUS v= ctls_primary_expr -> ^( TOK_UNARY_MINUS_T $v) | op= TOK_NOT v= ctls_primary_expr -> ^( TOK_NOT $v) );
    public final ctls_primary_expr_return ctls_primary_expr() throws RecognitionException {
        ctls_primary_expr_return retval = new ctls_primary_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ctls_primary_expr_return v = null;

        ctls_primary_expr_helper1_return ctls_primary_expr_helper1189 = null;


        Object op_tree=null;
        RewriteRuleTokenStream stream_TOK_MINUS=new RewriteRuleTokenStream(adaptor,"token TOK_MINUS");
        RewriteRuleTokenStream stream_TOK_NOT=new RewriteRuleTokenStream(adaptor,"token TOK_NOT");
        RewriteRuleSubtreeStream stream_ctls_primary_expr=new RewriteRuleSubtreeStream(adaptor,"rule ctls_primary_expr");
        boolean append_end = false; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1192:9: ( ctls_primary_expr_helper1 | op= TOK_MINUS v= ctls_primary_expr -> ^( TOK_UNARY_MINUS_T $v) | op= TOK_NOT v= ctls_primary_expr -> ^( TOK_NOT $v) )
            int alt78=3;
            switch ( input.LA(1) ) {
            case TOK_PLUS:
            case TOK_LP:
            case TOK_BOOL:
            case TOK_WORD1:
            case TOK_NEXT:
            case TOK_CASE:
            case TOK_WAREAD:
            case TOK_WAWRITE:
            case TOK_ATOM:
            case TOK_NUMBER:
            case TOK_NUMBER_WORD:
            case TOK_FALSEEXP:
            case TOK_TRUEEXP:
                {
                alt78=1;
                }
                break;
            case TOK_MINUS:
                {
                alt78=2;
                }
                break;
            case TOK_NOT:
                {
                alt78=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("1189:1: ctls_primary_expr returns [InternalSpec ret] : ( ctls_primary_expr_helper1 | op= TOK_MINUS v= ctls_primary_expr -> ^( TOK_UNARY_MINUS_T $v) | op= TOK_NOT v= ctls_primary_expr -> ^( TOK_NOT $v) );", 78, 0, input);

                throw nvae;
            }

            switch (alt78) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1192:11: ctls_primary_expr_helper1
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ctls_primary_expr_helper1_in_ctls_primary_expr12263);
                    ctls_primary_expr_helper1189=ctls_primary_expr_helper1();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, ctls_primary_expr_helper1189.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) retval.ret = ctls_primary_expr_helper1189.ret; 
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1194:11: op= TOK_MINUS v= ctls_primary_expr
                    {
                    op=(Token)input.LT(1);
                    match(input,TOK_MINUS,FOLLOW_TOK_MINUS_in_ctls_primary_expr12287); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_MINUS.add(op);

                    pushFollow(FOLLOW_ctls_primary_expr_in_ctls_primary_expr12291);
                    v=ctls_primary_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_ctls_primary_expr.add(v.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_unary_minus(input, ((Token)retval.start), op.getText() + " " + input.toString(v.start,v.stop), v.ret); 
                    }

                    // AST REWRITE
                    // elements: v
                    // token labels: 
                    // rule labels: v, retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_v=new RewriteRuleSubtreeStream(adaptor,"token v",v!=null?v.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1196:9: -> ^( TOK_UNARY_MINUS_T $v)
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1196:12: ^( TOK_UNARY_MINUS_T $v)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(TOK_UNARY_MINUS_T, "TOK_UNARY_MINUS_T"), root_1);

                        adaptor.addChild(root_1, stream_v.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1197:11: op= TOK_NOT v= ctls_primary_expr
                    {
                    op=(Token)input.LT(1);
                    match(input,TOK_NOT,FOLLOW_TOK_NOT_in_ctls_primary_expr12332); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_NOT.add(op);

                    pushFollow(FOLLOW_ctls_primary_expr_in_ctls_primary_expr12336);
                    v=ctls_primary_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_ctls_primary_expr.add(v.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_not(input, ((Token)retval.start), op.getText() + " " + input.toString(v.start,v.stop), v.ret); 
                    }

                    // AST REWRITE
                    // elements: v, TOK_NOT
                    // token labels: 
                    // rule labels: v, retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_v=new RewriteRuleSubtreeStream(adaptor,"token v",v!=null?v.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1199:9: -> ^( TOK_NOT $v)
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1199:12: ^( TOK_NOT $v)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_TOK_NOT.next(), root_1);

                        adaptor.addChild(root_1, stream_v.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctls_primary_expr

    public static class ctls_primary_expr_helper1_return extends ParserRuleReturnScope {
        public InternalSpec ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ctls_primary_expr_helper1
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1202:1: ctls_primary_expr_helper1 returns [InternalSpec ret] : ( constant primary_expr_select -> ^( VALUE_T constant NOP primary_expr_select ) | primary_expr_helper1_pointer1 | TOK_LP ctls_root_expr TOK_RP primary_expr_select -> ^( BLOCK_T ctls_root_expr NOP primary_expr_select ) | TOK_BOOL TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_BOOL simple_root_expr NOP primary_expr_select ) | TOK_WORD1 TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WORD1 simple_root_expr NOP primary_expr_select ) | TOK_NEXT TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_NEXT simple_root_expr NOP primary_expr_select ) | TOK_CASE case_element_list_expr TOK_ESAC primary_expr_select -> ^( CASE_LIST_EXPR_T case_element_list_expr NOP primary_expr_select ) | TOK_WAREAD TOK_LP f= simple_root_expr TOK_COMMA s= simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WAREAD $f $s NOP primary_expr_select ) | TOK_WAWRITE TOK_LP f= simple_root_expr tc1= TOK_COMMA m= simple_root_expr tc2= TOK_COMMA s= simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WAWRITE $f $m $s NOP primary_expr_select ) );
    public final ctls_primary_expr_helper1_return ctls_primary_expr_helper1() throws RecognitionException {
        ctls_primary_expr_helper1_return retval = new ctls_primary_expr_helper1_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token tc1=null;
        Token tc2=null;
        Token TOK_LP193=null;
        Token TOK_RP195=null;
        Token TOK_BOOL197=null;
        Token TOK_LP198=null;
        Token TOK_RP200=null;
        Token TOK_WORD1202=null;
        Token TOK_LP203=null;
        Token TOK_RP205=null;
        Token TOK_NEXT207=null;
        Token TOK_LP208=null;
        Token TOK_RP210=null;
        Token TOK_CASE212=null;
        Token TOK_ESAC214=null;
        Token TOK_WAREAD216=null;
        Token TOK_LP217=null;
        Token TOK_COMMA218=null;
        Token TOK_RP219=null;
        Token TOK_WAWRITE221=null;
        Token TOK_LP222=null;
        Token TOK_RP223=null;
        simple_root_expr_return f = null;

        simple_root_expr_return s = null;

        simple_root_expr_return m = null;

        constant_return constant190 = null;

        primary_expr_select_return primary_expr_select191 = null;

        primary_expr_helper1_pointer1_return primary_expr_helper1_pointer1192 = null;

        ctls_root_expr_return ctls_root_expr194 = null;

        primary_expr_select_return primary_expr_select196 = null;

        simple_root_expr_return simple_root_expr199 = null;

        primary_expr_select_return primary_expr_select201 = null;

        simple_root_expr_return simple_root_expr204 = null;

        primary_expr_select_return primary_expr_select206 = null;

        simple_root_expr_return simple_root_expr209 = null;

        primary_expr_select_return primary_expr_select211 = null;

        case_element_list_expr_return case_element_list_expr213 = null;

        primary_expr_select_return primary_expr_select215 = null;

        primary_expr_select_return primary_expr_select220 = null;

        primary_expr_select_return primary_expr_select224 = null;


        Object tc1_tree=null;
        Object tc2_tree=null;
        Object TOK_LP193_tree=null;
        Object TOK_RP195_tree=null;
        Object TOK_BOOL197_tree=null;
        Object TOK_LP198_tree=null;
        Object TOK_RP200_tree=null;
        Object TOK_WORD1202_tree=null;
        Object TOK_LP203_tree=null;
        Object TOK_RP205_tree=null;
        Object TOK_NEXT207_tree=null;
        Object TOK_LP208_tree=null;
        Object TOK_RP210_tree=null;
        Object TOK_CASE212_tree=null;
        Object TOK_ESAC214_tree=null;
        Object TOK_WAREAD216_tree=null;
        Object TOK_LP217_tree=null;
        Object TOK_COMMA218_tree=null;
        Object TOK_RP219_tree=null;
        Object TOK_WAWRITE221_tree=null;
        Object TOK_LP222_tree=null;
        Object TOK_RP223_tree=null;
        RewriteRuleTokenStream stream_TOK_LP=new RewriteRuleTokenStream(adaptor,"token TOK_LP");
        RewriteRuleTokenStream stream_TOK_BOOL=new RewriteRuleTokenStream(adaptor,"token TOK_BOOL");
        RewriteRuleTokenStream stream_TOK_WAWRITE=new RewriteRuleTokenStream(adaptor,"token TOK_WAWRITE");
        RewriteRuleTokenStream stream_TOK_WAREAD=new RewriteRuleTokenStream(adaptor,"token TOK_WAREAD");
        RewriteRuleTokenStream stream_TOK_WORD1=new RewriteRuleTokenStream(adaptor,"token TOK_WORD1");
        RewriteRuleTokenStream stream_TOK_RP=new RewriteRuleTokenStream(adaptor,"token TOK_RP");
        RewriteRuleTokenStream stream_TOK_CASE=new RewriteRuleTokenStream(adaptor,"token TOK_CASE");
        RewriteRuleTokenStream stream_TOK_ESAC=new RewriteRuleTokenStream(adaptor,"token TOK_ESAC");
        RewriteRuleTokenStream stream_TOK_NEXT=new RewriteRuleTokenStream(adaptor,"token TOK_NEXT");
        RewriteRuleTokenStream stream_TOK_COMMA=new RewriteRuleTokenStream(adaptor,"token TOK_COMMA");
        RewriteRuleSubtreeStream stream_case_element_list_expr=new RewriteRuleSubtreeStream(adaptor,"rule case_element_list_expr");
        RewriteRuleSubtreeStream stream_constant=new RewriteRuleSubtreeStream(adaptor,"rule constant");
        RewriteRuleSubtreeStream stream_simple_root_expr=new RewriteRuleSubtreeStream(adaptor,"rule simple_root_expr");
        RewriteRuleSubtreeStream stream_ctls_root_expr=new RewriteRuleSubtreeStream(adaptor,"rule ctls_root_expr");
        RewriteRuleSubtreeStream stream_primary_expr_select=new RewriteRuleSubtreeStream(adaptor,"rule primary_expr_select");
        boolean append_end = false; String exp_str = ""; 
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1205:9: ( constant primary_expr_select -> ^( VALUE_T constant NOP primary_expr_select ) | primary_expr_helper1_pointer1 | TOK_LP ctls_root_expr TOK_RP primary_expr_select -> ^( BLOCK_T ctls_root_expr NOP primary_expr_select ) | TOK_BOOL TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_BOOL simple_root_expr NOP primary_expr_select ) | TOK_WORD1 TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WORD1 simple_root_expr NOP primary_expr_select ) | TOK_NEXT TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_NEXT simple_root_expr NOP primary_expr_select ) | TOK_CASE case_element_list_expr TOK_ESAC primary_expr_select -> ^( CASE_LIST_EXPR_T case_element_list_expr NOP primary_expr_select ) | TOK_WAREAD TOK_LP f= simple_root_expr TOK_COMMA s= simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WAREAD $f $s NOP primary_expr_select ) | TOK_WAWRITE TOK_LP f= simple_root_expr tc1= TOK_COMMA m= simple_root_expr tc2= TOK_COMMA s= simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WAWRITE $f $m $s NOP primary_expr_select ) )
            int alt79=9;
            switch ( input.LA(1) ) {
            case TOK_PLUS:
            case TOK_NUMBER:
            case TOK_NUMBER_WORD:
            case TOK_FALSEEXP:
            case TOK_TRUEEXP:
                {
                alt79=1;
                }
                break;
            case TOK_ATOM:
                {
                alt79=2;
                }
                break;
            case TOK_LP:
                {
                alt79=3;
                }
                break;
            case TOK_BOOL:
                {
                alt79=4;
                }
                break;
            case TOK_WORD1:
                {
                alt79=5;
                }
                break;
            case TOK_NEXT:
                {
                alt79=6;
                }
                break;
            case TOK_CASE:
                {
                alt79=7;
                }
                break;
            case TOK_WAREAD:
                {
                alt79=8;
                }
                break;
            case TOK_WAWRITE:
                {
                alt79=9;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("1202:1: ctls_primary_expr_helper1 returns [InternalSpec ret] : ( constant primary_expr_select -> ^( VALUE_T constant NOP primary_expr_select ) | primary_expr_helper1_pointer1 | TOK_LP ctls_root_expr TOK_RP primary_expr_select -> ^( BLOCK_T ctls_root_expr NOP primary_expr_select ) | TOK_BOOL TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_BOOL simple_root_expr NOP primary_expr_select ) | TOK_WORD1 TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WORD1 simple_root_expr NOP primary_expr_select ) | TOK_NEXT TOK_LP simple_root_expr TOK_RP primary_expr_select -> ^( TOK_NEXT simple_root_expr NOP primary_expr_select ) | TOK_CASE case_element_list_expr TOK_ESAC primary_expr_select -> ^( CASE_LIST_EXPR_T case_element_list_expr NOP primary_expr_select ) | TOK_WAREAD TOK_LP f= simple_root_expr TOK_COMMA s= simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WAREAD $f $s NOP primary_expr_select ) | TOK_WAWRITE TOK_LP f= simple_root_expr tc1= TOK_COMMA m= simple_root_expr tc2= TOK_COMMA s= simple_root_expr TOK_RP primary_expr_select -> ^( TOK_WAWRITE $f $m $s NOP primary_expr_select ) );", 79, 0, input);

                throw nvae;
            }

            switch (alt79) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1205:11: constant primary_expr_select
                    {
                    pushFollow(FOLLOW_constant_in_ctls_primary_expr_helper112401);
                    constant190=constant();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_constant.add(constant190.getTree());
                    pushFollow(FOLLOW_primary_expr_select_in_ctls_primary_expr_helper112403);
                    primary_expr_select191=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select191.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    // AST REWRITE
                    // elements: primary_expr_select, constant
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1208:9: -> ^( VALUE_T constant NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1208:12: ^( VALUE_T constant NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(VALUE_T, "VALUE_T"), root_1);

                        adaptor.addChild(root_1, stream_constant.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1209:11: primary_expr_helper1_pointer1
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_primary_expr_helper1_pointer1_in_ctls_primary_expr_helper112454);
                    primary_expr_helper1_pointer1192=primary_expr_helper1_pointer1();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, primary_expr_helper1_pointer1192.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1218:11: TOK_LP ctls_root_expr TOK_RP primary_expr_select
                    {
                    TOK_LP193=(Token)input.LT(1);
                    match(input,TOK_LP,FOLLOW_TOK_LP_in_ctls_primary_expr_helper112507); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_LP.add(TOK_LP193);

                    pushFollow(FOLLOW_ctls_root_expr_in_ctls_primary_expr_helper112509);
                    ctls_root_expr194=ctls_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_ctls_root_expr.add(ctls_root_expr194.getTree());
                    TOK_RP195=(Token)input.LT(1);
                    match(input,TOK_RP,FOLLOW_TOK_RP_in_ctls_primary_expr_helper112511); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_RP.add(TOK_RP195);

                    pushFollow(FOLLOW_primary_expr_select_in_ctls_primary_expr_helper112513);
                    primary_expr_select196=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select196.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) retval.ret = ctls_root_expr194.ret; 
                    }

                    // AST REWRITE
                    // elements: ctls_root_expr, primary_expr_select
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1220:9: -> ^( BLOCK_T ctls_root_expr NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1220:12: ^( BLOCK_T ctls_root_expr NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(BLOCK_T, "BLOCK_T"), root_1);

                        adaptor.addChild(root_1, stream_ctls_root_expr.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 4 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1224:11: TOK_BOOL TOK_LP simple_root_expr TOK_RP primary_expr_select
                    {
                    TOK_BOOL197=(Token)input.LT(1);
                    match(input,TOK_BOOL,FOLLOW_TOK_BOOL_in_ctls_primary_expr_helper112584); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_BOOL.add(TOK_BOOL197);

                    TOK_LP198=(Token)input.LT(1);
                    match(input,TOK_LP,FOLLOW_TOK_LP_in_ctls_primary_expr_helper112586); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_LP.add(TOK_LP198);

                    pushFollow(FOLLOW_simple_root_expr_in_ctls_primary_expr_helper112588);
                    simple_root_expr199=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(simple_root_expr199.getTree());
                    TOK_RP200=(Token)input.LT(1);
                    match(input,TOK_RP,FOLLOW_TOK_RP_in_ctls_primary_expr_helper112590); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_RP.add(TOK_RP200);

                    pushFollow(FOLLOW_primary_expr_select_in_ctls_primary_expr_helper112592);
                    primary_expr_select201=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select201.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    // AST REWRITE
                    // elements: TOK_BOOL, simple_root_expr, primary_expr_select
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1227:9: -> ^( TOK_BOOL simple_root_expr NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1227:12: ^( TOK_BOOL simple_root_expr NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_TOK_BOOL.next(), root_1);

                        adaptor.addChild(root_1, stream_simple_root_expr.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 5 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1228:11: TOK_WORD1 TOK_LP simple_root_expr TOK_RP primary_expr_select
                    {
                    TOK_WORD1202=(Token)input.LT(1);
                    match(input,TOK_WORD1,FOLLOW_TOK_WORD1_in_ctls_primary_expr_helper112643); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_WORD1.add(TOK_WORD1202);

                    TOK_LP203=(Token)input.LT(1);
                    match(input,TOK_LP,FOLLOW_TOK_LP_in_ctls_primary_expr_helper112645); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_LP.add(TOK_LP203);

                    pushFollow(FOLLOW_simple_root_expr_in_ctls_primary_expr_helper112647);
                    simple_root_expr204=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(simple_root_expr204.getTree());
                    TOK_RP205=(Token)input.LT(1);
                    match(input,TOK_RP,FOLLOW_TOK_RP_in_ctls_primary_expr_helper112649); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_RP.add(TOK_RP205);

                    pushFollow(FOLLOW_primary_expr_select_in_ctls_primary_expr_helper112651);
                    primary_expr_select206=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select206.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    // AST REWRITE
                    // elements: TOK_WORD1, simple_root_expr, primary_expr_select
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1231:9: -> ^( TOK_WORD1 simple_root_expr NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1231:12: ^( TOK_WORD1 simple_root_expr NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_TOK_WORD1.next(), root_1);

                        adaptor.addChild(root_1, stream_simple_root_expr.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 6 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1233:11: TOK_NEXT TOK_LP simple_root_expr TOK_RP primary_expr_select
                    {
                    TOK_NEXT207=(Token)input.LT(1);
                    match(input,TOK_NEXT,FOLLOW_TOK_NEXT_in_ctls_primary_expr_helper112711); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_NEXT.add(TOK_NEXT207);

                    TOK_LP208=(Token)input.LT(1);
                    match(input,TOK_LP,FOLLOW_TOK_LP_in_ctls_primary_expr_helper112713); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_LP.add(TOK_LP208);

                    pushFollow(FOLLOW_simple_root_expr_in_ctls_primary_expr_helper112715);
                    simple_root_expr209=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(simple_root_expr209.getTree());
                    TOK_RP210=(Token)input.LT(1);
                    match(input,TOK_RP,FOLLOW_TOK_RP_in_ctls_primary_expr_helper112717); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_RP.add(TOK_RP210);

                    pushFollow(FOLLOW_primary_expr_select_in_ctls_primary_expr_helper112719);
                    primary_expr_select211=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select211.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    // AST REWRITE
                    // elements: primary_expr_select, TOK_NEXT, simple_root_expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1236:9: -> ^( TOK_NEXT simple_root_expr NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1236:12: ^( TOK_NEXT simple_root_expr NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_TOK_NEXT.next(), root_1);

                        adaptor.addChild(root_1, stream_simple_root_expr.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 7 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1238:11: TOK_CASE case_element_list_expr TOK_ESAC primary_expr_select
                    {
                    TOK_CASE212=(Token)input.LT(1);
                    match(input,TOK_CASE,FOLLOW_TOK_CASE_in_ctls_primary_expr_helper112779); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_CASE.add(TOK_CASE212);

                    pushFollow(FOLLOW_case_element_list_expr_in_ctls_primary_expr_helper112781);
                    case_element_list_expr213=case_element_list_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_case_element_list_expr.add(case_element_list_expr213.getTree());
                    TOK_ESAC214=(Token)input.LT(1);
                    match(input,TOK_ESAC,FOLLOW_TOK_ESAC_in_ctls_primary_expr_helper112783); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_ESAC.add(TOK_ESAC214);

                    pushFollow(FOLLOW_primary_expr_select_in_ctls_primary_expr_helper112785);
                    primary_expr_select215=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select215.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    // AST REWRITE
                    // elements: primary_expr_select, case_element_list_expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1241:9: -> ^( CASE_LIST_EXPR_T case_element_list_expr NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1241:12: ^( CASE_LIST_EXPR_T case_element_list_expr NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(CASE_LIST_EXPR_T, "CASE_LIST_EXPR_T"), root_1);

                        adaptor.addChild(root_1, stream_case_element_list_expr.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 8 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1243:11: TOK_WAREAD TOK_LP f= simple_root_expr TOK_COMMA s= simple_root_expr TOK_RP primary_expr_select
                    {
                    TOK_WAREAD216=(Token)input.LT(1);
                    match(input,TOK_WAREAD,FOLLOW_TOK_WAREAD_in_ctls_primary_expr_helper112845); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_WAREAD.add(TOK_WAREAD216);

                    TOK_LP217=(Token)input.LT(1);
                    match(input,TOK_LP,FOLLOW_TOK_LP_in_ctls_primary_expr_helper112847); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_LP.add(TOK_LP217);

                    pushFollow(FOLLOW_simple_root_expr_in_ctls_primary_expr_helper112851);
                    f=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(f.getTree());
                    TOK_COMMA218=(Token)input.LT(1);
                    match(input,TOK_COMMA,FOLLOW_TOK_COMMA_in_ctls_primary_expr_helper112853); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_COMMA.add(TOK_COMMA218);

                    pushFollow(FOLLOW_simple_root_expr_in_ctls_primary_expr_helper112857);
                    s=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(s.getTree());
                    TOK_RP219=(Token)input.LT(1);
                    match(input,TOK_RP,FOLLOW_TOK_RP_in_ctls_primary_expr_helper112859); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_RP.add(TOK_RP219);

                    pushFollow(FOLLOW_primary_expr_select_in_ctls_primary_expr_helper112861);
                    primary_expr_select220=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select220.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    // AST REWRITE
                    // elements: s, primary_expr_select, f, TOK_WAREAD
                    // token labels: 
                    // rule labels: f, retval, s
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_f=new RewriteRuleSubtreeStream(adaptor,"token f",f!=null?f.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_s=new RewriteRuleSubtreeStream(adaptor,"token s",s!=null?s.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1246:9: -> ^( TOK_WAREAD $f $s NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1246:12: ^( TOK_WAREAD $f $s NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_TOK_WAREAD.next(), root_1);

                        adaptor.addChild(root_1, stream_f.next());
                        adaptor.addChild(root_1, stream_s.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 9 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1248:11: TOK_WAWRITE TOK_LP f= simple_root_expr tc1= TOK_COMMA m= simple_root_expr tc2= TOK_COMMA s= simple_root_expr TOK_RP primary_expr_select
                    {
                    TOK_WAWRITE221=(Token)input.LT(1);
                    match(input,TOK_WAWRITE,FOLLOW_TOK_WAWRITE_in_ctls_primary_expr_helper112925); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_WAWRITE.add(TOK_WAWRITE221);

                    TOK_LP222=(Token)input.LT(1);
                    match(input,TOK_LP,FOLLOW_TOK_LP_in_ctls_primary_expr_helper112927); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_LP.add(TOK_LP222);

                    pushFollow(FOLLOW_simple_root_expr_in_ctls_primary_expr_helper112931);
                    f=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(f.getTree());
                    tc1=(Token)input.LT(1);
                    match(input,TOK_COMMA,FOLLOW_TOK_COMMA_in_ctls_primary_expr_helper112935); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_COMMA.add(tc1);

                    pushFollow(FOLLOW_simple_root_expr_in_ctls_primary_expr_helper112939);
                    m=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(m.getTree());
                    tc2=(Token)input.LT(1);
                    match(input,TOK_COMMA,FOLLOW_TOK_COMMA_in_ctls_primary_expr_helper112943); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_COMMA.add(tc2);

                    pushFollow(FOLLOW_simple_root_expr_in_ctls_primary_expr_helper112947);
                    s=simple_root_expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_simple_root_expr.add(s.getTree());
                    TOK_RP223=(Token)input.LT(1);
                    match(input,TOK_RP,FOLLOW_TOK_RP_in_ctls_primary_expr_helper112949); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_RP.add(TOK_RP223);

                    pushFollow(FOLLOW_primary_expr_select_in_ctls_primary_expr_helper112951);
                    primary_expr_select224=primary_expr_select();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select224.getTree());
                    if ( backtracking==0 ) {
                       if(!er()) append_end = true; if(!er()) retval.ret = InitSpec.mk_ref(input, ((Token)retval.start), input.toString(retval.start,input.LT(-1))); 
                    }

                    // AST REWRITE
                    // elements: f, primary_expr_select, m, s, TOK_WAWRITE
                    // token labels: 
                    // rule labels: f, retval, s, m
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_f=new RewriteRuleSubtreeStream(adaptor,"token f",f!=null?f.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_s=new RewriteRuleSubtreeStream(adaptor,"token s",s!=null?s.tree:null);
                    RewriteRuleSubtreeStream stream_m=new RewriteRuleSubtreeStream(adaptor,"token m",m!=null?m.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1251:9: -> ^( TOK_WAWRITE $f $m $s NOP primary_expr_select )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1251:12: ^( TOK_WAWRITE $f $m $s NOP primary_expr_select )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_TOK_WAWRITE.next(), root_1);

                        adaptor.addChild(root_1, stream_f.next());
                        adaptor.addChild(root_1, stream_m.next());
                        adaptor.addChild(root_1, stream_s.next());
                        adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                        adaptor.addChild(root_1, stream_primary_expr_select.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( backtracking==0 ) {
               if(append_end) retval.ret.setEndToken(((Token)retval.stop)); if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end ctls_primary_expr_helper1

    public static class primary_expr_helper1_pointer1_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start primary_expr_helper1_pointer1
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1261:1: primary_expr_helper1_pointer1 : TOK_ATOM primary_expr_select -> ^( VALUE_T TOK_ATOM NOP primary_expr_select ) ;
    public final primary_expr_helper1_pointer1_return primary_expr_helper1_pointer1() throws RecognitionException {
        primary_expr_helper1_pointer1_return retval = new primary_expr_helper1_pointer1_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TOK_ATOM225=null;
        primary_expr_select_return primary_expr_select226 = null;


        Object TOK_ATOM225_tree=null;
        RewriteRuleTokenStream stream_TOK_ATOM=new RewriteRuleTokenStream(adaptor,"token TOK_ATOM");
        RewriteRuleSubtreeStream stream_primary_expr_select=new RewriteRuleSubtreeStream(adaptor,"rule primary_expr_select");
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1261:31: ( TOK_ATOM primary_expr_select -> ^( VALUE_T TOK_ATOM NOP primary_expr_select ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1261:33: TOK_ATOM primary_expr_select
            {
            TOK_ATOM225=(Token)input.LT(1);
            match(input,TOK_ATOM,FOLLOW_TOK_ATOM_in_primary_expr_helper1_pointer113022); if (failed) return retval;
            if ( backtracking==0 ) stream_TOK_ATOM.add(TOK_ATOM225);

            pushFollow(FOLLOW_primary_expr_select_in_primary_expr_helper1_pointer113024);
            primary_expr_select226=primary_expr_select();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_primary_expr_select.add(primary_expr_select226.getTree());

            // AST REWRITE
            // elements: primary_expr_select, TOK_ATOM
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1262:9: -> ^( VALUE_T TOK_ATOM NOP primary_expr_select )
            {
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1262:12: ^( VALUE_T TOK_ATOM NOP primary_expr_select )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(VALUE_T, "VALUE_T"), root_1);

                adaptor.addChild(root_1, stream_TOK_ATOM.next());
                adaptor.addChild(root_1, adaptor.create(NOP, "NOP"));
                adaptor.addChild(root_1, stream_primary_expr_select.next());

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
    // $ANTLR end primary_expr_helper1_pointer1

    public static class primary_expr_select_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start primary_expr_select
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1267:1: primary_expr_select : ( primary_expr_select_helper | primary_expr_ref )* ;
    public final primary_expr_select_return primary_expr_select() throws RecognitionException {
        primary_expr_select_return retval = new primary_expr_select_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        primary_expr_select_helper_return primary_expr_select_helper227 = null;

        primary_expr_ref_return primary_expr_ref228 = null;



        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1267:24: ( ( primary_expr_select_helper | primary_expr_ref )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1267:26: ( primary_expr_select_helper | primary_expr_ref )*
            {
            root_0 = (Object)adaptor.nil();

            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1267:26: ( primary_expr_select_helper | primary_expr_ref )*
            loop80:
            do {
                int alt80=3;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==TOK_LB) ) {
                    alt80=1;
                }
                else if ( (LA80_0==TOK_DOT) ) {
                    alt80=2;
                }


                switch (alt80) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1267:27: primary_expr_select_helper
            	    {
            	    pushFollow(FOLLOW_primary_expr_select_helper_in_primary_expr_select13067);
            	    primary_expr_select_helper227=primary_expr_select_helper();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, primary_expr_select_helper227.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1267:56: primary_expr_ref
            	    {
            	    pushFollow(FOLLOW_primary_expr_ref_in_primary_expr_select13071);
            	    primary_expr_ref228=primary_expr_ref();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, primary_expr_ref228.getTree());

            	    }
            	    break;

            	default :
            	    break loop80;
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
    // $ANTLR end primary_expr_select

    public static class primary_expr_ref_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start primary_expr_ref
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1269:1: primary_expr_ref : ( TOK_DOT ( TOK_ATOM | TOK_NUMBER ) ) ;
    public final primary_expr_ref_return primary_expr_ref() throws RecognitionException {
        primary_expr_ref_return retval = new primary_expr_ref_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TOK_DOT229=null;
        Token set230=null;

        Object TOK_DOT229_tree=null;
        Object set230_tree=null;

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1269:21: ( ( TOK_DOT ( TOK_ATOM | TOK_NUMBER ) ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1269:23: ( TOK_DOT ( TOK_ATOM | TOK_NUMBER ) )
            {
            root_0 = (Object)adaptor.nil();

            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1269:23: ( TOK_DOT ( TOK_ATOM | TOK_NUMBER ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1269:24: TOK_DOT ( TOK_ATOM | TOK_NUMBER )
            {
            TOK_DOT229=(Token)input.LT(1);
            match(input,TOK_DOT,FOLLOW_TOK_DOT_in_primary_expr_ref13094); if (failed) return retval;
            set230=(Token)input.LT(1);
            if ( input.LA(1)==TOK_ATOM||input.LA(1)==TOK_NUMBER ) {
                input.consume();
                if ( backtracking==0 ) adaptor.addChild(root_0, adaptor.create(set230));
                errorRecovery=false;failed=false;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_primary_expr_ref13097);    throw mse;
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
    // $ANTLR end primary_expr_ref

    public static class primary_expr_select_helper_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start primary_expr_select_helper
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );
    public final primary_expr_select_helper_return primary_expr_select_helper() throws RecognitionException {
        primary_expr_select_helper_return retval = new primary_expr_select_helper_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        primary_expr_select_helper_arr_suffix_return primary_expr_select_helper_arr_suffix231 = null;

        primary_expr_select_helper_bit_suffix_return primary_expr_select_helper_bit_suffix232 = null;



        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1271:29: ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==TOK_LB) ) {
                switch ( input.LA(2) ) {
                case TOK_FALSEEXP:
                    {
                    int LA81_2 = input.LA(3);

                    if ( (synpred15()) ) {
                        alt81=1;
                    }
                    else if ( (true) ) {
                        alt81=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 2, input);

                        throw nvae;
                    }
                    }
                    break;
                case TOK_TRUEEXP:
                    {
                    int LA81_3 = input.LA(3);

                    if ( (synpred15()) ) {
                        alt81=1;
                    }
                    else if ( (true) ) {
                        alt81=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case TOK_NUMBER:
                    {
                    int LA81_4 = input.LA(3);

                    if ( (synpred15()) ) {
                        alt81=1;
                    }
                    else if ( (true) ) {
                        alt81=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case TOK_PLUS:
                    {
                    int LA81_5 = input.LA(3);

                    if ( (LA81_5==TOK_NUMBER) ) {
                        int LA81_23 = input.LA(4);

                        if ( (synpred15()) ) {
                            alt81=1;
                        }
                        else if ( (true) ) {
                            alt81=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 23, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 5, input);

                        throw nvae;
                    }
                    }
                    break;
                case TOK_NUMBER_WORD:
                    {
                    int LA81_6 = input.LA(3);

                    if ( (synpred15()) ) {
                        alt81=1;
                    }
                    else if ( (true) ) {
                        alt81=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 6, input);

                        throw nvae;
                    }
                    }
                    break;
                case TOK_ATOM:
                    {
                    int LA81_7 = input.LA(3);

                    if ( (synpred15()) ) {
                        alt81=1;
                    }
                    else if ( (true) ) {
                        alt81=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 7, input);

                        throw nvae;
                    }
                    }
                    break;
                case TOK_LP:
                    {
                    int LA81_8 = input.LA(3);

                    if ( (synpred15()) ) {
                        alt81=1;
                    }
                    else if ( (true) ) {
                        alt81=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 8, input);

                        throw nvae;
                    }
                    }
                    break;
                case TOK_BOOL:
                    {
                    int LA81_9 = input.LA(3);

                    if ( (LA81_9==TOK_LP) ) {
                        int LA81_30 = input.LA(4);

                        if ( (synpred15()) ) {
                            alt81=1;
                        }
                        else if ( (true) ) {
                            alt81=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 30, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 9, input);

                        throw nvae;
                    }
                    }
                    break;
                case TOK_WORD1:
                    {
                    int LA81_10 = input.LA(3);

                    if ( (LA81_10==TOK_LP) ) {
                        int LA81_31 = input.LA(4);

                        if ( (synpred15()) ) {
                            alt81=1;
                        }
                        else if ( (true) ) {
                            alt81=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 31, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 10, input);

                        throw nvae;
                    }
                    }
                    break;
                case TOK_NEXT:
                    {
                    int LA81_11 = input.LA(3);

                    if ( (LA81_11==TOK_LP) ) {
                        int LA81_32 = input.LA(4);

                        if ( (synpred15()) ) {
                            alt81=1;
                        }
                        else if ( (true) ) {
                            alt81=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 32, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 11, input);

                        throw nvae;
                    }
                    }
                    break;
                case TOK_CASE:
                    {
                    int LA81_12 = input.LA(3);

                    if ( (synpred15()) ) {
                        alt81=1;
                    }
                    else if ( (true) ) {
                        alt81=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 12, input);

                        throw nvae;
                    }
                    }
                    break;
                case TOK_WAREAD:
                    {
                    int LA81_13 = input.LA(3);

                    if ( (LA81_13==TOK_LP) ) {
                        int LA81_35 = input.LA(4);

                        if ( (synpred15()) ) {
                            alt81=1;
                        }
                        else if ( (true) ) {
                            alt81=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 35, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 13, input);

                        throw nvae;
                    }
                    }
                    break;
                case TOK_WAWRITE:
                    {
                    int LA81_14 = input.LA(3);

                    if ( (LA81_14==TOK_LP) ) {
                        int LA81_36 = input.LA(4);

                        if ( (synpred15()) ) {
                            alt81=1;
                        }
                        else if ( (true) ) {
                            alt81=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 36, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 14, input);

                        throw nvae;
                    }
                    }
                    break;
                case TOK_MINUS:
                    {
                    switch ( input.LA(3) ) {
                    case TOK_NUMBER:
                        {
                        int LA81_37 = input.LA(4);

                        if ( (synpred15()) ) {
                            alt81=1;
                        }
                        else if ( (true) ) {
                            alt81=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 37, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TOK_FALSEEXP:
                        {
                        int LA81_38 = input.LA(4);

                        if ( (synpred15()) ) {
                            alt81=1;
                        }
                        else if ( (true) ) {
                            alt81=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 38, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TOK_TRUEEXP:
                        {
                        int LA81_39 = input.LA(4);

                        if ( (synpred15()) ) {
                            alt81=1;
                        }
                        else if ( (true) ) {
                            alt81=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 39, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TOK_PLUS:
                        {
                        int LA81_40 = input.LA(4);

                        if ( (LA81_40==TOK_NUMBER) ) {
                            int LA81_86 = input.LA(5);

                            if ( (synpred15()) ) {
                                alt81=1;
                            }
                            else if ( (true) ) {
                                alt81=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 86, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 40, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TOK_NUMBER_WORD:
                        {
                        int LA81_41 = input.LA(4);

                        if ( (synpred15()) ) {
                            alt81=1;
                        }
                        else if ( (true) ) {
                            alt81=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 41, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TOK_ATOM:
                        {
                        int LA81_42 = input.LA(4);

                        if ( (synpred15()) ) {
                            alt81=1;
                        }
                        else if ( (true) ) {
                            alt81=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 42, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TOK_LP:
                        {
                        int LA81_43 = input.LA(4);

                        if ( (synpred15()) ) {
                            alt81=1;
                        }
                        else if ( (true) ) {
                            alt81=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 43, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TOK_BOOL:
                        {
                        int LA81_44 = input.LA(4);

                        if ( (LA81_44==TOK_LP) ) {
                            int LA81_92 = input.LA(5);

                            if ( (synpred15()) ) {
                                alt81=1;
                            }
                            else if ( (true) ) {
                                alt81=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 92, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 44, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TOK_WORD1:
                        {
                        int LA81_45 = input.LA(4);

                        if ( (LA81_45==TOK_LP) ) {
                            int LA81_93 = input.LA(5);

                            if ( (synpred15()) ) {
                                alt81=1;
                            }
                            else if ( (true) ) {
                                alt81=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 93, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 45, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TOK_NEXT:
                        {
                        int LA81_46 = input.LA(4);

                        if ( (LA81_46==TOK_LP) ) {
                            int LA81_94 = input.LA(5);

                            if ( (synpred15()) ) {
                                alt81=1;
                            }
                            else if ( (true) ) {
                                alt81=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 94, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 46, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TOK_CASE:
                        {
                        int LA81_47 = input.LA(4);

                        if ( (synpred15()) ) {
                            alt81=1;
                        }
                        else if ( (true) ) {
                            alt81=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 47, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TOK_WAREAD:
                        {
                        int LA81_48 = input.LA(4);

                        if ( (LA81_48==TOK_LP) ) {
                            int LA81_97 = input.LA(5);

                            if ( (synpred15()) ) {
                                alt81=1;
                            }
                            else if ( (true) ) {
                                alt81=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 97, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 48, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TOK_WAWRITE:
                        {
                        int LA81_49 = input.LA(4);

                        if ( (LA81_49==TOK_LP) ) {
                            int LA81_98 = input.LA(5);

                            if ( (synpred15()) ) {
                                alt81=1;
                            }
                            else if ( (true) ) {
                                alt81=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 98, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 49, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TOK_MINUS:
                        {
                        int LA81_50 = input.LA(4);

                        if ( (synpred15()) ) {
                            alt81=1;
                        }
                        else if ( (true) ) {
                            alt81=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 50, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TOK_NOT:
                        {
                        switch ( input.LA(4) ) {
                        case TOK_FALSEEXP:
                            {
                            int LA81_101 = input.LA(5);

                            if ( (synpred15()) ) {
                                alt81=1;
                            }
                            else if ( (true) ) {
                                alt81=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 101, input);

                                throw nvae;
                            }
                            }
                            break;
                        case TOK_TRUEEXP:
                            {
                            int LA81_102 = input.LA(5);

                            if ( (synpred15()) ) {
                                alt81=1;
                            }
                            else if ( (true) ) {
                                alt81=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 102, input);

                                throw nvae;
                            }
                            }
                            break;
                        case TOK_NUMBER:
                            {
                            int LA81_103 = input.LA(5);

                            if ( (synpred15()) ) {
                                alt81=1;
                            }
                            else if ( (true) ) {
                                alt81=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 103, input);

                                throw nvae;
                            }
                            }
                            break;
                        case TOK_PLUS:
                            {
                            int LA81_104 = input.LA(5);

                            if ( (LA81_104==TOK_NUMBER) ) {
                                int LA81_169 = input.LA(6);

                                if ( (synpred15()) ) {
                                    alt81=1;
                                }
                                else if ( (true) ) {
                                    alt81=2;
                                }
                                else {
                                    if (backtracking>0) {failed=true; return retval;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 169, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 104, input);

                                throw nvae;
                            }
                            }
                            break;
                        case TOK_NUMBER_WORD:
                            {
                            int LA81_105 = input.LA(5);

                            if ( (synpred15()) ) {
                                alt81=1;
                            }
                            else if ( (true) ) {
                                alt81=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 105, input);

                                throw nvae;
                            }
                            }
                            break;
                        case TOK_ATOM:
                            {
                            int LA81_106 = input.LA(5);

                            if ( (synpred15()) ) {
                                alt81=1;
                            }
                            else if ( (true) ) {
                                alt81=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 106, input);

                                throw nvae;
                            }
                            }
                            break;
                        case TOK_LP:
                            {
                            int LA81_107 = input.LA(5);

                            if ( (synpred15()) ) {
                                alt81=1;
                            }
                            else if ( (true) ) {
                                alt81=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 107, input);

                                throw nvae;
                            }
                            }
                            break;
                        case TOK_BOOL:
                            {
                            int LA81_108 = input.LA(5);

                            if ( (LA81_108==TOK_LP) ) {
                                int LA81_175 = input.LA(6);

                                if ( (synpred15()) ) {
                                    alt81=1;
                                }
                                else if ( (true) ) {
                                    alt81=2;
                                }
                                else {
                                    if (backtracking>0) {failed=true; return retval;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 175, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 108, input);

                                throw nvae;
                            }
                            }
                            break;
                        case TOK_WORD1:
                            {
                            int LA81_109 = input.LA(5);

                            if ( (LA81_109==TOK_LP) ) {
                                int LA81_176 = input.LA(6);

                                if ( (synpred15()) ) {
                                    alt81=1;
                                }
                                else if ( (true) ) {
                                    alt81=2;
                                }
                                else {
                                    if (backtracking>0) {failed=true; return retval;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 176, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 109, input);

                                throw nvae;
                            }
                            }
                            break;
                        case TOK_NEXT:
                            {
                            int LA81_110 = input.LA(5);

                            if ( (LA81_110==TOK_LP) ) {
                                int LA81_177 = input.LA(6);

                                if ( (synpred15()) ) {
                                    alt81=1;
                                }
                                else if ( (true) ) {
                                    alt81=2;
                                }
                                else {
                                    if (backtracking>0) {failed=true; return retval;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 177, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 110, input);

                                throw nvae;
                            }
                            }
                            break;
                        case TOK_CASE:
                            {
                            int LA81_111 = input.LA(5);

                            if ( (synpred15()) ) {
                                alt81=1;
                            }
                            else if ( (true) ) {
                                alt81=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 111, input);

                                throw nvae;
                            }
                            }
                            break;
                        case TOK_WAREAD:
                            {
                            int LA81_112 = input.LA(5);

                            if ( (LA81_112==TOK_LP) ) {
                                int LA81_180 = input.LA(6);

                                if ( (synpred15()) ) {
                                    alt81=1;
                                }
                                else if ( (true) ) {
                                    alt81=2;
                                }
                                else {
                                    if (backtracking>0) {failed=true; return retval;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 180, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 112, input);

                                throw nvae;
                            }
                            }
                            break;
                        case TOK_WAWRITE:
                            {
                            int LA81_113 = input.LA(5);

                            if ( (LA81_113==TOK_LP) ) {
                                int LA81_181 = input.LA(6);

                                if ( (synpred15()) ) {
                                    alt81=1;
                                }
                                else if ( (true) ) {
                                    alt81=2;
                                }
                                else {
                                    if (backtracking>0) {failed=true; return retval;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 181, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 113, input);

                                throw nvae;
                            }
                            }
                            break;
                        case TOK_MINUS:
                            {
                            int LA81_114 = input.LA(5);

                            if ( (synpred15()) ) {
                                alt81=1;
                            }
                            else if ( (true) ) {
                                alt81=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 114, input);

                                throw nvae;
                            }
                            }
                            break;
                        case TOK_NOT:
                            {
                            int LA81_115 = input.LA(5);

                            if ( (synpred15()) ) {
                                alt81=1;
                            }
                            else if ( (true) ) {
                                alt81=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 115, input);

                                throw nvae;
                            }
                            }
                            break;
                        default:
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 51, input);

                            throw nvae;
                        }

                        }
                        break;
                    default:
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 15, input);

                        throw nvae;
                    }

                    }
                    break;
                case TOK_NOT:
                    {
                    switch ( input.LA(3) ) {
                    case TOK_FALSEEXP:
                        {
                        int LA81_52 = input.LA(4);

                        if ( (synpred15()) ) {
                            alt81=1;
                        }
                        else if ( (true) ) {
                            alt81=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 52, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TOK_TRUEEXP:
                        {
                        int LA81_53 = input.LA(4);

                        if ( (synpred15()) ) {
                            alt81=1;
                        }
                        else if ( (true) ) {
                            alt81=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 53, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TOK_NUMBER:
                        {
                        int LA81_54 = input.LA(4);

                        if ( (synpred15()) ) {
                            alt81=1;
                        }
                        else if ( (true) ) {
                            alt81=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 54, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TOK_PLUS:
                        {
                        int LA81_55 = input.LA(4);

                        if ( (LA81_55==TOK_NUMBER) ) {
                            int LA81_122 = input.LA(5);

                            if ( (synpred15()) ) {
                                alt81=1;
                            }
                            else if ( (true) ) {
                                alt81=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 122, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 55, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TOK_NUMBER_WORD:
                        {
                        int LA81_56 = input.LA(4);

                        if ( (synpred15()) ) {
                            alt81=1;
                        }
                        else if ( (true) ) {
                            alt81=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 56, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TOK_ATOM:
                        {
                        int LA81_57 = input.LA(4);

                        if ( (synpred15()) ) {
                            alt81=1;
                        }
                        else if ( (true) ) {
                            alt81=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 57, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TOK_LP:
                        {
                        int LA81_58 = input.LA(4);

                        if ( (synpred15()) ) {
                            alt81=1;
                        }
                        else if ( (true) ) {
                            alt81=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 58, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TOK_BOOL:
                        {
                        int LA81_59 = input.LA(4);

                        if ( (LA81_59==TOK_LP) ) {
                            int LA81_129 = input.LA(5);

                            if ( (synpred15()) ) {
                                alt81=1;
                            }
                            else if ( (true) ) {
                                alt81=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 129, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 59, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TOK_WORD1:
                        {
                        int LA81_60 = input.LA(4);

                        if ( (LA81_60==TOK_LP) ) {
                            int LA81_130 = input.LA(5);

                            if ( (synpred15()) ) {
                                alt81=1;
                            }
                            else if ( (true) ) {
                                alt81=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 130, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 60, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TOK_NEXT:
                        {
                        int LA81_61 = input.LA(4);

                        if ( (LA81_61==TOK_LP) ) {
                            int LA81_131 = input.LA(5);

                            if ( (synpred15()) ) {
                                alt81=1;
                            }
                            else if ( (true) ) {
                                alt81=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 131, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 61, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TOK_CASE:
                        {
                        int LA81_62 = input.LA(4);

                        if ( (synpred15()) ) {
                            alt81=1;
                        }
                        else if ( (true) ) {
                            alt81=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 62, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TOK_WAREAD:
                        {
                        int LA81_63 = input.LA(4);

                        if ( (LA81_63==TOK_LP) ) {
                            int LA81_134 = input.LA(5);

                            if ( (synpred15()) ) {
                                alt81=1;
                            }
                            else if ( (true) ) {
                                alt81=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 134, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 63, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TOK_WAWRITE:
                        {
                        int LA81_64 = input.LA(4);

                        if ( (LA81_64==TOK_LP) ) {
                            int LA81_135 = input.LA(5);

                            if ( (synpred15()) ) {
                                alt81=1;
                            }
                            else if ( (true) ) {
                                alt81=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 135, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 64, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TOK_MINUS:
                        {
                        switch ( input.LA(4) ) {
                        case TOK_FALSEEXP:
                            {
                            int LA81_136 = input.LA(5);

                            if ( (synpred15()) ) {
                                alt81=1;
                            }
                            else if ( (true) ) {
                                alt81=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 136, input);

                                throw nvae;
                            }
                            }
                            break;
                        case TOK_TRUEEXP:
                            {
                            int LA81_137 = input.LA(5);

                            if ( (synpred15()) ) {
                                alt81=1;
                            }
                            else if ( (true) ) {
                                alt81=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 137, input);

                                throw nvae;
                            }
                            }
                            break;
                        case TOK_NUMBER:
                            {
                            int LA81_138 = input.LA(5);

                            if ( (synpred15()) ) {
                                alt81=1;
                            }
                            else if ( (true) ) {
                                alt81=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 138, input);

                                throw nvae;
                            }
                            }
                            break;
                        case TOK_PLUS:
                            {
                            int LA81_139 = input.LA(5);

                            if ( (LA81_139==TOK_NUMBER) ) {
                                int LA81_202 = input.LA(6);

                                if ( (synpred15()) ) {
                                    alt81=1;
                                }
                                else if ( (true) ) {
                                    alt81=2;
                                }
                                else {
                                    if (backtracking>0) {failed=true; return retval;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 202, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 139, input);

                                throw nvae;
                            }
                            }
                            break;
                        case TOK_NUMBER_WORD:
                            {
                            int LA81_140 = input.LA(5);

                            if ( (synpred15()) ) {
                                alt81=1;
                            }
                            else if ( (true) ) {
                                alt81=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 140, input);

                                throw nvae;
                            }
                            }
                            break;
                        case TOK_ATOM:
                            {
                            int LA81_141 = input.LA(5);

                            if ( (synpred15()) ) {
                                alt81=1;
                            }
                            else if ( (true) ) {
                                alt81=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 141, input);

                                throw nvae;
                            }
                            }
                            break;
                        case TOK_LP:
                            {
                            int LA81_142 = input.LA(5);

                            if ( (synpred15()) ) {
                                alt81=1;
                            }
                            else if ( (true) ) {
                                alt81=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 142, input);

                                throw nvae;
                            }
                            }
                            break;
                        case TOK_BOOL:
                            {
                            int LA81_143 = input.LA(5);

                            if ( (LA81_143==TOK_LP) ) {
                                int LA81_208 = input.LA(6);

                                if ( (synpred15()) ) {
                                    alt81=1;
                                }
                                else if ( (true) ) {
                                    alt81=2;
                                }
                                else {
                                    if (backtracking>0) {failed=true; return retval;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 208, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 143, input);

                                throw nvae;
                            }
                            }
                            break;
                        case TOK_WORD1:
                            {
                            int LA81_144 = input.LA(5);

                            if ( (LA81_144==TOK_LP) ) {
                                int LA81_209 = input.LA(6);

                                if ( (synpred15()) ) {
                                    alt81=1;
                                }
                                else if ( (true) ) {
                                    alt81=2;
                                }
                                else {
                                    if (backtracking>0) {failed=true; return retval;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 209, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 144, input);

                                throw nvae;
                            }
                            }
                            break;
                        case TOK_NEXT:
                            {
                            int LA81_145 = input.LA(5);

                            if ( (LA81_145==TOK_LP) ) {
                                int LA81_210 = input.LA(6);

                                if ( (synpred15()) ) {
                                    alt81=1;
                                }
                                else if ( (true) ) {
                                    alt81=2;
                                }
                                else {
                                    if (backtracking>0) {failed=true; return retval;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 210, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 145, input);

                                throw nvae;
                            }
                            }
                            break;
                        case TOK_CASE:
                            {
                            int LA81_146 = input.LA(5);

                            if ( (synpred15()) ) {
                                alt81=1;
                            }
                            else if ( (true) ) {
                                alt81=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 146, input);

                                throw nvae;
                            }
                            }
                            break;
                        case TOK_WAREAD:
                            {
                            int LA81_147 = input.LA(5);

                            if ( (LA81_147==TOK_LP) ) {
                                int LA81_213 = input.LA(6);

                                if ( (synpred15()) ) {
                                    alt81=1;
                                }
                                else if ( (true) ) {
                                    alt81=2;
                                }
                                else {
                                    if (backtracking>0) {failed=true; return retval;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 213, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 147, input);

                                throw nvae;
                            }
                            }
                            break;
                        case TOK_WAWRITE:
                            {
                            int LA81_148 = input.LA(5);

                            if ( (LA81_148==TOK_LP) ) {
                                int LA81_214 = input.LA(6);

                                if ( (synpred15()) ) {
                                    alt81=1;
                                }
                                else if ( (true) ) {
                                    alt81=2;
                                }
                                else {
                                    if (backtracking>0) {failed=true; return retval;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 214, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 148, input);

                                throw nvae;
                            }
                            }
                            break;
                        case TOK_MINUS:
                            {
                            int LA81_149 = input.LA(5);

                            if ( (synpred15()) ) {
                                alt81=1;
                            }
                            else if ( (true) ) {
                                alt81=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 149, input);

                                throw nvae;
                            }
                            }
                            break;
                        case TOK_NOT:
                            {
                            int LA81_150 = input.LA(5);

                            if ( (synpred15()) ) {
                                alt81=1;
                            }
                            else if ( (true) ) {
                                alt81=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 150, input);

                                throw nvae;
                            }
                            }
                            break;
                        default:
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 65, input);

                            throw nvae;
                        }

                        }
                        break;
                    case TOK_NOT:
                        {
                        int LA81_66 = input.LA(4);

                        if ( (synpred15()) ) {
                            alt81=1;
                        }
                        else if ( (true) ) {
                            alt81=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 66, input);

                            throw nvae;
                        }
                        }
                        break;
                    default:
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 16, input);

                        throw nvae;
                    }

                    }
                    break;
                case TOK_LCB:
                    {
                    int LA81_17 = input.LA(3);

                    if ( (synpred15()) ) {
                        alt81=1;
                    }
                    else if ( (true) ) {
                        alt81=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 17, input);

                        throw nvae;
                    }
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 1, input);

                    throw nvae;
                }

            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("1271:1: primary_expr_select_helper : ( ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix | primary_expr_select_helper_bit_suffix );", 81, 0, input);

                throw nvae;
            }
            switch (alt81) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1271:31: ( TOK_LB simple_root_expr TOK_RB )=> primary_expr_select_helper_arr_suffix
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_primary_expr_select_helper_arr_suffix_in_primary_expr_select_helper13131);
                    primary_expr_select_helper_arr_suffix231=primary_expr_select_helper_arr_suffix();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, primary_expr_select_helper_arr_suffix231.getTree());

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1272:11: primary_expr_select_helper_bit_suffix
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_primary_expr_select_helper_bit_suffix_in_primary_expr_select_helper13143);
                    primary_expr_select_helper_bit_suffix232=primary_expr_select_helper_bit_suffix();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, primary_expr_select_helper_bit_suffix232.getTree());

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
    // $ANTLR end primary_expr_select_helper

    public static class primary_expr_select_helper_arr_suffix_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start primary_expr_select_helper_arr_suffix
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1274:1: primary_expr_select_helper_arr_suffix : TOK_LB simple_root_expr TOK_RB -> ^( ARRAY_INDEX_T simple_root_expr ) ;
    public final primary_expr_select_helper_arr_suffix_return primary_expr_select_helper_arr_suffix() throws RecognitionException {
        primary_expr_select_helper_arr_suffix_return retval = new primary_expr_select_helper_arr_suffix_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TOK_LB233=null;
        Token TOK_RB235=null;
        simple_root_expr_return simple_root_expr234 = null;


        Object TOK_LB233_tree=null;
        Object TOK_RB235_tree=null;
        RewriteRuleTokenStream stream_TOK_LB=new RewriteRuleTokenStream(adaptor,"token TOK_LB");
        RewriteRuleTokenStream stream_TOK_RB=new RewriteRuleTokenStream(adaptor,"token TOK_RB");
        RewriteRuleSubtreeStream stream_simple_root_expr=new RewriteRuleSubtreeStream(adaptor,"rule simple_root_expr");
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1275:9: ( TOK_LB simple_root_expr TOK_RB -> ^( ARRAY_INDEX_T simple_root_expr ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1275:11: TOK_LB simple_root_expr TOK_RB
            {
            TOK_LB233=(Token)input.LT(1);
            match(input,TOK_LB,FOLLOW_TOK_LB_in_primary_expr_select_helper_arr_suffix13167); if (failed) return retval;
            if ( backtracking==0 ) stream_TOK_LB.add(TOK_LB233);

            pushFollow(FOLLOW_simple_root_expr_in_primary_expr_select_helper_arr_suffix13169);
            simple_root_expr234=simple_root_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_simple_root_expr.add(simple_root_expr234.getTree());
            TOK_RB235=(Token)input.LT(1);
            match(input,TOK_RB,FOLLOW_TOK_RB_in_primary_expr_select_helper_arr_suffix13171); if (failed) return retval;
            if ( backtracking==0 ) stream_TOK_RB.add(TOK_RB235);


            // AST REWRITE
            // elements: simple_root_expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1276:9: -> ^( ARRAY_INDEX_T simple_root_expr )
            {
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1276:12: ^( ARRAY_INDEX_T simple_root_expr )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(ARRAY_INDEX_T, "ARRAY_INDEX_T"), root_1);

                adaptor.addChild(root_1, stream_simple_root_expr.next());

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
    // $ANTLR end primary_expr_select_helper_arr_suffix

    public static class primary_expr_select_helper_bit_suffix_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start primary_expr_select_helper_bit_suffix
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1278:1: primary_expr_select_helper_bit_suffix : TOK_LB f= simple_root_expr TOK_COLON s= simple_root_expr TOK_RB -> ^( BIT_SELECT_T $f $s) ;
    public final primary_expr_select_helper_bit_suffix_return primary_expr_select_helper_bit_suffix() throws RecognitionException {
        primary_expr_select_helper_bit_suffix_return retval = new primary_expr_select_helper_bit_suffix_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TOK_LB236=null;
        Token TOK_COLON237=null;
        Token TOK_RB238=null;
        simple_root_expr_return f = null;

        simple_root_expr_return s = null;


        Object TOK_LB236_tree=null;
        Object TOK_COLON237_tree=null;
        Object TOK_RB238_tree=null;
        RewriteRuleTokenStream stream_TOK_LB=new RewriteRuleTokenStream(adaptor,"token TOK_LB");
        RewriteRuleTokenStream stream_TOK_RB=new RewriteRuleTokenStream(adaptor,"token TOK_RB");
        RewriteRuleTokenStream stream_TOK_COLON=new RewriteRuleTokenStream(adaptor,"token TOK_COLON");
        RewriteRuleSubtreeStream stream_simple_root_expr=new RewriteRuleSubtreeStream(adaptor,"rule simple_root_expr");
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1279:9: ( TOK_LB f= simple_root_expr TOK_COLON s= simple_root_expr TOK_RB -> ^( BIT_SELECT_T $f $s) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1279:11: TOK_LB f= simple_root_expr TOK_COLON s= simple_root_expr TOK_RB
            {
            TOK_LB236=(Token)input.LT(1);
            match(input,TOK_LB,FOLLOW_TOK_LB_in_primary_expr_select_helper_bit_suffix13211); if (failed) return retval;
            if ( backtracking==0 ) stream_TOK_LB.add(TOK_LB236);

            pushFollow(FOLLOW_simple_root_expr_in_primary_expr_select_helper_bit_suffix13215);
            f=simple_root_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_simple_root_expr.add(f.getTree());
            TOK_COLON237=(Token)input.LT(1);
            match(input,TOK_COLON,FOLLOW_TOK_COLON_in_primary_expr_select_helper_bit_suffix13217); if (failed) return retval;
            if ( backtracking==0 ) stream_TOK_COLON.add(TOK_COLON237);

            pushFollow(FOLLOW_simple_root_expr_in_primary_expr_select_helper_bit_suffix13221);
            s=simple_root_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_simple_root_expr.add(s.getTree());
            TOK_RB238=(Token)input.LT(1);
            match(input,TOK_RB,FOLLOW_TOK_RB_in_primary_expr_select_helper_bit_suffix13223); if (failed) return retval;
            if ( backtracking==0 ) stream_TOK_RB.add(TOK_RB238);


            // AST REWRITE
            // elements: f, s
            // token labels: 
            // rule labels: f, retval, s
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_f=new RewriteRuleSubtreeStream(adaptor,"token f",f!=null?f.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_s=new RewriteRuleSubtreeStream(adaptor,"token s",s!=null?s.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1280:9: -> ^( BIT_SELECT_T $f $s)
            {
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1280:12: ^( BIT_SELECT_T $f $s)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(BIT_SELECT_T, "BIT_SELECT_T"), root_1);

                adaptor.addChild(root_1, stream_f.next());
                adaptor.addChild(root_1, stream_s.next());

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
    // $ANTLR end primary_expr_select_helper_bit_suffix

    public static class case_element_expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start case_element_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1283:1: case_element_expr : simple_root_expr TOK_COLON simple_root_expr TOK_SEMI -> ^( CASE_ELEMENT_EXPR_T simple_root_expr simple_root_expr ) ;
    public final case_element_expr_return case_element_expr() throws RecognitionException {
        case_element_expr_return retval = new case_element_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TOK_COLON240=null;
        Token TOK_SEMI242=null;
        simple_root_expr_return simple_root_expr239 = null;

        simple_root_expr_return simple_root_expr241 = null;


        Object TOK_COLON240_tree=null;
        Object TOK_SEMI242_tree=null;
        RewriteRuleTokenStream stream_TOK_SEMI=new RewriteRuleTokenStream(adaptor,"token TOK_SEMI");
        RewriteRuleTokenStream stream_TOK_COLON=new RewriteRuleTokenStream(adaptor,"token TOK_COLON");
        RewriteRuleSubtreeStream stream_simple_root_expr=new RewriteRuleSubtreeStream(adaptor,"rule simple_root_expr");
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1283:22: ( simple_root_expr TOK_COLON simple_root_expr TOK_SEMI -> ^( CASE_ELEMENT_EXPR_T simple_root_expr simple_root_expr ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1283:24: simple_root_expr TOK_COLON simple_root_expr TOK_SEMI
            {
            pushFollow(FOLLOW_simple_root_expr_in_case_element_expr13271);
            simple_root_expr239=simple_root_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_simple_root_expr.add(simple_root_expr239.getTree());
            TOK_COLON240=(Token)input.LT(1);
            match(input,TOK_COLON,FOLLOW_TOK_COLON_in_case_element_expr13273); if (failed) return retval;
            if ( backtracking==0 ) stream_TOK_COLON.add(TOK_COLON240);

            pushFollow(FOLLOW_simple_root_expr_in_case_element_expr13275);
            simple_root_expr241=simple_root_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_simple_root_expr.add(simple_root_expr241.getTree());
            TOK_SEMI242=(Token)input.LT(1);
            match(input,TOK_SEMI,FOLLOW_TOK_SEMI_in_case_element_expr13277); if (failed) return retval;
            if ( backtracking==0 ) stream_TOK_SEMI.add(TOK_SEMI242);


            // AST REWRITE
            // elements: simple_root_expr, simple_root_expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1284:9: -> ^( CASE_ELEMENT_EXPR_T simple_root_expr simple_root_expr )
            {
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1284:12: ^( CASE_ELEMENT_EXPR_T simple_root_expr simple_root_expr )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(CASE_ELEMENT_EXPR_T, "CASE_ELEMENT_EXPR_T"), root_1);

                adaptor.addChild(root_1, stream_simple_root_expr.next());
                adaptor.addChild(root_1, stream_simple_root_expr.next());

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
    // $ANTLR end case_element_expr

    public static class case_element_list_expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start case_element_list_expr
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1286:1: case_element_list_expr : case_element_expr ( case_element_expr )* ;
    public final case_element_list_expr_return case_element_list_expr() throws RecognitionException {
        case_element_list_expr_return retval = new case_element_list_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        case_element_expr_return case_element_expr243 = null;

        case_element_expr_return case_element_expr244 = null;



        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1286:26: ( case_element_expr ( case_element_expr )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1286:28: case_element_expr ( case_element_expr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_case_element_expr_in_case_element_list_expr13313);
            case_element_expr243=case_element_expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, case_element_expr243.getTree());
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1286:46: ( case_element_expr )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==TOK_LCB||(LA82_0>=TOK_PLUS && LA82_0<=TOK_MINUS)||(LA82_0>=TOK_NOT && LA82_0<=TOK_LP)||(LA82_0>=TOK_BOOL && LA82_0<=TOK_CASE)||(LA82_0>=TOK_WAREAD && LA82_0<=TOK_WAWRITE)||LA82_0==TOK_ATOM||LA82_0==TOK_NUMBER||LA82_0==TOK_NUMBER_WORD||(LA82_0>=TOK_FALSEEXP && LA82_0<=TOK_TRUEEXP)) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1286:47: case_element_expr
            	    {
            	    pushFollow(FOLLOW_case_element_expr_in_case_element_list_expr13316);
            	    case_element_expr244=case_element_expr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, case_element_expr244.getTree());

            	    }
            	    break;

            	default :
            	    break loop82;
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
    // $ANTLR end case_element_list_expr

    public static class number_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start number
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1289:1: number : ( TOK_NUMBER | TOK_PLUS TOK_NUMBER );
    public final number_return number() throws RecognitionException {
        number_return retval = new number_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TOK_NUMBER245=null;
        Token TOK_PLUS246=null;
        Token TOK_NUMBER247=null;

        Object TOK_NUMBER245_tree=null;
        Object TOK_PLUS246_tree=null;
        Object TOK_NUMBER247_tree=null;

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1289:14: ( TOK_NUMBER | TOK_PLUS TOK_NUMBER )
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==TOK_NUMBER) ) {
                alt83=1;
            }
            else if ( (LA83_0==TOK_PLUS) ) {
                alt83=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("1289:1: number : ( TOK_NUMBER | TOK_PLUS TOK_NUMBER );", 83, 0, input);

                throw nvae;
            }
            switch (alt83) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1289:16: TOK_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    TOK_NUMBER245=(Token)input.LT(1);
                    match(input,TOK_NUMBER,FOLLOW_TOK_NUMBER_in_number13341); if (failed) return retval;
                    if ( backtracking==0 ) {
                    TOK_NUMBER245_tree = (Object)adaptor.create(TOK_NUMBER245);
                    adaptor.addChild(root_0, TOK_NUMBER245_tree);
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1290:11: TOK_PLUS TOK_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    TOK_PLUS246=(Token)input.LT(1);
                    match(input,TOK_PLUS,FOLLOW_TOK_PLUS_in_number13353); if (failed) return retval;
                    TOK_NUMBER247=(Token)input.LT(1);
                    match(input,TOK_NUMBER,FOLLOW_TOK_NUMBER_in_number13356); if (failed) return retval;
                    if ( backtracking==0 ) {
                    TOK_NUMBER247_tree = (Object)adaptor.create(TOK_NUMBER247);
                    adaptor.addChild(root_0, TOK_NUMBER247_tree);
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
    // $ANTLR end number

    public static class integer_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start integer
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1291:1: integer : ( TOK_NUMBER -> ^( TOK_PLUS TOK_NUMBER ) | TOK_PLUS TOK_NUMBER -> ^( TOK_PLUS TOK_NUMBER ) | TOK_MINUS TOK_NUMBER -> ^( TOK_MINUS TOK_NUMBER ) );
    public final integer_return integer() throws RecognitionException {
        integer_return retval = new integer_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TOK_NUMBER248=null;
        Token TOK_PLUS249=null;
        Token TOK_NUMBER250=null;
        Token TOK_MINUS251=null;
        Token TOK_NUMBER252=null;

        Object TOK_NUMBER248_tree=null;
        Object TOK_PLUS249_tree=null;
        Object TOK_NUMBER250_tree=null;
        Object TOK_MINUS251_tree=null;
        Object TOK_NUMBER252_tree=null;
        RewriteRuleTokenStream stream_TOK_MINUS=new RewriteRuleTokenStream(adaptor,"token TOK_MINUS");
        RewriteRuleTokenStream stream_TOK_PLUS=new RewriteRuleTokenStream(adaptor,"token TOK_PLUS");
        RewriteRuleTokenStream stream_TOK_NUMBER=new RewriteRuleTokenStream(adaptor,"token TOK_NUMBER");

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1291:15: ( TOK_NUMBER -> ^( TOK_PLUS TOK_NUMBER ) | TOK_PLUS TOK_NUMBER -> ^( TOK_PLUS TOK_NUMBER ) | TOK_MINUS TOK_NUMBER -> ^( TOK_MINUS TOK_NUMBER ) )
            int alt84=3;
            switch ( input.LA(1) ) {
            case TOK_NUMBER:
                {
                alt84=1;
                }
                break;
            case TOK_PLUS:
                {
                alt84=2;
                }
                break;
            case TOK_MINUS:
                {
                alt84=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("1291:1: integer : ( TOK_NUMBER -> ^( TOK_PLUS TOK_NUMBER ) | TOK_PLUS TOK_NUMBER -> ^( TOK_PLUS TOK_NUMBER ) | TOK_MINUS TOK_NUMBER -> ^( TOK_MINUS TOK_NUMBER ) );", 84, 0, input);

                throw nvae;
            }

            switch (alt84) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1291:17: TOK_NUMBER
                    {
                    TOK_NUMBER248=(Token)input.LT(1);
                    match(input,TOK_NUMBER,FOLLOW_TOK_NUMBER_in_integer13369); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_NUMBER.add(TOK_NUMBER248);


                    // AST REWRITE
                    // elements: TOK_NUMBER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1292:9: -> ^( TOK_PLUS TOK_NUMBER )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1292:12: ^( TOK_PLUS TOK_NUMBER )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(TOK_PLUS, "TOK_PLUS"), root_1);

                        adaptor.addChild(root_1, stream_TOK_NUMBER.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1293:11: TOK_PLUS TOK_NUMBER
                    {
                    TOK_PLUS249=(Token)input.LT(1);
                    match(input,TOK_PLUS,FOLLOW_TOK_PLUS_in_integer13397); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_PLUS.add(TOK_PLUS249);

                    TOK_NUMBER250=(Token)input.LT(1);
                    match(input,TOK_NUMBER,FOLLOW_TOK_NUMBER_in_integer13399); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_NUMBER.add(TOK_NUMBER250);


                    // AST REWRITE
                    // elements: TOK_NUMBER, TOK_PLUS
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1294:9: -> ^( TOK_PLUS TOK_NUMBER )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1294:12: ^( TOK_PLUS TOK_NUMBER )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_TOK_PLUS.next(), root_1);

                        adaptor.addChild(root_1, stream_TOK_NUMBER.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1295:11: TOK_MINUS TOK_NUMBER
                    {
                    TOK_MINUS251=(Token)input.LT(1);
                    match(input,TOK_MINUS,FOLLOW_TOK_MINUS_in_integer13427); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_MINUS.add(TOK_MINUS251);

                    TOK_NUMBER252=(Token)input.LT(1);
                    match(input,TOK_NUMBER,FOLLOW_TOK_NUMBER_in_integer13429); if (failed) return retval;
                    if ( backtracking==0 ) stream_TOK_NUMBER.add(TOK_NUMBER252);


                    // AST REWRITE
                    // elements: TOK_NUMBER, TOK_MINUS
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1296:9: -> ^( TOK_MINUS TOK_NUMBER )
                    {
                        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1296:12: ^( TOK_MINUS TOK_NUMBER )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_TOK_MINUS.next(), root_1);

                        adaptor.addChild(root_1, stream_TOK_NUMBER.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

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
    // $ANTLR end integer

    public static class number_word_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start number_word
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1298:1: number_word : TOK_NUMBER_WORD ;
    public final number_word_return number_word() throws RecognitionException {
        number_word_return retval = new number_word_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TOK_NUMBER_WORD253=null;

        Object TOK_NUMBER_WORD253_tree=null;

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1298:18: ( TOK_NUMBER_WORD )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1298:20: TOK_NUMBER_WORD
            {
            root_0 = (Object)adaptor.nil();

            TOK_NUMBER_WORD253=(Token)input.LT(1);
            match(input,TOK_NUMBER_WORD,FOLLOW_TOK_NUMBER_WORD_in_number_word13466); if (failed) return retval;
            if ( backtracking==0 ) {
            TOK_NUMBER_WORD253_tree = (Object)adaptor.create(TOK_NUMBER_WORD253);
            adaptor.addChild(root_0, TOK_NUMBER_WORD253_tree);
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
    // $ANTLR end number_word

    public static class subrange_return extends ParserRuleReturnScope {
        public InternalSpecCTLRange ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start subrange
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1301:1: subrange returns [InternalSpecCTLRange ret] : f= integer TOK_TWODOTS s= integer -> ^( SUBRANGE_T integer integer ) ;
    public final subrange_return subrange() throws RecognitionException {
        subrange_return retval = new subrange_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TOK_TWODOTS254=null;
        integer_return f = null;

        integer_return s = null;


        Object TOK_TWODOTS254_tree=null;
        RewriteRuleTokenStream stream_TOK_TWODOTS=new RewriteRuleTokenStream(adaptor,"token TOK_TWODOTS");
        RewriteRuleSubtreeStream stream_integer=new RewriteRuleSubtreeStream(adaptor,"rule integer");
        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1303:9: (f= integer TOK_TWODOTS s= integer -> ^( SUBRANGE_T integer integer ) )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1303:11: f= integer TOK_TWODOTS s= integer
            {
            pushFollow(FOLLOW_integer_in_subrange13505);
            f=integer();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_integer.add(f.getTree());
            TOK_TWODOTS254=(Token)input.LT(1);
            match(input,TOK_TWODOTS,FOLLOW_TOK_TWODOTS_in_subrange13507); if (failed) return retval;
            if ( backtracking==0 ) stream_TOK_TWODOTS.add(TOK_TWODOTS254);

            pushFollow(FOLLOW_integer_in_subrange13511);
            s=integer();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_integer.add(s.getTree());
            if ( backtracking==0 ) {
               if(!er()) retval.ret = new InternalSpecCTLRange(input.toString(f.start,f.stop), input.toString(s.start,s.stop), ((Token)retval.start)); 
            }

            // AST REWRITE
            // elements: integer, integer
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1305:9: -> ^( SUBRANGE_T integer integer )
            {
                // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1305:12: ^( SUBRANGE_T integer integer )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(SUBRANGE_T, "SUBRANGE_T"), root_1);

                adaptor.addChild(root_1, stream_integer.next());
                adaptor.addChild(root_1, stream_integer.next());

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
            if ( backtracking==0 ) {
               if(!er()) retval.ret.evalBDDChildrenExp(input); 
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
    // $ANTLR end subrange

    public static class constant_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start constant
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1307:1: constant : ( TOK_FALSEEXP | TOK_TRUEEXP | number | number_word );
    public final constant_return constant() throws RecognitionException {
        constant_return retval = new constant_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TOK_FALSEEXP255=null;
        Token TOK_TRUEEXP256=null;
        number_return number257 = null;

        number_word_return number_word258 = null;


        Object TOK_FALSEEXP255_tree=null;
        Object TOK_TRUEEXP256_tree=null;

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1307:15: ( TOK_FALSEEXP | TOK_TRUEEXP | number | number_word )
            int alt85=4;
            switch ( input.LA(1) ) {
            case TOK_FALSEEXP:
                {
                alt85=1;
                }
                break;
            case TOK_TRUEEXP:
                {
                alt85=2;
                }
                break;
            case TOK_PLUS:
            case TOK_NUMBER:
                {
                alt85=3;
                }
                break;
            case TOK_NUMBER_WORD:
                {
                alt85=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("1307:1: constant : ( TOK_FALSEEXP | TOK_TRUEEXP | number | number_word );", 85, 0, input);

                throw nvae;
            }

            switch (alt85) {
                case 1 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1307:17: TOK_FALSEEXP
                    {
                    root_0 = (Object)adaptor.nil();

                    TOK_FALSEEXP255=(Token)input.LT(1);
                    match(input,TOK_FALSEEXP,FOLLOW_TOK_FALSEEXP_in_constant13560); if (failed) return retval;
                    if ( backtracking==0 ) {
                    TOK_FALSEEXP255_tree = (Object)adaptor.create(TOK_FALSEEXP255);
                    adaptor.addChild(root_0, TOK_FALSEEXP255_tree);
                    }

                    }
                    break;
                case 2 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1308:11: TOK_TRUEEXP
                    {
                    root_0 = (Object)adaptor.nil();

                    TOK_TRUEEXP256=(Token)input.LT(1);
                    match(input,TOK_TRUEEXP,FOLLOW_TOK_TRUEEXP_in_constant13572); if (failed) return retval;
                    if ( backtracking==0 ) {
                    TOK_TRUEEXP256_tree = (Object)adaptor.create(TOK_TRUEEXP256);
                    adaptor.addChild(root_0, TOK_TRUEEXP256_tree);
                    }

                    }
                    break;
                case 3 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1309:11: number
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_number_in_constant13584);
                    number257=number();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, number257.getTree());

                    }
                    break;
                case 4 :
                    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1310:11: number_word
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_number_word_in_constant13596);
                    number_word258=number_word();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, number_word258.getTree());

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
    // $ANTLR end constant

    public static class optsemi_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start optsemi
    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1314:1: optsemi : ( TOK_SEMI )* ;
    public final optsemi_return optsemi() throws RecognitionException {
        optsemi_return retval = new optsemi_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TOK_SEMI259=null;

        Object TOK_SEMI259_tree=null;

        try {
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1314:15: ( ( TOK_SEMI )* )
            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1314:17: ( TOK_SEMI )*
            {
            root_0 = (Object)adaptor.nil();

            // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1314:17: ( TOK_SEMI )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( (LA86_0==TOK_SEMI) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1314:17: TOK_SEMI
            	    {
            	    TOK_SEMI259=(Token)input.LT(1);
            	    match(input,TOK_SEMI,FOLLOW_TOK_SEMI_in_optsemi13621); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    TOK_SEMI259_tree = (Object)adaptor.create(TOK_SEMI259);
            	    adaptor.addChild(root_0, TOK_SEMI259_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop86;
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
    // $ANTLR end optsemi

    // $ANTLR start synpred1
    public final void synpred1_fragment() throws RecognitionException {   
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:402:11: ( ( TOK_NOT )* ( TOK_EX | TOK_AX | TOK_EF | TOK_AF | TOK_EG | TOK_AG | TOK_AA | TOK_EE | TOK_EBF | TOK_ABF | TOK_EBG | TOK_ABG ) )
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:402:12: ( TOK_NOT )* ( TOK_EX | TOK_AX | TOK_EF | TOK_AF | TOK_EG | TOK_AG | TOK_AA | TOK_EE | TOK_EBF | TOK_ABF | TOK_EBG | TOK_ABG )
        {
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:402:12: ( TOK_NOT )*
        loop87:
        do {
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==TOK_NOT) ) {
                alt87=1;
            }


            switch (alt87) {
        	case 1 :
        	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:402:12: TOK_NOT
        	    {
        	    match(input,TOK_NOT,FOLLOW_TOK_NOT_in_synpred13104); if (failed) return ;

        	    }
        	    break;

        	default :
        	    break loop87;
            }
        } while (true);

        if ( (input.LA(1)>=TOK_EX && input.LA(1)<=TOK_AA)||input.LA(1)==TOK_EE ) {
            input.consume();
            errorRecovery=false;failed=false;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            MismatchedSetException mse =
                new MismatchedSetException(null,input);
            recoverFromMismatchedSet(input,mse,FOLLOW_set_in_synpred13117);    throw mse;
        }


        }
    }
    // $ANTLR end synpred1

    // $ANTLR start synpred2
    public final void synpred2_fragment() throws RecognitionException {   
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:443:11: ( TOK_AA TOK_LB ctl_root_expr TOK_UNTIL )
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:443:12: TOK_AA TOK_LB ctl_root_expr TOK_UNTIL
        {
        match(input,TOK_AA,FOLLOW_TOK_AA_in_synpred23614); if (failed) return ;
        match(input,TOK_LB,FOLLOW_TOK_LB_in_synpred23616); if (failed) return ;
        pushFollow(FOLLOW_ctl_root_expr_in_synpred23618);
        ctl_root_expr();
        _fsp--;
        if (failed) return ;
        match(input,TOK_UNTIL,FOLLOW_TOK_UNTIL_in_synpred23620); if (failed) return ;

        }
    }
    // $ANTLR end synpred2

    // $ANTLR start synpred3
    public final void synpred3_fragment() throws RecognitionException {   
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:444:11: ( TOK_AA TOK_LB ctl_root_expr TOK_BUNTIL )
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:444:12: TOK_AA TOK_LB ctl_root_expr TOK_BUNTIL
        {
        match(input,TOK_AA,FOLLOW_TOK_AA_in_synpred33640); if (failed) return ;
        match(input,TOK_LB,FOLLOW_TOK_LB_in_synpred33642); if (failed) return ;
        pushFollow(FOLLOW_ctl_root_expr_in_synpred33644);
        ctl_root_expr();
        _fsp--;
        if (failed) return ;
        match(input,TOK_BUNTIL,FOLLOW_TOK_BUNTIL_in_synpred33646); if (failed) return ;

        }
    }
    // $ANTLR end synpred3

    // $ANTLR start synpred4
    public final void synpred4_fragment() throws RecognitionException {   
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:445:11: ( TOK_EE TOK_LB ctl_root_expr TOK_UNTIL )
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:445:12: TOK_EE TOK_LB ctl_root_expr TOK_UNTIL
        {
        match(input,TOK_EE,FOLLOW_TOK_EE_in_synpred43666); if (failed) return ;
        match(input,TOK_LB,FOLLOW_TOK_LB_in_synpred43668); if (failed) return ;
        pushFollow(FOLLOW_ctl_root_expr_in_synpred43670);
        ctl_root_expr();
        _fsp--;
        if (failed) return ;
        match(input,TOK_UNTIL,FOLLOW_TOK_UNTIL_in_synpred43672); if (failed) return ;

        }
    }
    // $ANTLR end synpred4

    // $ANTLR start synpred5
    public final void synpred5_fragment() throws RecognitionException {   
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:446:11: ( TOK_EE TOK_LB ctl_root_expr TOK_BUNTIL )
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:446:12: TOK_EE TOK_LB ctl_root_expr TOK_BUNTIL
        {
        match(input,TOK_EE,FOLLOW_TOK_EE_in_synpred53692); if (failed) return ;
        match(input,TOK_LB,FOLLOW_TOK_LB_in_synpred53694); if (failed) return ;
        pushFollow(FOLLOW_ctl_root_expr_in_synpred53696);
        ctl_root_expr();
        _fsp--;
        if (failed) return ;
        match(input,TOK_BUNTIL,FOLLOW_TOK_BUNTIL_in_synpred53698); if (failed) return ;

        }
    }
    // $ANTLR end synpred5

    // $ANTLR start synpred6
    public final void synpred6_fragment() throws RecognitionException {   
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:705:11: ( ( TOK_NOT )* ( TOK_OP_NEXT | TOK_OP_PREV | TOK_OP_NOTPREVNOT | TOK_OP_GLOBALLY | TOK_OP_HISTORICALLY | TOK_OP_FINALLY | TOK_OP_ONCE ) )
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:705:12: ( TOK_NOT )* ( TOK_OP_NEXT | TOK_OP_PREV | TOK_OP_NOTPREVNOT | TOK_OP_GLOBALLY | TOK_OP_HISTORICALLY | TOK_OP_FINALLY | TOK_OP_ONCE )
        {
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:705:12: ( TOK_NOT )*
        loop88:
        do {
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==TOK_NOT) ) {
                alt88=1;
            }


            switch (alt88) {
        	case 1 :
        	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:705:12: TOK_NOT
        	    {
        	    match(input,TOK_NOT,FOLLOW_TOK_NOT_in_synpred66679); if (failed) return ;

        	    }
        	    break;

        	default :
        	    break loop88;
            }
        } while (true);

        if ( (input.LA(1)>=TOK_OP_NEXT && input.LA(1)<=TOK_OP_ONCE) ) {
            input.consume();
            errorRecovery=false;failed=false;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            MismatchedSetException mse =
                new MismatchedSetException(null,input);
            recoverFromMismatchedSet(input,mse,FOLLOW_set_in_synpred66692);    throw mse;
        }


        }
    }
    // $ANTLR end synpred6

    // $ANTLR start synpred7
    public final void synpred7_fragment() throws RecognitionException {   
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:962:11: ( ( TOK_NOT )* ( TOK_OP_NEXT | TOK_OP_PREV | TOK_OP_NOTPREVNOT | TOK_OP_GLOBALLY | TOK_OP_HISTORICALLY | TOK_OP_FINALLY | TOK_OP_ONCE ) )
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:962:12: ( TOK_NOT )* ( TOK_OP_NEXT | TOK_OP_PREV | TOK_OP_NOTPREVNOT | TOK_OP_GLOBALLY | TOK_OP_HISTORICALLY | TOK_OP_FINALLY | TOK_OP_ONCE )
        {
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:962:12: ( TOK_NOT )*
        loop89:
        do {
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==TOK_NOT) ) {
                alt89=1;
            }


            switch (alt89) {
        	case 1 :
        	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:962:12: TOK_NOT
        	    {
        	    match(input,TOK_NOT,FOLLOW_TOK_NOT_in_synpred79569); if (failed) return ;

        	    }
        	    break;

        	default :
        	    break loop89;
            }
        } while (true);

        if ( (input.LA(1)>=TOK_OP_NEXT && input.LA(1)<=TOK_OP_ONCE) ) {
            input.consume();
            errorRecovery=false;failed=false;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            MismatchedSetException mse =
                new MismatchedSetException(null,input);
            recoverFromMismatchedSet(input,mse,FOLLOW_set_in_synpred79582);    throw mse;
        }


        }
    }
    // $ANTLR end synpred7

    // $ANTLR start synpred8
    public final void synpred8_fragment() throws RecognitionException {   
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:999:11: ( ( TOK_NOT )* ( TOK_EX | TOK_AX | TOK_EF | TOK_AF | TOK_EG | TOK_AG | TOK_AA | TOK_EE | TOK_EBF | TOK_ABF | TOK_EBG | TOK_ABG ) )
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:999:12: ( TOK_NOT )* ( TOK_EX | TOK_AX | TOK_EF | TOK_AF | TOK_EG | TOK_AG | TOK_AA | TOK_EE | TOK_EBF | TOK_ABF | TOK_EBG | TOK_ABG )
        {
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:999:12: ( TOK_NOT )*
        loop90:
        do {
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==TOK_NOT) ) {
                alt90=1;
            }


            switch (alt90) {
        	case 1 :
        	    // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:999:12: TOK_NOT
        	    {
        	    match(input,TOK_NOT,FOLLOW_TOK_NOT_in_synpred810022); if (failed) return ;

        	    }
        	    break;

        	default :
        	    break loop90;
            }
        } while (true);

        if ( (input.LA(1)>=TOK_EX && input.LA(1)<=TOK_AA)||input.LA(1)==TOK_EE ) {
            input.consume();
            errorRecovery=false;failed=false;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            MismatchedSetException mse =
                new MismatchedSetException(null,input);
            recoverFromMismatchedSet(input,mse,FOLLOW_set_in_synpred810035);    throw mse;
        }


        }
    }
    // $ANTLR end synpred8

    // $ANTLR start synpred9
    public final void synpred9_fragment() throws RecognitionException {   
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1033:11: ( TOK_AA )
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1033:12: TOK_AA
        {
        match(input,TOK_AA,FOLLOW_TOK_AA_in_synpred910460); if (failed) return ;

        }
    }
    // $ANTLR end synpred9

    // $ANTLR start synpred10
    public final void synpred10_fragment() throws RecognitionException {   
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1034:11: ( TOK_EE )
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1034:12: TOK_EE
        {
        match(input,TOK_EE,FOLLOW_TOK_EE_in_synpred1010480); if (failed) return ;

        }
    }
    // $ANTLR end synpred10

    // $ANTLR start synpred11
    public final void synpred11_fragment() throws RecognitionException {   
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1050:11: ( TOK_AA TOK_LB ctls_root_expr TOK_BUNTIL )
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1050:12: TOK_AA TOK_LB ctls_root_expr TOK_BUNTIL
        {
        match(input,TOK_AA,FOLLOW_TOK_AA_in_synpred1110697); if (failed) return ;
        match(input,TOK_LB,FOLLOW_TOK_LB_in_synpred1110699); if (failed) return ;
        pushFollow(FOLLOW_ctls_root_expr_in_synpred1110701);
        ctls_root_expr();
        _fsp--;
        if (failed) return ;
        match(input,TOK_BUNTIL,FOLLOW_TOK_BUNTIL_in_synpred1110703); if (failed) return ;

        }
    }
    // $ANTLR end synpred11

    // $ANTLR start synpred12
    public final void synpred12_fragment() throws RecognitionException {   
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1052:11: ( TOK_AA TOK_LB )
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1052:12: TOK_AA TOK_LB
        {
        match(input,TOK_AA,FOLLOW_TOK_AA_in_synpred1210732); if (failed) return ;
        match(input,TOK_LB,FOLLOW_TOK_LB_in_synpred1210734); if (failed) return ;

        }
    }
    // $ANTLR end synpred12

    // $ANTLR start synpred13
    public final void synpred13_fragment() throws RecognitionException {   
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1058:11: ( TOK_EE TOK_LB ctls_root_expr TOK_BUNTIL )
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1058:12: TOK_EE TOK_LB ctls_root_expr TOK_BUNTIL
        {
        match(input,TOK_EE,FOLLOW_TOK_EE_in_synpred1310797); if (failed) return ;
        match(input,TOK_LB,FOLLOW_TOK_LB_in_synpred1310799); if (failed) return ;
        pushFollow(FOLLOW_ctls_root_expr_in_synpred1310801);
        ctls_root_expr();
        _fsp--;
        if (failed) return ;
        match(input,TOK_BUNTIL,FOLLOW_TOK_BUNTIL_in_synpred1310803); if (failed) return ;

        }
    }
    // $ANTLR end synpred13

    // $ANTLR start synpred14
    public final void synpred14_fragment() throws RecognitionException {   
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1060:11: ( TOK_EE TOK_LB )
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1060:12: TOK_EE TOK_LB
        {
        match(input,TOK_EE,FOLLOW_TOK_EE_in_synpred1410832); if (failed) return ;
        match(input,TOK_LB,FOLLOW_TOK_LB_in_synpred1410834); if (failed) return ;

        }
    }
    // $ANTLR end synpred14

    // $ANTLR start synpred15
    public final void synpred15_fragment() throws RecognitionException {   
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1271:31: ( TOK_LB simple_root_expr TOK_RB )
        // /home/yaniv/jtlv_proj/jtlv_devspace/JTLV_PARSERS/SPC.g:1271:32: TOK_LB simple_root_expr TOK_RB
        {
        match(input,TOK_LB,FOLLOW_TOK_LB_in_synpred1513122); if (failed) return ;
        pushFollow(FOLLOW_simple_root_expr_in_synpred1513124);
        simple_root_expr();
        _fsp--;
        if (failed) return ;
        match(input,TOK_RB,FOLLOW_TOK_RB_in_synpred1513126); if (failed) return ;

        }
    }
    // $ANTLR end synpred15

    public final boolean synpred5() {
        backtracking++;
        int start = input.mark();
        try {
            synpred5_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred6() {
        backtracking++;
        int start = input.mark();
        try {
            synpred6_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
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
    public final boolean synpred8() {
        backtracking++;
        int start = input.mark();
        try {
            synpred8_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred1() {
        backtracking++;
        int start = input.mark();
        try {
            synpred1_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred2() {
        backtracking++;
        int start = input.mark();
        try {
            synpred2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred3() {
        backtracking++;
        int start = input.mark();
        try {
            synpred3_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred4() {
        backtracking++;
        int start = input.mark();
        try {
            synpred4_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred9() {
        backtracking++;
        int start = input.mark();
        try {
            synpred9_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred14() {
        backtracking++;
        int start = input.mark();
        try {
            synpred14_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred15() {
        backtracking++;
        int start = input.mark();
        try {
            synpred15_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred10() {
        backtracking++;
        int start = input.mark();
        try {
            synpred10_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred11() {
        backtracking++;
        int start = input.mark();
        try {
            synpred11_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred12() {
        backtracking++;
        int start = input.mark();
        try {
            synpred12_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred13() {
        backtracking++;
        int start = input.mark();
        try {
            synpred13_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_EOF_in_spec134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_spec_list_in_spec146 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_spec148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_spec_element_in_spec_list212 = new BitSet(new long[]{0x00000000001E0002L});
    public static final BitSet FOLLOW_spec_element_in_spec_list228 = new BitSet(new long[]{0x00000000001E0002L});
    public static final BitSet FOLLOW_invar_spec_in_spec_element271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ctl_spec_in_spec_element285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ltl_spec_in_spec_element299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ctls_spec_in_spec_element313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_INVAR_SPEC_in_invar_spec361 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_invar_spec364 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_optsemi_in_invar_spec366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_CTL_SPEC_in_ctl_spec405 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctl_root_expr_in_ctl_spec408 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_optsemi_in_ctl_spec410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_LTL_SPEC_in_ltl_spec449 = new BitSet(new long[]{0x00DEC60800000000L,0x000000000697F800L});
    public static final BitSet FOLLOW_ltl_root_expr_in_ltl_spec452 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_optsemi_in_ltl_spec454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_CTL_STAR_SPEC_in_ctls_spec493 = new BitSet(new long[]{0xFFDEC60800000000L,0x000000000697F847L});
    public static final BitSet FOLLOW_ctls_root_expr_in_ctls_spec496 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_optsemi_in_ctls_spec498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_implies_expr_in_simple_root_expr540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_iff_expr_in_implies_expr584 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_TOK_IMPLIES_in_implies_expr600 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_implies_expr_in_implies_expr605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_or_expr_in_iff_expr671 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_TOK_IFF_in_iff_expr687 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_or_expr_in_iff_expr692 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_and_expr_in_or_expr757 = new BitSet(new long[]{0x0000000003800002L});
    public static final BitSet FOLLOW_TOK_OR_in_or_expr773 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_and_expr_in_or_expr778 = new BitSet(new long[]{0x0000000003800002L});
    public static final BitSet FOLLOW_TOK_XOR_in_or_expr802 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_and_expr_in_or_expr807 = new BitSet(new long[]{0x0000000003800002L});
    public static final BitSet FOLLOW_TOK_XNOR_in_or_expr831 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_and_expr_in_or_expr836 = new BitSet(new long[]{0x0000000003800002L});
    public static final BitSet FOLLOW_relational_expr_in_and_expr900 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_TOK_AND_in_and_expr916 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_relational_expr_in_and_expr921 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_in_expr_in_relational_expr984 = new BitSet(new long[]{0x00000001F8000002L});
    public static final BitSet FOLLOW_TOK_EQUAL_in_relational_expr1000 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_in_expr_in_relational_expr1005 = new BitSet(new long[]{0x00000001F8000002L});
    public static final BitSet FOLLOW_TOK_NOTEQUAL_in_relational_expr1030 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_in_expr_in_relational_expr1035 = new BitSet(new long[]{0x00000001F8000002L});
    public static final BitSet FOLLOW_TOK_LT_in_relational_expr1060 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_in_expr_in_relational_expr1065 = new BitSet(new long[]{0x00000001F8000002L});
    public static final BitSet FOLLOW_TOK_GT_in_relational_expr1090 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_in_expr_in_relational_expr1095 = new BitSet(new long[]{0x00000001F8000002L});
    public static final BitSet FOLLOW_TOK_LE_in_relational_expr1120 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_in_expr_in_relational_expr1125 = new BitSet(new long[]{0x00000001F8000002L});
    public static final BitSet FOLLOW_TOK_GE_in_relational_expr1150 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_in_expr_in_relational_expr1155 = new BitSet(new long[]{0x00000001F8000002L});
    public static final BitSet FOLLOW_union_expr_in_in_expr1220 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_TOK_SETIN_in_in_expr1236 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_union_expr_in_in_expr1241 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_set_expr_in_union_expr1305 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_TOK_UNION_in_union_expr1321 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_set_expr_in_union_expr1326 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_shift_expr_in_set_expr1388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subrange_in_set_expr1410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_LCB_in_set_expr1433 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_set_list_expr_in_set_expr1435 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_TOK_RCB_in_set_expr1437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_root_expr_in_set_list_expr1491 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_TOK_COMMA_in_set_list_expr1494 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_set_list_expr1497 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_remainder_expr_in_shift_expr1542 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_TOK_LSHIFT_in_shift_expr1558 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_remainder_expr_in_shift_expr1563 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_TOK_RSHIFT_in_shift_expr1587 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_remainder_expr_in_shift_expr1592 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_additive_expr_in_remainder_expr1655 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_TOK_MOD_in_remainder_expr1671 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_additive_expr_in_remainder_expr1676 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_multiplicative_expr_in_additive_expr1739 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_TOK_PLUS_in_additive_expr1755 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_multiplicative_expr_in_additive_expr1760 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_TOK_MINUS_in_additive_expr1784 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_multiplicative_expr_in_additive_expr1789 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_concatination_expr_in_multiplicative_expr1851 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_TOK_TIMES_in_multiplicative_expr1867 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_concatination_expr_in_multiplicative_expr1872 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_TOK_DIVIDE_in_multiplicative_expr1896 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_concatination_expr_in_multiplicative_expr1901 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_primary_expr_in_concatination_expr1963 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_TOK_CONCATENATION_in_concatination_expr1979 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_primary_expr_in_concatination_expr1984 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_primary_expr_helper1_in_primary_expr2054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_MINUS_in_primary_expr2096 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_primary_expr_in_primary_expr2100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_NOT_in_primary_expr2140 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_primary_expr_in_primary_expr2144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_primary_expr_helper12209 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_primary_expr_helper12211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_expr_helper1_pointer1_in_primary_expr_helper12253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_LP_in_primary_expr_helper12286 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_primary_expr_helper12288 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_TOK_RP_in_primary_expr_helper12290 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_primary_expr_helper12292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_BOOL_in_primary_expr_helper12334 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_TOK_LP_in_primary_expr_helper12337 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_primary_expr_helper12339 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_TOK_RP_in_primary_expr_helper12341 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_primary_expr_helper12343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_WORD1_in_primary_expr_helper12386 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_TOK_LP_in_primary_expr_helper12388 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_primary_expr_helper12390 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_TOK_RP_in_primary_expr_helper12392 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_primary_expr_helper12394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_NEXT_in_primary_expr_helper12436 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_TOK_LP_in_primary_expr_helper12438 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_primary_expr_helper12440 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_TOK_RP_in_primary_expr_helper12442 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_primary_expr_helper12444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_CASE_in_primary_expr_helper12486 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_case_element_list_expr_in_primary_expr_helper12488 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_TOK_ESAC_in_primary_expr_helper12490 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_primary_expr_helper12492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_WAREAD_in_primary_expr_helper12534 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_TOK_LP_in_primary_expr_helper12536 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_primary_expr_helper12538 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_TOK_COMMA_in_primary_expr_helper12540 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_primary_expr_helper12542 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_TOK_RP_in_primary_expr_helper12544 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_primary_expr_helper12546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_WAWRITE_in_primary_expr_helper12590 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_TOK_LP_in_primary_expr_helper12592 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_primary_expr_helper12594 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_TOK_COMMA_in_primary_expr_helper12596 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_primary_expr_helper12598 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_TOK_COMMA_in_primary_expr_helper12600 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_primary_expr_helper12602 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_TOK_RP_in_primary_expr_helper12604 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_primary_expr_helper12606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ctl_implies_expr_in_ctl_root_expr2674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ctl_iff_expr_in_ctl_implies_expr2717 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_TOK_IMPLIES_in_ctl_implies_expr2733 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctl_implies_expr_in_ctl_implies_expr2738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ctl_or_expr_in_ctl_iff_expr2803 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_TOK_IFF_in_ctl_iff_expr2819 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctl_or_expr_in_ctl_iff_expr2824 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ctl_and_expr_in_ctl_or_expr2888 = new BitSet(new long[]{0x0000000003800002L});
    public static final BitSet FOLLOW_TOK_OR_in_ctl_or_expr2904 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctl_and_expr_in_ctl_or_expr2909 = new BitSet(new long[]{0x0000000003800002L});
    public static final BitSet FOLLOW_TOK_XOR_in_ctl_or_expr2933 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctl_and_expr_in_ctl_or_expr2938 = new BitSet(new long[]{0x0000000003800002L});
    public static final BitSet FOLLOW_TOK_XNOR_in_ctl_or_expr2962 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctl_and_expr_in_ctl_or_expr2967 = new BitSet(new long[]{0x0000000003800002L});
    public static final BitSet FOLLOW_ctl_expr_in_ctl_and_expr3030 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_TOK_AND_in_ctl_and_expr3046 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctl_expr_in_ctl_and_expr3051 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_pure_ctl_expr_in_ctl_expr3279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ctl_relational_expr_in_ctl_expr3317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_EX_in_pure_ctl_expr3369 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctl_expr_in_pure_ctl_expr3374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_AX_in_pure_ctl_expr3398 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctl_expr_in_pure_ctl_expr3403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_EF_in_pure_ctl_expr3427 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctl_expr_in_pure_ctl_expr3432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_AF_in_pure_ctl_expr3456 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctl_expr_in_pure_ctl_expr3461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_EG_in_pure_ctl_expr3485 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctl_expr_in_pure_ctl_expr3490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_AG_in_pure_ctl_expr3514 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctl_expr_in_pure_ctl_expr3519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ctl_au_in_pure_ctl_expr3625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ctl_abu_in_pure_ctl_expr3651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ctl_eu_in_pure_ctl_expr3677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ctl_ebu_in_pure_ctl_expr3703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_EBF_in_pure_ctl_expr3719 = new BitSet(new long[]{0x0000060000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_subrange_in_pure_ctl_expr3724 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctl_expr_in_pure_ctl_expr3728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_ABF_in_pure_ctl_expr3752 = new BitSet(new long[]{0x0000060000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_subrange_in_pure_ctl_expr3757 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctl_expr_in_pure_ctl_expr3761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_EBG_in_pure_ctl_expr3785 = new BitSet(new long[]{0x0000060000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_subrange_in_pure_ctl_expr3790 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctl_expr_in_pure_ctl_expr3794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_ABG_in_pure_ctl_expr3818 = new BitSet(new long[]{0x0000060000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_subrange_in_pure_ctl_expr3823 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctl_expr_in_pure_ctl_expr3827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_NOT_in_pure_ctl_expr3861 = new BitSet(new long[]{0xFF00400000000000L,0x0000000000000047L});
    public static final BitSet FOLLOW_pure_ctl_expr_in_pure_ctl_expr3866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_AA_in_ctl_au3920 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_TOK_LB_in_ctl_au3925 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctl_root_expr_in_ctl_au3930 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_TOK_UNTIL_in_ctl_au3934 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctl_root_expr_in_ctl_au3938 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_TOK_RB_in_ctl_au3942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_EE_in_ctl_eu3997 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_TOK_LB_in_ctl_eu4002 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctl_root_expr_in_ctl_eu4007 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_TOK_UNTIL_in_ctl_eu4011 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctl_root_expr_in_ctl_eu4015 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_TOK_RB_in_ctl_eu4019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_AA_in_ctl_abu4074 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_TOK_LB_in_ctl_abu4079 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctl_root_expr_in_ctl_abu4084 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_TOK_BUNTIL_in_ctl_abu4088 = new BitSet(new long[]{0x0000060000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_subrange_in_ctl_abu4092 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctl_root_expr_in_ctl_abu4096 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_TOK_RB_in_ctl_abu4100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_EE_in_ctl_ebu4155 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_TOK_LB_in_ctl_ebu4160 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctl_root_expr_in_ctl_ebu4165 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_TOK_BUNTIL_in_ctl_ebu4169 = new BitSet(new long[]{0x0000060000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_subrange_in_ctl_ebu4173 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctl_root_expr_in_ctl_ebu4177 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_TOK_RB_in_ctl_ebu4181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ctl_in_expr_in_ctl_relational_expr4242 = new BitSet(new long[]{0x00000001F8000002L});
    public static final BitSet FOLLOW_TOK_EQUAL_in_ctl_relational_expr4258 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctl_in_expr_in_ctl_relational_expr4263 = new BitSet(new long[]{0x00000001F8000002L});
    public static final BitSet FOLLOW_TOK_NOTEQUAL_in_ctl_relational_expr4288 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctl_in_expr_in_ctl_relational_expr4293 = new BitSet(new long[]{0x00000001F8000002L});
    public static final BitSet FOLLOW_TOK_LT_in_ctl_relational_expr4318 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctl_in_expr_in_ctl_relational_expr4323 = new BitSet(new long[]{0x00000001F8000002L});
    public static final BitSet FOLLOW_TOK_GT_in_ctl_relational_expr4348 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctl_in_expr_in_ctl_relational_expr4353 = new BitSet(new long[]{0x00000001F8000002L});
    public static final BitSet FOLLOW_TOK_LE_in_ctl_relational_expr4378 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctl_in_expr_in_ctl_relational_expr4383 = new BitSet(new long[]{0x00000001F8000002L});
    public static final BitSet FOLLOW_TOK_GE_in_ctl_relational_expr4408 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctl_in_expr_in_ctl_relational_expr4413 = new BitSet(new long[]{0x00000001F8000002L});
    public static final BitSet FOLLOW_ctl_union_expr_in_ctl_in_expr4477 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_TOK_SETIN_in_ctl_in_expr4493 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctl_union_expr_in_ctl_in_expr4498 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ctl_set_expr_in_ctl_union_expr4561 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_TOK_UNION_in_ctl_union_expr4577 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctl_set_expr_in_ctl_union_expr4582 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_ctl_shift_expr_in_ctl_set_expr4643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subrange_in_ctl_set_expr4665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_LCB_in_ctl_set_expr4688 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctl_set_list_expr_in_ctl_set_expr4690 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_TOK_RCB_in_ctl_set_expr4692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_root_expr_in_ctl_set_list_expr4745 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_TOK_COMMA_in_ctl_set_list_expr4748 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_ctl_set_list_expr4751 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_ctl_remainder_expr_in_ctl_shift_expr4797 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_TOK_LSHIFT_in_ctl_shift_expr4813 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctl_remainder_expr_in_ctl_shift_expr4818 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_TOK_RSHIFT_in_ctl_shift_expr4842 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctl_remainder_expr_in_ctl_shift_expr4847 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_ctl_additive_expr_in_ctl_remainder_expr4909 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_TOK_MOD_in_ctl_remainder_expr4925 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctl_additive_expr_in_ctl_remainder_expr4930 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_ctl_multiplicative_expr_in_ctl_additive_expr4994 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_TOK_PLUS_in_ctl_additive_expr5010 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctl_multiplicative_expr_in_ctl_additive_expr5015 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_TOK_MINUS_in_ctl_additive_expr5039 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctl_multiplicative_expr_in_ctl_additive_expr5044 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_ctl_concatination_expr_in_ctl_multiplicative_expr5105 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_TOK_TIMES_in_ctl_multiplicative_expr5121 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctl_concatination_expr_in_ctl_multiplicative_expr5126 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_TOK_DIVIDE_in_ctl_multiplicative_expr5150 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctl_concatination_expr_in_ctl_multiplicative_expr5155 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_ctl_primary_expr_in_ctl_concatination_expr5216 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_TOK_CONCATENATION_in_ctl_concatination_expr5232 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctl_primary_expr_in_ctl_concatination_expr5237 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_ctl_primary_expr_helper1_in_ctl_primary_expr5306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_MINUS_in_ctl_primary_expr5330 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctl_primary_expr_in_ctl_primary_expr5334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_NOT_in_ctl_primary_expr5375 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctl_primary_expr_in_ctl_primary_expr5379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_ctl_primary_expr_helper15444 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_ctl_primary_expr_helper15446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_expr_helper1_pointer1_in_ctl_primary_expr_helper15497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_LP_in_ctl_primary_expr_helper15550 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctl_root_expr_in_ctl_primary_expr_helper15552 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_TOK_RP_in_ctl_primary_expr_helper15554 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_ctl_primary_expr_helper15556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_BOOL_in_ctl_primary_expr_helper15627 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_TOK_LP_in_ctl_primary_expr_helper15629 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_ctl_primary_expr_helper15631 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_TOK_RP_in_ctl_primary_expr_helper15633 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_ctl_primary_expr_helper15635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_WORD1_in_ctl_primary_expr_helper15686 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_TOK_LP_in_ctl_primary_expr_helper15688 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_ctl_primary_expr_helper15690 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_TOK_RP_in_ctl_primary_expr_helper15692 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_ctl_primary_expr_helper15694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_NEXT_in_ctl_primary_expr_helper15754 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_TOK_LP_in_ctl_primary_expr_helper15756 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_ctl_primary_expr_helper15758 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_TOK_RP_in_ctl_primary_expr_helper15760 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_ctl_primary_expr_helper15762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_CASE_in_ctl_primary_expr_helper15822 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_case_element_list_expr_in_ctl_primary_expr_helper15824 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_TOK_ESAC_in_ctl_primary_expr_helper15826 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_ctl_primary_expr_helper15828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_WAREAD_in_ctl_primary_expr_helper15888 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_TOK_LP_in_ctl_primary_expr_helper15890 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_ctl_primary_expr_helper15894 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_TOK_COMMA_in_ctl_primary_expr_helper15896 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_ctl_primary_expr_helper15900 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_TOK_RP_in_ctl_primary_expr_helper15902 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_ctl_primary_expr_helper15904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_WAWRITE_in_ctl_primary_expr_helper15968 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_TOK_LP_in_ctl_primary_expr_helper15970 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_ctl_primary_expr_helper15974 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_TOK_COMMA_in_ctl_primary_expr_helper15978 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_ctl_primary_expr_helper15982 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_TOK_COMMA_in_ctl_primary_expr_helper15986 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_ctl_primary_expr_helper15990 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_TOK_RP_in_ctl_primary_expr_helper15992 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_ctl_primary_expr_helper15994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ltl_implies_expr_in_ltl_root_expr6074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ltl_iff_expr_in_ltl_implies_expr6117 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_TOK_IMPLIES_in_ltl_implies_expr6133 = new BitSet(new long[]{0x00DEC60800000000L,0x000000000697F800L});
    public static final BitSet FOLLOW_ltl_implies_expr_in_ltl_implies_expr6138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ltl_or_expr_in_ltl_iff_expr6203 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_TOK_IFF_in_ltl_iff_expr6219 = new BitSet(new long[]{0x00DEC60800000000L,0x000000000697F800L});
    public static final BitSet FOLLOW_ltl_or_expr_in_ltl_iff_expr6224 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ltl_and_expr_in_ltl_or_expr6288 = new BitSet(new long[]{0x0000000003800002L});
    public static final BitSet FOLLOW_TOK_OR_in_ltl_or_expr6304 = new BitSet(new long[]{0x00DEC60800000000L,0x000000000697F800L});
    public static final BitSet FOLLOW_ltl_and_expr_in_ltl_or_expr6309 = new BitSet(new long[]{0x0000000003800002L});
    public static final BitSet FOLLOW_TOK_XOR_in_ltl_or_expr6333 = new BitSet(new long[]{0x00DEC60800000000L,0x000000000697F800L});
    public static final BitSet FOLLOW_ltl_and_expr_in_ltl_or_expr6338 = new BitSet(new long[]{0x0000000003800002L});
    public static final BitSet FOLLOW_TOK_XNOR_in_ltl_or_expr6362 = new BitSet(new long[]{0x00DEC60800000000L,0x000000000697F800L});
    public static final BitSet FOLLOW_ltl_and_expr_in_ltl_or_expr6367 = new BitSet(new long[]{0x0000000003800002L});
    public static final BitSet FOLLOW_ltl_binary_expr_in_ltl_and_expr6430 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_TOK_AND_in_ltl_and_expr6446 = new BitSet(new long[]{0x00DEC60800000000L,0x000000000697F800L});
    public static final BitSet FOLLOW_ltl_binary_expr_in_ltl_and_expr6451 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_ltl_unary_expr_in_ltl_binary_expr6516 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000710L});
    public static final BitSet FOLLOW_TOK_UNTIL_in_ltl_binary_expr6532 = new BitSet(new long[]{0x00DEC60800000000L,0x000000000697F800L});
    public static final BitSet FOLLOW_ltl_unary_expr_in_ltl_binary_expr6537 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000710L});
    public static final BitSet FOLLOW_TOK_SINCE_in_ltl_binary_expr6562 = new BitSet(new long[]{0x00DEC60800000000L,0x000000000697F800L});
    public static final BitSet FOLLOW_ltl_unary_expr_in_ltl_binary_expr6567 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000710L});
    public static final BitSet FOLLOW_TOK_RELEASES_in_ltl_binary_expr6592 = new BitSet(new long[]{0x00DEC60800000000L,0x000000000697F800L});
    public static final BitSet FOLLOW_ltl_unary_expr_in_ltl_binary_expr6597 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000710L});
    public static final BitSet FOLLOW_TOK_TRIGGERED_in_ltl_binary_expr6622 = new BitSet(new long[]{0x00DEC60800000000L,0x000000000697F800L});
    public static final BitSet FOLLOW_ltl_unary_expr_in_ltl_binary_expr6627 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000710L});
    public static final BitSet FOLLOW_ltl_pure_unary_expr_in_ltl_unary_expr6779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ltl_relational_expr_in_ltl_unary_expr6820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_OP_NEXT_in_ltl_pure_unary_expr6872 = new BitSet(new long[]{0x00DEC60800000000L,0x000000000697F800L});
    public static final BitSet FOLLOW_ltl_unary_expr_in_ltl_pure_unary_expr6877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_OP_PREV_in_ltl_pure_unary_expr6901 = new BitSet(new long[]{0x00DEC60800000000L,0x000000000697F800L});
    public static final BitSet FOLLOW_ltl_unary_expr_in_ltl_pure_unary_expr6906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_OP_NOTPREVNOT_in_ltl_pure_unary_expr6930 = new BitSet(new long[]{0x00DEC60800000000L,0x000000000697F800L});
    public static final BitSet FOLLOW_ltl_unary_expr_in_ltl_pure_unary_expr6935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_OP_GLOBALLY_in_ltl_pure_unary_expr6959 = new BitSet(new long[]{0x00DEC60800000000L,0x000000000697F800L});
    public static final BitSet FOLLOW_ltl_unary_expr_in_ltl_pure_unary_expr6964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_OP_HISTORICALLY_in_ltl_pure_unary_expr6988 = new BitSet(new long[]{0x00DEC60800000000L,0x000000000697F800L});
    public static final BitSet FOLLOW_ltl_unary_expr_in_ltl_pure_unary_expr6993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_OP_FINALLY_in_ltl_pure_unary_expr7017 = new BitSet(new long[]{0x00DEC60800000000L,0x000000000697F800L});
    public static final BitSet FOLLOW_ltl_unary_expr_in_ltl_pure_unary_expr7022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_OP_ONCE_in_ltl_pure_unary_expr7046 = new BitSet(new long[]{0x00DEC60800000000L,0x000000000697F800L});
    public static final BitSet FOLLOW_ltl_unary_expr_in_ltl_pure_unary_expr7051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_NOT_in_ltl_pure_unary_expr7085 = new BitSet(new long[]{0x0000400000000000L,0x000000000003F800L});
    public static final BitSet FOLLOW_ltl_pure_unary_expr_in_ltl_pure_unary_expr7090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ltl_in_expr_in_ltl_relational_expr7142 = new BitSet(new long[]{0x00000001F8000002L});
    public static final BitSet FOLLOW_TOK_EQUAL_in_ltl_relational_expr7158 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ltl_in_expr_in_ltl_relational_expr7163 = new BitSet(new long[]{0x00000001F8000002L});
    public static final BitSet FOLLOW_TOK_NOTEQUAL_in_ltl_relational_expr7188 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ltl_in_expr_in_ltl_relational_expr7193 = new BitSet(new long[]{0x00000001F8000002L});
    public static final BitSet FOLLOW_TOK_LT_in_ltl_relational_expr7218 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ltl_in_expr_in_ltl_relational_expr7223 = new BitSet(new long[]{0x00000001F8000002L});
    public static final BitSet FOLLOW_TOK_GT_in_ltl_relational_expr7248 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ltl_in_expr_in_ltl_relational_expr7253 = new BitSet(new long[]{0x00000001F8000002L});
    public static final BitSet FOLLOW_TOK_LE_in_ltl_relational_expr7278 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ltl_in_expr_in_ltl_relational_expr7283 = new BitSet(new long[]{0x00000001F8000002L});
    public static final BitSet FOLLOW_TOK_GE_in_ltl_relational_expr7308 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ltl_in_expr_in_ltl_relational_expr7313 = new BitSet(new long[]{0x00000001F8000002L});
    public static final BitSet FOLLOW_ltl_union_expr_in_ltl_in_expr7377 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_TOK_SETIN_in_ltl_in_expr7393 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ltl_union_expr_in_ltl_in_expr7398 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ltl_set_expr_in_ltl_union_expr7461 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_TOK_UNION_in_ltl_union_expr7477 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ltl_set_expr_in_ltl_union_expr7482 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_ltl_shift_expr_in_ltl_set_expr7543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subrange_in_ltl_set_expr7565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_LCB_in_ltl_set_expr7588 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ltl_set_list_expr_in_ltl_set_expr7590 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_TOK_RCB_in_ltl_set_expr7592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_root_expr_in_ltl_set_list_expr7645 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_TOK_COMMA_in_ltl_set_list_expr7648 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_ltl_set_list_expr7651 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_ltl_remainder_expr_in_ltl_shift_expr7697 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_TOK_LSHIFT_in_ltl_shift_expr7713 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ltl_remainder_expr_in_ltl_shift_expr7718 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_TOK_RSHIFT_in_ltl_shift_expr7742 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ltl_remainder_expr_in_ltl_shift_expr7747 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_ltl_additive_expr_in_ltl_remainder_expr7809 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_TOK_MOD_in_ltl_remainder_expr7825 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ltl_additive_expr_in_ltl_remainder_expr7830 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_ltl_multiplicative_expr_in_ltl_additive_expr7894 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_TOK_PLUS_in_ltl_additive_expr7910 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ltl_multiplicative_expr_in_ltl_additive_expr7915 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_TOK_MINUS_in_ltl_additive_expr7939 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ltl_multiplicative_expr_in_ltl_additive_expr7944 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_ltl_concatination_expr_in_ltl_multiplicative_expr8005 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_TOK_TIMES_in_ltl_multiplicative_expr8021 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ltl_concatination_expr_in_ltl_multiplicative_expr8026 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_TOK_DIVIDE_in_ltl_multiplicative_expr8050 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ltl_concatination_expr_in_ltl_multiplicative_expr8055 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_ltl_primary_expr_in_ltl_concatination_expr8116 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_TOK_CONCATENATION_in_ltl_concatination_expr8132 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ltl_primary_expr_in_ltl_concatination_expr8137 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_ltl_primary_expr_helper1_in_ltl_primary_expr8198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_MINUS_in_ltl_primary_expr8222 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ltl_primary_expr_in_ltl_primary_expr8226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_NOT_in_ltl_primary_expr8267 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ltl_primary_expr_in_ltl_primary_expr8271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_ltl_primary_expr_helper18336 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_ltl_primary_expr_helper18338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_expr_helper1_pointer1_in_ltl_primary_expr_helper18389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_LP_in_ltl_primary_expr_helper18442 = new BitSet(new long[]{0x00DEC60800000000L,0x000000000697F800L});
    public static final BitSet FOLLOW_ltl_root_expr_in_ltl_primary_expr_helper18444 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_TOK_RP_in_ltl_primary_expr_helper18446 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_ltl_primary_expr_helper18448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_BOOL_in_ltl_primary_expr_helper18519 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_TOK_LP_in_ltl_primary_expr_helper18521 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_ltl_primary_expr_helper18523 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_TOK_RP_in_ltl_primary_expr_helper18525 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_ltl_primary_expr_helper18527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_WORD1_in_ltl_primary_expr_helper18578 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_TOK_LP_in_ltl_primary_expr_helper18580 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_ltl_primary_expr_helper18582 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_TOK_RP_in_ltl_primary_expr_helper18584 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_ltl_primary_expr_helper18586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_NEXT_in_ltl_primary_expr_helper18646 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_TOK_LP_in_ltl_primary_expr_helper18648 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_ltl_primary_expr_helper18650 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_TOK_RP_in_ltl_primary_expr_helper18652 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_ltl_primary_expr_helper18654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_CASE_in_ltl_primary_expr_helper18714 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_case_element_list_expr_in_ltl_primary_expr_helper18716 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_TOK_ESAC_in_ltl_primary_expr_helper18718 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_ltl_primary_expr_helper18720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_WAREAD_in_ltl_primary_expr_helper18780 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_TOK_LP_in_ltl_primary_expr_helper18782 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_ltl_primary_expr_helper18786 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_TOK_COMMA_in_ltl_primary_expr_helper18788 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_ltl_primary_expr_helper18792 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_TOK_RP_in_ltl_primary_expr_helper18794 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_ltl_primary_expr_helper18796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_WAWRITE_in_ltl_primary_expr_helper18860 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_TOK_LP_in_ltl_primary_expr_helper18862 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_ltl_primary_expr_helper18866 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_TOK_COMMA_in_ltl_primary_expr_helper18870 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_ltl_primary_expr_helper18874 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_TOK_COMMA_in_ltl_primary_expr_helper18878 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_ltl_primary_expr_helper18882 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_TOK_RP_in_ltl_primary_expr_helper18884 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_ltl_primary_expr_helper18886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ctls_implies_expr_in_ctls_root_expr8967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ctls_iff_expr_in_ctls_implies_expr9010 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_TOK_IMPLIES_in_ctls_implies_expr9026 = new BitSet(new long[]{0xFFDEC60800000000L,0x000000000697F847L});
    public static final BitSet FOLLOW_ctls_implies_expr_in_ctls_implies_expr9031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ctls_or_expr_in_ctls_iff_expr9096 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_TOK_IFF_in_ctls_iff_expr9112 = new BitSet(new long[]{0xFFDEC60800000000L,0x000000000697F847L});
    public static final BitSet FOLLOW_ctls_or_expr_in_ctls_iff_expr9117 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ctls_and_expr_in_ctls_or_expr9180 = new BitSet(new long[]{0x0000000003800002L});
    public static final BitSet FOLLOW_TOK_OR_in_ctls_or_expr9196 = new BitSet(new long[]{0xFFDEC60800000000L,0x000000000697F847L});
    public static final BitSet FOLLOW_ctls_and_expr_in_ctls_or_expr9201 = new BitSet(new long[]{0x0000000003800002L});
    public static final BitSet FOLLOW_TOK_XOR_in_ctls_or_expr9225 = new BitSet(new long[]{0xFFDEC60800000000L,0x000000000697F847L});
    public static final BitSet FOLLOW_ctls_and_expr_in_ctls_or_expr9230 = new BitSet(new long[]{0x0000000003800002L});
    public static final BitSet FOLLOW_TOK_XNOR_in_ctls_or_expr9254 = new BitSet(new long[]{0xFFDEC60800000000L,0x000000000697F847L});
    public static final BitSet FOLLOW_ctls_and_expr_in_ctls_or_expr9259 = new BitSet(new long[]{0x0000000003800002L});
    public static final BitSet FOLLOW_ctls_ltl_binary_expr_in_ctls_and_expr9322 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_TOK_AND_in_ctls_and_expr9338 = new BitSet(new long[]{0xFFDEC60800000000L,0x000000000697F847L});
    public static final BitSet FOLLOW_ctls_ltl_binary_expr_in_ctls_and_expr9343 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_ctls_ltl_unary_expr_in_ctls_ltl_binary_expr9407 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000710L});
    public static final BitSet FOLLOW_TOK_UNTIL_in_ctls_ltl_binary_expr9423 = new BitSet(new long[]{0xFFDEC60800000000L,0x000000000697F847L});
    public static final BitSet FOLLOW_ctls_ltl_unary_expr_in_ctls_ltl_binary_expr9428 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000710L});
    public static final BitSet FOLLOW_TOK_SINCE_in_ctls_ltl_binary_expr9453 = new BitSet(new long[]{0xFFDEC60800000000L,0x000000000697F847L});
    public static final BitSet FOLLOW_ctls_ltl_unary_expr_in_ctls_ltl_binary_expr9458 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000710L});
    public static final BitSet FOLLOW_TOK_RELEASES_in_ctls_ltl_binary_expr9483 = new BitSet(new long[]{0xFFDEC60800000000L,0x000000000697F847L});
    public static final BitSet FOLLOW_ctls_ltl_unary_expr_in_ctls_ltl_binary_expr9488 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000710L});
    public static final BitSet FOLLOW_TOK_TRIGGERED_in_ctls_ltl_binary_expr9513 = new BitSet(new long[]{0xFFDEC60800000000L,0x000000000697F847L});
    public static final BitSet FOLLOW_ctls_ltl_unary_expr_in_ctls_ltl_binary_expr9518 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000710L});
    public static final BitSet FOLLOW_ctls_ltl_pure_unary_expr_in_ctls_ltl_unary_expr9669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ctls_ctl_expr_in_ctls_ltl_unary_expr9710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_OP_NEXT_in_ctls_ltl_pure_unary_expr9760 = new BitSet(new long[]{0xFFDEC60800000000L,0x000000000697F847L});
    public static final BitSet FOLLOW_ctls_ltl_unary_expr_in_ctls_ltl_pure_unary_expr9765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_OP_PREV_in_ctls_ltl_pure_unary_expr9789 = new BitSet(new long[]{0xFFDEC60800000000L,0x000000000697F847L});
    public static final BitSet FOLLOW_ctls_ltl_unary_expr_in_ctls_ltl_pure_unary_expr9794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_OP_NOTPREVNOT_in_ctls_ltl_pure_unary_expr9818 = new BitSet(new long[]{0xFFDEC60800000000L,0x000000000697F847L});
    public static final BitSet FOLLOW_ctls_ltl_unary_expr_in_ctls_ltl_pure_unary_expr9823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_OP_GLOBALLY_in_ctls_ltl_pure_unary_expr9847 = new BitSet(new long[]{0xFFDEC60800000000L,0x000000000697F847L});
    public static final BitSet FOLLOW_ctls_ltl_unary_expr_in_ctls_ltl_pure_unary_expr9852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_OP_HISTORICALLY_in_ctls_ltl_pure_unary_expr9876 = new BitSet(new long[]{0xFFDEC60800000000L,0x000000000697F847L});
    public static final BitSet FOLLOW_ctls_ltl_unary_expr_in_ctls_ltl_pure_unary_expr9881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_OP_FINALLY_in_ctls_ltl_pure_unary_expr9905 = new BitSet(new long[]{0xFFDEC60800000000L,0x000000000697F847L});
    public static final BitSet FOLLOW_ctls_ltl_unary_expr_in_ctls_ltl_pure_unary_expr9910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_OP_ONCE_in_ctls_ltl_pure_unary_expr9934 = new BitSet(new long[]{0xFFDEC60800000000L,0x000000000697F847L});
    public static final BitSet FOLLOW_ctls_ltl_unary_expr_in_ctls_ltl_pure_unary_expr9939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_NOT_in_ctls_ltl_pure_unary_expr9973 = new BitSet(new long[]{0x0000400000000000L,0x000000000003F800L});
    public static final BitSet FOLLOW_ctls_ltl_pure_unary_expr_in_ctls_ltl_pure_unary_expr9978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ctls_pure_ctl_expr_in_ctls_ctl_expr10197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ctls_relational_expr_in_ctls_ctl_expr10235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_EX_in_ctls_pure_ctl_expr10286 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctls_ctl_expr_in_ctls_pure_ctl_expr10291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_AX_in_ctls_pure_ctl_expr10315 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctls_ctl_expr_in_ctls_pure_ctl_expr10320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_EF_in_ctls_pure_ctl_expr10344 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctls_ctl_expr_in_ctls_pure_ctl_expr10349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_AF_in_ctls_pure_ctl_expr10373 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctls_ctl_expr_in_ctls_pure_ctl_expr10378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_EG_in_ctls_pure_ctl_expr10402 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctls_ctl_expr_in_ctls_pure_ctl_expr10407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_AG_in_ctls_pure_ctl_expr10431 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctls_ctl_expr_in_ctls_pure_ctl_expr10436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ctls_aa_in_ctls_pure_ctl_expr10465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ctls_ee_in_ctls_pure_ctl_expr10485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_EBF_in_ctls_pure_ctl_expr10502 = new BitSet(new long[]{0x0000060000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_subrange_in_ctls_pure_ctl_expr10507 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctls_ctl_expr_in_ctls_pure_ctl_expr10511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_ABF_in_ctls_pure_ctl_expr10535 = new BitSet(new long[]{0x0000060000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_subrange_in_ctls_pure_ctl_expr10540 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctls_ctl_expr_in_ctls_pure_ctl_expr10544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_EBG_in_ctls_pure_ctl_expr10568 = new BitSet(new long[]{0x0000060000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_subrange_in_ctls_pure_ctl_expr10573 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctls_ctl_expr_in_ctls_pure_ctl_expr10577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_ABG_in_ctls_pure_ctl_expr10601 = new BitSet(new long[]{0x0000060000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_subrange_in_ctls_pure_ctl_expr10606 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctls_ctl_expr_in_ctls_pure_ctl_expr10610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_NOT_in_ctls_pure_ctl_expr10644 = new BitSet(new long[]{0xFF00400000000000L,0x0000000000000047L});
    public static final BitSet FOLLOW_ctls_pure_ctl_expr_in_ctls_pure_ctl_expr10649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ctls_abu_in_ctls_aa10708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ctls_au_in_ctls_aa10739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ctls_ebu_in_ctls_ee10808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ctls_eu_in_ctls_ee10839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_AA_in_ctls_au10904 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_TOK_LB_in_ctls_au10909 = new BitSet(new long[]{0xFFDEC60800000000L,0x000000000697F847L});
    public static final BitSet FOLLOW_ctls_root_expr_in_ctls_au10914 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_TOK_RB_in_ctls_au10918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_EE_in_ctls_eu10973 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_TOK_LB_in_ctls_eu10978 = new BitSet(new long[]{0xFFDEC60800000000L,0x000000000697F847L});
    public static final BitSet FOLLOW_ctls_root_expr_in_ctls_eu10983 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_TOK_RB_in_ctls_eu10987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_AA_in_ctls_abu11041 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_TOK_LB_in_ctls_abu11046 = new BitSet(new long[]{0xFFDEC60800000000L,0x000000000697F847L});
    public static final BitSet FOLLOW_ctls_root_expr_in_ctls_abu11051 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_TOK_BUNTIL_in_ctls_abu11055 = new BitSet(new long[]{0x0000060000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_subrange_in_ctls_abu11059 = new BitSet(new long[]{0xFFDEC60800000000L,0x000000000697F847L});
    public static final BitSet FOLLOW_ctls_root_expr_in_ctls_abu11063 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_TOK_RB_in_ctls_abu11067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_EE_in_ctls_ebu11121 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_TOK_LB_in_ctls_ebu11126 = new BitSet(new long[]{0xFFDEC60800000000L,0x000000000697F847L});
    public static final BitSet FOLLOW_ctls_root_expr_in_ctls_ebu11131 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_TOK_BUNTIL_in_ctls_ebu11135 = new BitSet(new long[]{0x0000060000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_subrange_in_ctls_ebu11139 = new BitSet(new long[]{0xFFDEC60800000000L,0x000000000697F847L});
    public static final BitSet FOLLOW_ctls_root_expr_in_ctls_ebu11143 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_TOK_RB_in_ctls_ebu11147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ctls_in_expr_in_ctls_relational_expr11199 = new BitSet(new long[]{0x00000001F8000002L});
    public static final BitSet FOLLOW_TOK_EQUAL_in_ctls_relational_expr11215 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctls_in_expr_in_ctls_relational_expr11220 = new BitSet(new long[]{0x00000001F8000002L});
    public static final BitSet FOLLOW_TOK_NOTEQUAL_in_ctls_relational_expr11245 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctls_in_expr_in_ctls_relational_expr11250 = new BitSet(new long[]{0x00000001F8000002L});
    public static final BitSet FOLLOW_TOK_LT_in_ctls_relational_expr11275 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctls_in_expr_in_ctls_relational_expr11280 = new BitSet(new long[]{0x00000001F8000002L});
    public static final BitSet FOLLOW_TOK_GT_in_ctls_relational_expr11305 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctls_in_expr_in_ctls_relational_expr11310 = new BitSet(new long[]{0x00000001F8000002L});
    public static final BitSet FOLLOW_TOK_LE_in_ctls_relational_expr11335 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctls_in_expr_in_ctls_relational_expr11340 = new BitSet(new long[]{0x00000001F8000002L});
    public static final BitSet FOLLOW_TOK_GE_in_ctls_relational_expr11365 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctls_in_expr_in_ctls_relational_expr11370 = new BitSet(new long[]{0x00000001F8000002L});
    public static final BitSet FOLLOW_ctls_union_expr_in_ctls_in_expr11433 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_TOK_SETIN_in_ctls_in_expr11449 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctls_union_expr_in_ctls_in_expr11454 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ctls_set_expr_in_ctls_union_expr11517 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_TOK_UNION_in_ctls_union_expr11533 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctls_set_expr_in_ctls_union_expr11538 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_ctls_shift_expr_in_ctls_set_expr11600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subrange_in_ctls_set_expr11622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_LCB_in_ctls_set_expr11645 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctls_set_list_expr_in_ctls_set_expr11647 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_TOK_RCB_in_ctls_set_expr11649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_root_expr_in_ctls_set_list_expr11702 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_TOK_COMMA_in_ctls_set_list_expr11705 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_ctls_set_list_expr11708 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_ctls_remainder_expr_in_ctls_shift_expr11754 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_TOK_LSHIFT_in_ctls_shift_expr11770 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctls_remainder_expr_in_ctls_shift_expr11775 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_TOK_RSHIFT_in_ctls_shift_expr11799 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctls_remainder_expr_in_ctls_shift_expr11804 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_ctls_additive_expr_in_ctls_remainder_expr11866 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_TOK_MOD_in_ctls_remainder_expr11882 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctls_additive_expr_in_ctls_remainder_expr11887 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_ctls_multiplicative_expr_in_ctls_additive_expr11952 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_TOK_PLUS_in_ctls_additive_expr11968 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctls_multiplicative_expr_in_ctls_additive_expr11973 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_TOK_MINUS_in_ctls_additive_expr11997 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctls_multiplicative_expr_in_ctls_additive_expr12002 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_ctls_concatination_expr_in_ctls_multiplicative_expr12062 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_TOK_TIMES_in_ctls_multiplicative_expr12078 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctls_concatination_expr_in_ctls_multiplicative_expr12083 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_TOK_DIVIDE_in_ctls_multiplicative_expr12107 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctls_concatination_expr_in_ctls_multiplicative_expr12112 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_ctls_primary_expr_in_ctls_concatination_expr12173 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_TOK_CONCATENATION_in_ctls_concatination_expr12189 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctls_primary_expr_in_ctls_concatination_expr12194 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_ctls_primary_expr_helper1_in_ctls_primary_expr12263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_MINUS_in_ctls_primary_expr12287 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctls_primary_expr_in_ctls_primary_expr12291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_NOT_in_ctls_primary_expr12332 = new BitSet(new long[]{0x00DEC60000000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_ctls_primary_expr_in_ctls_primary_expr12336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_ctls_primary_expr_helper112401 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_ctls_primary_expr_helper112403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_expr_helper1_pointer1_in_ctls_primary_expr_helper112454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_LP_in_ctls_primary_expr_helper112507 = new BitSet(new long[]{0xFFDEC60800000000L,0x000000000697F847L});
    public static final BitSet FOLLOW_ctls_root_expr_in_ctls_primary_expr_helper112509 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_TOK_RP_in_ctls_primary_expr_helper112511 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_ctls_primary_expr_helper112513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_BOOL_in_ctls_primary_expr_helper112584 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_TOK_LP_in_ctls_primary_expr_helper112586 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_ctls_primary_expr_helper112588 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_TOK_RP_in_ctls_primary_expr_helper112590 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_ctls_primary_expr_helper112592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_WORD1_in_ctls_primary_expr_helper112643 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_TOK_LP_in_ctls_primary_expr_helper112645 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_ctls_primary_expr_helper112647 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_TOK_RP_in_ctls_primary_expr_helper112649 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_ctls_primary_expr_helper112651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_NEXT_in_ctls_primary_expr_helper112711 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_TOK_LP_in_ctls_primary_expr_helper112713 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_ctls_primary_expr_helper112715 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_TOK_RP_in_ctls_primary_expr_helper112717 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_ctls_primary_expr_helper112719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_CASE_in_ctls_primary_expr_helper112779 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_case_element_list_expr_in_ctls_primary_expr_helper112781 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_TOK_ESAC_in_ctls_primary_expr_helper112783 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_ctls_primary_expr_helper112785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_WAREAD_in_ctls_primary_expr_helper112845 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_TOK_LP_in_ctls_primary_expr_helper112847 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_ctls_primary_expr_helper112851 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_TOK_COMMA_in_ctls_primary_expr_helper112853 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_ctls_primary_expr_helper112857 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_TOK_RP_in_ctls_primary_expr_helper112859 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_ctls_primary_expr_helper112861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_WAWRITE_in_ctls_primary_expr_helper112925 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_TOK_LP_in_ctls_primary_expr_helper112927 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_ctls_primary_expr_helper112931 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_TOK_COMMA_in_ctls_primary_expr_helper112935 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_ctls_primary_expr_helper112939 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_TOK_COMMA_in_ctls_primary_expr_helper112943 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_ctls_primary_expr_helper112947 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_TOK_RP_in_ctls_primary_expr_helper112949 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_ctls_primary_expr_helper112951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_ATOM_in_primary_expr_helper1_pointer113022 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_select_in_primary_expr_helper1_pointer113024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_expr_select_helper_in_primary_expr_select13067 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_primary_expr_ref_in_primary_expr_select13071 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080008L});
    public static final BitSet FOLLOW_TOK_DOT_in_primary_expr_ref13094 = new BitSet(new long[]{0x0000000000000000L,0x0000000000140000L});
    public static final BitSet FOLLOW_set_in_primary_expr_ref13097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_expr_select_helper_arr_suffix_in_primary_expr_select_helper13131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_expr_select_helper_bit_suffix_in_primary_expr_select_helper13143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_LB_in_primary_expr_select_helper_arr_suffix13167 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_primary_expr_select_helper_arr_suffix13169 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_TOK_RB_in_primary_expr_select_helper_arr_suffix13171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_LB_in_primary_expr_select_helper_bit_suffix13211 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_primary_expr_select_helper_bit_suffix13215 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_TOK_COLON_in_primary_expr_select_helper_bit_suffix13217 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_primary_expr_select_helper_bit_suffix13221 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_TOK_RB_in_primary_expr_select_helper_bit_suffix13223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_root_expr_in_case_element_expr13271 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_TOK_COLON_in_case_element_expr13273 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_case_element_expr13275 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_TOK_SEMI_in_case_element_expr13277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_element_expr_in_case_element_list_expr13313 = new BitSet(new long[]{0x00DEC60800000002L,0x0000000006940000L});
    public static final BitSet FOLLOW_case_element_expr_in_case_element_list_expr13316 = new BitSet(new long[]{0x00DEC60800000002L,0x0000000006940000L});
    public static final BitSet FOLLOW_TOK_NUMBER_in_number13341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_PLUS_in_number13353 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_TOK_NUMBER_in_number13356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_NUMBER_in_integer13369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_PLUS_in_integer13397 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_TOK_NUMBER_in_integer13399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_MINUS_in_integer13427 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_TOK_NUMBER_in_integer13429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_NUMBER_WORD_in_number_word13466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integer_in_subrange13505 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_TOK_TWODOTS_in_subrange13507 = new BitSet(new long[]{0x0000060000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_integer_in_subrange13511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_FALSEEXP_in_constant13560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_TRUEEXP_in_constant13572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_number_in_constant13584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_number_word_in_constant13596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_SEMI_in_optsemi13621 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_TOK_NOT_in_synpred13104 = new BitSet(new long[]{0xFF00400000000000L,0x0000000000000047L});
    public static final BitSet FOLLOW_set_in_synpred13117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_AA_in_synpred23614 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_TOK_LB_in_synpred23616 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctl_root_expr_in_synpred23618 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_TOK_UNTIL_in_synpred23620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_AA_in_synpred33640 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_TOK_LB_in_synpred33642 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctl_root_expr_in_synpred33644 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_TOK_BUNTIL_in_synpred33646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_EE_in_synpred43666 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_TOK_LB_in_synpred43668 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctl_root_expr_in_synpred43670 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_TOK_UNTIL_in_synpred43672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_EE_in_synpred53692 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_TOK_LB_in_synpred53694 = new BitSet(new long[]{0xFFDEC60800000000L,0x0000000006940047L});
    public static final BitSet FOLLOW_ctl_root_expr_in_synpred53696 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_TOK_BUNTIL_in_synpred53698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_NOT_in_synpred66679 = new BitSet(new long[]{0x0000400000000000L,0x000000000003F800L});
    public static final BitSet FOLLOW_set_in_synpred66692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_NOT_in_synpred79569 = new BitSet(new long[]{0x0000400000000000L,0x000000000003F800L});
    public static final BitSet FOLLOW_set_in_synpred79582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_NOT_in_synpred810022 = new BitSet(new long[]{0xFF00400000000000L,0x0000000000000047L});
    public static final BitSet FOLLOW_set_in_synpred810035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_AA_in_synpred910460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_EE_in_synpred1010480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_AA_in_synpred1110697 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_TOK_LB_in_synpred1110699 = new BitSet(new long[]{0xFFDEC60800000000L,0x000000000697F847L});
    public static final BitSet FOLLOW_ctls_root_expr_in_synpred1110701 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_TOK_BUNTIL_in_synpred1110703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_AA_in_synpred1210732 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_TOK_LB_in_synpred1210734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_EE_in_synpred1310797 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_TOK_LB_in_synpred1310799 = new BitSet(new long[]{0xFFDEC60800000000L,0x000000000697F847L});
    public static final BitSet FOLLOW_ctls_root_expr_in_synpred1310801 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_TOK_BUNTIL_in_synpred1310803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_EE_in_synpred1410832 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_TOK_LB_in_synpred1410834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOK_LB_in_synpred1513122 = new BitSet(new long[]{0x00DEC60800000000L,0x0000000006940000L});
    public static final BitSet FOLLOW_simple_root_expr_in_synpred1513124 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_TOK_RB_in_synpred1513126 = new BitSet(new long[]{0x0000000000000002L});

}