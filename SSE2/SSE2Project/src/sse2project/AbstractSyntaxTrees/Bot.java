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
public class Bot extends BotList {
    public Bot(IntegerLiteral INTAST, SourcePosition thePosition){
      super (thePosition);
      INTLIT = INTAST;
    }
    //public Object visit(Visitor v, Object o) {
    //return v.visitAssignCommand(this, o);
  //}
    public IntegerLiteral INTLIT;
}