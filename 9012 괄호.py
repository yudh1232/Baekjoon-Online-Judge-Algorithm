import sys
input = sys.stdin.readline

answer = ''

t = int(input())
for _ in range(t):
    s = input().rstrip()

    # 스택
    stack = []
    
    # VPS인지 나타내는 변수
    flag = True
    
    for c in s:
        # 여는 괄호는 스택에 넣음
        if c == '(':
            stack.append(c)
        # 닫는 괄호는 짝이 맞는지 확인
        else:
            if len(stack) == 0:
                flag = False
                break
            elif stack[-1] == '(':
                stack.pop()
    
    # 스택에 여는 괄호가 남아있다면
    if len(stack) != 0:
        flag = False

    # 출력문 생성
    if flag:
        answer += 'YES\n'
    else:
        answer += 'NO\n'

# 결과 출력
print(answer)
