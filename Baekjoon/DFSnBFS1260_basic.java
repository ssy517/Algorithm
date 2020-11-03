package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFSnBFS1260_basic {
	
	static ArrayList<Integer>[] listarr;
	static boolean[] check;
	static int n;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s  = br.readLine();
		
		StringTokenizer st = new StringTokenizer(s," ");
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		//list 생성
		listarr = new ArrayList[n+1];
		
		for (int i = 0; i < n+1; i++) {
			listarr[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st1.nextToken());
			int b = Integer.parseInt(st1.nextToken());
			
			listarr[a].add(b);
			listarr[b].add(a);
		}
		
		// 순서대로 정렬
		for (int i = 0; i < listarr.length; i++) {
			Collections.sort(listarr[i]);
		}
		
		// boolean 생성
		check = new boolean[n+1];
		dfs(v);
		
		System.out.println();
		// 초기화
		check = new boolean[n+1];
		bfs(v);
		
				
	}
	
	 public static void dfs(int v) {
	       
		// if(check[v]) {
		//	 return;
		// }
		 check[v] = true;
		 System.out.print(v + " ");
		 
		 for (int x : listarr[v]) {
			if(!check[x]) {
				dfs(x);
			}
		}
	       
	 }
	 
	 public static void bfs(int v) {
	        
		 Queue<Integer> q = new LinkedList<Integer>();
		 q.offer(v);
		 check[v] = true;
		 
		 while(!q.isEmpty()) {
			 int x = q.poll();
			 System.out.print(x + " ");
			 
			 for (int y : listarr[x]) {
				 if(!check[y]) {
					check[y] = true;
					q.offer(y);
				}
			 }
		 }
		 
	       
	 }

}
