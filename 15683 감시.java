import java.io.*;
import java.util.*;

public class Main {

	static int n, m, result;
	static int[][] map, temp;
	static List<int[]> cctv;
	static int[] numbers;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// n, m을 입력받음
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// cctv의 번호, 좌표를 넣을 arrayList 선언
		cctv = new ArrayList<int[]>();
		
		// map정보를 입력받고, cctv 번호, 좌표를 저장
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					cctv.add(new int[] {map[i][j], i, j});
				}
			}
		}
		
		numbers = new int[cctv.size()];// cctv가 바라보는 방향상태를 담을 배열 선언
		result = n * m; // 결과값 초기화
		generateSet(0); // cctv가 바라보는 모든 방향상태에 따라 감시를 해보고 사각지대 최소값을 구함
		System.out.println(result); // 결과 출력
	}
	
	private static void generateSet(int cnt) {
		// 방향상태 배열 생성 완료
		if (cnt == cctv.size()) {
			// 감시 및 사각지대 최소값 계산
			calcResult();
			return;
		}
		
		// cctv 번호에 따라 방향상태의 개수를 설정
		int dirCnt = 0;
		if (cctv.get(cnt)[0] == 1 || cctv.get(cnt)[0] == 3 || cctv.get(cnt)[0] == 4)
			dirCnt = 4;
		else if (cctv.get(cnt)[0] == 2)
			dirCnt = 2;
		else
			dirCnt = 1;
		
		// 방향상태 배열 생성
		for (int i = 0; i < dirCnt; i++) {
			numbers[cnt] = i;			
			generateSet(cnt + 1);
		}
	}
	
	private static void calcResult() {
		// temp배열에 map배열을 복사
		temp = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp[i][j] = map[i][j];
			}
		}
		
		// 모든 cctv에 대하여
		for (int k = 0; k < cctv.size(); k++) {
			// 감시
			watch(cctv.get(k)[0], cctv.get(k)[1], cctv.get(k)[2], numbers[k]);
		}
		
		// 사각지대 최소값 계산
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (temp[i][j] == 0) count++;
			}
		}
		result = Math.min(result, count);
	}

	// cctv번호에 따라 감시
	private static void watch(int cctv, int x, int y, int dir) {
		if (cctv == 1) {
			dfs(x, y, dir);
		}
		else if (cctv == 2) {
			dfs(x, y, dir);
			dfs(x, y, dir + 2);
		}
		else if (cctv == 3) {
			dfs(x, y, dir);
			dfs(x, y, (dir + 1) % 4);
		}
		else if (cctv == 4) {
			dfs(x, y, dir);
			dfs(x, y, (dir + 1) % 4);
			dfs(x, y, (dir + 2) % 4);
		}
		else {
			dfs(x, y, dir);
			dfs(x, y, dir + 1);
			dfs(x, y, dir + 2);
			dfs(x, y, dir + 3);
		}
	}
	
	// dfs, 배열을 벗어나거나 벽을만나면 종료, 유효한 칸이면 감시표시(7)
	private static void dfs(int x, int y, int dir) {
		while (true) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (nx < 0 || ny < 0 || nx >= n || ny >= m) break;
			if (temp[nx][ny] == 6) break;
			temp[nx][ny] = 7;
			x = nx;
			y = ny;
		}
	}
}
