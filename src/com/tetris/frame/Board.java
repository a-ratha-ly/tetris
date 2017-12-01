package com.tetris.frame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import com.tetris.figure.*;


public class Board {
	
	private int board [][];
	private Figures one;
	private Random rand;
	private int score=0;
	private ArrayList<String> colors;

	public Board(){
		
		board= new int [20][10];
		rand=new Random();

		for(int i=0;i<20;i++){
			for(int j=0;j<10;j++){
				board[i][j]=0;
			}
		}

		for(int i=0;i<20;i++){
			board[i][0]=-1;
			board[i][9]=-1;
		}

		for(int j=0;j<10;j++){
			board[19][j]=-2;
		}
		
		colors = new ArrayList<String>();
		colors.add("no");
	}
	

	public void addfigure(){
		
		int n= rand.nextInt(6) + 1; //rand.nextInt(6 - 1 + 1) + 1;
		
		switch(n){
			case 1:one = new Blue();
				   colors.add("blue");
				break;
			case 2:one = new Green();
				   colors.add("green");
				break;
			case 3:one = new Blue();
				break;
			case 4:one = new Blue();
				break;
			case 5:one = new Blue();
				break;
			case 6:one = new Blue();
				break;	
		}
		
		if(one instanceof Blue){
			int tab[][]=((Blue)one).getBlue();
			int posX=((Blue)one).getPositionX();
			int posY=((Blue)one).getPositionY();
		
		
			for(int i=posX,ii=0;i<posX+4;i++,ii++){
				for(int j=posY,jj=0;j<posY+4;j++,jj++){
					if(tab[ii][jj]==Figures.nb)  board[i][j]=tab[ii][jj];
				}
			}
		}else if(one instanceof Green){
			int tab[][]=((Green)one).getGreen();
			int posX=((Green)one).getPositionX();
			int posY=((Green)one).getPositionY();
		
		
			for(int i=posX,ii=0;i<posX+4;i++,ii++){
				for(int j=posY,jj=0;j<posY+4;j++,jj++){
					if(tab[ii][jj]==Figures.nb)  board[i][j]=tab[ii][jj];
				}
			}
		}
	}
	
	public void remove(){
		
		if(one instanceof Blue){
			int posX=((Blue)one).getPositionX();
			int posY=((Blue)one).getPositionY();
			int tab[][]=((Blue)one).getBlue();
		
			for(int i=posX,ii=0;i<posX+4;i++,ii++){
				for(int j=posY,jj=0;j<posY+4;j++,jj++){
					if(tab[ii][jj]==Figures.nb) board[i][j]=0;
				}
			}
		}else if(one instanceof Green){
			
			int posX=((Green)one).getPositionX();
			int posY=((Green)one).getPositionY();
			int tab[][]=((Green)one).getGreen();
		
			for(int i=posX,ii=0;i<posX+4;i++,ii++){
				for(int j=posY,jj=0;j<posY+4;j++,jj++){
					if(tab[ii][jj]==Figures.nb) board[i][j]=0;
				}
			}
		}
	}

