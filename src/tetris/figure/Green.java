package tetris.figure;
import java.awt.Color;
import java.awt.Graphics;


public class Green extends Figures{
	
	private int green[][];
	protected int positionX;
	protected int positionY;
	
	public Green(){
		super();
		green= new int [4][4];
		green[1][0]=nb;
		green[2][0]=nb;
		green[2][2]=nb;
		green[2][1]=nb;
		positionX=0;
		positionY=3;
		color="green";
	}
	
	//GETTERS AND SETTERS
		public int getPositionX() {
			return positionX;
		}

		public int[][] getGreen() {
			return green;
		}

		public void setGreen(int[][] green) {
			this.green = green;
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
					if(green[i][j]==nb)  green[i][j]=0;
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
			green[1][0]=nb;
			green[2][0]=nb;
			green[2][2]=nb;
			green[2][1]=nb;
		}
		
		public void posLeft(){
			green[0][2]=nb;
			green[1][2]=nb;
			green[2][2]=nb;
			green[2][1]=nb;
		}
		
		public void posDown(){
			green[0][0]=nb;
			green[0][1]=nb;
			green[0][2]=nb;
			green[1][2]=nb;
		}
		
		public void posRight(){
			green[0][0]=nb;
			green[1][0]=nb;
			green[2][0]=nb;
			green[0][1]=nb;
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
			g.setColor(Color.GREEN);
			g.fillRect(x, y, 30, 30);
			g.setColor(Color.BLACK);
			g.drawRect(x, y, 30, 30);
		}
}
