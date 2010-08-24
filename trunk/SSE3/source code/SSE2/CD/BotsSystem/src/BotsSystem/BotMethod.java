// Bent Bruun Kristensen
// bbkristensen@mmmi.sdu.dk

package BotsSystem;
//import RunTimeSystem.*;
   
public class BotMethod {


   static class botMove extends Method {
      botMove() {
         text = "move";
      };

      public void execute(Participant p, Activity a) {
         Bot b = (Bot) p;
         Collaboration t = (Collaboration) a;
         b.moveTo(t.tx, t.ty, t.tc);
      };
   };

   static class botWork extends Method {
      botWork() {
         text = "work";
      };

      public void execute(Participant p, Activity a) {
         Bot b = (Bot) p;
         Collaboration t = (Collaboration) a;
         b.work(t.tc);
      };
   };   
};

