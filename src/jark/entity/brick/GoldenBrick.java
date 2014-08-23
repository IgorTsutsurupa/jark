package jark.entity.brick;

import jark.entity.EntityBuilder;

public class GoldenBrick extends Brick  {
	private static final long serialVersionUID = 7210204736285677407L;
	
	private int modCount;
	
	public GoldenBrick(EntityBuilder builder) {
		super(builder);
	}

	public static GoldenBrick getInstance() {
		return new GoldenBrick(new EntityBuilder().setSprite("/images/bricks/brick_golden.png"));
	}

	public void mutate() {
		modCount++;
	}

	public void destroy() {
		if (getStatus() < 1) {
			return;
		} else {
			super.destroy();
		}
	}

	public int getStatus() {
		return modCount;
	}

}