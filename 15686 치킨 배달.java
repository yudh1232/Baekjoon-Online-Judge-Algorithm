import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	static int[][] grid;
	static int[][] store;
	static int storeCnt;
	static int[] numbers;
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// n, m을 입력받음
		st = new StringTokenizer(in.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 도시 정보를 입력받고, 치킨집의 개수를 셈
		grid = new int[n][n];
		storeCnt = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < n; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if (grid[i][j] == 2) {
					storeCnt++;
				}
			}
		}
		
		// 치킨집의 좌표를 store 2차원 배열에 저장
		store = new int[storeCnt][2];
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 2) {
					store[temp][0] = i;
					store[temp][1] = j;
					temp++;
				}
			}
		}
		
		
		numbers = new int[m];
		result = 250000; // 결과값 변수
		
		// 치킨집중에서 m개를 뽑는 모든 경우에 대하여, 가장 치킨거리가 작게나오는 값을 구함
		combination(0, 0);
		
		System.out.println(result); // 결과 출력

	}
	
	// 치킨집중에서 m개를 뽑음
	private static void combination(int cnt, int start) {
		if (cnt == m) {
			// 치킨거리 계산
			chickDistCalc();			
			return;
		}
		
		for (int i = start; i < storeCnt; i++) {
			numbers[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}
	
	// 치킨거리 계산
	private static void chickDistCalc() {
		int dist = 0; // 집에서 치킨집까지의 거리 변수
		int min = 0; // 집에서 가장 가까운 치킨집까지의 거리 변수
		int sum = 0; // 각 집들의 가장 가까운 치킨집까지의 거리의 합 변수
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					min = 2500;
					for (int k = 0; k < m; k++) {
						dist = Math.abs(i - store[numbers[k]][0]) + Math.abs(j - store[numbers[k]][1]);
						min = Math.min(min, dist);
					}
					sum += min;
				}
			}
		}
		result = Math.min(result, sum);
	}
}
