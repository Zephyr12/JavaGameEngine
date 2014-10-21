package myengine;

import java.awt.Graphics2D;

public class MouseForceLineRenderer extends Component implements IRenderable{
	
	public MouseForceLineRenderer(GameObject2D obj, String[] args) {
		super(obj, args);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Render(Graphics2D g, Vec2 offset) {
		// TODO Auto-generated method stub
		
		g.drawLine(g.getDeviceConfiguration().getBounds().width/2,
				g.getDeviceConfiguration().getBounds().height/2,
				(int) (GameInput.GetInstance().mousePos.x*g.getDeviceConfiguration().getBounds().width),
				(int) (GameInput.GetInstance().mousePos.y* g.getDeviceConfiguration().getBounds().height*1.5));
	}

	@Override
	public int GetType() {
		// TODO Auto-generated method stub
		return this.TYPE_RENDERER;
	}

	

}
