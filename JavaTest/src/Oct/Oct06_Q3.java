package Oct;

import java.util.*;
import java.io.*;
/* 백준 1806
   누적 합, 두 포인터*/
public class Oct06_Q3 {
    static int N, S;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i <N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution());
    }

    public static int solution(){
        int retVal = Integer.MAX_VALUE, start = 0, end = 0, sum = 0;
        while(start <= N && end <= N){
            if(sum >= S && retVal > end-start){
                retVal = end-start;
            }
            if(sum < S){
                sum += nums[end++];
            }
            else{
                sum -= nums[start++];
            }
        }
        return retVal == Integer.MAX_VALUE ? 0 : retVal;
    }
}