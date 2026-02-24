package algo.y2026.m02.d24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1916 {
    static class Node implements Comparable<Node> {
        int target, cost;
        Node(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Node>[] arr = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) arr[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a].add(new Node(b, c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(N, arr, start, end));
    }

    private static int dijkstra(int n, List<Node>[] arr, int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currIdx = current.target;
            int currCost = current.cost;

            if (currCost > dist[currIdx]) continue;

            for (Node neighbor : arr[currIdx]) {
                if (dist[neighbor.target] > dist[currIdx] + neighbor.cost) {
                    dist[neighbor.target] = dist[currIdx] + neighbor.cost;
                    pq.add(new Node(neighbor.target, dist[neighbor.target]));
                }
            }
        }
        return dist[end];
    }
}