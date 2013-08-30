package jark.levelgen;

import jark.entity.brick.Brick;

import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Level implements Serializable {

	private static final long serialVersionUID = 4069440273815173572L;

	public Brick[][] bricks;

	public final static int DEFAULT_LEVEL_WIDTH = 20;
	public final static int DEFAULT_LEVEL_HEIGHT = 20;

	public Level() {
		this(DEFAULT_LEVEL_HEIGHT, DEFAULT_LEVEL_WIDTH);
	}

	public Level(int height, int width) {
		bricks = new Brick[height][width];
	}

	void setBrick(int x, int y, Brick brick) {
		bricks[y][x] = brick;
	}

	public boolean saveAs(String name) throws IOException {
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(new File("res/levels/" + name + ".lvl")))) {
			oos.writeObject(this);
		}
		return true;
	}

	public static Level load(String name) throws IOException {
		Level level = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				"res/levels/" + name + ".lvl"))) {
			level = (Level) ois.readObject();
			System.out.println("ok");
		} catch (ClassNotFoundException e) {
		}
		System.out.println(level);
		return level;
	}

	public void draw(Graphics g) {
		for (int i = 0; i < bricks.length; i++) {
			for (int j = 0; j < bricks[i].length; j++) {
				if (bricks[i][j] != null) {
					bricks[i][j].draw(g);
				}
			}
		}
	}

}