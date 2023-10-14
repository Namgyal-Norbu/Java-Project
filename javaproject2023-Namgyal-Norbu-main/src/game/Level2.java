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

public class Level2 extends GameLevel{


    Bowzer bowzer;

    Heart heart;

    public Game game;
    Coin coin;


    Pipe pipe;
    public Level2(Game game) {
        super(game);

        Shape platformShape6 = new BoxShape(3, 0.5f);
        StaticBody platform6 = new StaticBody(this, platformShape6);
        platform6.setPosition(new Vec2(13, 2));
        platform6.addImage(new BodyImage("data/Platform.png",2.5f));

        Shape platformShape7 = new BoxShape(3, 0.5f);
        StaticBody platform7 = new StaticBody(this, platformShape7);
        platform7.setPosition(new Vec2(0, -8));
        platform7.addImage(new BodyImage("data/Platform.png",2.5f));

        Shape platformShape8 = new BoxShape(3, 0.5f);
        StaticBody platform8 = new StaticBody(this, platformShape8);
        platform8.setPosition(new Vec2(-13, 2));
        platform8.addImage(new BodyImage("data/Platform.png",2.5f));

        Shape platformShape9 = new BoxShape(3, 0.5f);
        StaticBody platform9 = new StaticBody(this, platformShape9);
        platform9.setPosition(new Vec2(24, -5));
        platform9.addImage(new BodyImage("data/Platform.png",2.5f));

        Shape platformShape10 = new BoxShape(3, 0.5f);
        StaticBody platform10 = new StaticBody(this, platformShape10);
        platform10.setPosition(new Vec2(-24, -5));
        platform10.addImage(new BodyImage("data/Platform.png",2.5f));

        heart = new Heart(this);
        heart.setPosition(new Vec2(0,-17));

        bowzer = new Bowzer(this);
        bowzer.setPosition(new Vec2(-13,5.2f));


        coin = new Coin(this);
        coin.setPosition(new Vec2(0,-6.5f));

        coin = new Coin(this);
        coin.setPosition(new Vec2(14,-16.5f));

        coin = new Coin(this);
        coin.setPosition(new Vec2(-14,-16.5f));

        coin = new Coin(this);
        coin.setPosition(new Vec2(-24,-3.5f));

        coin = new Coin(this);
        coin.setPosition(new Vec2(24,-3.5f));

        pipe = new Pipe(this);
        pipe.setPosition(new Vec2(13,3.5f));
        Shellpick pickup= new Shellpick(pipe);
        pipe.addCollisionListener(pickup);

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
