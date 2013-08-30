package jark.entity;

public class Ball extends Entity {
	
	private boolean isMoving;
	
	public static final Ball BALL = new Ball(new EntityBuilder().setSprite("/images/ball.png"));
	
	private Ball(EntityBuilder builder) {
		super(builder);
	}
	
	public boolean isMoving() {
		return isMoving;
	}

	public void setMoving() {
		isMoving = true;
	}
	
	public void stopMoving() {
		isMoving = false;
	}
	
}