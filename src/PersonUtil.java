public class PersonUtil {

    public static Person convertNameAndNumberToPerson(String nameAndNumber){
        String[] nameAndNumberArray = nameAndNumber.split(",");
        return new Person(nameAndNumberArray[0], nameAndNumberArray[1]);
    }

}
