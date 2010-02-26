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
public abstract class BotList extends CollaborationList { //why and why not Collaboration!!!

    public BotList(SourcePosition thePosition){
      super (thePosition);
    }
    //public Object visit(Visitor v, Object o) {
    //return v.visitAssignCommand(this, o);
  //}
}
