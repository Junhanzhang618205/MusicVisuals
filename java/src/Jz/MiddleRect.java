package Jz;

public class MiddleRect implements Renderable {
    JzVisual jzVisual;

    public MiddleRect(JzVisual jzVisual) {
        this.jzVisual = jzVisual;
    }

    @Override
    public void render() {
        float cx = jzVisual.width / 2;
        float cy = jzVisual.height / 2;
        float gap = 300 / (float) jzVisual.getBands().length;
        jzVisual.noStroke();
        for (int i = 0; i < jzVisual.getBands().length; i++) {
//            rfVisual.fill(PApplet.map(i, 0, rfVisual.getBands().length, 255, 0), 255, 255);
            jzVisual.fill(255);
            jzVisual.rect(cx + i * gap - 150, cy+50, gap / 2, -jzVisual.getSmoothedBands()[i] * 0.2f);
        }
    }
}
