import sys
input = sys.stdin.readline

def solution(n, x, y):
    global a, b, c
    
    # 같은 숫자로 이루어져있는지 판단하기 위해 start변수 선언, 맨 왼쪽위 값 넣어줌
    start = paper[x][y]

    # 기저조건
    if n == 1:
        if start == -1:
            a += 1
        elif start == 0:
            b += 1
        else:
            c += 1
        return

    # 같은 숫자로 이루어져 있는지 체크
    is_same = True
    for i in range(x, x + n):
        for j in range(y, y + n):
            if paper[i][j] != start:
                is_same = False
                break
        if is_same == False:
            break
    
    # 같은 숫자로 이루어져 있으면 결과에 반영
    if is_same == True:
        if start == -1:
            a += 1
        elif start == 0:
            b += 1
        else:
            c += 1
    # 같은 숫자로 이루어져 있지 않으면 9개로 나눔
    else:
        n = n // 3
        for i in range(3):
            for j in range(3):
                solution(n, x + i * n, y + j * n)


# n을 입력받음
n = int(input())

# 종이 정보를 입력받음
paper = []
for _ in range(n):
    paper.append(list(map(int, input().split())))

# -1의 개수, 0의 개수, 1의 개수 초기화
a, b, c = 0, 0, 0

# 재귀적으로 답 구하기
solution(n, 0, 0)

# 결과 출력
print(a)
print(b)
print(c)
