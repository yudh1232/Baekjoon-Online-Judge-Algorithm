import sys
input = sys.stdin.readline
from collections import deque

# 테스트케이스 수를 입력받음
t = int(input())
for _ in range(t):
    # 수행할 함수를 입력받음
    p = input().rstrip()
    # 수의 개수를 입력받음
    n = int(input())
    # 배열을 입력받음
    s = input().rstrip()
    
    # n이 0이면
    if n == 0:
        # 빈 큐
        q = deque()
    # n이 0이 아니면
    else:
        # 배열을 콤마로 구분하여 큐에 넣음
        q = deque((list(s[1:-1].split(','))))
    
    # 에러인지 나타내는 변수
    is_error = False
    # 뒤집힘 여부를 나타내는 플래그
    flag = 1
    
    # 함수를 한글자씩 살펴봄
    for i in range(len(p)):
        # 명령이 'R'이면
        if p[i] == 'R':
            # 플래그값을 바꿈
            flag *= -1

        # 명령이 'D'이면
        else:
            # 큐가 비어있으면 에러
            if len(q) == 0:
                is_error = True
                break
            
            # 안 뒤집힌 상태이면 왼쪽에서 뺌
            if flag == 1:
                q.popleft()
            # 뒤집힌 상태이면 오른쪽에서 뺌
            else:
                q.pop()
    
    # 숫자를 다 뺀 후 뒤집힌 상태이면 큐를 뒤집음
    if flag == -1:
        q.reverse()

    # 결과 출력
    if is_error:
        print('error')
    else:
        print('[' + ','.join(q) + ']')
