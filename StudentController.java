package com.example.student_management_system;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.beans.property.SimpleStringProperty;

public class StudentController {

    @FXML
    private TableView<Student> studentTable;
    @FXML
    private TableColumn<Student, String> idColumn;
    @FXML
    private TableColumn<Student, String> nameColumn;
    @FXML
    private TableColumn<Student, String> majorColumn;
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField majorField;

    // List to hold the students displayed in the table
    private ObservableList<Student> studentList = FXCollections.observableArrayList();

    // Method to add a student
    @FXML
    private void addStudent(ActionEvent event) {
        String id = idField.getText();
        String name = nameField.getText();
        String major = majorField.getText();

        // Add student if all fields are filled
        if (!id.isEmpty() && !name.isEmpty() && !major.isEmpty()) {
            Student newStudent = new Student(id, name, major);
            studentList.add(newStudent);
        }

        // Clear input fields
        idField.clear();
        nameField.clear();
        majorField.clear();
    }

    // Method to delete a selected student
    @FXML
    private void deleteStudent(ActionEvent event) {
        int selectedIndex = studentTable.getSelectionModel().getSelectedIndex();
        // Remove selected student
        if (selectedIndex >= 0) {
            studentTable.getItems().remove(selectedIndex);
        }
    }

    // Initial setup for the table columns and data binding
    @FXML
    public void initialize() {
        // Binding columns to the Student object properties
        idColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        majorColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMajor()));

        // Set the student list to the table
        studentTable.setItems(studentList);
    }
}

