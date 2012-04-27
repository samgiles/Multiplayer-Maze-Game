package game.awt;

import entities.MovementListener;
import game.Game;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame{

	private static MainMenu instance = null;
	
	public static void showMenu() {
		if (instance == null) {
			instance = new MainMenu();
			instance.setSize(300, 300);
		}
		
		instance.setVisible(true);
	}
	
	public static void hideMenu() {
		if (instance == null) {
			return;
		}
		
		instance.setVisible(false);
	}
	
	public static void main(String args[]) {
		MainMenu.showMenu();
	}
	GamePanel game;
	
	private MainMenu() {
		getContentPane().setBackground(Color.BLACK);
		setPreferredSize(new Dimension(300, 300));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GamePanel.showPanel();
				MainMenu.this.setVisible(false);
			}
		});
		btnStartGame.setBounds(44, 59, 215, 25);
		getContentPane().add(btnStartGame);
		
		JButton btnStartMultiplayer = new JButton("Start Multiplayer");
		btnStartMultiplayer.setBounds(44, 96, 215, 25);
		getContentPane().add(btnStartMultiplayer);
		
		JButton btnViewPreviousMazes = new JButton("View Previous Mazes");
		btnViewPreviousMazes.setBounds(44, 155, 215, 25);
		getContentPane().add(btnViewPreviousMazes);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(44, 206, 215, 25);
		getContentPane().add(btnExit);
		
		JLabel lblAmazeing = new JLabel("MAZE GAME");
		lblAmazeing.setFont(new Font("Droid Sans Mono", Font.BOLD, 18));
		lblAmazeing.setForeground(new Color(0, 204, 51));
		lblAmazeing.setBounds(97, 30, 122, 17);
		getContentPane().add(lblAmazeing);
	}
}
