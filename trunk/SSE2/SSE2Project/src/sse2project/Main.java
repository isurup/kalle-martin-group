/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sse2project;

/**
 *
 * @author Martin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("<GROUP 1> SSE2: BoCoLa");
        String path  = "C:\\Documents and Settings\\Administrator\\My Documents\\Source Insight\\Projects\\Triangle";
        String fileName = "\\"+"tam1.txt";
        Compiler comp = new Compiler(path+fileName);
        comp.CompileProgram();
    }

}
