/* Generated By:JavaCC: Do not edit this line. MiniScheme1.java */
import java.io.*;
public class MiniScheme1 implements MiniScheme1Constants {
  public static void main(String args []) throws ParseException, FileNotFoundException
  {
        MiniScheme1 parser = new MiniScheme1(new FileInputStream(args[0]));
        Exp exp = MiniScheme1.program();
        exp.eval(new Env ());
  }

  static final public Token getToken() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SEMI:
      jj_consume_token(SEMI);
      break;
    case PLUS:
      jj_consume_token(PLUS);
      break;
    case MINUS:
      jj_consume_token(MINUS);
      break;
    case TIMES:
      jj_consume_token(TIMES);
      break;
    case QUOTIENT:
      jj_consume_token(QUOTIENT);
      break;
    case LPAREN:
      jj_consume_token(LPAREN);
      break;
    case RPAREN:
      jj_consume_token(RPAREN);
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  {if (true) return token;}
    throw new Error("Missing return statement in function");
  }

  static final public Exp program() throws ParseException {
 Exp exp1 = null;
    exp1 = expression();
  {if (true) return exp1;}
    throw new Error("Missing return statement in function");
  }

//****
  static final public Exp defintion() throws ParseException {
 Exp exp1 = null, exp2 = null;
    jj_consume_token(DEFINE);
    exp1 = variable();
    exp2 = expression();
                                                  exp1 = new Define (exp1, exp2);
  {if (true) return exp1;}
    throw new Error("Missing return statement in function");
  }

  static final public Exp variable() throws ParseException {
 Exp exp1 = null;
    exp1 = identifier();
         {if (true) return exp1;}
    throw new Error("Missing return statement in function");
  }

  static final public Exp identifier() throws ParseException {
 Exp exp1 = null;
    exp1 = initial();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MINUS:
      case DIGIT:
      case INITIAL:
      case 21:
      case 22:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      subsequent();
    }
  {if (true) return exp1;}
    throw new Error("Missing return statement in function");
  }

  static final public Exp initial() throws ParseException {
 Exp exp1 = null;
    jj_consume_token(INITIAL);
  {if (true) return exp1;}
    throw new Error("Missing return statement in function");
  }

  static final public Exp subsequent() throws ParseException {
 Exp exp1 = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INITIAL:
      jj_consume_token(INITIAL);
      break;
    case DIGIT:
      jj_consume_token(DIGIT);
      break;
    case PLUS:
      jj_consume_token(PLUS);
      break;
    case MINUS:
      jj_consume_token(MINUS);
      break;
    case 21:
      jj_consume_token(21);
      break;
    case 22:
      jj_consume_token(22);
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  {if (true) return exp1;}
    throw new Error("Missing return statement in function");
  }

  static final public Exp expression() throws ParseException {
 Exp exp1 = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INITIAL:
      exp1 = variable();
      break;
    case INTEGER:
      exp1 = literal();
      break;
    case SET:
      exp1 = assignment();
      break;
    case LPAREN:
      exp1 = defined_expression();
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  {if (true) return exp1;}
    throw new Error("Missing return statement in function");
  }

  static final public Exp literal() throws ParseException {
 Exp exp1 = null;
    exp1 = integer();
         {if (true) return exp1;}
    throw new Error("Missing return statement in function");
  }

  static final public Exp integer() throws ParseException {
 Exp i = null;
    jj_consume_token(INTEGER);
                     String t = token.image.replaceAll("//+", ""); i = new Int(Integer.parseInt(t));
         {if (true) return i;}
    throw new Error("Missing return statement in function");
  }

//***
  static final public Exp body() throws ParseException {
 Exp exp1 = null;
    exp1 = integer();
         {if (true) return exp1;}
    throw new Error("Missing return statement in function");
  }

  static final public Exp assignment() throws ParseException {
 Exp exp1 = null;
    jj_consume_token(SET);
    exp1 = variable();
    exp2 = expression();
                                                       exp1 = new Define (exp1, exp2);
  {if (true) return exp1;}
    throw new Error("Missing return statement in function");
  }

  static final public Exp defined_expression() throws ParseException {
 Exp exp1 = null, exp2 = null; Token t = null;
    jj_consume_token(LPAREN);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case READ:
      jj_consume_token(READ);
             exp1 = new ReadExp ();
      break;
    case WRITE:
      jj_consume_token(WRITE);
      exp1 = expression();
                                  exp1 = new WriteExp (exp1);
      break;
    case NEWLINE:
      jj_consume_token(NEWLINE);
                exp1 = new NewLine();
      break;
    case LET:
      jj_consume_token(LET);
      exp1 = binding_spec();
      exp2 = body();
      break;
    case TIMES:
      jj_consume_token(TIMES);
              t = token;
      exp1 = expression();
      exp2 = expression();
                                                                   exp1 = new ArithExp (t.image, exp1, exp2);
      break;
    case QUOTIENT:
      jj_consume_token(QUOTIENT);
                 t = token;
      exp1 = expression();
      exp2 = expression();
                                                                      exp1 = new ArithExp (t.image, exp1, exp2);
      break;
    case PLUS:
      jj_consume_token(PLUS);
             t = token;
      exp1 = expression();
      exp2 = expression();
                                                                  exp1 = new ArithExp (t.image, exp1, exp2);
      break;
    case MINUS:
      jj_consume_token(MINUS);
              t = token;
      exp1 = expression();
      exp2 = expression();
                                                                   exp1 = new ArithExp (t.image, exp1, exp2);
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(RPAREN);
   {if (true) return exp1;}
    throw new Error("Missing return statement in function");
  }

  static final public Exp binding_spec() throws ParseException {
 Exp exp1 = null;
    exp1 = integer();
         {if (true) return exp1;}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public MiniScheme1TokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[5];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0xfe0,0x7020c0,0x7020c0,0x141400,0x9c3c0,};
   }

  /** Constructor with InputStream. */
  public MiniScheme1(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public MiniScheme1(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new MiniScheme1TokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public MiniScheme1(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new MiniScheme1TokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public MiniScheme1(MiniScheme1TokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(MiniScheme1TokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[23];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 5; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 23; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}