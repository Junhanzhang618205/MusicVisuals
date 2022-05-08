package RF;

import processing.core.PApplet;
import processing.core.PConstants;

import static processing.core.PApplet.radians;


public class star implements Renderable {
    RfVisual rfVisual;
    RunTime runTime;

    public star(RfVisual rfVisual, RunTime runTime) {
        this.rfVisual = rfVisual;
        this.runTime = runTime;
    }

    @Override
    public void render() {
        float cx = rfVisual.width / 2;
        float cy = rfVisual.height / 2;
        rfVisual.colorMode(PApplet.HSB);

        rfVisual.strokeWeight(3);
        rfVisual.noFill();
        int len = rfVisual.getAudioBuffer().size();
        rfVisual.translate(cx, cy);
        rfVisual.ellipseMode(PConstants.RADIUS);
        rfVisual.rotate(radians((float) runTime.getTime() / 100));

        for (int i = 0; i < 360; i++) {
            if (i % 4 != 0) continue;
            rfVisual.stroke(
                    PApplet.map(i, 0, len, 0, 255)
                    , 100
                    , 150
            );
            float cur = rfVisual.getAudioBuffer().get(i);
            rfVisual.rotate(radians(4));
//            rfVisual.arc(100 * (1 + cur), 100, 100F, 50F, 0, 0.1F);
//            rfVisual.arc(200 * (1 + cur), 200, 100F, 50F, 0, 0.1F);
//            rfVisual.arc(300 * (1 + cur), 300, 100F, 50F, 0, 0.1F);
//            rfVisual.arc(400 * (1 + cur), 400, 100F, 50F, 0, 0.1F);
            rfVisual.circle((float) (100 * (1 + cur*0.5)), 100F, 1F);
            rfVisual.circle((float) (200 * (1 + cur*0.5)), 200F, 1F);
            rfVisual.circle((float) (300 * (1 + cur*0.5)), 300F, 1F);

        }


    }
}
