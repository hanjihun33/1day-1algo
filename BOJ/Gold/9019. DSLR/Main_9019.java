package algo.y2026.m02.d10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9019 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int i=0 ; i<T ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[10000]; 
            String[] command = new String[10000];
            
            q.add(A);
            visited[A] = true;
            command[A] = "";
			
			while(!q.isEmpty() && !visited[B]) {
				int cur = q.poll();
				
				int D = 2 * cur % 10000;
				int S = cur == 0 ? 9999 : cur - 1;
				int L = ( cur % 1000 ) * 10 + cur / 1000;
				int R = ( cur % 10 ) * 1000 + ( cur / 10 );
				
				if(!visited[D]) {
					q.add(D);
					visited[D] = true;
					command[D] = command[cur] + "D";
				}
				if(!visited[S]) {
					q.add(S);
					visited[S] = true;
					command[S] = command[cur] + "S";
				}
				if(!visited[L]) {
					q.add(L);
					visited[L] = true;
					command[L] = command[cur] + "L";
				}
				if(!visited[R]) {
					q.add(R);
					visited[R] = true;
					command[R] = command[cur] + "R";
				}
			}
			System.out.println(command[B]);
		}
	}
}

