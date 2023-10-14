/**
 * @author      Tenzin Norbu Tenzin.Norbu@city.ac.uk
 * @version     1.2
 * @since       2023
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class ChompDestroy implements CollisionListener {

    public Lava lava;

    public ChompDestroy(Lava l){this.lava =l;}


    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof Chomp) {
            lava.setChomp(lava.getChomp() + 1);
            collisionEvent.getOtherBody().destroy();

        }
    }
}

