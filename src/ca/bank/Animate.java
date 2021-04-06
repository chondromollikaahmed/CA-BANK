/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bank;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author Chondromollika Ahmed
 */
public class Animate {
    
    
    
    
    



  public static void down(final int start, final int stop, final long delay, final int increment, final JComponent component) {
    (new Thread() {
        public void run() {
          for (int i = start; i <= stop; i += increment) {
            try {
              Thread.sleep(delay);
              component.setLocation(component.getX(), i);
            } catch (Exception e) {
              e.printStackTrace();
            } 
          } 
        }
      }).start();
  }
  
  public static void up(final int start, final int stop, final long delay, final int increment, final JComponent component) {
    (new Thread() {
        public void run() {
          for (int i = start; i >= stop; i -= increment) {
            try {
              Thread.sleep(delay);
              component.setLocation(component.getX(), i);
            } catch (Exception e) {
              e.printStackTrace();
            } 
          } 
        }
      }).start();
  }
  
  public static void move_XRight(final int start, final int stop, final long delay, final int increment, final JComponent component) {
    (new Thread() {
        public void run() {
          for (int i = start; i <= stop; i += increment) {
            try {
              Thread.sleep(delay);
              component.setLocation(i, component.getY());
            } catch (Exception e) {
              e.printStackTrace();
            } 
          } 
        }
      }).start();
  }
  
  public static void move_XLeft(final int start, final int stop, final long delay, final int increment, final JComponent component) {
    (new Thread() {
        public void run() {
          for (int i = start; i >= stop; i -= increment) {
            try {
              Thread.sleep(delay);
              component.setLocation(i, component.getY());
            } catch (Exception e) {
              e.printStackTrace();
            } 
          } 
        }
      }).start();
  }
  
  public static void up(final int start, final int stop, final long delay, final int increment, final JFrame frame) {
    (new Thread() {
        public void run() {
          for (int i = start; i <= stop; i += increment) {
            try {
              Thread.sleep(delay);
              frame.setLocation(frame.getX(), i);
            } catch (Exception e) {
              e.printStackTrace();
            } 
          } 
        }
      }).start();
  }
  
  public static void down(final int start, final int stop, final long delay, final int increment, final JFrame frame) {
    (new Thread() {
        public void run() {
          for (int i = start; i >= stop; i -= increment) {
            try {
              Thread.sleep(delay);
              frame.setLocation(frame.getX(), i);
            } catch (Exception e) {
              e.printStackTrace();
            } 
          } 
        }
      }).start();
  }
  
  public static void move_XRight(final int start, final int stop, final long delay, final int increment, final JFrame frame) {
    (new Thread() {
        public void run() {
          for (int i = start; i <= stop; i += increment) {
            try {
              Thread.sleep(delay);
              frame.setLocation(i, frame.getY());
            } catch (Exception e) {
              e.printStackTrace();
            } 
          } 
        }
      }).start();
  }
  
  public static void move_XLeft(final int start, final int stop, final long delay, final int increment, final JFrame frame) {
    (new Thread() {
        public void run() {
          for (int i = start; i >= stop; i -= increment) {
            try {
              Thread.sleep(delay);
              frame.setLocation(i, frame.getY());
            } catch (Exception e) {
              e.printStackTrace();
            } 
          } 
        }
      }).start();
  }
  
  public static void FrameFadeIn() {}
}

    

