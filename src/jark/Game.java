package jark;

import jark.entity.Ball;
import jark.entity.Board;
import jark.levelgen.Level;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.Random;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {

	public class MouseMovedHandler extends MouseMotionAdapter {
		public void mouseMoved(MouseEvent e) {
			int x = e.getX();
			if (x + board.getWidth() - 10 <= WIDTH) {
				board.setX(e.getX());
			}
		}
	}

	public class MouseClickedHandler extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			ball.setMoving();
		}
	}

	private static final long serialVersionUID = 1L;

	private static final int WIDTH = 800;
	private static final int HEIGHT = WIDTH * 9 / 16;
	public final String NAME = "JArk";

	private boolean running = false;

	public static Ball ball;
	public static Board board;

	//TODO to Senbjorn: work out new velocity algorithm: change velocity by Thread.sleep(millis)
	//TODO fix bug with vy which can equals 0
	//TODO Work out new velocity algorithm: vector of velocity depends of start position of the board
	private static final Random r = new Random();
	private static int v0 = 7;
	private static double angle = (Math.PI * r.nextDouble());
	private static int ball_vx;
	private static int ball_vy;
	public Level currentLevel;
	
	public void init() {
		System.out.println(getHeight() + " " + getWidth());

		angle = (Math.PI * r.nextDouble());
		
		ball_vx = (int) (v0 * Math.cos(angle));
		ball_vy = (int) (v0 * Math.sin(angle));
		
		board = Board.BOARD;
		board.setX((WIDTH - board.getWidth()) / 2);
		board.setY(HEIGHT - board.getHeight() + 11);

		ball = Ball.BALL;
		ball.setX((WIDTH - ball.getWidth()) / 2) ;
		ball.setY(board.getY() - ball.getHeight());
		
		try {
			currentLevel = Level.load("level1");
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		addMouseListener(new MouseClickedHandler());
		addMouseMotionListener(new MouseMovedHandler());
	}

	public void start() {
		running = true;
		new Thread(this).start();
	}

	public void stop() {
		running = false;
	}

	public void run() {
		init();

		while (running) {
			update();
			render();
			try {
				Thread.sleep(12);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	//TODO to Senbjorn: work out new bang algorithm. It would be nice if you would make something like contacted() method. I just going to use it somewhere else
	//TODO Animation for board
	private void update() {
		if (!ball.isMoving()) {
			ball.setX(board.getX() + (board.getWidth() - ball.getWidth()) / 2);
		} else {
			if (ball.getX() <= 0 || ball.getX() >= WIDTH) {
				System.out.println("bang!");
				ball_vx = - ball_vx;
			}
			if (ball.getY() <= 0) {
				System.out.println("bang!");
				ball_vy = - ball_vy;
			}
			if (ball.getX() <= board.getX() + board.getWidth() / 2 && 
				ball.getX() >= board.getX() - board.getWidth() / 2) {
				if (ball.getY() > board.getY()) {
					ball_vy = - ball_vy;
				}
			}
			ball.setX(ball.getX() + ball_vx);
			ball.setY(ball.getY() - ball_vy);
		}
	}

	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(2);
			requestFocus();
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		board.draw(g);
		ball.draw(g);
		
		currentLevel.draw(g);

		g.dispose();
		bs.show();
	}

	public void setLevel(Level level) {
		currentLevel = level;
	}

	public static void main(String[] args) {
		Game game = new Game();

		game.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		game.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		game.setPreferredSize(new Dimension(WIDTH, HEIGHT));

		JFrame frame = new JFrame(game.NAME);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("/images/favicon.png"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(game, BorderLayout.CENTER);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		game.start();
	}
}