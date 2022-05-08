package Kty;

import processing.core.PApplet;

public class Wave implements Randerable {
    KtyVisual rfVisual;
    RunTime runTime;

    public Wave(KtyVisual rfVisual, RunTime runTime) {
        this.rfVisual = rfVisual;
        this.runTime = runTime;
    }

    @Override
    public void rander() {

        float cy = rfVisual.height / 2;
        rfVisual.colorMode(PApplet.HSB);
        int len = rfVisual.getAudioBuffer().size();
        for (int i = 0; i < len; i++) {
            rfVisual.stroke(
                    PApplet.map(i, 0, len, 0, 255)
                    , 255
                    , 255
            );
            rfVisual.line(i, cy, i, cy + cy * rfVisual.getAudioBuffer().get(i));
            rfVisual.line(rfVisual.width - i, cy, rfVisual.width - i, cy + cy * rfVisual.getAudioBuffer().get(i));
        }
    }
}
