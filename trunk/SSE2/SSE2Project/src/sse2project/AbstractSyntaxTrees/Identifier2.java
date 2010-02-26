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

public class Identifier2 extends Terminal {

  public Identifier2 (String theSpelling, SourcePosition thePosition) {
    super (theSpelling, thePosition);
    //type = null;
    //decl = null;
  }
}