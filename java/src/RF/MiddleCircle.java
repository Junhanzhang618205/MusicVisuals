package RF;

import processing.core.PApplet;

/**
 * This is Circle in the middle of the screen
 */
public class MiddleCircle implements Randerable {
    RfVisual rfVisual;
    private float avg = 0;


    public MiddleCircle(RfVisual rfVisual) {
        this.rfVisual = rfVisual;
    }

    @Override
    public void rander() {
        rfVisual.colorMode(PApplet.HSB);

        float sum = 0;
        for (int i = 0; i < rfVisual.getAudioBuffer().size(); i++) {
            sum += rfVisual.getAudioBuffer().get(i);
        }
        avg = sum / (float) rfVisual.getAudioBuffer().size();

        rfVisual.stroke(255);
        rfVisual.fill(100,255,255);
        rfVisual.circle(rfVisual.width / 2, rfVisual.height / 2, avg * 500);
    }
}
