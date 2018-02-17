package mob;

import game_project_test_1.*;

public abstract class mob extends Game_object{
     protected Sprite sprite;
     protected int dir=0;
     protected boolean moving=false;
     
     public void move(){
    	 
     }
     
     public void tick(){
    	 
     }
     
     private boolean collision(){
    	 return false;
     }
}
