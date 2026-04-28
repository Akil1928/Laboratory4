package controller;

import domain.ListException;
import domain.SinglyLinkedList;
import domain.Student;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class StudentController
{
    @javafx.fxml.FXML
    private BorderPane bp;
    @javafx.fxml.FXML
    private TableView<Student> studentTableview;
    @javafx.fxml.FXML
    private TableColumn<Student, String> idTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Student, String> nameTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Student, Integer> ageTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Student, String> addressTableColumn;

    private SinglyLinkedList studentList;
    private Alert alert;

    @javafx.fxml.FXML
    public void initialize() {
        this.studentList = util.Utility.getStudentList();
        alert = util.FXUtility.alert("Student List", "Display Student");
        alert.setAlertType(Alert.AlertType.ERROR);

        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        ageTableColumn.setCellValueFactory(new PropertyValueFactory<>("Age"));
        addressTableColumn.setCellValueFactory(new PropertyValueFactory<>("Address"));

        try {
            updateTableView();
        } catch (ListException ex) {
            alert.setContentText("Student list is empty");
            alert.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void clearOnAction(ActionEvent actionEvent) {
        this.studentList.clear();
        util.Utility.setStudentList(this.studentList);
        alert.setContentText("The list was deleted");
        alert.setAlertType(Alert.AlertType.INFORMATION);
        alert.showAndWait();
        try {
            updateTableView();
        } catch (ListException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void addOnAction(ActionEvent actionEvent) {
        util.FXUtility.loadPage("ucr.lab.HelloApplication", "/addStudent.fxml", bp);
    }

    @javafx.fxml.FXML
    public void addFirstOnAction(ActionEvent actionEvent) {
        util.FXUtility.loadPage("ucr.lab.HelloApplication", "/addFirstStudent.fxml", bp);
    }

    @javafx.fxml.FXML
    public void addSortedOnAction(ActionEvent actionEvent) {
        util.FXUtility.loadPage("ucr.lab.HelloApplication", "/addSortedStudent.fxml", bp);
    }

    @javafx.fxml.FXML
    public void removeOnAction(ActionEvent actionEvent) {

        Student selectedStudent = studentTableview.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            try {
                studentList.remove(selectedStudent);
            } catch (ListException e) {
                throw new RuntimeException(e);
            }
            util.Utility.setStudentList(studentList);
            alert.setContentText("Student removed from the list");
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.showAndWait();
            try {
                updateTableView();
            } catch (ListException e) {
                throw new RuntimeException(e);
            }
        } else {
            alert.setContentText("No student selected for removal");
            alert.showAndWait();
        }
    }

    private void updateTableView() throws ListException {
        this.studentTableview.getItems().clear();
        this.studentList = util.Utility.getStudentList();
        if (studentList != null && !studentList.isEmpty()) {
            for (int i = 1; i <= studentList.size(); i++) {
                this.studentTableview.getItems().add((Student) studentList.getNode(i).data);
            }
        }
    }
}
