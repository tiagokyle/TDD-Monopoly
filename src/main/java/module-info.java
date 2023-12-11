module com.example.tddmonopoly {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tddmonopoly to javafx.fxml;
    exports com.example.tddmonopoly;
}