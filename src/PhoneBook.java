import java.util.ArrayList;

public class PhoneBook {

  ArrayList<Person> people;

  PhoneBook(ArrayList<Person> people){
    this.people = people;
  }


  void addPerson(Person person){
    this.people.add(person);
  }

}
