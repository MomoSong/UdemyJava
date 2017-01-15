import java.util.ArrayList;

/**
 * Created by johnm on 2017-01-15.
 */

//Quit, print list of contacts, add new contact, update existing contact, remove contact
// and search/find contact.
public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> contactList;

    public void setMyPhone(String myPhone) {
        this.myNumber = myPhone;
    }

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.contactList = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("contact is already on file");
            return false;
        }
        contactList.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldOne, Contact newOne) {
        int foundPosition = findContact(oldOne);
        if (foundPosition < 0) {
            System.out.println(oldOne.getName() + ", was not found.");
            return false;
        }
        this.contactList.set(foundPosition, newOne);
        System.out.println(oldOne.getName() + ", was replaced with " + newOne.getName());
        return true;
    }

    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            System.out.println(contact.getName() + ", was not found.");
            return false;
        }
        this.contactList.remove(foundPosition);
        System.out.println(contact.getName() + ", was deleted.");
        return true;
    }

    private int findContact(Contact contact) {
        return this.contactList.indexOf(contact);
    }

    private int findContact(String contactName) {
        for (int i = 0; i < this.contactList.size(); i++) {
            Contact contact = this.contactList.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return this.contactList.get(position);
        }
        return null;
    }

    public String queryContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }

    public void printContact() {
        System.out.println("Contact List");
        for (int i = 0; i < this.contactList.size(); i++) {
            System.out.println((i + 1) + "." + this.contactList.get(i).getName() + " -> " +
                    this.contactList.get(i).getPhoneNum());
        }


    }
}
