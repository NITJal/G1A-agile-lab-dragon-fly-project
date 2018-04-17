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
	//scale dragon
	public void scaleDragon(int width, int height) {
		dragonFly = dragonFly.getScaledInstance(width, height, Image.SCALE_SMOOTH);		
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
	//set n get coordinates
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
	//outlining of dragon
	public Rectangle getRectangle() {
		return (new Rectangle(xLoc, yLoc, dragonFly.getWidth(null), dragonFly.getHeight(null)));
	}
	//buffered image for dragon
	public BufferedImage getBI() {
		BufferedImage bi = new BufferedImage(dragonFly.getWidth(null), dragonFly.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.getGraphics();
		g.drawImage(dragonFly, 0, 0, null);
		g.dispose();
		return bi;
	}
}


/
	