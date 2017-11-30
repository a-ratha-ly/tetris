import java.awt.Color;
import java.awt.Graphics;


public class Figures {
	
	public static int nb=0;
	protected String color;
	protected int figures;
	protected String direction;

	
	public Figures(){
		nb++;
		figures=0;
		direction="up";
		color="";
	}

	
	public int getFigures() {
		return figures;
	}

	public void setFigures(int figures) {
		this.figures = figures;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	
}
