module com.example.groupprojectcs3560 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;

    opens com.example.groupprojectcs3560 to javafx.fxml;
    exports com.example.groupprojectcs3560;
    exports com.example.groupprojectcs3560.TestFiles;
    opens com.example.groupprojectcs3560.TestFiles to javafx.fxml;
    exports com.example.groupprojectcs3560.ModelClasses;
    opens com.example.groupprojectcs3560.ModelClasses to javafx.fxml;
}