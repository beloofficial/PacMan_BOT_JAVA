import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Math.min;

public class BOT implements Runnable{
    Myplayer player;
    Position food;
    int n;
    Map map;
    int[][] d;
    int[][] a;
    BOT(Myplayer myplayer,Position food,Map map1) throws FileNotFoundException, InterruptedException {
        this.player = myplayer;
        this.food = food;
        map = map1;
        n = map.getSz();
        d = map.getMap();
        a = new int[n*n][4];
        for(int i = 0;i<n*n;i++)
        {
            for(int j = 0;j<4;j++)
            {
                a[i][j] = -21;
            }
        }
        for(int i = 0;i< n;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(d[i][j] != 1)
                {
                    if(j!=0)
                    { if(d[i][j-1]==0)
                            a[i*n+j][0] = i*n+j-1;}
                    else if(j==0)
                    { if(d[i][n-1]==0)
                                a[i*n+j][0] = i*n+n-1;}
                    if(i!=0)
                    {if(d[i-1][j]==0)
                            a[i*n+j][1] = (i-1)*n+j;}
                    else if(i==0)
                    {if(d[n-1][j]==0)
                                a[i*n+j][1] = n*(n-1)+j;}
                    if(j!=n-1)
                    {if(d[i][j+1]==0)
                            a[i*n+j][2] = i*n+j+1;}
                    else if(j==n-1)
                    {if(d[i][0]==0)
                            a[i*n+j][2] = i*n;}

                    if(i!=n-1)
                    {if(d[i+1][j]==0)
                            a[i*n+j][3] = (i+1)*n+j;}
                    else if(i==n-1)
                    {if(d[0][j]==0)
                            a[i*n+j][3] = i*0+j;}
                }
            }
        }

    }

    @Override
    public void run() {
        int s = this.player.getPosition().getX()*n+this.player.getPosition().getY();
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        boolean[] used = new boolean[n*n];
        int[] d1 = new int[n*n];
        int[] p = new int[n*n];
        used[s] = true;
        p[s] = -1;
        while (!q.isEmpty())
        {
            int v = q.peek();
            q.remove();
            for(int i = 0;i<4;i++)
            {
                int to = a[v][i];
                if(to!=-21)
                    if(!used[to])
                    {
                        used[to] = true;
                        q.add(to);
                        d1[to] = d1[v] + 1;
                        p[to] = v;
                    }
            }
        }

        int x,y;
        {
            int to = this.food.getX() * n + this.food.getY();
            if (!used[to])
                System.out.println("NO PATH");
            else {

                int[] path = new int[n * n];
                int sz = 0;
                for (int v = to; v != -1; v = p[v]) {
                    path[sz] = v;
                    sz++;
                }
                //System.out.print("PATH :");
                for (int i = sz-1; i >= 0; i--)
                {
                    //System.out.print(path[i]+" ");
                    x = path[i]/n;
                    y = path[i]%n;
                    player.getBall().setCenterY(x*42+46);
                    player.getBall().setCenterX(y*42+46);
                    player.getPosition().setX(x);
                    player.getPosition().setY(y);
                    try {
                        Thread.sleep(350);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}
