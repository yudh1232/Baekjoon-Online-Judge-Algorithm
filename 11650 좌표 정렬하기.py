import sys
input = sys.stdin.readline

# (x좌표, y좌표)를 담을 리스트
data = []

# n을 입력받음
n = int(input())

# x,y좌표를 입력받아 리스트에 넣음
for _ in range(n):
    x, y = map(int, input().split())
    data.append((x, y))

# x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬
data.sort(key=lambda x: (x[0], x[1]))

# 결과 출력
for i in range(n):
    print(data[i][0], data[i][1])
