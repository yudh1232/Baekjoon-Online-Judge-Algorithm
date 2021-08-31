import sys
input = sys.stdin.readline

# 1~10000까지의 숫자 개수를 세는 리스트
count = [0] * 10001

# n을 입력받음
n = int(input())

# 1~10000까지의 숫자들의 개수를 셈
for _ in range(n):
    x = int(input())
    count[x] += 1

for i in range(1, 10001):
    # 개수가 0 이면
    if count[i] == 0:
        continue
    # 개수가 1 이상이면
    else:
        # 개수만큼 그 숫자를 출력
        for _ in range(count[i]):
            print(i)
