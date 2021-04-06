
package ca.bank;

import java.sql.ResultSet;

/**
 *
 * @author Chondromollika_Ahmed
 */



public class ClientVar {
    
  private static String username;  
  private static String accNo;  
  private static double blance;  
  private static String transaction;  
  private static String picture;
  private static String firstName;
  private static String lastName;
  private static String email;

    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String firstName) {
        ClientVar.firstName = firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        ClientVar.lastName = lastName;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        ClientVar.email = email;
    }
   static ResultSet rs;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        ClientVar.username = username;
    }

    public static String getAccNo() {
        return accNo;
    }

    public static void setAccNo(String accNo) {
        ClientVar.accNo = accNo;
    }

    public static double getBlance() {
        return blance;
    }

    public static void setBlance(double blance) {
        ClientVar.blance = blance;
    }

    public static String getTransaction() {
        return transaction;
    }

    public static void setTransaction(String transaction) {
        ClientVar.transaction = transaction;
    }

    public static String getPicture() {
        return picture;
    }

    public static void setPicture(String picture) {
        ClientVar.picture = picture;
    }

    public static ResultSet getRs() {
        return rs;
    }

    public static void setRs(ResultSet rs) {
        ClientVar.rs = rs;
    }
    
    
}
