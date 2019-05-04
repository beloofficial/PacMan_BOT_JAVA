import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
public class Bot_Game extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private Map map;
    private Myplayer player;
    BOT bot;
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, InterruptedException {
        map = new Map("E:\\MY\\DUISEBEKOV_PROJECT\\src\\map0.txt");
        player = new Myplayer(map);
        FOOD food = new FOOD(map,player);
        //FOOD1 food = new FOOD1(map,player);
        Scene scene = new Scene(map,385,385);
        scene.getStylesheets().add("map.css");
        primaryStage.setScene(scene);
        primaryStage.show();

        map.requestFocus();
    }
}
