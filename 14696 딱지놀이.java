import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// n을 입력받음
		int n = Integer.parseInt(in.readLine());
		
		// a와 b의 모양 수 배열
		int[] a = new int[5];
		int[] b = new int[5];
		
		// a와 b가 내는 딱지에 나온 그림의 총 개수 변수
		int k = 0;
		
		// n번의 라운드 진행
		for (int i = 0; i < n; i++) {
			// a
			st = new StringTokenizer(in.readLine());
			k = Integer.parseInt(st.nextToken());
			// 각 모양별로 개수를 배열에 업데이트
			for (int j = 0; j < k; j++) {
				a[Integer.parseInt(st.nextToken())]++;
			}
			
			// b
			st = new StringTokenizer(in.readLine());
			k = Integer.parseInt(st.nextToken());
			// 각 모양별로 개수를 배열에 업데이트
			for (int j = 0; j < k; j++) {
				b[Integer.parseInt(st.nextToken())]++;
			}
			
			// 별모양부터 세모모양까지 개수 비교
			for (int j = 4; j > 0; j--) {
				if (a[j] > b[j]) {
					sb.append("A").append("\n");
					break;
				}
				else if (a[j] < b[j]) {
					sb.append("B").append("\n");
					break;
				}
				else {
					if (j == 1) sb.append("D").append("\n");
					else continue;
				}
			}
			
			// 다음 라운드로 가기 전 a와 b의 모양 수 초기화
			for (int j = 1; j <= 4; j++) {
				a[j] = 0;
				b[j] = 0;
			}
		}
		
		System.out.println(sb); // 결과 출력
	}
	
}
