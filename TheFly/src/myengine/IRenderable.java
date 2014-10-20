package myengine;
import java.awt.Graphics2D;


public interface IRenderable {
	
	
	
	// use to render yourself onto a screen
	void Render(Graphics2D g, Vec2 offset);
}
