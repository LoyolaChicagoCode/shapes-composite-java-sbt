package shapes;

import java.awt.Color;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestExtendedBoundingBox {

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
		Location b = new Location(70, 30, new Rectangle(80, 120))
				.getBoundingBox();
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
		Location b = new Stroke(Color.RED, new Rectangle(80, 120))
				.getBoundingBox();
		Rectangle r = (Rectangle) b.getShape();
		assertEquals(0, b.getX());
		assertEquals(0, b.getY());
		assertEquals(80, r.getWidth());
		assertEquals(120, r.getHeight());
	}

	@Test
	public void testGroupSimple() {
		Shape s = new Group(new Location(200, 100, new Circle(50)),
				new Location(400, 300, new Rectangle(100, 50)));
		Location b = s.getBoundingBox();
		Rectangle r = (Rectangle) b.getShape();
		assertEquals(150, b.getX());
		assertEquals(50, b.getY());
		assertEquals(350, r.getWidth());
		assertEquals(300, r.getHeight());
	}

	@Test
	public void testGroupComplex() {
		final Shape s = new Location(50, 100, new Group(new Circle(20),
				new Rectangle(100, 200), new Location(150, 50, new Stroke(
						Color.RED, new Fill(new Group(new Rectangle(50, 30),
								new Outline(new Rectangle(300, 60)),
								new Stroke(Color.CYAN, new Polygon(new Point(
										50, 50), new Point(60, 100), new Point(
										100, 110), new Point(120, 60))),
								new Location(100, 200, new Stroke(Color.ORANGE,
										new Outline(new Circle(50))))))))));
		Location b = s.getBoundingBox();
		Rectangle r = (Rectangle) b.getShape();
		assertEquals(30, b.getX());
		assertEquals(80, b.getY());
		assertEquals(470, r.getWidth());
		assertEquals(320, r.getHeight());
	}

	@Test
	public void testOutline() {
		Location b = new Outline(new Rectangle(80, 120)).getBoundingBox();
		Rectangle r = (Rectangle) b.getShape();
		assertEquals(0, b.getX());
		assertEquals(0, b.getY());
		assertEquals(80, r.getWidth());
		assertEquals(120, r.getHeight());
	}

	@Test
	public void testPolygon() {
		Shape s = new Polygon(new Point(50, 50), new Point(60, 100), new Point(
				100, 110), new Point(120, 60));
		Location b = s.getBoundingBox();
		Rectangle r = (Rectangle) b.getShape();
		assertEquals(50, b.getX());
		assertEquals(50, b.getY());
		assertEquals(70, r.getWidth());
		assertEquals(60, r.getHeight());
	}
}
