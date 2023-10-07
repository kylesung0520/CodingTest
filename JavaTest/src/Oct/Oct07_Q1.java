package Oct;

import java.util.*;
import java.io.*;
/* 백준 1753
    그래프 이론, 데이크스트라
* */
class Edge implements Comparable<Edge>{
    int e;
    int w;
    public Edge(int e, int w){
        this.e = e;
        this.w = w;
    }
    @Override
    public int compareTo(Edge o){
        return this.w - o.w;
    }
}

public class Oct07_Q1 {
    static ArrayList<Edge>[] nodes;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        nodes = new ArrayList[V+1];
        dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i = 1; i <= V; i++){
            nodes[i] = new ArrayList<>();
        }
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            nodes[s].add(new Edge(e, w));
        }
        dijkstra(start);
        for(int i = 1; i <= V; i++){
            if(dist[i] == Integer.MAX_VALUE){
                sb.append("INF").append("\n");
            }
            else{
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.print(sb);
    }

    static void dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Edge now = pq.poll();
            for(Edge next : nodes[now.e]){
                if(dist[next.e] > now.w + next.w){
                    dist[next.e] = now.w + next.w;
                    pq.offer(new Edge(next.e, dist[next.e]));
                }
            }
        }
    }
}