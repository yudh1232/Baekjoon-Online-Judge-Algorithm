import java.io.*;
import java.util.*;

public class Main {

	static int n, m, moltenCnt;
	static int[][] board;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// n, m을 입력받음
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 판을 입력받음
		board = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 치즈가 모두 녹는데 걸리는 시간
		int time = 0;
		
		// 치즈가 다 녹을때까지 반복
		while (true) {
			// 치즈가 다 녹았으면
			if (isEnd())
				break;
			
			moltenCnt = 0; // 1시간 동안 녹는 치즈 개수 변수
			visited = new boolean[n][m];
			
			// dfs를 통해 공기와 닿는 치즈 제거
			dfs(0, 0);
			
			// 시간 증가
			time++;
		}
		
		// 결과 출력
		System.out.println(time);
		System.out.println(moltenCnt);
	}

	private static void dfs(int x, int y) {
		// 방문 표시
		visited[x][y] = true;
		
		// 치즈를 만나면 녹이고 리턴
		if (board[x][y] == 1) {
			board[x][y] = 0;
			moltenCnt++;
			return;
		}
		
		// 다음위치 방문
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
			if (visited[nx][ny]) continue;
			dfs(nx, ny);
		}
	}

	// 치즈가 다 녹았는지 체크하는 함수
	private static boolean isEnd() {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sum += board[i][j];
			}
		}
		if (sum == 0) return true;
		else return false;
	}
	
}
