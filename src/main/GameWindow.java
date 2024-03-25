package main;

import javax.swing.JFrame;

public class GameWindow {
	private JFrame jframe;
	public GameWindow(GamePanel gamePanel) {
		jframe = new JFrame();
		
		jframe.setVisible(true);
		jframe.add(gamePanel);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.pack();	
		jframe.setResizable(false);
		jframe.setLocationRelativeTo(null);
	}
}
