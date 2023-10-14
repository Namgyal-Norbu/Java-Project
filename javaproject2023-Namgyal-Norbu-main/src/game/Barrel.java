package game;

import city.cs.engine.*;

/**
 * @author      Tenzin Norbu Tenzin.Norbu@city.ac.uk
 * @version     1.2
 * @since       2023
 */
public class Barrel extends DynamicBody  {


    private static Shape shape3 = new BoxShape(0.5f, 1);
    private BodyImage barrelimg = new BodyImage("data/Barrel.png", 2.4f);


    public Barrel(World w) {
        super(w, shape3);

        this.addImage(barrelimg);
    }


}
