package myengine;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;

//whole structure basically taken from the Unity3D engine with a bit off OOP thrown in
public class AnimatedSpriteRenderer extends Component implements IRenderable{
	
	
	List<BufferedImage> img = new ArrayList<>();
	int fps;
	float currentFrame = 0;
	public AnimatedSpriteRenderer(GameObject2D obj,String[] args){
		super(obj,args);
		fps = Integer.parseInt((String) args[0]);
		currentFrame = 0;
		LoadImagesFromPath((String[])Arrays.copyOfRange(args, 1, args.length),fps);
	}
	
	public void LoadImagesFromPath(String[] imgPaths,int fps){
		this.fps = fps;
		
		for(String imgPath : imgPaths){
			try {
				img.add(ImageIO.read(new File(imgPath)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				
			}
		}
	}
	
	@Override
	public void Render(Graphics2D g,Vec2 offset) {
		if(currentFrame >= img.size()){
			currentFrame = 0;
		}
		// TODO Auto-generated method stub
		g.rotate(Math.toRadians(object.rotation*360),object.x,object.y);
		g.drawImage(img.get((int)currentFrame),(int)(object.getX()+offset.x)-(img.get((int)currentFrame).getWidth()/2),(int)(object.getY()+offset.y)-(img.get((int)currentFrame).getHeight()/2),null);
		g.rotate(Math.toRadians(object.rotation*-360),object.x,object.y);
		currentFrame += fps/60.0;
		
	}

	@Override
	public int GetType() {
		// TODO Auto-generated method stub
		return this.TYPE_RENDERER;
	}

	

}
