package algo.y2026.m02.d26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753 {
	
	public static class Node implements Comparable<Node> {
		int target, cost;

		public Node(int target, int cost) {
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		List<Node>[] graph = new ArrayList[V + 1];
		for(int i=1 ; i<=V ; i++)  graph[i] = new ArrayList<>();
		
		for(int i=0 ; i<E ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b, c));
		}
		
		int[] dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(K, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (cur.cost > dist[cur.target]) continue;

			for (Node next : graph[cur.target]) {
				if (dist[next.target] > dist[cur.target] + next.cost) {
					dist[next.target] = dist[cur.target] + next.cost;
					pq.add(new Node(next.target, dist[next.target]));
				}
			}
		}

		for (int i = 1; i <= V; i++) {
		    if (dist[i] == Integer.MAX_VALUE) {
		        System.out.println("INF");
		    } else {
		        System.out.println(dist[i]);
		    }
		}
	}

}
