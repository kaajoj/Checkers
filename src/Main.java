import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
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


//        board.checketTab[0][0].setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                if (i == 3) {
//                    board.checketTab[0][0].setFill(Color.BLUE);
//                    i = 1;
//                } else {
//                    if (i == 2) {
//                        //board.checketTab[0][0] = new Rectangle(10,10);
//                        //primaryStage.show();
//                        i = 3;
//                    }
//                    if (i == 1) {
//                        board.checketTab[0][0].setFill(Color.RED);
//                        i = 2;
//                    }
//                }
//            }
//        });


        // szary
        board.piecesTab[7][2].setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                board.checketTab[6][3].setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        board.piecesTab[7][2].setVisible(false);
                        board.piecesTab[6][3].setFill(Color.GRAY);
                        board.piecesTab[6][3].setVisible(true);
                    }
                });

            }
        });






        // biały
        board.piecesTab[0][5].setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                board.checketTab[1][4].setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        board.piecesTab[0][5].setVisible(false);
                        board.piecesTab[1][4].setVisible(true);
                    }
                });

            }
        });

        board.piecesTab[2][5].setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                board.checketTab[3][4].setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        board.piecesTab[2][5].setVisible(false);
                        board.piecesTab[3][4].setVisible(true);
                    }
                });

                board.checketTab[1][4].setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        board.piecesTab[2][5].setVisible(false);
                        board.piecesTab[1][4].setVisible(true);
                    }
                });
            }
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
