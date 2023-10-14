/**
 * @author      Tenzin Norbu Tenzin.Norbu@city.ac.uk
 * @version     1.2
 * @since       2023
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class Shellpick implements CollisionListener {
    public Pipe pipe;

    public Shellpick(Pipe p){this.pipe =p;}


    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof Shell) {
            pipe.setShell(pipe.getShell() + 1);
            collisionEvent.getOtherBody().destroy();

        }
    }
}

