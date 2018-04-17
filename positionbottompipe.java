import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class BottomPipe {
	//global variables
	private Image bottomPipe;
	private int xLoc = 0, yLoc = 0;
	
	public BottomPipe(int initialWidth, int initialHeight) {
		bottomPipe = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("resources/tube_bottom.png"));
		scaleBottomPipe(initialWidth, initialHeight);
	}
	
	public void scaleBottomPipe(int width, int height) {
		bottomPipe = bottomPipe.getScaledInstance(width, height, Image.SCALE_SMOOTH);		
	}
	
	public Image getPipe() {
		return bottomPipe;
	}
	
	
	public int getWidth() {
		return bottomPipe.getWidth(null);
	}
	
	public int getHeight() {
		return bottomPipe.getHeight(null);
	}
	
	/**
	 * Method to set the x location of the BottomPipe object
	 * @param x
	 */
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
