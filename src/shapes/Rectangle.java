package shapes;

import java.awt.Graphics;

/**
 * A rectangle with specified width and height.
 */
public class Rectangle implements Shape {

	protected final int width, height;

	public Rectangle(final int width, final int height) {
		if (width < 0)
			throw new IllegalArgumentException("width < 0");
		if (height < 0)
			throw new IllegalArgumentException("height < 0");
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public Location getBoundingBox() {
		// TODO implement this method
		 return null;
	}

	@Override
	public void draw(final Graphics g) {
		g.drawRect(0, 0, getWidth(), getHeight());
	}

	@Override
	public void fill(final Graphics g) {
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}
