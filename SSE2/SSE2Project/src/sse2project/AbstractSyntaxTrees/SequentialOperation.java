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

public class SequentialOperation extends OperationList {
    public SequentialOperation(OperationList o1AST, OperationList o2AST, SourcePosition thePosition){
        super (thePosition);
        O1 = o1AST;
        O2 = o2AST;
    }
    //public Object visit(Visitor v, Object o) {
    //return v.visitSequentialCommand(this, o);
    //}
    public OperationList O1;
    public OperationList O2;
}