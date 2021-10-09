# n을 입력받음
n = int(input())
# 각 사람이 돈을 인출하는데 걸리는 시간을 입력받음
data = list(map(int, input().split()))
# data를 오름차순으로 정렬
data.sort()

# 결과값 변수
answer = 0
# 결과값 계산
for i in range(n):
    answer += data[i] * (n - i)

# 결과 출력
print(answer)
