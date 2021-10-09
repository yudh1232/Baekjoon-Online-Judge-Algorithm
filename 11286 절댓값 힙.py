import sys
input = sys.stdin.readline
import heapq

# n을 입력받음
n = int(input())
# 절댓값 힙 리스트 생성
heap = []

for _ in range(n):
    # x를 입력받음
    x = int(input())
    
    # x가 0이면
    if x == 0:
        # heap이 비어있으면 0출력
        if len(heap) == 0:
            print(0)
        # heap에 원소를 빼서 출력
        else:
            k, sign = heapq.heappop(heap)
            # k가 원래 양수면
            if sign == 1:
                print(k)
            # k가 원래 음수면
            else:
                print(-k)
    # x가 0이 아니면 heap에 원소를 넣음
    else:
        # x가 양수면, sign을 1로 설정
        if x > 0:
            heapq.heappush(heap, (x, 1))
        # x가 음수면, sign을 -1로 설정, -x를 힙에 넣음
        else:
            heapq.heappush(heap, (-x, -1))
