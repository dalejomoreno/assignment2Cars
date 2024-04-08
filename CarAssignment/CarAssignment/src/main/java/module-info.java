module org.assignment.carassignment {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.net.http;
    requires com.google.gson;

    opens org.assignment.carassignment to javafx.fxml;
    exports org.assignment.carassignment;
    exports org.assignment.carassignment.controller;
    opens org.assignment.carassignment.controller to javafx.fxml;

    opens org.assignment.carassignment.model to com.google.gson;
}