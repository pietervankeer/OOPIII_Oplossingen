module gui {
	requires javafx.controls;
    requires javafx.graphics;
    requires javafx.base;
    requires javafx.fxml;
	requires java.logging;
    
    opens StartUp to javafx.graphics, javafx.fxml;
    opens gui to javafx.graphics, javafx.fxml;
}