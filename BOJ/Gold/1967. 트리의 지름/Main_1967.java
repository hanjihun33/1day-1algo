package algo.y2026.m02.d15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1967 {
	
	static boolean[] visited;
	static ArrayList<int[]>[] graph;
	static int farnode;
	static int fardistance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		graph = new ArrayList[n+1];
		for(int i=1 ; i<=n ; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0 ; i<n-1 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new int[] {b,c});
			graph[b].add(new int[] {a,c});
		}
		
		//가장 먼 노드 찾기
        visited = new boolean[n + 1];
        fardistance = -1;
        dfs(1, 0);
        int far = farnode;
        
        //가장 긴 지름 찾기
        visited = new boolean[n + 1];
        fardistance = -1;
        dfs(far, 0);

        System.out.println(fardistance);

	}
	
	//a는 연결된 노드, b는 가중치
	private static void dfs(int a, int b) {
		visited[a] = true;

        if (b > fardistance) {
        	farnode = a;
        	fardistance = b;
        }

        for (int[] next : graph[a]) {
            int nextnode = next[0];
            int len = next[1];

            if (!visited[nextnode]) {
                dfs(nextnode, b + len);
            }
        }
		
	}

}
