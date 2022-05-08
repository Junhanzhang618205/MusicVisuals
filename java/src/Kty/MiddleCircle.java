package Kty;

import processing.core.PApplet;

/**
 * This is Circle in the middle of the screen
 */
public class MiddleCircle implements Randerable {
    KtyVisual rfVisual;


    public MiddleCircle(KtyVisual rfVisual) {
        this.rfVisual = rfVisual;
    }

    @Override
    public void rander() {
        rfVisual.colorMode(PApplet.HSB);

        float mag = 500;
        float maxSize = Math.min(rfVisual.width, rfVisual.height) / (4 * mag);
        float base = maxSize / 4;
        float avg = 0;
        float sum = 0;
        for (int i = 0; i < rfVisual.getAudioBuffer().size(); i++) {
            sum += rfVisual.getAudioBuffer().get(i);
        }
        avg = sum / (float) rfVisual.getAudioBuffer().size();
        avg += base;

        rfVisual.stroke(255);
        rfVisual.fill(100, 255, 255);
        rfVisual.circle(rfVisual.width / 2, rfVisual.height / 2, avg * mag);
    }
}
