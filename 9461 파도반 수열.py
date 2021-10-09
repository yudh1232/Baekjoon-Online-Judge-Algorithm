import sys
input = sys.stdin.readline

# dp로 파도반 수열 테이블 완성
p = [0] * 101
p[1], p[2], p[3] = 1, 1, 1
for i in range(4, 101):
    p[i] = p[i - 3] + p[i - 2]

# t를 입력받음
t = int(input())
# t만큼 반복
for _ in range(t):
    # n을 입력받음
    n = int(input())
    # p[n]을 출력
    print(p[n])
