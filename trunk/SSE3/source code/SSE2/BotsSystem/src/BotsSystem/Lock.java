// Bent Bruun Kristensen
// bbkristensen@mmmi.sdu.dk

package BotsSystem;

public class Lock {

   public Lock(int no) {
      c = no;
	  //kjaskdsj
   };

   synchronized public void ready() {
      if (--c>0) check();
      else notifyAll();
   };

   synchronized public void check() {
      try {
         waitWhile();
      } catch (InterruptedException ie) 
      { 
      };
   };

   synchronized public void waitWhile() 
      throws InterruptedException {
         wait();
   };

   int c = 1; 
};

