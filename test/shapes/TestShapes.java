package shapes;

import java.awt.Color;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestShapes {

	@Test
	public void testCircle() {
		Circle c = new Circle(50);
		assertEquals(50, c.getRadius());
	}

	@Test
	public void testRectangle() {
		Rectangle r = new Rectangle(80, 120);
		assertEquals(80, r.getWidth());
		assertEquals(120, r.getHeight());
	}

	@Test
	public void testLocation() {
		Location b = new Location(70, 30, new Rectangle(80, 120));
		assertEquals(70, b.getX());
		assertEquals(30, b.getY());
		Rectangle r = (Rectangle) b.getShape();
		assertEquals(80, r.getWidth());
		assertEquals(120, r.getHeight());
	}

	@Test
	public void testFill() {
		Fill f = new Fill(new Rectangle(80, 120));
		Rectangle r = (Rectangle) f.getShape();
		assertEquals(80, r.getWidth());
		assertEquals(120, r.getHeight());
	}

	@Test
	public void testStroke() {
		Stroke s = new Stroke(Color.RED, new Rectangle(80, 120));
		Rectangle r = (Rectangle) s.getShape();
		assertEquals(Color.RED, s.getColor());
		assertEquals(80, r.getWidth());
		assertEquals(120, r.getHeight());
	}

	@Test
	public void testGroupSimple() {
		Circle c = new Circle(50);
		Rectangle r = new Rectangle(100, 50);
		Group g = new Group(c, r);
		List<Shape> shapes = g.getShapes();
		assertEquals(2, shapes.size());
		assertSame(c, shapes.get(0));
		assertSame(r, shapes.get(1));
		try {
			shapes.clear();
			fail("Group.getShapes() returned mutable list!");
		} catch (Exception e) {
		}
	}
}
