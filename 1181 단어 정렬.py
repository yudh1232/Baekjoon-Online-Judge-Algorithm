# n을 입력받음
n = int(input())

# 단어들을 입력받음
data = []
for _ in range(n):
    data.append(input())

# 중복 단어 제거
data = list(set(data))

# 두가지 조건에 따라 정렬
data.sort(key = lambda x: (len(x), x))

# 결과 출력
for s in data:
    print(s)
