package Kty;

public class BottomRect implements Randerable {
    KtyVisual rfVisual;

    public BottomRect(KtyVisual rfVisual) {
        this.rfVisual = rfVisual;
    }

    @Override
    public void rander() {
        float gap = rfVisual.width / (float) rfVisual.getBands().length;
        rfVisual.noStroke();
        for (int i = 0; i < rfVisual.getBands().length; i++) {
//            rfVisual.fill(PApplet.map(i, 0, rfVisual.getBands().length, 255, 0), 255, 255);
            rfVisual.fill(255);
            rfVisual.rect(i * gap, rfVisual.height, gap/2,-rfVisual.getSmoothedBands()[i] * 0.2f);
        }
    }
}
