import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Board {

    VBox checker = new VBox();


    Rectangle[][] checketTab = new Rectangle[8][8];
    Circle[][] piecesTab = new Circle[8][8];


    public void draw() {

        for (int l = 0; l < checketTab.length; l++) {
                HBox level = new HBox();
            for (int c = 0; c < checketTab.length; c++) {
                Pane pane = new Pane();
                checketTab[c][l] = new Rectangle(50, 50);
                piecesTab[c][l] = new Circle(25, 25, 16);
                piecesTab[c][l].setFill(Color.WHITE);

                pane.getChildren().addAll(checketTab[c][l], piecesTab[c][l]);
                level.getChildren().add(pane);

                if (l % 2 == 0) {
                    if (c % 2 == 0) {
                        checketTab[c][l].setFill(Color.WHITE);
                        piecesTab[c][l].setFill(Color.BLACK);
                    }

                } else if (c % 2 != 0) {
                    checketTab[c][l].setFill(Color.WHITE);
                    piecesTab[c][l].setFill(Color.BLACK);
                }
            }
           checker.getChildren().add(level);
        }
    }


    public void drawStartPosition(){
        for (int c=0; c < piecesTab.length; c++ ) {
            piecesTab[c][3].setVisible(false);
            piecesTab[c][4].setVisible(false);
            for (int l = 0; l < piecesTab.length; l++) {
                if (l%2 == 0) {
                    if (c%2 == 0) {
                        piecesTab[c][l].setVisible(false);
                    }
                } else if (c%2 != 0) {
                    piecesTab[c][l].setVisible(false);
                }
            }
            for (int i = 0; i < 3; i++) {
                piecesTab[c][i].setFill(Color.GRAY);
            }
        }
//      Piece piece1 = new Piece();
//      piece1.drawP1();
    }

}
