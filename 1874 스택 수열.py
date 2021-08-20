import sys
input = sys.stdin.readline

# n을 입력받음
n = int(input())

s = [] # 스택
max = 0 # 현재까지 등장한 숫자중 최대값
answer = '' # 결과

for _ in range(n):
    a = int(input()) # 숫자를 입력받음

    # 입력받은 숫자가 max보다 크면
    if max < a:
        # max와 a가 같아질때까지 스택에 max를 넣고, 마지막에 하나를 뺌
        while max < a:
            max += 1
            s.append(max)
            answer += '+'
        s.pop()
        answer += '-'
    # 입력받은 숫자가 max보다 작으면
    if max > a:
        # 스택에서 하나를 빼고 입력받은 숫자와 같은지 확인
        if a == s.pop():
            answer += '-'
        else:
            answer = 'NO'
            break

# 결과 출력
if answer == 'NO':
    print(answer)
else:
    for c in answer:
        print(c)
