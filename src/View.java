public class View {
  Controller phoneBookController;

View(Controller controller){
  this.phoneBookController = controller;
}

public void run(){
  printMenu(); // honnan?,
  phoneBookController.readPeopleFromFile(filepath);
}
}
