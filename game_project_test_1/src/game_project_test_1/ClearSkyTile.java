package game_project_test_1;

public class ClearSkyTile extends Tile {

	public ClearSkyTile(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}
	
	protected void render (int x,int y, Screen screen){
		screen.renderTile(x<<4,y<<4,this);
	}
    
	public boolean solid(){
		return false;

}
}
