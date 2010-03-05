/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sse2project;

import java.io.IOException;

/**
 *
 * @author Martin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.println("<GROUP 1> SSE2: BoCoLa");
        String path  = "C:\\Documents and Settings\\Administrator\\My Documents\\Source Insight\\Projects\\Triangle";
        String fileName = "\\"+"tam2.txt";
        Compiler comp = new Compiler(path+fileName);
        comp.CompileProgram();
    }

}
