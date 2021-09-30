import sys
input = sys.stdin.readline

# n을 입력받음
n = int(input())

# 회의 정보를 입력받음
data = []
for _ in range(n):
    data.append(list(map(int, input().split())))

# 회의를 끝 시간을 기준으로, 끝 시간이 같으면 시작 시간으로 오름차순 정렬
data.sort(key=lambda x: (x[1], x[0]))

answer = 0 # 결과값
current_time = 0 # 현재시간

# 모든 회의에 대하여
for d in data:
    # 시작 시간이 현재시간보다 크거나 같다면
    if d[0] >= current_time:
        # 결과값 증가
        answer += 1
        # 현재시간은 끝 시간이 됨
        current_time = d[1]

# 결과 출력
print(answer)
