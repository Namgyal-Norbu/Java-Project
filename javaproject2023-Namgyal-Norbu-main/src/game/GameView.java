/**
 * @author      Tenzin Norbu Tenzin.Norbu@city.ac.uk
 * @version     1.2
 * @since       2023
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.SoundClip;
import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView{
    GameLevel gameworld;

    Image HealthBarFull = new ImageIcon("data/FullHealth.png").getImage();

    Image HealthBarHalf = new ImageIcon("data/HalfHealth.png").getImage();

    Image HealthBarQuarter = new ImageIcon("data/QuarterHealth.png").getImage();

    Image NoHealth = new ImageIcon("data/GameOver.png").getImage();

    Image zero = new ImageIcon("data/Coins/0.png").getImage();

    Image one = new ImageIcon("data/Coins/1.png").getImage();

    Image two = new ImageIcon("data/Coins/2.png").getImage();

    Image three = new ImageIcon("data/Coins/3.png").getImage();

    Image four = new ImageIcon("data/Coins/4.png").getImage();

    Image five = new ImageIcon("data/Coins/5.png").getImage();

    Image six  = new ImageIcon("data/background2.png").getImage();

    Image banner = new ImageIcon("data/Banner.png").getImage();


    Image background = new ImageIcon("data/Background.png").getImage();



    @Override
    protected void paintBackground(Graphics2D g) {
            g.drawImage(background, 0, 0, 1200, 1200, this);
    }


    public void paintForeground (Graphics2D G2) {

        {
            if (gameworld.getMario().getCoins() >= 0 && gameworld.getMario().getHealth() > 0)
                G2.drawImage(banner, 450, 50, 300, 50, this);
        }


        if (gameworld.getMario().getCoins() == 6 && gameworld.getMario().getHealth() > 0) {
            G2.drawImage(six, -150, 0, 1500, 800, this);

        } else if (gameworld.getMario().getHealth() >= 3) {

            G2.drawImage(HealthBarFull, 50, -1, 200, 75, this);
        } else if (gameworld.getMario().getHealth() == 2) {

            G2.drawImage(HealthBarHalf, 50, -15, 200, 100, this);
        } else if (gameworld.getMario().getHealth() == 1) {

            G2.drawImage(HealthBarQuarter, 50, -17, 200, 90, this);
        } else if (gameworld.getMario().getHealth() <= 0 ) {
            G2.drawImage(NoHealth, -15, -110, 1300, 1000, this);
        }
        if ((gameworld.getMario().getCoins() == 0 && gameworld.getMario().getHealth() > 0)) {
            G2.drawImage(zero, 1050, -1, 100, 50, this);

        } else if (gameworld.getMario().getCoins() == 1 && gameworld.getMario().getHealth() > 0) {
            G2.drawImage(one, 1050, -1, 100, 50, this);
        } else if (gameworld.getMario().getCoins() == 2 && gameworld.getMario().getHealth() > 0) {
            G2.drawImage(two, 1050, -1, 100, 50, this);
        } else if (gameworld.getMario().getCoins() == 3 && gameworld.getMario().getHealth() > 0) {
            G2.drawImage(three, 1050, -1, 100, 50, this);
        } else if (gameworld.getMario().getCoins() == 4 && gameworld.getMario().getHealth() > 0) {
            G2.drawImage(four, 1050, -1, 100, 50, this);
        } else if (gameworld.getMario().getCoins() == 5 && gameworld.getMario().getHealth() > 0) {
            G2.drawImage(five, 1050, -1, 100, 50, this);

        }

    }


        @Override
    public void setWorld(World world) {
        super.setWorld(world);
        this.gameworld=(GameLevel) world;
    }

    public GameView(GameLevel w, int width, int height) {super(w, width, height);
        gameworld=w;
    }

}
