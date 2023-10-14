/**
 * @author      Tenzin Norbu Tenzin.Norbu@city.ac.uk
 * @version     1.2
 * @since       2023
 */
package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class DonkeyKong extends StaticBody implements StepListener {
    private GameLevel world;

    private int counter=250;

    private State state;

    private enum State {
        still
    }
    private static final Shape DKShape = new BoxShape(1, 2.5f);
        public static BodyImage image2 = new BodyImage("data/DonkeyKong.png", 6);


        public DonkeyKong(World world) {
            super(world, DKShape);
            this.world = (GameLevel) world;
            this.addImage(image2);
            state = DonkeyKong.State.still;
            world.addStepListener(this);

        }

    /**
     * if Mario is on the left of Donkey Kong this method is run
     * <p>
     * Allows Donkeykong to aim to the left
     *
     *
     * @return the return is true if the x position of Donkey kong is greater number then the x position of Mario
     */
        public boolean shoot_left() {

            Body a = world.getMario();
            return this.getPosition().x > a.getPosition().x;


       }
    /**This is used to aim to the Right for DonkeyKong
     * This is used when the Mario is on the right of DonkeyKong
     * @return return is true if the x position of Donkey kong is less than the x position of Mario
     */
    public boolean shoot_right() {

        Body a = world.getMario();
        return this.getPosition().x < a.getPosition().x;

    }

    /**used to determine if DonkeyKong shoots left or right
     * through this method we determine what DonkeyKong will do and how fast Donkey shoots through a counter
     * @param stepEvent is used as a default parameter in the override class
     */
    @Override
    public void preStep(StepEvent stepEvent) {
            counter--;
        if (shoot_right() && counter<0){
            Barrel barrel = new Barrel(this.getWorld());
            barrel.setPosition(this.getPosition().sub(new Vec2(-1,0)));
            barrel.setLinearVelocity(new Vec2(6,5));
            counter=200;
        }else if (shoot_left()&&counter<0){
            Barrel barrel = new Barrel(this.getWorld());
            barrel.setPosition(this.getPosition().sub(new Vec2(1,0)));;
            barrel.setLinearVelocity( new Vec2(-6,5));
            counter=100;
        }

    }


    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
