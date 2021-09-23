import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] text = in.readLine().toCharArray();
		char[] pattern = in.readLine().toCharArray();
		
		int tLength = text.length;
		int pLength = pattern.length;
		
		// 실패함수 생성
		int[] pi = new int[pLength];
	    for (int i = 1, j = 0; i < pLength; i++) {
	        while (j > 0 && pattern[i] != pattern[j]) {
	        	j = pi[j - 1];  
	        }
	        if (pattern[i] == pattern[j]) pi[i] = ++j;
	    }
		
	    // 문자열 매칭
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0, j = 0; i < tLength; i++) { 
			
			while (j > 0 && text[i] != pattern[j]) j = pi[j - 1]; 
			
			if (text[i] == pattern[j]) {
				if (j == pLength - 1) {
					cnt++;
					list.add((i + 1) - pLength); 
					j = pi[j]; 
				}
				else { 
					j++;
				}
			}
		}
		
		// 출력문 생성
		sb.append(cnt).append("\n");
		if(cnt > 0) {
			for (int i = 0; i < list.size(); i++) {
				sb.append(list.get(i) + 1).append(" ");
			}
		}
		
		// 결과 출력
		System.out.println(sb);
	}
	
}
