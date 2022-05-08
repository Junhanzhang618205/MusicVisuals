package RF;

import processing.core.PApplet;

import static processing.core.PApplet.radians;

public class RoundRect implements Randerable {
    RfVisual rfVisual;
    RunTime runTime;

    public RoundRect(RfVisual rfVisual, RunTime runTime) {
        this.rfVisual = rfVisual;
        this.runTime = runTime;
    }

    @Override
    public void rander() {
        int len = rfVisual.getAudioBuffer().size();
        int cx = rfVisual.width/2;
        int cy = rfVisual.height/2;

        for (int i = 0; i < 360; i++) {
            if(i%4!=0)continue;
            float cur = rfVisual.getAudioBuffer().get(i);
            float radius = 200F;



        }

    }
}
