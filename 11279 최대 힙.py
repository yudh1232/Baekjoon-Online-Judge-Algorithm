import sys
input = sys.stdin.readline
import heapq

# n을 입력받음
n = int(input())
# max_heap 리스트 생성
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
            print(-heapq.heappop(heap))
    # x가 0이 아니면 heap에 원소를 넣음
    else:
        heapq.heappush(heap, -x)
