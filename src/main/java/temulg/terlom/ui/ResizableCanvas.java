/*
 * Copyright (c) 2018 Alex Dubov <oakad@yahoo.com>
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package temulg.terlom.ui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ResizableCanvas extends Canvas {
	public ResizableCanvas() {
		System.out.format("-- canvas\n");
	}

	private void draw() {
		double width = getWidth();
		double height = getHeight();
		GraphicsContext gc = getGraphicsContext2D();
		gc.clearRect(0, 0, width, height);
		gc.setStroke(Color.RED);
		gc.strokeLine(0, 0, width, height);
		gc.strokeLine(0, height, width, 0);
	}

	@Override
	public boolean isResizable() {
		return true;
	}

	@Override
	public void resizeRelocate(
		double x, double y, double width, double height
	) {
		setWidth(width);
		setHeight(height);
		draw();
	}
}
