package shapes;

import java.awt.Graphics;

/**
 * A graphical shape.
 */
public interface Shape {
	
	/**
	 * Draws this shape to a Graphics object in outline mode.
	 * 
	 * @param g the Graphics object
	 */
	void draw(Graphics g);

	/**
	 * Draws this shape to a Graphics object in fill mode.
	 * 
	 * @param g the Graphics object
	 */
	void fill(Graphics g);

	/**
	 * Calculates the bounding box (smallest enclosing rectangle) for this shape.
	 * 
	 * @return the bounding box
	 */
	Location getBoundingBox();
	
	// TODO add the size method
}
