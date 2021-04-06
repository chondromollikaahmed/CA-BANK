 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bank;

/**
 *
 * @author Chondromollika_Ahmed
 */



import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class AdminLogin {
    
    
   
    //for moving the frame 
    private int x,y ;
    // crating a frame 
    private JFrame logframe;
    // setting a image object for icon 
    
    private Image logo=new ImageIcon(AdminLogin.class.getResource("resources\\images\\ca-only.png")).getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);
    
    // setting a text field for username  
    
    private JTextField user;
    private JPasswordField pass;
    
    
    
    public AdminLogin()
    {
        loadWindow();
        logframe.setVisible(true);
    }
    
    
    
    private void loadWindow()
    {
           // setting the log frame 
                logframe = new JFrame();
		logframe.setBounds(100, 100, 700, 400);
		logframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		logframe.setUndecorated(true);
		logframe.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		logframe.getContentPane().setLayout(null);
		logframe.setLocationRelativeTo(null);
                
                 fadeFrame.JFrameFadeIn(0.0f, 1.0f, 0.005f, 10, logframe);
                
                
                
                
            //for adding a circle panel
            
            
            
            
              
            
            GradientPanel roundpane = new GradientPanel(Color.BLUE, Color.CYAN);
		roundpane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				logframe.setLocation(logframe.getX() + e.getX() - x, logframe.getY() + e.getY() - y);
			}
		});
		roundpane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				
			}
		});
                roundpane.setOpaque(false);
		roundpane.setBounds(0, 0, 400, 400);
		roundpane.setArc(roundpane.getWidth());
		roundpane.setBorderColor(Color.BLACK);
		roundpane.setBorderWidth(5);
		logframe.getContentPane().add(roundpane);
		roundpane.setLayout(null);
                
                
                
                
                
                
                
                
                JLabel jlogo = new JLabel("");
		jlogo.setIcon(new ImageIcon(logo));
		jlogo.setHorizontalAlignment(SwingConstants.CENTER);
		jlogo.setBounds(78, 100, 234, 160);
		roundpane.add(jlogo);
		
		JLabel cname = new JLabel("CA BANK");
		cname.setForeground(Color.WHITE);
		cname.setHorizontalAlignment(SwingConstants.CENTER);
		cname.setFont(new Font("Tahoma", Font.BOLD, 20));
		cname.setBounds(78, 242, 234, 36);
		roundpane.add(cname);
		
                
                
                
                
                
                
                
                
                
                
		JLabel motto = new JLabel("Manager");
		motto.setForeground(Color.WHITE);
		motto.setHorizontalAlignment(SwingConstants.CENTER);
		motto.setFont(new Font("Tahoma", Font.BOLD, 20));
		motto.setBounds(78, 290, 234, 36);
		roundpane.add(motto);
		
		GradientPanel container = new GradientPanel(Color.decode("#e65738"), Color.decode("#771d25"),GradientPanel.DIAGONAL_DOWN);
		container.setArc(10);
		container.setBorderColor(Color.white);
		container.setBorderWidth(2);
		container.setBounds(200, 50, 500, 300);
		logframe.getContentPane().add(container);
		container.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(229, 87, 250, 50);
		container.add(panel);
		panel.setLayout(null);
		
                
                
		user = new JTextField();
		user.setBackground(Color.WHITE);
		user.setBounds(10, 11, 230, 28);
		panel.add(user);
		user.setColumns(10);
		user.setBorder(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(229, 173, 250, 50);
		container.add(panel_1);
		
		pass = new JPasswordField();
		pass.setBounds(10, 11, 230, 28);
		panel_1.add(pass);
		pass.setBorder(null);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(229, 62, 250, 14);
		container.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(229, 148, 250, 14);
		container.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("LOGIN");
                btnNewButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                       if(user.getText().equals("ahmed")&&pass.getText().equals("chondromollika"))
                       {
                           JOptionPane.showMessageDialog(logframe, "Logged In Successfully.");
                            fadeFrame.JFrameFadeOut(1.0f,0.0f , 0.005f, 10, logframe, 2);
                            new Manager().setVisible(true);
                       }
                       else
                       {
                           JOptionPane.showMessageDialog(logframe, "username or password incorrect");
                       }
                    }
                });
		btnNewButton.setBounds(229, 234, 250, 43);
		container.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("LOGIN");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(229, 25, 115, 14);
		container.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("X");
		lblNewLabel_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure to close this application") == 0)
					System.exit(0);
			}
		});
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(469, 11, 21, 28);
		container.add(lblNewLabel_3_1);
                
                
               
		
		
    }
    
    public static void main(String[] args) {
        
        new AdminLogin();
    }
    
}
