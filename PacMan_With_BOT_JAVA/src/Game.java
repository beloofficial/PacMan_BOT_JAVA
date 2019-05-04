import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
public class Game extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private Map map;
    private Myplayer player;
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        map = new Map("E:\\MY\\DUISEBEKOV_PROJECT\\src\\map0.txt");
        player = new Myplayer(map);
        FOOD food = new FOOD(map,player);
        map.setOnKeyPressed(e -> {
            switch(e.getCode()){
                case RIGHT: player.moveRight();break;
                case LEFT: player.moveLeft();break;
                case UP: player.moveUp();break;
                case DOWN:player.moveDown();break;
            }});
        Scene scene = new Scene(map,385,385);
        scene.getStylesheets().add("map.css");
        primaryStage.setScene(scene);
        primaryStage.show();
        map.requestFocus();
    }
}
