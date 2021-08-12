import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// n을 입력받음
		int n = Integer.parseInt(in.readLine());
		int[][] dices = new int[n][6]; // 주사위 2차원 배열
		
		// 주사위 정보를 입력받아 2차원 배열에 넣음
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 6; j++) {
				dices[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int underIdx = 0; // 밑면의 인덱스
		int topIdx = 0; // 윗면의 인덱스
		int underValue = 0; // 밑면의 값
		int topValue = 0; // 윗면의 값
		int maxResult = 0; // 결과값
		// 1번 주사위의 면 6가지에 대하여
		for (int k = 0; k < 6; k++) {
			underIdx = k;
			topIdx = getOpposition(k);
			underValue = dices[0][underIdx];
			topValue = dices[0][topIdx];
			
			int result = 0;
			result += getSideMaxValue(underValue, topValue); // 옆면 중 최대값을 더함
			
			// 2번 주사위부터 n번 주사위까지
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < 6; j++) {
					// 이전 주사위의 윗면값이 이번 주사위의 밑면값이 됨
					if (dices[i][j] == topValue) {
						underIdx = j;
						topIdx = getOpposition(j);
						underValue = dices[i][underIdx];
						topValue = dices[i][topIdx];
						result += getSideMaxValue(underValue, topValue); // 옆면 중 최대값을 더함
						break;
					}
				}
			}
			// 결과값은 1번 주사위의 밑면 6가지 경우 중에서 최대인 값
			maxResult = Math.max(maxResult, result);
		}
		
		System.out.println(maxResult); // 결과값 출력
		
	}
	
	// 현재면의 반대면의 인덱스 반환
	private static int getOpposition(int i) {
		if (i == 0) return 5;
		else if (i == 1) return 3;
		else if (i == 2) return 4;
		else if (i == 3) return 1;
		else if (i == 4) return 2;
		else return 0;
	}
	
	// 윗면과 아랫면의 값을 전달받아 옆면의 최대값을 반환
	private static int getSideMaxValue(int a, int b) {
		int max, min;
		if (a > b) {
			max = a;
			min = b;
		}
		else {
			max = b;
			min = a;
		}
		if (max != 6) return 6;
		else if (min != 5) return 5;
		else return 4;
	}
	
}
