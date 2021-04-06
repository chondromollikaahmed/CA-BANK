/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bank;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Chondromollika_Ahmed
 */
public class CABANK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            //new DatabaseConnect();
            Thread.sleep(5000);
            new Welcome().setVisible(true);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
}
