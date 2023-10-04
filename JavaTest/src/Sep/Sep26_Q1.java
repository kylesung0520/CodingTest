package Sep;/*
* 백준 2108 - 통계학 (구현)
* */

import java.util.*;
import java.io.*;
public class Sep26_Q1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Map<Integer, Integer> hs = new HashMap<>();
        int sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            sum += num;
            max = Math.max(max, num);
            min = Math.min(min, num);

            arr[i] = num;

            hs.put(num, hs.getOrDefault(num, 0)+1);
        }
        List<Integer> num = new ArrayList<>();
        int tmp = Integer.MIN_VALUE;
        for(Integer each : hs.keySet()){
            if(hs.get(each) > tmp){
                num = new ArrayList<>();
                num.add(each);
                tmp = hs.get(each);
            }
            else if(hs.get(each) == tmp){
                num.add(each);
            }
        }
        Arrays.sort(arr);
        Collections.sort(num);
        int idx = num.size() == 1 ? 0 : 1;
        for(Integer each : num){
            tmp = each;
            idx--;
            if(idx < 0){
                break;
            }
        }
        int average = (int) Math.round((double) sum / (double) arr.length);
        sb.append(average+"\n").append(arr[arr.length/2]+"\n").append(tmp+"\n").append(max-min);
        System.out.print(sb);
    }
}