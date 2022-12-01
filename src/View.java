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
            case "4" -> {
                printInstruction("Kerlek add meg a nevet az illetonek");
                printPhoneNumberByName();
            }
            case "5" -> {
                printInstruction("Kerlek add meg a telefonszamat az illetonek");
                printNameByPhoneNumber();
            }
            case "x" -> System.exit(0);
            default -> printInstruction("Nem ertelmezheto input, kerlek probald meg ujra!");
        }
    }

    private void printNameByPhoneNumber() {
        try {
            String phoneNumber = getInput();
            System.out.println(phoneBookController.findNameByPhoneNumber(phoneNumber));
        } catch (NotANumberException e) {
            System.out.println(e.getMessage());
            this.printInstruction("Probald meg ujra!");
            this.printNameByPhoneNumber();
        } catch (NotFoundPersonException e) {
            System.out.println("Nincs ilyen telefonszam a konyvben.");
        } catch (Exception e) {
            System.out.println("Valami nem jo, probald ujra!");
            this.printNameByPhoneNumber();
        }
    }

    private void printPhoneNumberByName() {
        try {
            String personName = getInput();
            System.out.println(phoneBookController.findPhoneNumberByName(personName));
        } catch (NotFoundPersonException e) {
            System.out.println(e.getMessage());
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
        } catch (NotANumberException e) {
            System.out.println(e.getMessage());
            this.printInstruction("Probald meg ujra!");
            this.addPerson();
        } catch (Exception e) {
            System.out.println("Valami nem jo, probald ujra!");
            this.addPerson();
        }
    }

    void printMenu() {
        System.out.println();
        System.out.println("1 - Add meg a file inputot");
        System.out.println("2 - Torles a telefonkonyvbol");
        System.out.println("3 - Hozzaadas a telefonkonyvhoz");
        System.out.println("4 - Telefonszam keresese nev alapjan");
        System.out.println("5 - Nev keresese telefonszam alapjan");
        System.out.println("x - Kilepes");
        System.out.println();
    }

    void readPeopleFromFile() {
        String filePath = getInput();
        phoneBookController.readPeopleFromFile(filePath);
    }

    void deletePerson() {
        try {
            String personName = getInput();
            phoneBookController.deletePerson(personName);
        } catch (NotFoundPersonException e) {
            System.out.println(e.getMessage());
        }
    }
}
