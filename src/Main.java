import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    int countUp = 0;
    int CountDown = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {

       primaryStage.setTitle("Checkers");

       Board board = new Board();
       board.draw();

       primaryStage.setScene(new Scene(board.checker, 400, 400));
       primaryStage.setMinHeight(200);
       primaryStage.setMinWidth(200);
       primaryStage.setMaxHeight(600);
       primaryStage.setMaxWidth(600);

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
                                    if(board.piecesTab[finalC][finalL].getFill()==Color.GRAY) {
                                        board.piecesTab[finalC + 1][finalL + 1].setFill(Color.GRAY);
                                    } else board.piecesTab[finalC + 1][finalL + 1].setFill(Color.RED);
                                    board.piecesTab[finalC][finalL].setVisible(false);
                                    board.piecesTab[finalC +1][finalL +1].setVisible(true);
                                    primaryStage.show();
                                }
                            });
                            //movement of beating a pawn
                            if (finalC<6 & finalL<6) {
                                board.checketTab[finalC + 2][finalL + 2].setOnMouseClicked(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        if(board.piecesTab[finalC][finalL].getFill()==Color.GRAY) {
                                            board.piecesTab[finalC + 2][finalL + 2].setFill(Color.GRAY);
                                        } else board.piecesTab[finalC + 2][finalL + 2].setFill(Color.RED);
                                        board.piecesTab[finalC][finalL].setVisible(false);
                                        board.piecesTab[finalC + 1][finalL + 1].setVisible(false);
                                        board.piecesTab[finalC + 2][finalL + 2].setVisible(true);
                                        primaryStage.show();
                                        CountDown++;
                                        System.out.println("Gray score: " + CountDown);
                                    }
                                });
                            }
                        }

                        if (finalC>0 & finalL<7) {

                            board.checketTab[finalC -1][finalL +1].setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    if(board.piecesTab[finalC][finalL].getFill()==Color.GRAY) {
                                        board.piecesTab[finalC - 1][finalL + 1].setFill(Color.GRAY);
                                    } else board.piecesTab[finalC - 1][finalL + 1].setFill(Color.RED);
                                    board.piecesTab[finalC][finalL].setVisible(false);
                                    board.piecesTab[finalC -1][finalL +1].setVisible(true);
                                    primaryStage.show();
                                }
                            });
                           // movement of beating a pawn
                            if (finalC>1 & finalL<6) {
                                board.checketTab[finalC - 2][finalL + 2].setOnMouseClicked(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        if(board.piecesTab[finalC][finalL].getFill()==Color.GRAY) {
                                            board.piecesTab[finalC - 2][finalL + 2].setFill(Color.GRAY);
                                        } else board.piecesTab[finalC - 2][finalL + 2].setFill(Color.RED);
                                        board.piecesTab[finalC][finalL].setVisible(false);
                                        board.piecesTab[finalC - 1][finalL + 1].setVisible(false);
                                        board.piecesTab[finalC - 2][finalL + 2].setVisible(true);
                                        primaryStage.show();
                                        CountDown++;
                                        System.out.println("Gray score: " + CountDown);
                                    }
                                });
                            }
                        }

                        // left and right up
                        if (finalC<7 & finalL>0) {

                            board.checketTab[finalC +1][finalL -1].setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    if(board.piecesTab[finalC][finalL].getFill()==Color.RED) {
                                        board.piecesTab[finalC + 1][finalL - 1].setFill(Color.RED);
                                    } else board.piecesTab[finalC + 1][finalL - 1].setFill(Color.GRAY);
                                    board.piecesTab[finalC][finalL].setVisible(false);
                                    board.piecesTab[finalC +1][finalL -1].setVisible(true);
                                    primaryStage.show();
                                }
                            });
                            // movement of beating a pawn
                            if (finalC<6 & finalL>1) {
                                board.checketTab[finalC + 2][finalL - 2].setOnMouseClicked(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        if(board.piecesTab[finalC][finalL].getFill()==Color.RED) {
                                            board.piecesTab[finalC + 2][finalL - 2].setFill(Color.RED);
                                        } else board.piecesTab[finalC + 2][finalL - 2].setFill(Color.GRAY);
                                        board.piecesTab[finalC][finalL].setVisible(false);
                                        board.piecesTab[finalC + 1][finalL - 1].setVisible(false);
                                        board.piecesTab[finalC + 2][finalL - 2].setVisible(true);
                                        primaryStage.show();
                                        countUp++;
                                        System.out.println("Red score: " + countUp);
                                    }
                                });
                            }
                        }

                        if (finalC>0 & finalL>0) {

                            board.checketTab[finalC -1][finalL -1].setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    if(board.piecesTab[finalC][finalL].getFill()==Color.RED) {
                                        board.piecesTab[finalC - 1][finalL - 1].setFill(Color.RED);
                                    } else board.piecesTab[finalC - 1][finalL - 1].setFill(Color.GRAY);
                                    board.piecesTab[finalC][finalL].setVisible(false);
                                    board.piecesTab[finalC -1][finalL -1].setVisible(true);
                                    primaryStage.show();
                                }
                            });
                            // movement of beating a pawn
                            if (finalC>1 & finalL>1) {
                                board.checketTab[finalC - 2][finalL - 2].setOnMouseClicked(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        if(board.piecesTab[finalC][finalL].getFill()==Color.RED) {
                                            board.piecesTab[finalC - 2][finalL - 2].setFill(Color.RED);
                                        } else board.piecesTab[finalC - 2][finalL - 2].setFill(Color.GRAY);
                                        board.piecesTab[finalC][finalL].setVisible(false);
                                        board.piecesTab[finalC - 1][finalL - 1].setVisible(false);
                                        board.piecesTab[finalC - 2][finalL - 2].setVisible(true);
                                        primaryStage.show();
                                        countUp++;
                                        System.out.println("Red score: " + countUp);
                                    }
                                });
                            }
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
