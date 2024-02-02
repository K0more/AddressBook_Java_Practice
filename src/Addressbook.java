import java.util.HashMap;
import java.util.Map;

public  class Addressbook {
    HashMap<Integer,Person> contactList = new HashMap<>();
    public void addperson(AddressbookService addressbookService){
        Person newperson = new Person();
        addressbookService.setValues(newperson);
        int countid = contactList.size() + 1;
        contactList.put(countid, newperson);
        System.out.println("contact added with contactid: " + countid);
    }

    public void display(Person person) {
        for (Map.Entry<Integer, Person> entry : contactList.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }
    }
}

