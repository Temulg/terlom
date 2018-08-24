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
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import temulg.terlom.Application;

public class ActionTree implements Initializable {
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	void attachApp(Application app_) {
		app = app_;
	}

	@FXML
	private void createNewGroup(ActionEvent e) {
		System.out.format("-- New group %s\n", e);
		var ti = new TreeItem<Object>();
		ti.setValue("Group");
		treeRoot.getChildren().add(ti);
	}

	private Application app;

	@FXML
	private TreeView actionTree;
	@FXML
	private TreeItem<Object> treeRoot;
	@FXML
	private ContextMenu actionMenu;
}
