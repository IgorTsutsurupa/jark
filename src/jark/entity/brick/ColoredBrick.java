package jark.entity.brick;

import jark.entity.EntityBuilder;

public class ColoredBrick extends Brick {
	
	String color;

	public ColoredBrick(EntityBuilder builder, String color) {
		super(builder);
		this.color = color;
	}
	
	public ColoredBrick() {
		super();
	}

	public void destroy() {
		super.destroy();
	}
		
	public static ColoredBrick getInstance(String type) {
		return new ColoredBrick(new EntityBuilder().setSprite("/images/bricks/brick_" + type + ".png"), type);
	}
	
	public String toString() {
		return color;
	}

}