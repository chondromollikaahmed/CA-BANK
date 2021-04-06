package ca.bank;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chondromollika_Ahmed
 */


import javax.swing.JDialog;
import javax.swing.JFrame;
public class fadeFrame {
    
    
    
 


  public static int EXIT = 3;
  
  public static int DISPOSE = 2;
  
  public static int HIDE = 1;
  
  public static int DO_NOTHING = 0;
  
  public static int ICONIFIED=4;
  
  public static void JFrameFadeOut(final float opacityStart, final float opacityEnd, final float opacityDecrement, final long sleep, final JFrame frame, final int actionAfterFade) {
    if (!frame.isUndecorated()) 
    {
      System.out.println("The frame is decorated, please set undecorated to continue...uncheck the undecorated option in propierties.");
    
    } 
    else
    {
      (new Thread() 
      {
          public void run() {
            for (float i = opacityStart; i >= opacityEnd; i -= opacityDecrement) {
              try {
                Thread.sleep(sleep);
                frame.setOpacity(i);
              } catch (Exception e) {
                e.printStackTrace();
              } 
            } 
            fadeFrame.action(actionAfterFade, frame);
          }
        }).start();
    } 
  }
  
  public static void JFrameFadeIn(final float opacityStart, final float opacityEnd, final float opacityIncrement, final long sleep, final JFrame frame) {
    if (!frame.isUndecorated()) {
      System.out.println("The frame is decorated, please set undecorated to continue...uncheck the undecorated option in propierties.");
    } 
    else
    {
      (new Thread() {
          public void run() {
            for (float i = opacityStart; i <= opacityEnd; i += opacityIncrement) {
              try {
                Thread.sleep(sleep);
                frame.setOpacity(i);
              } catch (Exception e) {
                e.printStackTrace();
              } 
            } 
          }
        }).start();
    } 
  }
  
  public static void JDialogFadeOut(final float opacityStart, final float opacityEnd, final float opacityDecrement, final long sleep, final JDialog dialog, final int actionAfterFade) {
    if (!dialog.isUndecorated()) {
      System.out.println("The dialog is decorated, please set undecorated to continue...uncheck the undecorated option in propierties.");
    
    
    }     else {
      (new Thread() {
          public void run() {
            for (float i = opacityStart; i >= opacityEnd; i -= opacityDecrement) {
              try {
                Thread.sleep(sleep);
                dialog.setOpacity(i);
              } catch (Exception e) {
                e.printStackTrace();
              } 
            } 
            fadeFrame.action(actionAfterFade, dialog);
          }
        }).start();
    } 
  }
  
  public static void JDialogFadeIn(final float opacityStart, final float opacityEnd, final float opacityDecrement, final long sleep, final JDialog dialog) {
    if (!dialog.isUndecorated()) {
      System.out.println("The dialog is decorated, please set undecorated to continue...uncheck the undecorated option in propierties.");
    
    } 
    else 
    {
      (new Thread() 
      {
          public void run() {
            for (float i = opacityStart; i <= opacityEnd; i += opacityDecrement) {
              try {
                Thread.sleep(sleep);
                dialog.setOpacity(i);
              } catch (Exception e) {
                e.printStackTrace();
              } 
            } 
          }
        }).start();
    } 
  }
  
  private static void action(int option, JFrame frame) {
    switch (option) {
      
      case 1:
          frame.setVisible(false);
          break;
      case 2:
           frame.dispose();
           break;
      case 3:
           System.exit(0);
           break;
      case 4:
            frame.setState(JFrame.ICONIFIED);
            frame.setOpacity(1.0f);
            break;
    } 
  }
  
  private static void action(int option, JDialog frame) {
    switch (option) {
      case 1:
      case 2:
        frame.setVisible(false);
        break;
      case 3:
        System.exit(0);
        break;
    } 
  }
}

    

