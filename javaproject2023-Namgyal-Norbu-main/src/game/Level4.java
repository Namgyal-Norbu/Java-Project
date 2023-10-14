/**
 * @author      Tenzin Norbu Tenzin.Norbu@city.ac.uk
 * @version     1.2
 * @since       2023
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.swing.*;

public class Level4 extends GameLevel{



    Lava lava;

    Chomp chomp;


    public Level4(Game game) {
        super(game);


        GeneralCollisionListener gcl = new GeneralCollisionListener(this, game);
        mario.addCollisionListener(gcl);
        mario.setPosition(new Vec2(0,-11));

        Shape shape = new BoxShape(5, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0, -12));
        ground.addImage(new BodyImage("data/Ground.png", 0.8f));

        Shape shape2 = new BoxShape(5, 0.5f);
        StaticBody ground2 = new StaticBody(this, shape2);
        ground2.setPosition(new Vec2(12, -2));
        ground2.addImage(new BodyImage("data/Ground.png", 0.8f));

        Shape shape3 = new BoxShape(5, 0.5f);
        StaticBody ground3 = new StaticBody(this, shape3);
        ground3.setPosition(new Vec2(-12, -2));
        ground3.addImage(new BodyImage("data/Ground.png", 0.8f));

        Shape shape4 = new BoxShape(5, 0.5f);
        StaticBody ground4 = new StaticBody(this, shape4);
        ground4.setPosition(new Vec2(0, 10));
        ground4.addImage(new BodyImage("data/Ground.png", 0.8f));

        Shape shape5 = new BoxShape(2.5f, 0.5f);
        StaticBody ground5 = new StaticBody(this, shape5);
        ground5.setPosition(new Vec2(-26.5f, -14));
        ground5.addImage(new BodyImage("data/Platform.png", 1.5f));

        Shape shape6 = new BoxShape(2.5f, 0.5f);
        StaticBody ground6 = new StaticBody(this, shape6);
        ground6.setPosition(new Vec2(26.5f, -14));
        ground6.addImage(new BodyImage("data/Platform.png", 1.5f));

        Shape shape7 = new BoxShape(2.5f, 0.5f);
        StaticBody ground7 = new StaticBody(this, shape7);
        ground7.setPosition(new Vec2(26.5f, 12));
        ground7.addImage(new BodyImage("data/Platform.png", 1.5f));

        Shape shape8 = new BoxShape(2.5f, 0.5f);
        StaticBody ground8 = new StaticBody(this, shape8);
        ground8.setPosition(new Vec2(-26.5f, 12));
        ground8.addImage(new BodyImage("data/Platform.png", 1.5f));

        coin = new Coin(this);
        coin.setPosition(new Vec2(26.5f,13.5f));

        coin = new Coin(this);
        coin.setPosition(new Vec2(-26.5f,13.5f));

        coin = new Coin(this);
        coin.setPosition(new Vec2(26.5f,-12.5f));

        coin = new Coin(this);
        coin.setPosition(new Vec2(-26.5f,-12.5f));

        coin = new Coin(this);
        coin.setPosition(new Vec2(-12,-0.5f));

        coin = new Coin(this);
        coin.setPosition(new Vec2(12,-0.5f));


        lava = new Lava (this);
        lava.setPosition(new Vec2(-14.5f,-21.f));
        LavaDestroy pickup = new LavaDestroy(lava);
        lava.addCollisionListener(pickup);

        lava = new Lava (this);
        lava.setPosition(new Vec2(12.5f,-21.f));
        LavaDestroy pickup2 = new LavaDestroy(lava);
        lava.addCollisionListener(pickup2);

        chomp = new Chomp(this);
        chomp.setPosition(new Vec2(15,-1));
        ChompDestroy pickup7 = new ChompDestroy(lava);
        lava.addCollisionListener(pickup7);

        chomp = new Chomp(this);
        chomp.setPosition(new Vec2(-15,-1));
        ChompDestroy pickup8 = new ChompDestroy(lava);
        lava.addCollisionListener(pickup8);


        Timer timer = new Timer(5000,new Timeraction(this) );
        timer.start();
    }

    @Override
    public boolean isComplete() {
        return getMario().getCoins() >=6;


    }




}
