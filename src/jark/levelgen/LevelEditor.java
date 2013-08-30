package jark.levelgen;

import jark.entity.brick.Brick;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferStrategy;

public class LevelEditor extends Canvas implements Runnable {

	private static final long serialVersionUID = -5362128416321460348L;

	public class MouseClickedHandler extends MouseAdapter {

		public void mouseClicked(MouseEvent e) {
			int x = e.getX(), y = e.getY();
			if (isBuildMode()) {
				Brick brick = new Brick(getCurrentBrick());
				brick.setPos(x - x % Brick.DEFAULT_BRICK_WIDTH, y - y % Brick.DEFAULT_BRICK_HEIGHT);
				getLevel().setBrick(x / Brick.DEFAULT_BRICK_WIDTH, y / Brick.DEFAULT_BRICK_HEIGHT, brick);
				debugLevelPrint();
			}
			if (isEraseMode()) {
				getLevel().setBrick(x / Brick.DEFAULT_BRICK_WIDTH, y / Brick.DEFAULT_BRICK_HEIGHT, null);
			}
		}

		private void debugLevelPrint() {
			for (int i = 0; i < getLevel().bricks.length; i++) {
				for (int j = 0; j < getLevel().bricks[i].length; j++) {
					System.out.print(getLevel().bricks[i][j] != null ? getLevel().bricks[i][j]
									+ "    "
									: "*    ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}

	public class MouseMotionHandler extends MouseMotionAdapter {
		
		public void mouseMoved(MouseEvent e) {
			if (isBuildMode()) {
				getCurrentBrick().setPos(e.getX(), e.getY());
			}
		}
		
	}

	private Level currentLevel = new Level();
	private Brick currentBrick;
	private boolean buildMode;
	private boolean eraseMode;

	private boolean running;

	public void switchMode() {
		setBuildMode(!buildMode);
		setEraseMode(!eraseMode);
	}

	public Brick getCurrentBrick() {
		return currentBrick;
	}

	public void setCurrentBrick(Brick brick) {
		this.currentBrick = brick;
	}

	public boolean isBuildMode() {
		return buildMode;
	}

	public void setBuildMode(boolean var) {
		this.buildMode = var;
	}

	public boolean isEraseMode() {
		return eraseMode;
	}

	public void setEraseMode(boolean val) {
		this.eraseMode = val;
	}

	public Level getLevel() {
		return currentLevel;
	}

	public void setLevel(Level level) {
		this.currentLevel = level;
	}

	public void init() {
		addMouseListener(new MouseClickedHandler());
		addMouseMotionListener(new MouseMotionHandler());
	}

	public void start() {
		new Thread(this).start();
		running = true;
	}

	public void run() {
		init();

		while (running) {
			update();
			render();
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void update() {

	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(2);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		for (int i = 0; i < getLevel().bricks.length; i++) {
			for (int j = 0; j < getLevel().bricks[i].length; j++) {
				if (getLevel().bricks[i][j] != null) {
					getLevel().bricks[i][j].draw(g);
				}
			}
		}

		if (getCurrentBrick() != null) {
			getCurrentBrick().draw(g);
		}

		g.dispose();
		bs.show();
	}
}