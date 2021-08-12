import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static boolean[] isSelected;
	static int[] sour;
	static int[] bitterness;
	static int min = 1000000000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		isSelected = new boolean[n];
		sour = new int[n];
		bitterness = new int[n];
		
		// 신맛과 쓴맛을 입력받아 신맛 배열, 쓴맛 배열에 넣음
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			sour[i] = Integer.parseInt(st.nextToken());
			bitterness[i] = Integer.parseInt(st.nextToken());
		}
		
		// 부분집합 생성
		generateSubset(0);
		
		// 결과 출력
		System.out.println(min);
	}
	
	private static void generateSubset(int cnt) {
		// 부분집합이 완성되었을 때
		if (cnt == n) {
			int totalSour = 1;
			int totalBitter = 0;
			
			// 선택된 재료의 수를 나타내는 변수
			int count = 0;
			// 선택된 재료라면 신맛은 곱하고 쓴맛은 더함
			for (int i = 0; i < n; i++) {
				if (isSelected[i]) {
					totalSour *= sour[i];
					totalBitter += bitterness[i];
					count++;
				}
			}
			// 재료를 한 개도 선택안한 경우
			if (count == 0) return;
			
			// 최솟갑 구하기
			min = Math.min(min, Math.abs(totalSour - totalBitter));
			return;
		}
		
		// 부분집합 생성
		isSelected[cnt] = true;
		generateSubset(cnt + 1);
		
		isSelected[cnt] = false;
		generateSubset(cnt + 1);
	}
}
