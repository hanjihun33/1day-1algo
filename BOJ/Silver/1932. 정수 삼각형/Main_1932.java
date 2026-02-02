package algo.y2026.m01.d25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1932 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] triangle = new int[n][n];
		int[][] dp = new int[n][n];
		
		for(int i=0 ; i<n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j =0 ; j<=i ; j ++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = triangle[0][0];
		
		for(int i=1 ; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
                if (j == 0) { // 맨 왼쪽
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == i) { // 맨 오른쪽
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else { // 중간
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
			}
		}
		
		int ans = 0;
		for(int i=0 ; i<n ; i++) {
			ans = Math.max(ans, dp[n-1][i]);
		}
		System.out.println(ans);

	}

}
