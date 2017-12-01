package com.tetris.figure;

public class Yellow extends Figures{
	
	private static int nb=5;
	private int yellow[][];
	
	public Yellow(){
		super();
		yellow= new int [4][4];
		yellow[1][0]=1;
		yellow[2][0]=1;
		yellow[1][1]=1;
		yellow[2][1]=1;
	}
	
	
}
