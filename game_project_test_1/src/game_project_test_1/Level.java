package game_project_test_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Level {
	
	protected Tile[] tiles;
	protected int height, width;
	protected int[] tilesInt;
	private List<Game_object> game_objects=new ArrayList<Game_object>();
	
	public Level(int width, int height){
		this.width=width;
		this.height=height;
		tilesInt=new int[width*height];
		generateLevel();
	}
	
	public Level(String path){
		loadLevel(path);
		generateLevel();
	}

	protected void loadLevel(String path) {
		// TODO Auto-generated method stub
		
	}

	protected void generateLevel() {

	}
	
	void tick(){
	   for (int i=0;i<game_objects.size();i++){
		  game_objects.get(i).tick();	}
	}
	
	
	
	private void time(){
		
	}
	
	protected void render (int xScroll, int yScroll, Screen screen){
		screen.setOffset(xScroll,yScroll);
		int x0=xScroll>>4;
		int x1=(xScroll+screen.width+16)>>4;
		int y0=yScroll>>4;
		int y1=(yScroll+screen.height+16)>>4;
		for (int y=y0;y<y1;y++){
			for (int x=x0;x<x1;x++){
				getTile(x,y).render(x, y, screen);
				if (x+y*16<0||x+y*16>=256 || tiles[x+y*16]==null) 
				{	
					Tile.voidTile.render(x, y, screen);
				    continue;
			    } 
				else
				tiles[x+y*16].render(x,y,screen);
			}
		}
	}
	
	protected Tile getTile(int x, int y){
		if (x<0 || y<0 || x>=width || y>= height) return Tile.voidTile;
		if (tilesInt[x+y*width]==0) {System.out.println("Case 1/1"); return Tile.sunset;}
		if (tilesInt[x+y*width]==1) return Tile.sky;
		if (tilesInt[x+y*width]==2) return Tile.cloud;

		return Tile.voidTile;
	}
	
	public void add(Game_object e){
		game_objects.add(e);
	}

}
