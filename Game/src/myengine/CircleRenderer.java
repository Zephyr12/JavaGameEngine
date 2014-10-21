package myengine;
//testing egit
import java.awt.Color;
import java.awt.Graphics2D;

public class CircleRenderer extends Component implements IRenderable {
	Color c;
	int r;
	boolean f;
	public CircleRenderer(GameObject2D obj, String[] args) {
		super(obj, args);
		r = Integer.parseInt(args[0]);
		c = Color.decode(args[1]); 
		if(args.length>2){
			f = Boolean.parseBoolean(args[2]);
		}
		// TODO Auto-generated constructor stub
	}
	public void SetFill(boolean fill){
		f = fill;
	}
	@Override
	public void Render(Graphics2D g, Vec2 offset) {
		// TODO Auto-generated method stub
		Color base = g.getColor();
		g.setColor(c);
		g.drawOval((int)(object.getX()+offset.x)-r, (int)(object.getY()+offset.y)-r, 2*r, 2*r);
		if(f)
			g.fillOval((int)(object.getX()+offset.x)-r, (int)(object.getY()+offset.y)-r, 2*r, 2*r);
		g.setColor(base);
	}

	@Override
	public int GetType() {
		// TODO Auto-generated method stub
		return this.TYPE_RENDERER;
	}
	

}
