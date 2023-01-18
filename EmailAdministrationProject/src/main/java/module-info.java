module com.example.emailadministrationproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.emailadministrationproject to javafx.fxml;
    exports com.example.emailadministrationproject;
}