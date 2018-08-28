/*
 * Copyright (c) 2018 Alex Dubov <oakad@yahoo.com>
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package temulg.terlom.ui;

import java.lang.ref.WeakReference;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.WeakInvalidationListener;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;

class DefaultTreeCell extends TreeCell<ActionTreeValue> {
	public DefaultTreeCell() {
		treeItemProperty().addListener(weakTreeItemListener);

		if (getTreeItem() != null) {
			getTreeItem().graphicProperty().addListener(
				weakTreeItemGraphicListener
			);
		}
	}

	void updateDisplay(ActionTreeValue item, boolean empty) {
		setText(null);

		if (item != null && !empty)
			setGraphic(item.visibleNode());
		else
			setGraphic(null);
	}

	@Override
	public void updateItem(ActionTreeValue item, boolean empty) {
		super.updateItem(item, empty);
		updateDisplay(item, empty);
	}

	private WeakReference<TreeItem<ActionTreeValue>> treeItemRef;

	private final InvalidationListener treeItemGraphicListener
	= observable -> {
		updateDisplay(getItem(), isEmpty());
	};

	private final InvalidationListener treeItemListener
	= new InvalidationListener() {
		@Override
		public void invalidated(Observable observable) {
			TreeItem<ActionTreeValue> oldTreeItem
				= treeItemRef == null
				? null : treeItemRef.get();

			if (oldTreeItem != null)
				oldTreeItem.graphicProperty().removeListener(
					weakTreeItemGraphicListener
				);

    
			TreeItem<ActionTreeValue> newTreeItem = getTreeItem();

			if (newTreeItem != null) {
				newTreeItem.graphicProperty().addListener(
					weakTreeItemGraphicListener
				);
				treeItemRef = new WeakReference<TreeItem<ActionTreeValue>>(
					newTreeItem
				);
			}
		}
	};

	private WeakInvalidationListener weakTreeItemGraphicListener
		= new WeakInvalidationListener(treeItemGraphicListener);

	private WeakInvalidationListener weakTreeItemListener
		= new WeakInvalidationListener(treeItemListener);
}
