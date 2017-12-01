package tetris.frame;
import java.awt.BorderLayout;

import javax.swing.JFrame;



public class Mywindow extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private Mycanvas canvas;
	
	public Mywindow(){
		super();
		setLayout(new BorderLayout());
		canvas= new Mycanvas();
		
		add(canvas,BorderLayout.CENTER);
	}

}
