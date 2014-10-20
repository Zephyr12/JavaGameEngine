package myengine;

public class WorldViewer {
	Vec2 offset;
	static WorldViewer instance;
	private WorldViewer(){
		offset = new Vec2(0,0);
	}
	public static WorldViewer GetViewMatrix(){
		if(instance != null){
			return instance;
		}else{
			instance = new WorldViewer();
			return instance;
		}
	}
	public Vec2 GetOffset(){
		return offset;
	}
	public void SetOffset(Vec2 o){
		offset = o;
	}
}
