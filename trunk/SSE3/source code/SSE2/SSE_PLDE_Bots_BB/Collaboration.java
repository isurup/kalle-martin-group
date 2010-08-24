// Bent Bruun Kristensen
// bbkristensen@mmmi.sdu.dk

package BotSystem;
import RunTimeSystem.*;
import java.awt.*;
import java.util.*;
   
public class Collaboration extends Activity {

   public Collaboration() {
      int no = No++;
      tx = x[no]; 
      ty = y[no]; 
      tc = c[no];
   };

   static public void initialize() {
//
//
//
//
      for (int i = 1; i <= No; i++)  {
         Collaborations[i - 1].proceed(); 
      };
   };

   int tx, ty;
   Color tc;

   static int No = 0;
   static public Collaboration [] Collaborations = new Collaboration[10];
   static final int x [] = {200, 400, 200, 400};
   static final int y [] = {200, 200, 400, 400};
   static final Color c [] = {Color.green, Color.red, Color.blue, Color.yellow};
};
