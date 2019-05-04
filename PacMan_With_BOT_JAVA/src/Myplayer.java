import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Myplayer implements Player {
    private Map map1;
    private Position position;
    private Circle ball;
    Myplayer(Map map){
        this.map1=map;
        ball = new Circle(19);
        position = getPosition();
        ball.setFill(Color.RED);
        int x = position.getX()*42+46;
        int y = position.getY()*42+46;
        ball.setCenterX(y);
        ball.setCenterY(x);
        this.map1.getChildren().add(ball);
    }
    public Circle getBall(){
        return this.ball;
    }
    @Override
    public void moveRight() {
        position = getPosition();
        int x = position.getX();
        int y = position.getY();
        int[][] a = map1.getMap();
        if(y+1<map1.getSz())
        {
            if(a[x][y+1]!=1)
            {
                map1.getStartPosition().setY(y+1);
                ball.setCenterX((y+1)*42+46);
            }
        }
        if(y+1==map1.getSz())
        {
            if(a[x][0]!=1)
            {
                map1.getStartPosition().setY(0);
                ball.setCenterX(46);
            }
        }
    }

    @Override
    public void moveLeft() {
        position = getPosition();
        int x = position.getX();
        int y = position.getY();
        int[][] a = map1.getMap();
        if(y-1>=0)
        {
            if(a[x][y-1]!=1)
            {
                map1.getStartPosition().setY(y-1);
                ball.setCenterX((y-1)*42+46);
            }
        }

        if(y-1==-1)
        {
            if(a[x][map1.getSz()-1]!=1)
            {
                map1.getStartPosition().setY(map1.getSz()-1);
                ball.setCenterX((map1.getSz()-1)*42+46);
            }
        }
    }
    @Override
    public void moveDown() {
        position = getPosition();
        int x = position.getX();
        int y = position.getY();
        int[][] a = map1.getMap();
        if(x+1<map1.getSz())
        {
            if(a[x+1][y]!=1)
            {
                map1.getStartPosition().setX(x+1);
                ball.setCenterY((x+1)*42+46);
            }
        }
        if(x+1==map1.getSz())
        {
            if(a[0][y]!=1)
            {
                map1.getStartPosition().setX(0);
                ball.setCenterY(46);
            }
        }
    }

    @Override
    public void moveUp() {
        position = getPosition();
        int x = position.getX();
        int y = position.getY();
        int[][] a = map1.getMap();
        if(x-1>=0)
        {
            if(a[x-1][y]!=1)
            {
                map1.getStartPosition().setX(x-1);
                ball.setCenterY((x-1)*42+46);
            }
        }
        if(x-1==-1)
        {
            if(a[0][map1.getSz()-1]!=1)
            {
                map1.getStartPosition().setX(map1.getSz()-1);
                ball.setCenterY((map1.getSz()-1)*42+46);
            }
        }
    }

   @Override
    public Position getPosition() {
        return this.map1.getStartPosition();
    }
}