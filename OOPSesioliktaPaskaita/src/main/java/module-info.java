module com.example.oopsesioliktapaskaita {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires commons.csv;


    opens com.example.oopsesioliktapaskaita to javafx.fxml;
    exports com.example.oopsesioliktapaskaita;
}