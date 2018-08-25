/*
 * Copyright (c) 2018 Alex Dubov <oakad@yahoo.com>
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package temulg.terlom.ui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;

public class MainFrame implements Initializable {
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		for (var d: mainFrame.getDividerPositions()) {
			System.out.format("-- div %g\n", d);
		}
	}

	@FXML
	SplitPane mainFrame;
	@FXML
	ActionTree actionTreeController;
	@FXML
	AnchorPane contentFrame;
}
