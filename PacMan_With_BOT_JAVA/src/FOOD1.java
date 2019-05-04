import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.FileNotFoundException;
import java.util.Random;

public class FOOD1 {
    private Map map;
    private Pane foodPane;
    private Player player;
    private Circle circle;
    private Position foodPosition;
    private Label seconds;
    private final int timer = 5;
    private int numOfCircles = 10;
    private int time;
    private int points;
    private int size;
    private int[][] cells;
    private BOT bot;
    public FOOD1(Map var1, Player var2) {
        this.map = var1;
        this.foodPane = new Pane();
        this.map.getChildren().add(this.foodPane);
        this.player = var2;
        this.size = this.map.getSz();
        int x;
        int y;
        do {
            x = (int) (Math.random() * this.size);
            y = (int) (Math.random() * this.size);
        }while (this.player.getPosition().equals(new Position(x, y)));
        this.circle = new Circle(x * 42 + 46, y * 42 + 46, 10);
        this.circle.setFill(Color.GREEN);
        this.foodPane.getChildren().add(this.circle);
        this.foodPosition = new Position(y, x);
    }
    public Position getFoodPosition(){
        return this.foodPosition;
    }
}
