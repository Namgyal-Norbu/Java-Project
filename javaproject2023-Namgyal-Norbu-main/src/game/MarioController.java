/**
 * @author      Tenzin Norbu Tenzin.Norbu@city.ac.uk
 * @version     1.2
 * @since       2023
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class MarioController implements KeyListener {


    private static final float WALKING_SPEED = 6;
    private static final float Running_Speed = 12;
    private Mario mario;



    public MarioController(Mario m) {
        mario = m;
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // other key commands omitted

        if (code == KeyEvent.VK_A) {
            mario.removeAllImages();
            mario.addImage(new BodyImage("data/MarioLeft.png", 5));
            mario.startWalking(-WALKING_SPEED);

        }
        if (code == KeyEvent.VK_D) {
            mario.removeAllImages();
            mario.addImage(new BodyImage("data/MarioRight.png",4.8f));
            mario.startWalking(WALKING_SPEED);
        }else if(code == KeyEvent.VK_C) {
            mario.removeAllImages();
            mario.addImage(new BodyImage("data/MarioRight.png",4.8f));
            mario.startWalking(Running_Speed);

        }else if(code == KeyEvent.VK_SHIFT) {
            mario.removeAllImages();
            mario.addImage(new BodyImage("data/MarioLeft.png", 5));
            mario.startWalking(-Running_Speed);
        } else if (code == KeyEvent.VK_W)
                mario.jump(15);

    }


    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_A) {
            mario.stopWalking();
        } if (code == KeyEvent.VK_SHIFT) {
            mario.stopWalking();
        } if (code == KeyEvent.VK_C) {
            mario.stopWalking();
        }
        else if (code == KeyEvent.VK_D) {
            mario.stopWalking();
        }
    }
    public void updateMario(Mario newMario){
        mario = newMario;
    }

    }



