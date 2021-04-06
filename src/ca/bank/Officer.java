/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bank;

import Animacion.Animacion;

import com.opencsv.CSVWriter;
import function.Method;
import java.awt.Cursor;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import keeptoo.Drag;
import main.Main;

/**
 *
 * @author Chondromollika_Ahmed
 */
public class Officer extends javax.swing.JFrame {

    /**
     * Creates new form Client
     */
    
    DatabaseConnect db1;
    
    
    String tranid="";
    String queryacc="";
    String querytid="";
    double queryblance;
    
    String sendm_acc,sendm_to_acc;
         double sendm_amount;
    String send_user,recieve_user;
    
    public Officer() {
        
        this.setUndecorated(true);
        
        initComponents();
        
         fadeFrame.JFrameFadeIn(0.0f, 1.0f, 0.005f, 10, this);
        
        jPanel10.setVisible(false);
        
         table_tran.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent arg0) {

		boolean a = table_tran.isEditing();
		int index = table_tran.getSelectedRow();

		OfficerVar.setUser((String) table_tran.getValueAt(index, 5));
                System.out.println(table_tran.getValueAt(index, 5));
		
		jPanel10.setVisible(true);
                
                
                       
        
        
        db1=new DatabaseConnect();
        String query="select * from acc_info where username=?";
        try {
            db1.pst=db1.con.prepareStatement(query);
            db1.pst.setString(1, OfficerVar.getUser());
            db1.rs=db1.pst.executeQuery();
            
            if(db1.rs.next())
            {
                lbl_dashv_dob3.setText("DOB: "+db1.rs.getString(3));
                lbl_dashv_gender3.setText("Gender: "+db1.rs.getString(4));
                lbl_dashv_mobile3.setText("Number: "+db1.rs.getString(5));
                lbl_dashv_address3.setText("Address: "+db1.rs.getString(6));
                lbl_dashv_zip3.setText("Zip Code: "+db1.rs.getString(7));
                lbl_dashv_occu3.setText("Occupation: "+db1.rs.getString(8));
                lbl_dashv_marital3.setText("Marital Status: "+db1.rs.getString(9));
                lbl_dashv_country3.setText("Contry: "+db1.rs.getString(10));
                lbl_dashv_nid3.setText("NID: "+db1.rs.getString(11));
            }
            
            db1.pst=db1.con.prepareStatement("select * from signup where username=?");
            db1.pst.setString(1, OfficerVar.getUser());
            db1.rs=db1.pst.executeQuery();
            
            if(db1.rs.next())
                 {
                     lbl_dashv_fn3.setText("First Name:"+db1.rs.getString(2));
                     lbl_dashv_ln3.setText("Last Name:"+db1.rs.getString(3));
                 }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


	    }
	});
    
        
         
         
         tbl_addm.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent arg0) {

                
                Animate.move_XLeft(790, 290, 10, 10, pan_addm);
		boolean b = tbl_addm.isEditing();
		int ind = tbl_addm.getSelectedRow();

		
                 querytid=(String) tbl_addm.getValueAt(ind, 0);
                System.out.println(tbl_addm.getValueAt(ind, 1));
                queryacc=(String) tbl_addm.getValueAt(ind, 1);
                queryblance= (double) tbl_addm.getValueAt(ind, 2);
                
                
                String query="select * from add_money where trace_id=?";
                
                
                try {
                    db.pst=db.con.prepareStatement(query);
                    
                    db.pst.setString(1, querytid);
                    db.rs=db.pst.executeQuery();
                    
                    
                    if(db.rs.next())
                 {
                     addm_csv.setText("BRANCH:"+db.rs.getString(6));
                     addm_branch.setText("CSV:"+db.rs.getString(7));
                 }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
                 });
        
         
         
         
         //adding to the send money table
         
         
         
         tbl_sendm.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent arg0) {

                
                 Animate.move_XLeft(790, 340, 10, 10, pan_transfr);
		boolean b = tbl_sendm.isEditing();
		int ind = tbl_sendm.getSelectedRow();

		
                
                tranid=(String) tbl_sendm.getValueAt(ind, 0);
                sendm_acc=(String) tbl_sendm.getValueAt(ind, 1);
               
                sendm_to_acc=(String) tbl_sendm.getValueAt(ind, 3);
                sendm_amount= (double) tbl_sendm.getValueAt(ind, 2);
                
                
                String query="select username from signup where acc_no=?";
                
                
                try {
                    db.pst=db.con.prepareStatement(query);
                    
                    db.pst.setString(1, sendm_acc);
                    db.rs=db.pst.executeQuery();
                    
                    if(db.rs.next())
                 {
                    send_user=db.rs.getString("username");
                    sender.setText("SENDER USERNAME:"+db.rs.getString("username"));
                 }
                    
                    
                    query="select username from signup where acc_no=?";
                    
                    db.pst=db.con.prepareStatement(query);
                    
                    db.pst.setString(1, sendm_to_acc);
                    db.rs=db.pst.executeQuery();
                    
                    if(db.rs.next())
                 {
                     
                    recieve_user=db.rs.getString("username");
                    reciepent.setText("RECIEPENT USERNAME:"+db.rs.getString("username"));
                 }
                  
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
                 });
         
         
        this.setLocationRelativeTo(this);
        separ.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        edit2 = new keeptoo.KButton();
        menu_panel = new keeptoo.KGradientPanel();
        btn_tran = new javax.swing.JButton();
        btn_chat = new javax.swing.JButton();
        btn_transfr = new javax.swing.JButton();
        btn_dash = new javax.swing.JButton();
        lbl_dash = new javax.swing.JLabel();
        lbl_tran = new javax.swing.JLabel();
        lbl_transfr = new javax.swing.JLabel();
        lbl_chat = new javax.swing.JLabel();
        info = new javax.swing.JLabel();
        tran = new javax.swing.JLabel();
        transfr = new javax.swing.JLabel();
        chat = new javax.swing.JLabel();
        dash = new javax.swing.JLabel();
        separ = new javax.swing.JSeparator();
        info6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        menu = new javax.swing.JButton();
        flower = new javax.swing.JLabel();
        line_dash = new javax.swing.JLabel();
        line_chat = new javax.swing.JLabel();
        line_transfr = new javax.swing.JLabel();
        line_tran = new javax.swing.JLabel();
        lbl_dash_bg = new javax.swing.JLabel();
        lbl_tran_bg = new javax.swing.JLabel();
        lbl_transfr_bg = new javax.swing.JLabel();
        lbl_chat_bg = new javax.swing.JLabel();
        ASSIGN = new javax.swing.JLabel();
        combined_panel = new javax.swing.JPanel();
        pnl_addm = new javax.swing.JPanel();
        pnl_chat = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pnl_assignCC = new javax.swing.JPanel();
        panelHouse1 = new ca.bank.PanelHouse();
        cc_combo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        assignCheck = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        check_br = new javax.swing.JComboBox<>();
        cc_checkNo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        check_assign = new javax.swing.JTextField();
        assignCard = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        card_assign = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        card_csv = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        card_no = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        Acard = new javax.swing.JButton();
        assignLogo = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        pnl_req_appvr = new javax.swing.JPanel();
        kGradientPanel1 = new ca.bank.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_sendm = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_addm = new javax.swing.JTable();
        pan_addm = new javax.swing.JPanel();
        addm_approve = new javax.swing.JButton();
        addm_csv = new javax.swing.JLabel();
        addm_branch = new javax.swing.JLabel();
        pan_transfr = new ca.bank.KGradientPanel();
        reciepent = new javax.swing.JLabel();
        sender = new javax.swing.JLabel();
        transfr_approve = new javax.swing.JButton();
        pnl_dash = new javax.swing.JPanel();
        layer_pane_pp = new javax.swing.JLayeredPane();
        border = new javax.swing.JLabel();
        profile = new javax.swing.JLabel();
        pan_dash_profile_bg = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_dash_ofNo = new javax.swing.JLabel();
        lbl_dash_number = new javax.swing.JLabel();
        lbl_dash_email = new javax.swing.JLabel();
        lbl_dash_name = new javax.swing.JLabel();
        pnl_dash_dashboard = new javax.swing.JPanel();
        pnl_dash_showInfoButton = new ca.bank.KGradientPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        pnl_dash_userinfo_edit = new javax.swing.JPanel();
        lbl_dashv_dob1 = new javax.swing.JLabel();
        lbl_dashv_gender1 = new javax.swing.JLabel();
        lbl_dashv_mobile1 = new javax.swing.JLabel();
        lbl_dashv_address1 = new javax.swing.JLabel();
        lbl_dashv_zip1 = new javax.swing.JLabel();
        lbl_dashv_occu1 = new javax.swing.JLabel();
        lbl_dashv_marital1 = new javax.swing.JLabel();
        lbl_dashv_country1 = new javax.swing.JLabel();
        lbl_dashv_nid1 = new javax.swing.JLabel();
        kGradientPanel20 = new ca.bank.KGradientPanel();
        jLabel27 = new javax.swing.JLabel();
        pnl_dash_returnbutton1 = new ca.bank.KGradientPanel();
        jLabel28 = new javax.swing.JLabel();
        pan_layer_nid1 = new javax.swing.JPanel();
        lbl_nid1 = new javax.swing.JLabel();
        pnl_dash_saveInfoButton = new ca.bank.KGradientPanel();
        jLabel29 = new javax.swing.JLabel();
        tf_edit_zip = new javax.swing.JTextField();
        tf_edit_addr = new javax.swing.JTextField();
        tf_edit_num = new javax.swing.JTextField();
        tf_edit_nid = new javax.swing.JTextField();
        cb_unmarried = new javax.swing.JCheckBox();
        cb_married = new javax.swing.JCheckBox();
        combo_country = new javax.swing.JComboBox<>();
        combo_gender = new javax.swing.JComboBox<>();
        combo_occu = new javax.swing.JComboBox<>();
        dob = new com.toedter.calendar.JDateChooser();
        jPanel7 = new javax.swing.JPanel();
        pnl_dash_userinfo = new javax.swing.JPanel();
        lbl_dashv_dob = new javax.swing.JLabel();
        lbl_dashv_gender = new javax.swing.JLabel();
        lbl_dashv_mobile = new javax.swing.JLabel();
        lbl_dashv_address = new javax.swing.JLabel();
        lbl_dashv_zip = new javax.swing.JLabel();
        lbl_dashv_occu = new javax.swing.JLabel();
        lbl_dashv_marital = new javax.swing.JLabel();
        lbl_dashv_country = new javax.swing.JLabel();
        lbl_dashv_nid = new javax.swing.JLabel();
        kGradientPanel19 = new ca.bank.KGradientPanel();
        jLabel24 = new javax.swing.JLabel();
        pnl_dash_returnbutton = new ca.bank.KGradientPanel();
        jLabel23 = new javax.swing.JLabel();
        pan_layer_nid = new javax.swing.JPanel();
        lbl_nid = new javax.swing.JLabel();
        pnl_dash_editInfoButton = new ca.bank.KGradientPanel();
        jLabel25 = new javax.swing.JLabel();
        layer_pane_bg = new javax.swing.JLayeredPane();
        lb_dash_bg = new javax.swing.JLabel();
        pnl_tran = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        pnl_dash_userinfo1 = new javax.swing.JPanel();
        lbl_dashv_ln3 = new javax.swing.JLabel();
        lbl_dashv_dob3 = new javax.swing.JLabel();
        lbl_dashv_gender3 = new javax.swing.JLabel();
        lbl_dashv_mobile3 = new javax.swing.JLabel();
        lbl_dashv_address3 = new javax.swing.JLabel();
        lbl_dashv_zip3 = new javax.swing.JLabel();
        lbl_dashv_occu3 = new javax.swing.JLabel();
        lbl_dashv_marital3 = new javax.swing.JLabel();
        lbl_dashv_country3 = new javax.swing.JLabel();
        lbl_dashv_fn3 = new javax.swing.JLabel();
        lbl_dashv_nid3 = new javax.swing.JLabel();
        pan_layer_nid3 = new javax.swing.JPanel();
        lbl_nid3 = new javax.swing.JLabel();
        pnl_dash_editInfoButton1 = new ca.bank.KGradientPanel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_tran = new javax.swing.JTable();
        btn_user_tran_csv = new javax.swing.JButton();
        bg_panel = new javax.swing.JPanel();
        header = new keeptoo.KGradientPanel();
        exit = new javax.swing.JButton();
        min = new javax.swing.JButton();
        max = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ca_rotate = new javax.swing.JPanel();
        ca_r_l = new javax.swing.JLabel();
        sign_out = new javax.swing.JButton();
        change_background = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        edit2.setBackground(new java.awt.Color(51, 255, 0));
        edit2.setBorder(null);
        edit2.setForeground(new java.awt.Color(51, 102, 0));
        edit2.setText("Edit Profile");
        edit2.setBorderPainted(false);
        edit2.setFocusable(false);
        edit2.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        edit2.setkBackGroundColor(new java.awt.Color(255, 255, 255));
        edit2.setkBorderRadius(35);
        edit2.setkEndColor(new java.awt.Color(255, 204, 255));
        edit2.setkFillButton(false);
        edit2.setkForeGround(new java.awt.Color(51, 51, 51));
        edit2.setkHoverForeGround(new java.awt.Color(0, 255, 255));
        edit2.setkHoverStartColor(new java.awt.Color(204, 204, 204));
        edit2.setkIndicatorThickness(10);
        edit2.setkPressedColor(new java.awt.Color(255, 102, 102));
        edit2.setkSelectedColor(new java.awt.Color(0, 255, 0));
        edit2.setkStartColor(new java.awt.Color(0, 255, 255));
        edit2.setMargin(new java.awt.Insets(4, 4, 4, 4));
        edit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu_panel.setkEndColor(new java.awt.Color(255, 153, 153));
        menu_panel.setkGradientFocus(200);
        menu_panel.setkStartColor(new java.awt.Color(102, 255, 153));
        menu_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_tran.setForeground(new java.awt.Color(255, 255, 255));
        btn_tran.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_transaction_list_64px.png"))); // NOI18N
        btn_tran.setBorder(null);
        btn_tran.setBorderPainted(false);
        btn_tran.setContentAreaFilled(false);
        btn_tran.setFocusPainted(false);
        btn_tran.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_transaction_list_64px_1.png"))); // NOI18N
        btn_tran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tranMouseClicked(evt);
            }
        });
        btn_tran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tranActionPerformed(evt);
            }
        });
        menu_panel.add(btn_tran, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 60, 60));

        btn_chat.setForeground(new java.awt.Color(255, 255, 255));
        btn_chat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_chat_64px.png"))); // NOI18N
        btn_chat.setBorder(null);
        btn_chat.setBorderPainted(false);
        btn_chat.setContentAreaFilled(false);
        btn_chat.setFocusPainted(false);
        btn_chat.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_chat_64px_1.png"))); // NOI18N
        btn_chat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_chatMouseClicked(evt);
            }
        });
        btn_chat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chatActionPerformed(evt);
            }
        });
        menu_panel.add(btn_chat, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, 60, 60));

        btn_transfr.setForeground(new java.awt.Color(255, 255, 255));
        btn_transfr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_initiate_money_transfer_64px.png"))); // NOI18N
        btn_transfr.setBorder(null);
        btn_transfr.setBorderPainted(false);
        btn_transfr.setContentAreaFilled(false);
        btn_transfr.setFocusPainted(false);
        btn_transfr.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_initiate_money_transfer_64px_1.png"))); // NOI18N
        btn_transfr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_transfrMouseClicked(evt);
            }
        });
        btn_transfr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transfrActionPerformed(evt);
            }
        });
        menu_panel.add(btn_transfr, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 60, 60));

        btn_dash.setForeground(new java.awt.Color(255, 255, 255));
        btn_dash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_content_64px.png"))); // NOI18N
        btn_dash.setBorder(null);
        btn_dash.setBorderPainted(false);
        btn_dash.setContentAreaFilled(false);
        btn_dash.setFocusPainted(false);
        btn_dash.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_content_64px_1.png"))); // NOI18N
        btn_dash.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_content_64px_1.png"))); // NOI18N
        btn_dash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_dashMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_dashMouseClicked(evt);
            }
        });
        btn_dash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dashActionPerformed(evt);
            }
        });
        menu_panel.add(btn_dash, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 60, 60));

        lbl_dash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_dashMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_dashMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_dashMouseExited(evt);
            }
        });
        menu_panel.add(lbl_dash, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 123, 244, 60));

        lbl_tran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_tranMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_tranMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_tranMouseExited(evt);
            }
        });
        menu_panel.add(lbl_tran, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 193, 244, 60));

        lbl_transfr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_transfrMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_transfrMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_transfrMouseExited(evt);
            }
        });
        menu_panel.add(lbl_transfr, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 333, 244, 60));

        lbl_chat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_chatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_chatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_chatMouseExited(evt);
            }
        });
        menu_panel.add(lbl_chat, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 493, 244, 60));

        info.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/logos/ca_bank_small.png"))); // NOI18N
        menu_panel.add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 572, -1, -1));

        tran.setFont(new java.awt.Font("Segoe Script", 0, 28)); // NOI18N
        tran.setForeground(new java.awt.Color(51, 0, 51));
        tran.setText("Transection");
        menu_panel.add(tran, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        transfr.setFont(new java.awt.Font("Segoe Script", 0, 18)); // NOI18N
        transfr.setForeground(new java.awt.Color(51, 0, 51));
        transfr.setText("Request Appruval");
        menu_panel.add(transfr, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        chat.setFont(new java.awt.Font("Segoe Script", 0, 28)); // NOI18N
        chat.setForeground(new java.awt.Color(51, 0, 51));
        chat.setText("Chat");
        menu_panel.add(chat, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));

        dash.setFont(new java.awt.Font("Segoe Script", 0, 28)); // NOI18N
        dash.setForeground(new java.awt.Color(51, 0, 51));
        dash.setText("Dashboard");
        menu_panel.add(dash, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        separ.setForeground(new java.awt.Color(0, 153, 255));
        separ.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        separ.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        separ.setOpaque(true);
        menu_panel.add(separ, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 220, 10));

        info6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_about_me_female_64px.png"))); // NOI18N
        info6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                info6MouseClicked(evt);
            }
        });
        menu_panel.add(info6, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 575, -1, -1));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        menu_panel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 640));

        menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_sidebar_menu_45px_1.png"))); // NOI18N
        menu.setBorder(null);
        menu.setContentAreaFilled(false);
        menu.setFocusPainted(false);
        menu.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_sidebar_menu_45px.png"))); // NOI18N
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });
        menu_panel.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 40, 40));

        flower.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_bank_127px.png"))); // NOI18N
        menu_panel.add(flower, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        line_dash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_horizontal_line_127px_1.png"))); // NOI18N
        menu_panel.add(line_dash, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 162, 120, 20));

        line_chat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_horizontal_line_127px_1.png"))); // NOI18N
        menu_panel.add(line_chat, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 532, 120, 20));

        line_transfr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_horizontal_line_127px_1.png"))); // NOI18N
        menu_panel.add(line_transfr, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 372, 120, 20));

        line_tran.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_horizontal_line_127px_1.png"))); // NOI18N
        menu_panel.add(line_tran, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 232, 120, 20));

        lbl_dash_bg.setBackground(new java.awt.Color(204, 255, 255));
        lbl_dash_bg.setOpaque(true);
        lbl_dash_bg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_dash_bgMouseClicked(evt);
            }
        });
        menu_panel.add(lbl_dash_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 123, 244, 60));

        lbl_tran_bg.setBackground(new java.awt.Color(204, 255, 255));
        lbl_tran_bg.setOpaque(true);
        lbl_tran_bg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_tran_bgMouseClicked(evt);
            }
        });
        menu_panel.add(lbl_tran_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 193, 244, 60));

        lbl_transfr_bg.setBackground(new java.awt.Color(204, 255, 255));
        lbl_transfr_bg.setOpaque(true);
        lbl_transfr_bg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_transfr_bgMouseClicked(evt);
            }
        });
        menu_panel.add(lbl_transfr_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 333, 244, 60));

        lbl_chat_bg.setBackground(new java.awt.Color(204, 255, 255));
        lbl_chat_bg.setOpaque(true);
        lbl_chat_bg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_chat_bgMouseClicked(evt);
            }
        });
        menu_panel.add(lbl_chat_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 493, 244, 60));

        ASSIGN.setFont(new java.awt.Font("Rockwell", 0, 28)); // NOI18N
        ASSIGN.setText("Assign Card/Cash");
        ASSIGN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ASSIGNMouseClicked(evt);
            }
        });
        menu_panel.add(ASSIGN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));

        getContentPane().add(menu_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 640));

        combined_panel.setLayout(new java.awt.CardLayout());

        pnl_addm.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_addmLayout = new javax.swing.GroupLayout(pnl_addm);
        pnl_addm.setLayout(pnl_addmLayout);
        pnl_addmLayout.setHorizontalGroup(
            pnl_addmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );
        pnl_addmLayout.setVerticalGroup(
            pnl_addmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        combined_panel.add(pnl_addm, "card2");

        pnl_chat.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jLabel3.setText("chat");

        javax.swing.GroupLayout pnl_chatLayout = new javax.swing.GroupLayout(pnl_chat);
        pnl_chat.setLayout(pnl_chatLayout);
        pnl_chatLayout.setHorizontalGroup(
            pnl_chatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_chatLayout.createSequentialGroup()
                .addGap(491, 491, 491)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_chatLayout.setVerticalGroup(
            pnl_chatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_chatLayout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        combined_panel.add(pnl_chat, "card3");

        pnl_assignCC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelHouse1.setcolorAtBegin(new java.awt.Color(255, 204, 204));
        panelHouse1.setcolorAtEnd(new java.awt.Color(204, 255, 255));
        panelHouse1.setfocusAt(700);
        panelHouse1.setOpaque(false);
        panelHouse1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cc_combo.setBackground(new java.awt.Color(240, 240, 240));
        cc_combo.setFont(new java.awt.Font("SimSun", 0, 24)); // NOI18N
        cc_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CARD", "CHECK" }));
        cc_combo.setOpaque(false);
        cc_combo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cc_comboFocusLost(evt);
            }
        });
        cc_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cc_comboActionPerformed(evt);
            }
        });
        panelHouse1.add(cc_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 190, -1));

        jLabel8.setFont(new java.awt.Font("Rockwell", 0, 48)); // NOI18N
        jLabel8.setText("ASSIGN CARD/CASH");
        jLabel8.setBorder(new javax.swing.border.MatteBorder(null));
        panelHouse1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 470, -1));

        assignCheck.setOpaque(false);
        assignCheck.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        jLabel9.setText("Branch :");
        assignCheck.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel10.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        jLabel10.setText("Assigned TO :");
        assignCheck.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel11.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        jLabel11.setText("Check NO :");
        assignCheck.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        check_br.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dhaka", "Comilla", "Online" }));
        assignCheck.add(check_br, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, -1));

        cc_checkNo.setEditable(false);
        cc_checkNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cc_checkNoActionPerformed(evt);
            }
        });
        assignCheck.add(cc_checkNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 270, -1));

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setText("Generate Number");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        assignCheck.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 102, 102));
        jButton2.setText("Assign!");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        assignCheck.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, -1, -1));

        check_assign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_assignActionPerformed(evt);
            }
        });
        assignCheck.add(check_assign, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 200, -1));

        panelHouse1.add(assignCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 770, 350));

        assignCard.setOpaque(false);
        assignCard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        jLabel13.setText("CSV :");
        assignCard.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));
        assignCard.add(card_assign, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 170, -1));

        jLabel14.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        jLabel14.setText("Card NO :");
        assignCard.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        card_csv.setEditable(false);
        card_csv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                card_csvActionPerformed(evt);
            }
        });
        assignCard.add(card_csv, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 210, -1));

        jButton3.setBackground(new java.awt.Color(0, 153, 0));
        jButton3.setText("Generate CSV");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        assignCard.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, -1, -1));

        jLabel15.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        jLabel15.setText("Assigned TO :");
        assignCard.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        card_no.setEditable(false);
        card_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                card_noActionPerformed(evt);
            }
        });
        assignCard.add(card_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 270, -1));

        jButton4.setBackground(new java.awt.Color(0, 153, 0));
        jButton4.setText("Generate Number");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        assignCard.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, -1, -1));

        Acard.setBackground(new java.awt.Color(255, 102, 102));
        Acard.setText("Assign!");
        Acard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcardActionPerformed(evt);
            }
        });
        assignCard.add(Acard, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, -1, -1));

        panelHouse1.add(assignCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 770, 350));

        assignLogo.setOpaque(false);
        assignLogo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/logos/ca-only.png"))); // NOI18N
        assignLogo.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 390, 320));

        panelHouse1.add(assignLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 770, 350));

        pnl_assignCC.add(panelHouse1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 560));

        combined_panel.add(pnl_assignCC, "card4");

        pnl_req_appvr.setOpaque(false);
        pnl_req_appvr.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setkBorderRadius(60);
        kGradientPanel1.setkEndColor(new java.awt.Color(153, 255, 255));
        kGradientPanel1.setkGradientFocus(700);
        kGradientPanel1.setkStartColor(new java.awt.Color(204, 255, 255));
        kGradientPanel1.setOpaque(false);
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        jLabel1.setText("Add Money ");
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        jLabel12.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        jLabel12.setText("Transfer Money");
        kGradientPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jScrollPane2.setBorder(null);

        tbl_sendm.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        tbl_sendm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TRID", "From Acc.", "Amount", "To Acc", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_sendm.setGridColor(new java.awt.Color(0, 204, 204));
        tbl_sendm.setRowHeight(25);
        tbl_sendm.setSelectionBackground(new java.awt.Color(204, 255, 255));
        tbl_sendm.setSelectionForeground(new java.awt.Color(255, 102, 102));
        jScrollPane2.setViewportView(tbl_sendm);
        if (tbl_sendm.getColumnModel().getColumnCount() > 0) {
            tbl_sendm.getColumnModel().getColumn(0).setResizable(false);
            tbl_sendm.getColumnModel().getColumn(4).setResizable(false);
        }

        kGradientPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 780, 180));

        jScrollPane3.setBorder(null);
        jScrollPane3.setOpaque(false);

        tbl_addm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TID", "Acc NO", "Amount", "TYPE", "Credential", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_addm.setRowHeight(25);
        jScrollPane3.setViewportView(tbl_addm);

        kGradientPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 770, 180));

        pan_addm.setBackground(new java.awt.Color(255, 204, 204));
        pan_addm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addm_approve.setText("Approve");
        addm_approve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addm_approveActionPerformed(evt);
            }
        });
        pan_addm.add(addm_approve, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, -1));

        addm_csv.setText("CSV:");
        pan_addm.add(addm_csv, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        addm_branch.setText("Branch:");
        pan_addm.add(addm_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        kGradientPanel1.add(pan_addm, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 270, 490, 80));

        pan_transfr.setkBorderRadius(30);
        pan_transfr.setkEndColor(new java.awt.Color(102, 255, 255));
        pan_transfr.setkStartColor(new java.awt.Color(0, 204, 0));
        pan_transfr.setOpaque(false);
        pan_transfr.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reciepent.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        reciepent.setText("Reciepent USERNAME:");
        pan_transfr.add(reciepent, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        sender.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        sender.setText("SENDER USERNAME:");
        pan_transfr.add(sender, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        transfr_approve.setText("Approve");
        transfr_approve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transfr_approveActionPerformed(evt);
            }
        });
        pan_transfr.add(transfr_approve, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        kGradientPanel1.add(pan_transfr, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, 440, 65));

        pnl_req_appvr.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 805, 565));

        combined_panel.add(pnl_req_appvr, "card5");

        pnl_dash.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        layer_pane_pp.setLayout(new javax.swing.OverlayLayout(layer_pane_pp));

        border.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        border.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/images/border.png"))); // NOI18N
        border.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        border.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        border.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borderMouseClicked(evt);
            }
        });
        layer_pane_pp.add(border);

        profile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/images/profile.png"))); // NOI18N
        layer_pane_pp.add(profile);

        pnl_dash.add(layer_pane_pp, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, -1, -1));

        pan_dash_profile_bg.setBackground(new java.awt.Color(255, 255, 255));
        pan_dash_profile_bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Rockwell", 0, 28)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Mobile:");
        pan_dash_profile_bg.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 22, -1, -1));

        jLabel6.setFont(new java.awt.Font("Rockwell", 0, 28)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Off. NO:");
        pan_dash_profile_bg.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 60, -1, -1));

        lbl_dash_ofNo.setFont(new java.awt.Font("Perpetua", 0, 28)); // NOI18N
        lbl_dash_ofNo.setForeground(new java.awt.Color(153, 153, 153));
        lbl_dash_ofNo.setText("ABCDEFGH");
        pan_dash_profile_bg.add(lbl_dash_ofNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 65, -1, -1));

        lbl_dash_number.setFont(new java.awt.Font("Perpetua", 0, 28)); // NOI18N
        lbl_dash_number.setForeground(new java.awt.Color(204, 204, 204));
        lbl_dash_number.setText("01993522240");
        pan_dash_profile_bg.add(lbl_dash_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        lbl_dash_email.setFont(new java.awt.Font("Papyrus", 0, 21)); // NOI18N
        lbl_dash_email.setForeground(new java.awt.Color(0, 102, 0));
        lbl_dash_email.setText("chondromollika.ahmed@gmail.com");
        pan_dash_profile_bg.add(lbl_dash_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, -1));

        lbl_dash_name.setFont(new java.awt.Font("Castellar", 0, 28)); // NOI18N
        lbl_dash_name.setForeground(new java.awt.Color(0, 204, 255));
        lbl_dash_name.setText("Chondromollika ");
        pan_dash_profile_bg.add(lbl_dash_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, -1));

        pnl_dash.add(pan_dash_profile_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 120));

        pnl_dash_dashboard.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pnl_dash_dashboard.setOpaque(false);
        pnl_dash_dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_dash_showInfoButton.setkBorderRadius(20);
        pnl_dash_showInfoButton.setkEndColor(new java.awt.Color(255, 153, 102));
        pnl_dash_showInfoButton.setkStartColor(new java.awt.Color(255, 0, 102));
        pnl_dash_showInfoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_dash_showInfoButtonMouseClicked(evt);
            }
        });
        pnl_dash_showInfoButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Rockwell Condensed", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_dollar_euro_exchange_40px.png"))); // NOI18N
        jLabel26.setText("View Information");
        pnl_dash_showInfoButton.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));

        pnl_dash_dashboard.add(pnl_dash_showInfoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 510, 150, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/logos/ca-only.png"))); // NOI18N
        pnl_dash_dashboard.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, -1, -1));

        pnl_dash.add(pnl_dash_dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 570));

        jPanel8.setOpaque(false);
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_dash_userinfo_edit.setOpaque(false);
        pnl_dash_userinfo_edit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_dashv_dob1.setFont(new java.awt.Font("Sylfaen", 0, 21)); // NOI18N
        lbl_dashv_dob1.setText("Date Of Birth:");
        pnl_dash_userinfo_edit.add(lbl_dashv_dob1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 150, -1, -1));

        lbl_dashv_gender1.setFont(new java.awt.Font("Sylfaen", 0, 21)); // NOI18N
        lbl_dashv_gender1.setText("Gender:");
        pnl_dash_userinfo_edit.add(lbl_dashv_gender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 190, -1, -1));

        lbl_dashv_mobile1.setFont(new java.awt.Font("Sylfaen", 0, 21)); // NOI18N
        lbl_dashv_mobile1.setText("Mobile:");
        pnl_dash_userinfo_edit.add(lbl_dashv_mobile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 230, -1, -1));

        lbl_dashv_address1.setFont(new java.awt.Font("Sylfaen", 0, 21)); // NOI18N
        lbl_dashv_address1.setText("Adress:");
        pnl_dash_userinfo_edit.add(lbl_dashv_address1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 270, -1, -1));

        lbl_dashv_zip1.setFont(new java.awt.Font("Sylfaen", 0, 21)); // NOI18N
        lbl_dashv_zip1.setText("Zip Code:");
        pnl_dash_userinfo_edit.add(lbl_dashv_zip1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 310, -1, -1));

        lbl_dashv_occu1.setFont(new java.awt.Font("Sylfaen", 0, 21)); // NOI18N
        lbl_dashv_occu1.setText("Occupation:");
        pnl_dash_userinfo_edit.add(lbl_dashv_occu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, -1, -1));

        lbl_dashv_marital1.setFont(new java.awt.Font("Sylfaen", 0, 21)); // NOI18N
        lbl_dashv_marital1.setText("Marital Status:");
        pnl_dash_userinfo_edit.add(lbl_dashv_marital1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, -1, -1));

        lbl_dashv_country1.setFont(new java.awt.Font("Sylfaen", 0, 21)); // NOI18N
        lbl_dashv_country1.setText("Country:");
        pnl_dash_userinfo_edit.add(lbl_dashv_country1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, -1, -1));

        lbl_dashv_nid1.setFont(new java.awt.Font("Sylfaen", 0, 21)); // NOI18N
        lbl_dashv_nid1.setText("NID :");
        pnl_dash_userinfo_edit.add(lbl_dashv_nid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, -1, -1));

        kGradientPanel20.setToolTipText("return to dashboard");
        kGradientPanel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        kGradientPanel20.setkBorderRadius(20);
        kGradientPanel20.setkEndColor(new java.awt.Color(153, 204, 255));
        kGradientPanel20.setkStartColor(new java.awt.Color(0, 153, 153));
        kGradientPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Script MT Bold", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_dollar_euro_exchange_40px.png"))); // NOI18N
        jLabel27.setText("ADD");
        kGradientPanel20.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));

        pnl_dash_userinfo_edit.add(kGradientPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 370, 100, 50));

        pnl_dash_returnbutton1.setToolTipText("return to dashboard");
        pnl_dash_returnbutton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pnl_dash_returnbutton1.setkBorderRadius(20);
        pnl_dash_returnbutton1.setkEndColor(new java.awt.Color(153, 204, 255));
        pnl_dash_returnbutton1.setkStartColor(new java.awt.Color(51, 51, 51));
        pnl_dash_returnbutton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_dash_returnbutton1MouseClicked(evt);
            }
        });
        pnl_dash_returnbutton1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Script MT Bold", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_dollar_euro_exchange_40px.png"))); // NOI18N
        jLabel28.setText("Cancel Edit");
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });
        pnl_dash_returnbutton1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));

        pnl_dash_userinfo_edit.add(pnl_dash_returnbutton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 140, 50));

        pan_layer_nid1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pan_layer_nid1.setOpaque(false);
        pan_layer_nid1.setLayout(new javax.swing.OverlayLayout(pan_layer_nid1));

        lbl_nid1.setBorder(new javax.swing.border.MatteBorder(null));
        lbl_nid1.setPreferredSize(new java.awt.Dimension(130, 130));
        pan_layer_nid1.add(lbl_nid1);

        pnl_dash_userinfo_edit.add(pan_layer_nid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 130, 130));

        pnl_dash_saveInfoButton.setToolTipText("return to dashboard");
        pnl_dash_saveInfoButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pnl_dash_saveInfoButton.setkBorderRadius(20);
        pnl_dash_saveInfoButton.setkEndColor(new java.awt.Color(153, 204, 255));
        pnl_dash_saveInfoButton.setkStartColor(new java.awt.Color(102, 204, 0));
        pnl_dash_saveInfoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_dash_saveInfoButtonMouseClicked(evt);
            }
        });
        pnl_dash_saveInfoButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Script MT Bold", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_dollar_euro_exchange_40px.png"))); // NOI18N
        jLabel29.setText("Save");
        pnl_dash_saveInfoButton.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));

        pnl_dash_userinfo_edit.add(pnl_dash_saveInfoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 100, 50));

        tf_edit_zip.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        tf_edit_zip.setText("Zip Code");
        pnl_dash_userinfo_edit.add(tf_edit_zip, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 170, -1));

        tf_edit_addr.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        tf_edit_addr.setText("Address");
        tf_edit_addr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_edit_addrActionPerformed(evt);
            }
        });
        pnl_dash_userinfo_edit.add(tf_edit_addr, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 170, -1));

        tf_edit_num.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        tf_edit_num.setText("01993522240");
        pnl_dash_userinfo_edit.add(tf_edit_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 170, -1));

        tf_edit_nid.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        tf_edit_nid.setText("ID Number");
        tf_edit_nid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_edit_nidActionPerformed(evt);
            }
        });
        pnl_dash_userinfo_edit.add(tf_edit_nid, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 250, -1));

        cb_unmarried.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        cb_unmarried.setText("Unmarried");
        cb_unmarried.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_unmarriedActionPerformed(evt);
            }
        });
        pnl_dash_userinfo_edit.add(cb_unmarried, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, 130, 30));

        cb_married.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        cb_married.setText("Married");
        cb_married.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_marriedActionPerformed(evt);
            }
        });
        pnl_dash_userinfo_edit.add(cb_married, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, 110, 30));

        combo_country.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        combo_country.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bangladesh" }));
        combo_country.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_countryActionPerformed(evt);
            }
        });
        pnl_dash_userinfo_edit.add(combo_country, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, -1, -1));

        combo_gender.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        combo_gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));
        pnl_dash_userinfo_edit.add(combo_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, -1));

        combo_occu.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        combo_occu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Public Servant", "Business", "Student" }));
        pnl_dash_userinfo_edit.add(combo_occu, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, -1, -1));
        pnl_dash_userinfo_edit.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));

        jPanel8.add(pnl_dash_userinfo_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 810, 430));

        pnl_dash.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 570));

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_dash_userinfo.setOpaque(false);
        pnl_dash_userinfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_dashv_dob.setFont(new java.awt.Font("Sylfaen", 0, 21)); // NOI18N
        lbl_dashv_dob.setText("Date Of Birth:");
        pnl_dash_userinfo.add(lbl_dashv_dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 150, -1, -1));

        lbl_dashv_gender.setFont(new java.awt.Font("Sylfaen", 0, 21)); // NOI18N
        lbl_dashv_gender.setText("Gender:");
        pnl_dash_userinfo.add(lbl_dashv_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 190, -1, -1));

        lbl_dashv_mobile.setFont(new java.awt.Font("Sylfaen", 0, 21)); // NOI18N
        lbl_dashv_mobile.setText("Mobile:");
        pnl_dash_userinfo.add(lbl_dashv_mobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 230, -1, -1));

        lbl_dashv_address.setFont(new java.awt.Font("Sylfaen", 0, 21)); // NOI18N
        lbl_dashv_address.setText("Adress:");
        pnl_dash_userinfo.add(lbl_dashv_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 270, -1, -1));

        lbl_dashv_zip.setFont(new java.awt.Font("Sylfaen", 0, 21)); // NOI18N
        lbl_dashv_zip.setText("Zip Code:");
        pnl_dash_userinfo.add(lbl_dashv_zip, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 310, -1, -1));

        lbl_dashv_occu.setFont(new java.awt.Font("Sylfaen", 0, 21)); // NOI18N
        lbl_dashv_occu.setText("Occupation:");
        pnl_dash_userinfo.add(lbl_dashv_occu, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, -1, -1));

        lbl_dashv_marital.setFont(new java.awt.Font("Sylfaen", 0, 21)); // NOI18N
        lbl_dashv_marital.setText("Marital Status:");
        pnl_dash_userinfo.add(lbl_dashv_marital, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, -1, -1));

        lbl_dashv_country.setFont(new java.awt.Font("Sylfaen", 0, 21)); // NOI18N
        lbl_dashv_country.setText("Country:");
        pnl_dash_userinfo.add(lbl_dashv_country, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, -1, -1));

        lbl_dashv_nid.setFont(new java.awt.Font("Sylfaen", 0, 21)); // NOI18N
        lbl_dashv_nid.setText("NID :");
        pnl_dash_userinfo.add(lbl_dashv_nid, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, -1, -1));

        kGradientPanel19.setToolTipText("return to dashboard");
        kGradientPanel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        kGradientPanel19.setkBorderRadius(20);
        kGradientPanel19.setkEndColor(new java.awt.Color(153, 204, 255));
        kGradientPanel19.setkStartColor(new java.awt.Color(0, 153, 153));
        kGradientPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Script MT Bold", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_dollar_euro_exchange_40px.png"))); // NOI18N
        jLabel24.setText("ADD");
        kGradientPanel19.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));

        pnl_dash_userinfo.add(kGradientPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 370, 100, 50));

        pnl_dash_returnbutton.setToolTipText("return to dashboard");
        pnl_dash_returnbutton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pnl_dash_returnbutton.setkBorderRadius(20);
        pnl_dash_returnbutton.setkEndColor(new java.awt.Color(153, 204, 255));
        pnl_dash_returnbutton.setkStartColor(new java.awt.Color(51, 51, 51));
        pnl_dash_returnbutton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Script MT Bold", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_dollar_euro_exchange_40px.png"))); // NOI18N
        jLabel23.setText("Return To Dashboard");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        pnl_dash_returnbutton.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));

        pnl_dash_userinfo.add(pnl_dash_returnbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 210, 50));

        pan_layer_nid.setBorder(new javax.swing.border.MatteBorder(null));
        pan_layer_nid.setOpaque(false);
        pan_layer_nid.setLayout(new javax.swing.OverlayLayout(pan_layer_nid));
        pan_layer_nid.add(lbl_nid);

        pnl_dash_userinfo.add(pan_layer_nid, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 130, 130));

        pnl_dash_editInfoButton.setToolTipText("return to dashboard");
        pnl_dash_editInfoButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pnl_dash_editInfoButton.setkBorderRadius(20);
        pnl_dash_editInfoButton.setkEndColor(new java.awt.Color(153, 204, 255));
        pnl_dash_editInfoButton.setkStartColor(new java.awt.Color(102, 204, 0));
        pnl_dash_editInfoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_dash_editInfoButtonMouseClicked(evt);
            }
        });
        pnl_dash_editInfoButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Script MT Bold", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_dollar_euro_exchange_40px.png"))); // NOI18N
        jLabel25.setText("EDIT");
        pnl_dash_editInfoButton.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));

        pnl_dash_userinfo.add(pnl_dash_editInfoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 100, 50));

        jPanel7.add(pnl_dash_userinfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 810, 430));

        pnl_dash.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 570));

        layer_pane_bg.setLayout(new javax.swing.OverlayLayout(layer_pane_bg));

        lb_dash_bg.setPreferredSize(new java.awt.Dimension(100, 100));
        layer_pane_bg.add(lb_dash_bg);

        pnl_dash.add(layer_pane_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 570));

        combined_panel.add(pnl_dash, "card7");

        pnl_tran.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_dash_userinfo1.setOpaque(false);
        pnl_dash_userinfo1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_dashv_ln3.setFont(new java.awt.Font("Sylfaen", 0, 21)); // NOI18N
        lbl_dashv_ln3.setText("Last Name:");
        pnl_dash_userinfo1.add(lbl_dashv_ln3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 110, -1, -1));

        lbl_dashv_dob3.setFont(new java.awt.Font("Sylfaen", 0, 21)); // NOI18N
        lbl_dashv_dob3.setText("Date Of Birth:");
        pnl_dash_userinfo1.add(lbl_dashv_dob3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 150, -1, -1));

        lbl_dashv_gender3.setFont(new java.awt.Font("Sylfaen", 0, 21)); // NOI18N
        lbl_dashv_gender3.setText("Gender:");
        pnl_dash_userinfo1.add(lbl_dashv_gender3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 190, -1, -1));

        lbl_dashv_mobile3.setFont(new java.awt.Font("Sylfaen", 0, 21)); // NOI18N
        lbl_dashv_mobile3.setText("Mobile:");
        pnl_dash_userinfo1.add(lbl_dashv_mobile3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 230, -1, -1));

        lbl_dashv_address3.setFont(new java.awt.Font("Sylfaen", 0, 21)); // NOI18N
        lbl_dashv_address3.setText("Adress:");
        pnl_dash_userinfo1.add(lbl_dashv_address3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 270, -1, -1));

        lbl_dashv_zip3.setFont(new java.awt.Font("Sylfaen", 0, 21)); // NOI18N
        lbl_dashv_zip3.setText("Zip Code:");
        pnl_dash_userinfo1.add(lbl_dashv_zip3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 310, -1, -1));

        lbl_dashv_occu3.setFont(new java.awt.Font("Sylfaen", 0, 21)); // NOI18N
        lbl_dashv_occu3.setText("Occupation:");
        pnl_dash_userinfo1.add(lbl_dashv_occu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, -1, -1));

        lbl_dashv_marital3.setFont(new java.awt.Font("Sylfaen", 0, 21)); // NOI18N
        lbl_dashv_marital3.setText("Marital Status:");
        pnl_dash_userinfo1.add(lbl_dashv_marital3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, -1, -1));

        lbl_dashv_country3.setFont(new java.awt.Font("Sylfaen", 0, 21)); // NOI18N
        lbl_dashv_country3.setText("Country:");
        pnl_dash_userinfo1.add(lbl_dashv_country3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, -1, -1));

        lbl_dashv_fn3.setFont(new java.awt.Font("Sylfaen", 0, 21)); // NOI18N
        lbl_dashv_fn3.setText("First Name:");
        pnl_dash_userinfo1.add(lbl_dashv_fn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 70, -1, -1));

        lbl_dashv_nid3.setFont(new java.awt.Font("Sylfaen", 0, 21)); // NOI18N
        lbl_dashv_nid3.setText("NID :");
        pnl_dash_userinfo1.add(lbl_dashv_nid3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, -1, -1));

        pan_layer_nid3.setBorder(new javax.swing.border.MatteBorder(null));
        pan_layer_nid3.setOpaque(false);
        pan_layer_nid3.setLayout(new javax.swing.OverlayLayout(pan_layer_nid3));
        pan_layer_nid3.add(lbl_nid3);

        pnl_dash_userinfo1.add(pan_layer_nid3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 130, 130));

        pnl_dash_editInfoButton1.setToolTipText("return to dashboard");
        pnl_dash_editInfoButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pnl_dash_editInfoButton1.setkBorderRadius(20);
        pnl_dash_editInfoButton1.setkEndColor(new java.awt.Color(153, 204, 255));
        pnl_dash_editInfoButton1.setkStartColor(new java.awt.Color(102, 204, 0));
        pnl_dash_editInfoButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_dash_editInfoButton1MouseClicked(evt);
            }
        });
        pnl_dash_editInfoButton1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Script MT Bold", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_dollar_euro_exchange_40px.png"))); // NOI18N
        jLabel35.setText("cancel");
        pnl_dash_editInfoButton1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, -1, -1));

        pnl_dash_userinfo1.add(pnl_dash_editInfoButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 100, 50));

        jPanel10.add(pnl_dash_userinfo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 710, 430));

        pnl_tran.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 510));

        table_tran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tran ID", "Ref.", "Debit", "Credit", "Date", "User", "ACC.", "Reciepent", "Status", "ConcUr"
            }
        ));
        jScrollPane1.setViewportView(table_tran);

        pnl_tran.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 63, 810, 440));

        btn_user_tran_csv.setBackground(new java.awt.Color(153, 153, 0));
        btn_user_tran_csv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_export_csv_32px.png"))); // NOI18N
        btn_user_tran_csv.setText("EXPORT");
        btn_user_tran_csv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_user_tran_csvActionPerformed(evt);
            }
        });
        pnl_tran.add(btn_user_tran_csv, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 520, -1, -1));

        combined_panel.add(pnl_tran, "card6");

        getContentPane().add(combined_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 810, 570));

        bg_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setkEndColor(new java.awt.Color(255, 153, 204));
        header.setkStartColor(new java.awt.Color(204, 255, 204));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_exit_32px.png"))); // NOI18N
        exit.setBorder(null);
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.setFocusPainted(false);
        exit.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_exit_32px_1.png"))); // NOI18N
        exit.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_exit_64px.png"))); // NOI18N
        exit.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_exit_40px_1.png"))); // NOI18N
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        header.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1045, 0, 30, -1));

        min.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_minimize_window_32px_1.png"))); // NOI18N
        min.setBorder(null);
        min.setBorderPainted(false);
        min.setContentAreaFilled(false);
        min.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        min.setFocusPainted(false);
        min.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_minimize_window_32px.png"))); // NOI18N
        min.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_exit_64px.png"))); // NOI18N
        min.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_exit_40px_1.png"))); // NOI18N
        min.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minActionPerformed(evt);
            }
        });
        header.add(min, new org.netbeans.lib.awtextra.AbsoluteConstraints(985, 0, 30, -1));

        max.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_full_screen_32px.png"))); // NOI18N
        max.setBorder(null);
        max.setBorderPainted(false);
        max.setContentAreaFilled(false);
        max.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        max.setFocusPainted(false);
        max.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_full_screen_32px_1.png"))); // NOI18N
        max.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_exit_64px.png"))); // NOI18N
        max.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_exit_40px_1.png"))); // NOI18N
        max.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxActionPerformed(evt);
            }
        });
        header.add(max, new org.netbeans.lib.awtextra.AbsoluteConstraints(1015, 0, 30, -1));

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Front Officer Interface");
        header.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 390, -1));

        bg_panel.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, -1));

        ca_r_l.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/logos/ca_rotate.png"))); // NOI18N
        ca_r_l.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(0, 255, 255)));

        javax.swing.GroupLayout ca_rotateLayout = new javax.swing.GroupLayout(ca_rotate);
        ca_rotate.setLayout(ca_rotateLayout);
        ca_rotateLayout.setHorizontalGroup(
            ca_rotateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ca_rotateLayout.createSequentialGroup()
                .addComponent(ca_r_l, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        ca_rotateLayout.setVerticalGroup(
            ca_rotateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ca_rotateLayout.createSequentialGroup()
                .addComponent(ca_r_l)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bg_panel.add(ca_rotate, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 200, 610));

        sign_out.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_shutdown_40px.png"))); // NOI18N
        sign_out.setBorder(null);
        sign_out.setContentAreaFilled(false);
        sign_out.setFocusPainted(false);
        sign_out.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_sidebar_menu_45px.png"))); // NOI18N
        sign_out.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sign_outActionPerformed(evt);
            }
        });
        bg_panel.add(sign_out, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 30, 40, 40));

        change_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_edit_image_32px_1.png"))); // NOI18N
        change_background.setBorder(null);
        change_background.setContentAreaFilled(false);
        change_background.setFocusPainted(false);
        change_background.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/bank/resources/icons/icons8_sidebar_menu_45px.png"))); // NOI18N
        change_background.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                change_backgroundActionPerformed(evt);
            }
        });
        bg_panel.add(change_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 30, 40, 40));

        getContentPane().add(bg_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        int dialog=JOptionPane.YES_NO_CANCEL_OPTION;
        
        int result=JOptionPane.showConfirmDialog(null, "Leave CA Bank", "ca bank", dialog);
        
         if(result==0)
         {
             System.exit(0);
         }
    }//GEN-LAST:event_exitActionPerformed

    
    int loc_x,loc_y;
    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        this.setLocation(x-loc_x, y-loc_y);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        // TODO add your handling code here:
        header.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loc_x=evt.getX();
        loc_y=evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void minActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minActionPerformed
        this.setState(ICONIFIED);
    }//GEN-LAST:event_minActionPerformed

    boolean maximize=true;
    private void maxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxActionPerformed
        // TODO add your handling code here:
        if(maximize)
        {
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            GraphicsEnvironment env=GraphicsEnvironment.getLocalGraphicsEnvironment();
            this.setMaximizedBounds(env.getMaximumWindowBounds());
            maximize=false;
        }
        else
        {
            this.setExtendedState(JFrame.NORMAL);
            maximize=true;
        }
        
    }//GEN-LAST:event_maxActionPerformed

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed
        // TODO add your handling code here:
        
        if(menu_panel.getX()==-200)
        {
           
           Animacion.mover_derecha(-200,0,10,10,menu_panel); 
           separ.setVisible(true);
//           this.menu_panel.setLocation(100, 0);
//           this.menu_panel.revalidate();
//           this.menu_panel.repaint();
//           System.out.println(" "+menu_panel.getX());
//          
        }
        else
        {   
            
            Animacion.mover_izquierda(0, -200, 10, 10, menu_panel);
            separ.setVisible(false);
            
            
//            this.menu_panel.setLocation(-200, 0);
//            System.out.println(" "+menu_panel.getX());
//           this.menu_panel.revalidate();
//           this.menu_panel.repaint();
//            
           
        }
        
     //   Animacion.mover_izquierda(0,-200,10,10,menu_panel);
        
    }//GEN-LAST:event_menuActionPerformed

    private void btn_tranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tranActionPerformed
         new Functions().showTransaction("*", table_tran);
        
        
        new CombinedPanel(combined_panel,pnl_tran);
    }//GEN-LAST:event_btn_tranActionPerformed

    private void btn_transfrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transfrActionPerformed
            new CombinedPanel(combined_panel,pnl_req_appvr);
        lbl_dash_bg.setVisible(false);
        lbl_tran_bg.setVisible(false);
        
        lbl_transfr_bg.setVisible(true);
        
        lbl_chat_bg.setVisible(false);
        
        addm_load();
        sendMoney_load();
    
    }//GEN-LAST:event_btn_transfrActionPerformed

    private void sign_outActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sign_outActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_sign_outActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

            
            assignCheck.setVisible(false);
            assignCard.setVisible(false);
        
        Image img = Toolkit.getDefaultToolkit().getImage("src\\ca\\bank\\resources\\logos\\ca-only.png");  
          this.setIconImage(img);
          this.setTitle("CA BANK ["+OfficerVar.getEmail()+"]");

        // TODO add your handling code here:
        lbl_dash_number.setText(OfficerVar.getMobile());
        lbl_dash_name.setText(OfficerVar.getName());
       
        lbl_dash_email.setText(OfficerVar.getEmail());
        
        lbl_dash_ofNo.setText(OfficerVar.getOfficer_no());

        
        
        pnl_dash_userinfo.setVisible(false);
        pnl_dash_userinfo_edit.setVisible(false);
        
        pnl_dash_dashboard.setVisible(true);
        new CombinedPanel(combined_panel,pnl_dash);
        
        line_dash.setVisible(false);
        line_tran.setVisible(false);
        
        line_transfr.setVisible(false);
        
        line_chat.setVisible(false);
        
        
        lbl_dash_bg.setVisible(true);
        lbl_tran_bg.setVisible(false);
        
        lbl_transfr_bg.setVisible(false);
        
        lbl_chat_bg.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void lbl_dashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_dashMouseClicked
        // TODO add your handling code here:
        
