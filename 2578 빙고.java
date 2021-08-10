import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] grid;
	static boolean[][] selected;
	
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
	
	private static int checkBingo() {
		boolean bingoFlag;
		int bingoCnt = 0;
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
		
		bingoFlag = true;
		for (int i = 0; i < 5; i++) {
			if (selected[i][i] == false) bingoFlag = false;
		}
		if (bingoFlag == true) bingoCnt += 1;
		
		bingoFlag = true;
		for (int i = 0; i < 5; i++) {
			if (selected[i][4 - i] == false) bingoFlag = false;
		}
		if (bingoFlag == true) bingoCnt += 1;
		
		return bingoCnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		grid = new int[5][5];
		selected = new boolean[5][5];
		
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
				checkNum(Integer.parseInt(st.nextToken()));
				if (checkBingo() >= 3) {
					System.out.println(5 * i + j + 1);
					break loop;
				}
			}
		}
	}
	
}
