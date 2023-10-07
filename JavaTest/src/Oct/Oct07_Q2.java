package Oct;

import java.util.*;
import java.io.*;
/* 백준 2003
    브루트포스 알고리즘, 누적 합, 두 포인터
* */
public class Oct07_Q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N+1];
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int l = 0, r = 0, sum = 0, ans = 0;
        while(l <= N && r <= N){
            if(sum == M){
                ans += 1;
            }
            if(sum >= M){
                sum -= nums[l++];
            }
            else{
                sum += nums[r++];
            }
        }
        System.out.println(ans);
    }
}