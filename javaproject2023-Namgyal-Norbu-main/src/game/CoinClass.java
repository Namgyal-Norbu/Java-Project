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
import java.io.IOException;

public abstract class CoinClass extends StaticBody {
    private static final Shape coinshape = new BoxShape(0.1f, 1);
    private static final BodyImage image = new BodyImage("data/Coin.png", 2);




    public CoinClass(World world) {
        super(world, coinshape);
        this.addImage(image);

    }
}

