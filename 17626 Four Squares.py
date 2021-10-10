# 무한으로 10억을 설정
INF = int(1e9)

# n을 입력받음
n = int(input())

# dp 리스트 생성 및 초기값 설정
dp = [INF] * (n + 1)
dp[0] = 0
dp[1] = 1

# dp[2] ~ dp[n] 완성
for i in range(2, n + 1):
    j = 1
    while j ** 2 <= i:
        dp[i] = min(dp[i], dp[i - j ** 2] + 1)
        j += 1

# 결과 출력
print(dp[n])
