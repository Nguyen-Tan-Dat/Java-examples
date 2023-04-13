module com.dat.javasample {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.jsoup;
    requires org.json;


    opens com.dat.javasample to javafx.fxml;
    exports com.dat.javasample;
    opens com.dat.controller to javafx.fxml;
    exports com.dat.controller;
}