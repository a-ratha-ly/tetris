package tetris.frame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;



public class Mycanvas extends Canvas implements KeyListener,ActionListener{
	
	private Timer time;//gameOver; 
	private Board board;
	private static final long serialVersionUID = 1L;
	int x=50;
	int y=50;
	
	
	public Mycanvas(){
		super();
		board = new Board();
		time= new Timer(300,this);
	//	gameOver= new Timer(1000,this);
		board.addfigure();
		
		addKeyListener(this);
		time.start();
	}
	
	public void paint(Graphics g) {
	   
	   if(board.gameOver()){
		   for(int i=0;i<20;i++){
			   for(int j=0;j<10;j++){
				   board.paint(g,x,y,i,j);
				   x+=30;
			   }
			   y+=30;
			   x-=300;
		   } 
	   }else{
		 //  time.stop();
		 //  gameOver.start();
	   	//	for(int i=0;i<50;i++){
			   g.setColor(Color.red);
			   g.setFont(new Font("couture-bld", Font.BOLD,70)); 
			   g.drawString("GAME", 90, 300);
			   g.drawString("OVER",100, 360);
			  
			 //  g.setColor(Color.BLACK);
			 //  g.fillRect(0, 0,400, 700);
	   	//	}
		   
	   }
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		board.remove();
		board.down();
		x=50;
		y=50;
		repaint();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==40){
			board.remove();
			board.down();
			board.line();
			x=50;
			y=50;
			repaint();
		}
		if(e.getKeyCode()==39){
			board.remove();
			board.right();
			board.line();
			x=50;
			y=50;
			repaint();
		}
		if(e.getKeyCode()==37){
			board.remove();
			board.left();
			board.line();
			x=50;
			y=50;
			repaint();
		}
		if(e.getKeyCode()==32){
			board.remove();
			board.turn();
			board.line();
			x=50;
			y=50;
			repaint();
		}
	
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
