module com.example.coproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.coproject to javafx.fxml;
    exports com.example.coproject;
}