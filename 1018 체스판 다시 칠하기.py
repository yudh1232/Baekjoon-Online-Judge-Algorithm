# n, m을 입력받음
n, m = map(int, input().split())

# 보드를 입력받음
data = []
for _ in range(n):
    data.append(list(input()))

# 최솟값을 계산하기 위해 10억으로 설정
min_value = int(1e9)

# 8 * 8 격자를 움직여가며
for i in range(n - 8 + 1):
    for j in range(m - 8 + 1):
        result = 0
        c = data[i][j] # 맨 왼쪽위의 색
        
        # 8 * 8 격자에 대하여
        for a in range(8):
            for b in range(8):
                # c와 같아야 하는 부분
                if (a + b) % 2 == 0:
                    if c != data[i + a][j + b]:
                        result += 1
                # c와 달라야 하는 부분
                else:
                    if c == data[i + a][j + b]:
                        result += 1

        # 맨 왼쪽위를 그대로 두고 다시 칠하는 경우와, 맨 왼쪽위를 바꾸고 다시 칠하는 경우 중 작은값을 고름
        min_value = min(min_value, result, 64 - result)
    
print(min_value) # 결과 출력
