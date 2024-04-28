package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contactservice.ContactService;
import contact.Contact;

class ContactServicesTest {
    private ContactService contactService;
    private Contact contact;

    @BeforeEach
    void setUp() {
        contactService = new ContactService();
        contact = new Contact("1", "Erick", "Herrera", "7199225372", "2886 S Circle Dr");
        assertTrue(contactService.addContact(contact), "Prerequisite: Contact should be added successfully");
    }

    @Test
    void testAddContactSuccessfully() {
        Contact newContact = new Contact("2", "Jane", "Doe", "3031234567", "100 Main St");
        assertTrue(contactService.addContact(newContact), "Contact should be added successfully");
    }

    @Test
    void testAddContactFailDueToDuplicateId() {
        // Attempting to add a contact with an existing ID
        Contact duplicateIdContact = new Contact("1", "John", "Doe", "2021234567", "200 Main St");
        assertFalse(contactService.addContact(duplicateIdContact), "Contact should not be added due to duplicate ID");
    }

    @Test
    void testAddContactFailDueToNullContact() {
        assertFalse(contactService.addContact(null), "Contact should not be added because it is null");
    }

    @Test
    void testDeleteContactSuccessfully() {
        assertTrue(contactService.deleteContact(contact.getId()), "Contact should be deleted successfully");
        assertFalse(contactService.getContacts().containsKey(contact.getId()), "Contact should no longer exist after deletion");
    }

    @Test
    void testUpdateContactSuccessfully() {
        assertTrue(contactService.updateContact("1", "Erick", "Cabrera", "7199225372", "2886 S Circle Dr"), "Contact should be updated successfully");
    }
}
