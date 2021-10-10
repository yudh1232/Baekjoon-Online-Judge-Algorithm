# n을 입력받음
n = int(input())

# 좌표들을 입력받음
data = list(map(int, input().split()))

# 좌표들을 정렬한 리스트를 만듦
sorted_data = sorted(data)

# key: 좌표, value: key보다 작은 서로 다른 좌표의 개수
dic = {}

# dic 완성
count = 0
dic[sorted_data[0]] = 0
for i in range(1, n):
    if sorted_data[i] != sorted_data[i - 1]:
        count += 1
    dic[sorted_data[i]] = count

# 결과 출력
for i in data:
    print(dic[i], end = ' ')
