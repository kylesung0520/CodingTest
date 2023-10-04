package Oct;
import java.util.*;
import java.io.*;

/* 백준 1182
* 브루트포스 알고리즘, 백트래킹 */
public class Oct04_Q1 {
    static int nums[];
    static int S, N;
    static int ans = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        solution(0, 0);
        if(S == 0){ans -= 1;}
        System.out.println(ans);
    }

    public static void solution(int depth, int sum){
        if(depth == N){
            if(sum == S){
                ans++;
            }
            return;
        }
        solution(depth+1, sum + nums[depth]);
        solution(depth+1, sum);
    }
}