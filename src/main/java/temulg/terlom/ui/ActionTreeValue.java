/*
 * Copyright (c) 2018 Alex Dubov <oakad@yahoo.com>
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package temulg.terlom.ui;

import javafx.scene.Node;
import javafx.scene.control.TreeCell;

interface ActionTreeValue {
	Node visibleNode();

	Node editableNode(TreeCell<ActionTreeValue> cell);

	void startEdit();
	void cancelEdit();
	void commitEdit();
}
