/**
 * @author      Tenzin Norbu Tenzin.Norbu@city.ac.uk
 * @version     1.2
 * @since       2023
 */
package game;

import city.cs.engine.*;

public class Pipe extends StaticBody {

    private int barrels;

    private int shells;

    private static final Shape Pipeshape = new BoxShape(1, 1);
    private static final BodyImage image = new BodyImage("data/Pipe.png", 3);

    public void setBarrel (int Barrels){
        this.barrels= Barrels;
    }
    public int getBarrel(){
        return barrels;
    }

    public void setShell (int Shells){this.shells = Shells;}

    public int getShell(){
        return shells;
    }

    public Pipe(World world) {
        super(world, Pipeshape);
        this.addImage(image);
    }
}