//        line_dash.setVisible(true);
//        line_tran.setVisible(false);
//        line_addm.setVisible(false);
//        line_transfr.setVisible(false);
//        line_feedb.setVisible(false);
//        line_chat.setVisible(false);
//        
        new CombinedPanel(combined_panel,pnl_dash);
        lbl_dash_bg.setVisible(true);
        lbl_tran_bg.setVisible(false);
        
        lbl_transfr_bg.setVisible(false);
        
        lbl_chat_bg.setVisible(false);
    }//GEN-LAST:event_lbl_dashMouseClicked

    private void lbl_tranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_tranMouseClicked

//        line_dash.setVisible(false);
//        line_tran.setVisible(true);
//        line_addm.setVisible(false);
//        line_transfr.setVisible(false);
//        line_feedb.setVisible(false);
//        line_chat.setVisible(false);
//        

        new Functions().showTransaction("*", table_tran);
        
        new CombinedPanel(combined_panel,pnl_tran);
        lbl_dash_bg.setVisible(false);
        lbl_tran_bg.setVisible(true);
        
        lbl_transfr_bg.setVisible(false);
       
        lbl_chat_bg.setVisible(false);
    }//GEN-LAST:event_lbl_tranMouseClicked

    
    public void addm_load()
    {
        DefaultTableModel md=(DefaultTableModel) tbl_addm.getModel();
        
        Object[] row= new Object[10];
        md.setRowCount(0);
        
        String query="select * from add_money where status=?";
        
        db=new DatabaseConnect();
        
        try {
            db.pst=db.con.prepareStatement(query);
            db.pst.setString(1, "processing");
            db.rs=db.pst.executeQuery();
            
            while(db.rs.next())
            {
                row[0]=db.rs.getString(1);
                row[1]=db.rs.getString(2);
                row[2]=db.rs.getDouble(5);
                
                if(db.rs.getString(3).equals("N/A"))
                {
                row[3]="CARD";
                row[4]=db.rs.getString(2);
                }
                else 
                {
                   row[3]="CHECK"; 
                   row[4]=db.rs.getString(3);
                }
                 row[5]=db.rs.getString(8);
                 
                 md.addRow(row);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
    
    
    
    
    
    public void sendMoney_load()
    {
        DefaultTableModel md=(DefaultTableModel) tbl_sendm.getModel();
        
        Object[] row= new Object[10];
        md.setRowCount(0);
        
        String query="select * from transfer where status=?";
        
        db=new DatabaseConnect();
        
        try {
            db.pst=db.con.prepareStatement(query);
            db.pst.setString(1, "processing");
            db.rs=db.pst.executeQuery();
            
            while(db.rs.next())
            {
                row[0]=db.rs.getString(1);
                row[1]=db.rs.getString(2);
                row[2]=db.rs.getDouble(3);
                row[3]=db.rs.getString(4);
                row[4]=db.rs.getString(5);
                
                
                 
                 md.addRow(row);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
    }
    private void lbl_transfrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_transfrMouseClicked
//        line_dash.setVisible(false);
//        line_tran.setVisible(false);
//        line_addm.setVisible(false);
//        line_transfr.setVisible(true);
//        line_feedb.setVisible(false);
//        line_chat.setVisible(false);
//        
        new CombinedPanel(combined_panel,pnl_req_appvr);
        lbl_dash_bg.setVisible(false);
        lbl_tran_bg.setVisible(false);
        
        lbl_transfr_bg.setVisible(true);
        
        lbl_chat_bg.setVisible(false);
        
        addm_load();
        sendMoney_load();
        
        
    }//GEN-LAST:event_lbl_transfrMouseClicked

    
    
    
       
    
    
    
   // JPanel jp =new Chat_Panel();
    boolean chatClick=false;
    
    private void lbl_chatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_chatMouseClicked
//        line_dash.setVisible(false);
//        line_tran.setVisible(false);
//        line_addm.setVisible(false);
//        line_transfr.setVisible(false);
//        line_feedb.setVisible(false);
//        line_chat.setVisible(true);
//        
        



//        if(!chatClick)
//       {
//           chatClick=true;
//           
//          // Method.setFram(this);
//           
//               ImageIcon image = new ImageIcon("src\\ca\\bank\\resources\\images\\image.png");
//                Image img;
//                if (image.getIconWidth() > image.getIconHeight()) {
//                    img = image.getImage().getScaledInstance(100, -1, Image.SCALE_SMOOTH);
//                } else {
//                    img = image.getImage().getScaledInstance(-1, 100, Image.SCALE_SMOOTH);
//                }
//                profile_pic = new ImageIcon(img);
//            //    profile4.setIcon(profile_pic);
//    
//           
//           try {
//             //  Method.connect(profile_pic,"chondro","192.168.137.1");
//           } catch (Exception ex) {
//               ex.printStackTrace();
//           }
//       }
//
//

//        new CombinedPanel(combined_panel,jp);

chatOpen();
        lbl_dash_bg.setVisible(false);
        lbl_tran_bg.setVisible(false);
      
        lbl_transfr_bg.setVisible(false);
        
        lbl_chat_bg.setVisible(true);
    }//GEN-LAST:event_lbl_chatMouseClicked

    private void btn_dashMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashMousePressed
       // btn_dash.setSelected(true);
    }//GEN-LAST:event_btn_dashMousePressed

    private void lbl_dash_bgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_dash_bgMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_dash_bgMouseClicked

    private void lbl_tran_bgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_tran_bgMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_tran_bgMouseClicked

    private void lbl_transfr_bgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_transfr_bgMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_transfr_bgMouseClicked

    private void lbl_chat_bgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_chat_bgMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_chat_bgMouseClicked

    private void lbl_dashMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_dashMouseEntered
         menu_panel.setLocation(0, 0);
         menu_panel.revalidate();
         menu_panel.repaint();
         //Animacion.mover_derecha(-200,0,10,10,menu_panel); 
        line_dash.setVisible(true);
    }//GEN-LAST:event_lbl_dashMouseEntered

    private void lbl_dashMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_dashMouseExited
         menu_panel.setLocation(0, 0);
        //Animacion.mover_derecha(-200,0,10,10,menu_panel); 
        line_dash.setVisible(false);
    }//GEN-LAST:event_lbl_dashMouseExited

    private void lbl_tranMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_tranMouseEntered
       line_tran.setVisible(true);
    }//GEN-LAST:event_lbl_tranMouseEntered

    private void lbl_tranMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_tranMouseExited
       line_tran.setVisible(false);
    }//GEN-LAST:event_lbl_tranMouseExited

    private void lbl_transfrMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_transfrMouseEntered
         line_transfr.setVisible(true);
    }//GEN-LAST:event_lbl_transfrMouseEntered

    private void lbl_transfrMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_transfrMouseExited
         line_transfr.setVisible(false);
    }//GEN-LAST:event_lbl_transfrMouseExited

    private void lbl_chatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_chatMouseEntered
         line_chat.setVisible(true);
    }//GEN-LAST:event_lbl_chatMouseEntered

    private void lbl_chatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_chatMouseExited
         line_chat.setVisible(false);
    }//GEN-LAST:event_lbl_chatMouseExited

    private void btn_dashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashMouseClicked
        lbl_dash_bg.setVisible(true);
        lbl_tran_bg.setVisible(false);
        
        lbl_transfr_bg.setVisible(false);
        
        lbl_chat_bg.setVisible(false);
    }//GEN-LAST:event_btn_dashMouseClicked

    private void btn_tranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tranMouseClicked
        lbl_dash_bg.setVisible(false);
        lbl_tran_bg.setVisible(true);
        
        lbl_transfr_bg.setVisible(false);
        
        lbl_chat_bg.setVisible(false);
    }//GEN-LAST:event_btn_tranMouseClicked

    private void btn_transfrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_transfrMouseClicked
        lbl_dash_bg.setVisible(false);
        lbl_tran_bg.setVisible(false);
       
        lbl_transfr_bg.setVisible(true);
        
        lbl_chat_bg.setVisible(false);
    }//GEN-LAST:event_btn_transfrMouseClicked

    private void btn_chatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_chatMouseClicked
        lbl_dash_bg.setVisible(false);
        lbl_tran_bg.setVisible(false);
       
        lbl_transfr_bg.setVisible(false);
        
        lbl_chat_bg.setVisible(true);
    }//GEN-LAST:event_btn_chatMouseClicked

    private void btn_dashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dashActionPerformed
        new CombinedPanel(combined_panel,pnl_dash);
    }//GEN-LAST:event_btn_dashActionPerformed

    private void btn_chatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chatActionPerformed
        chatOpen();
        lbl_dash_bg.setVisible(false);
        lbl_tran_bg.setVisible(false);
      
        lbl_transfr_bg.setVisible(false);
        
        lbl_chat_bg.setVisible(true);
    }//GEN-LAST:event_btn_chatActionPerformed

    private void edit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edit2ActionPerformed
