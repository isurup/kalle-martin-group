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

public class BotsProgram extends AST {

  public BotsProgram (CollaborationList cAST, SourcePosition thePosition) {
    super (thePosition);
    CL = cAST;
    }
    //public Object visit(Visitor v, Object o) {
    //return v.visitProgram(this, o);
  //}
    public CollaborationList CL;
  }