# Music Visualiser Project

Name: Junhan Zhang

Student Number:  D20126150

## Instructions
- Required: Java 11
- Fork this repository.
- Enter the package [java](https://github.com/0ceanstar/MusicVisuals/tree/master/java).
- Run the shell [MyRun.sh](https://github.com/0ceanstar/MusicVisuals/blob/master/java/run.sh).
- ==Note: I run this program in Ubuntu, if you can not run, try other shells in the same path.==

# Description of the assignment

I made a program which will response to the music. The entities in the view will change their size, color or place by the music or the time. In addition to OOP programming ideas, I use some other ideas like the AOP programming, though what I use is very simple and basic. The knowledge or idea that I used is listed below:

- Object Oriented Programming: This is basic idea.  Giving different classes the different action so that they can not interfere each other. 
- Aspect-Oriented Programming: I use this to define the entities in the view. With this method, I only need to care about the action that I want to do when I write the entities' class. 
- java.Thread: I use this to count the time that have been passed since the game is begin. ("space" is pressed)
- processing.core: The main tool to show the GUI and render the view.

# How it works

The main idea of my program is to create 3 different views that will be displayed one by one over time, and I set the changing time is 30s, which means that the view will change every 30 seconds. Just like the code below:

```java
int time = (int) (runTime.getTime() / 1000);
if (time <= 30) {
    ...
} else if (time <= 60) {
    ...
} else {
    ...
}
```

So what I need to do is to add entities in each view. I used the knowledge that I have learned in the class, and I also add some other interesting entities that I found by accident. you can see the code like this:

```java
@Override
public void setup() {
    startMinim();
    loadAudio("MyMusic.mp3");

    view1.add(new BottomRect(this));
    view1.add(new Line(this, runTime));
    view1.add(new BigCircle(this));

    view2.add(new MiddleCircle(this));
    view2.add(new Wave(this, runTime));
    view2.add(new star(this, runTime));

    view3.add(new MiddleRect(this));
    view3.add(new VerticalWave(this));
    view3.add(new RoundRect(this, runTime));

}
```

# What I am most proud of in the assignment

## Time Thread

I used *java.Thread* to remark the current time. To do that, I create a class named `RunTime ` that extents the `Thread`, and I override the `run()` so that I can update the `time` every 50 millis, this thread is totally independent to the main thread. 

```java
@Override
public void run() {
    while (true) {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        endTime = System.currentTimeMillis();
        time = endTime - startTime;
    }
}
```

A detail here is that when I press the space, I need to reset the `RunTime ` so that it can count again from zero.

```java
@Override
public void keyPressed() {
    if (key == ' ') {
        getAudioPlayer().cue(0);
        getAudioPlayer().play();
        if (runTime.isAlive()) {
            runTime.init();
        } else {
            runTime.start();
        }
    }
}
```

## Interface `Renderable`

I noticed that every entities in the view need to write this function `render` . So I create a interface called `Renderable`, with this interface, I can create entities that implements the interface, and I can focus on the function `render` . When I need to use the function, I can use the `List<Renderable>` . And I think it embodies the thinking of AOP. 

```java
List<Renderable> view1 = new ArrayList<>();
//...
for (Renderable randerable : view1) {
    randerable.render();
}
```

##  RoundRect

I think this is my best class in the program. In this class, I created 90 rectangles that would rotate around a circle over the time, and they will also change their height by the audio.

```java
@Override
public void render() {
    float cx = rfVisual.width / 2;
    float cy = rfVisual.height / 2;
    rfVisual.translate(cx, cy);
    rfVisual.rectMode(CORNER);
    rfVisual.rotate(radians((float) runTime.getTime() / 100));
    int num = 90;
    for (int i = 0; i < 360; i++) {
        if (i % (360 / num) != 0) continue;
        float cur = rfVisual.getAudioBuffer().get(i);
        float radius = 200F;
        float degree = PI * (i);
        float width = ((2 * PI * radius) / num) / 2;
        float height = 5 + 100 * abs(cur);
        rfVisual.fill(
            PApplet.map(i, 0, 360, 0, 255)
            , 100
            , 150
        );
        rfVisual.rotate(radians((360 / num)));
        rfVisual.rect(radius * sin(degree)
                      , radius * cos(degree)
                      , width
                      , height);
    }

}
```



