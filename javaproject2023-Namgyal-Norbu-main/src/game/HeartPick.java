/**
 * @author      Tenzin Norbu Tenzin.Norbu@city.ac.uk
 * @version     1.2
 * @since       2023
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.CollisionEvent;

import java.awt.*;
import java.awt.image.ImageObserver;

public class HeartPick extends Picking implements ImageObserver {

    public HeartPick(Mario m) {
        this.mario = m;
    }


    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Heart) {
            mario.setHeart(mario.getHeart() + 1);
            e.getOtherBody().destroy();
        }

        }

    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
        return false;
    }
}

