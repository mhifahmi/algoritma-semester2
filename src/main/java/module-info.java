module com.algoritmadanpemrograman.tugass2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.algoritmadanpemrograman.tugass2 to javafx.fxml;
    exports com.algoritmadanpemrograman.tugass2;
}