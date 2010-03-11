/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sse2project.AbstractSyntaxTrees;

/**
 *
 * @author Administrator
 */
public interface  Visitor {
  // Commands
 // public abstract Object visitAssignCommand(AssignCommand ast, Object o);
    public abstract Object visitBot(Bot b,Object o);
    public abstract Object visitBotList(BotList bl,Object o);
    public abstract Object visitBotsProgram(BotsProgram bp,Object o);
    public abstract Object visitCollaboration(Collaboration c,Object o);
    public abstract Object visitCollaborationList(CollaborationList cl,Object o);
    public abstract Object visitSynchronization(Synchronization sync, Object o);
    public abstract Object visitIdentifier(Identifier i,Object o);
    public abstract Object visitIdentifier2(Identifier2 i,Object o);
    public abstract Object visitIntegerLiteral(IntegerLiteral il,Object o);
    public abstract Object visitOperationList(OperationList ol,Object o);
    public abstract Object visitOperations(Operations op,Object o);
    public abstract Object visitSequentialBot(SequentialBot sb,Object o);
    public abstract Object visitSequentialCollaboration(SequentialCollaboration sc,Object o);
    public abstract Object visitSequentialOperation(SequentialOperation so,Object o);
    public abstract Object visitTerminal(Terminal t,Object o);

    //public Object visitCollaboration(Synchronization aThis, Object o);
}
