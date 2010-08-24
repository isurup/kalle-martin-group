// Bent Bruun Kristensen
// bbkristensen@mmmi.sdu.dk

package RunTimeSystem;

public class Context {

   public static void TraceSwitch()  {
      Trace = !Trace;
   };

   synchronized public static void print(String s)  {
      if (Trace) { 
         System.out.print(s); 
         System.out.println(); 
      };     
   };

   static void println()  {
      if (Trace) System.out.println();
   };

   synchronized public static void justPrint(String s)  {
      System.out.print(s); 
      System.out.println();    
   };

   static boolean Trace = false;
};
