package gameBoard;

import javax.swing.*;

import java.awt.GridLayout;
import java.awt.Color;
import java.util.Random;

public class GUI {
	int setAlive = 0;
	Random gen = new Random();
	JFrame window = new JFrame("Game_of_Life");
	JPanel mainPanel = new JPanel(new GridLayout(100,100));
	JPanel[][] lifePanel = new JPanel[100][100];
	boolean[][] alive = new boolean[100][100];
	public GUI(){
		//creating first alive and dead panels
		for(int i = 0; i < 10; i++){
			for(int x = 0; x < 10; x++){
				setAlive = gen.nextInt(2);
				lifePanel[i][x] = new JPanel();
				mainPanel.add(lifePanel[i][x]);
				if(setAlive == 0){
				lifePanel[i][x].setBackground(Color.white);
				alive[i][x] = true;
				}else{
					lifePanel[i][x].setBackground(Color.black);
					alive[i][x] = false;
				}
			}
		}
		////////////////////////////////////////////
		//creating window
		window.add(mainPanel);
		window.setVisible(true);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	public boolean deadOrAlive(boolean cell,int x,int y){
		//a dead cell with 3 live neighbors becomes alive
		//a live cell with 2 or 3 live neighbors survives
		//any other time the cell dies or stays dead
		int neighbors = 0;
		if (cell){
			
		}
		
		
		
		return false;
	}
}
