package algo.y2026.m02.d19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15650 {
	
	static int N , M ;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		dfs(1,0);

	}
	
	
	//a는 시작점, b는 깊이
	private static void dfs(int a, int b) {
		
		if (b == M) {
			for(int c : arr) {
				System.out.print(c + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=a ; i<=N ; i++) {
			arr[b] = i;
			dfs(i+1,b+1);
		}
		
	}

}
