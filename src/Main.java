public class Main {

    public static void main(String[] args) {

        Controller phoneBookController = new Controller();
        View phoneBookView = new View(phoneBookController);

        phoneBookView.run();

    }
}
