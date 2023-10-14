/**
 * @author      Tenzin Norbu Tenzin.Norbu@city.ac.uk
 * @version     1.2
 * @since       2023
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Timer;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Level1 extends GameLevel{
    private SoundClip music;

    Chomp chomp;

    Pipe pipe;

    public Level1(Game game){
        super(game);

        Shape platformShape4 = new BoxShape(3, 0.5f);
        StaticBody platform4 = new StaticBody(this, platformShape4);
        platform4.setPosition(new Vec2(0, -8));
        platform4.addImage(new BodyImage("data/Platform.png",2.5f));

        Shape platformShape7 = new BoxShape(3, 0.5f);
        StaticBody platform7 = new StaticBody(this, platformShape7);
        platform7.setPosition(new Vec2(0, 8));
        platform7.addImage(new BodyImage("data/Platform.png",2.5f));

        Shape platformShape5 = new BoxShape(3, 0.5f);
        StaticBody platform5 = new StaticBody(this, platformShape5);
        platform5.setPosition(new Vec2(-15, 0));
        platform5.addImage(new BodyImage("data/Platform.png",2.5f));

        Shape platformShape6 = new BoxShape(3, 0.5f);
        StaticBody platform6 = new StaticBody(this, platformShape6);
        platform6.setPosition(new Vec2(15, 0));
        platform6.addImage(new BodyImage("data/Platform.png",2.5f));

        pipe = new Pipe(this);
        pipe.setPosition(new Vec2(0,9.5f));

        coin = new Coin(this);
        coin.setPosition(new Vec2(-15,1.5f));

        coin = new Coin(this);
        coin.setPosition(new Vec2(15,1.5f));

        coin = new Coin(this);
        coin.setPosition(new Vec2(25,-16.4f));

        coin = new Coin(this);
        coin.setPosition(new Vec2(-22,-16.4f));

        coin = new Coin(this);
        coin.setPosition(new Vec2(0,-6.4f));






        koopa = new Koopa(this);
        koopa.setPosition(new Vec2(16,-18));

        goomba = new Goomba(this);
        goomba.setPosition(new Vec2(-16,-18));
        Shape shape = new BoxShape(7, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(-12.2f, -18.2f));
        ground.addImage(new BodyImage("data/Ground.png", 1));

        Shape shape2 = new BoxShape(7, 0.5f);
        StaticBody ground2 = new StaticBody(this, shape2);
        ground2.setPosition(new Vec2(12.2f, -18.2f));
        ground2.addImage(new BodyImage("data/Ground.png", 1));

        Shape shape3 = new BoxShape(4, 0.5f);
        StaticBody ground3 = new StaticBody(this, shape3);
        ground3.setPosition(new Vec2(0, -18.2f));
        ground3.addImage(new BodyImage("data/Ground.png", 1));

        Shape shape4 = new BoxShape(10, 0.5f);
        StaticBody ground4 = new StaticBody(this, shape4);
        ground4.setPosition(new Vec2(23, -18.2f));
        ground4.addImage(new BodyImage("data/Ground.png", 1));

        Shape shape5 = new BoxShape(10, 0.5f);
        StaticBody ground5 = new StaticBody(this, shape5);
        ground5.setPosition(new Vec2(-23, -18.2f));
        ground5.addImage(new BodyImage("data/Ground.png", 1));



    }

    @Override
    public boolean isComplete() {
        return getMario().getCoins() >= 5;
    }
}
