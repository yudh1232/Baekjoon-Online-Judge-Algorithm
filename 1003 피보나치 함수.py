# DP를 이용한 피보나치
def fibo(n):
    for i in range(2, n + 1):
        zero = dp[i - 2][0] + dp[i - 1][0]
        one = dp[i - 2][1] + dp[i - 1][1]
        dp.append((zero, one))

t = int(input())
n = []

# 테스트 케이스를 입력받음
for _ in range(t):
    n.append(int(input()))

# 피보나치 초기값 fibo(0), fibo(1)의 값을 DP 테이블에 넣어줌
# (0의 개수, 1의 개수)
dp = [(1, 0), (0, 1)]

# 테스트 케이스 중 가장 큰 값에 대해서 fibo()를 수행하여 DP 테이블을 채워줌
fibo(max(n))

# 결과 출력
for i in n:
    print(dp[i][0], dp[i][1])
