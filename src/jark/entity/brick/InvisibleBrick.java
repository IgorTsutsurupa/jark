package jark.entity.brick;

import jark.entity.EntityBuilder;

public class InvisibleBrick extends Brick {
	private static final long serialVersionUID = 1414337125132828448L;
	
	private int _modCount;
	
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
		_modCount++;
	}

	public int getStatus() {
		return _modCount;
	}
	
}