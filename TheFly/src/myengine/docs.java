package myengine;
/*
common usage:
create a main class
inside the class
pastethis

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
and create a file called 
MainTestingLevel.xml
and fill it with
<?xml version="1.0"?>
<Scene>
	<obj>420,200
		
		<myengine.BoxCollider> 32,32</myengine.BoxCollider>	
		<myengine.PointBody> 1,0,0,true,1 </myengine.PointBody>
		
	</obj>
</Scene>
*/