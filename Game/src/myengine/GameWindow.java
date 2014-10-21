package myengine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;




public class GameWindow extends JFrame implements KeyListener,MouseListener,MouseMotionListener{
	FrontBuffer buffer;
	static GameWindow instance;
	
	public static GameWindow getInstance(int size,int aspectRatio){
		if(instance!=null){
			return instance;
		}else{
			instance =  new GameWindow(size,aspectRatio);
			return instance;

		}
	}
	
	private GameWindow(int size,double aspectRatio){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setSize(size,20);//(int)(size*aspectRatio));
		buffer = new FrontBuffer((int)((this.getWidth())),(int)((this.getHeight())));
		
		buffer.setFocusable(true);
		
		buffer.addKeyListener(this);
		buffer.addMouseMotionListener(this);
		buffer.addMouseListener(this);
		

		this.setContentPane(buffer);
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
		this.setResizable(true);
		//World.currentWorld().parseXmlFile("src"+File.separator+"StartMenu.xml");
		GameInput.GetInstance().setsize(size,(int) (size*aspectRatio));
		
	}
	
	public void Resize(int x,int y){
		this.setSize(x,y);
		
		buffer = new FrontBuffer(this.getWidth(),this.getHeight());
		
		buffer.setFocusable(true);
		
		buffer.addKeyListener(this);
		buffer.addMouseMotionListener(this);
		buffer.addMouseListener(this);
		

		this.setContentPane(buffer);
		buffer.repaint();
		//World.currentWorld().parseXmlFile("src"+File.separator+"StartMenu.xml");
		GameInput.GetInstance().setsize(x,y);
	}
	
	public void Render(){
		buffer.RenderBatch(World.currentWorld().GetRenderers(),WorldViewer.GetViewMatrix().GetOffset());
		buffer.repaint();
	}
	
	public void Update(){
		World.currentWorld().Update();
		Physics.GetSingleton().Simulate();
		
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		System.out.println(arg0.toString());
		World.currentWorld().KeyPressed(arg0);
		GameInput.GetInstance().PressKey(arg0.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		World.currentWorld().KeyPressed(arg0);
		GameInput.GetInstance().ReleaseKey(arg0.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		World.currentWorld().KeyPressed(arg0);
		

	}



	@Override
	public void mouseClicked(MouseEvent e) {
		buffer.requestFocusInWindow();
		// TODO Auto-generated method stub
		World.currentWorld().MouseClicked(e);
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		GameInput.GetInstance().ReportMouseClick(e.getButton());
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	
		GameInput.GetInstance().ReportMouseUp(e.getButton());
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseDragged(MouseEvent e) {
		
		GameInput.GetInstance().ReportMouseMove(new Vec2(e.getPoint().x/(float)buffer.getWidth(),e.getPoint().y/(float)buffer.getHeight()));
	}



	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.toString());
		GameInput.GetInstance().ReportMouseMove(new Vec2(e.getPoint().x/(float)buffer.getWidth(),e.getPoint().y/(float)buffer.getHeight()));
	}

	
	
}
