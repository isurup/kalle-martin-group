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

public class Program extends AST {

  public Program (Collaboration cAST, SourcePosition thePosition) {
    super (thePosition);
    C = cAST;
  }

  //public Object visit(Visitor v, Object o) {
  //  return v.visitProgram(this, o);
  //}

  public Collaboration C;
}