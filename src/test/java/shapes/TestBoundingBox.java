package shapes;

import static org.junit.Assert.*;

import java.awt.Color;
import org.junit.Test;

public class TestBoundingBox {

  @Test
  public void testCircle() {
    Location b = new Circle(50).getBoundingBox();
    Rectangle r = (Rectangle) b.getShape();
    assertEquals(-50, b.getX());
    assertEquals(-50, b.getY());
    assertEquals(100, r.getWidth());
    assertEquals(100, r.getHeight());
  }

  @Test
  public void testRectangle() {
    Location b = new Rectangle(80, 120).getBoundingBox();
    Rectangle r = (Rectangle) b.getShape();
    assertEquals(0, b.getX());
    assertEquals(0, b.getY());
    assertEquals(80, r.getWidth());
    assertEquals(120, r.getHeight());
  }

  @Test
  public void testLocation() {
    Location b = new Location(70, 30, new Rectangle(80, 120)).getBoundingBox();
    Rectangle r = (Rectangle) b.getShape();
    assertEquals(70, b.getX());
    assertEquals(30, b.getY());
    assertEquals(80, r.getWidth());
    assertEquals(120, r.getHeight());
  }

  @Test
  public void testFill() {
    Location b = new Fill(new Rectangle(80, 120)).getBoundingBox();
    Rectangle r = (Rectangle) b.getShape();
    assertEquals(0, b.getX());
    assertEquals(0, b.getY());
    assertEquals(80, r.getWidth());
    assertEquals(120, r.getHeight());
  }

  @Test
  public void testStroke() {
    Location b = new Stroke(Color.RED, new Rectangle(80, 120)).getBoundingBox();
    Rectangle r = (Rectangle) b.getShape();
    assertEquals(0, b.getX());
    assertEquals(0, b.getY());
    assertEquals(80, r.getWidth());
    assertEquals(120, r.getHeight());
  }

  @Test
  public void testGroupSimple() {
    Shape s =
        new Group(
            new Location(200, 100, new Circle(50)), new Location(400, 300, new Rectangle(100, 50)));
    Location b = s.getBoundingBox();
    Rectangle r = (Rectangle) b.getShape();
    assertEquals(150, b.getX());
    assertEquals(50, b.getY());
    assertEquals(350, r.getWidth());
    assertEquals(300, r.getHeight());
  }

  @Test
  public void testGroupComplex() {
    Shape s =
        new Location(
            50,
            100,
            new Fill(
                new Group(
                    new Circle(20),
                    new Location(
                        150,
                        50,
                        new Stroke(
                            Color.RED,
                            new Group(
                                new Rectangle(50, 30),
                                new Rectangle(300, 60),
                                new Location(
                                    100,
                                    200,
                                    new Stroke(Color.ORANGE, new Fill(new Circle(50))))))),
                    new Rectangle(100, 200))));
    Location b = s.getBoundingBox();
    Rectangle r = (Rectangle) b.getShape();
    assertEquals(30, b.getX());
    assertEquals(80, b.getY());
    assertEquals(470, r.getWidth());
    assertEquals(320, r.getHeight());
  }
}
