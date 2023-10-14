/**
 * @author      Tenzin Norbu Tenzin.Norbu@city.ac.uk
 * @version     1.2
 * @since       2023
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class LavaDestroy implements CollisionListener {

    private static SoundClip soundeffect;

    public Lava lava;

    public LavaDestroy(Lava l){this.lava =l;}




    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof Barrel) {
            lava.setBarrel(lava.getBarrel() + 1);
            collisionEvent.getOtherBody().destroy();

        }
    }
}