private ImageIcon profile_pic;
    private void change_backgroundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_change_backgroundActionPerformed

         
            JFileChooser ch = new JFileChooser();
            FileChoose preview = new FileChoose();
            ch.setAccessory(preview);
            ch.addPropertyChangeListener(preview);
            ch.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    String name = file.getName();
                    return file.isDirectory() || name.endsWith(".png") || name.endsWith(".PNG") || name.endsWith("jpg") || name.endsWith("JPG");
                }

                @Override
                public String getDescription() {
                    return "png,jpg";
                }
            });
            int opt = ch.showOpenDialog(this);
            if (opt == JFileChooser.APPROVE_OPTION) {
                ImageIcon image = new ImageIcon(ch.getSelectedFile().getAbsolutePath());
                Image img;
                if (image.getIconWidth() > image.getIconHeight()) {
                    img = image.getImage().getScaledInstance(810, -1, Image.SCALE_SMOOTH);
                } else {
                    img = image.getImage().getScaledInstance(-1, 810, Image.SCALE_SMOOTH);
                }
                profile_pic = new ImageIcon(img);
                lb_dash_bg.setIcon(profile_pic);
                
            }
        
    }//GEN-LAST:event_change_backgroundActionPerformed

    private void borderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borderMouseClicked
        if (evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt)) {
            JFileChooser ch = new JFileChooser();
            FileChoose preview = new FileChoose();
            ch.setAccessory(preview);
            ch.addPropertyChangeListener(preview);
            ch.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    String name = file.getName();
                    return file.isDirectory() || name.endsWith(".png") || name.endsWith(".PNG") || name.endsWith("jpg") || name.endsWith("JPG");
                }

                @Override
                public String getDescription() {
                    return "png,jpg";
                }
            });
            
            int opt = ch.showOpenDialog(this);
            if (opt == JFileChooser.APPROVE_OPTION) {
                ImageIcon image = new ImageIcon(ch.getSelectedFile().getAbsolutePath());
                Image img;
                if (image.getIconWidth() > image.getIconHeight()) {
                    img = image.getImage().getScaledInstance(100, -1, Image.SCALE_SMOOTH);
                } else {
                    img = image.getImage().getScaledInstance(-1, 100, Image.SCALE_SMOOTH);
                }
                profile_pic = new ImageIcon(img);
                profile.setIcon(profile_pic);

            }
        }
    }//GEN-LAST:event_borderMouseClicked
  DatabaseConnect db;
    private void pnl_dash_showInfoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_dash_showInfoButtonMouseClicked

        
        pnl_dash_userinfo.setVisible(true);
        pnl_dash_dashboard.setVisible(false);
        
        
        db=new DatabaseConnect();
        String query="select * from officer_info where officer_no=?";
        try {
            db.pst=db.con.prepareStatement(query);
            db.pst.setString(1, OfficerVar.getOfficer_no());
            db.rs=db.pst.executeQuery();
            
            if(db.rs.next())
            {
                lbl_dashv_dob.setText("DOB: "+db.rs.getString(3));
                lbl_dashv_gender.setText("Gender: "+db.rs.getString(4));
                lbl_dashv_mobile.setText("Number: "+db.rs.getString(5));
                lbl_dashv_address.setText("Address: "+db.rs.getString(6));
                lbl_dashv_zip.setText("Zip Code: "+db.rs.getString(7));
                lbl_dashv_occu.setText("Occupation: "+db.rs.getString(8));
                lbl_dashv_marital.setText("Marital Status: "+db.rs.getString(9));
                lbl_dashv_country.setText("Contry: "+db.rs.getString(10));
                lbl_dashv_nid.setText("NID: "+db.rs.getString(11));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_pnl_dash_showInfoButtonMouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked

        pnl_dash_userinfo.setVisible(false);
        pnl_dash_dashboard.setVisible(true);
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        pnl_dash_userinfo.setVisible(true);
        pnl_dash_userinfo_edit.setVisible(false);
    }//GEN-LAST:event_jLabel28MouseClicked

    private void tf_edit_addrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_edit_addrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_edit_addrActionPerformed

    private void tf_edit_nidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_edit_nidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_edit_nidActionPerformed

    private void cb_unmarriedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_unmarriedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_unmarriedActionPerformed

    private void cb_marriedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_marriedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_marriedActionPerformed

    private void combo_countryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_countryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_countryActionPerformed

    private void pnl_dash_editInfoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_dash_editInfoButtonMouseClicked
        getUserInfo();
        pnl_dash_userinfo.setVisible(false);
        pnl_dash_userinfo_edit.setVisible(true);
        
    }//GEN-LAST:event_pnl_dash_editInfoButtonMouseClicked

    private void pnl_dash_returnbutton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_dash_returnbutton1MouseClicked
        pnl_dash_userinfo.setVisible(true);
        pnl_dash_userinfo_edit.setVisible(false);
        
    }//GEN-LAST:event_pnl_dash_returnbutton1MouseClicked
    String marital="Unmarried";
    private void pnl_dash_saveInfoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_dash_saveInfoButtonMouseClicked

        
        
         db=new DatabaseConnect();
        
        
        String checkStat="select * from officer_info where officer_no=?";
        
        try {
            db.pst=db.con.prepareStatement(checkStat);
            db.pst.setString(1, OfficerVar.getOfficer_no());
            db.rs=db.pst.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        try {
            if(db.rs.next())
            {
                String updateQuery="UPDATE officer_info SET dob = ?, gender = ?, number = ?, address = ?, zip = ?, occu = ?, marital = ?, country = ?, nid = ? WHERE officer_no =?";
                
                try
                {
                    
                   SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
                    String date=f.format(dob.getDate());
                        db.pst=db.con.prepareStatement(updateQuery);
                        db.pst.setString(1, date);
                        db.pst.setString(2, combo_gender.getSelectedItem().toString());
                        db.pst.setString(3, tf_edit_num.getText());
                        db.pst.setString(4, tf_edit_addr.getText());
                        db.pst.setString(5, tf_edit_zip.getText());
                        db.pst.setString(6, combo_occu.getSelectedItem().toString());
                        db.pst.setString(7, marital);
                        db.pst.setString(8, combo_country.getSelectedItem().toString());
                        db.pst.setString(9, tf_edit_nid.getText());
                        db.pst.setString(10, OfficerVar.getOfficer_no());
                        db.pst.executeUpdate();
                        
                        JOptionPane.showMessageDialog(this, "Info Updated Successfully");
                        getUserInfo();
                        
                        pnl_dash_userinfo.setVisible(true);
                        pnl_dash_userinfo_edit.setVisible(false);
        
                
                }
                        catch(SQLException ex)
                        {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(this, "Error Occured When Updating");
                        }
            }
            
            else
            {
         String query= "insert into officer_info (officer_no, email, dob, gender, number, address, zip, occu, marital, country, nid) values(?,?,?,?,?,?,?,?,?,?,?)";



                    SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
                    String date=f.format(dob.getDate());

                    try {
                        db.pst=db.con.prepareStatement(query);
                        db.pst.setString(1,OfficerVar.getOfficer_no());
                        db.pst.setString(2,OfficerVar.getEmail());
                        db.pst.setString(3, date);
                        db.pst.setString(4, combo_gender.getSelectedItem().toString());
                        db.pst.setString(5, tf_edit_num.getText());
                        db.pst.setString(6, tf_edit_addr.getText());
                        db.pst.setString(7, tf_edit_zip.getText());
                        db.pst.setString(8, combo_occu.getSelectedItem().toString());
                        db.pst.setString(9, marital);
                        db.pst.setString(10, combo_country.getSelectedItem().toString());
                        db.pst.setString(11, tf_edit_nid.getText());
                        db.pst.executeUpdate();
                        
                        
                        
                         JOptionPane.showMessageDialog(this, "Info Saved Successfully");
                        getUserInfo();
                        
                        pnl_dash_userinfo.setVisible(true);
                        pnl_dash_userinfo_edit.setVisible(false);
        

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

               }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
       
    }//GEN-LAST:event_pnl_dash_saveInfoButtonMouseClicked

    private void pnl_dash_editInfoButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_dash_editInfoButton1MouseClicked
      jPanel10.setVisible(false);
    }//GEN-LAST:event_pnl_dash_editInfoButton1MouseClicked

    
    
    void chatOpen()
    {
         if(!chatClick)
       {
           chatClick=true;
           
//           
//          // new Login().setVisible(true);
//         //  Method.connect(profile_pic, cardnum, pin);
//           //Method.setFram(this);
//           
//               ImageIcon image = new ImageIcon("src\\ca\\bank\\resources\\images\\image.png");
//                Image img;
//                if (image.getIconWidth() > image.getIconHeight()) {
//                    img = image.getImage().getScaledInstance(100, -1, Image.SCALE_SMOOTH);
//                } else {
//                    img = image.getImage().getScaledInstance(-1, 100, Image.SCALE_SMOOTH);
//                }
//                profile_pic = new ImageIcon(img);
//            //    profile4.setIcon(profile_pic);



   JFileChooser ch = new JFileChooser();
            FileChoose preview = new FileChoose();
            ch.setAccessory(preview);
            ch.addPropertyChangeListener(preview);
            ch.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    String name = file.getName();
                    return file.isDirectory() || name.endsWith(".png") || name.endsWith(".PNG") || name.endsWith("jpg") || name.endsWith("JPG");
                }

                @Override
                public String getDescription() {
                    return "png,jpg";
                }
            });
            
            int opt = ch.showOpenDialog(this);
            if (opt == JFileChooser.APPROVE_OPTION) {
                ImageIcon image = new ImageIcon(ch.getSelectedFile().getAbsolutePath());
                Image img;
                if (image.getIconWidth() > image.getIconHeight()) {
                    img = image.getImage().getScaledInstance(100, -1, Image.SCALE_SMOOTH);
                } else {
                    img = image.getImage().getScaledInstance(-1, 100, Image.SCALE_SMOOTH);
                }
                   profile_pic = new ImageIcon(img);
            }
    
           
           try {
             Method.connect(profile_pic,OfficerVar.getOfficer_no(),"192.168.0.109");//137.1
             Main.setCname("Officer-"+OfficerVar.getEmail());
             new Main().setVisible(true);
  //             panabcd.start();
           } catch (Exception ex) {
               ex.printStackTrace();
           }
       }
         
         else
         {
            // new CombinedPanel(combined_panel, pnl_developer);
         }


    }
    private void btn_user_tran_csvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_user_tran_csvActionPerformed

        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();

        try {
            //FileWriter fw = new FileWriter(filename);

            db=new DatabaseConnect();
            String query="select * from transaction";

            db.pst=db.con.prepareStatement(query);
           // db.pst.setString(1, ClientVar.getUsername());
            ResultSet rs2=db.pst.executeQuery();

            CSVWriter writer = new CSVWriter(new FileWriter(filename));
            writer.writeAll(rs2, true,true);
            writer.close();
            /*fw.append("id_bankBalance");
            fw.append(",");
            fw.append("transaction");
            fw.append(",");
            fw.append("debit");
            fw.append(",");

            while(rs2.next())
            {
                fw.append(rs2.getString(1));
                fw.append(",");
                fw.append(rs2.getString(2));
                fw.append(",");

                fw.append(rs2.getString(3));
                fw.append(",");
                fw.append(rs2.getString(4));
                fw.append(",");
                fw.append(rs2.getString(5));

                fw.append("\n");

            }
            fw.flush();
            fw.close();*/

            JOptionPane.showMessageDialog(this, "CSV File is created successfully");
        } catch (IOException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }//GEN-LAST:event_btn_user_tran_csvActionPerformed

    private void addm_approveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addm_approveActionPerformed
                String query2="select * from blance_table where acc_no=?";
                String query3="update blance_table set blance=?, pending_bal=? where acc_no=?";
                String query4="insert into blance_table(acc_no,pending_bal,blance) values(?,?,?)";
                
                String query5 ="update add_money set status=? where trace_id=?";
                db=new DatabaseConnect();
                
        try {
            db.pst=db.con.prepareStatement(query2);
            db.pst.setString(1, queryacc);
            db.rs=db.pst.executeQuery();
            
            if(db.rs.next())
            {
                double current=db.rs.getDouble("blance");
                double pending= db.rs.getDouble("pending_bal");
                db.pst=db.con.prepareStatement(query3);
                db.pst.setDouble(1, queryblance+current);
                db.pst.setDouble(2,pending-queryblance);
                db.pst.setString(3, queryacc);
                db.pst.executeUpdate();
                
                
                db.pst=db.con.prepareStatement(query5);
                db.pst.setString(1, "DONE");
                db.pst.setString(2, querytid);
                db.pst.executeUpdate();
                
                addm_load();
            }
            
            else
            {
               db.pst=db.con.prepareStatement(query4);
               db.pst.setString(1, queryacc);
               db.pst.setString(2, "0");
               db.pst.setDouble(3, queryblance);
               db.pst.execute();
               
               
               db.pst=db.con.prepareStatement(query5);
                db.pst.setString(1, "DONE");
                db.pst.setString(2, querytid);
                db.pst.executeUpdate();
                
                addm_load();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        String addq="select * from info where acc_no=?";
        String upq="update info set last_added_money=? where acc_no=?";
        String insq="insert into info(acc_no,last_added_money) values(?,?)";
        
        try {
            db.pst=db.con.prepareStatement(addq);
            db.pst.setString(1, queryacc);
            db.rs=db.pst.executeQuery();
            
            if(db.rs.next())
            {
               db.pst=db.con.prepareStatement(upq);
               db.pst.setDouble(1, queryblance);
               db.pst.setString(2, queryacc);
               db.pst.executeUpdate();
                
            }
            
            else
            {
                db.pst=db.con.prepareStatement(insq);
               
               db.pst.setString(1, queryacc);
               db.pst.setDouble(2, queryblance);
               db.pst.execute();
               
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
                
    }//GEN-LAST:event_addm_approveActionPerformed
    
    DatabaseConnect dbt;
    public void insertTransaction(String ref,double d,double c,String acc,String user,String to_acc)
    {
        String query="INSERT INTO transaction (reference,debit,credit, username, acc_no, to_acc, tran_stat, concur) VALUES (?,?,?,?,?,?,?,?)";

        
       dbt=new DatabaseConnect();
       Date date=new Date();
       DateFormat timeFormat = new SimpleDateFormat("yyyy-dd-MM");
       
        try {
            dbt.pst=dbt.con.prepareStatement(query);
            dbt.pst.setString(1, ref);
            dbt.pst.setDouble(2, d);
            dbt.pst.setDouble(3, c);
          //  dbt.pst.setString(4, timeFormat.format(date));
            dbt.pst.setString(4, user);
            dbt.pst.setString(5, acc);
            dbt.pst.setString(6, to_acc);
            dbt.pst.setString(7, "DONE");
            dbt.pst.setString(8, "NO");
            dbt.pst.execute();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
    public void updateBalance(String acc,int type,String to_acc,String user)
    {
        double calculation;
        
        
        String query = "update blance_table set blance=? where acc_no=?";
        String prequery="select * from blance_table where acc_no=?";
        db=new DatabaseConnect();
        
        try {
            db.pst=db.con.prepareStatement(prequery);
            db.pst.setString(1, acc);
            db.rs=db.pst.executeQuery();
            
            if(db.rs.next())
            {
                
                if(type==1)
                   {
                       calculation=db.rs.getDouble("blance")-sendm_amount;
                       
                       insertTransaction("send", sendm_amount,0, acc,user,to_acc);
            
                     }
                
                
                
                 else
                  {
                      calculation=db.rs.getDouble("blance")+sendm_amount;
                      insertTransaction("receive", 0,sendm_amount, acc,user,to_acc);
            
                     }
                
                
                //updating blance table
                
                db.pst=db.con.prepareStatement(query);
                db.pst.setDouble(1, calculation);
                db.pst.setString(2, acc);
                db.pst.executeUpdate();
                
                
                
                
            }
            
            else
            {
                String q = "insert into blance_table(acc_no,pending_bal,blance) values(?,?,?)";
                db.pst=db.con.prepareStatement(q);
                
                db.pst.setString(1, acc);
                db.pst.setDouble(2, 0);
                db.pst.setDouble(3, sendm_amount);
                db.pst.execute();
            }
                
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        String lastquery1="select * from info where acc_no=?";
        String lastquery2="update info set last_tran=? ,last_tran_date=current_timestamp(),total=? where acc_no=?";
        String lastquery3="insert into info(acc_no,last_tran,total) values(?,?,?)";
        
        
        try {
            db.pst=db.con.prepareStatement(lastquery1);
            db.pst.setString(1, acc);
            db.rs=db.pst.executeQuery();
            
            if(db.rs.next())
            {
                double total=db.rs.getDouble("total")+sendm_amount;
                
                db.pst=db.con.prepareStatement(lastquery2);
                db.pst.setDouble(1, sendm_amount);
                
                db.pst.setDouble(2, total);
                db.pst.setString(3, acc);
                db.pst.executeUpdate();
                
            }
            else
            
            {
                
                db.pst=db.con.prepareStatement(lastquery3);
                db.pst.setString(1, acc);
                db.pst.setDouble(2, sendm_amount);
                
                db.pst.setDouble(3, sendm_amount);
                
                db.pst.execute();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
    
    public void getUserInfo()
  {
      db=new DatabaseConnect();
        String query="select * from officer_info where officer_no=?";
        try {
            db.pst=db.con.prepareStatement(query);
            db.pst.setString(1, OfficerVar.getOfficer_no());
            db.rs=db.pst.executeQuery();
            
            if(db.rs.next())
            {
                lbl_dashv_dob.setText("DOB: "+db.rs.getString(3));
                dob.setDate(db.rs.getDate(3));
                lbl_dashv_gender.setText("Gender: "+db.rs.getString(4));
                combo_gender.setSelectedItem(db.rs.getString(4));
                lbl_dashv_mobile.setText("Number: "+db.rs.getString(5));
                tf_edit_num.setText(db.rs.getString(5));
                lbl_dashv_address.setText("Address: "+db.rs.getString(6));
                tf_edit_addr.setText(db.rs.getString(6));
                lbl_dashv_zip.setText("Zip Code: "+db.rs.getString(7));
                tf_edit_zip.setText(db.rs.getString(7));
                lbl_dashv_occu.setText("Occupation: "+db.rs.getString(8));
                combo_occu.setSelectedItem(db.rs.getString(8));
                lbl_dashv_marital.setText("Marital Status: "+db.rs.getString(9));
                
                if(db.rs.getString(9).equals("married"))
                {
                    cb_married.setSelected(true);
                    cb_unmarried.setSelected(false);
                }
                else
                {
                    cb_married.setSelected(false);
                    cb_unmarried.setSelected(true);
                }
                
                lbl_dashv_country.setText("Contry: "+db.rs.getString(10));
                combo_country.setSelectedItem(db.rs.getString(10));
                lbl_dashv_nid.setText("NID: "+db.rs.getString(11));
                tf_edit_nid.setText(db.rs.getString(11));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
  }
  
    private void transfr_approveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transfr_approveActionPerformed

        updateBalance(sendm_acc, 1, sendm_to_acc, send_user);
        updateBalance(sendm_to_acc, 2, sendm_acc, recieve_user);
        JOptionPane.showMessageDialog(this, "Transaction Complete");
        db=new DatabaseConnect();
        String query="update transfer set status=? where id=?";
        try {
            db.pst=db.con.prepareStatement(query);
            db.pst.setString(1, "DONE");
            db.pst.setString(2, tranid);
            db.pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        sendMoney_load();
        
    }//GEN-LAST:event_transfr_approveActionPerformed

    private void cc_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cc_comboActionPerformed
        if(cc_combo.getSelectedItem().toString().equals("CARD"))
        {   
            assignCheck.setVisible(false);
            assignCard.setVisible(true);
        }
        else
        {
            assignCheck.setVisible(true);
            assignCard.setVisible(false);
            
        }
    }//GEN-LAST:event_cc_comboActionPerformed

    private void cc_checkNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cc_checkNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cc_checkNoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Random rand=new Random();
        
       cc_checkNo.setText(""+rand.nextInt(99999999));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void card_csvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_card_csvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_card_csvActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        card_csv.setText(""+new Random().nextInt(999));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void card_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_card_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_card_noActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        card_no.setText(""+new Random().nextInt(999999));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cc_comboFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cc_comboFocusLost
        if(cc_combo.getSelectedItem().toString().equals("CARD"))
        {  
            
            assignCheck.setVisible(false);
            assignCard.setVisible(true);
        }
        else
        {
            assignCheck.setVisible(true);
            assignCard.setVisible(false);
            
        }
    }//GEN-LAST:event_cc_comboFocusLost

    private void AcardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcardActionPerformed

        
        String q= "insert into gen_card(card_number,csv,pin,issued_to) values(?,?,?,?)";
        
        db=new DatabaseConnect();
        
        try {
            db.pst=db.con.prepareStatement(q);
            db.pst.setString(1, card_no.getText());
            db.pst.setString(2, card_csv.getText());
            db.pst.setString(3,""+1234);
            db.pst.setString(4, card_assign.getText());
            db.pst.execute();
            JOptionPane.showMessageDialog(this, "Genarated Successfully");
        } catch (SQLException ex) {
            Logger.getLogger(Officer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
            assignCheck.setVisible(false);
            assignCard.setVisible(false);
    }//GEN-LAST:event_AcardActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        db=new DatabaseConnect();
        String q="INSERT INTO gen_check(check_no, branch, issued_to) VALUES (?, ?, ?)";
        
        
        
        try {
            db.pst=db.con.prepareStatement(q);
            db.pst.setString(1, cc_checkNo.getText());
            db.pst.setString(2, check_br.getSelectedItem().toString());
            db.pst.setString(3, check_assign.getText());
            db.pst.execute();
            JOptionPane.showMessageDialog(this, "Genarated Succesfully");
            
        } catch (SQLException ex) {
            Logger.getLogger(Officer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
            assignCheck.setVisible(false);
            assignCard.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ASSIGNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ASSIGNMouseClicked
        new CombinedPanel(combined_panel, pnl_assignCC);
    }//GEN-LAST:event_ASSIGNMouseClicked

    private void info6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info6MouseClicked
        //new CombinedPanel(combined_panel, pnl_developer);
    }//GEN-LAST:event_info6MouseClicked

    private void check_assignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_assignActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check_assignActionPerformed

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
            java.util.logging.Logger.getLogger(Officer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Officer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Officer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Officer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Officer().setVisible(true);
            }
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ASSIGN;
    private javax.swing.JButton Acard;
    private javax.swing.JButton addm_approve;
    private javax.swing.JLabel addm_branch;
    private javax.swing.JLabel addm_csv;
    private javax.swing.JPanel assignCard;
    private javax.swing.JPanel assignCheck;
    private javax.swing.JPanel assignLogo;
    private javax.swing.JPanel bg_panel;
    private javax.swing.JLabel border;
    private javax.swing.JButton btn_chat;
    private javax.swing.JButton btn_dash;
    private javax.swing.JButton btn_tran;
    private javax.swing.JButton btn_transfr;
    private javax.swing.JButton btn_user_tran_csv;
    private javax.swing.JLabel ca_r_l;
    private javax.swing.JPanel ca_rotate;
    private javax.swing.JTextField card_assign;
    private javax.swing.JTextField card_csv;
    private javax.swing.JTextField card_no;
    private javax.swing.JCheckBox cb_married;
    private javax.swing.JCheckBox cb_unmarried;
    private javax.swing.JTextField cc_checkNo;
    private javax.swing.JComboBox<String> cc_combo;
    private javax.swing.JButton change_background;
    private javax.swing.JLabel chat;
    private javax.swing.JTextField check_assign;
    private javax.swing.JComboBox<String> check_br;
    private javax.swing.JPanel combined_panel;
    private javax.swing.JComboBox<String> combo_country;
    private javax.swing.JComboBox<String> combo_gender;
    private javax.swing.JComboBox<String> combo_occu;
    private javax.swing.JLabel dash;
    private com.toedter.calendar.JDateChooser dob;
    private keeptoo.KButton edit2;
    private javax.swing.JButton exit;
    private javax.swing.JLabel flower;
    private keeptoo.KGradientPanel header;
    private javax.swing.JLabel info;
    private javax.swing.JLabel info6;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private ca.bank.KGradientPanel kGradientPanel1;
    private ca.bank.KGradientPanel kGradientPanel19;
    private ca.bank.KGradientPanel kGradientPanel20;
    private javax.swing.JLayeredPane layer_pane_bg;
    private javax.swing.JLayeredPane layer_pane_pp;
    private javax.swing.JLabel lb_dash_bg;
    private javax.swing.JLabel lbl_chat;
    private javax.swing.JLabel lbl_chat_bg;
    private javax.swing.JLabel lbl_dash;
    private javax.swing.JLabel lbl_dash_bg;
    private javax.swing.JLabel lbl_dash_email;
    private javax.swing.JLabel lbl_dash_name;
    private javax.swing.JLabel lbl_dash_number;
    private javax.swing.JLabel lbl_dash_ofNo;
    private javax.swing.JLabel lbl_dashv_address;
    private javax.swing.JLabel lbl_dashv_address1;
    private javax.swing.JLabel lbl_dashv_address3;
    private javax.swing.JLabel lbl_dashv_country;
    private javax.swing.JLabel lbl_dashv_country1;
    private javax.swing.JLabel lbl_dashv_country3;
    private javax.swing.JLabel lbl_dashv_dob;
    private javax.swing.JLabel lbl_dashv_dob1;
    private javax.swing.JLabel lbl_dashv_dob3;
    private javax.swing.JLabel lbl_dashv_fn3;
    private javax.swing.JLabel lbl_dashv_gender;
    private javax.swing.JLabel lbl_dashv_gender1;
    private javax.swing.JLabel lbl_dashv_gender3;
    private javax.swing.JLabel lbl_dashv_ln3;
    private javax.swing.JLabel lbl_dashv_marital;
    private javax.swing.JLabel lbl_dashv_marital1;
    private javax.swing.JLabel lbl_dashv_marital3;
    private javax.swing.JLabel lbl_dashv_mobile;
    private javax.swing.JLabel lbl_dashv_mobile1;
    private javax.swing.JLabel lbl_dashv_mobile3;
    private javax.swing.JLabel lbl_dashv_nid;
    private javax.swing.JLabel lbl_dashv_nid1;
    private javax.swing.JLabel lbl_dashv_nid3;
    private javax.swing.JLabel lbl_dashv_occu;
    private javax.swing.JLabel lbl_dashv_occu1;
    private javax.swing.JLabel lbl_dashv_occu3;
    private javax.swing.JLabel lbl_dashv_zip;
    private javax.swing.JLabel lbl_dashv_zip1;
    private javax.swing.JLabel lbl_dashv_zip3;
    private javax.swing.JLabel lbl_nid;
    private javax.swing.JLabel lbl_nid1;
    private javax.swing.JLabel lbl_nid3;
    private javax.swing.JLabel lbl_tran;
    private javax.swing.JLabel lbl_tran_bg;
    private javax.swing.JLabel lbl_transfr;
    private javax.swing.JLabel lbl_transfr_bg;
    private javax.swing.JLabel line_chat;
    private javax.swing.JLabel line_dash;
    private javax.swing.JLabel line_tran;
    private javax.swing.JLabel line_transfr;
    private javax.swing.JButton max;
    private javax.swing.JButton menu;
    private keeptoo.KGradientPanel menu_panel;
    private javax.swing.JButton min;
    private javax.swing.JPanel pan_addm;
    private javax.swing.JPanel pan_dash_profile_bg;
    private javax.swing.JPanel pan_layer_nid;
    private javax.swing.JPanel pan_layer_nid1;
    private javax.swing.JPanel pan_layer_nid3;
    private ca.bank.KGradientPanel pan_transfr;
    private ca.bank.PanelHouse panelHouse1;
    private javax.swing.JPanel pnl_addm;
    private javax.swing.JPanel pnl_assignCC;
    private javax.swing.JPanel pnl_chat;
    private javax.swing.JPanel pnl_dash;
    private javax.swing.JPanel pnl_dash_dashboard;
    private ca.bank.KGradientPanel pnl_dash_editInfoButton;
    private ca.bank.KGradientPanel pnl_dash_editInfoButton1;
    private ca.bank.KGradientPanel pnl_dash_returnbutton;
    private ca.bank.KGradientPanel pnl_dash_returnbutton1;
    private ca.bank.KGradientPanel pnl_dash_saveInfoButton;
    private ca.bank.KGradientPanel pnl_dash_showInfoButton;
    private javax.swing.JPanel pnl_dash_userinfo;
    private javax.swing.JPanel pnl_dash_userinfo1;
    private javax.swing.JPanel pnl_dash_userinfo_edit;
    private javax.swing.JPanel pnl_req_appvr;
    private javax.swing.JPanel pnl_tran;
    private javax.swing.JLabel profile;
    private javax.swing.JLabel reciepent;
    private javax.swing.JLabel sender;
    private javax.swing.JSeparator separ;
    private javax.swing.JButton sign_out;
    private javax.swing.JTable table_tran;
    private javax.swing.JTable tbl_addm;
    private javax.swing.JTable tbl_sendm;
    private javax.swing.JTextField tf_edit_addr;
    private javax.swing.JTextField tf_edit_nid;
    private javax.swing.JTextField tf_edit_num;
    private javax.swing.JTextField tf_edit_zip;
    private javax.swing.JLabel tran;
    private javax.swing.JLabel transfr;
    private javax.swing.JButton transfr_approve;
    // End of variables declaration//GEN-END:variables
}
