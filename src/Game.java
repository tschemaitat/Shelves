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
        Character genevieve  = new Character("Assets/Visuals/Characters/Genevieve/Genevieve1.0.png", screen, xPos,yPos);

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
            updateCharacter(keyListener, genevieve);
            screen.update_screen();
        }

    }
    private static final double SPEED = 18.0;

    public static void updateCharacter(MyKeyListener keyListener, Character character){
        double vx = 0.0;
        double vy = 0.0;

        float speedDiagonal = 0.72f;
        if (keyListener.isKeyPressed(key_up)) {
            // Move the character up
            vy -= SPEED;
        }

        if (keyListener.isKeyPressed(key_down)) {
            // Move the character down
            vy += SPEED;
        }

        if (keyListener.isKeyPressed(key_left)) {
            // Move the character left
            vx -= SPEED;
        }

        if (keyListener.isKeyPressed(key_right)) {
            // Move the character right
            vx += SPEED;
        }

        if (vx != 0.0 && vy != 0.0) {
            double magnitude = Math.sqrt(vx * vx + vy * vy);
            vx /= magnitude;
            vy /= magnitude;
            vx *= SPEED;
            vy *= SPEED;
        }
        character.move(vx, vy);
    }
}
