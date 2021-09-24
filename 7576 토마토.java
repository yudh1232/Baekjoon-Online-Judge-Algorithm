import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 상하좌우
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[][] grid = new int[n][m];
		boolean visited[][] = new boolean[n][m];
		
		Queue<int[]> q = new LinkedList<int[]>();
		
		// 토마토의 상태를 입력받고 익은토마토면 큐에 넣음
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < m; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if (grid[i][j] == 1) {
					q.offer(new int[] {i, j});
					visited[i][j] = true;
				}
			}
		}
		
		// bfs
		int level = 0;
		while (!q.isEmpty()) {
			// 깊이별로 나눠서 진행
			int qSize = q.size();
			while (qSize > 0) {
				// 큐에서 하나 꺼냄
				int[] now = q.poll();
				int x = now[0];
				int y = now[1];
				
				// 상하좌우로 탐색
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
					if (visited[nx][ny]) continue;
					if (grid[nx][ny] == 0) {
						grid[nx][ny] = 1;
						q.offer(new int[] {nx, ny});
						visited[nx][ny] = true;
					}
				}
				
				qSize--;
			}
			// 깊이 증가
			level++;
		}
		
		// 토마토가 모두 익었는지 확인
		boolean flag = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 0) flag = false;
			}
		}
		
		// 모두 익었으면
		if (flag) System.out.println(level - 1);
		// 안 익은게 존재하면
		else System.out.println(-1);
	}
	
}
