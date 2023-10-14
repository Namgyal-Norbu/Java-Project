/**
 * @author      Tenzin Norbu Tenzin.Norbu@city.ac.uk
 * @version     1.2
 * @since       2023
 */
package game;

import city.cs.engine.*;

public class Shell extends DynamicBody {

    private static Shape shape = new BoxShape(0.5f, 1);
    private BodyImage Shellimg = new BodyImage("data/Shell.png", 2.4f);


    public Shell(World w) {
        super(w, shape);

        this.addImage(Shellimg);
    }


}

