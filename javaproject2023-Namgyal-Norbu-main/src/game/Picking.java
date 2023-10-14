/**
 * @author      Tenzin Norbu Tenzin.Norbu@city.ac.uk
 * @version     1.2
 * @since       2023
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public abstract class Picking implements CollisionListener {
    public Mario mario;
    public abstract void collide(CollisionEvent e);


}
