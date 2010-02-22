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

abstract public class Terminal extends AST {

  public Terminal (String theSpelling, SourcePosition thePosition) {
    super (thePosition);
    spelling = theSpelling;
  }

  public String spelling;
}
