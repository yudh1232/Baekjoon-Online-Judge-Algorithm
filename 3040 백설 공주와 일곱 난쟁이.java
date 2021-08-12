import java.io.*;

public class Main {

	static int[] numbers;
	static int[] input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		numbers = new int[7];
		input = new int[9];
		
		// 난쟁이의 키를 배열에 넣음
		for (int i = 0; i < 9; i++) {
			input[i] = Integer.parseInt(in.readLine());
		}
		
		// 7개 뽑기
		combination(0, 0);
	}
	
	private static void combination(int cnt, int start) {
		// 7개 뽑았으면
		if (cnt == 7) {
			// 합 구하기
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += numbers[i];
			}
			
			// 합이 100이면 출력
			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(numbers[i]);
				}
			}
			return;
		}
		
		// 조합 뽑기
		for (int i = start; i < 9; i++) {
			numbers[cnt] = input[i];
			combination(cnt + 1, i + 1);
		}
	}
}
