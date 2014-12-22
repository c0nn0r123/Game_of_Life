package gameBoard;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Color;

public class GUI {
	JFrame window = new JFrame("Game_of_Life");
	JPanel mainPanel = new JPanel(new GridLayout(100,100));
	JPanel[][] lifePanel = new JPanel[100][100];
	boolean[][] alive = new boolean[100][100];
	public GUI(){
		for(int i = 0; i < 10; i++){
			for(int x = 0; x < 10; x++){
				lifePanel[i][x] = new JPanel();
				alive[i][x] = true;
			}
		}
	}
}
