import javax.swing.*;
import java.awt.event.*;

public class MouseClickDetector implements MouseListener {
	private BurnsyMain mainGame;
	
	public MouseClickDetector(BurnsyMain b) {
		mainGame = b;
	}
	
	public void mouseClicked(MouseEvent e) {
		
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (mainGame.getState() == 0) {
				mainGame.startGame();
			}
		}
	}
	public void mousePressed(MouseEvent e) {
		
	}
	public void mouseReleased(MouseEvent e) {
		
	}
	public void mouseEntered(MouseEvent e) {
		
	}
	public void mouseExited(MouseEvent e) {
		
	}
}