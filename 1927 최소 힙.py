import sys
input = sys.stdin.readline
import heapq

# n을 입력받음
n = int(input())

# heap생성
heap = []

for _ in range(n):
    # 정수를 입력받음
    k = int(input())

    # 0이면 heappop
    if k == 0:
        if len(heap) == 0:
            print(0)
        else:
            print(heapq.heappop(heap))
    # 0이 아니면 heappush
    else:
        heapq.heappush(heap, k)
