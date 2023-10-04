package Oct;

import java.util.*;
import java.io.*;

/* 백준 1759
* 수학, 브루트포스 알고리즘, 조합론, 백트래킹 */
public class Oct04_Q2 {
    static List<String> chars = new ArrayList<>();
    static List<Character> m = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    static Set<String> tmpAns = new HashSet<>();
    static int L, C;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++){
           chars.add(st.nextToken());
        }

        Collections.sort(chars);
        solution(0, "");

        ArrayList<String> ans = new ArrayList<>(tmpAns);
        Collections.sort(ans);
        for(String each : ans){
            sb.append(each+"\n");
        }
        System.out.println(sb);
    }

    public static void solution(int depth, String comb){
        if(depth == chars.size()){
            if(comb.length() == L){
                int mCnt = 0, jCnt = 0;
                for(int i = 0; i < comb.length(); i++){
                    if(m.contains(comb.charAt(i))){
                        mCnt += 1;
                    }
                    else{
                        jCnt += 1;
                    }
                }
                if(mCnt >= 1 && jCnt >= 2){
                    tmpAns.add(comb);
                }
            }
            return;
        }
        solution(depth+1, comb+chars.get(depth));
        solution(depth+1, comb);
    }
}
