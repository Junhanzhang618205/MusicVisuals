package RF;

public class MiddleRect implements Renderable {
    RfVisual rfVisual;

    public MiddleRect(RfVisual rfVisual) {
        this.rfVisual = rfVisual;
    }

    @Override
    public void render() {
        float cx = rfVisual.width / 2;
        float cy = rfVisual.height / 2;
        float gap = 300 / (float) rfVisual.getBands().length;
        rfVisual.noStroke();
        for (int i = 0; i < rfVisual.getBands().length; i++) {
//            rfVisual.fill(PApplet.map(i, 0, rfVisual.getBands().length, 255, 0), 255, 255);
            rfVisual.fill(255);
            rfVisual.rect(cx + i * gap - 150, cy+50, gap / 2, -rfVisual.getSmoothedBands()[i] * 0.2f);
        }
    }
}
