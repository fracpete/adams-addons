/* The following code was generated by JFlex 1.4.3 on 4/05/20 12:18 PM */

/*
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


/*
 * Scanner.java
 * Copyright (C) 2010-2014 University of Waikato, Hamilton, New Zealand
 */

package adams.parser.twitterfilter;

import java_cup.runtime.SymbolFactory;

import java.io.InputStream;

/**
 * A scanner for twitter filter expressions.
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 * @version $Revision$
 */

public class Scanner implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int STRING = 2;
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1, 1
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\41\1\47\1\0\1\41\1\46\22\0\1\41\1\0\1\4"+
    "\5\0\1\43\1\44\2\0\1\42\1\37\1\35\1\0\1\34\11\40"+
    "\1\1\1\0\1\14\1\2\1\15\6\0\1\36\26\0\1\45\4\0"+
    "\1\10\1\0\1\20\1\11\1\21\1\32\1\17\1\30\1\27\2\0"+
    "\1\16\1\26\1\5\1\6\1\24\1\0\1\12\1\25\1\7\1\22"+
    "\1\33\1\31\1\13\1\23\4\0\1\3\uff81\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\1\2\1\3\1\4\1\5\6\1\1\6"+
    "\1\7\10\1\1\10\1\1\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\0\1\20\4\0\1\21\1\22"+
    "\1\23\11\0\1\24\4\0\1\10\1\25\1\26\1\27"+
    "\1\30\1\31\1\0\1\32\1\0\1\33\2\0\1\34"+
    "\10\0\1\35\2\0\1\10\1\36\1\0\1\37\3\0"+
    "\1\40\16\0\1\41\15\0\1\42\3\0\1\24\2\0"+
    "\1\43\3\0\1\44\4\0\1\45\2\0\1\46\1\34"+
    "\5\0\1\47\1\37\7\0\1\50\1\51\1\0\1\52"+
    "\1\53\1\54";

  private static int [] zzUnpackAction() {
    int [] result = new int[156];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\50\0\120\0\120\0\120\0\120\0\120\0\170"+
    "\0\240\0\310\0\360\0\u0118\0\u0140\0\u0168\0\u0190\0\u01b8"+
    "\0\u01e0\0\u0208\0\u0230\0\u0258\0\u0280\0\u02a8\0\u02d0\0\u02f8"+
    "\0\u0320\0\120\0\120\0\120\0\120\0\u0348\0\120\0\u0370"+
    "\0\u0398\0\120\0\u03c0\0\u03e8\0\u0410\0\u0438\0\120\0\120"+
    "\0\120\0\u0460\0\u0488\0\u04b0\0\u04d8\0\u0500\0\u0528\0\u0550"+
    "\0\u0578\0\u05a0\0\u05c8\0\u05f0\0\u0618\0\u0320\0\u0640\0\u0668"+
    "\0\120\0\120\0\120\0\120\0\120\0\u0690\0\120\0\u06b8"+
    "\0\120\0\u06e0\0\u0708\0\u0730\0\u0758\0\u0780\0\u07a8\0\u07d0"+
    "\0\u07f8\0\u0820\0\u0848\0\u0870\0\u0898\0\u08c0\0\u08e8\0\u0910"+
    "\0\120\0\u0938\0\u0960\0\u0988\0\u09b0\0\u09d8\0\u0a00\0\u0a28"+
    "\0\u0a50\0\u0a78\0\u0aa0\0\u0ac8\0\u0af0\0\u0b18\0\u0b40\0\u0b68"+
    "\0\u0b90\0\u0bb8\0\u0be0\0\u0c08\0\u0c30\0\120\0\u0c58\0\u0c80"+
    "\0\u0ca8\0\u0cd0\0\u0cf8\0\u0d20\0\u0d48\0\u0d70\0\u0d98\0\u0dc0"+
    "\0\u0de8\0\u0e10\0\u0e38\0\120\0\u0e60\0\u0e88\0\u0eb0\0\120"+
    "\0\u0ed8\0\u0f00\0\120\0\u0f28\0\u0f50\0\u0f78\0\u0fa0\0\u0fc8"+
    "\0\u0ff0\0\u1018\0\u1040\0\120\0\u1068\0\u1090\0\120\0\120"+
    "\0\u10b8\0\u10e0\0\u1108\0\u1130\0\u1158\0\120\0\120\0\u1180"+
    "\0\u11a8\0\u11d0\0\u11f8\0\u1220\0\u1248\0\u1270\0\120\0\120"+
    "\0\u1298\0\120\0\120\0\120";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[156];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12"+
    "\1\13\1\3\1\14\1\15\1\16\1\17\1\20\1\3"+
    "\1\21\1\3\1\22\1\3\1\23\1\24\1\3\1\25"+
    "\1\26\1\3\1\27\1\3\1\30\1\31\2\3\1\30"+
    "\1\32\1\33\1\34\1\35\1\3\2\32\4\36\1\37"+
    "\40\36\1\40\1\3\57\0\1\41\53\0\1\42\56\0"+
    "\1\43\33\0\1\44\63\0\1\45\34\0\1\46\43\0"+
    "\1\47\12\0\1\50\34\0\1\51\53\0\1\52\1\0"+
    "\1\53\45\0\1\54\66\0\1\55\40\0\1\56\37\0"+
    "\1\57\1\60\10\0\1\61\54\0\1\62\4\0\1\63"+
    "\25\0\1\64\47\0\1\65\73\0\1\30\1\66\1\67"+
    "\1\0\1\30\43\0\1\70\3\0\1\70\7\0\4\36"+
    "\1\0\40\36\7\0\1\71\1\72\1\0\1\73\2\0"+
    "\1\74\44\0\1\75\53\0\1\76\45\0\1\77\45\0"+
    "\1\100\52\0\1\101\42\0\1\102\47\0\1\103\1\0"+
    "\1\104\62\0\1\105\46\0\1\106\36\0\1\107\61\0"+
    "\1\110\35\0\1\111\51\0\1\112\47\0\1\113\56\0"+
    "\1\114\53\0\1\115\55\0\1\116\53\0\1\117\1\120"+
    "\43\0\1\70\1\0\1\67\1\0\1\70\16\0\1\121"+
    "\71\0\1\122\35\0\1\123\47\0\1\124\57\0\1\125"+
    "\25\0\1\126\54\0\1\127\55\0\1\130\41\0\1\131"+
    "\44\0\1\132\61\0\1\133\47\0\1\134\44\0\1\135"+
    "\61\0\1\136\37\0\1\137\67\0\1\120\43\0\1\120"+
    "\3\0\1\120\30\0\1\140\55\0\1\141\40\0\1\142"+
    "\36\0\1\143\47\0\1\144\66\0\1\145\42\0\1\146"+
    "\46\0\1\147\51\0\1\150\46\0\1\151\35\0\1\152"+
    "\65\0\1\153\31\0\1\154\46\0\1\155\62\0\1\156"+
    "\35\0\1\157\46\0\1\160\63\0\1\161\37\0\1\162"+
    "\56\0\1\163\47\0\1\164\53\0\1\165\27\0\1\166"+
    "\73\0\1\167\37\0\1\170\36\0\1\171\61\0\1\172"+
    "\34\0\1\173\62\0\1\174\36\0\1\175\47\0\1\176"+
    "\61\0\1\177\31\0\1\200\60\0\1\201\36\0\1\202"+
    "\63\0\1\203\45\0\1\204\35\0\1\205\53\0\1\206"+
    "\57\0\1\207\47\0\1\210\46\0\1\211\36\0\1\212"+
    "\50\0\1\213\47\0\1\214\60\0\1\215\35\0\1\216"+
    "\61\0\1\217\34\0\1\220\70\0\1\221\25\0\1\222"+
    "\70\0\1\223\30\0\1\224\51\0\1\225\44\0\1\226"+
    "\60\0\1\227\51\0\1\230\47\0\1\231\47\0\1\232"+
    "\33\0\1\233\53\0\1\234\36\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4800];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\5\11\22\1\4\11\1\1\1\11\1\1\1\0"+
    "\1\11\4\0\3\11\11\0\1\1\4\0\1\1\5\11"+
    "\1\0\1\11\1\0\1\11\2\0\1\1\10\0\1\1"+
    "\2\0\1\1\1\11\1\0\1\1\3\0\1\1\16\0"+
    "\1\11\15\0\1\11\3\0\1\11\2\0\1\11\3\0"+
    "\1\1\4\0\1\11\2\0\2\11\5\0\2\11\7\0"+
    "\2\11\1\0\3\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[156];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  // Author: FracPete (fracpete at waikato dot ac dot nz)
  // Version: $Revision$
  protected SymbolFactory sf;

  public Scanner(InputStream r, SymbolFactory sf){
    this(r);
    this.sf = sf;
  }
  StringBuilder string = new StringBuilder();


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Scanner(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public Scanner(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 114) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 41: 
          { return sf.newSymbol("user", sym.SCREENNAME);
          }
        case 45: break;
        case 1: 
          { System.err.println("Illegal character: " + yytext());
          }
        case 46: break;
        case 36: 
          { return sf.newSymbol("country", sym.COUNTRY);
          }
        case 47: break;
        case 7: 
          { return sf.newSymbol("greater than", sym.GT);
          }
        case 48: break;
        case 23: 
          { string.append('\t');
          }
        case 49: break;
        case 5: 
          { string.setLength(0); yybegin(STRING);
          }
        case 50: break;
        case 31: 
          { return sf.newSymbol("longitude", sym.LONGITUDE);
          }
        case 51: break;
        case 19: 
          { return sf.newSymbol("greater or equal than", sym.GE);
          }
        case 52: break;
        case 9: 
          { /* ignore white space. */
          }
        case 53: break;
        case 10: 
          { return sf.newSymbol("Comma", sym.COMMA);
          }
        case 54: break;
        case 37: 
          { return sf.newSymbol("hashtag", sym.HASHTAG);
          }
        case 55: break;
        case 14: 
          { yybegin(YYINITIAL);
                  return sf.newSymbol("String", sym.STRING, string.toString());
          }
        case 56: break;
        case 17: 
          { return sf.newSymbol("less or equal than", sym.LE);
          }
        case 57: break;
        case 32: 
          { return sf.newSymbol("user", sym.USER);
          }
        case 58: break;
        case 15: 
          { string.append('\\');
          }
        case 59: break;
        case 8: 
          { return sf.newSymbol("Number", sym.NUMBER, new Double(yytext()));
          }
        case 60: break;
        case 43: 
          { return sf.newSymbol("usermention", sym.USERMENTION);
          }
        case 61: break;
        case 16: 
          { return sf.newSymbol("or", sym.OR);
          }
        case 62: break;
        case 24: 
          { string.append('\r');
          }
        case 63: break;
        case 20: 
          { return sf.newSymbol("ifelse", sym.IFELSE);
          }
        case 64: break;
        case 12: 
          { return sf.newSymbol("Right Bracket", sym.RPAREN);
          }
        case 65: break;
        case 18: 
          { return sf.newSymbol("not equal", sym.NOT_EQ);
          }
        case 66: break;
        case 4: 
          { return sf.newSymbol("regexp match", sym.REGEXP_MATCH);
          }
        case 67: break;
        case 25: 
          { return sf.newSymbol("not", sym.NOT);
          }
        case 68: break;
        case 39: 
          { return sf.newSymbol("usermention", sym.FAVCOUNT);
          }
        case 69: break;
        case 3: 
          { return sf.newSymbol("exact match", sym.EXACT_MATCH);
          }
        case 70: break;
        case 33: 
          { return sf.newSymbol("place", sym.PLACE);
          }
        case 71: break;
        case 21: 
          { string.append('\"');
          }
        case 72: break;
        case 26: 
          { return sf.newSymbol("and", sym.AND);
          }
        case 73: break;
        case 44: 
          { return sf.newSymbol("usermention", sym.ISRETWEETED);
          }
        case 74: break;
        case 28: 
          { return sf.newSymbol("latitude", sym.LATITUDE);
          }
        case 75: break;
        case 27: 
          { return sf.newSymbol("xor", sym.XOR);
          }
        case 76: break;
        case 35: 
          { return sf.newSymbol("usermention", sym.RETWEET);
          }
        case 77: break;
        case 22: 
          { string.append('\n');
          }
        case 78: break;
        case 11: 
          { return sf.newSymbol("Left Bracket", sym.LPAREN);
          }
        case 79: break;
        case 42: 
          { return sf.newSymbol("country code", sym.COUNTRY_CODE);
          }
        case 80: break;
        case 13: 
          { string.append(yytext());
          }
        case 81: break;
        case 6: 
          { return sf.newSymbol("less than", sym.LT);
          }
        case 82: break;
        case 40: 
          { return sf.newSymbol("usermention", sym.STATUSLANG);
          }
        case 83: break;
        case 38: 
          { return sf.newSymbol("language code", sym.LANGUAGE_CODE);
          }
        case 84: break;
        case 29: 
          { return sf.newSymbol("has", sym.HAS);
          }
        case 85: break;
        case 2: 
          { return sf.newSymbol("substring match", sym.SUBSTRING_MATCH);
          }
        case 86: break;
        case 34: 
          { return sf.newSymbol("source", sym.SOURCE);
          }
        case 87: break;
        case 30: 
          { return sf.newSymbol("text", sym.TEXT);
          }
        case 88: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
              {     return sf.newSymbol("EOF",sym.EOF);
 }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
