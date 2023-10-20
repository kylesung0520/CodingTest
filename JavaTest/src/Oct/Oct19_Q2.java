/* 백준 1189 그래프, 구현 */
package Oct;

import java.util.*;
import java.io.*;

public class Oct19_Q2 {
    static int R, C, K, answer = 0;
    static Character[][] map;
    static int[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new Character[R][C];
        visited = new int[R][C];
        for(int i = 0; i < R; i++){
            String tmp = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = tmp.charAt(j);
            }
        }
        visited[R-1][0] = 1;
        dfs(R-1,0, 1);

        System.out.println(answer);
    }
    static void dfs(int x, int y, int cnt){
        if(x == 0 && y == C-1){
            if(cnt == K){
                answer += 1;
            }
            return;
        }
        for(int i = 0; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX >= 0 && nextY >= 0 && nextX < R && nextY < C){
                if(visited[nextX][nextY] != 1 && map[nextX][nextY] != 'T'){
                    visited[nextX][nextY] = 1;
                    dfs(nextX, nextY, cnt+1);
                    visited[nextX][nextY] = 0;
                }
            }
        }
    }
}