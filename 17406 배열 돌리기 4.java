import java.io.*;
import java.util.*;

public class Main {

	static int[][] grid;
	static int n, m, k;
	static int[] numbers; // 순열을 저장하기 위한 배열
	static boolean[] isSelected; // 순열을 뽑기 위한 배열
	static int[][] rotateInfo; // 회전 정보를 담는 배열
	static int minValue = 5000;
	
	private static void rotate() {
		// temp 배열에 grid 배열을 복사한 후 temp 배열을 회전
		int[][] temp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				temp[i][j] = grid[i][j];
			}
		}
		
		for (int a = 0; a < k; a++) {
			int r = rotateInfo[numbers[a]][0];
			int c = rotateInfo[numbers[a]][1];
			int S = rotateInfo[numbers[a]][2];
			
			// 회전
			for (int s = 1; s <= S; s++) {
				int t = temp[r - s][c - s];
				for (int i = r - s + 1; i <= r + s; i++) {
					temp[i - 1][c - s] = temp[i][c -s];
				}
				for (int j = c - s + 1; j <= c + s; j++) {
					temp[r + s][j - 1] = temp[r + s][j];
				}
				for (int i = r + s - 1; i >= r - s; i--) {
					temp[i + 1][c + s] = temp[i][c + s];
				}
				for (int j = c + s - 1; j >= c - s; j--) {
					temp[r - s][j + 1] = temp[r - s][j];
				}
				temp[r - s][c - s + 1] = t;
			}
						
		}
		
		// 결과값 계산
		int value = 0;
		for (int i = 1; i <= n; i++) {
			value = 0;
			for (int j = 1; j <= m; j++) {
				value += temp[i][j];
			}
			minValue = Math.min(minValue, value);
		}		
	}
	
	private static void permutation(int cnt) {
		// 순열이 완성되면 회전 후 결과값 계산
		if (cnt == k) {
			rotate();
			return;
		}
		
		for (int i = 0; i < k; i++) {
			if (isSelected[i]) continue;
			
			numbers[cnt] = i;
			isSelected[i] = true;
			
			permutation(cnt + 1);
			
			isSelected[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// n, m, k를 입력받음
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		// 순열을 뽑기위한 배열
		numbers = new int[k];
		isSelected = new boolean[k];
		
		// 2차원 배열 정보를 입력받음
		grid = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= m; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 회전 정보를 입력받음
		rotateInfo = new int[k][3];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				rotateInfo[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 회전 연산 적용 순서를 순열로 뽑고, 회전 후 결과값 계산
		permutation(0);
		
		System.out.println(minValue); // 결과 출력
	}
	
}
