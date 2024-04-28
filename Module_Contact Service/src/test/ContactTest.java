package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import contact.Contact;

class ContactTest {
    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("042395", "Erick", "Herrera", "7199225372", "2686 S Circle Dr");
    }

    @Test
    void testGetters() {
        assertEquals("042395", contact.getId());
        assertEquals("Erick", contact.getFirstName());
        assertEquals("Herrera", contact.getLastName());
        assertEquals("7199225372", contact.getPhoneNumber());
        assertEquals("2686 S Circle Dr", contact.getAddress());
    }

    @Test
    void testIdTooLong() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678910", "", "", "7199225372", "");
        });
        assertEquals("Invalid Id", exception.getMessage());
    }

    @Test
    void testFirstNameTooLong() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("", "Erick Miguel", "", "7199225372", "");
        });
        assertEquals("Invalid first name", exception.getMessage());
    }

    @Test
    void testLastNameTooLong() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("", "", "HerreraCabrera", "7199225372", "");
        });
        assertEquals("Invalid last name", exception.getMessage());
    }

    @Test
    void testInvalidPhoneNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("", "", "", "17199225372", "");
        });
        assertEquals("Invalid phone number", exception.getMessage());
    }

    @Test
    void testAddressTooLong() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("", "", "", "7199225372", "2686 S Circle Drive, Unit 2053, Colorado Springs, Colorado, 80906");
        });
        assertEquals("Invalid address", exception.getMessage());
    }
}
