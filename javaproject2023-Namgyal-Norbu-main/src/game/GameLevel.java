/**
 * @author      Tenzin Norbu Tenzin.Norbu@city.ac.uk
 * @version     1.2
 * @since       2023
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
public abstract class GameLevel extends World {


    public Mario mario;
    public Koopa koopa;
    public Game game;
    public Coin coin;
    public Goomba goomba;

    public GameLevel(Game game) {
        this.game = game;


        mario = new Mario(this);
        mario.setPosition(new Vec2(4, -10));
        CoinsPick pickup = new CoinsPick(mario);

        HeartPick pickup2 = new HeartPick(mario);
        mario.addCollisionListener(pickup2);

        mario.addCollisionListener(pickup);
        mario.addCollisionListener(new PipeEncounter(this, game));

        GeneralCollisionListener gcl = new GeneralCollisionListener(this, game);
        mario.addCollisionListener(gcl);

        Shape Wall1 = new BoxShape(1, 25);
        StaticBody wall1 = new StaticBody(this, Wall1);
        wall1.setPosition(new Vec2(-29, 5));

        Shape Wall2 = new BoxShape(1, 25);
        StaticBody wall2 = new StaticBody(this, Wall2);
        wall2.setPosition(new Vec2(29, 5));



        Shape platformShape4 = new BoxShape(20, 0.5f);
        StaticBody platform4 = new StaticBody(this, platformShape4);
        platform4.setPosition(new Vec2(0, 21));

        Shape platformShape5 = new BoxShape(20, 0.5f);
        StaticBody platform5 = new StaticBody(this, platformShape5);
        platform5.setPosition(new Vec2(-15, 21));

        Shape platformShape6 = new BoxShape(20, 0.5f);
        StaticBody platform6 = new StaticBody(this, platformShape6);
        platform6.setPosition(new Vec2(15, 21));




        }

        public Mario getMario () {
            return mario;
        }

        public Koopa getKoopa () {
            return koopa;
        }
        public abstract boolean isComplete ();
    }



