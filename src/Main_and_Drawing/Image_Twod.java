package Main_and_Drawing;

import Main_and_Drawing.Layouts.LayoutParameters;

import java.awt.*;

public class Image_Twod extends Twod {
    
    Drawable drawable;
    
    
    public Command onClick;
    public Command onTouch;
    public Command onMouseDown;
    public Command onMouseUp;
    public String name = null;
    
    public Image_Twod(Drawable drawable, LayoutParameters parameters, Layout parent) {
        super(parameters, parent);
        this.drawable = drawable;
    }

    public Drawable get_drawable() {
        return drawable;
    }
    
    public void set_drawable(Drawable drawable){
        this.drawable = drawable;
    }
    
    
    
    
    
    
    
    public void draw(Graphics2D grf){
        System.out.println("drawing: " + this);
        //grf.drawRect(x, y, width, height);
        if(visibility == VISIBLE & drawable != null)
            drawable.draw(grf, this);
    }
    
    public String toString(){
        String result = "";
        result += "name: " + name + " x: " + x + " y: " + y + " layout: ";
        return result;
    }

}
