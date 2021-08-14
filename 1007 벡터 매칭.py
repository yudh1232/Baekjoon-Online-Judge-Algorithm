import sys
input = sys.stdin.readline
from itertools import combinations
import math

# t를 입력받음
t = int(input())

# t만큼 수행
for _ in range(t):

    # n을 입력받음
    n = int(input())

    # 점들을 입력받아 리스트에 넣음
    points = []
    for _ in range(n):
        x, y = map(int, input().split())
        points.append((x, y))
    
    # 0부터 n - 1까지의 수를 리스트에 넣음
    idx = []
    for i in range(n):
        idx.append(i)

    # 0부터 n - 1까지의 수 중에서 n // 2개만큼 뽑는 조합을 생성
    c_list = list(combinations(idx, n // 2))
    c_list_len = len(c_list)

    # 최솟값을 구하기위해 큰 값으로 초기화
    min_sum = int(1e19)

    # 살펴본 조합의 개수
    count = 0
    for c in c_list:
        # 뽑은 조합중에서 딱 절반까지만 살펴보면 됨
        if count == c_list_len // 2:
            break

        # n // 2개의 벡터의 합의 x, y 성분
        x = 0
        y = 0

        # 절반의 x성분은 더해지고, 절반의 y성분은 빼짐
        for i in range(n):
            if i in c:
                x += points[i][0]
                y += points[i][1]
            else:
                x -= points[i][0]
                y -= points[i][1]

        # 벡터의 길이의 제곱 계산
        sum = x ** 2 + y ** 2
        # 최소값 업데이트
        min_sum = min(min_sum, sum)
        # 살펴본 조합의 수 += 1
        count += 1

    # 벡터의 길이 계산
    result = math.sqrt(min_sum)

    print(result) # 결과 출력
