package game_project_test_1;

import java.awt.event.KeyEvent;

import mob.mob;

public class Player extends Enemy
{
	
	private KeyInput input;
	
	public Player(KeyInput input){
		this.input=input;
		sprite=Sprite.player_forward;
	}
	
	public Player (int x, int y,KeyInput input){
		this.x=x;
		this.y=y;
		this.input=input;
	}
	
	
	
	public void tick(){
		int xa=0, ya=0;

		Game.state=0;
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;
		
		if (xa!=0||ya!=0) move(xa,ya);
		updateShooting();
	}
	
	public void render(Screen screen){
		if(dir==0) sprite=Sprite.player_forward;
		if(dir==1)sprite=Sprite.player_right;
		if(dir==2)sprite=Sprite.player_forward;
		if(dir==3)sprite=Sprite.player_left;
		screen.renderPlayer(x-16, y-16, sprite);
	}
	
	
}
