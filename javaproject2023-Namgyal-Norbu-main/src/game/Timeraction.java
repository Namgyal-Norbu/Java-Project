package game;


import city.cs.engine.Body;
import org.jbox2d.common.Vec2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Timeraction implements ActionListener {
    private Level4 gameLevel;

    public Timeraction(Level4 level) {
        this.gameLevel = level;
    }

    int counter = 0;

    @Override
    public void actionPerformed(ActionEvent e) {

        Barrel h = new Barrel(gameLevel);
        Barrel h3 = new Barrel(gameLevel);
        Barrel h4 = new Barrel(gameLevel);


        Body a = gameLevel.getMario();
        h.setPosition(a.getPosition().sub(new Vec2(0,-10)));
        h3.setPosition(new Vec2(-18, 14));
        h4.setPosition(new Vec2(18, 14));


    }
}
