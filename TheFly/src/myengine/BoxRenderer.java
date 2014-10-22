package myengine;

import java.awt.Color;
import java.awt.Graphics2D;

public class BoxRenderer extends Component implements IRenderable {
	Color c ;
	boolean f;
	int w;
	int h;
	public BoxRenderer(GameObject2D obj, String[] args) {
		super(obj, args);
		w = Integer.parseInt(args[0]);
		h = Integer.parseInt(args[1]);
		c = Color.decode(args[2]);
		f = Boolean.parseBoolean(args[3]);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Render(Graphics2D g, Vec2 offset) {
		// TODO Auto-generated method stub
		Color base = g.getColor();
		g.setColor(c);
		g.rotate(Math.toRadians(object.rotation*360),object.x,object.y);
		if(f){
			g.fillRect((int)(offset.x + (object.x - w/2)), (int)(offset.y + (object.y - h/2)), w, h);
		}else{
			g.drawRect((int)(offset.x + (object.x - w/2)), (int)(offset.y + (object.y - h/2)), w, h);
		}
		g.rotate(Math.toRadians(object.rotation*-360),object.x,object.y);
	}

	@Override
	public int GetType() {
		// TODO Auto-generated method stub
		return this.TYPE_RENDERER;
	}

}
