package Jz;

public class BigCircle implements Renderable {
    JzVisual jzVisual;

    public BigCircle(JzVisual jzVisual) {
        this.jzVisual = jzVisual;
    }

    @Override
    public void render() {
        float cx = jzVisual.width / 2;
        float cy = jzVisual.height / 2;

        int len = jzVisual.getAudioBuffer().size();
        jzVisual.stroke(255);
        jzVisual.noFill();
        jzVisual.strokeWeight(5);
        float sum = 0;
        for (int i = 0; i < len; i++) {
            if (i % 64 != 0) continue;
            float cur = jzVisual.getAudioBuffer().get(i);
            sum += cur;
        }
        jzVisual.circle(cx, cy, (float) (800 * (1 + sum / len * 64 * 0.4)));
    }
}
