package game_project_test_1;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Level1 extends Level {
	
	private int[] levelPixels;
	
	public Level1(String path){
		super(path);
	}
	

	protected  void loadLevel (String path){
		try{
			BufferedImage image=ImageIO.read(Level1.class.getResource(path));
			int w=image.getWidth();
			int h=image.getHeight();
			tiles=new Tile[w*h];
			levelPixels=new int[w*h];
			image.getRGB(0, 0,w,h,levelPixels,0,w);
		  } catch (IOException e){
			  System.out.println("Exception: loadLevel could not load level file");
	      }
    }
	
	//sunset - #ff5623
	//sky - #94c6d3
	//Cloud - #d3c4cd
	//VoidTile/NightSky - 
	protected void generateLevel(){
		for (int i=0;i<tiles.length;i++){
			System.out.println("Loop");
			if (levelPixels[i]==0xffFF5623){ tiles[i]=Tile.sunset;}
			if (levelPixels[i]==0xff94C6D3){ tiles[i]=Tile.sky;}
			if (levelPixels[i]==0xffD3C4CD){ tiles[i]=Tile.cloud;}
		}
	}
			
}
	
