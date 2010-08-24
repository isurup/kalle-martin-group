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

public class Identifier extends Terminal {

  public Identifier (String theSpelling, SourcePosition thePosition) {
    super (theSpelling, thePosition);
    //type = null;
    //decl = null;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitIdentifier(this, o);
  }

  //public TypeDenoter type;
  //public AST decl; // Either a Declaration or a FieldTypeDenoter
}
