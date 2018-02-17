package game_project_test_1;

public class FlowerTile extends Tile {
	public FlowerTile(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}
	
	public void render (int x,int y, Screen screen){
		screen.renderTile(x<<4,y<<4,this);
	}
    
	public boolean solid(){
		return false;
}
}
