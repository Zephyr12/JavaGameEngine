package demo_main;

import java.io.File;

import myengine.GameWindow;
import myengine.World;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameWindow g = GameWindow.getInstance(50, 0);
		g.Resize(500, 500);
		World.currentWorld().parseXmlFile("src/level.xml");
		while(true){
			g.Update();
			g.Render();
			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
