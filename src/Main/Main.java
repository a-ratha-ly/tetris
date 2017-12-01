package Main;

import tetris.frame.*;
import java.awt.Color;

import javax.swing.JFrame;

public class Main {

	public static void main(String []args){
		
		Mywindow one = new Mywindow();
		
		one.setSize(400,700);
		one.setVisible(true);
		one.setBackground(Color.BLACK);
		one.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			
		
	}
	
	
}
