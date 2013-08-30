package jark.entity;

import java.awt.Graphics;

import jark.graphics.Sprite;

public class Entity {
	
	protected int x;
	protected int y;
	protected Sprite sprite;
	
	public Entity() {
	}
	
	public Entity(EntityBuilder builder) {
		x = builder.x;
		y = builder.y;
		sprite = builder.sprite;
	}
	
	public Entity(Entity e) {
		x = e.x;
		y = e.y;
		sprite = e.sprite;
	}
	
	public void draw(Graphics g) {
		System.out.println(sprite);
		sprite.draw(g, x, y);
	}
	
	public int getWidth() { return sprite.getWidth(); }
	
	public int getHeight() { return sprite.getHeight(); }

	public int getX() { return x; }

	public int getY() { return y; }

	public void setX(int x) { this.x = x; }

	public void setY(int y) { this.y = y; }
	
	public void setPos(int x, int y) { this.x = x; this.y = y; }

}