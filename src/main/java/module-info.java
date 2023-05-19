module com.example.krokodilce {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.datatransfer;
	requires java.desktop;


	opens com.example.krokodilce to javafx.fxml;
    exports com.example.krokodilce;
}
