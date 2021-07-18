import math

def solution(x1, y1, r1, x2, y2, r2):
    # 두 원이 같은 경우
    if x1 == x2 and y1 == y2 and r1 == r2:
        return -1
    d = math.sqrt((x1 - x2) ** 2 + (y1 - y2) ** 2)
    # 두 원이 만나지 않을 때
    if d > r1 + r2:
        return 0
    # 두 원이 밖에서 접할 때
    elif d == r1 + r2:
        return 1
    # 두 원이 두 점에서 만날 때
    elif d < r1 + r2 and d > abs(r1 - r2):
        return 2
    # 두 원이 안에서 접할 때
    elif d == abs(r1 - r2):
        return 1
    # 한 원이 다른 원의 내부에 있을 때
    else: # d < abs(r1 - r2)일 때
        return 0

t = int(input())

for _ in range(t):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())
    print(solution(x1, y1, r1, x2, y2, r2))
