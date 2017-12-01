package com.tetris.figure;
public class Red extends Figures{
	
	private static int nb=3;
	private int red[][];
	
	public Red(){
		super();
		red = new int [4][4];
		red[1][0] = 1;
		red[2][0] = 1;
		red[1][1] = 1;
		red[2][1] = 1;
	}
}
