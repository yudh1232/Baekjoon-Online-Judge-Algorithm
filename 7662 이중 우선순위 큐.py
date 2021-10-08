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

    # key: 입력으로 들어온 숫자, value: 그 숫자의 개수
    dic = {}

    # k를 입력받음
    k = int(input())

    # k만큼 반복
    for _ in range(k):
        # c, n을 입력받음
        c, n = input().split()
        # n을 정수로 변환
        n = int(n)

        # 삽입 연산일 경우
        if c == 'I':
            # n이 dic에 이미 있었다면
            if n in dic:
                dic[n] += 1 # 개수 1증가
            # n이 dic에 없었다면
            else:
                dic[n] = 1 # dic에 추가
            
            # min_heap, max_heap에 추가
            heapq.heappush(min_heap, n)
            heapq.heappush(max_heap, -n)

            # 원소의 개수 1증가
            count += 1

        # 삭제 연산일 경우
        else:
            # 원소의 개수가 0이면 패스
            if count == 0:
                continue
            # 원소의 개수가 1이상이면
            else:
                # 최소값 삭제이면
                if n == -1:
                    # min_heap에서 유효한 최소값을 구하고 삭제함
                    while True:
                        temp = heapq.heappop(min_heap)
                        if dic[temp] != 0:
                            dic[temp] -= 1
                            count -= 1
                            break
                # 최대값 삭제이면
                else:
                    # max_heap에서 유효한 최대값을 구하고 삭제함
                    while True:
                        temp = -heapq.heappop(max_heap)
                        if dic[temp] != 0:
                            dic[temp] -= 1
                            count -= 1
                            break
    
    # 모든 연산 처리후 원소의 개수가 0이면
    if count == 0:
        print('EMPTY') # 'EMPTY' 출력
    # 원소의 개수가 1이상이면
    else:
        # max_heap에서 유효한 최대값을 구함
        while True:
            max_value = -heapq.heappop(max_heap)
            if dic[max_value] != 0:
                break
        # min_heap에서 유효한 최소값을 구함
        while True:
            min_value = heapq.heappop(min_heap)
            if dic[min_value] != 0:
                break
        
        # 결과 출력
        print(max_value, min_value)
