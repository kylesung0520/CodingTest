/* 백준 13549
   그래프, BFS, 최단경로
*/
package Oct;

import java.util.*;
import java.io.*;

class Pos{
    int x;
    int t;
    public Pos(int x, int t){
        this.x = x;
        this.t = t;
    }
}

public class Oct17_Q2 {
    static boolean[] visited = new boolean[100001];
    static int answer = Integer.MAX_VALUE, start, end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(answer);
    }

    static void bfs(){
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(start, 0));

        while(!q.isEmpty()){
            Pos now = q.poll();
            int currX = now.x;
            int currT = now.t;
            visited[currX] = true;
            answer = currX == end ? Math.min(currT, answer) : answer;

            if(currX-1 >= 0 && !visited[currX-1]){
                q.offer(new Pos(currX-1, currT+1));
            }
            if(currX+1 < visited.length && !visited[currX+1]){
                q.offer(new Pos(currX+1, currT+1));
            }
            if(currX*2 < visited.length && !visited[currX*2]){
                q.offer(new Pos(currX*2, currT));
            }
        }
    }
}