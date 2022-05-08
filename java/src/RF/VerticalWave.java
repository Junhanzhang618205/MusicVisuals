package RF;

import processing.core.PApplet;

public class VerticalWave implements Renderable {
    RfVisual rfVisual;

    public VerticalWave(RfVisual rfVisual) {
        this.rfVisual = rfVisual;
    }

    @Override
    public void render() {
        float cy = rfVisual.height / 2;
        rfVisual.colorMode(PApplet.HSB);
        int len = rfVisual.getAudioBuffer().size();
        for (int i = 0; i < len; i++) {
            rfVisual.stroke(
                    PApplet.map(i, 0, len, 0, 255)
                    , 255
                    , 255
            );
            float gap = rfVisual.width / len;
            float base = 300;
            float cur = rfVisual.getAudioBuffer().get(i);
            rfVisual.line(base, i * gap, base * (1 + cur), i * gap);
            rfVisual.line(rfVisual.width - 300, i * gap, rfVisual.width - base * (1 + cur), i * gap);
        }
    }
}
