import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 무한으로 10억을 설정
		final int INF = 1000000000;
		
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 0 ; tc < TC; tc++) {
			int n = Integer.parseInt(in.readLine());
			
			// 좌표들을 입력받아 저장
			int[][] coordinates = new int[n + 2][2];
			for (int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(in.readLine());
				coordinates[i][0] = Integer.parseInt(st.nextToken());
				coordinates[i][1] = Integer.parseInt(st.nextToken());
			}
			
			// 각 좌표의 거리차이가 1000이하이면 연결된 상태
			// 1000보다 크면 연결되지 않은 상태인 그래프를 생성
			int graph[][] = new int[n + 2][n + 2];
			for (int i = 1; i < n + 2; i++) {
				for (int j = 0; j < i; j++) {
					int distance = Math.abs(coordinates[i][0] - coordinates[j][0]) + Math.abs(coordinates[i][1] - coordinates[j][1]);
					if (distance <= 1000) {
						graph[i][j] = 1;
						graph[j][i] = 1;
					}
					else {
						graph[i][j] = INF;
						graph[j][i] = INF;
					}
				}
			}
			
			// 플로이드 워셜 알고리즘 수행
			for (int k = 0; k < n + 2; k++) {
				for (int i = 0; i < n + 2; i++) {
					for (int j = 0; j < n + 2; j++) {
						graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
					}
				}
			}
			
			// 출력문 생성
			if (graph[0][n + 1] == INF)
				sb.append("sad").append("\n");
			else {
				sb.append("happy").append("\n");
			}
		}
		
		// 결과 출력
		System.out.println(sb);
	}
	
}
