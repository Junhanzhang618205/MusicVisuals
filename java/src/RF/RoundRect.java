package RF;


import processing.core.PApplet;

import static java.lang.Math.abs;
import static processing.core.PApplet.*;

public class RoundRect implements Randerable {
    RfVisual rfVisual;
    RunTime runTime;

    public RoundRect(RfVisual rfVisual, RunTime runTime) {
        this.rfVisual = rfVisual;
        this.runTime = runTime;
    }

    @Override
    public void rander() {
        float cx = rfVisual.width / 2;
        float cy = rfVisual.height / 2;
        rfVisual.translate(cx, cy);
        rfVisual.rectMode(CORNER);
        rfVisual.rotate(radians((float) runTime.getTime() / 100));
        int num = 90;
        for (int i = 0; i < 360; i++) {
            if (i % (360 / num) != 0) continue;
            float cur = rfVisual.getAudioBuffer().get(i);
            float radius = 200F;
            float degree = PI * (i);
            float width = ((2 * PI * radius) / num) / 2;
            float height = 5 + 100 * abs(cur);
            rfVisual.fill(
                    PApplet.map(i, 0, 360, 0, 255)
                    , 100
                    , 150
            );
            rfVisual.rotate(radians((360 / num)));
            rfVisual.rect(radius * sin(degree)
                    , radius * cos(degree)
                    , width
                    , height);
        }

    }
}
