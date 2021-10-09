import sys
input = sys.stdin.readline

# t를 입력받음
t = int(input())
# t만큼 반복
for _ in range(t):
    # n을 입력받음
    n = int(input())

    # 의상의 종류와 그 종류의 의상 수를 나타내는 dict 생성
    dic = {}
    
    # 의상 수 n만큼 반복
    for _ in range(n):
        # 의상의 이름과 종류를 입력받음
        name, kind = input().split()
        # 그 종류의 의상 수를 업데이트
        if kind in dic:
            dic[kind] += 1
        else:
            dic[kind] = 1
    
    # 종류에 따른 의상 수를 나타내는 리스트
    value_list = list(dic.values())

    # 결과값 변수
    answer = 1

    # 결과값은 (value_list의 각 값 + 1)을 모두 곱한 뒤 1을 뺀 값 
    for v in value_list:
        answer *= (v + 1) # 어떤 종류의 의상 수(v) + 그 종류를 선택안했을 때의 값(1)
    answer -= 1 # 모든 종류를 선택안한 경우의 수(알몸)은 안되므로 1을 빼줌
        
    # 결과 출력
    print(answer)
