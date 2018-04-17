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
						
						//THESE ARE SOUND EFFECTS TO BE DISPLAYED ON COLLISION AND DEATH.
						pgs.sendText("Game Over");
						loopVar = false; // stop the game loop
						gamePlay = false; // game has ended
						break;
					}
				}
			}
		}
	}