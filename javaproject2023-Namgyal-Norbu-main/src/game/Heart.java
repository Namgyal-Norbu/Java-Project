/**
 * @author      Tenzin Norbu Tenzin.Norbu@city.ac.uk
 * @version     1.2
 * @since       2023
 */
package game;

import city.cs.engine.*;

public class Heart extends DynamicBody {

    private static final Shape HeartShape = new BoxShape(0.1f,1);
    private static final BodyImage image2 = new BodyImage("data/Heart.png",2);

    public Heart(World w ) {
        super(w,HeartShape);
        this.addImage(image2);
    }
}
