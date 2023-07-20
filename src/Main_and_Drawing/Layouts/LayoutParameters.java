package Main_and_Drawing.Layouts;

import Main_and_Drawing.Layout;
import Main_and_Drawing.Twod;

import java.awt.*;

public interface LayoutParameters {
	public int getWidth();
	
	public int getHeight();
	
	public LayoutParameters copy();
	
	public int getX();
	public int getY();
	
	public void setWidth(int width);
	public void setHeight(int height);
	public void setX(int x);
	public void setY(int y);
	
}
