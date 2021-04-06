/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bank;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Chondromollika_Ahmed
 */
public class Functions {
    
    
    DatabaseConnect db;
    public  ArrayList <TransactionInfo> loadTransaction(String add)
    {
        db=new DatabaseConnect();
        ArrayList <TransactionInfo> loadTransaction = new ArrayList<>();
        
        
        String query;
        if(add.equals("*"))
        {
            query="select * from transaction";
            
            
            try {
            
            db.pst=db.con.prepareStatement(query);
            db.rs=db.pst.executeQuery();
            
            TransactionInfo user;
            
            while(db.rs.next())
            {
                user=new TransactionInfo(db.rs.getInt(1), db.rs.getString(2), db.rs.getDouble(3), db.rs.getDouble(4), db.rs.getString(5), db.rs.getString(6), db.rs.getString(7), db.rs.getString(8), db.rs.getString(9), db.rs.getString(10));
                loadTransaction.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        }
        else
        {
         query="select * from transaction where username=?";
         
         try {
            
            db.pst=db.con.prepareStatement(query);
            db.pst.setString(1, add);
            db.rs=db.pst.executeQuery();
            
            TransactionInfo user;
            
            while(db.rs.next())
            {
                user=new TransactionInfo(db.rs.getInt(1), db.rs.getString(2), db.rs.getDouble(3), db.rs.getDouble(4), db.rs.getString(5), db.rs.getString(6), db.rs.getString(7), db.rs.getString(8), db.rs.getString(9), db.rs.getString(10));
                loadTransaction.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        }
        
        
        return loadTransaction;
    }
    
    
    public void showTransaction(String add,JTable table)
    {
         
        
        ArrayList<TransactionInfo> list=loadTransaction(add);
        
        DefaultTableModel model=(DefaultTableModel) table.getModel();
        Object[] row= new Object[10];
        model.setRowCount(0);
        for(int i=0 ;i<list.size();i++)
        {
            
            row[0]=list.get(i).getTranid();
            row[1]=list.get(i).getReference();
            row[2]=list.get(i).getDebit();
            row[3]=list.get(i).getCredit();
            row[4]=list.get(i).getDate();
            row[5]=list.get(i).getUsername();
            row[6]=list.get(i).getAcc_no();
            row[7]=list.get(i).getTo_acc();
            row[8]=list.get(i).getTran_stat();
            row[9]=list.get(i).getConcur();
            //row[10]=list.get(i).getReference();
            model.addRow(row);
        }
    }
    
}
