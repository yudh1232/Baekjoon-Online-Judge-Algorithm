import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// n, m, r을 입력받음
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		// n, m 중 큰 값을 구함
		int max = Math.max(n, m);
		// max * max 2차원 배열을 생성하고 배열 정보를 입력받음
		int[][] grid = new int[max][max];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < m; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 연산들을 입력받음
		st = new StringTokenizer(in.readLine(), " ");
		// 연산의 개수만큼 반복
		for (int k = 0; k < r; k++) {
			// grid에 연산을 수행한 결과를 담을 2차원 배열
			int[][] temp = new int[max][max];
			
			int operation = Integer.parseInt(st.nextToken());
			// 상하 반전
			if (operation == 1) {
				
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						temp[i][j] = grid[n - 1 - i][j];
					}
				}
				
			}
			// 좌우 반전
			else if (operation == 2) {
				
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						temp[i][j] = grid[i][m - 1 - j];
					}
				}
				
			}
			// 오른쪽으로 90도 회전
			else if (operation == 3) {
				
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						temp[j][n - 1 - i] = grid[i][j];
					}
				}
				
				int t = n;
				n = m;
				m = t;
				
			}
			// 왼쪽으로 90도 회전
			else if (operation == 4) {
	
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						temp[m - 1 - j][i] = grid[i][j];
					}
				}
				
				int t = n;
				n = m;
				m = t;
				
			}
			// 오른쪽으로 그룹이동
			else if (operation == 5) {
	
				for (int i = 0; i < n / 2; i++) {
					for (int j = 0; j < m / 2; j++) {
						temp[i][j + m / 2] = grid[i][j];
					}
					for (int j = m / 2; j < m; j++) {
						temp[i + n / 2][j] = grid[i][j];
					}
				}
				for (int i = n / 2; i < n; i++) {
					for (int j = 0; j < m / 2; j++) {
						temp[i - n / 2][j] = grid[i][j];
					}
					for (int j = m / 2; j < m; j++) {
						temp[i][j - m / 2] = grid[i][j];
					}
				}
				
			}
			// 왼쪽으로 그룹이동
			else {
				
				for (int i = 0; i < n / 2; i++) {
					for (int j = 0; j < m / 2; j++) {
						temp[i + n / 2][j] = grid[i][j];
					}
					for (int j = m / 2; j < m; j++) {
						temp[i][j - m / 2] = grid[i][j];
					}
				}
				for (int i = n / 2; i < n; i++) {
					for (int j = 0; j < m / 2; j++) {
						temp[i][j + m / 2] = grid[i][j];
					}
					for (int j = m / 2; j < m; j++) {
						temp[i - n / 2][j] = grid[i][j];
					}
				}
				
			}
			
			// grid를 초기화하고 연산결과인 temp를 집어넣음
			grid = new int[max][max];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					grid[i][j] = temp[i][j];
				}
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
