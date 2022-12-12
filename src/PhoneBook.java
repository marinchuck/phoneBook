import java.util.ArrayList;

public class PhoneBook {

    private ArrayList<Person> people;

    PhoneBook(ArrayList<Person> people) {
        this.people = people;
    }

    public PhoneBook() {
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    void add(Person personToAdd) {
        this.people.add(personToAdd);
    }

    void remove(Person personToRemove) {
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getName().equals(personToRemove.getName())) {
                people.remove(i);
            }
        }
    }

    Person findPersonByName(String name) throws NotFoundPersonException {
        for (var person : people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        throw new NotFoundPersonException("Nincs ilyen nevu ember a telefonkonyvben!");
    }

    @Override
    public String toString() {
        String phoneBook = "";
        for (var person : people) {
            phoneBook += person.toString() + "\n";
        }
        return phoneBook;
    }

    public Person findPersonByNumber(String phoneNumber) throws NotFoundPersonException {
        for (var person : people) {
            if (person.getPhoneNumber().equals(phoneNumber)) {
                return person;
            }
        }
        throw new NotFoundPersonException("Nincs ilyen telefonszam a telefonkonyvben!");
    }
}
