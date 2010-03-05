// Bent Bruun Kristensen
// bbkristensen@mmmi.sdu.dk

package BotsSystem;
import java.awt.*;
import java.util.*;

public abstract class Participant implements Runnable {   

   public Participant () {
      no = No++;
   };

   public abstract Method individualAction();

   synchronized public void chooseIndex() { 
      current = 0;
   };

   synchronized public int getIndex() { 
      return current;
   };

   synchronized public void idle() {
      if (actList.isEmpty()) {
         include(individualAction(), null);
      } 
   }; 

   synchronized public void include(Method m, Activity a) {
      actList.add(size(), new act(m, a));
   }; 

   synchronized public void exclude(int index) {
      actList.remove(index);
      current = -1;
   }; 

   synchronized public act inspect(int index) {
      return actList.get(index);
   }; 

   synchronized public int size() {
      return actList.size();
   }; 

   public void run()
   {   
      while (this != null) {
         idle();
         chooseIndex();
         act t = inspect(current);
         t.method.execute(this, t.activity);
         exclude(current);
         if (t.activity != null) t.activity.proceed();
      };
   };

   public class act {
      public act (Method m, Activity a) {
         method = m;
         activity = a;
      };

      public String actText() {
         return method.text;
      };

      public Activity actActivity() {
         return activity ;
      };

      Method method;
      Activity activity;
   };

   public static int No = 0;
   public int no;
   ArrayList <act> actList = new ArrayList <act>(20);
   int current = -1;
};


