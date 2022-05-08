package Jz;

public class BottomRect implements Renderable {
    JzVisual jzVisual;

    public BottomRect(JzVisual jzVisual) {
        this.jzVisual = jzVisual;
    }

    @Override
    public void render() {
        float gap = jzVisual.width / (float) jzVisual.getBands().length;
        jzVisual.noStroke();
        for (int i = 0; i < jzVisual.getBands().length; i++) {
//            rfVisual.fill(PApplet.map(i, 0, rfVisual.getBands().length, 255, 0), 255, 255);
            jzVisual.fill(255);
            jzVisual.rect(i * gap, jzVisual.height, gap/2,-jzVisual.getSmoothedBands()[i] * 0.2f);
        }
    }
}
