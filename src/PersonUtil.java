import java.util.regex.Pattern;

public class PersonUtil {

    private static Pattern pattern = Pattern.compile("[0-9]+");

    public static Person convertNameAndNumberToPerson(String nameAndNumber) throws Exception {

        String[] nameAndNumberArray = nameAndNumber.split(",");
        String name = nameAndNumberArray[0].trim();
        String phoneNumber = nameAndNumberArray[1].trim();
        if (!isNumeric(phoneNumber)) {
            throw new NotANumberException("A telefonszam nem csupan szamokat tartlamaz!");
        }
        return new Person(name, phoneNumber);

    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

}
