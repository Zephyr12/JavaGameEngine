package myengine;

public interface ICollideable {
	public int Type();
	public CollisionInfo Collide(ICollideable e);
	public Vec2 minmaxX();
}
