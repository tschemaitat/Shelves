import Main_and_Drawing.Drawable;
import Main_and_Drawing.Image_Twod;
import Main_and_Drawing.Layouts.RectP;
import Main_and_Drawing.Screen;
import Main_and_Drawing.Twod;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Main {
	public static void main(String[] args){
		Screen screen = new Screen(800, 800);
		Drawable drawable = new Drawable(Drawable.mode_rectangleFill);
		drawable.set_color(Color.YELLOW);
		Twod twod = new Image_Twod(drawable, new RectP(10, 10, 100, 100), null);
		
		screen.addTwoD(twod);
	}
}
