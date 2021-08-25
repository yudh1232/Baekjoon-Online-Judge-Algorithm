package _0825;

import java.io.*;

public class BOJ_10026_적록색약 {

	static int n;
	static char[][] data;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};	
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// n을 입력받음
		n = Integer.parseInt(in.readLine());
		
		// 그림을 입력받음
		data = new char[n][n];
		for (int i = 0; i < n; i++) {
			data[i] = in.readLine().toCharArray();
		}
		
		// dfs를 위한 visited 배열 생성
		visited = new boolean[n][n];
		
		// 적록색약이 아닌 결과값 구하기
		int result1 = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 이미 방문하지 않은 곳이라면 결과값 증가
				if (dfs(i, j)) result1++;
			}
		}
		
		// 적록색약 결과값을 구하기 위해 그림을 수정
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (data[i][j] == 'G') data[i][j] = 'R';
			}
		}
		
		// dfs를 위한 visited 배열 다시 생성
		visited = new boolean[n][n];
		
		// 적록색약인 결과값 구하기
		int result2 = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 이미 방문하지 않은 곳이라면 결과값 증가
				if (dfs(i, j)) result2++;
			}
		}
		
		// 결과값 출력
		System.out.println(result1 + " " + result2);
	}
	
	// dfs로 같은 구역을 모두 방문
	private static boolean dfs(int x, int y) {
		
		// 이미 방문했다면 false 리턴
		if (visited[x][y]) return false;
		
		// 방문 표시
		visited[x][y] = true;
		
		// 상하좌우로 이미 방문하지않았으면서 같은구역이면 방문하러 감
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
			if (visited[nx][ny]) continue;
			if (data[x][y] != data[nx][ny]) continue;
			dfs(nx, ny);
		}
		
		// 이미 방문하지 않았다면 true 리턴
		return true;
	}
	
}
