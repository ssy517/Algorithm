package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFSnBFS2206_wall {
	
	static int n;
	static int m;
	
	static int[][] arr;
	
	static boolean[][][] check;
	
	static int[] addx = {-1, 1, 0, 0};
	static int[] addy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			String input = st1.nextToken();
			
			for (int j = 0; j < m; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}
		
		check = new boolean[n][m][2];
		int answer = 0;
		
		// 탐색 시작
		answer = bfs();
	
		System.out.println(answer);
		
	}

	 public static int bfs() {
		
		 int answer = -1;
		 Queue<Point> q = new LinkedList<Point>();
		 
			q.offer(new Point(0, 0, 0, 1));
			check[0][0][0] = true;
			check[0][0][1] = true;

		 while(!q.isEmpty()) {
			 
			 Point p = q.peek();
			// System.out.println("x:" + p.x + "y:" + p.y);
			 if(p.x == n-1 && p.y == m-1) {
				 answer = p.count;
				 break;
			 }
			 
			 q.poll();
			 
			 for (int i = 0; i < 4; i++) {
				
				 int cx = p.x + addx[i];
				 int cy = p.y + addy[i];
				 
				 if(cx >= 0 && cx < n && cy >= 0 && cy < m && !check[cx][cy][p.breakWall]) {
					
					 if(arr[cx][cy] == 0) {
						check[cx][cy][p.breakWall] = true;
						q.offer(new Point(cx, cy, p.breakWall, p.count + 1));
					 }else if(arr[cx][cy] == 1 && p.breakWall == 0) {
						 check[cx][cy][p.breakWall] = true;
						 q.offer(new Point(cx, cy, p.breakWall + 1, p.count+1));
					 }
					
				}
				 
			}
	 
		 }
		 
		 return answer;
		 
	}
	 
	static class Point{
		int x, y;
		int breakWall;
		int count;

		public Point(int x, int y, int breakWall, int count) {
			super();
			this.x = x;
			this.y = y;
			this.breakWall = breakWall;
			this.count = count;
		}
		
		
	}
	 

}
