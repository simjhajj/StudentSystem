package com.example.student_management_system;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty major;

    public Student(String id, String name, String major) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.major = new SimpleStringProperty(major);
    }

    // Getter methods
    public String getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public String getMajor() {
        return major.get();
    }

    // Setter methods
    public void setId(String id) {
        this.id.set(id);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setMajor(String major) {
        this.major.set(major);
    }

    // Property methods
    public StringProperty idProperty() {
        return id;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty majorProperty() {
        return major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id.get() +
                ", name=" + name.get() +
                ", major=" + major.get() +
                '}';
    }
}
