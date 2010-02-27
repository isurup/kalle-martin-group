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
public abstract class OperationList extends CollaborationList{   // Why? And why not extend Collaboration
    public OperationList(SourcePosition thePosition){
        //super (thePosition);
    }

     public Object visit(Visitor v, Object o) {
    return v.visitOperationList(this, o);
  }
}

