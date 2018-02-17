package game_project_test_1;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener,MouseMotionListener{
	
	private static int mouseX = -1;
	private static int mouseY = -1;
	private static int mouseB = -1;

	public static int getX() {
		return mouseX;
	}

	public static int getY() {
		return mouseY;
	}


	public static int getButton() {
		return mouseB;
	}


	public void mouseDragged(MouseEvent e) {
		mouseX=e.getX();
		mouseY=e.getY();
		
	}

	public void mouseMoved(MouseEvent e) {
		mouseX=e.getX();
		mouseY=e.getY();
		
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		mouseB=e.getButton();
		
	}

	public void mouseReleased(MouseEvent arg0) {
		mouseB = -1;
		
	}

}
