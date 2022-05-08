package Kty;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;

import java.util.ArrayList;
import java.util.List;

public class KtyVisual extends Visual {

    List<Randerable> entities1 = new ArrayList<>();
    List<Randerable> entities2 = new ArrayList<>();
    List<Randerable> entities3 = new ArrayList<>();
    RunTime runTime = new RunTime();

    @Override
    public void settings() {
        size(2048, 1024);
    }

    @Override
    public void setup() {
        startMinim();
        loadAudio("MyMusic.mp3");

        entities1.add(new BottomRect(this));
        entities1.add(new Line(this, runTime));
        entities1.add(new BigCircle(this));

        entities2.add(new MiddleCircle(this));
        entities2.add(new Wave(this, runTime));
        entities2.add(new star(this, runTime));

        entities3.add(new MiddleRect(this));
        entities3.add(new RoundRect(this, runTime));

    }

    @Override
    public void keyPressed() {
        if (key == ' ') {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
            if (runTime.isAlive()) {
                runTime.init();
            } else {
                runTime.start();
            }
        }
    }

    @Override
    public void draw() {
        background(0);
        try {
            // Call this if you want to use FFT data
            calculateFFT();
        } catch (VisualException e) {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        calculateFrequencyBands();

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();

        for (Randerable randerable : entities1) {
            randerable.rander();
        }
    }
}
