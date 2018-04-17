import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class BottomPipe {
	private Image bottomPipe;
	private int xLoc = 0, yLoc = 0;
	
	public BottomPipe(int initialWidth, int initialHeight) {
		bottomPipe = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("resources/tube_bottom.png"));
		scaleBottomPipe(initialWidth, initialHeight);
	}
	
	 //Scale to desired width n height the bottomPipe
	public void scaleBottomPipe(int width, int height) {
		bottomPipe = bottomPipe.getScaledInstance(width, height, Image.SCALE_SMOOTH);		
	}
	
	//return Image
	public Image getPipe() {
		return bottomPipe;
	}
	
	
	 // return width
	 
	public int getWidth() {
		return bottomPipe.getWidth(null);
	}
	
// // return height
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
	
	//return x locationof pipe
	public int getX() {
		return xLoc;
	}
	
	//get y location of pipe
	public void setY(int y) {
		yLoc = y;
	}
	
	//return y location of pipe
	public int getY() {
		return yLoc;
	}
	
	
	 // return Rectangle outlining BottomPipe's position
	 
	public Rectangle getRectangle() {
		return (new Rectangle(xLoc, yLoc, bottomPipe.getWidth(null), bottomPipe.getHeight(null)));
	}
	
	
	 //return pipe BufferedImage object
	 
	public BufferedImage getBI() {
		BufferedImage bi = new BufferedImage(bottomPipe.getWidth(null), bottomPipe.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.getGraphics();
		g.drawImage(bottomPipe, 0, 0, null);
		g.dispose();
		return bi;
	}
}
