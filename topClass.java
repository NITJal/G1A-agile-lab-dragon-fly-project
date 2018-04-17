import java.awt.Dimension;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class TopClass {
	// global constant variables
	private static final int SCREEN_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private static final int SCREEN_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private static final int PIPE_GAP = SCREEN_HEIGHT / 5; // distance in pixels
															// between pipes
	private static final int PIPE_WIDTH = SCREEN_WIDTH / 8, PIPE_HEIGHT = 4 * PIPE_WIDTH;
	private static final int BIRD_WIDTH = 120, BIRD_HEIGHT = 75;
	private static final int UPDATE_DIFFERENCE = 25; // time in ms between
														// updates
	private static final int X_MOVEMENT_DIFFERENCE = 5; // distance the pipes
														// move every update
	private static final int SCREEN_DELAY = 300; // needed because of long load
													// times forcing pipes to
													// pop up mid-screen
	private static final int BIRD_X_LOCATION = SCREEN_WIDTH / 7;
	private static final int BIRD_JUMP_DIFF = 10, BIRD_FALL_DIFF = BIRD_JUMP_DIFF / 2,
			BIRD_JUMP_HEIGHT = PIPE_GAP - BIRD_HEIGHT - BIRD_JUMP_DIFF * 2;

	// global variables
	private boolean loopVar = true; // false -> don't run loop; true -> run loop
									// for pipes
	private boolean gamePlay = false; // false -> game not being played
	private boolean birdThrust = false; // false -> key has not been pressed to
										// move the bird vertically
	private boolean birdFired = false; // true -> button pressed before jump
										// completes
	private boolean released = true; // space bar released; starts as true so
										// first press registers
	private int birdYTracker = SCREEN_HEIGHT / 2 - BIRD_HEIGHT;
	private Object buildComplete = new Object();

	// global swing objects
	private JFrame f = new JFrame("DRAGON FLY !!!");
	private JButton startGame, startGame1;
	private JPanel topPanel; // declared globally to accommodate the repaint
								// operation and allow for removeAll(), etc.

	// other global objects
	private static TopClass tc = new TopClass();
	private static PlayGameScreen pgs; // panel that has the moving background
										// at the start of the game

	/**
	 * Default constructor
	 */
	public TopClass() {

	}

	public static void main(String[] args) {
		// build the GUI on a new thread

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				tc.buildFrame();

				// create a new thread to keep the GUI responsive while the game
				// runs
				Thread t = new Thread() {
					public void run() {
						tc.gameScreen(true);
					}
				};
				t.start();
			}
		});
	}

	/**
	 * Method to construct the JFrame and add the program content
	 */
	private void buildFrame() {
		Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("resources/blue_bird.png"));

		f.setContentPane(createContentPane());
		f.setResizable(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setAlwaysOnTop(false);
		f.setVisible(true);
		f.setMinimumSize(new Dimension(SCREEN_WIDTH * 1 / 4, SCREEN_HEIGHT * 1 / 4));
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setIconImage(icon);
		f.addKeyListener(this);
	}

	private JPanel createContentPane() {
		topPanel = new JPanel(); // top-most JPanel in layout hierarchy
		topPanel.setBackground(Color.BLACK);
		// allow us to layer the panels
		LayoutManager overlay = new OverlayLayout(topPanel);
		topPanel.setLayout(overlay);

		// Start Game JButton
		startGame = new JButton("PLAY!!");
		play("sfx_wing");

		startGame.setBackground(Color.RED);
		startGame.setForeground(Color.WHITE);
		startGame.setFocusable(false); // rather than just setFocusabled(false)
		startGame.setFont(new Font("Calibri", Font.BOLD, 42));
		startGame.setAlignmentX(0.5f); // center horizontally on-screen
		startGame.setAlignmentY(0.5f); // center vertically on-screen
		startGame.addActionListener(this);
		topPanel.add(startGame);

		// must add last to ensure button's visibility
		pgs = new PlayGameScreen(SCREEN_WIDTH, SCREEN_HEIGHT, true); // true -->
																		// we
																		// want
																		// pgs
																		// to be
																		// the
																		// splash
																		// screen
		topPanel.add(pgs);

		return topPanel;
	}
