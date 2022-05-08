package Jz;


import processing.core.PApplet;

import static java.lang.Math.abs;
import static processing.core.PApplet.*;

public class RoundRect implements Renderable {
    JzVisual jzVisual;
    RunTime runTime;

    public RoundRect(JzVisual jzVisual, RunTime runTime) {
        this.jzVisual = jzVisual;
        this.runTime = runTime;
    }

    @Override
    public void render() {
        float cx = jzVisual.width / 2;
        float cy = jzVisual.height / 2;
        jzVisual.translate(cx, cy);
        jzVisual.rectMode(CORNER);
        jzVisual.rotate(radians((float) runTime.getTime() / 100));
        int num = 90;
        for (int i = 0; i < 360; i++) {
            if (i % (360 / num) != 0) continue;
            float cur = jzVisual.getAudioBuffer().get(i);
            float radius = 200F;
            float degree = PI * (i);
            float width = ((2 * PI * radius) / num) / 2;
            float height = 5 + 100 * abs(cur);
            jzVisual.fill(
                    PApplet.map(i, 0, 360, 0, 255)
                    , 100
                    , 150
            );
            jzVisual.rotate(radians((360 / num)));
            jzVisual.rect(radius * sin(degree)
                    , radius * cos(degree)
                    , width
                    , height);
        }

    }
}
