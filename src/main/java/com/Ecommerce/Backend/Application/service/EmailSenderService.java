package com.Ecommerce.Backend.Application.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmailSenderService
{
    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String toEmail,String subject,String body)
    {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("saquibmohd458@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        message.setSentDate(new Date());

        mailSender.send(message);

        System.out.println("mail send successfully");
    }



}
