package ru.sterus.Java2.lessonA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainCircles extends JFrame {
    private static final int POS_X = 300;
    private static final int POS_Y = 70;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    Sprite[] sprites = new Sprite[10];
    Background background;

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }

    private MainCircles(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        GameCanvas canvas = new GameCanvas(this);
        add(canvas);

        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(0, 30));
        topPanel.setLayout(new GridLayout(1, 2));
        add(topPanel, BorderLayout.NORTH);

        JButton btnNewBall = new JButton("Add ball");
        btnNewBall.setFocusPainted(false);
        topPanel.add(btnNewBall);

        JButton btnDeleteLastBall = new JButton("Delete ball");
        btnDeleteLastBall.setFocusPainted(false);
        topPanel.add(btnDeleteLastBall);

        btnDeleteLastBall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sprites = deleteLastElementInArray(sprites);
            }
        });


        btnNewBall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sprites = addElementToArray(sprites, new Ball());
            }
        });

        initApplication();
        setTitle("Circles");
        setVisible(true);
    }

    private void initApplication(){
        for(int i = 0; i < sprites.length; i++){
            sprites[i] = new Ball();
        }
    }

    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltatime){
        update(canvas, deltatime);
        render(canvas, g);
    }

    private void update(GameCanvas canvas, float deltaTime){
        for(int i = 0; i < sprites.length; i++){
            sprites[i].update(canvas, deltaTime);
        }
    }
    private void render(GameCanvas canvas, Graphics g){
        for(int i = 0; i < sprites.length; i++){
            sprites[i].render(canvas, g);
        }
    }

    public void changeBackgroundColor(GameCanvas canvas){
        background = new Background(canvas);
    }

    Sprite[] addElementToArray(Sprite[] array, Ball item){
        Sprite[] newSprites = new Sprite[array.length + 1];
        for(int i = 0; i < array.length; i++){
            newSprites[i] = array[i];
        }
        newSprites[array.length] = item;
        return newSprites;
    }

    Sprite[] deleteLastElementInArray(Sprite[] array){
        if(array.length <= 0){
            return array;
        }
        Sprite[] newArray = new Sprite[array.length - 1];
        for(int i = 0; i < array.length - 1; i++){
            newArray[i] = array[i];
        }
        return newArray;
    }

}
