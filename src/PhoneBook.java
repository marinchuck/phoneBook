import java.util.ArrayList;

public class PhoneBook {

    ArrayList<Person> people;

    PhoneBook(ArrayList<Person> people) {
        this.people = people;
    }

    void add(Person personToAdd) {
        this.people.add(personToAdd);
    }

    void remove(Person personToRemove) {
        for (int i = 0; i < people.size() ; i++) {
            if(people.get(i).getName().equals(personToRemove.getName())){
                people.remove(i);
            }
        }
    }

    Person findPersonByName(String name){
        for (var person : people) {
            if(person.getName().equals(name)){
                return person;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String phoneBook = "";
        for (var person : people
        ) {
            phoneBook += person.toString() + "\n";
        }
        return phoneBook;
    }
}
