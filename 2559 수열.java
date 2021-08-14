import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// n, k를 입력받음
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		// 온도 수열을 입력받아 data배열에 넣음
		int[] data = new int[n];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		// 다이나믹 프로그래밍용 dp배열 생성, data[0] ~ data[k - 1]의 합을 dp[0]에 넣어줌 
		int[] dp = new int[n - k + 1];
		for (int i = 0; i < k; i++) {
			dp[0] += data[i];
		}
		
		// front와 rear 두 개의 포인터를 이용
		int frontIdx = 0;
		int rearIdx = k;
		int max = dp[0]; //결과값 변수
		for (int i = 1; i < n - k + 1; i++) {
			dp[i] = dp[i - 1] - data[frontIdx] + data[rearIdx];
			frontIdx++;
			rearIdx++;
			max = Math.max(max, dp[i]); // 결과값 업데이트
		}
		
		System.out.println(max); // 결과 출력
	}
	
}
