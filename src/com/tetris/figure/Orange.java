package com.tetris.figure;
public class Orange extends Figures{
	
	private static int nb=6;
	private int orange[][];
	
	public Orange(){
		super();
		orange= new int [4][4];	
		orange[1][0]=1;
		orange[2][0]=1;
		orange[1][1]=1;
		orange[2][1]=1;
	}
}
