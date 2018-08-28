/*
 * Copyright (c) 2018 Alex Dubov <oakad@yahoo.com>
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package temulg.terlom.ui;

import javafx.scene.Node;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;

public class ActionTreeCell extends DefaultTreeCell {
	public ActionTreeCell() {
		getStyleClass().add("text-field-tree-cell");
	}

	@Override
	public void startEdit() {
		if (!isEditable() || !getTreeView().isEditable())
			return;

		super.startEdit();

		if (isEditing()) {
			if (textField == null)
				createTextField();

			textField.setText(itemText());
			setText(null);
			setGraphic(textField);

			textField.selectAll();
			textField.requestFocus();
		}
	}

	private String itemText() {
		return ((Labeled)getItem().visibleNode()).getText();
	}

	private ActionTreeValue setItemText(String value) {
		((Labeled)getItem().visibleNode()).setText(value);
		return getItem();
	}

	private void createTextField() {
		textField = new TextField(itemText());

		textField.setOnAction(event -> {
			commitEdit(setItemText(
				textField.getText()
			));
			event.consume();
		});
		textField.setOnKeyReleased(t -> {
			if (t.getCode() == KeyCode.ESCAPE) {
				cancelEdit();
				t.consume();
			}
		});
	}

	@Override
	public void cancelEdit() {
		super.cancelEdit();
	}

	@Override
	public void updateItem(ActionTreeValue item, boolean empty) {
		super.updateItem(item, empty);

		if (isEmpty()) {
			setGraphic(null);
		} else {
			if (isEditing()) {
				if (textField != null)
					textField.setText(itemText());

				setGraphic(textField);
			} else {
				setGraphic(item.visibleNode());
			}
		}
	}

	private TextField textField;
}
