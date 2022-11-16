module com.example.groupprojectcs3560 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;

    opens com.example.groupprojectcs3560 to javafx.fxml;
    exports com.example.groupprojectcs3560;
}