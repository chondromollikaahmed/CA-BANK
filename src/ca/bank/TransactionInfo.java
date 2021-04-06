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
public class TransactionInfo {
    
    
    private int tranid;
    private String reference;
    private double debit;
    private double credit;
    private String date;
    private String username;
    private String acc_no;
    private String to_acc;
    private String tran_stat;
    private String concur;

    public TransactionInfo(int tranid, String reference, double debit, double credit, String date, String username, String acc_no, String to_acc, String tran_stat, String concur) {
        this.tranid = tranid;
        this.reference = reference;
        this.debit = debit;
        this.credit = credit;
        this.date = date;
        this.username = username;
        this.acc_no = acc_no;
        this.to_acc = to_acc;
        this.tran_stat = tran_stat;
        this.concur = concur;
    }

    public int getTranid() {
        return tranid;
    }

    public void setTranid(int tranid) {
        this.tranid = tranid;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(String acc_no) {
        this.acc_no = acc_no;
    }

    public String getTo_acc() {
        return to_acc;
    }

    public void setTo_acc(String to_acc) {
        this.to_acc = to_acc;
    }

    public String getTran_stat() {
        return tran_stat;
    }

    public void setTran_stat(String tran_stat) {
        this.tran_stat = tran_stat;
    }

    public String getConcur() {
        return concur;
    }

    public void setConcur(String concur) {
        this.concur = concur;
    }
    
    
    
}
