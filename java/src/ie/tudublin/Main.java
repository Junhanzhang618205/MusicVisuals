package ie.tudublin;

import Kty.KtyVisual;


public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new KtyVisual());
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}