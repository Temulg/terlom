/*
 * Copyright (c) 2018 Alex Dubov <oakad@yahoo.com>
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package temulg.terlom;

import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import temulg.terlom.ui.MainFrame;

public class Application extends javafx.application.Application {
	public static void main(String... args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Terlom");
		primaryStage.setScene(new Scene(
			MainFrame.load(this), 1024, 768
		));
		primaryStage.show();
	}

	void queryScreens() {
		var gs = Screen.getScreens();
		for (var s: gs) {
			double dpi = s.getDpi();
			double scaleX = s.getOutputScaleX();
			double scaleY = s.getOutputScaleY();

			System.out.format(
				"-- screen %s: dpi %g, sx %g, sy %g\n",
				s, dpi, scaleX, scaleY
			);
		}
	}
}
