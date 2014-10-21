package TheFly_Main;

import myengine.GameWindow;
import myengine.World;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameWindow window = GameWindow.getInstance(100,1);
		World.currentWorld().parseXmlFile("src//MainTestingLevel.xml");
		window.setTitle("Zenith");
		window.Render();
		while(true){
			//System.out.println("testinf");
			//System.out.println("Testing");
			window.Render();
			window.Update();
			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
