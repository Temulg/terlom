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

public class ActionTree implements Initializable {
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		actionTree.setCellFactory(tree -> {
			var cell = new ActionTreeCell();
			cell.setEditable(true);
			return cell;
		});
		System.out.format("-- sc %s\n", actionTree.getScene());
	}

	@FXML
	private void createNewGroup(ActionEvent e) {
		var ti = new TreeItem<ActionTreeValue>();
		ti.setValue(new ConnGroup());

		treeRoot.getChildren().add(ti);
		actionTree.layout();
		actionTree.edit(ti);
		System.out.format("-- New group %s\n", ti);
	}

	@FXML
	TreeView<ActionTreeValue> actionTree;
	@FXML
	TreeItem<ActionTreeValue> treeRoot;
	@FXML
	ContextMenu actionMenu;
}
