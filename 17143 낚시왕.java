package _0930;

import java.io.*;
import java.util.*;

public class BOJ_17143_낚시왕 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// r, c, m을 입력받음
		StringTokenizer st = new StringTokenizer(in.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// 격자 배열과 상어정보 배열 생성
		int[][] grid = new int[r + 1][c + 1];
		int[][] shark = new int[m + 1][5];
		
		// 상어정보를 입력받고, 격자에 상어를 위치시킴
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 5; j++) {
				shark[i][j] = Integer.parseInt(st.nextToken());
			}
			grid[shark[i][0]][shark[i][1]] = i;
		}
		
		// 결과값
		int answer = 0;
		
		// 낚시왕이 오른쪽으로 한 칸씩 이동
		for (int i = 1; i <= c; i++) {
			// 상어잡기, 해당 열의 위에서부터 아래로 살핌
			for (int j = 1; j <= r; j++) {
				// 상어가있으면
				if (grid[j][i] != 0) {
					answer += shark[grid[j][i]][4]; // 결과값에 추가
					shark[grid[j][i]][4] = 0; // 해당상어를 없앰
					break; // 상어잡기 끝
				}
			}
			
			// 상어이동, 새로운 격자 배열 생성
			grid = new int[r + 1][c + 1];
			for (int j = 1; j <= m; j++) {
				// 해당 상어가 살아있으면, 이동한 위치를 계산하여 격자에 넣어줌
				if (shark[j][4] != 0) {
					// 상어의 방향이 1이면
					if (shark[j][3] == 1) {
						int x = shark[j][2] % (2 * (r - 1));
						if (shark[j][0] - x >= 1) {
							shark[j][0] = shark[j][0] - x;
						}
						else if (shark[j][0] - x > 1 - r) {
							shark[j][0] = 2 - shark[j][0] + x;
							shark[j][3] = 2;
						}
						else {
							shark[j][0] = 2 * (r - 1) + shark[j][0] - x;
						}
					}
					// 상어의 방향이 2이면
					else if (shark[j][3] == 2) {
						int x = shark[j][2] % (2 * (r - 1));
						if (shark[j][0] + x <= r) {
							shark[j][0] = shark[j][0] + x;
						}
						else if (shark[j][0] + x < 2 * r) {
							shark[j][0] = 2 * r - shark[j][0] - x;
							shark[j][3] = 1;
						}
						else {
							shark[j][0] = shark[j][0] + x - (2 * (r - 1));
						}
					}
					// 상어의 방향이 3이면
					else if (shark[j][3] == 3) {
						int x = shark[j][2] % (2 * (c - 1));
						if (shark[j][1] + x <= c) {
							shark[j][1] = shark[j][1] + x;
						}
						else if (shark[j][1] + x < 2 * c) {
							shark[j][1] = 2 * c - shark[j][1] - x;
							shark[j][3] = 4;
						}
						else {
							shark[j][1] = shark[j][1] + x - (2 * (c - 1));
						}
					}
					// 상어의 방향이 4이면
					else {
						int x = shark[j][2] % (2 * (c - 1));
						if (shark[j][1] - x >= 1) {
							shark[j][1] = shark[j][1] - x;
						}
						else if (shark[j][1] - x > 1 - c) {
							shark[j][1] = 2 - shark[j][1] + x;
							shark[j][3] = 3;
						}
						else {
							shark[j][1] = 2 * (c - 1) + shark[j][1] - x;
						}
					}
					// 격자에 이미 다른상어가 있으면, 크기가 작은 상어는 잡아먹히고 큰 상어가 위치함
					if (grid[shark[j][0]][shark[j][1]] != 0) {
						if (shark[grid[shark[j][0]][shark[j][1]]][4] > shark[j][4]) {
							shark[j][4] = 0;
						}
						else {
							shark[grid[shark[j][0]][shark[j][1]]][4] = 0;
							grid[shark[j][0]][shark[j][1]] = j;
						}
					}
					// 격자에 다른상어가 없으면, 격자에 그냥 들어감
					else {
						grid[shark[j][0]][shark[j][1]] = j;
					}
				}
			}
		}
		
		// 결과 출력
		System.out.println(answer);
	}
	
}
