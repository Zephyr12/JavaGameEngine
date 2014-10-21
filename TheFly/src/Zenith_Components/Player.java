package Zenith_Components;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import myengine.CollisionInfo;
import myengine.Component;
import myengine.GameInput;
import myengine.GameObject2D;
import myengine.IUpdateable;
import myengine.PointBody;
import myengine.Vec2;

public class Player extends Component implements IUpdateable {
	double health,speed,jumpVelo;
	boolean canJump = false;
	public Player(GameObject2D obj, String[] args) {
		super(obj, args);
		health = Double.parseDouble(args[0]);
		speed = Double.parseDouble(args[1]);
		jumpVelo = Double.parseDouble(args[2]);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		if(GameInput.GetInstance().GetKey(KeyEvent.VK_LEFT)){
			PointBody p = (PointBody)(object.GetBehavior(PointBody.class));
			p.veloX = -speed;
		}
		else if(GameInput.GetInstance().GetKey(KeyEvent.VK_RIGHT)){
			PointBody p = (PointBody)(object.GetBehavior(PointBody.class));
			p.veloX = speed;
		}
		else{
			PointBody p = (PointBody)(object.GetBehavior(PointBody.class));
			p.veloX = 0;
		}
	}

	@Override
	public void OnCollide(CollisionInfo s) {
		double pointsup = 0;
		// TODO Auto-generated method stub
		if(s.getObject1() != this.object){
			pointsup = Vec2.Dot(new Vec2(0,-1),s.getNormal());
		}
		
		if(s.getObject1() == this.object){
			pointsup = Vec2.Dot(new Vec2(0,1),s.getNormal());
		}
		
		canJump = (pointsup > -0.1) || canJump;
	}

	@Override
	public void OnDestroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void KeyPressedEvent(KeyEvent k) {
		// TODO Auto-generated method stub
		if(GameInput.GetInstance().GetKey(KeyEvent.VK_SPACE)&&canJump){
			PointBody p = (PointBody)(object.GetBehavior(PointBody.class));
			canJump = false;
			p.veloY = -jumpVelo;
		}
	}

	@Override
	public void MouseClickedEvent(MouseEvent k) {
		// TODO Auto-generated method stub

	}

	@Override
	public int GetType() {
		// TODO Auto-generated method stub
		return Component.TYPE_BEHAVIOR;
	}

}
