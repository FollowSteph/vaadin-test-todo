package com.example.application.views.main;

import java.util.Objects;

public class Person {
    private static int counter = 0;
    private String name;
    private int id = counter++;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
//        return Objects.equals(name, person.name) && Objects.equals(name, person.name);
        return id == person.id;
    }

    @Override
    public String toString() {
        return name;
//        return Integer.toString(id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
