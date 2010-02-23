/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sse2project.AbstractSyntaxTrees;

/**
 *
 * @author Kalle
 */

abstract public class Terminal extends AST {

  public Terminal (String theSpelling) {
    spelling = theSpelling;
  }

  public String spelling;
}
