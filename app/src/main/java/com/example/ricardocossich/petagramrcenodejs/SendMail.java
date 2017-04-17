package com.example.ricardocossich.petagramrcenodejs;

/**
 * Created by rcossich on 23/03/2017.
 */

import android.util.Log;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

    private String user;
    private String email;

    public SendMail(String userName, String emailAddress) {
        this.user = userName;
        this.email = emailAddress;
    }
    public void GMailSender(){

        try{

            Log.d("Check","Check Properties 1");

            //Get system properties
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp-gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            Log.d("Check", "Check Properties 2");

            //Get the default session object
            Log.d("Check","Check session 1");
            Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator(){
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication("rce.coursera@gmail.com", "@csihsoa@");
                }
            });

            Log.d("Check","Check seesion 2");

            //Create message
            Log.d("Check","Message 1");
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("rce.coursera@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Password Reset");
            message.setContent("Hello","text/html; charset=utf-8");

            Log.d("Check","Message 2");

            Log.d("Check","Transport 1");
            Transport.send(message);

            Log.d("Check","Transport 2");

        }
        catch(MessagingException e){
            throw new RuntimeException(e);
        }
    }
    //get username
    public String getUser() {
        return user;
    }

    //set username
    public void setUser(String user) {
        this.user = user;
    }
    //get email address
    public String getEmail() {
        return email;
    }
    //set email address
    public void setEmail(String email) {
        this.email = email;
    }
}
