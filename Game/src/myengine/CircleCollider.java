package myengine;

public class CircleCollider extends Component implements ICollideable {
	public CircleCollider(GameObject2D obj, String[] args) {
		super(obj, args);
		radius = Float.parseFloat((String) args[0]);
		// TODO Auto-generated constructor stub
	}

	float radius;
	
	@Override
	public int Type() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CollisionInfo Collide(ICollideable e) {
		// TODO Auto-generated method stub
		if(e != null){
			if(e.Type() == 0){//CircleCircleCollision
				CircleCollider c = (CircleCollider)e;
				float dist = (float) Vec2.Dist(new Vec2(object.x,object.y), new Vec2(c.object.x,c.object.y));
				if(dist < radius + c.radius){
					
					PointBody b1 = (PointBody) object.GetBehavior(PointBody.class);
					PointBody b2 = (PointBody) ((CircleCollider)e).object.GetBehavior(PointBody.class);
					if(b1 != null && b2 != null){
						float pDepth = radius + c.radius - dist;
						Vec2 normal = Vec2.Sub(new Vec2(c.object.x,c.object.y), new Vec2(object.x,object.y)).Nrm();
						
						//if(RVdotN > 0){
						//	return null;
						//}
						return new CollisionInfo(normal, pDepth, this.object, c.object);
					}
				}
			}
			
			if(e.Type() == 1){ // box circle collision
			/*	
				CircleCollider c = this;
				BoxCollider b = (BoxCollider) e;
				
				Vec2 atb = Vec2.Sub(new Vec2(b.object.x,b.object.y),new Vec2(c.object.x,c.object.y));
				
				Vec2 closest = new Vec2(c.object.x,c.object.y);
				closest.x = Math.max(b.object.x - (b.wh.x/2.0), Math.min(b.object.x + (b.wh.x/2.0), closest.x));
				closest.y = Math.max(b.object.y - (b.wh.y/2.0), Math.min(b.object.y + (b.wh.y/2.0), closest.y));
				
				Boolean invneeded = false;
				if(atb.equals(closest)){
					if(b.object.x-(b.wh.x/2.0) > b.object.x-(b.wh.x/2.0)){
						if(closest.x > 0){
							closest.x = b.object.x-(b.wh.x/2.0);
						}else{
							closest.x = -(b.object.x-(b.wh.x/2.0));
						}
					}else{
						if(closest.y > 0){
							closest.y = b.object.y-(b.wh.y/2.0);
						}else{
							closest.y = -(b.object.y-(b.wh.y/2.0));
						}
					}
				}
				Vec2 nrml = Vec2.Sub(new Vec2(c.object.x,c.object.y), closest);
				double dist = nrml.Mag();
				double rad = c.radius;
				if(dist > rad){
					return null;
				}
				if(!invneeded){
					return new CollisionInfo(nrml.Nrm(),rad - dist,c.object,b.object);
				}else{
					return new CollisionInfo(new Vec2(-nrml.x,-nrml.y).Nrm(),rad - dist,c.object,b.object);
				}*/
			}	
			
		}
		return null;
	}
	public int GetType() {
		// TODO Auto-generated method stub
		return this.TYPE_COLLIDER;
	}

	@Override 
	public Vec2 minmaxX() {
		return new Vec2(object.x - radius,object.x + radius);
	}

	
}
