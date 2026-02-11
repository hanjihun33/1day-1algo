package algo.y2026.m02.d11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9251 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = br.readLine();
		String b = br.readLine();
		
		int alength = a.length();
		int blength = b.length();
		
		int[][] dp = new int[alength+1][blength+1];
		
		for(int i=1 ; i<=a.length() ; i++) {
			char aa = a.charAt(i-1);
			for(int j=1 ; j<=b.length() ; j++) {
				char bb = b.charAt(j-1);
				
				if (aa==bb) dp[i][j]=dp[i-1][j-1]+1;
				else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		System.out.println(dp[alength][blength]);
	}
}
