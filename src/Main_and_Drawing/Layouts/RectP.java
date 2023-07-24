package Main_and_Drawing.Layouts;

import Main_and_Drawing.Layout;
import Main_and_Drawing.Twod;

import java.awt.*;

public class RectP implements LayoutParameters{
	
	int x;
	int y;
	int width;
	int height;
	
	public RectP(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public int getWidth(Twod twod, Layout layout) {
		return width;
	}
	
	@Override
	public int getHeight(Twod twod, Layout layout) {
		return height;
		//hello
	}
	
	@Override
	public RectP copy(){
		return new RectP(x, y, width, height);
	}
	
	public Rectangle getRectangle(){
		return new Rectangle(x, y, width, height);
	}
	
	public void setAll(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	
	//region Simple get and sets
	@Override
	public int getX(Twod twod, Layout layout) {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	@Override
	public int getY(Twod twod, Layout layout) {
		return y;
	}
	
	@Override
	public void setWidth(int width) {
	
	}
	
	@Override
	public void setHeight(int height) {
	
	}
	
	public void setY(int y) {
		this.y = y;
	}
	//endregion
}
