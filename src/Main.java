import Main_and_Drawing.*;
import Main_and_Drawing.Layouts.RectP;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Main {
	public static void main(String[] args){
		Screen screen = new Screen(800, 800);
		Drawable drawable = new Drawable(Drawable.mode_rectangleFill);
		drawable.set_color(Color.YELLOW);
		Twod twod = new Image_Twod(drawable, new RectP(10, 10, 100, 100), null);
		twod.setMouseEventListener(new MouseFunction() {
			@Override
			public void onMouseEvent(MouseEvent_Edited event) {
				System.out.println("got clicked");
				if(event.type == MouseEvent_Edited.type_click)
					System.out.println("clicked");
			}
		});
		
		
		Stack_Layout stack_layout = new Stack_Layout(100, 100, 200, 200);
		stack_layout.add(twod);
		screen.addTwoD(stack_layout);
	}
}
