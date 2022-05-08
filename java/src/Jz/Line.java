package Jz;

import processing.core.PApplet;

public class Line implements Renderable {
    JzVisual jzVisual;
    RunTime runTime;
    float cy = 0;
    float cx = 0;

    public Line(JzVisual jzVisual, RunTime runTime) {
        this.jzVisual = jzVisual;
        this.runTime = runTime;
        cy = this.jzVisual.height / 2;
        cx = this.jzVisual.width / 2;
    }

    @Override
    public void render() {
        jzVisual.colorMode(PApplet.HSB);
        int len = jzVisual.getAudioBuffer().size();
        int plus = (int) runTime.getTime();
        jzVisual.strokeWeight(4);
        for (int i = 0; i < len; i++) {
            if (i % 4 != 0) continue;
            jzVisual.stroke(
                    PApplet.map(i, 0, len, 0, 255)
                    , 255
                    , 255
            );
            float cur = jzVisual.getAudioBuffer().get(i);

            float radius = Math.min(cx, cy) / 4;

            radius = radius / 4 + (float) (1000 * cur * 2.5);

            int x = (int) (cx - radius * Math.sin(Math.PI * (i + plus * 10) / len * 360));
            int y = (int) (cy - radius * Math.cos(Math.PI * (i + plus * 10) / len * 360));

            jzVisual.line(cx, cy, x, y);

        }
    }
}
