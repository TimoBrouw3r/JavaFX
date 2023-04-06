module nl.saxion.re {
    requires javafx.controls;
    requires javafx.fxml;

    opens nl.saxion.re to javafx.fxml;
    exports nl.saxion.re;
    exports nl.saxion.re.views;
    opens nl.saxion.re.views to javafx.fxml;
    exports nl.saxion.re.types;
    opens nl.saxion.re.types to javafx.fxml;
    exports nl.saxion.re.components;
    opens nl.saxion.re.components to javafx.fxml;


}
