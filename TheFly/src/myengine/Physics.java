package myengine;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Physics {
	public List<PointBody> objects = new ArrayList<PointBody>();	
	static Physics instance;
	double grav =0.01;
	private Physics(){
		objects = new ArrayList<PointBody>();
	}
	public static Physics GetSingleton(){
		if(instance == null){
			instance = new Physics();
			return instance;
		}else{
			return instance;
		}
	}
	public void SetG(double g){
		grav = g;
	}
	public void RegisterBody(PointBody body){
		System.out.println(objects.size());
		objects.add(body);
		Collections.sort(objects, new Comparator<PointBody>(){

			@Override
			public int compare(PointBody a, PointBody b) {
				//System.out.println(a.object.GetCollider());
				if(a.object.GetCollider().minmaxX().x < b.object.GetCollider().minmaxX().x){
					return -1;
				}else if(a.object.GetCollider().minmaxX().x > b.object.GetCollider().minmaxX().x){
					return 1;
				}else{
					return 0;
				}
				
			}
			
		});
	}
	public void DeleteBody(PointBody body){
		System.out.println(objects.size());
		objects.remove(body);
		Collections.sort(objects, new Comparator<PointBody>(){

			@Override
			public int compare(PointBody a, PointBody b) {
				//System.out.println(a.object.GetCollider());
				if(a.object.GetCollider().minmaxX().x < b.object.GetCollider().minmaxX().x){
					return -1;
				}else if(a.object.GetCollider().minmaxX().x > b.object.GetCollider().minmaxX().x){
					return 1;
				}else{
					return 0;
				}
				
			}
			
		});
	}
	public void Simulate(){
		//System.out.println(objects.size());
		try{
			Collections.sort(objects, new Comparator<PointBody>(){
		
			@Override
			public int compare(PointBody a, PointBody b) {
				if(a.object.GetCollider().minmaxX().x < b.object.GetCollider().minmaxX().x){
					return -1;
				}else if(a.object.GetCollider().minmaxX().x > b.object.GetCollider().minmaxX().x){
					return 1;
				}else{
					return 0;
				}
				
			}
			
		});
		}catch(Exception e){
			
		}
		for(int i = 0; i < objects.size();i++){ // Game G
			//PointBody b1 = objects.get(i);
			//b1.veloY += 0;//grav;
		}
		
		for(int i = 0; i < objects.size();i++){
			PointBody b1 = objects.get(i);
			for(int j = Math.max(i-5,0); j < objects.size();j++){
				PointBody b2 = objects.get(j);
				
				if(b1 != b2){
					//Vec2 forceDir = Vec2.Sub(new Vec2(b1.object.x,b1.object.y),new Vec2(b2.object.x,b2.object.y)).Nrm();
					//double forceMag =(2 * (b1.mass * b2.mass)) / Math.pow((Vec2.Dist(new Vec2(b1.object.x,b1.object.y),new Vec2(b2.object.x,b2.object.y))),2);
					if(b1.object.GetCollider().minmaxX().y<b2.object.GetCollider().minmaxX().x){
						//System.out.println(b1 + "  is not touching  " + b2);
					    break;
					}else{
						CollisionInfo ci = b1.object.GetCollider().Collide(b2.object.GetCollider());
						if(ci !=null){
							b1.object.OnCollide(ci);
							b2.object.OnCollide(ci);
							
							Vec2 normal = ci.getNormal();
							Vec2 relativeVelocity =  Vec2.Sub(new Vec2(b2.veloX,b2.veloY), new Vec2(b1.veloX,b1.veloY));
							double RVdotN = (float) Vec2.Dot(normal, relativeVelocity);
							double impulse = -((b1.bounce+ b2.bounce)*0.5) *RVdotN;
							impulse /= 1 / b1.mass + 1 / b2.mass;
							double pDepth = ci.getPenetrationDepth();
							
							b1.veloX -= impulse *normal.x /b1.mass; 
							b1.veloY -= impulse *normal.y /b1.mass;
							
							b2.veloX += impulse *normal.x /b2.mass; 
							b2.veloY += impulse *normal.y /b2.mass;
								
								if(pDepth > 0.005){
									double perc =0.5;
									
										Vec2 correction = new Vec2(normal.x*pDepth*perc,normal.y*pDepth*perc);
										if(!b1.lockPos){
											b1.object.x -= correction.x;
											b1.object.y -= correction.y;
										}
										if(!b2.lockPos){
											b2.object.x += correction.x;
											b2.object.y += correction.y;
										}
								}
							}
						}
						//System.out.println(b1 + "  could be touching  " + b2);
					}
					
					//b1.AddForce(forceDir.x*forceMag, forceDir.y*forceMag);
					//System.out.println(b1.getClass() + " : " + b1.veloX + " : " + b1.veloX);
				}
				
			}
		}
		
	
	public List<PointBody> GetObjects(){
		return objects;
	}
}
