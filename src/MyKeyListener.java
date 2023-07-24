import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class MyKeyListener implements KeyListener {

    private final Set<Integer> pressedKeys = new HashSet<>();
//    Deque<Character> keyEvents = new ArrayDeque<>();
//    keyEvents.push(e.getKeyChar());
//        System.out.println(e.getKeyChar());
//        System.out.println("STACK OF KEYEVENTS: " + keyEvents);
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressedKeys.add(e.getKeyCode());
        System.out.println(e.getKeyCode());

    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
    }

    public synchronized boolean isKeyPressed(int keyCode) {
        return pressedKeys.contains(keyCode);
    }

}
