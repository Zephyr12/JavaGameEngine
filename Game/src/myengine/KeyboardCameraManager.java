package myengine;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class KeyboardCameraManager extends Component implements IUpdateable {
	int speed;
	public KeyboardCameraManager(GameObject2D obj, String[] args) {
		super(obj, args);
		speed = Integer.parseInt(args[0]);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		if(GameInput.GetInstance().GetKey(KeyEvent.VK_W)){
			Vec2 offset = new Vec2(WorldViewer.GetViewMatrix().GetOffset().x,WorldViewer.GetViewMatrix().GetOffset().y+speed);
			WorldViewer.GetViewMatrix().SetOffset(offset);
		}
		if(GameInput.GetInstance().GetKey(KeyEvent.VK_A)){
			Vec2 offset = new Vec2(WorldViewer.GetViewMatrix().GetOffset().x+speed,WorldViewer.GetViewMatrix().GetOffset().y);
			WorldViewer.GetViewMatrix().SetOffset(offset);
		}
		if(GameInput.GetInstance().GetKey(KeyEvent.VK_S)){
			Vec2 offset = new Vec2(WorldViewer.GetViewMatrix().GetOffset().x,WorldViewer.GetViewMatrix().GetOffset().y-speed);
			WorldViewer.GetViewMatrix().SetOffset(offset);
		}
		if(GameInput.GetInstance().GetKey(KeyEvent.VK_D)){
			Vec2 offset = new Vec2(WorldViewer.GetViewMatrix().GetOffset().x-speed,WorldViewer.GetViewMatrix().GetOffset().y);
			WorldViewer.GetViewMatrix().SetOffset(offset);
		}
	}

	@Override
	public void KeyPressedEvent(KeyEvent k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void MouseClickedEvent(MouseEvent k) {
		// TODO Auto-generated method stub

	}

	@Override
	public int GetType() {
		// TODO Auto-generated method stub
		return this.TYPE_BEHAVIOR;
	}

	@Override
	public void OnCollide(CollisionInfo s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void OnDestroy() {
		// TODO Auto-generated method stub
		
	}

}
