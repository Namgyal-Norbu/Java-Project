/**
 * @author      Tenzin Norbu Tenzin.Norbu@city.ac.uk
 * @version     1.2
 * @since       2023
 */

package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import java.io.IOException;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class GeneralCollisionListener implements CollisionListener {

    private static SoundClip soundeffect;
    private SoundClip heartsound;
    GameLevel level;
    Game g;

    public GeneralCollisionListener(GameLevel level, Game game) {
        this.level = level;
        g = game;
    }
    /**here we ensure that we do not repeat the same try code on every variable instead
     * creating a static method and catching exceptions and initializing wav files.
     *
     */
    static {
        try {
            soundeffect = new SoundClip("data/Music/Damage.wav");
            soundeffect.setVolume(2);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
        }
    }

    /**The collision method plays sounds determined by the variables colliding
     * @param collisionEvent used to determine wether to get the reporting body or the other body
     * and what to do to the entities after colliding
     */
    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof Goomba) {
            ((Mario) collisionEvent.getReportingBody()).damage();
            soundeffect.play();

        } else if (collisionEvent.getOtherBody() instanceof Koopa) {
            ((Mario) collisionEvent.getReportingBody()).damage();
            soundeffect.play();

        } else if (collisionEvent.getOtherBody() instanceof Heart) {
            ((Mario) collisionEvent.getReportingBody()).Heartplus();
            try {
                heartsound = new SoundClip("data/Music/PowerUp.wav");
                heartsound.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            }
        } else if (collisionEvent.getOtherBody() instanceof Barrel) {
            ((Mario) collisionEvent.getReportingBody()).damage();
            collisionEvent.getOtherBody().destroy();
            soundeffect.play();
        } else if (collisionEvent.getOtherBody() instanceof Lava) {
            ((Mario) collisionEvent.getReportingBody()).gameover();
            soundeffect.play();
        } else if (collisionEvent.getOtherBody() instanceof Chomp) {
            ((Mario) collisionEvent.getReportingBody()).damage();
            soundeffect.play();
        } else if (collisionEvent.getOtherBody() instanceof Shell) {
            ((Mario) collisionEvent.getReportingBody()).damage();
            collisionEvent.getOtherBody().destroy();
            soundeffect.play();

        }

    }
}

