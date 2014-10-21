package myengine;
import java.awt.Graphics2D;


public class PointRenderer extends Component implements IRenderable {

	public PointRenderer(GameObject2D obj,String[] args) {
		super(obj,null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Render(Graphics2D g,Vec2 offset) {
		g.drawOval((int)(object.getX()+offset.x)-3, (int)(object.getY()+offset.y)-3, 6, 6);
	}
	public int GetType() {
		// TODO Auto-generated method stub
		return this.TYPE_RENDERER;
	}

	
}
