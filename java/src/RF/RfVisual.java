package RF;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;

import java.util.ArrayList;
import java.util.List;

public class RfVisual extends Visual {

    List<Randerable> view1 = new ArrayList<>();
    List<Randerable> view2 = new ArrayList<>();
    List<Randerable> view3 = new ArrayList<>();
    RunTime runTime = new RunTime();

    @Override
    public void settings() {
        size(2048, 1024);
    }

    @Override
    public void setup() {
        startMinim();
        loadAudio("MyMusic.mp3");

        view1.add(new BottomRect(this));
        view1.add(new Line(this, runTime));
        view1.add(new BigCircle(this));

        view2.add(new MiddleCircle(this));
        view2.add(new Wave(this, runTime));
        view2.add(new star(this, runTime));

        view3.add(new MiddleRect(this));
        view3.add(new VerticalWave(this));
        view3.add(new RoundRect(this, runTime));

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

        int time = (int) (runTime.getTime() / 1000);
        if (time <= 30) {
            for (Randerable randerable : view1) {
                randerable.rander();
            }
        } else if (time <= 60) {
            for (Randerable randerable : view2) {
                randerable.rander();
            }
        } else {
            for (Randerable randerable : view3) {
                randerable.rander();
            }
        }
    }
}
