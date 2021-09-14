import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// n을 입력받음
		int n = Integer.parseInt(in.readLine());
		
		// n이 1일때
		if (n == 1) {
			System.out.println(0);
			return;
		}
		
		// n이 2 또는 3일때
		if (n == 2 || n == 3) {
			System.out.println(1);
			return;
		}
		// dp 배열 초기화
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		
		// dp를 이용해 계산
		for (int i = 4; i <= n; i++) {
			// i가 2와 3으로 안 나누어 떨어질 때
			if (i % 2 != 0 && i % 3 != 0) {
				dp[i] = dp[i - 1] + 1;
			}
			// i가 2로 나누어 떨어질 때
			else if (i % 2 == 0 && i % 3 != 0) {
				dp[i] = Math.min(dp[i - 1] + 1, dp[i / 2] + 1);
			}
			// i가 3으로 나누어 떨어질 때
			else if (i % 2 != 0 && i % 3 == 0) {
				dp[i] = Math.min(dp[i - 1] + 1, dp[i / 3] + 1);
			}
			// i가 2와 3으로 나누어 떨어질 때
			else { // i % 2 == 0 && i % 3 == 0
				int temp = Math.min(dp[i - 1] + 1, dp[i / 2] + 1);
				dp[i] = Math.min(temp, dp[i / 3] + 1);
			}
		}
		
		// 결과 출력
		System.out.println(dp[n]);
	}
	
}
