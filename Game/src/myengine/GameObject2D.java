package myengine;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


public class GameObject2D implements IRenderable, IUpdateable {
	List<IRenderable> renderers;
	List<IUpdateable> behaviors;
	ICollideable collider;
	public float x,y;
	public GameObject2D(int xpos,int ypos){
		behaviors = new ArrayList<IUpdateable>();
		renderers = new ArrayList<IRenderable>();
		collider = null;
		x = xpos;
		y = ypos;
	}
	public void AddRenderer(IRenderable r){
		renderers.add(r);
	}
	
	public void SetCollider(ICollideable c){
		collider = c;
	}
	public ICollideable GetCollider(){
		return collider;
	}
	public Component GetBehavior(Class t){
		for(IUpdateable u : behaviors){
			if(t == u.getClass()){
				return (Component) u;
			}
		}
		return null;
	}
	public void AddComponent(Component comp){
		switch(comp.GetType()){
			case 2:
				AddRenderer((IRenderable) comp);
				if(comp instanceof IUpdateable){
					behaviors.add((IUpdateable) comp);
				}
			break;
			case 4:
				behaviors.add((IUpdateable) comp);
			break;
			case 6:
				SetCollider((ICollideable) comp);
				if(comp instanceof IUpdateable){
					behaviors.add((IUpdateable) comp);
				}
			break;
			default:
			break;
		}
	}
	@Override
	public void Update() {
		// TODO Auto-generated method stub
		for(IUpdateable u : behaviors){
			//System.out.println(u.getClass());
			u.Update();
		}
	}
	public void setPos(float tx,float ty){
		x = tx;
		y = ty;
	}
	public int getX(){
		return (int)x;
	}
	public int getY(){
		return (int)y;
	}
	@Override
	public void Render(Graphics2D g , Vec2 offset) {
		// TODO Auto-generated method stub
		for(IRenderable renderer : renderers){
			if(renderer != null){
				renderer.Render(g, offset);
			}
		}
	}
	@Override
	public void KeyPressedEvent(KeyEvent k) {
		
		for(int i = 0;i<behaviors.size();i++){
			behaviors.get(i).KeyPressedEvent(k);
		}
		
	}
	@Override
	public void MouseClickedEvent(MouseEvent k) {
		// TODO Auto-generated method stub
		for(int i = 0;i<behaviors.size();i++){
			behaviors.get(i).MouseClickedEvent(k);
		}
	}
	@Override
	public void OnCollide(CollisionInfo s) {
		// TODO Auto-generated method stub
		for(int i = 0;i<behaviors.size();i++){
			behaviors.get(i).OnCollide(s);
		}
	}
	public void OnDestroy(){
		for(int i = 0;i<behaviors.size();i++){
			behaviors.get(i).OnDestroy();
		}
	}

}
