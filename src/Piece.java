import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Piece {

    HBox hbPiece = new HBox();
    Circle circle = new Circle();

    public void drawP1() {
        circle = new Circle(25);
        circle.setFill(Color.BLACK);
        hbPiece.getChildren().add(circle);
    }

    public void drawP2() {
        circle = new Circle(25);
        circle.setFill(Color.RED);
        hbPiece.getChildren().add(circle);
    }
}
