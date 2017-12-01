package com.tetris.main;

import java.awt.Color;

import javax.swing.JFrame;

import com.tetris.frame.Mywindow;

public class Main {

	public static void main(String []args){
		
		Mywindow one = new Mywindow();
		
		one.setSize(400,700);
		one.setVisible(true);
		one.setBackground(Color.BLACK);
		one.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}
	
	
}
