public class Person {

private final String name;

  public String getName() {
    return name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  private final String phoneNumber;

  public Person(String name, String phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

    @Override
    public String toString() {
    return this.name + " - " + this.phoneNumber;
    }
}
