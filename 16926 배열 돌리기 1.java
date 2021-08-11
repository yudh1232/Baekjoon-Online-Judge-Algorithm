import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// n, m, r 을 입력받음
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		// 2차원 배열 정보를 입력받음
		int[][] grid = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < m; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int min = n <= m ? n : m; // n, m중 작은값을 구함
		// 회전
		for (int a = 0; a < r; a++) {
			for (int k = 0; k < min / 2; k++) {
				int temp = grid[k][k];
				for (int j = 1 + k; j <= m - 1 - k; j++) {
					grid[k][j - 1] = grid[k][j];
				}
				for (int i = 1 + k; i <= n - 1 - k; i++) {
					grid[i - 1][m - 1 - k] = grid[i][m - 1 - k];
				}
				for (int j = m - 2 - k; j >= k; j--) {
					grid[n - 1 - k][j + 1] = grid[n - 1 - k][j];
				}
				for (int i = n - 2 - k; i >= k; i--) {
					grid[i + 1][k] = grid[i][k];
				}
				grid[k + 1][k] = temp;
			}
		}
		
		// 출력문 생성
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(grid[i][j]).append(" ");
			}
			sb.setLength(sb.length() - 1);
			sb.append("\n");
		}
		
		System.out.println(sb); // 결과 출력
	}
	
}
