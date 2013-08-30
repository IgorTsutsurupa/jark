package jark.entity.brick;

import jark.entity.EntityBuilder;

public class InvisibleBrick extends Brick {

	private int modCount;
	
	public InvisibleBrick(EntityBuilder builder) {
		super(builder);
	}

	public void destroy() {
		if (getStatus() < 1) {
			mutate();
			return;
		} else {

		}
		
	}

	public void mutate() {
		modCount++;
	}

	public int getStatus() {
		return modCount;
	}
	
}