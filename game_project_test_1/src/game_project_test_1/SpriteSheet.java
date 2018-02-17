package game_project_test_1;

import java.awt.image.BufferedImage;

import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	private String path;
	final int SIZE;
	int[] pixels;

    public static SpriteSheet tiles=new SpriteSheet("/textures/sky.jpg",256);
    public static SpriteSheet voidTile=new SpriteSheet("/textures/sunset.jpg",256);
	//public static SpriteSheet projectile_hero=new SpriteSheet("/textures/sheets/projectiles/hero.png",256);
	public SpriteSheet(String path,int size){
	this.path=path;
	SIZE=size;
	pixels=new int[SIZE*SIZE];
	load();
	}
	
	public void load(){
 		try{
 			BufferedImage image=ImageIO.read(SpriteSheet.class.getResource(path));
 			int w=image.getWidth();
 			int h=image.getHeight();
 			image.getRGB(0,0,w,h,pixels,0,w);
 		}
 		catch(IOException e){
 			e.printStackTrace();
	    }
	}

}
