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
public class Collaboration extends CollaborationList{
  public Collaboration(BotList b1, OperationList o1, SourcePosition thePosition){
      super (thePosition);
  }
  public BotList B;
  public OperationList O;
}
