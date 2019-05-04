
import java.io.FileNotFoundException;
import java.util.Random;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class FOOD {
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
    public FOOD(Map var1, Player var2) {
        this.map = var1;
        this.foodPane = new Pane();
        this.map.getChildren().add(this.foodPane);
        this.player = var2;
        this.size = this.map.getSz();
        this.cells = this.map.getMap();
        Thread var3 = new Thread(() -> {
            while(this.numOfCircles > 0) {
                this.createFood();
                Platform.runLater(() -> {
                    this.foodPane.getChildren().addAll(new Node[]{this.circle, this.seconds});

                });

                for(this.time = 5; this.time > 0; --this.time) {
                    Platform.runLater(() -> {
                        this.seconds.setText("" + this.time);
                    });
                    if (this.player.getPosition().equals(this.foodPosition)) {
                        this.points += this.time;
                        break;
                    }

                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException va) {
                        ;
                    }
                }

                try {
                    Thread.sleep(10L);
                } catch (InterruptedException var) {
                    ;
                }

                Platform.runLater(() -> {
                    this.foodPane.getChildren().clear();
                });
                --this.numOfCircles;
            }

            System.out.println(this.getPoints());
        });
        var3.start();

    }

    public int getPoints() {
        return this.points;
    }

    private void createFood() {
        Random var1 = new Random();
        double var4 = 42;

        int var2;
        int var3;
        do {
            do {
                var2 = var1.nextInt(this.size);
                var3 = var1.nextInt(this.size);
            } while(this.player.getPosition().equals(new Position(var3, var2)));
        } while(this.map.getMap()[var3][var2] == 1);
        this.circle = new Circle((double)var2 * 42 + 46, (double)var3 * 42 + 46, var4 / 4.0D);
        this.circle.setFill(Color.GREEN);
        this.foodPosition = new Position(var3, var2);
        this.seconds = new Label("5");
        this.seconds.setTranslateX((double)var2 * var4+30);
        this.seconds.setTranslateY((double)var3 * var4+30);
        try {
            try {
               Runnable bot = new BOT((Myplayer) this.player,this.foodPosition,map);
               Thread th = new Thread(bot);
               th.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Position getFoodPosition(){
        return this.foodPosition;
    }
}
