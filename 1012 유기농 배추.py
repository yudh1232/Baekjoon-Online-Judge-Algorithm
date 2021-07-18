import sys
sys.setrecursionlimit(int(1e6))

def dfs(x, y):
    # 땅을 벗어난 경우 종료
    if x < 0 or y < 0 or x > m - 1 or y > n - 1:
        return -1

    # 방문하지 않았으면서 배추가 있는 땅일 경우
    if data[x][y] == 1:
        data[x][y] = 2 # 방문 표시    
        dfs(x - 1, y)
        dfs(x + 1, y)
        dfs(x, y - 1)
        dfs(x, y + 1)
        return 0
    else:
        return -1

t = int(input())
for _ in range(t):
    m, n, k = map(int, input().split())

    data = [[0] * n for _ in range(m)]

    # 배추 정보를 입력받음
    for _ in range(k):
        a, b = map(int, input().split())
        data[a][b] = 1

    # dfs 수행
    count = 0
    for i in range(m):
        for j in range(n):
            if dfs(i, j) == 0:
                count += 1

    print(count)
