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
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.TextFieldTreeCell;

public class ActionTree implements Initializable {
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		actionTree.setCellFactory(this::onActionTreeEdit);
	}

	@FXML
	private void createNewGroup(ActionEvent e) {
		System.out.format("-- New group %s\n", e);
		var ti = new TreeItem<ActionTreeValue>();
		ti.setValue(new ConnGroup());

		treeRoot.getChildren().add(ti);
		actionTree.edit(ti);
	}

	private TreeCell<ActionTreeValue> onActionTreeEdit(
		TreeView<ActionTreeValue> tree	
	) {
		var cell = new ActionTreeCell();
		cell.setEditable(true);
		return cell;
	}

	@FXML
	TreeView<ActionTreeValue> actionTree;
	@FXML
	TreeItem<ActionTreeValue> treeRoot;
	@FXML
	ContextMenu actionMenu;
}
