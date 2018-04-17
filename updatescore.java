private void updateScore(BottomPipe bp1, BottomPipe bp2, Bird bird) {
		if (bp1.getX() + PIPE_WIDTH < bird.getX() && bp1.getX() + PIPE_WIDTH > bird.getX() - X_MOVEMENT_DIFFERENCE) {
			pgs.incrementJump();
			play("sfx_point");
		} else if (bp2.getX() + PIPE_WIDTH < bird.getX()
				&& bp2.getX() + PIPE_WIDTH > bird.getX() - X_MOVEMENT_DIFFERENCE) {
			pgs.incrementJump();
		}
	}