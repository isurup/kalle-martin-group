// Bent Bruun Kristensen
// bbkristensen@mmmi.sdu.dk

package BotSystem;
import RunTimeSystem.*;
import java.util.*;
import java.awt.*;
   
public class Bot extends Participant {

   public Bot (Graphical_BotSystem.Simulator e) {
      bots[no] = this;
      myBot = e.new_Bot();
      new Thread(this).start();
   };

   public Method individualAction() {
      return new Method() {
         public void execute(Participant p, Activity a) {
            text = "move";
            Bot b = (Bot) p;
            b.move(Color.white);
         };
      };
   };
      
   public void work(Color c) {
      int x = Math.abs(A.nextInt()%80)+20;
      workFor(x, c);
   };
            
   void workFor(int x, Color c) {  
      myBot.myColor(c);
      myBot.workFor(x);
   };

   public void moveTo(int x, int y, Color c) {  
      myBot.myColor(c);
      myBot.moveTo(x, y);
      bx = x;
      by = y;
   };
            
   public void move(Color c) {
      int x = Math.abs(A.nextInt()%200)-100;
      int y = Math.abs(A.nextInt()%200)-100;
      move(x, y, c);
   };

   void move(int x, int y, Color c) {
      myBot.myColor(c);   
      myBot.moveTo(bx + x, by + y);
      bx += x;
      by += y;
   };
      
   int bx = 300;
   int by = 300;
   Graphical_BotSystem.Simulator.Bot myBot;
   static Random A = new Random();
   static public Bot [] bots = new Bot[10];
};
