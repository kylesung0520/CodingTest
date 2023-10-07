package Oct;

import java.util.*;
import java.io.*;

/* 백준 3273
    정렬, 두 포인터
* */
public class Oct07_Q3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        int target = Integer.parseInt(br.readLine());
        int l = 0, r = nums.length - 1, ans = 0;
        while(l < r){
            int sum = nums[l] + nums[r];
            if(sum == target){
                ans++;
            }
            if(sum >= target){
                r--;
            }
            else{
                l++;
            }
        }
        System.out.println(ans);
    }
}