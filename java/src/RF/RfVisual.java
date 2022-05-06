package RF;

import example.WaveForm;
import ie.tudublin.Visual;
import ie.tudublin.VisualException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RfVisual extends Visual {

    List<Randerable> entities = new ArrayList<>();

    @Override
    public void settings() {
        size(2048, 1024);
    }

    @Override
    public void setup() {
        startMinim();
        loadAudio("heroplanet.mp3");

        entities.add(new MiddleCircle(this));

    }

    @Override
    public void keyPressed() {
        if (key == ' ') {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
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

        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).rander();
        }
    }
}
