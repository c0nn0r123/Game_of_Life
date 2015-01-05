package gameBoard;

import javax.swing.*;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
	JFrame window = new JFrame("Game_of_Life");
	JPanel mainPanel = new JPanel(new GridLayout(100,100,2,2));
	JPanel[][] lifePanel = new JPanel[100][100];
	boolean[][] alive = new boolean[100][100];
	Timer timer = new Timer(2000, this);
	public GUI(){
		//creating first alive and dead panels
		for(int i = 0; i < 100; i++){
			for(int x = 0; x < 100; x++){
				lifePanel[i][x] = new JPanel();
				if(i > 30 && i < 50 && x > 47 && x < 50){
					lifePanel[i][x].setBackground(Color.white);
<<<<<<< HEAD
					alive[i][x] = true;	
=======
					
					alive[i][x] = true;
					alive[i][x]=true;	

					alive[i][x] = true;

					alive[i][x]=true;	

>>>>>>> origin/master
				}else{
					lifePanel[i][x].setBackground(Color.black);
					alive[i][x] = false;
				}
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
							System.out.println("alive");
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
							System.out.println("alive");
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
	/*public boolean onBoard (int x,int y, int i, int j){
		if(x+i>=0){
	}
		return false;

	}*/
	@Override
	public void actionPerformed(ActionEvent arg0) {
		for(int i = 0; i < 100; i++){
			for(int x = 0; x < 100; x++){
<<<<<<< HEAD
=======

>>>>>>> origin/master
				alive[i][x] = deadOrAlive(alive[i][x],i,x);
				if(alive[i][x]){
					lifePanel[i][x].setBackground(Color.white);
					alive[i][x]=true;
				
				}else{
					lifePanel[i][x].setBackground(Color.black);
<<<<<<< HEAD
				mainPanel.updateUI();				
=======
					alive[i][x]=false;
				}
				mainPanel.updateUI();


				//deadOrAlive(alive[i][x],i,x);

>>>>>>> origin/master
			}
		}
		
		System.out.println("tick");
	}
}
