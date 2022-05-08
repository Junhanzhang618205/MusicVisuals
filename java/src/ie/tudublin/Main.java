package ie.tudublin;

import RF.RfVisual;


public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new RfVisual());
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}