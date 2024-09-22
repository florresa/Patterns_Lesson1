
public class PersonBuilder {

    private String name;
    private String surname;
    private int age = -1;
    private String address;

    public PersonBuilder setName(String name) {
        checkField(name, "Name can not be null or empty");
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        checkField(surname, "Last name can not be null or empty");
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age <= 0 || age > 130) {
            throw new IllegalArgumentException("Illegal age: " + age + ". Age must be in range from 0 to 130");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        try {
            checkField(name, "Name can not be null or empty");
            checkField(surname, "Last name can not be null or empty");
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }

        return new Person(name, surname, age, address);
    }

    private void checkField(String field, String message) {
        if (field == null || field.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }
}
