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
		public static final int RUN_FALL = 4;
		public static final int ATTACK_1 = 5;
		public static final int CROUCHING = 6;
		public static final int ATTACK_2= 7;
		public static final int ATTACK_3 = 8;

		
		public static int getSpriteAmount(int playerAction) {
			switch(playerAction) {
			case IDLE:
			case RUNNING:
				return 8;
			case JUMPING:
				return 2;
			default:
				return 1;
						
			}
		}
	}
}
