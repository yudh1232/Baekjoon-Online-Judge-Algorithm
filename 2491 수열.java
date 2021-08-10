import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());
		int[] data = new int[n];

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		// n이 1일 때
		if (n == 1)
			max = 1;
		// n이 2이상 일때
		else {
			int condition = 0; // 0: 초기부터 같은값 유지중, 1: 증가중, 2: 감소중
			int count = 1; // 증가중 또는 감소중인 수열의 길이
			int equalCount = 1; // 같은값 유지중인 수열의 길이

			for (int i = 1; i < n; i++) {
				// 수열이 초기부터 같은값 유지중일 때
				if (condition == 0) {
					// 현재값이 이전값보다 크다면
					if (data[i - 1] < data[i]) {
						condition = 1;
						count++;
						equalCount = 1;
					}
					// 현재값과 이전값이 같다면
					else if (data[i - 1] == data[i]) {
						count++;
						equalCount++;
					}
					// 현재값이 이전값보다 작다면
					else {
						condition = 2;
						count++;
						equalCount = 1;
					}
				}
				// 수열이 증가중일 때
				else if (condition == 1) {
					// 현재값이 이전값보다 크다면
					if (data[i - 1] < data[i]) {
						count++;
						equalCount = 1;
					}
					// 현재값과 이전값이 같다면
					else if (data[i - 1] == data[i]) {
						count++;
						equalCount++;
					}
					// 현재값이 이전값보다 작다면
					else {
						condition = 2;
						count = equalCount + 1;
						equalCount = 1;
					}
				}
				// 수열이 감소중일 때
				else {
					// 현재값이 이전값보다 크다면
					if (data[i - 1] < data[i]) {
						condition = 1;
						count = equalCount + 1;
						equalCount = 1;
					}
					// 현재값과 이전값이 같다면
					else if (data[i - 1] == data[i]) {
						count++;
						equalCount++;
					}
					// 현재값이 이전값보다 작다면
					else {
						count++;
						equalCount = 1;
					}
				}
				
				// 최대값 갱신
				if (count > max) max = count;
			}			
		}		
		System.out.println(max); // 결과 출력
	}

}
