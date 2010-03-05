/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sse2project;

import java.io.FileWriter;

import java.io.File;
import java.io.IOException;
import sse2project.AbstractSyntaxTrees.Bot;
import sse2project.AbstractSyntaxTrees.BotList;
import sse2project.AbstractSyntaxTrees.BotsProgram;
import sse2project.AbstractSyntaxTrees.Collaboration;
import sse2project.AbstractSyntaxTrees.CollaborationList;
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

/**
 *
 * @author Administrator
 */

public class Encoder implements  Visitor{

    BotsProgram AST;
    File out;
    String str="";

    String temp = "";
    public Encoder()
    {
         out = new File("Text.txt");
    }
    public final void encodeRun (BotsProgram theAST, boolean showingTable) 
            throws IOException {
        theAST.visit(this, out);
     FileWriter fw = new FileWriter(out);
     fw.write(str);
     fw.close();
  }
    // Appends an instruction, with the given fields, to the object code.
  private void emit (int op, int n, int r, int d) {
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

        //temp = str;
        str += "Collaborations"+"["+"No"+"]"+"="+"new Collaboration();"+"\r\n";
        str+="{\r\n";
        str +=temp;
        str+="}\r\n";

        temp="";
        return null;
    }

    public Object visitCollaborationList(CollaborationList cl, Object o) {       
        cl.visit(this, o);
        return null;
    }

    public Object visitIdentifier(Identifier i, Object o) {       
        return null;
    }

    public Object visitIdentifier2(Identifier2 i, Object o) {      
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

       //temp=null;
       if(op.ID2.spelling.toUpperCase().compareTo("WORK")==0){         
            temp += "Collaborations[No-1].include(new BotMethod.botWork(),Bot.bots["+op.INTLIT.spelling+"]);"+"\r\n";
        }
       else  if(op.ID2.spelling.toUpperCase().compareTo("MOVE")==0){            
            temp += "Collaborations[No-1].include(new BotMethod.botMove(),Bot.bots["+op.INTLIT.spelling+ "]);"+"\r\n";
        }


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


}
