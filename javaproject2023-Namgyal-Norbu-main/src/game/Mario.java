/**
 * @author      Tenzin Norbu Tenzin.Norbu@city.ac.uk
 * @version     1.2
 * @since       2023
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Mario extends Walker {

    public int health = 3;
    private int coins;
    private int heart ;

    public void setCoins (int Coins){
        this.coins = Coins;
    }
    public int getCoins(){
        return coins;
    }
    public void setHeart(int Heart){
        this.heart = Heart;
    }
    public int getHeart() {return heart ;}

    public int getHealth(){return health;}

    private static final Shape marioShape = new BoxShape(1,2.5f);
    public static BodyImage image= new BodyImage("data/Mario.png", 6);
    public Mario(World world){
        super(world, marioShape);
        this.addImage(image);

    }

    public void damage(){
        health = health - 1;

    }

    public void gameover(){
        health = health - 100;
    }
    public void Heartplus(){
        health = health + 1;

    }
}
