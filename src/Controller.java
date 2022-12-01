import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Controller {
//String filePath;

    public PhoneBook getPhoneBook() {
        return phoneBook;
    }

    PhoneBook phoneBook;

    Controller(){
        this.phoneBook = new PhoneBook(new ArrayList<>());
    }

    void readPeopleFromFile(String filePath) {


        try {

            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            for (String line; (line = bufferedReader.readLine()) != null; ) {
                addPerson(line);
            }

        } catch (IOException e) {
            System.out.println("Error: wrong path!\n" + e.getMessage());
        }
    }

    public void addPerson(String personData) {
        Person personToAdd = PersonUtil.convertNameAndNumberToPerson(personData);
        this.phoneBook.add(personToAdd);
    }

    public void deletePerson(String personName) {
        Person person = this.phoneBook.findPersonByName(personName);
        this.phoneBook.remove(person);
    }
}


/*
package me.progmatic.telefonkonyv;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TextFileReader {
    public static List<String> getLinesOfTextFile(String filePath) {
        List<String> nameList = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            for (String line; (line = bufferedReader.readLine()) != null; ) {
                nameList.add(line);
            }

        } catch (IOException e) {
            System.out.println("Error: wrong path!\n" + e.getMessage());
        }

        return nameList;
    }
}
 */
