import sys
input = sys.stdin.readline

# n, m을 입력받음
n, m = map(int, input().split())
# 수들을 입력받음
data = list(map(int, input().split()))

# data[0] ~ data[i]의 합 리스트를 생성
s = [0] * (n + 1)
for i in range(1, n + 1):
    s[i] = s[i - 1] + data[i - 1]

# 각 i, j에 대하여 구간합 계산
for _ in range(m):
    i, j = map(int, input().split())
    print(s[j] - s[i - 1])
