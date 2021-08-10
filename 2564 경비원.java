import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int k = Integer.parseInt(in.readLine());
		int[][] input = new int[k][2];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(in.readLine(), " ");
		int dir = Integer.parseInt(st.nextToken());
		int value = Integer.parseInt(st.nextToken());

		int sum = 0; // 결과값 변수
		// 동근이의 방향이 북쪽일 때
		if (dir == 1) {
			for (int i = 0; i < k; i++) {
				int temp;
				// 상점의 방향이 북쪽일 때
				if (input[i][0] == 1) {
					temp = Math.abs(value - input[i][1]);
				}
				// 상점의 방향이 남쪽일 때
				else if (input[i][0] == 2) {
					if (value + input[i][1] <= m) temp = n + value + input[i][1];
					else temp = n + 2 * m - (value + input[i][1]);
				}
				// 상점의 방향이 서쪽일 때
				else if (input[i][0] == 3) {
					temp = value + input[i][1];
				}
				// 상점의 방향이 동쪽일 때
				else {
					temp = m - value + input[i][1];
				}
				sum += temp;
			}
		}
		// 동근이의 방향이 남쪽일 때
		else if (dir == 2) {
			for (int i = 0; i < k; i++) {
				int temp;
				// 상점의 방향이 북쪽일 때
				if (input[i][0] == 1) {
					if (value + input[i][1] <= m) temp = n + value + input[i][1];
					else temp = n + 2 * m - (value + input[i][1]);
				}
				// 상점의 방향이 남쪽일 때
				else if (input[i][0] == 2) {
					temp = Math.abs(value - input[i][1]);
				}
				// 상점의 방향이 서쪽일 때
				else if (input[i][0] == 3) {
					temp = value + n - input[i][1];
				}
				// 상점의 방향이 동쪽일 때
				else {
					temp = m - value + n - input[i][1];
				}
				sum += temp;
			}
		}
		// 동근이의 방향이 서쪽일 때
		else if (dir == 3) {
			for (int i = 0; i < k; i++) {
				int temp;
				// 상점의 방향이 북쪽일 때
				if (input[i][0] == 1) {
					temp = value + input[i][1];
				}
				// 상점의 방향이 남쪽일 때
				else if (input[i][0] == 2) {
					temp = n - value + input[i][1];
				}
				// 상점의 방향이 서쪽일 때
				else if (input[i][0] == 3) {
					temp = Math.abs(value - input[i][1]);
				}
				// 상점의 방향이 동쪽일 때
				else {
					if (value + input[i][1] <= n) temp = m + value + input[i][1];
					else temp = m + 2 * n - (value + input[i][1]);
				}
				sum += temp;
			}
		}
		// 동근이의 방향이 동쪽일 때
		else {
			for (int i = 0; i < k; i++) {
				int temp;
				// 상점의 방향이 북쪽일 때
				if (input[i][0] == 1) {
					temp = value + m - input[i][1];
				}
				// 상점의 방향이 남쪽일 때
				else if (input[i][0] == 2) {
					temp = n - value + m - input[i][1];
				}
				// 상점의 방향이 서쪽일 때
				else if (input[i][0] == 3) {
					if (value + input[i][1] <= n) temp = m + value + input[i][1];
					else temp = m + 2 * n - (value + input[i][1]);
				}
				// 상점의 방향이 동쪽일 때
				else {
					temp = Math.abs(value - input[i][1]);
				}
				sum += temp;
			}
		}
		
		// 결과 출력
		System.out.println(sum);
	}

}
