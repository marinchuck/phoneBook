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
            runTask(getInput());
        }
    }

    void runTask(String option) {
        switch (option) {
            case "1" -> {
                printInstruction("Kerlek add meg az eleresi utvonalat!");
                readPeopleFromFile();
                printPhoneBook();
            }
            case "2" -> {
                printInstruction("Kerlek add meg a nevet az illetonek!");
                deletePerson();
                printPhoneBook();
            }
            case "3" -> {
                printInstruction("Kerlek add meg az emberunk adatait vesszovel elvalasztva!");
                addPerson();
                printPhoneBook();
            }
            case "x" -> System.exit(0);
        }
    }

    private void printInstruction(String s) {
        System.out.println(s);
    }

    void printPhoneBook() {
        System.out.println(this.phoneBookController.getPhoneBook().toString());
    }

    String getInput() {
        String input = sc.nextLine();
        return input;
    }

    void addPerson() {
        try {
            String personData = getInput();
            phoneBookController.addPerson(personData);
        }
        catch(NotANumberException e){
            System.out.println(e.getMessage());
            this.addPerson();
        }
        catch (Exception e) {
            System.out.println("Valami nem jo, probald ujra!");
            this.addPerson();
        }
    }

    void printMenu() {
        System.out.println("1 - Add meg a file inputot");
        System.out.println("2 - Torles a telefonkonyvbol");
        System.out.println("3 - Hozzaadas a telefonkonyvhoz");
        System.out.println("x - Kilepes");
    }

    void readPeopleFromFile() {
        String filePath = getInput();
        phoneBookController.readPeopleFromFile(filePath);
    }

    void deletePerson() {
        String personName = getInput();
        phoneBookController.deletePerson(personName);
    }
}
