package RF;

import processing.core.PApplet;
import processing.core.PConstants;

import static java.lang.Math.PI;
import static processing.core.PApplet.radians;


public class Ellipse implements Randerable {
    RfVisual rfVisual;
    RunTime runTime;

    public Ellipse(RfVisual rfVisual, RunTime runTime) {
        this.rfVisual = rfVisual;
        this.runTime = runTime;
    }

    @Override
    public void rander() {
        float cx = rfVisual.width / 2;
        float cy = rfVisual.height / 2;
        rfVisual.colorMode(PApplet.HSB);

        rfVisual.strokeWeight(3);
        rfVisual.noFill();
        int len = rfVisual.getAudioBuffer().size();
        rfVisual.translate(cx, cy);
        rfVisual.ellipseMode(PConstants.RADIUS);

        for (int i = 0; i < len; i++) {
            if (i % 8 != 0) continue;
            rfVisual.stroke(
                    PApplet.map(i, 0, len, 0, 255)
                    , 100
                    , 150
            );
            float cur = rfVisual.getAudioBuffer().get(i);
//            rfVisual.rotate((float) ((i + runTime.getTime() / 10) * 0.0002));
            rfVisual.rotate(radians((float) (i + runTime.getTime() / 500) / len * 360));
            rfVisual.arc(200 * (1 + cur), 200 * (1 + cur), 100F, 50F, 0, 0.4F);
        }


    }
}
