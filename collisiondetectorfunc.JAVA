
	private void collisionDetection(BottomPipe bp1, BottomPipe bp2, TopPipe tp1, TopPipe tp2, Bird bird) {
		collisionHelper(bird.getRectangle(), bp1.getRectangle(), bird.getBI(), bp1.getBI());
		collisionHelper(bird.getRectangle(), bp2.getRectangle(), bird.getBI(), bp2.getBI());
		collisionHelper(bird.getRectangle(), tp1.getRectangle(), bird.getBI(), tp1.getBI());
		collisionHelper(bird.getRectangle(), tp2.getRectangle(), bird.getBI(), tp2.getBI());

		if (bird.getY() + BIRD_HEIGHT > SCREEN_HEIGHT * 7 / 8) { // ground
																	// detection
			play("sfx_hit");
			play("sfx_die");
			pgs.sendText("Game Over");
			loopVar = false;
			gamePlay = false; // game has ended
		}
		else
		{
			
			//{play("sfx_wing");}
		}
	}

	private void collisionHelper(Rectangle r1, Rectangle r2, BufferedImage b1, BufferedImage b2) {
		if (r1.intersects(r2)) {
			Rectangle r = r1.intersection(r2);

			int firstI = (int) (r.getMinX() - r1.getMinX()); // firstI is the
																// first x-pixel
																// to iterate
																// from
			int firstJ = (int) (r.getMinY() - r1.getMinY()); // firstJ is the
																// first y-pixel
																// to iterate
																// from
			int bp1XHelper = (int) (r1.getMinX() - r2.getMinX()); // helper
																	// variables
																	// to use
																	// when
																	// referring
																	// to
																	// collision
																	// object
			int bp1YHelper = (int) (r1.getMinY() - r2.getMinY());

			for (int i = firstI; i < r.getWidth() + firstI; i++) { //
				for (int j = firstJ; j < r.getHeight() + firstJ; j++) {
					if ((b1.getRGB(i, j) & 0xFF000000) != 0x00
							&& (b2.getRGB(i + bp1XHelper, j + bp1YHelper) & 0xFF000000) != 0x00) {

						play("sfx_hit");
						play("sfx_die");
						pgs.sendText("Game Over");
						loopVar = false; // stop the game loop
						gamePlay = false; // game has ended
						break;
					}
				}
			}
		}
	}