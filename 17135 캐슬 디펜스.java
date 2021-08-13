import java.io.*;
import java.util.*;

public class Main {
	static int n, m, D;
	static int[][] grid;
	static int[] numbers;
	static int killCnt;
	static int result;
	static int[][] temp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// n, m, D를 입력받음
		st = new StringTokenizer(in.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		// 격자판을 입력받음
		grid = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < m; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		numbers = new int[3]; // 궁수의 위치 조합을 담을 배열
		result = 0; // 결과값 변수
		combination(0, 0); // 궁수의 위치를 뽑아 게임을 진행, 제거할 수 있는 적의 최대 수를 구함
		System.out.println(result); // 결과값 출력
	}
	
	private static void combination(int cnt, int start) {
		// 조합이 완성되면
		if (cnt == 3) {
			// 게임 진행
			playGame();
			return;
		}
		
		// 조합 뽑기
		for (int i = start; i < m; i++) {
			numbers[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}
	
	private static void playGame() {
		
		killCnt = 0; // 제거한 적의 수 변수
		
		// 임시 맵을 생성하여 격자판을 복사
		temp = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp[i][j] = grid[i][j];
			}
		}
		
		while (true) {
			// 맵에 적이 없으면 반복 종료
			if (isTempEmpty()) {
				break;
			}
			
			// 죽일 수 있는 적 후보 구하기
			List<int[]> killList = new ArrayList<int[]>(); // 죽일 수 있는 적 후보 리스트
			for (int k = 0; k < 3; k++) { // 각 궁수에 대하여
				loop:
				for (int d = 1; d <= D; d++) { // 사정거리를 1부터 1씩 늘려감
					for (int j = 0; j < m; j++) {
						for (int i = 0; i < n; i++) {
							if (n - i + Math.abs(numbers[k] - j) == d) {
								// 현재 사정거리에 적을 발견하면 그 좌표를 적 후보 리스트에 넣음
								if (temp[i][j] == 1) {
									killList.add(new int[] {i, j});
									break loop;
								}
							}
						}
					}
				}
			}
			
			// 적을 죽임
			for (int k = 0; k < killList.size(); k++) {
				int i = killList.get(k)[0];
				int j = killList.get(k)[1];
				if (temp[i][j] == 1) {
					temp[i][j] = 0;
					killCnt++;
				}
			}
			
			// 적 후보 리스트 비우기
			killList.clear();
			
			// 맵에 적이 없으면 반복 종료
			if (isTempEmpty()) {
				break;
			}
			
			// 적의 이동
			tempMove();			
		}
		
		// 결과값을 갱신
		result = Math.max(result, killCnt);
		
	}
	
	// 적이 없는지 체크
	private static boolean isTempEmpty() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (temp[i][j] == 1) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	// 적의 이동
	private static void tempMove() {
		for (int i = n - 1; i > 0; i--) {
			for (int j = 0; j < m; j++) {
				temp[i][j] = temp[i - 1][j];
			}
		}
		
		for (int j = 0; j < m; j++) {
			temp[0][j] = 0;
		}
	}
	
}
