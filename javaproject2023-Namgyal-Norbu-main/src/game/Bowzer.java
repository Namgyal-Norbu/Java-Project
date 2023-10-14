/**
 * @author      Tenzin Norbu Tenzin.Norbu@city.ac.uk
 * @version     1.2
 * @since       2023
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Bowzer extends StaticBody implements StepListener{

    private static final Shape BowzerShape = new BoxShape(1, 2.5f);
    public static BodyImage image = new BodyImage("data/Bowzer.png", 6);
    private int count = 0;

    public Bowzer(World world) {
        super(world, BowzerShape);
        this.addImage(image);
        world.addStepListener(this);
    }

    /**
     * the shoot method allows Bowzer to shoot shells into the game
     *
     * this method is used everytime Bowzer shoots to determine his postion and a set linear velocity for the shell
     *
     *
     */
    public void shoot() {
        Shell shell = new Shell(this.getWorld());
        shell.setPosition(this.getPosition());
        shell.setLinearVelocity(new Vec2(10,12));
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        count++;
        if (count % 300 == 0)
            shoot();
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
