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

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
  private String from;
  
  private String password;
  
  private Session session;
  
  private MimeMessage message;
  
  ArrayList<String> to = new ArrayList<>();
  
  public Email(final String from, final String password) {
    this.from = from;
    this.password = password;
    Properties properties = new Properties();
    properties.setProperty("mail.smtp.host", "smtp.gmail.com");
    properties.setProperty("mail.smtp.port", "465");
    properties.put("mail.smtp.socketFactory.port", "465");
    properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    properties.setProperty("mail.smtp.auth", "true");
    this.session = Session.getDefaultInstance(properties, new Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(from, password);
          }
        });
    this.message = new MimeMessage(this.session);
    try {
      this.message.setFrom((Address)new InternetAddress(from));
    } catch (MessagingException messagingException) {
      Logger.getLogger(Email.class.getName()).log(Level.SEVERE, (String)null, (Throwable)messagingException);
    } 
  }
  
  public Email(String paramString1, int paramInt, final String from, final String password) {
    this.from = from;
    this.password = password;
    Properties properties = new Properties();
    properties.setProperty("mail.smtp.host", paramString1);
    properties.setProperty("mail.smtp.port", String.valueOf(paramInt));
    properties.put("mail.smtp.socketFactory.port", "465");
    properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    properties.setProperty("mail.smtp.auth", "true");
    this.session = Session.getDefaultInstance(properties, new Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(from, password);
          }
        });
    this.message = new MimeMessage(this.session);
    try {
      this.message.setFrom((Address)new InternetAddress(from));
    } catch (MessagingException messagingException) {
      Logger.getLogger(Email.class.getName()).log(Level.SEVERE, (String)null, (Throwable)messagingException);
    } 
  }
  
  public void setFrom(String paramString1, String paramString2) throws MessagingException, UnsupportedEncodingException {
    this.message.setFrom((Address)new InternetAddress(this.from, paramString2));
    this.message.setSentDate(new Date());
  }
  
  public void addRecipient(String paramString) {
    this.to.add(paramString);
  }
  
  public void setSubject(String paramString) throws MessagingException {
    this.message.setSubject(paramString);
  }
  
  public void setText(String paramString) throws MessagingException {
    this.message.setText(paramString);
  }
  
  public void setContent(Object paramObject, String paramString) throws MessagingException {
    this.message.setContent(paramObject, paramString);
  }
  
  public void addAttatchment(Multipart paramMultipart) throws MessagingException {
    this.message.setContent(paramMultipart);
  }
  
  public void send() throws MessagingException {
    for (String str : this.to)
      this.message.addRecipient(Message.RecipientType.TO, (Address)new InternetAddress(str)); 
    Transport.send((Message)this.message, this.message.getAllRecipients());
    System.out.println("Send Successfully.........");
  }
}

