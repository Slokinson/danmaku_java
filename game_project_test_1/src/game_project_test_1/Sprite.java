package game_project_test_1;

public class Sprite {
public final int SIZE;
private int x,y;
public int[] pixels;
private SpriteSheet sheet;
public static Sprite sunset = new Sprite(16,0,0,SpriteSheet.tiles);
public static Sprite sky = new Sprite(16,1,0,SpriteSheet.tiles);
public static Sprite cloud = new Sprite(16,2,0,SpriteSheet.tiles);

public static Sprite voidSprite = new Sprite(16,0,0,SpriteSheet.voidTile);

public static Sprite player_forward=new Sprite(32,0,5,SpriteSheet.tiles);
public static Sprite player_back=new Sprite(32,2,5,SpriteSheet.tiles);
public static Sprite player_left=new Sprite(32,3,5,SpriteSheet.tiles);
public static Sprite player_right=new Sprite(32,1,5,SpriteSheet.tiles);

public Sprite(int size,int x,int y, SpriteSheet sheet){
		SIZE=size;
		pixels=new int[SIZE*SIZE];
		this.x=x*size;
		this.y=y*size;
		this.sheet=sheet;
		load();
	}

public Sprite(int size, int color){
	SIZE=size;
	pixels=new int[SIZE*SIZE];
	setColor(color);
}

private void setColor(int color){
	for (int i=0;i<SIZE*SIZE;i++)
	{
		pixels[i]=color;
	}
}


private void load() {
	for (int y=0;y<SIZE;y++){
		for (int x=0;x<SIZE;x++){
			pixels[x+y*SIZE]=sheet.pixels[(x+this.x)+(y+this.y)*sheet.SIZE];
		}
	}
		
	
}
}
