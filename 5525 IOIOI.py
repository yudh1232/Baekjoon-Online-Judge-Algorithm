# n, m을 입력받음
n = int(input())
m = int(input())

# 문자열을 입력받음
s = input()

# 'IOI'인지 연속으로 몇번나왔는지 나타내는 리스트 생성
is_IOI = [0] * m

# is_IOI 리스트를 완성
i = 0 # is_IOI를 순회하는데 사용할 인덱스
k = 0 # 'IOI'가 연속으로 나온 횟수
while i < m - 2:
    if s[i:i+3] == 'IOI':
        k += 1
        is_IOI[i] = k
        i += 2
    else:
        i += 1
        k = 0

# is_IOI를 순회하며 결과값 계산
answer = 0 # 결과값
i = 0 # is_IOI를 순회하는데 사용할 인덱스
while i < m - 2:
    if is_IOI[i] >= n:
        answer += 1
        i += 2
    else:
        i += 1

# 결과 출력
print(answer)
