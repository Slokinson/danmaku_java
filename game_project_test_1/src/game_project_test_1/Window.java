package game_project_test_1;

import java.awt.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;
public class Window {
	
	
	
	public Window(int w, int h, String title, Game game) {
		 game.setPreferredSize(new Dimension(w, h));
	        game.setMaximumSize(new Dimension(w, h));
	        game.setMinimumSize(new Dimension(w, h));

		
		JFrame frame = new JFrame("Тест 1");
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
        frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.start();
	}
 
}