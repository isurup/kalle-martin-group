// Bent Bruun Kristensen
// bbkristensen@mmmi.sdu.dk

package BotsSystem;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Visualization extends Frame 
      implements ItemListener {  
   Visualization (Graphical_BotSystem theGBS) {
      super("   Visualization   ");
      gbs = theGBS;
      pack();
      setSize(600, 170);
      setLocation(500, 100);
      setBackground(Color.lightGray); 
      os = createImage(getSize().width,getSize().height); 
      bg = os.getGraphics(); 
      setVisible(false);
      mt.start();
   };

   Graphics bg; 
   Image os; 
   final int halfaSecond = 500;

   public void itemStateChanged(ItemEvent event) {
      ItemSelectable is = event.getItemSelectable();
   };

   void SleepPaint(int delay)  {
      repaint();
      try {
         Thread.sleep(delay);
      } catch (InterruptedException e) {
         return;
      }
   };

   public void update(Graphics g) { 
      paint(g); 
   }; 

   public void paint(Graphics g)  {
      if (gbs != null) {
         bg.clearRect(0,0,600, 170); 
         paintCollaborations();
         paintBots();
         g.drawImage(os,0,0,this); 
      };
   };

   void paintCollaborations()  {
      int px = 10;
      for (int i = 0; i < Collaboration.No; i++)  {
         Collaboration t = Collaboration.Collaborations[i];
         bg.setColor(Color.black);
         bg.drawString("BoCoLa ", px, 50);
         bg.setColor(t.tc);
         bg.drawString(" �", px+44, 50);
         bg.setColor(Color.black);
         int py = 70;
         for (int j = 0; j < t.size(); j++)  {
            Collaboration.dir d = (Collaboration.dir) t.inspect(j);
            String aText = d.dirText();
            Bot dp = (Bot) d.dirParticipant();
            aText = dp.no + "  " + aText; 
            if (j == t.getIndex()) {
               bg.setColor(Color.white);
               bg.drawString(aText, px, py);
               bg.setColor(Color.black);
            }
            else bg.drawString(aText, px, py);
            py += 15;
         };
         px += 64;
      };
   };

   void paintBots()  {
      int px = 280;
      for (int i = 0; i < Bot.No; i++)  {
         Bot b = Bot.bots[i];
         bg.setColor(Color.black);
         bg.drawString("Bot "+b.no, px, 50);
         int py = 70;
         for (int j = 0; j < b.size(); j++)  {
            Bot.act a = (Bot.act) b.inspect(j);
            String aText = a.actText();
            Collaboration aa = (Collaboration) a.actActivity();
            Color c;
            if (aa != null) c = aa.tc;
            else c = Color.black;
            if (j == b.getIndex()) {
               bg.setColor(Color.white);
               bg.drawString(aText, px, py);
               bg.setColor(c);
               bg.drawString(" �", px+28, py);
               bg.setColor(Color.black);
            } else {
               bg.drawString(aText, px, py);
               bg.setColor(c);
               bg.drawString(" �", px+28, py);
            };
            bg.setColor(Color.black);
            py += 15;
         };
         px += 50;
      };         
   };

   class myThread implements Runnable  {

      void start()  {
         new Thread(this).start();
      };

      public void run()  {
         while (this != null)  {
            SleepPaint(halfaSecond);
         }; 
      };
   };

   myThread mt = new myThread();
   Graphical_BotSystem gbs;
};


