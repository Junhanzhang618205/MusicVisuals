package RF;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;

import java.util.ArrayList;
import java.util.List;

public class RfVisual extends Visual {

    List<Renderable> view1 = new ArrayList<>();
    List<Renderable> view2 = new ArrayList<>();
    List<Renderable> view3 = new ArrayList<>();
    RunTime runTime = new RunTime();

    @Override
    public void settings() {
       // size(2048, 1024); // if you want to run this program in linux
        size(1024, 800);//if you are going to run this program in win
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
            for (Renderable randerable : view1) {
                randerable.render();
            }
        } else if (time <= 60) {
            for (Renderable randerable : view2) {
                randerable.render();
            }
        } else {
            for (Renderable renderable : view3) {
                renderable.render();
            }
        }
    }
}
