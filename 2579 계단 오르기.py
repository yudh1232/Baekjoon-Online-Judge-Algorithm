import sys
input = sys.stdin.readline

# n을 입력받음
n = int(input())

# 계단의 점수를 입력받음
data = [0]
for _ in range(n):
    data.append(int(input()))

# 다이나믹 프로그래밍 리스트 생성
dp = [[0] * 2 for _ in range(n + 1)]

# dp[i][0]: 한 계단 올라서 i번째 계단을 밟은경우
# dp[i][1]: 두 계단 올라서 i번째 계단을 밟은경우
# 첫번째 계단은 시작점이므로 dp[1][0], dp[1][1]에 둘 다 점수를 줌
dp[1][0] = data[1]
dp[1][1] = data[1]

# 2번 계단부터 n번 계단까지
for i in range(2, n + 1):
    # i번째 계단을 한 계단 올라서 밟으려면, i - 1번째 계단을 두 계단 올라서 밟았을 경우에만 가능
    dp[i][0] = dp[i - 1][1] + data[i]

    # i번째 계단을 두 계단 올라서 밟으려면, i - 2번째 계단에서 올라오면 됨
    dp[i][1] = max(dp[i - 2][0], dp[i - 2][1]) + data[i]

# 결과 출력
print(max(dp[n][0], dp[n][1]))
