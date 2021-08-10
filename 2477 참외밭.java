import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in =  new BufferedReader(new InputStreamReader(System.in));
		
		int[][] data = new int[6][2];
		
		int k = Integer.parseInt(in.readLine());
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			data[i][0] = Integer.parseInt(st.nextToken());
			data[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] count = new int[5]; // 방향 1, 2, 3, 4의 등장횟수를 세는 배열
		for (int i = 0; i < 6; i++) {
			count[data[i][0]]++;
		}
		
		// 한번씩 등장하는 방향의 인덱스를 저장
		int index1 = -1, index2 = -1;
		for (int i = 0; i < 6; i++) {
			if (count[data[i][0]] == 1) {
				if (index1 == -1) index1 = i;
				else index2 = i;
			}
		}
		
		// 한번씩 등장하는 방향의 길이 x, y
		// 방향이 두번씩 등장하는, 연속된 length가 4인 수열에서 중간부분에 위치한 길이 a, b
		// 예) 방향이 3 1 4 2 4 2일 경우 x, y, a, b는 각각 x: 3, y: 4, a: 2, b: 4에 해당하는 길이
		// 넓이: (x * y) - (a * b)
		int area = 0;
		if (index2 - index1 == 1)
			area = data[index1][1] * data[index2][1] - data[(index2 + 2) % 6][1] * data[(index2 + 3) % 6][1];
		else
			area = data[index1][1] * data[index2][1] - data[(index1 + 2) % 6][1] * data[(index1 + 3) % 6][1];
		
		System.out.println(k * area); // 결과 출력
	}
	
}
