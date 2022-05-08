package Jz;

import processing.core.PApplet;
import processing.core.PConstants;

import static processing.core.PApplet.radians;


public class star implements Renderable {
    JzVisual jzVisual;
    RunTime runTime;

    public star(JzVisual jzVisual, RunTime runTime) {
        this.jzVisual = jzVisual;
        this.runTime = runTime;
    }

    @Override
    public void render() {
        float cx = jzVisual.width / 2;
        float cy = jzVisual.height / 2;
        jzVisual.colorMode(PApplet.HSB);

        jzVisual.strokeWeight(3);
        jzVisual.noFill();
        int len = jzVisual.getAudioBuffer().size();
        jzVisual.translate(cx, cy);
        jzVisual.ellipseMode(PConstants.RADIUS);
        jzVisual.rotate(radians((float) runTime.getTime() / 100));

        for (int i = 0; i < 360; i++) {
            if (i % 4 != 0) continue;
            jzVisual.stroke(
                    PApplet.map(i, 0, len, 0, 255)
                    , 100
                    , 150
            );
            float cur = jzVisual.getAudioBuffer().get(i);
            jzVisual.rotate(radians(4));
//            rfVisual.arc(100 * (1 + cur), 100, 100F, 50F, 0, 0.1F);
//            rfVisual.arc(200 * (1 + cur), 200, 100F, 50F, 0, 0.1F);
//            rfVisual.arc(300 * (1 + cur), 300, 100F, 50F, 0, 0.1F);
//            rfVisual.arc(400 * (1 + cur), 400, 100F, 50F, 0, 0.1F);
            jzVisual.circle((float) (100 * (1 + cur*0.5)), 100F, 1F);
            jzVisual.circle((float) (200 * (1 + cur*0.5)), 200F, 1F);
            jzVisual.circle((float) (300 * (1 + cur*0.5)), 300F, 1F);

        }


    }
}
