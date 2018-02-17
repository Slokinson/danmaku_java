package game_project_test_1;


import java.util.ArrayList;
import java.util.List;

	public abstract class Enemy extends Game_object{
	     protected Sprite sprite;
	     protected int dir=0;
	     protected boolean moving=false;
	     protected List<Projectile> projectiles=new ArrayList <Projectile>();
	     
	     public void move (int xa, int ya){
	    	 
	    	 if(xa!=0 && ya!=0){
	    		 move(xa,0);
	    		 move(0,ya);
	    		 return;
	    	 }
	 		if (xa>0) dir=1;
	 		if (xa<0) dir=3;
	 		if (ya>0) dir=2;
	 		if (ya<0) dir=0;
	 		if(!collision(xa,ya)){
	 		x+=xa;
	 		y+=ya;}
	    	
	 	}
	     
	     public void tick(){
	    	 
	     }
	     
	     
	     protected boolean collision(int xa,int ya){
	    	 boolean solid=false;
	    	 if (level.getTile((x+xa)/16, (y+ya)/16).solid())
	          solid=true;
		     if((y+ya>1020)||y+ya<-20||(x+xa>600)||(x+xa<-20))
		         solid=true;
	    	 return solid;
	     }
	     

	 	protected void shoot(int x, int y, double dir){
	 		dir*=180/Math.PI;
	 		Projectile p = new HeroProjectile(x,y,dir);
	 		System.out.println("Shot");
	 		projectiles.add(p);
	 		level.add(p);
	 	}
	     /*
	     protected boolean collision(int xa,int ya){
	    	 boolean solid=false;
	    	 for (int i=0;i<4;i++){
	    		 int xt=((x+xa)+i%2*2-7)/16;//разобраться
	    		 int yt=((y+ya)+i/2*2+3)/16;
		    	 if (level.getTile(xt, yt/16).solid()) solid=true;
		     }
	    	 return solid;
	     }
	     */
	 	

		protected void updateShooting(){
			if(Mouse.getButton()==1){
				double dx=Mouse.getX()-Game.getWindowWidth()/2;
				double dy=Mouse.getY()-Game.getWindowHeight()/2;
				double dir=Math.atan2(dy, dx);
				shoot(x,y,dir);
			}
		}
	 	
	     public void render(){
	     }
}
