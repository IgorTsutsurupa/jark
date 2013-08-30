package jark.entity.brick;

import jark.entity.EntityBuilder;

public class MetalBrick extends Brick {

	private int modCount;
	
	public MetalBrick(EntityBuilder builder) {
		super(builder);
	}

	public void mutate() {
		modCount++;
//		type = "MetalBrick" + modCount;
	}

	public int getStatus() {
		return modCount;
	}
	
	@Override
	public void destroy() {
		if (getStatus() < 2) {
			mutate();
			return;
		} else {
			super.destroy();
		}
	}

	public static MetalBrick getInstance(int i) {
		return new MetalBrick(new EntityBuilder().setSprite("/images/bricks/brick_metal" + i + ".png"));
	}

}