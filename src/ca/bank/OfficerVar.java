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
public class OfficerVar {
    
    
    private static String user;
    private static String name;
    private static String nid;
    private static String mobile;
    private static String email;
    private static String officer_no;

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        OfficerVar.user = user;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String aName) {
        name = aName;
    }

    public static String getNid() {
        return nid;
    }

    public static void setNid(String aNid) {
        nid = aNid;
    }

    public static String getMobile() {
        return mobile;
    }

    public static void setMobile(String aMobile) {
        mobile = aMobile;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String aEmail) {
        email = aEmail;
    }

    public static String getOfficer_no() {
        return officer_no;
    }

    public static void setOfficer_no(String aOfficer_no) {
        officer_no = aOfficer_no;
    }
    
}
