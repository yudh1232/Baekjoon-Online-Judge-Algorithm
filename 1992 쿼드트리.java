package _0818;

import java.io.*;

public class BOJ_1992_쿼드트리 {

	static int n;
	static char[][] data;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		// n을 입력받음
		n = Integer.parseInt(in.readLine());
		
		// 영상을 입력받음
		data = new char[n][n];
		for (int i = 0; i < n; i++) {
			String s = in.readLine();
			for (int j = 0; j < n; j++) {
				data[i][j] = s.charAt(j);
			}
		}
		
		// 영상 압축(재귀)
		quadTree(n, 0, 0);
		
		// 결과 출력
		System.out.println(sb);
	}
	
	private static void quadTree(int n, int a, int b) {
		// 영상이 모두 0으로 되어있는지 또는 1로 되어있는지 확인하는 변수
		int sum = 0;
		
		// 기저조건
		if (n == 2) {
			
			// 영상의 값을 모두 더함
			sum = data[a][b] - '0' + data[a][b + 1] - '0' + data[a + 1][b] - '0' + data[a + 1][b + 1] - '0';
			
			// 영상이 모두 0
			if (sum == 0) {
				sb.append('0');
			}
			
			// 영상이 모두 1
			else if (sum == n * n) {
				sb.append('1');
			}
			
			// 영상이 섞여있는 경우
			else {
				sb.append('(');
				sb.append(data[a][b]).append(data[a][b + 1]).append(data[a + 1][b]).append(data[a + 1][b + 1]);
				sb.append(')');
			}
			
			return;
		}
		
		// 영상의 값을 모두 더함
		for (int i = a; i < a + n; i++) {
			for (int j = b; j < b + n; j++) {
				sum += data[i][j] - '0';
			}
		}
		
		// 영상이 모두 0
		if (sum == 0) {
			sb.append('0');
		}
		// 영상이 모두 1
		else if (sum == n * n) {
			sb.append('1');
		}
		// 영상이 섞여있는 경우, 4부분으로 나눔
		else {
			sb.append('(');
			quadTree(n / 2, a, b);
			quadTree(n / 2, a, b + n / 2);
			quadTree(n / 2, a + n / 2, b);
			quadTree(n / 2, a + n / 2, b + n / 2);
			sb.append(')');
		}
	}
	
}
