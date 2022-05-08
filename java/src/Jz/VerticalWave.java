package Jz;

import processing.core.PApplet;

public class VerticalWave implements Renderable {
    JzVisual jzVisual;

    public VerticalWave(JzVisual jzVisual) {
        this.jzVisual = jzVisual;
    }

    @Override
    public void render() {
        float cy = jzVisual.height / 2;
        jzVisual.colorMode(PApplet.HSB);
        int len = jzVisual.getAudioBuffer().size();
        for (int i = 0; i < len; i++) {
            jzVisual.stroke(
                    PApplet.map(i, 0, len, 0, 255)
                    , 255
                    , 255
            );
            float gap = jzVisual.width / len;
            float base = 300;
            float cur = jzVisual.getAudioBuffer().get(i);
            jzVisual.line(base, i * gap, base * (1 + cur), i * gap);
            jzVisual.line(jzVisual.width - 300, i * gap, jzVisual.width - base * (1 + cur), i * gap);
        }
    }
}
