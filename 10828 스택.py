import sys
input = sys.stdin.readline

# 스택 생성
stack = []

# n을 입력받음
n = int(input())


for _ in range(n):
    # 명령을 입력받음
    data = list(input().split())

    # 명령이 push이면
    if len(data) == 2:
        stack.append(int(data[1]))
    else:
        # 명령이 pop이면
        if data[0] == 'pop':
            if len(stack) == 0:
                print(-1)
            else:
                print(stack.pop())
        # 명령이 size이면
        elif data[0] == 'size':
            print(len(stack))
        # 명령이 empty이면
        elif data[0] == 'empty':
            if len(stack) == 0:
                print(1)
            else:
                print(0)
        # 명령이 top이면
        else:
            if len(stack) == 0:
                print(-1)
            else:
                print(stack[-1])
