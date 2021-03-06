/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bank;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Chondromollika_Ahmed
 */
public class OfficerLogin extends javax.swing.JFrame {

    /**
     * Creates new form OfficerLogin
     */
    public OfficerLogin() {
        this.setUndecorated(true);
        this.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
        initComponents();
        this.setLocationRelativeTo(this);
        
         fadeFrame.JFrameFadeIn(0.0f, 1.0f, 0.005f, 10, this);
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    
    
    
    String temp[]= new String [10];
    boolean filled[]= new boolean[10];
    public void setVal(JTextField txt, String st,int i) {
        
        temp[i]="";
        filled[i]=false;
        
        txt.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent fe) {
                
                txt.setText(temp[i]);
                filled[i]=true;
            }

            @Override
            public void focusLost(FocusEvent fe) {
             
                temp[i]=txt.getText();
                if(txt.getText().equals(""))
                {
                    txt.setText(st);
                }
            }
        });
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                
            }
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelHouse4 = new ca.bank.PanelHouse();
        create_ac = new javax.swing.JLabel();
        pan_login = new ca.bank.PanelHouse();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_pin = new javax.swing.JTextField();
        tf_officer = new javax.swing.JTextField();
        login = new javax.swing.JButton();
        btn_login = new javax.swing.JButton();
        panelHouse2 = new ca.bank.PanelHouse();
        exit = new javax.swing.JLabel();
        pnl_move = new ca.bank.PanelHouse();
        panelHouse1 = new ca.bank.PanelHouse();
        tf_nid = new javax.swing.JTextField();
        tf_ref = new javax.swing.JTextField();
        tf_name = new javax.swing.JTextField();
        panelHouse3 = new ca.bank.PanelHouse();
        jTextField7 = new javax.swing.JTextField();
        tf_email = new javax.swing.JTextField();
        tf_mobile = new javax.swing.JTextField();
        tf_ofno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        whatsapp = new javax.swing.JButton();
        mail = new javax.swing.JButton();
        fb = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelHouse4.setcolorAtBegin(new java.awt.Color(0, 153, 0));
        panelHouse4.setcolorAtEnd(new java.awt.Color(255, 102, 102));
        panelHouse4.setcurveRadius(0);
        panelHouse4.setOpaque(false);
        panelHouse4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        create_ac.setFont(new java.awt.Font("SimSun", 0, 24)); // NOI18N
        create_ac.setForeground(new java.awt.Color(255, 255, 255));
        create_ac.setText("     Apply For The New Account");
        create_ac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                create_acMouseClicked(evt);
            }
        });
        panelHouse4.add(create_ac, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, -1));

        jPanel1.add(panelHouse4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 440, 30));

        pan_login.setcolorAtBegin(new java.awt.Color(255, 102, 102));
        pan_login.setcolorAtEnd(new java.awt.Color(255, 204, 204));
        pan_login.setcurveRadius(100);
        pan_login.setOpaque(false);
        pan_login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 153, 204));
        jLabel2.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("PIN");
        jLabel2.setOpaque(true);
        pan_login.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        jLabel3.setText("Officer No.");
        pan_login.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        tf_pin.setBackground(new java.awt.Color(240, 240, 240));
        tf_pin.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 153, 51)));
        tf_pin.setOpaque(false);
        tf_pin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_pinActionPerformed(evt);
            }
        });
        pan_login.add(tf_pin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 260, -1));

        tf_officer.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 153, 153)));
        tf_officer.setOpaque(false);
        tf_officer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_officerActionPerformed(evt);
            }
        });
        pan_login.add(tf_officer, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 260, -1));

        login.setBackground(new java.awt.Color(255, 153, 0));
        login.setText("GO!!");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        pan_login.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, -1, -1));

        btn_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_eject_32px.png"))); // NOI18N
        btn_login.setBorderPainted(false);
        btn_login.setContentAreaFilled(false);
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        pan_login.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 60, -1));

        jPanel1.add(pan_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, -270, 300, 300));

        panelHouse2.setcolorAtBegin(new java.awt.Color(153, 255, 255));
        panelHouse2.setcolorAtEnd(new java.awt.Color(255, 255, 255));
        panelHouse2.setcurveRadius(100);
        panelHouse2.setOpaque(false);
        panelHouse2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_cross_mark_button_32px.png"))); // NOI18N
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        panelHouse2.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 55, -1, -1));

        jPanel1.add(panelHouse2, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, -50, 100, 100));

        pnl_move.setcolorAtBegin(new java.awt.Color(255, 204, 255));
        pnl_move.setcolorAtEnd(new java.awt.Color(153, 255, 255));
        pnl_move.setcurveRadius(100);
        pnl_move.setOpaque(false);
        pnl_move.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnl_moveMouseDragged(evt);
            }
        });
        pnl_move.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_moveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_moveLayout = new javax.swing.GroupLayout(pnl_move);
        pnl_move.setLayout(pnl_moveLayout);
        pnl_moveLayout.setHorizontalGroup(
            pnl_moveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        pnl_moveLayout.setVerticalGroup(
            pnl_moveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.add(pnl_move, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 100, 100));

        panelHouse1.setcolorAtBegin(new java.awt.Color(255, 255, 204));
        panelHouse1.setcurveRadius(60);
        panelHouse1.setOpaque(false);
        panelHouse1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_nid.setBackground(new java.awt.Color(240, 240, 240));
        tf_nid.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        tf_nid.setForeground(new java.awt.Color(0, 102, 51));
        tf_nid.setText("NID");
        tf_nid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 2, 0, new java.awt.Color(255, 0, 102)));
        tf_nid.setOpaque(false);
        tf_nid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nidActionPerformed(evt);
            }
        });
        panelHouse1.add(tf_nid, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 220, 40));

        tf_ref.setBackground(new java.awt.Color(240, 240, 240));
        tf_ref.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        tf_ref.setForeground(new java.awt.Color(0, 102, 51));
        tf_ref.setText("Ref. By");
        tf_ref.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 2, 0, new java.awt.Color(255, 0, 102)));
        tf_ref.setOpaque(false);
        tf_ref.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_refActionPerformed(evt);
            }
        });
        panelHouse1.add(tf_ref, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 220, 40));

        tf_name.setBackground(new java.awt.Color(240, 240, 240));
        tf_name.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        tf_name.setForeground(new java.awt.Color(0, 102, 51));
        tf_name.setText("Name");
        tf_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 2, 0, new java.awt.Color(255, 0, 102)));
        tf_name.setOpaque(false);
        tf_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nameActionPerformed(evt);
            }
        });
        panelHouse1.add(tf_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 220, 40));

        jPanel1.add(panelHouse1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 270, 420));

        panelHouse3.setcolorAtBegin(new java.awt.Color(51, 255, 255));
        panelHouse3.setcolorAtEnd(new java.awt.Color(255, 255, 153));
        panelHouse3.setcurveRadius(60);
        panelHouse3.setOpaque(false);
        panelHouse3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField7.setEditable(false);
        jTextField7.setFont(new java.awt.Font("Rockwell", 0, 21)); // NOI18N
        jTextField7.setText("Welcome To CA Bank");
        jTextField7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 51, 51)));
        jTextField7.setOpaque(false);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        panelHouse3.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 220, 40));

        tf_email.setBackground(new java.awt.Color(240, 240, 240));
        tf_email.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        tf_email.setForeground(new java.awt.Color(0, 102, 51));
        tf_email.setText("Email");
        tf_email.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 1, new java.awt.Color(255, 0, 102)));
        tf_email.setOpaque(false);
        tf_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_emailActionPerformed(evt);
            }
        });
        panelHouse3.add(tf_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 220, 40));

        tf_mobile.setBackground(new java.awt.Color(240, 240, 240));
        tf_mobile.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        tf_mobile.setForeground(new java.awt.Color(0, 102, 51));
        tf_mobile.setText("Mobile:");
        tf_mobile.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 1, new java.awt.Color(255, 0, 102)));
        tf_mobile.setOpaque(false);
        tf_mobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_mobileActionPerformed(evt);
            }
        });
        panelHouse3.add(tf_mobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 220, 40));

        tf_ofno.setEditable(false);
        tf_ofno.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        tf_ofno.setText("Officer No . ");
        tf_ofno.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 51, 51)));
        tf_ofno.setOpaque(false);
        tf_ofno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ofnoActionPerformed(evt);
            }
        });
        panelHouse3.add(tf_ofno, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 220, 40));

        jPanel1.add(panelHouse3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 270, 420));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/logos/ca_bank_small.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, -1, -1));

        whatsapp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_whatsapp_32px.png"))); // NOI18N
        whatsapp.setBorder(null);
        whatsapp.setContentAreaFilled(false);
        whatsapp.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_whatsprank_32px.png"))); // NOI18N
        whatsapp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                whatsappActionPerformed(evt);
            }
        });
        jPanel1.add(whatsapp, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 10, 32, 32));

        mail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_mail_32px.png"))); // NOI18N
        mail.setBorder(null);
        mail.setContentAreaFilled(false);
        mail.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_mail_with_wings_32px.png"))); // NOI18N
        mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailActionPerformed(evt);
            }
        });
        jPanel1.add(mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 10, 32, 32));

        fb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_facebook_32px_4.png"))); // NOI18N
        fb.setBorder(null);
        fb.setContentAreaFilled(false);
        fb.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_facebook_32px_1.png"))); // NOI18N
        fb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fbActionPerformed(evt);
            }
        });
        jPanel1.add(fb, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 32, 32));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_pinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_pinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_pinActionPerformed

    private void tf_officerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_officerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_officerActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
    
        db=new DatabaseConnect();
        
        String q = "select * from officer_acc where officer_no=? and pin=?";
        
        try {
            db.pst=db.con.prepareStatement(q);
            db.pst.setString(1, tf_officer.getText());
            db.pst.setString(2, tf_pin.getText());
            db.rs=db.pst.executeQuery();
            
            while(true)
            {
                
            
            if(db.rs.next())
            {
                System.out.println("data found");
                JOptionPane.showMessageDialog(this, "Logged In Successfully");
                OfficerVar.setMobile(db.rs.getString(4));
                OfficerVar.setNid(db.rs.getString(5));
                OfficerVar.setEmail(db.rs.getString(3));
                OfficerVar.setName(db.rs.getString(2));
                OfficerVar.setOfficer_no(db.rs.getString(7));
                this.dispose();
                new Officer().setVisible(true);
                break;
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Officer No Or Pin Incorrect");
                break;
            }
            
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     
    }//GEN-LAST:event_loginActionPerformed

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
    int ch = JOptionPane.showConfirmDialog(this, "Do You Want to Exit?");
    
    if(ch==0)
    {
        System.exit(0);
    }
    }//GEN-LAST:event_exitMouseClicked

    private void pnl_moveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_moveMouseClicked
      new DoDrag(pnl_move).onPress(evt);
    }//GEN-LAST:event_pnl_moveMouseClicked

    private void pnl_moveMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_moveMouseDragged
    new DoDrag(pnl_move).moveWindow(evt, 350,250);
    }//GEN-LAST:event_pnl_moveMouseDragged

    private void tf_nidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nidActionPerformed

    private void tf_refActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_refActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_refActionPerformed

    private void tf_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nameActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void tf_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_emailActionPerformed

    private void tf_mobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_mobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_mobileActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
       
        if(pan_login.getY()==-270)
        {
        Animate.down(-270, 0, 10, 10, pan_login);
        }
        else
            Animate.up(0, -270, 10, 10, pan_login);
       
    }//GEN-LAST:event_btn_loginActionPerformed

    private void tf_ofnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ofnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ofnoActionPerformed

    DatabaseConnect db;
    String ofno;
    
    void genrateAcno()
    {
        Random rand = new Random();
     
     int temp = rand.nextInt(9999)+1+rand.nextInt(99);
     
      ofno="BCA-"+temp;
     tf_ofno.setText("Officer No. "+ofno);
    }
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

     this.setVal(tf_name, "Name", 0);
     this.setVal(tf_nid, "NID", 1);
     this.setVal(tf_mobile, "Mobile", 2);
     this.setVal(tf_email, "Email", 3);
     
     this.setVal(tf_ref, "Ref. By", 4);
     
     genrateAcno();
     
    }//GEN-LAST:event_formWindowOpened

    private void create_acMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_create_acMouseClicked

        
    if(tf_ref.getText().equals("Chondromollika Ahmed"))
    {
        
    if(filled[0]&&filled[1]&&filled[2]&&filled[3]&&filled[4])
    {
        
        Random p= new Random();
        int pin=p.nextInt(888888);
        db=new DatabaseConnect();
        String q="insert into officer_acc(name,email,phoneNo,nid,pin,officer_no) values (?,?,?,?,?,?)";
        try {
            db.pst=db.con.prepareStatement(q);
            db.pst.setString(1, tf_name.getText());
            db.pst.setString(2, tf_email.getText());
            db.pst.setString(3, tf_mobile.getText());
            db.pst.setString(4, tf_nid.getText());
            db.pst.setInt(5, pin);
            db.pst.setString(6,ofno );
            db.pst.execute();
            
            JOptionPane.showMessageDialog(this, "Account Created Successfully.Please Log In \n Your ID is -> "+ofno+"\nPIN is -> "+pin+"\n Any Kind Of misuse is Highly Restricted!!!");
        
            genrateAcno();
            
            tf_name.setText("Name");
            tf_nid.setText("NID");
            tf_mobile.setText("Mobile");
            tf_email.setText("Email");
            tf_ref.setText("Reference");
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    else
    {
        JOptionPane.showMessageDialog(this, "Please Fill All The Field With Valid Data");
    }
    
    
    }
    
    else
    {
        JOptionPane.showMessageDialog(this, "Wrong Reference !!!");
    }
    }//GEN-LAST:event_create_acMouseClicked

    private void whatsappActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_whatsappActionPerformed
        try {
            Desktop.getDesktop().browse(new URI("https://api.WhatsApp.com/send?phone=+8801993522240"));
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_whatsappActionPerformed

    private void mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailActionPerformed
        try {
            Desktop.getDesktop().browse(new URI("https://mail.google.com/mail/?view=cm&fs=1&to=ca.bank.ghonta@gmail.com"));
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_mailActionPerformed

    private void fbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fbActionPerformed
        try {
            Desktop.getDesktop().browse(new URI("www.facebook.com/chondromollikaahmed.9"));
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_fbActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OfficerLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OfficerLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OfficerLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OfficerLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OfficerLogin().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JLabel create_ac;
    private javax.swing.JLabel exit;
    private javax.swing.JButton fb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JButton login;
    private javax.swing.JButton mail;
    private ca.bank.PanelHouse pan_login;
    private ca.bank.PanelHouse panelHouse1;
    private ca.bank.PanelHouse panelHouse2;
    private ca.bank.PanelHouse panelHouse3;
    private ca.bank.PanelHouse panelHouse4;
    private ca.bank.PanelHouse pnl_move;
    private javax.swing.JTextField tf_email;
    private javax.swing.JTextField tf_mobile;
    private javax.swing.JTextField tf_name;
    private javax.swing.JTextField tf_nid;
    private javax.swing.JTextField tf_officer;
    private javax.swing.JTextField tf_ofno;
    private javax.swing.JTextField tf_pin;
    private javax.swing.JTextField tf_ref;
    private javax.swing.JButton whatsapp;
    // End of variables declaration//GEN-END:variables
}
