package Oct;

import java.util.*;
import java.io.*;
/* 백준 2559
    누적 합, 두 포인터, 슬라이딩 윈도우
* */
public class Oct06_Q4 {
    static int N, K, max = 0;
    static int[] temps;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        temps = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            temps[i] = Integer.parseInt(st.nextToken());;
        }
        for(int i = 0; i < K; i++){
            max += temps[i];
        }
        solution();
        System.out.println(max);
    }

    public static void solution(){
        int start = K;
        int prev = max;
        while(start < N){
            prev = prev + temps[start] - temps[start-K];
            max = Math.max(max, prev);
            start++;
        }
    }
}