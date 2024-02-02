import com.sun.jdi.request.ClassUnloadRequest;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class AddressbookService {
    public String display(Person p){
        return p.getFirstname()+" "+p.getLastname()+" "+p.getCity()+" "+p.getState()+" "+ p.getEmail()+" "+p.getPhoneNo()+ " "+p.getZip();
    }

    public void setValues(Person p){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name");
        String fn = sc.next();
        p.setFirstname(fn);
        System.out.println("Enter last name");
        String ln = sc.next();
        p.setLastname(ln);
        System.out.println("Enter city");
        String city = sc.next();
        p.setCity(city);
        System.out.println("Enter state");
        String state = sc.next();
        p.setState(state);
        System.out.println("Enter email");
        String email = sc.next();
        p.setEmail(email);
        System.out.println("Enter phn no");
        int phNumber = sc.nextInt();
        p.setPhoneNo(phNumber);
        System.out.println("Enter zip");
        int zip = sc.nextInt();
        p.setZip(zip);
    }

    public void editDetails(String n, Addressbook addressbook){
        Iterator<Map.Entry<Integer, Person>> iterator = addressbook.contactList.entrySet().iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Person> entery = iterator.next();
            Person currentperson = entery.getValue();
            if (currentperson.getFirstname().equalsIgnoreCase(n)) {
                setValues(currentperson);
                System.out.println("updated details:");
                System.out.println(display(currentperson));
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("person not found");
        }


    }

//    public void deleteContact(String n, Addressbook addressbook) {
//        Iterator<Map.Entry<Integer, Person>> iterator = addressbook.contactList.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<Integer, Person> entry = iterator.next();
//            Person currentperson = entry.getValue();
//            if (currentperson.getFirstname().equalsIgnoreCase(n)) {
//                iterator.remove();
//                System.out.println("entry of the person is deleted");
//                break;
//            }
//            else{
//            System.out.println("inavlid, please type 'edit or 'delete'");
//        }
//    }
//    }
}