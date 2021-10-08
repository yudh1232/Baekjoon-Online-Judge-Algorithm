import sys
input = sys.stdin.readline
import heapq

# t를 입력받음
t = int(input())
# t만큼 반복
for _ in range(t):
    # min_heap과 max_heap 선언
    min_heap = []
    max_heap = []
    # 원소의 개수
    count = 0 

    k = int(input())
    for _ in range(k):
        c, n = input().split()
        n = int(n)
        if c == 'I':
            heapq.heappush(min_heap, n)
            heapq.heappush(max_heap, -n)
            count += 1
        else:
            if count == 0:
                continue
            else:
                if n == -1:
                    heapq.heappop(min_heap)
                else:
                    heapq.heappop(max_heap)
                count -= 1
    
    if count == 0:
        print('EMPTY')
    else:
        print(-heapq.heappop(max_heap), heapq.heappop(min_heap))
