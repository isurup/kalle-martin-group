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
public class Collaboration extends CollaborationList{
  public Collaboration(BotList BLAST, OperationList OLAST, SourcePosition thePosition){
      super (thePosition);
      BL = BLAST;
      OL = OLAST;
  }
  //public Object visit(Visitor v, Object o) {
    //return v.visitAssignCommand(this, o);
  //}
  public BotList BL;
  public OperationList OL;
}
