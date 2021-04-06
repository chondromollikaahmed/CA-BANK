/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bank;

import javax.mail.Message;

/**
 *
 * @author Chondromollika_Ahmed
 * 
 */
public class MailVar {
    
   private static Message[] msg;

    public static Message[] getMsg() {
        return msg;
    }

    public static void setMsg(Message[] msg) {
        MailVar.msg = msg;
    }

    
    
}
