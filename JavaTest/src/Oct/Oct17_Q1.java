/* 백준 1522
   Brute Force, 슬라이딩 윈도우
*/

package Oct;

import java.util.*;
import java.io.*;

public class Oct17_Q1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String str = br.readLine();

        int aCnt = 0, answer = Integer.MAX_VALUE;
        for(int i = 0; i < str.length(); i++){
            aCnt += str.charAt(i) == 'a' ? 1 : 0;
        }

        for(int i = 0; i < str.length(); i++){
            int bCnt = 0;
            for(int j = i; j < aCnt+i; j++){
                bCnt += str.charAt(j % str.length()) == 'b' ? 1 : 0;
            }
            answer = Math.min(bCnt, answer);
        }

        System.out.println(answer);
    }
}