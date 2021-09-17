import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	static int[][] grid, temp, blank, virus;
	static boolean[][] visited;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int blankCnt, virusCnt;
	static int[] numbers;
	static int result = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 지도 정보를 입력받음
		grid = new int[n][m];
		blankCnt = 0;
		virusCnt= 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < m; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if (grid[i][j] == 0) blankCnt++;
				if (grid[i][j] == 2) virusCnt++;
			}
		}
		
		blank = new int[blankCnt][2];
		virus = new int[virusCnt][2];
		blankCnt = 0;
		virusCnt = 0;
		
		// 빈칸과 바이러스의 좌표를 저장해둠
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 0) {
					blank[blankCnt][0] = i;
					blank[blankCnt++][1] = j;
				}
				else if (grid[i][j] == 2) {
					virus[virusCnt][0] = i;
					virus[virusCnt++][1] = j;
				}
			}
		}
		
		// 벽을 세울 위치 3개를 뽑는 모든 경우에 대해 바이러스를 전파해보고
		// 안전 영역의 최대크기를 구함
		numbers = new int[3];
		combination(0, 0);
		
		// 결과 출력
		System.out.println(result);
	}
	
	// 벽을 세울 위치 3개를 뽑기
	private static void combination(int cnt, int start) {
		if (cnt == 3) {
			// 안전 영역의 최대 크기 구하기
			calSafeArea();
			return;
		}
		
		for (int i = start; i < blankCnt; i++) {
			numbers[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}

	// 안전 영역의 최대 크기 구하기
	private static void calSafeArea() {
		// grid를 temp에 복사
		temp = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp[i][j] = grid[i][j];
			}
		}
		
		// 벽을 세움
		for (int k = 0; k < 3; k++) {
			temp[blank[numbers[k]][0]][blank[numbers[k]][1]] = 1;
		}
		
		// 바이러스 전파
		visited = new boolean[n][m];
		for (int k = 0; k < virusCnt; k++) {
			dfs(virus[k][0], virus[k][1]);
		}
		
		// 안전 영역의 최대 크기 구하기
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (temp[i][j] == 0) sum++;
			}
		}
		result = Math.max(result, sum);
	}

	// 바이러스 전파(dfs)
	private static void dfs(int x, int y) {
		if (x < 0 | x >= n || y < 0 || y >= m) return;
		if (visited[x][y] || temp[x][y] == 1) return;
		temp[x][y] = 2;
		visited[x][y] = true;
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			dfs(nx, ny);
		}
	}
	
}
