package game_project_test_1;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Game_object{
	int id;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	int weidth;
	int height;
	public int x, y;
	boolean object_reveal;  //���� object_revealed=0 - ������ �� ������������ �� �����, 1 - ������������
	boolean life; //���� life=0, ������ ���������� �����-�� ������� �� �������, 1 - �������
	
	public void tick(){
		
	}
	
	public void render(Screen screen){
		
	}
	
	public void remove(){
		removed=true;
	}
	
	public boolean isRemoved(){
		return removed;
	}
	public void init (Level level){
		this.level=level;
	}
	
	}
