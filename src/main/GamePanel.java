package main;

import java.awt.Dimension;
import java.awt.Graphics;
import static main.Game.GAME_HEIGHT;
import static main.Game.GAME_WIDTH;

import javax.swing.JPanel;

import input.KeyboardInput;
import input.MouseInput;


public class GamePanel extends JPanel{
	
	private MouseInput mouseInputs;
	private Game game;

	public GamePanel(Game game) {
		mouseInputs = new MouseInput(this);
		this.game = game;
		
		addKeyListener(new KeyboardInput(this));
		setPanelSize();
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
		
	}

	private void setPanelSize(){
		Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
		setPreferredSize(size);
	}
	

//	public void updateGame() {
//	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		game.render(g);
	}
	
	public Game getGame() {
		return game;
	}

	

	


}
