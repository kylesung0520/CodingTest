package Oct;

import java.util.*;
import java.io.*;

/* 백준 1488
 * 브루트포스 알고리즘, 백트래킹 */
public class Oct06_Q1 {
    static int N, MIN = Integer.MAX_VALUE, MAX = Integer.MIN_VALUE;
    static int[] nums, op = new int[4];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }

        solution(nums[0], 1);

        sb.append(MAX).append("\n").append(MIN);
        System.out.print(sb);
    }

    public static void solution(int sum, int depth){
        if(depth == N){
            MIN = Math.min(MIN, sum);
            MAX = Math.max(MAX, sum);
            return;
        }
        for(int i = 0; i < op.length; i++){
            if(op[i] > 0){
                op[i]--;
                switch(i){
                    case 0:
                        solution(sum+nums[depth], depth+1);
                        break;
                    case 1:
                        solution(sum-nums[depth], depth+1);
                        break;

                    case 2:
                        solution(sum*nums[depth], depth+1);
                        break;
                    case 3:
                        solution(sum/nums[depth], depth+1);
                        break;
                }
                op[i]++;
            }
        }
    }
}