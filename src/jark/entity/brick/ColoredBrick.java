package jark.entity.brick;

import jark.entity.EntityBuilder;

public class ColoredBrick extends Brick {
	private static final long serialVersionUID = -5750610466668831820L;
	
	String _color;

	public ColoredBrick(EntityBuilder builder, String color) {
		super(builder);
		this._color = color;
	}
	
	public ColoredBrick() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public String toString() {
		return _color;
	}
	
	public static ColoredBrick getInstance(String type) {
		return new ColoredBrick(new EntityBuilder().setSprite("/images/bricks/brick_" + type + ".png"), type);
	}

}