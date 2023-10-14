/**
 * @author      Tenzin Norbu Tenzin.Norbu@city.ac.uk
 * @version     1.2
 * @since       2023
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Chomp extends DynamicBody implements StepListener {

    private static final float radius = 1.0f;
    private static final Shape Shape = new CircleShape(radius);
    private static final BodyImage Image = new BodyImage("data/Chomp.png", 2*radius);

    private enum State {
        Move_Left, Move_Right, STAND_STILL;
    }
    public static final float RANGE = 6;
    private GameLevel world;
    private State state;

    public Chomp(GameLevel world) {
        super(world, Shape);
        this.world= world;
        addImage(Image);
        state = State.STAND_STILL;
        getWorld().addStepListener(this);
    }

    public boolean inRangeLeft() {
        Body a = world.getMario();
        float gap = getPosition().x - a.getPosition().x;
        return gap < RANGE && gap > 0;    //gap in (0,RANGE)
    }

    public boolean inRangeRight() {
        Body a = world.getMario();
        float gap = getPosition().x - a.getPosition().x;
        return gap > -RANGE && gap < 0;  //gap in (-RANGE, 0)
    }

    // update state
    public void preStep(StepEvent e) {
        if (inRangeRight()) {
            if (state != State.Move_Right) {
                state = State.Move_Right;
                setAngularVelocity(-8);
            }
        } else if (inRangeLeft()) {
            if (state != State.Move_Left) {
                state = State.Move_Left;
                setAngularVelocity(8);
            }
        } else {
            if (state != State.STAND_STILL) {
                state = State.STAND_STILL;
                setAngularVelocity(0);
                setLinearVelocity(new Vec2(0, 0));
            }
        }
        refreshRoll();
    }


    private void refreshRoll() {
        switch (state) {
            case Move_Left:
                setAngularVelocity(8);
                break;
            case Move_Right:
                setAngularVelocity(-8);
            default: // nothing to do
        }
    }

    public void postStep(StepEvent e) {
    }
}