	public void down(){
		
		boolean value=false;
		int tab[][]=null;
		int posXa,posYa;
		int posX=0,posY=0;
		
		if(one instanceof Blue){
	
			tab=((Blue)one).getBlue();
			posXa=((Blue)one).getPositionX();
			posYa=((Blue)one).getPositionY();
		
			if(one.getDirection().compareTo("left")==0){
				if(board[posXa+2][posYa]==0 && board[posXa+3][posYa+1]==0 ){
					((Blue)one).down();
				}
				else value=true;
			}else if(one.getDirection().compareTo("up")==0){
				if(board[posXa+2][posYa]==0 && board[posXa+2][posYa+1]==0 && board[posXa+2][posYa+2]==0){
					((Blue)one).down();
				}
				else value=true;
			}else if(one.getDirection().compareTo("down")==0){
				if(board[posXa+2][posYa]==0 && board[posXa+3][posYa+1]==0 && board[posXa+2][posYa+2]==0){
					((Blue)one).down();
				}
				else value=true;
			}else{
				if(board[posXa+3][posYa+1]==0 && board[posXa+2][posYa+2]==0){
					((Blue)one).down();
				}
				else value=true;
			}
			
			this.line();
			posX=((Blue)one).getPositionX();
			posY=((Blue)one).getPositionY();
			
		}else if(one instanceof Green){
			
			tab=((Green)one).getGreen();
			posXa=((Green)one).getPositionX();
			posYa=((Green)one).getPositionY();
		
			if(one.getDirection().compareTo("left")==0){
				if(board[posXa+3][posYa+1]==0 && board[posXa+3][posYa+2]==0 ){
					((Green)one).down();
				}
				else value=true;
			}else if(one.getDirection().compareTo("up")==0){
				if(board[posXa+3][posYa]==0 && board[posXa+3][posYa+1]==0 && board[posXa+3][posYa+2]==0){
					((Green)one).down();
				}
				else value=true;
			}else if(one.getDirection().compareTo("down")==0){
				if(board[posXa+1][posYa]==0 && board[posXa+1][posYa+1]==0 && board[posXa+2][posYa+2]==0){
					((Green)one).down();
				}
				else value=true;
			}else{
				if(board[posXa+1][posYa+1]==0 && board[posXa+3][posYa]==0) {
					((Green)one).down();
				}
				else value=true;
			}
			
			this.line();
			posX=((Green)one).getPositionX();
			posY=((Green)one).getPositionY();
		}
		
		for(int i=posX,ii=0;i<posX+4;i++,ii++){
			for(int j=posY,jj=0;j<posY+4;j++,jj++){
				if(tab!= null)     //***************************************************************************
				if(tab[ii][jj]==Figures.nb) board[i][j]=tab[ii][jj];
			}
		}
		if(value) this.addfigure();
	}

	public void turn(){
		
		int tab[][]=null;
		int posXa,posYa;
		int posX=0,posY=0;
		
		if(one instanceof Blue){
			
			posXa=((Blue)one).getPositionX();
			posYa=((Blue)one).getPositionY();
			
			if(one.getDirection().compareTo("left")==0){
				if(board[posXa+1][posYa+2]!=-1){
					((Blue)one).turn();
				}
				else if(board[posXa][posYa]==0 && board[posXa+2][posYa]==0 && board[posXa][posYa+2]==0
						&& board[posXa+1][posYa+2]==0 && board[posXa+2][posYa+2]==0){
					((Blue)one).turn();
				}
			}else if(one.getDirection().compareTo("right")==0){
				if(board[posXa+1][posYa]!=-1){
					((Blue)one).turn();
				}
				else if(board[posXa][posYa]==0 && board[posXa+1][posYa]==0 && board[posXa+2][posYa]==0
						&& board[posXa][posYa+2]==0 && board[posXa+2][posYa+2]==0){
					((Blue)one).turn();
				}
			}else if(one.getDirection().compareTo("up")==0){
				if(board[posXa+2][posYa+1]!=-2){
					((Blue)one).turn();
				}
				else if(board[posXa][posYa]==0 && board[posXa][posYa+2]==0 && board[posXa+2][posYa]==0
						&& board[posXa+2][posYa+1]==0 && board[posXa+2][posYa+2]==0){
					((Blue)one).turn();
				}
			} else if(board[posXa][posYa]==0 && board[posXa][posYa+1]==0 && board[posXa][posYa+2]==0
					&& board[posXa+2][posYa]==0 && board[posXa+2][posYa+2]==0){
				((Blue)one).turn();
			} else{
				((Blue)one).turn();
			}
			
			tab=((Blue)one).getBlue();
			
			posX=((Blue)one).getPositionX();
			posY=((Blue)one).getPositionY();
		
		}else if(one instanceof Green){
			
			posXa=((Green)one).getPositionX();
			posYa=((Green)one).getPositionY();
			
			if(one.getDirection().compareTo("left")==0){
				if(board[posXa+1][posYa+3]!=-1){
					((Green)one).turn();
				}
				else if(board[posXa][posYa]==0 && board[posXa+1][posYa]==0 && board[posXa+2][posYa]==0
						&& board[posXa][posYa+1]==0 && board[posXa+1][posYa+1]==0){
					((Green)one).turn();
				}
			}else if(one.getDirection().compareTo("right")==0){
				if(board[posXa+1][posYa-1]!=-1){
					((Green)one).turn();
				}
				else if(board[posXa+1][posYa+1]==0 && board[posXa+1][posYa+2]==0 && board[posXa+2][posYa+1]==0
						&& board[posXa+2][posYa+2]==0 && board[posXa][posYa+2]==0){
					((Green)one).turn();
				}
			}else if(one.getDirection().compareTo("up")==0){
				if(board[posXa+3][posYa+1]!=-2){
					((Green)one).turn();
				}
				else if(board[posXa][posYa]==0 && board[posXa][posYa+1]==0 && board[posXa][posYa+2]==0
						&& board[posXa+1][posYa+1]==0 && board[posXa+1][posYa+2]==0){
					((Green)one).turn();
				}
			} else if(board[posXa+1][posYa]==0 && board[posXa+1][posYa+1]==0 && board[posXa+2][posYa]==0
					&& board[posXa+2][posYa+1]==0 && board[posXa+2][posYa+2]==0){
				((Green)one).turn();
			} else{
				((Green)one).turn();
			}
			
			tab=((Green)one).getGreen();
			
			posX=((Green)one).getPositionX();
			posY=((Green)one).getPositionY();
			
		}
		
		
		for(int i=posX,ii=0;i<posX+4;i++,ii++){
			for(int j=posY,jj=0;j<posY+4;j++,jj++){
				if(tab[ii][jj]==Figures.nb) board[i][j]=tab[ii][jj];
			}
		}
		
	}
	
