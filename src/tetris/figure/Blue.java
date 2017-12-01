package tetris.figure;
import java.awt.Color;
import java.awt.Graphics;


public class Blue extends Figures{
	
	
	protected int blue[][];
	protected int positionX;
	protected int positionY;

	public Blue(){
		super();
		blue= new int [4][4];
		blue[0][1]=nb;
		blue[1][2]=nb;
		blue[1][0]=nb;
		blue[1][1]=nb;
		positionX=0;
		positionY=3;
		color="blue";
	}
	//GETTERS AND SETTERS
	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}


	public int[][] getBlue() {
		return blue;
	}

	public void setBlue(int[][] blue) {
		this.blue = blue;
	}
	
	//BEHAVIOUR
	public void moveLeft(){
		positionY--;
	}
	
	public void moveRight(){
		positionY++;
	}
	
	public void down(){
		positionX++;
	}
	
	public void remove(){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(blue[i][j]==nb)  blue[i][j]=0;
			}
		}
	}
	public void turn(){
		
		if(direction.compareTo("up")==0){
			remove();
			posRight();
			direction="right";
		}else if(direction.compareTo("right")==0){
			remove();
			posDown();
			direction="down";
		}else if(direction.compareTo("down")==0){
			remove();
			posLeft();
			direction="left";
		}else  if(direction.compareTo("left")==0){
			remove();
			posUp();
			direction="up";
		}
	}

	
	
	
	public void posUp(){
		blue[0][1]=nb;
		blue[1][0]=nb;
		blue[1][1]=nb;
		blue[1][2]=nb;
	}
	
	public void posLeft(){
		blue[0][1]=nb;
		blue[1][1]=nb;
		blue[2][1]=nb;
		blue[1][0]=nb;
	}
	
	public void posDown(){
		blue[1][1]=nb;
		blue[1][0]=nb;
		blue[2][1]=nb;
		blue[1][2]=nb;
	}
	
	public void posRight(){
		blue[0][1]=nb;
		blue[1][1]=nb;
		blue[2][1]=nb;
		blue[1][2]=nb;
		
	}
	
	public void which(){
		if(direction.compareTo("up")==0){
			posUp();
		}
		if(direction.compareTo("left")==0){
			posLeft();
		}
		if(direction.compareTo("right")==0){
			posRight();
		}
		if(direction.compareTo("down")==0){
			posDown();
		}
	}
	
	public void paint(Graphics g,int x,int y){
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 30, 30);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, 30, 30);
	}
	
}
