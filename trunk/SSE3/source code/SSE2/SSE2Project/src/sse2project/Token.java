/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sse2project;

/*
 * @(#)Token.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */


final class Token extends Object {

  protected int kind;
  protected String spelling;
  protected SourcePosition position;

  public Token(int kind, String spelling, SourcePosition position) {

    if (kind == Token.IDENTIFIER) {
      int currentKind = firstReservedWord;
      boolean searching = true;

      while (searching) {
        int comparison = tokenTable[currentKind].compareTo(spelling);
        if (comparison == 0) {
          this.kind = currentKind;
          searching = false;
        } else if (comparison > 0 || currentKind == lastReservedWord) {
          this.kind = Token.IDENTIFIER;
          searching = false;
        } else {
          currentKind ++;
        }
      }
    } else
      this.kind = kind;

    this.spelling = spelling;
    this.position = position;

  }

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
    INTLITERAL		  = 0,
    //CHARLITERAL	= 1,
    IDENTIFIER		= 1,
    //MOVE = 5,
    //WORK = 6,


// reserved words - must be in alphabetical order...
  	BETWEEN 		= 2,
  	BY 				= 3,
  	COLLABORATION 	= 4,
        SYNC = 5,

    // punctuation...
    SEMICOLON	= 6,
    COMMA		= 7,

    // brackets...
    LPAREN      = 8,
    RPAREN      = 9,
    LBRACKET	= 10,
    RBRACKET	= 11,

    // special tokens...
    EOT			= 12,
    ERROR		= 13;

  private static String[] tokenTable = new String[] {
    "<int>",
    //"<char>",
    "<identifier>",
	"between",
	"by",
	"collaboration",
        "sync",

    ";",
    ",",
    "(",
    ")",
    "[",
    "]",

    "",
    "<error>"
  };

  private final static int	firstReservedWord = Token.BETWEEN,
  				lastReservedWord  = Token.SYNC;

}
