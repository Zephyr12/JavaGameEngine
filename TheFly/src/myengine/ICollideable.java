package myengine;

import java.io.Serializable;

public interface ICollideable extends Serializable{
	public int Type();
	public CollisionInfo Collide(ICollideable e);
	public Vec2 minmaxX();
}
