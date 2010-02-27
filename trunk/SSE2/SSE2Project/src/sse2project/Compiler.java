/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sse2project;

import sse2project.AbstractSyntaxTrees.BotsProgram;

public class Compiler
{
    private static Scanner scanner;
    private static Parser parser;
    private static BotsProgram theAST;

    public  String sourceName;
    
    public Compiler(){
    }
    public Compiler(String sourceName){
        this.sourceName = sourceName;        
    }

    boolean CompileProgram()
    {
        SourceFile source = new SourceFile(sourceName);            

        if (source == null) {
            System.out.println("Can't access source file " + sourceName);
            System.exit(1);
        }

        scanner = new Scanner(source);
        parser = new Parser(scanner);
        theAST = parser.parseBotsProgram();

        theAST.visit(null, this);

        return true;
    }
}
