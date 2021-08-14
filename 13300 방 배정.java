import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// n, k를 입력받음
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		// 학년, 성별에따른 학생 수 배열
		int[][] studentCnt = new int[6][2];
		
		// 학생 정보를 입력받고, 학생 수 배열 업데이트
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			studentCnt[y - 1][s]++;
		}
		
		// 방의 개수 계산
		int roomCnt = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 2; j++) {
				roomCnt += studentCnt[i][j] / k;
				if (studentCnt[i][j] % k != 0) roomCnt++;
			}
		}
		
		System.out.println(roomCnt); // 결과 출력
	}
	
}
