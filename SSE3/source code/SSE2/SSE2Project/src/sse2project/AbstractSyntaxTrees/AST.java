/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sse2project.AbstractSyntaxTrees;

/**
 *
 * @author Kalle
 */

//import Triangle.CodeGenerator.RuntimeEntity;
import sse2project.SourcePosition;

public abstract class AST {


  public AST()
  {
  }
  public AST (SourcePosition thePosition) {
    position = thePosition;
    //entity = null;
  }

  public SourcePosition getPosition() {
    return position;
  }

  //public abstract Object visit(Visitor v, Object o);

  public SourcePosition	position;
  //public RuntimeEntity  entity;
}
