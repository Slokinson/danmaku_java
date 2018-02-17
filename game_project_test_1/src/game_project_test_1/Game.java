package game_project_test_1;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{

	//Timer timer = new Timer(20, this);
	

	JFrame frame;
	private KeyInput key;
    private boolean running = false;
    private Thread thread;
    private static int width=800;
    private static int height=600;
    private BufferedImage image = new BufferedImage(800,600,BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
    private Screen screen;
    private int curFps;
    private Level level;
    public static int state;
    private Player player;
    public static int scale=3;


    
	public Game(){
	       screen=new Screen(width,height);
	       level=new Level1("/textures/level.png");
	       System.out.println(state);
	       key=new KeyInput();
		   TileCoordinate playerSpawn = new TileCoordinate(0,0);
	       player=new Player(key);
	       player.init(level);
	       Mouse mouse=new Mouse();
	       addMouseMotionListener(mouse);
	       addMouseListener(mouse);
	       addKeyListener(key);
	}
	
	
	public static int getWindowWidth(){
		  return width*scale;
	  }
	  
	  public static int getWindowHeight(){
		  return height*scale;
	  }
	  public void handler(){
		  BufferedImageLoader loader = new BufferedImageLoader();
		  //back = loader.loadImage("/level1back.png");
	  }
	
	    
	 public synchronized void start(){
	        if(!running){
	            running = true;
	            thread = new Thread(this,"Display");
	            thread.start();
	        }
	    }
	 
	 
	 public synchronized void stop(){
		 running=false;
		 try{thread.join();
		 } catch(InterruptedException e){
			 e.printStackTrace();
		 }
	 }
	 
	 
	 /*private void init(){
	    }*/
	  private void checkState() {
	       switch(state){
	         case 0: ; break;
	         case 1: level= new RandomLevel(64,64); break;
	       default: System.out.println("Произошла ошибка");}
		
	}
	 public void run(){
		 checkState();
		 long lastTime=System.nanoTime();
		 final double ns=1000000000.0/60.0; //подумать чо тут происходит
		 double delta=0;
	     long timer = System.currentTimeMillis();
	     int frames = 0;
	     requestFocus();
		 while (running){
			 long now=System.nanoTime();  // TODO: разобраться
			 delta+=(now-lastTime)/ns;
	         lastTime = now;
			 while (delta >=1){
			   tick();
			   delta--;
			 }
			 render();
			 frames++;
	         if(System.currentTimeMillis() - timer > 1000){
	             timer += 1000;
	             curFps = frames;
	             frames = 0;
	         }
		 }
	 }
	 
	 private void init() {
		// TODO Auto-generated method stub
		
	}
	public void tick()
	 {
	    key.tick();
	    player.tick();
	    level.tick();	
        checkState();

	 }
	 
	 public static void main(String[] args) {
	        new Window(800, 600, "Данмаку-шутер", new Game());
	    }
	 
	 public void render()
	 {
		 BufferStrategy bs = this.getBufferStrategy();
	        if(bs == null){
	            this.createBufferStrategy(3);
	            return;
	        }
	     screen.clear();
	     int xScroll=player.x-screen.width/2;
	     int yScroll=player.y-screen.height/2;
	     level.render(xScroll,yScroll,screen);
	     player.render(screen);
	     for (int i=0; i<pixels.length;i++){
	    	 pixels[i]=screen.pixels[i];
	     }
	     Graphics g=bs.getDrawGraphics();
	     g.drawImage(image,0,0,getWidth(),getHeight(),null); //ещё немного повторить как это работает
	     g.setColor(Color.BLACK);
	     g.setFont(new Font("Verdana",0,50));
	     g.dispose();
	     bs.show(); 
	    	 

	     //g.drawImage(back, 0, 0, getWidth(), getHeight(), this);

	     
	 }
    }