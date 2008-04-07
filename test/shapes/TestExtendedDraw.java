package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import org.junit.Test;

public class TestExtendedDraw {

	@Test
	public void testSimple() {
		final Shape s = new Location(50, 100, new Fill(new Outline(new Circle(
				20))));
		final BufferedImage i = new BufferedImage(500, 500,
				BufferedImage.TYPE_INT_RGB);
		s.draw(i.getGraphics());
		final BufferedImage j = new BufferedImage(500, 500,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = j.getGraphics();
		g.translate(50, 100);
		g.drawArc(-20, -20, 40, 40, 0, 360);
		TestDraw.assertEquals(i, j);
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
		final BufferedImage i = new BufferedImage(500, 500,
				BufferedImage.TYPE_INT_RGB);
		s.draw(i.getGraphics());
		final BufferedImage j = new BufferedImage(500, 500,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = j.getGraphics();
		g.translate(50, 100);
		g.drawArc(-20, -20, 40, 40, 0, 360);
		g.drawRect(0, 0, 100, 200);
		g.setColor(Color.RED);
		g.fillRect(150, 50, 50, 30);
		g.drawRect(150, 50, 300, 60);
		g.setColor(Color.CYAN);
		g.fillPolygon(new int[] { 200, 210, 250, 270 }, new int[] { 100, 150,
				160, 110 }, 4);
		g.setColor(Color.ORANGE);
		g.translate(250, 250);
		g.drawArc(-50, -50, 100, 100, 0, 360);
		TestDraw.assertEquals(i, j);
	}

	@Test
	public void testGroupComplex2() {
		final Shape s = new Location(50, 100, new Group(new Circle(20),
				new Rectangle(100, 200), new Location(150, 50, new Stroke(
						Color.RED, new Fill(new Group(new Rectangle(50, 30),
								new Outline(new Rectangle(300, 60)),
								new Stroke(Color.CYAN, new Outline(new Polygon(new Point(
										50, 50), new Point(60, 100), new Point(
										100, 110), new Point(120, 60)))),
								new Location(100, 200, new Stroke(Color.ORANGE,
										new Outline(new Circle(50))))))))));
		final BufferedImage i = new BufferedImage(500, 500,
				BufferedImage.TYPE_INT_RGB);
		s.draw(i.getGraphics());
		final BufferedImage j = new BufferedImage(500, 500,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = j.getGraphics();
		g.translate(50, 100);
		g.drawArc(-20, -20, 40, 40, 0, 360);
		g.drawRect(0, 0, 100, 200);
		g.setColor(Color.RED);
		g.fillRect(150, 50, 50, 30);
		g.drawRect(150, 50, 300, 60);
		g.setColor(Color.CYAN);
		g.drawPolygon(new int[] { 200, 210, 250, 270 }, new int[] { 100, 150,
				160, 110 }, 4);
		g.setColor(Color.ORANGE);
		g.translate(250, 250);
		g.drawArc(-50, -50, 100, 100, 0, 360);
		TestDraw.assertEquals(i, j);
	}
}
