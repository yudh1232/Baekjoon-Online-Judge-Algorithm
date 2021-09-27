import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// BufferedReader 객체 생성
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 한 줄을 입력받아 공백으로 구분하여 분리
		StringTokenizer st = new StringTokenizer(in.readLine());
		int m = Integer.parseInt(st.nextToken()); // m값 저장
		int n = Integer.parseInt(st.nextToken()); // n값 저장
		
		// 정답 출력문을 만들 스트링빌더 객체 생성
		StringBuilder answer = new StringBuilder();
		
		// 0 -> "zero", 1 -> "one" ... 9 -> "nine"에 대응되도록 배열 생성
		String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		
		// m이상 n이하의 숫자들을 영어로 변환한 문자열을 담을 배열 생성
		String[] arr = new String[n - m + 1];
		int index = 0; // 이 배열을 관리할 인덱스 변수 생성
		
		// m이상 n이하의 숫자들을 영어로 바꿈
		for (int i = m; i <= n; i++) {
			// 한자리수인 경우 "영어 ." 형태로 arr 배열에 저장
			if (i < 10) {
				arr[index++] = number[i] + " .";
			}
			// 두자리수인 경우 "영어 영어" 형태로 arr 배열에 저장
			else {
				arr[index++] = number[i / 10] + " " + number[i % 10];
			}
		}
		
		// arr을 정렬(알파벳순)
		Arrays.sort(arr);
		
		// arr 배열을 순회하며 숫자로 바꿈
		for (int i = 0; i < index; i++) {
			st = new StringTokenizer(arr[i]); // arr의 원소를 공백으로 구분하여 분리
			String first = st.nextToken(); // 첫번째: one ~ nine
			String second = st.nextToken(); // 두번째: . ~ nine
			StringBuilder sb = new StringBuilder(); // 영어를 다시 숫자로바꾸기 위한 스트링빌더
			
			// first를 숫자로 바꿈
			if (first.equals("one")) { // one -> 1
				sb.append("1");
			}
			else if (first.equals("two")) { // two -> 2
				sb.append("2");
			}
			else if (first.equals("three")) { // three -> 3
				sb.append("3");
			}
			else if (first.equals("four")) { // four -> 4
				sb.append("4");
			}
			else if (first.equals("five")) { // five -> 5
				sb.append("5");
			}
			else if (first.equals("six")) { // six -> 6
				sb.append("6");
			}
			else if (first.equals("seven")) { // seven -> 7
				sb.append("7");
			}
			else if (first.equals("eight")) { // eight -> 8
				sb.append("8");
			}
			else if (first.equals("nine")) { // nine -> 9
				sb.append("9");
			}
			
			// second를 숫자로 바꿈
			if (second.equals("zero")) { // zero -> 0
				sb.append("0");
			}
			else if (second.equals("one")) { // one -> 1
				sb.append("1");
			}
			else if (second.equals("two")) { // two -> 2
				sb.append("2");
			}
			else if (second.equals("three")) { // three -> 3
				sb.append("3");
			}
			else if (second.equals("four")) { // four -> 4
				sb.append("4");
			}
			else if (second.equals("five")) { // five -> 5
				sb.append("5");
			}
			else if (second.equals("six")) { // six -> 6
				sb.append("6");
			}
			else if (second.equals("seven")) { // seven -> 7
				sb.append("7");
			}
			else if (second.equals("eight")) { // eight -> 8
				sb.append("8");
			}
			else if (second.equals("nine")) { // nine -> 9
				sb.append("9");
			}
			
			// 숫자로 변환한 결과를 정답 출력문에 넣음
			answer.append(sb.toString());

			// 10개 변환마다 정답 출력문에 개행문자 넣음
			if (i % 10 == 9) answer.append("\n");
			else answer.append(" ");
		}
		
		// 결과 출력
		System.out.println(answer);
	}
	
}
