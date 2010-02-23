/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sse2project.AbstractSyntaxTrees;

/**
 *
 * @author Kalle
 */

public class SequentialCollaboration extends CollaborationList {

  public SequentialCollaboration (CollaborationList c1AST, CollaborationList c2AST) {
    //super (thePosition);
    C1 = c1AST;
    C2 = c2AST;
  }

  //public Object visit(Visitor v, Object o) {
    //return v.visitSequentialCommand(this, o);
  //}

  public CollaborationList C1, C2;

}