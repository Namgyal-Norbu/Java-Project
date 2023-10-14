package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * @author      Tenzin Norbu Tenzin.Norbu@city.ac.uk
 * @version     1.2
 * @since       2023
 */
public class BarrelPick implements CollisionListener {

    public Pipe pipe;

    public BarrelPick(Pipe p){this.pipe =p;}




    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof Barrel) {
            pipe.setBarrel(pipe.getBarrel() + 1);
            collisionEvent.getOtherBody().destroy();

        }
    }
}
