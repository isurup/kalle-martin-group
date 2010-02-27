/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sse2project;

/**
 *
 * @author Martin
 */
final class Token extends Object {

  protected int kind;
  protected String spelling;
  protected SourcePosition position;

  public Token(int kind, String spelling, SourcePosition position) {

  if (kind == Token.COLLABORATION) {
      int currentKind = firstReservedWord;
      boolean searching = true;

      while (searching) {
        int comparison = tokenTable[currentKind].compareTo(spelling);
        if (comparison == 0) {
          this.kind = currentKind;
          searching = false;
        }
//        else if (comparison > 0 || currentKind == lastReservedWord) {
//          this.kind = Token.IDENTIFIER;
//          searching = false;
//        }
        else {
          currentKind ++;
        }
      }
    } else
        this.kind = kind;
        this.spelling = spelling;
        this.position = position;

  }

//    if (kind == Token.IDENTIFIER) {
//      int currentKind = firstReservedWord;
//      boolean searching = true;
//
//      while (searching) {
//        int comparison = tokenTable[currentKind].compareTo(spelling);
//        if (comparison == 0) {
//          this.kind = currentKind;
//          searching = false;
//        } else if (comparison > 0 || currentKind == lastReservedWord) {
//          this.kind = Token.IDENTIFIER;
//          searching = false;
//        } else {
//          currentKind ++;
//        }
//      }
//    } else
//        this.kind = kind;
//        this.spelling = spelling;
//        this.position = position;
//
//  }

  public static String spell (int kind) {
    return tokenTable[kind];
  }

  public String toString() {
    return "Kind=" + kind + ", spelling=" + spelling +
      ", position=" + position;
  }

  // Token classes...

  public static final int

    // literals, identifiers, operators...
    INTLITERAL	= 0,
    //CHARLITERAL	= 1,
    IDENTIFIER	= 1,
    IDENTIFIER2 = 2,
    OPERATIONS = 3,
    //OPERATOR	= 3,

    // reserved words - must be in alphabetical order...
    COLLABORATION       = 5,
    
    BY                  = 7,
    BETWEEN             = 8,
    //BEGIN		= 5,
    //CONST		= 6,
    //DO			= 7,
    //ELSE		= 8,
    //END			= 9,
    WORK                = 10,
    MOVE                = 11,
    //FUNC		= 10,
    //IF			= 11,
    //IN			= 12,
    //LET			= 13,
    //OF			= 14,
    //PROC		= 15,
    //RECORD		= 16,
    //THEN		= 17,
    //TYPE		= 18,
    //VAR			= 19,
    //WHILE		= 20,

    // punctuation...
    //DOT			= 21,
    //COLON		= 22,
    SEMICOLON	= 23,
    COMMA		= 24,
    //BECOMES		= 25,
    //IS			= 26,

    // brackets...
    //LPAREN		= 27,
    //RPAREN		= 28,
    LBRACKET	= 29,
    RBRACKET	= 30,
    //LCURLY		= 31,
    //7RCURLY		= 32,

    // special tokens...
    EOT			= 33,
    ERROR		= 34;

  private static String[] tokenTable = new String[] {
    "<int>",
    //"<char>",
    "<identifier>",
    "collaboration",
    "<operations>",
    //"<operator>",
    "array",
    "<identifier2>",
    "by",
    "between",
    "work",
    "move",
    //"begin",
    //"const",
    //"do",
    //"else",
    //"end",
    //"func",
    //"if",
    //"in",
    //"let",
    //"of",
    //"proc",
    //"record",
    //"then",
    //"type",
    //"var",
    //"while",
    //".",
    //":",
    ";",
    ",",
    //":=",
    //"~",
    //"(",
    //")",
    "[",
    "]",
    //"{",
    //"}",
    "",
    "<error>"
  };
private final static int	firstReservedWord = Token.COLLABORATION,
  				lastReservedWord  = Token.MOVE;
//  private final static int	firstReservedWord = Token.ARRAY,
//  				lastReservedWord  = Token.WHILE;

}
