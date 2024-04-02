package utilz;

public class Constants {
	
	public static class Directions{
		public static final int LEFT = 0;
		public static final int UP = 1;
		public static final int RIGHT = 2;

	}
	
	public static class PlayerConstants{
		public static final int IDLE = 0;
		public static final int RUNNING = 1;
		public static final int JUMPING = 2;
		public static final int FALLING = 3;
		public static final int ATTACK_1 = 4;

		
		public static int getSpriteAmount(int playerAction) {
			switch(playerAction) {
			case IDLE:
				return 5;
			case RUNNING:
				return 6;
			case ATTACK_1:
			case JUMPING:
				return 3;
			default:
				return 1;
						
			}
		}
	}
}