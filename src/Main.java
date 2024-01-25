//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Person p1 = new Person();
        AddressbookService s1 = new AddressbookService();
        s1.setValues(p1);
        System.out.println(s1.display(p1));
        Addressbook a1 = new Addressbook();
        a1.contactList.put(1,p1);
        System.out.println(a1.contactList);

    }
}