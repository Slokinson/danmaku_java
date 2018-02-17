package game_project_test_1;

public class Tile {
   public int x,y;
   public Sprite sprite;
   
   public static Tile sunset =new SkyTile(Sprite.sunset);
   public static Tile voidTile=new VoidTile(Sprite.voidSprite);
   public static Tile sky =new ClearSkyTile(Sprite.sky);
   public static Tile cloud =new CloudTile(Sprite.cloud);

   
   public Tile(Sprite sprite){
	   this.sprite=sprite;
   }
   
   protected void render(int x,int y, Screen screen){
	   
   }
   
   public boolean solid(){
	   return false;
   }
}
