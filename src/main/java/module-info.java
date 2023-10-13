module com.example.twouprework {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.twouprework to javafx.fxml;
    exports com.example.twouprework;
}