	public void left(){
		
		int tab[][]=null;
		int posXa,posYa;
		int posX=0,posY=0;
		
		if(one instanceof Blue){
		
			tab=((Blue)one).getBlue();
			posXa=((Blue)one).getPositionX();
			posYa=((Blue)one).getPositionY();
			
			if(one.getDirection().compareTo("left")==0 ){
				if(board[posXa+1][posYa-1]==0 && board[posXa][posYa]==0 && board[posXa+2][posYa]==0){
					((Blue)one).moveLeft();
				}
			}else if(one.getDirection().compareTo("up")==0){
				if(board[posXa+1][posYa-1]==0 && board[posXa][posYa]==0){
					((Blue)one).moveLeft();
				}
			}else if(one.getDirection().compareTo("down")==0){
				if(board[posXa+1][posYa-1]==0 && board[posXa+2][posYa]==0){
					((Blue)one).moveLeft();
				}
			}else{
				if(board[posXa][posYa]==0 && board[posXa+1][posYa]==0 && board[posXa+2][posYa]==0){
					((Blue)one).moveLeft();
				}
			}
			posX=((Blue)one).getPositionX();
			posY=((Blue)one).getPositionY();
		
		}else if(one instanceof Green){
			
			tab=((Green)one).getGreen();
			posXa=((Green)one).getPositionX();
			posYa=((Green)one).getPositionY();
			
			if(one.getDirection().compareTo("left")==0 ){
				if(board[posXa][posYa+1]==0 && board[posXa+1][posYa+1]==0 && board[posXa+2][posYa]==0){
					((Green)one).moveLeft();
				}
			}else if(one.getDirection().compareTo("up")==0){
				if(board[posXa+1][posYa-1]==0 && board[posXa+2][posYa-1]==0){
					((Green)one).moveLeft();
				}
			}else if(one.getDirection().compareTo("down")==0){
				if(board[posXa][posYa-1]==0 && board[posXa+1][posYa+1]==0){
					((Green)one).moveLeft();
				}
			}else{
				if(board[posXa][posYa-1]==0 && board[posXa+1][posYa-1]==0 && board[posXa+2][posYa-1]==0){
					((Green)one).moveLeft();
				}
			}
			posX=((Green)one).getPositionX();
			posY=((Green)one).getPositionY();
			
		}
		
		for(int i=posX,ii=0;i<posX+4;i++,ii++){
			for(int j=posY,jj=0;j<posY+4;j++,jj++){
				if(tab[ii][jj]==Figures.nb) board[i][j]=tab[ii][jj];
			}
		}
	}
	
