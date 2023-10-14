/**
 * @author      Tenzin Norbu Tenzin.Norbu@city.ac.uk
 * @version     1.2
 * @since       2023
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.StepEvent;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public class Koopa extends Enemies{

    private static final BodyImage KoopaImage = new BodyImage("data/Koopa.png",3);

    public Koopa(World world) {
        super(world, shape);
        addImage(KoopaImage);
        world.addStepListener(this);
        startWalking(Speed);
    }


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

