import sys
input = sys.stdin.readline

answer = ''
while True:
    s = input().rstrip()
    if s == '.':
        break
    
    # 스택
    stack = []

    # 균형잡혔는지 나타내는 변수
    flag = True
    
    for c in s:
        # 여는 괄호는 스택에 넣음
        if c == '(' or c == '[':
            stack.append(c)
        # 닫는 괄호는 짝이 맞는지 확인
        elif c == ')':
            if len(stack) == 0:
                flag = False
            elif stack[-1] != '(':
                flag = False
            # 짝이 맞다면
            else:
                stack.pop()
        # 닫는 괄호는 짝이 맞는지 확인
        elif  c == ']':
            if len(stack) == 0:
                flag = False
            elif stack[-1] != '[':
                flag = False
            # 짝이 맞다면
            else:
                stack.pop()
    
    # 스택에 여는 괄호가 남아있다면
    if len(stack) != 0:
        flag = False
    
    # 출력문 생성
    if flag:
        answer += 'yes\n'
    else:
        answer += 'no\n'

# 결과 출력
print(answer)
