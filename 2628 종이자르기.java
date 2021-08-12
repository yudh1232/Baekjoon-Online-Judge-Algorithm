import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// m(가로길이), n(세로길이), k(자르는횟수)를 입력받음
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(in.readLine());
		
		// 가로로자르는 위치와, 세로로자르는 위치를 arraylist에 넣음
		List<Integer> widthCut = new ArrayList<Integer>();
		List<Integer> heightCut = new ArrayList<Integer>();
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			if (Integer.parseInt(st.nextToken()) == 0) {
				widthCut.add(Integer.parseInt(st.nextToken()));
			}
			else {
				heightCut.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		// 정렬
		Collections.sort(widthCut);
		Collections.sort(heightCut);		
		
		// 잘라진 조각들중에서 최대 높이를 구함
		int maxHeight = 0;
		if (widthCut.size() == 0) {
			maxHeight = n;
		}
		else {
			maxHeight = widthCut.get(0);
			for (int i = 0; i < widthCut.size() - 1; i++) {
				maxHeight = Math.max(maxHeight, widthCut.get(i + 1) - widthCut.get(i));
			}
			maxHeight = Math.max(maxHeight, n - widthCut.get(widthCut.size() - 1));
		}
		
		// 잘라진 조각들중에서 최대 너비를 구함
		int maxWidth = 0;
		if (heightCut.size() == 0) {
			maxWidth = m;
		}
		else {
			maxWidth = heightCut.get(0);
			for (int i = 0; i < heightCut.size() - 1; i++) {
				maxWidth = Math.max(maxWidth, heightCut.get(i + 1) - heightCut.get(i));
			}
			maxWidth = Math.max(maxWidth, m - heightCut.get(heightCut.size() - 1));
		}
		
		// 결과 출력
		System.out.println(maxHeight * maxWidth);

	}
	
}
