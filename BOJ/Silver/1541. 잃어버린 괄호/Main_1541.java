package algo.y2026.m02.d11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String exp = br.readLine();
		
		String[] minus = exp.split("-");
		
		int sum = 0 ;
		for(int i=0 ; i<minus.length ; i++) {
			int num = 0;
			
			String[] plus = minus[i].split("\\+");
			for(String s : plus) {
				num += Integer.parseInt(s);
			}
			if(i==0) sum+= num;
			else sum-= num;
		}
		System.out.println(sum);
	}
}

//55-50+40
