import Main_and_Drawing.Drawable;
import Main_and_Drawing.Image_Twod;
import Main_and_Drawing.Layouts.KeyEvent_Edited;
import Main_and_Drawing.Layouts.RectP;
import Main_and_Drawing.Screen;
import Main_and_Drawing.Twod;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Game {
    public static final int key_up = 87;
    public static final int key_down = 83;
    public static final int key_left = 65;
    public static final int key_right = 68;
    public static void main(String[] args){

        Screen screen = new Screen(800, 800);
        int xPos = 10;
        int yPos = 10;
        Character genevieve  = new Character("Assets/Visuals/Characters/Genevieve/Genevieve1.0.png", screen);

        MyKeyListener keyListener = new MyKeyListener();
        screen.addKeyListener(keyListener);
        screen.setFocusable(true);
        screen.requestFocus();

        while(true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            screen.update_screen();
            checker(keyListener);



        }

    }

    public static int[] checker(MyKeyListener keyListener){


        float speedDiagonal = 0.72f;
        if (keyListener.isKeyPressed(key_up)) {
            // Move the character up
            yPos += 10;
        }

        if (keyListener.isKeyPressed(key_down)) {
            // Move the character down
            yPos -= 10;
        }

        if (keyListener.isKeyPressed(key_left)) {
            // Move the character left
            xPos -= 10;
        }

        if (keyListener.isKeyPressed(key_right)) {
            // Move the character right
            xPos += 10;
        }
    }
}
