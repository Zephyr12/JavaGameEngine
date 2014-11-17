package myengine;
import java.awt.Graphics2D;
import java.io.Serializable;


public interface IRenderable extends Serializable{
	
	
	
	// use to render yourself onto a screen
	void Render(Graphics2D g, Vec2 offset);
}
