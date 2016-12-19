package shapes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

public class TestExtendedShapes {

	@Test
	public void testOutline() {
		Outline f = new Outline(new Rectangle(80, 120));
		Rectangle r = (Rectangle) f.getShape();
		assertEquals(80, r.getWidth());
		assertEquals(120, r.getHeight());
	}

	@Test
	public void testPolygon() {
		Point p1 = new Point(50, 50);
		Point p2 = new Point(60, 100);
		Point p3 = new Point(100, 110);
		Point p4 = new Point(120, 60);
		Polygon p = new Polygon(p1, p2, p3, p4);
		assertTrue(p instanceof Group);
		List<Point> points = p.getPoints();
		assertEquals(4, points.size());
		assertSame(p1, points.get(0));
		assertSame(p2, points.get(1));
		assertSame(p3, points.get(2));
		assertSame(p4, points.get(3));
		assertSame(p3, p.getShapes().get(2));
		try {
			points.clear();
			fail("Polygon.getPoints() returned mutable list!");
		} catch (Exception e) {
		}
	}

	@Test
	public void testPoint() {
		Point p = new Point(30, 70);
		assertTrue(p instanceof Location);
		assertEquals(30, p.getX());
		assertEquals(70, p.getY());
	}
}
