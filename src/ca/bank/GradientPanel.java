package ca.bank;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class GradientPanel extends JPanel{
	
	public static int VERTICAL = 0;
	public static int HORIZONTAL = 1;
	public static int DIAGONAL_DOWN = 2;
	public static int DIAGONAL_UP = 3;
	
	private Color color1, color2;
	private int direction;
	private int shape;
	private int arc;
	private int borderWidth;
	private Color borderColor;
	
	public GradientPanel() {
		super();
		
		color1 = Color.gray;
		color2 = Color.white;
	}
	
	public GradientPanel(Color color1, Color color2) {
		super();
		this.color1 = color1;
		this.color2 = color2;
	}
	
	public GradientPanel(Color color1, Color color2, int direction) {
		super();
		this.color1 = color1;
		this.color2 = color2;
		this.direction = direction;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		
		GradientPaint gradientPaint;
		
		//Gradient Direction
		if(direction == HORIZONTAL)
			gradientPaint = new GradientPaint(0, getHeight() / 2, color1, getWidth(), getHeight() / 2, color2);
		else if(direction == DIAGONAL_DOWN)
			gradientPaint = new GradientPaint(0, getHeight(), color1, getWidth(), 0, color2);
		else if(direction == DIAGONAL_UP)
			gradientPaint = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
		else
			gradientPaint = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
		graphics2d.setPaint(gradientPaint);
		
		graphics2d.fillRoundRect(0, 0, getWidth(), getHeight(), arc,  arc);
		
		if(borderWidth > 0) {
			graphics2d.setStroke(new BasicStroke(borderWidth));
			graphics2d.setColor(borderColor);
			
			graphics2d.drawRoundRect(borderWidth/2, borderWidth/2, getWidth() - borderWidth/2, getHeight() - 1 - borderWidth/2, arc, arc);
		}
		
		setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		
	}

	public Color getColor1() {
		return color1;
	}
	public void setColor1(Color color1) {
		this.color1 = color1;
	}
	public Color getColor2() {
		return color2;
	}
	public void setColor2(Color color2) {
		this.color2 = color2;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public int getShape() {
		return shape;
	}
	public void setShape(int shape) {
		this.shape = shape;
	}
	public int getBorderWidth() {
		return borderWidth;
	}
	public void setBorderWidth(int borderWidth) {
		this.borderWidth = borderWidth;
	}
	public Color getBorderColor() {
		return borderColor;
	}
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}
	public int getArc() {
		return arc;
	}
	public void setArc(int arc) {
		this.arc = arc;
	}
	
	
	
	
	
	
}
