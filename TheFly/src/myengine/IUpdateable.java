package myengine;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.Serializable;


public interface IUpdateable extends Serializable{
	public void Update();
	public void OnCollide(CollisionInfo s);
	public void OnDestroy();
	public void KeyPressedEvent(KeyEvent k);
	public void MouseClickedEvent(MouseEvent k);
}
