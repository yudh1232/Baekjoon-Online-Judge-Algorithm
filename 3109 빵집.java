import java.io.*;
import java.util.*;

public class Main {

	static int r, c;
	static char[][] map;
	static boolean[][] visited;
	static int[] row;
	static int pipeCount;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// r, c를 입력받음
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		// 빵집 근처의 지도를 입력받음
		map = new char[r][c];
		for (int i = 0; i < r; i++) {
			map[i] = in.readLine().toCharArray();
		}
		
		// DFS에 사용할 visited 배열 선언
		visited = new boolean[r][c];
		
		row = new int[c]; // 각 colNo에 대한 행번호를 저장하는 배열
		pipeCount = 0; // 파이프의 개수
		
		// 파이프라인 설치
		for (int i = 0; i < r; i++) {
			setPipe(i, 0);
		}
		
		System.out.println(pipeCount); // 결과 출력
	}
	
	private static void setPipe(int rowNo, int colNo) {
		// 방문표시
		visited[rowNo][colNo] = true;
		
		// 각 colNo에 대해 행번호를 기억해놓음
		row[colNo] = rowNo;
		
		// 파이프가 끝까지 도달했으면
		if (colNo == c - 1) {
			// 지도에 파이프 설치
			for (int i = 0; i < c; i++) {
				map[row[i]][i] = '*';
			}
			// 파이프 개수 증가
			pipeCount++;
			return;
		}
		
		// 다음 좌표가 map을 벗어나지 않고, 방문하지 않았고. 현재좌표에 파이프가 설치되지 않았다면 다음좌표를 탐색함
		if (colNo + 1 < c) {
			if (rowNo - 1 >= 0 && map[rowNo - 1][colNo + 1] == '.' && !visited[rowNo - 1][colNo + 1]) {
				setPipe(rowNo - 1, colNo + 1);
			}
			if (map[rowNo][colNo] == '.' && map[rowNo][colNo + 1] == '.' && !visited[rowNo][colNo + 1]) {
				setPipe(rowNo, colNo + 1);
			}
			if (map[rowNo][colNo] == '.' && rowNo + 1 < r && map[rowNo + 1][colNo + 1] == '.' && !visited[rowNo + 1][colNo + 1]) {
				setPipe(rowNo + 1, colNo + 1);
			}
		}
	}
}
