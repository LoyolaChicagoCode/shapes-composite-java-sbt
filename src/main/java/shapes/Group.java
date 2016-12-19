package shapes;

import java.awt.Graphics;
import java.util.Arrays;
import java.util.List;

/**
 * A composite for grouping shapes.
 */
public class Group implements Shape {

	protected final List<Shape> shapes;

	public Group(final Shape... shapes) {
		this.shapes = Arrays.asList(shapes);
	}

	public List<Shape> getShapes() {
		return shapes;
	}

	@Override
	public Location getBoundingBox() {
		// TODO implement this method
		 return null;
	}

	@Override
	public void draw(final Graphics g) {
		// TODO implement this method
	}

	@Override
	public void fill(final Graphics g) {
		// TODO implement this method
	}
}
