package myengine;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;


public class PointBody extends Component implements IUpdateable{
	
	public double mass;
	public double veloX;
	public double veloY;
	public boolean lockPos;
	public double bounce = 1;
	public PointBody(GameObject2D obj,String[] args) {
		super(obj,args);
		veloX = Double.parseDouble((String) args[1]);
		veloY = Double.parseDouble((String) args[2]);
		this.mass = Double.parseDouble((String) args[0]);
		this.bounce = Double.parseDouble((String) args[4]);
		lockPos = Boolean.parseBoolean((String) args[3]);
		
		// TODO Auto-generated constructor stub
		Physics.GetSingleton().RegisterBody(this);
	}
	
	public void AddForce(double d,double e){
		
		veloX += d/mass; 
		veloY += e/mass; 
	}
	public double invMass(){
		return (mass == 0) ? 0:1/mass;
	}
	
	@Override
	public void Update(){
		//if(GameInput.GetInstance().mouseStates[MouseEvent.BUTTON1] == true){
			//veloX += 0.2*(GameInput.GetInstance().mousePos.x-0.5f);
			//veloY += 0.2*(GameInput.GetInstance().mousePos.y-0.3f);
		//}
		//System.out.println(GameInput.GetInstance().mousePos.x);
		if(!lockPos){
			object.x += veloX;
			object.y += veloY;
		}else{
			veloX =0;
			veloY =0;
		}
	}

	@Override
	public void KeyPressedEvent(KeyEvent k) {
		// TODO Auto-generated method stub
		
	}
	public int GetType() {
		// TODO Auto-generated method stub
		return this.TYPE_BEHAVIOR;
	}

	@Override
	public void MouseClickedEvent(MouseEvent k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void OnCollide(CollisionInfo s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void OnDestroy() {
		// TODO Auto-generated method stub
		Physics.GetSingleton().DeleteBody(this);
	}
}
