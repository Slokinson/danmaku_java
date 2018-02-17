package game_project_test_1;

import java.util.Random;

public class Screen {
	
	public int width, height;
	public int[] pixels;
	private final int MAP_SIZE=64;
	private final int MAP_SIZE_MASK=MAP_SIZE-1;
	public int[] tiles=new int[MAP_SIZE*MAP_SIZE];
	public int xOffset,yOffset;
	private Random random = new Random();
	int x=0;
	int y=0;
	int counter=0;
	
	public Screen(int width, int height){
		this.width=width;
		this.height=height;
		pixels=new int[width*height];
		
		for (int i=0; i<64*64; i++){
			tiles[i]=random.nextInt(0xffffff);
			tiles[0]=0;
		}
			
	}
	
	
	public void clear(){
		for (int i=0;i<pixels.length;i++)
			pixels[i]=0;
	}
	/*public void render(int xOffset, int yOffset){
		counter++;
		if (counter%100==0) //перепосмотреть почему
			x++;
		if (counter%800==0)
			y++;
		for (int y=0;y<height;y++){
			int yp=y+yOffset;
			if (yp<0 || yp>=height) continue;
			for (int x=0;x<width;x++){
				int xp=x+xOffset;
				if (xp<0 || xp>=width) 	continue;
				//int tileIndex=((xx>>4)&MAP_SIZE_MASK)+((yy>>4)&MAP_SIZE_MASK)*MAP_SIZE; //посмотреть про битовый сдвиг, и где &63 - ограничение
				pixels[xp+yp*width]=Sprite.sky.pixels[(x&15)+(y&15)*Sprite.sky.SIZE];
			}
		}
	}*/
	
	public void renderTile(int xp,int yp, Tile tile){
		xp-=xOffset;
		yp-=yOffset;
		for (int y=0;y<tile.sprite.SIZE;y++){
			int ya=y+yp;
			for (int x=0;x<tile.sprite.SIZE;x++){
				int xa=x+xp;
				if (xa<-tile.sprite.SIZE||xa>=width||ya<0||ya>=height) break;
				if (xa<0) xa=0;
				pixels[xa+ya*width]=tile.sprite.pixels[x+y*tile.sprite.SIZE];
			}
		}
	}
	
	public void renderSprite(int xp, int yp, Sprite sprite){
		xp-=xOffset;
		yp-=yOffset;
		for (int y=0;y<sprite.SIZE;y++){
			int ya=y+yp;
			for (int x=0;x<sprite.SIZE;x++){
				int xa=x+xp;
				if (xa<-sprite.SIZE||xa>=width||ya<0||ya>=height) break;
				if (xa<0) xa=0;
				pixels[xa+ya*width]=sprite.pixels[x+y*sprite.SIZE];
			}
		}
	}
	
	public void renderPlayer(int xp, int yp, Sprite sprite){
		xp-=xOffset;
		yp-=yOffset;
		for (int y=0;y<32;y++){
			int ya=y+yp;
			for (int x=0;x<32;x++){
				int xa=x+xp;
				if (xa<-32||xa>=width||ya<0||ya>=height) break;
				if (xa<0) xa=0;
				int col=sprite.pixels[x+y*32];
				if (col>=0xffFEFEFE || col==0xffffffff)
					System.out.println(" ");
					else
				  pixels[xa+ya*width]=col;
			}
		}
	}
	
	public void setOffset(int xOffset, int yOffset){
		this.xOffset=xOffset;
		this.yOffset=yOffset;
	}

}
