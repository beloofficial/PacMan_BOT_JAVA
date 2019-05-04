import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map extends Pane {
    static Position start;
    private int unit;
    private int[][] a;
    static int sz;
    private String txt;
    Map(String txt) throws FileNotFoundException {
        this.txt = txt;
        String txt1 = this.txt;
        unit = 40;
        File file = new File(txt1);
        Scanner output = new Scanner(file);
        String line = output.nextLine();
        sz = Integer.parseInt(line);
        Rectangle shape;
        StackPane pane;

        String[] s;
        a = new int[sz][sz];
        int q;
        for(int i = 0;i<sz;i++)
        {
            line = output.nextLine();
            s = line.split(" ");
            for(int j = 0;j<sz;j++)
            {
                q = Integer.parseInt(s[j]);
                a[i][j] = q;
                if(q == 2)
                {
                    start = new Position(i,j);
                    a[i][j] = 0;
                }
                shape = setBox(q);
                pane = new StackPane();
                pane.getChildren().add(shape);
                    pane.getStyleClass().add("border");
                    pane.getStyleClass().add("fill");
                pane.setLayoutX(j*42+25);
                pane.setLayoutY(i*42+25);
                getChildren().add(pane);
            }
        }
    }

    private Rectangle setBox(int q)
    {
        Rectangle rec = new Rectangle();
        rec.setHeight(40);
        rec.setWidth(40);
        if(q == 0)
        {
            rec.setFill(Color.TRANSPARENT);
            rec.setStroke(Color.TRANSPARENT);
        }
        else if(q == 1)
        {

            rec.setFill(Color.BLACK);
            rec.setStroke(Color.TRANSPARENT);
        }
        else
        {
            rec.setFill(Color.TRANSPARENT);
            rec.setStroke(Color.TRANSPARENT);
        }
        return rec;
    }

    public int getSz()
    {
        return this.sz;
    }
    public int[][] getMap()
    {
        return this.a;
    }
    public Position getStartPosition()
    {
        return this.start;
    }
    public int getUnit(){
        return unit;
    }
}
