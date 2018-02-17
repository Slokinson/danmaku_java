package game_project_test_1;
public class Character extends Game_object {
	int x=0;
    int y=0;
    int speed=2;
	int mapX=0;
	int mapY=0;
	int storedDirection;
	Direction objectDirection = Direction.NONE;

	public void move() {
		switch(objectDirection) {
		case UP:
			mapY+=speed;
			break;
		case DOWN:
			mapY-=speed;
			break;
		case LEFT:
			mapX+=speed;
			break;
		case RIGHT:
			mapX-=speed;
			break;
		case STOP:
			speed=0;
			break;
		case MOVE:
			speed=2;
		default:
			break;
		}
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getMapX() {
		return mapX;
	}
	
	public int getMapY() {
		return mapY;
	}
	
	
	public int getSpeed() {
		return speed;
	}
	
}
