import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Board {

    VBox checker = new VBox();


    Rectangle[][] tab = new Rectangle[8][8];
    Circle[][] tab2 = new Circle[8][8];


    public void draw() {

        for (int l = 0; l < tab.length; l++) {
                HBox level = new HBox();
            for (int c = 0; c < tab.length; c++) {
                Pane pane = new Pane();
                tab[c][l] = new Rectangle(50, 50);
                tab2[c][l] = new Circle(25, 25, 16);
                tab2[c][l].setFill(Color.WHITE);

                pane.getChildren().addAll(tab[c][l], tab2[c][l]);
                level.getChildren().add(pane);

                if (l % 2 == 0) {
                    if (c % 2 == 0) {
                        tab[c][l].setFill(Color.WHITE);
                        tab2[c][l].setFill(Color.BLACK);
                    }

                } else if (c % 2 != 0) {
                    tab[c][l].setFill(Color.WHITE);
                    tab2[c][l].setFill(Color.BLACK);
                }
            }
           checker.getChildren().add(level);
        }
    }


    public void drawPiece(){
//        Piece piece1 = new Piece();
//        piece1.drawP1();
//        checker.getChildren().add(piece1.hbPiece);
//

    }

}
