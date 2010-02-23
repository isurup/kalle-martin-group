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

public class SequentialCollaboration extends CollaborationList {

  public SequentialCollaboration (CollaborationList c1AST, CollaborationList c2AST, SourcePosition thePosition){
      super (thePosition);
      C1 = c1AST;
      C2 = c2AST;

  }

  //public Object visit(Visitor v, Object o) {
    //return v.visitSequentialCommand(this, o);
  //}

  public CollaborationList C1;
  public CollaborationList C2;

}