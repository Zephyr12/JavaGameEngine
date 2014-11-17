package myengine;

import java.io.Serializable;



public abstract class Component implements Serializable {
	public static int TYPE_RENDERER = 2;
	public static int TYPE_BEHAVIOR = 4;
	public static int TYPE_COLLIDER = 6;
	protected GameObject2D object;
	public Component(GameObject2D obj,String[] args){
		object = obj;
	}
	public abstract int GetType();
	
	
}
