package _0810;

import java.io.*;
import java.util.*;

public class BOJ_1158_요세푸스문제 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		// 링크드리스트에 1부터 n까지 넣음
		LinkedList<Integer> data = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			data.add(i);
		}

		// 
		int index = 0;
		int[] answer = new int[n];
		for (int i = 0; i < n; i++) {
			// 링크드리스트에서 요세푸스 순열에 따라 숫자를 뺌
			index = (index + k - 1) % data.size();
			answer[i] = data.get(index);
			data.remove(index);
		}
		
		// 출력문 생성
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for (int i = 0; i < n; i ++) {
			sb.append(answer[i]).append(",").append(" ");
		}
		sb.setLength(sb.length() - 2);
		sb.append(">");
		
		System.out.println(sb); // 결과 출력
	}
	
}
