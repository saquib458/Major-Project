package com.Ecommerce.Backend.Application.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class EmailSenderServiceTest {

    @Autowired
      EmailSenderService senderService;

    @Test
    public void testEmailSender()
    {
        senderService.sendMail("saquibmohd458@gmail.com","Testing !!!","My test case passed successfully ");

    }


}