package game_project_test_1;

public class HeroProjectile extends Projectile{
public HeroProjectile(int x,int y, double dir){
	super(x,y,dir);
	range=200;
	damage=20;
	speed=5;
	rateOfFire=3;
	sprite=Sprite.player_forward;
	nx=speed*Math.cos(angle);
	ny=speed*Math.sin(angle);
}

public void tick(){
	move();
  }

protected void move(){
	x+=nx;
	y+=ny;
  }

public void render(Screen screen){
	System.out.println("Projectile_rendering");
	screen.renderSprite(x,y,sprite);
  }
}
