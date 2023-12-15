module com.example.tddmonopoly {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires org.apache.commons.io;


    opens com.example.tddmonopoly to javafx.fxml;
    exports com.example.tddmonopoly;
}