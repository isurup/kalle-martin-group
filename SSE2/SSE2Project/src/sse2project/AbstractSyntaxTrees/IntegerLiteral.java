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

public class IntegerLiteral extends Terminal {

  public IntegerLiteral (String theSpelling, SourcePosition thePosition) {
    super (theSpelling, thePosition);
  }

  public Object visit(Visitor v, Object o) {
    return v.visitIntegerLiteral(this, o);
  }

}
