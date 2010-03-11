/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sse2project;

import java.io.IOException;
import sse2project.AbstractSyntaxTrees.Bot;
import sse2project.AbstractSyntaxTrees.BotList;
import sse2project.AbstractSyntaxTrees.BotsProgram;
import sse2project.AbstractSyntaxTrees.Collaboration;
import sse2project.AbstractSyntaxTrees.CollaborationList;
import sse2project.AbstractSyntaxTrees.Synchronization;
import sse2project.AbstractSyntaxTrees.Identifier;
import sse2project.AbstractSyntaxTrees.Identifier2;
import sse2project.AbstractSyntaxTrees.IntegerLiteral;
import sse2project.AbstractSyntaxTrees.OperationList;
import sse2project.AbstractSyntaxTrees.Operations;
import sse2project.AbstractSyntaxTrees.SequentialBot;
import sse2project.AbstractSyntaxTrees.SequentialCollaboration;
import sse2project.AbstractSyntaxTrees.SequentialOperation;
import sse2project.AbstractSyntaxTrees.Terminal;
import sse2project.AbstractSyntaxTrees.Visitor;

public class Compiler implements Visitor
{
    private static Scanner scanner;
    private static Parser parser;
    private static Encoder encoder;
    private static BotsProgram theAST;

    public  String sourceName;
    
    public Compiler(){
    }
    public Compiler(String sourceName){
        this.sourceName = sourceName;        
    }

    boolean CompileProgram() //throws IOException
    {
        SourceFile source = new SourceFile(sourceName);            

        if (source == null) {
            System.out.println("Can't access source file " + sourceName);
            System.exit(1);
        }

        scanner = new Scanner(source);
        parser = new Parser(scanner);
        theAST = parser.parseBotsProgram();
        
        
        theAST.visit(this, this);
        encoder =new Encoder();
        encoder.encodeRun(theAST, true);
        return true;
    }

    public Object visitBot(Bot b, Object o) {
       System.out.println("visitBot");
       b.INTLIT.visit(this, o);
       return null;
    }

    public Object visitBotList(BotList bl, Object o) {
        System.out.println("visitBotList");
        bl.visit(this, o);
        return null;
    }

    public Object visitBotsProgram(BotsProgram bp, Object o) {
        System.out.println("visitBotsProgram");
        bp.CL.visit(this, o);
        return    null;
    }

    public Object visitCollaboration(Collaboration c, Object o) {
        System.out.println("visitCollaboration");
        c.ID.visit(this, o);
        c.BL.visit(this, o);
        c.OL.visit(this, o);
        return null;
    }

    public Object visitCollaborationList(CollaborationList cl, Object o) {
        System.out.println("visitCollaborationList");
        cl.visit(this, o);
        return null;
    }

     public Object visitSynchronization(Synchronization sync, Object o) {//BotList BL1AST, OperationList OL1AST, BotList BL2AST, OperationList OL2AST
        System.out.println("visitSynchronization");
        sync.B1.visit(this, o);
        sync.O1.visit(this, o);
        sync.B2.visit(this, o);
        sync.O1.visit(this, o);
        return null;
    }

    public Object visitIdentifier(Identifier i, Object o) {
        System.out.print("visitIdentifier");
        System.out.println("<"+i.spelling+">");
        return null;
    }

    public Object visitIdentifier2(Identifier2 i, Object o) {
        System.out.print("visitIdentifier2");
        System.out.println("<"+i.spelling+">");
        return null;
    }

    public Object visitIntegerLiteral(IntegerLiteral il, Object o) {
        System.out.print("visitIntegerLiteral");
        System.out.println("<"+il.spelling+">");
        return null;
    }

    public Object visitOperationList(OperationList ol, Object o) {
        System.out.println("visitOperationList");
        ol.visit(this, o);
        return null;
    }

    public Object visitOperations(Operations op, Object o) {
        System.out.println("visitOperations");
        op.ID2.visit(this, o);
        op.INTLIT.visit(this, o);
        return null;
    }

    public Object visitSequentialBot(SequentialBot sb, Object o) {
        System.out.println("visitSequentialBot");
        sb.B1.visit(this, o);
        if(sb.B2!=null)
        sb.B2.visit(this, o);//repair this
        if(sb.INTLIT!=null)
        sb.INTLIT.visit(this, o);//repair this
        return null;
    }

    public Object visitSequentialCollaboration(SequentialCollaboration sc, Object o) {
        System.out.println("visitSequentialCollaboration");                
        sc.C1.visit(this, o);
        sc.C2.visit(this, o);
        return null;
    }

    public Object visitSequentialOperation(SequentialOperation so, Object o) {
        System.out.println("visitSequentialOperation");
        so.O1.visit(this, o);
        so.O2.visit(this, o);
        return null;
    }

    public Object visitTerminal(Terminal t, Object o) {
        System.out.println("visitTerminal");
        t.visit(this, o);
        return null;
    }

    public Object visitCollaboration(Synchronization aThis, Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
