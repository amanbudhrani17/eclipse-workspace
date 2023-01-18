module com.example.filechooser {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.filechooser to javafx.fxml;
    exports com.example.filechooser;
}