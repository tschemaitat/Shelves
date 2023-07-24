package Main_and_Drawing;

import Main_and_Drawing.Layouts.RectP;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Stack_Layout extends Layout {
    
    public Stack_Layout(int x, int y, int width, int height) {
        super(new RectP(x, y, width, height), null);
    }
    
    protected void draw_custom(Graphics2D grf){
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D image_graphics = image.createGraphics();
        if(list.size() == 0)
            return;
        for(int i = 0; i < list.size(); i++){
            Twod obj = list.get(i);
            if(obj.visibility == VISIBLE)
                obj.draw(image_graphics);
            //obj.drawBounds(grf);
        }
        
        grf.drawImage(image, x, y, null);
    }
    
    public Twod observe(MouseEvent_Edited event){
        //System.out.println("stack layout observing ("+x +", "+ y+"): " + event.x() + ", " + event.y());
        MouseEvent_Edited layout_event = new MouseEvent_Edited(event.x() + x * -1, event.y() + y * -1, event.type);
        //System.out.println("new event: " + layout_event.x() + ", " + layout_event.y());
        if(list.size() == 0)
            return null;
        for(int i = list.size() - 1; i >= 0; i--){
            Twod obj = list.get(i);
            Twod observed = obj.observe(layout_event);
            if(observed != null){
                //System.out.println("child observed event, returning true");
                return observed;
            }
            
        }
        return null;
    }

    protected void add_custom(Twod twod){
    
    }
    
    protected void remove_custom(Twod twod) {
    
    }
    
    protected void to_top(Twod obj){
    
    }
    
    
    @Override
    public void onMouseEvent(MouseEvent_Edited event) {
    
    }
    
    
}
