package shapes;

import java.awt.Graphics;

/**
 * A decorator indicating that a shape should be drawn as a filled shape instead of an outlined one.
 */
public class Fill implements Shape {

  protected final Shape shape;

  public Fill(final Shape shape) {
    this.shape = shape;
  }

  public Shape getShape() {
    return shape;
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
