package HomeWork3;

public class People {
    private final String SURNAME;
    private final String PHONE_NUMBER;

    public People(String surname, String phoneNumber) {
        this.SURNAME = surname;
        this.PHONE_NUMBER = phoneNumber;
    }

    public  String getSurname() {
        return SURNAME;
    }

    public String getPhoneNumber() {
        return PHONE_NUMBER;
    }
}
