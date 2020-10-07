package study;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class String1152 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine(); 
				
		String str[];
		
		int answer = 0;
		
		if(word.equals(" ") || word.equals("")) {

		}else {
			str = word.trim().split(" ");
			answer = str.length;
		}
		
		System.out.println(answer);

	}

	

}
