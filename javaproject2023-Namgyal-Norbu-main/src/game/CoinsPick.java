package game;
/**
 * @author      Tenzin Norbu Tenzin.Norbu@city.ac.uk
 * @version     1.2
 * @since       2023
 */
import city.cs.engine.CollisionEvent;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class CoinsPick extends Picking {

    SoundClip CoinEffect;

    public Game g;

    public Mario mario;

    public CoinsPick(Mario m) {
        this.mario = m;
    }


    @Override
    public void collide(CollisionEvent e) {

        if (e.getOtherBody() instanceof Coin) {
            mario.setCoins(mario.getCoins() + 1);
            e.getOtherBody().destroy();
            try {
              CoinEffect= new SoundClip("data/Music/CoinCollect.wav");
                CoinEffect.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException g) {
                g.printStackTrace();
            }

        }
    }
}


