package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DFSnBFS2667_apartment {
	
	static int[][] arr;
	static boolean[][] check;
	static int n;
	
	static int addx[] = {-1, 1, 0, 0};
	static int addy[] = {0, 0, -1, 1};
	
	static List<Integer> apt;
	static int count = 0;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n  = Integer.parseInt(br.readLine());

		arr = new int[n][n];
		// 배열 입력받기
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = input.charAt(j)-'0';
			}	
		}
		
		check = new boolean[n][n];
		apt = new ArrayList<Integer>();
		
		// 탐색 시작
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[i][j] == 1 && !check[i][j]) {
					count++;
					apt.add(0);
					// 연결된 집 탐색
					bfs(i, j);
				}
			}
		}
			
		System.out.println(count);
		
		Collections.sort(apt);
		for (int i = 0; i < apt.size(); i++) {
			System.out.println(apt.get(i));
		}
	}
	
	 public static void dfs(int i, int j) {
	       
		 check[i][j] = true;
		 int tmp = apt.get(count-1)+1;
		 apt.set(count-1, tmp);
		 
		 for (int k = 0; k < 4; k++) {
			int x = i + addx[k];
			int y = j + addy[k];
			
			if(x >= 0 && y >= 0 && x < n && y < n) {
				if(arr[x][y] == 1 && !check[x][y]) {
					dfs(x, y);
				}
			}	
		}
	       
	 }
	 
	 public static void bfs(int i, int j) {
		
		 Queue<int[]> q = new LinkedList<int[]>();
		 q.offer(new int[] {i, j});
		 
		 check[i][j] = true;
		 
		 apt.set(count-1, apt.get(count-1)+1);
		
		 while(!q.isEmpty()) {
			 
			 int cx = q.peek()[0];
			 int cy = q.peek()[1];
			 q.poll();
			 
			 for (int k = 0; k < 4; k++) {
				int x = cx + addx[k];
				int y = cy + addy[k];
				
				if(x >= 0 && y >= 0 && x < n && y < n) {
					if(arr[x][y] == 1 && !check[x][y]) {
						check[x][y] = true;
						q.offer(new int[] {x, y});
						
						apt.set(count-1, apt.get(count-1)+1);
					}
				}
			}
			 
		 }
		 
	}

}
