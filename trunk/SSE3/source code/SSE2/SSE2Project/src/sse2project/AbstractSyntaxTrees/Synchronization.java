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
public class Synchronization extends CollaborationList{
  public Synchronization(Operations O1AST, Bot B1AST, Operations O2AST, Bot B2AST){//, SourcePosition thePosition){
      //super (thePosition);

      B1 = B1AST;
      O1 = O1AST;
      B2 = B2AST;
      O2 = O2AST;
  }

    public Synchronization(OperationList o1, BotList b1, OperationList o2, BotList b2) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
  public Object visit(Visitor v, Object o) {
    return v.visitSynchronization(this, o);
  }
  public BotList B1;
  public OperationList O1;
  public BotList B2;
  public OperationList O2;
}
