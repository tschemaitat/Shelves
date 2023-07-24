import Main_and_Drawing.Drawable;
import Main_and_Drawing.Image_Twod;
import Main_and_Drawing.Layouts.RectP;
import Main_and_Drawing.Screen;
import Main_and_Drawing.Twod;

public class Character {
    private int x; // Character's current x-coordinate
    //HEY
    private int y; // Character's current y-coordinate
    private Twod twod;
    // Constructor to set the initial position of the character

    public  Character(String path , Screen screen, int initialX, int initialY){
        this.x = initialX;
        this.y = initialY;
        Drawable drawable = new Drawable("Assets/Visuals/Characters/Genevieve/Genevieve1.0.png");
        twod = new Image_Twod(drawable, new RectP(x, y, 100, 100), null);
        screen.addTwoD(twod);

    }

    // Move the character based on velocity components vx and vy
    public void move(double vx, double vy) {
        // Update the character's position based on the velocity components
        x += (int) vx;
        y += (int) vy;
        twod.setX(x);
        twod.setY(y);
        System.out.println("MOVING");

        // Add any necessary bounds checking to ensure the character stays within the room or game area.
    }

    // Getters for x and y coordinates (you can add setters if needed)
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
