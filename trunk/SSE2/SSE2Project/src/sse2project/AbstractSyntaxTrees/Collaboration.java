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

public abstract class Collaboration extends AST {

  public Collaboration (SourcePosition thePosition) {
    super (thePosition);
  }
}
