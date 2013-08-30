package jark.entity;

public class Board extends Entity {
	
	public static final Board BOARD = new Board(new EntityBuilder().setSprite("/images/board1.png"));
	
	private Board(EntityBuilder bulder) {
		super(bulder);
	}

}