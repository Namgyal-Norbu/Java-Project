/**
 * @author      Tenzin Norbu Tenzin.Norbu@city.ac.uk
 * @version     1.2
 * @since       2023
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public abstract class Enemies extends Walker implements StepListener {

    public int Speed = 4;
    public float left, right;
    public int RANGE = 3;
    public static final Shape shape = new BoxShape(0.5f,1.3f);



    public Enemies(World world, Shape shape) {
        super(world, shape);
    }

    public abstract void preStep(StepEvent stepEvent);

    public abstract void postStep(StepEvent stepEvent);
}
