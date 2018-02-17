package game_project_test_1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {
	
	private boolean[]keys = new boolean[120];
	public boolean up,down,left,right,dead;
	
	public void tick()
	{
		up=keys[KeyEvent.VK_W]||keys[KeyEvent.VK_UP];
		down=keys[KeyEvent.VK_S]||keys[KeyEvent.VK_DOWN];
		left=keys[KeyEvent.VK_A]||keys[KeyEvent.VK_LEFT];
		right=keys[KeyEvent.VK_D]||keys[KeyEvent.VK_RIGHT];
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_F1)
				dead=true;
		keys[e.getKeyCode()]=true;
	}

	public void keyReleased(KeyEvent e) {
		up=false;down=false;dead=false;right=false;left=false;
		keys[e.getKeyCode()]=false;

		
	}

	public void keyTyped(KeyEvent e) {
			
	}

}
