package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFSnBFS1697_hideNseek {
	
	static int n;
	static int k;
	
	static int[] map;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[100000+1];
	System.out.println(n + "  &  " + k);
		if(n == k) {
			System.out.println(0);
		}else {
		// 탐색 시작
		bfs(n);
		}
		
	}

	 public static void bfs(int a) {
	
		 Queue<Integer> q = new LinkedList<Integer>();
		 q.offer(a);
		 map[a] = 1;
		 
		 while(!q.isEmpty()) {
			 a = q.poll();
			 int x;	 
		 
			 for (int i = 0; i < 3; i++) {
				 if(i==0) {
					 x = a-1;
				 }else if(i==1) {
					 x = a+1;
				 }else {
					 x = 2*a;
				 }
				 
				 if(x == k) {
						System.out.println(map[a]);
						return;
                 }
				 if(x >= 0 && x <= 100000 && map[x] ==0) {			
						q.offer(x);
						map[x] = map[a] + 1;
				 }
			 }
		 }
		 }


		 
	
	 
	
	 

}
