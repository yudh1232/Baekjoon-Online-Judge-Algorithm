package _0812;

import java.io.*;
import java.util.*;

public class BOJ_2669_직사각형네개의합집합의면적구하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 직사각형을 표현하기 위한 2차원 배열
		int[][] grid = new int[100][100];
		for (int k = 0; k < 4; k++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			// 직사각형들을 2차원 배열에 1로 표시
			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					grid[i][j] = 1;
				}
			}
		}
		
		// grid에서 1의 개수를 카운트함
		int count = 0;
		for (int i = 1; i < 100; i++) {
			for (int j = 1; j < 100; j++) {
				if (grid[i][j] == 1) count++;
			}
		}
		
		System.out.println(count); // 결과 출력
	}
	
}
