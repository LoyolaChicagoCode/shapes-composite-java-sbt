package shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * A decorator for specifying the stroke (foreground) color for drawing the
 * shape.
 */
public class Stroke implements Shape {

	// TODO entirely your job
	// XXX remove instance variables and method bodies

	public Stroke(final Color color, final Shape shape) {
	}

	public Color getColor() {
		return null;
	}

	public Shape getShape() {
		return null;
	}

	@Override
	public Location getBoundingBox() {
		return null;
	}

	@Override
	public void draw(final Graphics g) {
	}

	@Override
	public void fill(final Graphics g) {
	}
}
