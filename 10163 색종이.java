import java.io.*;
import java.util.*;

public class BOJ_10163_색종이 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// n을 입력받음
		int n = Integer.parseInt(in.readLine());
		// grid 2차원배열 생성
		int[][] grid = new int[1001][1001];
		// 색종이 2차원배열 생성. 좌표, 너비, 높이를 담음
		int[][] paper = new int[n][4];
		
		// 색종이들을 grid에 표시. 나중에 들어온 색종이는 이전에 들어온 색종이를 덮어씀
		for (int k = 0; k < n; k++) {
			st = new StringTokenizer(in.readLine());
			paper[k][0] = Integer.parseInt(st.nextToken());
			paper[k][1] = Integer.parseInt(st.nextToken());
			paper[k][2] = Integer.parseInt(st.nextToken());
			paper[k][3] = Integer.parseInt(st.nextToken());
			
			for (int i = paper[k][0]; i < paper[k][0] + paper[k][2]; i++) {
				for (int j = paper[k][1]; j < paper[k][1] + paper[k][3]; j++) {
					grid[i][j] = k;
				}
			}
		}
		
		// 색종이들의 면적 계산
		for (int k = 0; k < n; k++) {
			int area = 0;
			for (int i = paper[k][0]; i < paper[k][0] + paper[k][2]; i++) {
				for (int j = paper[k][1]; j < paper[k][1] + paper[k][3]; j++) {
					if (grid[i][j] == k) area++;
				}
			}
			sb.append(area).append("\n"); // 출력문 생성
		}
		
		System.out.println(sb); // 결과 출력
	}
	
}
