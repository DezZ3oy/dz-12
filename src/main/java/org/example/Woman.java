package org.example;

public class Woman extends Person {
    private final String originalLastName;

    public Woman(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        this.originalLastName = lastName;
    }

    public boolean isRetired() {
        return this.age > 60;
    }

    public String getOriginalLastName() {
        return originalLastName;
    }

}
