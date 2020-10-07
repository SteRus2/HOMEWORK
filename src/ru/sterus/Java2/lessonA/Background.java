package ru.sterus.Java2.lessonA;

import java.awt.*;

public class Background {

    Color color;
    float timeForBackground = 1000;

    public Background(GameCanvas canvas){

                color = new Color(
                        (int) (Math.random() * 255),
                        (int) (Math.random() * 255),
                        (int) (Math.random() * 255)
                );
                canvas.setBackground(color);
    }


}

