package com.Ecommerce.Backend.Application.validations;

import org.junit.jupiter.api.Test;
import org.mockito.internal.junit.JUnitTestRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.security.RunAs;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ValidationTest {

    @Autowired
    Validation validation;

    @Test
    public void testValidPassword()
    {

        assertTrue(validation.isValidPassword("Saquib@1411"));

    }

    @Test
    public void testValidPassword2()
    {
        assertFalse(validation.isValidPassword("saquib@1411"));

    }

    @Test
    public void testValidEmail()
    {

        assertTrue(validation.isValidEmail("saquib458@gmail.com"));

    }

    @Test
    public void testValidEmail2()
    {

        assertFalse(validation.isValidEmail("saquib.gmail"));

    }


    @Test
    public void testValidMobileNo()
    {

        assertFalse(validation.isValidMobileNo("749969"));

    }

    @Test
    public void testValidMobileNo2()
    {

        assertTrue(validation.isValidMobileNo("7499692732"));

    }
}