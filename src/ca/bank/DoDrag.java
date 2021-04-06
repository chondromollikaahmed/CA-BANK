/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bank;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;


/**
 *
 * @author Chondromollika_Ahmed
 */
public class DoDrag {
    
    
    
   
  private final JComponent component;
  
  private static int posX;
  
  private static int posY = 0;
  
  public DoDrag(JComponent component) {
    this.component = component;
  }
  
  public void onPress(MouseEvent evt) {
    posX = evt.getX();
    posY = evt.getY();
  }
  
  public void moveWindow(MouseEvent evt,int Xextra, int Yextra) {
      component.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    SwingUtilities.getRoot(this.component).setLocation(evt.getXOnScreen() - posX-Xextra, evt.getYOnScreen() - posY-Yextra);
  }


    
}
