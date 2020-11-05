package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFSnBFS7569_tomato {
	
	static int h;
	static int m;
	static int n;
	
	static int[][][] arr;
	static int[][][] map;
	static boolean[][][] check;
	static List<int[]> list;
	
	static int addx[] = {-1, 1, 0, 0, 0, 0};
	static int addy[] = {0, 0, -1, 1, 0, 0};
	static int addz[] = {0, 0, 0, 0, -1, 1};
	
	static int count;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		arr = new int[h][n][m];
		
		list = new ArrayList<int[]>();
		
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				String input = br.readLine();
				StringTokenizer st1 = new StringTokenizer(input," ");
				for (int j = 0; j < m; j++) {
					arr[k][i][j] = Integer.parseInt(st1.nextToken());
					if(arr[k][i][j] == 1) {
						list.add(new int[] {k, i, j});
					}
				}
			}
		}
		check = new boolean[h][n][m];
		int answer = 0;
		
		if(list != null) {
			// 탐색 시작
			bfs(list);
			loop:for (int k = 0; k < h; k++) {
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < m; j++) {
							if(arr[k][i][j]==0) {
								answer = -1;
								break loop;
							}
							if(arr[k][i][j] > answer) {
								answer = arr[k][i][j]-1;
							}
						}
				}
			}
		}
	
		System.out.println("answer: " + answer);
		
	}

	 public static void bfs(List<int[]> list) {
		
		 Queue<int[]> q = new LinkedList<int[]>();
		 
		 for (int k = 0; k < list.size(); k++) {
			q.offer(list.get(k));
			int c = list.get(k)[0];
			int a = list.get(k)[1];
			int b = list.get(k)[2];
			check[c][a][b] = true;
		 }
		 
		 while(!q.isEmpty()) {
			 
			 int cz = q.peek()[0];
			 int cx = q.peek()[1];
			 int cy = q.peek()[2];
			 q.poll();
			 
			 for (int k = 0; k < 6; k++) {
				int z = cz + addz[k];
				int x = cx + addx[k];
				int y = cy + addy[k];
		
				if(x >= 0 && y >= 0 && z >= 0 && x < n && y < m && z < h) {
					if(arr[z][x][y] != -1 && !check[z][x][y]) {
						check[z][x][y] = true;
						q.offer(new int[] {z, x, y});
						arr[z][x][y] = arr[cz][cx][cy]+1;
					}
				}
			}
			 
		 }
		 
	}
	 

}
