/*
 * Copyright (c) 2018 Alex Dubov <oakad@yahoo.com>
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package temulg.terlom.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import temulg.terlom.Application;

public class Container {
	public Container(Application app, Stage stage) throws Exception {
		var loader = new FXMLLoader(getClass().getResource(
			"MainFrame.fxml"
		));
		var p = loader.<Parent>load();
		frame = loader.<MainFrame>getController();


		stage.setTitle("Terlom");
		var s = new Scene(p);

		s.getRoot().setStyle(
			"-fx-font-size: 36;"
		);
/*
		s.widthProperty().addListener((ob, prev, next) -> {

			System.out.format("-- width %g, %g\n", prev, next);

		});
*/
		stage.setWidth(1500);
		stage.setHeight(1000);
		stage.setScene(s);
	}

	final MainFrame frame;
}
