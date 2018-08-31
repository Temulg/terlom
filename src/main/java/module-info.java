module terlom {
	exports temulg.terlom;

	opens temulg.terlom.ui to javafx.fxml;

	requires javafx.controls;
	requires javafx.fxml;
}
