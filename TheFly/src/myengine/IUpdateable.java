package myengine;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;


public interface IUpdateable {
	public void Update();
	public void OnCollide(CollisionInfo s);
	public void OnDestroy();
	public void KeyPressedEvent(KeyEvent k);
	public void MouseClickedEvent(MouseEvent k);
}
