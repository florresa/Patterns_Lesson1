import java.util.Objects;

public class Person {

    private final String name;
    private final String surname;
    private int age = -1;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, String city) {
        this.name = name;
        this.surname = surname;
        this.address = city;
    }

    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = city;
    }

    public boolean hasAge() {
        return age > -1;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAddress(address);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", фамилия: " + surname + ", возраст: " + (hasAge() ? age : "неизвестно") +
                ", город: " + (hasAddress() ? address : "неизвестно");
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}

