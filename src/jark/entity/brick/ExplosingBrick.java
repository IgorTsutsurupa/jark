package jark.entity.brick;

import jark.entity.EntityBuilder;

public class ExplosingBrick extends Brick {
	private static final long serialVersionUID = 2288412113716804047L;

	public ExplosingBrick(EntityBuilder builder) {
		super(builder);
	}

	@Override
	public void destroy() {}

}