package myengine;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;


public class TiledMapRenderer extends Component implements IRenderable{
	
	
	List<BufferedImage> tiles = new ArrayList<>();
	
	BufferedImage map;
	public TiledMapRenderer(GameObject2D obj,String[] args){
		super(obj,args);
		
		
		
	}
	
	public void LoadImagesFromPath(String[] imgPaths,int fps){
		for(int x = 0; x < map.getWidth();x++){
			
		}
		
	}
	
	@Override
	public void Render(Graphics2D g,Vec2 offset) {
		
		
	}
	public int GetType() {
		// TODO Auto-generated method stub
		return this.TYPE_RENDERER;
	}

}