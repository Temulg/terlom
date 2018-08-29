/*
 * Copyright (c) 2018 Alex Dubov <oakad@yahoo.com>
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package temulg.terlom.ui;

import javafx.scene.AccessibleRole;
import javafx.scene.Node;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeCell;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

class ConnGroup extends Labeled implements ActionTreeValue {
	@Override
	public Node visibleNode() {
		return visibleNode;
	}

	@Override
	public Node editableNode(TreeCell<ActionTreeValue> cell) {
		if (editableNode == null)
			editableNode = new EditableNode(cell);

		return editableNode;
	}

	@Override
	public void startEdit() {
		if (editableNode != null) {
			editableNode.selectAll();
			editableNode.requestFocus();
		}
	}

	@Override
	public void cancelEdit() {
		editableNode = null;
	}

	@Override
	public void commitEdit() {
		editableNode = null;
	}

	private class VisibleNode extends HBox {
		VisibleNode() {
			text = new Text("New Group");
			getChildren().add(text);
			getStyleClass().setAll("label");
			setAccessibleRole(AccessibleRole.TEXT);	
		}

		private String getText() {
			return text.getText();
		}

		private void setText(String s) {
			text.setText(s);
		}

		private final Text text;
	}

	private class EditableNode extends TextField {
		EditableNode(TreeCell<ActionTreeValue> cell) {
			super(visibleNode.getText());

			setOnAction(event -> {
				visibleNode.setText(getText());
				cell.commitEdit(ConnGroup.this);
				event.consume();
			});

			setOnKeyReleased(t -> {
				if (t.getCode() == KeyCode.ESCAPE) {
					cell.cancelEdit();
					t.consume();
				}
			});
		}
	}

	private final VisibleNode visibleNode = new VisibleNode();
	private EditableNode editableNode;
}
