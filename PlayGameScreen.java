import javax.swing.*;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Color;

public class PlayGameScreen extends JPanel {
	
	private int screenWidth, screenHeight;
	private boolean isSplash = true;
	private int successfulJumps = 0;
	private String message = "Dragon Fly";
	private Font primaryFont = new Font("Goudy Stout", Font.BOLD, 56), failFont = new Font("Calibri", Font.BOLD, 56);
	private int messageWidth = 0, scoreWidth = 0;
	private BottomPipe bp1, bp2;
	private TopPipe tp1, tp2;
	private Dragon bird;

	public PlayGameScreen(int screenWidth, int screenHeight, boolean isSplash) {
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		this.isSplash = isSplash;
	
	 //controlling jpanel with a graphics object and painting using that object
	 
	public void setBottomPipe(BottomPipe bp1, BottomPipe bp2) {
		this.bp1 = bp1;
		this.bp2 = bp2;
	}
	
	public void setTopPipe(TopPipe tp1, TopPipe tp2) {
		this.tp1 = tp1;
		this.tp2 = tp2;
	}
	
	
	public void setBird(Dragon bird) {
		this.bird = bird;
	}
	
	