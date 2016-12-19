package shapes;

import java.awt.Graphics;

/**
 * A circle with a specified radius.
 */
public class Circle implements Shape {

	protected final int radius;

	public Circle(final int radius) {
		if (radius < 0)
			throw new IllegalArgumentException("radius < 0");
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	@Override
	public Location getBoundingBox() {
		final int r = getRadius();
		return new Location(-r, -r, new Rectangle(2 * r, 2 * r));
	}

	@Override
	public void draw(final Graphics g) {
		final int r = getRadius();
		g.drawArc(-r, -r, 2 * r, 2 * r, 0, 360);
	}

	@Override
	public void fill(final Graphics g) {
		final int r = getRadius();
		g.fillArc(-r, -r, 2 * r, 2 * r, 0, 360);
	}
}
