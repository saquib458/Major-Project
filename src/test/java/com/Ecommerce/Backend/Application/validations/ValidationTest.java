package com.Ecommerce.Backend.Application.validations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;


class ValidationTest {



    @Test
    public void testPassword()
    {
        Validation validation=new Validation();
        assertTrue(validation.isValidPassword("saquib."));
    }


}