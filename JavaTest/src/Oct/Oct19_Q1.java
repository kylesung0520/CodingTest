/* 백준 1744
   그리디 알고리즘, 정렬, 많은 조건 분기
*/
package Oct;

import java.util.*;
import java.io.*;

public class Oct19_Q1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int answer = 0, N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            int tmp = Integer.parseInt(br.readLine());
            arr[i] = tmp;
        }
        Arrays.sort(arr);

        int mIdx = 0, pIdx = N-1;

        // 최댓값을 위해 음수끼리 곱하기
        while(mIdx < N && arr[mIdx] < 1){
            if(mIdx+1 < N && arr[mIdx+1] < 1){
                answer += (arr[mIdx]*arr[mIdx+1]);
                mIdx++;
            }
            else{
                answer += arr[mIdx];
            }
            mIdx++;
        }

        // 최댓값을 위해 양수끼리 곱하기
        while(pIdx >= mIdx && arr[pIdx] > 0){
            if(pIdx-1 >= mIdx && arr[pIdx-1] > 1){
                answer += (arr[pIdx] * arr[pIdx-1]);
                pIdx--;
            }
            else{
                answer += arr[pIdx];
            }
            pIdx--;
        }
        System.out.println(answer);
    }
}