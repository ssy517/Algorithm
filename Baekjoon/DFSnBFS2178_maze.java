package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFSnBFS2178_maze {
	
	static int m;
	static int n;
	
	static int[][] arr;
	static int[][] map;
	static boolean[][] check;
	
	static int addx[] = {-1, 1, 0, 0};
	static int addy[] = {0, 0, -1, 1};
	
	static int count;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = input.charAt(j)-'0';
				map[i][j] = 0;
			}
		}
		
		check = new boolean[n][m];
		
		// 탐색 시작
		bfs(0, 0);
	
		System.out.println(arr[n-1][m-1]);
		
	}

	 public static void bfs(int i, int j) {
		
		 Queue<int[]> q = new LinkedList<int[]>();
		 q.offer(new int[] {i, j});
		 
		 check[i][j] = true;
		 arr[i][j] = 1;
		 
		 while(!q.isEmpty()) {
			 
			 int cx = q.peek()[0];
			 int cy = q.peek()[1];
			 q.poll();
			 
			 for (int k = 0; k < 4; k++) {
				int x = cx + addx[k];
				int y = cy + addy[k];
		
				if(x >= 0 && y >= 0 && x < n && y < m) {
					if(arr[x][y] != 0 && !check[x][y]) {
						check[x][y] = true;
						q.offer(new int[] {x, y});
						arr[x][y] = arr[cx][cy]+1;
					}
				}
			}
			 
		 }
		 
	}
	 

}
