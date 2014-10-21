package myengine;

public class GameInput {
	static GameInput i = new GameInput();
	boolean[] keyStates = new boolean[512];
	boolean[] mouseStates = new boolean[512];
	Vec2 mousePos = new Vec2(0,0);
	public Vec2 screenSize = new Vec2(0,0);
	Vec2 mouseDelta = new Vec2(0,0);
	
	public void PressKey(int KeyCode){
		keyStates[KeyCode] = true;
	}
	public void ReleaseKey(int KeyCode){
		keyStates[KeyCode] = false;
	}
	public void ReportMouseClick(int button){
		mouseStates[button] = true;
	}
	public void ReportMouseUp(int button){
		mouseStates[button] = false;
	}
	public void ReportMouseMove(Vec2 pos){
		//System.out.println(pos.x);
		mouseDelta = Vec2.Sub(pos, mousePos);
		
		mousePos = pos;
		
	}
	public boolean GetMouseButton(int button){
		return mouseStates[button];
	}
	public Vec2 GetPos(){
		return mousePos;
	}
	public Vec2 GetDeltas(){
		return mouseDelta;
	}
	public boolean GetKey(int KeyCode){
		return keyStates[KeyCode];
	}
	private GameInput(){
		
	}
	public static GameInput GetInstance(){
		return i;
	}
	public void setsize(int x,int y){
		System.out.println(new Vec2(x,y).toString());
		screenSize = new Vec2(x,y);	
	}
}