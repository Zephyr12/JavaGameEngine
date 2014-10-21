package myengine;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


public class TrailRenderer extends Component implements IUpdateable, IRenderable {
	List<Vec2> ppos;
	Color col;
	float distTillDraw;
	float maxPoints;
	public TrailRenderer(GameObject2D obj,String[] args) {
		super(obj,args);
		col = Color.decode((String)args[2]);
		// TODO Auto-generated constructor stub
		distTillDraw = Integer.parseInt((String)args[0]);
		maxPoints = Integer.parseInt((String)args[1]);
		ppos = new ArrayList<Vec2>();
		ppos.add(new Vec2(object.getX(),object.getY()));
	}

	@Override
	public void Render(Graphics2D g,Vec2 offset) {
		Color base = g.getColor();
		// TODO Auto-generated method stub
		g.setColor(col);
		int[] x = new int[ppos.size()],y = new int[ppos.size()];
		for(int i = 0;i < ppos.size();i++){
			x[i] = (int) (ppos.get(i).x+WorldViewer.GetViewMatrix().offset.x);
			y[i] = (int) (ppos.get(i).y+WorldViewer.GetViewMatrix().offset.y);
		}
		g.drawPolyline(x, y, ppos.size());
		g.setColor(base);
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		if(Vec2.Dist(new Vec2(object.getX(),object.getY()), ppos.get(ppos.size()-1))>distTillDraw){
			ppos.add(new Vec2(object.getX(),object.getY()));
		}
		if(ppos.size() > maxPoints){
			ppos.remove(0);
		}
	}

	@Override
	public void KeyPressedEvent(KeyEvent k) {
		// TODO Auto-generated method stub
		
	}
	public int GetType() {
		// TODO Auto-generated method stub
		return this.TYPE_RENDERER;
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
		
	}


}
