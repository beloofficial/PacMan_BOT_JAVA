import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Belo {

    private int n; //количество вершин в орграфе
    private int m; //количество дуг в орграфе
    private ArrayList adj[]; //список смежности
    private boolean used[]; //массив для хранения информации о пройденных и не пройденных вершинах
    private Queue queue; //очередь для добавления вершин при обходе в ширину

    private BufferedReader cin;
    private PrintWriter cout;
    private StringTokenizer tokenizer;

    private void bfs(int v) {
        if (used[v]) {
            return;
        }
        queue.add(v);
        used[v] = true;
        while (!queue.isEmpty()) {
            v = (int) queue.poll();
            cout.print((v + 1) + " ");
            for (int i = 0; i < adj[v].size(); ++i) { int w = (int) adj[v].get(i);
                if (used[w]) { continue; } queue.add(w);
                used[w] = true;  } }

    }


                private void readData() throws IOException
                {
                    cin = new BufferedReader(new InputStreamReader(System.in));
                    cout = new PrintWriter(System.out);
                    tokenizer = new StringTokenizer(cin.readLine());
                    n = Integer.parseInt(tokenizer.nextToken());
                    m = Integer.parseInt(tokenizer.nextToken());
                    adj = new ArrayList[n];
                    for (int i = 0; i < n; ++i) {
                        adj[i] = new ArrayList();
            }

            for (int i = 0; i < m; ++i) {
                        tokenizer = new StringTokenizer(cin.readLine());
                        int v = Integer.parseInt(tokenizer.nextToken());
                        int w = Integer.parseInt(tokenizer.nextToken());
                        v--; w--;
                        adj[v].add(w);
                        adj[w].add(v);
                    }
                    used = new boolean[n];
                    Arrays.fill(used, false);
                    queue = new LinkedList();
        }

        private void run() throws IOException {
            readData();
            for (int v = 0; v < n; ++v)
            {
                bfs(v);
            }
            cin.close();
            cout.close();
    }
    public static void main(String[] args) throws IOException
    {
        Belo solution = new Belo();
        solution.run();
    }
}