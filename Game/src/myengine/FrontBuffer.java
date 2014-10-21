package myengine;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.swing.JPanel;


public class FrontBuffer extends JPanel{
	BufferedImage b;
	
	public FrontBuffer(int x, int y){
		this.setSize(x,y);
		b = new BufferedImage(x,y,BufferedImage.TYPE_3BYTE_BGR);
		
	}
	
	public void RenderBatch(IRenderable[] i,Vec2 o){
		b = new BufferedImage(b.getWidth(),b.getHeight(),BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g = b.createGraphics();
		for (int y =0;y<i.length;y++){
			IRenderable ir = i[y]; 
			//g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			ir.Render(g,o);
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		Graphics2D g1 = (Graphics2D) g;
		
		super.paintComponents(g);
		g1.drawImage(b,0,0,this.getWidth(),this.getHeight()+20,Color.white, null);
	}
	
}
