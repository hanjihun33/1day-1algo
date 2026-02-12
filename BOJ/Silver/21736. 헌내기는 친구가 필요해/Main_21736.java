package algo.y2026.m02.d12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_21736 {
	
	static int N,M;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M];
		int a=0,b=0;
		
		for(int i=0 ; i<N ; i++) {
			String s = br.readLine();
			for(int j=0 ; j<M ; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='I') {
					a = i;
					b = j;
				}
			}
		}
		
		int res = bfs(a,b);
		if( res==0 ) System.out.println("TT");
		else System.out.println(res);
		
	}

	private static int bfs(int a, int b) {
		ArrayDeque<int[]> dq = new ArrayDeque<int[]>();
		visited[a][b] = true;
		dq.add(new int[] {a,b});
		
		int cnt = 0;
		
		while(!dq.isEmpty()) {
			int[] cur = dq.poll();
			
			if(map[cur[0]][cur[1]] == 'P') cnt++;
			for(int i=0 ; i<4 ; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
				if(visited[nx][ny]) continue;
				if(map[nx][ny] == 'X') continue;
				
				visited[nx][ny] = true;
				dq.add(new int[] {nx,ny});
			}
		}
		return cnt;
	}
}
