/**
 * @author      Tenzin Norbu Tenzin.Norbu@city.ac.uk
 * @version     1.2
 * @since       2023
 */
package game;

import city.cs.engine.*;

public class Lava extends StaticBody {

    int barrels;

    int chomp;
    public void setBarrel (int Barrels){
        this.barrels= Barrels;
    }

    public int getBarrel(){
        return barrels;
    }

    public void setChomp (int Chomp){
        this.chomp= Chomp;
    }

    public int getChomp(){
        return chomp;
    }




    public Lava(World world) {
        super(world, Lavashape);
        this.addImage(Lava);

    }
    private static final Shape Lavashape = new BoxShape(35, 3.5f);
    private static final BodyImage Lava = new BodyImage("data/Lava.png", 10);


}

