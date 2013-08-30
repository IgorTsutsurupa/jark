package jark.entity.brick;

import jark.entity.Entity;
import jark.entity.EntityBuilder;

import java.io.Serializable;

public class Brick extends Entity implements Serializable {
	private static final long serialVersionUID = -7738402002055022001L;

	public static final int DEFAULT_BRICK_HEIGHT = 15;
	public static final int DEFAULT_BRICK_WIDTH = 40;
	
	public Brick(EntityBuilder builder) {
		super(builder);
	}
	
	public Brick() {
		super();
	}
	
	public Brick(Brick currentBrick) {
		super(currentBrick);
	}

	public void destroy() {}
	
}