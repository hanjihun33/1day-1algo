package algo.y2026.m02.d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_1260 {
	
	static int N,M,V;
	static boolean[][] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		V = Integer.parseInt(st.nextToken()); // 시작할 정점의 번호
		
		arr = new boolean[N+1][N+1];
		
		for(int i=0 ; i<M ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = true;
		}
		
		visited = new boolean[N+1];
		dfs(V);
		sb.append("\n");
		
		visited = new boolean[N+1];
		bfs(V);
		
		System.out.println(sb.toString());
	}

	private static void bfs(int v) {
		Deque<Integer> dq = new ArrayDeque<Integer>();
		dq.add(v);
		visited[v] = true;
		
		while (!dq.isEmpty()) {
			int cur = dq.poll();
			sb.append(cur).append(" ");
			
			for(int i=1 ; i<=N ; i++) {
				if(arr[cur][i] && !visited[i]) {
					dq.add(i);
					visited[i] = true;
				}
			}
		}
				
	}

	private static void dfs(int v) {
		visited[v] = true;
		sb.append(v).append(" ");
		
		for(int i = 1; i <= N; i++) {
            if(arr[v][i] && !visited[i]) {
                dfs(i);
            }
        }
	}
}
