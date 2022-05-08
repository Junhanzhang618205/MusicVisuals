package Jz;

import processing.core.PApplet;

/**
 * This is Circle in the middle of the screen
 */
public class MiddleCircle implements Renderable {
    JzVisual jzVisual;


    public MiddleCircle(JzVisual jzVisual) {
        this.jzVisual = jzVisual;
    }

    @Override
    public void render() {
        jzVisual.colorMode(PApplet.HSB);

        float mag = 500;
        float maxSize = Math.min(jzVisual.width, jzVisual.height) / (4 * mag);
        float base = maxSize / 4;
        float avg = 0;
        float sum = 0;
        for (int i = 0; i < jzVisual.getAudioBuffer().size(); i++) {
            sum += jzVisual.getAudioBuffer().get(i);

        }
        avg = sum / (float) jzVisual.getAudioBuffer().size();
        int color = (int) (100 * (1 + avg * 100));
        avg += base;
        if (color <= 0) color = 0;
        else if (color >= 255) color = 255;

        jzVisual.stroke(255);
        jzVisual.fill(color, 255, 255);
        jzVisual.circle(jzVisual.width / 2, jzVisual.height / 2, avg * mag);
    }
}
