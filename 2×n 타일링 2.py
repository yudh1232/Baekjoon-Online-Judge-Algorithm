# n을 입력받음
n = int(input())

# dp리스트 생성
dp = [0] * (n + 1)

# 초기값 설정
dp[0] = 1
dp[1] = 1

# dp[i] = dp[i - 1] + 2 * dp[i - 2]
for i in range(2, n + 1):
    dp[i] = dp[i - 1] + 2 * dp[i - 2]

# 결과 출력
print(dp[n] % 10007)
