import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.awt.*;


public class Main extends Application {


int i = 1;
int k = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {

       primaryStage.setTitle("Checkers");

       Board board = new Board();
       board.draw();

       primaryStage.setScene(new Scene(board.checker, 500, 500));

       board.drawPiece();
       //board.tab[0][0].setVisible(false);
       //board.tab2[2][4].setVisible(false);
       primaryStage.show();

        ChangeListener<Number> stageSizeListener = (observable, oldValue, newValue) -> {
            double oldV = oldValue.doubleValue();
            double newV = newValue.doubleValue();

            if (!Double.isNaN(oldV)) {
                double substract = (newV-oldV)/8;
                    if (oldValue.intValue() < newValue.intValue()) {
                            for (int m = 0; m < board.tab.length; m++) {
                                for (int i = 0; i < board.tab.length; i++) {
                                    board.tab[i][m].setWidth(board.tab[i][m].getWidth()+ substract);
                                }
                            }
                        } else {
                            for (int m = 0; m < board.tab.length; m++) {
                                for (int i = 0; i < board.tab.length; i++) {
                                    board.tab[i][m].setWidth(board.tab[i][m].getWidth() + substract);
                                }
                            }
                    }
            }
        };

        ChangeListener<Number> stageSizeListener2 = (observable, oldValue, newValue) -> {
            double oldV = oldValue.doubleValue();
            double newV = newValue.doubleValue();

            if (!Double.isNaN(oldV)) {
                double substract = (newV-oldV)/8;
                if (oldValue.intValue() < newValue.intValue()) {
                    for (int m = 0; m < board.tab.length; m++) {
                        for (int i = 0; i < board.tab.length; i++) {
                            board.tab[i][m].setHeight(board.tab[i][m].getHeight() + substract);
                        }
                    }
                } else {
                    for (int m = 0; m < board.tab.length; m++) {
                        for (int i = 0; i < board.tab.length; i++) {
                            board.tab[i][m].setHeight(board.tab[i][m].getHeight() + substract);
                        }
                    }
                }
            }
        };

        primaryStage.widthProperty().addListener(stageSizeListener);
        primaryStage.heightProperty().addListener(stageSizeListener2);


//        tab[0][0].setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                if (i == 3) {
//                    tab[0][0].setFill(Color.BLUE);
//                    i = 1;
//                } else {
//                    if (i == 2) {
//                        tab[0][0].setFill(Color.RED);
//                        i = 3;
//                    }
//                    if (i == 1) {
//                        tab[0][0].setFill(Color.WHITE);
//                        i = 2;
//                    }
//                }
//            }
//        });

//        board.tab[0][0].setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                if (i == 3) {
//                    board.tab[0][0].setFill(Color.BLUE);
//                    i = 1;
//                } else {
//                    if (i == 2) {
//                        //board.tab[0][0] = new Rectangle(10,10);
//                        //primaryStage.show();
//                        i = 3;
//                    }
//                    if (i == 1) {
//                        board.tab[0][0].setFill(Color.RED);
//                        i = 2;
//                    }
//                }
//            }
//        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
