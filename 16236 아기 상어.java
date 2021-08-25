package _0825;

import java.io.*;
import java.util.*;

public class BOJ_16236_아기상어 {

	static int n, sharkX, sharkY, size;
	static int[][] grid;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// n을 입력받음
		n = Integer.parseInt(in.readLine());
		
		// 공간의 상태를 나타내는 2차원 배열
		grid = new int[n][n];
		
		// 공간의 상태를 입력받음
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < n; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				// 상어가 있던 곳이라면, 상어의 좌표를 따로 저장하고 그 자리를 0으로 만듦
				if (grid[i][j] == 9) {
					sharkX = i;
					sharkY = j;
					grid[i][j] = 0;
				}
			}
		}
		
		size = 2; // 상어의 사이즈
		int result = 0; // 결과값(물고기를 잡아먹을 수 있는 시간)
		int eatCount = 0; // 먹은 물고기 수
		Queue<int[]> q = new LinkedList<int[]>(); // bfs를 위한 큐
		boolean eatFail = false; // 물고기 먹기에 실패했는지 나타내는 변수
		
		// 먹을 물고기가 있고, 물고기 먹기에 실패하지 않았다면 계속 반복
		while (check() && !eatFail) {
			visited = new boolean[n][n];
			q.offer(new int[] {sharkX, sharkY});
			visited[sharkX][sharkY] = true;
			eatFail = true;
			
			int level = 0; // bfs 레벨을 나타내는 변수
			
			// 먹을 물고기의 좌표
			int eatX = n;
			int eatY = n;
			
			// 먹을 물고기 찾으러 가기
			while (!q.isEmpty()) {
				
				// 레벨(거리) 별로 나누어서 bfs 진행
				int qSize = q.size();
				for (int i = qSize; i > 0; i--) {
					int[] xy = q.poll();
					int x = xy[0];
					int y = xy[1];
					
					// 같은 거리의 물고기라면 위 그리고 왼쪽을 우선시 함
					if (grid[x][y] != 0 && grid[x][y] < size) {
						if (x < eatX) {
							eatX = x;
							eatY = y;
						}
						else if (x == eatX & y < eatY) {
							eatX = x;
							eatY = y;
						}
					}
					
					for (int d = 0; d < 4; d++) {
						int nx = x + dx[d];
						int ny = y + dy[d];
						if (nx >= 0 && ny >= 0 && nx < n && ny < n && size >= grid[nx][ny] && !visited[nx][ny]) {
							q.offer(new int[] {nx, ny});
							visited[nx][ny] = true;
						}
					}
				}
				
				// 먹을 물고기를 찾았으면 먹기
				if (eatX != n) {
					grid[eatX][eatY] = 0;
					eatCount++; // 
					
					// 자신의 크기와 같은 수의 물고기를 먹었다면 크기 증가 
					if (size == eatCount) {
						size++;
						eatCount = 0;
					}
					
					// 결과값에 상어와 물고기와의 거리를 더해줌
					result += level;
					
					q.clear();
					
					sharkX = eatX;
					sharkY = eatY;
					
					eatFail = false;
					
					break;
				}
				
				// bfs 레벨 증가
				level++;
			}
		}
		
		// 결과 출력
		System.out.println(result);
	}
	
	// 먹을 물고기가 있는지 체크
	static boolean check() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] != 0 && grid[i][j] < size) {
					return true;
				}
			}
		}
		return false;
	}
	
}
