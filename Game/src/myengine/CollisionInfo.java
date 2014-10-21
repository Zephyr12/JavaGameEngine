package myengine;

public class CollisionInfo {


	private Vec2 normal;
	
	private double pDepth;
	private GameObject2D object1;
	private GameObject2D object2;
	
	public CollisionInfo(Vec2 normal, double pDepth, GameObject2D object1,
			GameObject2D object2) {
		super();
		this.normal = normal;
		this.pDepth = pDepth;
		this.object1 = object1;
		this.object2 = object2;
		
	}

	public Vec2 getNormal() {
		return normal;
	}

	public double getPenetrationDepth() {
		return pDepth;
	}

	public GameObject2D getObject1() {
		return object1;
	}

	public GameObject2D getObject2() {
		return object2;
	}

	

	

}
