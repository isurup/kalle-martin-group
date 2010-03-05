// Bent Bruun Kristensen
// bbkristensen@mmmi.sdu.dk

package BotsSystem;
//import RunTimeSystem.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Graphical_BotSystem extends Frame 
         implements ActionListener, ItemListener {
   public Graphical_BotSystem () {
      super("   Bot System   ");
      MenuBar mb = new MenuBar();
      Menu mmm = new Menu("Command");
      mmm.add(new MenuItem("Start"));
      mmm.add(new MenuItem("Quit"));
      mmm.addActionListener(this);
      mb.add(mmm);
      Menu mm = new Menu("Tools");
      mm.add(cbmi0 = new CheckboxMenuItem("Activity Visualization"));
      cbmi0.addItemListener(this);
      mm.add(cbmi1 = new CheckboxMenuItem("Augmented System"));
      cbmi1.addItemListener(this);
      mm.add(cbmi2 = new CheckboxMenuItem("Bot System Trace"));
      cbmi2.addItemListener(this);
      mb.add(mm);
      setMenuBar(mb);
      pack();
      setSize(600, 600);
      setLocation(0,0);
      setBackground(Color.lightGray); 
      os = createImage(getSize().width,getSize().height); 
      bg = os.getGraphics(); 
      setVisible(true);
      e = new Simulator(); 
      v = new Visualization(this);
	  
   };

   Graphics bg; 
   Image os; 
   private CheckboxMenuItem cbmi0, cbmi1, cbmi2;
   final int xSecond = 100;
   boolean started = false;
   boolean augmented = false;

   public void actionPerformed(ActionEvent event) {
      String action = event.getActionCommand();
	
      if (action == "Start") {
         if (!started) {
            started = true;
            for (int i = 0; i < 6; i++){
                new Bot(e);
            }
            Collaboration.initialize();
         };
      };
      
      if (action == "Quit") System.exit(0);
      
   };

   public void itemStateChanged(ItemEvent event) {
      ItemSelectable is = event.getItemSelectable();
      if (is == cbmi0) v.setVisible(cbmi0.getState());
      if (is == cbmi1) augmented = cbmi1.getState();
      if (is == cbmi2) Context.TraceSwitch();
   };

   void SleepPaint(int delay)  {
      repaint();
      try {
         Thread.sleep(delay);
      } catch (InterruptedException e) {
         return;
      };
   };

   public void update(Graphics g) { 
      paint(g); 
   }; 

   public void paint(Graphics g)  {
      bg.clearRect(0,0,600, 600); 
      paintSimulator();
      g.drawImage(os,0,0,this); 
   };

   void paintSimulator()  {
      bg.setColor(Color.green); 
      bg.fillOval(205, 205, 10, 10); 
      bg.setColor(Color.red); 
      bg.fillOval(405, 205, 10, 10); 
      bg.setColor(Color.blue); 
      bg.fillOval(205, 405, 10, 10); 
      bg.setColor(Color.yellow); 
      bg.fillOval(405, 405, 10, 10); 
      for (int i = 0; i < e.botNo; i++)  {
         Simulator.Bot ebi = e.bots[i];
         bg.setColor(ebi.co);
         bg.fillOval(ebi.px, ebi.py, 21, 21); 
         bg.setColor(Color.black);
         bg.drawString(""+i, ebi.px+6, ebi.py+15);
         if (augmented) {
            bg.setColor(ebi.co);
            bg.drawOval(ebi.mtx, ebi.mty, 20, 20); 
            bg.setColor(Color.black);
            bg.drawString(""+i, ebi.mtx+6, ebi.mty+15);
            if (ebi.wf!=0) bg.drawString(""+ebi.wf, ebi.mtx+15, ebi.mty+30);
         };
      }; 
   };

   class Simulator {  

      public Bot new_Bot() {
         Bot xb = new Bot();
         bots[botNo++] = xb;
         return xb;
      };
   
      class Bot {

         public void myColor(Color c) {
            co = c;
         };

         public void workFor(int x) {
            Color cco = co;
            wf = x;
            while (wf > 1) { 
               if (wf%2 == 0) co = Color.lightGray;
               else co = cco;
               --wf;
               SleepPaint(xSecond);
            };
            co = cco;
            wf = 0;
         };

         public void moveTo(int x, int y)  {
            mtx = x;
            mty = y;
            int dx = x - px; 
            int ox = px;
            int dy = y - py;
            int oy = py;
            double d = Math.sqrt(dx * dx + dy * dy);
            if (d == 0) {d = 1;};
            double dix = dx / d;
            double diy = dy / d;
            double dpx = px;
            double dpy = py;
            double a = 1.00001;
            while (Math.sqrt((x-dpx)*(x-dpx)+(y-dpy)*(y-dpy)) >= 1) { 
               dpx += a * dix;
               px = (int) dpx;
               dpy += a * diy;
               py = (int) dpy;
               if (Math.sqrt((ox-dpx)*(ox-dpx)+(oy-dpy)*(oy-dpy))<18) a = a*a;
               if (Math.sqrt((x-dpx)*(x-dpx)+(y-dpy)*(y-dpy))<18) a = Math.sqrt(a);
               SleepPaint(xSecond);
            };
            px = x;
            py = y;
         };

         int px = 300;
         int py = 300;
         int mtx, mty, wf;
         Color co = Color.white;
      };

      Bot [] bots = new Bot[9];//9
      int botNo = 0;
      Random A = new Random();
   };

   Simulator e;
   Visualization v;
};
