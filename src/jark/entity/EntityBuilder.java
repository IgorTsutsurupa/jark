package jark.entity;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import jark.entity.brick.Brick;
import jark.entity.brick.ColoredBrick;
import jark.entity.brick.GoldenBrick;
import jark.entity.brick.MetalBrick;
import jark.graphics.Sprite;

public class EntityBuilder {
	public int x;
	public int y;
	public Sprite sprite;

	public EntityBuilder() {
		this.x = 0;
		this.y = 0;
		this.sprite = null;
	}

	public EntityBuilder setX(int val) {
		this.x = val;
		return this;
	}

	public EntityBuilder setY(int val) {
		this.y = val;
		return this;
	}

	public EntityBuilder setSprite(String path) {
		BufferedImage sourceImage = null;
		try {
			URL url = getClass().getResource(path);
			sourceImage = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.sprite = new Sprite(Toolkit.getDefaultToolkit().createImage(sourceImage.getSource()));
		return this;
		//			try {
		//				return new Sprite(ImageIO.read(new File(path)));
		//			} catch (IOException e) {
		//				return null;
		//			}
		//		this.sprite = Sprite.getSprite(path);
		//		return this;
	}

	public Entity build() {
		return new Entity(this);
	}

	public static Brick getInstance(String s) {
		Brick brick;
		switch (s) {
		case ("blue"): case ("red"): case ("green"):
		case ("yellow"): case ("lightgreen"): case ("violet"):
		case ("pink"): case ("linghtpink"): case ("cyan"):
		case ("lightcyan"): case ("darkyellow"): 
			brick = ColoredBrick.getInstance(s); break;
		case ("metal1"): case ("metal2"): case ("metal3"): 
			brick = MetalBrick.getInstance(s.charAt(5)); break;
		case ("golden"):
			brick = GoldenBrick.getInstance(); break;
		default: brick = null;
		}
		return brick;
	}
}