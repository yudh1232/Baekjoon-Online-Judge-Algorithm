import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 도화지 배열
		int[][] paper = new int[100][100];
		
		int n = Integer.parseInt(in.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int a = y; a < y + 10; a++) {
				for (int b = x; b < x + 10; b++) {
					// 검은 영역을 1로 표시
					paper[a][b] = 1;
				}
			}
		}
		
		// 검은 영역의 넓이 계산
		int area = 0;
		for (int i = 1; i < 100; i++) {
			for (int j = 1; j < 100; j++) {
				if (paper[i][j] == 1) area++;
			}
		}
		
		// 결과 출력
		System.out.println(area);
	}
	
}
