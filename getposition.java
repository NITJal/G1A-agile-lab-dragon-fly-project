import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Dragon {
	private Image dragonFly;
	private int xLoc = 0, yLoc = 0;
	public Dragon(int initialWidth, int initialHeight) {
		dragonFly = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("resources/blue_bird.png"));
		scaleDragon(initialWidth, initialHeight);
	}
	
	public Image getDragon() {
		return dragonFly;
	}
	public int getWidth() {
		try {
			return dragonFly.getWidth(null);
		}
		catch(Exception e) {
			return -1;
		}
	}
	public int getHeight() {
		try {
			return dragonFly.getHeight(null);
		}
		catch(Exception e) {
			return -1;
		}
	}
	public void setX(int x) {
		xLoc = x;
	}
	
	
	public int getX() {
		return xLoc;
	}
	public void setY(int y) {
		yLoc = y;
	}
	public int getY() {
		return yLoc;
	}
	
}