package RF;

import processing.core.PApplet;
import processing.core.PConstants;

public class Wave implements Randerable {
    RfVisual rfVisual;
    float cy = 0;

    public Wave(RfVisual rfVisual) {
        this.rfVisual = rfVisual;
        cy = this.rfVisual.height / 2;
    }

    @Override
    public void rander() {
        rfVisual.colorMode(PApplet.HSB);
        int len = rfVisual.getAudioBuffer().size();
        for (int i = 0; i < len; i++) {
            if (i % 8 != 0) continue;
            rfVisual.stroke(
                    PApplet.map(i, 0, len, 255, 255)
                    , 255
                    , 255
            );
            float cur = rfVisual.getAudioBuffer().get(i);
            rfVisual.line(i, cy, i, cy + cy * cur);

            rfVisual.line(rfVisual.width / 2, cy, i, cy + cy * cur);


        }
    }
}
