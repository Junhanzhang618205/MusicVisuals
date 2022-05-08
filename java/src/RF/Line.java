package RF;

import processing.core.PApplet;

public class Line implements Renderable {
    RfVisual rfVisual;
    RunTime runTime;
    float cy = 0;
    float cx = 0;

    public Line(RfVisual rfVisual, RunTime runTime) {
        this.rfVisual = rfVisual;
        this.runTime = runTime;
        cy = this.rfVisual.height / 2;
        cx = this.rfVisual.width / 2;
    }

    @Override
    public void render() {
        rfVisual.colorMode(PApplet.HSB);
        int len = rfVisual.getAudioBuffer().size();
        int plus = (int) runTime.getTime();
        rfVisual.strokeWeight(4);
        for (int i = 0; i < len; i++) {
            if (i % 4 != 0) continue;
            rfVisual.stroke(
                    PApplet.map(i, 0, len, 0, 255)
                    , 255
                    , 255
            );
            float cur = rfVisual.getAudioBuffer().get(i);

            float radius = Math.min(cx, cy) / 4;

            radius = radius / 4 + (float) (1000 * cur * 2.5);

            int x = (int) (cx - radius * Math.sin(Math.PI * (i + plus * 10) / len * 360));
            int y = (int) (cy - radius * Math.cos(Math.PI * (i + plus * 10) / len * 360));

            rfVisual.line(cx, cy, x, y);

        }
    }
}
