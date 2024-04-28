package contactservice;

import java.util.HashMap;
import java.util.Map;
import contact.Contact; 

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    public boolean addContact(Contact contact) {
        if (contact == null || contacts.containsKey(contact.getId())) {
            return false;
        }
        contacts.put(contact.getId(), contact);
        return true;
    }

    public boolean deleteContact(String id) {
        if (id == null) {
            return false;
        }
        return contacts.remove(id) != null;
    }

    public boolean updateContact(String id, String firstName, String lastName, String phoneNumber, String address) {
        if (!contacts.containsKey(id)) {
            return false;
        }
        Contact contactToUpdate = contacts.get(id);
        updateContactFields(contactToUpdate, firstName, lastName, phoneNumber, address);
        return true;
    }

    private void updateContactFields(Contact contact, String firstName, String lastName, String phoneNumber, String address) {
        if (firstName != null && !firstName.isEmpty()) {
            contact.setFirstName(firstName);
        }
        if (lastName != null && !lastName.isEmpty()) {
            contact.setLastName(lastName);
        }
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            contact.setPhoneNumber(phoneNumber);
        }
        if (address != null && !address.isEmpty()) {
            contact.setAddress(address);
        }
    }

    // Getter for testing purposes
    public Map<String, Contact> getContacts() {
        return contacts;
    }
}
