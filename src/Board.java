import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Board {

    VBox checker = new VBox();
    Rectangle[][] tab = new Rectangle[8][8];


    public void draw() {

        for (int m = 0; m < tab.length; m++) {
            HBox level = new HBox();
            for (int i = 0; i < tab.length; i++) {
                tab[i][m] = new Rectangle(50, 50);
                level.getChildren().add(tab[i][m]);
                if (m % 2 == 0) {
                    if (i % 2 == 0) tab[i][m].setFill(Color.WHITE);
                } else if (i % 2 != 0) tab[i][m].setFill(Color.WHITE);
            }
            checker.getChildren().add(level);
        }
    }


    public void drawPiece(){
        Piece piece1 = new Piece();
        piece1.drawP1();
        checker.getChildren().add(piece1.hbPiece);

        Piece piece2 = new Piece();
        piece2.drawP2();
        checker.getChildren().add(piece2.hbPiece);

    }

}
