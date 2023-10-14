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

public class PipeEncounter implements CollisionListener {

    SoundClip PipeSound;
    GameLevel level;

    SoundClip failed;
    Game g;

    public PipeEncounter(GameLevel level, Game game) {
        this.level = level;
        g = game;
    }


    @Override
    public void collide(CollisionEvent e) {
          if (e.getOtherBody() instanceof Pipe && level.isComplete() == false) {
            try {
                failed = new SoundClip("data/Music/Failed.wav");
                failed.setVolume(2);
                failed.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException g) {
                g.printStackTrace();
            }}
       else  if (e.getOtherBody() instanceof Pipe && level.isComplete() == true) {
            try {
                PipeSound = new SoundClip("data/Music/PipeSound.wav");
                PipeSound.play();

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException g) {
                g.printStackTrace();
            }
                if (level.isComplete()) {
                    g.goToNextLevel();

            }


                }
            }
        }



