import java.util.Scanner;

public class View {

    Controller phoneBookController;
    Scanner sc;

    View(Controller controller) {
        this.phoneBookController = controller;
        this.sc = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            printMenu();
            runTask(sc.nextLine());
        }
    }

    void runTask(String option) {
        switch (option) {
            case "1" -> readPeopleFromFile();
            case "2" -> deletePerson();
            case "3" -> addPerson();
            case "x" -> System.exit(0);
        }
    }

    void addPerson() {
        String personData = sc.nextLine();
        phoneBookController.addPerson(personData);
    }

    void printMenu() {
        System.out.println("1 - Add meg a file inputot");
        System.out.println("2 - Torles a telefonkonyvbol");
        System.out.println("3 - Hozzaadas a telefonkonyvhoz");
        System.out.println("x - Kilepes");
    }

    void readPeopleFromFile() {
        String filePath = sc.nextLine();
        phoneBookController.readPeopleFromFile(filePath);
    }

    void deletePerson() {
        String personName = sc.nextLine();
        phoneBookController.deletePerson(personName);
    }
}
