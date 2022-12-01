import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    PhoneBook phoneBook;

    Controller() {
        this.phoneBook = new PhoneBook(new ArrayList<>());
    }

    public PhoneBook getPhoneBook() {
        return phoneBook;
    }

    void readPeopleFromFile(String filePath) {

        try {

            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            for (String line; (line = bufferedReader.readLine()) != null; ) {
                try {
                    this.addPerson(line);
                } catch (Exception e) {
                    continue;
                }
            }

        } catch (IOException e) {
            System.out.println("Error: wrong path!\n" + e.getMessage());
        }
    }

    public void addPerson(String personData) throws Exception {
        Person personToAdd = PersonUtil.convertNameAndNumberToPerson(personData);
        this.phoneBook.add(personToAdd);
    }

    public void deletePerson(String personName) throws NotFoundPersonException {
        Person person = this.phoneBook.findPersonByName(personName);
        this.phoneBook.remove(person);
    }

    public String findPhoneNumberByName(String name) throws NotFoundPersonException {
        return this.phoneBook.findPersonByName(name).getPhoneNumber();
    }

    public String findNameByPhoneNumber(String phoneNumber)
        throws NotANumberException, NotFoundPersonException {
        if (PersonUtil.isNumeric(phoneNumber)) {
            return this.phoneBook.findPersonByNumber(phoneNumber).getName();
        } else {
            throw new NotANumberException("A telefonszam nem csupan szamokat tartlamaz!");
        }
    }
}

