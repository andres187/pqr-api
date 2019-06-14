package com.uninorte.proyecto.whatsapp;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Whatsapp {
   // Replace these placeholders with your Account Sid and Auth Token
   public static final String ACCOUNT_SID = "ACc1b7706205284574dfd918c9873d9df2";
   public static final String AUTH_TOKEN = "d6d8a7d92109834db42be4418278a42a";

   public void enviar() {
       Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
       Message message = Message.creator(
               new com.twilio.type.PhoneNumber("whatsapp:+573012693220"),
               new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
               "join pig-pig")
           .create();
       
       System.out.println(message.getSid());
   }
}