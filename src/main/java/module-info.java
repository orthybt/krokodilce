module com.example.krokodilce {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.desktop;
	requires java.logging;
	requires com.fasterxml.jackson.dataformat.xml;
	requires com.fasterxml.jackson.databind;

	opens com.example.krokodilce to javafx.fxml;
	exports com.example.krokodilce;
}
