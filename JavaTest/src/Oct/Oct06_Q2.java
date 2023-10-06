package Oct;
import java.util.*;
import java.io.*;
/* 백준 11659
   누적 합
*/
public class Oct06_Q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] prefix = new int[N+1];
        int sum = 0;
        for(int i = 1; i <= N; i++){
            sum += Integer.parseInt(st.nextToken());
            prefix[i] = sum;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int ret = prefix[end] - (prefix[start-1]);

            sb.append(ret).append("\n");
        }

        System.out.println(sb);
    }
}
