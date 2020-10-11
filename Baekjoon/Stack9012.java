package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack9012 {
	
	public static void main(String[] args) throws Exception {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int i = 0;
		
		while(i<n) {
			String answer = "NO";
			String input = br.readLine();
			
			char[] arr = input.toCharArray();
			
			int count = 0;
			for (int j = 0; j < arr.length; j++) {
				
				if( arr[j] == '(' ) {
					count++;
				}else {
					count--;
				}
				
				if(count<0) break;
			}
			
			if(count == 0 ) {
				answer = "YES";
			}
			
			System.out.println(answer);
			i++;
		}
		
		
	}
	
	

}
