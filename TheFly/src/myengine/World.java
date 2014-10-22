package myengine;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;




public class World {
	public List<GameObject2D> s;
	
	public static World instance;
	
	private World(){
		s = new ArrayList<GameObject2D>();
	}
	public void parseXmlFile(String pathToLevel){
			for(int i = 0; i < s.size();i++){
				this.DeleteObject(s.get(i));
			}
			//get the factor
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	
			try {
				//Using factory get an instance of document builder
				DocumentBuilder db = dbf.newDocumentBuilder();
	
				//parse using builder to get DOM representation of the XML file
				File srcFile = new File(pathToLevel);
			//	System.out.println(new File(".").getCanonicalPath());
				Document dom = db.parse(srcFile);
				
				GameWindow.getInstance(10,10).Resize(Integer.parseInt(dom.getFirstChild().getFirstChild().getNodeValue().split(",")[0].trim())
						, Integer.parseInt(dom.getFirstChild().getFirstChild().getNodeValue().split(",")[1].trim())
						);
				Node n = dom.getFirstChild().getFirstChild().getNextSibling();
				while(n != null){
					if(n.getNodeType() == Node.ELEMENT_NODE){
						if(n.getNodeName().equals("obj")){//found an object
							Node x = n.getFirstChild();
							String posXY = x.getNodeValue().replaceAll("\\s", "");
							int posX =Integer.parseInt(posXY.split(",")[0]);
							int posY =Integer.parseInt(posXY.split(",")[1]);
							float rot =Float.parseFloat(posXY.split(",")[2]);
							GameObject2D obj = new GameObject2D(posX,posY,rot);
							
							while(x != null){
								if(x.getNodeType() == Node.ELEMENT_NODE){// first component is a renderer
									String className = x.getNodeName();
									String rawArguements = x.getFirstChild().getNodeValue()+" ";
									String[] arguements = rawArguements.trim().split(",");
									//System.out.println(rawArguements);
									try {
										Component c = (Component) Class.forName(className).getConstructor(GameObject2D.class,String[].class).newInstance(obj,arguements);
										obj.AddComponent(c);
									} catch (InstantiationException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (IllegalAccessException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (IllegalArgumentException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (InvocationTargetException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (NoSuchMethodException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (SecurityException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (ClassNotFoundException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
								}
								x = x.getNextSibling();
							}
							World.currentWorld().RegisterObject(obj);
						}
					}
					n = n.getNextSibling();
					
				}
			}catch(ParserConfigurationException pce) {
				pce.printStackTrace();
			}catch(SAXException se) {
				se.printStackTrace();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
			
		}
	public static World currentWorld(){
		if(instance != null){
			return instance;
		}else{
			instance = new World();
			return instance;
		}
	}
	public void RegisterObject(GameObject2D d){
		
		s.add(d);
	}
	public void DeleteObject(GameObject2D d){
		d.OnDestroy();
		s.remove(d);
	}
	public IRenderable[] GetRenderers(){
		List<IRenderable> retL = new ArrayList<>();
		for(int i = 0; i < s.size();i++){
			GameObject2D go2 = s.get(i);
			retL.add(go2);
		}
		return retL.toArray(new IRenderable[retL.size()]);
	}
	public void Update(){
		for(int i = 0;i<s.size();i++){
			GameObject2D go2 = s.get(i);
			go2.Update();
		}
	}
	public void KeyPressed(KeyEvent e){
		for(int i = 0;i<s.size();i++){
			GameObject2D go2 = s.get(i);
			go2.KeyPressedEvent(e);
		}
	}
	public void MouseClicked(MouseEvent e){
		for(int i = 0;i<s.size();i++){
			GameObject2D go2 = s.get(i);
			go2.MouseClickedEvent(e);
		}
	}
	
}
