/**
 * @author      Tenzin Norbu Tenzin.Norbu@city.ac.uk
 * @version     1.2
 * @since       2023
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Goomba extends Enemies{


    private static final BodyImage GoombaImage = new BodyImage("data/Goomba.png",2.5f);




    public Goomba(World world) {
        super(world, shape);
        addImage(GoombaImage);
        world.addStepListener(this);
        startWalking(Speed);
    }

    @Override
    public void setPosition(Vec2 position) {
        super.setPosition(position);
        left = position.x-RANGE;
        right = position.x+RANGE;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if (getPosition().x > right){
            startWalking(-Speed);
        }
        if (getPosition().x < left){
            startWalking(Speed);
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}

