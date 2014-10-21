package myengine;

public class Vec2 {
	public double x;
	public double y;
	
	public Vec2(double ix,double iy){
		x = ix;
		y = iy;
	}
	
	public static Vec2 Add(Vec2 a, Vec2 b){
		return new Vec2(a.x+b.x,a.y+b.y);
	}
	public static Vec2 Sub(Vec2 a, Vec2 b){
		return new Vec2(a.x-b.x,a.y-b.y);
	}
	public static double Dot(Vec2 a, Vec2 b){
		return (a.x*b.x)+(a.y*b.y);
	}
	public static double Dist(Vec2 a, Vec2 b){
		return Math.abs(new Vec2(a.x-b.x,a.y-b.y).Mag());
	}
	public double Mag(){
		
		return Math.sqrt((x*x) + (y*y));
	}
	public Vec2 Nrm(){
		double mag = this.Mag();
		double x = this.x/mag;
		double y = this.y/mag;
		return new Vec2(x,y);
	}
	public String toString(){
		return "("+x+","+y+")";
	}
	public boolean equals(Object o){
		if(o instanceof Vec2){
			if(((Vec2) o).x == x && ((Vec2) o).y == y){
				return true;
			}
		}
		return false;
	}
}
