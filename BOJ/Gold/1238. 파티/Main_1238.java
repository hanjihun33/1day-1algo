package algo.y2026.m04.d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main_1238 {
	
	static int N, M, X;
	static ArrayList<Node>[] graph;
	static ArrayList<Node>[] reverseGraph;
	static final int INF = Integer.MAX_VALUE;
	
	static class Node implements Comparable<Node> {
		int to;
		int cost;
		
		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 학생의 수
		M = Integer.parseInt(st.nextToken()); // 도로의 수
		X = Integer.parseInt(st.nextToken()); // X번 마을
		
		
		graph = new ArrayList[N + 1];
        reverseGraph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, time));
            reverseGraph[to].add(new Node(from, time));
        }

        int[] go = dijkstra(X, reverseGraph);
        int[] back = dijkstra(X, graph);
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, go[i] + back[i]);
        }

        System.out.println(answer);
    }

    static int[] dijkstra(int start, ArrayList<Node>[] map) {
        int[] dist = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dist[i] = INF;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (dist[current.to] < current.cost) continue;

            for (Node next : map[current.to]) {
                int newCost = current.cost + next.cost;

                if (dist[next.to] > newCost) {
                    dist[next.to] = newCost;
                    pq.offer(new Node(next.to, newCost));
                }
            }
        }

        return dist;
    }
}