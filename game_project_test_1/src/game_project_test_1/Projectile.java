package game_project_test_1;

public abstract class Projectile extends Game_object{
     protected final int xOrigin, yOrigin;
     protected double angle;
     protected Sprite sprite;
     protected double nx,ny;
     protected double speed, rateOfFire, range, damage;
     public Projectile(int x,int y, double dir){
    	 xOrigin=x;
    	 yOrigin=y;
    	 angle=dir;
    	 this.x=x;
    	 this.y=y;
     }
public Sprite getSprite(){
	
	return sprite;
}

public int getSpriteSize(Sprite sprite){
	return sprite.SIZE;
}

protected void move(){
}
}