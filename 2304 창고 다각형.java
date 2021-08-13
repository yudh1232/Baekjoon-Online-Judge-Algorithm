import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// n을 입력받음
		int n = Integer.parseInt(in.readLine());
		
		// (l, h)를 2차원 배열에 저장
		int[][] data = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 2; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// data를 l을 기준으로 오름차순 정렬
		Arrays.sort(data, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}			
		});
		
		// 가장 큰 높이 구하기
		int maxH = 0;
		for (int i = 0; i < n; i++) {
			maxH = Math.max(maxH, data[i][1]);
		}
		
		// 가장 큰 높이의 기둥 수 구하기
		int maxHPillarCnt = 0;		
		for (int i = 0; i < n; i++) {
			if (data[i][1] == maxH) maxHPillarCnt++;
		}
		
		int area = 0; // 결과값 변수
		
		// 가장 큰 높이의 기둥 수가 1이면
		if (maxHPillarCnt == 1) {
			
			// 가장 큰 높이 기둥의 index를 구함
			int maxHPillarIdx = -1;
			for (int i = 0; i < n; i++) {
				if (data[i][1] == maxH) {
					maxHPillarIdx = i;
					break;
				}
			}
			
			// 처음부터 가장 큰 높이 기둥을 만날때까지의 넓이 계산
			int nowIdx = 0;
			for (int i = 1; i <= maxHPillarIdx; i++) {
				int nextIdx = i;
				if (data[nowIdx][1] < data[nextIdx][1]) {
					area += (data[nextIdx][0] - data[nowIdx][0]) * data[nowIdx][1];
					nowIdx = i;
				}
			}
			
			// 가장 큰 높이 기둥의 넓이 계산
			area += data[maxHPillarIdx][1];
			
			// 마지막부터 가장 큰 높이 기둥을 만날때까지의 넓이 계산
			nowIdx = n - 1; 
			for (int i = n - 2; i >= maxHPillarIdx; i--) {
				int nextIdx = i;
				if (data[nowIdx][1] < data[nextIdx][1]) {
					area += (data[nowIdx][0] - data[nextIdx][0]) * data[nowIdx][1];
					nowIdx = i;
				}
			}
		}
		// 가장 큰 높이의 기둥 수가 2이상이면
		else if (maxHPillarCnt >= 2) {
			
			// 왼쪽에 있는 가장 큰 높이 기둥의 index를 구함
			int maxHLeftPillarIdx = -1;
			for (int i = 0; i < n; i++) {
				if (data[i][1] == maxH) {
					maxHLeftPillarIdx = i;
					break;
				}
			}
			// 오른쪽에 있는 가장 큰 높이 기둥의 index를 구함
			int maxHRightPillarIdx = -1;
			for (int i = n - 1; i >= 0; i--) {
				if (data[i][1] == maxH) {
					maxHRightPillarIdx = i;
					break;
				}
			}
			
			// 처음부터 왼쪽의 가장 큰 높이 기둥을 만날때까지의 넓이 계산
			int nowIdx = 0;
			for (int i = 1; i <= maxHLeftPillarIdx; i++) {
				int nextIdx = i;
				if (data[nowIdx][1] < data[nextIdx][1]) {
					area += (data[nextIdx][0] - data[nowIdx][0]) * data[nowIdx][1];
					nowIdx = i;
				}
			}
			
			// 가장 큰 높이 기둥들 사이의 넓이 계산
			area += (data[maxHRightPillarIdx][0] - data[maxHLeftPillarIdx][0] + 1) * maxH;
			
			// 마지막부터 오른쪽의 가장 큰 높이 기둥을 만날때까지의 넓이 계산
			nowIdx = n - 1; 
			for (int i = n - 2; i >= maxHRightPillarIdx; i--) {
				int nextIdx = i;
				if (data[nowIdx][1] < data[nextIdx][1]) {
					area += (data[nowIdx][0] - data[nextIdx][0]) * data[nowIdx][1];
					nowIdx = i;
				}
			}			
		}
		
		System.out.println(area); // 결과 출력
	}
	
}
