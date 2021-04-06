/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bank;
import java.awt.*;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author Jehadur
 */
public class PanelHouse extends JPanel{
    
    
       public Color colorAtBegin = Color.BLUE;
    public Color colorAtEnd = Color.cyan;
    public boolean controlTransparent = true;
    public int focusAt = 300;
    public int curveRadius = 30;
    public boolean fillBackground = true;
    public int pixels;


    
    

    @Override
    public void setOpaque(boolean isOpaque) {
        super.setOpaque(isOpaque); 
    }
    public PanelHouse(int pix) {

        this.setPreferredSize(new Dimension(300, 100));
        this.pixels = pix;
        Border border = BorderFactory.createEmptyBorder(pixels, pixels, pixels, pixels);
        this.setBorder(BorderFactory.createCompoundBorder(this.getBorder(), border));
        this.setLayout(new BorderLayout());
        
        /**
         * Above code is use to make drop shadow border
         */

        /////////////////////////////////////
        if (controlTransparent) {
            setBg(true);
        } else {
            setBg(false);
        }

    }

    @Override
    public synchronized void addMouseMotionListener(MouseMotionListener l) {
        super.addMouseMotionListener(l); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();
        Dimension arcs = new Dimension(curveRadius, curveRadius);

        GradientPaint gp = new GradientPaint(0, 0, colorAtBegin, focusAt, h, colorAtEnd);;

        // g2d.fillRect(0, 0, w, h);
        g2d.setPaint(gp);
        if (fillBackground == true) {
            g2d.fillRoundRect(0, 0, w - 1, h - 1, arcs.width, arcs.height);
        }

        g2d.drawRoundRect(0, 0, w - 1, h - 1, arcs.width, arcs.height);

        //g2d.dispose();


        /**
         * Following code is use to make drop shadow border
         */
        int shade = 0;
        int topOpacity = 80;
        for (int i = 0; i < pixels; i++) {
            g.setColor(new Color(shade, shade, shade, ((topOpacity / pixels) * i)));
            g.drawRect(i, i, this.getWidth() - ((i * 2) + 1), this.getHeight() - ((i * 2) + 1));
        }
    }

    private void setBg(boolean isOpaque) {
        Component[] components = this.getComponents();
        for (Component component : components) {

            ((JLabel) component).setOpaque(isOpaque);
            ((JCheckBox) component).setOpaque(isOpaque);
            ((JTextField) component).setOpaque(isOpaque);
            ((JPasswordField) component).setOpaque(isOpaque);
            ((JFormattedTextField) component).setOpaque(isOpaque);
            ((JToolBar) component).setOpaque(isOpaque);
            ((JRadioButton) component).setOpaque(isOpaque);

        }
    }

    
    
    
    
    
    public boolean isfillBackground() {
        return fillBackground;
    }

    public void setfillBackground(boolean fillBackground) {
        this.fillBackground = fillBackground;
    }

    public int getcurveRadius() {
        return curveRadius;
    }

    public void setcurveRadius(int curveRadius) {
        this.curveRadius = curveRadius;
    }

    public Color getcolorAtBegin() {
        return colorAtBegin;
    }

    public void setcolorAtBegin(Color colorAtBegin) {
        this.colorAtBegin = colorAtBegin;
    }

    public Color getcolorAtEnd() {
        return colorAtEnd;
    }

    public void setcolorAtEnd(Color colorAtEnd) {
        this.colorAtEnd = colorAtEnd;
    }

    public boolean iscontrolTransparent() {
        return controlTransparent;
    }

    public void setcontrolTransparent(boolean controlTransparent) {
        this.controlTransparent = controlTransparent;
    }

    public int getfocusAt() {
        return focusAt;
    }

    public void setfocusAt(int focusAt) {
        this.focusAt = focusAt;
    }

    public PanelHouse() {
        if (controlTransparent) {
            setBg(true);
        } else {
            setBg(false);
        }
    }
}
