module nl.saxion.re {
    requires javafx.controls;
    requires javafx.fxml;

    opens nl.saxion.re to javafx.fxml;
    exports nl.saxion.re;
}
