package jark.graphics;

import java.awt.Graphics;
import java.awt.Image;

public class Sprite {
	
	public static final int BRICK_HEIGHT = 15;
	public static final int BRICK_WIDTH = 45;

	private Image image;

	public Sprite(Image image) {
		this.image = image;
	}

	public int getWidth() {
		return image.getWidth(null);
	}

	public int getHeight() {
		return image.getHeight(null);
	}

	public void draw(Graphics g, int x, int y) {
		g.drawImage(image, x, y, null);
	}

	@Override
	public String toString() {
		return image + " ";
	}
	
}