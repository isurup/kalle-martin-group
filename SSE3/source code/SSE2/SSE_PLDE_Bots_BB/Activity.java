// Bent Bruun Kristensen
// bbkristensen@mmmi.sdu.dk

package RunTimeSystem;
import java.util.*;

public abstract class Activity {

   public void include(Method m, Participant p) {
      dirList.add(size(), new dir(m, p));
   }; 

   public int getIndex() { 
      return index;
   };

   public dir inspect(int index) {
      return dirList.get(index);
   }; 

   public int size() {
      return dirList.size();
   }; 

   public void proceed() {
      nextIndex();
      dir d = (dir) dirList.get(index);
      d.participant.include(d.method, this);
   };

   void nextIndex() {
      index = (index + 1)%dirList.size();
   };

   public class dir {
      public dir(Method m, Participant p) {
         method = m;
         participant = p;
      };

      public String dirText() {
         return method.text;
      };

      public Participant dirParticipant() {
         return participant;
      };

      Method method;
      Participant participant;
   };

   ArrayList <dir> dirList = new ArrayList <dir>(20);
   int index = -1;
   int noOfParticipants = 1;
};
