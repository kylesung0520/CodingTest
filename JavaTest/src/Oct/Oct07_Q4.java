package Oct;

import java.util.*;
import java.io.*;
/* 백준 10025
   누적 합, 두 포인터, 슬라이딩 윈도우
* */
public class Oct07_Q4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[10000001];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[x] = g;
        }

        int l = 0;
        int window = (K*2)+1;
        boolean flag = false;
        int ans = 0, sum = 0;

        while(l <= 10000000){
            if(l == window-1){flag = true;}
            if(l >= window){sum -= arr[l-window];}
            sum += arr[l++];
            if(sum > ans && flag){
                ans = sum;
            }
        }

        System.out.println(ans);
    }
}