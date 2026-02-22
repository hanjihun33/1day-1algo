package algo.y2026.m02.d22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_13549 {
	
	static int N, K;
    static int[] visited;
    static int MAX;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visited = new int[100001];
		MAX = 100000;
		for (int i = 0; i < visited.length; i++) {
		    visited[i] = -1;
		}
		
		if (N >= K) {
			System.out.println(N - K);
			return;
		}

		bfs();
	}

	private static void bfs() {
		Deque<Integer> dq = new LinkedList<>();

		dq.add(N);
		visited[N] = 0;

		while (!dq.isEmpty()) {
			int cur = dq.poll();

			if (cur == K) {
				System.out.println(visited[cur]);
				return;
			}

			if (cur * 2 <= MAX && visited[cur * 2] == -1) {
				visited[cur * 2] = visited[cur];
				dq.addFirst(cur * 2);
			}

			if (cur - 1 >= 0 && visited[cur - 1] == -1) {
				visited[cur - 1] = visited[cur] + 1;
				dq.addLast(cur - 1);
			}

			if (cur + 1 <= MAX && visited[cur + 1] == -1) {
				visited[cur + 1] = visited[cur] + 1;
				dq.addLast(cur + 1);
			}
		}
	}
}
