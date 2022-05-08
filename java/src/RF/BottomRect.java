package RF;

public class BottomRect implements Renderable {
    RfVisual rfVisual;

    public BottomRect(RfVisual rfVisual) {
        this.rfVisual = rfVisual;
    }

    @Override
    public void render() {
        float gap = rfVisual.width / (float) rfVisual.getBands().length;
        rfVisual.noStroke();
        for (int i = 0; i < rfVisual.getBands().length; i++) {
//            rfVisual.fill(PApplet.map(i, 0, rfVisual.getBands().length, 255, 0), 255, 255);
            rfVisual.fill(255);
            rfVisual.rect(i * gap, rfVisual.height, gap/2,-rfVisual.getSmoothedBands()[i] * 0.2f);
        }
    }
}
