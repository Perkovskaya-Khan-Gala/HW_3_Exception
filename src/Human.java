public class Human {
    String name;
    String surname;
    String patronymic;
    long phoneNumber;

    public Human(String surname, String name, String patronymic, long phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("<%s> <%s> <%s> <%s>",name,surname,patronymic,phoneNumber);
    }
}

