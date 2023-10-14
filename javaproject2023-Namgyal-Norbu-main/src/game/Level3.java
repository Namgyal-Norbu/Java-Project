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

public class Level3 extends GameLevel {

    Pipe pipe;

    Coin coin;

    Lava lava;

    DonkeyKong donkeyKong;




    public Level3(Game game) {
        super(game);

        mario.setPosition(new Vec2(24,-15));
        pipe = new Pipe(this);
        pipe.setPosition(new Vec2(-25.9f,-3.6f));
        BarrelPick pickup2 = new BarrelPick(pipe);
        pipe.addCollisionListener(pickup2);

        coin = new Coin (this);
        coin.setPosition(new Vec2(15,-8.1f));

        coin = new Coin (this);
        coin.setPosition(new Vec2(-5,-4));

        coin = new Coin (this);
        coin.setPosition(new Vec2(-15,-4));

        coin = new Coin (this);
        coin.setPosition(new Vec2(4,-4));

        lava = new Lava (this);
        lava.setPosition(new Vec2(-5.8f,-21.5f));
        LavaDestroy pickup = new LavaDestroy(lava);
        lava.addCollisionListener(pickup);
        lava = new Lava (this);
        lava.setPosition(new Vec2(-16.8f,-21.5f));


        donkeyKong = new DonkeyKong(this);
        donkeyKong.setPosition(new Vec2(-7,9));

        Shape platformshape = new BoxShape(1.8f,0.5f);
        StaticBody platform = new StaticBody(this, platformshape);
        platform.setPosition(new Vec2(4, -5.2f));
        platform.addImage(new BodyImage("data/Platform.png", 2));

        Shape platformshape8 = new BoxShape(1.8f,0.5f);
        StaticBody platform8 = new StaticBody(this, platformshape8);
        platform8.setPosition(new Vec2(-5, -5.2f));
        platform8.addImage(new BodyImage("data/Platform.png", 2));

        Shape platformshape9 = new BoxShape(1.8f,0.5f);
        StaticBody platform9 = new StaticBody(this, platformshape9);
        platform9.setPosition(new Vec2(-15, -5.2f));
        platform9.addImage(new BodyImage("data/Platform.png", 2));



        Shape platformShape1 = new BoxShape(5, 5);
        StaticBody platform1 = new StaticBody(this, platformShape1);
        platform1.setPosition(new Vec2(15, -14));
        platform1.addImage(new BodyImage("data/Wall.png",10));

        Shape platformShape2 = new BoxShape(5, 5);
        StaticBody platform2 = new StaticBody(this, platformShape2);
        platform2.setPosition(new Vec2(15, 14));
        platform2.addImage(new BodyImage("data/Wall.png",10));

        Shape shape = new BoxShape(2, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(-7, 6));
        ground.addImage(new BodyImage("data/Ground.png", 0.5f));

        Shape shape2 = new BoxShape(3, 0.5f);
        StaticBody ground2 = new StaticBody(this, shape2);
        ground2.setPosition(new Vec2(-26, -5.2f));
        ground2.addImage(new BodyImage("data/Platform.png", 2));

        Shape shape3 = new BoxShape(7, 0.5f);
        StaticBody ground3 = new StaticBody(this, shape3);
        ground3.setPosition(new Vec2(23, -16.2f));
        ground3.addImage(new BodyImage("data/Ground.png", 1));


    }

    @Override
    public boolean isComplete() {
        return getMario().getCoins() >= 4 ;
    }
}
