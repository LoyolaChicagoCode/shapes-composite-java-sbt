package shapes;

import java.awt.Graphics;

/** A decorator for specifying a shape's location. */
public class Location implements Shape {

  protected final int x, y;

  protected final Shape shape;

  public Location(final int x, final int y, final Shape shape) {
    this.x = x;
    this.y = y;
    this.shape = shape;
  }

  public Shape getShape() {
    return shape;
  }

  int getX() {
    return x;
  }

  int getY() {
    return y;
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
