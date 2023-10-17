package Oct;

import java.util.*;
import java.io.*;

public class Oct17_Q3 {
    static String target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        target = br.readLine();
        String str = br.readLine();

        int answer = solution(str) ? 1 : 0;
        System.out.println(answer);
    }

    static boolean solution(String str){
        if(str.length() == target.length()){
            if(str.equals(target)){
                return true;
            }
            return false;
        }
        if(str.charAt(str.length()-1) == 'A'){
            if(solution(str.substring(0, str.length()-1))){
                return true;
            }
        }
        if(str.charAt(0) == 'B'){
            if(solution(new StringBuilder(
                    str.substring(1)).reverse().toString())) {
                return true;
            }
        }
        return false;
    }
}