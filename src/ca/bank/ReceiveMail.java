/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bank;

import ca.bank.MailVar;
import com.sun.mail.pop3.POP3Store;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import com.sun.mail.pop3.*;
import javax.mail.Store;

/**
 *
 * @author Chondromolllika_Ahmed
 */
public class ReceiveMail {
    
    
     public static void  receiveEmail(String host, String storeType, String username, String password) {
  try {
      
   Properties properties = new Properties();
   
   
   
   properties.setProperty("mail.imap.port", "993");
properties.setProperty("mail.imap.connectiontimeout", "4000");
properties.setProperty("mail.imap.timeout", "4000");
   
   properties.setProperty("mail.imap.ssl.enable", "true");
   
//   properties.setProperty("mail.imap.ssl.enable", "true");
//   properties.put("mail.pop3.host", pop3Host);
//   properties.put("mail.pop3.port", "995");
//   properties.put("mail.pop3.starttls.enable", "true");
//   
   
   Session emailSession = Session.getDefaultInstance(properties);

//   POP3Store emailStore = (POP3Store) emailSession.getStore(storeType);
//  // emailStore.connect(user, password);
//   emailStore.connect(pop3Host, user, password);

   
   
   Store store = emailSession.getStore("imap");
   
   store.connect(host, username, password);
   
   
   
   Folder emailFolder = store.getFolder("INBOX");
   emailFolder.open(Folder.READ_ONLY);

   Message[] messages = emailFolder.getMessages();
   MailVar.setMsg(messages);
   
   Message[] m=MailVar.getMsg();
   
   for (int i = 0; i < m.length; i++) {
	Message message = m[i];
        
        String str=message.getFrom()[0].toString();
       
        
        if(str.indexOf("CA")!=-1)
        {
	System.out.println("---------------------------------");
	System.out.println("Email Number " + (i + 1));
	System.out.println("Subject: " + message.getSubject());
        
	System.out.println("From:" + message.getFrom()[0].toString());
	System.out.println("Text: " + message.getContent().toString());
        }
        else
        {
          
        }
   }

  // emailFolder.close(false);
   //store.close();
   

  } catch (NoSuchProviderException e) {e.printStackTrace();} 
  catch (MessagingException e) {e.printStackTrace();}
  catch (IOException e) {e.printStackTrace();}
 }

 public static void main(String[] args) {

  String host = "imap.gmail.com";//change accordingly
  String mailStoreType = "imap";
  String username= "ca.bank.ghonta@gmail.com";
  String password= "ghontarpassword";//change accordingly
  
  

  receiveEmail(host, mailStoreType, username, password);

 }

}
