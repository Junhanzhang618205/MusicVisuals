package Jz;

import processing.core.PApplet;

public class Wave implements Renderable {
    JzVisual jzVisual;
    RunTime runTime;

    public Wave(JzVisual jzVisual, RunTime runTime) {
        this.jzVisual = jzVisual;
        this.runTime = runTime;
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
            jzVisual.line(i, cy, i, cy + cy * jzVisual.getAudioBuffer().get(i));
            jzVisual.line(jzVisual.width - i, cy, jzVisual.width - i, cy + cy * jzVisual.getAudioBuffer().get(i));
        }
    }
}
