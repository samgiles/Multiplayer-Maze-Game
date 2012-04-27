package com.sam.mazegenerator;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.graphics.AWTGraphicsContext;
import com.graphics.IGraphicsContext;

public class TestMazeGen extends JPanel {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new TestMazeGen());
		frame.setPreferredSize(new Dimension(300, 300));
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	MazeGenerator generator;
	
	public TestMazeGen() {
		super();
		generator = new MazeGenerator(10,10);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		IGraphicsContext graphics = new AWTGraphicsContext(g);
		generator.draw(graphics);
	}
}
