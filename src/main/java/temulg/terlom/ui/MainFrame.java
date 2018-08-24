/*
 * Copyright (c) 2018 Alex Dubov <oakad@yahoo.com>
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package temulg.terlom.ui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import temulg.terlom.Application;

public class MainFrame implements Initializable {
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	void attachApp(Application app_) {
		app = app_;
		actionTreeController.attachApp(app_);
	}

	public static Parent load(Application app) throws Exception {
		var loader = new FXMLLoader(MainFrame.class.getResource(
			"MainFrame.fxml"
		));
		var p = loader.<Parent>load();
		loader.<MainFrame>getController().attachApp(app);
		return p;
	}

	private Application app;

	@FXML
	private ActionTree actionTreeController;
	@FXML
	private AnchorPane contentFrame;
}
