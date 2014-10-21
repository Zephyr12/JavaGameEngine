package myengine;

public class BoxCollider extends Component implements ICollideable {
	Vec2 wh;
	public BoxCollider(GameObject2D obj, String[] args) {
		super(obj, args);
		double w = Double.parseDouble(args[0]);
		double h = Double.parseDouble(args[1]);
		wh = new Vec2(w,h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int Type() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public CollisionInfo Collide(ICollideable e) {// best link ever for basic physics ~:~:~ http://gamedevelopment.tutsplus.com/tutorials/how-to-create-a-custom-2d-physics-engine-the-basics-and-impulse-resolution--gamedev-6331
		
		if(e != null){
			if(e.Type() == 1){//Box Box Collision
				BoxCollider b = (BoxCollider) e;
				Vec2 atb = Vec2.Sub(new Vec2(object.x, object.y),new Vec2(b.object.x, b.object.y));
				Vec2 bmin = new Vec2(b.object.x-(wh.x/2.0),b.object.y-(wh.y/2.0));
				Vec2 bmax = new Vec2(b.object.x+(wh.x/2.0),b.object.y+(wh.y/2.0));
				
				Vec2 amin = new Vec2(object.x-(wh.x/2.0),object.y-(wh.y/2.0));
				Vec2 amax = new Vec2(object.x+(wh.x/2.0),object.y+(wh.y/2.0));
				
				double aextentx = (amax.x - amin.x) / 2.0;
				double bextentx = (bmax.x - bmin.x) / 2.0;
				double xoverlap = aextentx + bextentx - Math.abs(atb.x);
				if(xoverlap > 0){
					double aextenty = (amax.y - amin.y) / 2.0;
					double bextenty = (bmax.y - bmin.y) / 2.0;
					double yoverlap = aextenty + bextenty - Math.abs(atb.y);
					if(yoverlap > 0){
						if(xoverlap < yoverlap){
							if(atb.x > 0){
								CollisionInfo f = new CollisionInfo(new Vec2(-1,0), xoverlap, this.object, b.object);
								return f;
							}else{
								CollisionInfo f = new CollisionInfo(new Vec2(1,0), xoverlap, this.object, b.object);
								return f;
							}
						}else{
							if(atb.y > 0){
								CollisionInfo f = new CollisionInfo(new Vec2(0,-1), yoverlap, this.object, b.object);
								return f;
							}else{
								CollisionInfo f = new CollisionInfo(new Vec2(0,1), yoverlap, this.object, b.object);
								return f;
							}
						}
					}
					
				}
						
				
			}
			if(e.Type() == 0){ // box circle collision
				
				CircleCollider c = (CircleCollider) e;
				BoxCollider b = this;
				Vec2 atb = Vec2.Sub(new Vec2(b.object.x,b.object.y),new Vec2(c.object.x,c.object.y));
				Vec2 closestCheck = new Vec2(c.object.x,c.object.y);
				Vec2 closest = new Vec2(c.object.x,c.object.y);
				closest.x = Math.max(b.object.x - (b.wh.x/2.0), Math.min(b.object.x + (b.wh.x/2.0), closest.x));
				closest.y = Math.max(b.object.y - (b.wh.y/2.0), Math.min(b.object.y + (b.wh.y/2.0), closest.y));
				
				Boolean invneeded = false;
				if(closest.equals(closestCheck)){
					invneeded = true;
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
					System.out.println("Testing");
					return new CollisionInfo(nrml.Nrm(),rad - dist,c.object,b.object);
				}else{
					System.out.println("Testing");
					return new CollisionInfo(new Vec2(-nrml.x,-nrml.y).Nrm(),rad - dist,c.object,b.object);
				}
			}
		}
		// TODO Auto-generated method stub
		return null;
	}
	
	

	@Override
	public Vec2 minmaxX() {
		
		return new Vec2(object.x-(wh.x/2),object.x+(wh.x/2));
	}

	@Override
	public int GetType() {
		// TODO Auto-generated method stub
		return this.TYPE_COLLIDER;
	}

}
