/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sse2project;

/**
 *
 * @author Kalle
 */

import sse2project.AbstractSyntaxTrees.BotsProgram;
import sse2project.AbstractSyntaxTrees.CollaborationList;
import sse2project.AbstractSyntaxTrees.Collaboration;
import sse2project.AbstractSyntaxTrees.SequentialCollaboration;
import sse2project.AbstractSyntaxTrees.BotList;
import sse2project.AbstractSyntaxTrees.Bot;
import sse2project.AbstractSyntaxTrees.SequentialBot;
import sse2project.AbstractSyntaxTrees.OperationList;
import sse2project.AbstractSyntaxTrees.Operations;
import sse2project.AbstractSyntaxTrees.SequentialOperation;
import sse2project.AbstractSyntaxTrees.Identifier;
import sse2project.AbstractSyntaxTrees.Identifier2;
import sse2project.AbstractSyntaxTrees.IntegerLiteral;


public class Parser {

  private Scanner lexicalAnalyser;
  //private ErrorReporter errorReporter;
  private Token currentToken;
  private SourcePosition previousTokenPosition;

  public Parser(Scanner lexer) { //, ErrorReporter reporter
    lexicalAnalyser = lexer;
    //errorReporter = reporter;
    previousTokenPosition = new SourcePosition();
  }

// accept checks whether the current token matches tokenExpected.
// If so, fetches the next token.
// If not, reports a syntactic error.

  void accept (int tokenExpected) throws SyntaxError {
    if (currentToken.kind == tokenExpected) {
      previousTokenPosition = currentToken.position;
      currentToken = lexicalAnalyser.scan();
    } else {
      syntacticError("\"%\" expected here", Token.spell(tokenExpected));
    }
  }

  void acceptIt() {
    previousTokenPosition = currentToken.position;
    currentToken = lexicalAnalyser.scan();
  }

// start records the position of the start of a phrase.
// This is defined to be the position of the first
// character of the first token of the phrase.

  void start(SourcePosition position) {
    position.start = currentToken.position.start;
  }

// finish records the position of the end of a phrase.
// This is defined to be the position of the last
// character of the last token of the phrase.

  void finish(SourcePosition position) {
    position.finish = previousTokenPosition.finish;
  }

  void syntacticError(String messageTemplate, String tokenQuoted) throws SyntaxError {
    SourcePosition pos = currentToken.position;
    //errorReporter.reportError(messageTemplate, tokenQuoted, pos);
    throw(new SyntaxError());
  }

///////////////////////////////////////////////////////////////////////////////
//
// PROGRAMS
//
///////////////////////////////////////////////////////////////////////////////

