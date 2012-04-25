package game.awt;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MainMenu extends JFrame{

	public static void main(String args[]) {
		JFrame main = new MainMenu();
		
		main.setVisible(true);
	}
	
	
	public MainMenu() {
		setPreferredSize(new Dimension(300, 300));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
