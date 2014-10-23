package myengine;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//whole structure basically taken from the Unity3D engine with a bit off OOP thrown in
public class SpriteRenderer extends Component implements IRenderable{
	
	
	BufferedImage img;
	public SpriteRenderer(GameObject2D obj,String[] args){
		super(obj,args);
		img = new BufferedImage(1,1,1);
		LoadImageFromPath((String)args[0]);
	}
	public void LoadImageFromPath(String imgPath){
		try {
			img = ImageIO.read(new File(imgPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(imgPath);
			e.printStackTrace();
		}
	}
	@Override
	public void Render(Graphics2D g,Vec2 offset) {
		// TODO Auto-generated method stub
		g.rotate(Math.toRadians(object.rotation*360),object.x+offset.x,object.y+offset.y);
		g.drawImage(img,(int)(object.getX()+offset.x-(img.getWidth()*0.5)),(int)(object.getY()+offset.y-(img.getHeight()*0.5)),null);
		g.rotate(Math.toRadians(object.rotation*-360),object.x+offset.x,object.y+offset.y);
	}
	public int GetType() {
		// TODO Auto-generated method stub
		return this.TYPE_RENDERER;
	}
	
}
