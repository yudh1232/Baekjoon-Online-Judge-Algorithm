import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] grid;
	static boolean[][] selected;
	
	// 불린 수를 체크함
	private static void checkNum(int num) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (grid[i][j] == num) {
					selected[i][j] = true;
					return;
				}
			}
		}
	}
	
	// 빙고가 생겼는지 체크
	private static int checkBingo() {
		boolean bingoFlag;
		int bingoCnt = 0;
		
		// 가로줄 체크
		for (int i = 0; i < 5; i++) {
			bingoFlag = true;
			for (int j = 0; j < 5; j++) {
				if (selected[i][j] == false) {
					bingoFlag = false;
					break;
				}
			}
			if (bingoFlag == true) bingoCnt += 1;
		}
		
		// 세로줄 체크
		for (int j = 0; j < 5; j++) {
			bingoFlag = true;
			for (int i = 0; i < 5; i++) {
				if (selected[i][j] == false) {
					bingoFlag = false;
					break;
				}
			}
			if (bingoFlag == true) bingoCnt += 1;
		}
		
		// 대각선 체크
		bingoFlag = true;
		for (int i = 0; i < 5; i++) {
			if (selected[i][i] == false) bingoFlag = false;
		}
		if (bingoFlag == true) bingoCnt += 1;
		
		// 대각선 체크
		bingoFlag = true;
		for (int i = 0; i < 5; i++) {
			if (selected[i][4 - i] == false) bingoFlag = false;
		}
		if (bingoFlag == true) bingoCnt += 1;
		
		return bingoCnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		grid = new int[5][5]; // 빙고판 2차원 배열
		selected = new boolean[5][5]; // 불린 수를 체크하는 2차원 배열
		
		// 빙고판에 숫자를 입력받음
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		loop:
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				// 불린 수를 체크함
				checkNum(Integer.parseInt(st.nextToken()));
				// 빙고가 3개이상 나왔다면
				if (checkBingo() >= 3) {
					System.out.println(5 * i + j + 1); // 결과 출력
					break loop;
				}
			}
		}
	}
	
}
