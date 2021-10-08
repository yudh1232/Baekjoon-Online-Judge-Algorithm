import sys
input = sys.stdin.readline

# n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 함수
def dfs(k):
    global result

    # k가 n보다 크면 리턴
    if k > n:
        return

    # k가 n과 같으면 결과값 증가
    if k == n:
        result += 1
        return
    
    # 현재값 k에 1, 2, 3을 더해서 재귀호출
    for i in range(1, 4):
        dfs(k + i)


# t를 입력받음
t = int(input())
# t만큼 반복
for _ in range(t):
    # n을 입력받음
    n = int(input())
    
    # 결과값 변수
    result = 0

    # dfs 수행
    dfs(0)

    # 결과 출력
    print(result)
