package Main_and_Drawing;

import java.awt.event.MouseEvent;

public class MouseEvent_Edited {
	public final static int type_click = 1000;
	public final static int type_pressed = 1001;
	public final static int type_released = 1002;
	public final static int type_touch = 1003;
	public final static int type_untouch = 1004;
	
	int x;
	int y;
	private MouseEvent event;
	public int type;
	public MouseEvent_Edited(MouseEvent e, int type){
		event = e;
		this.type = type;
	}
	
	public String type_string(){
		if(type == type_click)
			return "type_click";
		if(type == type_pressed)
			return "type_pressed";
		if(type == type_released)
			return "type_released";
		if(type == type_touch)
			return "type_touch";
		if(type == type_untouch)
			return "type_untouch";
		return null;
	}
	
	public int type(){
		return type;
	}
	
	
	public MouseEvent_Edited(int x, int y, int type){
		this.x = x;
		this.y = y;
		this.type = type;
	}
	
	public int x(){
		if(event == null)
			return x;
		return event.getX();
	}
	
	public int y(){
		if(event == null)
			return y;
		return event.getY();
	}
	
	public int getXOnScreen(){
		return event.getXOnScreen();
	}
	public int getYOnScreen(){
		return event.getYOnScreen();
	}
	
	public MouseEvent_Edited set_layout(Layout layout){
		MouseEvent_Edited result = new MouseEvent_Edited(x(), y(), type);
		return result;
	}
	
	
	
	
}
