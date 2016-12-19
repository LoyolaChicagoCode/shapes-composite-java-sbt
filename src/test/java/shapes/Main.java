package shapes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

  public static void main(String[] args) {
    final int padding = 20;
    // first draw the same complex group of shapes by hand
    // (without the bounding box)
    final JFrame h = new JFrame();
    h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    @SuppressWarnings("serial")
    final JPanel q =
        new JPanel() {
          @Override
          public void paintComponent(final Graphics g) {
            g.translate(-10, -60);
            g.translate(50, 100);
            g.drawArc(-20, -20, 40, 40, 0, 360);
            g.drawRect(0, 0, 100, 200);
            g.setColor(Color.RED);
            g.fillRect(150, 50, 50, 30);
            g.drawRect(150, 50, 300, 60);
            g.setColor(Color.ORANGE);
            g.translate(250, 250);
            g.fillArc(-50, -50, 100, 100, 0, 360);
          }
        };
    q.setPreferredSize(new Dimension(470 + 2 * padding, 320 + 2 * padding));
    h.setContentPane(q);
    h.pack();
    h.setVisible(true);
    // next define a complex group of shapes
    final Shape s =
        new Location(
            50,
            100,
            new Group(
                new Circle(20),
                new Rectangle(100, 200),
                new Location(
                    150,
                    50,
                    new Stroke(
                        Color.RED,
                        new Group(
                            new Fill(new Rectangle(50, 30)),
                            new Rectangle(300, 60),
                            new Location(
                                100, 200, new Stroke(Color.ORANGE, new Fill(new Circle(50)))))))));
    // calculate the bounding box
    final Location b = s.getBoundingBox();
    final Rectangle r = (Rectangle) b.getShape();
    // draw it in a frame centered around the bounding box
    final JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    @SuppressWarnings("serial")
    final JPanel p =
        new JPanel() {
          @Override
          public void paintComponent(final Graphics g) {
            g.translate(-b.getX() + padding, -b.getY() + padding);
            s.draw(g);
            s.getBoundingBox().draw(g);
          }
        };
    p.setPreferredSize(new Dimension(r.getWidth() + 2 * padding, r.getHeight() + 2 * padding));
    f.setContentPane(p);
    f.pack();
    f.setVisible(true);
  }
}
