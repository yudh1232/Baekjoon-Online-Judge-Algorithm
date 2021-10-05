import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// n, d, k, c를 입력받음
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		 
		// 벨트 배열 생성, 벨트 정보를 입력받음
		int[] belt = new int[n];
		for (int i = 0; i < n; i++) {
			belt[i] = Integer.parseInt(in.readLine());
		}
		
		// i번 번호의 초밥이 선택된 횟수를 나타내는 배열
		int[] isSelected = new int[d + 1];
		
		// 현재 선택된 초밥을 나타내는 큐
		Queue<Integer> q = new LinkedList<Integer>();
		
		// 큐에 중복된 초밥이 들어가있는 횟수
		int duplicateCount = 0;
		
		// 벨트의 0번째부터 k - 1번째까지
		for (int i = 0; i < k; i++) {
			// 큐에 넣고, isSelected[belt[i]]를 증가
			q.offer(belt[i]);
			isSelected[belt[i]]++;
			
			// 만약 큐에 중복된 값이 있는 경우 duplicateCount를 증가
			if (isSelected[belt[i]] != 1) duplicateCount++;
		}
		
		// 결과값 변수
		int answer = 0;
		
		for (int i = k, j; i < n + k; i++) {
			// 결과값 갱신
			if (isSelected[c] == 0) { // 선택된 것중에 c가없다면, 현재 초밥의 가지수는 q.size() - duplicateCount + 1
				if (q.size() - duplicateCount + 1 > answer)
					answer = q.size() - duplicateCount + 1;
			}
            else { // 선택된 것중에 c가있다면, 현재 초밥의 가지수는 q.size() - duplicateCount
            	if (q.size() - duplicateCount > answer)
					answer = q.size() - duplicateCount;
            }
			
			// 슬라이딩 윈도우, 큐에서 하나를 poll하고 하나를 offer함
			int x = q.poll();
			isSelected[x]--;
			if (isSelected[x] != 0) duplicateCount--;
			
			if (i >= n) j = i - n;
			else j = i;
			
			q.offer(belt[j]);
			isSelected[belt[j]]++;
			if (isSelected[belt[j]] != 1) duplicateCount++;
		}
		
		// 결과 출력
		System.out.println(answer);
	}
	
}
