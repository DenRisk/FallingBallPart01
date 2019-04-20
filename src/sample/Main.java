package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;



public class Main extends Application {

    private static Circle circle;
    AnimationTimer animationTimer;
    MoveEngine moveEngine;
    boolean living = true;
    public static int startVx = 500;
    public static int startVy = 0;

//    private final long[] frameTimes = new long[100];
//    private int frameTimeIndex = 0 ;
//    private boolean arrayFilled = false ;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane root = new Pane();
        primaryStage.setTitle("Timline");
        primaryStage.setScene(new Scene(root, 800, 700));

        circle = new Circle(30, Color.VIOLET);

        root.getChildren().add(circle);



        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (living == true) {
                    circle.setCenterX(Koordinaten.getStartX());
                    circle.setCenterY(Koordinaten.getStartY());
                    new MoveEngine();

                }
            }
        };
        animationTimer.start();



        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
