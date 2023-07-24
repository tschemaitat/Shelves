package Main_and_Drawing.Layouts;

import Main_and_Drawing.Layout;
import Main_and_Drawing.Twod;

import java.awt.*;

public interface LayoutParameters {
	public int getWidth(Twod twod, Layout layout);
	
	public int getHeight(Twod twod, Layout layout);
	
	public LayoutParameters copy();
	
	public int getX(Twod twod, Layout layout);
	public int getY(Twod twod, Layout layout);
	
	public void setWidth(int width);
	public void setHeight(int height);
	
	//region Simple get and sets
	
	public void setX(int x);
	public void setY(int y);
	
}
