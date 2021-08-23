package _0823;

import java.io.*;
import java.util.*;

public class BOJ_1759_암호만들기 {
	
	static char[] answer, data;
	static int l, c;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		// l, c를 입력받음
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		answer = new char[l];
		data = new char[c];
		
		// c개의 문자를 입력받음
		st = new StringTokenizer(in.readLine(), " ");		
		for (int i = 0; i < c; i++) {
			data[i] = st.nextToken().charAt(0);
		}
		
		// 오름차순 정렬
		Arrays.sort(data);
		
		// 가능성 있는 암호 찾기
		combination(0, 0);
		
		// 결과 출력
		System.out.println(sb);
	}
	
	// c개의 문자중 l개를 뽑고, 자음이 2개이상, 모음이 1개이상이라면 출력문에 넣음
	private static void combination(int cnt, int start) {
		
		// l개를 뽑았으면
		if (cnt == l) {
			int consonantCnt = 0;
			int vowelCnt = 0;
			
			// 자음, 모음개수 세기
			for (int j = 0; j < l; j++) {
				if (answer[j] == 'a' || answer[j] == 'e' || answer[j] == 'i' || answer[j] == 'o' || answer[j] == 'u') {
					vowelCnt++;
				}
				else {
					consonantCnt++;
				}
			}
			
			// 자음이 2개이상, 모음이 1개이상이라면 출력문에 넣음
			if (consonantCnt >= 2 && vowelCnt >= 1) sb.append(new String(answer)).append("\n");
			return;
		}
		
		for (int i = start; i < c; i++) {
			answer[cnt] = data[i];
			combination(cnt + 1, i + 1);
		}
	}
	
}
