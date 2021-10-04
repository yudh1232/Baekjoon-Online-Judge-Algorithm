import math

# 테스트케이스의 수를 입력받음
t = int(input())

for _ in range(t):
    # m, n, x ,y를 입력받음
    m, n, x, y = map(int, input().split())

    # m, n의 최소공배수를 구함    
    lcm = m * n // math.gcd(m, n)

    # m, n 중 큰 수와 작은수를 구함
    if m >= n:
        bigger, smaller = m, n
        bigger2, smaller2 = x, y
    else:
        bigger, smaller = n, m
        bigger2, smaller2 = y, x
    
    # 결과값
    answer = -1

    # 최소공배수를 큰 수로 나눈값만큼 반복
    for i in range(lcm // bigger):
        # (bigger2 + i * bigger) == (smaller2 + j * smaller)를 만족하는 (bigger2 + i * bigger) 값을 구함
        k = (bigger2 + i * bigger) % smaller
        if k == 0:
            k = smaller

        if k == smaller2:
            answer = bigger2 + i * bigger
            break

    # 결과 출력
    print(answer)
