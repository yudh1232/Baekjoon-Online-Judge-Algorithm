import sys
input = sys.stdin.readline

# n, m을 입력받음
n, m = map(int, input().split())
# 이름이 key인 딕셔너리 
book1 = {}
# 번호가 key인 딕셔너리
book2 = {}

# 포켓몬 이름을 입력받고 딕셔너리 생성
for i in range(1, n + 1):
    i = str(i)
    s = input().rstrip()
    book1[s] = i
    book2[i] = s

# 출력문 생성을 위한 리스트
str_list = []

# 리스트에 딕셔너리를 이용해 출력문을 넣음
for _ in range(m):
    s = input().rstrip()
    if s.isdigit():
        str_list.append(book2[s])
    else:
        str_list.append(book1[s])

# 출력문 생성
answer = '\n'.join(str_list)

# 결과 출력
print(answer)
