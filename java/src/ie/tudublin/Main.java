package ie.tudublin;

import Jz.JzVisual;


public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new JzVisual());
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}