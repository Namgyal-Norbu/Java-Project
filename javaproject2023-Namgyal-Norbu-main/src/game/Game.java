package game;

import city.cs.engine.*;
import city.cs.engine.SoundClip;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

/**
 * Your main game entry point
 */

/**
 * @author      Tenzin Norbu
 * @version     1.2
 * @since       2023
 */
public class Game {


    public SoundClip music;

    private SoundClip music2;

    private SoundClip music3;

    private SoundClip music4;

    private static SoundClip gameover;

    GameLevel currentLevel;

    GameView view;

    MarioController controller;

    static {
        try {
            gameover = new SoundClip("data/Music/Gameover.wav");
            gameover.setVolume(2);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
        }
    }

    /**
     * Initialise a new Game.
     */
    public Game() {




        //1. make an empty game world
        currentLevel = new Level1(this);

        view = new GameView(currentLevel, 1200, 750);


        // view.setGridResolution(1);
        controller = new MarioController(currentLevel.getMario());
        view.addKeyListener(controller);
        view.addMouseListener(new GiveFocus(view));

        //3. create a Java window (frame) and add the game
        //   view to it
         JFrame frame = new JFrame("Mario");
        frame.add(view);
        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world aview
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        //optional: uncomment this to make a debugging view
       // JFrame debugView = new DebugViewer(currentLevel, 800, 525);

        // start our game world simulation!



        currentLevel.start();

            try {
                music = new SoundClip("data/Music/ThemeSong.wav");
                music.loop();

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            }

    }

    /**
     * Method lets player enter the next level.
     * <p>
     * this method is used every time a player encounters the pipe
     *
     *
     *
     */
    public void goToNextLevel() {
        if (currentLevel instanceof Level1) {
            currentLevel.stop();
            music.stop();

            Mario prevMario = currentLevel.getMario();

            currentLevel = new Level2(this);

            Mario newMario = currentLevel.getMario();

            view.setWorld(currentLevel);

            try {
                music2 = new SoundClip("data/Music/Level2Song.wav");
                music2.loop();

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }


            controller.updateMario(currentLevel.getMario());

            currentLevel.start();


        }  else if (currentLevel instanceof Level2){
            currentLevel.stop();
           music2.stop();

            Mario prevMario = currentLevel.getMario();

            currentLevel = new Level3(this);

            Mario newMario = currentLevel.getMario();

            view.setWorld(currentLevel);

           try {
                music3 = new SoundClip("data/Music/Level3Song.wav");
                music3.loop();

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }

            controller = new MarioController(currentLevel.getMario());
            view.addKeyListener(controller);
            view.addMouseListener(new GiveFocus(view));


            controller.updateMario(currentLevel.getMario());

            currentLevel.start();

        } else if (currentLevel instanceof Level3) {
            currentLevel.stop();
           music3.stop();
            Mario prevMario = currentLevel.getMario();

            currentLevel = new Level4(this);

            Mario newMario = currentLevel.getMario();

            view.setWorld(currentLevel);

           try {
                music4 = new SoundClip("data/Music/Level4Song.wav");
                music4.loop();

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }

            controller = new MarioController(currentLevel.getMario());
            view.addKeyListener(controller);
            view.addMouseListener(new GiveFocus(view));

            controller.updateMario(currentLevel.getMario());

            currentLevel.start();

        }
    }

        /**
         * Run the game.
         */
        public static void main (String[]args){

            new Game();

        }

    }



