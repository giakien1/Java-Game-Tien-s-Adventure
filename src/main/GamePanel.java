package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import input.KeyboardInput;
import input.MouseInput;

import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.Directions.*;


public class GamePanel extends JPanel{
	private MouseInput mouseInputs;
	private Game game;
	
	//8064x1792
	//28x14
	public GamePanel(Game game) {
		mouseInputs = new MouseInput(this);
		this.game = game;
		
		addKeyListener(new KeyboardInput(this));
		setPanelSize();
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
		
		
	}

	private void setPanelSize(){
		Dimension size = new Dimension(1280, 800);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
	}
	

	public void updateGame() {
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		game.render(g);
	}
	
	public Game getGame() {
		return game;
	}

	

	


}
