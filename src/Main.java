import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;


public class Main extends Application {


int i = 1;
int k = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {

       primaryStage.setTitle("Checkers");

       Board board = new Board();
       board.draw();

       primaryStage.setScene(new Scene(board.checker, 400, 400));
       primaryStage.setMinHeight(256);
       primaryStage.setMinWidth(256);
       primaryStage.setMaxHeight(640);
       primaryStage.setMaxWidth(640);

       board.drawStartPosition();
       primaryStage.show();

        ChangeListener<Number> stageSizeListener = (observable, oldValue, newValue) -> {
            double oldV = oldValue.doubleValue();
            double newV = newValue.doubleValue();

            if (!Double.isNaN(oldV)) {
                double substract = (newV-oldV)/8;
                    if (oldValue.intValue() < newValue.intValue()) {
                            for (int m = 0; m < board.checketTab.length; m++) {
                                for (int i = 0; i < board.checketTab.length; i++) {
                                    board.checketTab[i][m].setWidth(board.checketTab[i][m].getWidth()+ substract);
                                    board.piecesTab[i][m].setRadius(board.piecesTab[i][m].getRadius() + substract/8);
                                    board.piecesTab[i][m].setCenterX(board.checketTab[i][m].getWidth()/2);
                                    board.piecesTab[i][m].setCenterY(board.checketTab[i][m].getHeight()/2);
                                }
                            }
                        } else {
                            for (int m = 0; m < board.checketTab.length; m++) {
                                for (int i = 0; i < board.checketTab.length; i++) {
                                    board.checketTab[i][m].setWidth(board.checketTab[i][m].getWidth() + substract);
                                    board.piecesTab[i][m].setRadius(board.piecesTab[i][m].getRadius() + substract/8);
                                    board.piecesTab[i][m].setCenterX(board.checketTab[i][m].getWidth()/2);
                                    board.piecesTab[i][m].setCenterY(board.checketTab[i][m].getHeight()/2);
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
                    for (int m = 0; m < board.checketTab.length; m++) {
                        for (int i = 0; i < board.checketTab.length; i++) {
                            board.checketTab[i][m].setHeight(board.checketTab[i][m].getHeight() + substract);
                            board.piecesTab[i][m].setRadius(board.piecesTab[i][m].getRadius() + substract/8);
                            board.piecesTab[i][m].setCenterX(board.checketTab[i][m].getWidth()/2);
                            board.piecesTab[i][m].setCenterY(board.checketTab[i][m].getHeight()/2);
                        }
                    }
                } else {
                    for (int m = 0; m < board.checketTab.length; m++) {
                        for (int i = 0; i < board.checketTab.length; i++) {
                            board.checketTab[i][m].setHeight(board.checketTab[i][m].getHeight() + substract);
                            board.piecesTab[i][m].setRadius(board.piecesTab[i][m].getRadius() + substract/8);
                            board.piecesTab[i][m].setCenterX(board.checketTab[i][m].getWidth()/2);
                            board.piecesTab[i][m].setCenterY(board.checketTab[i][m].getHeight()/2);
                        }
                    }
                }
            }
        };

        primaryStage.widthProperty().addListener(stageSizeListener);
        primaryStage.heightProperty().addListener(stageSizeListener2);

        for (int c=0; c < board.piecesTab.length; c++) {
            for (int l = 0; l < board.piecesTab.length; l++) {

                int finalC = c;
                int finalL = l;

                board.piecesTab[c][l].setOnMouseClicked(new EventHandler<MouseEvent>() {

                    // left and right down
                    @Override
                    public void handle(MouseEvent event) {


                        if (finalC<7 & finalL<7) {
                            board.checketTab[finalC +1][finalL +1].setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    board.piecesTab[finalC][finalL].setVisible(false);
                                    board.piecesTab[finalC +1][finalL +1].setVisible(true);
                                    //if(board.piecesTab[finalC][finalL].getFill)
                                }
                            });
                        }
                        if (finalC>0 & finalL<7) {
                            board.checketTab[finalC -1][finalL +1].setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    board.piecesTab[finalC][finalL].setVisible(false);
                                    board.piecesTab[finalC -1][finalL +1].setVisible(true);
                                }
                            });
                        }

                        // left and right up
                        if (finalC<7 & finalL>0) {
                            board.checketTab[finalC +1][finalL -1].setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    board.piecesTab[finalC][finalL].setVisible(false);
                                    board.piecesTab[finalC +1][finalL -1].setVisible(true);
                                }
                            });
                        }

                        if (finalC>0 & finalL>0) {
                            board.checketTab[finalC -1][finalL -1].setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    board.piecesTab[finalC][finalL].setVisible(false);
                                    board.piecesTab[finalC -1][finalL -1].setVisible(true);
                                }
                            });
                        }
                    }
                });
            }
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}
