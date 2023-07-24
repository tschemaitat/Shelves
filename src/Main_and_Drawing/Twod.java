package Main_and_Drawing;

import Main_and_Drawing.Layouts.LayoutParameters;
import Main_and_Drawing.Layouts.RectP;

import java.awt.*;

public abstract class Twod {
	protected int visibility = 1;
	protected int UIvisibility = 1;
	public String name = "";
	
	public static final int VISIBLE = 1;
	public static final int INVISIBLE = 0;
	
	//region dimension gets and sets
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	
	public void setX(int x) {
		RectP rect = (RectP)layoutParameters;
		rect.setX(x);
		update(parent);
	}
	public void setY(int y) {
		RectP rect = (RectP)layoutParameters;
		rect.setY(y);
		update(parent);
	}
	public void setHeight(int height) {
		layoutParameters.setHeight(height);
		update(parent);
	}
	public void setWidth(int width) {
		layoutParameters.setWidth(width);
		update(parent);
	}
	//endregion
	
	int x;
	int y;
	int height;
	int width;
	
	boolean mouse_touching = false;
	
	
	
	LayoutParameters layoutParameters;
	public Polygon bounds;
	
	private Layout parent;
	
	
	public Twod(LayoutParameters parameters, Layout parent){
		if(parent != null){
			this.parent = parent;
			parent.add(this);
		}
		layoutParameters = parameters;
	}
	
	
	
	
	//public List<Twod> getChildren();
	
	public Layout getParent() {
		return parent;
	}
	
	public void setParent(Layout parent){
		this.parent = parent;
		if(parent != null)
			update(parent);
	}
	
	public void setVisibility(int num){
		visibility = num;
	}
	public void setVisible(){
		visibility = VISIBLE;
	}
	public void setInvisible(){
		visibility = INVISIBLE;
	}
	
	public void setUIVisibility(int num) {
		UIvisibility = num;
	}
	public void setUIVisible(){
		UIvisibility = VISIBLE;
	}
	public void setUIInvisible(){
		UIvisibility = INVISIBLE;
	}
	
	
	
	public boolean inBounds(int x, int y){
		return bounds.contains(x, y);
	}
	
	public Twod observe(MouseEvent_Edited event){
		
		//System.out.println("observing for twod: " + name);
		//System.out.println("event is: "+event.x()+","+event.y()+" twod is at: " + getX() + ", " + getY() + " width/height: " + width+", " + height);
		if(UIvisibility == 0)
			return null;
		int x = event.x();
		int y = event.y();
		if(inBounds(event.x(), event.y())){
			//System.out.println("it is in bounds");
			//System.out.println("got clicked");
			//System.out.println("twod: in bounds");
			return this;
		}
		return null;
	}
	
	public abstract void draw(Graphics2D grf);
	
	public void update(Layout parent){
		x = layoutParameters.getX(this, parent);
		y = layoutParameters.getY(this, parent);
		width = layoutParameters.getWidth(this, parent);
		height = layoutParameters.getHeight(this, parent);
		setBounds();
	}
	
	private void setBounds(){
		bounds = new Polygon();
		bounds.addPoint(x, y);
		bounds.addPoint(x+width, y);
		bounds.addPoint(x+width, y+height);
		bounds.addPoint(x, y+height);
	}
	
	public void drawBounds(Graphics graphics){
		Rectangle rect = bounds.getBounds();
		graphics.drawRect(x, y, width, height);
	}
	
	public LayoutParameters getLayoutParameters() {
		return layoutParameters;
	}
	
	public void setLayoutParameters(LayoutParameters layoutParameters) {
		this.layoutParameters = layoutParameters;
	}
	
	public void onMouseEvent(MouseEvent_Edited event){
		//System.out.println("reached two onmouseevnet");
		if(mouseFunction != null)
			mouseFunction.onMouseEvent(event);
	}
	
	MouseFunction mouseFunction = null;
	public void setMouseEventListener(MouseFunction mouseFunction){
		this.mouseFunction = mouseFunction;
	}
}
