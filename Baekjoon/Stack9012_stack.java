package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack9012_stack {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int i = 0;
		
		while(i<n) {
			Stack<Character> stack = new Stack<Character>();
			String answer = "";
			String input = br.readLine();
			
			char[] arr = input.toCharArray();
			
			for (int j = 0; j < arr.length; j++) {
				
				
				if( arr[j] == '(' ) { // 여는 괄호
					stack.push(arr[j]);
				}else {	// 닫는 괄호
					if( stack.isEmpty() ) {
						// 비어있다면 짝이 안맞으니까 break
						answer = "NO";
						break;
					}else {
						// 비어있지 않다면 짝맞춰서 없애기
						stack.pop();
					}	
				}
			}
			
			if(stack.size() == 0 && answer != "NO") {
				answer = "YES";
			}else {
				answer = "NO";
			}
			
			System.out.println(answer);
			i++;
		}
		
		
	}
	
	

}
