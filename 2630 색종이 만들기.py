import sys
input = sys.stdin.readline

# 재귀적으로 하얀색 색종이와 파란색 색종이 수를 셈
def count(x, y, k):
    # 하얀색 색종이와 파란색 색종이 수를 전역변수로 선언
    global white, blue

    # 정사각형의 맨 왼쪽위의 값
    start = paper[x][y]

    # 정사각형의 길이가 1일 경우
    if k == 1:
        if start == 0:
            white += 1
        else:
            blue += 1
        return

    # 정사각형의 길이가 1보다 큰 경우, 각 칸들의 색이 같은지 체크
    for i in range(k):
        for j in range(k):
            # 각 칸들의 색이 다르다면 정사각형을 쪼갬
            if paper[x + i][y + j] != start:
                count(x, y, k // 2)
                count(x, y + k // 2, k // 2)
                count(x + k // 2, y, k // 2)
                count(x + k // 2, y + k // 2, k // 2)
                return
    
    # 각 칸들의 색이 같다면
    if start == 0:
        white += 1
    else:
        blue += 1
    return

# n을 입력받음
n = int(input())

# 종이 정보를 입력받음
paper = []
for _ in range(n):
    paper.append(list(map(int, input().split())))

# 변수 초기화
white, blue = 0, 0

# 하얀색 색종이와 파란색 색종이 수를 셈
count(0, 0, n)

# 결과 출력
print(white)
print(blue)
