package gameBoard;

import javax.swing.*;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class GUI implements ActionListener {
	JFrame window = new JFrame("Game_of_Life");
	JPanel mainPanel = new JPanel(new GridLayout(100,100,2,2));
	JPanel[][] lifePanel = new JPanel[100][100];
	boolean[][] alive = new boolean[100][100];
	Scanner rd = new Scanner(System.in);
	Timer timer = new Timer(500, this);

	public GUI(){
		
		System.out.println("what Shape?");
		System.out.println("Boat, Ship, Beehive, loaf, or move");
		String Shape = rd.nextLine();
		
		//creating first alive and dead panels
		for(int i = 0; i < 100; i++){
			for(int x = 0; x < 100; x++){
				lifePanel[i][x] = new JPanel();
				alive[i][x] = false;
				startShape(i,x,Shape);
				if(!alive[i][x])
					lifePanel[i][x].setBackground(Color.black);
				else
					lifePanel[i][x].setBackground(Color.white);
				mainPanel.add(lifePanel[i][x]);
				}
			}
		
		////////////////////////////////////////////
		//creating window
		window.add(mainPanel);
		window.setVisible(true);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		timer.start();
	}
	///////still life starters and the movement starter////////////
	public void startShape(int y, int x, String state){
		if (state.equalsIgnoreCase("beehive")){
			if (((y == 45 || y == 46) && (x == 43 || x == 45)) || ((x == 44) && (y == 44 || y == 47))){
				alive[y][x] = true;
			}
		}else if(state.equalsIgnoreCase("boat")){
			if((y == 45 && (x == 44 || x == 46)) || (y == 46 && ( x == 45 || x == 46)) || (y == 44 && x == 45)){
				alive[y][x] = true;
			}
		}else if(state.equalsIgnoreCase("ship")){
			if((y == 45 && (x == 44 || x == 46)) || (y == 46 && ( x == 45 || x == 46)) || (y == 44 && (x == 44 ||x == 45))){
				alive[y][x] = true;
			}
		}else if(state.equalsIgnoreCase("loaf")){
			if((y == 45 && (x == 44 || x == 46)) || (y == 46 && ( x == 44 || x == 47)) || (y == 44 && x == 45)|| (y == 47 &&(x == 45 || x == 46))){
				alive[y][x] = true;
			}
		}else if(state.equalsIgnoreCase("move")){
			if(y > 30 && y < 50 && x > 47 && x < 50){
				alive[y][x] = true;	
			}
		}
	}
	////////////////////////////////////////////
 	public boolean deadOrAlive(boolean cell,int x,int y){

		//a dead cell with 3 live neighbors becomes alive
		//a live cell with 2 or 3 live neighbors survives
		//any other time the cell dies or stays dead
		//use loop -1 to 1 to loop through neighbors
		int neighbors = 0;
		if (cell){
			for(int i =-1;i<=1;i++){
				for(int j = -1; j<=1;j++){
					if(((x + i >= 0) && (y + j >=0)) && ((x + i <= 99) &&  (y + j <= 99)) && !(i == 0 && j == 0)){// && i == j)){
						if(alive[x+i][y+j]){
							//System.out.println("alive");
							neighbors++;
						}
					}
				}
			}
			if(neighbors == 2||neighbors==3){
				return true;
			}else 
				return false;
		}else if(!cell){
			for(int i =-1;i<=1;i++){
				for(int j = -1; j<=1;j++){
					if(((x + i >= 0) &&  (y + j >=0)) && ((x + i <= 99) &&  (y + j <= 99)) && !(i == 0 && j == 0 && i == j)){
						if(alive[x+i][y+j]){
							//System.out.println("alive");
							neighbors++;
						}
					}
				}
			}
			if(neighbors == 3){
				return true;
			}else 
				return false;
		}

		return false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 100; i++){
			for(int x = 0; x < 100; x++){
				alive[i][x] = deadOrAlive(alive[i][x],i,x);
				if(alive[i][x]){
					lifePanel[i][x].setBackground(Color.white);
					alive[i][x]=true;
				}else{
					lifePanel[i][x].setBackground(Color.black);
					alive[i][x]=false;
				}	
			}
		}
		mainPanel.updateUI();
		System.out.println("tick");
	}
}
