package com.algo.hw18;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// n을 입력받음
		int n = Integer.parseInt(in.readLine());
		
		// 각 집을 빨강, 초록, 파랑으로 칠하는 비용을 입력받음
		int[][] cost = new int[n][3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// dp 이용, dp 초기값 초기화
		int[][] dp = new int[n][3];
		dp[0][0] = cost[0][0];
		dp[0][1] = cost[0][1];
		dp[0][2] = cost[0][2];
		
		for (int i = 1; i < n; i++) {
			// 0열은 dp배열의 이전 행의 1열과 2열의값 중 작은것과 cost배열의 현재 행의 값을 더해서 구함
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
			// 1열은 dp배열의 이전 행의 0열과 2열의값 중 작은것과 cost배열의 현재 행의 값을 더해서 구함
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
			// 2열은 dp배열의 이전 행의 0열과 1열의값 중 작은것과 cost배열의 현재 행의 값을 더해서 구함
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
		}
		
		// dp 배열의 n-1행의 값들 중에서 최소값이 결과값
		int answer = Math.min(dp[n - 1][0], dp[n - 1][1]);
		answer = Math.min(answer, dp[n - 1][2]);
		
		// 결과값 출력
		System.out.println(answer);
	}
	
}
