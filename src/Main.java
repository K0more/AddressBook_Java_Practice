import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


    public class Main {
        public static void main(String[] args) {
            Map<String, Addressbook> addressbooks = new HashMap<>();
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("Enter 1 to create a new address book, 2 to select an existing address book:");
                int action = sc.nextInt();
                switch (action) {
                    case 1:
                        System.out.println("Enter the name for the new address book:");
                        String newAddressBookName = sc.next();
                        addressbooks.put(newAddressBookName, new Addressbook());
                        System.out.println("Address book '" + newAddressBookName + "' created.");
                        break;

                    case 2:
                        System.out.println("Enter the name of the address book you want to select:");
                        String selectedAddressBookName = sc.next();
                        Addressbook selectedAddressBook = addressbooks.get(selectedAddressBookName);
                        if (selectedAddressBook == null) {
                            System.out.println("Address book '" + selectedAddressBookName + "' not found.");
                        } else {
                            performAddressBookOperations(selectedAddressBook);
                        }
                        break;

                    default:
                        System.out.println("Invalid action. Please try again.");
                }
            }
        }

        public static void performAddressBookOperations(Addressbook addressbook) {
            AddressbookService addressbookService = new AddressbookService();
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("Enter 1 to add a person, 2 to edit contacts, 3 to delete contacts, 4 to display Addressbook, 5 to search by city, 6 to change addressbook 7 to view persons by city, 8 to view persons by state, 9 to get count by city, 10 to get count by state, 11 to sort entries by name, 12 to sort entries by city, 13 to sort entries by state, 14 to sort entries by zip:");
                int action = sc.nextInt();

                switch (action) {
                    case 1:
                        addressbook.addPerson(addressbookService);
                        break;

                    case 2:
                        System.out.println("Enter the name you want to edit:");
                        String nameToEdit = sc.next();
                        addressbookService.editDetails(nameToEdit, addressbook);
                        break;

                    case 3:
                        System.out.println("Enter the name you want to delete:");
                        String nameToDelete = sc.next();
                        addressbookService.deleteContact(nameToDelete, addressbook);
                        break;
                    case 4:
                        System.out.println("Address Book:");
                        for (Person person : addressbook.contactList.values()) {
                            addressbook.display(person);
                            break;
                        }
                    case 5:
                        System.out.println("Enter the city or state to search:");
                        String cityOrStateToSearch = sc.next();
                        addressbook.searchByCityOrState(cityOrStateToSearch);
                        break;

                        case 6:
                        return; // Return to main menu

                    case 7:
                        System.out.println("Enter the city to view persons:");
                        String cityToView = sc.next();
                        addressbook.viewPersonsByCity(cityToView);
                        break;

                    case 8:
                        System.out.println("Enter the state to view persons:");
                        String stateToView = sc.next();
                        addressbook.viewPersonsByState(stateToView);
                        break;

                    case 9:
                        System.out.println("Enter the city to get count:");
                        String cityToGetCount = sc.next();
                        long countByCity = addressbook.getCountByCity(cityToGetCount);
                        System.out.println("Count of persons in " + cityToGetCount + ": " + countByCity);
                        break;

                    case 10:
                        System.out.println("Enter the state to get count:");
                        String stateToGetCount = sc.next();
                        long countByState = addressbook.getCountByState(stateToGetCount);
                        System.out.println("Count of persons in " + stateToGetCount + ": " + countByState);
                        break;

                    case 11:
                        addressbook.sortEntriesByName();
                        break;

                    case 12:
                        addressbook.sortEntriesByCity();
                        break;

                    case 13:
                        addressbook.sortEntriesByState();
                        break;

                    case 14:
                        addressbook.sortEntriesByZip();
                        break;
                }
            }
        }
    }

