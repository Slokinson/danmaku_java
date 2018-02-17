package game_project_test_1;

import java.util.Random;

public class Level2 extends Level {
	
	private static final Random random = new Random();
	
	public Level2(int width, int height){
		super(width,height);
	}
	
	protected void generateLevel(){
		/*for (int y=0;y<height;y++)
			for (int x=0;x<width;x++)
				tiles[x+y*width]=random.nextInt(4);*/
	}

}
