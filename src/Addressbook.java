import java.util.*;
import java.util.stream.Collectors;

class Addressbook {
    HashMap<Integer, Person> contactList = new HashMap<>();
    HashMap<String, List<Person>> cityDictionary = new HashMap<>();
    HashMap<String, List<Person>> stateDictionary = new HashMap<>();

    public void addPerson(AddressbookService addressBookService) {
        Person newPerson = new Person();
        addressBookService.setValues(newPerson);

        if (!isDuplicate(newPerson)) {
            int countId = contactList.size() + 1;
            contactList.put(countId, newPerson);

            // Update dictionaries
            updateCityDictionary(newPerson);
            updateStateDictionary(newPerson);

            System.out.println("Contact added with contactid: " + countId);
        } else {
            System.out.println("Duplicate entry. Person with the same name already exists.");
        }
    }

    public void searchByCityOrState(String cityOrState) {
        System.out.println("Search results in " + cityOrState + ":");
        contactList.values().stream()
                .filter(person -> person.getCity().equalsIgnoreCase(cityOrState) || person.getState().equalsIgnoreCase(cityOrState))
                .forEach(person -> System.out.println(person.toString()));
    }
    private boolean isDuplicate(Person newPerson) {
        return contactList.values().stream().anyMatch(existingPerson -> existingPerson.equals(newPerson));
    }

    private void updateCityDictionary(Person person) {
        cityDictionary.computeIfAbsent(person.getCity(), k -> new ArrayList<>()).add(person);
    }

    private void updateStateDictionary(Person person) {
        stateDictionary.computeIfAbsent(person.getState(), k -> new ArrayList<>()).add(person);
    }

    public void viewPersonsByCity(String city) {
        System.out.println("Persons in " + city + ":");
        cityDictionary.getOrDefault(city, Collections.emptyList())
                .forEach(person -> System.out.println(person.toString()));
    }

    public void viewPersonsByState(String state) {
        System.out.println("Persons in " + state + ":");
        stateDictionary.getOrDefault(state, Collections.emptyList())
                .forEach(person -> System.out.println(person.toString()));
    }

    public void display(Person person) {
        for (Map.Entry<Integer, Person> entry : contactList.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }


    }
    public long getCountByCity(String city) {
        return cityDictionary.getOrDefault(city, Collections.emptyList()).size();
    }

    public long getCountByState(String state) {
        return stateDictionary.getOrDefault(state, Collections.emptyList()).size();
    }

    public void sortEntriesByName() {
        List<Person> sortedList = contactList.values().stream()
                .sorted(Comparator.comparing(Person::getFirstname))
                .collect(Collectors.toList());

        // Print sorted entries
        System.out.println("Sorted entries by name:");
        sortedList.forEach(person -> System.out.println(person.toString()));
    }

    public void sortEntriesByCity() {
        List<Person> sortedList = contactList.values().stream()
                .sorted(Comparator.comparing(Person::getCity))
                .collect(Collectors.toList());

        // Print sorted entries
        System.out.println("Sorted entries by City:");
        sortedList.forEach(person -> System.out.println(person.toString()));
    }

    public void sortEntriesByState() {
        List<Person> sortedList = contactList.values().stream()
                .sorted(Comparator.comparing(Person::getState))
                .collect(Collectors.toList());

        // Print sorted entries
        System.out.println("Sorted entries by State:");
        sortedList.forEach(person -> System.out.println(person.toString()));
    }

    public void sortEntriesByZip() {
        List<Person> sortedList = contactList.values().stream()
                .sorted(Comparator.comparingInt(Person::getZip))
                .collect(Collectors.toList());

        // Print sorted entries
        System.out.println("Sorted entries by Zip:");
        sortedList.forEach(person -> System.out.println(person.toString()));
    }
}