	public void right(){
		
		int tab[][]=null;
		int posXa,posYa;
		int posX=0,posY=0;
		
		if(one instanceof Blue){
		
			tab=((Blue)one).getBlue();
			
			posXa=((Blue)one).getPositionX();
			posYa=((Blue)one).getPositionY();
			
			if(one.getDirection().compareTo("left")==0 ){
				if(board[posXa][posYa+2]==0 && board[posXa+1][posYa+2]==0 && board[posXa+2][posYa+2]==0){
					((Blue)one).moveRight();
				}
			}else if(one.getDirection().compareTo("up")==0){
				if(board[posXa][posYa+2]==0 && board[posXa+1][posYa+3]==0){
					((Blue)one).moveRight();
				}
			}else if(one.getDirection().compareTo("down")==0){
				if(board[posXa+1][posYa+3]==0 && board[posXa+2][posYa+2]==0){
					((Blue)one).moveRight();
				}
			}else{
				if(board[posXa][posYa+2]==0 && board[posXa+1][posYa+3]==0 && board[posXa+2][posYa+2]==0){
					((Blue)one).moveRight();
				}
			}
			
			posX=((Blue)one).getPositionX();
			posY=((Blue)one).getPositionY();
		
		}else if(one instanceof Green){
			
			tab=((Green)one).getGreen();
			
			posXa=((Green)one).getPositionX();
			posYa=((Green)one).getPositionY();
			
			if(one.getDirection().compareTo("left")==0 ){
				if(board[posXa][posYa+3]==0 && board[posXa+1][posYa+3]==0 && board[posXa+2][posYa+3]==0){
					((Green)one).moveRight();
				}
			}else if(one.getDirection().compareTo("up")==0){
				if(board[posXa+1][posYa+1]==0 && board[posXa+2][posYa+3]==0){
					((Green)one).moveRight();
				}
			}else if(one.getDirection().compareTo("down")==0){
				if(board[posXa+0][posYa+3]==0 && board[posXa+1][posYa+3]==0){
					((Green)one).moveRight();
				}
			}else{
				if(board[posXa][posYa+2]==0 && board[posXa+1][posYa+1]==0 && board[posXa+2][posYa+1]==0){
					((Green)one).moveRight();
				}
			}
			
			posX=((Green)one).getPositionX();
			posY=((Green)one).getPositionY();
			
		}
		
		for(int i=posX,ii=0;i<posX+4;i++,ii++){
			for(int j=posY,jj=0;j<posY+4;j++,jj++){
				if(tab[ii][jj]==Figures.nb) board[i][j]=tab[ii][jj];
			}
		}
	}


	public void line(){
		int value=0;
		for(int i=1;i<19;i++){
			for(int j=1;j<9;j++){
				if(board[i][j]!=0){
					value++;
				
				}
			}
			if(value==8){
				
				for(int l=i;l>0;l--){
					for(int k=0;k<10;k++){
						board[l][k]=board[l-1][k];
					}
				}
				for(int m=1;m<9;m++){
					board[0][m]=0;
				}
				score+=10;
				
			}
			value=0;
		}
	}
	
	public boolean gameOver(){
		boolean value=true;
		for(int i=0;i<3;i++){
			for(int j=3;j<6;j++){
				if(board[i][j]!=0 && board[i][j]!=Figures.nb){   
					
					value=false;
					System.out.println("se acabo el juego");
				}
				
				
			}
		}
		//if(board[3][4]==0 && board[3][4]==Figures.nb) value=false;
		
		return value;
		
	}
	
	public void paint(Graphics g,int x,int y,int i,int j){
		if(board[i][j]==0){
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(x, y, 30, 30);
			g.setColor(Color.BLACK);
			g.drawRect(x, y, 30, 30);
		}else if(board[i][j]==-1 ){
			g.setColor(Color.GRAY);
			g.fillRect(x, y, 30, 30);
			g.setColor(Color.BLACK);
			g.drawRect(x, y, 30, 30);
		}else if(board[i][j]==-2){
			g.setColor(Color.GRAY);
			g.fillRect(x, y, 30, 30);
			g.setColor(Color.BLACK);
			g.drawRect(x, y, 30, 30);
		}else if(board[i][j]==Figures.nb){
			if(one instanceof Blue){
				((Blue)one).paint(g,x,y);
			}else if(one instanceof Green){
				((Green)one).paint(g,x,y);
			}
		}else{
			/*
				if(colors.get(board[i][j]).compareTo("blue")==0){
					g.setColor(Color.BLUE);
					g.fillRect(x, y, 30, 30);
					g.setColor(Color.BLACK);
					g.drawRect(x, y, 30, 30);
				}else if(colors.get(board[i][j]).compareTo("green")==0){
					g.setColor(Color.GREEN);
					g.fillRect(x, y, 30, 30);
					g.setColor(Color.BLACK);
					g.drawRect(x, y, 30, 30);
				}	
				*/
		}
			
		
	}

	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}

}
