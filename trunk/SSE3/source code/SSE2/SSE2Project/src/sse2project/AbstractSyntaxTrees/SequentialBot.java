/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sse2project.AbstractSyntaxTrees;

/**
 *
 * @author Kalle
 */
import sse2project.SourcePosition;

public class SequentialBot extends Bot {//extends CollaborationList{

  public SequentialBot (BotList b1AST, BotList b2AST){//, SourcePosition thePosition){
      //super (thePosition);                                                         //Why are there problem with SourcePosition??
      
      B1 = b1AST;
      B2 = b2AST;

  }
  public Object visit(Visitor v, Object o) {
    return v.visitSequentialBot(this, o);
  }

  public BotList B1;
  public BotList B2;
}
//import sse2project.SourcePosition;
//
//public class SequentialCollaboration extends CollaborationList {
//
//  public SequentialCollaboration (CollaborationList c1AST, CollaborationList c2AST, SourcePosition thePosition){
//      super (thePosition);
//      C1 = c1AST;
//      C2 = c2AST;
//
//  }
//
//  //public Object visit(Visitor v, Object o) {
//    //return v.visitSequentialCommand(this, o);
//  //}
//
//  public CollaborationList C1;
//  public CollaborationList C2;
//
//}