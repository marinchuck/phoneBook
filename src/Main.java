import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Controller phoneBookController = new Controller();
        View phoneBookView = new View(phoneBookController);

        phoneBookView.run();
        YamlUtil.save(phoneBookView.getPhoneBookController().getPhoneBook());

        System.exit(0);



    }
}
