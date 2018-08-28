/*
 * Copyright (c) 2018 Alex Dubov <oakad@yahoo.com>
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package temulg.terlom.ui;

import javafx.scene.AccessibleRole;
import javafx.scene.Node;
import javafx.scene.control.Labeled;
import javafx.scene.control.Skin;
import javafx.scene.control.skin.LabeledSkinBase;

class ConnGroup extends Labeled implements ActionTreeValue {
	@Override
	public Node visibleNode() {
		return visibleNode;
	}

	private class VisibleNode extends Labeled {
		VisibleNode() {
			super("New group");
			getStyleClass().setAll("label");
			setAccessibleRole(AccessibleRole.TEXT);	
		}

		@Override
		protected Skin<?> createDefaultSkin() {
			return new VisibleNodeSkin(this);
		}	
	}

	private static class VisibleNodeSkin
	extends LabeledSkinBase<VisibleNode> {
		private VisibleNodeSkin(final VisibleNode control) {
			super(control);
		}
	}

	private final VisibleNode visibleNode = new VisibleNode();
}
