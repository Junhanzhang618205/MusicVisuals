package RF;

public class BigCircle implements Randerable {
    RfVisual rfVisual;

    public BigCircle(RfVisual rfVisual) {
        this.rfVisual = rfVisual;
    }

    @Override
    public void rander() {
        float cx = rfVisual.width / 2;
        float cy = rfVisual.height / 2;

        int len = rfVisual.getAudioBuffer().size();
        rfVisual.stroke(255);
        rfVisual.noFill();
        rfVisual.strokeWeight(5);
        float sum = 0;
        for (int i = 0; i < len; i++) {
            if (i % 64 != 0) continue;
            float cur = rfVisual.getAudioBuffer().get(i);
            sum += cur;
        }
        rfVisual.circle(cx, cy, (float) (800 * (1 + sum / len * 64 * 0.4)));
    }
}