  public BotsProgram parseBotsProgram() {

    BotsProgram programAST = null;

    previousTokenPosition.start = 0;
    previousTokenPosition.finish = 0;
    currentToken = lexicalAnalyser.scan();

    try {
      CollaborationList cAST = parseCollaborationList();
      programAST = new BotsProgram(cAST, previousTokenPosition);
      if (currentToken.kind != Token.EOT) {
        syntacticError("\"%\" not expected after end of program",
          currentToken.spelling);
      }
    }
    catch (SyntaxError s) { return null; }
    return programAST;
  }
///////////////////////////////////////////////////////////////////////////////
//
// COLLABORATIONLISTS
//
///////////////////////////////////////////////////////////////////////////////
    CollaborationList parseCollaborationList() throws SyntaxError {

        CollaborationList c1AST = parseCollaboration();
        while (currentToken.kind == Token.COLLABORATION){
            //accept(Token.COLLABORATION);
            CollaborationList c2AST = parseCollaboration();
            c1AST = new SequentialCollaboration(c1AST, c2AST);//, currentToken.position);
            }
        return c1AST;
    }



///////////////////////////////////////////////////////////////////////////////
//
// COLLABORATIONS
//
///////////////////////////////////////////////////////////////////////////////
    Collaboration parseCollaboration() throws SyntaxError{
        Collaboration cAST;// = parseCollaboration();
        accept(Token.COLLABORATION);    
        Identifier ID = parseIdentifier();       
        BotList b1 = parseBotList();
        accept(Token.LBRACKET);
        OperationList o1 = parseOperationList();
        accept(Token.RBRACKET);
        cAST = new Collaboration(ID, b1, o1);
        return cAST;
    }

///////////////////////////////////////////////////////////////////////////////
//
// BOTLISTS
//
///////////////////////////////////////////////////////////////////////////////
    BotList parseBotList() throws SyntaxError{
        BotList b1AST;
        accept(Token.BETWEEN);
        b1AST = parseBot();

        while (currentToken.kind == Token.COMMA){
            accept(Token.COMMA);
            BotList b2AST = parseBot();
            b1AST = new SequentialBot(b1AST, b2AST);//, currentToken.position);
        }        
        return b1AST;
    }
///////////////////////////////////////////////////////////////////////////////
//
// BOTS
//
///////////////////////////////////////////////////////////////////////////////
    Bot parseBot() throws SyntaxError {
        Bot B;// = parseBot();
        IntegerLiteral IL = parseIntegerLiteral();
        accept(Token.INTLITERAL);
        B = new Bot(IL);
        return B;
    }
///////////////////////////////////////////////////////////////////////////////
//
// OPERATIONLISTS
//
///////////////////////////////////////////////////////////////////////////////
    OperationList parseOperationList() throws SyntaxError {
        OperationList o1AST =  parseOperation();
        
        while(currentToken.kind == Token.SEMICOLON){
             accept(Token.SEMICOLON);
             if(currentToken.kind == Token.RBRACKET)
                 break;
            OperationList o2AST = parseOperation();
            o1AST = new SequentialOperation(o1AST, o2AST, currentToken.position);
        }
     return o1AST;
    }

///////////////////////////////////////////////////////////////////////////////
//
// OPERATIONS
//
///////////////////////////////////////////////////////////////////////////////
    Operations parseOperation()throws SyntaxError {
        Operations OAST=null;// = parseOperation();
        Identifier2 ID2 = new Identifier2(currentToken.spelling, previousTokenPosition);
        accept(Token.IDENTIFIER);        
        accept(Token.BY);
        IntegerLiteral IL =   parseIntegerLiteral();
        accept(Token.INTLITERAL);
        OAST  = new Operations(ID2, IL, previousTokenPosition);
        return OAST;
    }

///////////////////////////////////////////////////////////////////////////////
//
// IDENTIFIER
//
///////////////////////////////////////////////////////////////////////////////
    Identifier parseIdentifier() throws SyntaxError {
        Identifier I = null;

    if (currentToken.kind == Token.IDENTIFIER) {
      previousTokenPosition = currentToken.position;
      String spelling = currentToken.spelling;
      I = new Identifier(spelling, previousTokenPosition);
      currentToken = lexicalAnalyser.scan();
    } else {
      I = null;
      syntacticError("identifier expected here", "");
    }
    return I;
    }
///////////////////////////////////////////////////////////////////////////////
//
// INTEGER-LITERALS
//
///////////////////////////////////////////////////////////////////////////////
    public IntegerLiteral parseIntegerLiteral() throws SyntaxError {
        // parseIntegerLiteral parses an integer-literal, and constructs
// a leaf AST to represent it.

  //IntegerLiteral parseIntegerLiteral() throws SyntaxError {
    IntegerLiteral IL = null;

    if (currentToken.kind == Token.INTLITERAL) {
      previousTokenPosition = currentToken.position;
      String spelling = currentToken.spelling;
      IL = new IntegerLiteral(spelling, previousTokenPosition);
      ///currentToken = lexicalAnalyser.scan();
    } else {
      IL = null;
      syntacticError("integer literal expected here", "");
    }
    return IL;
  }
    

///////////////////////////////////////////////////////////////////////////////
//
// IDENTIFIER2
//
///////////////////////////////////////////////////////////////////////////////
    Identifier2 parseIdentifier2()throws SyntaxError {
        Identifier2 ID2AST = parseIdentifier2();
        if(currentToken.kind == Token.IDENTIFIER){//Token.WORK
            acceptIt();
        }
        else if (currentToken.kind == Token.IDENTIFIER){//Token.MOVE
            acceptIt();
        }
     return ID2AST;
    }






///////////////////////////////////////////////////////////////////////////////
//
// LITERALS
//
///////////////////////////////////////////////////////////////////////////////



// parseCharacterLiteral parses a character-literal, and constructs a leaf
// AST to represent it.

}
