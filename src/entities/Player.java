package entities;

import static utilz.Constants.Directions.LEFT;
import static utilz.Constants.Directions.RIGHT;
import static utilz.Constants.Directions.UP;
import static utilz.Constants.PlayerConstants.IDLE;
import static utilz.Constants.PlayerConstants.RUNNING;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Player extends Entity{

	private BufferedImage[][] animations;
	private int aniTick, aniIndex, aniSpeed = 15;
	private int playerAction = IDLE;
	private boolean moving = false;
	private boolean left, up, right;
	private float playerSpeed = 2.0f;
	
	
	
	
	public Player(float x, float y) {
		super(x, y);
		loadAnimations();
		
	}
	public void update() {
		updatePos();
		updateAnimationTick();
		setAnimation();
	}
	
	public void render(Graphics g) {
		g.drawImage(animations[playerAction][aniIndex],(int) x,(int) y, 288, 128, null);
	}
	
	private void updateAnimationTick() {
		aniTick++;
		if(aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex++;
			if(aniIndex >= 8) {
				aniIndex = 0;
			}
		}
	}
	
	private void setAnimation() {
		if(moving) 
			playerAction = RUNNING;
		else
			playerAction = IDLE;
	}
	
	private void updatePos() {
		moving = false;
		
		if(left && !right) {
			x -= playerSpeed;
			moving = true;
		} else if(right && !left){
			x += playerSpeed;
			moving = true;
		}
		
		if(up) {
			y -= playerSpeed;
			moving = true;
		}
	}
	
	private void loadAnimations() {
		InputStream is = getClass().getResourceAsStream("/img/fire_FREE_SpriteSheet_288x128.png");
				
				try {
					BufferedImage img = ImageIO.read(is);
					
					animations = new BufferedImage[10][19];
					for(int j = 0; j < animations.length; j++) {
						for(int i = 0; i < animations[j].length; i++) {
							animations[j][i] = img.getSubimage(i*288, j*128, 288, 128);
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						is.close();
					} catch(IOException e){
						e.printStackTrace();
					}
				}
	}

	public boolean isLeft() {
		return left;
	}
	public void setLeft(boolean left) {
		this.left = left;
	}
	public boolean isUp() {
		return up;
	}
	public void setUp(boolean up) {
		this.up = up;
	}
	public boolean isRight() {
		return right;
	}
	public void setRight(boolean right) {
		this.right = right;
	}
}
