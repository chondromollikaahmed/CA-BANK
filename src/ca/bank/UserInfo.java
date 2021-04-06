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
public class UserInfo {
    
   private String username;
   private String accNo;
   private String blance;
   private String firstName;
   private String lastName;
   private String email;
   private String nid;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getBlance() {
        return blance;
    }

    public void setBlance(String blance) {
        this.blance = blance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public UserInfo(String username, String accNo, String blance, String firstName, String lastName, String email, String nid) {
        this.username = username;
        this.accNo = accNo;
        this.blance = blance;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.nid = nid;
    }

    public UserInfo(String username, String accNo, String blance) {
        this.username = username;
        this.accNo = accNo;
        this.blance = blance;
    }
   
   
    
    
}
