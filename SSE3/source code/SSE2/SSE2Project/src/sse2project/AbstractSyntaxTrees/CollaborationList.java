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
public abstract class CollaborationList extends AST {

  public CollaborationList(){//(SourcePosition thePosition) {
      //super (thePosition);
  }
  public Object visit(Visitor v, Object o) {
    return v.visitCollaborationList(this, o);
  }
}
